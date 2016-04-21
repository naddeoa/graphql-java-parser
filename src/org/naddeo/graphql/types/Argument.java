package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.naddeo.graphql.types.value.Value;

/**
 * @author naddeo
 */
@Data
@Builder
public class Argument {

    @NonNull public final String name;
    @NonNull public final Value value;
}
