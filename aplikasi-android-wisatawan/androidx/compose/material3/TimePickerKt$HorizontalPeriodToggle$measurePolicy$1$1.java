package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 INSTANCE = new TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1();

    TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2173measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> measurables, long constraints) {
        MeasureScope measureScope = $this$MeasurePolicy;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "Spacer")) {
                Placeable spacerPlaceable = ((Measurable) element$iv).m4689measureBRTryo0(Constraints.m5779copyZbe2FdA$default(constraints, 0, MathKt.roundToInt(measureScope.m5825toPx0680j_4(TimePickerTokens.INSTANCE.m2769getPeriodSelectorOutlineWidthD9Ej5fM())), 0, 0, 12, (Object) null));
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$first$iv) {
                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv$iv), (Object) "Spacer")) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable<Measurable> $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Measurable item : $this$map$iv) {
                    destination$iv$iv2.add(item.m4689measureBRTryo0(Constraints.m5779copyZbe2FdA$default(constraints, 0, Constraints.m5788getMaxWidthimpl(constraints) / 2, 0, 0, 12, (Object) null)));
                }
                return MeasureScope.layout$default($this$MeasurePolicy, Constraints.m5788getMaxWidthimpl(constraints), Constraints.m5787getMaxHeightimpl(constraints), (Map) null, new TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1$measure$1((List) destination$iv$iv2, spacerPlaceable), 4, (Object) null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
