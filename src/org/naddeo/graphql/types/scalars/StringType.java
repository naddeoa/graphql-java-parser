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
public class StringType implements GraphQLType
{
    public static final StringType NON_NULL_STRING = StringType.builder().nullable(false).list(false).build();
    public static final StringType STRING_LIST = StringType.builder().nullable(true).list(true).build();
    public static final StringType NON_NULL_STRING_LIST = STRING_LIST.withNullable(false);

    private final Boolean nullable;
    private final Boolean list;

    @Override
    public String getName()
    {
        return "String";
    }
}
