package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.DirectiveList;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.InlineFragment;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

import static org.naddeo.graphql.test.data.TestData.joinQueries;

@RequiredArgsConstructor
public enum InlineFragmentInput implements TestData<InlineFragment> {
    HAPPY_PATH(TestObject.<InlineFragment>builder()
            .parserInput("... on Advertiser  " + joinQueries(DirectivesInput.HAPPY_PATH.getTest(), SelectionSetInput.HAPPY_PATH.getTest()))
            .expectedClass(InlineFragment.class)
            .pojoValue(InlineFragment.builder()
                    .typeName("Advertiser")
                    .directives(DirectivesInput.HAPPY_PATH.getTest().getPojoValue())
                    .selections(SelectionSetInput.HAPPY_PATH.getTest().getPojoValue())
                    .build())
            .build()),
    NO_DIRECTIVES(TestObject.<InlineFragment>builder()
            .parserInput("... on User " + SelectionSetInput.MULTIPLE_FIELDS.getTest().getParserInput())
            .expectedClass(InlineFragment.class)
            .pojoValue(InlineFragment.builder()
                    .typeName("User")
                    .directives(DirectiveList.EMPTY_DIRECTIVE_LIST)
                    .selections(SelectionSetInput.MULTIPLE_FIELDS.getTest().getPojoValue())
                    .build())
            .build()),;


    @Getter
    private final TestObject<InlineFragment> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
