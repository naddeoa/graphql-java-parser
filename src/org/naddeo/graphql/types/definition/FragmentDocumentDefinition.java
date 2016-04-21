package org.naddeo.graphql.types.definition;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.FragmentDefinition;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class FragmentDocumentDefinition extends DocumentDefinition<FragmentDefinition> {

    @NonNull private final FragmentDefinition definition;

    @Override
    public FragmentDefinition getDefinition()
    {
        return definition;
    }

    @Override
    public DefinitionType getType()
    {
        return DefinitionType.OPERATION;
    }
}
