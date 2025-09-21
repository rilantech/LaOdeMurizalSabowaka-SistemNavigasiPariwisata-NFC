package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$animateSnap$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ float $cancelOffset;
    final /* synthetic */ Ref.FloatRef $consumedUpToNow;
    final /* synthetic */ ScrollScope $this_animateSnap;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$animateSnap$2(SnapFlingBehavior snapFlingBehavior, float f, Ref.FloatRef floatRef, ScrollScope scrollScope) {
        super(1);
        this.this$0 = snapFlingBehavior;
        this.$cancelOffset = f;
        this.$consumedUpToNow = floatRef;
        this.$this_animateSnap = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) p1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        if ((r0 == r6.getValue().floatValue()) == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.animation.core.AnimationScope<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "$this$animateTo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.material3.SnapFlingBehavior r0 = r5.this$0
            java.lang.Object r1 = r6.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r2 = r5.$cancelOffset
            float r0 = r0.coerceToTarget(r1, r2)
            kotlin.jvm.internal.Ref$FloatRef r1 = r5.$consumedUpToNow
            float r1 = r1.element
            float r1 = r0 - r1
            androidx.compose.foundation.gestures.ScrollScope r2 = r5.$this_animateSnap
            float r2 = r2.scrollBy(r1)
            float r3 = r1 - r2
            float r3 = java.lang.Math.abs(r3)
            r4 = 1056964608(0x3f000000, float:0.5)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0042
            java.lang.Object r3 = r6.getValue()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            if (r3 != 0) goto L_0x0045
        L_0x0042:
            r6.cancelAnimation()
        L_0x0045:
            kotlin.jvm.internal.Ref$FloatRef r3 = r5.$consumedUpToNow
            float r4 = r3.element
            float r4 = r4 + r2
            r3.element = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior$animateSnap$2.invoke(androidx.compose.animation.core.AnimationScope):void");
    }
}
