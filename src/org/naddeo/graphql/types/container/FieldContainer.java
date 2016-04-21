package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.Field;

import java.util.Iterator;
import java.util.stream.Stream;

public interface FieldContainer {

    Stream<Field> fieldStream();

    default Iterator<Field> fieldIterator()
    {
        return fieldStream().iterator();
    }
}
