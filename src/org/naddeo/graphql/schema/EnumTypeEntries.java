package org.naddeo.graphql.schema;

import com.google.common.collect.ImmutableSet;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

/**
 *
 */
@Value
@Builder
public class EnumTypeEntries
{
    @Singular
    private final ImmutableSet<String> entries;
}
