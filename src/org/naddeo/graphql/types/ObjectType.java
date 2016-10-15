package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder
@Wither
public class ObjectType implements GraphQLType
{
    private final String name;
    private final Boolean nullable;
    private final Boolean list;
}
