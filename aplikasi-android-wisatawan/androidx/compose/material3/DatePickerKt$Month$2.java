package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ CalendarMonth $month;
    final /* synthetic */ Function1<Long, Unit> $onDateSelected;
    final /* synthetic */ boolean $rangeSelectionEnabled;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ CalendarDate $today;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$2(CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, CalendarDate calendarDate, StateData stateData, boolean z, Function1<? super Long, Boolean> function12, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, int i) {
        super(2);
        this.$month = calendarMonth;
        this.$onDateSelected = function1;
        this.$today = calendarDate;
        this.$stateData = stateData;
        this.$rangeSelectionEnabled = z;
        this.$dateValidator = function12;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.Month(this.$month, this.$onDateSelected, this.$today, this.$stateData, this.$rangeSelectionEnabled, this.$dateValidator, this.$dateFormatter, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
