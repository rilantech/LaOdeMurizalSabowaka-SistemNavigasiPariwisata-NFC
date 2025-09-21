package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/gestures/ScrollableKt$scrollableNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollableKt$scrollableNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ State<ScrollingLogic> $scrollLogic;

    ScrollableKt$scrollableNestedScrollConnection$1(State<ScrollingLogic> $scrollLogic2, boolean $enabled2) {
        this.$scrollLogic = $scrollLogic2;
        this.$enabled = $enabled2;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2072onPreScrollOzD1aCk(long available, int source) {
        if (NestedScrollSource.m6082equalsimpl0(source, NestedScrollSource.Companion.m6088getFlingWNlRxjI())) {
            this.$scrollLogic.getValue().registerNestedFling(true);
        }
        return Offset.Companion.m4729getZeroF1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2071onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.$enabled) {
            return this.$scrollLogic.getValue().m2076performRawScrollMKHz9U(available);
        }
        return Offset.Companion.m4729getZeroF1C5BW0();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2070onPostFlingRZ2iAVY(long r4, long r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r8) {
        /*
            r3 = this;
            boolean r4 = r8 instanceof androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            if (r4 == 0) goto L_0x0014
            r4 = r8
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r4 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) r4
            int r5 = r4.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r0
            if (r5 == 0) goto L_0x0014
            int r5 = r4.label
            int r5 = r5 - r0
            r4.label = r5
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r4 = new androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            r4.<init>(r3, r8)
        L_0x0019:
            java.lang.Object r5 = r4.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            switch(r0) {
                case 0: goto L_0x0037;
                case 1: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x002c:
            long r6 = r4.J$0
            java.lang.Object r8 = r4.L$0
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1 r8 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1) r8
            kotlin.ResultKt.throwOnFailure(r5)
            r1 = r5
            goto L_0x0056
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0 = r3
            boolean r1 = r0.$enabled
            if (r1 == 0) goto L_0x0062
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r1 = r0.$scrollLogic
            java.lang.Object r1 = r1.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            r4.L$0 = r0
            r4.J$0 = r6
            r2 = 1
            r4.label = r2
            java.lang.Object r1 = r1.m2074doFlingAnimationQWom1Mo(r6, r4)
            if (r1 != r8) goto L_0x0055
            return r8
        L_0x0055:
            r8 = r0
        L_0x0056:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r0 = r1.m7788unboximpl()
            long r6 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r6, r0)
            r0 = r8
            goto L_0x0068
        L_0x0062:
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r6.m7790getZero9UxMQ8M()
        L_0x0068:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m7770boximpl(r6)
            androidx.compose.runtime.State<androidx.compose.foundation.gestures.ScrollingLogic> r7 = r0.$scrollLogic
            r6.m7788unboximpl()
            r8 = 0
            java.lang.Object r7 = r7.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
            r1 = 0
            r7.registerNestedFling(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1.m2070onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
