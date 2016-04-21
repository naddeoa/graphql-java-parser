package org.naddeo.graphql.test.data;

import lombok.Data;
import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

@Data
public class StreamSizeData<T> {
    @NonNull private final Function<T, Stream> streamFunction;
    @NonNull private final Long expectedResults;
    @NonNull private final Class streamReturnType;

}
