package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0010*\u00020\u0019H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "ceilToIntPx", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextDelegate.kt */
public final class TextDelegateKt {
    public static final int ceilToIntPx(float $this$ceilToIntPx) {
        return MathKt.roundToInt((float) Math.ceil((double) $this$ceilToIntPx));
    }

    /* renamed from: updateTextDelegate-rm0N8CA$default  reason: not valid java name */
    public static /* synthetic */ TextDelegate m947updateTextDelegaterm0N8CA$default(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z, int i, int i2, int i3, List list, int i4, Object obj) {
        boolean z2;
        int i5;
        int i6 = i4;
        if ((i6 & 32) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        int r9 = (i6 & 64) != 0 ? TextOverflow.Companion.m5756getClipgIe3tQ8() : i;
        int i7 = (i6 & 128) != 0 ? Integer.MAX_VALUE : i2;
        if ((i6 & 256) != 0) {
            i5 = 1;
        } else {
            i5 = i3;
        }
        return m946updateTextDelegaterm0N8CA(textDelegate, annotatedString, textStyle, density, resolver, z2, r9, i7, i5, list);
    }

    /* renamed from: updateTextDelegate-rm0N8CA  reason: not valid java name */
    public static final TextDelegate m946updateTextDelegaterm0N8CA(TextDelegate current, AnnotatedString text, TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, boolean softWrap, int overflow, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders) {
        AnnotatedString annotatedString = text;
        TextStyle textStyle = style;
        Density density2 = density;
        FontFamily.Resolver resolver = fontFamilyResolver;
        List<AnnotatedString.Range<Placeholder>> list = placeholders;
        TextDelegate textDelegate = current;
        Intrinsics.checkNotNullParameter(textDelegate, "current");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        if (!Intrinsics.areEqual((Object) current.getText(), (Object) annotatedString)) {
            boolean z = softWrap;
            int i = overflow;
            int i2 = maxLines;
            int i3 = minLines;
        } else if (!Intrinsics.areEqual((Object) current.getStyle(), (Object) textStyle)) {
            boolean z2 = softWrap;
            int i4 = overflow;
            int i5 = maxLines;
            int i6 = minLines;
        } else if (current.getSoftWrap() != softWrap) {
            int i7 = overflow;
            int i8 = maxLines;
            int i9 = minLines;
        } else if (!TextOverflow.m5749equalsimpl0(current.m944getOverflowgIe3tQ8(), overflow)) {
            int i10 = maxLines;
            int i11 = minLines;
        } else if (current.getMaxLines() != maxLines) {
            int i12 = minLines;
        } else if (current.getMinLines() == minLines && Intrinsics.areEqual((Object) current.getDensity(), (Object) density2) && Intrinsics.areEqual((Object) current.getPlaceholders(), (Object) list) && current.getFontFamilyResolver() == resolver) {
            return textDelegate;
        }
        return new TextDelegate(text, style, maxLines, minLines, softWrap, overflow, density, fontFamilyResolver, placeholders, (DefaultConstructorMarker) null);
    }
}
