package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J \u0010!\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001e\u0010/\u001a\u00020,2\u0006\u0010 \u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0003J.\u00102\u001a\u00020\t*\u00020\t2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000304H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010%R\u0018\u0010&\u001a\u00020\u0003*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "isVertical", "getKey", "()Ljava/lang/Object;", "mainAxisLayoutSize", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "getSize", "J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getOffset-Bjo55l4", "(I)J", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasuredPage.kt */
public final class MeasuredPage implements PageInfo {
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int i, int i2, List list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, list, j, obj, orientation, horizontal, vertical, layoutDirection2, z);
    }

    private MeasuredPage(int index2, int size2, List<? extends Placeable> placeables2, long visualOffset2, Object key2, Orientation orientation, Alignment.Horizontal horizontalAlignment2, Alignment.Vertical verticalAlignment2, LayoutDirection layoutDirection2, boolean reverseLayout2) {
        List<? extends Placeable> list = placeables2;
        Object obj = key2;
        Orientation orientation2 = orientation;
        LayoutDirection layoutDirection3 = layoutDirection2;
        Intrinsics.checkNotNullParameter(list, "placeables");
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(layoutDirection3, "layoutDirection");
        this.index = index2;
        this.size = size2;
        this.placeables = list;
        this.visualOffset = visualOffset2;
        this.key = obj;
        this.horizontalAlignment = horizontalAlignment2;
        this.verticalAlignment = verticalAlignment2;
        this.layoutDirection = layoutDirection3;
        this.reverseLayout = reverseLayout2;
        this.isVertical = orientation2 == Orientation.Vertical;
        int maxCrossAxis = 0;
        List $this$fastForEach$iv = this.placeables;
        int index$iv = 0;
        int size3 = $this$fastForEach$iv.size();
        while (index$iv < size3) {
            Placeable it = $this$fastForEach$iv.get(index$iv);
            int i = size3;
            maxCrossAxis = Math.max(maxCrossAxis, !this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            size3 = i;
        }
        this.crossAxisSize = maxCrossAxis;
        this.placeableOffsets = new int[(this.placeables.size() * 2)];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
    }

    public int getIndex() {
        return this.index;
    }

    public final int getSize() {
        return this.size;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public int getOffset() {
        return this.offset;
    }

    public final void position(int offset2, int layoutWidth, int layoutHeight) {
        MeasuredPage measuredPage = this;
        measuredPage.offset = offset2;
        measuredPage.mainAxisLayoutSize = measuredPage.isVertical ? layoutHeight : layoutWidth;
        int mainAxisOffset = offset2;
        List $this$fastForEachIndexed$iv = measuredPage.placeables;
        int index$iv = 0;
        int size2 = $this$fastForEachIndexed$iv.size();
        while (index$iv < size2) {
            Placeable placeable = $this$fastForEachIndexed$iv.get(index$iv);
            int indexInArray = index$iv * 2;
            if (measuredPage.isVertical) {
                int[] iArr = measuredPage.placeableOffsets;
                Alignment.Horizontal horizontal = measuredPage.horizontalAlignment;
                if (horizontal != null) {
                    iArr[indexInArray] = horizontal.align(placeable.getWidth(), layoutWidth, measuredPage.layoutDirection);
                    measuredPage.placeableOffsets[indexInArray + 1] = mainAxisOffset;
                    mainAxisOffset += placeable.getHeight();
                    int i = layoutHeight;
                } else {
                    int i2 = layoutWidth;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                int i3 = layoutWidth;
                int[] iArr2 = measuredPage.placeableOffsets;
                iArr2[indexInArray] = mainAxisOffset;
                int i4 = indexInArray + 1;
                Alignment.Vertical vertical = measuredPage.verticalAlignment;
                if (vertical != null) {
                    iArr2[i4] = vertical.align(placeable.getHeight(), layoutHeight);
                    mainAxisOffset += placeable.getWidth();
                } else {
                    int i5 = layoutHeight;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            index$iv++;
            measuredPage = this;
            int i6 = offset2;
        }
        int i7 = layoutWidth;
        int i8 = layoutHeight;
    }

    public final void place(Placeable.PlacementScope scope) {
        int i;
        int mainAxisOffset;
        int i2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Placeable.PlacementScope $this$place_u24lambda_u245 = scope;
        int i3 = 0;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int size2 = this.placeables.size();
            int i4 = 0;
            while (i4 < size2) {
                int index2 = i4;
                Placeable placeable = this.placeables.get(index2);
                long offset2 = m2524getOffsetBjo55l4(index2);
                if (this.reverseLayout) {
                    long $this$copy_u2d4Tuh3kE$iv = offset2;
                    if (this.isVertical) {
                        mainAxisOffset = IntOffset.m7672getXimpl($this$copy_u2d4Tuh3kE$iv);
                        i = i3;
                    } else {
                        i = i3;
                        mainAxisOffset = (this.mainAxisLayoutSize - IntOffset.m7672getXimpl($this$copy_u2d4Tuh3kE$iv)) - getMainAxisSize(placeable);
                    }
                    if (this.isVertical) {
                        long j = offset2;
                        i2 = (this.mainAxisLayoutSize - IntOffset.m7673getYimpl($this$copy_u2d4Tuh3kE$iv)) - getMainAxisSize(placeable);
                    } else {
                        i2 = IntOffset.m7673getYimpl($this$copy_u2d4Tuh3kE$iv);
                    }
                    offset2 = IntOffsetKt.IntOffset(mainAxisOffset, i2);
                } else {
                    i = i3;
                    long j2 = offset2;
                }
                long other$iv = this.visualOffset;
                long offset3 = IntOffsetKt.IntOffset(IntOffset.m7672getXimpl(offset2) + IntOffset.m7672getXimpl(other$iv), IntOffset.m7673getYimpl(offset2) + IntOffset.m7673getYimpl(other$iv));
                if (this.isVertical) {
                    Placeable.PlacementScope.m6442placeWithLayeraW9wM$default($this$place_u24lambda_u245, placeable, offset3, 0.0f, (Function1) null, 6, (Object) null);
                    Placeable placeable2 = placeable;
                } else {
                    Placeable.PlacementScope.m6441placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u245, placeable, offset3, 0.0f, (Function1) null, 6, (Object) null);
                }
                i4++;
                i3 = i;
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    private final long m2524getOffsetBjo55l4(int index2) {
        int[] iArr = this.placeableOffsets;
        return IntOffsetKt.IntOffset(iArr[index2 * 2], iArr[(index2 * 2) + 1]);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m2523copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m7672getXimpl($this$copy_u2d4Tuh3kE) : mainAxisMap.invoke(Integer.valueOf(IntOffset.m7672getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? mainAxisMap.invoke(Integer.valueOf(IntOffset.m7673getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m7673getYimpl($this$copy_u2d4Tuh3kE));
    }
}
