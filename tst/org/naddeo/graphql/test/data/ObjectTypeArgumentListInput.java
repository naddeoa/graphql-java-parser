package org.naddeo.graphql.test.data;

import org.naddeo.graphql.types.ObjectType;
import org.naddeo.graphql.types.ObjectTypeArgument;
import org.naddeo.graphql.types.ObjectTypeArgumentList;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ObjectTypeArgumentListInput implements TestData<ObjectTypeArgumentList>
{
    HAPPY_PATH(TestObject.<ObjectTypeArgumentList>builder()
            .parserInput("units: LengthUnit = METER, currency: CurrencyUnit!")
            .expectedClass(ObjectTypeArgumentList.class)
            .pojoValue(ObjectTypeArgumentList.builder()
                    .argument(ObjectTypeArgument.builder()
                            .name("units")
                            .defaultValue("METER")
                            .type(ObjectType.builder()
                                    .name("LengthUnit")
                                    .list(false)
                                    .nullable(true)
                                    .build())
                            .build())
                    .argument(ObjectTypeArgument.builder()
                            .name("currency")
                            .defaultValue(null)
                            .type(ObjectType.builder()
                                    .name("CurrencyUnit")
                                    .list(false)
                                    .nullable(false)
                                    .build())
                            .build())
                    .build())
            .build()),

    LISTS_WITHOUT_COMMAS(TestObject.<ObjectTypeArgumentList>builder()
            .parserInput("units: [LengthUnit]  currency: [CurrencyUnit]!")
            .expectedClass(ObjectTypeArgumentList.class)
            .pojoValue(ObjectTypeArgumentList.builder()
                    .argument(ObjectTypeArgument.builder()
                            .name("units")
                            .defaultValue(null)
                            .type(ObjectType.builder()
                                    .name("LengthUnit")
                                    .list(true)
                                    .nullable(true)
                                    .build())
                            .build())
                    .argument(ObjectTypeArgument.builder()
                            .name("currency")
                            .defaultValue(null)
                            .type(ObjectType.builder()
                                    .name("CurrencyUnit")
                                    .list(true)
                                    .nullable(false)
                                    .build())
                            .build())
                    .build())
            .build()),;

    @Getter
    private final TestObject<ObjectTypeArgumentList> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
