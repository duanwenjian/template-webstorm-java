// This is a generated file. Not intended for manual editing.
package com.template.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.template.psi.impl.*;

public interface TemplateTypes {

  IElementType MARK = new TemplateElementType("MARK");
  IElementType MODIFIERITEMS = new TemplateElementType("MODIFIERITEMS");
  IElementType PROPERTY = new TemplateElementType("PROPERTY");
  IElementType TEMPLATE = new TemplateElementType("TEMPLATE");

  IElementType COMMENT = new TemplateTokenType("COMMENT");
  IElementType CRLF = new TemplateTokenType("CRLF");
  IElementType KEY = new TemplateTokenType("KEY");
  IElementType MARKEND = new TemplateTokenType("MARKEND");
  IElementType MARKSEND = new TemplateTokenType("MARKSEND");
  IElementType MARKSTART = new TemplateTokenType("MARKSTART");
  IElementType MODIFIER = new TemplateTokenType("MODIFIER");
  IElementType SEPARATOR = new TemplateTokenType("SEPARATOR");
  IElementType SEPARATOR_START = new TemplateTokenType("SEPARATOR_START");
  IElementType VALUE = new TemplateTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == MARK) {
        return new TemplateMarkImpl(node);
      }
      else if (type == MODIFIERITEMS) {
        return new TemplateModifieritemsImpl(node);
      }
      else if (type == PROPERTY) {
        return new TemplatePropertyImpl(node);
      }
      else if (type == TEMPLATE) {
        return new TemplateTemplateImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
