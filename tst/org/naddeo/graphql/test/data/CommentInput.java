package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.BaseGrammarTest;
import org.naddeo.graphql.types.ArgumentList;
import org.naddeo.graphql.types.definition.DocumentDefinitions;
import org.naddeo.graphql.types.value.IntegerValue;
import org.naddeo.graphql.types.value.Value;

@RequiredArgsConstructor
public enum CommentInput implements TestData<Value> {
    HAPPY_PATH(TestObject.<Value>builder()
            .parserInput("22 # This should be ignored")
            .expectedClass(IntegerValue.class)
            .pojoValue(BaseGrammarTest.VALUE_FACTORY.of(22))
            .build());

    @Getter
    private final TestObject<Value> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
