package org.naddeo.graphql;

/**
 * Classes that implement this interface declare that they are a part of the
 * GraphQL object model and they can be converted into a string portion of a
 * GraphQL document.
 */
public interface GraphQLDisplayable
{
    /**
     * Get this object as it should appear in a GraphQL document.
     * @return this object as it should appear in a GraphQL document
     */
    String getDisplay();
}
