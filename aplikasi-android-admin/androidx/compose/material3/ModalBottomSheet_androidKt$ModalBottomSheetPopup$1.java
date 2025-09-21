package androidx.compose.material3;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheetPopup$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ ModalBottomSheetWindow $modalBottomSheetWindow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheetPopup$1(ModalBottomSheetWindow modalBottomSheetWindow) {
        super(1);
        this.$modalBottomSheetWindow = modalBottomSheetWindow;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        this.$modalBottomSheetWindow.show();
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$invoke$$inlined$onDispose$1(this.$modalBottomSheetWindow);
    }
}
