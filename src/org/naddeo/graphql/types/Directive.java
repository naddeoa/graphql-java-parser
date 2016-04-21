package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.container.ArgumentContainer;

import java.util.stream.Stream;

@Data
@Builder
public class Directive implements ArgumentContainer{

    @NonNull private final String name;
    @NonNull private final ArgumentList arguments;

    public Directive(String name, ArgumentList arguments)
    {
        this.name = name;
        this.arguments = arguments == null ? ArgumentList.EMPTY_ARGUMENT_LIST : arguments;
    }

    @Override
    public Stream<Argument> argumentStream()
    {
        return this.arguments.argumentStream();
    }
}
