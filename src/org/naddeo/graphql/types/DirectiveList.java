package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.naddeo.graphql.types.container.DirectiveContainer;

import java.util.stream.Stream;

@Data
@Builder
public class DirectiveList implements DirectiveContainer {

    public static final DirectiveList EMPTY_DIRECTIVE_LIST = new DirectiveList(null);

    @Singular @NonNull private final ImmutableSet<Directive> directives;

    public DirectiveList(ImmutableSet<Directive> directives)
    {
        this.directives = directives == null ? ImmutableSet.of() : directives;
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        return this.directives.stream();
    }
}
