package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H@"}, d2 = {"<anonymous>", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.android.kt */
final class BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1 implements BringIntoViewParent {
    final /* synthetic */ CompositionLocalConsumerModifierNode $this_defaultBringIntoViewParent;

    BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        this.$this_defaultBringIntoViewParent = compositionLocalConsumerModifierNode;
    }

    public final Object bringChildIntoView(LayoutCoordinates childCoordinates, Function0<Rect> boundsProvider, Continuation<? super Unit> $completion) {
        View view = (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.$this_defaultBringIntoViewParent, AndroidCompositionLocals_androidKt.getLocalView());
        long childOffset = LayoutCoordinatesKt.positionInRoot(childCoordinates);
        Rect invoke = boundsProvider.invoke();
        Rect rootRect = invoke != null ? invoke.m3040translatek4lQ0M(childOffset) : null;
        if (rootRect != null) {
            view.requestRectangleOnScreen(BringIntoViewResponder_androidKt.toRect(rootRect), false);
        }
        return Unit.INSTANCE;
    }
}
