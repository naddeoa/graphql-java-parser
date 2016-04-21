package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.FragmentDefinition;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.definition.DocumentDefinitions;

@RequiredArgsConstructor
public enum FragmentSpreadInput implements TestData<FragmentSpread> {
    HAPPY_PATH(TestObject.<FragmentSpread>builder()
            .parserInput("... myFragment " + DirectivesInput.NO_ARGS.getTest().getParserInput())
            .expectedClass(FragmentSpread.class)
            .pojoValue(FragmentSpread.builder().name("myFragment").directives(DirectivesInput.NO_ARGS.getTest().getPojoValue()).build())
            .build()),
    COMPLEX(TestObject.<FragmentSpread>builder()
            .parserInput("... bigFragment " + DirectivesInput.MULTIPLE_DIRECTIVES.getTest().getParserInput())
            .expectedClass(FragmentSpread.class)
            .pojoValue(FragmentSpread.builder().name("bigFragment").directives(DirectivesInput.MULTIPLE_DIRECTIVES.getTest().getPojoValue()).build())
            .build()),
    ;

    @Getter
    private final TestObject<FragmentSpread> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
