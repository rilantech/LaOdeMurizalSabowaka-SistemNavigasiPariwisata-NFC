package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ String $partialExpandActionLabel;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(SheetState sheetState, boolean z, String str, String str2, String str3, CoroutineScope coroutineScope) {
        super(1);
        this.$state = sheetState;
        this.$sheetSwipeEnabled = z;
        this.$expandActionLabel = str;
        this.$partialExpandActionLabel = str2;
        this.$dismissActionLabel = str3;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SheetState $this$invoke_u24lambda_u240 = this.$state;
        boolean z = this.$sheetSwipeEnabled;
        String str = this.$expandActionLabel;
        String str2 = this.$partialExpandActionLabel;
        SheetState sheetState = this.$state;
        String str3 = this.$dismissActionLabel;
        CoroutineScope coroutineScope = this.$scope;
        if ($this$invoke_u24lambda_u240.getSwipeableState$material3_release().getAnchors$material3_release().size() > 1 && z) {
            if ($this$invoke_u24lambda_u240.getCurrentValue() == SheetValue.PartiallyExpanded) {
                if ($this$invoke_u24lambda_u240.getSwipeableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                    SemanticsPropertiesKt.expand($this$semantics, str, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1(coroutineScope, $this$invoke_u24lambda_u240));
                }
            } else if ($this$invoke_u24lambda_u240.getSwipeableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                SemanticsPropertiesKt.collapse($this$semantics, str2, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2(coroutineScope, $this$invoke_u24lambda_u240));
            }
            if (!sheetState.getSkipHiddenState$material3_release()) {
                SemanticsPropertiesKt.dismiss($this$semantics, str3, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$3(coroutineScope, $this$invoke_u24lambda_u240));
            }
        }
    }
}
