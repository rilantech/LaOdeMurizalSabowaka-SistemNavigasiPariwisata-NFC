package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$HorizontalMonthsList$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<Long, Unit> $onDateSelected;
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$HorizontalMonthsList$4(Function1<? super Long, Unit> function1, StateData stateData, LazyListState lazyListState, DatePickerFormatter datePickerFormatter, Function1<? super Long, Boolean> function12, DatePickerColors datePickerColors, int i) {
        super(2);
        this.$onDateSelected = function1;
        this.$stateData = stateData;
        this.$lazyListState = lazyListState;
        this.$dateFormatter = datePickerFormatter;
        this.$dateValidator = function12;
        this.$colors = datePickerColors;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.HorizontalMonthsList(this.$onDateSelected, this.$stateData, this.$lazyListState, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
