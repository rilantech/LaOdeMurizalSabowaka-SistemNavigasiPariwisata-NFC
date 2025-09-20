package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0002\u0010\u0019J\t\u0010>\u001a\u00020?H\u0001R\u0014\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u001dX\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0012\u0010,\u001a\u00020\u0007X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0014\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0014\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001bR\u001d\u00105\u001a\u0002068VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020\u0007X\u0005¢\u0006\u0006\u001a\u0004\b=\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/PageInfo;", "pagesCount", "", "pageSize", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "consumedScroll", "", "firstVisiblePage", "Landroidx/compose/foundation/pager/MeasuredPage;", "closestPageToSnapPosition", "firstVisiblePageOffset", "canScrollForward", "measureResult", "(Ljava/util/List;IIIILandroidx/compose/foundation/gestures/Orientation;IIZFLandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/PageInfo;IZLandroidx/compose/ui/layout/MeasureResult;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "getCanScrollForward", "()Z", "getClosestPageToSnapPosition", "()Landroidx/compose/foundation/pager/PageInfo;", "getConsumedScroll", "()F", "getFirstVisiblePage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getFirstVisiblePageOffset", "height", "getHeight", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPageSize", "getPageSpacing", "getPagesCount", "getReverseLayout", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisiblePagesInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasureResult.kt */
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final PageInfo closestPageToSnapPosition;
    private final float consumedScroll;
    private final MeasuredPage firstVisiblePage;
    private final int firstVisiblePageOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final int pagesCount;
    private final boolean reverseLayout;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<PageInfo> visiblePagesInfo;

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public PagerMeasureResult(List<? extends PageInfo> visiblePagesInfo2, int pagesCount2, int pageSize2, int pageSpacing2, int afterContentPadding2, Orientation orientation2, int viewportStartOffset2, int viewportEndOffset2, boolean reverseLayout2, float consumedScroll2, MeasuredPage firstVisiblePage2, PageInfo closestPageToSnapPosition2, int firstVisiblePageOffset2, boolean canScrollForward2, MeasureResult measureResult) {
        List<? extends PageInfo> list = visiblePagesInfo2;
        Orientation orientation3 = orientation2;
        MeasureResult measureResult2 = measureResult;
        Intrinsics.checkNotNullParameter(list, "visiblePagesInfo");
        Intrinsics.checkNotNullParameter(orientation3, "orientation");
        Intrinsics.checkNotNullParameter(measureResult2, "measureResult");
        this.visiblePagesInfo = list;
        this.pagesCount = pagesCount2;
        this.pageSize = pageSize2;
        this.pageSpacing = pageSpacing2;
        this.afterContentPadding = afterContentPadding2;
        this.orientation = orientation3;
        this.viewportStartOffset = viewportStartOffset2;
        this.viewportEndOffset = viewportEndOffset2;
        this.reverseLayout = reverseLayout2;
        this.consumedScroll = consumedScroll2;
        this.firstVisiblePage = firstVisiblePage2;
        this.closestPageToSnapPosition = closestPageToSnapPosition2;
        this.firstVisiblePageOffset = firstVisiblePageOffset2;
        this.canScrollForward = canScrollForward2;
        this.$$delegate_0 = measureResult2;
    }

    public List<PageInfo> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    public int getPagesCount() {
        return this.pagesCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPageSpacing() {
        return this.pageSpacing;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public PageInfo getClosestPageToSnapPosition() {
        return this.closestPageToSnapPosition;
    }

    public final int getFirstVisiblePageOffset() {
        return this.firstVisiblePageOffset;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m2537getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }
}
