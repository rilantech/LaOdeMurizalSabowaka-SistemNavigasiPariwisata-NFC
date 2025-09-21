package androidx.compose.material3;

import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$HorizontalMonthsList$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final DatePickerKt$HorizontalMonthsList$1 INSTANCE = new DatePickerKt$HorizontalMonthsList$1();

    DatePickerKt$HorizontalMonthsList$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setHorizontalScrollAxisRange($this$semantics, new ScrollAxisRange(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, false, 4, (DefaultConstructorMarker) null));
    }
}
