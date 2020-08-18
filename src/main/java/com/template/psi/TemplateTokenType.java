package com.template.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.*;
import com.template.TemplateLanguage;

public class TemplateTokenType extends IElementType {
    public TemplateTokenType(@NotNull @NonNls String debugName) {
        super(debugName, TemplateLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "TemplateTokenType." + super.toString();
    }
}

