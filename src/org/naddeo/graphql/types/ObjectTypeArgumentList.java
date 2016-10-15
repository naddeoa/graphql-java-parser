package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import static java.util.stream.Collectors.joining;

@Value
@Builder
public class ObjectTypeArgumentList implements GraphQLDisplayable
{
    public static ObjectTypeArgumentList EMPTY_ARGUMENT_LIST = new ObjectTypeArgumentList(null);

    @Singular
    private final ImmutableSet<ObjectTypeArgument> arguments;

    public ObjectTypeArgumentList(ImmutableSet<ObjectTypeArgument> arguments)
    {
        this.arguments = arguments == null ? ImmutableSet.of() : arguments;
    }

    @Override
    public String getDisplay()
    {
        return arguments.stream().map(GraphQLDisplayable::getDisplay).collect(joining(", "));
    }
}
