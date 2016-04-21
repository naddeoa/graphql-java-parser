package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.FragmentSpread;

import java.util.Iterator;
import java.util.stream.Stream;

public interface FragmentSpreadContainer {

    Stream<FragmentSpread> fragmentSpreadStream();

    default Iterator<FragmentSpread> fragmentSpreadIterator()
    {
        return fragmentSpreadStream().iterator();
    }
}
