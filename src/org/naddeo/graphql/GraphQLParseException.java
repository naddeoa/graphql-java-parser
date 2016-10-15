package org.naddeo.graphql;

import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * This exception is thrown when an error occurs while parsing a GraphQL document.
 * Check the message for human readable details on why the parse failed and what
 * was expected.
 */
@Value
@EqualsAndHashCode(callSuper = false)
public class GraphQLParseException extends RuntimeException
{
    private final String message;
}
