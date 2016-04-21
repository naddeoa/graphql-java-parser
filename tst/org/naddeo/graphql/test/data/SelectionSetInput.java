package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.Field;
import org.naddeo.graphql.types.InlineFragment;
import org.naddeo.graphql.types.Selection;
import org.naddeo.graphql.types.SelectionSet;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.naddeo.graphql.test.data.TestData.joinQueries;

@RequiredArgsConstructor
public enum SelectionSetInput implements TestData<SelectionSet> {
    HAPPY_PATH(TestObject.<SelectionSet>builder()
            .parserInput("" +
                    "{" +
                    "   advertiserId" +
                    "   name" +
                    "   externalId" +
                    "}")
            .expectedClass(SelectionSet.class)
            .pojoValue(SelectionSet.builder()
                    .selection(Selection.builder().of(Field.builder().name("advertiserId").build()).build())
                    .selection(Selection.builder().of(Field.builder().name("name").build()).build())
                    .selection(Selection.builder().of(Field.builder().name("externalId").build()).build())
                    .build())
            .build()),
    SINGLE(TestObject.<SelectionSet>builder()
            .parserInput("{name}")
            .expectedClass(SelectionSet.class)
            .pojoValue(SelectionSet.builder()
                    .selection(Selection.builder().of(Field.builder().name("name").build()).build())
                    .build())
            .build()),

    MULTIPLE_FIELDS(TestObject.<SelectionSet>builder()
            .parserInput("{" +
                    TestData.joinQueries(
                            FieldInput.ALIAS_NAME.getTest(),
                            FieldInput.NAME_ARGUMENTS.getTest(),
                            FieldInput.ALIAS_NAME_ARGUMENTS_DIRECTIVE.getTest()) +
                    "}")
            .expectedClass(SelectionSet.class)
            .pojoValue(SelectionSet.builder()
                    .selections(selectionOf(FieldInput.ALIAS_NAME))
                    .selections(selectionOf(FieldInput.NAME_ARGUMENTS))
                    .selections(selectionOf(FieldInput.ALIAS_NAME_ARGUMENTS_DIRECTIVE))
                    .build())
            .build()),

    WITH_FRAGMENT_SPREAD(TestObject.<SelectionSet>builder()
            .parserInput("{" +
                    TestData.joinQueries(FieldInput.HAPPY_PATH.getTest(), FragmentSpreadInput.HAPPY_PATH.getTest()) +
                    "}")
            .expectedClass(SelectionSet.class)
            .pojoValue(SelectionSet.builder()
                    .selections(selectionOf(FieldInput.HAPPY_PATH))
                    .selection(Selection.builder().of(FragmentSpreadInput.HAPPY_PATH.getTest().getPojoValue()).build())
                    .build())
            .build()),

    WITH_INLINE_FRAGMENT(TestObject.<SelectionSet>builder()
            .parserInput("{" +
                    joinQueries(FieldInput.HAPPY_PATH.getTest()) +
                    "... on Advertiser  " + joinQueries(DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()) + // Can't use InlineFragmentInput here, circular enum dependency
                    "}")
            .expectedClass(SelectionSet.class)
            .pojoValue(SelectionSet.builder()
                    .selections(selectionOf(FieldInput.HAPPY_PATH))
                    .selection(Selection.builder().of(InlineFragment.builder()
                            .typeName("Advertiser")
                            .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                            .selections(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                            .build()).build())
                    .build())
            .build()),

    WITH_ALL_TYPES(TestObject.<SelectionSet>builder()
            .parserInput("{" +
                    joinQueries(FieldInput.ALIAS_NAME_ARGUMENTS_DIRECTIVE.getTest(), FragmentSpreadInput.COMPLEX.getTest()) +
                    "... on Advertiser  " + joinQueries(DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()) + // Can't use InlineFragmentInput here, circular enum dependency
                    "}")
            .expectedClass(SelectionSet.class)
            .pojoValue(SelectionSet.builder()
                    .selections(selectionOf(FieldInput.ALIAS_NAME_ARGUMENTS_DIRECTIVE))
                    .selection(Selection.builder().of(FragmentSpreadInput.COMPLEX.getTest().getPojoValue()).build())
                    .selection(Selection.builder().of(InlineFragment.builder()
                            .typeName("Advertiser")
                            .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                            .selections(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                            .build()).build())
                    .build())
            .build()),;


    @Getter
    private final TestObject<SelectionSet> test;

    static Collection<Selection> selectionOf(FieldInput fields)
    {
        return fields
                .getTest()
                .getPojoValue()
                .getFields()
                .stream()
                .map(field -> Selection.builder().of(field).build())
                .collect(Collectors.toList());
    }

    @Override
    public String toString()
    {
        return testName();
    }
}
