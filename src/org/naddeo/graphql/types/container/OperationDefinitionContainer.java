package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.OperationDefinition;

import java.util.Iterator;
import java.util.stream.Stream;

public interface OperationDefinitionContainer {

    Stream<OperationDefinition> operationDefinitionStream();

    default Iterator<OperationDefinition> operationDefinitinosIterator()
    {
        return operationDefinitionStream().iterator();
    }
}
