package org.naddeo.graphql.types;

import org.junit.Test;
import org.naddeo.graphql.types.scalars.StringType;

import static org.junit.Assert.assertEquals;

public class ObjectTypeFieldTest
{
    @Test
    public void getDisplay() throws Exception
    {
        ObjectTypeField objectTypeField = ObjectTypeField.builder()
                .name("name")
                .type(StringType.NON_NULL_STRING)
                .arguments(ObjectTypeArgumentList.builder()
                        .argument(ObjectTypeArgument.builder()
                                .name("arg")
                                .type(StringType.STRING_LIST)
                                .build())
                        .build())
                .build();

        String expected = "name(arg: [String]): String!";
        assertEquals(expected, objectTypeField.getDisplay());
    }
}