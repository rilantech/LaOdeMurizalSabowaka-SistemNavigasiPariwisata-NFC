package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<GraphicsLayerScope, Unit> $layerBlock;
    final /* synthetic */ long $position;
    final /* synthetic */ float $zIndex;
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1(Function1<? super GraphicsLayerScope, Unit> function1, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j, float f) {
        super(0);
        this.$layerBlock = function1;
        this.this$0 = layoutNodeLayoutDelegate;
        this.$position = j;
        this.$zIndex = f;
    }

    public final void invoke() {
        Placeable.PlacementScope.Companion $this$invoke_u24lambda_u240 = Placeable.PlacementScope.Companion;
        Function1<GraphicsLayerScope, Unit> function1 = this.$layerBlock;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
        long j = this.$position;
        float f = this.$zIndex;
        if (function1 == null) {
            $this$invoke_u24lambda_u240.m4733place70tqf50(layoutNodeLayoutDelegate.getOuterCoordinator(), j, f);
            return;
        }
        $this$invoke_u24lambda_u240.m4738placeWithLayeraW9wM(layoutNodeLayoutDelegate.getOuterCoordinator(), j, f, function1);
    }
}
