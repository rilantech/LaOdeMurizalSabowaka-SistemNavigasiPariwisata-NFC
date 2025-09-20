package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Constraints;", "it", "invoke-ZezNO4M", "(J)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends Lambda implements Function1<Constraints, Constraints> {
    final /* synthetic */ float $headerHeightPx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f) {
        super(1);
        this.$headerHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return Constraints.m5776boximpl(m1176invokeZezNO4M(((Constraints) p1).m5794unboximpl()));
    }

    /* renamed from: invoke-ZezNO4M  reason: not valid java name */
    public final long m1176invokeZezNO4M(long it) {
        return ConstraintsKt.m5805offsetNN6EwU$default(Constraints.m5779copyZbe2FdA$default(it, 0, 0, 0, 0, 10, (Object) null), 0, -MathKt.roundToInt(this.$headerHeightPx), 1, (Object) null);
    }
}
