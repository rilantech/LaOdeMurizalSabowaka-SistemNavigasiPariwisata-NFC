package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
final class LayoutNode$collapsedSemantics$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<SemanticsConfiguration> $config;
    final /* synthetic */ LayoutNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNode$collapsedSemantics$1(LayoutNode layoutNode, Ref.ObjectRef<SemanticsConfiguration> objectRef) {
        super(0);
        this.this$0 = layoutNode;
        this.$config = objectRef;
    }

    public final void invoke() {
        int mask$iv$iv;
        int i;
        Ref.ObjectRef<SemanticsConfiguration> objectRef;
        int type$iv;
        NodeChain this_$iv;
        int type$iv2;
        Ref.ObjectRef<SemanticsConfiguration> objectRef2;
        int mask$iv$iv2;
        int $i$f$forEachImmediateDelegate$ui_release;
        DelegatingNode this_$iv$iv$iv;
        int type$iv3;
        int count$iv$iv;
        MutableVector mutableVector;
        boolean z;
        NodeChain this_$iv2 = this.this$0.getNodes$ui_release();
        int type$iv4 = NodeKind.m6666constructorimpl(8);
        Ref.ObjectRef<SemanticsConfiguration> objectRef3 = this.$config;
        int i2 = false;
        int mask$iv$iv3 = type$iv4;
        NodeChain this_$iv$iv = this_$iv2;
        if ((this_$iv$iv.getAggregateChildKindSet() & mask$iv$iv3) != 0) {
            Modifier.Node node$iv$iv$iv = this_$iv$iv.getTail$ui_release();
            while (node$iv$iv$iv != null) {
                Modifier.Node it$iv$iv = node$iv$iv$iv;
                if ((it$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                    MutableVector mutableVector2 = null;
                    Modifier.Node this_$iv$iv$iv2 = it$iv$iv;
                    while (this_$iv$iv$iv2 != null) {
                        NodeChain this_$iv3 = this_$iv;
                        int i3 = i;
                        if (this_$iv$iv$iv2 instanceof SemanticsModifierNode) {
                            SemanticsModifierNode it = (SemanticsModifierNode) this_$iv$iv$iv2;
                            if (it.getShouldClearDescendantSemantics()) {
                                objectRef.element = new SemanticsConfiguration();
                                mask$iv$iv2 = mask$iv$iv;
                                z = true;
                                ((SemanticsConfiguration) objectRef.element).setClearingSemantics(true);
                            } else {
                                mask$iv$iv2 = mask$iv$iv;
                                z = true;
                            }
                            if (it.getShouldMergeDescendantSemantics()) {
                                ((SemanticsConfiguration) objectRef.element).setMergingSemanticsOfDescendants(z);
                            }
                            SemanticsModifierNode semanticsModifierNode = it;
                            objectRef2 = objectRef;
                            it.applySemantics((SemanticsConfiguration) objectRef.element);
                            type$iv2 = type$iv;
                        } else {
                            objectRef2 = objectRef;
                            mask$iv$iv2 = mask$iv$iv;
                            if (!((this_$iv$iv$iv2.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                type$iv2 = type$iv;
                            } else {
                                int count$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv2;
                                int $i$f$forEachImmediateDelegate$ui_release2 = false;
                                Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv3.getDelegate$ui_release();
                                while (node$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv2;
                                    if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                        count$iv$iv2++;
                                        if (count$iv$iv2 == 1) {
                                            this_$iv$iv$iv2 = next$iv$iv;
                                            type$iv3 = type$iv;
                                            this_$iv$iv$iv = this_$iv$iv$iv3;
                                            $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                            Modifier.Node node = next$iv$iv;
                                        } else {
                                            if (mutableVector2 == null) {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv;
                                                this_$iv$iv$iv = this_$iv$iv$iv3;
                                                $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                count$iv$iv = count$iv$iv2;
                                                type$iv3 = type$iv;
                                                this_$iv$iv$iv = this_$iv$iv$iv3;
                                                $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                mutableVector = mutableVector2;
                                            }
                                            MutableVector mutableVector3 = mutableVector;
                                            Modifier.Node theNode$iv$iv = this_$iv$iv$iv2;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(theNode$iv$iv);
                                                }
                                                this_$iv$iv$iv2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(next$iv$iv);
                                            }
                                            mutableVector2 = mutableVector3;
                                            count$iv$iv2 = count$iv$iv;
                                        }
                                    } else {
                                        type$iv3 = type$iv;
                                        this_$iv$iv$iv = this_$iv$iv$iv3;
                                        $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                        Modifier.Node node2 = next$iv$iv;
                                    }
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    type$iv = type$iv3;
                                    this_$iv$iv$iv3 = this_$iv$iv$iv;
                                    $i$f$forEachImmediateDelegate$ui_release2 = $i$f$forEachImmediateDelegate$ui_release;
                                }
                                type$iv2 = type$iv;
                                DelegatingNode delegatingNode = this_$iv$iv$iv3;
                                int i4 = $i$f$forEachImmediateDelegate$ui_release2;
                                if (count$iv$iv2 == 1) {
                                    this_$iv = this_$iv3;
                                    i = i3;
                                    mask$iv$iv = mask$iv$iv2;
                                    objectRef = objectRef2;
                                    type$iv = type$iv2;
                                }
                            }
                        }
                        this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector2);
                        this_$iv = this_$iv3;
                        i = i3;
                        mask$iv$iv = mask$iv$iv2;
                        objectRef = objectRef2;
                        type$iv = type$iv2;
                    }
                }
                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                this_$iv2 = this_$iv;
                i2 = i;
                mask$iv$iv3 = mask$iv$iv;
                objectRef3 = objectRef;
                type$iv4 = type$iv;
            }
            int i5 = type$iv;
            int i6 = i;
            int i7 = mask$iv$iv;
            return;
        }
        int i8 = type$iv4;
        int i9 = mask$iv$iv3;
    }
}
