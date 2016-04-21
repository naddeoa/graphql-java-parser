package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.BaseGrammarTest;
import org.naddeo.graphql.types.ArgumentList;
import org.naddeo.graphql.types.OperationDefinition;
import org.naddeo.graphql.types.definition.DocumentDefinition;
import org.naddeo.graphql.types.definition.DocumentDefinitions;
import org.naddeo.graphql.types.definition.FragmentDocumentDefinition;
import org.naddeo.graphql.types.definition.OperationDocumentDefinition;

import static org.naddeo.graphql.BaseGrammarTest.DOCUMENT_DEFINITION_FACTORY;

@RequiredArgsConstructor
public enum DefinitionInput implements TestData<DocumentDefinition> {
    HAPPY_PATH_FRAGMENT(TestObject.<DocumentDefinition>builder()
            .parserInput(FragmentDefinitionInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(FragmentDocumentDefinition.class)
            .pojoValue(DOCUMENT_DEFINITION_FACTORY.of(FragmentDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
            .build()),

    HAPPY_PATH_OPERATION(TestObject.<DocumentDefinition>builder()
            .parserInput(OperationDefinitionInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(OperationDocumentDefinition.class)
            .pojoValue(DOCUMENT_DEFINITION_FACTORY.of(OperationDefinitionInput.HAPPY_PATH.getTest().getPojoValue()))
            .build()),;

    @Getter
    private final TestObject<DocumentDefinition> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
