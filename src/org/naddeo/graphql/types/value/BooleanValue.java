package org.naddeo.graphql.types.value;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author naddeo
 */
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class BooleanValue extends Value<Boolean>{

    @NonNull private final Boolean value;

    @Override
    public Boolean getValue()
    {
        return value;
    }

    @Override
    public ValueType getType()
    {
        return ValueType.BOOLEAN;
    }
}
