package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.OperationDefinition;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

import static org.naddeo.graphql.test.data.TestData.joinQueries;

@RequiredArgsConstructor
public enum OperationDefinitionInput implements TestData<OperationDefinition> {
    HAPPY_PATH(TestObject.<OperationDefinition>builder()
            .parserInput("query myQuery " + joinQueries(VariableDefinitionsInput.HAPPY_PATH.getTest(), DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()))
            .expectedClass(OperationDefinition.class)
            .pojoValue(OperationDefinition.builder()
                    .operationType("query")
                    .name("myQuery")
                    .variableArguments(VariableDefinitionsInput.HAPPY_PATH.getTest().getPojoValue())
                    .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    NO_DIRECTIVES(TestObject.<OperationDefinition>builder()
            .parserInput("query myQuery " + joinQueries(VariableDefinitionsInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()))
            .expectedClass(OperationDefinition.class)
            .pojoValue(OperationDefinition.builder()
                    .operationType("query")
                    .name("myQuery")
                    .variableArguments(VariableDefinitionsInput.HAPPY_PATH.getTest().getPojoValue())
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    NO_VARIABLES(TestObject.<OperationDefinition>builder()
            .parserInput("query myQuery " + joinQueries(DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()))
            .expectedClass(OperationDefinition.class)
            .pojoValue(OperationDefinition.builder()
                    .operationType("query")
                    .name("myQuery")
                    .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    ONLY_SELECTION(TestObject.<OperationDefinition>builder()
            .parserInput(SelectionSetInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(OperationDefinition.class)
            .pojoValue(OperationDefinition.builder()
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),;


    @Getter
    private final TestObject<OperationDefinition> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
