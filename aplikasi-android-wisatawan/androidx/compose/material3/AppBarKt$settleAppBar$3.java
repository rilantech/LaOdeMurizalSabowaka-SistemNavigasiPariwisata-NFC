package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$settleAppBar$3 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ TopAppBarState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$settleAppBar$3(TopAppBarState topAppBarState) {
        super(1);
        this.$state = topAppBarState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(AnimationScope<Float, AnimationVector1D> $this$animateTo) {
        Intrinsics.checkNotNullParameter($this$animateTo, "$this$animateTo");
        this.$state.setHeightOffset($this$animateTo.getValue().floatValue());
    }
}
