package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/Density;", "invoke-Bjo55l4", "(Landroidx/compose/ui/unit/Density;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$2$1$1$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ DismissState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$2$1$1$1(DismissState dismissState) {
        super(1);
        this.$state = dismissState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntOffset.m5953boximpl(m1428invokeBjo55l4((Density) p1));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1428invokeBjo55l4(Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffsetKt.IntOffset(MathKt.roundToInt(this.$state.getOffset().getValue().floatValue()), 0);
    }
}
