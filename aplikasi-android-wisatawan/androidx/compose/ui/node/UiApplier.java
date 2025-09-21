package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/node/UiApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", "root", "(Landroidx/compose/ui/node/LayoutNode;)V", "insertBottomUp", "", "index", "", "instance", "insertTopDown", "move", "from", "to", "count", "onClear", "onEndChanges", "remove", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UiApplier.android.kt */
public final class UiApplier extends AbstractApplier<LayoutNode> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UiApplier(LayoutNode root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    public void insertTopDown(int index, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    public void insertBottomUp(int index, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        ((LayoutNode) getCurrent()).insertAt$ui_release(index, instance);
    }

    public void remove(int index, int count) {
        ((LayoutNode) getCurrent()).removeAt$ui_release(index, count);
    }

    public void move(int from, int to, int count) {
        ((LayoutNode) getCurrent()).move$ui_release(from, to, count);
    }

    /* access modifiers changed from: protected */
    public void onClear() {
        ((LayoutNode) getRoot()).removeAll$ui_release();
    }

    public void onEndChanges() {
        super.onEndChanges();
        Owner owner$ui_release = ((LayoutNode) getRoot()).getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onEndApplyChanges();
        }
    }
}
