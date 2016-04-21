package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.Argument;

import java.util.Iterator;
import java.util.stream.Stream;

public interface ArgumentContainer {

    Stream<Argument> argumentStream();

    default Iterator<Argument> argumentIterator()
    {
        return this.argumentStream().iterator();
    }
}
