package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.Argument;
import org.naddeo.graphql.types.ArgumentList;
import org.naddeo.graphql.types.Directive;
import org.naddeo.graphql.types.DirectiveList;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

import static org.naddeo.graphql.BaseGrammarTest.VALUE_FACTORY;

@RequiredArgsConstructor
public enum DirectivesInput implements TestData<DirectiveList>{
    HAPPY_PATH(TestObject.<DirectiveList>builder()
            .parserInput("@include(if:true)")
            .pojoValue(DirectiveList.builder()
                    .directive(Directive.builder()
                            .name("include")
                            .arguments(ArgumentList.builder()
                                    .argument(Argument.builder()
                                            .name("if")
                                            .value(VALUE_FACTORY.of(true)).build()).build()).build()).build())
            .expectedClass(DirectiveList.class)
            .build()),

    NO_ARGS(TestObject.<DirectiveList>builder()
            .parserInput("@include")
            .pojoValue(DirectiveList.builder()
                    .directive(Directive.builder()
                            .name("include")
                            .build()).build())
            .expectedClass(DirectiveList.class)
            .build()),

    MULTIPLE_NO_ARGS(TestObject.<DirectiveList>builder()
            .parserInput("@include @other,  @another")
            .pojoValue(DirectiveList.builder()
                    .directive(Directive.builder().name("another").build())
                    .directive(Directive.builder().name("other").build())
                    .directive(Directive.builder().name("include").build())
                    .build())
            .expectedClass(DirectiveList.class)
            .build()),

    MULTIPLE_DIRECTIVES(TestObject.<DirectiveList>builder()
            .parserInput("@include(if:true) @customDirective (a:false, b:22.2 c:55)")
            .pojoValue(DirectiveList.builder()
                    .directive(Directive.builder()
                            .name("include")
                            .arguments(ArgumentList.builder()
                                    .argument(Argument.builder()
                                            .name("if")
                                            .value(VALUE_FACTORY.of(true)).build()).build()).build())
                    .directive(Directive.builder()
                            .name("customDirective")
                            .arguments(ArgumentList.builder()
                                    .argument(Argument.builder()
                                            .name("a")
                                            .value(VALUE_FACTORY.of(false)).build())
                                    .argument(Argument.builder()
                                            .name("b")
                                            .value(VALUE_FACTORY.of(22.2)).build())
                                    .argument(Argument.builder()
                                            .name("c")
                                            .value(VALUE_FACTORY.of(55)).build())
                                    .build()).build()).build())
            .expectedClass(DirectiveList.class)
            .build()),;


    @Getter
    private final TestObject<DirectiveList> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
