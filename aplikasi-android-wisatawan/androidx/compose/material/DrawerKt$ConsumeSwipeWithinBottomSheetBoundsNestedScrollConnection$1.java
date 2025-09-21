package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\rH\u0003ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u0007H\u0003ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\r*\u00020\u0019H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001f"}, d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
public final class DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ AnchoredDraggableState<?> $state;
    private final Orientation orientation = Orientation.Vertical;

    DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(AnchoredDraggableState<?> $state2) {
        this.$state = $state2;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1294onPreScrollOzD1aCk(long available, int source) {
        float delta = offsetToFloat(available);
        if (delta >= 0.0f || !NestedScrollSource.m4372equalsimpl0(source, NestedScrollSource.Companion.m4377getDragWNlRxjI())) {
            return Offset.Companion.m3019getZeroF1C5BW0();
        }
        return toOffset(this.$state.dispatchRawDelta(delta));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1292onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m4372equalsimpl0(source, NestedScrollSource.Companion.m4377getDragWNlRxjI())) {
            return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
        }
        return Offset.Companion.m3019getZeroF1C5BW0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1293onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L_0x0019:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L_0x0033;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            long r7 = r9.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x005e
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            float r3 = r2.velocityToFloat(r7)
            androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
            float r4 = r4.requireOffset()
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x005f
            androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
            float r5 = r5.getMinOffset()
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x005f
            androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
            r9.J$0 = r7
            r5 = 1
            r9.label = r5
            java.lang.Object r2 = r4.settle(r3, r9)
            if (r2 != r1) goto L_0x005e
            return r1
        L_0x005e:
            goto L_0x0065
        L_0x005f:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m6080getZero9UxMQ8M()
        L_0x0065:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6060boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.m1293onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1291onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L_0x0014
            r5 = r9
            androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r0
            if (r6 == 0) goto L_0x0014
            int r6 = r5.label
            int r6 = r6 - r0
            r5.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L_0x0019:
            java.lang.Object r6 = r5.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            switch(r0) {
                case 0: goto L_0x0032;
                case 1: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002c:
            long r7 = r5.J$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r4
            androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
            float r2 = r0.velocityToFloat(r7)
            r5.J$0 = r7
            r3 = 1
            r5.label = r3
            java.lang.Object r0 = r1.settle(r2, r5)
            if (r0 != r9) goto L_0x0048
            return r9
        L_0x0048:
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6060boximpl(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.m1291onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long toOffset(float $this$toOffset) {
        float f = 0.0f;
        float f2 = this.orientation == Orientation.Horizontal ? $this$toOffset : 0.0f;
        if (this.orientation == Orientation.Vertical) {
            f = $this$toOffset;
        }
        return OffsetKt.Offset(f2, f);
    }

    private final float velocityToFloat(long $this$toFloat) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6069getXimpl($this$toFloat) : Velocity.m6070getYimpl($this$toFloat);
    }

    private final float offsetToFloat(long $this$toFloat) {
        return this.orientation == Orientation.Horizontal ? Offset.m3003getXimpl($this$toFloat) : Offset.m3004getYimpl($this$toFloat);
    }
}
