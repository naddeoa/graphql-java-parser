package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.value.Value;

@Data
@Builder
public class VariableArgument {

    @NonNull private final String name;
    @NonNull private final String type;
    private final Value defaultValue;
}
