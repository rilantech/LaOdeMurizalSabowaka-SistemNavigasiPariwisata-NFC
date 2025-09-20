package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalModifierNode.kt */
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    ModifierLocalMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    <T> void provide(ModifierLocal<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(getProvidedValues() != EmptyMap.INSTANCE)) {
            throw new IllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap".toString());
        } else if (getProvidedValues().contains$ui_release(key)) {
            getProvidedValues().set$ui_release(key, value);
        } else {
            throw new IllegalArgumentException(("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + key + " was not found.").toString());
        }
    }

    <T> T getCurrent(ModifierLocal<T> $this$current) {
        int type$iv;
        boolean includeSelf$iv;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        NodeChain nodes$ui_release;
        boolean includeSelf$iv2;
        int type$iv2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int type$iv3;
        boolean includeSelf$iv3;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$current, "<this>");
        if (getNode().isAttached()) {
            ModifierLocal key = $this$current;
            DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = this;
            int type$iv5 = NodeKind.m6666constructorimpl(32);
            boolean includeSelf$iv4 = false;
            int mask$iv$iv = type$iv5;
            DelegatableNode $this$visitAncestors$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
            if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
                Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode().getParent$ui_release();
                LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv);
                while (layout$iv$iv != null) {
                    if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                        while (node$iv$iv != null) {
                            if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                MutableVector mutableVector2 = null;
                                Modifier.Node node = node$iv$iv;
                                while (node != null) {
                                    DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                    if (node instanceof ModifierLocalModifierNode) {
                                        ModifierLocalModifierNode it = (ModifierLocalModifierNode) node;
                                        includeSelf$iv3 = includeSelf$iv2;
                                        if (it.getProvidedValues().contains$ui_release(key)) {
                                            return it.getProvidedValues().get$ui_release(key);
                                        }
                                        type$iv3 = type$iv2;
                                    } else {
                                        includeSelf$iv3 = includeSelf$iv2;
                                        Modifier.Node this_$iv$iv$iv = node;
                                        int kindSet$ui_release = this_$iv$iv$iv.getKindSet$ui_release() & type$iv2;
                                        Modifier.Node node2 = this_$iv$iv$iv;
                                        int i = 1;
                                        if ((kindSet$ui_release != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                            type$iv3 = type$iv2;
                                        } else {
                                            int count$iv$iv2 = 0;
                                            Modifier.Node node$iv$iv$iv = ((DelegatingNode) node).getDelegate$ui_release();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if (((next$iv$iv.getKindSet$ui_release() & type$iv2) != 0 ? i : 0) != 0) {
                                                    count$iv$iv2++;
                                                    if (count$iv$iv2 == i) {
                                                        node = next$iv$iv;
                                                        type$iv4 = type$iv2;
                                                        Modifier.Node node3 = next$iv$iv;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            type$iv4 = type$iv2;
                                                            count$iv$iv = count$iv$iv2;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            type$iv4 = type$iv2;
                                                            count$iv$iv = count$iv$iv2;
                                                            mutableVector = mutableVector2;
                                                        }
                                                        Modifier.Node theNode$iv$iv = node;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector != null) {
                                                                mutableVector.add(theNode$iv$iv);
                                                            }
                                                            node = null;
                                                        }
                                                        if (mutableVector != null) {
                                                            mutableVector.add(next$iv$iv);
                                                        }
                                                        mutableVector2 = mutableVector;
                                                        count$iv$iv2 = count$iv$iv;
                                                    }
                                                } else {
                                                    type$iv4 = type$iv2;
                                                    Modifier.Node node4 = next$iv$iv;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                type$iv2 = type$iv4;
                                                i = 1;
                                            }
                                            type$iv3 = type$iv2;
                                            if (count$iv$iv2 == 1) {
                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                                includeSelf$iv2 = includeSelf$iv3;
                                                type$iv2 = type$iv3;
                                            }
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector2);
                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                                    includeSelf$iv2 = includeSelf$iv3;
                                    type$iv2 = type$iv3;
                                }
                                continue;
                            }
                            node$iv$iv = node$iv$iv.getParent$ui_release();
                            ModifierLocal<T> modifierLocal = $this$current;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                            includeSelf$iv4 = includeSelf$iv2;
                            type$iv5 = type$iv2;
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        type$iv = type$iv2;
                        includeSelf$iv = includeSelf$iv2;
                    } else {
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                        type$iv = type$iv5;
                        includeSelf$iv = includeSelf$iv4;
                    }
                    layout$iv$iv = layout$iv$iv.getParent$ui_release();
                    node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                    ModifierLocal<T> modifierLocal2 = $this$current;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv4 = includeSelf$iv;
                    type$iv5 = type$iv;
                }
                return key.getDefaultFactory$ui_release().invoke();
            }
            DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
