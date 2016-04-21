package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.Argument;
import org.naddeo.graphql.types.ArgumentList;
import org.naddeo.graphql.types.OperationDefinition;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

import static org.naddeo.graphql.BaseGrammarTest.VALUE_FACTORY;

@RequiredArgsConstructor
public enum ArgumentsInput implements TestData<ArgumentList> {
    HAPPY_PATH(TestObject.<ArgumentList>builder()
            .parserInput("(id:2)")
            .pojoValue(ArgumentList.builder().argument(Argument.builder().name("id").value(VALUE_FACTORY.of(2)).build()).build())
            .expectedClass(ArgumentList.class)
            .build()),

    MULTIPLE_ARGS(TestObject.<ArgumentList>builder()
            .parserInput("(id:2 name:\"john\" age : 22.5)")
            .pojoValue(ArgumentList.builder()
                    .argument(Argument.builder().name("age").value(VALUE_FACTORY.of(22.5)).build())
                    .argument(Argument.builder().name("name").value(VALUE_FACTORY.of("john")).build())
                    .argument(Argument.builder().name("id").value(VALUE_FACTORY.of(2)).build())
                    .build())
            .expectedClass(ArgumentList.class)
            .build()),

    IGNORE_COMMENTS(TestObject.<ArgumentList>builder()
            .parserInput("(id:2, name:\"john\",, age : 22.5, male:true)")
            .pojoValue(ArgumentList.builder()
                    .argument(Argument.builder().name("male").value(VALUE_FACTORY.of(true)).build())
                    .argument(Argument.builder().name("age").value(VALUE_FACTORY.of(22.5)).build())
                    .argument(Argument.builder().name("name").value(VALUE_FACTORY.of("john")).build())
                    .argument(Argument.builder().name("id").value(VALUE_FACTORY.of(2)).build())
                    .build())
            .expectedClass(ArgumentList.class)
            .build()),;

    @Getter
    private final TestObject<ArgumentList> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
