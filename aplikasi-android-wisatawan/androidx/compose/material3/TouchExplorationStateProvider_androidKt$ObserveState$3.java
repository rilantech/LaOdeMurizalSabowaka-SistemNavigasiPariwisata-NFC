package androidx.compose.material3;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$ObserveState$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Function1<Lifecycle.Event, Unit> $handleEvent;
    final /* synthetic */ Function0<Unit> $onDispose;
    final /* synthetic */ Lifecycle $this_ObserveState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TouchExplorationStateProvider_androidKt$ObserveState$3(Lifecycle lifecycle, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.$this_ObserveState = lifecycle;
        this.$handleEvent = function1;
        this.$onDispose = function0;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver observer = new TouchExplorationStateProvider_androidKt$ObserveState$3$observer$1(this.$handleEvent);
        this.$this_ObserveState.addObserver(observer);
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new TouchExplorationStateProvider_androidKt$ObserveState$3$invoke$$inlined$onDispose$1(this.$onDispose, this.$this_ObserveState, observer);
    }
}
