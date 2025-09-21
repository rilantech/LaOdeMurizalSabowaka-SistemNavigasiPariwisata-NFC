package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$rangeSelectionDrawModifier$1$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ State<SelectedRangeInfo> $rangeSelectionInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$rangeSelectionDrawModifier$1$1(State<SelectedRangeInfo> state, DatePickerColors datePickerColors) {
        super(1);
        this.$rangeSelectionInfo = state;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ContentDrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        SelectedRangeInfo it = this.$rangeSelectionInfo.getValue();
        if (it != null) {
            DateRangePickerKt.m1717drawRangeBackgroundmxwnekA($this$drawWithContent, it, this.$colors.m1700getDayInSelectionRangeContainerColor0d7_KjU$material3_release());
        }
        $this$drawWithContent.drawContent();
    }
}
