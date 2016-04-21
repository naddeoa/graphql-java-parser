package org.naddeo.graphql.types.definition;

import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.naddeo.graphql.types.Directive;
import org.naddeo.graphql.types.Field;
import org.naddeo.graphql.types.FragmentDefinition;
import org.naddeo.graphql.types.FragmentSpread;
import org.naddeo.graphql.types.InlineFragment;
import org.naddeo.graphql.types.OperationDefinition;
import org.naddeo.graphql.types.VariableArgument;
import org.naddeo.graphql.types.container.DirectiveContainer;
import org.naddeo.graphql.types.container.FieldContainer;
import org.naddeo.graphql.types.container.FragmentDefinitionContainer;
import org.naddeo.graphql.types.container.FragmentSpreadContainer;
import org.naddeo.graphql.types.container.InlineFragmentContainer;
import org.naddeo.graphql.types.container.OperationDefinitionContainer;
import org.naddeo.graphql.types.container.VariableArgumentContainer;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

@Data
@Builder
public class DocumentDefinitions implements OperationDefinitionContainer, FragmentDefinitionContainer, FieldContainer, FragmentSpreadContainer, InlineFragmentContainer, DirectiveContainer, VariableArgumentContainer {

    @Singular
    @NonNull
    private final ImmutableSet<DocumentDefinition> definitions;

    public DocumentDefinitions(ImmutableSet<DocumentDefinition> definitions)
    {
        this.definitions = definitions == null ? ImmutableSet.of() : definitions;
    }

    @Override
    public final Stream<OperationDefinition> operationDefinitionStream()
    {
        return this.definitions.stream()
                .filter(def -> def.getDefinition() instanceof OperationDefinition)
                .map(DocumentDefinition::getDefinition)
                .map(OperationDefinition.class::cast);
    }

    @Override
    public final Stream<FragmentDefinition> fragmentDefinitionStream()
    {
        return this.definitions.stream()
                .filter(def -> def.getDefinition() instanceof FragmentDefinition)
                .map(DocumentDefinition::getDefinition)
                .map(FragmentDefinition.class::cast);
    }

    @Override
    public Stream<Directive> directiveStream()
    {
        return concat(this.operationDefinitionStream().flatMap(OperationDefinition::directiveStream),
                this.fragmentDefinitionStream().flatMap(FragmentDefinition::directiveStream));
    }

    @Override
    public Stream<Field> fieldStream()
    {
        return concat(this.operationDefinitionStream().flatMap(OperationDefinition::fieldStream),
            this.fragmentDefinitionStream().flatMap(FragmentDefinition::fieldStream));
    }

    @Override
    public Stream<FragmentSpread> fragmentSpreadStream()
    {
        return concat(this.operationDefinitionStream().flatMap(OperationDefinition::fragmentSpreadStream),
            this.fragmentDefinitionStream().flatMap(FragmentDefinition::fragmentSpreadStream));
    }

    @Override
    public Stream<InlineFragment> inlineFragmentStream()
    {
        return concat(this.operationDefinitionStream().flatMap(OperationDefinition::inlineFragmentStream),
                this.fragmentDefinitionStream().flatMap(FragmentDefinition::inlineFragmentStream));
    }

    @Override
    public Stream<VariableArgument> variableArgumentStream()
    {
        return this.operationDefinitionStream().flatMap(OperationDefinition::variableArgumentStream);
    }
}
