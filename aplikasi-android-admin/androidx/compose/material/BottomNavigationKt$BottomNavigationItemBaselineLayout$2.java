package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
final class BottomNavigationKt$BottomNavigationItemBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ float $iconPositionAnimationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    BottomNavigationKt$BottomNavigationItemBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, float f) {
        this.$label = function2;
        this.$iconPositionAnimationProgress = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2901measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Placeable placeable;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "icon")) {
                Placeable iconPlaceable = ((Measurable) element$iv).m6399measureBRTryo0(j);
                Function2 it = this.$label;
                if (it != null) {
                    for (Object element$iv2 : $this$first$iv) {
                        Function2 it2 = it;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "label")) {
                            placeable = ((Measurable) element$iv2).m6399measureBRTryo0(Constraints.m7489copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
                        } else {
                            it = it2;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                placeable = null;
                Placeable labelPlaceable = placeable;
                if (this.$label == null) {
                    Placeable placeable2 = iconPlaceable;
                    return BottomNavigationKt.m2899placeIcon3p2s80s(measureScope, iconPlaceable, j);
                }
                Intrinsics.checkNotNull(labelPlaceable);
                Placeable placeable3 = iconPlaceable;
                return BottomNavigationKt.m2900placeLabelAndIconDIyivk0($this$Layout, labelPlaceable, iconPlaceable, constraints, this.$iconPositionAnimationProgress);
            }
            j = constraints;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
