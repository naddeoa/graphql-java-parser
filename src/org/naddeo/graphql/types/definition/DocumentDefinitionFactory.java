package org.naddeo.graphql.types.definition;

import org.naddeo.graphql.types.FragmentDefinition;
import org.naddeo.graphql.types.OperationDefinition;

public class DocumentDefinitionFactory {

    public FragmentDocumentDefinition of(FragmentDefinition definition)
    {
        return new FragmentDocumentDefinition(definition);
    }

    public OperationDocumentDefinition of(OperationDefinition definition)
    {
        return new OperationDocumentDefinition(definition);
    }
}
