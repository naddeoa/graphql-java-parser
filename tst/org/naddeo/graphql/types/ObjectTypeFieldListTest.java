package org.naddeo.graphql.types;

import org.junit.Test;
import org.naddeo.graphql.types.scalars.IntType;
import org.naddeo.graphql.types.scalars.StringType;

import static org.junit.Assert.assertEquals;

/**
 * Created by naddeo on 10/16/16.
 */
public class ObjectTypeFieldListTest
{
    @Test
    public void testGetDisplay()
    {
        ObjectTypeFieldList objectTypeFieldList = ObjectTypeFieldList.builder()
                .typeField(ObjectTypeField.builder()
                        .name("name")
                        .type(StringType.NON_NULL_STRING)
                        .arguments(ObjectTypeArgumentList.builder()
                                .argument(ObjectTypeArgument.builder()
                                        .name("arg")
                                        .type(StringType.STRING_LIST)
                                        .build())
                                .build())
                        .build())
                .typeField(ObjectTypeField.builder()
                        .name("age")
                        .type(IntType.INT)
                        .build())
                .build();

        String expected = "name(arg: [String]): String!, age: Int";
        assertEquals(expected, objectTypeFieldList.getDisplay());
    }
}