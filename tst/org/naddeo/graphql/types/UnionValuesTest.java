package org.naddeo.graphql.types;

import org.junit.Test;
import org.naddeo.graphql.types.scalars.IntType;
import org.naddeo.graphql.types.scalars.StringType;

import static org.junit.Assert.assertEquals;

public class UnionValuesTest
{
    @Test
    public void testGetDisplay_happyPath() throws Exception
    {
        UnionValues unionValues = UnionValues.builder()
                .type("String")
                .type("Int")
                .build();

        String expected = "String | Int";
        assertEquals(expected, unionValues.getDisplay());
    }

    @Test
    public void testGetDisplay_empty() throws Exception
    {
        UnionValues unionValues = UnionValues.builder()
                .build();

        String expected = "";
        assertEquals(expected, unionValues.getDisplay());
    }
}