package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B4\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J/\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3077measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        Object obj;
        Object obj2;
        Object obj3;
        long textConstraints;
        Object obj4;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        int bottomPadding = measureScope.m7529roundToPx0680j_4(this.paddingValues.m2262calculateBottomPaddingD9Ej5fM());
        long relaxedConstraints = Constraints.m7489copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        Placeable leadingPlaceable = measurable != null ? measurable.m6399measureBRTryo0(relaxedConstraints) : null;
        int occupiedSpaceHorizontally = 0 + TextFieldImplKt.widthOrZero(leadingPlaceable);
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable trailingPlaceable = measurable2 != null ? measurable2.m6399measureBRTryo0(ConstraintsKt.m7515offsetNN6EwU$default(relaxedConstraints, -occupiedSpaceHorizontally, 0, 2, (Object) null)) : null;
        int occupiedSpaceHorizontally2 = occupiedSpaceHorizontally + TextFieldImplKt.widthOrZero(trailingPlaceable);
        int labelHorizontalPaddingOffset = measureScope.m7529roundToPx0680j_4(this.paddingValues.m2263calculateLeftPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection())) + measureScope.m7529roundToPx0680j_4(this.paddingValues.m2264calculateRightPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()));
        long labelConstraints = ConstraintsKt.m7514offsetNN6EwU(relaxedConstraints, MathHelpersKt.lerp((-occupiedSpaceHorizontally2) - labelHorizontalPaddingOffset, -labelHorizontalPaddingOffset, this.animationProgress), -bottomPadding);
        Iterator it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            Iterator it4 = it3;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), (Object) "Label")) {
                break;
            }
            it3 = it4;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable labelPlaceable = measurable3 != null ? measurable3.m6399measureBRTryo0(labelConstraints) : null;
        if (labelPlaceable != null) {
            Placeable it5 = labelPlaceable;
            long j = labelConstraints;
            this.onLabelMeasured.invoke(Size.m4770boximpl(SizeKt.Size((float) it5.getWidth(), (float) it5.getHeight())));
        }
        long textConstraints2 = Constraints.m7489copyZbe2FdA$default(ConstraintsKt.m7514offsetNN6EwU(constraints, -occupiedSpaceHorizontally2, (-bottomPadding) - Math.max(TextFieldImplKt.heightOrZero(labelPlaceable) / 2, measureScope.m7529roundToPx0680j_4(this.paddingValues.m2265calculateTopPaddingD9Ej5fM()))), 0, 0, 0, 0, 11, (Object) null);
        Iterable $this$first$iv = list;
        int $i$f$first = 0;
        Iterator it6 = $this$first$iv.iterator();
        while (true) {
            Iterable $this$first$iv2 = $this$first$iv;
            if (it6.hasNext()) {
                Object element$iv = it6.next();
                int $i$f$first2 = $i$f$first;
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "TextField")) {
                    Placeable textFieldPlaceable = ((Measurable) element$iv).m6399measureBRTryo0(textConstraints2);
                    long placeholderConstraints = Constraints.m7489copyZbe2FdA$default(textConstraints2, 0, 0, 0, 0, 14, (Object) null);
                    Iterator it7 = list.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            textConstraints = textConstraints2;
                            obj4 = null;
                            break;
                        }
                        obj4 = it7.next();
                        textConstraints = textConstraints2;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) "Hint")) {
                            break;
                        }
                        textConstraints2 = textConstraints;
                    }
                    Measurable measurable4 = (Measurable) obj4;
                    long j2 = placeholderConstraints;
                    Placeable placeholderPlaceable = measurable4 != null ? measurable4.m6399measureBRTryo0(placeholderConstraints) : null;
                    long j3 = constraints;
                    int width = OutlinedTextFieldKt.m3075calculateWidthO3s9Psw(TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldImplKt.widthOrZero(trailingPlaceable), textFieldPlaceable.getWidth(), TextFieldImplKt.widthOrZero(labelPlaceable), TextFieldImplKt.widthOrZero(placeholderPlaceable), this.animationProgress, j3, $this$measure_u2d3p2s80s.getDensity(), this.paddingValues);
                    int bottomPadding2 = OutlinedTextFieldKt.m3074calculateHeightO3s9Psw(TextFieldImplKt.heightOrZero(leadingPlaceable), TextFieldImplKt.heightOrZero(trailingPlaceable), textFieldPlaceable.getHeight(), TextFieldImplKt.heightOrZero(labelPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable), this.animationProgress, j3, $this$measure_u2d3p2s80s.getDensity(), this.paddingValues);
                    Iterable $this$first$iv3 = list;
                    for (Object element$iv2 : $this$first$iv3) {
                        Iterable $this$first$iv4 = $this$first$iv3;
                        int labelHorizontalPaddingOffset2 = labelHorizontalPaddingOffset;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) OutlinedTextFieldKt.BorderId)) {
                            Measurable measurable5 = (Measurable) element$iv2;
                            int i = width != Integer.MAX_VALUE ? width : 0;
                            int i2 = bottomPadding2 != Integer.MAX_VALUE ? bottomPadding2 : 0;
                            long j4 = relaxedConstraints;
                            long j5 = textConstraints;
                            int height = bottomPadding2;
                            int i3 = occupiedSpaceHorizontally2;
                            int i4 = bottomPadding;
                            return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, height, (Map) null, new OutlinedTextFieldMeasurePolicy$measure$2(bottomPadding2, width, leadingPlaceable, trailingPlaceable, textFieldPlaceable, labelPlaceable, placeholderPlaceable, measurable5.m6399measureBRTryo0(ConstraintsKt.Constraints(i, width, i2, bottomPadding2)), this, $this$measure_u2d3p2s80s), 4, (Object) null);
                        }
                        int height2 = bottomPadding2;
                        int i5 = width;
                        long j6 = relaxedConstraints;
                        int i6 = occupiedSpaceHorizontally2;
                        int height3 = bottomPadding;
                        long j7 = textConstraints;
                        MeasureScope measureScope2 = $this$measure_u2d3p2s80s;
                        List<? extends Measurable> list2 = measurables;
                        bottomPadding2 = height2;
                        $this$first$iv3 = $this$first$iv4;
                        labelHorizontalPaddingOffset = labelHorizontalPaddingOffset2;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                long textConstraints3 = textConstraints2;
                int i7 = labelHorizontalPaddingOffset;
                long j8 = relaxedConstraints;
                int i8 = occupiedSpaceHorizontally2;
                int i9 = bottomPadding;
                MeasureScope measureScope3 = $this$measure_u2d3p2s80s;
                list = measurables;
                long j9 = constraints;
                $this$first$iv = $this$first$iv2;
                $i$f$first = $i$f$first2;
                textConstraints2 = textConstraints3;
            } else {
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope r15, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r16, int r17, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r18
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r4 = r2.iterator()
        L_0x000c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013a
            java.lang.Object r5 = r4.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.material.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r9 = "TextField"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x000c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            java.lang.Object r2 = r1.invoke(r5, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r5 = r2.intValue()
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x003d:
            boolean r3 = r2.hasNext()
            r7 = 0
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r6 = 0
            java.lang.Object r8 = androidx.compose.material.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r9 = "Label"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r4 == 0) goto L_0x003d
            goto L_0x005a
        L_0x0059:
            r3 = r7
        L_0x005a:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            r2 = 0
            if (r3 == 0) goto L_0x0070
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            java.lang.Object r6 = r1.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            r6 = r3
            goto L_0x0071
        L_0x0070:
            r6 = r2
        L_0x0071:
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x007a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0095
            java.lang.Object r4 = r3.next()
            r8 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r9 = 0
            java.lang.Object r10 = androidx.compose.material.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r11 = "Trailing"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r8 == 0) goto L_0x007a
            goto L_0x0096
        L_0x0095:
            r4 = r7
        L_0x0096:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x00ac
            r3 = r4
            r4 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            java.lang.Object r8 = r1.invoke(r3, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r3 = r8.intValue()
            r4 = r3
            goto L_0x00ad
        L_0x00ac:
            r4 = r2
        L_0x00ad:
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00b6:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x00d1
            java.lang.Object r8 = r3.next()
            r9 = r8
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            r10 = 0
            java.lang.Object r11 = androidx.compose.material.TextFieldImplKt.getLayoutId(r9)
            java.lang.String r12 = "Leading"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x00b6
            goto L_0x00d2
        L_0x00d1:
            r8 = r7
        L_0x00d2:
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            if (r8 == 0) goto L_0x00e7
            r3 = r8
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            java.lang.Object r9 = r1.invoke(r3, r9)
            java.lang.Number r9 = (java.lang.Number) r9
            int r3 = r9.intValue()
            goto L_0x00e8
        L_0x00e7:
            r3 = r2
        L_0x00e8:
            r8 = r16
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x00f1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x010c
            java.lang.Object r9 = r8.next()
            r10 = r9
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            r11 = 0
            java.lang.Object r12 = androidx.compose.material.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r13 = "Hint"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r10 == 0) goto L_0x00f1
            r7 = r9
        L_0x010c:
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            if (r7 == 0) goto L_0x0122
            r2 = r7
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            java.lang.Object r8 = r1.invoke(r2, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r2 = r8.intValue()
            r7 = r2
            goto L_0x0123
        L_0x0122:
            r7 = r2
        L_0x0123:
            float r8 = r0.animationProgress
            long r9 = androidx.compose.material.TextFieldImplKt.getZeroConstraints()
            float r11 = r15.getDensity()
            androidx.compose.foundation.layout.PaddingValues r12 = r0.paddingValues
            int r2 = androidx.compose.material.OutlinedTextFieldKt.m3075calculateWidthO3s9Psw(r3, r4, r5, r6, r7, r8, r9, r11, r12)
            return r2
        L_0x013a:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Collection contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldMeasurePolicy.intrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r15, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r16, int r17, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r18
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r4 = r2.iterator()
        L_0x000c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013a
            java.lang.Object r5 = r4.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.material.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r9 = "TextField"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x000c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            java.lang.Object r2 = r1.invoke(r5, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r5 = r2.intValue()
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x003d:
            boolean r3 = r2.hasNext()
            r7 = 0
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r6 = 0
            java.lang.Object r8 = androidx.compose.material.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r9 = "Label"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r4 == 0) goto L_0x003d
            goto L_0x005a
        L_0x0059:
            r3 = r7
        L_0x005a:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            r2 = 0
            if (r3 == 0) goto L_0x0070
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            java.lang.Object r6 = r1.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            r6 = r3
            goto L_0x0071
        L_0x0070:
            r6 = r2
        L_0x0071:
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x007a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0095
            java.lang.Object r4 = r3.next()
            r8 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r9 = 0
            java.lang.Object r10 = androidx.compose.material.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r11 = "Trailing"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r8 == 0) goto L_0x007a
            goto L_0x0096
        L_0x0095:
            r4 = r7
        L_0x0096:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x00ac
            r3 = r4
            r4 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            java.lang.Object r8 = r1.invoke(r3, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r3 = r8.intValue()
            r4 = r3
            goto L_0x00ad
        L_0x00ac:
            r4 = r2
        L_0x00ad:
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00b6:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x00d1
            java.lang.Object r8 = r3.next()
            r9 = r8
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            r10 = 0
            java.lang.Object r11 = androidx.compose.material.TextFieldImplKt.getLayoutId(r9)
            java.lang.String r12 = "Leading"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x00b6
            goto L_0x00d2
        L_0x00d1:
            r8 = r7
        L_0x00d2:
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            if (r8 == 0) goto L_0x00e7
            r3 = r8
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            java.lang.Object r9 = r1.invoke(r3, r9)
            java.lang.Number r9 = (java.lang.Number) r9
            int r3 = r9.intValue()
            goto L_0x00e8
        L_0x00e7:
            r3 = r2
        L_0x00e8:
            r8 = r16
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x00f1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x010c
            java.lang.Object r9 = r8.next()
            r10 = r9
            androidx.compose.ui.layout.IntrinsicMeasurable r10 = (androidx.compose.ui.layout.IntrinsicMeasurable) r10
            r11 = 0
            java.lang.Object r12 = androidx.compose.material.TextFieldImplKt.getLayoutId(r10)
            java.lang.String r13 = "Hint"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r10 == 0) goto L_0x00f1
            r7 = r9
        L_0x010c:
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            if (r7 == 0) goto L_0x0122
            r2 = r7
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            java.lang.Object r8 = r1.invoke(r2, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r2 = r8.intValue()
            r7 = r2
            goto L_0x0123
        L_0x0122:
            r7 = r2
        L_0x0123:
            float r8 = r0.animationProgress
            long r9 = androidx.compose.material.TextFieldImplKt.getZeroConstraints()
            float r11 = r15.getDensity()
            androidx.compose.foundation.layout.PaddingValues r12 = r0.paddingValues
            int r2 = androidx.compose.material.OutlinedTextFieldKt.m3074calculateHeightO3s9Psw(r3, r4, r5, r6, r7, r8, r9, r11, r12)
            return r2
        L_0x013a:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Collection contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }
}
