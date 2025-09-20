package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.node.LayoutNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"getChildrenOfVirtualChildren", "", "Landroidx/compose/ui/layout/Measurable;", "scope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "isInLookaheadPass", "", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasureScopeWithLayoutNode.kt */
public final class MeasureScopeWithLayoutNodeKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MeasureScopeWithLayoutNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<List<Measurable>> getChildrenOfVirtualChildren(IntrinsicMeasureScope scope) {
        IntrinsicMeasureScope intrinsicMeasureScope = scope;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "scope");
        LayoutNode layoutNode = ((MeasureScopeWithLayoutNode) intrinsicMeasureScope).getLayoutNode();
        boolean lookahead = isInLookaheadPass(layoutNode);
        List foldedChildren$ui_release = layoutNode.getFoldedChildren$ui_release();
        List target$iv = new ArrayList(foldedChildren$ui_release.size());
        List $this$fastForEach$iv$iv = foldedChildren$ui_release;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Collection collection = target$iv;
            LayoutNode it = (LayoutNode) $this$fastForEach$iv$iv.get(index$iv$iv);
            collection.add(lookahead ? it.getChildLookaheadMeasurables$ui_release() : it.getChildMeasurables$ui_release());
        }
        return target$iv;
    }

    private static final boolean isInLookaheadPass(LayoutNode $this$isInLookaheadPass) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$isInLookaheadPass.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 2:
                return true;
            case 3:
            case 4:
                return false;
            case 5:
                LayoutNode parent$ui_release = $this$isInLookaheadPass.getParent$ui_release();
                if (parent$ui_release != null) {
                    return isInLookaheadPass(parent$ui_release);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
