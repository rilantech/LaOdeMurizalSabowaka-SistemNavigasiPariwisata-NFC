package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material3/SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ Function1<Float, Unit> $onFling;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ SheetState $sheetState;

    SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(SheetState $sheetState2, Function1<? super Float, Unit> $onFling2, Orientation $orientation2) {
        this.$sheetState = $sheetState2;
        this.$onFling = $onFling2;
        this.$orientation = $orientation2;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m1965onPreScrollOzD1aCk(long available, int source) {
        float delta = offsetToFloat(available);
        if (delta >= 0.0f || !NestedScrollSource.m4372equalsimpl0(source, NestedScrollSource.Companion.m4377getDragWNlRxjI())) {
            return Offset.Companion.m3019getZeroF1C5BW0();
        }
        return toOffset(this.$sheetState.getSwipeableState$material3_release().dispatchRawDelta(delta));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1963onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m4372equalsimpl0(source, NestedScrollSource.Companion.m4377getDragWNlRxjI())) {
            return toOffset(this.$sheetState.getSwipeableState$material3_release().dispatchRawDelta(offsetToFloat(available)));
        }
        return Offset.Companion.m3019getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m1964onPreFlingQWom1Mo(long available, Continuation<? super Velocity> $completion) {
        long j;
        float toFling = velocityToFloat(available);
        float currentOffset = this.$sheetState.requireOffset();
        if (toFling >= 0.0f || currentOffset <= this.$sheetState.getSwipeableState$material3_release().getMinOffset()) {
            j = Velocity.Companion.m6080getZero9UxMQ8M();
        } else {
            this.$onFling.invoke(Boxing.boxFloat(toFling));
            j = available;
        }
        return Velocity.m6060boximpl(j);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m1962onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        this.$onFling.invoke(Boxing.boxFloat(velocityToFloat(available)));
        return Velocity.m6060boximpl(available);
    }

    private final long toOffset(float $this$toOffset) {
        float f = 0.0f;
        float f2 = this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f;
        if (this.$orientation == Orientation.Vertical) {
            f = $this$toOffset;
        }
        return OffsetKt.Offset(f2, f);
    }

    private final float velocityToFloat(long $this$toFloat) {
        return this.$orientation == Orientation.Horizontal ? Velocity.m6069getXimpl($this$toFloat) : Velocity.m6070getYimpl($this$toFloat);
    }

    private final float offsetToFloat(long $this$toFloat) {
        return this.$orientation == Orientation.Horizontal ? Offset.m3003getXimpl($this$toFloat) : Offset.m3004getYimpl($this$toFloat);
    }
}
