package org.naddeo.graphql.types;

import org.naddeo.graphql.GraphQLDisplayable;

import lombok.Builder;
import lombok.Value;

/**
 * This class represents an entire object type definition of the following form:
 *
 * <pre>
 *     type Human implements Character {
 *         id: ID!
 *         name: String!
 *         friends: [Character]
 *         appearsIn: [Episode]!
 *         starships: [Starship]
 *         totalCredits: Int
 *     }
 * </pre>
 */
@Value
@Builder
public class ObjectTypeDefinition implements GraphQLDisplayable
{
    private final String name;
    private final String implementedInterface;
    private final ObjectTypeFieldList objectTypeFieldList;

    public ObjectTypeDefinition(String name, String implementedInterface, ObjectTypeFieldList objectTypeFieldList)
    {
        this.name = name;
        this.implementedInterface = implementedInterface;
        this.objectTypeFieldList = objectTypeFieldList == null ? ObjectTypeFieldList.EMPTY_FIELD_LIST : objectTypeFieldList;
    }

    @Override
    public String getDisplay()
    {
        StringBuilder sb = new StringBuilder("type ");
        sb.append(name);

        if (implementedInterface != null) {
            sb.append(" implements ");
            sb.append(implementedInterface);
        }

        if (!objectTypeFieldList.getTypeFields().isEmpty()) {
            sb.append(" { ");
            sb.append(objectTypeFieldList.getDisplay());
            sb.append(" }");
        }

        return sb.toString();
    }
}
