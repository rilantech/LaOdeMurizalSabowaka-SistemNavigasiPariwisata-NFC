package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0016\u001a\u00020\u0017XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0005R\u001f\u0010\u001c\u001a\u00020\u001dX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0005R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"androidx/compose/foundation/pager/PagerStateKt$EmptyLayoutInfo$1", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "afterContentPadding", "", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "closestPageToSnapPosition", "Landroidx/compose/foundation/pager/PageInfo;", "getClosestPageToSnapPosition", "()Landroidx/compose/foundation/pager/PageInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "pageSize", "getPageSize", "pageSpacing", "getPageSpacing", "pagesCount", "getPagesCount", "reverseLayout", "", "getReverseLayout", "()Z", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "J", "viewportStartOffset", "getViewportStartOffset", "visiblePagesInfo", "", "getVisiblePagesInfo", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerStateKt$EmptyLayoutInfo$1 implements PagerLayoutInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final PageInfo closestPageToSnapPosition;
    private final Orientation orientation = Orientation.Horizontal;
    private final int pageSize;
    private final int pageSpacing;
    private final int pagesCount;
    private final boolean reverseLayout;
    private final int viewportEndOffset;
    private final long viewportSize = IntSize.Companion.m6009getZeroYbymL2g();
    private final int viewportStartOffset;
    private final List<PageInfo> visiblePagesInfo = CollectionsKt.emptyList();

    PagerStateKt$EmptyLayoutInfo$1() {
    }

    public List<PageInfo> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    public PageInfo getClosestPageToSnapPosition() {
        return this.closestPageToSnapPosition;
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

    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m832getViewportSizeYbymL2g() {
        return this.viewportSize;
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
}
