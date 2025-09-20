package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/IntermediateMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
final class LookaheadScope$intermediateLayout$1 extends Lambda implements Function3<IntermediateMeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ Function4<MeasureScope, Measurable, Constraints, IntSize, MeasureResult> $measure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadScope$intermediateLayout$1(Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> function4) {
        super(3);
        this.$measure = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return m4688invoke3p2s80s((IntermediateMeasureScope) p1, (Measurable) p2, ((Constraints) p3).m5794unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m4688invoke3p2s80s(IntermediateMeasureScope $this$intermediateLayout, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$intermediateLayout, "$this$intermediateLayout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return this.$measure.invoke($this$intermediateLayout, measurable, Constraints.m5776boximpl(constraints), IntSize.m5996boximpl($this$intermediateLayout.m4636getLookaheadSizeYbymL2g()));
    }
}
