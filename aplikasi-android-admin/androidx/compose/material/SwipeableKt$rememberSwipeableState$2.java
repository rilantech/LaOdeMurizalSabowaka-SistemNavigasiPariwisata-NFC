package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material/SwipeableState;", "T", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableKt$rememberSwipeableState$2 extends Lambda implements Function0<SwipeableState<T>> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<T, Boolean> $confirmStateChange;
    final /* synthetic */ T $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableKt$rememberSwipeableState$2(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        super(0);
        this.$initialValue = t;
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = function1;
    }

    public final SwipeableState<T> invoke() {
        return new SwipeableState<>(this.$initialValue, this.$animationSpec, this.$confirmStateChange);
    }
}
