package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$SwitchableDateEntryContent$2 extends Lambda implements Function3<DisplayMode, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$SwitchableDateEntryContent$2(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, Function1<? super Long, Boolean> function1, DatePickerColors datePickerColors, int i) {
        super(3);
        this.$state = dateRangePickerState;
        this.$dateFormatter = datePickerFormatter;
        this.$dateValidator = function1;
        this.$colors = datePickerColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        m3430invokeQujVXRc(((DisplayMode) p1).m3447unboximpl(), (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-QujVXRc  reason: not valid java name */
    public final void m3430invokeQujVXRc(int mode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "CP(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(mode) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1354418636, $changed, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:458)");
            }
            if (DisplayMode.m3444equalsimpl0(mode, DisplayMode.Companion.m3449getPickerjFl4v0())) {
                $composer.startReplaceableGroup(-1168754929);
                ComposerKt.sourceInformation($composer, "460@19572L208");
                StateData stateData$material3_release = this.$state.getStateData$material3_release();
                DatePickerFormatter datePickerFormatter = this.$dateFormatter;
                Function1<Long, Boolean> function1 = this.$dateValidator;
                DatePickerColors datePickerColors = this.$colors;
                int i = this.$$dirty;
                DateRangePickerKt.DateRangePickerContent(stateData$material3_release, datePickerFormatter, function1, datePickerColors, $composer, (i & 112) | (i & 896) | (i & 7168));
                $composer.endReplaceableGroup();
            } else if (DisplayMode.m3444equalsimpl0(mode, DisplayMode.Companion.m3448getInputjFl4v0())) {
                $composer.startReplaceableGroup(-1168754686);
                ComposerKt.sourceInformation($composer, "467@19815L175");
                StateData stateData$material3_release2 = this.$state.getStateData$material3_release();
                DatePickerFormatter datePickerFormatter2 = this.$dateFormatter;
                Function1<Long, Boolean> function12 = this.$dateValidator;
                int i2 = this.$$dirty;
                DateRangeInputKt.DateRangeInputContent(stateData$material3_release2, datePickerFormatter2, function12, $composer, (i2 & 896) | (i2 & 112));
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(-1168754501);
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
