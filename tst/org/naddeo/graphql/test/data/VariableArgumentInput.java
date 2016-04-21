package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.BaseGrammarTest;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.VariableArgument;
import org.naddeo.graphql.types.VariableArguments;
import org.naddeo.graphql.types.definition.DocumentDefinitions;
import org.naddeo.graphql.types.value.ValueFactory;

import static org.naddeo.graphql.BaseGrammarTest.VALUE_FACTORY;

@RequiredArgsConstructor
public enum VariableArgumentInput implements TestData<VariableArgument> {
    HAPPY_PATH(TestObject.<VariableArgument>builder()
            .parserInput("id : Long = 3")
            .expectedClass(VariableArgument.class)
            .pojoValue(VariableArgument.builder().name("id").type("Long").defaultValue(VALUE_FACTORY.of(3)).build())
            .build()),
    NO_DEFAULT_VALUE(TestObject.<VariableArgument>builder()
            .parserInput("id : Long")
            .expectedClass(VariableArgument.class)
            .pojoValue(VariableArgument.builder().name("id").type("Long").build())
            .build()),;

    @Getter
    private final TestObject<VariableArgument> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
