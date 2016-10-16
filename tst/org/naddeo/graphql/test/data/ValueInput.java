package org.naddeo.graphql.test.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.definition.DocumentDefinitions;
import org.naddeo.graphql.types.value.BooleanValue;
import org.naddeo.graphql.types.value.FloatValue;
import org.naddeo.graphql.types.value.IntegerValue;
import org.naddeo.graphql.types.value.ObjectValue;
import org.naddeo.graphql.types.value.StringValue;
import org.naddeo.graphql.types.value.Value;
import org.naddeo.graphql.types.value.VariableValue;

import static org.naddeo.graphql.BaseGrammarTest.VALUE_FACTORY;

@RequiredArgsConstructor
public enum ValueInput implements TestData<Value> {
    STRING_VALUE(TestObject.<Value>builder()
            .parserInput("\"string value\"")
            .expectedClass(StringValue.class)
            .pojoValue(VALUE_FACTORY.of("string value"))
            .build()),

    FLOAT_VALUE(TestObject.<Value>builder()
            .parserInput("55.52")
            .pojoValue(VALUE_FACTORY.of(55.52))
            .expectedClass(FloatValue.class)
            .build()),

    INTEGER_VALUE(TestObject.<Value>builder()
            .parserInput("100")
            .pojoValue(VALUE_FACTORY.of(100))
            .expectedClass(IntegerValue.class)
            .build()),

    VARIABLE_VALUE(TestObject.<Value>builder()
            .parserInput("$varName")
            .pojoValue(VALUE_FACTORY.ofVariable("varName"))
            .expectedClass(VariableValue.class)
            .build()),

    OBJECT_VALUE(TestObject.<Value>builder()
            .parserInput("Object")
            .pojoValue(VALUE_FACTORY.ofObject("Object"))
            .expectedClass(ObjectValue.class)
            .build()),

    BOOLEAN_VALUE(TestObject.<Value>builder()
            .parserInput("true")
            .pojoValue(VALUE_FACTORY.of(true))
            .expectedClass(BooleanValue.class)
            .build());

    @Getter
    private final TestObject<Value> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
