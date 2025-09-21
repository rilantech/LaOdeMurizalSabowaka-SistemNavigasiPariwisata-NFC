package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a9\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001aS\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0001\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPaintExtensions.android.kt */
public final class TextPaintExtensions_androidKt {
    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint $this$applySpanStyle, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, Density density, boolean requiresLetterSpacing) {
        Intrinsics.checkNotNullParameter($this$applySpanStyle, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        Intrinsics.checkNotNullParameter(density, "density");
        long r0 = TextUnit.m7734getTypeUIouoOA(style.m6995getFontSizeXSAIIZE());
        if (TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7768getSpUIouoOA())) {
            $this$applySpanStyle.setTextSize(density.m7534toPxR2X_6o(style.m6995getFontSizeXSAIIZE()));
        } else if (TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7767getEmUIouoOA())) {
            $this$applySpanStyle.setTextSize($this$applySpanStyle.getTextSize() * TextUnit.m7735getValueimpl(style.m6995getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r2 = style.m6996getFontStyle4Lr2A7w();
            FontStyle r22 = FontStyle.m7131boximpl(r2 != null ? r2.m7137unboximpl() : FontStyle.Companion.m7139getNormal_LCdwA());
            FontSynthesis r3 = style.m6997getFontSynthesisZQGJjVo();
            $this$applySpanStyle.setTypeface((Typeface) resolveTypeface.invoke(fontFamily, fontWeight, r22, FontSynthesis.m7140boximpl(r3 != null ? r3.m7148unboximpl() : FontSynthesis.Companion.m7149getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual((Object) style.getLocaleList(), (Object) LocaleList.Companion.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales($this$applySpanStyle, style.getLocaleList());
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual((Object) style.getFontFeatureSettings(), (Object) "")) {
            $this$applySpanStyle.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual((Object) style.getTextGeometricTransform(), (Object) TextGeometricTransform.Companion.getNone$ui_text_release())) {
            $this$applySpanStyle.setTextScaleX($this$applySpanStyle.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            $this$applySpanStyle.setTextSkewX($this$applySpanStyle.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        $this$applySpanStyle.m7288setColor8_81llA(style.m6994getColor0d7_KjU());
        $this$applySpanStyle.m7287setBrush12SF9DM(style.getBrush(), Size.Companion.m4790getUnspecifiedNHjbRc(), style.getAlpha());
        $this$applySpanStyle.setShadow(style.getShadow());
        $this$applySpanStyle.setTextDecoration(style.getTextDecoration());
        $this$applySpanStyle.setDrawStyle(style.getDrawStyle());
        if (TextUnitType.m7763equalsimpl0(TextUnit.m7734getTypeUIouoOA(style.m6998getLetterSpacingXSAIIZE()), TextUnitType.Companion.m7768getSpUIouoOA())) {
            boolean z = true;
            if (!(TextUnit.m7735getValueimpl(style.m6998getLetterSpacingXSAIIZE()) == 0.0f)) {
                float emWidth = $this$applySpanStyle.getTextSize() * $this$applySpanStyle.getTextScaleX();
                float letterSpacingPx = density.m7534toPxR2X_6o(style.m6998getLetterSpacingXSAIIZE());
                if (emWidth != 0.0f) {
                    z = false;
                }
                if (!z) {
                    $this$applySpanStyle.setLetterSpacing(letterSpacingPx / emWidth);
                }
                return m7304generateFallbackSpanStyle62GTOB8(style.m6998getLetterSpacingXSAIIZE(), requiresLetterSpacing, style.m6992getBackground0d7_KjU(), style.m6993getBaselineShift5SSeXJ0());
            }
        }
        if (TextUnitType.m7763equalsimpl0(TextUnit.m7734getTypeUIouoOA(style.m6998getLetterSpacingXSAIIZE()), TextUnitType.Companion.m7767getEmUIouoOA())) {
            $this$applySpanStyle.setLetterSpacing(TextUnit.m7735getValueimpl(style.m6998getLetterSpacingXSAIIZE()));
        }
        return m7304generateFallbackSpanStyle62GTOB8(style.m6998getLetterSpacingXSAIIZE(), requiresLetterSpacing, style.m6992getBackground0d7_KjU(), style.m6993getBaselineShift5SSeXJ0());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (androidx.compose.ui.text.style.BaselineShift.m7312equalsimpl0(r36.m7315unboximpl(), androidx.compose.ui.text.style.BaselineShift.Companion.m7319getNoney9eOQZs()) == false) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* renamed from: generateFallbackSpanStyle-62GTOB8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.text.SpanStyle m7304generateFallbackSpanStyle62GTOB8(long r31, boolean r33, long r34, androidx.compose.ui.text.style.BaselineShift r36) {
        /*
            r0 = r34
            r2 = 1
            r3 = 0
            if (r33 == 0) goto L_0x0026
            long r4 = androidx.compose.ui.unit.TextUnit.m7734getTypeUIouoOA(r31)
            androidx.compose.ui.unit.TextUnitType$Companion r6 = androidx.compose.ui.unit.TextUnitType.Companion
            long r6 = r6.m7768getSpUIouoOA()
            boolean r4 = androidx.compose.ui.unit.TextUnitType.m7763equalsimpl0(r4, r6)
            if (r4 == 0) goto L_0x0026
            float r4 = androidx.compose.ui.unit.TextUnit.m7735getValueimpl(r31)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0021
            r4 = r2
            goto L_0x0022
        L_0x0021:
            r4 = r3
        L_0x0022:
            if (r4 != 0) goto L_0x0026
            r4 = r2
            goto L_0x0027
        L_0x0026:
            r4 = r3
        L_0x0027:
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r5.m4999getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m4964equalsimpl0(r0, r5)
            if (r5 != 0) goto L_0x0042
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r5.m4998getTransparent0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m4964equalsimpl0(r0, r5)
            if (r5 != 0) goto L_0x0042
            r5 = r2
            goto L_0x0043
        L_0x0042:
            r5 = r3
        L_0x0043:
            if (r36 == 0) goto L_0x0056
            androidx.compose.ui.text.style.BaselineShift$Companion r6 = androidx.compose.ui.text.style.BaselineShift.Companion
            float r6 = r6.m7319getNoney9eOQZs()
            float r7 = r36.m7315unboximpl()
            boolean r6 = androidx.compose.ui.text.style.BaselineShift.m7312equalsimpl0(r7, r6)
            if (r6 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r2 = r3
        L_0x0057:
            r3 = 0
            if (r4 != 0) goto L_0x005f
            if (r5 != 0) goto L_0x005f
            if (r2 != 0) goto L_0x005f
            goto L_0x00a6
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r18 = r31
            goto L_0x006c
        L_0x0064:
            androidx.compose.ui.unit.TextUnit$Companion r6 = androidx.compose.ui.unit.TextUnit.Companion
            long r6 = r6.m7746getUnspecifiedXSAIIZE()
            r18 = r6
        L_0x006c:
            if (r5 == 0) goto L_0x0071
            r23 = r0
            goto L_0x0079
        L_0x0071:
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r6 = r6.m4999getUnspecified0d7_KjU()
            r23 = r6
        L_0x0079:
            if (r2 == 0) goto L_0x007e
            r20 = r36
            goto L_0x0080
        L_0x007e:
            r20 = r3
        L_0x0080:
            androidx.compose.ui.text.SpanStyle r3 = new androidx.compose.ui.text.SpanStyle
            r8 = r3
            r29 = 63103(0xf67f, float:8.8426E-41)
            r30 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r8.<init>((long) r9, (long) r11, (androidx.compose.ui.text.font.FontWeight) r13, (androidx.compose.ui.text.font.FontStyle) r14, (androidx.compose.ui.text.font.FontSynthesis) r15, (androidx.compose.ui.text.font.FontFamily) r16, (java.lang.String) r17, (long) r18, (androidx.compose.ui.text.style.BaselineShift) r20, (androidx.compose.ui.text.style.TextGeometricTransform) r21, (androidx.compose.ui.text.intl.LocaleList) r22, (long) r23, (androidx.compose.ui.text.style.TextDecoration) r25, (androidx.compose.ui.graphics.Shadow) r26, (androidx.compose.ui.text.PlatformSpanStyle) r27, (androidx.compose.ui.graphics.drawscope.DrawStyle) r28, (int) r29, (kotlin.jvm.internal.DefaultConstructorMarker) r30)
        L_0x00a6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.m7304generateFallbackSpanStyle62GTOB8(long, boolean, long, androidx.compose.ui.text.style.BaselineShift):androidx.compose.ui.text.SpanStyle");
    }

    public static final void setTextMotion(AndroidTextPaint $this$setTextMotion, TextMotion textMotion) {
        int i;
        Intrinsics.checkNotNullParameter($this$setTextMotion, "<this>");
        TextMotion finalTextMotion = textMotion == null ? TextMotion.Companion.getStatic() : textMotion;
        if (finalTextMotion.getSubpixelTextPositioning$ui_text_release()) {
            i = $this$setTextMotion.getFlags() | 128;
        } else {
            i = $this$setTextMotion.getFlags() & -129;
        }
        $this$setTextMotion.setFlags(i);
        int r1 = finalTextMotion.m7445getLinearity4e0Vf04$ui_text_release();
        if (TextMotion.Linearity.m7449equalsimpl0(r1, TextMotion.Linearity.Companion.m7454getLinear4e0Vf04())) {
            $this$setTextMotion.setFlags($this$setTextMotion.getFlags() | 64);
            $this$setTextMotion.setHinting(0);
        } else if (TextMotion.Linearity.m7449equalsimpl0(r1, TextMotion.Linearity.Companion.m7453getFontHinting4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(1);
        } else if (TextMotion.Linearity.m7449equalsimpl0(r1, TextMotion.Linearity.Companion.m7455getNone4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(0);
        } else {
            $this$setTextMotion.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle $this$hasFontAttributes) {
        Intrinsics.checkNotNullParameter($this$hasFontAttributes, "<this>");
        return ($this$hasFontAttributes.getFontFamily() == null && $this$hasFontAttributes.m6996getFontStyle4Lr2A7w() == null && $this$hasFontAttributes.getFontWeight() == null) ? false : true;
    }

    public static final float correctBlurRadius(float blurRadius) {
        if (blurRadius == 0.0f) {
            return Float.MIN_VALUE;
        }
        return blurRadius;
    }
}
