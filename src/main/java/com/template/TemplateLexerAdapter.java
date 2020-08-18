package com.template;

import com.intellij.lexer.FlexAdapter;
import java.io.Reader;

public class TemplateLexerAdapter extends FlexAdapter {
    public TemplateLexerAdapter() {
        super(new TemplateLexer((Reader) null));
    }
}