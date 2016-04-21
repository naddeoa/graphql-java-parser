package org.naddeo.graphql;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.naddeo.graphql.test.data.DirectivesInput;
import org.naddeo.graphql.test.data.TestData;

import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class DirectivesGrammarTest extends BaseGrammarTest {

    @Parameters(name = "TestData: {0}")
    public static Collection<TestData[]> data()
    {
        return parameterize(DirectivesInput.values());
    }

    private TestData currentTest;

    @Test
    public void test()
    {
        assertCanParse(currentTest);
    }

    @Override
    ForcedStatement getTestedRule()
    {
        return ForcedStatement.DIRECTIVES;
    }
}
