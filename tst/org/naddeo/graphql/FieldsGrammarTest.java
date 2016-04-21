package org.naddeo.graphql;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.naddeo.graphql.test.data.FieldInput;
import org.naddeo.graphql.test.data.TestData;

import java.util.Collection;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class FieldsGrammarTest extends BaseGrammarTest {


    @Parameterized.Parameters(name = "TestData: {0}")
    public static Collection<TestData[]> data()
    {
        return parameterize(FieldInput.values());
    }

    private TestData currentTest;

    @Test
    public void test()
    {
        assertCanParse(currentTest);
    }

    @Override
    public ForcedStatement getTestedRule()
    {
        return ForcedStatement.FIELDS;
    }

}