package org.naddeo.graphql.types.value;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * @author naddeo
 */
@EqualsAndHashCode(callSuper = false)
public class StringValue extends Value<String>{

    @NonNull private final String value;

    StringValue(String value)
    {
        this.value = value.replace("\"", "");
    }

    @Override
    public String getValue()
    {
        return value;
    }

    @Override
    public ValueType getType()
    {
        return ValueType.STRING;
    }

    @Override
    public String toString()
    {
        return new StringBuilder(getType().toString())
                .append(":")
                .append("\"")
                .append(getValue())
                .append("\"")
                .toString();
    }

    @Override
    public String getDisplay()
    {
        return "\"" + value + "\"";
    }
}
