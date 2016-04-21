package org.naddeo.graphql.matchers;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class StreamSizeMatcher extends TypeSafeMatcher<Stream>{

    private final long expectedSize;
    private final Class containsClass;

    private long cachedActualSize;

    @Override
    protected boolean matchesSafely(Stream stream)
    {
        return (cachedActualSize = stream.count()) == expectedSize;
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText("Expected " + expectedSize + " elements contained in stream of " + containsClass);
    }

    @Override
    protected void describeMismatchSafely(Stream item, Description mismatchDescription)
    {
        mismatchDescription.appendText("got " + cachedActualSize);
    }

    public static StreamSizeMatcher containsThisMany(long n, Class containsClass)
    {
        return new StreamSizeMatcher(n, containsClass);
    }
}
