package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2$1(SheetState sheetState) {
        super(1);
        this.$sheetState = sheetState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntOffset.m5953boximpl(m1858invokeBjo55l4((Density) p1));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1858invokeBjo55l4(Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffsetKt.IntOffset(0, (int) this.$sheetState.requireOffset());
    }
}
