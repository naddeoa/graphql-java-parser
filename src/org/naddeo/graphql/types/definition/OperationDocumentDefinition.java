package org.naddeo.graphql.types.definition;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.OperationDefinition;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class OperationDocumentDefinition extends DocumentDefinition<OperationDefinition> {

    @NonNull private final OperationDefinition definition;

    @Override
    public OperationDefinition getDefinition()
    {
        return definition;
    }

    @Override
    public DefinitionType getType()
    {
        return DefinitionType.FRAGMENT;
    }
}
