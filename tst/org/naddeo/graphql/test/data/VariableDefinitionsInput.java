package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.BaseGrammarTest;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.VariableArgument;
import org.naddeo.graphql.types.VariableArguments;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

import static org.naddeo.graphql.BaseGrammarTest.*;

@RequiredArgsConstructor
public enum VariableDefinitionsInput implements TestData<VariableArguments> {
    HAPPY_PATH(TestObject.<VariableArguments>builder()
            .parserInput("(id : Long = 0)")
            .expectedClass(VariableArguments.class)
            .pojoValue(VariableArguments.builder()
                    .variableArgument(VariableArgument.builder().name("id").type("Long").defaultValue(VALUE_FACTORY.of((0))).build()).build())
            .build()),
    MULTIPLE_VARS(TestObject.<VariableArguments>builder()
            .parserInput("(id: Long = 0, name: String, ended: Boolean = false)")
            .expectedClass(VariableArguments.class)
            .pojoValue(VariableArguments.builder()
                    .variableArgument(VariableArgument.builder().name("id").type("Long").defaultValue(VALUE_FACTORY.of((0))).build())
                    .variableArgument(VariableArgument.builder().name("name").type("String").build())
                    .variableArgument(VariableArgument.builder().name("ended").type("Boolean").defaultValue(VALUE_FACTORY.of((false))).build())
                    .build())
            .build()),

    MULTIPLE_LINES(TestObject.<VariableArguments>builder()
            .parserInput(MULTIPLE_VARS.test.getParserInput().replace(",", "\n"))
            .expectedClass(VariableArguments.class)
            .pojoValue(MULTIPLE_VARS.test.getPojoValue())
            .build()),;

    @Getter
    private final TestObject<VariableArguments> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
