package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$slideInHorizontally$1 extends Lambda implements Function1<Integer, Integer> {
    public static final EnterExitTransitionKt$slideInHorizontally$1 INSTANCE = new EnterExitTransitionKt$slideInHorizontally$1();

    EnterExitTransitionKt$slideInHorizontally$1() {
        super(1);
    }

    public final Integer invoke(int it) {
        return Integer.valueOf((-it) / 2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }
}
