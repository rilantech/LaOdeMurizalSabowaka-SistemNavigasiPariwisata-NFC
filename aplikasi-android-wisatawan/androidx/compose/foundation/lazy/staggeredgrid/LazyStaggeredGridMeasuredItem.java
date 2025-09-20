package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0010\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u001e\u0010>\u001a\u0002092\u0006\u00103\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\b\u0010@\u001a\u00020AH\u0016J.\u0010B\u001a\u00020&*\u00020&2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030DH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001a\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0014\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u000e\u0010 \u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R)\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@RX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u001f\u0010-\u001a\u00020.X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b/\u0010)R\u0011\u00100\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R\u001b\u00103\u001a\u00020\u0003*\u00020&8BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b4\u00105R\u0019\u0010!\u001a\u00020\u0003*\u00020\b8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\"\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisOffset", "getCrossAxisOffset", "()I", "crossAxisSize", "getCrossAxisSize", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "maxMainAxisOffset", "minMainAxisOffset", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "sizeWithSpacings", "getSizeWithSpacings", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "getParentData", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "toString", "", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible = true;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int sizeWithSpacings;
    private final int span;

    public LazyStaggeredGridMeasuredItem(int index2, Object key2, List<? extends Placeable> placeables2, boolean isVertical2, int spacing, int lane2, int span2, int beforeContentPadding2, int afterContentPadding2, Object contentType2) {
        Comparable maxValue$iv;
        int i;
        Comparable maxValue$iv2;
        int i2;
        long j;
        Object obj = key2;
        List<? extends Placeable> list = placeables2;
        boolean z = isVertical2;
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(list, "placeables");
        this.index = index2;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = lane2;
        this.span = span2;
        this.beforeContentPadding = beforeContentPadding2;
        this.afterContentPadding = afterContentPadding2;
        this.contentType = contentType2;
        List $this$fastMaxOfOrNull$iv = this.placeables;
        if ($this$fastMaxOfOrNull$iv.isEmpty()) {
            maxValue$iv = null;
        } else {
            Placeable placeable = $this$fastMaxOfOrNull$iv.get(0);
            maxValue$iv = Integer.valueOf(z ? placeable.getHeight() : placeable.getWidth());
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Placeable placeable2 = $this$fastMaxOfOrNull$iv.get(i$iv);
                    Comparable v$iv = Integer.valueOf(this.isVertical ? placeable2.getHeight() : placeable2.getWidth());
                    maxValue$iv = v$iv.compareTo(maxValue$iv) > 0 ? v$iv : maxValue$iv;
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        Integer num = (Integer) maxValue$iv;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        this.mainAxisSize = i;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(i + spacing, 0);
        List $this$fastMaxOfOrNull$iv2 = this.placeables;
        if ($this$fastMaxOfOrNull$iv2.isEmpty()) {
            maxValue$iv2 = null;
        } else {
            Placeable it = $this$fastMaxOfOrNull$iv2.get(0);
            maxValue$iv2 = Integer.valueOf(this.isVertical ? it.getWidth() : it.getHeight());
            int i$iv2 = 1;
            int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable it2 = $this$fastMaxOfOrNull$iv2.get(i$iv2);
                    Comparable v$iv2 = Integer.valueOf(this.isVertical ? it2.getWidth() : it2.getHeight());
                    maxValue$iv2 = v$iv2.compareTo(maxValue$iv2) > 0 ? v$iv2 : maxValue$iv2;
                    if (i$iv2 == lastIndex2) {
                        break;
                    }
                    i$iv2++;
                }
            }
        }
        Integer num2 = (Integer) maxValue$iv2;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = 0;
        }
        this.crossAxisSize = i2;
        this.mainAxisLayoutSize = -1;
        if (this.isVertical) {
            j = IntSizeKt.IntSize(i2, this.mainAxisSize);
        } else {
            j = IntSizeKt.IntSize(this.mainAxisSize, i2);
        }
        this.size = j;
        this.offset = IntOffset.Companion.m5972getZeronOccac();
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

    public int getLane() {
        return this.lane;
    }

    public final int getSpan() {
        return this.span;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index2) {
        return this.placeables.get(index2).getParentData();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m795getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m794getOffsetnOccac() {
        return this.offset;
    }

    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize2) {
        long j;
        this.mainAxisLayoutSize = mainAxisLayoutSize2;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.afterContentPadding + mainAxisLayoutSize2;
        if (this.isVertical) {
            j = IntOffsetKt.IntOffset(crossAxis, mainAxis);
        } else {
            j = IntOffsetKt.IntOffset(mainAxis, crossAxis);
        }
        this.offset = j;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5962getXimpl(m794getOffsetnOccac()) : IntOffset.m5963getYimpl(m794getOffsetnOccac());
    }

    public final void place(Placeable.PlacementScope scope, LazyStaggeredGridMeasureContext context) {
        int i;
        int minOffset;
        int maxOffset;
        int i2;
        int i3;
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = this;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        LazyStaggeredGridMeasureContext $this$place_u24lambda_u246 = context;
        if (lazyStaggeredGridMeasuredItem.mainAxisLayoutSize != -1) {
            Placeable.PlacementScope $this$place_u24lambda_u246_u24lambda_u245 = scope;
            List $this$fastForEachIndexed$iv = lazyStaggeredGridMeasuredItem.placeables;
            int index$iv = 0;
            for (int size2 = $this$fastForEachIndexed$iv.size(); index$iv < size2; size2 = i) {
                Placeable placeable = $this$fastForEachIndexed$iv.get(index$iv);
                int index2 = index$iv;
                Placeable $this$mainAxisSize$iv = placeable;
                int minOffset2 = lazyStaggeredGridMeasuredItem.minMainAxisOffset - (this.isVertical != 0 ? $this$mainAxisSize$iv.getHeight() : $this$mainAxisSize$iv.getWidth());
                int maxOffset2 = lazyStaggeredGridMeasuredItem.maxMainAxisOffset;
                long offset2 = m794getOffsetnOccac();
                int index$iv2 = index$iv;
                Object parentData = lazyStaggeredGridMeasuredItem.getParentData(index2);
                int i4 = index2;
                LazyLayoutAnimateItemModifierNode animateNode = (parentData instanceof LazyLayoutAnimateItemModifierNode) != 0 ? (LazyLayoutAnimateItemModifierNode) parentData : null;
                if (animateNode != null) {
                    long other$iv = animateNode.m724getPlacementDeltanOccac();
                    i = size2;
                    long j = other$iv;
                    long animatedOffset = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(offset2) + IntOffset.m5962getXimpl(other$iv), IntOffset.m5963getYimpl(offset2) + IntOffset.m5963getYimpl(other$iv));
                    if ((lazyStaggeredGridMeasuredItem.m793getMainAxisgyyYBs(offset2) <= minOffset2 && lazyStaggeredGridMeasuredItem.m793getMainAxisgyyYBs(animatedOffset) <= minOffset2) || (lazyStaggeredGridMeasuredItem.m793getMainAxisgyyYBs(offset2) >= maxOffset2 && lazyStaggeredGridMeasuredItem.m793getMainAxisgyyYBs(animatedOffset) >= maxOffset2)) {
                        animateNode.cancelAnimation();
                    }
                    offset2 = animatedOffset;
                } else {
                    i = size2;
                }
                if ($this$place_u24lambda_u246.getReverseLayout()) {
                    long $this$copy_u2d4Tuh3kE$iv = offset2;
                    maxOffset = maxOffset2;
                    if (this.isVertical != 0) {
                        i2 = IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE$iv);
                        long j2 = offset2;
                        minOffset = minOffset2;
                    } else {
                        int mainAxisOffset = IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE$iv);
                        long j3 = offset2;
                        int i5 = lazyStaggeredGridMeasuredItem.mainAxisLayoutSize - mainAxisOffset;
                        Placeable $this$mainAxisSize$iv2 = placeable;
                        int i6 = mainAxisOffset;
                        minOffset = minOffset2;
                        i2 = i5 - (this.isVertical != 0 ? $this$mainAxisSize$iv2.getHeight() : $this$mainAxisSize$iv2.getWidth());
                    }
                    if (this.isVertical) {
                        int mainAxisOffset2 = IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE$iv);
                        int i7 = lazyStaggeredGridMeasuredItem.mainAxisLayoutSize - mainAxisOffset2;
                        Placeable $this$mainAxisSize$iv3 = placeable;
                        int i8 = mainAxisOffset2;
                        i3 = i7 - (this.isVertical != 0 ? $this$mainAxisSize$iv3.getHeight() : $this$mainAxisSize$iv3.getWidth());
                    } else {
                        i3 = IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE$iv);
                    }
                    offset2 = IntOffsetKt.IntOffset(i2, i3);
                } else {
                    maxOffset = maxOffset2;
                    long j4 = offset2;
                    minOffset = minOffset2;
                }
                long other$iv2 = $this$place_u24lambda_u246.m780getContentOffsetnOccac();
                int i9 = maxOffset;
                int i10 = minOffset;
                Placeable.PlacementScope.m4731placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u246_u24lambda_u245, placeable, IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(offset2) + IntOffset.m5962getXimpl(other$iv2), IntOffset.m5963getYimpl(offset2) + IntOffset.m5963getYimpl(other$iv2)), 0.0f, (Function1) null, 6, (Object) null);
                index$iv = index$iv2 + 1;
                lazyStaggeredGridMeasuredItem = this;
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m793getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m5963getYimpl($this$mainAxis) : IntOffset.m5962getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m792copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE));
    }

    public String toString() {
        return super.toString();
    }
}
