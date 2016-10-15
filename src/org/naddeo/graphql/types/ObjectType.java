package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder
@Wither
public class ObjectType implements GraphQLDisplayable
{
    private static final String LIST_TEMPLATE = "[%s]";
    private static final String NON_NULL_TEMPLATE = "%s!";

    private final String name;
    private final Boolean nullable;
    private final Boolean list;

    @Override
    public String getDisplay()
    {
        String display = name;

        if(list){
            display = String.format(LIST_TEMPLATE, display);
        }

        if(!nullable){
            display = String.format(NON_NULL_TEMPLATE, display);
        }

        return display;
    }
}
