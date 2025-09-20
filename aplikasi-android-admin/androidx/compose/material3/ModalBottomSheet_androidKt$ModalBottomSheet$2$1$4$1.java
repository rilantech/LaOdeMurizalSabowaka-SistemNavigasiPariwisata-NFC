package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1 extends Lambda implements Function2<CoroutineScope, Float, Unit> {
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1(Function1<? super Float, Unit> function1) {
        super(2);
        this.$settleToDismiss = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((CoroutineScope) p1, ((Number) p2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(CoroutineScope $this$modalBottomSheetSwipeable, float it) {
        Intrinsics.checkNotNullParameter($this$modalBottomSheetSwipeable, "$this$modalBottomSheetSwipeable");
        this.$settleToDismiss.invoke(Float.valueOf(it));
    }
}
