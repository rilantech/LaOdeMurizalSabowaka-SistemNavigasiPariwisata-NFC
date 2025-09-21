package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bp\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J:\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003J.\u0010A\u001a\u00020\u0013*\u00020\u00132\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030CH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010ER\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010 R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u000e\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R)\u0010)\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013@RX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0019R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0019R\u001f\u00101\u001a\u000202X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010,\u001a\u0004\b3\u0010+R\u0019\u0010\u0012\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010,R\u001b\u00104\u001a\u00020\u0003*\u00020\u00138BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b5\u00106R\u0018\u0010#\u001a\u00020\u0003*\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b$\u00107\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "column", "getColumn", "()I", "getContentType", "()Ljava/lang/Object;", "crossAxisOffset", "getCrossAxisOffset", "getCrossAxisSize", "getIndex", "()Z", "getKey", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "offset", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "row", "getRow", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "getParentData", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "mainAxisOffset", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredItem.kt */
public final class LazyGridMeasuredItem implements LazyGridItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private int column;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection2, int i4, int i5, List list, long j, Object obj2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection2, i4, i5, list, j, obj2);
    }

    private LazyGridMeasuredItem(int index2, Object key2, boolean isVertical2, int crossAxisSize2, int mainAxisSpacing, boolean reverseLayout2, LayoutDirection layoutDirection2, int beforeContentPadding2, int afterContentPadding2, List<? extends Placeable> placeables2, long visualOffset2, Object contentType2) {
        long j;
        Object obj = key2;
        LayoutDirection layoutDirection3 = layoutDirection2;
        List<? extends Placeable> list = placeables2;
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(layoutDirection3, "layoutDirection");
        Intrinsics.checkNotNullParameter(list, "placeables");
        this.index = index2;
        this.key = obj;
        this.isVertical = isVertical2;
        this.crossAxisSize = crossAxisSize2;
        this.reverseLayout = reverseLayout2;
        this.layoutDirection = layoutDirection3;
        this.beforeContentPadding = beforeContentPadding2;
        this.afterContentPadding = afterContentPadding2;
        this.placeables = list;
        this.visualOffset = visualOffset2;
        this.contentType = contentType2;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int maxMainAxis = 0;
        List $this$fastForEach$iv = this.placeables;
        int size2 = $this$fastForEach$iv.size();
        int index$iv = 0;
        while (index$iv < size2) {
            Placeable it = $this$fastForEach$iv.get(index$iv);
            int i = size2;
            maxMainAxis = Math.max(maxMainAxis, this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            size2 = i;
        }
        this.mainAxisSize = maxMainAxis;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(maxMainAxis + mainAxisSpacing, 0);
        if (this.isVertical) {
            j = IntSizeKt.IntSize(this.crossAxisSize, maxMainAxis);
        } else {
            j = IntSizeKt.IntSize(maxMainAxis, this.crossAxisSize);
        }
        this.size = j;
        this.offset = IntOffset.Companion.m5972getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index2) {
        return this.placeables.get(index2).getParentData();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m716getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m715getOffsetnOccac() {
        return this.offset;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5962getXimpl(m715getOffsetnOccac()) : IntOffset.m5963getYimpl(m715getOffsetnOccac());
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public static /* synthetic */ void position$default(LazyGridMeasuredItem lazyGridMeasuredItem, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        int i8;
        int i9;
        if ((i7 & 16) != 0) {
            i8 = -1;
        } else {
            i8 = i5;
        }
        if ((i7 & 32) != 0) {
            i9 = -1;
        } else {
            i9 = i6;
        }
        lazyGridMeasuredItem.position(i, i2, i3, i4, i8, i9);
    }

    public final void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight, int row2, int column2) {
        int crossAxisOffset2;
        long j;
        boolean z = this.isVertical;
        this.mainAxisLayoutSize = z ? layoutHeight : layoutWidth;
        int crossAxisLayoutSize = z ? layoutWidth : layoutHeight;
        if (!z || this.layoutDirection != LayoutDirection.Rtl) {
            crossAxisOffset2 = crossAxisOffset;
        } else {
            crossAxisOffset2 = (crossAxisLayoutSize - crossAxisOffset) - this.crossAxisSize;
        }
        if (this.isVertical) {
            j = IntOffsetKt.IntOffset(crossAxisOffset2, mainAxisOffset);
        } else {
            j = IntOffsetKt.IntOffset(mainAxisOffset, crossAxisOffset2);
        }
        this.offset = j;
        this.row = row2;
        this.column = column2;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void place(Placeable.PlacementScope scope) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Placeable.PlacementScope $this$place_u24lambda_u244 = scope;
        int i3 = 0;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int placeablesCount = getPlaceablesCount();
            int i4 = 0;
            while (i4 < placeablesCount) {
                int index2 = i4;
                Placeable placeable = this.placeables.get(index2);
                int minOffset = this.minMainAxisOffset - getMainAxisSize(placeable);
                int maxOffset = this.maxMainAxisOffset;
                long offset2 = m715getOffsetnOccac();
                Object parentData = getParentData(index2);
                LazyLayoutAnimateItemModifierNode animateNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
                if (animateNode != null) {
                    long other$iv = animateNode.m724getPlacementDeltanOccac();
                    i = i3;
                    long j = other$iv;
                    long animatedOffset = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(offset2) + IntOffset.m5962getXimpl(other$iv), IntOffset.m5963getYimpl(offset2) + IntOffset.m5963getYimpl(other$iv));
                    if ((m714getMainAxisgyyYBs(offset2) <= minOffset && m714getMainAxisgyyYBs(animatedOffset) <= minOffset) || (m714getMainAxisgyyYBs(offset2) >= maxOffset && m714getMainAxisgyyYBs(animatedOffset) >= maxOffset)) {
                        animateNode.cancelAnimation();
                    }
                    offset2 = animatedOffset;
                } else {
                    i = i3;
                }
                if (this.reverseLayout != 0) {
                    long $this$copy_u2d4Tuh3kE$iv = offset2;
                    long j2 = offset2;
                    int mainAxisOffset = this.isVertical ? IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE$iv) : (this.mainAxisLayoutSize - IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE$iv)) - getMainAxisSize(placeable);
                    if (this.isVertical) {
                        i2 = (this.mainAxisLayoutSize - IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE$iv)) - getMainAxisSize(placeable);
                    } else {
                        i2 = IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE$iv);
                    }
                    offset2 = IntOffsetKt.IntOffset(mainAxisOffset, i2);
                } else {
                    long j3 = offset2;
                }
                long other$iv2 = this.visualOffset;
                long offset3 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(offset2) + IntOffset.m5962getXimpl(other$iv2), IntOffset.m5963getYimpl(offset2) + IntOffset.m5963getYimpl(other$iv2));
                if (this.isVertical) {
                    int i5 = maxOffset;
                    int i6 = minOffset;
                    Placeable.PlacementScope.m4732placeWithLayeraW9wM$default($this$place_u24lambda_u244, placeable, offset3, 0.0f, (Function1) null, 6, (Object) null);
                } else {
                    int i7 = minOffset;
                    Placeable.PlacementScope.m4731placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u244, placeable, offset3, 0.0f, (Function1) null, 6, (Object) null);
                }
                i4++;
                i3 = i;
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m714getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m5963getYimpl($this$mainAxis) : IntOffset.m5962getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m713copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE));
    }
}
