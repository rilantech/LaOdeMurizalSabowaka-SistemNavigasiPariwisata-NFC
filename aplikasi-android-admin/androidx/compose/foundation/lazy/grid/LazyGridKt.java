package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0001\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\u0007¢\u0006\u0002\b\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003ø\u0001\u0000¢\u0006\u0002\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyGrid(androidx.compose.ui.Modifier r36, androidx.compose.foundation.lazy.grid.LazyGridState r37, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, androidx.compose.foundation.lazy.grid.LazyGridSlots> r38, androidx.compose.foundation.layout.PaddingValues r39, boolean r40, boolean r41, androidx.compose.foundation.gestures.FlingBehavior r42, boolean r43, androidx.compose.foundation.layout.Arrangement.Vertical r44, androidx.compose.foundation.layout.Arrangement.Horizontal r45, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r15 = r37
            r14 = r38
            r13 = r41
            r12 = r44
            r11 = r45
            r10 = r46
            r9 = r48
            r8 = r50
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "slots"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "verticalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "horizontalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 152645664(0x9193020, float:1.8439333E-33)
            r1 = r47
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)66@3113L15,76@3554L18,78@3603L50,80@3679L51,82@3756L221,95@4018L48,102@4304L277,110@4645L125,119@4994L7,98@4159L1320:LazyGrid.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r48
            r2 = r49
            r3 = r8 & 1
            if (r3 == 0) goto L_0x0048
            r1 = r1 | 6
            r6 = r36
            goto L_0x005e
        L_0x0048:
            r6 = r9 & 14
            if (r6 != 0) goto L_0x005c
            r6 = r36
            boolean r16 = r7.changed((java.lang.Object) r6)
            if (r16 == 0) goto L_0x0057
            r16 = 4
            goto L_0x0059
        L_0x0057:
            r16 = 2
        L_0x0059:
            r1 = r1 | r16
            goto L_0x005e
        L_0x005c:
            r6 = r36
        L_0x005e:
            r16 = r8 & 2
            if (r16 == 0) goto L_0x0065
            r1 = r1 | 48
            goto L_0x0076
        L_0x0065:
            r16 = r9 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x0076
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0072
            r16 = 32
            goto L_0x0074
        L_0x0072:
            r16 = 16
        L_0x0074:
            r1 = r1 | r16
        L_0x0076:
            r16 = r8 & 4
            if (r16 == 0) goto L_0x007d
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x008d
        L_0x007d:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x008d
            boolean r4 = r7.changedInstance(r14)
            if (r4 == 0) goto L_0x008a
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x008c
        L_0x008a:
            r4 = 128(0x80, float:1.794E-43)
        L_0x008c:
            r1 = r1 | r4
        L_0x008d:
            r4 = r8 & 8
            if (r4 == 0) goto L_0x0096
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r0 = r39
            goto L_0x00ac
        L_0x0096:
            r0 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x00aa
            r0 = r39
            boolean r17 = r7.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00a5
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x00a7
        L_0x00a5:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x00a7:
            r1 = r1 | r17
            goto L_0x00ac
        L_0x00aa:
            r0 = r39
        L_0x00ac:
            r17 = r8 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            if (r17 == 0) goto L_0x00b8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r5 = r40
            goto L_0x00ce
        L_0x00b8:
            r19 = r9 & r18
            if (r19 != 0) goto L_0x00cc
            r5 = r40
            boolean r20 = r7.changed((boolean) r5)
            if (r20 == 0) goto L_0x00c7
            r20 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00c9
        L_0x00c7:
            r20 = 8192(0x2000, float:1.14794E-41)
        L_0x00c9:
            r1 = r1 | r20
            goto L_0x00ce
        L_0x00cc:
            r5 = r40
        L_0x00ce:
            r20 = r8 & 32
            r21 = 458752(0x70000, float:6.42848E-40)
            if (r20 == 0) goto L_0x00d9
            r20 = 196608(0x30000, float:2.75506E-40)
        L_0x00d6:
            r1 = r1 | r20
            goto L_0x00e9
        L_0x00d9:
            r20 = r9 & r21
            if (r20 != 0) goto L_0x00e9
            boolean r20 = r7.changed((boolean) r13)
            if (r20 == 0) goto L_0x00e6
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d6
        L_0x00e6:
            r20 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00d6
        L_0x00e9:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r22 = r9 & r20
            if (r22 != 0) goto L_0x0105
            r22 = r8 & 64
            if (r22 != 0) goto L_0x00fe
            r0 = r42
            boolean r22 = r7.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x0100
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x00fe:
            r0 = r42
        L_0x0100:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r1 = r1 | r22
            goto L_0x0107
        L_0x0105:
            r0 = r42
        L_0x0107:
            r0 = r8 & 128(0x80, float:1.794E-43)
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x0113
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r0
            r0 = r43
            goto L_0x0129
        L_0x0113:
            r0 = r9 & r22
            if (r0 != 0) goto L_0x0127
            r0 = r43
            boolean r23 = r7.changed((boolean) r0)
            if (r23 == 0) goto L_0x0122
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0124
        L_0x0122:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x0124:
            r1 = r1 | r23
            goto L_0x0129
        L_0x0127:
            r0 = r43
        L_0x0129:
            r0 = r8 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0131
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x012f:
            r1 = r1 | r0
            goto L_0x0142
        L_0x0131:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x0142
            boolean r0 = r7.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x013f
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012f
        L_0x013f:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x012f
        L_0x0142:
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x014a
            r0 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0148:
            r1 = r1 | r0
            goto L_0x015b
        L_0x014a:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x015b
            boolean r0 = r7.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0158
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0148
        L_0x0158:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0148
        L_0x015b:
            r0 = r8 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0162
            r2 = r2 | 6
            goto L_0x0170
        L_0x0162:
            r0 = r49 & 14
            if (r0 != 0) goto L_0x0170
            boolean r0 = r7.changedInstance(r10)
            if (r0 == 0) goto L_0x016e
            r0 = 4
            goto L_0x016f
        L_0x016e:
            r0 = 2
        L_0x016f:
            r2 = r2 | r0
        L_0x0170:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r5) goto L_0x0197
            r0 = r2 & 11
            r5 = 2
            if (r0 != r5) goto L_0x0197
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x0185
            goto L_0x0197
        L_0x0185:
            r7.skipToGroupEnd()
            r17 = r39
            r22 = r40
            r19 = r42
            r33 = r1
            r31 = r2
            r20 = r6
            r10 = r7
            goto L_0x033f
        L_0x0197:
            r7.startDefaults()
            r0 = r9 & 1
            r5 = 6
            if (r0 == 0) goto L_0x01c1
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a6
            goto L_0x01c1
        L_0x01a6:
            r7.skipToGroupEnd()
            r0 = r8 & 64
            if (r0 == 0) goto L_0x01b9
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r0
            r17 = r39
            r4 = r40
            r19 = r42
            r3 = r1
            goto L_0x01fa
        L_0x01b9:
            r17 = r39
            r4 = r40
            r19 = r42
            r3 = r1
            goto L_0x01fa
        L_0x01c1:
            if (r3 == 0) goto L_0x01c8
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x01c8:
            if (r4 == 0) goto L_0x01d6
            r0 = 0
            r3 = 0
            float r4 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r0 = androidx.compose.foundation.layout.PaddingKt.m2241PaddingValues0680j_4(r0)
            goto L_0x01d8
        L_0x01d6:
            r0 = r39
        L_0x01d8:
            if (r17 == 0) goto L_0x01dc
            r3 = 0
            goto L_0x01de
        L_0x01dc:
            r3 = r40
        L_0x01de:
            r4 = r8 & 64
            if (r4 == 0) goto L_0x01f4
            androidx.compose.foundation.gestures.ScrollableDefaults r4 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.gestures.FlingBehavior r4 = r4.flingBehavior(r7, r5)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r17
            r17 = r0
            r19 = r4
            r4 = r3
            r3 = r1
            goto L_0x01fa
        L_0x01f4:
            r19 = r42
            r17 = r0
            r4 = r3
            r3 = r1
        L_0x01fa:
            r7.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x020b
            java.lang.String r0 = "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)"
            r1 = 152645664(0x9193020, float:1.8439333E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r3, r2, r0)
        L_0x020b:
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.OverscrollEffect r5 = r0.overscrollEffect(r7, r5)
            int r0 = r3 >> 3
            r0 = r0 & 14
            int r1 = r2 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            kotlin.jvm.functions.Function0 r1 = androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(r15, r10, r7, r0)
            int r0 = r3 >> 3
            r0 = r0 & 14
            int r16 = r3 >> 9
            r16 = r16 & 112(0x70, float:1.57E-43)
            r0 = r0 | r16
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r16 = androidx.compose.foundation.lazy.grid.LazySemanticsKt.rememberLazyGridSemanticState(r15, r4, r7, r0)
            r0 = r3 & 112(0x70, float:1.57E-43)
            r47 = r2
            r2 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = r3 & r18
            r0 = r0 | r2
            r2 = r3 & r21
            r0 = r0 | r2
            int r2 = r3 >> 9
            r2 = r2 & r20
            r0 = r0 | r2
            int r2 = r3 >> 3
            r2 = r2 & r22
            r20 = r0 | r2
            r22 = 0
            r0 = r1
            r2 = r1
            r1 = r37
            r31 = r47
            r32 = r2
            r2 = r38
            r33 = r3
            r3 = r17
            r36 = r4
            r34 = r5
            r5 = r41
            r35 = r6
            r6 = r45
            r39 = r7
            r7 = r44
            r8 = r39
            r9 = r20
            r10 = r22
            kotlin.jvm.functions.Function2 r9 = rememberLazyGridMeasurePolicy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r15.setVertical$foundation_release(r13)
            r0 = r33 & 112(0x70, float:1.57E-43)
            r10 = r39
            r8 = r32
            ScrollPositionUpdater(r8, r15, r10, r0)
            if (r13 == 0) goto L_0x0287
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0289
        L_0x0287:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0289:
            androidx.compose.ui.layout.RemeasurementModifier r1 = r37.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r7 = r35
            androidx.compose.ui.Modifier r1 = r7.then(r1)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r2 = r37.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            int r2 = r33 >> 9
            r2 = r2 & r18
            int r3 = r33 << 3
            r3 = r3 & r21
            r18 = r2 | r3
            r2 = r8
            r3 = r16
            r4 = r0
            r5 = r43
            r6 = r36
            r20 = r7
            r7 = r10
            r21 = r8
            r8 = r18
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r1, r0)
            r2 = r33 & 112(0x70, float:1.57E-43)
            int r3 = r33 >> 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r5 = r2 | r3
            r8 = r0
            r0 = r1
            r1 = r37
            r2 = r36
            r3 = r8
            r4 = r10
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.grid.LazyGridBeyondBoundsModifierKt.lazyGridBeyondBoundsModifier(r0, r1, r2, r3, r4, r5)
            r7 = r34
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.OverscrollKt.overscroll(r0, r7)
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r5)
            java.lang.Object r4 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            boolean r28 = r0.reverseDirection(r4, r8, r6)
            androidx.compose.foundation.interaction.MutableInteractionSource r30 = r37.getInternalInteractionSource$foundation_release()
            r24 = r15
            androidx.compose.foundation.gestures.ScrollableState r24 = (androidx.compose.foundation.gestures.ScrollableState) r24
            r25 = r8
            r26 = r7
            r27 = r43
            r29 = r19
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r23, r24, r25, r26, r27, r28, r29, r30)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r37.getPrefetchState$foundation_release()
            r0 = 0
            r18 = 0
            r1 = r21
            r4 = r9
            r5 = r10
            r22 = r6
            r6 = r0
            r0 = r7
            r7 = r18
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x033f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033f:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 != 0) goto L_0x0348
            r18 = r10
            goto L_0x0375
        L_0x0348:
            androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1 r16 = new androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
            r0 = r16
            r1 = r20
            r2 = r37
            r3 = r38
            r4 = r17
            r5 = r22
            r6 = r41
            r7 = r19
            r8 = r43
            r15 = r9
            r9 = r44
            r18 = r10
            r10 = r45
            r11 = r46
            r12 = r48
            r13 = r49
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0375:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ScrollPositionUpdater(Function0<? extends LazyGridItemProvider> itemProviderLambda, LazyGridState state, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-649335720);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(itemProviderLambda) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649335720, $changed, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:138)");
            }
            LazyGridItemProvider itemProvider = (LazyGridItemProvider) itemProviderLambda.invoke();
            if (itemProvider.getItemCount() > 0) {
                LazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(state, itemProvider, 0, 2, (Object) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyGridKt$ScrollPositionUpdater$1(itemProviderLambda, state, $changed));
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(Function0<? extends LazyGridItemProvider> itemProviderLambda, LazyGridState state, Function2<? super Density, ? super Constraints, LazyGridSlots> slots, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, Composer $composer, int $changed, int i) {
        Arrangement.Vertical verticalArrangement2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(1292704639);
        ComposerKt.sourceInformation(composer, "C(rememberLazyGridMeasurePolicy)P(3,6,5!1,4,2)173@6918L8458:LazyGrid.kt#7791vq");
        Arrangement.Horizontal horizontalArrangement2 = (i2 & 64) != 0 ? null : horizontalArrangement;
        if ((i2 & 128) != 0) {
            verticalArrangement2 = null;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1292704639, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:156)");
        } else {
            int i3 = $changed;
        }
        Object[] keys$iv = {state, slots, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalArrangement2, verticalArrangement2};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(isVertical, contentPadding, reverseLayout, itemProviderLambda, slots, state, verticalArrangement2, horizontalArrangement2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }
}
