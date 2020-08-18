// This is a generated file. Not intended for manual editing.
package com.template.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.template.psi.TemplateTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.template.psi.*;

public class TemplateTemplateImpl extends ASTWrapperPsiElement implements TemplateTemplate {

  public TemplateTemplateImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TemplateVisitor visitor) {
    visitor.visitTemplate(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TemplateVisitor) accept((TemplateVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TemplateModifieritems getModifieritems() {
    return findChildByClass(TemplateModifieritems.class);
  }

}
