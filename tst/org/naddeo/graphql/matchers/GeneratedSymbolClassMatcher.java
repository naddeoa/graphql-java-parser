package org.naddeo.graphql.matchers;

import java_cup.runtime.Symbol;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author naddeo
 */
@RequiredArgsConstructor
public class GeneratedSymbolClassMatcher extends TypeSafeMatcher<Symbol> {

    private final Class cls;

    @Override
    protected boolean matchesSafely(Symbol symbol)
    {
        return symbol.value.getClass().equals(cls);
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText("Symbol should have returned a " + cls.toString());
    }

    @Override
    protected void describeMismatchSafely(Symbol symbol, Description mismatchDescription)
    {
        mismatchDescription.appendText(symbol.value.getClass().toString());
    }

    public static GeneratedSymbolClassMatcher returnsClass(Class cls)
    {
        return new GeneratedSymbolClassMatcher(cls);
    }

}
