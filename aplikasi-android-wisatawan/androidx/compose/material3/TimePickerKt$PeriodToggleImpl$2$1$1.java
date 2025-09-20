package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$PeriodToggleImpl$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$PeriodToggleImpl$2$1$1(TimePickerState timePickerState) {
        super(0);
        this.$state = timePickerState;
    }

    public final void invoke() {
        this.$state.setAfternoonToggle$material3_release(false);
    }
}
