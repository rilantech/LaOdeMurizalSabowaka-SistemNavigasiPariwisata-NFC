package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
final class LookaheadScopeKt$LookaheadScope$2$1 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final LookaheadScopeKt$LookaheadScope$2$1 INSTANCE = new LookaheadScopeKt$LookaheadScope$2$1();

    LookaheadScopeKt$LookaheadScope$2$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutNode) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode $this$init) {
        Intrinsics.checkNotNullParameter($this$init, "$this$init");
        $this$init.setVirtualLookaheadRoot$ui_release(true);
    }
}
