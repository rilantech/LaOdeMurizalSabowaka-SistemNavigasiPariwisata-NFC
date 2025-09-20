package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a-\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001aÃ\u0001\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u00107\u001a\u0004\u0018\u000108H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0018\u0010;\u001a\u0004\u0018\u00010\u0013*\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpanStyle.kt */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor = Color.Companion.m4998getTransparent0d7_KjU();
    /* access modifiers changed from: private */
    public static final long DefaultColor = Color.Companion.m4989getBlack0d7_KjU();
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m7000lerpTextUnitInheritableC3pnCVY(long a, long b, float t) {
        if (TextUnitKt.m7753isUnspecifiedR2X_6o(a) || TextUnitKt.m7753isUnspecifiedR2X_6o(b)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m7725boximpl(a), TextUnit.m7725boximpl(b), t)).m7744unboximpl();
        }
        return TextUnitKt.m7755lerpC3pnCVY(a, b, t);
    }

    public static final <T> T lerpDiscrete(T a, T b, float fraction) {
        return ((double) fraction) < 0.5d ? a : b;
    }

    public static final SpanStyle lerp(SpanStyle start, SpanStyle stop, float fraction) {
        float f = fraction;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(start.getTextForegroundStyle$ui_text_release(), stop.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(start.getFontFamily(), stop.getFontFamily(), f);
        long r7 = m7000lerpTextUnitInheritableC3pnCVY(start.m6995getFontSizeXSAIIZE(), stop.m6995getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = start.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = stop.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(start.m6996getFontStyle4Lr2A7w(), stop.m6996getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(start.m6997getFontSynthesisZQGJjVo(), stop.m6997getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(start.getFontFeatureSettings(), stop.getFontFeatureSettings(), f);
        long r14 = m7000lerpTextUnitInheritableC3pnCVY(start.m6998getLetterSpacingXSAIIZE(), stop.m6998getLetterSpacingXSAIIZE(), f);
        BaselineShift r1 = start.m6993getBaselineShift5SSeXJ0();
        float r12 = r1 != null ? r1.m7315unboximpl() : BaselineShift.m7310constructorimpl(0.0f);
        BaselineShift r5 = stop.m6993getBaselineShift5SSeXJ0();
        float r13 = BaselineShiftKt.m7322lerpjWV1Mfo(r12, r5 != null ? r5.m7315unboximpl() : BaselineShift.m7310constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = start.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = stop.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(start.getLocaleList(), stop.getLocaleList(), f);
        long r19 = ColorKt.m5014lerpjxsXWHM(start.m6992getBackground0d7_KjU(), stop.m6992getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(start.getTextDecoration(), stop.getTextDecoration(), f);
        Shadow shadow = start.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        Shadow shadow2 = stop.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(lerp, r7, lerp2, fontStyle, fontSynthesis, fontFamily, str, r14, BaselineShift.m7309boximpl(r13), lerp3, localeList, r19, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(start.getDrawStyle(), stop.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle start, PlatformSpanStyle stop, float fraction) {
        if (start == null && stop == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.lerp(start == null ? PlatformSpanStyle.Companion.getDefault() : start, stop == null ? PlatformSpanStyle.Companion.getDefault() : stop, fraction);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle style) {
        long j;
        Intrinsics.checkNotNullParameter(style, "style");
        TextForegroundStyle takeOrElse = style.getTextForegroundStyle$ui_text_release().takeOrElse(SpanStyleKt$resolveSpanStyleDefaults$1.INSTANCE);
        long r5 = TextUnitKt.m7753isUnspecifiedR2X_6o(style.m6995getFontSizeXSAIIZE()) ? DefaultFontSize : style.m6995getFontSizeXSAIIZE();
        FontWeight fontWeight = style.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle r0 = style.m6996getFontStyle4Lr2A7w();
        FontStyle r8 = FontStyle.m7131boximpl(r0 != null ? r0.m7137unboximpl() : FontStyle.Companion.m7139getNormal_LCdwA());
        FontSynthesis r02 = style.m6997getFontSynthesisZQGJjVo();
        FontSynthesis r9 = FontSynthesis.m7140boximpl(r02 != null ? r02.m7148unboximpl() : FontSynthesis.Companion.m7149getAllGVVA2EU());
        FontFamily fontFamily = style.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = style.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m7753isUnspecifiedR2X_6o(style.m6998getLetterSpacingXSAIIZE())) {
            j = DefaultLetterSpacing;
        } else {
            j = style.m6998getLetterSpacingXSAIIZE();
        }
        BaselineShift r03 = style.m6993getBaselineShift5SSeXJ0();
        BaselineShift r14 = BaselineShift.m7309boximpl(r03 != null ? r03.m7315unboximpl() : BaselineShift.Companion.m7319getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = style.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = style.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long $this$takeOrElse_u2dDxMtmZc$iv = style.m6992getBackground0d7_KjU();
        long j2 = ($this$takeOrElse_u2dDxMtmZc$iv > Color.Companion.m4999getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.Companion.m4999getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : DefaultBackgroundColor;
        TextDecoration textDecoration = style.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = style.getPlatformStyle();
        DrawStyle drawStyle = style.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, r5, fontWeight2, r8, r9, fontFamily2, str, j, r14, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x01fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01fd  */
    /* renamed from: fastMerge-dSHsh3o  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.SpanStyle m6999fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r39, long r40, androidx.compose.ui.graphics.Brush r42, float r43, long r44, androidx.compose.ui.text.font.FontWeight r46, androidx.compose.ui.text.font.FontStyle r47, androidx.compose.ui.text.font.FontSynthesis r48, androidx.compose.ui.text.font.FontFamily r49, java.lang.String r50, long r51, androidx.compose.ui.text.style.BaselineShift r53, androidx.compose.ui.text.style.TextGeometricTransform r54, androidx.compose.ui.text.intl.LocaleList r55, long r56, androidx.compose.ui.text.style.TextDecoration r58, androidx.compose.ui.graphics.Shadow r59, androidx.compose.ui.text.PlatformSpanStyle r60, androidx.compose.ui.graphics.drawscope.DrawStyle r61) {
        /*
            r0 = r39
            r1 = r40
            r3 = r42
            r4 = r43
            r5 = r46
            r6 = r47
            r7 = r48
            r8 = r49
            r9 = r50
            r10 = r53
            r11 = r54
            r12 = r55
            r13 = r58
            r14 = r59
            r15 = r60
            java.lang.String r15 = "$this$fastMerge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r15)
            r15 = r44
            r17 = 0
            boolean r18 = androidx.compose.ui.unit.TextUnitKt.m7753isUnspecifiedR2X_6o(r15)
            r15 = 1
            r16 = r18 ^ 1
            r17 = 0
            if (r16 == 0) goto L_0x0049
            long r11 = r39.m6995getFontSizeXSAIIZE()
            r9 = r44
            boolean r11 = androidx.compose.ui.unit.TextUnit.m7732equalsimpl0(r9, r11)
            if (r11 == 0) goto L_0x003f
            goto L_0x004b
        L_0x003f:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x0049:
            r9 = r44
        L_0x004b:
            if (r3 != 0) goto L_0x007a
            r11 = r40
            r16 = 0
            androidx.compose.ui.graphics.Color$Companion r18 = androidx.compose.ui.graphics.Color.Companion
            long r18 = r18.m4999getUnspecified0d7_KjU()
            int r18 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r18 == 0) goto L_0x005d
            r11 = r15
            goto L_0x005f
        L_0x005d:
            r11 = r17
        L_0x005f:
            if (r11 == 0) goto L_0x007a
            androidx.compose.ui.text.style.TextForegroundStyle r11 = r39.getTextForegroundStyle$ui_text_release()
            long r11 = r11.m7436getColor0d7_KjU()
            boolean r11 = androidx.compose.ui.graphics.Color.m4964equalsimpl0(r1, r11)
            if (r11 == 0) goto L_0x0070
            goto L_0x007a
        L_0x0070:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x007a:
            if (r6 == 0) goto L_0x0091
            androidx.compose.ui.text.font.FontStyle r11 = r39.m6996getFontStyle4Lr2A7w()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x0087
            goto L_0x0091
        L_0x0087:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x0091:
            if (r5 == 0) goto L_0x00a8
            androidx.compose.ui.text.font.FontWeight r11 = r39.getFontWeight()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x009e
            goto L_0x00a8
        L_0x009e:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x00a8:
            if (r8 == 0) goto L_0x00bb
            androidx.compose.ui.text.font.FontFamily r11 = r39.getFontFamily()
            if (r8 != r11) goto L_0x00b1
            goto L_0x00bb
        L_0x00b1:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x00bb:
            r11 = r51
            r16 = 0
            boolean r18 = androidx.compose.ui.unit.TextUnitKt.m7753isUnspecifiedR2X_6o(r11)
            r11 = r18 ^ 1
            if (r11 == 0) goto L_0x00de
            long r11 = r39.m6998getLetterSpacingXSAIIZE()
            r9 = r51
            boolean r11 = androidx.compose.ui.unit.TextUnit.m7732equalsimpl0(r9, r11)
            if (r11 == 0) goto L_0x00d4
            goto L_0x00e0
        L_0x00d4:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x00de:
            r9 = r51
        L_0x00e0:
            if (r13 == 0) goto L_0x00f7
            androidx.compose.ui.text.style.TextDecoration r11 = r39.getTextDecoration()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x00ed
            goto L_0x00f7
        L_0x00ed:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x00f7:
            androidx.compose.ui.text.style.TextForegroundStyle r11 = r39.getTextForegroundStyle$ui_text_release()
            androidx.compose.ui.graphics.Brush r11 = r11.getBrush()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x01f0
            if (r3 == 0) goto L_0x0124
            androidx.compose.ui.text.style.TextForegroundStyle r11 = r39.getTextForegroundStyle$ui_text_release()
            float r11 = r11.getAlpha()
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 != 0) goto L_0x0115
            r11 = r15
            goto L_0x0117
        L_0x0115:
            r11 = r17
        L_0x0117:
            if (r11 == 0) goto L_0x011a
            goto L_0x0124
        L_0x011a:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x0124:
            if (r7 == 0) goto L_0x013b
            androidx.compose.ui.text.font.FontSynthesis r11 = r39.m6997getFontSynthesisZQGJjVo()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x0131
            goto L_0x013b
        L_0x0131:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x013b:
            r11 = r50
            if (r11 == 0) goto L_0x0152
            java.lang.String r12 = r39.getFontFeatureSettings()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x014a
            goto L_0x0152
        L_0x014a:
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x0152:
            r12 = r53
            if (r12 == 0) goto L_0x0169
            androidx.compose.ui.text.style.BaselineShift r15 = r39.m6993getBaselineShift5SSeXJ0()
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)
            if (r15 == 0) goto L_0x0161
            goto L_0x0169
        L_0x0161:
            r15 = r54
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x0169:
            r15 = r54
            if (r15 == 0) goto L_0x017e
            androidx.compose.ui.text.style.TextGeometricTransform r9 = r39.getTextGeometricTransform()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x0178
            goto L_0x017e
        L_0x0178:
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x017e:
            r9 = r55
            if (r9 == 0) goto L_0x0193
            androidx.compose.ui.text.intl.LocaleList r10 = r39.getLocaleList()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x018d
            goto L_0x0193
        L_0x018d:
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x0193:
            r18 = r56
            r10 = 0
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            long r20 = r20.m4999getUnspecified0d7_KjU()
            int r20 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r20 == 0) goto L_0x01a2
            r10 = 1
            goto L_0x01a4
        L_0x01a2:
            r10 = r17
        L_0x01a4:
            if (r10 == 0) goto L_0x01b8
            long r9 = r39.m6992getBackground0d7_KjU()
            r12 = r56
            boolean r9 = androidx.compose.ui.graphics.Color.m4964equalsimpl0(r12, r9)
            if (r9 == 0) goto L_0x01b3
            goto L_0x01ba
        L_0x01b3:
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x01b8:
            r12 = r56
        L_0x01ba:
            if (r14 == 0) goto L_0x01cc
            androidx.compose.ui.graphics.Shadow r9 = r39.getShadow()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x01c7
            goto L_0x01cc
        L_0x01c7:
            r9 = r60
            r10 = r61
            goto L_0x01f8
        L_0x01cc:
            r9 = r60
            if (r9 == 0) goto L_0x01de
            androidx.compose.ui.text.PlatformSpanStyle r10 = r39.getPlatformStyle()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r10 == 0) goto L_0x01db
            goto L_0x01de
        L_0x01db:
            r10 = r61
            goto L_0x01f8
        L_0x01de:
            r10 = r61
            if (r10 == 0) goto L_0x01ed
            androidx.compose.ui.graphics.drawscope.DrawStyle r12 = r39.getDrawStyle()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r12 != 0) goto L_0x01ed
            goto L_0x01f8
        L_0x01ed:
            r12 = r17
            goto L_0x01f9
        L_0x01f0:
            r11 = r50
            r15 = r54
            r9 = r60
            r10 = r61
        L_0x01f8:
            r12 = 1
        L_0x01f9:
            if (r12 != 0) goto L_0x01fd
            return r0
        L_0x01fd:
            if (r3 == 0) goto L_0x0206
            androidx.compose.ui.text.style.TextForegroundStyle$Companion r13 = androidx.compose.ui.text.style.TextForegroundStyle.Companion
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r13.from(r3, r4)
            goto L_0x020c
        L_0x0206:
            androidx.compose.ui.text.style.TextForegroundStyle$Companion r13 = androidx.compose.ui.text.style.TextForegroundStyle.Companion
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r13.m7437from8_81llA(r1)
        L_0x020c:
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r39.getTextForegroundStyle$ui_text_release()
            androidx.compose.ui.text.style.TextForegroundStyle r19 = r1.merge(r13)
            if (r8 != 0) goto L_0x021e
            androidx.compose.ui.text.font.FontFamily r1 = r39.getFontFamily()
            r25 = r1
            goto L_0x0220
        L_0x021e:
            r25 = r8
        L_0x0220:
            boolean r1 = androidx.compose.ui.unit.TextUnitKt.m7753isUnspecifiedR2X_6o(r44)
            if (r1 != 0) goto L_0x0229
            r20 = r44
            goto L_0x022f
        L_0x0229:
            long r1 = r39.m6995getFontSizeXSAIIZE()
            r20 = r1
        L_0x022f:
            if (r5 != 0) goto L_0x0238
            androidx.compose.ui.text.font.FontWeight r1 = r39.getFontWeight()
            r22 = r1
            goto L_0x023a
        L_0x0238:
            r22 = r5
        L_0x023a:
            if (r6 != 0) goto L_0x0243
            androidx.compose.ui.text.font.FontStyle r1 = r39.m6996getFontStyle4Lr2A7w()
            r23 = r1
            goto L_0x0245
        L_0x0243:
            r23 = r6
        L_0x0245:
            if (r7 != 0) goto L_0x024e
            androidx.compose.ui.text.font.FontSynthesis r1 = r39.m6997getFontSynthesisZQGJjVo()
            r24 = r1
            goto L_0x0250
        L_0x024e:
            r24 = r7
        L_0x0250:
            if (r11 != 0) goto L_0x0259
            java.lang.String r1 = r39.getFontFeatureSettings()
            r26 = r1
            goto L_0x025b
        L_0x0259:
            r26 = r11
        L_0x025b:
            boolean r1 = androidx.compose.ui.unit.TextUnitKt.m7753isUnspecifiedR2X_6o(r51)
            if (r1 != 0) goto L_0x0264
            r27 = r51
            goto L_0x026a
        L_0x0264:
            long r1 = r39.m6998getLetterSpacingXSAIIZE()
            r27 = r1
        L_0x026a:
            if (r53 != 0) goto L_0x0274
            androidx.compose.ui.text.style.BaselineShift r1 = r39.m6993getBaselineShift5SSeXJ0()
            r29 = r1
            goto L_0x0276
        L_0x0274:
            r29 = r53
        L_0x0276:
            if (r15 != 0) goto L_0x027f
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r39.getTextGeometricTransform()
            r30 = r1
            goto L_0x0281
        L_0x027f:
            r30 = r15
        L_0x0281:
            if (r55 != 0) goto L_0x028a
            androidx.compose.ui.text.intl.LocaleList r1 = r39.getLocaleList()
            r31 = r1
            goto L_0x028c
        L_0x028a:
            r31 = r55
        L_0x028c:
            r1 = r56
            r18 = 0
            r32 = r1
            r34 = 0
            androidx.compose.ui.graphics.Color$Companion r35 = androidx.compose.ui.graphics.Color.Companion
            long r35 = r35.m4999getUnspecified0d7_KjU()
            int r35 = (r32 > r35 ? 1 : (r32 == r35 ? 0 : -1))
            if (r35 == 0) goto L_0x02a1
            r16 = 1
            goto L_0x02a3
        L_0x02a1:
            r16 = r17
        L_0x02a3:
            if (r16 == 0) goto L_0x02a8
            r32 = r1
            goto L_0x02b0
        L_0x02a8:
            r16 = 0
            long r16 = r39.m6992getBackground0d7_KjU()
            r32 = r16
        L_0x02b0:
            if (r58 != 0) goto L_0x02ba
            androidx.compose.ui.text.style.TextDecoration r1 = r39.getTextDecoration()
            r34 = r1
            goto L_0x02bc
        L_0x02ba:
            r34 = r58
        L_0x02bc:
            if (r14 != 0) goto L_0x02c5
            androidx.compose.ui.graphics.Shadow r1 = r39.getShadow()
            r35 = r1
            goto L_0x02c7
        L_0x02c5:
            r35 = r14
        L_0x02c7:
            androidx.compose.ui.text.PlatformSpanStyle r36 = mergePlatformStyle(r0, r9)
            if (r10 != 0) goto L_0x02d4
            androidx.compose.ui.graphics.drawscope.DrawStyle r1 = r39.getDrawStyle()
            r37 = r1
            goto L_0x02d6
        L_0x02d4:
            r37 = r10
        L_0x02d6:
            androidx.compose.ui.text.SpanStyle r1 = new androidx.compose.ui.text.SpanStyle
            r18 = r1
            r38 = 0
            r18.<init>((androidx.compose.ui.text.style.TextForegroundStyle) r19, (long) r20, (androidx.compose.ui.text.font.FontWeight) r22, (androidx.compose.ui.text.font.FontStyle) r23, (androidx.compose.ui.text.font.FontSynthesis) r24, (androidx.compose.ui.text.font.FontFamily) r25, (java.lang.String) r26, (long) r27, (androidx.compose.ui.text.style.BaselineShift) r29, (androidx.compose.ui.text.style.TextGeometricTransform) r30, (androidx.compose.ui.text.intl.LocaleList) r31, (long) r32, (androidx.compose.ui.text.style.TextDecoration) r34, (androidx.compose.ui.graphics.Shadow) r35, (androidx.compose.ui.text.PlatformSpanStyle) r36, (androidx.compose.ui.graphics.drawscope.DrawStyle) r37, (kotlin.jvm.internal.DefaultConstructorMarker) r38)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m6999fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle $this$mergePlatformStyle, PlatformSpanStyle other) {
        if ($this$mergePlatformStyle.getPlatformStyle() == null) {
            return other;
        }
        if (other == null) {
            return $this$mergePlatformStyle.getPlatformStyle();
        }
        return $this$mergePlatformStyle.getPlatformStyle().merge(other);
    }
}
