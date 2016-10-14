package org.naddeo.graphql.types;

/**
 * Built in scalar type definitions.
 */
public class ScalarTypes
{
    public static final ObjectType STRING = ObjectType.builder()
            .name("String")
            .list(false)
            .nullable(true)
            .build();

    public static final ObjectType NON_NULL_STRING = STRING.withNullable(false);

    public static final ObjectType FLOAT = ObjectType.builder()
            .name("Float")
            .list(false)
            .nullable(true)
            .build();

    public static final ObjectType NON_NULL_FLOAT = FLOAT.withNullable(false);

    public static final ObjectType INT = ObjectType.builder()
            .name("Int")
            .list(false)
            .nullable(true)
            .build();

    public static final ObjectType NON_NULL_INT = INT.withNullable(false);

    public static final ObjectType BOOLEAN = ObjectType.builder()
            .name("Boolean")
            .list(false)
            .nullable(true)
            .build();

    public static final ObjectType NON_NULL_BOOLEAN = BOOLEAN.withNullable(false);
}
