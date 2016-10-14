package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ObjectType
{
    private final String name;
    private final Boolean nullable;
    private final Boolean list;
}
