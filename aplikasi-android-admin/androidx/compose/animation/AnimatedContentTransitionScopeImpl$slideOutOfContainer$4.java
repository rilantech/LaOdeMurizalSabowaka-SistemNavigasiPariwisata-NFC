package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "S", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentTransitionScopeImpl$slideOutOfContainer$4 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ Function1<Integer, Integer> $targetOffset;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentTransitionScopeImpl$slideOutOfContainer$4(AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, Function1<? super Integer, Integer> function1) {
        super(1);
        this.this$0 = animatedContentTransitionScopeImpl;
        this.$targetOffset = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Integer invoke(int it) {
        State state = this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
        long targetSize = state != null ? ((IntSize) state.getValue()).m7718unboximpl() : IntSize.Companion.m7719getZeroYbymL2g();
        return this.$targetOffset.invoke(Integer.valueOf((-IntOffset.m7673getYimpl(this.this$0.m1741calculateOffsetemnUabE(IntSizeKt.IntSize(it, it), targetSize))) + IntSize.m7713getHeightimpl(targetSize)));
    }
}
