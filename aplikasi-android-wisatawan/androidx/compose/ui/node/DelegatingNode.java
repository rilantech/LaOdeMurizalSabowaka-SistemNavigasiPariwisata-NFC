package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0004¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0000¢\u0006\u0004\b\u0012\u0010\u0010J%\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0016H\bø\u0001\u0000¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0014H\u0010¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000eH\u0004J\u0015\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b%J\u0017\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0010¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0001H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "T", "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "delegateUnprotected", "delegateUnprotected$ui_release", "forEachImmediateDelegate", "", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "undelegate", "instance", "undelegateUnprotected", "undelegateUnprotected$ui_release", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatingNode.kt */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom((Modifier.Node) this);

    public static /* synthetic */ void getSelfKindSet$ui_release$annotations() {
    }

    public final int getSelfKindSet$ui_release() {
        return this.selfKindSet;
    }

    public void updateCoordinator$ui_release(NodeCoordinator coordinator) {
        super.updateCoordinator$ui_release(coordinator);
        for (Modifier.Node node$iv = getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            node$iv.updateCoordinator$ui_release(coordinator);
        }
    }

    public final Modifier.Node getDelegate$ui_release() {
        return this.delegate;
    }

    public final void setDelegate$ui_release(Modifier.Node node) {
        this.delegate = node;
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui_release(T delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "delegatableNode");
        return delegate(delegatableNode);
    }

    public final void undelegateUnprotected$ui_release(DelegatableNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        undelegate(instance);
    }

    /* access modifiers changed from: protected */
    public final <T extends DelegatableNode> T delegate(T delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "delegatableNode");
        Modifier.Node delegateNode = delegatableNode.getNode();
        boolean isDelegatedToThisNode = true;
        Modifier.Node delegator = null;
        if (delegateNode != delegatableNode) {
            Modifier.Node node = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            if (node != null) {
                delegator = node.getParent$ui_release();
            }
            if (delegateNode != getNode() || !Intrinsics.areEqual((Object) delegator, (Object) this)) {
                isDelegatedToThisNode = false;
            }
            if (isDelegatedToThisNode) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        } else if (!delegateNode.isAttached()) {
            delegateNode.setAsDelegateTo$ui_release(getNode());
            int beforeKindSet = getKindSet$ui_release();
            int delegatedKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(delegateNode);
            delegateNode.setKindSet$ui_release(delegatedKindSet);
            validateDelegateKindSet(delegatedKindSet, delegateNode);
            delegateNode.setChild$ui_release(this.delegate);
            this.delegate = delegateNode;
            delegateNode.setParent$ui_release(this);
            updateNodeKindSet(getKindSet$ui_release() | delegatedKindSet, false);
            if (isAttached()) {
                if (((delegatedKindSet & NodeKind.m4956constructorimpl(2)) != 0 ? 1 : 0) != 0) {
                    if ((beforeKindSet & NodeKind.m4956constructorimpl(2)) == 0) {
                        isDelegatedToThisNode = false;
                    }
                    if (!isDelegatedToThisNode) {
                        NodeChain chain = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
                        getNode().updateCoordinator$ui_release((NodeCoordinator) null);
                        chain.syncCoordinators();
                        delegateNode.markAsAttached$ui_release();
                        delegateNode.runAttachLifecycle$ui_release();
                        NodeKindKt.autoInvalidateInsertedNode(delegateNode);
                    }
                }
                updateCoordinator$ui_release(getCoordinator$ui_release());
                delegateNode.markAsAttached$ui_release();
                delegateNode.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(delegateNode);
            }
            return delegatableNode;
        } else {
            throw new IllegalStateException("Cannot delegate to an already attached node".toString());
        }
    }

    /* access modifiers changed from: protected */
    public final void undelegate(DelegatableNode instance) {
        boolean z;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Modifier.Node prev = null;
        Modifier.Node it = this.delegate;
        boolean found = false;
        while (true) {
            z = false;
            if (it == null) {
                break;
            } else if (it == instance) {
                if (it.isAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(it);
                    it.runDetachLifecycle$ui_release();
                    it.markAsDetached$ui_release();
                }
                it.setAsDelegateTo$ui_release(it);
                it.setAggregateChildKindSet$ui_release(0);
                if (prev == null) {
                    this.delegate = it.getChild$ui_release();
                } else {
                    prev.setChild$ui_release(it.getChild$ui_release());
                }
                it.setChild$ui_release((Modifier.Node) null);
                it.setParent$ui_release((Modifier.Node) null);
                found = true;
            } else {
                prev = it;
                it = it.getChild$ui_release();
            }
        }
        if (found) {
            int beforeKindSet = getKindSet$ui_release();
            int afterKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
            updateNodeKindSet(afterKindSet, true);
            if (isAttached()) {
                if (((beforeKindSet & NodeKind.m4956constructorimpl(2)) != 0 ? 1 : 0) != 0) {
                    if ((afterKindSet & NodeKind.m4956constructorimpl(2)) != 0) {
                        z = true;
                    }
                    if (!z) {
                        NodeChain chain = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
                        getNode().updateCoordinator$ui_release((NodeCoordinator) null);
                        chain.syncCoordinators();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("Could not find delegate: " + instance).toString());
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int current = getKindSet$ui_release();
        boolean z = true;
        if (((delegateKindSet & NodeKind.m4956constructorimpl(2)) != 0 ? 1 : 0) != 0) {
            if ((current & NodeKind.m4956constructorimpl(2)) == 0) {
                z = false;
            }
            if (z && !(this instanceof LayoutModifierNode)) {
                throw new IllegalStateException(("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + delegateNode).toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r4 = r3.getChild$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateNodeKindSet(int r6, boolean r7) {
        /*
            r5 = this;
            int r0 = r5.getKindSet$ui_release()
            r5.setKindSet$ui_release(r6)
            if (r0 == r6) goto L_0x005d
            r1 = r6
            r2 = r5
            androidx.compose.ui.node.DelegatableNode r2 = (androidx.compose.ui.node.DelegatableNode) r2
            boolean r2 = androidx.compose.ui.node.DelegatableNodeKt.isDelegationRoot(r2)
            if (r2 == 0) goto L_0x0016
            r5.setAggregateChildKindSet$ui_release(r1)
        L_0x0016:
            boolean r2 = r5.isAttached()
            if (r2 == 0) goto L_0x005d
            androidx.compose.ui.Modifier$Node r2 = r5.getNode()
            r3 = r5
            androidx.compose.ui.Modifier$Node r3 = (androidx.compose.ui.Modifier.Node) r3
        L_0x0023:
            if (r3 == 0) goto L_0x0034
            int r4 = r3.getKindSet$ui_release()
            r1 = r1 | r4
            r3.setKindSet$ui_release(r1)
            if (r3 == r2) goto L_0x0034
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            goto L_0x0023
        L_0x0034:
            if (r7 == 0) goto L_0x003f
            if (r3 != r2) goto L_0x003f
            int r1 = androidx.compose.ui.node.NodeKindKt.calculateNodeKindSetFromIncludingDelegates(r2)
            r2.setKindSet$ui_release(r1)
        L_0x003f:
            if (r3 == 0) goto L_0x004c
            androidx.compose.ui.Modifier$Node r4 = r3.getChild$ui_release()
            if (r4 == 0) goto L_0x004c
            int r4 = r4.getAggregateChildKindSet$ui_release()
            goto L_0x004d
        L_0x004c:
            r4 = 0
        L_0x004d:
            r1 = r1 | r4
        L_0x004e:
            if (r3 == 0) goto L_0x005d
            int r4 = r3.getKindSet$ui_release()
            r1 = r1 | r4
            r3.setAggregateChildKindSet$ui_release(r1)
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            goto L_0x004e
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatingNode.updateNodeKindSet(int, boolean):void");
    }

    public final void forEachImmediateDelegate$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getDelegate$ui_release(); node != null; node = node.getChild$ui_release()) {
            block.invoke(node);
        }
    }

    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node node$iv = getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            Modifier.Node it = node$iv;
            it.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!it.isAttached()) {
                it.markAsAttached$ui_release();
            }
        }
    }

    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node node$iv = getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            node$iv.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node node$iv = getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            node$iv.runDetachLifecycle$ui_release();
        }
    }

    public void markAsDetached$ui_release() {
        for (Modifier.Node node$iv = getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            node$iv.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node node$iv = getDelegate$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            node$iv.reset$ui_release();
        }
    }
}
