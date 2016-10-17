package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import static java.util.stream.Collectors.joining;

/**
 * This class represents a collection of {@link ObjectTypeField}s.
 */
@Value
@Builder
public class ObjectTypeFieldList implements GraphQLDisplayable
{
    public static final ObjectTypeFieldList EMPTY_FIELD_LIST = new ObjectTypeFieldList(null);

    @Singular
    private final ImmutableSet<ObjectTypeField> typeFields;

    public ObjectTypeFieldList(ImmutableSet<ObjectTypeField> typeFields)
    {
        this.typeFields = typeFields == null ? ImmutableSet.of() : typeFields;
    }

    @Override
    public String getDisplay()
    {
        return this.typeFields.stream().map(GraphQLDisplayable::getDisplay).collect(joining(", "));
    }
}
