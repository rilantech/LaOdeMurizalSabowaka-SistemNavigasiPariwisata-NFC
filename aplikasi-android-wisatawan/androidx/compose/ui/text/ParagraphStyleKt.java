package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001aq\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-HtYhynw", "(Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m6036getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle start, ParagraphStyle stop, float fraction) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(start.m5240getTextAlignbuA522U(), stop.m5240getTextAlignbuA522U(), fraction);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(start.m5242getTextDirectionmmuk1to(), stop.m5242getTextDirectionmmuk1to(), fraction);
        long r4 = SpanStyleKt.m5290lerpTextUnitInheritableC3pnCVY(start.m5239getLineHeightXSAIIZE(), stop.m5239getLineHeightXSAIIZE(), fraction);
        TextIndent textIndent = start.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = stop.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, r4, TextIndentKt.lerp(textIndent, textIndent2, fraction), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), fraction), (LineHeightStyle) SpanStyleKt.lerpDiscrete(start.getLineHeightStyle(), stop.getLineHeightStyle(), fraction), (LineBreak) SpanStyleKt.lerpDiscrete(start.m5237getLineBreakLgCVezo(), stop.m5237getLineBreakLgCVezo(), fraction), (Hyphens) SpanStyleKt.lerpDiscrete(start.m5235getHyphensEaSxIns(), stop.m5235getHyphensEaSxIns(), fraction), (TextMotion) SpanStyleKt.lerpDiscrete(start.getTextMotion(), stop.getTextMotion(), fraction), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle start, PlatformParagraphStyle stop, float fraction) {
        if (start == null && stop == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.lerp(start == null ? PlatformParagraphStyle.Companion.getDefault() : start, stop == null ? PlatformParagraphStyle.Companion.getDefault() : stop, fraction);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle style, LayoutDirection direction) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(direction, "direction");
        TextAlign r2 = TextAlign.m5700boximpl(style.m5241getTextAlignOrDefaulte0LSkKk$ui_text_release());
        TextDirection r3 = TextDirection.m5713boximpl(TextStyleKt.m5357resolveTextDirectionYj3eThk(direction, style.m5242getTextDirectionmmuk1to()));
        long r4 = TextUnitKt.m6043isUnspecifiedR2X_6o(style.m5239getLineHeightXSAIIZE()) ? DefaultLineHeight : style.m5239getLineHeightXSAIIZE();
        TextIndent textIndent = style.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = style.getPlatformStyle();
        LineHeightStyle lineHeightStyle = style.getLineHeightStyle();
        LineBreak r9 = LineBreak.m5628boximpl(style.m5238getLineBreakOrDefaultrAG3T2k$ui_text_release());
        Hyphens r10 = Hyphens.m5619boximpl(style.m5236getHyphensOrDefaultvmbZdU8$ui_text_release());
        TextMotion textMotion = style.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(r2, r3, r4, textIndent2, platformStyle, lineHeightStyle, r9, r10, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (androidx.compose.ui.unit.TextUnit.m6022equalsimpl0(r12, r26.m5239getLineHeightXSAIIZE()) != false) goto L_0x0043;
     */
    /* renamed from: fastMerge-HtYhynw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.ParagraphStyle m5243fastMergeHtYhynw(androidx.compose.ui.text.ParagraphStyle r26, androidx.compose.ui.text.style.TextAlign r27, androidx.compose.ui.text.style.TextDirection r28, long r29, androidx.compose.ui.text.style.TextIndent r31, androidx.compose.ui.text.PlatformParagraphStyle r32, androidx.compose.ui.text.style.LineHeightStyle r33, androidx.compose.ui.text.style.LineBreak r34, androidx.compose.ui.text.style.Hyphens r35, androidx.compose.ui.text.style.TextMotion r36) {
        /*
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r31
            r4 = r32
            r5 = r33
            r6 = r34
            r7 = r35
            r8 = r36
            java.lang.String r9 = "$this$fastMerge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            r9 = 1
            if (r1 == 0) goto L_0x0029
            androidx.compose.ui.text.style.TextAlign r10 = r26.m5240getTextAlignbuA522U()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            r12 = r29
            goto L_0x0097
        L_0x0029:
            r10 = r29
            r12 = 0
            boolean r13 = androidx.compose.ui.unit.TextUnitKt.m6043isUnspecifiedR2X_6o(r10)
            r10 = r13 ^ 1
            if (r10 == 0) goto L_0x0041
            long r10 = r26.m5239getLineHeightXSAIIZE()
            r12 = r29
            boolean r10 = androidx.compose.ui.unit.TextUnit.m6022equalsimpl0(r12, r10)
            if (r10 == 0) goto L_0x0097
            goto L_0x0043
        L_0x0041:
            r12 = r29
        L_0x0043:
            if (r3 == 0) goto L_0x004f
            androidx.compose.ui.text.style.TextIndent r10 = r26.getTextIndent()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0097
        L_0x004f:
            if (r2 == 0) goto L_0x005b
            androidx.compose.ui.text.style.TextDirection r10 = r26.m5242getTextDirectionmmuk1to()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0097
        L_0x005b:
            if (r4 == 0) goto L_0x0067
            androidx.compose.ui.text.PlatformParagraphStyle r10 = r26.getPlatformStyle()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0097
        L_0x0067:
            if (r5 == 0) goto L_0x0073
            androidx.compose.ui.text.style.LineHeightStyle r10 = r26.getLineHeightStyle()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0097
        L_0x0073:
            if (r6 == 0) goto L_0x007f
            androidx.compose.ui.text.style.LineBreak r10 = r26.m5237getLineBreakLgCVezo()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0097
        L_0x007f:
            if (r7 == 0) goto L_0x008b
            androidx.compose.ui.text.style.Hyphens r10 = r26.m5235getHyphensEaSxIns()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x0097
        L_0x008b:
            if (r8 == 0) goto L_0x0098
            androidx.compose.ui.text.style.TextMotion r10 = r26.getTextMotion()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r10 != 0) goto L_0x0098
        L_0x0097:
            goto L_0x0099
        L_0x0098:
            r9 = 0
        L_0x0099:
            if (r9 != 0) goto L_0x009d
            return r0
        L_0x009d:
            boolean r10 = androidx.compose.ui.unit.TextUnitKt.m6043isUnspecifiedR2X_6o(r29)
            if (r10 == 0) goto L_0x00aa
            long r10 = r26.m5239getLineHeightXSAIIZE()
            r17 = r10
            goto L_0x00ac
        L_0x00aa:
            r17 = r12
        L_0x00ac:
            if (r3 != 0) goto L_0x00b6
            androidx.compose.ui.text.style.TextIndent r10 = r26.getTextIndent()
            r19 = r10
            goto L_0x00b8
        L_0x00b6:
            r19 = r3
        L_0x00b8:
            if (r1 != 0) goto L_0x00c0
            androidx.compose.ui.text.style.TextAlign r10 = r26.m5240getTextAlignbuA522U()
            r15 = r10
            goto L_0x00c1
        L_0x00c0:
            r15 = r1
        L_0x00c1:
            if (r2 != 0) goto L_0x00ca
            androidx.compose.ui.text.style.TextDirection r10 = r26.m5242getTextDirectionmmuk1to()
            r16 = r10
            goto L_0x00cc
        L_0x00ca:
            r16 = r2
        L_0x00cc:
            androidx.compose.ui.text.PlatformParagraphStyle r20 = mergePlatformStyle(r0, r4)
            if (r5 != 0) goto L_0x00d9
            androidx.compose.ui.text.style.LineHeightStyle r10 = r26.getLineHeightStyle()
            r21 = r10
            goto L_0x00db
        L_0x00d9:
            r21 = r5
        L_0x00db:
            if (r6 != 0) goto L_0x00e4
            androidx.compose.ui.text.style.LineBreak r10 = r26.m5237getLineBreakLgCVezo()
            r22 = r10
            goto L_0x00e6
        L_0x00e4:
            r22 = r6
        L_0x00e6:
            if (r7 != 0) goto L_0x00ef
            androidx.compose.ui.text.style.Hyphens r10 = r26.m5235getHyphensEaSxIns()
            r23 = r10
            goto L_0x00f1
        L_0x00ef:
            r23 = r7
        L_0x00f1:
            if (r8 != 0) goto L_0x00fa
            androidx.compose.ui.text.style.TextMotion r10 = r26.getTextMotion()
            r24 = r10
            goto L_0x00fc
        L_0x00fa:
            r24 = r8
        L_0x00fc:
            androidx.compose.ui.text.ParagraphStyle r10 = new androidx.compose.ui.text.ParagraphStyle
            r25 = 0
            r14 = r10
            r14.<init>((androidx.compose.ui.text.style.TextAlign) r15, (androidx.compose.ui.text.style.TextDirection) r16, (long) r17, (androidx.compose.ui.text.style.TextIndent) r19, (androidx.compose.ui.text.PlatformParagraphStyle) r20, (androidx.compose.ui.text.style.LineHeightStyle) r21, (androidx.compose.ui.text.style.LineBreak) r22, (androidx.compose.ui.text.style.Hyphens) r23, (androidx.compose.ui.text.style.TextMotion) r24, (kotlin.jvm.internal.DefaultConstructorMarker) r25)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyleKt.m5243fastMergeHtYhynw(androidx.compose.ui.text.ParagraphStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion):androidx.compose.ui.text.ParagraphStyle");
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle $this$mergePlatformStyle, PlatformParagraphStyle other) {
        if ($this$mergePlatformStyle.getPlatformStyle() == null) {
            return other;
        }
        if (other == null) {
            return $this$mergePlatformStyle.getPlatformStyle();
        }
        return $this$mergePlatformStyle.getPlatformStyle().merge(other);
    }
}
