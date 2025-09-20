package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutKt$SubcomposeLayout$8 extends Lambda implements Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> {
    public static final SubcomposeLayoutKt$SubcomposeLayout$8 INSTANCE = new SubcomposeLayoutKt$SubcomposeLayout$8();

    SubcomposeLayoutKt$SubcomposeLayout$8() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m6480invoke0kLqBqw((SubcomposeIntermediateMeasureScope) p1, ((Constraints) p2).m7504unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m6480invoke0kLqBqw(SubcomposeIntermediateMeasureScope $this$null, long constraints) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return $this$null.getLookaheadMeasurePolicy().invoke($this$null, Constraints.m7486boximpl(constraints));
    }
}
