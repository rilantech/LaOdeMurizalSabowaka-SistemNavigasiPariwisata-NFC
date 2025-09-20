package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "it", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1 extends Lambda implements Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> {
    public static final LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1 INSTANCE = new LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1();

    LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m6388invoke0kLqBqw((SubcomposeIntermediateMeasureScope) p1, ((Constraints) p2).m7504unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m6388invoke0kLqBqw(SubcomposeIntermediateMeasureScope $this$null, long it) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return $this$null.getLookaheadMeasurePolicy().invoke($this$null, Constraints.m7486boximpl(it));
    }
}
