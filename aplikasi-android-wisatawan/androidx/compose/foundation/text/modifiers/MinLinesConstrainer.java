package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "inputTextStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getInputTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lineHeightCache", "", "oneLineHeightCache", "resolvedStyle", "coerceMinLines", "Landroidx/compose/ui/unit/Constraints;", "inConstraints", "minLines", "", "coerceMinLines-Oh53vG4$foundation_release", "(JI)J", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MinLinesConstrainer.kt */
public final class MinLinesConstrainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static MinLinesConstrainer last;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final TextStyle inputTextStyle;
    private final LayoutDirection layoutDirection;
    private float lineHeightCache;
    private float oneLineHeightCache;
    private final TextStyle resolvedStyle;

    public /* synthetic */ MinLinesConstrainer(LayoutDirection layoutDirection2, TextStyle textStyle, Density density2, FontFamily.Resolver resolver, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutDirection2, textStyle, density2, resolver);
    }

    private MinLinesConstrainer(LayoutDirection layoutDirection2, TextStyle inputTextStyle2, Density density2, FontFamily.Resolver fontFamilyResolver2) {
        this.layoutDirection = layoutDirection2;
        this.inputTextStyle = inputTextStyle2;
        this.density = density2;
        this.fontFamilyResolver = fontFamilyResolver2;
        this.resolvedStyle = TextStyleKt.resolveDefaults(inputTextStyle2, layoutDirection2);
        this.lineHeightCache = Float.NaN;
        this.oneLineHeightCache = Float.NaN;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final TextStyle getInputTextStyle() {
        return this.inputTextStyle;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer$Companion;", "", "()V", "last", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "from", "minMaxUtil", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "paramStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MinLinesConstrainer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MinLinesConstrainer from(MinLinesConstrainer minMaxUtil, LayoutDirection layoutDirection, TextStyle paramStyle, Density density, FontFamily.Resolver fontFamilyResolver) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(paramStyle, "paramStyle");
            Intrinsics.checkNotNullParameter(density, "density");
            Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
            boolean z = true;
            if (minMaxUtil != null) {
                MinLinesConstrainer it = minMaxUtil;
                if (layoutDirection == it.getLayoutDirection() && Intrinsics.areEqual((Object) paramStyle, (Object) it.getInputTextStyle())) {
                    if ((density.getDensity() == it.getDensity().getDensity()) && fontFamilyResolver == it.getFontFamilyResolver()) {
                        return it;
                    }
                }
            }
            MinLinesConstrainer it2 = MinLinesConstrainer.last;
            if (it2 != null && layoutDirection == it2.getLayoutDirection() && Intrinsics.areEqual((Object) paramStyle, (Object) it2.getInputTextStyle())) {
                if (density.getDensity() != it2.getDensity().getDensity()) {
                    z = false;
                }
                if (z && fontFamilyResolver == it2.getFontFamilyResolver()) {
                    return it2;
                }
            }
            MinLinesConstrainer it3 = new MinLinesConstrainer(layoutDirection, TextStyleKt.resolveDefaults(paramStyle, layoutDirection), density, fontFamilyResolver, (DefaultConstructorMarker) null);
            Companion companion = MinLinesConstrainer.Companion;
            MinLinesConstrainer.last = it3;
            return it3;
        }
    }

    /* renamed from: coerceMinLines-Oh53vG4$foundation_release  reason: not valid java name */
    public final long m1003coerceMinLinesOh53vG4$foundation_release(long inConstraints, int minLines) {
        int minHeight;
        int i = minLines;
        float oneLineHeight = this.oneLineHeightCache;
        float lineHeight = this.lineHeightCache;
        if (Float.isNaN(oneLineHeight) || Float.isNaN(lineHeight)) {
            oneLineHeight = ParagraphKt.m5224ParagraphUdtVg6A$default(MinLinesConstrainerKt.EmptyTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null), this.density, this.fontFamilyResolver, (List) null, (List) null, 1, false, 96, (Object) null).getHeight();
            lineHeight = ParagraphKt.m5224ParagraphUdtVg6A$default(MinLinesConstrainerKt.TwoLineTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null), this.density, this.fontFamilyResolver, (List) null, (List) null, 2, false, 96, (Object) null).getHeight() - oneLineHeight;
            this.oneLineHeightCache = oneLineHeight;
            this.lineHeightCache = lineHeight;
        }
        if (i != 1) {
            minHeight = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(MathKt.roundToInt((((float) (i - 1)) * lineHeight) + oneLineHeight), 0), Constraints.m5787getMaxHeightimpl(inConstraints));
        } else {
            minHeight = Constraints.m5789getMinHeightimpl(inConstraints);
        }
        return ConstraintsKt.Constraints(Constraints.m5790getMinWidthimpl(inConstraints), Constraints.m5788getMaxWidthimpl(inConstraints), minHeight, Constraints.m5787getMaxHeightimpl(inConstraints));
    }
}
