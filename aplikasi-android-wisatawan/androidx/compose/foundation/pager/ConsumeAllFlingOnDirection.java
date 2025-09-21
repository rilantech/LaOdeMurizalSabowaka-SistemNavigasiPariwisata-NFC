package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0013\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/pager/ConsumeAllFlingOnDirection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "consumeOnOrientation", "consumeOnOrientation-8S9VItk", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "consumeOnOrientation-QWom1Mo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
final class ConsumeAllFlingOnDirection implements NestedScrollConnection {
    private final Orientation orientation;

    public ConsumeAllFlingOnDirection(Orientation orientation2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        this.orientation = orientation2;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: consumeOnOrientation-QWom1Mo  reason: not valid java name */
    public final long m809consumeOnOrientationQWom1Mo(long $this$consumeOnOrientation_u2dQWom1Mo, Orientation orientation2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        if (orientation2 == Orientation.Vertical) {
            return Velocity.m6065copyOhffZ5M$default($this$consumeOnOrientation_u2dQWom1Mo, 0.0f, 0.0f, 2, (Object) null);
        }
        return Velocity.m6065copyOhffZ5M$default($this$consumeOnOrientation_u2dQWom1Mo, 0.0f, 0.0f, 1, (Object) null);
    }

    /* renamed from: consumeOnOrientation-8S9VItk  reason: not valid java name */
    public final long m808consumeOnOrientation8S9VItk(long $this$consumeOnOrientation_u2d8S9VItk, Orientation orientation2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        if (orientation2 == Orientation.Vertical) {
            return Offset.m2997copydBAh8RU$default($this$consumeOnOrientation_u2d8S9VItk, 0.0f, 0.0f, 2, (Object) null);
        }
        return Offset.m2997copydBAh8RU$default($this$consumeOnOrientation_u2d8S9VItk, 0.0f, 0.0f, 1, (Object) null);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m811onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m4372equalsimpl0(source, NestedScrollSource.Companion.m4378getFlingWNlRxjI())) {
            return m808consumeOnOrientation8S9VItk(available, this.orientation);
        }
        return Offset.Companion.m3019getZeroF1C5BW0();
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m810onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        return Velocity.m6060boximpl(m809consumeOnOrientationQWom1Mo(available, this.orientation));
    }
}
