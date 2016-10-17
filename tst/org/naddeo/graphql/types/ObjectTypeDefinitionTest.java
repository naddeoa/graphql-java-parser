package org.naddeo.graphql.types;

import org.junit.Test;
import org.naddeo.graphql.test.data.ObjectTypeFieldInput;

import static org.junit.Assert.assertEquals;

public class ObjectTypeDefinitionTest
{
    @Test
    public void testGetDisplay_happyPath()
    {
        ObjectTypeDefinition objectTypeDefinition = ObjectTypeDefinition.builder()
                .name("MyType")
                .implementedInterface("MyInterface")
                .objectTypeFieldList(ObjectTypeFieldList.builder()
                        .typeField(ObjectTypeFieldInput.HAPPY_PATH.getTest().getPojoValue())
                        .build())
                .build();

        String expected = String.format("type MyType implements MyInterface { %s }", ObjectTypeFieldInput.HAPPY_PATH.getTest().getParserInput());
        assertEquals(expected, objectTypeDefinition.getDisplay());
    }
}