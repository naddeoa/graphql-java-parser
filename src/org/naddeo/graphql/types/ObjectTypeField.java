package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ObjectTypeField
{
    private final String name;
    private final ObjectTypeArgumentList arguments;
    private final ObjectType type;
}
