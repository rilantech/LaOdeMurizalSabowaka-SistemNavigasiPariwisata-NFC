package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\bø\u0001\u0000\u001a\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aè\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012/\u00101\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040\b¢\u0006\u0002\b5\u0012\u0004\u0012\u00020602H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "itemConstraints", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "filter", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-ZRKPzZ8", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Ljava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasure.kt */
public final class LazyGridMeasureKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureLazyGrid-ZRKPzZ8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m711measureLazyGridZRKPzZ8(int r43, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r44, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r45, int r46, int r47, int r48, int r49, int r50, int r51, float r52, long r53, boolean r55, androidx.compose.foundation.layout.Arrangement.Vertical r56, androidx.compose.foundation.layout.Arrangement.Horizontal r57, boolean r58, androidx.compose.ui.unit.Density r59, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r60, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider r61, java.util.List<java.lang.Integer> r62, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r63) {
        /*
            r14 = r43
            r15 = r44
            r13 = r47
            r11 = r53
            r10 = r63
            java.lang.String r0 = "measuredLineProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "measuredItemProvider"
            r9 = r45
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "density"
            r8 = r59
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "placementAnimator"
            r7 = r60
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "spanLayoutProvider"
            r6 = r61
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "pinnedItems"
            r3 = r62
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r29 = 1
            if (r13 < 0) goto L_0x0044
            r1 = r29
            goto L_0x0045
        L_0x0044:
            r1 = 0
        L_0x0045:
            java.lang.String r2 = "Failed requirement."
            if (r1 == 0) goto L_0x0534
            if (r48 < 0) goto L_0x004e
            r1 = r29
            goto L_0x004f
        L_0x004e:
            r1 = 0
        L_0x004f:
            if (r1 == 0) goto L_0x052a
            if (r14 > 0) goto L_0x009f
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r0 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            int r1 = androidx.compose.ui.unit.Constraints.m5790getMinWidthimpl(r53)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = androidx.compose.ui.unit.Constraints.m5789getMinHeightimpl(r53)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1 r4 = androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1.INSTANCE
            java.lang.Object r1 = r10.invoke(r1, r2, r4)
            r21 = r1
            androidx.compose.ui.layout.MeasureResult r21 = (androidx.compose.ui.layout.MeasureResult) r21
            java.util.List r22 = kotlin.collections.CollectionsKt.emptyList()
            int r1 = -r13
            int r24 = r46 + r48
            if (r55 == 0) goto L_0x0081
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0083
        L_0x0081:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0083:
            r27 = r2
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r25 = 0
            r16 = r0
            r23 = r1
            r26 = r58
            r28 = r48
            r29 = r49
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x009f:
            r1 = r50
            r4 = r51
            int r5 = kotlin.math.MathKt.roundToInt((float) r52)
            int r4 = r4 - r5
            if (r1 != 0) goto L_0x00ae
            if (r4 >= 0) goto L_0x00ae
            int r5 = r5 + r4
            r4 = 0
        L_0x00ae:
            kotlin.collections.ArrayDeque r16 = new kotlin.collections.ArrayDeque
            r16.<init>()
            r30 = r16
            int r0 = -r13
            if (r49 >= 0) goto L_0x00bb
            r16 = r49
            goto L_0x00bd
        L_0x00bb:
            r16 = 0
        L_0x00bd:
            int r0 = r0 + r16
            r32 = r46
            int r4 = r4 + r0
        L_0x00c2:
            if (r4 >= 0) goto L_0x00e1
            if (r1 <= 0) goto L_0x00e1
            int r3 = r1 + -1
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r6 = r15.getAndMeasure(r3)
            r7 = r30
            r8 = 0
            r7.add(r8, r6)
            int r8 = r6.getMainAxisSizeWithSpacings()
            int r4 = r4 + r8
            r1 = r3
            r8 = r59
            r6 = r61
            r3 = r62
            r7 = r60
            goto L_0x00c2
        L_0x00e1:
            r7 = r30
            if (r4 >= r0) goto L_0x00e7
            int r5 = r5 + r4
            r4 = r0
        L_0x00e7:
            int r4 = r4 - r0
            r3 = 0
            r3 = r1
            r8 = r32
            int r6 = r8 + r48
            r16 = r1
            r1 = 0
            int r6 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r1)
            r1 = 0
            int r1 = -r4
            r17 = r1
            r1 = r7
            java.util.List r1 = (java.util.List) r1
            r18 = 0
            r19 = 0
            r20 = r3
            int r3 = r1.size()
            r42 = r19
            r19 = r4
            r4 = r42
        L_0x010d:
            if (r4 >= r3) goto L_0x0126
            java.lang.Object r21 = r1.get(r4)
            r22 = r21
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r22 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r22
            r23 = 0
            int r20 = r20 + 1
            int r24 = r22.getMainAxisSizeWithSpacings()
            int r17 = r17 + r24
            int r4 = r4 + 1
            goto L_0x010d
        L_0x0126:
            r1 = r16
            r3 = r17
            r4 = r19
            r9 = r20
        L_0x012e:
            if (r9 >= r14) goto L_0x0187
            if (r3 < r6) goto L_0x0140
            if (r3 <= 0) goto L_0x0140
            boolean r16 = r7.isEmpty()
            if (r16 == 0) goto L_0x013b
            goto L_0x0140
        L_0x013b:
            r30 = r0
            r16 = r1
            goto L_0x018b
        L_0x0140:
            r16 = r1
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r1 = r15.getAndMeasure(r9)
            boolean r17 = r1.isEmpty()
            if (r17 == 0) goto L_0x014f
            r30 = r0
            goto L_0x018b
        L_0x014f:
            int r17 = r1.getMainAxisSizeWithSpacings()
            int r3 = r3 + r17
            if (r3 > r0) goto L_0x0177
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r17 = r1.getItems()
            java.lang.Object r17 = kotlin.collections.ArraysKt.last((T[]) r17)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r17 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r17
            r30 = r0
            int r0 = r17.getIndex()
            r17 = r3
            int r3 = r14 + -1
            if (r0 == r3) goto L_0x017b
            int r0 = r9 + 1
            int r3 = r1.getMainAxisSizeWithSpacings()
            int r4 = r4 - r3
            r16 = r0
            goto L_0x017e
        L_0x0177:
            r30 = r0
            r17 = r3
        L_0x017b:
            r7.add(r1)
        L_0x017e:
            int r9 = r9 + 1
            r1 = r16
            r3 = r17
            r0 = r30
            goto L_0x012e
        L_0x0187:
            r30 = r0
            r16 = r1
        L_0x018b:
            if (r3 >= r8) goto L_0x01cf
            int r32 = r8 - r3
            int r4 = r4 - r32
            int r3 = r3 + r32
            r1 = r16
        L_0x0195:
            if (r4 >= r13) goto L_0x01b7
            if (r1 <= 0) goto L_0x01b1
            int r0 = r1 + -1
            r16 = r1
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r1 = r15.getAndMeasure(r0)
            r17 = r6
            r6 = 0
            r7.add(r6, r1)
            int r18 = r1.getMainAxisSizeWithSpacings()
            int r4 = r4 + r18
            r1 = r0
            r6 = r17
            goto L_0x0195
        L_0x01b1:
            r16 = r1
            r17 = r6
            r6 = 0
            goto L_0x01bc
        L_0x01b7:
            r16 = r1
            r17 = r6
            r6 = 0
        L_0x01bc:
            int r5 = r5 + r32
            if (r4 >= 0) goto L_0x01c9
            int r5 = r5 + r4
            int r3 = r3 + r4
            r4 = 0
            r0 = r3
            r3 = r4
            r1 = r5
            r31 = r16
            goto L_0x01d7
        L_0x01c9:
            r0 = r3
            r3 = r4
            r1 = r5
            r31 = r16
            goto L_0x01d7
        L_0x01cf:
            r17 = r6
            r6 = 0
            r0 = r3
            r3 = r4
            r1 = r5
            r31 = r16
        L_0x01d7:
            int r4 = kotlin.math.MathKt.roundToInt((float) r52)
            int r4 = kotlin.math.MathKt.getSign((int) r4)
            int r5 = kotlin.math.MathKt.getSign((int) r1)
            if (r4 != r5) goto L_0x01f5
            int r4 = kotlin.math.MathKt.roundToInt((float) r52)
            int r4 = java.lang.Math.abs(r4)
            int r5 = java.lang.Math.abs(r1)
            if (r4 < r5) goto L_0x01f5
            float r4 = (float) r1
            goto L_0x01f7
        L_0x01f5:
            r4 = r52
        L_0x01f7:
            if (r3 < 0) goto L_0x01fd
            r5 = r29
            goto L_0x01fe
        L_0x01fd:
            r5 = r6
        L_0x01fe:
            if (r5 == 0) goto L_0x051d
            int r2 = -r3
            java.lang.Object r5 = r7.first()
            r16 = r5
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r16 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r16
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r5 = r16.getItems()
            java.lang.Object r5 = kotlin.collections.ArraysKt.firstOrNull((T[]) r5)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r5 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r5
            if (r5 == 0) goto L_0x021a
            int r5 = r5.getIndex()
            goto L_0x021b
        L_0x021a:
            r5 = r6
        L_0x021b:
            java.lang.Object r18 = r7.lastOrNull()
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r18 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r18
            if (r18 == 0) goto L_0x0236
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r18 = r18.getItems()
            if (r18 == 0) goto L_0x0236
            java.lang.Object r18 = kotlin.collections.ArraysKt.lastOrNull((T[]) r18)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r18 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r18
            if (r18 == 0) goto L_0x0236
            int r18 = r18.getIndex()
            goto L_0x0238
        L_0x0236:
            r18 = r6
        L_0x0238:
            r32 = r18
            r18 = 0
            r19 = 0
            r20 = r62
            r21 = 0
            r22 = 0
            r23 = r7
            int r7 = r20.size()
            r6 = r22
        L_0x024d:
            if (r6 >= r7) goto L_0x02ec
            r24 = r7
            r7 = r20
            java.lang.Object r20 = r7.get(r6)
            r25 = r20
            java.lang.Number r25 = (java.lang.Number) r25
            int r25 = r25.intValue()
            r26 = 0
            r27 = r25
            r28 = 0
            r33 = r1
            r1 = r27
            if (r1 < 0) goto L_0x0270
            if (r1 >= r5) goto L_0x0270
            r1 = r29
            goto L_0x0271
        L_0x0270:
            r1 = 0
        L_0x0271:
            if (r1 == 0) goto L_0x02c0
            r1 = r25
            r27 = 0
            long r27 = r15.m720itemConstraintsOenEA2s(r1)
            r1 = r4
            r34 = r5
            r4 = r27
            r27 = 2
            r28 = 0
            r35 = 0
            r36 = r1
            r1 = r45
            r37 = r2
            r2 = r25
            r38 = r3
            r3 = r35
            r22 = r6
            r35 = r17
            r39 = 0
            r6 = r27
            r17 = r7
            r40 = r23
            r23 = r24
            r7 = r28
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r1 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m717getAndMeasure3p2s80s$default(r1, r2, r3, r4, r6, r7)
            if (r19 != 0) goto L_0x02b8
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r19 = r2
            java.util.List r19 = (java.util.List) r19
            r2 = r19
            goto L_0x02ba
        L_0x02b8:
            r2 = r19
        L_0x02ba:
            r2.add(r1)
            r19 = r2
            goto L_0x02d4
        L_0x02c0:
            r37 = r2
            r38 = r3
            r36 = r4
            r34 = r5
            r22 = r6
            r35 = r17
            r40 = r23
            r23 = r24
            r39 = 0
            r17 = r7
        L_0x02d4:
            int r6 = r22 + 1
            r20 = r17
            r7 = r23
            r1 = r33
            r5 = r34
            r17 = r35
            r4 = r36
            r2 = r37
            r3 = r38
            r23 = r40
            goto L_0x024d
        L_0x02ec:
            r33 = r1
            r37 = r2
            r38 = r3
            r36 = r4
            r34 = r5
            r22 = r6
            r35 = r17
            r17 = r20
            r40 = r23
            r39 = 0
            if (r19 != 0) goto L_0x030a
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r17 = r1
            goto L_0x030c
        L_0x030a:
            r17 = r19
        L_0x030c:
            r18 = 0
            r1 = 0
            r7 = r62
            r19 = 0
            r2 = 0
            int r6 = r7.size()
            r20 = r1
            r3 = r2
        L_0x031d:
            if (r3 >= r6) goto L_0x0390
            java.lang.Object r21 = r7.get(r3)
            r1 = r21
            java.lang.Number r1 = (java.lang.Number) r1
            int r22 = r1.intValue()
            r23 = 0
            r1 = r22
            r2 = 0
            r4 = r32
            int r5 = r4 + 1
            if (r5 > r1) goto L_0x033b
            if (r1 >= r14) goto L_0x033b
            r1 = r29
            goto L_0x033d
        L_0x033b:
            r1 = r39
        L_0x033d:
            if (r1 == 0) goto L_0x037d
            r1 = r22
            r2 = 0
            long r1 = r15.m720itemConstraintsOenEA2s(r1)
            r41 = r4
            r4 = r1
            r24 = 2
            r25 = 0
            r26 = 0
            r1 = r45
            r2 = r22
            r27 = r3
            r3 = r26
            r26 = r6
            r6 = r24
            r24 = r7
            r7 = r25
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r1 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m717getAndMeasure3p2s80s$default(r1, r2, r3, r4, r6, r7)
            if (r20 != 0) goto L_0x0375
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r20 = r2
            java.util.List r20 = (java.util.List) r20
            r2 = r20
            goto L_0x0377
        L_0x0375:
            r2 = r20
        L_0x0377:
            r2.add(r1)
            r20 = r2
            goto L_0x0385
        L_0x037d:
            r27 = r3
            r41 = r4
            r26 = r6
            r24 = r7
        L_0x0385:
            int r3 = r27 + 1
            r7 = r24
            r6 = r26
            r32 = r41
            goto L_0x031d
        L_0x0390:
            r27 = r3
            r24 = r7
            r41 = r32
            if (r20 != 0) goto L_0x03a0
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r18 = r1
            goto L_0x03a2
        L_0x03a0:
            r18 = r20
        L_0x03a2:
            if (r13 > 0) goto L_0x03ad
            if (r49 >= 0) goto L_0x03a8
            goto L_0x03ad
        L_0x03a8:
            r32 = r16
            r7 = r40
            goto L_0x03e6
        L_0x03ad:
            r1 = 0
            int r2 = r40.size()
            r3 = r38
        L_0x03b4:
            if (r1 >= r2) goto L_0x03e0
            r7 = r40
            java.lang.Object r4 = r7.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r4 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r4
            int r4 = r4.getMainAxisSizeWithSpacings()
            if (r3 == 0) goto L_0x03df
            if (r4 > r3) goto L_0x03df
            r5 = r7
            java.util.List r5 = (java.util.List) r5
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            if (r1 == r5) goto L_0x03df
            int r3 = r3 - r4
            int r5 = r1 + 1
            java.lang.Object r5 = r7.get(r5)
            r16 = r5
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r16 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r16
            int r1 = r1 + 1
            r40 = r7
            goto L_0x03b4
        L_0x03df:
            goto L_0x03e2
        L_0x03e0:
            r7 = r40
        L_0x03e2:
            r38 = r3
            r32 = r16
        L_0x03e6:
            if (r55 == 0) goto L_0x03ef
            int r1 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r53)
            r19 = r1
            goto L_0x03f5
        L_0x03ef:
            int r1 = androidx.compose.ui.unit.ConstraintsKt.m5802constrainWidthK40F9xA(r11, r0)
            r19 = r1
        L_0x03f5:
            if (r55 == 0) goto L_0x03ff
            int r1 = androidx.compose.ui.unit.ConstraintsKt.m5801constrainHeightK40F9xA(r11, r0)
            r20 = r1
            goto L_0x0405
        L_0x03ff:
            int r1 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r53)
            r20 = r1
        L_0x0405:
            r16 = r7
            java.util.List r16 = (java.util.List) r16
            r21 = r0
            r22 = r8
            r23 = r37
            r24 = r55
            r25 = r56
            r26 = r57
            r27 = r58
            r28 = r59
            java.util.List r6 = calculateItemsOffsets(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r5 = r36
            int r1 = (int) r5
            r4 = r0
            r21 = r30
            r16 = r39
            r0 = r60
            r2 = r19
            r3 = r20
            r15 = r4
            r4 = r6
            r22 = r5
            r5 = r45
            r12 = r6
            r6 = r61
            r23 = r7
            r7 = r55
            r0.onMeasured(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r14 + -1
            r11 = r41
            if (r11 != r0) goto L_0x045d
            if (r15 <= r8) goto L_0x045a
            goto L_0x045d
        L_0x045a:
            r3 = r16
            goto L_0x045f
        L_0x045d:
            r3 = r29
        L_0x045f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3 r2 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
            r2.<init>(r12)
            java.lang.Object r0 = r10.invoke(r0, r1, r2)
            r5 = r0
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            int r7 = -r13
            int r24 = r46 + r48
            boolean r0 = r17.isEmpty()
            if (r0 == 0) goto L_0x0486
            boolean r0 = r18.isEmpty()
            if (r0 == 0) goto L_0x0486
            r6 = r12
            r14 = r34
            goto L_0x04e4
        L_0x0486:
            r0 = r12
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = r0.size()
            r2.<init>(r4)
            r4 = r0
            r6 = 0
            r25 = 0
            r26 = r0
            int r0 = r4.size()
            r27 = r1
            r1 = r25
        L_0x04a1:
            if (r1 >= r0) goto L_0x04db
            java.lang.Object r25 = r4.get(r1)
            r28 = r25
            r30 = 0
            r36 = r0
            r0 = r28
            r28 = r0
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r28 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r28
            r39 = 0
            r40 = r4
            int r4 = r28.getIndex()
            r14 = r34
            if (r14 > r4) goto L_0x04c4
            if (r4 > r11) goto L_0x04c4
            r4 = r29
            goto L_0x04c6
        L_0x04c4:
            r4 = r16
        L_0x04c6:
            if (r4 == 0) goto L_0x04ce
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r0)
        L_0x04ce:
            int r1 = r1 + 1
            r34 = r14
            r0 = r36
            r4 = r40
            r14 = r43
            goto L_0x04a1
        L_0x04db:
            r40 = r4
            r14 = r34
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            r6 = r0
        L_0x04e4:
            if (r55 == 0) goto L_0x04ea
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x04ec
        L_0x04ea:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x04ec:
            r16 = r0
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r25 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r0 = r25
            r1 = r32
            r2 = r38
            r4 = r22
            r26 = r8
            r8 = r24
            r24 = r9
            r9 = r43
            r10 = r58
            r27 = r11
            r11 = r16
            r16 = r12
            r12 = r48
            r13 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r25
        L_0x051d:
            r15 = r0
            r33 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x052a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0534:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m711measureLazyGridZRKPzZ8(int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider, java.util.List, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> pinnedItems, LazyGridMeasuredItemProvider measuredItemProvider, Function1<? super Integer, Constraints> itemConstraints, Function1<? super Integer, Boolean> filter) {
        List<LazyGridMeasuredItem> list = null;
        List $this$fastForEach$iv = pinnedItems;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int index = $this$fastForEach$iv.get(index$iv).intValue();
            if (filter.invoke(Integer.valueOf(index)).booleanValue()) {
                LazyGridMeasuredItem measuredItem = LazyGridMeasuredItemProvider.m717getAndMeasure3p2s80s$default(measuredItemProvider, index, 0, itemConstraints.invoke(Integer.valueOf(index)).m5794unboximpl(), 2, (Object) null);
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(measuredItem);
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> lines, List<LazyGridMeasuredItem> itemsBefore, List<LazyGridMeasuredItem> itemsAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int firstLineScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        ArrayList positionedItems;
        int[] offsets;
        int i;
        List<LazyGridMeasuredLine> list = lines;
        int i2 = layoutWidth;
        int i3 = layoutHeight;
        boolean z = reverseLayout;
        int mainAxisLayoutSize = isVertical ? i3 : i2;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(firstLineScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int sum$iv = 0;
        List $this$fastForEach$iv$iv = lines;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            sum$iv += ((LazyGridMeasuredLine) $this$fastForEach$iv$iv.get(index$iv$iv)).getItems().length;
        }
        ArrayList positionedItems2 = new ArrayList(sum$iv);
        if (hasSpareSpace) {
            if (itemsBefore.isEmpty() && itemsAfter.isEmpty()) {
                int linesCount = lines.size();
                int[] iArr = new int[linesCount];
                for (int i4 = 0; i4 < linesCount; i4++) {
                    iArr[i4] = list.get(calculateItemsOffsets$reverseAware(i4, z, linesCount)).getMainAxisSize();
                }
                int[] sizes = iArr;
                int[] iArr2 = new int[linesCount];
                for (int i5 = 0; i5 < linesCount; i5++) {
                    iArr2[i5] = 0;
                }
                int[] offsets2 = iArr2;
                if (!isVertical) {
                    Density density2 = density;
                    if (horizontalArrangement != null) {
                        offsets = offsets2;
                        horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets2);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (verticalArrangement != null) {
                    verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                    offsets = offsets2;
                } else {
                    Density density3 = density;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                IntProgression reverseAwareOffsetIndices = ArraysKt.getIndices(offsets);
                if (z) {
                    reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
                }
                int index = reverseAwareOffsetIndices.getFirst();
                int last = reverseAwareOffsetIndices.getLast();
                int step = reverseAwareOffsetIndices.getStep();
                if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                    while (true) {
                        int absoluteOffset = offsets[index];
                        LazyGridMeasuredLine line = list.get(calculateItemsOffsets$reverseAware(index, z, linesCount));
                        if (z) {
                            i = (mainAxisLayoutSize - absoluteOffset) - line.getMainAxisSize();
                        } else {
                            i = absoluteOffset;
                        }
                        int relativeOffset = i;
                        int linesCount2 = linesCount;
                        int relativeOffset2 = relativeOffset;
                        IntProgression reverseAwareOffsetIndices2 = reverseAwareOffsetIndices;
                        CollectionsKt.addAll(positionedItems2, (T[]) line.position(relativeOffset2, i2, i3));
                        if (index == last) {
                            break;
                        }
                        index += step;
                        list = lines;
                        linesCount = linesCount2;
                        reverseAwareOffsetIndices = reverseAwareOffsetIndices2;
                    }
                } else {
                    IntProgression intProgression = reverseAwareOffsetIndices;
                }
                positionedItems = positionedItems2;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            int currentMainAxis = firstLineScrollOffset;
            List $this$fastForEach$iv = itemsBefore;
            int size2 = $this$fastForEach$iv.size();
            int index$iv = 0;
            while (index$iv < size2) {
                LazyGridMeasuredItem it = $this$fastForEach$iv.get(index$iv);
                int currentMainAxis2 = currentMainAxis - it.getMainAxisSizeWithSpacings();
                int currentMainAxis3 = currentMainAxis2;
                ArrayList positionedItems3 = positionedItems2;
                LazyGridMeasuredItem.position$default(it, currentMainAxis2, 0, layoutWidth, layoutHeight, 0, 0, 48, (Object) null);
                positionedItems3.add(it);
                index$iv++;
                positionedItems2 = positionedItems3;
                currentMainAxis = currentMainAxis3;
                size2 = size2;
                $this$fastForEach$iv = $this$fastForEach$iv;
            }
            int i6 = index$iv;
            List list2 = $this$fastForEach$iv;
            positionedItems = positionedItems2;
            int currentMainAxis4 = firstLineScrollOffset;
            List $this$fastForEach$iv2 = lines;
            int index$iv2 = 0;
            int size3 = $this$fastForEach$iv2.size();
            while (index$iv2 < size3) {
                LazyGridMeasuredLine it2 = $this$fastForEach$iv2.get(index$iv2);
                CollectionsKt.addAll(positionedItems, (T[]) it2.position(currentMainAxis4, i2, i3));
                currentMainAxis4 += it2.getMainAxisSizeWithSpacings();
                index$iv2++;
                $this$fastForEach$iv2 = $this$fastForEach$iv2;
            }
            List $this$fastForEach$iv3 = itemsAfter;
            int currentMainAxis5 = currentMainAxis4;
            int index$iv3 = 0;
            for (int size4 = $this$fastForEach$iv3.size(); index$iv3 < size4; size4 = size4) {
                LazyGridMeasuredItem it3 = $this$fastForEach$iv3.get(index$iv3);
                LazyGridMeasuredItem.position$default(it3, currentMainAxis5, 0, layoutWidth, layoutHeight, 0, 0, 48, (Object) null);
                LazyGridMeasuredItem it4 = it3;
                positionedItems.add(it4);
                currentMainAxis5 += it4.getMainAxisSizeWithSpacings();
                index$iv3++;
                $this$fastForEach$iv3 = $this$fastForEach$iv3;
            }
            int i7 = index$iv3;
            List list3 = $this$fastForEach$iv3;
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int linesCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (linesCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
