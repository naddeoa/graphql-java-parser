package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import org.naddeo.graphql.types.container.DirectiveContainer;
import org.naddeo.graphql.types.container.FieldContainer;
import org.naddeo.graphql.types.container.FragmentSpreadContainer;
import org.naddeo.graphql.types.container.InlineFragmentContainer;
import org.naddeo.graphql.types.container.SelectionContainer;

import java.util.stream.Stream;

@Data
@Builder
public class FragmentDefinition implements SelectionContainer, DirectiveContainer, FieldContainer, FragmentSpreadContainer, InlineFragmentContainer {

    private final String name;
    private final String typeCondition;
    private final DirectiveList directives;
    private final SelectionSet selectionSet;

    public FragmentDefinition(String name, String typeCondition, DirectiveList directives, SelectionSet selectionSet)
    {
        this.name = name;
        this.typeCondition = typeCondition;
        this.directives = directives == null ? DirectiveList.EMPTY_DIRECTIVE_LIST : directives;
        this.selectionSet = selectionSet == null ? SelectionSet.EMPTY_SELECTION_SET : selectionSet;
    }

    @Override
    public Stream<Selection> selectionStream()
    {
        return this.selectionSet.selectionStream();
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        return this.directives.directiveStream();
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
}
