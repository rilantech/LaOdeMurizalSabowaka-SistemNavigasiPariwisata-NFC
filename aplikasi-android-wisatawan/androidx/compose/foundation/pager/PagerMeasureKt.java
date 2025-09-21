package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a@\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a\u0017\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001am\u0010\n\u001a\u00020\u0004*\u00020\u00152\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aä\u0001\u00104\u001a\u000205*\u00020\u00152\u0006\u00106\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032/\u0010?\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0002\bB\u0012\u0004\u0012\u00020C0@H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006F"}, d2 = {"DEBUG", "", "createPagesAfterList", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "", "pagesCount", "beyondBoundsPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "firstVisiblePage", "firstVisiblePageOffset", "scrollToBeConsumed", "", "constraints", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-ntgEbfI", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIFJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasure.kt */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: androidx.compose.foundation.pager.MeasuredPage} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measurePager-ntgEbfI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.pager.PagerMeasureResult m824measurePagerntgEbfI(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope r49, int r50, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider r51, int r52, int r53, int r54, int r55, int r56, int r57, float r58, long r59, androidx.compose.foundation.gestures.Orientation r61, androidx.compose.ui.Alignment.Vertical r62, androidx.compose.ui.Alignment.Horizontal r63, boolean r64, long r65, int r67, int r68, java.util.List<java.lang.Integer> r69, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r70) {
        /*
            r14 = r49
            r15 = r50
            r13 = r53
            r11 = r59
            r10 = r61
            r9 = r68
            r8 = r69
            r7 = r70
            java.lang.String r0 = "$this$measurePager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "pagerItemProvider"
            r5 = r51
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "pinnedPages"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r6 = 0
            r26 = 1
            if (r13 < 0) goto L_0x0037
            r0 = r26
            goto L_0x0038
        L_0x0037:
            r0 = r6
        L_0x0038:
            java.lang.String r16 = "Failed requirement."
            if (r0 == 0) goto L_0x05c0
            if (r54 < 0) goto L_0x0041
            r0 = r26
            goto L_0x0042
        L_0x0041:
            r0 = r6
        L_0x0042:
            if (r0 == 0) goto L_0x05b4
            int r0 = r67 + r55
            int r32 = kotlin.ranges.RangesKt.coerceAtLeast((int) r0, (int) r6)
            r0 = 0
            if (r15 > 0) goto L_0x009f
            java.util.List r17 = kotlin.collections.CollectionsKt.emptyList()
            int r0 = -r13
            int r24 = r52 + r54
            int r1 = androidx.compose.ui.unit.Constraints.m5790getMinWidthimpl(r59)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = androidx.compose.ui.unit.Constraints.m5789getMinHeightimpl(r59)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$2 r3 = androidx.compose.foundation.pager.PagerMeasureKt$measurePager$2.INSTANCE
            java.lang.Object r1 = r7.invoke(r1, r2, r3)
            r31 = r1
            androidx.compose.ui.layout.MeasureResult r31 = (androidx.compose.ui.layout.MeasureResult) r31
            androidx.compose.foundation.pager.PagerMeasureResult r1 = new androidx.compose.foundation.pager.PagerMeasureResult
            r18 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r16 = r1
            r19 = r67
            r20 = r55
            r21 = r54
            r22 = r61
            r23 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return r1
        L_0x009f:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r10 != r0) goto L_0x00ab
            int r0 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r59)
            r18 = r0
            goto L_0x00ad
        L_0x00ab:
            r18 = r67
        L_0x00ad:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r10 == r0) goto L_0x00b9
            int r0 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r59)
            r20 = r0
            goto L_0x00bb
        L_0x00b9:
            r20 = r67
        L_0x00bb:
            r21 = 5
            r22 = 0
            r17 = 0
            r19 = 0
            long r33 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r17, r18, r19, r20, r21, r22)
            r0 = r56
            r1 = r57
            if (r0 < r15) goto L_0x00d0
            int r0 = r15 + -1
            r1 = 0
        L_0x00d0:
            int r2 = kotlin.math.MathKt.roundToInt((float) r58)
            int r1 = r1 - r2
            if (r0 != 0) goto L_0x00de
            if (r1 >= 0) goto L_0x00de
            int r2 = r2 + r1
            r1 = 0
            r17 = r2
            goto L_0x00e0
        L_0x00de:
            r17 = r2
        L_0x00e0:
            kotlin.collections.ArrayDeque r2 = new kotlin.collections.ArrayDeque
            r2.<init>()
            r4 = r2
            int r2 = -r13
            if (r55 >= 0) goto L_0x00ec
            r3 = r55
            goto L_0x00ed
        L_0x00ec:
            r3 = r6
        L_0x00ed:
            int r2 = r2 + r3
            r3 = r52
            int r1 = r1 + r2
            r18 = 0
            r48 = r18
            r18 = r0
            r0 = r48
        L_0x00f9:
            if (r1 >= 0) goto L_0x015c
            if (r18 <= 0) goto L_0x015c
            int r19 = r18 + -1
            androidx.compose.ui.unit.LayoutDirection r20 = r49.getLayoutDirection()
            r14 = r0
            r0 = r49
            r13 = r1
            r1 = r19
            r15 = r2
            r35 = r3
            r2 = r33
            r21 = r15
            r15 = r4
            r4 = r51
            r22 = r13
            r13 = r6
            r5 = r65
            r7 = r61
            r8 = r63
            r9 = r62
            r10 = r20
            r11 = r64
            r12 = r67
            androidx.compose.foundation.pager.MeasuredPage r0 = m823getAndMeasureSGf7dI0(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11, r12)
            r15.add(r13, r0)
            int r1 = r0.getCrossAxisSize()
            int r1 = java.lang.Math.max(r14, r1)
            int r2 = r22 + r32
            r18 = r19
            r14 = r49
            r5 = r51
            r11 = r59
            r10 = r61
            r9 = r68
            r8 = r69
            r7 = r70
            r0 = r1
            r1 = r2
            r6 = r13
            r4 = r15
            r2 = r21
            r3 = r35
            r15 = r50
            r13 = r53
            goto L_0x00f9
        L_0x015c:
            r14 = r0
            r22 = r1
            r21 = r2
            r35 = r3
            r15 = r4
            r13 = r6
            r2 = r21
            r1 = r22
            if (r1 >= r2) goto L_0x016e
            int r17 = r17 + r1
            r1 = r2
        L_0x016e:
            int r1 = r1 - r2
            r0 = 0
            r0 = r18
            r12 = r35
            int r3 = r12 + r54
            int r11 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r13)
            r3 = 0
            int r3 = -r1
            r4 = r15
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x0186:
            if (r6 >= r7) goto L_0x0199
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            androidx.compose.foundation.pager.MeasuredPage r9 = (androidx.compose.foundation.pager.MeasuredPage) r9
            r10 = 0
            int r0 = r0 + 1
            int r3 = r3 + r32
            int r6 = r6 + 1
            goto L_0x0186
        L_0x0199:
            r9 = r3
            r10 = r14
            r19 = r18
            r14 = r0
            r18 = r1
        L_0x01a0:
            r8 = r50
            r7 = r2
            if (r14 >= r8) goto L_0x0222
            if (r9 < r11) goto L_0x01bc
            if (r9 <= 0) goto L_0x01bc
            boolean r0 = r15.isEmpty()
            if (r0 == 0) goto L_0x01b0
            goto L_0x01bc
        L_0x01b0:
            r13 = r7
            r2 = r10
            r35 = r11
            r37 = r12
            r12 = r14
            r11 = r15
            r15 = r8
            r14 = r9
            goto L_0x022c
        L_0x01bc:
            androidx.compose.ui.unit.LayoutDirection r20 = r49.getLayoutDirection()
            r0 = r49
            r1 = r14
            r2 = r33
            r4 = r51
            r5 = r65
            r13 = r7
            r7 = r61
            r27 = r15
            r15 = r8
            r8 = r63
            r31 = r14
            r14 = r9
            r9 = r62
            r36 = r10
            r10 = r20
            r35 = r11
            r11 = r64
            r37 = r12
            r12 = r67
            androidx.compose.foundation.pager.MeasuredPage r0 = m823getAndMeasureSGf7dI0(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11, r12)
            int r9 = r14 + r32
            if (r9 > r13) goto L_0x0205
            int r1 = r15 + -1
            r12 = r31
            if (r12 == r1) goto L_0x0207
            int r14 = r12 + 1
            int r18 = r18 - r32
            r19 = r14
            r11 = r27
            r10 = r36
            goto L_0x0217
        L_0x0205:
            r12 = r31
        L_0x0207:
            int r1 = r0.getCrossAxisSize()
            r2 = r36
            int r1 = java.lang.Math.max(r2, r1)
            r11 = r27
            r11.add(r0)
            r10 = r1
        L_0x0217:
            int r14 = r12 + 1
            r15 = r11
            r2 = r13
            r11 = r35
            r12 = r37
            r13 = 0
            goto L_0x01a0
        L_0x0222:
            r13 = r7
            r2 = r10
            r35 = r11
            r37 = r12
            r12 = r14
            r11 = r15
            r15 = r8
            r14 = r9
        L_0x022c:
            r10 = r37
            if (r14 >= r10) goto L_0x02bd
            int r20 = r10 - r14
            int r18 = r18 - r20
            int r14 = r14 + r20
            r9 = r2
            r8 = r18
        L_0x0239:
            r7 = r53
            if (r8 >= r7) goto L_0x0299
            if (r19 <= 0) goto L_0x028d
            int r18 = r19 + -1
            androidx.compose.ui.unit.LayoutDirection r22 = r49.getLayoutDirection()
            r0 = r49
            r1 = r18
            r2 = r33
            r4 = r51
            r5 = r65
            r7 = r61
            r23 = r8
            r8 = r63
            r24 = r13
            r13 = r9
            r9 = r62
            r37 = r10
            r10 = r22
            r15 = r11
            r11 = r64
            r38 = r12
            r12 = r67
            androidx.compose.foundation.pager.MeasuredPage r0 = m823getAndMeasureSGf7dI0(r0, r1, r2, r4, r5, r7, r8, r9, r10, r11, r12)
            r12 = 0
            r15.add(r12, r0)
            int r1 = r0.getCrossAxisSize()
            int r9 = java.lang.Math.max(r13, r1)
            int r8 = r23 + r32
            r19 = r18
            r11 = r15
            r13 = r24
            r10 = r37
            r12 = r38
            r15 = r50
            goto L_0x0239
        L_0x028d:
            r23 = r8
            r37 = r10
            r15 = r11
            r38 = r12
            r24 = r13
            r12 = 0
            r13 = r9
            goto L_0x02a4
        L_0x0299:
            r23 = r8
            r37 = r10
            r15 = r11
            r38 = r12
            r24 = r13
            r12 = 0
            r13 = r9
        L_0x02a4:
            int r17 = r17 + r20
            if (r23 >= 0) goto L_0x02b6
            int r17 = r17 + r23
            int r9 = r14 + r23
            r18 = 0
            r14 = r9
            r11 = r17
            r0 = r18
            r10 = r19
            goto L_0x02cc
        L_0x02b6:
            r11 = r17
            r10 = r19
            r0 = r23
            goto L_0x02cc
        L_0x02bd:
            r37 = r10
            r15 = r11
            r38 = r12
            r24 = r13
            r12 = 0
            r13 = r2
            r11 = r17
            r0 = r18
            r10 = r19
        L_0x02cc:
            int r1 = kotlin.math.MathKt.roundToInt((float) r58)
            int r1 = kotlin.math.MathKt.getSign((int) r1)
            int r2 = kotlin.math.MathKt.getSign((int) r11)
            if (r1 != r2) goto L_0x02ec
            int r1 = kotlin.math.MathKt.roundToInt((float) r58)
            int r1 = java.lang.Math.abs(r1)
            int r2 = java.lang.Math.abs(r11)
            if (r1 < r2) goto L_0x02ec
            float r1 = (float) r11
            r25 = r1
            goto L_0x02ee
        L_0x02ec:
            r25 = r58
        L_0x02ee:
            if (r0 < 0) goto L_0x02f4
            r6 = r26
            goto L_0x02f5
        L_0x02f4:
            r6 = r12
        L_0x02f5:
            if (r6 == 0) goto L_0x05aa
            int r9 = -r0
            java.lang.Object r1 = r15.first()
            androidx.compose.foundation.pager.MeasuredPage r1 = (androidx.compose.foundation.pager.MeasuredPage) r1
            if (r53 > 0) goto L_0x0307
            if (r55 >= 0) goto L_0x0303
            goto L_0x0307
        L_0x0303:
            r31 = r0
            r8 = r1
            goto L_0x032e
        L_0x0307:
            r2 = 0
            int r3 = r15.size()
        L_0x030c:
            if (r2 >= r3) goto L_0x032b
            r4 = r32
            if (r0 == 0) goto L_0x032a
            if (r4 > r0) goto L_0x032a
            r5 = r15
            java.util.List r5 = (java.util.List) r5
            int r5 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            if (r2 == r5) goto L_0x032a
            int r0 = r0 - r4
            int r5 = r2 + 1
            java.lang.Object r5 = r15.get(r5)
            r1 = r5
            androidx.compose.foundation.pager.MeasuredPage r1 = (androidx.compose.foundation.pager.MeasuredPage) r1
            int r2 = r2 + 1
            goto L_0x030c
        L_0x032a:
        L_0x032b:
            r31 = r0
            r8 = r1
        L_0x032e:
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1 r16 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            r0 = r16
            r1 = r49
            r2 = r33
            r4 = r51
            r5 = r65
            r7 = r61
            r17 = r13
            r13 = r8
            r8 = r63
            r36 = r9
            r9 = r62
            r12 = r10
            r10 = r64
            r39 = r11
            r11 = r67
            r0.<init>(r1, r2, r4, r5, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r11 = r68
            r10 = r69
            java.util.List r40 = createPagesBeforeList(r12, r11, r10, r0)
            r0 = r40
            r1 = 0
            r2 = 0
            int r3 = r0.size()
            r9 = r17
        L_0x0369:
            if (r2 >= r3) goto L_0x0380
            java.lang.Object r4 = r0.get(r2)
            r5 = r4
            androidx.compose.foundation.pager.MeasuredPage r5 = (androidx.compose.foundation.pager.MeasuredPage) r5
            r6 = 0
            int r7 = r5.getCrossAxisSize()
            int r9 = java.lang.Math.max(r9, r7)
            int r2 = r2 + 1
            goto L_0x0369
        L_0x0380:
            java.lang.Object r0 = r15.last()
            androidx.compose.foundation.pager.MeasuredPage r0 = (androidx.compose.foundation.pager.MeasuredPage) r0
            int r8 = r0.getIndex()
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1 r16 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            r0 = r16
            r1 = r49
            r2 = r33
            r4 = r51
            r5 = r65
            r7 = r61
            r18 = r12
            r12 = r8
            r8 = r63
            r17 = r9
            r9 = r62
            r27 = r15
            r15 = r10
            r10 = r64
            r41 = r14
            r14 = r11
            r11 = r67
            r0.<init>(r1, r2, r4, r5, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r11 = r50
            java.util.List r42 = createPagesAfterList(r12, r11, r14, r15, r0)
            r0 = r42
            r1 = 0
            r2 = 0
            int r3 = r0.size()
            r12 = r17
        L_0x03c7:
            if (r2 >= r3) goto L_0x03de
            java.lang.Object r4 = r0.get(r2)
            r5 = r4
            androidx.compose.foundation.pager.MeasuredPage r5 = (androidx.compose.foundation.pager.MeasuredPage) r5
            r6 = 0
            int r7 = r5.getCrossAxisSize()
            int r12 = java.lang.Math.max(r12, r7)
            int r2 = r2 + 1
            goto L_0x03c7
        L_0x03de:
            java.lang.Object r0 = r27.first()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x03f8
            boolean r0 = r40.isEmpty()
            if (r0 == 0) goto L_0x03f8
            boolean r0 = r42.isEmpty()
            if (r0 == 0) goto L_0x03f8
            r6 = r26
            goto L_0x03f9
        L_0x03f8:
            r6 = 0
        L_0x03f9:
            r43 = r6
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            r10 = r61
            if (r10 != r0) goto L_0x0404
            r0 = r12
            goto L_0x0406
        L_0x0404:
            r0 = r41
        L_0x0406:
            r8 = r59
            int r4 = androidx.compose.ui.unit.ConstraintsKt.m5802constrainWidthK40F9xA(r8, r0)
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r10 != r0) goto L_0x0415
            r0 = r41
            goto L_0x0416
        L_0x0415:
            r0 = r12
        L_0x0416:
            int r5 = androidx.compose.ui.unit.ConstraintsKt.m5801constrainHeightK40F9xA(r8, r0)
            r1 = r27
            java.util.List r1 = (java.util.List) r1
            r16 = r49
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            r0 = r49
            r2 = r40
            r3 = r42
            r6 = r41
            r7 = r37
            r8 = r36
            r9 = r61
            r14 = r10
            r10 = r64
            r15 = r11
            r11 = r16
            r45 = r12
            r44 = r18
            r16 = 0
            r12 = r55
            r47 = r13
            r15 = r16
            r46 = r24
            r13 = r67
            java.util.List r0 = calculatePagesOffsets(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r43 == 0) goto L_0x045c
            r16 = r0
            goto L_0x04bb
        L_0x045c:
            r1 = r0
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r6 = r1.size()
            r3.<init>(r6)
            r6 = r1
            r7 = 0
            r8 = 0
            int r9 = r6.size()
        L_0x0470:
            if (r8 >= r9) goto L_0x04b3
            java.lang.Object r10 = r6.get(r8)
            r11 = r10
            r12 = 0
            r13 = r11
            androidx.compose.foundation.pager.MeasuredPage r13 = (androidx.compose.foundation.pager.MeasuredPage) r13
            r16 = 0
            int r15 = r13.getIndex()
            java.lang.Object r17 = r27.first()
            androidx.compose.foundation.pager.MeasuredPage r17 = (androidx.compose.foundation.pager.MeasuredPage) r17
            r18 = r1
            int r1 = r17.getIndex()
            if (r15 < r1) goto L_0x04a2
            int r1 = r13.getIndex()
            java.lang.Object r15 = r27.last()
            androidx.compose.foundation.pager.MeasuredPage r15 = (androidx.compose.foundation.pager.MeasuredPage) r15
            int r15 = r15.getIndex()
            if (r1 > r15) goto L_0x04a2
            r1 = r26
            goto L_0x04a3
        L_0x04a2:
            r1 = 0
        L_0x04a3:
            if (r1 == 0) goto L_0x04ab
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            r1.add(r11)
        L_0x04ab:
            int r8 = r8 + 1
            r1 = r18
            r15 = 0
            goto L_0x0470
        L_0x04b3:
            r18 = r1
            r1 = r3
            java.util.List r1 = (java.util.List) r1
            r16 = r1
        L_0x04bb:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r14 != r1) goto L_0x04c2
            r7 = r5
            goto L_0x04c3
        L_0x04c2:
            r7 = r4
        L_0x04c3:
            r1 = r16
            r2 = 0
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x04d2
            r3 = 0
            r15 = r3
            r3 = 0
            goto L_0x0547
        L_0x04d2:
            r3 = 0
            java.lang.Object r15 = r1.get(r3)
            r17 = r15
            androidx.compose.foundation.pager.MeasuredPage r17 = (androidx.compose.foundation.pager.MeasuredPage) r17
            r18 = 0
            r6 = r49
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            int r11 = r17.getOffset()
            int r12 = r17.getIndex()
            androidx.compose.foundation.gestures.snapping.SnapPositionInLayout r13 = androidx.compose.foundation.pager.PagerStateKt.getSnapAlignmentStartToStart()
            r8 = r53
            r9 = r54
            r10 = r67
            float r6 = androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(r6, r7, r8, r9, r10, r11, r12, r13)
            float r6 = java.lang.Math.abs(r6)
            float r6 = -r6
            r8 = 1
            int r9 = kotlin.collections.CollectionsKt.getLastIndex(r1)
            if (r8 > r9) goto L_0x0546
        L_0x0509:
            java.lang.Object r10 = r1.get(r8)
            r11 = r10
            androidx.compose.foundation.pager.MeasuredPage r11 = (androidx.compose.foundation.pager.MeasuredPage) r11
            r12 = 0
            r17 = r49
            androidx.compose.ui.unit.Density r17 = (androidx.compose.ui.unit.Density) r17
            int r22 = r11.getOffset()
            int r23 = r11.getIndex()
            androidx.compose.foundation.gestures.snapping.SnapPositionInLayout r24 = androidx.compose.foundation.pager.PagerStateKt.getSnapAlignmentStartToStart()
            r18 = r7
            r19 = r53
            r20 = r54
            r21 = r67
            float r13 = androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(r17, r18, r19, r20, r21, r22, r23, r24)
            float r13 = java.lang.Math.abs(r13)
            float r11 = -r13
            int r12 = java.lang.Float.compare(r6, r11)
            if (r12 >= 0) goto L_0x0541
            r12 = r10
            r6 = r11
            r15 = r12
        L_0x0541:
            if (r8 == r9) goto L_0x0546
            int r8 = r8 + 1
            goto L_0x0509
        L_0x0546:
        L_0x0547:
            r1 = r15
            androidx.compose.foundation.pager.MeasuredPage r1 = (androidx.compose.foundation.pager.MeasuredPage) r1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$6 r8 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$6
            r8.<init>(r0)
            r9 = r70
            java.lang.Object r2 = r9.invoke(r2, r6, r8)
            r30 = r2
            androidx.compose.ui.layout.MeasureResult r30 = (androidx.compose.ui.layout.MeasureResult) r30
            r2 = r53
            int r6 = -r2
            r8 = r37
            int r23 = r8 + r54
            r2 = r50
            r10 = r38
            if (r10 < r2) goto L_0x0578
            r11 = r41
            if (r11 <= r8) goto L_0x0575
            goto L_0x057a
        L_0x0575:
            r29 = r3
            goto L_0x057c
        L_0x0578:
            r11 = r41
        L_0x057a:
            r29 = r26
        L_0x057c:
            androidx.compose.foundation.pager.PagerMeasureResult r3 = new androidx.compose.foundation.pager.PagerMeasureResult
            r12 = r1
            androidx.compose.foundation.pager.PageInfo r12 = (androidx.compose.foundation.pager.PageInfo) r12
            r2 = r27
            r15 = r3
            r17 = r50
            r18 = r67
            r19 = r55
            r20 = r54
            r21 = r61
            r22 = r6
            r24 = r64
            r26 = r47
            r27 = r12
            r28 = r31
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return r3
        L_0x05aa:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r16.toString()
            r1.<init>(r3)
            throw r1
        L_0x05b4:
            r9 = r7
            r14 = r10
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r16.toString()
            r0.<init>(r1)
            throw r0
        L_0x05c0:
            r9 = r7
            r14 = r10
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r16.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasureKt.m824measurePagerntgEbfI(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, int, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider, int, int, int, int, int, int, float, long, androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.Alignment$Vertical, androidx.compose.ui.Alignment$Horizontal, boolean, long, int, int, java.util.List, kotlin.jvm.functions.Function3):androidx.compose.foundation.pager.PagerMeasureResult");
    }

    private static final List<MeasuredPage> createPagesAfterList(int currentLastPage, int pagesCount, int beyondBoundsPageCount, List<Integer> pinnedPages, Function1<? super Integer, MeasuredPage> getAndMeasure) {
        List<MeasuredPage> list = null;
        int end = Math.min(currentLastPage + beyondBoundsPageCount, pagesCount - 1);
        int i = currentLastPage + 1;
        if (i <= end) {
            while (true) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(getAndMeasure.invoke(Integer.valueOf(i)));
                if (i == end) {
                    break;
                }
                i++;
            }
        }
        List $this$fastForEach$iv = pinnedPages;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int pageIndex = $this$fastForEach$iv.get(index$iv).intValue();
            boolean z = false;
            if (end + 1 <= pageIndex && pageIndex < pagesCount) {
                z = true;
            }
            if (z) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(getAndMeasure.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int currentFirstPage, int beyondBoundsPageCount, List<Integer> pinnedPages, Function1<? super Integer, MeasuredPage> getAndMeasure) {
        List<MeasuredPage> list = null;
        int start = Math.max(0, currentFirstPage - beyondBoundsPageCount);
        int i = currentFirstPage - 1;
        if (start <= i) {
            while (true) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(getAndMeasure.invoke(Integer.valueOf(i)));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        List $this$fastForEach$iv = pinnedPages;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int pageIndex = $this$fastForEach$iv.get(index$iv).intValue();
            if (pageIndex < start) {
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(getAndMeasure.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0  reason: not valid java name */
    public static final MeasuredPage m823getAndMeasureSGf7dI0(LazyLayoutMeasureScope $this$getAndMeasure_u2dSGf7dI0, int index, long childConstraints, PagerLazyLayoutItemProvider pagerItemProvider, long visualPageOffset, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int pageAvailableSize) {
        return new MeasuredPage(index, pageAvailableSize, $this$getAndMeasure_u2dSGf7dI0.m737measure0kLqBqw(index, childConstraints), visualPageOffset, pagerItemProvider.getKey(index), orientation, horizontalAlignment, verticalAlignment, layoutDirection, reverseLayout, (DefaultConstructorMarker) null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope $this$calculatePagesOffsets, List<MeasuredPage> pages, List<MeasuredPage> extraPagesBefore, List<MeasuredPage> extraPagesAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int pagesScrollOffset, Orientation orientation, boolean reverseLayout, Density density, int spaceBetweenPages, int pageAvailableSize) {
        ArrayList positionedPages;
        int[] offsets;
        int pagesCount;
        int relativeOffset;
        int i = layoutWidth;
        int i2 = layoutHeight;
        Orientation orientation2 = orientation;
        boolean z = reverseLayout;
        int i3 = pageAvailableSize;
        int pageSizeWithSpacing = i3 + spaceBetweenPages;
        int mainAxisLayoutSize = orientation2 == Orientation.Vertical ? i2 : i;
        boolean z2 = true;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(pagesScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList positionedPages2 = new ArrayList(pages.size() + extraPagesBefore.size() + extraPagesAfter.size());
        if (hasSpareSpace) {
            if (!extraPagesBefore.isEmpty() || !extraPagesAfter.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                int pagesCount2 = pages.size();
                int[] iArr = new int[pagesCount2];
                for (int i4 = 0; i4 < pagesCount2; i4++) {
                    iArr[i4] = i3;
                }
                int[] sizes = iArr;
                int[] iArr2 = new int[pagesCount2];
                for (int i5 = 0; i5 < pagesCount2; i5++) {
                    iArr2[i5] = 0;
                }
                int[] offsets2 = iArr2;
                int pagesCount3 = pagesCount2;
                Arrangement.HorizontalOrVertical arrangement = Arrangement.Absolute.INSTANCE.m425spacedBy0680j_4($this$calculatePagesOffsets.m740toDpu2uoSUM(i3));
                if (orientation2 == Orientation.Vertical) {
                    arrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                    offsets = offsets2;
                    int[] iArr3 = sizes;
                    positionedPages = positionedPages2;
                    pagesCount = pagesCount3;
                } else {
                    Density density2 = density;
                    offsets = offsets2;
                    int[] iArr4 = sizes;
                    pagesCount = pagesCount3;
                    positionedPages = positionedPages2;
                    arrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
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
                        int pagesCount4 = pagesCount;
                        MeasuredPage page = pages.get(calculatePagesOffsets$reverseAware(index, z, pagesCount));
                        if (z) {
                            relativeOffset = (mainAxisLayoutSize - absoluteOffset) - page.getSize();
                        } else {
                            relativeOffset = absoluteOffset;
                        }
                        page.position(relativeOffset, i, i2);
                        positionedPages.add(page);
                        if (index == last) {
                            break;
                        }
                        index += step;
                        pagesCount = pagesCount4;
                    }
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            positionedPages = positionedPages2;
            int currentMainAxis = pagesScrollOffset;
            List $this$fastForEach$iv = extraPagesBefore;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                MeasuredPage it = $this$fastForEach$iv.get(index$iv);
                currentMainAxis -= pageSizeWithSpacing;
                it.position(currentMainAxis, i, i2);
                positionedPages.add(it);
            }
            int currentMainAxis2 = pagesScrollOffset;
            List $this$fastForEach$iv2 = pages;
            int size2 = $this$fastForEach$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                MeasuredPage it2 = $this$fastForEach$iv2.get(index$iv2);
                it2.position(currentMainAxis2, i, i2);
                positionedPages.add(it2);
                currentMainAxis2 += pageSizeWithSpacing;
            }
            List $this$fastForEach$iv3 = extraPagesAfter;
            int size3 = $this$fastForEach$iv3.size();
            for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                MeasuredPage it3 = $this$fastForEach$iv3.get(index$iv3);
                it3.position(currentMainAxis2, i, i2);
                positionedPages.add(it3);
                currentMainAxis2 += pageSizeWithSpacing;
            }
        }
        return positionedPages;
    }

    private static final int calculatePagesOffsets$reverseAware(int $this$calculatePagesOffsets_u24reverseAware, boolean $reverseLayout, int pagesCount) {
        return !$reverseLayout ? $this$calculatePagesOffsets_u24reverseAware : (pagesCount - $this$calculatePagesOffsets_u24reverseAware) - 1;
    }

    private static final void debugLog(Function0<String> generateMsg) {
    }
}
