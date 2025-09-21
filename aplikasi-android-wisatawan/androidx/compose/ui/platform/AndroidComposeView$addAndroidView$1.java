package androidx.compose.ui.platform;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$addAndroidView$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView$addAndroidView$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidComposeView $thisView;
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$addAndroidView$1(LayoutNode $layoutNode2, AndroidComposeView $receiver, AndroidComposeView $thisView2) {
        this.$layoutNode = $layoutNode2;
        this.this$0 = $receiver;
        this.$thisView = $thisView2;
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        LayoutNode findClosestParentNode = SemanticsNodeKt.findClosestParentNode(this.$layoutNode, AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.INSTANCE);
        Integer parentId = findClosestParentNode != null ? Integer.valueOf(findClosestParentNode.getSemanticsId()) : null;
        if (parentId == null || parentId.intValue() == this.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            parentId = -1;
        }
        info.setParent(this.$thisView, parentId.intValue());
        int semanticsId = this.$layoutNode.getSemanticsId();
        Integer beforeId = this.this$0.accessibilityDelegate.getIdToBeforeMap$ui_release().get(Integer.valueOf(semanticsId));
        if (beforeId != null) {
            AndroidComposeView androidComposeView = this.this$0;
            AndroidComposeView androidComposeView2 = this.$thisView;
            int it = beforeId.intValue();
            View beforeView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui_release(), beforeId.intValue());
            if (beforeView != null) {
                info.setTraversalBefore(beforeView);
            } else {
                info.setTraversalBefore(androidComposeView2, it);
            }
            AccessibilityNodeInfo unwrap = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
            androidComposeView.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, unwrap, androidComposeView.accessibilityDelegate.getEXTRA_DATA_TEST_TRAVERSALBEFORE_VAL$ui_release());
        }
        Integer afterId = this.this$0.accessibilityDelegate.getIdToAfterMap$ui_release().get(Integer.valueOf(semanticsId));
        if (afterId != null) {
            AndroidComposeView androidComposeView3 = this.this$0;
            AndroidComposeView androidComposeView4 = this.$thisView;
            int it2 = afterId.intValue();
            View afterView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(androidComposeView3.getAndroidViewsHandler$ui_release(), afterId.intValue());
            if (afterView != null) {
                info.setTraversalAfter(afterView);
            } else {
                info.setTraversalAfter(androidComposeView4, it2);
            }
            AccessibilityNodeInfo unwrap2 = info.unwrap();
            Intrinsics.checkNotNullExpressionValue(unwrap2, "info.unwrap()");
            androidComposeView3.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, unwrap2, androidComposeView3.accessibilityDelegate.getEXTRA_DATA_TEST_TRAVERSALAFTER_VAL$ui_release());
        }
    }
}
