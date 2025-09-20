package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$rememberTimePickerState$1$1 extends Lambda implements Function0<TimePickerState> {
    final /* synthetic */ int $initialHour;
    final /* synthetic */ int $initialMinute;
    final /* synthetic */ boolean $is24Hour;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$rememberTimePickerState$1$1(int i, int i2, boolean z) {
        super(0);
        this.$initialHour = i;
        this.$initialMinute = i2;
        this.$is24Hour = z;
    }

    public final TimePickerState invoke() {
        return new TimePickerState(this.$initialHour, this.$initialMinute, this.$is24Hour);
    }
}
