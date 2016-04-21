package org.naddeo.graphql.matchers;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.naddeo.graphql.types.value.Value;
import org.naddeo.graphql.types.value.ValueType;

/**
 * @author naddeo
 */
public class ValueMatchers {

    public static IsA isA(Class cls)
    {
        return new IsA(cls);
    }

    @RequiredArgsConstructor
    public static class IsA extends TypeSafeMatcher<Value> {

        private final Class cls;

        @Override
        protected boolean matchesSafely(Value value)
        {
            return value.getClass().equals(cls);
        }

        @Override
        public void describeTo(Description description)
        {
            description.appendText("Value should be a " + cls.toString());
        }

        @Override
        protected void describeMismatchSafely(Value value, Description mismatchDescription)
        {
            mismatchDescription.appendText("is a " + value.getClass().toString());
        }
    }

    public static HasType hasType(ValueType type)
    {
        return new HasType(type);
    }

    @RequiredArgsConstructor
    public static class HasType extends TypeSafeMatcher<Value> {

        private final ValueType type;

        @Override
        protected boolean matchesSafely(Value value)
        {
            return value.getType().equals(type);
        }

        @Override
        public void describeTo(Description description)
        {
            description.appendText("Value should have grammar type " + type.toString());
        }

        @Override
        protected void describeMismatchSafely(Value value, Description mismatchDescription)
        {
            mismatchDescription.appendText("has grammar type " + value.getType().toString());
        }
    }
}
