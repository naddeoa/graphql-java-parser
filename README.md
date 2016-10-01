# Java parser for strings of GraphQL

This project provides a cup/jflex based lexer/parser that can be used to parse GraphQL strings. This
isn't a GraphQL server, but it is intended to be used in GraphQL server implementations. All that
this parser does it take GraphQL strings and convert them into an easy to use immutable object model that
allows you to stream over different parts of the GraphQL query and pull information out.

There is still a lot of project setup stuff to do. It isn't on Maven, and it may be a little out of
date compared to the GraphQL spec. Unit tests are run through IDEs at the moment instead of ant.

# Examples

```java

GraphQLDocumentParser parser = null;

/**
  * The exact initialization will depend on how the parser is used. This example is taken from
  * the unit tests (BaseGrammerTest), where input is taken from stdin and fed into the parser.
  */
public void initializationExample() throws IOException
{
    PipedInputStream input = new PipedInputStream();
    OutputStream output = new PipedOutputStream(input);
    parser = new GraphQLDocumentParser(new GraphQLDocumentLexer(new InputStreamReader(input)));
}

/**
  * This will be a little more streamlined in the future, but for now, this is how the parser
  * is used. In this example, the following string was read from stdin.
  *
  * "fragment myFragment on User @include(if:true) {   advertiserId   name   externalId }"
  */
public void exampleUsage(){
    Symbol symbol = parser.parse(); // Get the output from jflex/cup

    // Return type depends on the input string. It could have been a query, or a document if the input was different
    FragmentDefinition fragmentDefinition = (FragmentDefinition )symbol.value;

    // Pick specific info out of the definition. See FragmentDefinition.java
    String name = fragmentDefinition.getName(); // "myFragment"
    String typeCondition = fragmentDefinition.getTypeCondition(); // "User"

    // Use getters or streams to get nested info
    DirectiveList directives = fragmentDefinition.getDirectives();
    Directive directive = directives.get(0); // the only directive in the grpahql string above
    String directiveName = directive.getName(); // "include"
    Stream<Argument> argument = directive.argumentStream(); // stream the only arguments directly out of the directives
    String name = argument.collect(Collections.toList()).get(0).getName(); // "if"

    // Get all selections.
    List<Field> selections = fragmentDefinition.fieldStream().collect(Collectors.toList());

    // Get all of the fields in the query
    Field advertiserId = selections.get(0);
    Field name = selections.get(1);
    Field externalId = selections.get(2);

    String name = advertiserId.getName(); // "advertiserId"
}
```

# Demo
The only available demo at the moment comes in the form of a cli. Run the
following.

```sh
ant all run
```

This will start taking input from stdin. Then, paste any valid graphql in, like
the following:

```
fragment on Greetings {
            hello,
}
```

And hit `ctrl+d` to exit the parser. An error will occur if the string was
invalid, otherwise the object model will be printed out and the parser will
exit. Output for the above example is as follows. The `toString()` methods are
generated by lombok.

```
DocumentDefinitions(definitions=[OPERATION:FragmentDefinition(name=null, typeCondition=Greetings, directives=DirectiveList(directives=[]), selectionSet=SelectionSet(selections=[Selection(of=Field(alias=null, name=hello, arguments=ArgumentList(arguments=[]), directives=DirectiveList(directives=[]), selections=SelectionSet(selections=[])))]))])
```

# Todo
* Maven-ize the package and dependencies
* Wrap the parser so casting isn't needed
* Make it easy to supply streams or strings into the parser and get objects out
* Update documentation
* Fix the ant junit task



