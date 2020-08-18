package com.template.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.template.TemplateFileType;
import com.template.TemplateLanguage;
import org.jetbrains.annotations.NotNull;

public class TemplateFile extends PsiFileBase {
    public TemplateFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, TemplateLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TemplateFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Template File";
    }
}