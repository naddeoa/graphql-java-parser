package org.naddeo.graphql.types.scalars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VariableTypeTest
{
    @Test
    public void testGetDisplay() throws Exception
    {
        VariableType variableType = VariableType.builder()
                .name("variable")
                .build();

        String expected = "$variable";
        assertEquals(expected, variableType.getDisplay());
    }
}