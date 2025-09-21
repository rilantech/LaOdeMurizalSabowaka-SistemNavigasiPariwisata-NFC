package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005JD\u0010\r\u001a\u00020\u000e*\u00020\u000e26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\u0017J\f\u0010\u0015\u001a\u00020\u0004*\u00020\u0004H\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\u00020\u0004*\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/layout/LookaheadScopeImpl;", "Landroidx/compose/ui/layout/LookaheadScope;", "scopeCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function0;)V", "getScopeCoordinates", "()Lkotlin/jvm/functions/Function0;", "setScopeCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "onPlaced", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Lkotlin/ParameterName;", "name", "layoutCoordinates", "", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
public final class LookaheadScopeImpl implements LookaheadScope {
    private Function0<? extends LayoutCoordinates> scopeCoordinates;

    public LookaheadScopeImpl() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public LookaheadScopeImpl(Function0<? extends LayoutCoordinates> scopeCoordinates2) {
        this.scopeCoordinates = scopeCoordinates2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LookaheadScopeImpl(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0);
    }

    public final Function0<LayoutCoordinates> getScopeCoordinates() {
        return this.scopeCoordinates;
    }

    public final void setScopeCoordinates(Function0<? extends LayoutCoordinates> function0) {
        this.scopeCoordinates = function0;
    }

    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates $this$toLookaheadCoordinates) {
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates;
        Intrinsics.checkNotNullParameter($this$toLookaheadCoordinates, "<this>");
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = $this$toLookaheadCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) $this$toLookaheadCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl != null) {
            return lookaheadLayoutCoordinatesImpl;
        }
        NodeCoordinator it = (NodeCoordinator) $this$toLookaheadCoordinates;
        LookaheadDelegate lookaheadDelegate = it.getLookaheadDelegate();
        return (lookaheadDelegate == null || (lookaheadLayoutCoordinates = lookaheadDelegate.getLookaheadLayoutCoordinates()) == null) ? it : lookaheadLayoutCoordinates;
    }

    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope $this$lookaheadScopeCoordinates) {
        Intrinsics.checkNotNullParameter($this$lookaheadScopeCoordinates, "<this>");
        Function0<? extends LayoutCoordinates> function0 = this.scopeCoordinates;
        Intrinsics.checkNotNull(function0);
        return (LayoutCoordinates) function0.invoke();
    }

    @Deprecated(message = "onPlaced in LookaheadLayoutScope has been deprecated. It's replaced with reading LookaheadLayoutCoordinates directly during placement inIntermediateMeasureScope")
    public Modifier onPlaced(Modifier $this$onPlaced, Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> onPlaced) {
        Intrinsics.checkNotNullParameter($this$onPlaced, "<this>");
        Intrinsics.checkNotNullParameter(onPlaced, "onPlaced");
        return OnPlacedModifierKt.onPlaced($this$onPlaced, new LookaheadScopeImpl$onPlaced$1(onPlaced, this));
    }
}
