// This is a generated file. Not intended for manual editing.
package com.template.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.template.psi.TemplateTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TemplateParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return templateFile(b, l + 1);
  }

  /* ********************************************************** */
  // property|template|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = property(b, l + 1);
    if (!r) r = template(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // MARKSTART SEPARATOR_START? SEPARATOR MODIFIER MARKSEND
  public static boolean mark(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mark")) return false;
    if (!nextTokenIs(b, MARKSTART)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MARKSTART);
    r = r && mark_1(b, l + 1);
    r = r && consumeTokens(b, 0, SEPARATOR, MODIFIER, MARKSEND);
    exit_section_(b, m, MARK, r);
    return r;
  }

  // SEPARATOR_START?
  private static boolean mark_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mark_1")) return false;
    consumeToken(b, SEPARATOR_START);
    return true;
  }

  /* ********************************************************** */
  // SEPARATOR_START? SEPARATOR MODIFIER
  public static boolean modifieritems(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifieritems")) return false;
    if (!nextTokenIs(b, "<modifieritems>", SEPARATOR, SEPARATOR_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIERITEMS, "<modifieritems>");
    r = modifieritems_0(b, l + 1);
    r = r && consumeTokens(b, 0, SEPARATOR, MODIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEPARATOR_START?
  private static boolean modifieritems_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifieritems_0")) return false;
    consumeToken(b, SEPARATOR_START);
    return true;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, "<property>", KEY, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // MARKSTART modifieritems? MARKEND
  public static boolean template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template")) return false;
    if (!nextTokenIs(b, MARKSTART)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MARKSTART);
    r = r && template_1(b, l + 1);
    r = r && consumeToken(b, MARKEND);
    exit_section_(b, m, TEMPLATE, r);
    return r;
  }

  // modifieritems?
  private static boolean template_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_1")) return false;
    modifieritems(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // item_*
  static boolean templateFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "templateFile", c)) break;
    }
    return true;
  }

}
