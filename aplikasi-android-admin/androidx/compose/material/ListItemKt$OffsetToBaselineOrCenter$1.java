package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$OffsetToBaselineOrCenter$1 implements MeasurePolicy {
    final /* synthetic */ float $offset;

    ListItemKt$OffsetToBaselineOrCenter$1(float f) {
        this.$offset = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m3043measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        int containerHeight;
        int y;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Placeable placeable = ((Measurable) list.get(0)).m6399measureBRTryo0(Constraints.m7489copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
        int baseline = placeable.get(AlignmentLineKt.getFirstBaseline());
        if (baseline != Integer.MIN_VALUE) {
            int y2 = measureScope.m7529roundToPx0680j_4(this.$offset) - baseline;
            y = y2;
            containerHeight = Math.max(Constraints.m7499getMinHeightimpl(constraints), placeable.getHeight() + y2);
        } else {
            int containerHeight2 = Math.max(Constraints.m7499getMinHeightimpl(constraints), placeable.getHeight());
            y = IntOffset.m7673getYimpl(Alignment.Companion.getCenter().m4594alignKFBX0sM(IntSize.Companion.m7719getZeroYbymL2g(), IntSizeKt.IntSize(0, containerHeight2 - placeable.getHeight()), $this$Layout.getLayoutDirection()));
            containerHeight = containerHeight2;
        }
        return MeasureScope.layout$default($this$Layout, placeable.getWidth(), containerHeight, (Map) null, new ListItemKt$OffsetToBaselineOrCenter$1$measure$1(placeable, y), 4, (Object) null);
    }
}
