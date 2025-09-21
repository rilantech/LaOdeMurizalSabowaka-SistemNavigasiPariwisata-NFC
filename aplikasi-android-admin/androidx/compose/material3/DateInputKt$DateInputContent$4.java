package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputContent$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function1<Long, Boolean> $dateValidator;
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputContent$4(StateData stateData, DatePickerFormatter datePickerFormatter, Function1<? super Long, Boolean> function1, int i) {
        super(2);
        this.$stateData = stateData;
        this.$dateFormatter = datePickerFormatter;
        this.$dateValidator = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DateInputKt.DateInputContent(this.$stateData, this.$dateFormatter, this.$dateValidator, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
