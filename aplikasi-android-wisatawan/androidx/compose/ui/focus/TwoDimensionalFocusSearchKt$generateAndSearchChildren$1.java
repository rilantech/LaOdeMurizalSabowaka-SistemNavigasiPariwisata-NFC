package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "invoke", "(Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TwoDimensionalFocusSearch.kt */
final class TwoDimensionalFocusSearchKt$generateAndSearchChildren$1 extends Lambda implements Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean> {
    final /* synthetic */ int $direction;
    final /* synthetic */ FocusTargetNode $focusedItem;
    final /* synthetic */ Function1<FocusTargetNode, Boolean> $onFound;
    final /* synthetic */ FocusTargetNode $this_generateAndSearchChildren;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, Function1<? super FocusTargetNode, Boolean> function1) {
        super(1);
        this.$this_generateAndSearchChildren = focusTargetNode;
        this.$focusedItem = focusTargetNode2;
        this.$direction = i;
        this.$onFound = function1;
    }

    public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope $this$searchBeyondBounds) {
        Intrinsics.checkNotNullParameter($this$searchBeyondBounds, "$this$searchBeyondBounds");
        Boolean valueOf = Boolean.valueOf(TwoDimensionalFocusSearchKt.m2967searchChildren4C6V_qg(this.$this_generateAndSearchChildren, this.$focusedItem, this.$direction, this.$onFound));
        if (valueOf.booleanValue() || !$this$searchBeyondBounds.getHasMoreContent()) {
            return valueOf;
        }
        return null;
    }
}
