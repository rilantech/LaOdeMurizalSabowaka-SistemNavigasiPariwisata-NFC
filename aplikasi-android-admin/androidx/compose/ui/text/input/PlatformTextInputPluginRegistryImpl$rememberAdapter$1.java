package androidx.compose.ui.text.input;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "T", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTextInputAdapter.kt */
final class PlatformTextInputPluginRegistryImpl$rememberAdapter$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ PlatformTextInputPluginRegistryImpl.AdapterHandle<T> $adapterHandle;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlatformTextInputPluginRegistryImpl$rememberAdapter$1(PlatformTextInputPluginRegistryImpl.AdapterHandle<T> adapterHandle, CoroutineScope coroutineScope, PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl) {
        super(1);
        this.$adapterHandle = adapterHandle;
        this.$scope = coroutineScope;
        this.this$0 = platformTextInputPluginRegistryImpl;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new PlatformTextInputPluginRegistryImpl$rememberAdapter$1$invoke$$inlined$onDispose$1(this.$adapterHandle, this.$scope, this.this$0);
    }
}
