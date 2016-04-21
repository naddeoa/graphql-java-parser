package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.naddeo.graphql.types.container.FieldContainer;
import org.naddeo.graphql.types.container.FragmentSpreadContainer;
import org.naddeo.graphql.types.container.InlineFragmentContainer;
import org.naddeo.graphql.types.container.SelectionContainer;

import java.util.stream.Stream;

@Data
@Builder
public class SelectionSet implements FieldContainer, FragmentSpreadContainer, InlineFragmentContainer, SelectionContainer {

    public static final SelectionSet EMPTY_SELECTION_SET = new SelectionSet(null);

    @Singular
    @NonNull
    private final ImmutableSet<Selection> selections;

    public SelectionSet(ImmutableSet<Selection> selections)
    {
        this.selections = selections == null ? ImmutableSet.of() : selections;
    }

    @Override
    public final Stream<Field> fieldStream()
    {
        return this.selections.stream()
                .filter(selection -> selection.getOf() instanceof Field)
                .map(Selection::getOf)
                .map(Field.class::cast);
    }

    @Override
    public final Stream<FragmentSpread> fragmentSpreadStream()
    {
        return this.selections.stream()
                .filter(selection -> selection.getOf() instanceof FragmentSpread)
                .map(Selection::getOf)
                .map(FragmentSpread.class::cast);
    }

    @Override
    public final Stream<InlineFragment> inlineFragmentStream()
    {
        return this.selections.stream()
                .filter(selection -> selection.getOf() instanceof InlineFragment)
                .map(Selection::getOf)
                .map(InlineFragment.class::cast);
    }

    @Override
    public Stream<Selection> selectionStream()
    {
        return this.selections.stream();
    }

}
