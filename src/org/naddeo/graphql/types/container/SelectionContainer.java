package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.Selection;
import org.naddeo.graphql.types.SelectionSet;

import java.util.Iterator;
import java.util.stream.Stream;

public interface SelectionContainer {

    Stream<Selection> selectionStream();

    default Iterator<Selection> selectionIterator()
    {
        return this.selectionStream().iterator();
    }
}
