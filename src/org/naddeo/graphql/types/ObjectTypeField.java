package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ObjectTypeField implements GraphQLDisplayable
{
    private final String name;
    private final ObjectTypeArgumentList arguments;
    private final GraphQLType type;

    public ObjectTypeField(String name, ObjectTypeArgumentList arguments, GraphQLType type)
    {
        this.name = name;
        this.arguments = arguments == null ? ObjectTypeArgumentList.EMPTY_ARGUMENT_LIST : arguments;
        this.type = type;
    }

    @Override
    public String getDisplay()
    {
        StringBuilder sb = new StringBuilder(name);

        if (!arguments.getArguments().isEmpty()) {
            sb.append("(");
            sb.append(arguments.getDisplay());
            sb.append(")");
        }

        sb.append(": ");
        sb.append(type.getDisplay());
        return sb.toString();
    }
}
