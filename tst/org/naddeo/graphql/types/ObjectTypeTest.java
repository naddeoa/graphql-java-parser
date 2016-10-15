package org.naddeo.graphql.types;

import org.junit.Test;

import junit.framework.TestCase;

public class ObjectTypeTest
{
    @Test
    public void testGetDisplay_nonNullList() throws Exception
    {
        ObjectType objectType = ObjectType.builder()
                .name("name")
                .list(true)
                .nullable(false)
                .build();

        String expected = "[name]!";
        TestCase.assertEquals(expected, objectType.getDisplay());
    }

    @Test
    public void testGetDisplay_happyPath() throws Exception
    {
        ObjectType objectType = ObjectType.builder()
                .name("name")
                .list(false)
                .nullable(true)
                .build();

        String expected = "name";
        TestCase.assertEquals(expected, objectType.getDisplay());
    }
}