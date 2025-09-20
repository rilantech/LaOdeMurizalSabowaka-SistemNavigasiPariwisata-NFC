package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    Object m6063onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return Velocity.m7770boximpl(Velocity.Companion.m7790getZero9UxMQ8M());
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    Object m6065onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return Velocity.m7770boximpl(Velocity.Companion.m7790getZero9UxMQ8M());
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NestedScrollModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
        public static long m6070onPreScrollOzD1aCk(NestedScrollConnection $this, long available, int source) {
            return NestedScrollConnection.super.m6066onPreScrollOzD1aCk(available, source);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
        public static long m6068onPostScrollDzOQY0M(NestedScrollConnection $this, long consumed, long available, int source) {
            return NestedScrollConnection.super.m6064onPostScrollDzOQY0M(consumed, available, source);
        }

        @Deprecated
        /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
        public static Object m6069onPreFlingQWom1Mo(NestedScrollConnection $this, long available, Continuation<? super Velocity> $completion) {
            return NestedScrollConnection.super.m6065onPreFlingQWom1Mo(available, $completion);
        }

        @Deprecated
        /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
        public static Object m6067onPostFlingRZ2iAVY(NestedScrollConnection $this, long consumed, long available, Continuation<? super Velocity> $completion) {
            return NestedScrollConnection.super.m6063onPostFlingRZ2iAVY(consumed, available, $completion);
        }
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    long m6066onPreScrollOzD1aCk(long available, int source) {
        return Offset.Companion.m4729getZeroF1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    long m6064onPostScrollDzOQY0M(long consumed, long available, int source) {
        return Offset.Companion.m4729getZeroF1C5BW0();
    }
}
