package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerDefaults$DateRangePickerTitle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ DateRangePickerState $state;
    final /* synthetic */ DateRangePickerDefaults $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerDefaults$DateRangePickerTitle$1(DateRangePickerDefaults dateRangePickerDefaults, DateRangePickerState dateRangePickerState, Modifier modifier, int i, int i2) {
        super(2);
        this.$tmp0_rcvr = dateRangePickerDefaults;
        this.$state = dateRangePickerState;
        this.$modifier = modifier;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.DateRangePickerTitle(this.$state, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
