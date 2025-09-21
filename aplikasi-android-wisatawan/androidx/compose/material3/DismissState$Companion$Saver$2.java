package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DismissState;", "it", "Landroidx/compose/material3/DismissValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class DismissState$Companion$Saver$2 extends Lambda implements Function1<DismissValue, DismissState> {
    final /* synthetic */ Function1<DismissValue, Boolean> $confirmValueChange;
    final /* synthetic */ Function2<Density, Float, Float> $positionalThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DismissState$Companion$Saver$2(Function1<? super DismissValue, Boolean> function1, Function2<? super Density, ? super Float, Float> function2) {
        super(1);
        this.$confirmValueChange = function1;
        this.$positionalThreshold = function2;
    }

    public final DismissState invoke(DismissValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new DismissState(it, this.$confirmValueChange, this.$positionalThreshold);
    }
}
