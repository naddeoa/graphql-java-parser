package org.naddeo.graphql;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ForcedStatement {
    FIELDS("**DBG_FIELDS", "fields"),
    VALUE("**DBG_VALUE", "value"),
    ARGUMENTS("**DBG_ARGUMENTS", "arguments"),
    DIRECTIVES("**DBG_DIRECTIVES", "directives"),
    SELECTION_SET("**DBG_SELECTION_SET", "selection_set"),
    FRAGMENT_SPREAD("**DBG_FRAGMENT_SPREAD", "fragment_spread"),
    INLINE_FRAGMENT("**DBG_INLINE_FRAGMENT", "inline_fragment"),
    VARIABLE_ARGUMENT("**DBG_VARIABLE_ARG", "variable_arg"),
    VARIABLE_DEFINITIONS("**DBG_VARIABLE_DEFS", "variable_defs"),
    OPERATION_DEFINITION("**DBG_OPERATION_DEF", "operation_def"),
    FRAGMENT_DEFINITION("**DBG_FRAGMENT_DEF", "fragment_def"),
    DEFINITION("**DBG_DEFINITION", "definition"),
    DOCUMENT("**DBG_DOCUMENT", "document"),
    ENUM_DEF("**DEBUG_ENUM_DEF", "enum_def"),
    TYPE("**DEBUG_TYPE", "type"),
    TYPE_ARGUMENT("**DEBUG_TYPE_ARGUMENT", "type_argument"),
    TYPE_ARGUMENTS("**DEBUG_TYPE_ARGUMENTS", "type_arguments"),
    TYPE_FIELD("**DEBUG_TYPE_FIELD", "type_field"),
    TYPE_FIELDS("**DEBUG_TYPE_FIELDS", "type_fields"),
    ;

    public final String token;
    public final String rule;

    public String create(String lang)
    {
        return this.token + " " + lang;
    }
}
