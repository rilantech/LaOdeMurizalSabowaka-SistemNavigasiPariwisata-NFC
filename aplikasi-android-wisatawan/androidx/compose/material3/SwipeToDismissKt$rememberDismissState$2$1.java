package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$rememberDismissState$2$1 extends Lambda implements Function0<DismissState> {
    final /* synthetic */ Function1<DismissValue, Boolean> $confirmValueChange;
    final /* synthetic */ DismissValue $initialValue;
    final /* synthetic */ Function2<Density, Float, Float> $positionalThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$rememberDismissState$2$1(DismissValue dismissValue, Function1<? super DismissValue, Boolean> function1, Function2<? super Density, ? super Float, Float> function2) {
        super(0);
        this.$initialValue = dismissValue;
        this.$confirmValueChange = function1;
        this.$positionalThreshold = function2;
    }

    public final DismissState invoke() {
        return new DismissState(this.$initialValue, this.$confirmValueChange, this.$positionalThreshold);
    }
}
