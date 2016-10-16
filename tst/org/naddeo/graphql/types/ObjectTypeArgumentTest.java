package org.naddeo.graphql.types;

import org.junit.Test;
import org.naddeo.graphql.types.value.ValueFactory;

import static org.junit.Assert.assertEquals;

public class ObjectTypeArgumentTest
{
    private final ValueFactory valueFactory = new ValueFactory();

    @Test
    public void testGetDisplay_happyPath() throws Exception
    {
        ObjectTypeArgument objectTypeArgument = ObjectTypeArgument.builder()
                .name("name")
                .defaultValue(valueFactory.of("defaultValue"))
                .type(ObjectType.builder()
                        .name("Type")
                        .list(true)
                        .nullable(true)
                        .build())
                .build();

        String expected = "name: [Type] = \"defaultValue\"";
        assertEquals(expected, objectTypeArgument.getDisplay());
    }

    @Test
    public void testGetDisplay_objectType() throws Exception
    {
        ObjectTypeArgument objectTypeArgument = ObjectTypeArgument.builder()
                .name("name")
                .defaultValue(valueFactory.ofObject("METER"))
                .type(ObjectType.builder()
                        .name("Type")
                        .list(false)
                        .nullable(false)
                        .build())
                .build();

        String expected = "name: Type! = METER";
        assertEquals(expected, objectTypeArgument.getDisplay());
    }
}