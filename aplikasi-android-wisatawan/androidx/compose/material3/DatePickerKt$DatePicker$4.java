package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$4(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, int i) {
        super(2);
        this.$state = datePickerState;
        this.$dateFormatter = datePickerFormatter;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C161@7665L142:DatePicker.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1578326756, $changed, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:160)");
            }
            DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
            DatePickerState datePickerState = this.$state;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            Modifier padding = PaddingKt.padding(Modifier.Companion, DatePickerKt.DatePickerHeadlinePadding);
            int i = this.$$dirty;
            datePickerDefaults.DatePickerHeadline(datePickerState, datePickerFormatter, padding, $composer, (i & 14) | 3456 | ((i >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
