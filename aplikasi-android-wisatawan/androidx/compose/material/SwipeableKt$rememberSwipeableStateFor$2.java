package androidx.compose.material;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "T", "", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableKt$rememberSwipeableStateFor$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<Boolean> $forceAnimationCheck;
    final /* synthetic */ Function1<T, Unit> $onValueChange;
    final /* synthetic */ SwipeableState<T> $swipeableState;
    final /* synthetic */ T $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableKt$rememberSwipeableStateFor$2(T t, SwipeableState<T> swipeableState, Function1<? super T, Unit> function1, MutableState<Boolean> mutableState) {
        super(1);
        this.$value = t;
        this.$swipeableState = swipeableState;
        this.$onValueChange = function1;
        this.$forceAnimationCheck = mutableState;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        if (!Intrinsics.areEqual((Object) this.$value, (Object) this.$swipeableState.getCurrentValue())) {
            this.$onValueChange.invoke(this.$swipeableState.getCurrentValue());
            MutableState<Boolean> mutableState = this.$forceAnimationCheck;
            mutableState.setValue(Boolean.valueOf(!mutableState.getValue().booleanValue()));
        }
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1();
    }
}
