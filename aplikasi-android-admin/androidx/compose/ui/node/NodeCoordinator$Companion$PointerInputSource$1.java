package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/ui/node/NodeCoordinator$Companion$PointerInputSource$1", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public final class NodeCoordinator$Companion$PointerInputSource$1 implements NodeCoordinator.HitTestSource {
    NodeCoordinator$Companion$PointerInputSource$1() {
    }

    /* renamed from: entityType-OLwlOKw  reason: not valid java name */
    public int m6658entityTypeOLwlOKw() {
        return NodeKind.m6666constructorimpl(16);
    }

    public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
        int kind$iv;
        int kind$iv2;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(node, "node");
        int kind$iv3 = NodeKind.m6666constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node this_$iv$iv = node;
        while (this_$iv$iv != null) {
            int i = 1;
            if (!(this_$iv$iv instanceof PointerInputModifierNode)) {
                if (((this_$iv$iv.getKindSet$ui_release() & kind$iv3) != 0 ? 1 : null) == null || !(this_$iv$iv instanceof DelegatingNode)) {
                    kind$iv = kind$iv3;
                } else {
                    int count$iv = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet$ui_release() & kind$iv3) != 0 ? i : 0) != 0) {
                            count$iv++;
                            if (count$iv == i) {
                                this_$iv$iv = next$iv;
                                kind$iv2 = kind$iv3;
                            } else {
                                if (mutableVector2 == null) {
                                    kind$iv2 = kind$iv3;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    kind$iv2 = kind$iv3;
                                    mutableVector = mutableVector2;
                                }
                                mutableVector2 = mutableVector;
                                Modifier.Node theNode$iv = this_$iv$iv;
                                if (theNode$iv != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(theNode$iv);
                                    }
                                    this_$iv$iv = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(next$iv);
                                }
                            }
                        } else {
                            kind$iv2 = kind$iv3;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        kind$iv3 = kind$iv2;
                        i = 1;
                    }
                    kind$iv = kind$iv3;
                    if (count$iv == 1) {
                        kind$iv3 = kind$iv;
                    }
                }
            } else if (((PointerInputModifierNode) this_$iv$iv).interceptOutOfBoundsChildEvents()) {
                return true;
            } else {
                kind$iv = kind$iv3;
            }
            this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
            kind$iv3 = kind$iv;
        }
        return false;
    }

    public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
        Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
        return true;
    }

    /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
    public void m6657childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        layoutNode.m6540hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
    }
}
