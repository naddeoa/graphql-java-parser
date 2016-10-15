package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;

import static java.lang.String.join;

/**
 * Interface that represents all instances of types in the GraphQL system.
 * Since this is the parser object model, an instance of this interface represents
 * an instance of a type that was encountered during parsing, not necessarily the
 * definition of the type. For example, this is a type: "MyType". This is another
 * type: "MyType!". What consumers do with this object model is then up to them, but
 * they'll know exactly what was parsed, where it was parsed.
 *
 * This class also comes with a default implementation of {@link GraphQLDisplayable}.
 */
public interface GraphQLType extends GraphQLDisplayable
{
    /**
     * @return the name of the type instance
     */
    String getName();

    /**
     * @return whether this type instance is nullable
     */
    Boolean getNullable();

    /**
     * @return whether this type instance is a list
     */
    Boolean getList();

    /**
     * {@inheritDoc}
     */
    default String getDisplay()
    {
        String display = getName();

        if (this.getList() != null && this.getList()) {
            display = join("", "[", display, "]");
        }

        if (this.getNullable() == null || !this.getNullable()) {
            display = display + "!";
        }

        return display;
    }
}
