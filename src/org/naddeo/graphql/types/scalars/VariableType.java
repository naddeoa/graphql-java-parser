package org.naddeo.graphql.types.scalars;

import org.naddeo.graphql.types.GraphQLType;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

/**
 * Type for variables
 */
@Value
@Builder
@Wither
public class VariableType implements GraphQLType
{
    private final String name;

    @Override
    public Boolean getNullable()
    {
        return true;
    }

    @Override
    public Boolean getList()
    {
        return false;
    }

    public String getDisplay()
    {
        return "$" + name;
    }
}
