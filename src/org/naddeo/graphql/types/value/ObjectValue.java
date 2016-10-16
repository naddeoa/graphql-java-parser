package org.naddeo.graphql.types.value;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Value of a user defined type.
 */
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ObjectValue extends Value<String>
{
    @NonNull
    private final String value;

    @Override
    public String getValue()
    {
        return value;
    }

    @Override
    public ValueType getType()
    {
        return ValueType.OBJECT;
    }

    @Override
    public String getDisplay()
    {
        return value;
    }
}
