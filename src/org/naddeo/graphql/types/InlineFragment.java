package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.container.DirectiveContainer;
import org.naddeo.graphql.types.container.SelectionContainer;

import java.util.stream.Stream;

@Data
@Builder
public class InlineFragment implements DirectiveContainer, SelectionContainer {

    @NonNull private final String typeName;
    @NonNull private final DirectiveList directives;
    @NonNull private final SelectionSet selections;

    public InlineFragment(String typeName, DirectiveList directives, SelectionSet selections)
    {
        this.typeName = typeName;
        this.directives = directives == null ? DirectiveList.EMPTY_DIRECTIVE_LIST : directives;
        this.selections = selections == null ? SelectionSet.EMPTY_SELECTION_SET : selections;
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        if (this.directives == null) {
            return Stream.empty();
        }

        return this.directives.directiveStream();
    }

    @Override
    public Stream<Selection> selectionStream()
    {
        if (this.selections == null) {
            return Stream.empty();
        }

        return this.selections.selectionStream();
    }
}
