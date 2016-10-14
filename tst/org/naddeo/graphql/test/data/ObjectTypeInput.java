package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.ObjectType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ObjectTypeInput implements TestData<ObjectType>
{
    HAPPY_PATH(TestObject.<ObjectType>builder()
            .parserInput("Human")
            .expectedClass(ObjectType.class)
            .pojoValue(ObjectType.builder()
                    .name("Human")
                    .list(false)
                    .nullable(true)
                    .build())
            .build()),

    NULLABLE(TestObject.<ObjectType>builder()
            .parserInput("Human!")
            .expectedClass(ObjectType.class)
            .pojoValue(ObjectType.builder()
                    .name("Human")
                    .list(false)
                    .nullable(false)
                    .build())
            .build()),

    LIST(TestObject.<ObjectType>builder()
            .parserInput("[ Human ]")
            .expectedClass(ObjectType.class)
            .pojoValue(ObjectType.builder()
                    .name("Human")
                    .list(true)
                    .nullable(true)
                    .build())
            .build()),

    NULLABLE_LIST(TestObject.<ObjectType>builder()
            .parserInput("[ Human ]!")
            .expectedClass(ObjectType.class)
            .pojoValue(ObjectType.builder()
                    .name("Human")
                    .list(true)
                    .nullable(false)
                    .build())
            .build());

    @Getter
    private final TestObject<ObjectType> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
