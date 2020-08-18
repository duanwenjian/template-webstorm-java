package com.template;

import com.intellij.codeInsight.template.Template;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.template.psi.TemplateTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TemplateSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey MARK =
            createTextAttributesKey("Template_MARK", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey HTML_TAG =
            createTextAttributesKey("Template_HTML_TAG", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey CODE =
            createTextAttributesKey("Template_CODE", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    public static final TextAttributesKey VARIABLE =
            createTextAttributesKey("Template_VARIABLE", DefaultLanguageHighlighterColors.INTERFACE_NAME);

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("Template_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("Template_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("Template_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] MARK_KEYS = new TextAttributesKey[]{MARK};
    private static final TextAttributesKey[] HTML_TAG_KEYS = new TextAttributesKey[]{HTML_TAG};
    private static final TextAttributesKey[] VARIABLE_KEYS = new TextAttributesKey[]{VARIABLE};

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new TemplateLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if(tokenType.equals(TemplateTypes.MARKSTART)){
            return MARK_KEYS;
        } else if (tokenType.equals(TemplateTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else{
            return EMPTY_KEYS;
        }
    }
}
