package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J1\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010\rH@ø\u0001\u0001¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J)\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b3\u00104J-\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J%\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    /* access modifiers changed from: private */
    public WindowInsetsAnimationController animationController;
    /* access modifiers changed from: private */
    public Job animationJob;
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets windowInsets2, View view2, SideCalculator sideCalculator2, Density density2) {
        Intrinsics.checkNotNullParameter(windowInsets2, "windowInsets");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(sideCalculator2, "sideCalculator");
        Intrinsics.checkNotNullParameter(density2, "density");
        this.windowInsets = windowInsets2;
        this.view = view2;
        this.sideCalculator = sideCalculator2;
        this.density = density2;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1, (Interpolator) null, this.cancellationSignal, (WindowInsetsAnimationControlListener) this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> $completion) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellable$iv.initCancellability();
        this.continuation = cancellable$iv;
        requestAnimationController();
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return result;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2358onPreScrollOzD1aCk(long available, int source) {
        return m2354scroll8S9VItk(available, this.sideCalculator.hideMotion(Offset.m4713getXimpl(available), Offset.m4714getYimpl(available)));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2356onPostScrollDzOQY0M(long consumed, long available, int source) {
        return m2354scroll8S9VItk(available, this.sideCalculator.showMotion(Offset.m4713getXimpl(available), Offset.m4714getYimpl(available)));
    }

    /* renamed from: scroll-8S9VItk  reason: not valid java name */
    private final long m2354scroll8S9VItk(long available, float scrollAmount) {
        Job it = this.animationJob;
        if (it != null) {
            it.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }
        WindowInsetsAnimationController animationController2 = this.animationController;
        boolean z = true;
        if (!(scrollAmount == 0.0f)) {
            boolean isVisible = this.windowInsets.isVisible();
            if (scrollAmount <= 0.0f) {
                z = false;
            }
            if (!(isVisible == z && animationController2 == null)) {
                if (animationController2 == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.m2295consumedOffsetsMKHz9U(available);
                }
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets hiddenStateInsets = animationController2.getHiddenStateInsets();
                Intrinsics.checkNotNullExpressionValue(hiddenStateInsets, "animationController.hiddenStateInsets");
                int hidden = sideCalculator2.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator3 = this.sideCalculator;
                Insets shownStateInsets = animationController2.getShownStateInsets();
                Intrinsics.checkNotNullExpressionValue(shownStateInsets, "animationController.shownStateInsets");
                int shown = sideCalculator3.valueOf(shownStateInsets);
                Insets currentInsets = animationController2.getCurrentInsets();
                Intrinsics.checkNotNullExpressionValue(currentInsets, "animationController.currentInsets");
                int current = this.sideCalculator.valueOf(currentInsets);
                if (current == (scrollAmount > 0.0f ? shown : hidden)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m4729getZeroF1C5BW0();
                }
                float total = ((float) current) + scrollAmount + this.partialConsumption;
                int next = RangesKt.coerceIn(MathKt.roundToInt(total), hidden, shown);
                this.partialConsumption = total - ((float) MathKt.roundToInt(total));
                if (next != current) {
                    animationController2.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, next), 1.0f, 0.0f);
                }
                return this.sideCalculator.m2295consumedOffsetsMKHz9U(available);
            }
        }
        return Offset.Companion.m4729getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m2357onPreFlingQWom1Mo(long available, Continuation<? super Velocity> $completion) {
        return m2353flinghuYlsQE(available, this.sideCalculator.hideMotion(Velocity.m7779getXimpl(available), Velocity.m7780getYimpl(available)), false, $completion);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m2355onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        return m2353flinghuYlsQE(available, this.sideCalculator.showMotion(Velocity.m7779getXimpl(available), Velocity.m7780getYimpl(available)), true, $completion);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* renamed from: fling-huYlsQE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m2353flinghuYlsQE(long r25, float r27, boolean r28, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r29) {
        /*
            r24 = this;
            r0 = r29
            boolean r1 = r0 instanceof androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r1 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r24
            goto L_0x0021
        L_0x0019:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r1 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            r2 = r24
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            r5 = 0
            r7 = 0
            r8 = 1
            switch(r4) {
                case 0: goto L_0x0060;
                case 1: goto L_0x0051;
                case 2: goto L_0x0042;
                case 3: goto L_0x0037;
                default: goto L_0x002f;
            }
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            long r2 = r0.J$0
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0162
        L_0x0042:
            long r2 = r0.J$0
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r4 = (kotlin.jvm.internal.Ref.FloatRef) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r5 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r5
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01a8
        L_0x0051:
            float r2 = r0.F$0
            long r9 = r0.J$0
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r11 = r2
            r2 = r4
            r4 = r1
            goto L_0x00ae
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r1)
            r2 = r24
            r4 = r28
            r9 = r25
            r11 = r27
            kotlinx.coroutines.Job r12 = r2.animationJob
            if (r12 == 0) goto L_0x0079
            androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException r13 = new androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException
            r13.<init>()
            java.util.concurrent.CancellationException r13 = (java.util.concurrent.CancellationException) r13
            r12.cancel((java.util.concurrent.CancellationException) r13)
        L_0x0079:
            r2.animationJob = r5
            r2.partialConsumption = r7
            int r12 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0083
            r12 = r8
            goto L_0x0084
        L_0x0083:
            r12 = 0
        L_0x0084:
            if (r12 == 0) goto L_0x0088
            if (r4 == 0) goto L_0x0094
        L_0x0088:
            android.view.WindowInsetsAnimationController r12 = r2.animationController
            if (r12 != 0) goto L_0x009f
            androidx.compose.foundation.layout.AndroidWindowInsets r12 = r2.windowInsets
            boolean r12 = r12.isVisible()
            if (r12 != r4) goto L_0x009f
        L_0x0094:
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.Companion
            long r2 = r2.m7790getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m7770boximpl(r2)
            return r2
        L_0x009f:
            r0.L$0 = r2
            r0.J$0 = r9
            r0.F$0 = r11
            r0.label = r8
            java.lang.Object r4 = r2.getAnimationController(r0)
            if (r4 != r3) goto L_0x00ae
            return r3
        L_0x00ae:
            android.view.WindowInsetsAnimationController r4 = (android.view.WindowInsetsAnimationController) r4
            if (r4 != 0) goto L_0x00bd
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.Companion
            long r2 = r2.m7790getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m7770boximpl(r2)
            return r2
        L_0x00bd:
            androidx.compose.foundation.layout.SideCalculator r12 = r2.sideCalculator
            android.graphics.Insets r13 = r4.getHiddenStateInsets()
            java.lang.String r14 = "animationController.hiddenStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            int r14 = r12.valueOf(r13)
            androidx.compose.foundation.layout.SideCalculator r12 = r2.sideCalculator
            android.graphics.Insets r13 = r4.getShownStateInsets()
            java.lang.String r15 = "animationController.shownStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r15)
            int r13 = r12.valueOf(r13)
            android.graphics.Insets r12 = r4.getCurrentInsets()
            java.lang.String r15 = "animationController.currentInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            androidx.compose.foundation.layout.SideCalculator r15 = r2.sideCalculator
            int r12 = r15.valueOf(r12)
            int r15 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r15 > 0) goto L_0x00f0
            if (r12 == r14) goto L_0x00f6
        L_0x00f0:
            int r15 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r15 < 0) goto L_0x010b
            if (r12 != r13) goto L_0x010b
        L_0x00f6:
            if (r12 != r13) goto L_0x00fa
            r6 = r8
            goto L_0x00fb
        L_0x00fa:
            r6 = 0
        L_0x00fb:
            r4.finish(r6)
            r2.animationController = r5
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.Companion
            long r2 = r2.m7790getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m7770boximpl(r2)
            return r2
        L_0x010b:
            androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec r5 = new androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec
            androidx.compose.ui.unit.Density r15 = r2.density
            r5.<init>(r15)
            float r15 = (float) r12
            float r16 = r5.flingDistance(r11)
            float r16 = r15 + r16
            float r15 = (float) r14
            float r15 = r16 - r15
            int r6 = r13 - r14
            float r6 = (float) r6
            float r15 = r15 / r6
            r6 = 1056964608(0x3f000000, float:0.5)
            int r6 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0128
            r6 = r8
            goto L_0x0129
        L_0x0128:
            r6 = 0
        L_0x0129:
            if (r6 == 0) goto L_0x012d
            r15 = r13
            goto L_0x012e
        L_0x012d:
            r15 = r14
        L_0x012e:
            float r8 = (float) r13
            int r8 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x016d
            float r8 = (float) r14
            int r8 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x013a
            r8 = r12
            goto L_0x016e
        L_0x013a:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3 r5 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3
            if (r6 == 0) goto L_0x0141
            r18 = 1
            goto L_0x0143
        L_0x0141:
            r18 = 0
        L_0x0143:
            r19 = 0
            r8 = r12
            r12 = r5
            r13 = r2
            r14 = r8
            r16 = r11
            r17 = r4
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r2
            r0.J$0 = r9
            r4 = 3
            r0.label = r4
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r4 != r3) goto L_0x0160
            return r3
        L_0x0160:
            r4 = r2
            r2 = r9
        L_0x0162:
            androidx.compose.foundation.layout.SideCalculator r5 = r4.sideCalculator
            long r5 = r5.m2296consumedVelocityQWom1Mo(r2, r7)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m7770boximpl(r5)
            return r5
        L_0x016d:
            r8 = r12
        L_0x016e:
            kotlin.jvm.internal.Ref$FloatRef r7 = new kotlin.jvm.internal.Ref$FloatRef
            r7.<init>()
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2 r23 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2
            if (r6 == 0) goto L_0x017a
            r21 = 1
            goto L_0x017c
        L_0x017a:
            r21 = 0
        L_0x017c:
            r22 = 0
            r12 = r23
            r6 = r13
            r13 = r2
            r17 = r14
            r14 = r8
            r15 = r11
            r16 = r5
            r18 = r6
            r19 = r7
            r20 = r4
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r4 = r23
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r2
            r0.L$1 = r7
            r0.J$0 = r9
            r5 = 2
            r0.label = r5
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r4, r0)
            if (r4 != r3) goto L_0x01a5
            return r3
        L_0x01a5:
            r5 = r2
            r4 = r7
            r2 = r9
        L_0x01a8:
            androidx.compose.foundation.layout.SideCalculator r6 = r5.sideCalculator
            float r7 = r4.element
            long r6 = r6.m2296consumedVelocityQWom1Mo(r2, r7)
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m7770boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m2353flinghuYlsQE(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void adjustInsets(float inset) {
        WindowInsetsAnimationController it = this.animationController;
        if (it != null) {
            Insets currentInsets = it.getCurrentInsets();
            Intrinsics.checkNotNullExpressionValue(currentInsets, "it.currentInsets");
            it.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, MathKt.roundToInt(inset)), 1.0f, 0.0f);
        }
    }

    public void onReady(WindowInsetsAnimationController controller, int types) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.animationController = controller;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(controller, WindowInsetsNestedScrollConnection$onReady$1.INSTANCE);
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$dispose$1.INSTANCE);
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController animationController2 = this.animationController;
        if (animationController2 != null) {
            animationController2.finish(!Intrinsics.areEqual((Object) animationController2.getCurrentInsets(), (Object) animationController2.getHiddenStateInsets()));
        }
    }

    public void onFinished(WindowInsetsAnimationController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        animationEnded();
    }

    public void onCancelled(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        if (r0.isReady() == true) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void animationEnded() {
        /*
            r4 = this;
            android.view.WindowInsetsAnimationController r0 = r4.animationController
            r1 = 0
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isReady()
            r2 = 1
            if (r0 != r2) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r2 = r1
        L_0x000e:
            if (r2 == 0) goto L_0x001d
            android.view.WindowInsetsAnimationController r0 = r4.animationController
            if (r0 == 0) goto L_0x001d
            androidx.compose.foundation.layout.AndroidWindowInsets r2 = r4.windowInsets
            boolean r2 = r2.isVisible()
            r0.finish(r2)
        L_0x001d:
            r0 = 0
            r4.animationController = r0
            kotlinx.coroutines.CancellableContinuation<? super android.view.WindowInsetsAnimationController> r2 = r4.continuation
            if (r2 == 0) goto L_0x002b
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1 r3 = androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.resume(r0, r3)
        L_0x002b:
            r4.continuation = r0
            kotlinx.coroutines.Job r2 = r4.animationJob
            if (r2 == 0) goto L_0x003b
            androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException r3 = new androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException
            r3.<init>()
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
            r2.cancel((java.util.concurrent.CancellationException) r3)
        L_0x003b:
            r4.animationJob = r0
            r0 = 0
            r4.partialConsumption = r0
            r4.isControllerRequested = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.animationEnded():void");
    }
}
