package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.naddeo.graphql.types.container.ArgumentContainer;

import java.util.stream.Stream;

@Data
@Builder
public class ArgumentList implements ArgumentContainer{

    public static final ArgumentList EMPTY_ARGUMENT_LIST = new ArgumentList(null);

    @Singular @NonNull public final ImmutableSet<Argument> arguments;

    public ArgumentList(ImmutableSet<Argument> arguments)
    {
        this.arguments = arguments == null ? ImmutableSet.of() : arguments;
    }

    @Override
    public Stream<Argument> argumentStream()
    {
        return this.arguments.stream();
    }
}
