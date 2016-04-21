package org.naddeo.graphql.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Selection<T> {

    private final T of;
}
