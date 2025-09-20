package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "<set-?>");
        this.paddingValues = paddingValues2;
    }

    public PaddingValuesModifier(PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2286measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Measurable measurable2 = measurable;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        if (Dp.m7553compareTo0680j_4(this.paddingValues.m2263calculateLeftPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.m7554constructorimpl((float) 0)) >= 0 && Dp.m7553compareTo0680j_4(this.paddingValues.m2265calculateTopPaddingD9Ej5fM(), Dp.m7554constructorimpl((float) 0)) >= 0 && Dp.m7553compareTo0680j_4(this.paddingValues.m2264calculateRightPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.m7554constructorimpl((float) 0)) >= 0 && Dp.m7553compareTo0680j_4(this.paddingValues.m2262calculateBottomPaddingD9Ej5fM(), Dp.m7554constructorimpl((float) 0)) >= 0) {
            int horizontal = measureScope.m7529roundToPx0680j_4(this.paddingValues.m2263calculateLeftPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection())) + measureScope.m7529roundToPx0680j_4(this.paddingValues.m2264calculateRightPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()));
            int vertical = measureScope.m7529roundToPx0680j_4(this.paddingValues.m2265calculateTopPaddingD9Ej5fM()) + measureScope.m7529roundToPx0680j_4(this.paddingValues.m2262calculateBottomPaddingD9Ej5fM());
            Placeable placeable = measurable2.m6399measureBRTryo0(ConstraintsKt.m7514offsetNN6EwU(j, -horizontal, -vertical));
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.m7512constrainWidthK40F9xA(j, placeable.getWidth() + horizontal), ConstraintsKt.m7511constrainHeightK40F9xA(j, placeable.getHeight() + vertical), (Map) null, new PaddingValuesModifier$measure$2(placeable, measureScope, this), 4, (Object) null);
        }
        throw new IllegalArgumentException("Padding must be non-negative".toString());
    }
}
