package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1(ScrollState scrollState) {
        super(0);
        this.$state = scrollState;
    }

    public final Float invoke() {
        return Float.valueOf((float) this.$state.getValue());
    }
}
