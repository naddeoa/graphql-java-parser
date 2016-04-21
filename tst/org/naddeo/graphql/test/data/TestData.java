package org.naddeo.graphql.test.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface TestData<PojoType> {

    TestObject<PojoType> getTest();

    String name();

    default String testName()
    {
        return name() + " " + getClass() + ": " + getTest().getParserInput();
    }

    static String joinQueries(TestObject ... data){
        return String.join(" ", Arrays.stream(data)
                .map(TestObject::getParserInput)
                .collect(Collectors.toList()));
    }

}
