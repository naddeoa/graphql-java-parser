package org.naddeo.graphql;

import java_cup.runtime.*;

%%

%class GraphQLDocumentLexer

%unicode
%cup
%line
%column

%{

	private Symbol symbol(int type){
		return symbol(type, yytext());
	}

	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}

%}

LineTerminator 	= \r|\n|\r\n
WhiteSpace    	= {LineTerminator} | [ \t\f]

INT_VALUE       = -?[0-9]+
FLOAT_VALUE     = {INT_VALUE}\.[0-9]*
STRING_VALUE    = \"[^\"\\\\]*\"
COMMENT         = #.*
NAME            = [_A-Za-z][_0-9A-Za-z]*

%%

<YYINITIAL> {

    {COMMENT}               {}
    ","                     {}

    // These are special debug tokens that allow us to start from different parts
    // of the grammer. This allows us to write more modular tests on subsets of the langauge.
    "**DBG_FIELDS"                  { return symbol(sym.DEBUG_FIELDS); }
    "**DBG_ARGUMENTS"               { return symbol(sym.DEBUG_ARGUMENTS); }
    "**DBG_VALUE"                   { return symbol(sym.DEBUG_VALUE); }
    "**DBG_DIRECTIVES"              { return symbol(sym.DEBUG_DIRECTIVES); }
    "**DBG_SELECTION_SET"           { return symbol(sym.DEBUG_SELECTION_SET); }
    "**DBG_FRAGMENT_SPREAD"         { return symbol(sym.DEBUG_FRAGMENT_SPREAD); }
    "**DBG_INLINE_FRAGMENT"         { return symbol(sym.DEBUG_INLINE_FRAGMENT); }
    "**DBG_VARIABLE_ARG"            { return symbol(sym.DEBUG_VARIABLE_ARG); }
    "**DBG_VARIABLE_DEFS"           { return symbol(sym.DEBUG_VARIABLE_DEFS); }
    "**DBG_OPERATION_DEF"           { return symbol(sym.DEBUG_OPERATION_DEF); }
    "**DBG_FRAGMENT_DEF"            { return symbol(sym.DEBUG_FRAGMENT_DEF); }
    "**DBG_DEFINITION"              { return symbol(sym.DEBUG_DEFINITION); }
    "**DBG_DOCUMENT"                { return symbol(sym.DEBUG_DOCUMENT); }
    "**DBG_SCHEMA"                  { return symbol(sym.DEBUG_SCHEMA); }
    "**DEBUG_ENUM_DEF"              { return symbol(sym.DEBUG_ENUM_DEF); }
    "**DEBUG_TYPE"                  { return symbol(sym.DEBUG_TYPE); }
    "**DEBUG_TYPE_ARGUMENT"         { return symbol(sym.DEBUG_TYPE_ARGUMENT); }
    "**DEBUG_TYPE_ARGUMENTS"        { return symbol(sym.DEBUG_TYPE_ARGUMENTS); }
    "**DEBUG_TYPE_FIELD"            { return symbol(sym.DEBUG_TYPE_FIELD); }

    "fragment"                      { return symbol(sym.FRAGMENT); }
    "query"                         { return symbol(sym.OPERATION_TYPE); }
    "mutation"                      { return symbol(sym.OPERATION_TYPE); }
    ":"                             { return symbol(sym.COLON); }
    "|"                             { return symbol(sym.BAR); }
    "!"                             { return symbol(sym.EXCLAMATION); }
    "..."                           { return symbol(sym.ELLIPSES); }
    "@"                             { return symbol(sym.AT); }
    "("                             { return symbol(sym.L_PAREN); }
    ")"                             { return symbol(sym.R_PAREN); }
    "="                             { return symbol(sym.EQUALS); }
    "{"                             { return symbol(sym.L_BRACKET); }
    "}"                             { return symbol(sym.R_BRACKET); }
    "["                             { return symbol(sym.L_SQUARE_BRACKET); }
    "]"                             { return symbol(sym.R_SQUARE_BRACKET); }
    "$"                             { return symbol(sym.DOLLAR); }
    "on"                            { return symbol(sym.ON); }
    "true"                          { return symbol(sym.BOOLEAN_VALUE, Boolean.parseBoolean(yytext())); }
    "false"                         { return symbol(sym.BOOLEAN_VALUE, Boolean.parseBoolean(yytext())); }
    "enum"                          { return symbol(sym.ENUM); }
    "type"                          { return symbol(sym.TYPE); }

    {NAME}                          { return symbol(sym.NAME); }
    {INT_VALUE}                     { return symbol(sym.INT_VALUE, Integer.parseInt(yytext())); }
    {FLOAT_VALUE}                   { return symbol(sym.FLOAT_VALUE, Double.parseDouble(yytext())); }
    {STRING_VALUE}                  { return symbol(sym.STRING_VALUE); }


    {WhiteSpace}                    {}
    [^]                             {}
}
