package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScrollableState.kt */
final class ScrollableStateKt$rememberScrollableState$1$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ State<Function1<Float, Float>> $lambdaState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableStateKt$rememberScrollableState$1$1(State<? extends Function1<? super Float, Float>> state) {
        super(1);
        this.$lambdaState = state;
    }

    public final Float invoke(float it) {
        return (Float) this.$lambdaState.getValue().invoke(Float.valueOf(it));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).floatValue());
    }
}
