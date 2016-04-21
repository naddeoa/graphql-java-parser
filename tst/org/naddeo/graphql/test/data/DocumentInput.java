package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

import static org.naddeo.graphql.BaseGrammarTest.DOCUMENT_DEFINITION_FACTORY;
import static org.naddeo.graphql.test.data.TestData.joinQueries;

@RequiredArgsConstructor
public enum DocumentInput implements TestData<DocumentDefinitions> {
    HAPPY_PATH(TestObject.<DocumentDefinitions>builder()
            .parserInput(joinQueries(FragmentDefinitionInput.HAPPY_PATH.getTest(), OperationDefinitionInput.HAPPY_PATH.getTest()))
            .expectedClass(DocumentDefinitions.class)
            .pojoValue(DocumentDefinitions.builder()
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(FragmentDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(OperationDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
                    .build())
            .build()),
    DEDUPED(TestObject.<DocumentDefinitions>builder()
            .parserInput(joinQueries(
                    FragmentDefinitionInput.HAPPY_PATH.getTest(),
                    OperationDefinitionInput.HAPPY_PATH.getTest(),
                    FragmentDefinitionInput.HAPPY_PATH.getTest(),
                    OperationDefinitionInput.HAPPY_PATH.getTest(),
                    FragmentDefinitionInput.HAPPY_PATH.getTest(),
                    OperationDefinitionInput.HAPPY_PATH.getTest()))
            .expectedClass(DocumentDefinitions.class)
            .pojoValue(DocumentDefinitions.builder()
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(FragmentDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(OperationDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
                    .build())
            .build()),
    MULTIPLE_OF_EACH(TestObject.<DocumentDefinitions>builder()
            .parserInput(joinQueries(
                    FragmentDefinitionInput.HAPPY_PATH.getTest(),
                    FragmentDefinitionInput.NO_DIRECTIVES.getTest(),
                    OperationDefinitionInput.NO_DIRECTIVES.getTest(),
                    OperationDefinitionInput.NO_VARIABLES.getTest(),
                    OperationDefinitionInput.HAPPY_PATH.getTest()))
            .expectedClass(DocumentDefinitions.class)
            .pojoValue(DocumentDefinitions.builder()
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(FragmentDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(FragmentDefinitionInput.NO_DIRECTIVES.getTest().getPojoValue()))
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(OperationDefinitionInput.NO_DIRECTIVES.getTest().getPojoValue()))
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(OperationDefinitionInput.NO_VARIABLES.getTest().getPojoValue()))
                    .definition(DOCUMENT_DEFINITION_FACTORY.of(OperationDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
                    .build())
            .build()),;

    @Getter
    private final TestObject<DocumentDefinitions> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
