package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.FragmentDefinition;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

@RequiredArgsConstructor
public enum FragmentDefinitionInput implements TestData<FragmentDefinition> {
    HAPPY_PATH(TestObject.<FragmentDefinition>builder()
            .parserInput("fragment myFragment on User " + TestData.joinQueries(DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()))
            .expectedClass(FragmentDefinition.class)
            .pojoValue(FragmentDefinition.builder()
                    .name("myFragment")
                    .typeCondition("User")
                    .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    NO_DIRECTIVES(TestObject.<FragmentDefinition>builder()
            .parserInput("fragment myFragment on User " + SelectionSetInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(FragmentDefinition.class)
            .pojoValue(FragmentDefinition.builder()
                    .name("myFragment")
                    .typeCondition("User")
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    NO_NAME(TestObject.<FragmentDefinition>builder()
            .parserInput("fragment on User " + TestData.joinQueries(DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()))
            .expectedClass(FragmentDefinition.class)
            .pojoValue(FragmentDefinition.builder()
                    .typeCondition("User")
                    .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                    .selectionSet(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    ;


    @Getter
    private final TestObject<FragmentDefinition> test;


    @Override
    public String toString()
    {
        return testName();
    }
}
