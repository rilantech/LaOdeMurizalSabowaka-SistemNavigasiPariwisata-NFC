package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
final class LookaheadScopeImpl$onPlaced$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> $onPlaced;
    final /* synthetic */ LookaheadScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadScopeImpl$onPlaced$1(Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2, LookaheadScopeImpl lookaheadScopeImpl) {
        super(1);
        this.$onPlaced = function2;
        this.this$0 = lookaheadScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> function2 = this.$onPlaced;
        LookaheadScopeImpl lookaheadScopeImpl = this.this$0;
        Function0<LayoutCoordinates> scopeCoordinates = lookaheadScopeImpl.getScopeCoordinates();
        Intrinsics.checkNotNull(scopeCoordinates);
        LayoutCoordinates lookaheadCoordinates = lookaheadScopeImpl.toLookaheadCoordinates(scopeCoordinates.invoke());
        Intrinsics.checkNotNull(lookaheadCoordinates, "null cannot be cast to non-null type androidx.compose.ui.layout.LookaheadLayoutCoordinates");
        LayoutCoordinates lookaheadCoordinates2 = this.this$0.toLookaheadCoordinates(coordinates);
        Intrinsics.checkNotNull(lookaheadCoordinates2, "null cannot be cast to non-null type androidx.compose.ui.layout.LookaheadLayoutCoordinates");
        function2.invoke((LookaheadLayoutCoordinates) lookaheadCoordinates, (LookaheadLayoutCoordinates) lookaheadCoordinates2);
    }
}
