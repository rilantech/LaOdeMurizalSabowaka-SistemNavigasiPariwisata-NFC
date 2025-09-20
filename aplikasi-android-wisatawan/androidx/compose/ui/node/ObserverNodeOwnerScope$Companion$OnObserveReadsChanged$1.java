package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ObserverModifierNode.kt */
final class ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 extends Lambda implements Function1<ObserverNodeOwnerScope, Unit> {
    public static final ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 INSTANCE = new ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1();

    ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ObserverNodeOwnerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ObserverNodeOwnerScope it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isValidOwnerScope()) {
            it.getObserverNode$ui_release().onObservedReadsChanged();
        }
    }
}
