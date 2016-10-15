package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder
@Wither
public class ObjectTypeArgument
{
    private final String name;
    private final ObjectType type;
    private final String defaultValue;
}
