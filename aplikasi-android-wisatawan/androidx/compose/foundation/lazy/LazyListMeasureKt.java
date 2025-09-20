package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001aB\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001aî\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042/\u0010.\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3\u0012\u0004\u0012\u0002040/H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-CD5nmq0", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;ILjava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasure.kt */
public final class LazyListMeasureKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: androidx.compose.foundation.lazy.LazyListMeasuredItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureLazyList-CD5nmq0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m680measureLazyListCD5nmq0(int r45, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r46, int r47, int r48, int r49, int r50, int r51, int r52, float r53, long r54, boolean r56, java.util.List<java.lang.Integer> r57, androidx.compose.foundation.layout.Arrangement.Vertical r58, androidx.compose.foundation.layout.Arrangement.Horizontal r59, boolean r60, androidx.compose.ui.unit.Density r61, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r62, int r63, java.util.List<java.lang.Integer> r64, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r65) {
        /*
            r14 = r45
            r15 = r46
            r13 = r48
            r11 = r54
            r10 = r57
            r9 = r63
            r8 = r64
            r7 = r65
            java.lang.String r0 = "measuredItemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "headerIndexes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "density"
            r6 = r61
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "placementAnimator"
            r5 = r62
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "pinnedItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r29 = 1
            if (r13 < 0) goto L_0x003e
            r0 = r29
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            java.lang.String r1 = "Failed requirement."
            if (r0 == 0) goto L_0x046d
            if (r49 < 0) goto L_0x0048
            r0 = r29
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            if (r0 == 0) goto L_0x0461
            if (r14 > 0) goto L_0x0099
            androidx.compose.foundation.lazy.LazyListMeasureResult r0 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            int r1 = androidx.compose.ui.unit.Constraints.m5790getMinWidthimpl(r54)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = androidx.compose.ui.unit.Constraints.m5789getMinHeightimpl(r54)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1 r3 = androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1.INSTANCE
            java.lang.Object r1 = r7.invoke(r1, r2, r3)
            r21 = r1
            androidx.compose.ui.layout.MeasureResult r21 = (androidx.compose.ui.layout.MeasureResult) r21
            java.util.List r22 = kotlin.collections.CollectionsKt.emptyList()
            int r1 = -r13
            int r24 = r47 + r49
            if (r56 == 0) goto L_0x007b
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x007d
        L_0x007b:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x007d:
            r27 = r2
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r25 = 0
            r16 = r0
            r23 = r1
            r26 = r60
            r28 = r49
            r29 = r50
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x0099:
            r0 = r51
            r2 = r52
            if (r0 < r14) goto L_0x00a2
            int r0 = r14 + -1
            r2 = 0
        L_0x00a2:
            int r3 = kotlin.math.MathKt.roundToInt((float) r53)
            int r2 = r2 - r3
            if (r0 != 0) goto L_0x00ad
            if (r2 >= 0) goto L_0x00ad
            int r3 = r3 + r2
            r2 = 0
        L_0x00ad:
            kotlin.collections.ArrayDeque r16 = new kotlin.collections.ArrayDeque
            r16.<init>()
            r30 = r16
            int r4 = -r13
            if (r50 >= 0) goto L_0x00ba
            r16 = r50
            goto L_0x00bc
        L_0x00ba:
            r16 = 0
        L_0x00bc:
            int r4 = r4 + r16
            r32 = r47
            int r2 = r2 + r4
            r16 = 0
            r5 = r16
        L_0x00c5:
            if (r2 >= 0) goto L_0x00ee
            if (r0 <= 0) goto L_0x00ee
            int r6 = r0 + -1
            r16 = r1
            androidx.compose.foundation.lazy.LazyListMeasuredItem r1 = r15.getAndMeasure(r6)
            r7 = r30
            r10 = 0
            r7.add(r10, r1)
            int r10 = r1.getCrossAxisSize()
            int r5 = java.lang.Math.max(r5, r10)
            int r10 = r1.getSizeWithSpacings()
            int r2 = r2 + r10
            r0 = r6
            r10 = r57
            r6 = r61
            r1 = r16
            r7 = r65
            goto L_0x00c5
        L_0x00ee:
            r16 = r1
            r7 = r30
            if (r2 >= r4) goto L_0x00f6
            int r3 = r3 + r2
            r2 = r4
        L_0x00f6:
            int r2 = r2 - r4
            r1 = 0
            r1 = r0
            r10 = r32
            int r6 = r10 + r49
            r17 = r0
            r0 = 0
            int r6 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r0)
            r0 = 0
            int r0 = -r2
            r18 = r0
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            r19 = 0
            r20 = 0
            r21 = r1
            int r1 = r0.size()
            r44 = r20
            r20 = r2
            r2 = r44
        L_0x011c:
            if (r2 >= r1) goto L_0x0135
            java.lang.Object r22 = r0.get(r2)
            r23 = r22
            androidx.compose.foundation.lazy.LazyListMeasuredItem r23 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r23
            r24 = 0
            int r21 = r21 + 1
            int r25 = r23.getSizeWithSpacings()
            int r18 = r18 + r25
            int r2 = r2 + 1
            goto L_0x011c
        L_0x0135:
            r1 = r18
            r2 = r20
            r0 = r21
        L_0x013b:
            if (r0 >= r14) goto L_0x017f
            if (r1 < r6) goto L_0x014b
            if (r1 <= 0) goto L_0x014b
            boolean r18 = r7.isEmpty()
            if (r18 == 0) goto L_0x0148
            goto L_0x014b
        L_0x0148:
            r30 = r6
            goto L_0x0181
        L_0x014b:
            r30 = r6
            androidx.compose.foundation.lazy.LazyListMeasuredItem r6 = r15.getAndMeasure(r0)
            int r18 = r6.getSizeWithSpacings()
            int r1 = r1 + r18
            if (r1 > r4) goto L_0x016a
            r18 = r1
            int r1 = r14 + -1
            if (r0 == r1) goto L_0x016c
            int r1 = r0 + 1
            int r17 = r6.getSizeWithSpacings()
            int r2 = r2 - r17
            r17 = r1
            goto L_0x0178
        L_0x016a:
            r18 = r1
        L_0x016c:
            int r1 = r6.getCrossAxisSize()
            int r1 = java.lang.Math.max(r5, r1)
            r7.add(r6)
            r5 = r1
        L_0x0178:
            int r0 = r0 + 1
            r1 = r18
            r6 = r30
            goto L_0x013b
        L_0x017f:
            r30 = r6
        L_0x0181:
            if (r1 >= r10) goto L_0x01cb
            int r32 = r10 - r1
            int r2 = r2 - r32
            int r1 = r1 + r32
        L_0x0189:
            if (r2 >= r13) goto L_0x01b4
            if (r17 <= 0) goto L_0x01af
            int r6 = r17 + -1
            r33 = r0
            androidx.compose.foundation.lazy.LazyListMeasuredItem r0 = r15.getAndMeasure(r6)
            r34 = r4
            r4 = 0
            r7.add(r4, r0)
            int r4 = r0.getCrossAxisSize()
            int r5 = java.lang.Math.max(r5, r4)
            int r4 = r0.getSizeWithSpacings()
            int r2 = r2 + r4
            r17 = r6
            r0 = r33
            r4 = r34
            goto L_0x0189
        L_0x01af:
            r33 = r0
            r34 = r4
            goto L_0x01b8
        L_0x01b4:
            r33 = r0
            r34 = r4
        L_0x01b8:
            int r3 = r3 + r32
            if (r2 >= 0) goto L_0x01c5
            int r3 = r3 + r2
            int r1 = r1 + r2
            r2 = 0
            r4 = r3
            r0 = r5
            r6 = r17
            r5 = r1
            goto L_0x01d4
        L_0x01c5:
            r4 = r3
            r0 = r5
            r6 = r17
            r5 = r1
            goto L_0x01d4
        L_0x01cb:
            r33 = r0
            r34 = r4
            r4 = r3
            r0 = r5
            r6 = r17
            r5 = r1
        L_0x01d4:
            int r1 = kotlin.math.MathKt.roundToInt((float) r53)
            int r1 = kotlin.math.MathKt.getSign((int) r1)
            int r3 = kotlin.math.MathKt.getSign((int) r4)
            if (r1 != r3) goto L_0x01f2
            int r1 = kotlin.math.MathKt.roundToInt((float) r53)
            int r1 = java.lang.Math.abs(r1)
            int r3 = java.lang.Math.abs(r4)
            if (r1 < r3) goto L_0x01f2
            float r1 = (float) r4
            goto L_0x01f4
        L_0x01f2:
            r1 = r53
        L_0x01f4:
            r3 = r1
            if (r2 < 0) goto L_0x01fa
            r1 = r29
            goto L_0x01fb
        L_0x01fa:
            r1 = 0
        L_0x01fb:
            if (r1 == 0) goto L_0x0455
            int r1 = -r2
            java.lang.Object r16 = r7.first()
            androidx.compose.foundation.lazy.LazyListMeasuredItem r16 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r16
            if (r13 > 0) goto L_0x0212
            if (r50 >= 0) goto L_0x0209
            goto L_0x0212
        L_0x0209:
            r18 = r0
            r35 = r2
            r32 = r4
            r13 = r16
            goto L_0x0251
        L_0x0212:
            r17 = 0
            r18 = r0
            int r0 = r7.size()
            r32 = r4
            r4 = r17
        L_0x021e:
            if (r4 >= r0) goto L_0x024d
            java.lang.Object r17 = r7.get(r4)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r17 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r17
            r19 = r0
            int r0 = r17.getSizeWithSpacings()
            if (r2 == 0) goto L_0x024c
            if (r0 > r2) goto L_0x024c
            r17 = r7
            java.util.List r17 = (java.util.List) r17
            int r13 = kotlin.collections.CollectionsKt.getLastIndex(r17)
            if (r4 == r13) goto L_0x024c
            int r2 = r2 - r0
            int r13 = r4 + 1
            java.lang.Object r13 = r7.get(r13)
            r16 = r13
            androidx.compose.foundation.lazy.LazyListMeasuredItem r16 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r16
            int r4 = r4 + 1
            r13 = r48
            r0 = r19
            goto L_0x021e
        L_0x024c:
        L_0x024d:
            r35 = r2
            r13 = r16
        L_0x0251:
            java.util.List r36 = createItemsBeforeList(r6, r15, r9, r8)
            r0 = r36
            r2 = 0
            r4 = 0
            r16 = r2
            int r2 = r0.size()
            r37 = r6
            r6 = r4
            r4 = r18
        L_0x0269:
            if (r6 >= r2) goto L_0x0286
            java.lang.Object r17 = r0.get(r6)
            r18 = r17
            androidx.compose.foundation.lazy.LazyListMeasuredItem r18 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r18
            r19 = 0
            r20 = r0
            int r0 = r18.getCrossAxisSize()
            int r4 = java.lang.Math.max(r4, r0)
            int r6 = r6 + 1
            r0 = r20
            goto L_0x0269
        L_0x0286:
            r20 = r0
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            java.util.List r38 = createItemsAfterList(r0, r15, r14, r9, r8)
            r0 = r38
            r2 = 0
            r6 = 0
            r16 = r2
            int r2 = r0.size()
            r44 = r6
            r6 = r4
            r4 = r44
        L_0x02a4:
            if (r4 >= r2) goto L_0x02c1
            java.lang.Object r17 = r0.get(r4)
            r18 = r17
            androidx.compose.foundation.lazy.LazyListMeasuredItem r18 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r18
            r19 = 0
            r20 = r0
            int r0 = r18.getCrossAxisSize()
            int r6 = java.lang.Math.max(r6, r0)
            int r4 = r4 + 1
            r0 = r20
            goto L_0x02a4
        L_0x02c1:
            r20 = r0
            java.lang.Object r0 = r7.first()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x02dd
            boolean r0 = r36.isEmpty()
            if (r0 == 0) goto L_0x02dd
            boolean r0 = r38.isEmpty()
            if (r0 == 0) goto L_0x02dd
            r0 = r29
            goto L_0x02de
        L_0x02dd:
            r0 = 0
        L_0x02de:
            r39 = r0
            if (r56 == 0) goto L_0x02e4
            r0 = r6
            goto L_0x02e5
        L_0x02e4:
            r0 = r5
        L_0x02e5:
            int r19 = androidx.compose.ui.unit.ConstraintsKt.m5802constrainWidthK40F9xA(r11, r0)
            if (r56 == 0) goto L_0x02ee
            r0 = r5
            goto L_0x02ef
        L_0x02ee:
            r0 = r6
        L_0x02ef:
            int r20 = androidx.compose.ui.unit.ConstraintsKt.m5801constrainHeightK40F9xA(r11, r0)
            r16 = r7
            java.util.List r16 = (java.util.List) r16
            r17 = r36
            r18 = r38
            r21 = r5
            r22 = r10
            r23 = r1
            r24 = r56
            r25 = r58
            r26 = r59
            r27 = r60
            r28 = r61
            java.util.List r4 = calculateItemsOffsets(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            int r2 = (int) r3
            r15 = r33
            r0 = r62
            r16 = r1
            r1 = r2
            r2 = r19
            r17 = r3
            r3 = r20
            r23 = r4
            r22 = r32
            r21 = r34
            r18 = 0
            r12 = r5
            r5 = r46
            r26 = r6
            r24 = r30
            r25 = r37
            r6 = r56
            r0.onMeasured(r1, r2, r3, r4, r5, r6)
            r0 = r57
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0369
            r0 = r23
            r1 = r46
            r2 = r57
            r3 = r48
            r4 = r19
            r5 = r20
            androidx.compose.foundation.lazy.LazyListMeasuredItem r0 = androidx.compose.foundation.lazy.LazyListHeadersKt.findOrComposeLazyListHeader(r0, r1, r2, r3, r4, r5)
            goto L_0x036a
        L_0x0369:
            r0 = 0
        L_0x036a:
            r11 = r0
            if (r15 < r14) goto L_0x0375
            if (r12 <= r10) goto L_0x0372
            goto L_0x0375
        L_0x0372:
            r3 = r18
            goto L_0x0377
        L_0x0375:
            r3 = r29
        L_0x0377:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$5 r2 = new androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$5
            r6 = r23
            r2.<init>(r6, r11)
            r23 = r7
            r7 = r65
            java.lang.Object r0 = r7.invoke(r0, r1, r2)
            r5 = r0
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            r4 = r48
            int r2 = -r4
            int r27 = r10 + r49
            if (r39 == 0) goto L_0x039e
            r30 = r2
            r42 = r6
            goto L_0x0419
        L_0x039e:
            r0 = r6
            r1 = 0
            r28 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r30 = r2
            int r2 = r0.size()
            r1.<init>(r2)
            r2 = r0
            r31 = 0
            r32 = 0
            r33 = r0
            int r0 = r2.size()
            r4 = r32
        L_0x03bc:
            if (r4 >= r0) goto L_0x0410
            java.lang.Object r32 = r2.get(r4)
            r34 = r32
            r37 = 0
            r40 = r0
            r0 = r34
            r34 = r2
            r2 = r0
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r2
            r41 = 0
            r42 = r6
            int r6 = r2.getIndex()
            java.lang.Object r43 = r23.first()
            androidx.compose.foundation.lazy.LazyListMeasuredItem r43 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r43
            int r7 = r43.getIndex()
            if (r6 < r7) goto L_0x03f3
            int r6 = r2.getIndex()
            java.lang.Object r7 = r23.last()
            androidx.compose.foundation.lazy.LazyListMeasuredItem r7 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r7
            int r7 = r7.getIndex()
            if (r6 <= r7) goto L_0x03f5
        L_0x03f3:
            if (r2 != r11) goto L_0x03f8
        L_0x03f5:
            r6 = r29
            goto L_0x03fa
        L_0x03f8:
            r6 = r18
        L_0x03fa:
            if (r6 == 0) goto L_0x0403
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            r2.add(r0)
        L_0x0403:
            int r4 = r4 + 1
            r7 = r65
            r2 = r34
            r0 = r40
            r6 = r42
            goto L_0x03bc
        L_0x0410:
            r34 = r2
            r42 = r6
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            r6 = r0
        L_0x0419:
            if (r56 == 0) goto L_0x041f
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0421
        L_0x041f:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0421:
            r18 = r0
            androidx.compose.foundation.lazy.LazyListMeasureResult r28 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r0 = r28
            r1 = r13
            r7 = r30
            r2 = r35
            r4 = r17
            r29 = r42
            r8 = r27
            r9 = r45
            r27 = r10
            r10 = r60
            r30 = r11
            r11 = r18
            r31 = r12
            r12 = r49
            r18 = r13
            r13 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r28
        L_0x0455:
            r18 = r0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r16.toString()
            r0.<init>(r1)
            throw r0
        L_0x0461:
            r16 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r16.toString()
            r0.<init>(r1)
            throw r0
        L_0x046d:
            r16 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r16.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m680measureLazyListCD5nmq0(int, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator, int, java.util.List, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> visibleItems, LazyListMeasuredItemProvider measuredItemProvider, int itemsCount, int beyondBoundsItemCount, List<Integer> pinnedItems) {
        List<LazyListMeasuredItem> list = null;
        int end = Math.min(((LazyListMeasuredItem) CollectionsKt.last(visibleItems)).getIndex() + beyondBoundsItemCount, itemsCount - 1);
        int i = ((LazyListMeasuredItem) CollectionsKt.last(visibleItems)).getIndex() + 1;
        if (i <= end) {
            while (true) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(measuredItemProvider.getAndMeasure(i));
                if (i == end) {
                    break;
                }
                i++;
            }
        }
        List $this$fastForEach$iv = pinnedItems;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int index = $this$fastForEach$iv.get(index$iv).intValue();
            if (index > end) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(measuredItemProvider.getAndMeasure(index));
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int currentFirstItemIndex, LazyListMeasuredItemProvider measuredItemProvider, int beyondBoundsItemCount, List<Integer> pinnedItems) {
        List<LazyListMeasuredItem> list = null;
        int start = Math.max(0, currentFirstItemIndex - beyondBoundsItemCount);
        int i = currentFirstItemIndex - 1;
        if (start <= i) {
            while (true) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(measuredItemProvider.getAndMeasure(i));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        List $this$fastForEach$iv = pinnedItems;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int index = $this$fastForEach$iv.get(index$iv).intValue();
            if (index < start) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(measuredItemProvider.getAndMeasure(index));
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> items, List<LazyListMeasuredItem> extraItemsBefore, List<LazyListMeasuredItem> extraItemsAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int itemsScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int[] offsets;
        int relativeOffset;
        List<LazyListMeasuredItem> list = items;
        int i = layoutWidth;
        int i2 = layoutHeight;
        boolean z = reverseLayout;
        int mainAxisLayoutSize = isVertical ? i2 : i;
        boolean z2 = true;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(itemsScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList positionedItems = new ArrayList(items.size() + extraItemsBefore.size() + extraItemsAfter.size());
        if (hasSpareSpace) {
            if (!extraItemsBefore.isEmpty() || !extraItemsAfter.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                int itemsCount = items.size();
                int[] iArr = new int[itemsCount];
                for (int i3 = 0; i3 < itemsCount; i3++) {
                    iArr[i3] = list.get(calculateItemsOffsets$reverseAware(i3, z, itemsCount)).getSize();
                }
                int[] sizes = iArr;
                int[] iArr2 = new int[itemsCount];
                for (int i4 = 0; i4 < itemsCount; i4++) {
                    iArr2[i4] = 0;
                }
                int[] offsets2 = iArr2;
                if (!isVertical) {
                    Density density2 = density;
                    if (horizontalArrangement != null) {
                        offsets = offsets2;
                        int[] iArr3 = sizes;
                        horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (verticalArrangement != null) {
                    verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                    offsets = offsets2;
                    int[] iArr4 = sizes;
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
                        LazyListMeasuredItem item = list.get(calculateItemsOffsets$reverseAware(index, z, itemsCount));
                        if (z) {
                            relativeOffset = (mainAxisLayoutSize - absoluteOffset) - item.getSize();
                        } else {
                            relativeOffset = absoluteOffset;
                        }
                        item.position(relativeOffset, i, i2);
                        positionedItems.add(item);
                        if (index == last) {
                            break;
                        }
                        index += step;
                        list = items;
                    }
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            int currentMainAxis = itemsScrollOffset;
            List $this$fastForEach$iv = extraItemsBefore;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                LazyListMeasuredItem it = $this$fastForEach$iv.get(index$iv);
                currentMainAxis -= it.getSizeWithSpacings();
                it.position(currentMainAxis, i, i2);
                positionedItems.add(it);
            }
            int currentMainAxis2 = itemsScrollOffset;
            List $this$fastForEach$iv2 = items;
            int size2 = $this$fastForEach$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                LazyListMeasuredItem it2 = $this$fastForEach$iv2.get(index$iv2);
                it2.position(currentMainAxis2, i, i2);
                positionedItems.add(it2);
                currentMainAxis2 += it2.getSizeWithSpacings();
            }
            List $this$fastForEach$iv3 = extraItemsAfter;
            int size3 = $this$fastForEach$iv3.size();
            for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                LazyListMeasuredItem it3 = $this$fastForEach$iv3.get(index$iv3);
                it3.position(currentMainAxis2, i, i2);
                positionedItems.add(it3);
                currentMainAxis2 += it3.getSizeWithSpacings();
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int itemsCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (itemsCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
