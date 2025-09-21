package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010#\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010&\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0006\u0010'\u001a\u00020\u0019J\u001f\u0010(\u001a\u00020\u0019*\u00020)2\u0006\u0010*\u001a\u00020+ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010 R\u0019\u0010!\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "Landroidx/compose/ui/unit/Dp;", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "F", "startRadius", "Ljava/lang/Float;", "targetCenter", "targetRadius", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RippleAnimation.kt */
public final class RippleAnimation {
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedAlpha;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;
    private final MutableState finishRequested$delegate;
    private final CompletableDeferred<Unit> finishSignalDeferred;
    private final MutableState finishedFadingIn$delegate;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;
    private Float targetRadius;

    public /* synthetic */ RippleAnimation(Offset offset, float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f, z);
    }

    private RippleAnimation(Offset origin2, float radius2, boolean bounded2) {
        this.origin = origin2;
        this.radius = radius2;
        this.bounded = bounded2;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred((Job) null);
        this.finishedFadingIn$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.finishRequested$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn$delegate.getValue()).booleanValue();
    }

    private final void setFinishedFadingIn(boolean z) {
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(z));
    }

    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested$delegate.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z) {
        this.finishRequested$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r2.setFinishedFadingIn(true);
        r3 = r2.finishSignalDeferred;
        r6.L$0 = r2;
        r6.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r3.await(r6) != r1) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        r6.L$0 = null;
        r6.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r2.fadeOut(r6) != r1) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animate(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.material.ripple.RippleAnimation$animate$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation$animate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r5, r6)
        L_0x0019:
            r6 = r0
            java.lang.Object r0 = r6.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0042;
                case 1: goto L_0x003a;
                case 2: goto L_0x0032;
                case 3: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006f
        L_0x0032:
            java.lang.Object r2 = r6.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0062
        L_0x003a:
            java.lang.Object r2 = r6.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0051
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r5
            r6.L$0 = r2
            r6.label = r3
            java.lang.Object r4 = r2.fadeIn(r6)
            if (r4 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2.setFinishedFadingIn(r3)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r3 = r2.finishSignalDeferred
            r6.L$0 = r2
            r4 = 2
            r6.label = r4
            java.lang.Object r3 = r3.await(r6)
            if (r3 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r3 = 0
            r6.L$0 = r3
            r3 = 3
            r6.label = r3
            java.lang.Object r2 = r2.fadeOut(r6)
            if (r2 != r1) goto L_0x006f
            return r1
        L_0x006f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.animate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object fadeIn(Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeIn$2(this, (Continuation<? super RippleAnimation$fadeIn$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object fadeOut(Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeOut$2(this, (Continuation<? super RippleAnimation$fadeOut$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    /* renamed from: draw-4WTKRHQ  reason: not valid java name */
    public final void m1516draw4WTKRHQ(DrawScope $this$draw_u2d4WTKRHQ, long color) {
        float f;
        Float f2;
        DrawScope drawScope = $this$draw_u2d4WTKRHQ;
        Intrinsics.checkNotNullParameter(drawScope, "$this$draw");
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1518getRippleStartRadiusuvyYCjk($this$draw_u2d4WTKRHQ.m3866getSizeNHjbRc()));
        }
        if (this.targetRadius == null) {
            if (Float.isNaN(this.radius)) {
                f2 = Float.valueOf(RippleAnimationKt.m1517getRippleEndRadiuscSwnlzA(drawScope, this.bounded, $this$draw_u2d4WTKRHQ.m3866getSizeNHjbRc()));
            } else {
                f2 = Float.valueOf(drawScope.m5825toPx0680j_4(this.radius));
            }
            this.targetRadius = f2;
        }
        if (this.origin == null) {
            this.origin = Offset.m2992boximpl($this$draw_u2d4WTKRHQ.m3865getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m2992boximpl(OffsetKt.Offset(Size.m3072getWidthimpl($this$draw_u2d4WTKRHQ.m3866getSizeNHjbRc()) / 2.0f, Size.m3069getHeightimpl($this$draw_u2d4WTKRHQ.m3866getSizeNHjbRc()) / 2.0f));
        }
        if (!getFinishRequested() || getFinishedFadingIn()) {
            f = this.animatedAlpha.getValue().floatValue();
        } else {
            f = 1.0f;
        }
        float alpha = f;
        Float f3 = this.startRadius;
        Intrinsics.checkNotNull(f3);
        float floatValue = f3.floatValue();
        Float f4 = this.targetRadius;
        Intrinsics.checkNotNull(f4);
        float radius2 = MathHelpersKt.lerp(floatValue, f4.floatValue(), this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float r1 = Offset.m3003getXimpl(offset.m3013unboximpl());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float lerp = MathHelpersKt.lerp(r1, Offset.m3003getXimpl(offset2.m3013unboximpl()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float r2 = Offset.m3004getYimpl(offset3.m3013unboximpl());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long centerOffset = OffsetKt.Offset(lerp, MathHelpersKt.lerp(r2, Offset.m3004getYimpl(offset4.m3013unboximpl()), this.animatedCenterPercent.getValue().floatValue()));
        long modulatedColor = Color.m3252copywmQWz5c$default(color, Color.m3255getAlphaimpl(color) * alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (this.bounded) {
            DrawScope $this$clipRect_u2drOu3jXo_u24default$iv = $this$draw_u2d4WTKRHQ;
            float right$iv = Size.m3072getWidthimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3866getSizeNHjbRc());
            float bottom$iv = Size.m3069getHeightimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3866getSizeNHjbRc());
            int clipOp$iv = ClipOp.Companion.m3242getIntersectrtfAjoo();
            DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv;
            DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
            long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3809getSizeNHjbRc();
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
            DrawScope drawScope2 = $this$clipRect_u2drOu3jXo_u24default$iv;
            $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3921clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
            DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
            DrawScope.m3829drawCircleVaOC9Bg$default($this$withTransform$iv$iv, modulatedColor, radius2, centerOffset, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv2.m3810setSizeuvyYCjk(previousSize$iv$iv);
            return;
        }
        DrawScope.m3829drawCircleVaOC9Bg$default($this$draw_u2d4WTKRHQ, modulatedColor, radius2, centerOffset, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
    }
}
