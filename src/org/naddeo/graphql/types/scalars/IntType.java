package org.naddeo.graphql.types.scalars;

import org.naddeo.graphql.types.GraphQLType;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

/**
 * Built in Int scalar type definition
 */
@Value
@Builder
@Wither
public class IntType implements GraphQLType
{
    public static final IntType INT = IntType.builder().nullable(true).list(false).build();
    public static final IntType NON_NULL_INT = IntType.builder().nullable(false).list(false).build();
    public static final IntType INT_LIST = IntType.builder().nullable(true).list(true).build();
    public static final IntType NON_NULL_INT_LIST = INT_LIST.withNullable(false);

    private final Boolean nullable;
    private final Boolean list;

    @Override
    public String getName()
    {
        return "Int";
    }
}
