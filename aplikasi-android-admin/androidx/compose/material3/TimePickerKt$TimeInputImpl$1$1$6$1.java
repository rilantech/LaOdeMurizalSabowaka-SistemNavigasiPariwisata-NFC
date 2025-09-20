package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActionScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1$6$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$6$1(TimePickerState timePickerState) {
        super(1);
        this.$state = timePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((KeyboardActionScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope $this$$receiver) {
        Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
        this.$state.m3904setSelectioniHAOin8$material3_release(Selection.Companion.m3671getMinuteJiIwxys());
    }
}
