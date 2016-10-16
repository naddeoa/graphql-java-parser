package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;
import org.naddeo.graphql.types.value.Value;

import lombok.Builder;
import lombok.experimental.Wither;

@lombok.Value
@Builder
@Wither
public class ObjectTypeArgument implements GraphQLDisplayable
{
    private final String name;
    private final GraphQLType type;
    private final Value<?> defaultValue;

    @Override
    public String getDisplay()
    {
        StringBuilder sb = new StringBuilder(name);
        sb.append(": ");
        sb.append(type.getDisplay());

        if(defaultValue != null){
            sb.append(" = ");
            sb.append(defaultValue.getDisplay());
        }

        return sb.toString();
    }
}
