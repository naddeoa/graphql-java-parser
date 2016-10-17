package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.ObjectTypeDefinition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ObjectTypeDefinitionInput implements TestData<ObjectTypeDefinition>
{
    HAPPY_PATH(TestObject.<ObjectTypeDefinition>builder()
            .parserInput(String.format("type Human implements Character { %s }", ObjectTypeFieldListInput.HAPPY_PATH.getTest().getParserInput()))
            .expectedClass(ObjectTypeDefinition.class)
            .pojoValue(ObjectTypeDefinition.builder()
                    .name("Human")
                    .implementedInterface("Character")
                    .objectTypeFieldList(ObjectTypeFieldListInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),

    WITHOUT_INTERFACE(TestObject.<ObjectTypeDefinition>builder()
            .parserInput(String.format("type Human { %s }", ObjectTypeFieldListInput.HAPPY_PATH.getTest().getParserInput()))
            .expectedClass(ObjectTypeDefinition.class)
            .pojoValue(ObjectTypeDefinition.builder()
                    .name("Human")
                    .objectTypeFieldList(ObjectTypeFieldListInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    ;

    @Getter
    private final TestObject<ObjectTypeDefinition> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
