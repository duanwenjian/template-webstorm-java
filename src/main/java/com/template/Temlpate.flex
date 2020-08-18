// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.template;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.template.psi.TemplateTypes;
import com.intellij.psi.TokenType;

%%

%class TemplateLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

// 空格
WHITE_SPACE=[\ \n\t\f]
// 空行
CRLF=\R
//注释
END_OF_LINE_COMMENT=("<--")[^\r\n]*("-->")
TEMPLATE_START=<%
MODIFIER=[^ \n\f\\(<%)(%>)].*[^ \n\f\\(<%)(%>)]
TEMPLATE_END=%>

SEPARATOR_START=[a-zA-Z]+
SEPARATOR=[:=]+
FIRST_MARK=[^ \n\f\\=]

NORMAL_LINE=[^(<%)(%>)].*

// template VARIABLE
TEMPLATE_VARIABLE=[^\n\t\f]*(("<%=") | ("<%:=") | ("<%")[a-zA-Z]+[:=])[^\r\n]*("%>")

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return TemplateTypes.COMMENT; }

//<YYINITIAL> {NORMAL_LINE}                          { yybegin(YYINITIAL); return TemplateTypes.NORMAL; }


<YYINITIAL> {TEMPLATE_START}                          { yybegin(YYINITIAL); return TemplateTypes.MARKSTART; }

{MODIFIER}                                     {return TemplateTypes.MODIFIER; }

{TEMPLATE_END}                          { return TemplateTypes.MARKEND; }

{SEPARATOR_START}                          { return TemplateTypes.SEPARATOR_START; }
{SEPARATOR}                          { return TemplateTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }


