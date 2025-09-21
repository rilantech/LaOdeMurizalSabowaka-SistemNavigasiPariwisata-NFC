package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollState$scrollableState$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ ScrollState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollState$scrollableState$1(ScrollState scrollState) {
        super(1);
        this.this$0 = scrollState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).floatValue());
    }

    public final Float invoke(float it) {
        float absolute = ((float) this.this$0.getValue()) + it + this.this$0.accumulator;
        float newValue = RangesKt.coerceIn(absolute, 0.0f, (float) this.this$0.getMaxValue());
        boolean changed = !(absolute == newValue);
        float consumed = newValue - ((float) this.this$0.getValue());
        int consumedInt = MathKt.roundToInt(consumed);
        ScrollState scrollState = this.this$0;
        scrollState.setValue(scrollState.getValue() + consumedInt);
        this.this$0.accumulator = consumed - ((float) consumedInt);
        return Float.valueOf(changed ? consumed : it);
    }
}
