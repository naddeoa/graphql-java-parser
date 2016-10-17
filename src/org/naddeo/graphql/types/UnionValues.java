package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

/**
 * This object represents the possible values of a union type. It has the following syntax:
 *
 * <pre>
 *     Class1 | [Class2] | Class3!
 * </pre>
 */
@Value
@Builder
public class UnionValues implements GraphQLDisplayable
{
    public static final UnionValues EMPTY_VALUES = new UnionValues(null);

    @Singular
    private final ImmutableSet<String> types;

    public UnionValues(ImmutableSet<String> types)
    {
        this.types = types == null ? ImmutableSet.of() : types;
    }

    @Override
    public String getDisplay()
    {
        return String.join(" | ", types);
    }
}
