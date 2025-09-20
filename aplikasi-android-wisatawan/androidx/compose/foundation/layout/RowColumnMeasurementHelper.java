package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Br\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0017J2\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0006H\u0002J(\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0002J3\u00106\u001a\u0002072\u0006\u00104\u001a\u0002052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J&\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\bJ\n\u0010\r\u001a\u00020\u0006*\u00020\u0016J\n\u0010C\u001a\u00020\u0006*\u00020\u0016R5\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0015X\u0004¢\u0006\u0004\n\u0002\u0010*\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "arrangement", "Lkotlin/Function5;", "", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangement", "()Lkotlin/jvm/functions/Function5;", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisPosition", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnMeasurementHelper.kt */
public final class RowColumnMeasurementHelper {
    private final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> arrangement;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5 function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, function5, f, sizeMode, crossAxisAlignment2, list, placeableArr);
    }

    private RowColumnMeasurementHelper(LayoutOrientation orientation2, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement2, float arrangementSpacing2, SizeMode crossAxisSize2, CrossAxisAlignment crossAxisAlignment2, List<? extends Measurable> measurables2, Placeable[] placeables2) {
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(arrangement2, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize2, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment2, "crossAxisAlignment");
        Intrinsics.checkNotNullParameter(measurables2, "measurables");
        Intrinsics.checkNotNullParameter(placeables2, "placeables");
        this.orientation = orientation2;
        this.arrangement = arrangement2;
        this.arrangementSpacing = arrangementSpacing2;
        this.crossAxisSize = crossAxisSize2;
        this.crossAxisAlignment = crossAxisAlignment2;
        this.measurables = measurables2;
        this.placeables = placeables2;
        int size = measurables2.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getArrangement() {
        return this.arrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM  reason: not valid java name */
    public final float m583getArrangementSpacingD9Ej5fM() {
        return this.arrangementSpacing;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable $this$mainAxisSize) {
        Intrinsics.checkNotNullParameter($this$mainAxisSize, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public final int crossAxisSize(Placeable $this$crossAxisSize) {
        Intrinsics.checkNotNullParameter($this$crossAxisSize, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y  reason: not valid java name */
    public final RowColumnMeasureHelperResult m584measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long constraints, int startIndex, int endIndex) {
        long fixedSpace;
        long arrangementSpacingPx;
        int spaceAfterLastNoWeight;
        int crossAxisSpace;
        int i;
        int afterCrossAxisAlignmentLine;
        int beforeCrossAxisAlignmentLine;
        int crossAxisLayoutSize;
        int i2;
        int targetSpace;
        long fixedSpace2;
        long remainingToTarget;
        long arrangementSpacingPx2;
        int i3;
        int subSize;
        int i4;
        int mainAxisMax;
        int mainAxisMax2;
        int mainAxisMax3;
        Measurable child;
        long j;
        int subSize2;
        int i5 = endIndex;
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        long constraints2 = OrientationIndependentConstraints.m507constructorimpl(constraints, this.orientation);
        long arrangementSpacingPx3 = (long) measureScope.m5819roundToPx0680j_4(this.arrangementSpacing);
        long fixedSpace3 = 0;
        int crossAxisSpace2 = 0;
        int subSize3 = i5 - startIndex;
        int i6 = startIndex;
        float totalWeight = 0.0f;
        int weightChildrenCount = 0;
        int crossAxisSpace3 = 0;
        int spaceAfterLastNoWeight2 = 0;
        while (true) {
            int anyAlignBy = 1;
            if (i6 >= i5) {
                break;
            }
            Measurable child2 = this.measurables.get(i6);
            RowColumnParentData parentData = this.rowColumnParentData[i6];
            float weight = RowColumnImplKt.getWeight(parentData);
            if (weight > 0.0f) {
                totalWeight += weight;
                weightChildrenCount++;
                i4 = i6;
                subSize = subSize3;
            } else {
                int mainAxisMax4 = Constraints.m5788getMaxWidthimpl(constraints2);
                Placeable placeable = this.placeables[i6];
                if (placeable == null) {
                    if (mainAxisMax4 == Integer.MAX_VALUE) {
                        child = child2;
                        mainAxisMax3 = mainAxisMax4;
                        subSize2 = Integer.MAX_VALUE;
                        j = 0;
                    } else {
                        child = child2;
                        mainAxisMax3 = mainAxisMax4;
                        j = 0;
                        subSize2 = (int) RangesKt.coerceAtLeast(((long) mainAxisMax4) - fixedSpace3, 0);
                    }
                    mainAxisMax = mainAxisMax3;
                    mainAxisMax2 = crossAxisSpace3;
                    long j2 = j;
                    i4 = i6;
                    subSize = subSize3;
                    placeable = child.m4689measureBRTryo0(OrientationIndependentConstraints.m520toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m509copyyUG9Ft0$default(constraints2, 0, subSize2, 0, 0, 8, (Object) null), this.orientation));
                } else {
                    mainAxisMax2 = crossAxisSpace3;
                    mainAxisMax = mainAxisMax4;
                    i4 = i6;
                    subSize = subSize3;
                }
                int spaceAfterLastNoWeight3 = Math.min((int) arrangementSpacingPx3, (int) RangesKt.coerceAtLeast((((long) mainAxisMax) - fixedSpace3) - ((long) mainAxisSize(placeable)), 0));
                fixedSpace3 += (long) (mainAxisSize(placeable) + spaceAfterLastNoWeight3);
                int crossAxisSpace4 = Math.max(crossAxisSpace2, crossAxisSize(placeable));
                if (mainAxisMax2 == 0 && !RowColumnImplKt.isRelative(parentData)) {
                    anyAlignBy = 0;
                }
                this.placeables[i4] = placeable;
                spaceAfterLastNoWeight2 = spaceAfterLastNoWeight3;
                crossAxisSpace2 = crossAxisSpace4;
                crossAxisSpace3 = anyAlignBy;
            }
            i6 = i4 + 1;
            MeasureScope measureScope2 = measureScope;
            long j3 = constraints;
            subSize3 = subSize;
        }
        int anyAlignBy2 = crossAxisSpace3;
        int i7 = i6;
        int subSize4 = subSize3;
        int weightedSpace = 0;
        if (weightChildrenCount == 0) {
            fixedSpace = fixedSpace3 - ((long) spaceAfterLastNoWeight2);
            crossAxisSpace = crossAxisSpace2;
            spaceAfterLastNoWeight = spaceAfterLastNoWeight2;
            arrangementSpacingPx = arrangementSpacingPx3;
            i = 0;
        } else {
            if (totalWeight <= 0.0f || Constraints.m5788getMaxWidthimpl(constraints2) == Integer.MAX_VALUE) {
                targetSpace = Constraints.m5790getMinWidthimpl(constraints2);
            } else {
                targetSpace = Constraints.m5788getMaxWidthimpl(constraints2);
            }
            long arrangementSpacingTotal = ((long) (weightChildrenCount - 1)) * arrangementSpacingPx3;
            long remainingToTarget2 = RangesKt.coerceAtLeast((((long) targetSpace) - fixedSpace3) - arrangementSpacingTotal, 0);
            float weightUnitSpace = totalWeight > 0.0f ? ((float) remainingToTarget2) / totalWeight : 0.0f;
            Iterator it = RangesKt.until(startIndex, endIndex).iterator();
            int weightedSpace2 = 0;
            while (it.hasNext()) {
                weightedSpace2 += MathKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[((IntIterator) it).nextInt()]) * weightUnitSpace);
                targetSpace = targetSpace;
            }
            int i8 = startIndex;
            long remainder = remainingToTarget2 - ((long) weightedSpace2);
            int weightedSpace3 = 0;
            int anyAlignBy3 = anyAlignBy2;
            while (i8 < i5) {
                int spaceAfterLastNoWeight4 = spaceAfterLastNoWeight2;
                if (this.placeables[i8] == null) {
                    Measurable child3 = this.measurables.get(i8);
                    arrangementSpacingPx2 = arrangementSpacingPx3;
                    RowColumnParentData parentData2 = this.rowColumnParentData[i8];
                    float weight2 = RowColumnImplKt.getWeight(parentData2);
                    if (weight2 > 0.0f) {
                        remainingToTarget = remainingToTarget2;
                        int remainderUnit = MathKt.getSign(remainder);
                        fixedSpace2 = fixedSpace3;
                        remainder -= (long) remainderUnit;
                        int childMainAxisSize = Math.max(0, MathKt.roundToInt(weightUnitSpace * weight2) + remainderUnit);
                        if (!RowColumnImplKt.getFill(parentData2) || childMainAxisSize == Integer.MAX_VALUE) {
                            i3 = 0;
                        } else {
                            i3 = childMainAxisSize;
                        }
                        float f = weight2;
                        int i9 = remainderUnit;
                        Placeable placeable2 = child3.m4689measureBRTryo0(OrientationIndependentConstraints.m520toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m505constructorimpl(i3, childMainAxisSize, 0, Constraints.m5787getMaxHeightimpl(constraints2)), this.orientation));
                        weightedSpace3 += mainAxisSize(placeable2);
                        crossAxisSpace2 = Math.max(crossAxisSpace2, crossAxisSize(placeable2));
                        anyAlignBy3 = (anyAlignBy3 != 0 || RowColumnImplKt.isRelative(parentData2)) ? 1 : 0;
                        this.placeables[i8] = placeable2;
                    } else {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                } else {
                    fixedSpace2 = fixedSpace3;
                    arrangementSpacingPx2 = arrangementSpacingPx3;
                    remainingToTarget = remainingToTarget2;
                }
                i8++;
                spaceAfterLastNoWeight2 = spaceAfterLastNoWeight4;
                arrangementSpacingPx3 = arrangementSpacingPx2;
                remainingToTarget2 = remainingToTarget;
                fixedSpace3 = fixedSpace2;
            }
            fixedSpace = fixedSpace3;
            spaceAfterLastNoWeight = spaceAfterLastNoWeight2;
            arrangementSpacingPx = arrangementSpacingPx3;
            long j4 = remainingToTarget2;
            i = 0;
            weightedSpace = (int) RangesKt.coerceIn(((long) weightedSpace3) + arrangementSpacingTotal, 0, ((long) Constraints.m5788getMaxWidthimpl(constraints2)) - fixedSpace);
            anyAlignBy2 = anyAlignBy3;
            crossAxisSpace = crossAxisSpace2;
        }
        int beforeCrossAxisAlignmentLine2 = 0;
        int afterCrossAxisAlignmentLine2 = 0;
        if (anyAlignBy2 != 0) {
            for (int i10 = startIndex; i10 < i5; i10++) {
                Placeable placeable3 = this.placeables[i10];
                Intrinsics.checkNotNull(placeable3);
                CrossAxisAlignment crossAxisAlignment2 = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i10]);
                Integer alignmentLinePosition = crossAxisAlignment2 != null ? crossAxisAlignment2.calculateAlignmentLinePosition$foundation_layout_release(placeable3) : null;
                if (alignmentLinePosition != null) {
                    int it2 = alignmentLinePosition.intValue();
                    if (it2 == Integer.MIN_VALUE) {
                        it2 = i;
                    }
                    beforeCrossAxisAlignmentLine2 = Math.max(beforeCrossAxisAlignmentLine2, it2);
                    int crossAxisSize2 = crossAxisSize(placeable3);
                    int it3 = alignmentLinePosition.intValue();
                    if (it3 != Integer.MIN_VALUE) {
                        i2 = it3;
                    } else {
                        i2 = crossAxisSize(placeable3);
                    }
                    afterCrossAxisAlignmentLine2 = Math.max(afterCrossAxisAlignmentLine2, crossAxisSize2 - i2);
                }
            }
            beforeCrossAxisAlignmentLine = beforeCrossAxisAlignmentLine2;
            afterCrossAxisAlignmentLine = afterCrossAxisAlignmentLine2;
        } else {
            beforeCrossAxisAlignmentLine = 0;
            afterCrossAxisAlignmentLine = 0;
        }
        int mainAxisLayoutSize = Math.max((int) RangesKt.coerceAtLeast(fixedSpace + ((long) weightedSpace), 0), Constraints.m5790getMinWidthimpl(constraints2));
        if (Constraints.m5787getMaxHeightimpl(constraints2) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) {
            crossAxisLayoutSize = Math.max(crossAxisSpace, Math.max(Constraints.m5789getMinHeightimpl(constraints2), beforeCrossAxisAlignmentLine + afterCrossAxisAlignmentLine));
        } else {
            crossAxisLayoutSize = Constraints.m5787getMaxHeightimpl(constraints2);
        }
        int subSize5 = subSize4;
        int[] iArr = new int[subSize5];
        for (int i11 = i; i11 < subSize5; i11++) {
            iArr[i11] = i;
        }
        int[] mainAxisPositions = iArr;
        int[] iArr2 = new int[subSize5];
        while (i < subSize5) {
            Placeable placeable4 = this.placeables[i + startIndex];
            Intrinsics.checkNotNull(placeable4);
            iArr2[i] = mainAxisSize(placeable4);
            i++;
        }
        int[] childrenMainAxisSize = iArr2;
        int i12 = spaceAfterLastNoWeight;
        long j5 = arrangementSpacingPx;
        int[] iArr3 = childrenMainAxisSize;
        return new RowColumnMeasureHelperResult(crossAxisLayoutSize, mainAxisLayoutSize, startIndex, endIndex, beforeCrossAxisAlignmentLine, mainAxisPositions(mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions, measureScope));
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(mainAxisLayoutSize), childrenMainAxisSize, measureScope.getLayoutDirection(), measureScope, mainAxisPositions);
        return mainAxisPositions;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment childCrossAlignment;
        LayoutDirection layoutDirection2;
        if (parentData == null || (childCrossAlignment = parentData.getCrossAxisAlignment()) == null) {
            childCrossAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize2 = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection2 = LayoutDirection.Ltr;
        } else {
            layoutDirection2 = layoutDirection;
        }
        return childCrossAlignment.align$foundation_layout_release(crossAxisSize2, layoutDirection2, placeable, beforeCrossAxisAlignmentLine);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(placeableScope, "placeableScope");
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Placeable.PlacementScope $this$placeHelper_u24lambda_u245 = placeableScope;
        int i3 = measureResult.getStartIndex();
        int endIndex = measureResult.getEndIndex();
        int i4 = i3;
        while (i4 < endIndex) {
            Placeable placeable = this.placeables[i4];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(i4).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                i = i4;
                i2 = endIndex;
                Placeable.PlacementScope.place$default($this$placeHelper_u24lambda_u245, placeable, mainAxisPositions[i4 - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, (Object) null);
            } else {
                i = i4;
                i2 = endIndex;
                Placeable.PlacementScope.place$default($this$placeHelper_u24lambda_u245, placeable, crossAxisPosition, mainAxisPositions[i - measureResult.getStartIndex()], 0.0f, 4, (Object) null);
            }
            i4 = i + 1;
            LayoutDirection layoutDirection2 = layoutDirection;
            endIndex = i2;
        }
    }
}
