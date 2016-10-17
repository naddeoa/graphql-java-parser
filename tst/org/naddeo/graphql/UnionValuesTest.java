package org.naddeo.graphql;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.naddeo.graphql.test.data.ObjectTypeInput;
import org.naddeo.graphql.test.data.TestData;
import org.naddeo.graphql.test.data.UnionValuesInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class UnionValuesTest extends BaseGrammarTest
{
    @Parameterized.Parameters(name = "TestData: {0}")
    public static Collection<TestData[]> data()
    {
        return parameterize(UnionValuesInput.values());
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
        return ForcedStatement.UNION_VALUES;
    }
}
