package androidx.compose.foundation.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J$\u0010\u0015\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J,\u0010\u0018\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\"\u0010\u001a\u001a\u00020\u0005*\u00020\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\"\u0010\u001d\u001a\u00020\u0005*\u00020\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J/\u0010\u001e\u001a\u00020\u001f*\u00020 2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020!0\u00112\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\"\u0010&\u001a\u00020\u0005*\u00020\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\"\u0010'\u001a\u00020\u0005*\u00020\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R.\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR.\u0010\u000b\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR.\u0010\r\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"androidx/compose/foundation/layout/FlowLayoutKt$flowMeasurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxCrossAxisIntrinsicItemSize", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "Lkotlin/ExtensionFunctionType;", "getMaxCrossAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxMainAxisIntrinsicItemSize", "getMaxMainAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "intrinsicCrossAxisSize", "measurables", "", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "height", "arrangementSpacing", "minIntrinsicMainAxisSize", "crossAxisAvailable", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
public final class FlowLayoutKt$flowMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $crossAxisArrangement;
    final /* synthetic */ float $crossAxisArrangementSpacing;
    final /* synthetic */ SizeMode $crossAxisSize;
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $mainAxisArrangement;
    final /* synthetic */ float $mainAxisArrangementSpacing;
    final /* synthetic */ int $maxItemsInMainAxis;
    final /* synthetic */ LayoutOrientation $orientation;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;

    FlowLayoutKt$flowMeasurePolicy$1(LayoutOrientation $orientation2, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> $mainAxisArrangement2, float $mainAxisArrangementSpacing2, SizeMode $crossAxisSize2, CrossAxisAlignment $crossAxisAlignment2, int $maxItemsInMainAxis2, float $crossAxisArrangementSpacing2, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> $crossAxisArrangement2) {
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function3;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function32;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function33;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function34;
        this.$orientation = $orientation2;
        this.$mainAxisArrangement = $mainAxisArrangement2;
        this.$mainAxisArrangementSpacing = $mainAxisArrangementSpacing2;
        this.$crossAxisSize = $crossAxisSize2;
        this.$crossAxisAlignment = $crossAxisAlignment2;
        this.$maxItemsInMainAxis = $maxItemsInMainAxis2;
        this.$crossAxisArrangementSpacing = $crossAxisArrangementSpacing2;
        this.$crossAxisArrangement = $crossAxisArrangement2;
        if ($orientation2 == LayoutOrientation.Horizontal) {
            function3 = FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function3 = FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.maxMainAxisIntrinsicItemSize = function3;
        if ($orientation2 == LayoutOrientation.Horizontal) {
            function32 = FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function32 = FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.maxCrossAxisIntrinsicItemSize = function32;
        if ($orientation2 == LayoutOrientation.Horizontal) {
            function33 = FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function33 = FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.minCrossAxisIntrinsicItemSize = function33;
        if ($orientation2 == LayoutOrientation.Horizontal) {
            function34 = FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function34 = FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.minMainAxisIntrinsicItemSize = function34;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2189measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int layoutHeight;
        int layoutWidth;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (measurables.isEmpty()) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, 0, 0, (Map) null, FlowLayoutKt$flowMeasurePolicy$1$measure$1.INSTANCE, 4, (Object) null);
        }
        Placeable[] placeables = new Placeable[measurables.size()];
        RowColumnMeasurementHelper measureHelper = new RowColumnMeasurementHelper(this.$orientation, this.$mainAxisArrangement, this.$mainAxisArrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, measurables, placeables, (DefaultConstructorMarker) null);
        MeasureScope measureScope2 = $this$measure_u2d3p2s80s;
        RowColumnMeasurementHelper rowColumnMeasurementHelper = measureHelper;
        FlowResult flowResult = FlowLayoutKt.m2186breakDownItemsw1Onq5I(measureScope2, rowColumnMeasurementHelper, this.$orientation, OrientationIndependentConstraints.m2217constructorimpl(j, this.$orientation), this.$maxItemsInMainAxis);
        MutableVector this_$iv = flowResult.getItems();
        int size = this_$iv.getSize();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((RowColumnMeasureHelperResult) this_$iv.getContent()[i]).getCrossAxisSize();
        }
        int[] crossAxisSizes = iArr;
        int[] outPosition = new int[crossAxisSizes.length];
        int totalCrossAxisSize = flowResult.getCrossAxisTotalSize() + (measureScope.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing) * (this_$iv.getSize() - 1));
        int[] outPosition2 = outPosition;
        RowColumnMeasurementHelper measureHelper2 = measureHelper;
        Placeable[] placeableArr = placeables;
        this.$crossAxisArrangement.invoke(Integer.valueOf(totalCrossAxisSize), crossAxisSizes, $this$measure_u2d3p2s80s.getLayoutDirection(), $this$measure_u2d3p2s80s, outPosition2);
        if (this.$orientation == LayoutOrientation.Horizontal) {
            layoutWidth = flowResult.getMainAxisTotalSize();
            layoutHeight = totalCrossAxisSize;
        } else {
            layoutWidth = totalCrossAxisSize;
            layoutHeight = flowResult.getMainAxisTotalSize();
        }
        int layoutWidth2 = ConstraintsKt.m7512constrainWidthK40F9xA(j, layoutWidth);
        int layoutHeight2 = ConstraintsKt.m7511constrainHeightK40F9xA(j, layoutHeight);
        int[] outPosition3 = outPosition2;
        int[] iArr2 = outPosition3;
        RowColumnMeasurementHelper rowColumnMeasurementHelper2 = measureHelper2;
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, layoutWidth2, layoutHeight2, (Map) null, new FlowLayoutKt$flowMeasurePolicy$1$measure$2(flowResult, measureHelper2, outPosition3, measureScope), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (this.$orientation == LayoutOrientation.Horizontal) {
            return minIntrinsicMainAxisSize(measurables, height, $this$minIntrinsicWidth.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicWidth.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing));
        }
        return intrinsicCrossAxisSize(measurables, height, $this$minIntrinsicWidth.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicWidth.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (this.$orientation == LayoutOrientation.Horizontal) {
            return intrinsicCrossAxisSize(measurables, width, $this$minIntrinsicHeight.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicHeight.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing));
        }
        return minIntrinsicMainAxisSize(measurables, width, $this$minIntrinsicHeight.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicHeight.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (this.$orientation == LayoutOrientation.Horizontal) {
            return intrinsicCrossAxisSize(measurables, width, $this$maxIntrinsicHeight.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$maxIntrinsicHeight.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing));
        }
        return maxIntrinsicMainAxisSize(measurables, width, $this$maxIntrinsicHeight.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (this.$orientation == LayoutOrientation.Horizontal) {
            return maxIntrinsicMainAxisSize(measurables, height, $this$maxIntrinsicWidth.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing));
        }
        return intrinsicCrossAxisSize(measurables, height, $this$maxIntrinsicWidth.m7529roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$maxIntrinsicWidth.m7529roundToPx0680j_4(this.$crossAxisArrangementSpacing));
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing) {
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return FlowLayoutKt.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, this.$maxItemsInMainAxis);
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return FlowLayoutKt.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.$maxItemsInMainAxis);
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing) {
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return FlowLayoutKt.intrinsicCrossAxisSize(measurables, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, this.$maxItemsInMainAxis);
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }
}
