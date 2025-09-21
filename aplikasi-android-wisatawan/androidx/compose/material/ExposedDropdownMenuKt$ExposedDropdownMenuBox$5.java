package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$5 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ MutableIntState $menuHeight$delegate;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$5(View view, Ref<LayoutCoordinates> ref, int i, MutableIntState mutableIntState) {
        super(1);
        this.$view = view;
        this.$coordinates = ref;
        this.$verticalMarginInPx = i;
        this.$menuHeight$delegate = mutableIntState;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1(new OnGlobalLayoutListener(this.$view, new ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1(this.$view, this.$coordinates, this.$verticalMarginInPx, this.$menuHeight$delegate)));
    }
}
