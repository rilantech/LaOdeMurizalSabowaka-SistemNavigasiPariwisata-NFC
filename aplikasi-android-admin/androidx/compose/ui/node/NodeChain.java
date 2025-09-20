package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002mnB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002JE\u0010,\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001901H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b2\u00103J@\u00104\u001a\u00060\rR\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00108\u001a\u00020\u0019H\u0002J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J!\u0010<\u001a\u00020\u00192\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b=\u0010>J\u0015\u0010<\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@J.\u0010\u0011\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0002\bEJC\u0010C\u001a\u00020D\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bF\u0010GJ-\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0002\bEJ%\u0010H\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0002\bIJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0006\u0010L\u001a\u00020DJ\r\u0010M\u001a\u00020DH\u0000¢\u0006\u0002\bNJ\b\u0010O\u001a\u00020\u0010H\u0002J\u0018\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u001fH\u0002J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J\r\u0010T\u001a\u00020DH\u0000¢\u0006\u0002\bUJ\u0006\u0010V\u001a\u00020DJ\r\u0010W\u001a\u00020DH\u0000¢\u0006\u0002\bXJ<\u0010Y\u001a\u00020D2\u0006\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0019H\u0002J\b\u0010Z\u001a\u00020DH\u0002J\u0006\u0010[\u001a\u00020DJ.\u0010#\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\\\u0010BJ%\u0010]\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0002\b^JC\u0010]\u001a\u00020D\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b_\u0010GJ-\u0010]\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0002\b^J\b\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0010H\u0002J\u0015\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ \u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0017\u0010k\u001a\u00020D2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\blR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006o"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "createAndInsertNodeAsChild", "element", "parent", "createAndInsertNodeAsParent", "child", "detachAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "offset", "before", "after", "shouldAttachOnInsert", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "mask", "has$ui_release", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "headToTailExclusive", "headToTailExclusive$ui_release", "insertChild", "insertParent", "markAsAttached", "markAsDetached", "markAsDetached$ui_release", "padChain", "propagateCoordinator", "start", "coordinator", "removeNode", "resetState", "resetState$ui_release", "runAttachLifecycle", "runDetachLifecycle", "runDetachLifecycle$ui_release", "structuralUpdate", "syncAggregateChildKindSet", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "paddedHead", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNode", "prev", "next", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeChain.kt */
public final class NodeChain {
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeChain.kt */
    public interface Logger {
        void linearDiffAborted(int i, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeInserted(int i, int i2, Modifier.Element element, Modifier.Node node, Modifier.Node node2);

        void nodeRemoved(int i, Modifier.Element element, Modifier.Node node);

        void nodeReused(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeUpdated(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);
    }

    public NodeChain(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode2);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        Modifier.Node tail2 = innerNodeCoordinator.getTail();
        this.tail = tail2;
        this.head = tail2;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final InnerNodeCoordinator getInnerCoordinator$ui_release() {
        return this.innerCoordinator;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.outerCoordinator;
    }

    public final Modifier.Node getTail$ui_release() {
        return this.tail;
    }

    public final Modifier.Node getHead$ui_release() {
        return this.head;
    }

    private final boolean isUpdating() {
        return this.head == NodeChainKt.SentinelHead;
    }

    /* access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    public final void useLogger$ui_release(Logger logger2) {
        this.logger = logger2;
    }

    private final Modifier.Node padChain() {
        if (this.head != NodeChainKt.SentinelHead) {
            Modifier.Node currentHead = this.head;
            currentHead.setParent$ui_release(NodeChainKt.SentinelHead);
            NodeChainKt.SentinelHead.setChild$ui_release(currentHead);
            return NodeChainKt.SentinelHead;
        }
        throw new IllegalStateException("padChain called on already padded chain".toString());
    }

    private final Modifier.Node trimChain(Modifier.Node paddedHead) {
        boolean z = true;
        if (paddedHead == NodeChainKt.SentinelHead) {
            Modifier.Node result = NodeChainKt.SentinelHead.getChild$ui_release();
            if (result == null) {
                result = this.tail;
            }
            result.setParent$ui_release((Modifier.Node) null);
            NodeChainKt.SentinelHead.setChild$ui_release((Modifier.Node) null);
            NodeChainKt.SentinelHead.setAggregateChildKindSet$ui_release(-1);
            NodeChainKt.SentinelHead.updateCoordinator$ui_release((NodeCoordinator) null);
            if (result == NodeChainKt.SentinelHead) {
                z = false;
            }
            if (z) {
                return result;
            }
            throw new IllegalStateException("trimChain did not update the head".toString());
        }
        throw new IllegalStateException("trimChain called on already trimmed chain".toString());
    }

    public final void updateFrom$ui_release(Modifier m) {
        Modifier.Node node;
        Modifier modifier = m;
        Intrinsics.checkNotNullParameter(modifier, "m");
        boolean coordinatorSyncNeeded = false;
        Modifier.Node paddedHead = padChain();
        MutableVector before = this.current;
        int beforeSize = before != null ? before.getSize() : 0;
        MutableVector<Modifier.Element> mutableVector = this.buffer;
        if (mutableVector == null) {
            mutableVector = new MutableVector<>(new Modifier.Element[16], 0);
        }
        MutableVector this_$iv = NodeChainKt.fillVector(modifier, mutableVector);
        int i = 0;
        MutableVector mutableVector2 = null;
        if (this_$iv.getSize() == beforeSize) {
            Modifier.Node node2 = paddedHead.getChild$ui_release();
            while (true) {
                if (node2 == null || i >= beforeSize) {
                    node = node2;
                } else if (before != null) {
                    Modifier.Element prev = (Modifier.Element) before.getContent()[i];
                    Modifier.Element next = (Modifier.Element) this_$iv.getContent()[i];
                    switch (NodeChainKt.actionForModifiers(prev, next)) {
                        case 0:
                            Logger logger2 = this.logger;
                            if (logger2 != null) {
                                logger2.linearDiffAborted(i, prev, next, node2);
                            }
                            node = node2.getParent$ui_release();
                            break;
                        case 1:
                            updateNode(prev, next, node2);
                            Logger logger3 = this.logger;
                            if (logger3 != null) {
                                logger3.nodeUpdated(i, i, prev, next, node2);
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            Logger logger4 = this.logger;
                            if (logger4 != null) {
                                logger4.nodeReused(i, i, prev, next, node2);
                                break;
                            } else {
                                continue;
                            }
                    }
                } else {
                    throw new IllegalStateException("expected prior modifier list to be non-empty".toString());
                }
                node2 = node2.getChild$ui_release();
                i++;
            }
            node = node2;
            if (i < beforeSize) {
                if (before == null) {
                    throw new IllegalStateException("expected prior modifier list to be non-empty".toString());
                } else if (node != null) {
                    structuralUpdate(i, before, this_$iv, node, this.layoutNode.isAttached());
                    coordinatorSyncNeeded = true;
                } else {
                    throw new IllegalStateException("structuralUpdate requires a non-null tail".toString());
                }
            }
        } else if (!this.layoutNode.isAttached() && beforeSize == 0) {
            coordinatorSyncNeeded = true;
            Modifier.Node node3 = paddedHead;
            while (i < this_$iv.getSize()) {
                Modifier.Element next2 = (Modifier.Element) this_$iv.getContent()[i];
                Modifier.Node parent = node3;
                node3 = createAndInsertNodeAsChild(next2, parent);
                Logger logger5 = this.logger;
                if (logger5 != null) {
                    logger5.nodeInserted(0, i, next2, parent, node3);
                }
                i++;
            }
            syncAggregateChildKindSet();
        } else if (this_$iv.getSize() != 0) {
            MutableVector before2 = before == null ? new MutableVector(new Modifier.Element[16], 0) : before;
            structuralUpdate(0, before2, this_$iv, paddedHead, this.layoutNode.isAttached());
            before = before2;
            coordinatorSyncNeeded = true;
        } else if (before != null) {
            Modifier.Node node4 = paddedHead.getChild$ui_release();
            while (node4 != null && i < before.getSize()) {
                Logger logger6 = this.logger;
                if (logger6 != null) {
                    logger6.nodeRemoved(i, (Modifier.Element) before.getContent()[i], node4);
                }
                node4 = detachAndRemoveNode(node4).getChild$ui_release();
                i++;
            }
            InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            innerNodeCoordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
            this.outerCoordinator = this.innerCoordinator;
        } else {
            throw new IllegalStateException("expected prior modifier list to be non-empty".toString());
        }
        this.current = this_$iv;
        if (before != null) {
            before.clear();
            mutableVector2 = before;
        }
        this.buffer = mutableVector2;
        this.head = trimChain(paddedHead);
        if (coordinatorSyncNeeded) {
            syncCoordinators();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r2 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void resetState$ui_release() {
        /*
            r12 = this;
            r0 = r12
            r1 = 0
            androidx.compose.ui.Modifier$Node r2 = r0.getTail$ui_release()
        L_0x0006:
            if (r2 == 0) goto L_0x001a
            r3 = r2
            r4 = 0
            boolean r5 = r3.isAttached()
            if (r5 == 0) goto L_0x0013
            r3.reset$ui_release()
        L_0x0013:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0006
        L_0x001a:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r0 = r12.current
            if (r0 == 0) goto L_0x004c
            r1 = 0
            r2 = r0
            r3 = 0
            int r4 = r2.getSize()
            if (r4 <= 0) goto L_0x0049
            r5 = 0
            java.lang.Object[] r6 = r2.getContent()
        L_0x002e:
            r7 = r6[r5]
            androidx.compose.ui.Modifier$Element r7 = (androidx.compose.ui.Modifier.Element) r7
            r8 = r5
            r9 = 0
            boolean r10 = r7 instanceof androidx.compose.ui.input.pointer.SuspendPointerInputElement
            if (r10 == 0) goto L_0x0043
            androidx.compose.ui.node.ForceUpdateElement r10 = new androidx.compose.ui.node.ForceUpdateElement
            r11 = r7
            androidx.compose.ui.node.ModifierNodeElement r11 = (androidx.compose.ui.node.ModifierNodeElement) r11
            r10.<init>(r11)
            r0.set(r8, r10)
        L_0x0043:
            int r5 = r5 + 1
            if (r5 < r4) goto L_0x002e
        L_0x0049:
        L_0x004c:
            r12.runDetachLifecycle$ui_release()
            r12.markAsDetached$ui_release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.resetState$ui_release():void");
    }

    public final void syncCoordinators() {
        LayoutModifierNodeCoordinator c;
        NodeCoordinator coordinator = this.innerCoordinator;
        for (Modifier.Node node = this.tail.getParent$ui_release(); node != null; node = node.getParent$ui_release()) {
            LayoutModifierNode layoutmod = DelegatableNodeKt.asLayoutModifierNode(node);
            if (layoutmod != null) {
                if (node.getCoordinator$ui_release() != null) {
                    NodeCoordinator coordinator$ui_release = node.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    c = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode prevNode = c.getLayoutModifierNode();
                    c.setLayoutModifierNode$ui_release(layoutmod);
                    if (prevNode != node) {
                        c.onLayoutModifierNodeChanged();
                    }
                } else {
                    c = new LayoutModifierNodeCoordinator(this.layoutNode, layoutmod);
                    node.updateCoordinator$ui_release(c);
                }
                coordinator.setWrappedBy$ui_release(c);
                c.setWrapped$ui_release(coordinator);
                coordinator = c;
            } else {
                node.updateCoordinator$ui_release(coordinator);
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = coordinator;
    }

    private final void syncAggregateChildKindSet() {
        Modifier.Node node = this.tail.getParent$ui_release();
        int aggregateChildKindSet = 0;
        while (node != null && node != NodeChainKt.SentinelHead) {
            aggregateChildKindSet |= node.getKindSet$ui_release();
            node.setAggregateChildKindSet$ui_release(aggregateChildKindSet);
            node = node.getParent$ui_release();
        }
    }

    public final void markAsAttached() {
        for (Modifier.Node node$iv = getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            node$iv.markAsAttached$ui_release();
        }
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node node$iv = getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            Modifier.Node it = node$iv;
            it.runAttachLifecycle$ui_release();
            if (it.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
                NodeKindKt.autoInvalidateInsertedNode(it);
            }
            if (it.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
                NodeKindKt.autoInvalidateUpdatedNode(it);
            }
            it.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            it.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        NodeChain nodeChain = this;
        MutableVector current2 = nodeChain.current;
        if (current2 == null) {
            return CollectionsKt.emptyList();
        }
        MutableVector infoList = new MutableVector(new ModifierInfo[current2.getSize()], 0);
        int i = 0;
        Modifier.Node node$iv = getHead$ui_release();
        while (node$iv != null && node$iv != getTail$ui_release()) {
            Modifier.Node node = node$iv;
            NodeCoordinator coordinator = node.getCoordinator$ui_release();
            if (coordinator != null) {
                OwnedLayer currentNodeLayer = coordinator.getLayer();
                OwnedLayer innerNodeLayer = nodeChain.innerCoordinator.getLayer();
                OwnedLayer ownedLayer = innerNodeLayer;
                Modifier.Node localChild = node.getChild$ui_release();
                if (!(localChild == nodeChain.tail && node.getCoordinator$ui_release() != localChild.getCoordinator$ui_release())) {
                    innerNodeLayer = null;
                }
                infoList.add(new ModifierInfo((Modifier) current2.getContent()[i], coordinator, currentNodeLayer == null ? innerNodeLayer : currentNodeLayer));
                node$iv = node$iv.getChild$ui_release();
                nodeChain = this;
                i++;
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return infoList.asMutableList();
    }

    public final void markAsDetached$ui_release() {
        for (Modifier.Node node$iv = getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
            Modifier.Node it = node$iv;
            if (it.isAttached()) {
                it.markAsDetached$ui_release();
            }
        }
    }

    public final void runDetachLifecycle$ui_release() {
        for (Modifier.Node node$iv = getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
            Modifier.Node it = node$iv;
            if (it.isAttached()) {
                it.runDetachLifecycle$ui_release();
            }
        }
    }

    private final Differ getDiffer(Modifier.Node head2, int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
        Differ current2 = this.cachedDiffer;
        if (current2 == null) {
            Differ it = new Differ(this, head2, offset, before, after, shouldAttachOnInsert);
            this.cachedDiffer = it;
            return it;
        }
        Differ it2 = current2;
        it2.setNode(head2);
        it2.setOffset(offset);
        it2.setBefore(before);
        it2.setAfter(after);
        it2.setShouldAttachOnInsert(shouldAttachOnInsert);
        return current2;
    }

    /* access modifiers changed from: private */
    public final void propagateCoordinator(Modifier.Node start, NodeCoordinator coordinator) {
        Modifier.Node node = start.getParent$ui_release();
        while (node != null) {
            if (node == NodeChainKt.SentinelHead) {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
                this.outerCoordinator = coordinator;
                return;
            }
            if (!((node.getKindSet$ui_release() & NodeKind.m6666constructorimpl(2)) != 0)) {
                node.updateCoordinator$ui_release(coordinator);
                node = node.getParent$ui_release();
            } else {
                return;
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "offset", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "shouldAttachOnInsert", "", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeChain.kt */
    private final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;
        final /* synthetic */ NodeChain this$0;

        public Differ(NodeChain this$02, Modifier.Node node2, int offset2, MutableVector<Modifier.Element> before2, MutableVector<Modifier.Element> after2, boolean shouldAttachOnInsert2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            Intrinsics.checkNotNullParameter(before2, "before");
            Intrinsics.checkNotNullParameter(after2, "after");
            this.this$0 = this$02;
            this.node = node2;
            this.offset = offset2;
            this.before = before2;
            this.after = after2;
            this.shouldAttachOnInsert = shouldAttachOnInsert2;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node2) {
            Intrinsics.checkNotNullParameter(node2, "<set-?>");
            this.node = node2;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.after = mutableVector;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        public final void setShouldAttachOnInsert(boolean z) {
            this.shouldAttachOnInsert = z;
        }

        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            return NodeChainKt.actionForModifiers((Modifier.Element) this.before.getContent()[this.offset + oldIndex], (Modifier.Element) this.after.getContent()[this.offset + newIndex]) != 0;
        }

        public void insert(int newIndex) {
            int index = this.offset + newIndex;
            Modifier.Node parent = this.node;
            this.node = this.this$0.createAndInsertNodeAsChild((Modifier.Element) this.after.getContent()[index], parent);
            Logger access$getLogger$p = this.this$0.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeInserted(index, index, (Modifier.Element) this.after.getContent()[index], parent, this.node);
            }
            if (this.shouldAttachOnInsert) {
                Modifier.Node child$ui_release = this.node.getChild$ui_release();
                Intrinsics.checkNotNull(child$ui_release);
                NodeCoordinator childCoordinator = child$ui_release.getCoordinator$ui_release();
                Intrinsics.checkNotNull(childCoordinator);
                LayoutModifierNode layoutmod = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (layoutmod != null) {
                    LayoutModifierNodeCoordinator thisCoordinator = new LayoutModifierNodeCoordinator(this.this$0.getLayoutNode(), layoutmod);
                    this.node.updateCoordinator$ui_release(thisCoordinator);
                    this.this$0.propagateCoordinator(this.node, thisCoordinator);
                    thisCoordinator.setWrappedBy$ui_release(childCoordinator.getWrappedBy$ui_release());
                    thisCoordinator.setWrapped$ui_release(childCoordinator);
                    childCoordinator.setWrappedBy$ui_release(thisCoordinator);
                } else {
                    this.node.updateCoordinator$ui_release(childCoordinator);
                }
                this.node.markAsAttached$ui_release();
                this.node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }
            this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        }

        public void remove(int atIndex, int oldIndex) {
            Modifier.Node toRemove = this.node.getChild$ui_release();
            Intrinsics.checkNotNull(toRemove);
            Logger access$getLogger$p = this.this$0.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeRemoved(oldIndex, (Modifier.Element) this.before.getContent()[this.offset + oldIndex], toRemove);
            }
            if ((toRemove.getKindSet$ui_release() & NodeKind.m6666constructorimpl(2)) != 0) {
                NodeCoordinator removedCoordinator = toRemove.getCoordinator$ui_release();
                Intrinsics.checkNotNull(removedCoordinator);
                NodeCoordinator parentCoordinator = removedCoordinator.getWrappedBy$ui_release();
                NodeCoordinator childCoordinator = removedCoordinator.getWrapped$ui_release();
                Intrinsics.checkNotNull(childCoordinator);
                if (parentCoordinator != null) {
                    parentCoordinator.setWrapped$ui_release(childCoordinator);
                }
                childCoordinator.setWrappedBy$ui_release(parentCoordinator);
                this.this$0.propagateCoordinator(this.node, childCoordinator);
            }
            this.node = this.this$0.detachAndRemoveNode(toRemove);
        }

        public void same(int oldIndex, int newIndex) {
            Modifier.Node child$ui_release = this.node.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            this.node = child$ui_release;
            Modifier.Element prev = (Modifier.Element) this.before.getContent()[this.offset + oldIndex];
            Modifier.Element next = (Modifier.Element) this.after.getContent()[this.offset + newIndex];
            if (!Intrinsics.areEqual((Object) prev, (Object) next)) {
                this.this$0.updateNode(prev, next, this.node);
                Logger access$getLogger$p = this.this$0.logger;
                if (access$getLogger$p != null) {
                    int i = this.offset;
                    int i2 = i + newIndex;
                    access$getLogger$p.nodeUpdated(i + oldIndex, i2, prev, next, this.node);
                    return;
                }
                return;
            }
            Logger access$getLogger$p2 = this.this$0.logger;
            if (access$getLogger$p2 != null) {
                int i3 = this.offset;
                int i4 = i3 + newIndex;
                access$getLogger$p2.nodeReused(i3 + oldIndex, i4, prev, next, this.node);
            }
        }
    }

    private final void structuralUpdate(int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, Modifier.Node tail2, boolean shouldAttachOnInsert) {
        MyersDiffKt.executeDiff(before.getSize() - offset, after.getSize() - offset, getDiffer(tail2, offset, before, after, shouldAttachOnInsert));
        syncAggregateChildKindSet();
    }

    /* access modifiers changed from: private */
    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child = node.getChild$ui_release();
        Modifier.Node parent = node.getParent$ui_release();
        if (child != null) {
            child.setParent$ui_release(parent);
            node.setChild$ui_release((Modifier.Node) null);
        }
        if (parent != null) {
            parent.setChild$ui_release(child);
            node.setParent$ui_release((Modifier.Node) null);
        }
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    private final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node child) {
        Modifier.Node node;
        if (element instanceof ModifierNodeElement) {
            node = ((ModifierNodeElement) element).create();
            Modifier.Node it = node;
            it.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(it));
        } else {
            node = new BackwardsCompatNode(element);
        }
        if (!node.isAttached()) {
            node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
            return insertParent(node, child);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node child) {
        Modifier.Node theParent = child.getParent$ui_release();
        if (theParent != null) {
            theParent.setChild$ui_release(node);
            node.setParent$ui_release(theParent);
        }
        child.setParent$ui_release(node);
        node.setChild$ui_release(child);
        return node;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node parent) {
        Modifier.Node node;
        if (element instanceof ModifierNodeElement) {
            node = ((ModifierNodeElement) element).create();
            Modifier.Node it = node;
            it.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(it));
        } else {
            node = new BackwardsCompatNode(element);
        }
        if (!node.isAttached()) {
            node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
            return insertChild(node, parent);
        }
        throw new IllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ".toString());
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node parent) {
        Modifier.Node theChild = parent.getChild$ui_release();
        if (theChild != null) {
            theChild.setParent$ui_release(node);
            node.setChild$ui_release(theChild);
        }
        parent.setChild$ui_release(node);
        node.setParent$ui_release(parent);
        return node;
    }

    /* access modifiers changed from: private */
    public final void updateNode(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            }
        } else if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(next);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            }
        } else {
            throw new IllegalStateException("Unknown Modifier.Node type".toString());
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m6615firstFromHeadaLcG6gQ$ui_release(int type, Function1<? super T, Boolean> block) {
        int $i$f$headToTail$ui_release;
        NodeChain this_$iv$iv;
        int i;
        NodeChain this_$iv;
        Function1<? super T, Boolean> function1;
        int $i$f$headToTail$ui_release2;
        NodeChain this_$iv$iv2;
        int i2;
        NodeChain this_$iv2;
        int i3;
        int $i$f$headToTail$ui_release3;
        NodeChain this_$iv$iv3;
        int $i$f$headToTail$ui_release4;
        NodeChain this_$iv$iv4;
        DelegatingNode this_$iv$iv$iv;
        int count$iv$iv;
        Function1<? super T, Boolean> function12 = block;
        Intrinsics.checkNotNullParameter(function12, "block");
        int i4 = 0;
        NodeChain this_$iv3 = this;
        int i5 = false;
        int mask$iv$iv = type;
        NodeChain this_$iv$iv5 = this_$iv3;
        int $i$f$headToTail$ui_release5 = false;
        if ((this_$iv$iv5.getAggregateChildKindSet() & mask$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv5.getHead$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node node = node$iv$iv$iv;
                if ((node.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    Object stack$iv$iv = null;
                    i3 = i4;
                    Object node$iv$iv = node;
                    while (node$iv$iv != null) {
                        NodeChain this_$iv4 = this_$iv;
                        int i6 = i;
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node$iv$iv instanceof Object) {
                            Object it = node$iv$iv;
                            if (function1.invoke(it).booleanValue()) {
                                return it;
                            }
                            this_$iv$iv3 = this_$iv$iv;
                            $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                        } else {
                            if (!((((Modifier.Node) node$iv$iv).getKindSet$ui_release() & type) != 0) || !(node$iv$iv instanceof DelegatingNode)) {
                                this_$iv$iv3 = this_$iv$iv;
                                $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node$iv$iv;
                                Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv$iv2 != null) {
                                    Object next$iv$iv = node$iv$iv$iv2;
                                    if ((next$iv$iv.getKindSet$ui_release() & type) != 0) {
                                        count$iv$iv2++;
                                        this_$iv$iv$iv = this_$iv$iv$iv2;
                                        if (count$iv$iv2 == 1) {
                                            node$iv$iv = next$iv$iv;
                                            this_$iv$iv4 = this_$iv$iv;
                                            $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                        } else {
                                            Object obj = (MutableVector) stack$iv$iv;
                                            if (obj == null) {
                                                count$iv$iv = count$iv$iv2;
                                                this_$iv$iv4 = this_$iv$iv;
                                                $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                                obj = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector = (MutableVector) obj;
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                this_$iv$iv4 = this_$iv$iv;
                                                $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                            }
                                            stack$iv$iv = obj;
                                            Modifier.Node theNode$iv$iv = (Modifier.Node) node$iv$iv;
                                            if (theNode$iv$iv != null) {
                                                MutableVector mutableVector2 = (MutableVector) stack$iv$iv;
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv$iv);
                                                }
                                                node$iv$iv = null;
                                            }
                                            MutableVector mutableVector3 = (MutableVector) stack$iv$iv;
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv$iv);
                                            }
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    } else {
                                        this_$iv$iv$iv = this_$iv$iv$iv2;
                                        this_$iv$iv4 = this_$iv$iv;
                                        $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                    }
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                                    this_$iv$iv = this_$iv$iv4;
                                    $i$f$headToTail$ui_release = $i$f$headToTail$ui_release4;
                                }
                                this_$iv$iv3 = this_$iv$iv;
                                $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                                if (count$iv$iv2 == 1) {
                                    function1 = block;
                                    this_$iv = this_$iv4;
                                    i = i6;
                                    this_$iv$iv = this_$iv$iv3;
                                    $i$f$headToTail$ui_release = $i$f$headToTail$ui_release3;
                                }
                            }
                        }
                        node$iv$iv = DelegatableNodeKt.pop((MutableVector) stack$iv$iv);
                        function1 = block;
                        this_$iv = this_$iv4;
                        i = i6;
                        this_$iv$iv = this_$iv$iv3;
                        $i$f$headToTail$ui_release = $i$f$headToTail$ui_release3;
                    }
                    this_$iv2 = this_$iv;
                    i2 = i;
                    this_$iv$iv2 = this_$iv$iv;
                    $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release;
                } else {
                    i3 = i4;
                    this_$iv2 = this_$iv;
                    i2 = i;
                    this_$iv$iv2 = this_$iv$iv;
                    $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release;
                }
                if ((node.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                    return null;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                function12 = block;
                i4 = i3;
                this_$iv3 = this_$iv2;
                i5 = i2;
                this_$iv$iv5 = this_$iv$iv2;
                $i$f$headToTail$ui_release5 = $i$f$headToTail$ui_release2;
            }
            int i7 = i4;
            NodeChain nodeChain = this_$iv;
            int i8 = i;
            NodeChain nodeChain2 = this_$iv$iv;
            int i9 = $i$f$headToTail$ui_release;
            return null;
        }
        NodeChain nodeChain3 = this_$iv3;
        NodeChain nodeChain4 = this_$iv$iv5;
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m6618headToTailaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        NodeChain this_$iv$iv;
        int $i$f$headToTail$ui_release;
        NodeChain this_$iv;
        int count$iv;
        Function1<? super T, Unit> function1;
        NodeChain this_$iv$iv2;
        int $i$f$headToTail$ui_release2;
        NodeChain this_$iv2;
        int i;
        NodeChain this_$iv$iv3;
        int $i$f$headToTail$ui_release3;
        NodeChain this_$iv$iv4;
        int $i$f$headToTail$ui_release4;
        DelegatingNode this_$iv$iv5;
        int count$iv2;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv3 = 0;
        int mask$iv = type;
        NodeChain this_$iv3 = this;
        int $i$f$headToTail$ui_release5 = false;
        if ((this_$iv3.getAggregateChildKindSet() & mask$iv) != 0) {
            NodeChain this_$iv$iv6 = this_$iv3;
            Modifier.Node node$iv$iv = this_$iv$iv6.getHead$ui_release();
            while (node$iv$iv != null) {
                Modifier.Node it$iv = node$iv$iv;
                if ((it$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Object stack$iv = null;
                    Object node$iv = it$iv;
                    while (node$iv != null) {
                        int i2 = count$iv;
                        NodeChain this_$iv4 = this_$iv;
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node$iv instanceof Object) {
                            function1.invoke(node$iv);
                            $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                            this_$iv$iv3 = this_$iv$iv;
                        } else {
                            if (!((((Modifier.Node) node$iv).getKindSet$ui_release() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                                $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                                this_$iv$iv3 = this_$iv$iv;
                            } else {
                                int count$iv4 = 0;
                                DelegatingNode this_$iv$iv7 = (DelegatingNode) node$iv;
                                Modifier.Node node$iv$iv2 = this_$iv$iv7.getDelegate$ui_release();
                                while (node$iv$iv2 != null) {
                                    Object next$iv = node$iv$iv2;
                                    if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                        count$iv4++;
                                        this_$iv$iv5 = this_$iv$iv7;
                                        if (count$iv4 == 1) {
                                            node$iv = next$iv;
                                            $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                            this_$iv$iv4 = this_$iv$iv;
                                        } else {
                                            Object obj = (MutableVector) stack$iv;
                                            if (obj == null) {
                                                count$iv2 = count$iv4;
                                                $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                                this_$iv$iv4 = this_$iv$iv;
                                                obj = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector = (MutableVector) obj;
                                            } else {
                                                count$iv2 = count$iv4;
                                                $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                                this_$iv$iv4 = this_$iv$iv;
                                            }
                                            stack$iv = obj;
                                            Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                            if (theNode$iv != null) {
                                                MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv);
                                                }
                                                node$iv = null;
                                            }
                                            MutableVector mutableVector3 = (MutableVector) stack$iv;
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv);
                                            }
                                            count$iv4 = count$iv2;
                                        }
                                    } else {
                                        this_$iv$iv5 = this_$iv$iv7;
                                        $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                        this_$iv$iv4 = this_$iv$iv;
                                    }
                                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                                    this_$iv$iv7 = this_$iv$iv5;
                                    $i$f$headToTail$ui_release = $i$f$headToTail$ui_release4;
                                    this_$iv$iv = this_$iv$iv4;
                                }
                                $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                                this_$iv$iv3 = this_$iv$iv;
                                if (count$iv4 == 1) {
                                    function1 = block;
                                    count$iv = i2;
                                    this_$iv = this_$iv4;
                                    $i$f$headToTail$ui_release = $i$f$headToTail$ui_release3;
                                    this_$iv$iv = this_$iv$iv3;
                                }
                            }
                        }
                        node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
                        function1 = block;
                        count$iv = i2;
                        this_$iv = this_$iv4;
                        $i$f$headToTail$ui_release = $i$f$headToTail$ui_release3;
                        this_$iv$iv = this_$iv$iv3;
                    }
                    i = count$iv;
                    this_$iv2 = this_$iv;
                    $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release;
                    this_$iv$iv2 = this_$iv$iv;
                } else {
                    i = count$iv;
                    this_$iv2 = this_$iv;
                    $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release;
                    this_$iv$iv2 = this_$iv$iv;
                }
                if ((it$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    function12 = block;
                    count$iv3 = i;
                    this_$iv3 = this_$iv2;
                    $i$f$headToTail$ui_release5 = $i$f$headToTail$ui_release2;
                    this_$iv$iv6 = this_$iv$iv2;
                } else {
                    return;
                }
            }
            int i3 = count$iv;
            NodeChain nodeChain = this_$iv;
            int i4 = $i$f$headToTail$ui_release;
            NodeChain nodeChain2 = this_$iv$iv;
            return;
        }
        NodeChain nodeChain3 = this_$iv3;
    }

    public final void headToTail$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) != 0) {
            Modifier.Node node$iv = getHead$ui_release();
            while (node$iv != null) {
                Modifier.Node it = node$iv;
                if ((it.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(it);
                }
                if ((it.getAggregateChildKindSet$ui_release() & mask) != 0) {
                    node$iv = node$iv.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getHead$ui_release(); node != null; node = node.getChild$ui_release()) {
            block.invoke(node);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node node = getHead$ui_release();
        while (node != null && node != getTail$ui_release()) {
            block.invoke(node);
            node = node.getChild$ui_release();
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m6620tailToHeadaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        int $i$f$tailToHead$ui_release;
        NodeChain this_$iv;
        int mask$iv;
        int count$iv;
        Function1<? super T, Unit> function1;
        int $i$f$tailToHead$ui_release2;
        NodeChain this_$iv2;
        int $i$f$tailToHead$ui_release3;
        NodeChain this_$iv3;
        DelegatingNode this_$iv$iv;
        int count$iv2;
        Function1<? super T, Unit> function12 = block;
        Intrinsics.checkNotNullParameter(function12, "block");
        int count$iv3 = 0;
        int mask$iv2 = type;
        NodeChain this_$iv4 = this;
        int $i$f$tailToHead$ui_release4 = false;
        if ((this_$iv4.getAggregateChildKindSet() & mask$iv2) != 0) {
            Modifier.Node node$iv$iv = this_$iv4.getTail$ui_release();
            while (node$iv$iv != null) {
                Modifier.Node it$iv = node$iv$iv;
                if ((it$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Object stack$iv = null;
                    Object node$iv = it$iv;
                    while (node$iv != null) {
                        int i = count$iv;
                        int mask$iv3 = mask$iv;
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node$iv instanceof Object) {
                            function1.invoke(node$iv);
                            this_$iv2 = this_$iv;
                            $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release;
                        } else {
                            if (!((((Modifier.Node) node$iv).getKindSet$ui_release() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                                this_$iv2 = this_$iv;
                                $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release;
                            } else {
                                int count$iv4 = 0;
                                DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv;
                                Modifier.Node node$iv$iv2 = this_$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv2 != null) {
                                    Object next$iv = node$iv$iv2;
                                    if ((next$iv.getKindSet$ui_release() & type) != 0) {
                                        count$iv4++;
                                        this_$iv$iv = this_$iv$iv2;
                                        if (count$iv4 == 1) {
                                            node$iv = next$iv;
                                            this_$iv3 = this_$iv;
                                            $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                        } else {
                                            Object obj = (MutableVector) stack$iv;
                                            if (obj == null) {
                                                count$iv2 = count$iv4;
                                                this_$iv3 = this_$iv;
                                                $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                                obj = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector = (MutableVector) obj;
                                            } else {
                                                count$iv2 = count$iv4;
                                                this_$iv3 = this_$iv;
                                                $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                            }
                                            stack$iv = obj;
                                            Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                            if (theNode$iv != null) {
                                                MutableVector mutableVector2 = (MutableVector) stack$iv;
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(theNode$iv);
                                                }
                                                node$iv = null;
                                            }
                                            MutableVector mutableVector3 = (MutableVector) stack$iv;
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv);
                                            }
                                            count$iv4 = count$iv2;
                                        }
                                    } else {
                                        this_$iv$iv = this_$iv$iv2;
                                        this_$iv3 = this_$iv;
                                        $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                    }
                                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                                    this_$iv$iv2 = this_$iv$iv;
                                    this_$iv = this_$iv3;
                                    $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release3;
                                }
                                this_$iv2 = this_$iv;
                                $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release;
                                if (count$iv4 == 1) {
                                    function1 = block;
                                    count$iv = i;
                                    mask$iv = mask$iv3;
                                    this_$iv = this_$iv2;
                                    $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release2;
                                }
                            }
                        }
                        node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
                        function1 = block;
                        count$iv = i;
                        mask$iv = mask$iv3;
                        this_$iv = this_$iv2;
                        $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release2;
                    }
                }
                node$iv$iv = node$iv$iv.getParent$ui_release();
                function12 = block;
                count$iv3 = count$iv;
                mask$iv2 = mask$iv;
                this_$iv4 = this_$iv;
                $i$f$tailToHead$ui_release4 = $i$f$tailToHead$ui_release;
            }
            int i2 = count$iv;
            int i3 = mask$iv;
            NodeChain nodeChain = this_$iv;
            int i4 = $i$f$tailToHead$ui_release;
            return;
        }
        int i5 = mask$iv2;
        NodeChain nodeChain2 = this_$iv4;
    }

    public final void tailToHead$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) != 0) {
            for (Modifier.Node node$iv = getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
                Modifier.Node it = node$iv;
                if ((it.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(it);
                }
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getTail$ui_release(); node != null; node = node.getParent$ui_release()) {
            block.invoke(node);
        }
    }

    /* renamed from: tail-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m6619tailH91voCI$ui_release(int type) {
        int $i$f$tailToHead$ui_release;
        NodeChain this_$iv$iv;
        int mask$iv$iv;
        int count$iv$iv;
        NodeChain this_$iv;
        int i;
        int $i$f$tailToHead$ui_release2;
        NodeChain this_$iv$iv2;
        int mask$iv$iv2;
        int $i$f$tailToHead$ui_release3;
        NodeChain this_$iv$iv3;
        int mask$iv$iv3;
        int count$iv$iv2;
        int i2 = 0;
        NodeChain this_$iv2 = this;
        int count$iv$iv3 = false;
        int mask$iv$iv4 = type;
        NodeChain this_$iv$iv4 = this_$iv2;
        int $i$f$tailToHead$ui_release4 = false;
        if ((this_$iv$iv4.getAggregateChildKindSet() & mask$iv$iv4) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv4.getTail$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node node = node$iv$iv$iv;
                if ((node.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    Object stack$iv$iv = null;
                    i = i2;
                    Object node$iv$iv = node;
                    while (node$iv$iv != null) {
                        NodeChain this_$iv3 = this_$iv;
                        int i3 = count$iv$iv;
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node$iv$iv instanceof Object) {
                            return node$iv$iv;
                        }
                        Modifier.Node this_$iv$iv$iv = (Modifier.Node) node$iv$iv;
                        Modifier.Node node2 = this_$iv$iv$iv;
                        if (((this_$iv$iv$iv.getKindSet$ui_release() & type) != 0 ? 1 : 0) == 0 || !(node$iv$iv instanceof DelegatingNode)) {
                            mask$iv$iv2 = mask$iv$iv;
                            this_$iv$iv2 = this_$iv$iv;
                            $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release;
                        } else {
                            int count$iv$iv4 = 0;
                            Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) node$iv$iv).getDelegate$ui_release();
                            while (node$iv$iv$iv2 != null) {
                                Object next$iv$iv = node$iv$iv$iv2;
                                if ((next$iv$iv.getKindSet$ui_release() & type) != 0) {
                                    count$iv$iv4++;
                                    mask$iv$iv3 = mask$iv$iv;
                                    if (count$iv$iv4 == 1) {
                                        node$iv$iv = next$iv$iv;
                                        this_$iv$iv3 = this_$iv$iv;
                                        $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                    } else {
                                        Object obj = (MutableVector) stack$iv$iv;
                                        if (obj == null) {
                                            count$iv$iv2 = count$iv$iv4;
                                            this_$iv$iv3 = this_$iv$iv;
                                            $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                            obj = new MutableVector(new Modifier.Node[16], 0);
                                            MutableVector mutableVector = (MutableVector) obj;
                                        } else {
                                            count$iv$iv2 = count$iv$iv4;
                                            this_$iv$iv3 = this_$iv$iv;
                                            $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                        }
                                        stack$iv$iv = obj;
                                        Modifier.Node theNode$iv$iv = (Modifier.Node) node$iv$iv;
                                        if (theNode$iv$iv != null) {
                                            MutableVector mutableVector2 = (MutableVector) stack$iv$iv;
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(theNode$iv$iv);
                                            }
                                            node$iv$iv = null;
                                        }
                                        MutableVector mutableVector3 = (MutableVector) stack$iv$iv;
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(next$iv$iv);
                                        }
                                        count$iv$iv4 = count$iv$iv2;
                                    }
                                } else {
                                    mask$iv$iv3 = mask$iv$iv;
                                    this_$iv$iv3 = this_$iv$iv;
                                    $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                mask$iv$iv = mask$iv$iv3;
                                this_$iv$iv = this_$iv$iv3;
                                $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release3;
                            }
                            mask$iv$iv2 = mask$iv$iv;
                            this_$iv$iv2 = this_$iv$iv;
                            $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release;
                            if (count$iv$iv4 == 1) {
                                this_$iv = this_$iv3;
                                count$iv$iv = i3;
                                mask$iv$iv = mask$iv$iv2;
                                this_$iv$iv = this_$iv$iv2;
                                $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release2;
                            }
                        }
                        node$iv$iv = DelegatableNodeKt.pop((MutableVector) stack$iv$iv);
                        this_$iv = this_$iv3;
                        count$iv$iv = i3;
                        mask$iv$iv = mask$iv$iv2;
                        this_$iv$iv = this_$iv$iv2;
                        $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release2;
                    }
                    continue;
                } else {
                    i = i2;
                }
                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                i2 = i;
                this_$iv2 = this_$iv;
                count$iv$iv3 = count$iv$iv;
                mask$iv$iv4 = mask$iv$iv;
                this_$iv$iv4 = this_$iv$iv;
                $i$f$tailToHead$ui_release4 = $i$f$tailToHead$ui_release;
            }
            int i4 = i2;
            NodeChain nodeChain = this_$iv;
            int i5 = count$iv$iv;
            int i6 = mask$iv$iv;
            NodeChain nodeChain2 = this_$iv$iv;
            int i7 = $i$f$tailToHead$ui_release;
            return null;
        }
        NodeChain nodeChain3 = this_$iv2;
        int i8 = mask$iv$iv4;
        NodeChain nodeChain4 = this_$iv$iv4;
        return null;
    }

    /* renamed from: head-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m6617headH91voCI$ui_release(int type) {
        NodeChain this_$iv$iv$iv;
        int $i$f$headToTail$ui_release;
        NodeChain this_$iv$iv;
        int count$iv$iv;
        NodeChain this_$iv;
        NodeChain this_$iv$iv$iv2;
        int $i$f$headToTail$ui_release2;
        NodeChain this_$iv$iv2;
        int i;
        NodeChain this_$iv2;
        int i2;
        NodeChain this_$iv$iv$iv3;
        int $i$f$headToTail$ui_release3;
        NodeChain this_$iv$iv3;
        NodeChain this_$iv$iv$iv4;
        int $i$f$headToTail$ui_release4;
        NodeChain this_$iv$iv4;
        int count$iv$iv2;
        int i3 = 0;
        NodeChain this_$iv3 = this;
        int count$iv$iv3 = false;
        int mask$iv$iv = type;
        NodeChain this_$iv$iv5 = this_$iv3;
        int $i$f$headToTail$ui_release5 = false;
        if ((this_$iv$iv5.getAggregateChildKindSet() & mask$iv$iv) != 0) {
            NodeChain this_$iv$iv$iv5 = this_$iv$iv5;
            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv5.getHead$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node node = node$iv$iv$iv;
                if ((node.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    Object stack$iv$iv = null;
                    i2 = i3;
                    Object node$iv$iv = node;
                    while (node$iv$iv != null) {
                        NodeChain this_$iv4 = this_$iv;
                        int i4 = count$iv$iv;
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node$iv$iv instanceof Object) {
                            return node$iv$iv;
                        }
                        Modifier.Node this_$iv$iv$iv6 = (Modifier.Node) node$iv$iv;
                        Modifier.Node node2 = this_$iv$iv$iv6;
                        if (((this_$iv$iv$iv6.getKindSet$ui_release() & type) != 0 ? 1 : 0) == 0 || !(node$iv$iv instanceof DelegatingNode)) {
                            this_$iv$iv3 = this_$iv$iv;
                            $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                            this_$iv$iv$iv3 = this_$iv$iv$iv;
                        } else {
                            int count$iv$iv4 = 0;
                            Modifier.Node node$iv$iv$iv2 = ((DelegatingNode) node$iv$iv).getDelegate$ui_release();
                            while (node$iv$iv$iv2 != null) {
                                Object next$iv$iv = node$iv$iv$iv2;
                                if ((next$iv$iv.getKindSet$ui_release() & type) != 0) {
                                    count$iv$iv4++;
                                    this_$iv$iv4 = this_$iv$iv;
                                    if (count$iv$iv4 == 1) {
                                        node$iv$iv = next$iv$iv;
                                        $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                        this_$iv$iv$iv4 = this_$iv$iv$iv;
                                    } else {
                                        Object obj = (MutableVector) stack$iv$iv;
                                        if (obj == null) {
                                            count$iv$iv2 = count$iv$iv4;
                                            $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                            this_$iv$iv$iv4 = this_$iv$iv$iv;
                                            obj = new MutableVector(new Modifier.Node[16], 0);
                                            MutableVector mutableVector = (MutableVector) obj;
                                        } else {
                                            count$iv$iv2 = count$iv$iv4;
                                            $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                            this_$iv$iv$iv4 = this_$iv$iv$iv;
                                        }
                                        stack$iv$iv = obj;
                                        Modifier.Node theNode$iv$iv = (Modifier.Node) node$iv$iv;
                                        if (theNode$iv$iv != null) {
                                            MutableVector mutableVector2 = (MutableVector) stack$iv$iv;
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(theNode$iv$iv);
                                            }
                                            node$iv$iv = null;
                                        }
                                        MutableVector mutableVector3 = (MutableVector) stack$iv$iv;
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(next$iv$iv);
                                        }
                                        count$iv$iv4 = count$iv$iv2;
                                    }
                                } else {
                                    this_$iv$iv4 = this_$iv$iv;
                                    $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
                                    this_$iv$iv$iv4 = this_$iv$iv$iv;
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                this_$iv$iv = this_$iv$iv4;
                                $i$f$headToTail$ui_release = $i$f$headToTail$ui_release4;
                                this_$iv$iv$iv = this_$iv$iv$iv4;
                            }
                            this_$iv$iv3 = this_$iv$iv;
                            $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release;
                            this_$iv$iv$iv3 = this_$iv$iv$iv;
                            if (count$iv$iv4 == 1) {
                                this_$iv = this_$iv4;
                                count$iv$iv = i4;
                                this_$iv$iv = this_$iv$iv3;
                                $i$f$headToTail$ui_release = $i$f$headToTail$ui_release3;
                                this_$iv$iv$iv = this_$iv$iv$iv3;
                            }
                        }
                        node$iv$iv = DelegatableNodeKt.pop((MutableVector) stack$iv$iv);
                        this_$iv = this_$iv4;
                        count$iv$iv = i4;
                        this_$iv$iv = this_$iv$iv3;
                        $i$f$headToTail$ui_release = $i$f$headToTail$ui_release3;
                        this_$iv$iv$iv = this_$iv$iv$iv3;
                    }
                    this_$iv2 = this_$iv;
                    i = count$iv$iv;
                    this_$iv$iv2 = this_$iv$iv;
                    $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                } else {
                    i2 = i3;
                    this_$iv2 = this_$iv;
                    i = count$iv$iv;
                    this_$iv$iv2 = this_$iv$iv;
                    $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                }
                if ((node.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                    return null;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                i3 = i2;
                this_$iv3 = this_$iv2;
                count$iv$iv3 = i;
                this_$iv$iv5 = this_$iv$iv2;
                $i$f$headToTail$ui_release5 = $i$f$headToTail$ui_release2;
                this_$iv$iv$iv5 = this_$iv$iv$iv2;
            }
            int i5 = i3;
            NodeChain nodeChain = this_$iv;
            int i6 = count$iv$iv;
            NodeChain nodeChain2 = this_$iv$iv;
            int i7 = $i$f$headToTail$ui_release;
            NodeChain nodeChain3 = this_$iv$iv$iv;
            return null;
        }
        NodeChain nodeChain4 = this_$iv3;
        NodeChain nodeChain5 = this_$iv$iv5;
        return null;
    }

    /* renamed from: has-H91voCI$ui_release  reason: not valid java name */
    public final boolean m6616hasH91voCI$ui_release(int type) {
        return (getAggregateChildKindSet() & type) != 0;
    }

    public final boolean has$ui_release(int mask) {
        return (getAggregateChildKindSet() & mask) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$toString_u24lambda_u2430 = sb;
        $this$toString_u24lambda_u2430.append("[");
        if (this.head != this.tail) {
            Modifier.Node node$iv = getHead$ui_release();
            while (true) {
                if (node$iv == null || node$iv == getTail$ui_release()) {
                    break;
                }
                Modifier.Node it = node$iv;
                $this$toString_u24lambda_u2430.append(String.valueOf(it));
                if (it.getChild$ui_release() == this.tail) {
                    $this$toString_u24lambda_u2430.append("]");
                    break;
                }
                $this$toString_u24lambda_u2430.append(",");
                node$iv = node$iv.getChild$ui_release();
            }
        } else {
            $this$toString_u24lambda_u2430.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
