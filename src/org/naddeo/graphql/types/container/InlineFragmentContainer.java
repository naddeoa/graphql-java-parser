package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.InlineFragment;

import java.util.Iterator;
import java.util.stream.Stream;

public interface InlineFragmentContainer {

    Stream<InlineFragment> inlineFragmentStream();

    default Iterator<InlineFragment> inlineFragmentIterator()
    {
        return inlineFragmentStream().iterator();
    }
}
