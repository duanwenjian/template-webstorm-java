// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.template;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Map;

public class TemplateColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Code", TemplateSyntaxHighlighter.CODE),
            new AttributesDescriptor("VARIABLE", TemplateSyntaxHighlighter.VARIABLE),
            new AttributesDescriptor("Separator", TemplateSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Bad Value", TemplateSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return TemplateIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new TemplateSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "<h2>我的待办</h2>\n" +
                "<ul>\n" +
                "    <%list.forEach(function(item, index) {%>\n" +
                "        <li>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-5 <%=index % 2 ? 'text-secondary' : ''%>\">\n" +
                "                    <%=item.text%>\n" +
                "                    <%:=item.text%>\n" +
                "                    <%abc:=item.text%>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "    <%})%>\n" +
                "</ul>\n" +
                "<a href=\"#\" class=\"btn btn-dark add-todo\">新增</a>";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Template";
    }
}
