package org.naddeo.graphql.types;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.container.DirectiveContainer;

import java.util.stream.Stream;

@Data
@Builder
public class FragmentSpread implements DirectiveContainer {

    @NonNull private final String name;
    @NonNull private final DirectiveList directives;

    public FragmentSpread(String name, DirectiveList directives)
    {
        this.name = name;
        this.directives = directives == null ? DirectiveList.EMPTY_DIRECTIVE_LIST : directives;
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        return this.directives.directiveStream();
    }
}
