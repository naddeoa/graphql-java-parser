package org.naddeo.graphql.types.value;

import org.naddeo.graphql.GraphQLDisplayable;

/**
 * A Value represents a scalar value, such as a string or integer.
 *
 * @author Anthony Naddeo anthony.naddeo@gmail.com
 */
public abstract class Value<T> implements GraphQLDisplayable {

    abstract public T getValue();

    /**
     * @return A ValueType that denotes what this represents in GraphQL.
     * Both variable and stringValues will have a value of type of String, but
     * they represent different GraphQL types.
     */
    abstract public ValueType getType();

    @Override
    public String toString()
    {
        return getType() + ":" + getValue();
    }
}
