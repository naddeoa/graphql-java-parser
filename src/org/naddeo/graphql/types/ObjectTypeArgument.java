package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder
@Wither
public class ObjectTypeArgument implements GraphQLDisplayable
{
    private final String name;
    private final ObjectType type;
    private final String defaultValue;

    @Override
    public String getDisplay()
    {
        StringBuilder sb = new StringBuilder(name);
        sb.append(": ");
        sb.append(type.getDisplay());

        if(defaultValue != null){
            sb.append(" = ");
            sb.append(defaultValue);
        }

        return sb.toString();
    }
}
