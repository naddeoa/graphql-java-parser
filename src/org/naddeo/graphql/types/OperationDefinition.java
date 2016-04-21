package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.container.DirectiveContainer;
import org.naddeo.graphql.types.container.FieldContainer;
import org.naddeo.graphql.types.container.FragmentSpreadContainer;
import org.naddeo.graphql.types.container.InlineFragmentContainer;
import org.naddeo.graphql.types.container.SelectionContainer;
import org.naddeo.graphql.types.container.VariableArgumentContainer;

import java.util.stream.Stream;

@Data
@Builder
public class OperationDefinition implements FieldContainer, FragmentSpreadContainer, InlineFragmentContainer, DirectiveContainer, VariableArgumentContainer, SelectionContainer {

    private final String operationType;
    @NonNull private final String name;
    @NonNull private final VariableArguments variableArguments;
    @NonNull private final DirectiveList directives;
    @NonNull private final SelectionSet selectionSet;

    public OperationDefinition(String operationType, String name, VariableArguments variableArguments, DirectiveList directives, SelectionSet selectionSet)
    {
        this.operationType = operationType;
        this.name = name;
        this.variableArguments = variableArguments == null ? VariableArguments.EMPTY_VARIABLE_ARGUMENTS : variableArguments;
        this.directives = directives == null ? DirectiveList.EMPTY_DIRECTIVE_LIST : directives;
        this.selectionSet = selectionSet == null ? SelectionSet.EMPTY_SELECTION_SET : selectionSet;
    }

    @Override
    public Stream<Field> fieldStream()
    {
        return this.selectionSet.fieldStream();
    }

    @Override
    public Stream<FragmentSpread> fragmentSpreadStream()
    {
        return this.selectionSet.fragmentSpreadStream();
    }

    @Override
    public Stream<InlineFragment> inlineFragmentStream()
    {
        return this.selectionSet.inlineFragmentStream();
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        return this.directives.directiveStream();
    }

    @Override
    public Stream<VariableArgument> variableArgumentStream()
    {
        return this.variableArguments.variableArgumentStream();
    }

    @Override
    public Stream<Selection> selectionStream()
    {
        return this.selectionSet.selectionStream();
    }
}
