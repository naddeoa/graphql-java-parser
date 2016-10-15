package org.naddeo.graphql.types;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectTypeArgumentTest
{
    @Test
    public void testGetDisplay_happyPath() throws Exception
    {
        ObjectTypeArgument objectTypeArgument = ObjectTypeArgument.builder()
                .name("name")
                .defaultValue("defaultValue")
                .type(ObjectType.builder()
                        .name("Type")
                        .list(true)
                        .nullable(true)
                        .build())
                .build();

        String expected = "name: [Type] = defaultValue";
        assertEquals(expected, objectTypeArgument.getDisplay());
    }
}