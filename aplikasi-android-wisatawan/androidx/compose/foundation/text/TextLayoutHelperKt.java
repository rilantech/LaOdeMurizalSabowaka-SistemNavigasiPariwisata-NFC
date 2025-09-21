package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001au\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"canReuse", "", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "canReuse-7_7YC6M", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutHelper.kt */
public final class TextLayoutHelperKt {
    /* renamed from: canReuse-7_7YC6M  reason: not valid java name */
    public static final boolean m978canReuse7_7YC6M(TextLayoutResult $this$canReuse_u2d7_7YC6M, AnnotatedString text, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines, boolean softWrap, int overflow, Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        AnnotatedString annotatedString = text;
        TextStyle textStyle = style;
        List<AnnotatedString.Range<Placeholder>> list = placeholders;
        boolean z = softWrap;
        int i = overflow;
        Density density2 = density;
        LayoutDirection layoutDirection2 = layoutDirection;
        FontFamily.Resolver resolver = fontFamilyResolver;
        Intrinsics.checkNotNullParameter($this$canReuse_u2d7_7YC6M, "$this$canReuse");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = $this$canReuse_u2d7_7YC6M.getLayoutInput();
        if ($this$canReuse_u2d7_7YC6M.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) layoutInput.getText(), (Object) annotatedString)) {
            int i2 = maxLines;
        } else if (!layoutInput.getStyle().hasSameLayoutAffectingAttributes(textStyle)) {
            int i3 = maxLines;
        } else if (!Intrinsics.areEqual((Object) layoutInput.getPlaceholders(), (Object) list)) {
            int i4 = maxLines;
        } else if (layoutInput.getMaxLines() != maxLines || layoutInput.getSoftWrap() != z || !TextOverflow.m5749equalsimpl0(layoutInput.m5294getOverflowgIe3tQ8(), i) || !Intrinsics.areEqual((Object) layoutInput.getDensity(), (Object) density2) || layoutInput.getLayoutDirection() != layoutDirection2 || !Intrinsics.areEqual((Object) layoutInput.getFontFamilyResolver(), (Object) resolver) || Constraints.m5790getMinWidthimpl(constraints) != Constraints.m5790getMinWidthimpl(layoutInput.m5293getConstraintsmsEJaDk())) {
            return false;
        } else {
            if (!z && !TextOverflow.m5749equalsimpl0(i, TextOverflow.Companion.m5757getEllipsisgIe3tQ8())) {
                return true;
            }
            if (Constraints.m5788getMaxWidthimpl(constraints) == Constraints.m5788getMaxWidthimpl(layoutInput.m5293getConstraintsmsEJaDk()) && Constraints.m5787getMaxHeightimpl(constraints) == Constraints.m5787getMaxHeightimpl(layoutInput.m5293getConstraintsmsEJaDk())) {
                return true;
            }
            return false;
        }
        return false;
    }
}
