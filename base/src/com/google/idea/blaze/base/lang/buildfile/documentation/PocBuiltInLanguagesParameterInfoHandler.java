package com.google.idea.blaze.base.lang.buildfile.documentation;

import com.google.common.collect.ImmutableMap;
import com.google.idea.blaze.base.lang.buildfile.language.semantics.AttributeDefinition;
import com.google.idea.blaze.base.lang.buildfile.language.semantics.BuildLanguageSpec;
import com.google.idea.blaze.base.lang.buildfile.language.semantics.BuildLanguageSpecProvider;
import com.google.idea.blaze.base.lang.buildfile.language.semantics.RuleDefinition;
import com.google.idea.blaze.base.lang.buildfile.psi.ArgumentList;
import com.google.idea.blaze.base.lang.buildfile.psi.FuncallExpression;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.parameterInfo.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Collectors;

public class PocBuiltInLanguagesParameterInfoHandler implements ParameterInfoHandler<FuncallExpression, PocBuiltInLanguagesParameterInfoHandler.CallInfo> {

    @Override
    public boolean couldShowInLookup() {
        return false;
    }

    @Nullable
    @Override
    public Object[] getParametersForLookup(LookupElement item, ParameterInfoContext context) {
        return new Object[0];
    }

    @Nullable
    @Override
    public FuncallExpression findElementForParameterInfo(@NotNull CreateParameterInfoContext ctx) {
        PsiFile file = ctx.getFile();
        PsiElement token = file.findElementAt(ctx.getOffset());

        FuncallExpression funcall = PsiTreeUtil.getParentOfType(token, FuncallExpression.class, true);
        ArgumentList asd = PsiTreeUtil.getParentOfType(token, ArgumentList.class, true);

        BuildLanguageSpec spec = BuildLanguageSpecProvider.getInstance().getLanguageSpec(ctx.getProject());

        RuleDefinition rule = spec.getRule(funcall.getFunctionName());

        CallInfo[] info = new CallInfo[1];
        info[0] = new CallInfo(rule.getAttributes());
        ctx.setItemsToShow(info);

        return funcall;
    }

    @Override
    public void showParameterInfo(@NotNull FuncallExpression element, @NotNull CreateParameterInfoContext ctx) {
        ctx.showHint(element, element.getTextRange().getStartOffset(), this);
    }

    @Nullable
    @Override
    public FuncallExpression findElementForUpdatingParameterInfo(@NotNull UpdateParameterInfoContext ctx) {
        PsiFile file = ctx.getFile();
        PsiElement token = file.findElementAt(ctx.getOffset());

        FuncallExpression funcall = PsiTreeUtil.getParentOfType(token, FuncallExpression.class, true);
        return funcall;
    }

    @Override
    public void updateParameterInfo(@NotNull FuncallExpression funcallExpression, @NotNull UpdateParameterInfoContext ctx) {
//        BuildLanguageSpec spec = BuildLanguageSpecProvider.getInstance().getLanguageSpec(ctx.getProject());
//        RuleDefinition rule = spec.getRule(funcallExpression.getFunctionName());
//
        System.out.println("TODO");
    }

    @Override
    public void updateUI(CallInfo p, @NotNull ParameterInfoUIContext ctx) {
        String text = p.attrs
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + toParameterDescription(entry.getValue()))
                .collect(Collectors.joining(", "));
        ctx.setupUIComponentPresentation(text, 0, 13, false, false, false, ctx.getDefaultParameterColor());
    }

    class CallInfo {
        public final ImmutableMap<String, AttributeDefinition> attrs;

        CallInfo(ImmutableMap<String, AttributeDefinition> attrs) {
            this.attrs = attrs;
        }
    }

    private static String toParameterDescription(AttributeDefinition attr) {
        String isRequiredString = attr.isMandatory() ? "REQUIRED" : "OPTIONAL";
        return attr.getType().toString().toLowerCase() + " [" + isRequiredString + "]";
    }

}
