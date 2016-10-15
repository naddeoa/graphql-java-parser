package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder
public class ObjectTypeArgumentList
{
    @Singular
    private final ImmutableSet<ObjectTypeArgument> arguments;
}
