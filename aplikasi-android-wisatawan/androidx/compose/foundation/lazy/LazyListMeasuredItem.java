package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B~\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010&\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u001e\u0010=\u001a\u00020:2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003J.\u0010@\u001a\u00020\u0014*\u00020\u00142\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030BH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001fR\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\u00020\u0014X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010/R\u001b\u00100\u001a\u00020\u0003*\u00020\u00148BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b1\u00102R\u0018\u00103\u001a\u00020\u0003*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "mainAxisLayoutSize", "maxMainAxisOffset", "minMainAxisOffset", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasuredItem.kt */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection2, z2, i2, i3, i4, j, obj, obj2);
    }

    private LazyListMeasuredItem(int index2, List<? extends Placeable> placeables2, boolean isVertical2, Alignment.Horizontal horizontalAlignment2, Alignment.Vertical verticalAlignment2, LayoutDirection layoutDirection2, boolean reverseLayout2, int beforeContentPadding2, int afterContentPadding2, int spacing2, long visualOffset2, Object key2, Object contentType2) {
        List<? extends Placeable> list = placeables2;
        LayoutDirection layoutDirection3 = layoutDirection2;
        Object obj = key2;
        Intrinsics.checkNotNullParameter(list, "placeables");
        Intrinsics.checkNotNullParameter(layoutDirection3, "layoutDirection");
        Intrinsics.checkNotNullParameter(obj, "key");
        this.index = index2;
        this.placeables = list;
        this.isVertical = isVertical2;
        this.horizontalAlignment = horizontalAlignment2;
        this.verticalAlignment = verticalAlignment2;
        this.layoutDirection = layoutDirection3;
        this.reverseLayout = reverseLayout2;
        this.beforeContentPadding = beforeContentPadding2;
        this.afterContentPadding = afterContentPadding2;
        this.spacing = spacing2;
        this.visualOffset = visualOffset2;
        this.key = obj;
        this.contentType = contentType2;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int mainAxisSize = 0;
        List $this$fastForEach$iv = this.placeables;
        int size2 = $this$fastForEach$iv.size();
        int maxCrossAxis = 0;
        int index$iv = 0;
        while (index$iv < size2) {
            Placeable it = $this$fastForEach$iv.get(index$iv);
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            mainAxisSize += this.isVertical ? it.getHeight() : it.getWidth();
            maxCrossAxis = Math.max(maxCrossAxis, !this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
        }
        this.size = mainAxisSize;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = maxCrossAxis;
        this.placeableOffsets = new int[(this.placeables.size() * 2)];
    }

    public int getIndex() {
        return this.index;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index2) {
        return this.placeables.get(index2).getParentData();
    }

    public final void position(int offset2, int layoutWidth, int layoutHeight) {
        this.offset = offset2;
        this.mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        int mainAxisOffset = offset2;
        List $this$fastForEachIndexed$iv = this.placeables;
        int index$iv = 0;
        int size2 = $this$fastForEachIndexed$iv.size();
        while (index$iv < size2) {
            Placeable placeable = $this$fastForEachIndexed$iv.get(index$iv);
            int indexInArray = index$iv * 2;
            if (this.isVertical) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    iArr[indexInArray] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                    this.placeableOffsets[indexInArray + 1] = mainAxisOffset;
                    mainAxisOffset += placeable.getHeight();
                    int i = layoutHeight;
                } else {
                    int i2 = layoutWidth;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                int i3 = layoutWidth;
                int[] iArr2 = this.placeableOffsets;
                iArr2[indexInArray] = mainAxisOffset;
                int i4 = indexInArray + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical != null) {
                    iArr2[i4] = vertical.align(placeable.getHeight(), layoutHeight);
                    mainAxisOffset += placeable.getWidth();
                } else {
                    int i5 = layoutHeight;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            index$iv++;
            int i6 = offset2;
        }
        int i7 = layoutHeight;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public final long m684getOffsetBjo55l4(int index2) {
        int[] iArr = this.placeableOffsets;
        return IntOffsetKt.IntOffset(iArr[index2 * 2], iArr[(index2 * 2) + 1]);
    }

    public final void place(Placeable.PlacementScope scope) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Placeable.PlacementScope $this$place_u24lambda_u245 = scope;
        int i3 = 0;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int placeablesCount = getPlaceablesCount();
            int i4 = 0;
            while (i4 < placeablesCount) {
                int index2 = i4;
                Placeable placeable = this.placeables.get(index2);
                int minOffset = this.minMainAxisOffset - getMainAxisSize(placeable);
                int maxOffset = this.maxMainAxisOffset;
                long offset2 = m684getOffsetBjo55l4(index2);
                Object parentData = getParentData(index2);
                LazyLayoutAnimateItemModifierNode animateNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
                if (animateNode != null) {
                    long other$iv = animateNode.m724getPlacementDeltanOccac();
                    i = i3;
                    long j = other$iv;
                    long animatedOffset = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(offset2) + IntOffset.m5962getXimpl(other$iv), IntOffset.m5963getYimpl(offset2) + IntOffset.m5963getYimpl(other$iv));
                    if ((m683getMainAxisgyyYBs(offset2) <= minOffset && m683getMainAxisgyyYBs(animatedOffset) <= minOffset) || (m683getMainAxisgyyYBs(offset2) >= maxOffset && m683getMainAxisgyyYBs(animatedOffset) >= maxOffset)) {
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
                    Placeable.PlacementScope.m4732placeWithLayeraW9wM$default($this$place_u24lambda_u245, placeable, offset3, 0.0f, (Function1) null, 6, (Object) null);
                } else {
                    int i7 = minOffset;
                    Placeable.PlacementScope.m4731placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u245, placeable, offset3, 0.0f, (Function1) null, 6, (Object) null);
                }
                i4++;
                i3 = i;
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m683getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m5963getYimpl($this$mainAxis) : IntOffset.m5962getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m682copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m5962getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m5963getYimpl($this$copy_u2d4Tuh3kE));
    }
}
