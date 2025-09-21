package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;", "Landroidx/compose/foundation/relocation/BringIntoViewChildNode;", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "(Landroidx/compose/foundation/relocation/BringIntoViewResponder;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "getResponder", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "setResponder", "bringChildIntoView", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.kt */
final class BringIntoViewResponderNode extends BringIntoViewChildNode implements BringIntoViewParent {
    private final ModifierLocalMap providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(BringIntoViewKt.getModifierLocalBringIntoViewParent(), this));
    private BringIntoViewResponder responder;

    public final BringIntoViewResponder getResponder() {
        return this.responder;
    }

    public final void setResponder(BringIntoViewResponder bringIntoViewResponder) {
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "<set-?>");
        this.responder = bringIntoViewResponder;
    }

    public BringIntoViewResponderNode(BringIntoViewResponder responder2) {
        Intrinsics.checkNotNullParameter(responder2, "responder");
        this.responder = responder2;
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    /* access modifiers changed from: private */
    public static final Rect bringChildIntoView$localRect(BringIntoViewResponderNode this$0, LayoutCoordinates $childCoordinates, Function0<Rect> $boundsProvider) {
        Rect rect;
        LayoutCoordinates layoutCoordinates = this$0.getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return null;
        }
        LayoutCoordinates childCoordinates = $childCoordinates.isAttached() ? $childCoordinates : null;
        if (childCoordinates == null || (rect = $boundsProvider.invoke()) == null) {
            return null;
        }
        return BringIntoViewResponderKt.localRectOf(layoutCoordinates, childCoordinates, rect);
    }

    public Object bringChildIntoView(LayoutCoordinates childCoordinates, Function0<Rect> boundsProvider, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new BringIntoViewResponderNode$bringChildIntoView$2(this, childCoordinates, boundsProvider, new BringIntoViewResponderNode$bringChildIntoView$parentRect$1(this, childCoordinates, boundsProvider), (Continuation<? super BringIntoViewResponderNode$bringChildIntoView$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
