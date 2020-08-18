// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.template;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TemplateFileType extends LanguageFileType {
    public static final TemplateFileType INSTANCE = new TemplateFileType();

    private TemplateFileType() {
        super(TemplateLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Template File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Template language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "tmpl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TemplateIcons.FILE;
    }
}
