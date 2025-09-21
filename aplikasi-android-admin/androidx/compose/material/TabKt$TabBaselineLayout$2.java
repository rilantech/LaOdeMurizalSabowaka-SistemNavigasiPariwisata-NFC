package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$TabBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    TabKt$TabBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$text = function2;
        this.$icon = function22;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m3155measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Placeable placeable;
        Placeable placeable2;
        float f;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        if (this.$text != null) {
            for (Object element$iv : $this$first$iv) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "text")) {
                    placeable = ((Measurable) element$iv).m6399measureBRTryo0(Constraints.m7489copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable = null;
        Placeable textPlaceable = placeable;
        if (this.$icon != null) {
            for (Object element$iv2 : $this$first$iv) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "icon")) {
                    placeable2 = ((Measurable) element$iv2).m6399measureBRTryo0(constraints);
                } else {
                    long j = constraints;
                }
            }
            long j2 = constraints;
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        long j3 = constraints;
        placeable2 = null;
        Placeable iconPlaceable = placeable2;
        int i = 0;
        int width = textPlaceable != null ? textPlaceable.getWidth() : 0;
        if (iconPlaceable != null) {
            i = iconPlaceable.getWidth();
        }
        int tabWidth = Math.max(width, i);
        if (textPlaceable == null || iconPlaceable == null) {
            f = TabKt.SmallTabHeight;
        } else {
            f = TabKt.LargeTabHeight;
        }
        int tabHeight = measureScope.m7529roundToPx0680j_4(f);
        Placeable placeable3 = textPlaceable;
        return MeasureScope.layout$default($this$Layout, tabWidth, tabHeight, (Map) null, new TabKt$TabBaselineLayout$2$measure$1(textPlaceable, iconPlaceable, $this$Layout, tabWidth, tabHeight, textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getFirstBaseline())) : null, textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getLastBaseline())) : null), 4, (Object) null);
    }
}
