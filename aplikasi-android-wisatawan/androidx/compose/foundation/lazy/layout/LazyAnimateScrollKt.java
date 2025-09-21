package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Dp;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.ConnectionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\b\u001a%\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "MinimumDistance", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;", "index", "", "scrollOffset", "(Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyAnimateScroll.kt */
public final class LazyAnimateScrollKt {
    /* access modifiers changed from: private */
    public static final float BoundDistance = Dp.m5844constructorimpl((float) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final float MinimumDistance = Dp.m5844constructorimpl((float) 50);
    /* access modifiers changed from: private */
    public static final float TargetDistance = Dp.m5844constructorimpl((float) DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);

    private static final void debugLog(Function0<String> generateMsg) {
    }

    public static final Object animateScrollToItem(LazyAnimateScrollScope $this$animateScrollToItem, int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object scroll = $this$animateScrollToItem.scroll(new LazyAnimateScrollKt$animateScrollToItem$2(index, $this$animateScrollToItem, scrollOffset, (Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2>) null), $completion);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }
}
