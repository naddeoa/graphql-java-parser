package org.naddeo.graphql;

import java_cup.runtime.Symbol;
import org.junit.Assert;
import org.junit.Before;
import org.naddeo.graphql.test.data.StreamSizeData;
import org.naddeo.graphql.test.data.TestData;
import org.naddeo.graphql.types.definition.DocumentDefinitionFactory;
import org.naddeo.graphql.types.value.ValueFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.naddeo.graphql.matchers.GeneratedSymbolClassMatcher.returnsClass;
import static org.naddeo.graphql.matchers.StreamSizeMatcher.containsThisMany;

public abstract class BaseGrammarTest {

    private static final String _parseFailMsg = "'%s' rule did not accept the following valid input:\n%s";
    public static final ValueFactory VALUE_FACTORY = new ValueFactory();
    public static final DocumentDefinitionFactory DOCUMENT_DEFINITION_FACTORY = new DocumentDefinitionFactory();

    private boolean previouslyInitialized = false;

    abstract ForcedStatement getTestedRule();

    GraphQLDocumentParser parser = null;
    OutputStream output = null;

    @Before
    public void _init() throws IOException
    {
        previouslyInitialized = true;
        PipedInputStream input = new PipedInputStream();
        output = new PipedOutputStream(input);
        parser = new GraphQLDocumentParser(new GraphQLDocumentLexer(new InputStreamReader(input)));
    }

    Symbol parse(String input) throws Exception
    {
        output.write(input.getBytes());
        output.close();
        return parser.parse();
    }

    String parseFailMessage(String input)
    {
        return format(_parseFailMsg, getTestedRule().rule, input);
    }

    Symbol assertCanParse(String query)
    {
        throwIfNotInitialized();

        Symbol symbol = null;
        try {
            symbol = parse(getTestedRule().create(query));
        } catch (NullPointerException e) {
            e.printStackTrace();
            Assert.fail(parseFailMessage(query));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(parseFailMessage(query));
        }

        return symbol;
    }

    static Collection<TestData[]> parameterize(TestData[] data)
    {
        return Arrays.stream(data).map(d -> new TestData[]{d}).collect(Collectors.toList());
    }

    <T> Symbol assertCanParse(TestData<T> data)
    {
        Symbol symbol = assertCanParse(data.getTest().getParserInput().toString());
        assertThat(assertMessage(), symbol, returnsClass(data.getTest().getExpectedClass()));
        assertThat(assertMessage(), symbol.value, equalTo(data.getTest().getPojoValue()));
        assertStreamSizes(data);

        return symbol;
    }

    /**
     * Assert that each of the stream functions returns the expected number of results
     * @param data The data to test
     */
    <T> void assertStreamSizes(TestData<T> data)
    {
        for(StreamSizeData<T> entry : data.getTest().getStreamSizes()){
            Stream stream = entry.getStreamFunction().apply(data.getTest().getPojoValue());
            assertThat(entry.toString(), stream, containsThisMany(entry.getExpectedResults(), entry.getStreamReturnType()));
        }
    }

    public final String assertMessage()
    {
        return String.format("grammar rule '%s': ", getTestedRule().rule);
    }

    private void throwIfNotInitialized()
    {
        if (!previouslyInitialized) {
            throw new IllegalStateException("super.init() was never called. This should go an @Before method.");
        }
    }
}
