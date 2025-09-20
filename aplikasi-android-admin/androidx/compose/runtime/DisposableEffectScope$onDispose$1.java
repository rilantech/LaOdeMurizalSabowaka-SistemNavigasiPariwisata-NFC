package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
/* compiled from: Effects.kt */
public final class DisposableEffectScope$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Function0<Unit> $onDisposeEffect;

    public DisposableEffectScope$onDispose$1(Function0<Unit> $onDisposeEffect2) {
        this.$onDisposeEffect = $onDisposeEffect2;
    }

    public void dispose() {
        this.$onDisposeEffect.invoke();
    }
}
