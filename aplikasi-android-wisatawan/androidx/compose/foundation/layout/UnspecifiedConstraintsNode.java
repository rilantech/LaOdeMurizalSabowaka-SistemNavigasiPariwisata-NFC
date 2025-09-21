package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001c\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J)\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u001f\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R%\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "setMinHeight-0680j_4", "(F)V", "F", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m5864getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m5864getUnspecifiedD9Ej5fM() : f2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m634getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m637setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m633getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m636setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    private UnspecifiedConstraintsNode(float minWidth2, float minHeight2) {
        this.minWidth = minWidth2;
        this.minHeight = minHeight2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m635measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (Dp.m5849equalsimpl0(this.minWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) || Constraints.m5790getMinWidthimpl(constraints) != 0) {
            i = Constraints.m5790getMinWidthimpl(constraints);
        } else {
            i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$measure_u2d3p2s80s.m5819roundToPx0680j_4(this.minWidth), Constraints.m5788getMaxWidthimpl(constraints)), 0);
        }
        int r2 = Constraints.m5788getMaxWidthimpl(constraints);
        if (Dp.m5849equalsimpl0(this.minHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) || Constraints.m5789getMinHeightimpl(constraints) != 0) {
            i2 = Constraints.m5789getMinHeightimpl(constraints);
        } else {
            i2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$measure_u2d3p2s80s.m5819roundToPx0680j_4(this.minHeight), Constraints.m5787getMaxHeightimpl(constraints)), 0);
        }
        Placeable placeable = measurable.m4689measureBRTryo0(ConstraintsKt.Constraints(i, r2, i2, Constraints.m5787getMaxHeightimpl(constraints)));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new UnspecifiedConstraintsNode$measure$1(placeable), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicWidth(height), !Dp.m5849equalsimpl0(this.minWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) ? $this$minIntrinsicWidth.m5819roundToPx0680j_4(this.minWidth) : 0);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicWidth(height), !Dp.m5849equalsimpl0(this.minWidth, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) ? $this$maxIntrinsicWidth.m5819roundToPx0680j_4(this.minWidth) : 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicHeight(width), !Dp.m5849equalsimpl0(this.minHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) ? $this$minIntrinsicHeight.m5819roundToPx0680j_4(this.minHeight) : 0);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicHeight(width), !Dp.m5849equalsimpl0(this.minHeight, Dp.Companion.m5864getUnspecifiedD9Ej5fM()) ? $this$maxIntrinsicHeight.m5819roundToPx0680j_4(this.minHeight) : 0);
    }
}
