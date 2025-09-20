package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
/* synthetic */ class ModalBottomSheet_androidKt$modalBottomSheetSwipeable$1 extends FunctionReferenceImpl implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object>, SuspendFunction {
    ModalBottomSheet_androidKt$modalBottomSheetSwipeable$1(Object obj) {
        super(3, obj, Intrinsics.Kotlin.class, "suspendConversion0", "modalBottomSheetSwipeable$suspendConversion0(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object $completion) {
        return invoke((CoroutineScope) p1, ((Number) p2).floatValue(), (Continuation<? super Unit>) (Continuation) $completion);
    }

    public final Object invoke(CoroutineScope p0, float p1, Continuation<? super Unit> $completion) {
        return ((Function2) this.receiver).invoke(p0, Boxing.boxFloat(p1));
    }
}
