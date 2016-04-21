package org.naddeo.graphql.test.data;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

@Data
@Builder
public class TestObject<T> {
    @NonNull private final String parserInput;
    @NonNull private final T pojoValue;
    @NonNull private final Class expectedClass;
    @NonNull @Singular ImmutableList<StreamSizeData> streamSizes;

}
