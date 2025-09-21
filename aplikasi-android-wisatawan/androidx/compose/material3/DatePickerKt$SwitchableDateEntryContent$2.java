package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$SwitchableDateEntryContent$2 extends Lambda implements Function3<DisplayMode, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$SwitchableDateEntryContent$2(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, Function1<? super Long, Boolean> function1, DatePickerColors datePickerColors, int i) {
        super(3);
        this.$state = datePickerState;
        this.$dateFormatter = datePickerFormatter;
        this.$dateValidator = function1;
        this.$colors = datePickerColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        m1714invokeQujVXRc(((DisplayMode) p1).m1737unboximpl(), (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-QujVXRc  reason: not valid java name */
    public final void m1714invokeQujVXRc(int mode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "CP(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(mode) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1854706084, $changed, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1104)");
            }
            if (DisplayMode.m1734equalsimpl0(mode, DisplayMode.Companion.m1739getPickerjFl4v0())) {
                $composer.startReplaceableGroup(-1168728183);
                ComposerKt.sourceInformation($composer, "1106@46318L203");
                StateData stateData$material3_release = this.$state.getStateData$material3_release();
                DatePickerFormatter datePickerFormatter = this.$dateFormatter;
                Function1<Long, Boolean> function1 = this.$dateValidator;
                DatePickerColors datePickerColors = this.$colors;
                int i = this.$$dirty;
                DatePickerKt.DatePickerContent(stateData$material3_release, datePickerFormatter, function1, datePickerColors, $composer, (i & 112) | (i & 896) | (i & 7168));
                $composer.endReplaceableGroup();
            } else if (DisplayMode.m1734equalsimpl0(mode, DisplayMode.Companion.m1738getInputjFl4v0())) {
                $composer.startReplaceableGroup(-1168727945);
                ComposerKt.sourceInformation($composer, "1113@46556L170");
                StateData stateData$material3_release2 = this.$state.getStateData$material3_release();
                DatePickerFormatter datePickerFormatter2 = this.$dateFormatter;
                Function1<Long, Boolean> function12 = this.$dateValidator;
                int i2 = this.$$dirty;
                DateInputKt.DateInputContent(stateData$material3_release2, datePickerFormatter2, function12, $composer, (i2 & 896) | (i2 & 112));
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(-1168727765);
                $composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
