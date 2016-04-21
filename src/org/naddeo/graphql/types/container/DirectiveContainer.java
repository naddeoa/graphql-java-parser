package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.Directive;

import java.util.Iterator;
import java.util.stream.Stream;

public interface DirectiveContainer {

    Stream<Directive> directiveStream();

    default Iterator<Directive> directiveIterator()
    {
        return this.directiveStream().iterator();
    }
}
