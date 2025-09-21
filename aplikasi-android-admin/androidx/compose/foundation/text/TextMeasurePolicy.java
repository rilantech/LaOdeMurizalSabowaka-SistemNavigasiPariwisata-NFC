package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J/\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "placements", "Lkotlin/Function0;", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;

    public TextMeasurePolicy(Function0<? extends List<Rect>> placements2) {
        Intrinsics.checkNotNullParameter(placements2, "placements");
        this.placements = placements2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2696measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        List toPlace;
        int $i$f$fastForEachIndexed;
        List $this$fastForEachIndexed$iv$iv;
        List $this$fastMapIndexedNotNull$iv;
        Object it$iv;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        List $this$fastMapIndexedNotNull$iv2 = this.placements.invoke();
        if ($this$fastMapIndexedNotNull$iv2 != null) {
            ArrayList target$iv = new ArrayList($this$fastMapIndexedNotNull$iv2.size());
            List $this$fastForEachIndexed$iv$iv2 = $this$fastMapIndexedNotNull$iv2;
            int $i$f$fastForEachIndexed2 = false;
            int index$iv$iv = 0;
            int size = $this$fastForEachIndexed$iv$iv2.size();
            while (index$iv$iv < size) {
                Rect rect = (Rect) $this$fastForEachIndexed$iv$iv2.get(index$iv$iv);
                int index = index$iv$iv;
                if (rect != null) {
                    Rect it = rect;
                    int index2 = index;
                    int i = index2;
                    $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                    $this$fastForEachIndexed$iv$iv = $this$fastForEachIndexed$iv$iv2;
                    $i$f$fastForEachIndexed = $i$f$fastForEachIndexed2;
                    it$iv = new Pair(((Measurable) list.get(index2)).m6399measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) ((float) Math.floor((double) it.getWidth())), 0, (int) ((float) Math.floor((double) it.getHeight())), 5, (Object) null)), IntOffset.m7663boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(it.getLeft()), MathKt.roundToInt(it.getTop()))));
                } else {
                    $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                    $this$fastForEachIndexed$iv$iv = $this$fastForEachIndexed$iv$iv2;
                    $i$f$fastForEachIndexed = $i$f$fastForEachIndexed2;
                    it$iv = null;
                }
                if (it$iv != null) {
                    target$iv.add(it$iv);
                }
                index$iv$iv++;
                list = measurables;
                $this$fastMapIndexedNotNull$iv2 = $this$fastMapIndexedNotNull$iv;
                $this$fastForEachIndexed$iv$iv2 = $this$fastForEachIndexed$iv$iv;
                $i$f$fastForEachIndexed2 = $i$f$fastForEachIndexed;
            }
            List list2 = $this$fastForEachIndexed$iv$iv2;
            int i2 = $i$f$fastForEachIndexed2;
            toPlace = target$iv;
        } else {
            toPlace = null;
        }
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.m7498getMaxWidthimpl(constraints), Constraints.m7497getMaxHeightimpl(constraints), (Map) null, new TextMeasurePolicy$measure$1(toPlace), 4, (Object) null);
    }
}
