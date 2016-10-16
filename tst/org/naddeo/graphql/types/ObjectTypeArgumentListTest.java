package org.naddeo.graphql.types;

import org.junit.Test;
import org.naddeo.graphql.types.value.ValueFactory;

import static org.junit.Assert.assertEquals;

public class ObjectTypeArgumentListTest
{
    private final ValueFactory valueFactory = new ValueFactory();

    @Test
    public void testGetDisplay_happyPath() throws Exception
    {
        ObjectTypeArgumentList objectTypeArgumentList = ObjectTypeArgumentList.builder()
                .argument(ObjectTypeArgument.builder()
                        .name("name")
                        .defaultValue(valueFactory.of("john")) // TODO this should have quotes
                        .type(ObjectType.builder().name("String").list(false).nullable(true).build())
                        .build())
                .argument(ObjectTypeArgument.builder()
                        .name("age")
                        .defaultValue(valueFactory.of(20.5))
                        .type(ObjectType.builder().name("Float").list(false).nullable(false).build())
                        .build())
                .build();

        String expected = "name: String = \"john\", age: Float! = 20.5";
        assertEquals(expected, objectTypeArgumentList.getDisplay());
    }
}