package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u000201B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "view", "Landroid/view/View;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroid/view/View;)V", "averagePrecomposeTimeNs", "", "averagePremeasureTimeNs", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "isActive", "", "prefetchRequests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$PrefetchRequest;", "prefetchScheduled", "calculateAverageTime", "new", "current", "doFrame", "", "frameTimeNanos", "enoughTimeLeft", "now", "nextFrame", "average", "onAbandoned", "onForgotten", "onRemembered", "run", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Companion", "PrefetchRequest", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetcher.android.kt */
public final class LazyLayoutPrefetcher implements RememberObserver, LazyLayoutPrefetchState.Prefetcher, Runnable, Choreographer.FrameCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static long frameIntervalNs;
    private long averagePrecomposeTimeNs;
    private long averagePremeasureTimeNs;
    private final Choreographer choreographer = Choreographer.getInstance();
    private boolean isActive;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final MutableVector<PrefetchRequest> prefetchRequests = new MutableVector<>(new PrefetchRequest[16], 0);
    private boolean prefetchScheduled;
    private final LazyLayoutPrefetchState prefetchState;
    private final SubcomposeLayoutState subcomposeLayoutState;
    private final View view;

    public LazyLayoutPrefetcher(LazyLayoutPrefetchState prefetchState2, SubcomposeLayoutState subcomposeLayoutState2, LazyLayoutItemContentFactory itemContentFactory2, View view2) {
        Intrinsics.checkNotNullParameter(prefetchState2, "prefetchState");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState2, "subcomposeLayoutState");
        Intrinsics.checkNotNullParameter(itemContentFactory2, "itemContentFactory");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.prefetchState = prefetchState2;
        this.subcomposeLayoutState = subcomposeLayoutState2;
        this.itemContentFactory = itemContentFactory2;
        this.view = view2;
        Companion.calculateFrameIntervalIfNeeded(view2);
    }

    public void run() {
        boolean z;
        if (this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !this.isActive) {
            z = false;
        } else if (this.view.getWindowVisibility() != 0) {
            z = false;
        } else {
            long nextFrameNs = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime()) + frameIntervalNs;
            boolean scheduleForNextFrame = false;
            while (this.prefetchRequests.isNotEmpty() && !scheduleForNextFrame) {
                PrefetchRequest request = (PrefetchRequest) this.prefetchRequests.getContent()[0];
                LazyLayoutItemProvider itemProvider = this.itemContentFactory.getItemProvider().invoke();
                if (!request.getCanceled()) {
                    int itemCount = itemProvider.getItemCount();
                    int index = request.getIndex();
                    if (index >= 0 && index < itemCount) {
                        if (request.getPrecomposeHandle() == null) {
                            Trace.beginSection("compose:lazylist:prefetch:compose");
                            try {
                                long beforeTimeNs = System.nanoTime();
                                LazyLayoutItemProvider itemProvider2 = itemProvider;
                                try {
                                    if (enoughTimeLeft(beforeTimeNs, nextFrameNs, this.averagePrecomposeTimeNs)) {
                                        Object key = itemProvider2.getKey(request.getIndex());
                                        request.setPrecomposeHandle(this.subcomposeLayoutState.precompose(key, this.itemContentFactory.getContent(request.getIndex(), key, itemProvider2.getContentType(request.getIndex()))));
                                        this.averagePrecomposeTimeNs = calculateAverageTime(System.nanoTime() - beforeTimeNs, this.averagePrecomposeTimeNs);
                                    } else {
                                        scheduleForNextFrame = true;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    Trace.endSection();
                                } catch (Throwable th) {
                                    th = th;
                                    Trace.endSection();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                LazyLayoutItemProvider lazyLayoutItemProvider = itemProvider;
                                Trace.endSection();
                                throw th;
                            }
                        } else {
                            if (!request.getMeasured()) {
                                Trace.beginSection("compose:lazylist:prefetch:measure");
                                try {
                                    long beforeTimeNs2 = System.nanoTime();
                                    if (enoughTimeLeft(beforeTimeNs2, nextFrameNs, this.averagePremeasureTimeNs)) {
                                        SubcomposeLayoutState.PrecomposedSlotHandle handle = request.getPrecomposeHandle();
                                        Intrinsics.checkNotNull(handle);
                                        int placeablesCount = handle.getPlaceablesCount();
                                        for (int placeableIndex = 0; placeableIndex < placeablesCount; placeableIndex++) {
                                            handle.m4771premeasure0kLqBqw(placeableIndex, request.m762getConstraintsmsEJaDk());
                                        }
                                        this.averagePremeasureTimeNs = calculateAverageTime(System.nanoTime() - beforeTimeNs2, this.averagePremeasureTimeNs);
                                        this.prefetchRequests.removeAt(0);
                                    } else {
                                        scheduleForNextFrame = true;
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                } finally {
                                    Trace.endSection();
                                }
                            } else {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                        }
                    }
                }
                this.prefetchRequests.removeAt(0);
            }
            if (scheduleForNextFrame) {
                this.choreographer.postFrameCallback(this);
                return;
            } else {
                this.prefetchScheduled = false;
                return;
            }
        }
        this.prefetchScheduled = z;
    }

    private final boolean enoughTimeLeft(long now, long nextFrame, long average) {
        return now > nextFrame || now + average < nextFrame;
    }

    public void doFrame(long frameTimeNanos) {
        if (this.isActive) {
            this.view.post(this);
        }
    }

    private final long calculateAverageTime(long j, long current) {
        if (current == 0) {
            return j;
        }
        long j2 = (long) 4;
        return ((current / j2) * ((long) 3)) + (j / j2);
    }

    /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
    public LazyLayoutPrefetchState.PrefetchHandle m761schedulePrefetch0kLqBqw(int index, long constraints) {
        PrefetchRequest request = new PrefetchRequest(index, constraints, (DefaultConstructorMarker) null);
        this.prefetchRequests.add(request);
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(this);
        }
        return request;
    }

    public void onRemembered() {
        this.prefetchState.setPrefetcher$foundation_release(this);
        this.isActive = true;
    }

    public void onForgotten() {
        this.isActive = false;
        this.prefetchState.setPrefetcher$foundation_release((LazyLayoutPrefetchState.Prefetcher) null);
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    public void onAbandoned() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$PrefetchRequest;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(IJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "canceled", "", "getCanceled", "()Z", "setCanceled", "(Z)V", "getConstraints-msEJaDk", "()J", "J", "getIndex", "()I", "measured", "getMeasured", "setMeasured", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "getPrecomposeHandle", "()Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "setPrecomposeHandle", "(Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;)V", "cancel", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutPrefetcher.android.kt */
    private static final class PrefetchRequest implements LazyLayoutPrefetchState.PrefetchHandle {
        private boolean canceled;
        private final long constraints;
        private final int index;
        private boolean measured;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;

        public /* synthetic */ PrefetchRequest(int i, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, j);
        }

        private PrefetchRequest(int index2, long constraints2) {
            this.index = index2;
            this.constraints = constraints2;
        }

        public final int getIndex() {
            return this.index;
        }

        /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
        public final long m762getConstraintsmsEJaDk() {
            return this.constraints;
        }

        public final SubcomposeLayoutState.PrecomposedSlotHandle getPrecomposeHandle() {
            return this.precomposeHandle;
        }

        public final void setPrecomposeHandle(SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle) {
            this.precomposeHandle = precomposedSlotHandle;
        }

        public final boolean getCanceled() {
            return this.canceled;
        }

        public final void setCanceled(boolean z) {
            this.canceled = z;
        }

        public final boolean getMeasured() {
            return this.measured;
        }

        public final void setMeasured(boolean z) {
            this.measured = z;
        }

        public void cancel() {
            if (!this.canceled) {
                this.canceled = true;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                if (precomposedSlotHandle != null) {
                    precomposedSlotHandle.dispose();
                }
                this.precomposeHandle = null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$Companion;", "", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutPrefetcher.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void calculateFrameIntervalIfNeeded(View view) {
            if (LazyLayoutPrefetcher.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                float refreshRate = 60.0f;
                if (!view.isInEditMode() && display != null) {
                    float displayRefreshRate = display.getRefreshRate();
                    if (displayRefreshRate >= 30.0f) {
                        refreshRate = displayRefreshRate;
                    }
                }
                LazyLayoutPrefetcher.frameIntervalNs = (long) (((float) 1000000000) / refreshRate);
            }
        }
    }
}
