package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Value;

/**
 * This class represents a union definition with the following syntax:
 *
 * <pre>
 *     union MyUnion = Class1 | Class2! | [Class3]!
 * </pre>
 */
@Value
@Builder
public class UnionTypeDefinition implements GraphQLDisplayable
{
    private final String name;
    private final UnionValues values;

    public UnionTypeDefinition(String name, UnionValues values)
    {
        this.name = name;
        this.values = values;
    }

    @Override
    public String getDisplay()
    {
        return new StringBuilder("union ")
                .append(name)
                .append(" = ")
                .append(values.getDisplay())
                .toString();
    }
}
