package org.naddeo.graphql.test.data;

import org.naddeo.graphql.schema.EnumType;
import org.naddeo.graphql.schema.EnumTypeEntries;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumTypeInput implements TestData<EnumType>
{
    HAPPY_PATH(TestObject.<EnumType>builder()
            .parserInput("enum LegionZones { AZSUNA HIGHMOUNTAIN VALSHARA STORMHEIM }")
            .expectedClass(EnumType.class)
            .pojoValue(EnumType.builder()
                    .name("LegionZones")
                    .entries(EnumTypeEntries.builder()
                            .entry("AZSUNA")
                            .entry("HIGHMOUNTAIN")
                            .entry("VALSHARA")
                            .entry("STORMHEIM")
                            .build())
                    .build())
            .build());

    @Getter
    private final TestObject<EnumType> test;

    @Override
    public String toString()
    {
        return testName();
    }
}
