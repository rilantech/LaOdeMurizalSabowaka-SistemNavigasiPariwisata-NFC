package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it", "invoke-mzRDjE0", "(J)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$shrinkVertically$2 extends Lambda implements Function1<IntSize, IntSize> {
    final /* synthetic */ Function1<Integer, Integer> $targetHeight;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$shrinkVertically$2(Function1<? super Integer, Integer> function1) {
        super(1);
        this.$targetHeight = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntSize.m5996boximpl(m56invokemzRDjE0(((IntSize) p1).m6008unboximpl()));
    }

    /* renamed from: invoke-mzRDjE0  reason: not valid java name */
    public final long m56invokemzRDjE0(long it) {
        return IntSizeKt.IntSize(IntSize.m6004getWidthimpl(it), this.$targetHeight.invoke(Integer.valueOf(IntSize.m6003getHeightimpl(it))).intValue());
    }
}
