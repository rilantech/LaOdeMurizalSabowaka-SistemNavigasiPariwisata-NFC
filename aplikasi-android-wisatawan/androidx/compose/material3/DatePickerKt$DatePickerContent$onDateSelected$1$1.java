package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$onDateSelected$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$onDateSelected$1$1(StateData stateData) {
        super(1);
        this.$stateData = stateData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long dateInMillis) {
        this.$stateData.getSelectedStartDate().setValue(this.$stateData.getCalendarModel().getCanonicalDate(dateInMillis));
    }
}
