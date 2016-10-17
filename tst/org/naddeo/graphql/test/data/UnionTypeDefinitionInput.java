package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.UnionTypeDefinition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UnionTypeDefinitionInput implements TestData<UnionTypeDefinition>
{
    HAPPY_PATH(TestObject.<UnionTypeDefinition>builder()
            .parserInput("union MyUnion = " + UnionValuesInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(UnionTypeDefinition.class)
            .pojoValue(UnionTypeDefinition.builder()
                    .name("MyUnion")
                    .values(UnionValuesInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build());

    @Getter
    private final TestObject<UnionTypeDefinition> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
