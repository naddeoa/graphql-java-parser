package org.naddeo.graphql;

import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)
    {
        GraphQLDocumentParser p = new GraphQLDocumentParser(new GraphQLDocumentLexer(new InputStreamReader(System.in)));
        try {
            System.out.println(p.parse().value);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
