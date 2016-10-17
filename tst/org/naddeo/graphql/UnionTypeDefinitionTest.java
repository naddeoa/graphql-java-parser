package org.naddeo.graphql;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.naddeo.graphql.test.data.TestData;
import org.naddeo.graphql.test.data.UnionTypeDefinitionInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class UnionTypeDefinitionTest extends BaseGrammarTest
{
    @Parameterized.Parameters(name = "TestData: {0}")
    public static Collection<TestData[]> data()
    {
        return parameterize(UnionTypeDefinitionInput.values());
    }

    private TestData currentTest;

    @Test
    public void testParse()
    {
        assertCanParse(currentTest);
    }

    @Test
    public void testDisplay()
    {
        assertCanDisplay(currentTest);
    }

    @Override
    ForcedStatement getTestedRule()
    {
        return ForcedStatement.UNION_DEF;
    }
}
