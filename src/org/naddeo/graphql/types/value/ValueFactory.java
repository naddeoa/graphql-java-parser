package org.naddeo.graphql.types.value;

/**
 * @author naddeo
 */
public class ValueFactory {

    public StringValue of(String value){
        return new StringValue(value);
    }

    public IntegerValue of(Integer value){
        return new IntegerValue(value);
    }

    public FloatValue of(Double value){
        return new FloatValue(value);
    }

    public VariableValue ofVariable(String value){
        return new VariableValue(value);
    }

    public BooleanValue of(Boolean value){
        return new BooleanValue(value);
    }

    public ObjectValue ofObject(String value){
        return new ObjectValue(value);
    }
}
