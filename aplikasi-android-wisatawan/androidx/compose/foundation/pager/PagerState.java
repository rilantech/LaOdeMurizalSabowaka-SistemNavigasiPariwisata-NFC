package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J:\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u00052\u0010\b\u0002\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001a\u0010 \u0001\u001a\u00030\u00012\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0000¢\u0006\u0003\b£\u0001J\u0014\u0010¤\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010¥\u0001J\u0013\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010§\u0001\u001a\u00020EH\u0002J\u0012\u0010¨\u0001\u001a\u00020\u00052\u0007\u0010©\u0001\u001a\u00020\u0005H\u0016J\u0010\u0010ª\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0003J\u0013\u0010«\u0001\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010¬\u0001\u001a\u00020\u00052\u0007\u0010­\u0001\u001a\u00020\u0005H\u0002JN\u0010®\u0001\u001a\u00030\u00012\b\u0010¯\u0001\u001a\u00030°\u00012.\u0010±\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030³\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010´\u0001\u0012\u0007\u0012\u0005\u0018\u00010µ\u00010²\u0001¢\u0006\u0003\b¶\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010·\u0001J(\u0010¸\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0001\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0003\u0010¹\u0001J\r\u0010º\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178F@BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178F@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u001b\u0010%\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b3\u0010'R\u0014\u00104\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\nR\u0014\u00106\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\nR\u000e\u00108\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020@X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u001aR\u0014\u0010D\u001a\u00020E8@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001b\u0010H\u001a\u00020I8@X\u0002¢\u0006\f\u001a\u0004\bL\u0010M*\u0004\bJ\u0010KR\u001e\u0010N\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\nR\u0014\u0010P\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\nR\u0012\u0010R\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\nR\u0014\u0010T\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\nR\u0014\u0010V\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\nR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020E0YX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\u00020[X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010'R\u0014\u0010`\u001a\u00020aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u001a\"\u0004\bf\u0010\u001cR%\u0010g\u001a\u00020hX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010m\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR/\u0010o\u001a\u0004\u0018\u00010n2\b\u0010\u0007\u001a\u0004\u0018\u00010n8@@BX\u0002¢\u0006\u0012\n\u0004\bt\u0010\u001e\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0014\u0010u\u001a\u00020vX\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u000e\u0010y\u001a\u00020zX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010{\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b|\u0010'R\u000e\u0010}\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010~\u001a\u00020\u00038FX\u0002¢\u0006\r\n\u0005\b\u0001\u0010)\u001a\u0004\b\u0010\nR/\u0010\u0001\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010\u000e\u001a\u0005\b\u0001\u0010\n\"\u0005\b\u0001\u0010\fR1\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058@@@X\u0002¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010'\"\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u00020\u00038FX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010)\u001a\u0005\b\u0001\u0010\nR:\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0007\u001a\u00030\u00018@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010\u001e\u001a\u0005\b\u0001\u0010j\"\u0005\b\u0001\u0010lR\u001f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006»\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialPage", "", "initialPageOffsetFraction", "", "(IF)V", "<set-?>", "animationTargetPage", "getAnimationTargetPage", "()I", "setAnimationTargetPage", "(I)V", "animationTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentPage", "getCurrentPage", "currentPageOffsetFraction", "getCurrentPageOffsetFraction", "()F", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/State;", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "distanceToSnapPosition", "getDistanceToSnapPosition", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "indexToPrefetch", "getInitialPage", "getInitialPageOffsetFraction", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo$foundation_release", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pageAvailableSpace", "getPageAvailableSpace", "pageCount", "getPageCount", "pageSize", "getPageSize$foundation_release", "pageSpacing", "getPageSpacing$foundation_release", "pagerLayoutInfoState", "Landroidx/compose/runtime/MutableState;", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "positionThresholdFraction", "getPositionThresholdFraction", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "()J", "setPremeasureConstraints-BRTryo0$foundation_release", "(J)V", "J", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "scrollableState", "settledPage", "getSettledPage", "settledPage$delegate", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "snapRemainingScrollOffset", "getSnapRemainingScrollOffset$foundation_release", "setSnapRemainingScrollOffset$foundation_release", "(F)V", "snapRemainingScrollOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "targetPage", "getTargetPage", "targetPage$delegate", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation_release", "setUpDownDifference-k-4lQ0M$foundation_release", "upDownDifference$delegate", "visiblePages", "", "Landroidx/compose/foundation/pager/PageInfo;", "getVisiblePages", "()Ljava/util/List;", "wasScrollingForward", "animateScrollToPage", "", "page", "pageOffsetFraction", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "applyMeasureResult$foundation_release", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "getOffsetFractionForPage", "notifyPrefetch", "performScroll", "distance", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceInPageRange", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private final MutableIntState animationTargetPage$delegate;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final State currentPageOffsetFraction$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int indexToPrefetch;
    private final int initialPage;
    private final float initialPageOffsetFraction;
    private final MutableInteractionSource internalInteractionSource;
    private int numMeasurePasses;
    private MutableState<PagerLayoutInfo> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    /* access modifiers changed from: private */
    public final PagerScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final MutableFloatState snapRemainingScrollOffset$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasScrollingForward;

    public PagerState() {
        this(0, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public abstract int getPageCount();

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuation);
    }

    public PagerState(int initialPage2, float initialPageOffsetFraction2) {
        this.initialPage = initialPage2;
        this.initialPageOffsetFraction = initialPageOffsetFraction2;
        double d = (double) initialPageOffsetFraction2;
        if (-0.5d <= d && d <= 0.5d) {
            this.upDownDifference$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2992boximpl(Offset.Companion.m3019getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.snapRemainingScrollOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
            PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(initialPage2, 0);
            this.scrollPosition = pagerScrollPosition;
            this.scrollableState = ScrollableStateKt.ScrollableState(new PagerState$scrollableState$1(this));
            this.prefetchingEnabled = true;
            this.indexToPrefetch = -1;
            this.pagerLayoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PagerStateKt.getEmptyLayoutInfo(), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.density = PagerStateKt.UnitDensity;
            this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
            this.animationTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
            this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(initialPage2);
            this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$settledPage$2(this));
            this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$targetPage$2(this));
            this.currentPageOffsetFraction$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$currentPageOffsetFraction$2(this));
            this.prefetchState = new LazyLayoutPrefetchState();
            this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
            this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
            this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.remeasurementModifier = new PagerState$remeasurementModifier$1(this);
            this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
            this.pinnedPages = new LazyLayoutPinnedItemList();
            pagerScrollPosition.getNearestRangeState();
            this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            return;
        }
        throw new IllegalArgumentException(("initialPageOffsetFraction " + initialPageOffsetFraction2 + " is not within the range -0.5 to 0.5").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerState(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }

    public final int getInitialPage() {
        return this.initialPage;
    }

    public final float getInitialPageOffsetFraction() {
        return this.initialPageOffsetFraction;
    }

    /* renamed from: getUpDownDifference-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m829getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference$delegate.getValue()).m3013unboximpl();
    }

    /* renamed from: setUpDownDifference-k-4lQ0M$foundation_release  reason: not valid java name */
    public final void m831setUpDownDifferencek4lQ0M$foundation_release(long j) {
        this.upDownDifference$delegate.setValue(Offset.m2992boximpl(j));
    }

    public final float getSnapRemainingScrollOffset$foundation_release() {
        return this.snapRemainingScrollOffset$delegate.getFloatValue();
    }

    public final void setSnapRemainingScrollOffset$foundation_release(float f) {
        this.snapRemainingScrollOffset$delegate.setFloatValue(f);
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.scrollPosition.getFirstVisiblePage();
    }

    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.scrollPosition.getScrollOffset();
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final PagerLayoutInfo getLayoutInfo$foundation_release() {
        return this.pagerLayoutInfoState.getValue();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "<set-?>");
        this.density = density2;
    }

    private final List<PageInfo> getVisiblePages() {
        return this.pagerLayoutInfoState.getValue().getVisiblePagesInfo();
    }

    /* access modifiers changed from: private */
    public final int getPageAvailableSpace() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    /* access modifiers changed from: private */
    public final float getPositionThresholdFraction() {
        return Math.min(this.density.m5825toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), ((float) getPageSize$foundation_release()) / 2.0f) / ((float) getPageSize$foundation_release());
    }

    private final float getDistanceToSnapPosition() {
        PageInfo it = getLayoutInfo$foundation_release().getClosestPageToSnapPosition();
        if (it != null) {
            return SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(this.density, PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo$foundation_release()), getLayoutInfo$foundation_release().getBeforeContentPadding(), getLayoutInfo$foundation_release().getAfterContentPadding(), getLayoutInfo$foundation_release().getPageSize(), it.getOffset(), it.getIndex(), PagerStateKt.getSnapAlignmentStartToStart());
        }
        return 0.0f;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    /* access modifiers changed from: private */
    public final int getAnimationTargetPage() {
        return this.animationTargetPage$delegate.getIntValue();
    }

    private final void setAnimationTargetPage(int i) {
        this.animationTargetPage$delegate.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    private final void setSettledPageState(int i) {
        this.settledPageState$delegate.setIntValue(i);
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return ((Number) this.currentPageOffsetFraction$delegate.getValue()).floatValue();
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    /* access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release  reason: not valid java name */
    public final long m828getPremeasureConstraintsmsEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release  reason: not valid java name */
    public final void m830setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints = j;
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    private static Object getNearestRange$foundation_release$delegate(PagerState pagerState) {
        return pagerState.scrollPosition.getNearestRangeState();
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            return pagerState.scrollToPage(i, f, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
    }

    public final Object scrollToPage(int page, float pageOffsetFraction, Continuation<? super Unit> $completion) {
        Object scroll$default = ScrollableState.scroll$default(this, (MutatePriority) null, new PagerState$scrollToPage$2(this, pageOffsetFraction, page, (Continuation<? super PagerState$scrollToPage$2>) null), $completion, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
            }
            return pagerState.animateScrollToPage(i, f, animationSpec, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        r5 = (double) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        if (-0.5d > r5) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        if (r5 > 0.5d) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        if (r3 == false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        r1 = r12.getCurrentPage();
        r13 = r12.coerceInPageRange(r2);
        r12.setAnimationTargetPage(r13);
        r3 = ((androidx.compose.foundation.pager.PageInfo) kotlin.collections.CollectionsKt.first(r12.getVisiblePages())).getIndex();
        r4 = ((androidx.compose.foundation.pager.PageInfo) kotlin.collections.CollectionsKt.last(r12.getVisiblePages())).getIndex();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
        if (r2 <= r12.getCurrentPage()) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d6, code lost:
        if (r2 > r4) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00dc, code lost:
        if (r2 >= r12.getCurrentPage()) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00de, code lost:
        if (r2 >= r3) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (java.lang.Math.abs(r2 - r12.getCurrentPage()) < 3) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f0, code lost:
        if (r2 <= r12.getCurrentPage()) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f2, code lost:
        r3 = kotlin.ranges.RangesKt.coerceAtLeast(r2 - r12.getVisiblePages().size(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0101, code lost:
        r3 = kotlin.ranges.RangesKt.coerceAtMost(r12.getVisiblePages().size(), r1) + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010e, code lost:
        r14 = r3;
        r0.L$0 = r12;
        r0.L$1 = r11;
        r0.F$0 = r10;
        r0.I$0 = r13;
        r0.I$1 = r14;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0129, code lost:
        if (scrollToPage$default(r12, r14, 0.0f, r0, 2, (java.lang.Object) null) != r8) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012b, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012c, code lost:
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r2 = r13;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0131, code lost:
        r6 = r1;
        r13 = r2;
        r10 = r3;
        r11 = r4;
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0137, code lost:
        r6 = r1;
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0139, code lost:
        r3 = ((float) ((r13 * r1.getPageAvailableSpace()) - (r6 * r1.getPageAvailableSpace()))) + (r1.getDistanceToSnapPosition() + (((float) r1.getPageAvailableSpace()) * r10));
        r0.L$0 = r1;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0164, code lost:
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(r1, r3, r11, r0) != r8) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0166, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0167, code lost:
        r1.setAnimationTargetPage(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0192, code lost:
        throw new java.lang.IllegalArgumentException(("pageOffsetFraction " + r10 + " is not within the range -0.5 to 0.5").toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateScrollToPage(int r16, float r17, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r15 = this;
            r0 = r19
            boolean r1 = r0 instanceof androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r1 = (androidx.compose.foundation.pager.PagerState$animateScrollToPage$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r15
            goto L_0x001f
        L_0x0018:
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r1 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            r2 = r15
            r1.<init>(r15, r0)
            r0 = r1
        L_0x001f:
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r9 = 3
            r3 = 0
            r4 = 1
            switch(r1) {
                case 0: goto L_0x0064;
                case 1: goto L_0x0051;
                case 2: goto L_0x003e;
                case 3: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.pager.PagerState r1 = (androidx.compose.foundation.pager.PagerState) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0167
        L_0x003e:
            int r1 = r0.I$1
            int r2 = r0.I$0
            float r3 = r0.F$0
            java.lang.Object r4 = r0.L$1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0131
        L_0x0051:
            float r1 = r0.F$0
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            androidx.compose.animation.core.AnimationSpec r5 = (androidx.compose.animation.core.AnimationSpec) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.pager.PagerState r6 = (androidx.compose.foundation.pager.PagerState) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r10 = r1
            r11 = r5
            r12 = r6
            goto L_0x0099
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r15
            r2 = r17
            r5 = r16
            r6 = r18
            int r10 = r1.getCurrentPage()
            if (r5 != r10) goto L_0x0084
            float r10 = r1.getCurrentPageOffsetFraction()
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 != 0) goto L_0x007e
            r10 = r4
            goto L_0x007f
        L_0x007e:
            r10 = r3
        L_0x007f:
            if (r10 == 0) goto L_0x0084
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0084:
            r0.L$0 = r1
            r0.L$1 = r6
            r0.I$0 = r5
            r0.F$0 = r2
            r0.label = r4
            java.lang.Object r10 = r1.awaitScrollDependencies(r0)
            if (r10 != r8) goto L_0x0095
            return r8
        L_0x0095:
            r12 = r1
            r10 = r2
            r2 = r5
            r11 = r6
        L_0x0099:
            double r5 = (double) r10
            r13 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r1 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x00a7
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 > 0) goto L_0x00a7
            r3 = r4
        L_0x00a7:
            if (r3 == 0) goto L_0x016e
            int r1 = r12.getCurrentPage()
            int r13 = r12.coerceInPageRange(r2)
            r12.setAnimationTargetPage(r13)
            java.util.List r3 = r12.getVisiblePages()
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r3)
            androidx.compose.foundation.pager.PageInfo r3 = (androidx.compose.foundation.pager.PageInfo) r3
            int r3 = r3.getIndex()
            java.util.List r4 = r12.getVisiblePages()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r4)
            androidx.compose.foundation.pager.PageInfo r4 = (androidx.compose.foundation.pager.PageInfo) r4
            int r4 = r4.getIndex()
            int r5 = r12.getCurrentPage()
            if (r2 <= r5) goto L_0x00d8
            if (r2 > r4) goto L_0x00e0
        L_0x00d8:
            int r4 = r12.getCurrentPage()
            if (r2 >= r4) goto L_0x0137
            if (r2 >= r3) goto L_0x0137
        L_0x00e0:
            int r3 = r12.getCurrentPage()
            int r3 = r2 - r3
            int r3 = java.lang.Math.abs(r3)
            if (r3 < r9) goto L_0x0137
            int r3 = r12.getCurrentPage()
            if (r2 <= r3) goto L_0x0101
            java.util.List r3 = r12.getVisiblePages()
            int r3 = r3.size()
            int r3 = r2 - r3
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r1)
            goto L_0x010e
        L_0x0101:
            java.util.List r3 = r12.getVisiblePages()
            int r3 = r3.size()
            int r3 = kotlin.ranges.RangesKt.coerceAtMost((int) r3, (int) r1)
            int r3 = r3 + r2
        L_0x010e:
            r14 = r3
            r1 = 0
            r0.L$0 = r12
            r0.L$1 = r11
            r0.F$0 = r10
            r0.I$0 = r13
            r0.I$1 = r14
            r1 = 2
            r0.label = r1
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r12
            r2 = r14
            r4 = r0
            java.lang.Object r1 = scrollToPage$default(r1, r2, r3, r4, r5, r6)
            if (r1 != r8) goto L_0x012c
            return r8
        L_0x012c:
            r3 = r10
            r4 = r11
            r5 = r12
            r2 = r13
            r1 = r14
        L_0x0131:
            r6 = r1
            r13 = r2
            r10 = r3
            r11 = r4
            r1 = r5
            goto L_0x0139
        L_0x0137:
            r6 = r1
            r1 = r12
        L_0x0139:
            int r2 = r1.getPageAvailableSpace()
            int r13 = r13 * r2
            int r2 = r1.getPageAvailableSpace()
            int r6 = r6 * r2
            float r2 = r1.getDistanceToSnapPosition()
            int r3 = r1.getPageAvailableSpace()
            float r3 = (float) r3
            float r3 = r3 * r10
            float r2 = r2 + r3
            int r3 = r13 - r6
            float r3 = (float) r3
            float r3 = r3 + r2
            r2 = 0
            r2 = r1
            androidx.compose.foundation.gestures.ScrollableState r2 = (androidx.compose.foundation.gestures.ScrollableState) r2
            r0.L$0 = r1
            r4 = 0
            r0.L$1 = r4
            r0.label = r9
            java.lang.Object r2 = androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(r2, r3, r11, r0)
            if (r2 != r8) goto L_0x0167
            return r8
        L_0x0167:
            r2 = -1
            r1.setAnimationTargetPage(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        L_0x016e:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "pageOffsetFraction "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.String r3 = " is not within the range -0.5 to 0.5"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r1 = r2.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object awaitScrollDependencies(Continuation<? super Unit> $completion) {
        Object waitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout($completion);
        return waitForFirstLayout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? waitForFirstLayout : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState$scroll$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
            r0.<init>(r5, r8)
        L_0x0019:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L_0x0041;
                case 1: goto L_0x0031;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006a
        L_0x0031:
            java.lang.Object r5 = r8.L$2
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r6 = r8.L$1
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r7 = r8.L$0
            androidx.compose.foundation.pager.PagerState r7 = (androidx.compose.foundation.pager.PagerState) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0057
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            r8.L$0 = r5
            r8.L$1 = r6
            r8.L$2 = r7
            r2 = 1
            r8.label = r2
            java.lang.Object r2 = r5.awaitScrollDependencies(r8)
            if (r2 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x0057:
            androidx.compose.foundation.gestures.ScrollableState r2 = r7.scrollableState
            r3 = 0
            r8.L$0 = r3
            r8.L$1 = r3
            r8.L$2 = r3
            r3 = 2
            r8.label = r3
            java.lang.Object r5 = r2.scroll(r6, r5, r8)
            if (r5 != r1) goto L_0x006a
            return r1
        L_0x006a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scroll$suspendImpl(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    private final void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.scrollPosition.updateFromMeasureResult(result);
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.pagerLayoutInfoState.setValue(result);
        setCanScrollForward(result.getCanScrollForward());
        MeasuredPage firstVisiblePage = result.getFirstVisiblePage();
        boolean z = false;
        if (!((firstVisiblePage != null ? firstVisiblePage.getIndex() : 0) == 0 && result.getFirstVisiblePageOffset() == 0)) {
            z = true;
        }
        setCanScrollBackward(z);
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(result);
        if (!isScrollInProgress()) {
            setSettledPageState(getCurrentPage());
        }
    }

    /* access modifiers changed from: private */
    public final int coerceInPageRange(int $this$coerceInPageRange) {
        if (getPageCount() > 0) {
            return RangesKt.coerceIn($this$coerceInPageRange, 0, getPageCount() - 1);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public final float performScroll(float distance) {
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            float f = this.scrollToBeConsumed + distance;
            this.scrollToBeConsumed = f;
            if (Math.abs(f) > 0.5f) {
                float preScrollToBeConsumed = this.scrollToBeConsumed;
                Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
                if (remeasurement$foundation_release != null) {
                    remeasurement$foundation_release.forceRemeasure();
                }
                if (this.prefetchingEnabled) {
                    notifyPrefetch(preScrollToBeConsumed - this.scrollToBeConsumed);
                }
            }
            if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
                return distance;
            }
            float scrollConsumed = distance - this.scrollToBeConsumed;
            this.scrollToBeConsumed = 0.0f;
            return scrollConsumed;
        }
        throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
    }

    private final void notifyPrefetch(float delta) {
        int indexToPrefetch2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (this.prefetchingEnabled) {
            PagerLayoutInfo info = getLayoutInfo$foundation_release();
            boolean z = true;
            if (!info.getVisiblePagesInfo().isEmpty()) {
                boolean scrollingForward = delta < 0.0f;
                if (scrollingForward) {
                    indexToPrefetch2 = ((PageInfo) CollectionsKt.last(info.getVisiblePagesInfo())).getIndex() + 1;
                } else {
                    indexToPrefetch2 = ((PageInfo) CollectionsKt.first(info.getVisiblePagesInfo())).getIndex() - 1;
                }
                if (indexToPrefetch2 != this.indexToPrefetch) {
                    if (indexToPrefetch2 < 0 || indexToPrefetch2 >= info.getPagesCount()) {
                        z = false;
                    }
                    if (z) {
                        if (!(this.wasScrollingForward == scrollingForward || (prefetchHandle = this.currentPrefetchHandle) == null)) {
                            prefetchHandle.cancel();
                        }
                        this.wasScrollingForward = scrollingForward;
                        this.indexToPrefetch = indexToPrefetch2;
                        this.currentPrefetchHandle = this.prefetchState.m759schedulePrefetch0kLqBqw(indexToPrefetch2, this.premeasureConstraints);
                    }
                }
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo info) {
        int expectedPrefetchIndex;
        if (this.indexToPrefetch != -1 && (!info.getVisiblePagesInfo().isEmpty())) {
            if (this.wasScrollingForward) {
                expectedPrefetchIndex = ((PageInfo) CollectionsKt.last(info.getVisiblePagesInfo())).getIndex() + 1;
            } else {
                expectedPrefetchIndex = ((PageInfo) CollectionsKt.first(info.getVisiblePagesInfo())).getIndex() - 1;
            }
            if (this.indexToPrefetch != expectedPrefetchIndex) {
                this.indexToPrefetch = -1;
                LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
                if (prefetchHandle != null) {
                    prefetchHandle.cancel();
                }
                this.currentPrefetchHandle = null;
            }
        }
    }

    public final float getOffsetFractionForPage(int page) {
        boolean z = false;
        if (page >= 0 && page <= getPageCount()) {
            z = true;
        }
        if (z) {
            return ((float) (getCurrentPage() - page)) + getCurrentPageOffsetFraction();
        }
        throw new IllegalArgumentException(("page " + page + " is not within the range 0 to pageCount").toString());
    }
}
