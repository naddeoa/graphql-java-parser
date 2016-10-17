package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.UnionValues;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UnionValuesInput implements TestData<UnionValues>
{
    HAPPY_PATH(TestObject.<UnionValues>builder()
            .parserInput("Human | Character | Person")
            .expectedClass(UnionValues.class)
            .pojoValue(UnionValues.builder()
                    .type("Human")
                    .type("Character")
                    .type("Person")
                    .build())
            .build()),;

    @Getter
    private final TestObject<UnionValues> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
