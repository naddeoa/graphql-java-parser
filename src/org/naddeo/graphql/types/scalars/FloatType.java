package org.naddeo.graphql.types.scalars;

import org.naddeo.graphql.types.GraphQLType;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

/**
 * Built in String scalar type definition
 */
@Value
@Builder
@Wither
public class FloatType implements GraphQLType
{
    public static final FloatType FLOAT = FloatType.builder().nullable(true).list(false).build();
    public static final FloatType NON_NULL_FLOAT = FloatType.builder().nullable(false).list(false).build();
    public static final FloatType FLOAT_LIST = FloatType.builder().nullable(true).list(true).build();
    public static final FloatType NON_NULL_FLOAT_LIST = FLOAT_LIST.withNullable(false);

    private final Boolean nullable;
    private final Boolean list;

    @Override
    public String getName()
    {
        return "Float";
    }
}
