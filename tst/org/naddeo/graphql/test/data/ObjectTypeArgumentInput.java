package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.ObjectType;
import org.naddeo.graphql.types.ObjectTypeArgument;
import org.naddeo.graphql.types.value.ValueFactory;
import org.naddeo.graphql.types.value.ValueFactoryTest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ObjectTypeArgumentInput implements TestData<ObjectTypeArgument>
{
    HAPPY_PATH(TestObject.<ObjectTypeArgument>builder()
            .parserInput("name: SomeType = \"DefaultValue\"")
            .expectedClass(ObjectTypeArgument.class)
            .pojoValue(ObjectTypeArgument.builder()
                    .name("name")
                    .type(ObjectType.builder()
                            .name("SomeType")
                            .nullable(true)
                            .list(false)
                            .build())
                    .defaultValue(new ValueFactory().of("DefaultValue"))
                    .build())
            .build()),

    NO_DEFAULT_VALUE(TestObject.<ObjectTypeArgument>builder()
            .parserInput("name :[SomeType]!")
            .expectedClass(ObjectTypeArgument.class)
            .pojoValue(ObjectTypeArgument.builder()
                    .name("name")
                    .type(ObjectType.builder()
                            .name("SomeType")
                            .nullable(false)
                            .list(true)
                            .build())
                    .build())
            .build()),;

    @Getter
    private final TestObject<ObjectTypeArgument> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
