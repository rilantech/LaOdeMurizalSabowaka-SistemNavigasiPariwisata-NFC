package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$CircularLayout$1 implements MeasurePolicy {
    final /* synthetic */ float $radius;

    TimePickerKt$CircularLayout$1(float f) {
        this.$radius = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2172measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Object obj;
        Object obj2;
        boolean z;
        boolean z2;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$filter$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$filter$iv, "measurables");
        float radiusPx = measureScope.m5825toPx0680j_4(this.$radius);
        long itemConstraints = Constraints.m5779copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Measurable it = (Measurable) element$iv$iv;
            if ((LayoutIdKt.getLayoutId(it) == LayoutId.Selector || LayoutIdKt.getLayoutId(it) == LayoutId.InnerCircle) ? false : true) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<Measurable> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Measurable measurable : $this$map$iv) {
            destination$iv$iv2.add(measurable.m4689measureBRTryo0(itemConstraints));
        }
        List placeables = (List) destination$iv$iv2;
        Iterator it2 = $this$filter$iv.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (LayoutIdKt.getLayoutId((Measurable) obj) == LayoutId.Selector) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        Measurable selectorMeasurable = (Measurable) obj;
        Iterator it3 = $this$filter$iv.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            if (LayoutIdKt.getLayoutId((Measurable) obj2) == LayoutId.InnerCircle) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Measurable innerMeasurable = (Measurable) obj2;
        Measurable measurable2 = innerMeasurable;
        Measurable measurable3 = selectorMeasurable;
        long j = itemConstraints;
        return MeasureScope.layout$default($this$Layout, Constraints.m5790getMinWidthimpl(constraints), Constraints.m5789getMinHeightimpl(constraints), (Map) null, new TimePickerKt$CircularLayout$1$measure$1(selectorMeasurable != null ? selectorMeasurable.m4689measureBRTryo0(itemConstraints) : null, placeables, innerMeasurable != null ? innerMeasurable.m4689measureBRTryo0(itemConstraints) : null, constraints, radiusPx, 6.2831855f / ((float) placeables.size())), 4, (Object) null);
    }
}
