package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0011¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/DynamicProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "(Landroidx/compose/runtime/SnapshotMutationPolicy;Lkotlin/jvm/functions/Function0;)V", "provided", "Landroidx/compose/runtime/State;", "value", "provided$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
public final class DynamicProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    /* access modifiers changed from: private */
    public final SnapshotMutationPolicy<T> policy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy<T> policy2, Function0<? extends T> defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(policy2, "policy");
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        this.policy = policy2;
    }

    public State<T> provided$runtime_release(T value, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-84026900);
        ComposerKt.sourceInformation($composer, "C(provided)*125@5325L42:CompositionLocal.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-84026900, $changed, -1, "androidx.compose.runtime.DynamicProvidableCompositionLocal.provided (CompositionLocal.kt:125)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = SnapshotStateKt.mutableStateOf(value, this.policy);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        ((MutableState) value$iv$iv).setValue(value);
        MutableState mutableState = (MutableState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return mutableState;
    }
}
