package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import org.naddeo.graphql.types.container.ArgumentContainer;
import org.naddeo.graphql.types.container.FieldContainer;
import org.naddeo.graphql.types.container.SelectionContainer;

import java.util.stream.Stream;

@Data
@Builder
public class Fields implements FieldContainer, SelectionContainer, ArgumentContainer {

    @Singular @NonNull public final ImmutableSet<Field> fields;

    @Override
    public Stream<Field> fieldStream()
    {
        return this.fields.stream();
    }

    @Override
    public Stream<Argument> argumentStream()
    {
        return this.fields.stream().flatMap(Field::argumentStream);
    }

    @Override
    public Stream<Selection> selectionStream()
    {
        return this.fields.stream().flatMap(Field::selectionStream);
    }
}
