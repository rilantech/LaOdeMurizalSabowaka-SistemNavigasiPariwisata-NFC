package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$1$1$1$1$1$inRange$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ long $dateInMillis;
    final /* synthetic */ boolean $rangeSelectionEnabled;
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$1$1$1$1$1$inRange$1$1(StateData stateData, boolean z, long j) {
        super(0);
        this.$stateData = stateData;
        this.$rangeSelectionEnabled = z;
        this.$dateInMillis = j;
    }

    public final Boolean invoke() {
        boolean z;
        long j;
        long j2;
        StateData $this$invoke_u24lambda_u240 = this.$stateData;
        boolean z2 = this.$rangeSelectionEnabled;
        long j3 = this.$dateInMillis;
        if (z2) {
            CalendarDate value = $this$invoke_u24lambda_u240.getSelectedStartDate().getValue();
            if (value != null) {
                j = value.getUtcTimeMillis();
            } else {
                j = Long.MAX_VALUE;
            }
            if (j3 >= j) {
                CalendarDate value2 = $this$invoke_u24lambda_u240.getSelectedEndDate().getValue();
                if (value2 != null) {
                    j2 = value2.getUtcTimeMillis();
                } else {
                    j2 = Long.MIN_VALUE;
                }
                if (j3 <= j2) {
                    z = true;
                    return Boolean.valueOf(z);
                }
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
