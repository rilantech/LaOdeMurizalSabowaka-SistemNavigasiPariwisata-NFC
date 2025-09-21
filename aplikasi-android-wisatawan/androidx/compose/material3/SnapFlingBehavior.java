package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0014\b\u0001\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0019H\u0002J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016JK\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u00102JS\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH@ø\u0001\u0000¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0002J(\u00108\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0002¢\u0006\u0002\u0010<J(\u0010=\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0002¢\u0006\u0002\u0010<J)\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010@J)\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001d\u0010B\u001a\u00020\u0006*\u00020.2\u0006\u0010?\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010@J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010EJ)\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010)\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010@R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\u00020\u000eX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/material3/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;)V", "DefaultScrollMotionDurationScaleFactor", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "F", "itemSize", "getItemSize", "()F", "motionScaleDuration", "androidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1", "Landroidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1;", "velocityThreshold", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "calculateDistanceToDesiredSnapPosition", "layoutInfo", "item", "equals", "", "other", "", "findClosestOffset", "velocity", "hashCode", "animateDecay", "Landroidx/compose/material3/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "fling", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "longSnap", "performFling", "runApproach", "initialTargetOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
public final class SnapFlingBehavior implements FlingBehavior {
    /* access modifiers changed from: private */
    public final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private final float MinFlingVelocityDp = Dp.m5844constructorimpl((float) 400);
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final Density density;
    private final LazyListState lazyListState;
    private SnapFlingBehavior$motionScaleDuration$1 motionScaleDuration = new SnapFlingBehavior$motionScaleDuration$1(this);
    private final AnimationSpec<Float> snapAnimationSpec;
    /* access modifiers changed from: private */
    public final float velocityThreshold;

    public SnapFlingBehavior(LazyListState lazyListState2, DecayAnimationSpec<Float> decayAnimationSpec2, AnimationSpec<Float> snapAnimationSpec2, Density density2) {
        Intrinsics.checkNotNullParameter(lazyListState2, "lazyListState");
        Intrinsics.checkNotNullParameter(decayAnimationSpec2, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(snapAnimationSpec2, "snapAnimationSpec");
        Intrinsics.checkNotNullParameter(density2, "density");
        this.lazyListState = lazyListState2;
        this.decayAnimationSpec = decayAnimationSpec2;
        this.snapAnimationSpec = snapAnimationSpec2;
        this.density = density2;
        this.velocityThreshold = density2.m5825toPx0680j_4(this.MinFlingVelocityDp);
    }

    private final List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.lazyListState.getLayoutInfo().getVisibleItemsInfo();
    }

    private final float getItemSize() {
        if (!(!getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        int sum$iv = 0;
        List $this$fastForEach$iv$iv = getVisibleItemsInfo();
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            sum$iv += ((LazyListItemInfo) $this$fastForEach$iv$iv.get(index$iv$iv)).getSize();
        }
        return ((float) sum$iv) / ((float) getVisibleItemsInfo().size());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.SnapFlingBehavior$performFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.material3.SnapFlingBehavior$performFling$1 r0 = (androidx.compose.material3.SnapFlingBehavior$performFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SnapFlingBehavior$performFling$1 r0 = new androidx.compose.material3.SnapFlingBehavior$performFling$1
            r0.<init>(r4, r7)
        L_0x0019:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0033;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r0
            goto L_0x0040
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r4
            r7.label = r3
            java.lang.Object r5 = r2.fling(r5, r6, r7)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            androidx.compose.material3.AnimationResult r5 = (androidx.compose.material3.AnimationResult) r5
            java.lang.Object r6 = r5.component1()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.animation.core.AnimationState r5 = r5.component2()
            r1 = 0
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r3 = 0
        L_0x0057:
            if (r3 == 0) goto L_0x005a
            goto L_0x0064
        L_0x005a:
            java.lang.Object r6 = r5.getVelocity()
            java.lang.Number r6 = (java.lang.Number) r6
            float r1 = r6.floatValue()
        L_0x0064:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fling(androidx.compose.foundation.gestures.ScrollScope r7, float r8, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.material3.SnapFlingBehavior$fling$1 r0 = (androidx.compose.material3.SnapFlingBehavior$fling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SnapFlingBehavior$fling$1 r0 = new androidx.compose.material3.SnapFlingBehavior$fling$1
            r0.<init>(r6, r9)
        L_0x0019:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L_0x0032;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r0
            goto L_0x004c
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1 r3 = r2.motionScaleDuration
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            androidx.compose.material3.SnapFlingBehavior$fling$result$1 r4 = new androidx.compose.material3.SnapFlingBehavior$fling$result$1
            r5 = 0
            r4.<init>(r8, r2, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 1
            r9.label = r5
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r9)
            if (r7 != r1) goto L_0x004c
            return r1
        L_0x004c:
            androidx.compose.material3.AnimationResult r7 = (androidx.compose.material3.AnimationResult) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.fling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object shortSnap(ScrollScope $this$shortSnap, float velocity, Continuation<? super AnimationResult<Float, AnimationVector1D>> $completion) {
        float closestOffset = findClosestOffset(0.0f, this.lazyListState);
        return animateSnap($this$shortSnap, closestOffset, closestOffset, AnimationStateKt.AnimationState$default(0.0f, velocity, 0, 0, false, 28, (Object) null), this.snapAnimationSpec, $completion);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object longSnap(androidx.compose.foundation.gestures.ScrollScope r21, float r22, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r23) {
        /*
            r20 = this;
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.material3.SnapFlingBehavior$longSnap$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material3.SnapFlingBehavior$longSnap$1 r1 = (androidx.compose.material3.SnapFlingBehavior$longSnap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r20
            goto L_0x0021
        L_0x0019:
            androidx.compose.material3.SnapFlingBehavior$longSnap$1 r1 = new androidx.compose.material3.SnapFlingBehavior$longSnap$1
            r2 = r20
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r8 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            switch(r1) {
                case 0: goto L_0x0049;
                case 1: goto L_0x003a;
                case 2: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r8
            goto L_0x00c2
        L_0x003a:
            java.lang.Object r1 = r0.L$1
            androidx.compose.foundation.gestures.ScrollScope r1 = (androidx.compose.foundation.gestures.ScrollScope) r1
            java.lang.Object r2 = r0.L$0
            androidx.compose.material3.SnapFlingBehavior r2 = (androidx.compose.material3.SnapFlingBehavior) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r3 = r1
            r1 = r2
            r2 = r8
            goto L_0x008a
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r20
            r2 = r22
            r3 = r21
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r4 = r1.decayAnimationSpec
            r5 = 0
            float r4 = androidx.compose.animation.core.DecayAnimationSpecKt.calculateTargetValue(r4, r5, r2)
            float r4 = java.lang.Math.abs(r4)
            float r6 = r1.getItemSize()
            float r6 = r4 - r6
            float r4 = kotlin.ranges.RangesKt.coerceAtLeast((float) r6, (float) r5)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r6 = 1
            if (r5 != 0) goto L_0x006f
            r5 = r6
            goto L_0x0070
        L_0x006f:
            r5 = 0
        L_0x0070:
            if (r5 == 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            float r5 = java.lang.Math.signum(r2)
            float r4 = r4 * r5
        L_0x0079:
            r0.L$0 = r1
            r0.L$1 = r3
            r0.label = r6
            java.lang.Object r2 = r1.runApproach(r3, r4, r2, r0)
            if (r2 != r9) goto L_0x008a
            return r9
        L_0x008a:
            androidx.compose.material3.AnimationResult r2 = (androidx.compose.material3.AnimationResult) r2
            java.lang.Object r4 = r2.component1()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            androidx.compose.animation.core.AnimationState r2 = r2.component2()
            r18 = 30
            r19 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r10 = r2
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r10, (float) r11, (float) r12, (long) r13, (long) r15, (boolean) r17, (int) r18, (java.lang.Object) r19)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r6 = r1.snapAnimationSpec
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r2 = 2
            r0.label = r2
            r2 = r3
            r3 = r4
            r7 = r0
            java.lang.Object r1 = r1.animateSnap(r2, r3, r4, r5, r6, r7)
            if (r1 != r9) goto L_0x00c2
            return r9
        L_0x00c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.longSnap(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runApproach(androidx.compose.foundation.gestures.ScrollScope r20, float r21, float r22, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r23) {
        /*
            r19 = this;
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.material3.SnapFlingBehavior$runApproach$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material3.SnapFlingBehavior$runApproach$1 r1 = (androidx.compose.material3.SnapFlingBehavior$runApproach$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r19
            goto L_0x0021
        L_0x0019:
            androidx.compose.material3.SnapFlingBehavior$runApproach$1 r1 = new androidx.compose.material3.SnapFlingBehavior$runApproach$1
            r2 = r19
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            switch(r1) {
                case 0: goto L_0x003f;
                case 1: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            r1 = 0
            java.lang.Object r2 = r0.L$0
            androidx.compose.material3.SnapFlingBehavior r2 = (androidx.compose.material3.SnapFlingBehavior) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r9 = r2
            r2 = r7
            goto L_0x006e
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r7)
            r9 = r19
            r3 = r21
            r2 = r20
            r11 = r22
            r17 = 28
            r18 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            androidx.compose.animation.core.AnimationState r10 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r10, r11, r12, r14, r16, r17, r18)
            r11 = 0
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r5 = r9.decayAnimationSpec
            r0.L$0 = r9
            r1 = 1
            r0.label = r1
            r1 = r9
            r4 = r10
            r6 = r0
            java.lang.Object r1 = r1.animateDecay(r2, r3, r4, r5, r6)
            if (r1 != r8) goto L_0x006c
            return r8
        L_0x006c:
            r2 = r1
            r1 = r11
        L_0x006e:
            androidx.compose.material3.AnimationResult r2 = (androidx.compose.material3.AnimationResult) r2
            androidx.compose.animation.core.AnimationState r1 = r2.component2()
            java.lang.Object r2 = r1.getVelocity()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.foundation.lazy.LazyListState r3 = r9.lazyListState
            float r2 = r9.findClosestOffset(r2, r3)
            androidx.compose.material3.AnimationResult r3 = new androidx.compose.material3.AnimationResult
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r3.<init>(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.runApproach(androidx.compose.foundation.gestures.ScrollScope, float, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object other) {
        if (!(other instanceof SnapFlingBehavior) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).snapAnimationSpec, (Object) this.snapAnimationSpec) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).decayAnimationSpec, (Object) this.decayAnimationSpec) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).lazyListState, (Object) this.lazyListState) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).density, (Object) this.density)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((0 * 31) + this.snapAnimationSpec.hashCode()) * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.lazyListState.hashCode()) * 31) + this.density.hashCode();
    }

    private final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> $this$component1) {
        Intrinsics.checkNotNullParameter($this$component1, "<this>");
        return $this$component1.getStart();
    }

    private final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> $this$component2) {
        Intrinsics.checkNotNullParameter($this$component2, "<this>");
        return $this$component2.getEndInclusive();
    }

    private static final boolean findClosestOffset$isValidDistance(float $this$findClosestOffset_u24isValidDistance) {
        if (!($this$findClosestOffset_u24isValidDistance == Float.POSITIVE_INFINITY)) {
            if (!($this$findClosestOffset_u24isValidDistance == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    private static final ClosedFloatingPointRange<Float> findClosestOffset$calculateSnappingOffsetBounds(LazyListState $lazyListState, SnapFlingBehavior this$0) {
        float lowerBoundOffset = Float.NEGATIVE_INFINITY;
        float upperBoundOffset = Float.POSITIVE_INFINITY;
        LazyListLayoutInfo $this$findClosestOffset_u24calculateSnappingOffsetBounds_u24lambda_u248 = $lazyListState.getLayoutInfo();
        List $this$fastForEach$iv = $this$findClosestOffset_u24calculateSnappingOffsetBounds_u24lambda_u248.getVisibleItemsInfo();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            float offset = this$0.calculateDistanceToDesiredSnapPosition($this$findClosestOffset_u24calculateSnappingOffsetBounds_u24lambda_u248, $this$fastForEach$iv.get(index$iv));
            if (offset <= 0.0f && offset > lowerBoundOffset) {
                lowerBoundOffset = offset;
            }
            if (offset >= 0.0f && offset < upperBoundOffset) {
                upperBoundOffset = offset;
            }
        }
        return RangesKt.rangeTo(lowerBoundOffset, upperBoundOffset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        if (java.lang.Math.abs(r0) <= java.lang.Math.abs(r1)) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final float findClosestOffset(float r8, androidx.compose.foundation.lazy.LazyListState r9) {
        /*
            r7 = this;
            kotlin.ranges.ClosedFloatingPointRange r0 = findClosestOffset$calculateSnappingOffsetBounds(r9, r7)
            java.lang.Comparable r1 = r7.component1(r0)
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Comparable r0 = r7.component2(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r2 = java.lang.Math.signum(r8)
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0025
            r4 = r5
            goto L_0x0026
        L_0x0025:
            r4 = r6
        L_0x0026:
            if (r4 == 0) goto L_0x0036
            float r2 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r1)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0035
            goto L_0x0041
        L_0x0035:
            goto L_0x004d
        L_0x0036:
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x003e
            r4 = r5
            goto L_0x003f
        L_0x003e:
            r4 = r6
        L_0x003f:
            if (r4 == 0) goto L_0x0043
        L_0x0041:
            r2 = r0
            goto L_0x0050
        L_0x0043:
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r5 = r6
        L_0x004b:
            if (r5 == 0) goto L_0x004f
        L_0x004d:
            r2 = r1
            goto L_0x0050
        L_0x004f:
            r2 = r3
        L_0x0050:
            boolean r4 = findClosestOffset$isValidDistance(r2)
            if (r4 == 0) goto L_0x0059
            r3 = r2
            goto L_0x005a
        L_0x0059:
        L_0x005a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.findClosestOffset(float, androidx.compose.foundation.lazy.LazyListState):float");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>, code=androidx.compose.animation.core.AnimationState, for r10v0, types: [androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>, androidx.compose.animation.core.AnimationState, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateDecay(androidx.compose.foundation.gestures.ScrollScope r8, float r9, androidx.compose.animation.core.AnimationState r10, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r11, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.SnapFlingBehavior$animateDecay$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material3.SnapFlingBehavior$animateDecay$1 r0 = (androidx.compose.material3.SnapFlingBehavior$animateDecay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SnapFlingBehavior$animateDecay$1 r0 = new androidx.compose.material3.SnapFlingBehavior$animateDecay$1
            r0.<init>(r7, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            switch(r2) {
                case 0: goto L_0x003b;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            float r8 = r12.F$0
            java.lang.Object r9 = r12.L$1
            kotlin.jvm.internal.Ref$FloatRef r9 = (kotlin.jvm.internal.Ref.FloatRef) r9
            java.lang.Object r10 = r12.L$0
            androidx.compose.animation.core.AnimationState r10 = (androidx.compose.animation.core.AnimationState) r10
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0072
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            java.lang.Object r4 = r10.getVelocity()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r5 = 1
            if (r4 != 0) goto L_0x0058
            r4 = r5
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            r4 = r4 ^ r5
            androidx.compose.material3.SnapFlingBehavior$animateDecay$2 r6 = new androidx.compose.material3.SnapFlingBehavior$animateDecay$2
            r6.<init>(r9, r2, r3, r8)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r12.L$0 = r10
            r12.L$1 = r3
            r12.F$0 = r9
            r12.label = r5
            java.lang.Object r8 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay(r10, r11, (boolean) r4, r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r12)
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r8 = r9
            r9 = r3
        L_0x0072:
            androidx.compose.material3.AnimationResult r11 = new androidx.compose.material3.AnimationResult
            float r1 = r9.element
            float r1 = r8 - r1
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r11.<init>(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.animateDecay(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> $this$animateDecay_u24consumeDelta, ScrollScope $this_animateDecay, float delta) {
        if (Math.abs(delta - $this_animateDecay.scrollBy(delta)) > 0.5f) {
            $this$animateDecay_u24consumeDelta.cancelAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateSnap(androidx.compose.foundation.gestures.ScrollScope r23, float r24, float r25, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r26, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r27, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r28) {
        /*
            r22 = this;
            r0 = r28
            boolean r1 = r0 instanceof androidx.compose.material3.SnapFlingBehavior$animateSnap$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material3.SnapFlingBehavior$animateSnap$1 r1 = (androidx.compose.material3.SnapFlingBehavior$animateSnap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r22
            goto L_0x0021
        L_0x0019:
            androidx.compose.material3.SnapFlingBehavior$animateSnap$1 r1 = new androidx.compose.material3.SnapFlingBehavior$animateSnap$1
            r2 = r22
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            switch(r4) {
                case 0: goto L_0x004a;
                case 1: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            float r2 = r0.F$1
            float r3 = r0.F$0
            java.lang.Object r4 = r0.L$2
            kotlin.jvm.internal.Ref$FloatRef r4 = (kotlin.jvm.internal.Ref.FloatRef) r4
            java.lang.Object r5 = r0.L$1
            androidx.compose.animation.core.AnimationState r5 = (androidx.compose.animation.core.AnimationState) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.SnapFlingBehavior r6 = (androidx.compose.material3.SnapFlingBehavior) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r5
            r14 = r6
            goto L_0x00ab
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = r22
            r2 = r24
            r5 = r26
            r4 = r23
            r7 = r25
            r24 = r27
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            java.lang.Object r9 = r5.getVelocity()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            java.lang.Object r11 = r5.getVelocity()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            r12 = 0
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            r12 = 1
            if (r11 != 0) goto L_0x0080
            r11 = r12
            goto L_0x0081
        L_0x0080:
            r11 = 0
        L_0x0081:
            r11 = r11 ^ r12
            androidx.compose.material3.SnapFlingBehavior$animateSnap$2 r13 = new androidx.compose.material3.SnapFlingBehavior$animateSnap$2
            r13.<init>(r6, r7, r8, r4)
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r8
            r0.F$0 = r2
            r0.F$1 = r9
            r0.label = r12
            r22 = r5
            r23 = r10
            r25 = r11
            r26 = r13
            r27 = r0
            java.lang.Object r4 = androidx.compose.animation.core.SuspendAnimationKt.animateTo(r22, r23, r24, r25, r26, r27)
            if (r4 != r3) goto L_0x00a6
            return r3
        L_0x00a6:
            r3 = r2
            r15 = r5
            r14 = r6
            r4 = r8
            r2 = r9
        L_0x00ab:
            java.lang.Object r5 = r15.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r16 = r14.coerceToTarget(r5, r2)
            androidx.compose.material3.AnimationResult r13 = new androidx.compose.material3.AnimationResult
            float r5 = r4.element
            float r5 = r3 - r5
            java.lang.Float r12 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r17 = 29
            r18 = 0
            r6 = 0
            r8 = 0
            r10 = 0
            r19 = 0
            r5 = r15
            r7 = r16
            r20 = r12
            r12 = r19
            r21 = r13
            r13 = r17
            r17 = r14
            r14 = r18
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r5, (float) r6, (float) r7, (long) r8, (long) r10, (boolean) r12, (int) r13, (java.lang.Object) r14)
            r7 = r20
            r6 = r21
            r6.<init>(r7, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.animateSnap(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final float coerceToTarget(float $this$coerceToTarget, float target) {
        if (target == 0.0f) {
            return 0.0f;
        }
        return target > 0.0f ? RangesKt.coerceAtMost($this$coerceToTarget, target) : RangesKt.coerceAtLeast($this$coerceToTarget, target);
    }

    private final float calculateDistanceToDesiredSnapPosition(LazyListLayoutInfo layoutInfo, LazyListItemInfo item) {
        LazyListLayoutInfo $this$calculateDistanceToDesiredSnapPosition_u24lambda_u249 = layoutInfo;
        float f = (float) 2;
        return ((float) item.getOffset()) - ((((float) ((getSingleAxisViewportSize($this$calculateDistanceToDesiredSnapPosition_u24lambda_u249) - $this$calculateDistanceToDesiredSnapPosition_u24lambda_u249.getBeforeContentPadding()) - $this$calculateDistanceToDesiredSnapPosition_u24lambda_u249.getAfterContentPadding())) / f) - (((float) item.getSize()) / f));
    }

    private final int getSingleAxisViewportSize(LazyListLayoutInfo $this$singleAxisViewportSize) {
        return $this$singleAxisViewportSize.getOrientation() == Orientation.Vertical ? IntSize.m6003getHeightimpl($this$singleAxisViewportSize.m678getViewportSizeYbymL2g()) : IntSize.m6004getWidthimpl($this$singleAxisViewportSize.m678getViewportSizeYbymL2g());
    }
}
