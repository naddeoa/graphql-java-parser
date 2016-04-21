package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.VariableArgument;

import java.util.Iterator;
import java.util.stream.Stream;

public interface VariableArgumentContainer {

    Stream<VariableArgument> variableArgumentStream();

    default Iterator<VariableArgument> variableArgumentIterator()
    {
        return this.variableArgumentStream().iterator();
    }
}
