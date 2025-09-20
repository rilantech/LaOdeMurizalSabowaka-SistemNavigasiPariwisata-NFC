package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPicker$1$2$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ int $selectedYear;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPicker$1$2$1$2$1(Function1<? super Integer, Unit> function1, int i) {
        super(0);
        this.$onYearSelected = function1;
        this.$selectedYear = i;
    }

    public final void invoke() {
        this.$onYearSelected.invoke(Integer.valueOf(this.$selectedYear));
    }
}
