package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutKt$SubcomposeLayout$3 extends Lambda implements Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> {
    public static final SubcomposeLayoutKt$SubcomposeLayout$3 INSTANCE = new SubcomposeLayoutKt$SubcomposeLayout$3();

    SubcomposeLayoutKt$SubcomposeLayout$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m4768invoke0kLqBqw((SubcomposeIntermediateMeasureScope) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m4768invoke0kLqBqw(SubcomposeIntermediateMeasureScope $this$null, long constraints) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return $this$null.getLookaheadMeasurePolicy().invoke($this$null, Constraints.m5776boximpl(constraints));
    }
}
