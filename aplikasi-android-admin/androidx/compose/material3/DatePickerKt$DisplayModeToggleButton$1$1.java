package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DisplayModeToggleButton$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<DisplayMode, Unit> $onDisplayModeChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DisplayModeToggleButton$1$1(Function1<? super DisplayMode, Unit> function1) {
        super(0);
        this.$onDisplayModeChange = function1;
    }

    public final void invoke() {
        this.$onDisplayModeChange.invoke(DisplayMode.m3441boximpl(DisplayMode.Companion.m3448getInputjFl4v0()));
    }
}
