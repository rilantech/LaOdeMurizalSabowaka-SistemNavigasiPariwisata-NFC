package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001fJ:\u0010 \u001a\u00020!2'\u0010\"\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0%\u0012\u0006\u0012\u0004\u0018\u00010&0#¢\u0006\u0002\b'H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\u00020!*\u00020$2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "numOfItemsForTeleport", "getNumOfItemsForTeleport", "calculateLineAverageMainAxisSize", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "isVertical", "", "expectedDistanceTo", "", "index", "targetScrollOffset", "getTargetItemOffset", "(I)Ljava/lang/Integer;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridAnimateScrollScope.kt */
public final class LazyGridAnimateScrollScope implements LazyAnimateScrollScope {
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState state2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        this.state = state2;
    }

    public Density getDensity() {
        return this.state.getDensity$foundation_release();
    }

    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public Integer getTargetItemOffset(int index) {
        Object it$iv;
        int i;
        List $this$fastForEach$iv$iv = this.state.getLayoutInfo().getVisibleItemsInfo();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (((LazyGridItemInfo) it$iv).getIndex() == index) {
                break;
            }
            index$iv$iv++;
        }
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) it$iv;
        if (lazyGridItemInfo == null) {
            return null;
        }
        LazyGridItemInfo item = lazyGridItemInfo;
        if (this.state.isVertical$foundation_release()) {
            i = IntOffset.m7673getYimpl(item.m2417getOffsetnOccac());
        } else {
            i = IntOffset.m7672getXimpl(item.m2417getOffsetnOccac());
        }
        return Integer.valueOf(i);
    }

    public void snapToItem(ScrollScope $this$snapToItem, int index, int scrollOffset) {
        Intrinsics.checkNotNullParameter($this$snapToItem, "<this>");
        this.state.snapToItemIndexInternal$foundation_release(index, scrollOffset);
    }

    public float expectedDistanceTo(int index, int targetScrollOffset) {
        int slotsPerLine = this.state.getSlotsPerLine$foundation_release();
        int averageLineMainAxisSize = calculateLineAverageMainAxisSize(this.state.getLayoutInfo(), this.state.isVertical$foundation_release());
        int i = 1;
        boolean before = index < getFirstVisibleItemIndex();
        int firstVisibleItemIndex = index - getFirstVisibleItemIndex();
        int i2 = slotsPerLine - 1;
        if (before) {
            i = -1;
        }
        int linesDiff = (firstVisibleItemIndex + (i2 * i)) / slotsPerLine;
        int coercedOffset = Math.min(Math.abs(targetScrollOffset), averageLineMainAxisSize);
        if (targetScrollOffset < 0) {
            coercedOffset *= -1;
        }
        return (((float) (averageLineMainAxisSize * linesDiff)) + ((float) coercedOffset)) - ((float) getFirstVisibleItemScrollOffset());
    }

    public int getNumOfItemsForTeleport() {
        return this.state.getSlotsPerLine$foundation_release() * 100;
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo layoutInfo, boolean isVertical) {
        int i;
        List visibleItems = layoutInfo.getVisibleItemsInfo();
        Function1 lineOf = new LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1(isVertical, visibleItems);
        int totalLinesMainAxisSize = 0;
        int linesCount = 0;
        int lineStartIndex = 0;
        while (lineStartIndex < visibleItems.size()) {
            int currentLine = ((Number) lineOf.invoke(Integer.valueOf(lineStartIndex))).intValue();
            if (currentLine == -1) {
                lineStartIndex++;
            } else {
                int lineMainAxisSize = 0;
                int lineEndIndex = lineStartIndex;
                while (lineEndIndex < visibleItems.size() && ((Number) lineOf.invoke(Integer.valueOf(lineEndIndex))).intValue() == currentLine) {
                    if (isVertical) {
                        i = IntSize.m7713getHeightimpl(visibleItems.get(lineEndIndex).m2418getSizeYbymL2g());
                    } else {
                        i = IntSize.m7714getWidthimpl(visibleItems.get(lineEndIndex).m2418getSizeYbymL2g());
                    }
                    lineMainAxisSize = Math.max(lineMainAxisSize, i);
                    lineEndIndex++;
                }
                totalLinesMainAxisSize += lineMainAxisSize;
                linesCount++;
                lineStartIndex = lineEndIndex;
            }
        }
        return (totalLinesMainAxisSize / linesCount) + layoutInfo.getMainAxisItemSpacing();
    }

    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object scroll$default = ScrollableState.scroll$default(this.state, (MutatePriority) null, block, $completion, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }
}
