package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Badge.kt */
final class BadgeKt$BadgedBox$2 implements MeasurePolicy {
    public static final BadgeKt$BadgedBox$2 INSTANCE = new BadgeKt$BadgedBox$2();

    BadgeKt$BadgedBox$2() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2890measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "badge")) {
                Placeable badgePlaceable = ((Measurable) element$iv).m6399measureBRTryo0(Constraints.m7489copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
                for (Object element$iv2 : $this$first$iv) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "anchor")) {
                        Placeable anchorPlaceable = ((Measurable) element$iv2).m6399measureBRTryo0(constraints);
                        int firstBaseline = anchorPlaceable.get(AlignmentLineKt.getFirstBaseline());
                        int lastBaseline = anchorPlaceable.get(AlignmentLineKt.getLastBaseline());
                        return measureScope.layout(anchorPlaceable.getWidth(), anchorPlaceable.getHeight(), MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(firstBaseline)), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(lastBaseline))), new BadgeKt$BadgedBox$2$measure$1(badgePlaceable, measureScope, anchorPlaceable));
                    }
                    long j = constraints;
                }
                long j2 = constraints;
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            long j3 = constraints;
        }
        long j4 = constraints;
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
