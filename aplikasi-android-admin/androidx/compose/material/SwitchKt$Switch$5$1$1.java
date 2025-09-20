package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$5$1$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$5$1$1(AnchoredDraggableState<Boolean> anchoredDraggableState) {
        super(0);
        this.$anchoredDraggableState = anchoredDraggableState;
    }

    public final Float invoke() {
        return Float.valueOf(this.$anchoredDraggableState.requireOffset());
    }
}
