package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$2$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ MutableState<String> $errorText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputTextField$2$1(MutableState<String> mutableState) {
        super(1);
        this.$errorText = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        if (!StringsKt.isBlank(this.$errorText.getValue())) {
            SemanticsPropertiesKt.error($this$semantics, this.$errorText.getValue());
        }
    }
}
