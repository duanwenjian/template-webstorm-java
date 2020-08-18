package com.template;

import com.intellij.lang.Language;

public class TemplateLanguage extends Language {
    public static final TemplateLanguage INSTANCE = new TemplateLanguage();

    private TemplateLanguage() {
        super("Template");
    }
}
