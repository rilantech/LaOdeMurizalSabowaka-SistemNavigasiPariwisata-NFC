package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
final class SheetDefaultsKt$rememberSheetState$2$1 extends Lambda implements Function0<SheetState> {
    final /* synthetic */ Function1<SheetValue, Boolean> $confirmValueChange;
    final /* synthetic */ SheetValue $initialValue;
    final /* synthetic */ boolean $skipHiddenState;
    final /* synthetic */ boolean $skipPartiallyExpanded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SheetDefaultsKt$rememberSheetState$2$1(boolean z, SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z2) {
        super(0);
        this.$skipPartiallyExpanded = z;
        this.$initialValue = sheetValue;
        this.$confirmValueChange = function1;
        this.$skipHiddenState = z2;
    }

    public final SheetState invoke() {
        return new SheetState(this.$skipPartiallyExpanded, this.$initialValue, this.$confirmValueChange, this.$skipHiddenState);
    }
}
