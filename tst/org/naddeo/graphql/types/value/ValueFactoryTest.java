package org.naddeo.graphql.types.value;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.naddeo.graphql.matchers.ValueMatchers.hasType;
import static org.naddeo.graphql.matchers.ValueMatchers.isA;

public class ValueFactoryTest {

    ValueFactory instance;

    @Before
    public void init()
    {
        instance = new ValueFactory();
    }

    @Test
    public void test_floatValue()
    {
        Value value = instance.of(44.3);
        assertThat(value, isA(FloatValue.class));
        assertThat(value, hasType(ValueType.FLOAT));
        assertThat(value.getValue(), is(not(nullValue())));
        assertThat(value, equalTo(new FloatValue(44.3)));
    }

    @Test
    public void test_intValue()
    {
        Value value = instance.of(44);
        assertThat(value, isA(IntegerValue.class));
        assertThat(value, hasType(ValueType.INTEGER));
        assertThat(value.getValue(), is(not(nullValue())));
        assertThat(value, equalTo(new IntegerValue(44)));
    }

    @Test
    public void test_stringValue()
    {
        Value value = instance.of("string");
        assertThat(value, isA(StringValue.class));
        assertThat(value, hasType(ValueType.STRING));
        assertThat(value.getValue(), is(not(nullValue())));
        assertThat(value, equalTo(new StringValue("string")));
    }

    @Test
    public void test_booleanValue()
    {
        Value value = instance.of(true);
        assertThat(value, isA(BooleanValue.class));
        assertThat(value, hasType(ValueType.BOOLEAN));
        assertThat(value.getValue(), is(not(nullValue())));
        assertThat(value, equalTo(new BooleanValue(true)));
    }

    @Test
    public void test_variableValue()
    {
        Value value = instance.ofVariable("varName");
        assertThat(value, isA(VariableValue.class));
        assertThat(value, hasType(ValueType.VARIABLE));
        assertThat(value.getValue(), is(not(nullValue())));
        assertThat(value, equalTo(new VariableValue("varName")));
    }

    @Test
    public void test_stringValuetoString()
    {
        Value value = instance.of("string");
        assertThat(value.toString(), equalTo("STRING:\"string\""));
    }

    @Test
    public void test_toString()
    {
        Value value = instance.of(false);
        assertThat(value.toString(), equalTo("BOOLEAN:false"));
    }

    @Test(expected = NullPointerException.class)
    public void test_rejectNullString()
    {
        String nullValue = null;
        instance.of(nullValue);
    }

    @Test(expected = NullPointerException.class)
    public void test_rejectNullFloat()
    {
        Double nullValue = null;
        instance.of(nullValue);
    }

    @Test(expected = NullPointerException.class)
    public void test_rejectNullVariable()
    {
        String nullValue = null;
        instance.ofVariable(nullValue);
    }

    @Test(expected = NullPointerException.class)
    public void test_rejectNullBoolean()
    {
        Boolean nullValue = null;
        instance.of(nullValue);
    }

    @Test(expected = NullPointerException.class)
    public void test_rejectNullInteger()
    {
        Integer nullValue = null;
        instance.of(nullValue);
    }
}