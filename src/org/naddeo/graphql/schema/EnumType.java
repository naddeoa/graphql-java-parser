package org.naddeo.graphql.schema;

import lombok.Builder;
import lombok.Value;

/**
 * Created by naddeo on 10/14/16.
 */
@Value
@Builder
public class EnumType
{
    private final String name;
    private final EnumTypeEntries entries;
}
