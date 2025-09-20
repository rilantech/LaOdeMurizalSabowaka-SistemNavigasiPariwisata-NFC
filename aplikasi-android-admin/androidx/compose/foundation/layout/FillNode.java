package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J)\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(Direction direction2) {
        Intrinsics.checkNotNullParameter(direction2, "<set-?>");
        this.direction = direction2;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction2, float fraction2) {
        Intrinsics.checkNotNullParameter(direction2, "direction");
        this.direction = direction2;
        this.fraction = fraction2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2184measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int maxWidth;
        int minWidth;
        int maxHeight;
        int minHeight;
        Measurable measurable2 = measurable;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        if (!Constraints.m7494getHasBoundedWidthimpl(constraints) || this.direction == Direction.Vertical) {
            minWidth = Constraints.m7500getMinWidthimpl(constraints);
            maxWidth = Constraints.m7498getMaxWidthimpl(constraints);
        } else {
            int width = RangesKt.coerceIn(MathKt.roundToInt(((float) Constraints.m7498getMaxWidthimpl(constraints)) * this.fraction), Constraints.m7500getMinWidthimpl(constraints), Constraints.m7498getMaxWidthimpl(constraints));
            minWidth = width;
            maxWidth = width;
        }
        if (!Constraints.m7493getHasBoundedHeightimpl(constraints) || this.direction == Direction.Horizontal) {
            minHeight = Constraints.m7499getMinHeightimpl(constraints);
            maxHeight = Constraints.m7497getMaxHeightimpl(constraints);
        } else {
            int height = RangesKt.coerceIn(MathKt.roundToInt(((float) Constraints.m7497getMaxHeightimpl(constraints)) * this.fraction), Constraints.m7499getMinHeightimpl(constraints), Constraints.m7497getMaxHeightimpl(constraints));
            minHeight = height;
            maxHeight = height;
        }
        Placeable placeable = measurable2.m6399measureBRTryo0(ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new FillNode$measure$1(placeable), 4, (Object) null);
    }
}
