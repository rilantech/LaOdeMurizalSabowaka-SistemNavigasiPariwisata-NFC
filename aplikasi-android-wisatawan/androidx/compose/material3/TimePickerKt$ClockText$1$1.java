package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockText$1$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<Offset> $center$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockText$1$1(MutableState<Offset> mutableState) {
        super(1);
        this.$center$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TimePickerKt.ClockText$lambda$30(this.$center$delegate, LayoutCoordinatesKt.boundsInParent(it).m3033getCenterF1C5BW0());
    }
}
