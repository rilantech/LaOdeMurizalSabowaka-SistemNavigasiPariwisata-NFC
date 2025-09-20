package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGJ\u0016\u0010H\u001a\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00000KH\u0002J6\u0010L\u001a\u00020\u00002\b\u0010M\u001a\u0004\u0018\u00010N2\u0017\u0010O\u001a\u0013\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020I0P¢\u0006\u0002\bRH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bSJ\u000f\u0010T\u001a\u0004\u0018\u00010UH\u0000¢\u0006\u0002\bVJ\u001e\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00000\u00122\u000e\b\u0002\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00000KH\u0002J\u000e\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020[J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00122\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0005H\u0002J\u0010\u0010^\u001a\u00020I2\u0006\u0010_\u001a\u00020\tH\u0002J\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00000\u00122\b\b\u0002\u0010]\u001a\u00020\u0005H\u0000¢\u0006\u0002\b`J\u001a\u0010a\u001a\u00020I*\u00020\u00072\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00000KH\u0002R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0011\u0010#\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0014\u0010&\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u0002058Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u0002058Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b9\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00000\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u0013\u0010<\u001a\u0004\u0018\u00010=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020A8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bB\u00107R\u0011\u0010C\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bD\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", "config", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "isTransparent", "isTransparent$ui_release", "isUnmergedLeafNode", "isUnmergedLeafNode$ui_release", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "touchBoundsInRoot", "getTouchBoundsInRoot", "getUnmergedConfig$ui_release", "copyWithMergingEnabled", "copyWithMergingEnabled$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "findOneLayerOfMergingSemanticsNodes", "list", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "includeFakeNodes", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "fillOneLayerOfSemanticsWrappers", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node outerSemanticsNode2, boolean mergingEnabled2, LayoutNode layoutNode2, SemanticsConfiguration unmergedConfig2) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode2, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        Intrinsics.checkNotNullParameter(unmergedConfig2, "unmergedConfig");
        this.outerSemanticsNode = outerSemanticsNode2;
        this.mergingEnabled = mergingEnabled2;
        this.layoutNode = layoutNode2;
        this.unmergedConfig = unmergedConfig2;
        this.id = layoutNode2.getSemanticsId();
    }

    public final Modifier.Node getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final void setFake$ui_release(boolean z) {
        this.isFake = z;
    }

    public final boolean isUnmergedLeafNode$ui_release() {
        return !this.isFake && getReplacedChildren$ui_release().isEmpty() && SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$isUnmergedLeafNode$1.INSTANCE) == null;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release.getRootForTest();
        }
        return null;
    }

    public final int getId() {
        return this.id;
    }

    public final Rect getTouchBoundsInRoot() {
        DelegatableNode entity;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            DelegatableNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
            if (outerMergingSemantics == null) {
                outerMergingSemantics = this.outerSemanticsNode;
            }
            entity = outerMergingSemantics;
        } else {
            entity = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(entity.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m6882getSizeYbymL2g() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        return findCoordinatorToGetBounds$ui_release != null ? findCoordinatorToGetBounds$ui_release.m6640getSizeYbymL2g() : IntSize.Companion.m7719getZeroYbymL2g();
    }

    public final Rect getBoundsInRoot() {
        Rect boundsInRoot;
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (!(it == null || (boundsInRoot = LayoutCoordinatesKt.boundsInRoot(it)) == null)) {
                return boundsInRoot;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInRoot-F1C5BW0  reason: not valid java name */
    public final long m6880getPositionInRootF1C5BW0() {
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (it != null) {
                return LayoutCoordinatesKt.positionInRoot(it);
            }
        }
        return Offset.Companion.m4729getZeroF1C5BW0();
    }

    public final Rect getBoundsInWindow() {
        Rect boundsInWindow;
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (!(it == null || (boundsInWindow = LayoutCoordinatesKt.boundsInWindow(it)) == null)) {
                return boundsInWindow;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInWindow-F1C5BW0  reason: not valid java name */
    public final long m6881getPositionInWindowF1C5BW0() {
        NodeCoordinator it = findCoordinatorToGetBounds$ui_release();
        if (it != null) {
            if (!it.isAttached()) {
                it = null;
            }
            if (it != null) {
                return LayoutCoordinatesKt.positionInWindow(it);
            }
        }
        return Offset.Companion.m4729getZeroF1C5BW0();
    }

    public final boolean isTransparent$ui_release() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.isTransparent();
        }
        return false;
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.get(alignmentLine);
        }
        return Integer.MIN_VALUE;
    }

    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration mergedConfig = this.unmergedConfig.copy();
        mergeConfig(mergedConfig);
        return mergedConfig;
    }

    private final void mergeConfig(SemanticsConfiguration mergedConfig) {
        if (!this.unmergedConfig.isClearingSemantics()) {
            List $this$fastForEach$iv = unmergedChildren$ui_release$default(this, false, 1, (Object) null);
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                SemanticsNode child = (SemanticsNode) $this$fastForEach$iv.get(index$iv);
                if (!child.isMergingSemanticsOfDescendants()) {
                    mergedConfig.mergeChild$ui_release(child.unmergedConfig);
                    child.mergeConfig(mergedConfig);
                }
            }
        }
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z);
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(boolean includeFakeNodes) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        List unmergedChildren = new ArrayList();
        fillOneLayerOfSemanticsWrappers(this.layoutNode, unmergedChildren);
        if (includeFakeNodes) {
            emitFakeNodes(unmergedChildren);
        }
        return unmergedChildren;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode $this$fillOneLayerOfSemanticsWrappers, List<SemanticsNode> list) {
        MutableVector this_$iv = $this$fillOneLayerOfSemanticsWrappers.getZSortedChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv[i$iv];
                if (child.isAttached()) {
                    if (child.getNodes$ui_release().m6616hasH91voCI$ui_release(NodeKind.m6666constructorimpl(8))) {
                        list.add(SemanticsNodeKt.SemanticsNode(child, this.mergingEnabled));
                    } else {
                        fillOneLayerOfSemanticsWrappers(child, list);
                    }
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren(!this.mergingEnabled, false);
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, true);
    }

    private final List<SemanticsNode> getChildren(boolean includeReplacedSemantics, boolean includeFakeNodes) {
        if (!includeReplacedSemantics && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, (List) null, 1, (Object) null);
        }
        return unmergedChildren$ui_release(includeFakeNodes);
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final SemanticsNode getParent() {
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode node = null;
        if (this.mergingEnabled) {
            node = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$1.INSTANCE);
        }
        if (node == null) {
            node = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$2.INSTANCE);
        }
        if (node == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(node, this.mergingEnabled);
    }

    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list) {
        List $this$fastForEach$iv = unmergedChildren$ui_release$default(this, false, 1, (Object) null);
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            SemanticsNode child = (SemanticsNode) $this$fastForEach$iv.get(index$iv);
            if (child.isMergingSemanticsOfDescendants()) {
                list.add(child);
            } else if (!child.unmergedConfig.isClearingSemantics()) {
                child.findOneLayerOfMergingSemanticsNodes(list);
            }
        }
        return list;
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (this.isFake) {
            SemanticsNode parent = getParent();
            if (parent != null) {
                return parent.findCoordinatorToGetBounds$ui_release();
            }
            return null;
        }
        DelegatableNode semanticsModifierNode = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (semanticsModifierNode == null) {
            semanticsModifierNode = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.m6502requireCoordinator64DMado(semanticsModifierNode, NodeKind.m6666constructorimpl(8));
    }

    private final void emitFakeNodes(List<SemanticsNode> unmergedChildren) {
        Role nodeRole = SemanticsNodeKt.getRole(this);
        if (nodeRole != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!unmergedChildren.isEmpty())) {
            unmergedChildren.add(m6879fakeSemanticsNodeypyhhiA(nodeRole, new SemanticsNode$emitFakeNodes$fakeNode$1(nodeRole)));
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && (!unmergedChildren.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            String contentDescription = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
            if (contentDescription != null) {
                unmergedChildren.add(0, m6879fakeSemanticsNodeypyhhiA((Role) null, new SemanticsNode$emitFakeNodes$fakeNode$2(contentDescription)));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA  reason: not valid java name */
    private final SemanticsNode m6879fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        SemanticsConfiguration configuration = new SemanticsConfiguration();
        SemanticsConfiguration it = configuration;
        it.setMergingSemanticsOfDescendants(false);
        it.setClearingSemantics(false);
        properties.invoke(it);
        SemanticsNode fakeNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(properties), false, new LayoutNode(true, role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this)), configuration);
        fakeNode.isFake = true;
        fakeNode.fakeNodeParent = this;
        return fakeNode;
    }

    public final SemanticsNode copyWithMergingEnabled$ui_release() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }
}
