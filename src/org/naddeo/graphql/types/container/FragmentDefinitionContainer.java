package org.naddeo.graphql.types.container;

import org.naddeo.graphql.types.FragmentDefinition;

import java.util.Iterator;
import java.util.stream.Stream;

public interface FragmentDefinitionContainer {

    Stream<FragmentDefinition> fragmentDefinitionStream();

    default Iterator<FragmentDefinition> fragmentDefinitionIterator()
    {
        return fragmentDefinitionStream().iterator();
    }
}
