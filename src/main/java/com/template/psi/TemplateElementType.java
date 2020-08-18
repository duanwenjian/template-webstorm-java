package com.template.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import com.template.TemplateLanguage;


public class TemplateElementType extends IElementType {
    public TemplateElementType( @NotNull @NonNls String debugName) {
        super(debugName, TemplateLanguage.INSTANCE);
    }
}
