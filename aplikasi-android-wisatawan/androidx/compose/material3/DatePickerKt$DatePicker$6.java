package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$6(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, Function1<? super Long, Boolean> function1, DatePickerColors datePickerColors, int i) {
        super(2);
        this.$state = datePickerState;
        this.$dateFormatter = datePickerFormatter;
        this.$dateValidator = function1;
        this.$colors = datePickerColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C195@8777L178:DatePicker.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(173769747, $changed, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:194)");
            }
            DatePickerState datePickerState = this.$state;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            Function1<Long, Boolean> function1 = this.$dateValidator;
            DatePickerColors datePickerColors = this.$colors;
            int i = this.$$dirty;
            DatePickerKt.SwitchableDateEntryContent(datePickerState, datePickerFormatter, function1, datePickerColors, $composer, (i & 14) | ((i >> 3) & 112) | ((i >> 3) & 896) | ((i >> 12) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
