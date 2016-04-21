package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.Argument;
import org.naddeo.graphql.types.ArgumentList;
import org.naddeo.graphql.types.Directive;
import org.naddeo.graphql.types.DirectiveList;
import org.naddeo.graphql.types.Field;
import org.naddeo.graphql.types.Fields;
import org.naddeo.graphql.types.Selection;

import static org.naddeo.graphql.BaseGrammarTest.VALUE_FACTORY;
import static org.naddeo.graphql.test.data.TestData.joinQueries;

@RequiredArgsConstructor
public enum FieldInput implements TestData<Fields> {
    HAPPY_PATH(TestObject.<Fields>builder()
            .parserInput("advertiserId : adCfid (id : 2)")
            .pojoValue(Fields.builder().field(Field.builder()
                    .alias("advertiserId")
                    .name("adCfid")
                    .arguments(ArgumentList.builder()
                            .argument(Argument.builder()
                                    .name("id")
                                    .value(VALUE_FACTORY.of(2)).build()).build()).build()).build())
            .expectedClass(Fields.class)
            .streamSize(new StreamSizeData<>(Fields::fieldStream, 1l, Field.class))
            .streamSize(new StreamSizeData<>(Fields::argumentStream, 1l, Argument.class))
            .streamSize(new StreamSizeData<>(Fields::selectionStream, 0l, Selection.class))
            .build()),

    ALIAS_NAME(TestObject.<Fields>builder()
            .parserInput("advertiserId : adCfid")
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder()
                    .field(Field.builder()
                            .alias("advertiserId")
                            .name("adCfid").build()).build())
            .streamSize(new StreamSizeData<>(Fields::fieldStream, 1l, Field.class))
            .streamSize(new StreamSizeData<>(Fields::argumentStream, 0l, Argument.class))
            .streamSize(new StreamSizeData<>(Fields::selectionStream, 0l, Selection.class))
            .build()),

    NAME(TestObject.<Fields>builder()
            .parserInput("advertiserId")
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder().field(Field.builder().name("advertiserId").build()).build())
            .build()),

    NAME_ARGUMENTS(TestObject.<Fields>builder()
            .parserInput("advertiserId(id:\"string\")")
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder().field(Field.builder()
                    .name("advertiserId")
                    .arguments(ArgumentList.builder()
                            .argument(Argument.builder()
                                    .name("id")
                                    .value(VALUE_FACTORY.of("string")).build()).build()).build()).build())
            .build()),

    NAME_DIRECTIVE(TestObject.<Fields>builder()
            .parserInput("advertiserId @include(if:true)")
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder().field(Field.builder()
                    .name("advertiserId")
                    .directives(DirectiveList.builder()
                            .directive(Directive.builder()
                                    .name("include")
                                    .arguments(ArgumentList.builder()
                                            .argument(Argument.builder()
                                                    .name("if")
                                                    .value(VALUE_FACTORY.of(true)).build()).build()).build()).build()).build()).build())
            .build()),

    ALIAS_NAME_DIRECTIVES(TestObject.<Fields>builder()
            .parserInput("alias : advertiserId @include(if:true)")
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder().field(Field.builder()
                    .alias("alias")
                    .name("advertiserId")
                    .directives(DirectiveList.builder()
                            .directive(Directive.builder()
                                    .name("include")
                                    .arguments(ArgumentList.builder()
                                            .argument(Argument.builder()
                                                    .name("if")
                                                    .value(VALUE_FACTORY.of(true)).build()).build()).build()).build()).build()).build())
            .build()),

    ALIAS_NAME_ARGUMENTS_DIRECTIVE(TestObject.<Fields>builder()
            .parserInput("alias : advertiserId(id:2 name:\"jim\") @include(if:true)")
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder().field(Field.builder()
                    .alias("alias")
                    .name("advertiserId")
                    .arguments(ArgumentList.builder()
                            .argument(Argument.builder().name("id").value(VALUE_FACTORY.of(2)).build())
                            .argument(Argument.builder().name("name").value(VALUE_FACTORY.of("jim")).build())
                            .build())
                    .directives(DirectiveList.builder()
                            .directive(Directive.builder()
                                    .name("include")
                                    .arguments(ArgumentList.builder()
                                            .argument(Argument.builder()
                                                    .name("if")
                                                    .value(VALUE_FACTORY.of(true)).build()).build()).build()).build()).build()).build())
            .build()),

    MULTIPLE_FIELDS(TestObject.<Fields>builder()
            .parserInput(joinQueries(NAME.test, ALIAS_NAME_DIRECTIVES.test, ALIAS_NAME_ARGUMENTS_DIRECTIVE.test))
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder()
                    .fields(NAME.test.getPojoValue().getFields())
                    .fields(ALIAS_NAME_DIRECTIVES.test.getPojoValue().getFields())
                    .fields(ALIAS_NAME_ARGUMENTS_DIRECTIVE.test.getPojoValue().getFields())
                    .build())
            .build()),

    WITH_SELECTION_SET(TestObject.<Fields>builder()
            .parserInput("advertiserId : adCfid (id : 2)" + SelectionSetInput.HAPPY_PATH.getTest().getParserInput())
            .expectedClass(Fields.class)
            .pojoValue(Fields.builder().field(Field.builder()
                    .alias("advertiserId")
                    .name("adCfid")
                    .selections(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .arguments(ArgumentList.builder()
                            .argument(Argument.builder()
                                    .name("id")
                                    .value(VALUE_FACTORY.of(2)).build()).build()).build()).build())
            .build());

    @Getter
    private final TestObject<Fields> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
