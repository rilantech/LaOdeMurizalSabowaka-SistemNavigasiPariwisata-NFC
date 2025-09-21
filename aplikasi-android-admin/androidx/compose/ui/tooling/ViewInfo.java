package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\rJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0001HÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010%\u001a\u00020#J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\b\u0010'\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/tooling/ViewInfo;", "", "fileName", "", "lineNumber", "", "bounds", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "children", "", "layoutInfo", "(Ljava/lang/String;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/util/List;Ljava/lang/Object;)V", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/List;", "getFileName", "()Ljava/lang/String;", "getLayoutInfo", "()Ljava/lang/Object;", "getLineNumber", "()I", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "allChildren", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hasBounds", "hashCode", "toString", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ViewInfo {
    public static final int $stable = 8;
    private final IntRect bounds;
    private final List<ViewInfo> children;
    private final String fileName;
    private final Object layoutInfo;
    private final int lineNumber;
    private final SourceLocation location;

    public static /* synthetic */ ViewInfo copy$default(ViewInfo viewInfo, String str, int i, IntRect intRect, SourceLocation sourceLocation, List<ViewInfo> list, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = viewInfo.fileName;
        }
        if ((i2 & 2) != 0) {
            i = viewInfo.lineNumber;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            intRect = viewInfo.bounds;
        }
        IntRect intRect2 = intRect;
        if ((i2 & 8) != 0) {
            sourceLocation = viewInfo.location;
        }
        SourceLocation sourceLocation2 = sourceLocation;
        if ((i2 & 16) != 0) {
            list = viewInfo.children;
        }
        List<ViewInfo> list2 = list;
        if ((i2 & 32) != 0) {
            obj = viewInfo.layoutInfo;
        }
        return viewInfo.copy(str, i3, intRect2, sourceLocation2, list2, obj);
    }

    public final String component1() {
        return this.fileName;
    }

    public final int component2() {
        return this.lineNumber;
    }

    public final IntRect component3() {
        return this.bounds;
    }

    public final SourceLocation component4() {
        return this.location;
    }

    public final List<ViewInfo> component5() {
        return this.children;
    }

    public final Object component6() {
        return this.layoutInfo;
    }

    public final ViewInfo copy(String str, int i, IntRect intRect, SourceLocation sourceLocation, List<ViewInfo> list, Object obj) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, "bounds");
        Intrinsics.checkNotNullParameter(list, "children");
        return new ViewInfo(str, i, intRect, sourceLocation, list, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) viewInfo.fileName) && this.lineNumber == viewInfo.lineNumber && Intrinsics.areEqual((Object) this.bounds, (Object) viewInfo.bounds) && Intrinsics.areEqual((Object) this.location, (Object) viewInfo.location) && Intrinsics.areEqual((Object) this.children, (Object) viewInfo.children) && Intrinsics.areEqual(this.layoutInfo, viewInfo.layoutInfo);
    }

    public int hashCode() {
        int hashCode = ((((this.fileName.hashCode() * 31) + Integer.hashCode(this.lineNumber)) * 31) + this.bounds.hashCode()) * 31;
        SourceLocation sourceLocation = this.location;
        int i = 0;
        int hashCode2 = (((hashCode + (sourceLocation == null ? 0 : sourceLocation.hashCode())) * 31) + this.children.hashCode()) * 31;
        Object obj = this.layoutInfo;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode2 + i;
    }

    public ViewInfo(String fileName2, int lineNumber2, IntRect bounds2, SourceLocation location2, List<ViewInfo> children2, Object layoutInfo2) {
        Intrinsics.checkNotNullParameter(fileName2, "fileName");
        Intrinsics.checkNotNullParameter(bounds2, "bounds");
        Intrinsics.checkNotNullParameter(children2, "children");
        this.fileName = fileName2;
        this.lineNumber = lineNumber2;
        this.bounds = bounds2;
        this.location = location2;
        this.children = children2;
        this.layoutInfo = layoutInfo2;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final IntRect getBounds() {
        return this.bounds;
    }

    public final SourceLocation getLocation() {
        return this.location;
    }

    public final List<ViewInfo> getChildren() {
        return this.children;
    }

    public final Object getLayoutInfo() {
        return this.layoutInfo;
    }

    public final boolean hasBounds() {
        return (this.bounds.getBottom() == 0 || this.bounds.getRight() == 0) ? false : true;
    }

    public final List<ViewInfo> allChildren() {
        List<ViewInfo> $this$flatMap$iv = this.children;
        Collection collection = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        for (ViewInfo it : $this$flatMap$iv) {
            CollectionsKt.addAll(destination$iv$iv, it.allChildren());
        }
        return CollectionsKt.plus(collection, (List) destination$iv$iv);
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append('(').append(this.fileName).append(':').append(this.lineNumber).append(",\n            |bounds=(top=").append(this.bounds.getTop()).append(", left=").append(this.bounds.getLeft()).append(",\n            |location=");
        SourceLocation it = this.location;
        if (it == null || (str = new StringBuilder().append('(').append(it.getOffset()).append('L').append(it.getLength()).toString()) == null) {
            str = "<none>";
        }
        return StringsKt.trimMargin$default(append.append(str).append("\n            |bottom=").append(this.bounds.getBottom()).append(", right=").append(this.bounds.getRight()).append("),\n            |childrenCount=").append(this.children.size()).append(')').toString(), (String) null, 1, (Object) null);
    }
}
