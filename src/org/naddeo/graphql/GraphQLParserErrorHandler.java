package org.naddeo.graphql;

import java.util.List;
import java.util.Stack;

import java_cup.runtime.Symbol;

import static java.lang.String.join;
import static java.util.stream.Collectors.toList;

/**
 * This class handles error reporting for the cup parser. It hooks into the parser
 * in the report_error hook that cup provides.
 */
class GraphQLParserErrorHandler
{
    /**
     * Throw a {@link GraphQLParseException} with a message generated from all of the inputs.
     * @param parser an instance of the cup parser
     * @param symbolStack The symbol stack from the parser. This needs to be supplied by the parser
     * since it is an implementation detail and isn't exposed in the parser interface.
     * @param message the message that the parser declared
     * @param currentSymbol the symbol the parser was on when the error occured
     * @throws GraphQLParseException
     */
    public void handle(GraphQLDocumentParser parser, Stack<Symbol> symbolStack, String message, Symbol currentSymbol) throws GraphQLParseException
    {
        List<String> displayableStack = symbolStack.stream().map(GraphQLParserErrorHandler::getDisplay).collect(toList());

        Symbol nextToken = null;
        try {
            nextToken = parser.getScanner().next_token();
        } catch (Exception ignored) {
        }

        throw new GraphQLParseException(String.format("Syntax error while parsing query, message was: %s\n" +
                        "So far, I parsed:          %s\n" +
                        "However, I didn't expect:  %s\n" +
                        "Next would have been:      %s",
                message,
                join(" ", displayableStack),
                getDisplay(currentSymbol),
                getDisplay(nextToken)));
    }

    /**
     * Convert the symbol into a string that can be printed in the exception message.
     * If the symbol contains a {@link GraphQLDisplayable} then the {@link GraphQLDisplayable#getDisplay()}
     * is used.
     * @param symbol a symbol from a GraphQL parse
     * @return string representation of that symbol.
     */
    private static String getDisplay(Symbol symbol)
    {
        if (symbol == null || symbol.value == null) {
            return "";
        }

        if (symbol.value instanceof GraphQLDisplayable) {
            return ((GraphQLDisplayable) symbol.value).getDisplay();
        } else {
            return symbol.value.toString();
        }
    }
}
