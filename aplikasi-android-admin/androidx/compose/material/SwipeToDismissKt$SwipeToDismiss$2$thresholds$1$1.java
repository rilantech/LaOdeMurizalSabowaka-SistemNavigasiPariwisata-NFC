package androidx.compose.material;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/material/ThresholdConfig;", "from", "Landroidx/compose/material/DismissValue;", "to", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 extends Lambda implements Function2<DismissValue, DismissValue, ThresholdConfig> {
    final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(Function1<? super DismissDirection, ? extends ThresholdConfig> function1) {
        super(2);
        this.$dismissThresholds = function1;
    }

    public final ThresholdConfig invoke(DismissValue from, DismissValue to) {
        Intrinsics.checkNotNullParameter(from, TypedValues.TransitionType.S_FROM);
        Intrinsics.checkNotNullParameter(to, TypedValues.TransitionType.S_TO);
        Function1<DismissDirection, ThresholdConfig> function1 = this.$dismissThresholds;
        DismissDirection access$getDismissDirection = SwipeToDismissKt.getDismissDirection(from, to);
        Intrinsics.checkNotNull(access$getDismissDirection);
        return function1.invoke(access$getDismissDirection);
    }
}
