package org.naddeo.graphql.types.scalars;

import org.naddeo.graphql.types.GraphQLType;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

/**
 * Built in Boolean scalar type definition
 */
@Value
@Builder
@Wither
public class BooleanType implements GraphQLType
{
    public static final BooleanType BOOLEAN = BooleanType.builder().nullable(true).list(false).build();
    public static final BooleanType NON_NULL_BOOLEAN = BooleanType.builder().nullable(false).list(false).build();
    public static final BooleanType BOOLEAN_LIST = BooleanType.builder().nullable(true).list(true).build();
    public static final BooleanType NON_NULL_BOOLEAN_LIST = BOOLEAN_LIST.withNullable(false);

    private final Boolean nullable;
    private final Boolean list;

    @Override
    public String getName()
    {
        return "Boolean";
    }
}
