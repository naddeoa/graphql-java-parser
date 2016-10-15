package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.ObjectType;
import org.naddeo.graphql.types.ObjectTypeField;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ObjectTypeFieldInput implements TestData<ObjectTypeField>
{
    HAPPY_PATH(TestObject.<ObjectTypeField>builder()
            .parserInput("fieldName: String")
            .expectedClass(ObjectTypeField.class)
            .pojoValue(ObjectTypeField.builder()
                    .name("fieldName")
                    .type(ObjectType.builder()
                            .name("String")
                            .nullable(true)
                            .list(false)
                            .build())
                    .build())
            .build()),

    COMPLEX_TYPE(TestObject.<ObjectTypeField>builder()
            .parserInput("fieldName: " + ObjectTypeInput.NULLABLE_LIST.getTest().getParserInput())
            .expectedClass(ObjectTypeField.class)
            .pojoValue(ObjectTypeField.builder()
                    .name("fieldName")
                    .type(ObjectTypeInput.NULLABLE_LIST.getTest().getPojoValue())
                    .build())
            .build()),

    WITH_ARGUMENTS(TestObject.<ObjectTypeField>builder()
            .parserInput("fieldName ("
                    + ObjectTypeArgumentListInput.LISTS_WITHOUT_COMMAS.getTest().getParserInput()
                    + ") : "
                    + ObjectTypeInput.NULLABLE_LIST.getTest().getParserInput())
            .expectedClass(ObjectTypeField.class)
            .pojoValue(ObjectTypeField.builder()
                    .name("fieldName")
                    .arguments(ObjectTypeArgumentListInput.LISTS_WITHOUT_COMMAS.getTest().getPojoValue())
                    .type(ObjectTypeInput.NULLABLE_LIST.getTest().getPojoValue())
                    .build())
            .build());
    @Getter
    private final TestObject<ObjectTypeField> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
