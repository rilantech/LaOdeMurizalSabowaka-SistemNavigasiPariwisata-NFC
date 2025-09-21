package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputContent$3$1 extends Lambda implements Function1<CalendarDate, Unit> {
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputContent$3$1(StateData stateData) {
        super(1);
        this.$stateData = stateData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((CalendarDate) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(CalendarDate date) {
        this.$stateData.getSelectedStartDate().setValue(date);
    }
}
