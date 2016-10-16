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
public class VariableValue extends Value<String>{

    @NonNull private final String value;

    @Override
    public String getValue()
    {
        return value;
    }

    @Override
    public ValueType getType()
    {
        return ValueType.VARIABLE;
    }

    @Override
    public String getDisplay()
    {
        return "$" + value;
    }
}
