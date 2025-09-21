package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003H\bJ\u0006\u0010\u0018\u001a\u00020\u0007J\"\u0010\u0019\u001a\u00020\u00132\u0014\b\u0004\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u001bH\bø\u0001\u0000J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/DepthSortedSet;", "", "extraAssertions", "", "(Z)V", "DepthComparator", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "mapOfOriginalDepth", "", "", "getMapOfOriginalDepth", "()Ljava/util/Map;", "mapOfOriginalDepth$delegate", "Lkotlin/Lazy;", "set", "Landroidx/compose/ui/node/TreeSet;", "add", "", "node", "contains", "isEmpty", "isNotEmpty", "pop", "popEach", "block", "Lkotlin/Function1;", "remove", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DepthSortedSet.kt */
public final class DepthSortedSet {
    private final Comparator<LayoutNode> DepthComparator;
    private final boolean extraAssertions;
    private final Lazy mapOfOriginalDepth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, DepthSortedSet$mapOfOriginalDepth$2.INSTANCE);
    private final TreeSet<LayoutNode> set;

    public DepthSortedSet(boolean extraAssertions2) {
        this.extraAssertions = extraAssertions2;
        Comparator<LayoutNode> depthSortedSet$DepthComparator$1 = new DepthSortedSet$DepthComparator$1();
        this.DepthComparator = depthSortedSet$DepthComparator$1;
        this.set = new TreeSet<>(depthSortedSet$DepthComparator$1);
    }

    private final Map<LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth$delegate.getValue();
    }

    public final boolean contains(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        boolean contains = this.set.contains(node);
        if (this.extraAssertions) {
            if (!(contains == getMapOfOriginalDepth().containsKey(node))) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return contains;
    }

    public final void add(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            if (this.extraAssertions) {
                Integer usedDepth = getMapOfOriginalDepth().get(node);
                if (usedDepth == null) {
                    getMapOfOriginalDepth().put(node, Integer.valueOf(node.getDepth$ui_release()));
                } else {
                    if (!(usedDepth.intValue() == node.getDepth$ui_release())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            this.set.add(node);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean remove(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            boolean contains = this.set.remove(node);
            if (this.extraAssertions) {
                Integer usedDepth = getMapOfOriginalDepth().remove(node);
                boolean z = true;
                if (contains) {
                    int depth$ui_release = node.getDepth$ui_release();
                    if (usedDepth == null || usedDepth.intValue() != depth$ui_release) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (usedDepth != null) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            return contains;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final LayoutNode pop() {
        LayoutNode node = (LayoutNode) this.set.first();
        Intrinsics.checkNotNullExpressionValue(node, "node");
        remove(node);
        return node;
    }

    public final void popEach(Function1<? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        while (!isEmpty()) {
            block.invoke(pop());
        }
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public String toString() {
        String treeSet = this.set.toString();
        Intrinsics.checkNotNullExpressionValue(treeSet, "set.toString()");
        return treeSet;
    }
}
