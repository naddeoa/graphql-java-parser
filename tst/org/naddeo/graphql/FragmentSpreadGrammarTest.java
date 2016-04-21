package org.naddeo.graphql;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.naddeo.graphql.test.data.FragmentSpreadInput;
import org.naddeo.graphql.test.data.TestData;

import java.util.Collection;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class FragmentSpreadGrammarTest extends BaseGrammarTest {

    @Parameters(name = "TestData: {0}")
    public static Collection<TestData[]> data()
    {
        return parameterize(FragmentSpreadInput.values());
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
        return ForcedStatement.FRAGMENT_SPREAD;
    }
}