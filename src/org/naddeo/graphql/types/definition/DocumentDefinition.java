package org.naddeo.graphql.types.definition;

public abstract class DocumentDefinition<T> {

    abstract public T getDefinition();

    abstract public DefinitionType getType();

    @Override
    public String toString()
    {
        return getType() + ":" + getDefinition();
    }
}
