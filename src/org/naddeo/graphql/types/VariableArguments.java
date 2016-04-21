package org.naddeo.graphql.types;

import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.naddeo.graphql.types.container.VariableArgumentContainer;

import java.util.stream.Stream;

@Data
@Builder
public class VariableArguments implements VariableArgumentContainer {
    public static final VariableArguments EMPTY_VARIABLE_ARGUMENTS = new VariableArguments(null);

    @Singular private final ImmutableSet<VariableArgument> variableArguments;

    public VariableArguments(ImmutableSet<VariableArgument> variableArguments)
    {
        this.variableArguments = variableArguments == null ? ImmutableSet.of() : variableArguments;
    }

    @Override
    public Stream<VariableArgument> variableArgumentStream()
    {
        return this.variableArguments.stream();
    }
}
