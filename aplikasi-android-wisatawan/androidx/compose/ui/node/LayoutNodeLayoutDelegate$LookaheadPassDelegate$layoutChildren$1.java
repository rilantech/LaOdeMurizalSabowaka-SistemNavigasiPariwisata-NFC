package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LookaheadDelegate $lookaheadDelegate;
    final /* synthetic */ LayoutNodeLayoutDelegate.LookaheadPassDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate, LookaheadDelegate lookaheadDelegate) {
        super(0);
        this.this$0 = lookaheadPassDelegate;
        this.$lookaheadDelegate = lookaheadDelegate;
    }

    public final void invoke() {
        this.this$0.clearPlaceOrder();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass1.INSTANCE);
        this.$lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
        this.this$0.checkChildrenPlaceOrderForUpdates();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass2.INSTANCE);
    }
}
