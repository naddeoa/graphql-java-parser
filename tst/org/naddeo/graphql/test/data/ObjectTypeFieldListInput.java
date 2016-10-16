package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.ObjectTypeFieldList;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ObjectTypeFieldListInput implements TestData<ObjectTypeFieldList>
{
    HAPPY_PATH(TestObject.<ObjectTypeFieldList>builder()
            .parserInput(ObjectTypeFieldInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(ObjectTypeFieldList.class)
            .pojoValue(ObjectTypeFieldList.builder()
                    .typeField(ObjectTypeFieldInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),;

    @Getter
    private final TestObject<ObjectTypeFieldList> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
