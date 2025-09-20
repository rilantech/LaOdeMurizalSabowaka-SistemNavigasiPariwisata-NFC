package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean singleLine2, float animationProgress2, PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.singleLine = singleLine2;
        this.animationProgress = animationProgress2;
        this.paddingValues = paddingValues2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m3855measure3p2s80s(androidx.compose.ui.layout.MeasureScope r57, java.util.List<? extends androidx.compose.ui.layout.Measurable> r58, long r59) {
        /*
            r56 = this;
            r15 = r56
            r14 = r57
            r13 = r58
            java.lang.String r0 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.compose.foundation.layout.PaddingValues r0 = r15.paddingValues
            float r0 = r0.m2265calculateTopPaddingD9Ej5fM()
            int r23 = r14.m7529roundToPx0680j_4(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = r15.paddingValues
            float r0 = r0.m2262calculateBottomPaddingD9Ej5fM()
            int r12 = r14.m7529roundToPx0680j_4(r0)
            r0 = 0
            r1 = 0
            r8 = 10
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r59
            long r2 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r2, r4, r5, r6, r7, r8, r9)
            r4 = r13
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x003b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0056
            java.lang.Object r5 = r4.next()
            r6 = r5
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r6)
            java.lang.String r9 = "Leading"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x003b
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x0061
            androidx.compose.ui.layout.Placeable r4 = r5.m6399measureBRTryo0(r2)
            r6 = r4
            goto L_0x0062
        L_0x0061:
            r6 = 0
        L_0x0062:
            int r4 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r6)
            int r0 = r0 + r4
            int r4 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r1 = java.lang.Math.max(r1, r4)
            r4 = r13
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0078:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0093
            java.lang.Object r5 = r4.next()
            r7 = r5
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            r8 = 0
            java.lang.Object r9 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r7)
            java.lang.String r11 = "Trailing"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r7 == 0) goto L_0x0078
            goto L_0x0094
        L_0x0093:
            r5 = 0
        L_0x0094:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x00ae
            int r4 = -r0
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r2
            r18 = r4
            long r7 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            androidx.compose.ui.layout.Placeable r4 = r5.m6399measureBRTryo0(r7)
            r7 = r4
            goto L_0x00af
        L_0x00ae:
            r7 = 0
        L_0x00af:
            int r4 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r7)
            int r0 = r0 + r4
            int r4 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r7)
            int r1 = java.lang.Math.max(r1, r4)
            r4 = r13
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00c5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00e0
            java.lang.Object r5 = r4.next()
            r8 = r5
            androidx.compose.ui.layout.Measurable r8 = (androidx.compose.ui.layout.Measurable) r8
            r9 = 0
            java.lang.Object r11 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r8)
            java.lang.String r10 = "Prefix"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x00c5
            goto L_0x00e1
        L_0x00e0:
            r5 = 0
        L_0x00e1:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x00fb
            int r4 = -r0
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r2
            r18 = r4
            long r8 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            androidx.compose.ui.layout.Placeable r4 = r5.m6399measureBRTryo0(r8)
            r8 = r4
            goto L_0x00fc
        L_0x00fb:
            r8 = 0
        L_0x00fc:
            int r4 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r8)
            int r0 = r0 + r4
            int r4 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r8)
            int r1 = java.lang.Math.max(r1, r4)
            r4 = r13
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0112:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0132
            java.lang.Object r5 = r4.next()
            r9 = r5
            androidx.compose.ui.layout.Measurable r9 = (androidx.compose.ui.layout.Measurable) r9
            r10 = 0
            java.lang.Object r11 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r9)
            r16 = r4
            java.lang.String r4 = "Suffix"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x012f
            goto L_0x0133
        L_0x012f:
            r4 = r16
            goto L_0x0112
        L_0x0132:
            r5 = 0
        L_0x0133:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x014d
            int r4 = -r0
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r2
            r18 = r4
            long r9 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            androidx.compose.ui.layout.Placeable r4 = r5.m6399measureBRTryo0(r9)
            r9 = r4
            goto L_0x014e
        L_0x014d:
            r9 = 0
        L_0x014e:
            int r4 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            int r10 = r0 + r4
            int r0 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = -r12
            int r4 = -r10
            long r4 = androidx.compose.ui.unit.ConstraintsKt.m7514offsetNN6EwU(r2, r4, r1)
            r1 = r13
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x016e:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x0194
            java.lang.Object r11 = r1.next()
            r16 = r11
            androidx.compose.ui.layout.Measurable r16 = (androidx.compose.ui.layout.Measurable) r16
            r17 = 0
            r18 = r1
            java.lang.Object r1 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r16)
            r19 = r11
            java.lang.String r11 = "Label"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r11)
            if (r1 == 0) goto L_0x0191
            r11 = r19
            goto L_0x0195
        L_0x0191:
            r1 = r18
            goto L_0x016e
        L_0x0194:
            r11 = 0
        L_0x0195:
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            if (r11 == 0) goto L_0x019e
            androidx.compose.ui.layout.Placeable r1 = r11.m6399measureBRTryo0(r4)
            goto L_0x019f
        L_0x019e:
            r1 = 0
        L_0x019f:
            int r11 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r1)
            int r11 = r23 + r11
            r16 = r4
            int r4 = -r11
            int r5 = r4 - r12
            r30 = 11
            r31 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r24 = r59
            long r14 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            int r4 = -r10
            long r14 = androidx.compose.ui.unit.ConstraintsKt.m7514offsetNN6EwU(r14, r4, r5)
            r4 = r13
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r18 = 0
            java.util.Iterator r19 = r4.iterator()
        L_0x01d1:
            boolean r20 = r19.hasNext()
            r32 = r10
            java.lang.String r10 = "Collection contains no element matching the predicate."
            if (r20 == 0) goto L_0x03f1
            java.lang.Object r20 = r19.next()
            r21 = r20
            androidx.compose.ui.layout.Measurable r21 = (androidx.compose.ui.layout.Measurable) r21
            r24 = 0
            r25 = r4
            java.lang.Object r4 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r21)
            r33 = r5
            java.lang.String r5 = "TextField"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x03db
            r4 = r20
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            androidx.compose.ui.layout.Placeable r4 = r4.m6399measureBRTryo0(r14)
            r34 = r16
            r30 = 14
            r31 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r24 = r14
            r36 = r14
            long r14 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r24, r26, r27, r28, r29, r30, r31)
            r5 = r13
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x021b:
            boolean r16 = r5.hasNext()
            if (r16 == 0) goto L_0x0241
            java.lang.Object r16 = r5.next()
            r17 = r16
            androidx.compose.ui.layout.Measurable r17 = (androidx.compose.ui.layout.Measurable) r17
            r18 = 0
            r19 = r5
            java.lang.Object r5 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r17)
            r24 = r10
            java.lang.String r10 = "Hint"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r10)
            if (r5 == 0) goto L_0x023c
            goto L_0x0245
        L_0x023c:
            r5 = r19
            r10 = r24
            goto L_0x021b
        L_0x0241:
            r24 = r10
            r16 = 0
        L_0x0245:
            r5 = r16
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x0251
            androidx.compose.ui.layout.Placeable r5 = r5.m6399measureBRTryo0(r14)
            goto L_0x0252
        L_0x0251:
            r5 = 0
        L_0x0252:
            r26 = r33
            int r10 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r4)
            r27 = r14
            int r14 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r5)
            int r10 = java.lang.Math.max(r10, r14)
            int r10 = r10 + r11
            int r10 = r10 + r12
            int r10 = java.lang.Math.max(r0, r10)
            r15 = r10
            int r0 = -r15
            r20 = 1
            r21 = 0
            r18 = 0
            r16 = r2
            r19 = r0
            long r38 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            r44 = 11
            r45 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            long r16 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r38, r40, r41, r42, r43, r44, r45)
            r29 = r16
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0295:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x02ba
            java.lang.Object r10 = r0.next()
            r14 = r10
            androidx.compose.ui.layout.Measurable r14 = (androidx.compose.ui.layout.Measurable) r14
            r16 = 0
            r17 = r0
            java.lang.Object r0 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r14)
            r38 = r2
            java.lang.String r2 = "Supporting"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x02b5
            goto L_0x02bd
        L_0x02b5:
            r0 = r17
            r2 = r38
            goto L_0x0295
        L_0x02ba:
            r38 = r2
            r10 = 0
        L_0x02bd:
            androidx.compose.ui.layout.Measurable r10 = (androidx.compose.ui.layout.Measurable) r10
            if (r10 == 0) goto L_0x02c8
            r2 = r29
            androidx.compose.ui.layout.Placeable r0 = r10.m6399measureBRTryo0(r2)
            goto L_0x02cb
        L_0x02c8:
            r2 = r29
            r0 = 0
        L_0x02cb:
            r29 = r11
            r11 = r0
            int r25 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            int r40 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r6)
            int r41 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r7)
            int r42 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r8)
            int r43 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            int r44 = r4.getWidth()
            int r45 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r1)
            int r46 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r5)
            r47 = r59
            int r14 = androidx.compose.material3.TextFieldKt.m3854calculateWidthyeHjK3Y(r40, r41, r42, r43, r44, r45, r46, r47)
            int r40 = r4.getHeight()
            int r41 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r1)
            int r42 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r43 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r7)
            int r44 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r8)
            int r45 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r46 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r5)
            int r47 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            r10 = r56
            float r0 = r10.animationProgress
            r16 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            r16 = 0
            if (r0 != 0) goto L_0x0325
            r0 = 1
            r48 = r0
            goto L_0x0327
        L_0x0325:
            r48 = r16
        L_0x0327:
            float r51 = r57.getDensity()
            androidx.compose.foundation.layout.PaddingValues r0 = r10.paddingValues
            r49 = r59
            r52 = r0
            int r30 = androidx.compose.material3.TextFieldKt.m3853calculateHeightmKXJcVc(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r51, r52)
            int r0 = r30 - r25
            r17 = r13
            java.lang.Iterable r17 = (java.lang.Iterable) r17
            r18 = 0
            java.util.Iterator r19 = r17.iterator()
        L_0x0342:
            boolean r20 = r19.hasNext()
            if (r20 == 0) goto L_0x03cf
            java.lang.Object r20 = r19.next()
            r21 = r20
            androidx.compose.ui.layout.Measurable r21 = (androidx.compose.ui.layout.Measurable) r21
            r22 = 0
            r40 = r2
            java.lang.Object r2 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r21)
            java.lang.String r3 = "Container"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x03b5
            r2 = r20
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r3) goto L_0x036c
            r53 = r14
            goto L_0x036e
        L_0x036c:
            r53 = r16
        L_0x036e:
            if (r0 == r3) goto L_0x0373
            r3 = r0
            goto L_0x0375
        L_0x0373:
            r3 = r16
        L_0x0375:
            r21 = r12
            r10 = r53
            long r12 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r10, r14, r3, r0)
            androidx.compose.ui.layout.Placeable r24 = r2.m6399measureBRTryo0(r12)
            androidx.compose.material3.TextFieldMeasurePolicy$measure$1 r16 = new androidx.compose.material3.TextFieldMeasurePolicy$measure$1
            r31 = r0
            r0 = r16
            r2 = r14
            r3 = r30
            r10 = r24
            r33 = r21
            r12 = r56
            r13 = r23
            r42 = r14
            r54 = r27
            r27 = r36
            r36 = r54
            r14 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r20 = r16
            kotlin.jvm.functions.Function1 r20 = (kotlin.jvm.functions.Function1) r20
            r21 = 4
            r22 = 0
            r19 = 0
            r16 = r57
            r17 = r42
            r18 = r30
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.ui.layout.MeasureScope.layout$default(r16, r17, r18, r19, r20, r21, r22)
            return r0
        L_0x03b5:
            r31 = r0
            r33 = r12
            r42 = r14
            r54 = r27
            r27 = r36
            r36 = r54
            r10 = r56
            r13 = r58
            r2 = r40
            r54 = r27
            r27 = r36
            r36 = r54
            goto L_0x0342
        L_0x03cf:
            r31 = r0
            r40 = r2
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r2 = r24
            r0.<init>(r2)
            throw r0
        L_0x03db:
            r38 = r2
            r29 = r11
            r27 = r14
            r34 = r16
            r26 = r33
            r33 = r12
            r13 = r58
            r4 = r25
            r5 = r26
            r10 = r32
            goto L_0x01d1
        L_0x03f1:
            r38 = r2
            r2 = r10
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.m3855measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, TextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, TextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, TextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, TextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicWidth(java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r16, int r17, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r18) {
        /*
            r15 = this;
            r0 = r18
            r1 = r16
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x000b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01ab
            java.lang.Object r4 = r3.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r8 = "TextField"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x000b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.invoke(r4, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r6 = r1.intValue()
            r1 = r16
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x003c:
            boolean r2 = r1.hasNext()
            r8 = 0
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r1.next()
            r3 = r2
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            r4 = 0
            java.lang.Object r5 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r3)
            java.lang.String r7 = "Label"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x003c
            goto L_0x0059
        L_0x0058:
            r2 = r8
        L_0x0059:
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            r1 = 0
            if (r2 == 0) goto L_0x006f
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Object r4 = r0.invoke(r2, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r2 = r4.intValue()
            r7 = r2
            goto L_0x0070
        L_0x006f:
            r7 = r1
        L_0x0070:
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0079:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0094
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r5 = 0
            java.lang.Object r9 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r10 = "Trailing"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r4 == 0) goto L_0x0079
            goto L_0x0095
        L_0x0094:
            r3 = r8
        L_0x0095:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            if (r3 == 0) goto L_0x00ab
            r2 = r3
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Object r4 = r0.invoke(r2, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r2 = r4.intValue()
            r3 = r2
            goto L_0x00ac
        L_0x00ab:
            r3 = r1
        L_0x00ac:
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00b5:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00d0
            java.lang.Object r4 = r2.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r9 = 0
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r11 = "Prefix"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r5 == 0) goto L_0x00b5
            goto L_0x00d1
        L_0x00d0:
            r4 = r8
        L_0x00d1:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x00e7
            r2 = r4
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            java.lang.Object r5 = r0.invoke(r2, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r2 = r5.intValue()
            r4 = r2
            goto L_0x00e8
        L_0x00e7:
            r4 = r1
        L_0x00e8:
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00f1:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x010c
            java.lang.Object r5 = r2.next()
            r9 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            r10 = 0
            java.lang.Object r11 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r9)
            java.lang.String r12 = "Suffix"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x00f1
            goto L_0x010d
        L_0x010c:
            r5 = r8
        L_0x010d:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x0123
            r2 = r5
            r5 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            java.lang.Object r9 = r0.invoke(r2, r9)
            java.lang.Number r9 = (java.lang.Number) r9
            int r2 = r9.intValue()
            r5 = r2
            goto L_0x0124
        L_0x0123:
            r5 = r1
        L_0x0124:
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x012d:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x0148
            java.lang.Object r9 = r2.next()
            r10 = r9
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            r11 = 0
            java.lang.Object r12 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r13 = "Leading"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r10 == 0) goto L_0x012d
            goto L_0x0149
        L_0x0148:
            r9 = r8
        L_0x0149:
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            if (r9 == 0) goto L_0x015e
            r2 = r9
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r17)
            java.lang.Object r10 = r0.invoke(r2, r10)
            java.lang.Number r10 = (java.lang.Number) r10
            int r2 = r10.intValue()
            goto L_0x015f
        L_0x015e:
            r2 = r1
        L_0x015f:
            r9 = r16
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0168:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0183
            java.lang.Object r10 = r9.next()
            r11 = r10
            androidx.compose.ui.layout.IntrinsicMeasurable r11 = (androidx.compose.ui.layout.IntrinsicMeasurable) r11
            r12 = 0
            java.lang.Object r13 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r11)
            java.lang.String r14 = "Hint"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r11 == 0) goto L_0x0168
            r8 = r10
        L_0x0183:
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            if (r8 == 0) goto L_0x0199
            r1 = r8
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            java.lang.Object r9 = r0.invoke(r1, r9)
            java.lang.Number r9 = (java.lang.Number) r9
            int r1 = r9.intValue()
            r8 = r1
            goto L_0x019a
        L_0x0199:
            r8 = r1
        L_0x019a:
            long r9 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            int r1 = androidx.compose.material3.TextFieldKt.m3854calculateWidthyeHjK3Y(r2, r3, r4, r5, r6, r7, r8, r9)
            return r1
        L_0x01ab:
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            java.lang.String r4 = "Collection contains no element matching the predicate."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.intrinsicWidth(java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r17, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r18, int r19, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r20
            r2 = r18
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r4 = r2.iterator()
        L_0x000d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01f7
            java.lang.Object r5 = r4.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r9 = "TextField"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x000d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
            java.lang.Object r2 = r1.invoke(r5, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r3 = r2.intValue()
            r2 = r18
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r4 = r2.hasNext()
            r10 = 0
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r2.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r8 = "Label"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x003e
            goto L_0x005b
        L_0x005a:
            r4 = r10
        L_0x005b:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x006f
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r19)
            java.lang.Object r6 = r1.invoke(r4, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r4 = r6.intValue()
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            r5 = r18
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0079:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0094
            java.lang.Object r6 = r5.next()
            r7 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            r8 = 0
            java.lang.Object r9 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r11 = "Trailing"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r7 == 0) goto L_0x0079
            goto L_0x0095
        L_0x0094:
            r6 = r10
        L_0x0095:
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            if (r6 == 0) goto L_0x00ab
            r5 = r6
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r19)
            java.lang.Object r7 = r1.invoke(r5, r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r5 = r7.intValue()
            r6 = r5
            goto L_0x00ac
        L_0x00ab:
            r6 = 0
        L_0x00ac:
            r5 = r18
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00b5:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00d0
            java.lang.Object r7 = r5.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r9 = 0
            java.lang.Object r11 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r12 = "Leading"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r8 == 0) goto L_0x00b5
            goto L_0x00d1
        L_0x00d0:
            r7 = r10
        L_0x00d1:
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            if (r7 == 0) goto L_0x00e6
            r5 = r7
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            java.lang.Object r8 = r1.invoke(r5, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r5 = r8.intValue()
            goto L_0x00e7
        L_0x00e6:
            r5 = 0
        L_0x00e7:
            r7 = r18
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x00f0:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x010b
            java.lang.Object r8 = r7.next()
            r9 = r8
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            r11 = 0
            java.lang.Object r12 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r9)
            java.lang.String r13 = "Prefix"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r9 == 0) goto L_0x00f0
            goto L_0x010c
        L_0x010b:
            r8 = r10
        L_0x010c:
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            if (r8 == 0) goto L_0x0121
            r7 = r8
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r19)
            java.lang.Object r9 = r1.invoke(r7, r9)
            java.lang.Number r9 = (java.lang.Number) r9
            int r7 = r9.intValue()
            goto L_0x0122
        L_0x0121:
            r7 = 0
        L_0x0122:
            r8 = r18
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x012b:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0146
            java.lang.Object r9 = r8.next()
            r11 = r9
            androidx.compose.ui.layout.IntrinsicMeasurable r11 = (androidx.compose.ui.layout.IntrinsicMeasurable) r11
            r12 = 0
            java.lang.Object r13 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r11)
            java.lang.String r14 = "Suffix"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r11 == 0) goto L_0x012b
            goto L_0x0147
        L_0x0146:
            r9 = r10
        L_0x0147:
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            if (r9 == 0) goto L_0x015c
            r8 = r9
            r9 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r19)
            java.lang.Object r11 = r1.invoke(r8, r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r8 = r11.intValue()
            goto L_0x015d
        L_0x015c:
            r8 = 0
        L_0x015d:
            r9 = r18
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0166:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0181
            java.lang.Object r11 = r9.next()
            r12 = r11
            androidx.compose.ui.layout.IntrinsicMeasurable r12 = (androidx.compose.ui.layout.IntrinsicMeasurable) r12
            r13 = 0
            java.lang.Object r14 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r12)
            java.lang.String r15 = "Hint"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r12 == 0) goto L_0x0166
            goto L_0x0182
        L_0x0181:
            r11 = r10
        L_0x0182:
            androidx.compose.ui.layout.IntrinsicMeasurable r11 = (androidx.compose.ui.layout.IntrinsicMeasurable) r11
            if (r11 == 0) goto L_0x0197
            r9 = r11
            r11 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r19)
            java.lang.Object r12 = r1.invoke(r9, r12)
            java.lang.Number r12 = (java.lang.Number) r12
            int r9 = r12.intValue()
            goto L_0x0198
        L_0x0197:
            r9 = 0
        L_0x0198:
            r11 = r18
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L_0x01a1:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01bc
            java.lang.Object r12 = r11.next()
            r13 = r12
            androidx.compose.ui.layout.IntrinsicMeasurable r13 = (androidx.compose.ui.layout.IntrinsicMeasurable) r13
            r14 = 0
            java.lang.Object r15 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r13)
            java.lang.String r2 = "Supporting"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x01a1
            r10 = r12
        L_0x01bc:
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            if (r10 == 0) goto L_0x01d2
            r2 = r10
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r19)
            java.lang.Object r11 = r1.invoke(r2, r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r2 = r11.intValue()
            r10 = r2
            goto L_0x01d3
        L_0x01d2:
            r10 = 0
        L_0x01d3:
            float r2 = r0.animationProgress
            r11 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x01e7
            r2 = 1
            r11 = r2
            goto L_0x01e8
        L_0x01e7:
            r11 = 0
        L_0x01e8:
            long r12 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r14 = r17.getDensity()
            androidx.compose.foundation.layout.PaddingValues r15 = r0.paddingValues
            int r2 = androidx.compose.material3.TextFieldKt.m3853calculateHeightmKXJcVc(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15)
            return r2
        L_0x01f7:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Collection contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }
}
