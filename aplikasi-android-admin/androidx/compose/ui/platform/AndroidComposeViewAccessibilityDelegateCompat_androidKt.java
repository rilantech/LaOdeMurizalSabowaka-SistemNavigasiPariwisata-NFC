package androidx.compose.ui.platform;

import android.graphics.Region;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0013\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0002H\u0002\u001a\f\u0010\u0018\u001a\u00020\n*\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u001a0\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0!H\u0002\u001a\u0018\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020\n*\u00020\u0002H\u0002\u001a \u0010'\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0002\u001a\u0014\u0010*\u001a\u00020\n*\u00020\u00022\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010(*\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u0016\u0010/\u001a\u0004\u0018\u000100*\u0002012\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u001b\u00102\u001a\u0004\u0018\u00010\u0006*\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0018\u0010\f\u001a\u00020\n*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0018\u0010\r\u001a\u00020\n*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u00020\n*\u00020\u00028BX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, d2 = {"getTraversalIndex", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "getGetTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsNode;)F", "infoContentDescriptionOrNull", "", "getInfoContentDescriptionOrNull", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/String;", "isPassword", "", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isRtl", "isTextField", "isTraversalGroup", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/Boolean;", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "enabled", "excludeLineAndPageGranularities", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "getAllUncoveredSemanticsNodesToMap", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "hasPaneTitle", "overlaps", "Landroidx/compose/ui/platform/OpenEndRange;", "it", "propertiesDeleted", "oldNode", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "rangeUntil", "that", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    private static /* synthetic */ void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    public static final OpenEndRange<Float> rangeUntil(float $this$rangeUntil, float that) {
        return new OpenEndFloatRange($this$rangeUntil, that);
    }

    /* access modifiers changed from: private */
    public static final boolean overlaps(OpenEndRange<Float> $this$overlaps, OpenEndRange<Float> it) {
        return !$this$overlaps.isEmpty() && !it.isEmpty() && Math.max($this$overlaps.getStart().floatValue(), it.getStart().floatValue()) < Math.min($this$overlaps.getEndExclusive().floatValue(), it.getEndExclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> selector) {
        for (LayoutNode currentParent = $this$findClosestParentNode.getParent$ui_release(); currentParent != null; currentParent = currentParent.getParent$ui_release()) {
            if (selector.invoke(currentParent).booleanValue()) {
                return currentParent;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode $this$enabled) {
        return SemanticsConfigurationKt.getOrNull($this$enabled.getConfig(), SemanticsProperties.INSTANCE.getDisabled()) == null;
    }

    /* access modifiers changed from: private */
    public static final boolean isVisible(SemanticsNode $this$isVisible) {
        return !$this$isVisible.isTransparent$ui_release() && !$this$isVisible.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser());
    }

    /* access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode $this$propertiesDeleted, AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy oldNode) {
        Iterator<Map.Entry<SemanticsPropertyKey<?>, Object>> it = oldNode.getUnmergedConfig().iterator();
        while (it.hasNext()) {
            if (!$this$propertiesDeleted.getConfig().contains((SemanticsPropertyKey) it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean hasPaneTitle(SemanticsNode $this$hasPaneTitle) {
        return $this$hasPaneTitle.getConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }

    /* access modifiers changed from: private */
    public static final boolean isPassword(SemanticsNode $this$isPassword) {
        return $this$isPassword.getConfig().contains(SemanticsProperties.INSTANCE.getPassword());
    }

    /* access modifiers changed from: private */
    public static final boolean isTextField(SemanticsNode $this$isTextField) {
        return $this$isTextField.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText());
    }

    /* access modifiers changed from: private */
    public static final boolean isRtl(SemanticsNode $this$isRtl) {
        return $this$isRtl.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* access modifiers changed from: private */
    public static final Boolean isTraversalGroup(SemanticsNode $this$isTraversalGroup) {
        return (Boolean) SemanticsConfigurationKt.getOrNull($this$isTraversalGroup.getConfig(), SemanticsProperties.INSTANCE.getIsTraversalGroup());
    }

    /* access modifiers changed from: private */
    public static final float getGetTraversalIndex(SemanticsNode $this$getTraversalIndex) {
        if ($this$getTraversalIndex.getConfig().contains(SemanticsProperties.INSTANCE.getTraversalIndex())) {
            return ((Number) $this$getTraversalIndex.getConfig().get(SemanticsProperties.INSTANCE.getTraversalIndex())).floatValue();
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public static final String getInfoContentDescriptionOrNull(SemanticsNode $this$infoContentDescriptionOrNull) {
        List list = (List) SemanticsConfigurationKt.getOrNull($this$infoContentDescriptionOrNull.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
        if (list != null) {
            return (String) CollectionsKt.firstOrNull(list);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode $this$excludeLineAndPageGranularities) {
        if (isTextField($this$excludeLineAndPageGranularities) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull($this$excludeLineAndPageGranularities.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
            return true;
        }
        LayoutNode ancestor = findClosestParentNode($this$excludeLineAndPageGranularities.getLayoutNode$ui_release(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.INSTANCE);
        if (ancestor != null) {
            SemanticsConfiguration collapsedSemantics$ui_release = ancestor.getCollapsedSemantics$ui_release();
            if (!(collapsedSemantics$ui_release != null ? Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsProperties.INSTANCE.getFocused()), (Object) true) : false)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction<?> $this$accessibilityEquals, Object other) {
        if ($this$accessibilityEquals == other) {
            return true;
        }
        if (!(other instanceof AccessibilityAction) || !Intrinsics.areEqual((Object) $this$accessibilityEquals.getLabel(), (Object) ((AccessibilityAction) other).getLabel())) {
            return false;
        }
        if ($this$accessibilityEquals.getAction() == null && ((AccessibilityAction) other).getAction() != null) {
            return false;
        }
        if ($this$accessibilityEquals.getAction() == null || ((AccessibilityAction) other).getAction() != null) {
            return true;
        }
        return false;
    }

    public static final Map<Integer, SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToMap(SemanticsOwner $this$getAllUncoveredSemanticsNodesToMap) {
        Intrinsics.checkNotNullParameter($this$getAllUncoveredSemanticsNodesToMap, "<this>");
        SemanticsNode root = $this$getAllUncoveredSemanticsNodesToMap.getUnmergedRootSemanticsNode();
        Map nodes = new LinkedHashMap();
        if (!root.getLayoutNode$ui_release().isPlaced() || !root.getLayoutNode$ui_release().isAttached()) {
            return nodes;
        }
        Region unaccountedSpace = new Region();
        Rect $this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240 = root.getBoundsInRoot();
        unaccountedSpace.set(new android.graphics.Rect(MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getLeft()), MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getTop()), MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getRight()), MathKt.roundToInt($this$getAllUncoveredSemanticsNodesToMap_u24lambda_u241_u24lambda_u240.getBottom())));
        getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(unaccountedSpace, root, nodes, root);
        return nodes;
    }

    private static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region unaccountedSpace, SemanticsNode root, Map<Integer, SemanticsNodeWithAdjustedBounds> nodes, SemanticsNode currentNode) {
        int virtualViewId;
        Rect boundsForFakeNode;
        LayoutInfo layoutInfo;
        Region region = unaccountedSpace;
        Map<Integer, SemanticsNodeWithAdjustedBounds> map = nodes;
        SemanticsNode semanticsNode = currentNode;
        boolean z = false;
        boolean notAttachedOrPlaced = !currentNode.getLayoutNode$ui_release().isPlaced() || !currentNode.getLayoutNode$ui_release().isAttached();
        if (unaccountedSpace.isEmpty() && currentNode.getId() != root.getId()) {
            return;
        }
        if (!notAttachedOrPlaced || currentNode.isFake$ui_release()) {
            Rect touchBoundsInRoot = currentNode.getTouchBoundsInRoot();
            android.graphics.Rect boundsInRoot = new android.graphics.Rect(MathKt.roundToInt(touchBoundsInRoot.getLeft()), MathKt.roundToInt(touchBoundsInRoot.getTop()), MathKt.roundToInt(touchBoundsInRoot.getRight()), MathKt.roundToInt(touchBoundsInRoot.getBottom()));
            Region region2 = new Region();
            region2.set(boundsInRoot);
            if (currentNode.getId() == root.getId()) {
                virtualViewId = -1;
            } else {
                virtualViewId = currentNode.getId();
            }
            if (region2.op(region, region2, Region.Op.INTERSECT)) {
                Integer valueOf = Integer.valueOf(virtualViewId);
                android.graphics.Rect bounds = region2.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "region.bounds");
                map.put(valueOf, new SemanticsNodeWithAdjustedBounds(semanticsNode, bounds));
                List children = currentNode.getReplacedChildren$ui_release();
                for (int i = children.size() - 1; -1 < i; i--) {
                    getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, root, map, children.get(i));
                }
                SemanticsNode semanticsNode2 = root;
                region.op(boundsInRoot, region, Region.Op.REVERSE_DIFFERENCE);
                boolean z2 = notAttachedOrPlaced;
                return;
            }
            SemanticsNode semanticsNode3 = root;
            if (currentNode.isFake$ui_release()) {
                SemanticsNode parentNode = currentNode.getParent();
                if (!(parentNode == null || (layoutInfo = parentNode.getLayoutInfo()) == null || !layoutInfo.isPlaced())) {
                    z = true;
                }
                if (z) {
                    boundsForFakeNode = parentNode.getBoundsInRoot();
                } else {
                    boundsForFakeNode = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
                }
                boolean z3 = notAttachedOrPlaced;
                map.put(Integer.valueOf(virtualViewId), new SemanticsNodeWithAdjustedBounds(semanticsNode, new android.graphics.Rect(MathKt.roundToInt(boundsForFakeNode.getLeft()), MathKt.roundToInt(boundsForFakeNode.getTop()), MathKt.roundToInt(boundsForFakeNode.getRight()), MathKt.roundToInt(boundsForFakeNode.getBottom()))));
                return;
            }
            if (virtualViewId == -1) {
                Integer valueOf2 = Integer.valueOf(virtualViewId);
                android.graphics.Rect bounds2 = region2.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds2, "region.bounds");
                map.put(valueOf2, new SemanticsNodeWithAdjustedBounds(semanticsNode, bounds2));
            }
        }
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> $this$findById, int id) {
        Intrinsics.checkNotNullParameter($this$findById, "<this>");
        int size = $this$findById.size();
        for (int index = 0; index < size; index++) {
            if ($this$findById.get(index).getSemanticsNodeId() == id) {
                return $this$findById.get(index);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLegacyClassName-V4PA4sw  reason: not valid java name */
    public static final String m6767toLegacyClassNameV4PA4sw(int $this$toLegacyClassName_u2dV4PA4sw) {
        if (Role.m6868equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.Companion.m6872getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m6868equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.Companion.m6873getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m6868equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.Companion.m6876getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m6868equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.Companion.m6875getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m6868equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.Companion.m6874getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: androidx.compose.ui.viewinterop.AndroidViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.HashMap r0 = r8.getLayoutNodeToHolder()
            java.util.Set r0 = r0.entrySet()
            java.lang.String r1 = "layoutNodeToHolder.entries"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x001a:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r2.next()
            r5 = r3
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            r6 = 0
            java.lang.Object r7 = r5.getKey()
            androidx.compose.ui.node.LayoutNode r7 = (androidx.compose.ui.node.LayoutNode) r7
            int r7 = r7.getSemanticsId()
            if (r7 != r9) goto L_0x0037
            r7 = 1
            goto L_0x0038
        L_0x0037:
            r7 = 0
        L_0x0038:
            if (r7 == 0) goto L_0x001a
            goto L_0x003c
        L_0x003b:
            r3 = r4
        L_0x003c:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            if (r3 == 0) goto L_0x0047
            java.lang.Object r0 = r3.getValue()
            r4 = r0
            androidx.compose.ui.viewinterop.AndroidViewHolder r4 = (androidx.compose.ui.viewinterop.AndroidViewHolder) r4
        L_0x0047:
            android.view.View r4 = (android.view.View) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler, int):android.view.View");
    }
}
