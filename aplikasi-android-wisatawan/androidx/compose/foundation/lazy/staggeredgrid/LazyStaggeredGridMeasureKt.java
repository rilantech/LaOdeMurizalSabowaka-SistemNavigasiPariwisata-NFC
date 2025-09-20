package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\b¢\u0006\u0002\u0010\u0010\u001aJ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000eH\b\u001a;\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001d0\u001cH\u0002¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\u00020\u0005*\u00020\u00142\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a\u001c\u0010'\u001a\u00020\u0003*\u00020\u00142\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0002\u001a.\u0010*\u001a\u00020\u0005*\u00020+2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a\f\u0010.\u001a\u00020\u0003*\u00020\u001fH\u0002\u001a2\u0010/\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\b¢\u0006\u0002\u00100\u001a\u0016\u00101\u001a\u00020\u0003*\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u0003H\u0000\u001a!\u00103\u001a\u00020\u0003*\u00020\u001f2\u0006\u00104\u001a\u00020+H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u001a,\u00107\u001a\u000208*\u00020\u00142\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0001H\u0003\u001a\u0010=\u001a\u000208*\u00020\f2\u0006\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010P\u001a\u0014\u0010Q\u001a\u00020\u0005*\u00020\u001f2\u0006\u0010R\u001a\u00020\u0003H\u0002\u001a!\u0010S\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006T"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "measureStaggeredGrid-dSVRQoE", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIII)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope scope, Function1<? super LazyLayoutMeasureScope, ? extends T> block) {
        return block.invoke(scope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] $this$debugRender) {
        return "";
    }

    private static final void debugLog(Function0<String> message) {
    }

    /* renamed from: measureStaggeredGrid-dSVRQoE  reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m786measureStaggeredGriddSVRQoE(LazyLayoutMeasureScope $this$measureStaggeredGrid_u2ddSVRQoE, LazyStaggeredGridState state, List<Integer> pinnedItems, LazyStaggeredGridItemProvider itemProvider, LazyStaggeredGridSlots resolvedSlots, long constraints, boolean isVertical, boolean reverseLayout, long contentOffset, int mainAxisAvailableSize, int mainAxisSpacing, int beforeContentPadding, int afterContentPadding) {
        Object obj;
        int i;
        Object obj2;
        int i2;
        int $i$f$withoutReadObservation;
        int i3;
        int[] iArr;
        Intrinsics.checkNotNullParameter($this$measureStaggeredGrid_u2ddSVRQoE, "$this$measureStaggeredGrid");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pinnedItems, "pinnedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(resolvedSlots, "resolvedSlots");
        LazyStaggeredGridMeasureContext context = new LazyStaggeredGridMeasureContext(state, pinnedItems, itemProvider, resolvedSlots, constraints, isVertical, $this$measureStaggeredGrid_u2ddSVRQoE, mainAxisAvailableSize, contentOffset, beforeContentPadding, afterContentPadding, reverseLayout, mainAxisSpacing, (DefaultConstructorMarker) null);
        Ref.ObjectRef initialItemIndices = new Ref.ObjectRef();
        Ref.ObjectRef initialItemOffsets = new Ref.ObjectRef();
        Snapshot.Companion this_$iv = Snapshot.Companion;
        int $i$f$withoutReadObservation2 = false;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
            try {
                int[] firstVisibleIndices = state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider, state.getScrollPosition$foundation_release().getIndices());
                int[] firstVisibleOffsets = state.getScrollPosition$foundation_release().getOffsets();
                if (firstVisibleIndices.length == context.getLaneCount()) {
                    Snapshot.Companion companion = this_$iv;
                    obj = firstVisibleIndices;
                    i = 0;
                } else {
                    context.getLaneInfo().reset();
                    int[] iArr2 = new int[context.getLaneCount()];
                    int[] $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242 = iArr2;
                    int length = $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242.length;
                    int lane = 0;
                    while (lane < length) {
                        Snapshot.Companion this_$iv2 = this_$iv;
                        try {
                            if (lane < firstVisibleIndices.length) {
                                $i$f$withoutReadObservation = $i$f$withoutReadObservation2;
                                if (firstVisibleIndices[lane] != -1) {
                                    i3 = firstVisibleIndices[lane];
                                    iArr = iArr2;
                                    $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242[lane] = i3;
                                    context.getLaneInfo().setLane($this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242[lane], lane);
                                    lane++;
                                    LazyStaggeredGridState lazyStaggeredGridState = state;
                                    iArr2 = iArr;
                                    this_$iv = this_$iv2;
                                    $i$f$withoutReadObservation2 = $i$f$withoutReadObservation;
                                }
                            } else {
                                $i$f$withoutReadObservation = $i$f$withoutReadObservation2;
                            }
                            if (lane == 0) {
                                iArr = iArr2;
                                i3 = 0;
                            } else {
                                iArr = iArr2;
                                i3 = m785maxInRangejy6DScQ($this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242, SpanRange.m798constructorimpl(0, lane)) + 1;
                            }
                            $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242[lane] = i3;
                            context.getLaneInfo().setLane($this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u242[lane], lane);
                            lane++;
                            LazyStaggeredGridState lazyStaggeredGridState2 = state;
                            iArr2 = iArr;
                            this_$iv = this_$iv2;
                            $i$f$withoutReadObservation2 = $i$f$withoutReadObservation;
                        } catch (Throwable th) {
                            th = th;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            throw th;
                        }
                    }
                    int i4 = $i$f$withoutReadObservation2;
                    int[] iArr3 = iArr2;
                    i = 0;
                    obj = iArr2;
                }
                initialItemIndices.element = obj;
                if (firstVisibleOffsets.length == context.getLaneCount()) {
                    obj2 = firstVisibleOffsets;
                } else {
                    int[] iArr4 = new int[context.getLaneCount()];
                    int[] $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u243 = iArr4;
                    int lane2 = 0;
                    int length2 = $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u243.length;
                    while (lane2 < length2) {
                        if (lane2 < firstVisibleOffsets.length) {
                            i2 = firstVisibleOffsets[lane2];
                        } else {
                            i2 = lane2 == 0 ? i : $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u243[lane2 - 1];
                        }
                        $this$measureStaggeredGrid_dSVRQoE_u24lambda_u244_u24lambda_u243[lane2] = i2;
                        lane2++;
                    }
                    obj2 = iArr4;
                }
                initialItemOffsets.element = obj2;
                Unit unit = Unit.INSTANCE;
                try {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                    return measure(context, MathKt.roundToInt(state.getScrollToBeConsumed$foundation_release()), (int[]) initialItemIndices.element, (int[]) initialItemOffsets.element, true);
                } catch (Throwable th2) {
                    th = th2;
                    snapshot$iv.dispose();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Snapshot.Companion companion2 = this_$iv;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            Snapshot.Companion companion3 = this_$iv;
            snapshot$iv.dispose();
            throw th;
        }
    }

    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext $this$measure, int initialScrollDelta, int[] initialItemIndices, int[] initialItemOffsets, boolean canRestartMeasure) {
        int itemCount;
        int initialLaneToMeasure;
        int initialLaneToMeasure2;
        int scrollDelta;
        boolean z;
        int itemCount2;
        boolean z2;
        boolean z3;
        int maxOffset;
        int[] currentItemIndices;
        int itemCount3;
        int[] firstItemIndices;
        int[] currentItemOffsets;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext;
        int toScrollBack;
        float consumedScroll;
        int layoutWidth;
        int layoutHeight;
        boolean z4;
        boolean canScrollForward;
        boolean z5;
        int itemCount4;
        ArrayDeque[] measuredItems;
        List $this$fastForEach$iv$iv;
        boolean z6;
        int layoutHeight2;
        int[] currentItemOffsets2;
        int[] firstItemOffsets;
        boolean z7;
        int[] firstItemIndices2;
        int scrollDelta2;
        int maxOffsetLane;
        boolean gapDetected;
        int maxOffsetLane2;
        int[] currentItemOffsets3;
        int scrollDelta3;
        boolean gapDetected2;
        boolean gapDetected3;
        int currentIndex;
        boolean gapDetected4;
        int initialLaneToMeasure3;
        int i;
        int i2;
        int[] gaps;
        int initialLaneToMeasure4;
        int initialItemsMeasured;
        boolean z8;
        String str;
        int scrollDelta4;
        int[] firstItemIndices3;
        int minOffset;
        int laneToCheckForGaps;
        int initialItemsMeasured2;
        int initialLaneToMeasure5;
        int i3;
        int i4;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = $this$measure;
        int[] iArr = initialItemIndices;
        int[] iArr2 = initialItemOffsets;
        LazyLayoutMeasureScope $this$measure_u24lambda_u2438 = $this$measure.getMeasureScope();
        int itemCount5 = $this$measure.getItemProvider().getItemCount();
        if (itemCount5 <= 0) {
            itemCount = itemCount5;
        } else if ($this$measure.getLaneCount() == 0) {
            itemCount = itemCount5;
        } else {
            int scrollDelta5 = initialScrollDelta;
            int[] firstItemIndices4 = Arrays.copyOf(iArr, iArr.length);
            String str2 = "copyOf(this, size)";
            Intrinsics.checkNotNullExpressionValue(firstItemIndices4, str2);
            int[] gaps2 = Arrays.copyOf(iArr2, iArr2.length);
            Intrinsics.checkNotNullExpressionValue(gaps2, str2);
            ensureIndicesInRange(lazyStaggeredGridMeasureContext2, firstItemIndices4, itemCount5);
            offsetBy(gaps2, -scrollDelta5);
            int laneCount = $this$measure.getLaneCount();
            ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
            for (int i5 = 0; i5 < laneCount; i5++) {
                arrayDequeArr[i5] = new ArrayDeque(16);
            }
            ArrayDeque[] measuredItems2 = arrayDequeArr;
            offsetBy(gaps2, -$this$measure.getBeforeContentPadding());
            int laneToCheckForGaps2 = -1;
            while (true) {
                if (!measure$lambda$38$hasSpaceBeforeFirst(firstItemIndices4, gaps2, lazyStaggeredGridMeasureContext2)) {
                    initialLaneToMeasure = itemCount5;
                    int i6 = laneToCheckForGaps2;
                    break;
                }
                int laneIndex = indexOfMaxValue(firstItemIndices4);
                int itemIndex = firstItemIndices4[laneIndex];
                int length = gaps2.length;
                for (int i7 = 0; i7 < length; i7++) {
                    if (firstItemIndices4[i7] != firstItemIndices4[laneIndex] && gaps2[i7] < gaps2[laneIndex]) {
                        gaps2[i7] = gaps2[laneIndex];
                    }
                }
                int previousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, itemIndex, laneIndex);
                if (previousItemIndex < 0) {
                    laneToCheckForGaps2 = laneIndex;
                    initialLaneToMeasure = itemCount5;
                    break;
                }
                long spanRange = lazyStaggeredGridMeasureContext2.m782getSpanRangelOCCd4c($this$measure.getItemProvider(), previousItemIndex, laneIndex);
                LazyStaggeredGridLaneInfo laneInfo = $this$measure.getLaneInfo();
                long $this$laneInfo$iv = spanRange;
                long $this$isFullSpan$iv$iv = $this$laneInfo$iv;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = $this$measure;
                int laneToCheckForGaps3 = laneToCheckForGaps2;
                int itemCount6 = itemCount5;
                if (((int) ($this$isFullSpan$iv$iv & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv >> 32)) != 1) {
                    i4 = -2;
                } else {
                    i4 = (int) ($this$laneInfo$iv >> 32);
                }
                laneInfo.setLane(previousItemIndex, i4);
                LazyStaggeredGridMeasuredItem measuredItem = $this$measure.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(previousItemIndex, spanRange);
                int offset = m785maxInRangejy6DScQ(gaps2, spanRange);
                long $this$isFullSpan$iv = spanRange;
                int i8 = laneIndex;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = $this$measure;
                long j = $this$isFullSpan$iv;
                int[] gaps3 = ((int) ($this$isFullSpan$iv & 4294967295L)) - ((int) ($this$isFullSpan$iv >> 32)) != 1 ? $this$measure.getLaneInfo().getGaps(previousItemIndex) : null;
                long $this$forEach_u2dnIS5qE8$iv = spanRange;
                int i9 = itemIndex;
                long j2 = spanRange;
                long j3 = $this$forEach_u2dnIS5qE8$iv;
                int i10 = (int) ($this$forEach_u2dnIS5qE8$iv & 4294967295L);
                for (int i$iv = (int) ($this$forEach_u2dnIS5qE8$iv >> 32); i$iv < i10; i$iv++) {
                    int lane = i$iv;
                    firstItemIndices4[lane] = previousItemIndex;
                    gaps2[lane] = offset + measuredItem.getSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[lane]);
                }
                int[] iArr3 = initialItemIndices;
                int[] iArr4 = initialItemOffsets;
                laneToCheckForGaps2 = laneToCheckForGaps3;
                itemCount5 = itemCount6;
            }
            int minOffset2 = -$this$measure.getBeforeContentPadding();
            if (gaps2[0] < minOffset2) {
                scrollDelta5 += gaps2[0];
                offsetBy(gaps2, minOffset2 - gaps2[0]);
            }
            offsetBy(gaps2, $this$measure.getBeforeContentPadding());
            int i11 = -1;
            int laneToCheckForGaps4 = laneToCheckForGaps2 == -1 ? ArraysKt.indexOf(firstItemIndices4, 0) : laneToCheckForGaps2;
            if (laneToCheckForGaps4 != -1) {
                int lane2 = laneToCheckForGaps4;
                if (measure$lambda$38$misalignedStart(firstItemIndices4, lazyStaggeredGridMeasureContext2, gaps2, lane2) && canRestartMeasure) {
                    $this$measure.getLaneInfo().reset();
                    int length2 = firstItemIndices4.length;
                    int[] iArr5 = new int[length2];
                    for (int i12 = 0; i12 < length2; i12++) {
                        iArr5[i12] = -1;
                    }
                    int length3 = gaps2.length;
                    int[] iArr6 = new int[length3];
                    for (int i13 = 0; i13 < length3; i13++) {
                        iArr6[i13] = gaps2[lane2];
                    }
                    return measure(lazyStaggeredGridMeasureContext2, scrollDelta, iArr5, iArr6, false);
                }
            }
            int[] currentItemIndices2 = Arrays.copyOf(firstItemIndices4, firstItemIndices4.length);
            Intrinsics.checkNotNullExpressionValue(currentItemIndices2, str2);
            int length4 = gaps2.length;
            int[] iArr7 = new int[length4];
            for (int i14 = 0; i14 < length4; i14++) {
                iArr7[i14] = -gaps2[i14];
            }
            int[] currentItemOffsets4 = iArr7;
            int maxOffset2 = RangesKt.coerceAtLeast($this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), 0);
            int initialItemsMeasured3 = 0;
            int initialLaneToMeasure6 = indexOfMinValue$default(currentItemIndices2, 0, 1, (Object) null);
            while (initialLaneToMeasure6 != i11 && initialItemsMeasured3 < $this$measure.getLaneCount()) {
                int itemIndex2 = currentItemIndices2[initialLaneToMeasure6];
                int laneIndex2 = initialLaneToMeasure6;
                int initialLaneToMeasure7 = indexOfMinValue(currentItemIndices2, itemIndex2);
                int initialItemsMeasured4 = initialItemsMeasured3 + 1;
                if (itemIndex2 >= 0) {
                    initialLaneToMeasure5 = initialLaneToMeasure7;
                    initialItemsMeasured2 = initialItemsMeasured4;
                    long spanRange2 = lazyStaggeredGridMeasureContext2.m782getSpanRangelOCCd4c($this$measure.getItemProvider(), itemIndex2, laneIndex2);
                    LazyStaggeredGridMeasuredItem measuredItem2 = $this$measure.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(itemIndex2, spanRange2);
                    laneToCheckForGaps = laneToCheckForGaps4;
                    LazyStaggeredGridLaneInfo laneInfo2 = $this$measure.getLaneInfo();
                    long $this$laneInfo$iv2 = spanRange2;
                    long $this$isFullSpan$iv$iv2 = $this$laneInfo$iv2;
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext5 = $this$measure;
                    scrollDelta4 = scrollDelta;
                    firstItemIndices3 = firstItemIndices4;
                    str = str2;
                    if (((int) ($this$isFullSpan$iv$iv2 & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv2 >> 32)) != 1) {
                        i3 = -2;
                    } else {
                        i3 = (int) ($this$laneInfo$iv2 >> 32);
                    }
                    laneInfo2.setLane(itemIndex2, i3);
                    int offset2 = m785maxInRangejy6DScQ(currentItemOffsets4, spanRange2) + measuredItem2.getSizeWithSpacings();
                    long value$iv$iv$iv = spanRange2;
                    minOffset = minOffset2;
                    int i15 = (int) (value$iv$iv$iv & 4294967295L);
                    int i$iv2 = (int) (value$iv$iv$iv >> 32);
                    while (i$iv2 < i15) {
                        int lane3 = i$iv2;
                        currentItemOffsets4[lane3] = offset2;
                        currentItemIndices2[lane3] = itemIndex2;
                        measuredItems2[lane3].addLast(measuredItem2);
                        i$iv2++;
                        offset2 = offset2;
                    }
                    if (currentItemOffsets4[(int) (spanRange2 >> 32)] <= minOffset + $this$measure.getMainAxisSpacing()) {
                        measuredItem2.setVisible(false);
                    }
                    long $this$isFullSpan$iv2 = spanRange2;
                    long value$iv$iv$iv$iv = $this$isFullSpan$iv2;
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext6 = $this$measure;
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = measuredItem2;
                    long j4 = $this$isFullSpan$iv2;
                    if (((int) (value$iv$iv$iv$iv & 4294967295L)) - ((int) (value$iv$iv$iv$iv >> 32)) != 1) {
                        initialItemsMeasured3 = $this$measure.getLaneCount();
                        lazyStaggeredGridMeasureContext2 = $this$measure;
                        initialLaneToMeasure6 = initialLaneToMeasure5;
                        laneToCheckForGaps4 = laneToCheckForGaps;
                        minOffset2 = minOffset;
                        firstItemIndices4 = firstItemIndices3;
                        scrollDelta = scrollDelta4;
                        str2 = str;
                        i11 = -1;
                    }
                } else {
                    scrollDelta4 = scrollDelta;
                    minOffset = minOffset2;
                    firstItemIndices3 = firstItemIndices4;
                    str = str2;
                    laneToCheckForGaps = laneToCheckForGaps4;
                    initialLaneToMeasure5 = initialLaneToMeasure7;
                    initialItemsMeasured2 = initialItemsMeasured4;
                }
                lazyStaggeredGridMeasureContext2 = $this$measure;
                initialLaneToMeasure6 = initialLaneToMeasure5;
                initialItemsMeasured3 = initialItemsMeasured2;
                laneToCheckForGaps4 = laneToCheckForGaps;
                minOffset2 = minOffset;
                firstItemIndices4 = firstItemIndices3;
                scrollDelta = scrollDelta4;
                str2 = str;
                i11 = -1;
            }
            int scrollDelta6 = scrollDelta;
            int minOffset3 = minOffset2;
            int[] firstItemIndices5 = firstItemIndices4;
            String str3 = str2;
            int i16 = laneToCheckForGaps4;
            while (true) {
                int[] $this$any$iv = currentItemOffsets4;
                int length5 = $this$any$iv.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length5) {
                        z = false;
                        break;
                    }
                    int it = $this$any$iv[i17];
                    if (it < maxOffset2 || it <= 0) {
                        z = true;
                        break;
                    }
                    i17++;
                }
                if (!z) {
                    ArrayDeque[] arrayDequeArr2 = measuredItems2;
                    int length6 = arrayDequeArr2.length;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= length6) {
                            z8 = true;
                            break;
                        } else if (!arrayDequeArr2[i18].isEmpty()) {
                            z8 = false;
                            break;
                        } else {
                            i18++;
                        }
                    }
                    if (!z8) {
                        itemCount2 = initialLaneToMeasure2;
                        break;
                    }
                }
                int currentLaneIndex = indexOfMinValue$default(currentItemOffsets4, 0, 1, (Object) null);
                int itemIndex3 = ArraysKt.maxOrThrow(currentItemIndices2) + 1;
                itemCount2 = initialLaneToMeasure2;
                if (itemIndex3 >= itemCount2) {
                    break;
                }
                int itemCount7 = itemCount2;
                int[] firstItemOffsets2 = gaps2;
                int[] currentItemOffsets5 = currentItemOffsets4;
                int maxOffset3 = maxOffset2;
                int initialLaneToMeasure8 = initialLaneToMeasure6;
                int[] firstItemIndices6 = firstItemIndices5;
                int scrollDelta7 = scrollDelta6;
                ArrayDeque[] measuredItems3 = measuredItems2;
                int[] currentItemIndices3 = currentItemIndices2;
                String str4 = str3;
                int initialItemsMeasured5 = initialItemsMeasured3;
                long spanRange3 = $this$measure.m782getSpanRangelOCCd4c($this$measure.getItemProvider(), itemIndex3, currentLaneIndex);
                LazyStaggeredGridLaneInfo laneInfo3 = $this$measure.getLaneInfo();
                long $this$laneInfo$iv3 = spanRange3;
                LazyStaggeredGridMeasureContext this_$iv = $this$measure;
                long $this$isFullSpan$iv$iv3 = $this$laneInfo$iv3;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext7 = this_$iv;
                int i19 = currentLaneIndex;
                int scrollDelta8 = scrollDelta7;
                if (((int) ($this$isFullSpan$iv$iv3 & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv3 >> 32)) != 1) {
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext8 = this_$iv;
                    i2 = -2;
                } else {
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext9 = this_$iv;
                    i2 = (int) ($this$laneInfo$iv3 >> 32);
                }
                laneInfo3.setLane(itemIndex3, i2);
                LazyStaggeredGridMeasuredItem measuredItem3 = $this$measure.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(itemIndex3, spanRange3);
                int[] currentItemOffsets6 = currentItemOffsets5;
                int offset3 = m785maxInRangejy6DScQ(currentItemOffsets6, spanRange3);
                long $this$isFullSpan$iv3 = spanRange3;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext10 = $this$measure;
                int[] firstItemIndices7 = firstItemIndices6;
                long j5 = $this$isFullSpan$iv3;
                if (((int) ($this$isFullSpan$iv3 & 4294967295L)) - ((int) ($this$isFullSpan$iv3 >> 32)) != 1) {
                    gaps = $this$measure.getLaneInfo().getGaps(itemIndex3);
                    if (gaps == null) {
                        gaps = new int[$this$measure.getLaneCount()];
                    }
                } else {
                    gaps = null;
                }
                long $this$forEach_u2dnIS5qE8$iv2 = spanRange3;
                int[] gaps4 = gaps;
                int i20 = (int) ($this$forEach_u2dnIS5qE8$iv2 & 4294967295L);
                for (int i$iv3 = (int) ($this$forEach_u2dnIS5qE8$iv2 >> 32); i$iv3 < i20; i$iv3++) {
                    int lane4 = i$iv3;
                    if (gaps4 != null) {
                        gaps4[lane4] = offset3 - currentItemOffsets6[lane4];
                    }
                    currentItemIndices3[lane4] = itemIndex3;
                    currentItemOffsets6[lane4] = measuredItem3.getSizeWithSpacings() + offset3;
                    measuredItems3[lane4].addLast(measuredItem3);
                }
                $this$measure.getLaneInfo().setGaps(itemIndex3, gaps4);
                if (currentItemOffsets6[(int) (spanRange3 >> 32)] <= minOffset3 + $this$measure.getMainAxisSpacing()) {
                    measuredItem3.setVisible(false);
                    currentItemOffsets4 = currentItemOffsets6;
                    initialLaneToMeasure4 = initialLaneToMeasure8;
                    measuredItems2 = measuredItems3;
                    initialItemsMeasured = initialItemsMeasured5;
                    gaps2 = firstItemOffsets2;
                    maxOffset2 = maxOffset3;
                    initialLaneToMeasure2 = itemCount7;
                    str3 = str4;
                    firstItemIndices5 = firstItemIndices7;
                    currentItemIndices2 = currentItemIndices3;
                    scrollDelta6 = scrollDelta8;
                } else {
                    currentItemOffsets4 = currentItemOffsets6;
                    initialLaneToMeasure4 = initialLaneToMeasure8;
                    measuredItems2 = measuredItems3;
                    initialItemsMeasured = initialItemsMeasured5;
                    gaps2 = firstItemOffsets2;
                    maxOffset2 = maxOffset3;
                    initialLaneToMeasure2 = itemCount7;
                    str3 = str4;
                    firstItemIndices5 = firstItemIndices7;
                    currentItemIndices2 = currentItemIndices3;
                    scrollDelta6 = scrollDelta8;
                }
            }
            int length7 = measuredItems2.length;
            for (int laneIndex3 = 0; laneIndex3 < length7; laneIndex3++) {
                ArrayDeque laneItems = measuredItems2[laneIndex3];
                while (laneItems.size() > 1 && !((LazyStaggeredGridMeasuredItem) laneItems.first()).isVisible()) {
                    LazyStaggeredGridMeasuredItem item = (LazyStaggeredGridMeasuredItem) laneItems.removeFirst();
                    int[] gaps5 = item.getSpan() != 1 ? $this$measure.getLaneInfo().getGaps(item.getIndex()) : null;
                    gaps2[laneIndex3] = gaps2[laneIndex3] - (item.getSizeWithSpacings() + (gaps5 == null ? 0 : gaps5[laneIndex3]));
                }
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) laneItems.firstOrNull();
                firstItemIndices5[laneIndex3] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            }
            int[] $this$any$iv2 = currentItemIndices2;
            int length8 = $this$any$iv2.length;
            int i21 = 0;
            while (true) {
                if (i21 >= length8) {
                    z2 = false;
                    break;
                }
                if (($this$any$iv2[i21] == itemCount2 + -1 ? 1 : 0) != 0) {
                    z2 = true;
                    break;
                }
                i21++;
            }
            if (z2) {
                offsetBy(currentItemOffsets4, -$this$measure.getMainAxisSpacing());
            }
            int[] $this$all$iv = currentItemOffsets4;
            int length9 = $this$all$iv.length;
            int i22 = 0;
            while (true) {
                if (i22 >= length9) {
                    z3 = true;
                    break;
                }
                if (($this$all$iv[i22] < $this$measure.getMainAxisAvailableSize() ? 1 : 0) == 0) {
                    z3 = false;
                    break;
                }
                i22++;
            }
            if (z3) {
                int maxOffsetLane3 = indexOfMaxValue(currentItemOffsets4);
                int toScrollBack2 = $this$measure.getMainAxisAvailableSize() - currentItemOffsets4[maxOffsetLane3];
                offsetBy(gaps2, -toScrollBack2);
                offsetBy(currentItemOffsets4, toScrollBack2);
                boolean gapDetected5 = false;
                while (true) {
                    int[] $this$any$iv3 = gaps2;
                    int length10 = $this$any$iv3.length;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= length10) {
                            maxOffsetLane = maxOffsetLane3;
                            gapDetected = gapDetected5;
                            maxOffsetLane2 = 0;
                            break;
                        }
                        maxOffsetLane = maxOffsetLane3;
                        gapDetected = gapDetected5;
                        if ($this$any$iv3[i23] < $this$measure.getBeforeContentPadding()) {
                            maxOffsetLane2 = 1;
                            break;
                        }
                        i23++;
                        maxOffsetLane3 = maxOffsetLane;
                        gapDetected5 = gapDetected;
                    }
                    if (maxOffsetLane2 == 0) {
                        currentItemOffsets3 = currentItemOffsets4;
                        maxOffset = maxOffset2;
                        int i24 = initialLaneToMeasure6;
                        firstItemIndices = firstItemIndices5;
                        scrollDelta3 = scrollDelta6;
                        itemCount3 = itemCount2;
                        currentItemIndices = currentItemIndices2;
                        gapDetected2 = gapDetected;
                        break;
                    }
                    int laneIndex4 = indexOfMinValue$default(gaps2, 0, 1, (Object) null);
                    if (laneIndex4 != indexOfMaxValue(firstItemIndices5)) {
                        gapDetected3 = true;
                    } else {
                        gapDetected3 = gapDetected;
                    }
                    if (firstItemIndices5[laneIndex4] == -1) {
                        currentIndex = itemCount2;
                    } else {
                        currentIndex = firstItemIndices5[laneIndex4];
                    }
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext11 = $this$measure;
                    int previousIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext11, currentIndex, laneIndex4);
                    if (previousIndex < 0) {
                        if (!gapDetected3) {
                            firstItemIndices = firstItemIndices5;
                            if (!measure$lambda$38$misalignedStart(firstItemIndices, lazyStaggeredGridMeasureContext11, gaps2, laneIndex4)) {
                                int i25 = currentIndex;
                                gapDetected4 = gapDetected3;
                                int i26 = initialLaneToMeasure6;
                                initialLaneToMeasure3 = scrollDelta6;
                                itemCount3 = itemCount2;
                                currentItemIndices = currentItemIndices2;
                                currentItemOffsets3 = currentItemOffsets4;
                                maxOffset = maxOffset2;
                                scrollDelta3 = initialLaneToMeasure3;
                                gapDetected2 = gapDetected4;
                            }
                        } else {
                            firstItemIndices = firstItemIndices5;
                        }
                        if (canRestartMeasure) {
                            $this$measure.getLaneInfo().reset();
                            int length11 = firstItemIndices.length;
                            int i27 = currentIndex;
                            int[] iArr8 = new int[length11];
                            boolean z9 = gapDetected3;
                            for (int i28 = 0; i28 < length11; i28++) {
                                iArr8[i28] = -1;
                            }
                            int length12 = gaps2.length;
                            int[] iArr9 = new int[length12];
                            int i29 = initialLaneToMeasure6;
                            for (int initialLaneToMeasure9 = 0; initialLaneToMeasure9 < length12; initialLaneToMeasure9++) {
                                iArr9[initialLaneToMeasure9] = gaps2[laneIndex4];
                            }
                            return measure(lazyStaggeredGridMeasureContext11, scrollDelta6, iArr8, iArr9, false);
                        }
                        gapDetected4 = gapDetected3;
                        int i30 = initialLaneToMeasure6;
                        initialLaneToMeasure3 = scrollDelta6;
                        itemCount3 = itemCount2;
                        currentItemIndices = currentItemIndices2;
                        currentItemOffsets3 = currentItemOffsets4;
                        maxOffset = maxOffset2;
                        scrollDelta3 = initialLaneToMeasure3;
                        gapDetected2 = gapDetected4;
                    } else {
                        boolean gapDetected6 = gapDetected3;
                        int initialLaneToMeasure10 = initialLaneToMeasure6;
                        int[] firstItemIndices8 = firstItemIndices5;
                        int initialLaneToMeasure11 = scrollDelta6;
                        int itemCount8 = itemCount2;
                        long spanRange4 = lazyStaggeredGridMeasureContext11.m782getSpanRangelOCCd4c($this$measure.getItemProvider(), previousIndex, laneIndex4);
                        LazyStaggeredGridLaneInfo laneInfo4 = $this$measure.getLaneInfo();
                        long $this$laneInfo$iv4 = spanRange4;
                        long $this$isFullSpan$iv$iv4 = $this$laneInfo$iv4;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext12 = $this$measure;
                        int[] currentItemIndices4 = currentItemIndices2;
                        int[] currentItemOffsets7 = currentItemOffsets4;
                        int maxOffset4 = maxOffset2;
                        if (((int) ($this$isFullSpan$iv$iv4 & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv4 >> 32)) != 1) {
                            int i31 = laneIndex4;
                            i = -2;
                        } else {
                            int i32 = laneIndex4;
                            i = (int) ($this$laneInfo$iv4 >> 32);
                        }
                        laneInfo4.setLane(previousIndex, i);
                        LazyStaggeredGridMeasuredItem measuredItem4 = $this$measure.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(previousIndex, spanRange4);
                        int offset4 = m785maxInRangejy6DScQ(gaps2, spanRange4);
                        long $this$isFullSpan$iv4 = spanRange4;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext13 = $this$measure;
                        int scrollDelta9 = initialLaneToMeasure11;
                        long j6 = $this$isFullSpan$iv4;
                        int[] gaps6 = ((int) ($this$isFullSpan$iv4 & 4294967295L)) - ((int) ($this$isFullSpan$iv4 >> 32)) != 1 ? $this$measure.getLaneInfo().getGaps(previousIndex) : null;
                        long value$iv$iv$iv2 = spanRange4;
                        long j7 = spanRange4;
                        int i$iv4 = (int) (value$iv$iv$iv2 >> 32);
                        int i33 = (int) (value$iv$iv$iv2 & 4294967295L);
                        gapDetected5 = gapDetected6;
                        while (i$iv4 < i33) {
                            int lane5 = i$iv4;
                            int i34 = i33;
                            if (gaps2[lane5] != offset4) {
                                gapDetected5 = true;
                            }
                            measuredItems2[lane5].addFirst(measuredItem4);
                            firstItemIndices8[lane5] = previousIndex;
                            gaps2[lane5] = offset4 + measuredItem4.getSizeWithSpacings() + (gaps6 == null ? 0 : gaps6[lane5]);
                            i$iv4++;
                            i33 = i34;
                        }
                        maxOffsetLane3 = maxOffsetLane;
                        initialLaneToMeasure6 = initialLaneToMeasure10;
                        itemCount2 = itemCount8;
                        currentItemIndices2 = currentItemIndices4;
                        maxOffset2 = maxOffset4;
                        currentItemOffsets4 = currentItemOffsets7;
                        firstItemIndices5 = firstItemIndices8;
                        scrollDelta6 = scrollDelta9;
                    }
                }
                if (!gapDetected2 || !canRestartMeasure) {
                    lazyStaggeredGridMeasureContext = $this$measure;
                    int scrollDelta10 = scrollDelta3 + toScrollBack2;
                    int minOffsetLane = indexOfMinValue$default(gaps2, 0, 1, (Object) null);
                    if (gaps2[minOffsetLane] < 0) {
                        int offsetValue = gaps2[minOffsetLane];
                        currentItemOffsets = currentItemOffsets3;
                        offsetBy(currentItemOffsets, offsetValue);
                        offsetBy(gaps2, -offsetValue);
                        toScrollBack = scrollDelta10 + offsetValue;
                    } else {
                        currentItemOffsets = currentItemOffsets3;
                        toScrollBack = scrollDelta10;
                    }
                } else {
                    $this$measure.getLaneInfo().reset();
                    return measure($this$measure, scrollDelta3, firstItemIndices, gaps2, false);
                }
            } else {
                currentItemOffsets = currentItemOffsets4;
                maxOffset = maxOffset2;
                int i35 = initialLaneToMeasure6;
                firstItemIndices = firstItemIndices5;
                int scrollDelta11 = scrollDelta6;
                itemCount3 = itemCount2;
                currentItemIndices = currentItemIndices2;
                lazyStaggeredGridMeasureContext = $this$measure;
                toScrollBack = scrollDelta11;
            }
            if (MathKt.getSign(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed$foundation_release())) != MathKt.getSign(toScrollBack) || Math.abs(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed$foundation_release())) < Math.abs(toScrollBack)) {
                consumedScroll = $this$measure.getState().getScrollToBeConsumed$foundation_release();
            } else {
                consumedScroll = (float) toScrollBack;
            }
            int[] itemScrollOffsets = Arrays.copyOf(gaps2, gaps2.length);
            Intrinsics.checkNotNullExpressionValue(itemScrollOffsets, str3);
            int length13 = itemScrollOffsets.length;
            for (int i$iv5 = 0; i$iv5 < length13; i$iv5++) {
                itemScrollOffsets[i$iv5] = -itemScrollOffsets[i$iv5];
            }
            if ($this$measure.getBeforeContentPadding() > $this$measure.getMainAxisSpacing()) {
                int laneIndex5 = 0;
                int length14 = measuredItems2.length;
                while (laneIndex5 < length14) {
                    ArrayDeque laneItems2 = measuredItems2[laneIndex5];
                    int i36 = 0;
                    int size = laneItems2.size();
                    while (true) {
                        if (i36 >= size) {
                            scrollDelta2 = toScrollBack;
                            break;
                        }
                        LazyStaggeredGridMeasuredItem item2 = (LazyStaggeredGridMeasuredItem) laneItems2.get(i36);
                        scrollDelta2 = toScrollBack;
                        int[] gaps7 = $this$measure.getLaneInfo().getGaps(item2.getIndex());
                        int size2 = item2.getSizeWithSpacings() + (gaps7 == null ? 0 : gaps7[laneIndex5]);
                        int[] iArr10 = gaps7;
                        if (i36 == CollectionsKt.getLastIndex(laneItems2) || gaps2[laneIndex5] == 0 || gaps2[laneIndex5] < size2) {
                            break;
                        }
                        gaps2[laneIndex5] = gaps2[laneIndex5] - size2;
                        firstItemIndices[laneIndex5] = ((LazyStaggeredGridMeasuredItem) laneItems2.get(i36 + 1)).getIndex();
                        i36++;
                        toScrollBack = scrollDelta2;
                    }
                    laneIndex5++;
                    toScrollBack = scrollDelta2;
                }
                int scrollDelta12 = toScrollBack;
            } else {
                int scrollDelta13 = toScrollBack;
            }
            int contentPadding = $this$measure.getBeforeContentPadding() + $this$measure.getAfterContentPadding();
            if ($this$measure.isVertical()) {
                layoutWidth = Constraints.m5788getMaxWidthimpl($this$measure.m779getConstraintsmsEJaDk());
            } else {
                layoutWidth = ConstraintsKt.m5802constrainWidthK40F9xA($this$measure.m779getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(currentItemOffsets) + contentPadding);
            }
            if ($this$measure.isVertical()) {
                layoutHeight = ConstraintsKt.m5801constrainHeightK40F9xA($this$measure.m779getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(currentItemOffsets) + contentPadding);
            } else {
                layoutHeight = Constraints.m5787getMaxHeightimpl($this$measure.m779getConstraintsmsEJaDk());
            }
            int mainAxisLayoutSize = (Math.min($this$measure.isVertical() ? layoutHeight : layoutWidth, $this$measure.getMainAxisAvailableSize()) - $this$measure.getBeforeContentPadding()) + $this$measure.getAfterContentPadding();
            int extraItemOffset = itemScrollOffsets[0];
            LazyStaggeredGridMeasureContext $this$calculateExtraItems$iv = $this$measure;
            List list = null;
            int i37 = contentPadding;
            List $this$fastForEach$iv$iv2 = $this$calculateExtraItems$iv.getPinnedItems();
            int extraItemOffset2 = extraItemOffset;
            int extraItemOffset3 = $this$fastForEach$iv$iv2.size();
            int index$iv$iv = 0;
            while (index$iv$iv < extraItemOffset3) {
                List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
                int index$iv = $this$fastForEach$iv$iv2.get(index$iv$iv).intValue();
                int i38 = extraItemOffset3;
                int initialItemsMeasured6 = initialItemsMeasured3;
                int initialItemsMeasured7 = index$iv;
                int lane6 = $this$measure.getLaneInfo().getLane(initialItemsMeasured7);
                switch (lane6) {
                    case -2:
                    case -1:
                        firstItemOffsets = gaps2;
                        currentItemOffsets2 = currentItemOffsets;
                        int[] $this$all$iv2 = firstItemIndices;
                        int length15 = $this$all$iv2.length;
                        layoutHeight2 = layoutHeight;
                        int layoutHeight3 = 0;
                        while (true) {
                            if (layoutHeight3 >= length15) {
                                z7 = true;
                                break;
                            } else {
                                int i39 = length15;
                                if (($this$all$iv2[layoutHeight3] > initialItemsMeasured7 ? 1 : 0) == 0) {
                                    z7 = false;
                                    break;
                                } else {
                                    layoutHeight3++;
                                    length15 = i39;
                                }
                            }
                        }
                    default:
                        layoutHeight2 = layoutHeight;
                        firstItemOffsets = gaps2;
                        currentItemOffsets2 = currentItemOffsets;
                        if (firstItemIndices[lane6] <= initialItemsMeasured7) {
                            z7 = false;
                            break;
                        } else {
                            z7 = true;
                            break;
                        }
                }
                if (z7) {
                    firstItemIndices2 = firstItemIndices;
                    long spanRange$iv = $this$calculateExtraItems$iv.m782getSpanRangelOCCd4c($this$calculateExtraItems$iv.getItemProvider(), index$iv, 0);
                    if (list == null) {
                        list = (List) new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem measuredItem$iv = $this$calculateExtraItems$iv.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(index$iv, spanRange$iv);
                    LazyStaggeredGridMeasuredItem it2 = measuredItem$iv;
                    int i40 = index$iv;
                    int extraItemOffset4 = extraItemOffset2 - it2.getSizeWithSpacings();
                    it2.position(extraItemOffset4, 0, mainAxisLayoutSize);
                    list.add(measuredItem$iv);
                    extraItemOffset2 = extraItemOffset4;
                } else {
                    firstItemIndices2 = firstItemIndices;
                }
                index$iv$iv++;
                firstItemIndices = firstItemIndices2;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv3;
                extraItemOffset3 = i38;
                initialItemsMeasured3 = initialItemsMeasured6;
                gaps2 = firstItemOffsets;
                currentItemOffsets = currentItemOffsets2;
                layoutHeight = layoutHeight2;
            }
            int layoutHeight4 = layoutHeight;
            int[] firstItemOffsets3 = gaps2;
            int[] currentItemOffsets8 = currentItemOffsets;
            int i41 = initialItemsMeasured3;
            int[] firstItemIndices9 = firstItemIndices;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List extraItemsBefore = list;
            List<LazyStaggeredGridMeasuredItem> calculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext, measuredItems2, itemScrollOffsets, mainAxisLayoutSize);
            int extraItemOffset5 = itemScrollOffsets[0];
            LazyStaggeredGridMeasureContext $this$calculateExtraItems$iv2 = $this$measure;
            int $i$f$calculateExtraItems = 0;
            List extraItemsAfter = null;
            List $this$fastForEach$iv$iv4 = $this$calculateExtraItems$iv2.getPinnedItems();
            int $i$f$fastForEach = false;
            int index$iv$iv2 = 0;
            int[] iArr11 = itemScrollOffsets;
            int size3 = $this$fastForEach$iv$iv4.size();
            while (index$iv$iv2 < size3) {
                int i42 = size3;
                int index$iv2 = $this$fastForEach$iv$iv4.get(index$iv$iv2).intValue();
                int $i$f$fastForEach2 = $i$f$fastForEach;
                int $i$f$fastForEach3 = itemCount3;
                int $i$f$calculateExtraItems2 = $i$f$calculateExtraItems;
                int itemIndex4 = index$iv2;
                if (itemIndex4 < $i$f$fastForEach3) {
                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv4;
                    int lane7 = $this$measure.getLaneInfo().getLane(itemIndex4);
                    switch (lane7) {
                        case -2:
                        case -1:
                            measuredItems = measuredItems2;
                            int[] $this$all$iv3 = currentItemIndices;
                            int length16 = $this$all$iv3.length;
                            itemCount4 = $i$f$fastForEach3;
                            int itemCount9 = 0;
                            while (true) {
                                if (itemCount9 >= length16) {
                                    z6 = true;
                                    break;
                                } else {
                                    int i43 = length16;
                                    if (($this$all$iv3[itemCount9] < itemIndex4 ? 1 : 0) == 0) {
                                        z6 = false;
                                        break;
                                    } else {
                                        itemCount9++;
                                        length16 = i43;
                                    }
                                }
                            }
                        default:
                            measuredItems = measuredItems2;
                            itemCount4 = $i$f$fastForEach3;
                            if (currentItemIndices[lane7] >= itemIndex4) {
                                z6 = false;
                                break;
                            } else {
                                z6 = true;
                                break;
                            }
                    }
                } else {
                    measuredItems = measuredItems2;
                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv4;
                    itemCount4 = $i$f$fastForEach3;
                    z6 = false;
                }
                if (z6) {
                    long spanRange$iv2 = $this$calculateExtraItems$iv2.m782getSpanRangelOCCd4c($this$calculateExtraItems$iv2.getItemProvider(), index$iv2, 0);
                    if (extraItemsAfter == null) {
                        extraItemsAfter = (List) new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem measuredItem$iv2 = $this$calculateExtraItems$iv2.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(index$iv2, spanRange$iv2);
                    LazyStaggeredGridMeasuredItem it3 = measuredItem$iv2;
                    int i44 = index$iv2;
                    it3.position(extraItemOffset5, 0, mainAxisLayoutSize);
                    extraItemOffset5 += it3.getSizeWithSpacings();
                    extraItemsAfter.add(measuredItem$iv2);
                }
                index$iv$iv2++;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext14 = $this$measure;
                size3 = i42;
                $i$f$calculateExtraItems = $i$f$calculateExtraItems2;
                $i$f$fastForEach = $i$f$fastForEach2;
                $this$fastForEach$iv$iv4 = $this$fastForEach$iv$iv;
                measuredItems2 = measuredItems;
                itemCount3 = itemCount4;
            }
            List list2 = $this$fastForEach$iv$iv4;
            int i45 = $i$f$fastForEach;
            int itemCount10 = itemCount3;
            ArrayDeque[] arrayDequeArr3 = measuredItems2;
            if (extraItemsAfter == null) {
                extraItemsAfter = CollectionsKt.emptyList();
            }
            List positionedItems = new ArrayList();
            positionedItems.addAll(extraItemsBefore);
            positionedItems.addAll(calculateVisibleItems);
            positionedItems.addAll(extraItemsAfter);
            $this$measure.getState().getPlacementAnimator$foundation_release().onMeasured((int) consumedScroll, layoutWidth, layoutHeight4, positionedItems, $this$measure.getMeasuredItemProvider(), $this$measure.isVertical(), $this$measure.getLaneCount());
            boolean canScrollBackward = firstItemIndices9[0] != 0 || firstItemOffsets3[0] > 0;
            int[] $this$any$iv4 = currentItemOffsets8;
            int length17 = $this$any$iv4.length;
            int i46 = 0;
            while (true) {
                if (i46 < length17) {
                    List extraItemsBefore2 = extraItemsBefore;
                    if ($this$any$iv4[i46] > $this$measure.getMainAxisAvailableSize()) {
                        z4 = true;
                    } else {
                        i46++;
                        extraItemsBefore = extraItemsBefore2;
                    }
                } else {
                    z4 = false;
                }
            }
            if (!z4) {
                int[] $this$all$iv4 = currentItemIndices;
                int length18 = $this$all$iv4.length;
                int i47 = 0;
                while (true) {
                    if (i47 < length18) {
                        if (($this$all$iv4[i47] < itemCount10 + -1 ? 1 : 0) == 0) {
                            z5 = false;
                        } else {
                            i47++;
                        }
                    } else {
                        z5 = true;
                    }
                }
                if (!z5) {
                    canScrollForward = false;
                    return new LazyStaggeredGridMeasureResult(firstItemIndices9, firstItemOffsets3, consumedScroll, MeasureScope.layout$default($this$measure_u24lambda_u2438, layoutWidth, layoutHeight4, (Map) null, new LazyStaggeredGridMeasureKt$measure$1$29(positionedItems, $this$measure), 4, (Object) null), canScrollForward, canScrollBackward, $this$measure.isVertical(), itemCount10, calculateVisibleItems, IntSizeKt.IntSize(layoutWidth, layoutHeight4), minOffset3, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), (DefaultConstructorMarker) null);
                }
            }
            canScrollForward = true;
            return new LazyStaggeredGridMeasureResult(firstItemIndices9, firstItemOffsets3, consumedScroll, MeasureScope.layout$default($this$measure_u24lambda_u2438, layoutWidth, layoutHeight4, (Map) null, new LazyStaggeredGridMeasureKt$measure$1$29(positionedItems, $this$measure), 4, (Object) null), canScrollForward, canScrollBackward, $this$measure.isVertical(), itemCount10, calculateVisibleItems, IntSizeKt.IntSize(layoutWidth, layoutHeight4), minOffset3, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), (DefaultConstructorMarker) null);
        }
        return new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0.0f, MeasureScope.layout$default($this$measure_u24lambda_u2438, Constraints.m5790getMinWidthimpl($this$measure.m779getConstraintsmsEJaDk()), Constraints.m5789getMinHeightimpl($this$measure.m779getConstraintsmsEJaDk()), (Map) null, LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE, 4, (Object) null), false, false, $this$measure.isVertical(), itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m5790getMinWidthimpl($this$measure.m779getConstraintsmsEJaDk()), Constraints.m5789getMinHeightimpl($this$measure.m779getConstraintsmsEJaDk())), -$this$measure.getBeforeContentPadding(), $this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), (DefaultConstructorMarker) null);
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] firstItemIndices, int[] firstItemOffsets, LazyStaggeredGridMeasureContext $this_measure) {
        int length = firstItemIndices.length;
        for (int lane = 0; lane < length; lane++) {
            int itemIndex = firstItemIndices[lane];
            if (firstItemOffsets[lane] < Math.max(-$this_measure.getMainAxisSpacing(), 0) && itemIndex > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] firstItemIndices, LazyStaggeredGridMeasureContext $this_measure, int[] firstItemOffsets, int referenceLane) {
        int lane = 0;
        int length = firstItemIndices.length;
        while (true) {
            boolean misalignedOffsets = false;
            if (lane < length) {
                if (findPreviousItemIndex($this_measure, firstItemIndices[lane], lane) == -1 && firstItemOffsets[lane] != firstItemOffsets[referenceLane]) {
                    misalignedOffsets = true;
                }
                if (misalignedOffsets) {
                    return true;
                }
                lane++;
            } else {
                int length2 = firstItemIndices.length;
                for (int lane2 = 0; lane2 < length2; lane2++) {
                    if (findPreviousItemIndex($this_measure, firstItemIndices[lane2], lane2) != -1 && firstItemOffsets[lane2] >= firstItemOffsets[referenceLane]) {
                        return true;
                    }
                }
                int firstItemLane = $this_measure.getLaneInfo().getLane(0);
                if (firstItemLane == 0 || firstItemLane == -1 || firstItemLane == -2) {
                    return false;
                }
                return true;
            }
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext $this$calculateVisibleItems, ArrayDeque<LazyStaggeredGridMeasuredItem>[] measuredItems, int[] itemScrollOffsets, int mainAxisLayoutSize) {
        boolean z;
        ArrayDeque[] arrayDequeArr = measuredItems;
        int[] iArr = itemScrollOffsets;
        int i = 0;
        for (ArrayDeque it : arrayDequeArr) {
            i += it.size();
        }
        ArrayList positionedItems = new ArrayList(i);
        while (true) {
            ArrayDeque[] arrayDequeArr2 = measuredItems;
            int length = arrayDequeArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                z = true;
                if (!arrayDequeArr2[i2].isEmpty()) {
                    break;
                }
                i2++;
            }
            if (z) {
                ArrayDeque[] arrayDequeArr3 = measuredItems;
                int result$iv = -1;
                int min$iv = Integer.MAX_VALUE;
                int length2 = arrayDequeArr3.length;
                for (int i$iv = 0; i$iv < length2; i$iv++) {
                    LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr3[i$iv].firstOrNull();
                    int value$iv = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                    if (min$iv > value$iv) {
                        min$iv = value$iv;
                        result$iv = i$iv;
                    }
                }
                int laneIndex = result$iv;
                LazyStaggeredGridMeasuredItem item = arrayDequeArr[laneIndex].removeFirst();
                if (item.getLane() == laneIndex) {
                    long spanRange = SpanRange.m798constructorimpl(item.getLane(), item.getSpan());
                    int mainAxisOffset = m785maxInRangejy6DScQ(iArr, spanRange);
                    int crossAxisOffset = $this$calculateVisibleItems.getResolvedSlots().getPositions()[laneIndex];
                    if (item.getPlaceablesCount() != 0) {
                        item.position(mainAxisOffset, crossAxisOffset, mainAxisLayoutSize);
                        positionedItems.add(item);
                        long $this$forEach_u2dnIS5qE8$iv = spanRange;
                        int i3 = laneIndex;
                        int i4 = (int) ($this$forEach_u2dnIS5qE8$iv & 4294967295L);
                        for (int i$iv2 = (int) ($this$forEach_u2dnIS5qE8$iv >> 32); i$iv2 < i4; i$iv2++) {
                            iArr[i$iv2] = mainAxisOffset + item.getSizeWithSpacings();
                        }
                    }
                }
            } else {
                int i5 = mainAxisLayoutSize;
                return positionedItems;
            }
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext $this$calculateExtraItems, Function1<? super LazyStaggeredGridMeasuredItem, Unit> position, Function1<? super Integer, Boolean> filter) {
        List<LazyStaggeredGridMeasuredItem> list = null;
        List $this$fastForEach$iv = $this$calculateExtraItems.getPinnedItems();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int index = $this$fastForEach$iv.get(index$iv).intValue();
            if (filter.invoke(Integer.valueOf(index)).booleanValue()) {
                long spanRange = $this$calculateExtraItems.m782getSpanRangelOCCd4c($this$calculateExtraItems.getItemProvider(), index, 0);
                if (list == null) {
                    list = (List) new ArrayList();
                }
                LazyStaggeredGridMeasuredItem measuredItem = $this$calculateExtraItems.getMeasuredItemProvider().m790getAndMeasurejy6DScQ(index, spanRange);
                position.invoke(measuredItem);
                list.add(measuredItem);
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m784forEachnIS5qE8(long $this$forEach_u2dnIS5qE8, Function1<? super Integer, Unit> block) {
        int i = (int) (4294967295L & $this$forEach_u2dnIS5qE8);
        for (int i2 = (int) ($this$forEach_u2dnIS5qE8 >> 32); i2 < i; i2++) {
            block.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] $this$offsetBy, int delta) {
        int length = $this$offsetBy.length;
        for (int i = 0; i < length; i++) {
            $this$offsetBy[i] = $this$offsetBy[i] + delta;
        }
    }

    /* renamed from: maxInRange-jy6DScQ  reason: not valid java name */
    private static final int m785maxInRangejy6DScQ(int[] $this$maxInRange_u2djy6DScQ, long indexRange) {
        int max = Integer.MIN_VALUE;
        long $this$forEach_u2dnIS5qE8$iv = indexRange;
        int i = (int) (4294967295L & $this$forEach_u2dnIS5qE8$iv);
        for (int i$iv = (int) ($this$forEach_u2dnIS5qE8$iv >> 32); i$iv < i; i$iv++) {
            max = Math.max(max, $this$maxInRange_u2djy6DScQ[i$iv]);
        }
        return max;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] $this$indexOfMinValue, int minBound) {
        Intrinsics.checkNotNullParameter($this$indexOfMinValue, "<this>");
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = $this$indexOfMinValue.length;
        for (int i = 0; i < length; i++) {
            int i2 = minBound + 1;
            int i3 = $this$indexOfMinValue[i];
            boolean z = false;
            if (i2 <= i3 && i3 < min) {
                z = true;
            }
            if (z) {
                min = $this$indexOfMinValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final <T> int indexOfMinBy(T[] $this$indexOfMinBy, Function1<? super T, Integer> block) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = $this$indexOfMinBy.length;
        for (int i = 0; i < length; i++) {
            int value = block.invoke($this$indexOfMinBy[i]).intValue();
            if (min > value) {
                min = value;
                result = i;
            }
        }
        return result;
    }

    private static final int indexOfMaxValue(int[] $this$indexOfMaxValue) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int length = $this$indexOfMaxValue.length;
        for (int i = 0; i < length; i++) {
            if (max < $this$indexOfMaxValue[i]) {
                max = $this$indexOfMaxValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final int[] transform(int[] $this$transform, Function1<? super Integer, Integer> block) {
        int length = $this$transform.length;
        for (int i = 0; i < length; i++) {
            $this$transform[i] = block.invoke(Integer.valueOf($this$transform[i])).intValue();
        }
        return $this$transform;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext $this$ensureIndicesInRange, int[] indices, int itemCount) {
        int length = indices.length - 1;
        if (length >= 0) {
            do {
                int i = length;
                length--;
                while (true) {
                    if (indices[i] < itemCount && $this$ensureIndicesInRange.getLaneInfo().assignedToLane(indices[i], i)) {
                        break;
                    }
                    indices[i] = findPreviousItemIndex($this$ensureIndicesInRange, indices[i], i);
                }
                if (indices[i] >= 0 && !$this$ensureIndicesInRange.isFullSpan($this$ensureIndicesInRange.getItemProvider(), indices[i])) {
                    $this$ensureIndicesInRange.getLaneInfo().setLane(indices[i], i);
                    continue;
                }
            } while (length >= 0);
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext $this$findPreviousItemIndex, int item, int lane) {
        return $this$findPreviousItemIndex.getLaneInfo().findPreviousItemIndex(item, lane);
    }
}
