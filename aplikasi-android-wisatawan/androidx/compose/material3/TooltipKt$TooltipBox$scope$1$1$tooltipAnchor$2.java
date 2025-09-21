package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $longPressLabel;
    final /* synthetic */ Function0<Job> $onLongPress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$2(String str, Function0<? extends Job> function0) {
        super(1);
        this.$longPressLabel = str;
        this.$onLongPress = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        String str = this.$longPressLabel;
        final Function0<Job> function0 = this.$onLongPress;
        SemanticsPropertiesKt.onLongClick($this$semantics, str, new Function0<Boolean>() {
            public final Boolean invoke() {
                function0.invoke();
                return true;
            }
        });
    }
}
