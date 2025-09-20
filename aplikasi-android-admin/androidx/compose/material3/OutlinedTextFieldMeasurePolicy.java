package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B4\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J/\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> onLabelMeasured2, boolean singleLine2, float animationProgress2, PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(onLabelMeasured2, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.onLabelMeasured = onLabelMeasured2;
        this.singleLine = singleLine2;
        this.animationProgress = animationProgress2;
        this.paddingValues = paddingValues2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m3615measure3p2s80s(androidx.compose.ui.layout.MeasureScope r47, java.util.List<? extends androidx.compose.ui.layout.Measurable> r48, long r49) {
        /*
            r46 = this;
            r14 = r46
            r15 = r47
            r13 = r48
            java.lang.String r0 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 0
            r1 = 0
            androidx.compose.foundation.layout.PaddingValues r2 = r14.paddingValues
            float r2 = r2.m2262calculateBottomPaddingD9Ej5fM()
            int r12 = r15.m7529roundToPx0680j_4(r2)
            r8 = 10
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r49
            long r10 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r2, r4, r5, r6, r7, r8, r9)
            r2 = r13
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0032:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x004d
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            r5 = 0
            java.lang.Object r6 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r4)
            java.lang.String r7 = "Leading"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r4 == 0) goto L_0x0032
            goto L_0x004e
        L_0x004d:
            r3 = 0
        L_0x004e:
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            if (r3 == 0) goto L_0x0059
            androidx.compose.ui.layout.Placeable r2 = r3.m6399measureBRTryo0(r10)
            r3 = r2
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            int r2 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r3)
            int r0 = r0 + r2
            int r2 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r3)
            int r1 = java.lang.Math.max(r1, r2)
            r2 = r13
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0070:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008b
            java.lang.Object r4 = r2.next()
            r5 = r4
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r5)
            java.lang.String r9 = "Trailing"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r5 == 0) goto L_0x0070
            goto L_0x008c
        L_0x008b:
            r4 = 0
        L_0x008c:
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            if (r4 == 0) goto L_0x00a6
            int r2 = -r0
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r10
            r18 = r2
            long r5 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            androidx.compose.ui.layout.Placeable r2 = r4.m6399measureBRTryo0(r5)
            r4 = r2
            goto L_0x00a7
        L_0x00a6:
            r4 = 0
        L_0x00a7:
            int r2 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r4)
            int r0 = r0 + r2
            int r2 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r4)
            int r1 = java.lang.Math.max(r1, r2)
            r2 = r13
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00bd:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x00d8
            java.lang.Object r5 = r2.next()
            r6 = r5
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            r7 = 0
            java.lang.Object r9 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r6)
            java.lang.String r8 = "Prefix"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x00bd
            goto L_0x00d9
        L_0x00d8:
            r5 = 0
        L_0x00d9:
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            if (r5 == 0) goto L_0x00f3
            int r2 = -r0
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r10
            r18 = r2
            long r6 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            androidx.compose.ui.layout.Placeable r2 = r5.m6399measureBRTryo0(r6)
            r5 = r2
            goto L_0x00f4
        L_0x00f3:
            r5 = 0
        L_0x00f4:
            int r2 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r5)
            int r0 = r0 + r2
            int r2 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r5)
            int r1 = java.lang.Math.max(r1, r2)
            r2 = r13
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x010a:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x012a
            java.lang.Object r6 = r2.next()
            r7 = r6
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            r8 = 0
            java.lang.Object r9 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r7)
            r16 = r2
            java.lang.String r2 = "Suffix"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0127
            goto L_0x012b
        L_0x0127:
            r2 = r16
            goto L_0x010a
        L_0x012a:
            r6 = 0
        L_0x012b:
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            if (r6 == 0) goto L_0x0145
            int r2 = -r0
            r20 = 2
            r21 = 0
            r19 = 0
            r16 = r10
            r18 = r2
            long r7 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            androidx.compose.ui.layout.Placeable r2 = r6.m6399measureBRTryo0(r7)
            r6 = r2
            goto L_0x0146
        L_0x0145:
            r6 = 0
        L_0x0146:
            int r2 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r6)
            int r8 = r0 + r2
            int r0 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r0 = java.lang.Math.max(r1, r0)
            float r1 = r14.animationProgress
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x015f
            r1 = 1
            goto L_0x0160
        L_0x015f:
            r1 = 0
        L_0x0160:
            r35 = r1
            androidx.compose.foundation.layout.PaddingValues r1 = r14.paddingValues
            androidx.compose.ui.unit.LayoutDirection r7 = r47.getLayoutDirection()
            float r1 = r1.m2263calculateLeftPaddingu2uoSUM(r7)
            int r1 = r15.m7529roundToPx0680j_4(r1)
            androidx.compose.foundation.layout.PaddingValues r7 = r14.paddingValues
            androidx.compose.ui.unit.LayoutDirection r9 = r47.getLayoutDirection()
            float r7 = r7.m2264calculateRightPaddingu2uoSUM(r9)
            int r7 = r15.m7529roundToPx0680j_4(r7)
            int r1 = r1 + r7
            if (r35 == 0) goto L_0x0186
            int r7 = -r8
            int r7 = r7 - r1
            goto L_0x0187
        L_0x0186:
            int r7 = -r1
        L_0x0187:
            int r9 = -r12
            r36 = r1
            long r1 = androidx.compose.ui.unit.ConstraintsKt.m7514offsetNN6EwU(r10, r7, r9)
            r7 = r13
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0195:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x01bb
            java.lang.Object r9 = r7.next()
            r16 = r9
            androidx.compose.ui.layout.Measurable r16 = (androidx.compose.ui.layout.Measurable) r16
            r17 = 0
            r18 = r7
            java.lang.Object r7 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r16)
            r19 = r9
            java.lang.String r9 = "Label"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 == 0) goto L_0x01b8
            r9 = r19
            goto L_0x01bc
        L_0x01b8:
            r7 = r18
            goto L_0x0195
        L_0x01bb:
            r9 = 0
        L_0x01bc:
            androidx.compose.ui.layout.Measurable r9 = (androidx.compose.ui.layout.Measurable) r9
            if (r9 == 0) goto L_0x01c5
            androidx.compose.ui.layout.Placeable r7 = r9.m6399measureBRTryo0(r1)
            goto L_0x01c6
        L_0x01c5:
            r7 = 0
        L_0x01c6:
            r37 = r7
            if (r37 == 0) goto L_0x01ea
            r7 = r37
            r9 = 0
            r38 = r1
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Size, kotlin.Unit> r1 = r14.onLabelMeasured
            int r2 = r7.getWidth()
            float r2 = (float) r2
            r16 = r9
            int r9 = r7.getHeight()
            float r9 = (float) r9
            long r17 = androidx.compose.ui.geometry.SizeKt.Size(r2, r9)
            androidx.compose.ui.geometry.Size r2 = androidx.compose.ui.geometry.Size.m4770boximpl(r17)
            r1.invoke(r2)
            goto L_0x01ec
        L_0x01ea:
            r38 = r1
        L_0x01ec:
            int r1 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r37)
            int r1 = r1 / 2
            androidx.compose.foundation.layout.PaddingValues r2 = r14.paddingValues
            float r2 = r2.m2265calculateTopPaddingD9Ej5fM()
            int r2 = r15.m7529roundToPx0680j_4(r2)
            int r1 = java.lang.Math.max(r1, r2)
            r40 = r1
            int r1 = -r8
            int r2 = -r12
            int r2 = r2 - r40
            r14 = r49
            long r23 = androidx.compose.ui.unit.ConstraintsKt.m7514offsetNN6EwU(r14, r1, r2)
            r29 = 11
            r30 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            long r1 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r23, r25, r26, r27, r28, r29, r30)
            r7 = r13
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            r9 = 0
            java.util.Iterator r16 = r7.iterator()
        L_0x0228:
            boolean r17 = r16.hasNext()
            r41 = r8
            java.lang.String r8 = "Collection contains no element matching the predicate."
            if (r17 == 0) goto L_0x0445
            java.lang.Object r17 = r16.next()
            r18 = r17
            androidx.compose.ui.layout.Measurable r18 = (androidx.compose.ui.layout.Measurable) r18
            r19 = 0
            r20 = r7
            java.lang.Object r7 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r18)
            r21 = r9
            java.lang.String r9 = "TextField"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 == 0) goto L_0x042b
            r7 = r17
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            androidx.compose.ui.layout.Placeable r7 = r7.m6399measureBRTryo0(r1)
            r29 = 14
            r30 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r23 = r1
            long r14 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r23, r25, r26, r27, r28, r29, r30)
            r9 = r13
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x026e:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x0290
            java.lang.Object r16 = r9.next()
            r17 = r16
            androidx.compose.ui.layout.Measurable r17 = (androidx.compose.ui.layout.Measurable) r17
            r18 = 0
            r42 = r1
            java.lang.Object r1 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r17)
            java.lang.String r2 = "Hint"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x028d
            goto L_0x0294
        L_0x028d:
            r1 = r42
            goto L_0x026e
        L_0x0290:
            r42 = r1
            r16 = 0
        L_0x0294:
            r1 = r16
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            if (r1 == 0) goto L_0x02a0
            androidx.compose.ui.layout.Placeable r1 = r1.m6399measureBRTryo0(r14)
            r9 = r1
            goto L_0x02a1
        L_0x02a0:
            r9 = 0
        L_0x02a1:
            int r1 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r7)
            int r2 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r1 = java.lang.Math.max(r1, r2)
            int r1 = r1 + r40
            int r1 = r1 + r12
            int r1 = java.lang.Math.max(r0, r1)
            r2 = r1
            int r0 = -r2
            r20 = 1
            r21 = 0
            r18 = 0
            r16 = r10
            r19 = r0
            long r23 = androidx.compose.ui.unit.ConstraintsKt.m7515offsetNN6EwU$default(r16, r18, r19, r20, r21)
            r29 = 11
            r30 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            long r0 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r23, r25, r26, r27, r28, r29, r30)
            r16 = r13
            java.lang.Iterable r16 = (java.lang.Iterable) r16
            java.util.Iterator r16 = r16.iterator()
        L_0x02e2:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x0308
            java.lang.Object r17 = r16.next()
            r18 = r17
            androidx.compose.ui.layout.Measurable r18 = (androidx.compose.ui.layout.Measurable) r18
            r19 = 0
            r20 = r2
            java.lang.Object r2 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r18)
            r23 = r10
            java.lang.String r10 = "Supporting"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r10)
            if (r2 == 0) goto L_0x0303
            goto L_0x030e
        L_0x0303:
            r2 = r20
            r10 = r23
            goto L_0x02e2
        L_0x0308:
            r20 = r2
            r23 = r10
            r17 = 0
        L_0x030e:
            r2 = r17
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
            if (r2 == 0) goto L_0x031a
            androidx.compose.ui.layout.Placeable r2 = r2.m6399measureBRTryo0(r0)
            r11 = r2
            goto L_0x031b
        L_0x031a:
            r11 = 0
        L_0x031b:
            r44 = r23
            int r22 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            int r23 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r3)
            int r24 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r4)
            int r25 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r5)
            int r26 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r6)
            int r27 = r7.getWidth()
            int r28 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r37)
            int r29 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            float r33 = r47.getDensity()
            r10 = r46
            androidx.compose.foundation.layout.PaddingValues r2 = r10.paddingValues
            r30 = r35
            r31 = r49
            r34 = r2
            int r2 = androidx.compose.material3.OutlinedTextFieldKt.m3613calculateWidthDHJA7U0(r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r34)
            int r23 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r3)
            int r24 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r4)
            int r25 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r5)
            int r26 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r27 = r7.getHeight()
            int r28 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r37)
            int r29 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r30 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            float r33 = r47.getDensity()
            r16 = r0
            androidx.compose.foundation.layout.PaddingValues r0 = r10.paddingValues
            r34 = r0
            int r0 = androidx.compose.material3.OutlinedTextFieldKt.m3612calculateHeightDHJA7U0(r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r34)
            r23 = r0
            int r1 = r23 - r22
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r18 = 0
            java.util.Iterator r19 = r0.iterator()
        L_0x038e:
            boolean r21 = r19.hasNext()
            if (r21 == 0) goto L_0x0421
            java.lang.Object r21 = r19.next()
            r24 = r21
            androidx.compose.ui.layout.Measurable r24 = (androidx.compose.ui.layout.Measurable) r24
            r25 = 0
            r26 = r0
            java.lang.Object r0 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r24)
            java.lang.String r10 = "Container"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)
            if (r0 == 0) goto L_0x0400
            r0 = r21
            androidx.compose.ui.layout.Measurable r0 = (androidx.compose.ui.layout.Measurable) r0
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r8) goto L_0x03b7
            r10 = r2
            goto L_0x03b8
        L_0x03b7:
            r10 = 0
        L_0x03b8:
            if (r1 == r8) goto L_0x03bd
            r8 = r1
            goto L_0x03be
        L_0x03bd:
            r8 = 0
        L_0x03be:
            r24 = r12
            long r12 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r10, r2, r8, r1)
            androidx.compose.ui.layout.Placeable r25 = r0.m6399measureBRTryo0(r12)
            androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2 r18 = new androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$2
            r27 = r16
            r0 = r18
            r34 = r1
            r29 = r36
            r30 = r38
            r32 = r42
            r1 = r23
            r38 = r2
            r36 = r20
            r39 = r41
            r8 = r37
            r10 = r25
            r12 = r46
            r13 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r19 = r18
            kotlin.jvm.functions.Function1 r19 = (kotlin.jvm.functions.Function1) r19
            r20 = 4
            r21 = 0
            r18 = 0
            r0 = r14
            r15 = r47
            r16 = r38
            r17 = r23
            androidx.compose.ui.layout.MeasureResult r2 = androidx.compose.ui.layout.MeasureScope.layout$default(r15, r16, r17, r18, r19, r20, r21)
            return r2
        L_0x0400:
            r34 = r1
            r24 = r12
            r0 = r14
            r27 = r16
            r29 = r36
            r30 = r38
            r39 = r41
            r32 = r42
            r38 = r2
            r36 = r20
            r10 = r46
            r13 = r48
            r0 = r26
            r1 = r34
            r36 = r29
            r38 = r30
            goto L_0x038e
        L_0x0421:
            r30 = r38
            r38 = r2
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            r2.<init>(r8)
            throw r2
        L_0x042b:
            r32 = r1
            r44 = r10
            r24 = r12
            r29 = r36
            r30 = r38
            r39 = r41
            r13 = r48
            r14 = r49
            r7 = r20
            r9 = r21
            r8 = r39
            r38 = r30
            goto L_0x0228
        L_0x0445:
            r32 = r1
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>(r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.m3615measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth($this$maxIntrinsicWidth, measurables, height, OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth($this$minIntrinsicWidth, measurables, height, OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope r17, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r18, int r19, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r20) {
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
            if (r5 == 0) goto L_0x01b9
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
            int r7 = r2.intValue()
            r2 = r18
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r3 = r2.hasNext()
            r9 = 0
            if (r3 == 0) goto L_0x005a
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r5 = 0
            java.lang.Object r6 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r8 = "Label"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r4 == 0) goto L_0x003e
            goto L_0x005b
        L_0x005a:
            r3 = r9
        L_0x005b:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            r2 = 0
            if (r3 == 0) goto L_0x0071
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)
            java.lang.Object r5 = r1.invoke(r3, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r3 = r5.intValue()
            r8 = r3
            goto L_0x0072
        L_0x0071:
            r8 = r2
        L_0x0072:
            r3 = r18
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x007b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0096
            java.lang.Object r4 = r3.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r11 = "Trailing"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r5 == 0) goto L_0x007b
            goto L_0x0097
        L_0x0096:
            r4 = r9
        L_0x0097:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x00ad
            r3 = r4
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)
            java.lang.Object r5 = r1.invoke(r3, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r3 = r5.intValue()
            r4 = r3
            goto L_0x00ae
        L_0x00ad:
            r4 = r2
        L_0x00ae:
            r3 = r18
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00b7:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00d2
            java.lang.Object r5 = r3.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r10 = 0
            java.lang.Object r11 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r12 = "Leading"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r6 == 0) goto L_0x00b7
            goto L_0x00d3
        L_0x00d2:
            r5 = r9
        L_0x00d3:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x00e8
            r3 = r5
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r19)
            java.lang.Object r6 = r1.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            goto L_0x00e9
        L_0x00e8:
            r3 = r2
        L_0x00e9:
            r5 = r18
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00f2:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x010d
            java.lang.Object r6 = r5.next()
            r10 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            r11 = 0
            java.lang.Object r12 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r13 = "Prefix"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r10 == 0) goto L_0x00f2
            goto L_0x010e
        L_0x010d:
            r6 = r9
        L_0x010e:
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            if (r6 == 0) goto L_0x0123
            r5 = r6
            r6 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r19)
            java.lang.Object r10 = r1.invoke(r5, r10)
            java.lang.Number r10 = (java.lang.Number) r10
            int r5 = r10.intValue()
            goto L_0x0124
        L_0x0123:
            r5 = r2
        L_0x0124:
            r6 = r18
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x012d:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0148
            java.lang.Object r10 = r6.next()
            r11 = r10
            androidx.compose.ui.layout.IntrinsicMeasurable r11 = (androidx.compose.ui.layout.IntrinsicMeasurable) r11
            r12 = 0
            java.lang.Object r13 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r11)
            java.lang.String r14 = "Suffix"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r11 == 0) goto L_0x012d
            goto L_0x0149
        L_0x0148:
            r10 = r9
        L_0x0149:
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            if (r10 == 0) goto L_0x015e
            r6 = r10
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r19)
            java.lang.Object r11 = r1.invoke(r6, r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r6 = r11.intValue()
            goto L_0x015f
        L_0x015e:
            r6 = r2
        L_0x015f:
            r10 = r18
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0168:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0183
            java.lang.Object r11 = r10.next()
            r12 = r11
            androidx.compose.ui.layout.IntrinsicMeasurable r12 = (androidx.compose.ui.layout.IntrinsicMeasurable) r12
            r13 = 0
            java.lang.Object r14 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r12)
            java.lang.String r15 = "Hint"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r12 == 0) goto L_0x0168
            r9 = r11
        L_0x0183:
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            if (r9 == 0) goto L_0x0197
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r19)
            java.lang.Object r11 = r1.invoke(r9, r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r9 = r11.intValue()
            goto L_0x0198
        L_0x0197:
            r9 = r2
        L_0x0198:
            float r10 = r0.animationProgress
            r11 = 1065353216(0x3f800000, float:1.0)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 >= 0) goto L_0x01a9
            r2 = 1
        L_0x01a9:
            r10 = r2
            long r11 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r13 = r17.getDensity()
            androidx.compose.foundation.layout.PaddingValues r14 = r0.paddingValues
            int r2 = androidx.compose.material3.OutlinedTextFieldKt.m3613calculateWidthDHJA7U0(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14)
            return r2
        L_0x01b9:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Collection contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.intrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r17, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r18, int r19, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r20) {
        /*
            r16 = this;
            r0 = r20
            r1 = r18
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x000b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01f1
            java.lang.Object r4 = r3.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r8 = "TextField"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x01ed
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            java.lang.Object r1 = r0.invoke(r4, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r6 = r1.intValue()
            r1 = r18
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x003c:
            boolean r2 = r1.hasNext()
            r9 = 0
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
            r2 = r9
        L_0x0059:
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            r1 = 0
            if (r2 == 0) goto L_0x006f
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            java.lang.Object r4 = r0.invoke(r2, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r2 = r4.intValue()
            r7 = r2
            goto L_0x0070
        L_0x006f:
            r7 = r1
        L_0x0070:
            r2 = r18
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0079:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0094
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r5 = 0
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r10 = "Trailing"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r10)
            if (r4 == 0) goto L_0x0079
            goto L_0x0095
        L_0x0094:
            r3 = r9
        L_0x0095:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            if (r3 == 0) goto L_0x00ab
            r2 = r3
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            java.lang.Object r4 = r0.invoke(r2, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r2 = r4.intValue()
            r3 = r2
            goto L_0x00ac
        L_0x00ab:
            r3 = r1
        L_0x00ac:
            r2 = r18
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00b5:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00d0
            java.lang.Object r4 = r2.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r8 = 0
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r11 = "Leading"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r5 == 0) goto L_0x00b5
            goto L_0x00d1
        L_0x00d0:
            r4 = r9
        L_0x00d1:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x00e6
            r2 = r4
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)
            java.lang.Object r5 = r0.invoke(r2, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r2 = r5.intValue()
            goto L_0x00e7
        L_0x00e6:
            r2 = r1
        L_0x00e7:
            r4 = r18
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00f0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x010b
            java.lang.Object r5 = r4.next()
            r8 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r10 = 0
            java.lang.Object r11 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r12 = "Prefix"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r8 == 0) goto L_0x00f0
            goto L_0x010c
        L_0x010b:
            r5 = r9
        L_0x010c:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x0121
            r4 = r5
            r5 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            java.lang.Object r8 = r0.invoke(r4, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r4 = r8.intValue()
            goto L_0x0122
        L_0x0121:
            r4 = r1
        L_0x0122:
            r5 = r18
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x012b:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0146
            java.lang.Object r8 = r5.next()
            r10 = r8
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            r11 = 0
            java.lang.Object r12 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r13 = "Suffix"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r10 == 0) goto L_0x012b
            goto L_0x0147
        L_0x0146:
            r8 = r9
        L_0x0147:
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            if (r8 == 0) goto L_0x015c
            r5 = r8
            r8 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r19)
            java.lang.Object r10 = r0.invoke(r5, r10)
            java.lang.Number r10 = (java.lang.Number) r10
            int r5 = r10.intValue()
            goto L_0x015d
        L_0x015c:
            r5 = r1
        L_0x015d:
            r8 = r18
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0166:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x0181
            java.lang.Object r10 = r8.next()
            r11 = r10
            androidx.compose.ui.layout.IntrinsicMeasurable r11 = (androidx.compose.ui.layout.IntrinsicMeasurable) r11
            r12 = 0
            java.lang.Object r13 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r11)
            java.lang.String r14 = "Hint"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r11 == 0) goto L_0x0166
            goto L_0x0182
        L_0x0181:
            r10 = r9
        L_0x0182:
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            if (r10 == 0) goto L_0x0197
            r8 = r10
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r19)
            java.lang.Object r11 = r0.invoke(r8, r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r8 = r11.intValue()
            goto L_0x0198
        L_0x0197:
            r8 = r1
        L_0x0198:
            r10 = r18
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x01a1:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x01bc
            java.lang.Object r11 = r10.next()
            r12 = r11
            androidx.compose.ui.layout.IntrinsicMeasurable r12 = (androidx.compose.ui.layout.IntrinsicMeasurable) r12
            r13 = 0
            java.lang.Object r14 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r12)
            java.lang.String r15 = "Supporting"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r12 == 0) goto L_0x01a1
            r9 = r11
        L_0x01bc:
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            if (r9 == 0) goto L_0x01d2
            r1 = r9
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r19)
            java.lang.Object r10 = r0.invoke(r1, r10)
            java.lang.Number r10 = (java.lang.Number) r10
            int r1 = r10.intValue()
            r9 = r1
            goto L_0x01d3
        L_0x01d2:
            r9 = r1
        L_0x01d3:
            long r10 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r12 = r17.getDensity()
            r14 = r16
            androidx.compose.foundation.layout.PaddingValues r13 = r14.paddingValues
            int r1 = androidx.compose.material3.OutlinedTextFieldKt.m3612calculateHeightDHJA7U0(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            return r1
        L_0x01ed:
            r14 = r16
            goto L_0x000b
        L_0x01f1:
            r14 = r16
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            java.lang.String r4 = "Collection contains no element matching the predicate."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }
}
