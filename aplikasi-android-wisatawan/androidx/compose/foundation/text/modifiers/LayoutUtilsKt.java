package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutUtils.kt */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY  reason: not valid java name */
    public static final long m1000finalConstraintstfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        return ConstraintsKt.Constraints$default(0, m1002finalMaxWidthtfFHcEY(constraints, softWrap, overflow, maxIntrinsicWidth), 0, Constraints.m5787getMaxHeightimpl(constraints), 5, (Object) null);
    }

    /* renamed from: finalMaxWidth-tfFHcEY  reason: not valid java name */
    public static final int m1002finalMaxWidthtfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        int maxWidth;
        if (!(softWrap || TextOverflow.m5749equalsimpl0(overflow, TextOverflow.Companion.m5757getEllipsisgIe3tQ8())) || !Constraints.m5784getHasBoundedWidthimpl(constraints)) {
            maxWidth = Integer.MAX_VALUE;
        } else {
            maxWidth = Constraints.m5788getMaxWidthimpl(constraints);
        }
        if (Constraints.m5790getMinWidthimpl(constraints) == maxWidth) {
            return maxWidth;
        }
        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(maxIntrinsicWidth), Constraints.m5790getMinWidthimpl(constraints), maxWidth);
    }

    /* renamed from: finalMaxLines-xdlQI24  reason: not valid java name */
    public static final int m1001finalMaxLinesxdlQI24(boolean softWrap, int overflow, int maxLinesIn) {
        if (!softWrap && TextOverflow.m5749equalsimpl0(overflow, TextOverflow.Companion.m5757getEllipsisgIe3tQ8())) {
            return 1;
        }
        return RangesKt.coerceAtLeast(maxLinesIn, 1);
    }
}
