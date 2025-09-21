package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalManager.kt */
public final class ModifierLocalManager {
    private final MutableVector<BackwardsCompatNode> inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
    private final MutableVector<ModifierLocal<?>> insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<LayoutNode> removed = new MutableVector<>(new LayoutNode[16], 0);
    private final MutableVector<ModifierLocal<?>> removedLocal = new MutableVector<>(new ModifierLocal[16], 0);

    public ModifierLocalManager(Owner owner2) {
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new ModifierLocalManager$invalidate$1(this));
        }
    }

    public final void triggerUpdates() {
        this.invalidated = false;
        HashSet<BackwardsCompatNode> toUpdate = new HashSet<>();
        MutableVector this_$iv = this.removed;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode layout = (LayoutNode) content$iv[i$iv];
                ModifierLocal key = (ModifierLocal) this.removedLocal.getContent()[i$iv];
                if (layout.getNodes$ui_release().getHead$ui_release().isAttached()) {
                    invalidateConsumersOfNodeForKey(layout.getNodes$ui_release().getHead$ui_release(), key, toUpdate);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector this_$iv2 = this.inserted;
        int size$iv2 = this_$iv2.getSize();
        if (size$iv2 > 0) {
            int i$iv2 = 0;
            Object[] content$iv2 = this_$iv2.getContent();
            do {
                BackwardsCompatNode node = (BackwardsCompatNode) content$iv2[i$iv2];
                ModifierLocal key2 = (ModifierLocal) this.insertedLocal.getContent()[i$iv2];
                if (node.isAttached()) {
                    invalidateConsumersOfNodeForKey(node, key2, toUpdate);
                }
                i$iv2++;
            } while (i$iv2 < size$iv2);
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        for (BackwardsCompatNode it : toUpdate) {
            it.updateModifierLocalConsumer();
        }
    }

    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> key, Set<BackwardsCompatNode> set) {
        int i;
        int type$iv;
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv;
        boolean z;
        ModifierLocal<?> modifierLocal;
        int type$iv2;
        int i2;
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv2;
        boolean z2;
        boolean diveDeeper$iv$iv;
        int type$iv3;
        boolean z3;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        ModifierLocal<?> modifierLocal2 = key;
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node;
        int type$iv5 = NodeKind.m4956constructorimpl(32);
        int i3 = 0;
        int mask$iv$iv = type$iv5;
        DelegatableNode $this$visitSubtreeIf$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv3;
        if ($this$visitSubtreeIf$iv$iv.getNode().isAttached()) {
            MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv$iv = $this$visitSubtreeIf$iv$iv.getNode().getChild$ui_release();
            if (child$iv$iv == null) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitSubtreeIf$iv$iv.getNode());
            } else {
                branches$iv$iv.add(child$iv$iv);
            }
            while (branches$iv$iv.isNotEmpty()) {
                boolean z4 = true;
                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            break;
                        }
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            MutableVector mutableVector2 = null;
                            DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv4 = node$iv$iv;
                            while (true) {
                                if ($this$visitSubtreeIf_u2d6rFNWt0$iv4 == null) {
                                    $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                                    type$iv2 = type$iv;
                                    i2 = i;
                                    z2 = z;
                                    diveDeeper$iv$iv = z2;
                                    break;
                                }
                                if ($this$visitSubtreeIf_u2d6rFNWt0$iv4 instanceof ModifierLocalModifierNode) {
                                    $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                                    ModifierLocalModifierNode it = (ModifierLocalModifierNode) $this$visitSubtreeIf_u2d6rFNWt0$iv4;
                                    i2 = i;
                                    if ((it instanceof BackwardsCompatNode) == 0 || !(((BackwardsCompatNode) it).getElement() instanceof ModifierLocalConsumer)) {
                                        Set<BackwardsCompatNode> set2 = set;
                                    } else if (((BackwardsCompatNode) it).getReadValues().contains(modifierLocal)) {
                                        set.add(it);
                                    } else {
                                        Set<BackwardsCompatNode> set3 = set;
                                    }
                                    if (!(!it.getProvidedValues().contains$ui_release(modifierLocal))) {
                                        type$iv2 = type$iv;
                                        z2 = true;
                                        diveDeeper$iv$iv = false;
                                        break;
                                    }
                                    type$iv3 = type$iv;
                                    z3 = true;
                                } else {
                                    $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                                    i2 = i;
                                    if (!(($this$visitSubtreeIf_u2d6rFNWt0$iv4.getKindSet$ui_release() & type$iv) != 0) || !($this$visitSubtreeIf_u2d6rFNWt0$iv4 instanceof DelegatingNode)) {
                                        type$iv3 = type$iv;
                                        z3 = true;
                                    } else {
                                        int count$iv$iv2 = 0;
                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) $this$visitSubtreeIf_u2d6rFNWt0$iv4).getDelegate$ui_release();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                                count$iv$iv2++;
                                                if (count$iv$iv2 == 1) {
                                                    $this$visitSubtreeIf_u2d6rFNWt0$iv4 = next$iv$iv;
                                                    type$iv4 = type$iv;
                                                    Modifier.Node node2 = next$iv$iv;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        count$iv$iv = count$iv$iv2;
                                                        type$iv4 = type$iv;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        count$iv$iv = count$iv$iv2;
                                                        type$iv4 = type$iv;
                                                        mutableVector = mutableVector2;
                                                    }
                                                    Modifier.Node theNode$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv4;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(theNode$iv$iv);
                                                        }
                                                        $this$visitSubtreeIf_u2d6rFNWt0$iv4 = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(next$iv$iv);
                                                    }
                                                    mutableVector2 = mutableVector;
                                                    count$iv$iv2 = count$iv$iv;
                                                }
                                            } else {
                                                type$iv4 = type$iv;
                                                Modifier.Node node3 = next$iv$iv;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            ModifierLocal<?> modifierLocal3 = key;
                                            type$iv = type$iv4;
                                        }
                                        type$iv3 = type$iv;
                                        z3 = true;
                                        if (count$iv$iv2 == 1) {
                                            z = true;
                                            $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                            i = i2;
                                            type$iv = type$iv3;
                                            modifierLocal = key;
                                        }
                                    }
                                }
                                $this$visitSubtreeIf_u2d6rFNWt0$iv4 = DelegatableNodeKt.pop(mutableVector2);
                                z = z3;
                                $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                i = i2;
                                type$iv = type$iv3;
                                modifierLocal = key;
                            }
                            if (!diveDeeper$iv$iv) {
                                modifierLocal2 = key;
                                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                i3 = i2;
                                type$iv5 = type$iv2;
                                break;
                            }
                        } else {
                            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                            type$iv2 = type$iv;
                            i2 = i;
                            z2 = z;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        z4 = z2;
                        $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                        i = i2;
                        type$iv = type$iv2;
                        modifierLocal2 = key;
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                modifierLocal2 = key;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                i3 = i;
                type$iv5 = type$iv;
            }
            return;
        }
        DelegatableNode delegatableNode = $this$visitSubtreeIf_u2d6rFNWt0$iv3;
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    public final void updatedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        this.removed.add(DelegatableNodeKt.requireLayoutNode(node));
        this.removedLocal.add(key);
        invalidate();
    }
}
