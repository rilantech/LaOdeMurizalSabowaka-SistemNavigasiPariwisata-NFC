package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusInvalidationManager.kt */
final class FocusInvalidationManager$invalidateNodes$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FocusInvalidationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusInvalidationManager$invalidateNodes$1(FocusInvalidationManager focusInvalidationManager) {
        super(0);
        this.this$0 = focusInvalidationManager;
    }

    public final void invoke() {
        Iterator it;
        int $i$f$forEach;
        FocusInvalidationManager focusInvalidationManager;
        Iterable $this$forEach$iv;
        Iterator it2;
        int $i$f$forEach2;
        FocusInvalidationManager focusInvalidationManager2;
        Iterable $this$forEach$iv2;
        FocusInvalidationManager focusInvalidationManager3;
        Iterator it3;
        int $i$f$forEach3;
        Iterable $this$forEach$iv3;
        FocusInvalidationManager focusInvalidationManager4;
        FocusState focusState;
        FocusState focusState2;
        FocusInvalidationManager focusInvalidationManager5;
        MutableVector branches$iv$iv;
        DelegatingNode this_$iv$iv$iv;
        FocusInvalidationManager focusInvalidationManager6;
        int count$iv$iv;
        MutableVector mutableVector;
        Iterator it4;
        int $i$f$forEach4;
        Iterator it5;
        DelegatingNode this_$iv$iv$iv2;
        int count$iv$iv2;
        MutableVector mutableVector2;
        FocusInvalidationManager focusInvalidationManager7;
        Iterator it6;
        int $i$f$forEach5;
        Iterable $this$forEach$iv4;
        FocusInvalidationManager focusInvalidationManager8;
        MutableVector branches$iv$iv2;
        DelegatingNode this_$iv$iv$iv3;
        FocusInvalidationManager focusInvalidationManager9;
        int count$iv$iv3;
        MutableVector mutableVector3;
        Iterator it7;
        int $i$f$forEach6;
        Iterable $this$forEach$iv5;
        Iterator it8;
        int $i$f$forEach7;
        int count$iv$iv4;
        MutableVector mutableVector4;
        Iterable $this$forEach$iv6 = this.this$0.focusPropertiesNodes;
        FocusInvalidationManager focusInvalidationManager10 = this.this$0;
        int $i$f$forEach8 = false;
        Iterator it9 = $this$forEach$iv6.iterator();
        while (true) {
            int i = 1024;
            if (it.hasNext()) {
                FocusPropertiesModifierNode it10 = (FocusPropertiesModifierNode) it.next();
                if (it10.getNode().isAttached()) {
                    DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv = it10;
                    int type$iv = NodeKind.m4956constructorimpl(1024);
                    MutableVector mutableVector5 = null;
                    Modifier.Node this_$iv$iv$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv.getNode();
                    while (this_$iv$iv$iv4 != null) {
                        if (this_$iv$iv$iv4 instanceof FocusTargetNode) {
                            $this$forEach$iv5 = $this$forEach$iv;
                            focusInvalidationManager.focusTargetNodes.add((FocusTargetNode) this_$iv$iv$iv4);
                            $i$f$forEach6 = $i$f$forEach;
                            it7 = it;
                        } else {
                            $this$forEach$iv5 = $this$forEach$iv;
                            if (!((this_$iv$iv$iv4.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv4 instanceof DelegatingNode)) {
                                $i$f$forEach6 = $i$f$forEach;
                                it7 = it;
                            } else {
                                int count$iv$iv5 = 0;
                                Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv4).getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    Modifier.Node next$iv$iv = node$iv$iv$iv;
                                    if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                        count$iv$iv5++;
                                        $i$f$forEach7 = $i$f$forEach;
                                        if (count$iv$iv5 == 1) {
                                            this_$iv$iv$iv4 = next$iv$iv;
                                            it8 = it;
                                            Modifier.Node node = next$iv$iv;
                                        } else {
                                            if (mutableVector5 == null) {
                                                count$iv$iv4 = count$iv$iv5;
                                                it8 = it;
                                                mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                count$iv$iv4 = count$iv$iv5;
                                                it8 = it;
                                                mutableVector4 = mutableVector5;
                                            }
                                            MutableVector mutableVector6 = mutableVector4;
                                            Modifier.Node theNode$iv$iv = this_$iv$iv$iv4;
                                            if (theNode$iv$iv != null) {
                                                if (mutableVector6 != null) {
                                                    Boolean.valueOf(mutableVector6.add(theNode$iv$iv));
                                                }
                                                this_$iv$iv$iv4 = null;
                                            }
                                            if (mutableVector6 != null) {
                                                Boolean.valueOf(mutableVector6.add(next$iv$iv));
                                            }
                                            mutableVector5 = mutableVector6;
                                            count$iv$iv5 = count$iv$iv4;
                                        }
                                    } else {
                                        $i$f$forEach7 = $i$f$forEach;
                                        it8 = it;
                                        Modifier.Node node2 = next$iv$iv;
                                    }
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    $i$f$forEach = $i$f$forEach7;
                                    it = it8;
                                }
                                $i$f$forEach6 = $i$f$forEach;
                                it7 = it;
                                if (count$iv$iv5 == 1) {
                                    $this$forEach$iv = $this$forEach$iv5;
                                    $i$f$forEach = $i$f$forEach6;
                                    it = it7;
                                }
                            }
                        }
                        this_$iv$iv$iv4 = DelegatableNodeKt.pop(mutableVector5);
                        $this$forEach$iv = $this$forEach$iv5;
                        $i$f$forEach = $i$f$forEach6;
                        it = it7;
                    }
                    $this$forEach$iv4 = $this$forEach$iv;
                    $i$f$forEach5 = $i$f$forEach;
                    it6 = it;
                    int mask$iv$iv = type$iv;
                    DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                        MutableVector branches$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                        if (child$iv$iv == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, $this$visitChildren$iv$iv.getNode());
                        } else {
                            branches$iv$iv3.add(child$iv$iv);
                        }
                        while (branches$iv$iv3.isNotEmpty()) {
                            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv3.removeAt(branches$iv$iv3.getSize() - 1);
                            if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                                Modifier.Node node$iv$iv = branch$iv$iv;
                                while (true) {
                                    if (node$iv$iv == null) {
                                        FocusInvalidationManager focusInvalidationManager11 = focusInvalidationManager;
                                        DelegatableNode delegatableNode = $this$visitChildren$iv$iv;
                                        MutableVector mutableVector7 = branches$iv$iv3;
                                        break;
                                    } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                        MutableVector mutableVector8 = null;
                                        int mask$iv$iv2 = mask$iv$iv;
                                        Modifier.Node this_$iv$iv$iv5 = node$iv$iv;
                                        while (this_$iv$iv$iv5 != null) {
                                            DelegatableNode $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv;
                                            if (this_$iv$iv$iv5 instanceof FocusTargetNode) {
                                                branches$iv$iv2 = branches$iv$iv3;
                                                focusInvalidationManager.focusTargetNodes.add((FocusTargetNode) this_$iv$iv$iv5);
                                                focusInvalidationManager8 = focusInvalidationManager;
                                            } else {
                                                branches$iv$iv2 = branches$iv$iv3;
                                                if (!((this_$iv$iv$iv5.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv5 instanceof DelegatingNode)) {
                                                    focusInvalidationManager8 = focusInvalidationManager;
                                                } else {
                                                    int count$iv$iv6 = 0;
                                                    DelegatingNode this_$iv$iv$iv6 = (DelegatingNode) this_$iv$iv$iv5;
                                                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv6.getDelegate$ui_release();
                                                    while (node$iv$iv$iv2 != null) {
                                                        Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                                                        if ((next$iv$iv2.getKindSet$ui_release() & type$iv) != 0) {
                                                            count$iv$iv6++;
                                                            focusInvalidationManager9 = focusInvalidationManager;
                                                            if (count$iv$iv6 == 1) {
                                                                this_$iv$iv$iv5 = next$iv$iv2;
                                                                this_$iv$iv$iv3 = this_$iv$iv$iv6;
                                                                Modifier.Node node3 = next$iv$iv2;
                                                            } else {
                                                                if (mutableVector8 == null) {
                                                                    count$iv$iv3 = count$iv$iv6;
                                                                    this_$iv$iv$iv3 = this_$iv$iv$iv6;
                                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                                } else {
                                                                    count$iv$iv3 = count$iv$iv6;
                                                                    this_$iv$iv$iv3 = this_$iv$iv$iv6;
                                                                    mutableVector3 = mutableVector8;
                                                                }
                                                                MutableVector mutableVector9 = mutableVector3;
                                                                Modifier.Node theNode$iv$iv2 = this_$iv$iv$iv5;
                                                                if (theNode$iv$iv2 != null) {
                                                                    if (mutableVector9 != null) {
                                                                        Boolean.valueOf(mutableVector9.add(theNode$iv$iv2));
                                                                    }
                                                                    this_$iv$iv$iv5 = null;
                                                                }
                                                                if (mutableVector9 != null) {
                                                                    Boolean.valueOf(mutableVector9.add(next$iv$iv2));
                                                                }
                                                                mutableVector8 = mutableVector9;
                                                                count$iv$iv6 = count$iv$iv3;
                                                            }
                                                        } else {
                                                            focusInvalidationManager9 = focusInvalidationManager;
                                                            this_$iv$iv$iv3 = this_$iv$iv$iv6;
                                                            Modifier.Node node4 = next$iv$iv2;
                                                        }
                                                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                                        focusInvalidationManager = focusInvalidationManager9;
                                                        this_$iv$iv$iv6 = this_$iv$iv$iv3;
                                                    }
                                                    focusInvalidationManager8 = focusInvalidationManager;
                                                    DelegatingNode delegatingNode = this_$iv$iv$iv6;
                                                    if (count$iv$iv6 == 1) {
                                                        $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                                        branches$iv$iv3 = branches$iv$iv2;
                                                        focusInvalidationManager = focusInvalidationManager8;
                                                    }
                                                }
                                            }
                                            this_$iv$iv$iv5 = DelegatableNodeKt.pop(mutableVector8);
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                            branches$iv$iv3 = branches$iv$iv2;
                                            focusInvalidationManager = focusInvalidationManager8;
                                        }
                                        FocusInvalidationManager focusInvalidationManager12 = focusInvalidationManager;
                                        DelegatableNode delegatableNode2 = $this$visitChildren$iv$iv;
                                        MutableVector mutableVector10 = branches$iv$iv3;
                                        mask$iv$iv = mask$iv$iv2;
                                    } else {
                                        FocusInvalidationManager focusInvalidationManager13 = focusInvalidationManager;
                                        DelegatableNode delegatableNode3 = $this$visitChildren$iv$iv;
                                        MutableVector mutableVector11 = branches$iv$iv3;
                                        node$iv$iv = node$iv$iv.getChild$ui_release();
                                    }
                                }
                            } else {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, branch$iv$iv);
                            }
                        }
                        focusInvalidationManager7 = focusInvalidationManager;
                        DelegatableNode delegatableNode4 = $this$visitChildren$iv$iv;
                        MutableVector mutableVector12 = branches$iv$iv3;
                    } else {
                        int i2 = mask$iv$iv;
                        throw new IllegalStateException("visitChildren called on an unattached node".toString());
                    }
                } else {
                    $this$forEach$iv4 = $this$forEach$iv;
                    focusInvalidationManager7 = focusInvalidationManager;
                    $i$f$forEach5 = $i$f$forEach;
                    it6 = it;
                }
                $this$forEach$iv6 = $this$forEach$iv4;
                $i$f$forEach8 = $i$f$forEach5;
                it9 = it6;
                focusInvalidationManager10 = focusInvalidationManager7;
            } else {
                int i3 = $i$f$forEach;
                this.this$0.focusPropertiesNodes.clear();
                Set focusTargetsWithInvalidatedFocusEvents = new LinkedHashSet();
                Iterable $this$forEach$iv7 = this.this$0.focusEventNodes;
                FocusInvalidationManager focusInvalidationManager14 = this.this$0;
                int $i$f$forEach9 = false;
                Iterator it11 = $this$forEach$iv7.iterator();
                while (it2.hasNext()) {
                    Object element$iv = it2.next();
                    FocusEventModifierNode focusEventNode = (FocusEventModifierNode) element$iv;
                    if (!focusEventNode.getNode().isAttached()) {
                        focusEventNode.onFocusEvent(FocusStateImpl.Inactive);
                        $this$forEach$iv3 = $this$forEach$iv2;
                        focusInvalidationManager3 = focusInvalidationManager2;
                        $i$f$forEach3 = $i$f$forEach2;
                        it3 = it2;
                        Object obj = element$iv;
                    } else {
                        boolean requiresUpdate = true;
                        boolean aggregatedNode = false;
                        FocusTargetNode focusTargetNode = null;
                        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = focusEventNode;
                        int type$iv2 = NodeKind.m4956constructorimpl(i);
                        MutableVector mutableVector13 = null;
                        Modifier.Node this_$iv$iv$iv7 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2.getNode();
                        while (this_$iv$iv$iv7 != null) {
                            Iterable $this$forEach$iv8 = $this$forEach$iv2;
                            if (this_$iv$iv$iv7 instanceof FocusTargetNode) {
                                FocusTargetNode it12 = (FocusTargetNode) this_$iv$iv$iv7;
                                if (focusTargetNode != null) {
                                    aggregatedNode = true;
                                }
                                focusTargetNode = it12;
                                $i$f$forEach4 = $i$f$forEach2;
                                if (focusInvalidationManager2.focusTargetNodes.contains(it12)) {
                                    requiresUpdate = false;
                                    focusTargetsWithInvalidatedFocusEvents.add(it12);
                                }
                                it4 = it2;
                            } else {
                                $i$f$forEach4 = $i$f$forEach2;
                                if (!((this_$iv$iv$iv7.getKindSet$ui_release() & type$iv2) != 0) || !(this_$iv$iv$iv7 instanceof DelegatingNode)) {
                                    it4 = it2;
                                } else {
                                    int count$iv$iv7 = 0;
                                    DelegatingNode this_$iv$iv$iv8 = (DelegatingNode) this_$iv$iv$iv7;
                                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv8.getDelegate$ui_release();
                                    while (node$iv$iv$iv3 != null) {
                                        Modifier.Node next$iv$iv3 = node$iv$iv$iv3;
                                        if ((next$iv$iv3.getKindSet$ui_release() & type$iv2) != 0) {
                                            count$iv$iv7++;
                                            this_$iv$iv$iv2 = this_$iv$iv$iv8;
                                            if (count$iv$iv7 == 1) {
                                                this_$iv$iv$iv7 = next$iv$iv3;
                                                it5 = it2;
                                                Modifier.Node node5 = next$iv$iv3;
                                            } else {
                                                if (mutableVector13 == null) {
                                                    count$iv$iv2 = count$iv$iv7;
                                                    it5 = it2;
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv2 = count$iv$iv7;
                                                    it5 = it2;
                                                    mutableVector2 = mutableVector13;
                                                }
                                                MutableVector mutableVector14 = mutableVector2;
                                                Modifier.Node theNode$iv$iv3 = this_$iv$iv$iv7;
                                                if (theNode$iv$iv3 != null) {
                                                    if (mutableVector14 != null) {
                                                        Boolean.valueOf(mutableVector14.add(theNode$iv$iv3));
                                                    }
                                                    this_$iv$iv$iv7 = null;
                                                }
                                                if (mutableVector14 != null) {
                                                    Boolean.valueOf(mutableVector14.add(next$iv$iv3));
                                                }
                                                mutableVector13 = mutableVector14;
                                                count$iv$iv7 = count$iv$iv2;
                                            }
                                        } else {
                                            this_$iv$iv$iv2 = this_$iv$iv$iv8;
                                            it5 = it2;
                                            Modifier.Node node6 = next$iv$iv3;
                                        }
                                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                        this_$iv$iv$iv8 = this_$iv$iv$iv2;
                                        it2 = it5;
                                    }
                                    it4 = it2;
                                    if (count$iv$iv7 == 1) {
                                        $this$forEach$iv2 = $this$forEach$iv8;
                                        $i$f$forEach2 = $i$f$forEach4;
                                        it2 = it4;
                                    }
                                }
                            }
                            this_$iv$iv$iv7 = DelegatableNodeKt.pop(mutableVector13);
                            $this$forEach$iv2 = $this$forEach$iv8;
                            $i$f$forEach2 = $i$f$forEach4;
                            it2 = it4;
                        }
                        $this$forEach$iv3 = $this$forEach$iv2;
                        $i$f$forEach3 = $i$f$forEach2;
                        it3 = it2;
                        int mask$iv$iv3 = type$iv2;
                        DelegatableNode $this$visitChildren$iv$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                        if ($this$visitChildren$iv$iv3.getNode().isAttached()) {
                            Object obj2 = element$iv;
                            MutableVector branches$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                            Modifier.Node child$iv$iv2 = $this$visitChildren$iv$iv3.getNode().getChild$ui_release();
                            if (child$iv$iv2 == null) {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, $this$visitChildren$iv$iv3.getNode());
                            } else {
                                branches$iv$iv4.add(child$iv$iv2);
                            }
                            while (branches$iv$iv4.isNotEmpty()) {
                                Modifier.Node branch$iv$iv2 = (Modifier.Node) branches$iv$iv4.removeAt(branches$iv$iv4.getSize() - 1);
                                if ((branch$iv$iv2.getAggregateChildKindSet$ui_release() & mask$iv$iv3) != 0) {
                                    Modifier.Node node$iv$iv2 = branch$iv$iv2;
                                    while (true) {
                                        if (node$iv$iv2 == null) {
                                            break;
                                        } else if ((node$iv$iv2.getKindSet$ui_release() & mask$iv$iv3) != 0) {
                                            MutableVector mutableVector15 = null;
                                            int mask$iv$iv4 = mask$iv$iv3;
                                            Modifier.Node this_$iv$iv$iv9 = node$iv$iv2;
                                            while (this_$iv$iv$iv9 != null) {
                                                DelegatableNode $this$visitChildren$iv$iv4 = $this$visitChildren$iv$iv3;
                                                if (this_$iv$iv$iv9 instanceof FocusTargetNode) {
                                                    FocusTargetNode it13 = (FocusTargetNode) this_$iv$iv$iv9;
                                                    if (focusTargetNode != null) {
                                                        aggregatedNode = true;
                                                    }
                                                    focusTargetNode = it13;
                                                    branches$iv$iv = branches$iv$iv4;
                                                    if (focusInvalidationManager4.focusTargetNodes.contains(it13)) {
                                                        requiresUpdate = false;
                                                        focusTargetsWithInvalidatedFocusEvents.add(it13);
                                                    }
                                                    focusInvalidationManager5 = focusInvalidationManager4;
                                                } else {
                                                    branches$iv$iv = branches$iv$iv4;
                                                    if (!((this_$iv$iv$iv9.getKindSet$ui_release() & type$iv2) != 0) || !(this_$iv$iv$iv9 instanceof DelegatingNode)) {
                                                        focusInvalidationManager5 = focusInvalidationManager4;
                                                    } else {
                                                        int count$iv$iv8 = 0;
                                                        DelegatingNode this_$iv$iv$iv10 = (DelegatingNode) this_$iv$iv$iv9;
                                                        Modifier.Node node$iv$iv$iv4 = this_$iv$iv$iv10.getDelegate$ui_release();
                                                        while (node$iv$iv$iv4 != null) {
                                                            Modifier.Node next$iv$iv4 = node$iv$iv$iv4;
                                                            if ((next$iv$iv4.getKindSet$ui_release() & type$iv2) != 0) {
                                                                count$iv$iv8++;
                                                                focusInvalidationManager6 = focusInvalidationManager4;
                                                                if (count$iv$iv8 == 1) {
                                                                    this_$iv$iv$iv9 = next$iv$iv4;
                                                                    this_$iv$iv$iv = this_$iv$iv$iv10;
                                                                    Modifier.Node node7 = next$iv$iv4;
                                                                } else {
                                                                    if (mutableVector15 == null) {
                                                                        count$iv$iv = count$iv$iv8;
                                                                        this_$iv$iv$iv = this_$iv$iv$iv10;
                                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        count$iv$iv = count$iv$iv8;
                                                                        this_$iv$iv$iv = this_$iv$iv$iv10;
                                                                        mutableVector = mutableVector15;
                                                                    }
                                                                    Modifier.Node theNode$iv$iv4 = this_$iv$iv$iv9;
                                                                    if (theNode$iv$iv4 != null) {
                                                                        if (mutableVector != null) {
                                                                            Boolean.valueOf(mutableVector.add(theNode$iv$iv4));
                                                                        }
                                                                        this_$iv$iv$iv9 = null;
                                                                    }
                                                                    if (mutableVector != null) {
                                                                        Boolean.valueOf(mutableVector.add(next$iv$iv4));
                                                                    }
                                                                    mutableVector15 = mutableVector;
                                                                    count$iv$iv8 = count$iv$iv;
                                                                }
                                                            } else {
                                                                focusInvalidationManager6 = focusInvalidationManager4;
                                                                this_$iv$iv$iv = this_$iv$iv$iv10;
                                                                Modifier.Node node8 = next$iv$iv4;
                                                            }
                                                            node$iv$iv$iv4 = node$iv$iv$iv4.getChild$ui_release();
                                                            focusInvalidationManager4 = focusInvalidationManager6;
                                                            this_$iv$iv$iv10 = this_$iv$iv$iv;
                                                        }
                                                        focusInvalidationManager5 = focusInvalidationManager4;
                                                        DelegatingNode delegatingNode2 = this_$iv$iv$iv10;
                                                        if (count$iv$iv8 == 1) {
                                                            $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv4;
                                                            branches$iv$iv4 = branches$iv$iv;
                                                            focusInvalidationManager4 = focusInvalidationManager5;
                                                        }
                                                    }
                                                }
                                                this_$iv$iv$iv9 = DelegatableNodeKt.pop(mutableVector15);
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv4;
                                                branches$iv$iv4 = branches$iv$iv;
                                                focusInvalidationManager4 = focusInvalidationManager5;
                                            }
                                            DelegatableNode delegatableNode5 = $this$visitChildren$iv$iv3;
                                            MutableVector mutableVector16 = branches$iv$iv4;
                                            mask$iv$iv3 = mask$iv$iv4;
                                            focusInvalidationManager2 = focusInvalidationManager4;
                                        } else {
                                            DelegatableNode delegatableNode6 = $this$visitChildren$iv$iv3;
                                            MutableVector mutableVector17 = branches$iv$iv4;
                                            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                                            focusInvalidationManager4 = focusInvalidationManager4;
                                        }
                                    }
                                } else {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, branch$iv$iv2);
                                }
                                mask$iv$iv3 = mask$iv$iv3;
                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv3;
                                branches$iv$iv4 = branches$iv$iv4;
                                focusInvalidationManager2 = focusInvalidationManager4;
                            }
                            focusInvalidationManager3 = focusInvalidationManager4;
                            DelegatableNode delegatableNode7 = $this$visitChildren$iv$iv3;
                            MutableVector mutableVector18 = branches$iv$iv4;
                            if (requiresUpdate) {
                                if (aggregatedNode) {
                                    focusState = FocusEventModifierNodeKt.getFocusState(focusEventNode);
                                } else {
                                    if (focusTargetNode == null || (focusState2 = focusTargetNode.getFocusState()) == null) {
                                        focusState2 = FocusStateImpl.Inactive;
                                    }
                                    focusState = focusState2;
                                }
                                focusEventNode.onFocusEvent(focusState);
                            }
                        } else {
                            int i4 = mask$iv$iv3;
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                    }
                    $this$forEach$iv7 = $this$forEach$iv3;
                    $i$f$forEach9 = $i$f$forEach3;
                    it11 = it3;
                    focusInvalidationManager14 = focusInvalidationManager3;
                    i = 1024;
                }
                int i5 = $i$f$forEach2;
                this.this$0.focusEventNodes.clear();
                for (FocusTargetNode it14 : this.this$0.focusTargetNodes) {
                    if (it14.isAttached()) {
                        FocusStateImpl preInvalidationState = it14.getFocusState();
                        it14.invalidateFocus$ui_release();
                        if (preInvalidationState != it14.getFocusState() || focusTargetsWithInvalidatedFocusEvents.contains(it14)) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(it14);
                        }
                    }
                }
                this.this$0.focusTargetNodes.clear();
                focusTargetsWithInvalidatedFocusEvents.clear();
                if (!this.this$0.focusPropertiesNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                } else if (!this.this$0.focusEventNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                } else if (!this.this$0.focusTargetNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                } else {
                    return;
                }
            }
        }
    }
}
