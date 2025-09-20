package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$5(DatePickerState datePickerState, int i) {
        super(2);
        this.$state = datePickerState;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        ComposerKt.sourceInformation($composer, "C179@8296L163,176@8098L380:DatePicker.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1702543532, $changed, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:175)");
            }
            Modifier padding = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
            int r1 = this.$state.m3425getDisplayModejFl4v0();
            Object key1$iv = this.$state;
            DatePickerState datePickerState = this.$state;
            int i = this.$$dirty & 14;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(key1$iv);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new DatePickerKt$DatePicker$5$1$1(datePickerState);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            DatePickerKt.m3421DisplayModeToggleButtontER2X8s(padding, r1, (Function1) value$iv$iv, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
