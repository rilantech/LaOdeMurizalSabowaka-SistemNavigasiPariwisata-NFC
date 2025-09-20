package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetState$anchoredDraggableState$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ ModalBottomSheetState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetState$anchoredDraggableState$2(ModalBottomSheetState modalBottomSheetState) {
        super(0);
        this.this$0 = modalBottomSheetState;
    }

    public final Float invoke() {
        return Float.valueOf(this.this$0.requireDensity().m5825toPx0680j_4(ModalBottomSheetKt.ModalBottomSheetVelocityThreshold));
    }
}
