package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"androidx/compose/material3/PinnedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class PinnedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ PinnedScrollBehavior this$0;

    PinnedScrollBehavior$nestedScrollConnection$1(PinnedScrollBehavior $receiver) {
        this.this$0 = $receiver;
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1906onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.Companion.m3019getZeroF1C5BW0();
        }
        if (!(Offset.m3004getYimpl(consumed) == 0.0f) || Offset.m3004getYimpl(available) <= 0.0f) {
            TopAppBarState state = this.this$0.getState();
            state.setContentOffset(state.getContentOffset() + Offset.m3004getYimpl(consumed));
        } else {
            this.this$0.getState().setContentOffset(0.0f);
        }
        return Offset.Companion.m3019getZeroF1C5BW0();
    }
}
