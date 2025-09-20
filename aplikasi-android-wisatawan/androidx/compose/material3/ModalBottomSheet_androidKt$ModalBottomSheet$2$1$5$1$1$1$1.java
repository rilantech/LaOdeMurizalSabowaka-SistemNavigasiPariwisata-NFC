package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1$1$1(Function0<Unit> function0) {
        super(0);
        this.$animateToDismiss = function0;
    }

    public final Boolean invoke() {
        this.$animateToDismiss.invoke();
        return true;
    }
}
