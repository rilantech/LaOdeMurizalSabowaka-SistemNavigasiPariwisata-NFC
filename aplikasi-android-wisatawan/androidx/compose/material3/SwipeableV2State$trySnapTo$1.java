package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$trySnapTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$trySnapTo$1(SwipeableV2State<T> swipeableV2State, T t) {
        super(0);
        this.this$0 = swipeableV2State;
        this.$targetValue = t;
    }

    public final void invoke() {
        this.this$0.snap(this.$targetValue);
    }
}
