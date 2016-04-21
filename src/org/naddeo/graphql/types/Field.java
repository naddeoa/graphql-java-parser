package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.container.ArgumentContainer;
import org.naddeo.graphql.types.container.DirectiveContainer;
import org.naddeo.graphql.types.container.SelectionContainer;

import java.util.stream.Stream;

import static com.google.common.base.MoreObjects.*;

@Data
@Builder
public class Field implements DirectiveContainer, SelectionContainer, ArgumentContainer {

    private final String alias;
    @NonNull private final String name;
    @NonNull private final ArgumentList arguments;
    @NonNull private final DirectiveList directives;
    @NonNull private final SelectionSet selections;

    public Field(String alias, String name, ArgumentList arguments, DirectiveList directives, SelectionSet selections)
    {
        this.alias = alias;
        this.name = name;
        this.selections = selections == null ? SelectionSet.EMPTY_SELECTION_SET : selections;
        this.arguments = arguments == null ? ArgumentList.EMPTY_ARGUMENT_LIST : arguments;
        this.directives = directives == null ? DirectiveList.EMPTY_DIRECTIVE_LIST : directives;
    }

    public String getResponseKey()
    {
        return firstNonNull(alias, name);
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        return this.directives.directiveStream();
    }

    @Override
    public Stream<Selection> selectionStream()
    {
        return this.selections.selectionStream();
    }

    @Override
    public Stream<Argument> argumentStream()
    {
        return this.arguments.argumentStream();
    }
}
