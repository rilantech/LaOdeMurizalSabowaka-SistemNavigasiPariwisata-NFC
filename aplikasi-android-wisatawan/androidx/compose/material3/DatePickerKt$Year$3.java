package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Year$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $currentYear;
    final /* synthetic */ String $description;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Year$3(Modifier modifier, boolean z, boolean z2, Function0<Unit> function0, String str, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$selected = z;
        this.$currentYear = z2;
        this.$onClick = function0;
        this.$description = str;
        this.$colors = datePickerColors;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.Year(this.$modifier, this.$selected, this.$currentYear, this.$onClick, this.$description, this.$colors, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
