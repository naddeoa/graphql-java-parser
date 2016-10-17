package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder
@Wither
public class ObjectType implements GraphQLType
{
    @NonNull
    private final String name;
    @NonNull
    private final Boolean nullable;
    @NonNull
    private final Boolean list;
}
