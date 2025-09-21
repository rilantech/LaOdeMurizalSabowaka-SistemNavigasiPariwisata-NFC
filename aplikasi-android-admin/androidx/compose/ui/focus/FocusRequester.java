package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\bJ\r\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "findFocusTarget", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focus", "focus$ui_release", "freeFocus", "requestFocus", "", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRequester.kt */
public final class FocusRequester {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final FocusRequester Cancel = new FocusRequester();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FocusRequester Default = new FocusRequester();
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes = new MutableVector<>(new FocusRequesterModifierNode[16], 0);

    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    public final boolean focus$ui_release() {
        MutableVector this_$iv$iv;
        int i;
        MutableVector this_$iv$iv2;
        Modifier.Node child$iv$iv$iv;
        MutableVector this_$iv$iv3;
        Modifier.Node child$iv$iv$iv2;
        boolean success$iv;
        MutableVector this_$iv$iv4;
        int $i$f$forEachImmediateDelegate$ui_release;
        DelegatingNode this_$iv$iv$iv$iv;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        boolean z;
        FocusRequester this_$iv = this;
        int $i$f$findFocusTarget = false;
        Companion companion = Companion;
        int i2 = 0;
        if (this_$iv != companion.getDefault()) {
            if (!(this_$iv != companion.getCancel())) {
                throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
            } else if (this_$iv.focusRequesterNodes.isNotEmpty()) {
                boolean success$iv2 = false;
                MutableVector this_$iv$iv5 = this_$iv.focusRequesterNodes;
                int size$iv$iv = this_$iv$iv5.getSize();
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv5.getContent();
                    while (true) {
                        int type$iv$iv = NodeKind.m6666constructorimpl(1024);
                        int mask$iv$iv$iv = type$iv$iv;
                        DelegatableNode $this$visitChildren$iv$iv$iv = (FocusRequesterModifierNode) content$iv$iv[i$iv$iv];
                        if ($this$visitChildren$iv$iv$iv.getNode().isAttached()) {
                            FocusRequester this_$iv2 = this_$iv;
                            int $i$f$findFocusTarget2 = $i$f$findFocusTarget;
                            MutableVector branches$iv$iv$iv = new MutableVector(new Modifier.Node[16], i2);
                            Modifier.Node child$iv$iv$iv3 = $this$visitChildren$iv$iv$iv.getNode().getChild$ui_release();
                            if (child$iv$iv$iv3 == null) {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv$iv, $this$visitChildren$iv$iv$iv.getNode());
                            } else {
                                branches$iv$iv$iv.add(child$iv$iv$iv3);
                            }
                            while (true) {
                                if (!branches$iv$iv$iv.isNotEmpty()) {
                                    Modifier.Node node = child$iv$iv$iv3;
                                    boolean z2 = success$iv2;
                                    this_$iv$iv = this_$iv$iv5;
                                    i = i2;
                                    break;
                                }
                                Modifier.Node branch$iv$iv$iv = (Modifier.Node) branches$iv$iv$iv.removeAt(branches$iv$iv$iv.getSize() - 1);
                                if ((branch$iv$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                    Modifier.Node node$iv$iv$iv = branch$iv$iv$iv;
                                    while (true) {
                                        if (node$iv$iv$iv == null) {
                                            boolean z3 = success$iv2;
                                            MutableVector this_$iv$iv6 = this_$iv$iv2;
                                            int i3 = i2;
                                            child$iv$iv$iv3 = child$iv$iv$iv;
                                            this_$iv$iv5 = this_$iv$iv6;
                                            break;
                                        } else if ((node$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                                            MutableVector mutableVector2 = null;
                                            Modifier.Node this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                            while (this_$iv$iv$iv$iv2 != null) {
                                                MutableVector branches$iv$iv$iv2 = branches$iv$iv$iv;
                                                if (this_$iv$iv$iv$iv2 instanceof FocusTargetNode) {
                                                    FocusTargetNode it$iv = (FocusTargetNode) this_$iv$iv$iv$iv2;
                                                    FocusTargetNode focusTarget = it$iv;
                                                    if (focusTarget.fetchFocusProperties$ui_release().getCanFocus()) {
                                                        FocusTargetNode focusTargetNode = it$iv;
                                                        child$iv$iv$iv2 = child$iv$iv$iv;
                                                        z = FocusTransactionsKt.requestFocus(focusTarget);
                                                        success$iv = success$iv2;
                                                        FocusTargetNode focusTargetNode2 = focusTarget;
                                                    } else {
                                                        FocusTargetNode focusTargetNode3 = it$iv;
                                                        child$iv$iv$iv2 = child$iv$iv$iv;
                                                        success$iv = success$iv2;
                                                        z = TwoDimensionalFocusSearchKt.m4674findChildCorrespondingToFocusEnterOMvw8(focusTarget, FocusDirection.Companion.m4638getEnterdhqQ8s(), FocusRequester$focus$1$1.INSTANCE);
                                                    }
                                                    if (z) {
                                                        success$iv2 = true;
                                                        this_$iv$iv = this_$iv$iv2;
                                                        i = 0;
                                                        break;
                                                    }
                                                    this_$iv$iv3 = this_$iv$iv2;
                                                } else {
                                                    child$iv$iv$iv2 = child$iv$iv$iv;
                                                    success$iv = success$iv2;
                                                    if (!((this_$iv$iv$iv$iv2.getKindSet$ui_release() & type$iv$iv) != 0) || !(this_$iv$iv$iv$iv2 instanceof DelegatingNode)) {
                                                        this_$iv$iv3 = this_$iv$iv2;
                                                    } else {
                                                        int count$iv$iv$iv2 = 0;
                                                        DelegatingNode this_$iv$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv$iv2;
                                                        int $i$f$forEachImmediateDelegate$ui_release2 = false;
                                                        Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv3.getDelegate$ui_release();
                                                        while (node$iv$iv$iv$iv != null) {
                                                            Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                            if ((next$iv$iv$iv.getKindSet$ui_release() & type$iv$iv) != 0) {
                                                                count$iv$iv$iv2++;
                                                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                                if (count$iv$iv$iv2 == 1) {
                                                                    this_$iv$iv$iv$iv2 = next$iv$iv$iv;
                                                                    $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                                    this_$iv$iv4 = this_$iv$iv2;
                                                                    Modifier.Node node2 = next$iv$iv$iv;
                                                                } else {
                                                                    if (mutableVector2 == null) {
                                                                        count$iv$iv$iv = count$iv$iv$iv2;
                                                                        $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                                        this_$iv$iv4 = this_$iv$iv2;
                                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        count$iv$iv$iv = count$iv$iv$iv2;
                                                                        $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                                        this_$iv$iv4 = this_$iv$iv2;
                                                                        mutableVector = mutableVector2;
                                                                    }
                                                                    MutableVector mutableVector3 = mutableVector;
                                                                    Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv2;
                                                                    if (theNode$iv$iv$iv != null) {
                                                                        if (mutableVector3 != null) {
                                                                            mutableVector3.add(theNode$iv$iv$iv);
                                                                        }
                                                                        this_$iv$iv$iv$iv2 = null;
                                                                    }
                                                                    if (mutableVector3 != null) {
                                                                        mutableVector3.add(next$iv$iv$iv);
                                                                    }
                                                                    mutableVector2 = mutableVector3;
                                                                    count$iv$iv$iv2 = count$iv$iv$iv;
                                                                }
                                                            } else {
                                                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                                $i$f$forEachImmediateDelegate$ui_release = $i$f$forEachImmediateDelegate$ui_release2;
                                                                this_$iv$iv4 = this_$iv$iv2;
                                                                Modifier.Node node3 = next$iv$iv$iv;
                                                            }
                                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv;
                                                            $i$f$forEachImmediateDelegate$ui_release2 = $i$f$forEachImmediateDelegate$ui_release;
                                                            this_$iv$iv2 = this_$iv$iv4;
                                                        }
                                                        int i4 = $i$f$forEachImmediateDelegate$ui_release2;
                                                        this_$iv$iv3 = this_$iv$iv2;
                                                        if (count$iv$iv$iv2 == 1) {
                                                            branches$iv$iv$iv = branches$iv$iv$iv2;
                                                            success$iv2 = success$iv;
                                                            child$iv$iv$iv = child$iv$iv$iv2;
                                                            this_$iv$iv2 = this_$iv$iv3;
                                                        }
                                                    }
                                                }
                                                this_$iv$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector2);
                                                branches$iv$iv$iv = branches$iv$iv$iv2;
                                                success$iv2 = success$iv;
                                                child$iv$iv$iv = child$iv$iv$iv2;
                                                this_$iv$iv2 = this_$iv$iv3;
                                            }
                                            boolean z4 = success$iv2;
                                            i2 = 0;
                                            child$iv$iv$iv3 = child$iv$iv$iv;
                                            this_$iv$iv5 = this_$iv$iv2;
                                        } else {
                                            boolean z5 = success$iv2;
                                            MutableVector this_$iv$iv7 = this_$iv$iv2;
                                            int i5 = i2;
                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                            child$iv$iv$iv3 = child$iv$iv$iv;
                                            this_$iv$iv5 = this_$iv$iv7;
                                        }
                                    }
                                } else {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv$iv, branch$iv$iv$iv);
                                }
                            }
                            i$iv$iv++;
                            if (i$iv$iv >= size$iv$iv) {
                                break;
                            }
                            i2 = i;
                            this_$iv = this_$iv2;
                            $i$f$findFocusTarget = $i$f$findFocusTarget2;
                            this_$iv$iv5 = this_$iv$iv;
                        } else {
                            int i6 = $i$f$findFocusTarget;
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                    }
                } else {
                    MutableVector mutableVector4 = this_$iv$iv5;
                }
                return success$iv2;
            } else {
                FocusRequester focusRequester = this_$iv;
                throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
            }
        } else {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
    }

    public final boolean captureFocus() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector this_$iv = this.focusRequesterNodes;
            int size$iv = this_$iv.getSize();
            if (size$iv <= 0) {
                return false;
            }
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            while (!FocusRequesterModifierNodeKt.captureFocus((FocusRequesterModifierNode) content$iv[i$iv])) {
                i$iv++;
                if (i$iv >= size$iv) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final boolean freeFocus() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector this_$iv = this.focusRequesterNodes;
            int size$iv = this_$iv.getSize();
            if (size$iv <= 0) {
                return false;
            }
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            while (!FocusRequesterModifierNodeKt.freeFocus((FocusRequesterModifierNode) content$iv[i$iv])) {
                i$iv++;
                if (i$iv >= size$iv) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusRequester.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCancel$annotations() {
        }

        private Companion() {
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0004H\u0002J\t\u0010\n\u001a\u00020\u0004H\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0002J\t\u0010\f\u001a\u00020\u0004H\u0002J\t\u0010\r\u001a\u00020\u0004H\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: FocusRequester.kt */
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;
            public static final FocusRequesterFactory INSTANCE = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }
        }

        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }
    }

    private final boolean findFocusTarget(Function1<? super FocusTargetNode, Boolean> onFound) {
        MutableVector this_$iv;
        int i;
        MutableVector this_$iv2;
        Modifier.Node child$iv$iv;
        MutableVector this_$iv3;
        boolean success;
        Modifier.Node child$iv$iv2;
        MutableVector this_$iv4;
        boolean success2;
        int count$iv$iv;
        MutableVector mutableVector;
        int $i$f$findFocusTarget = 0;
        Companion companion = Companion;
        int i2 = 0;
        if (this != companion.getDefault()) {
            if (!(this != companion.getCancel())) {
                throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
            } else if (this.focusRequesterNodes.isNotEmpty()) {
                boolean success3 = false;
                MutableVector this_$iv5 = this.focusRequesterNodes;
                int size$iv = this_$iv5.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv5.getContent();
                    while (true) {
                        int type$iv = NodeKind.m6666constructorimpl(1024);
                        int mask$iv$iv = type$iv;
                        DelegatableNode $this$visitChildren$iv$iv = (FocusRequesterModifierNode) content$iv[i$iv];
                        if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                            int $i$f$findFocusTarget2 = $i$f$findFocusTarget;
                            MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], i2);
                            Modifier.Node child$iv$iv3 = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                            if (child$iv$iv3 == null) {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                            } else {
                                branches$iv$iv.add(child$iv$iv3);
                            }
                            while (true) {
                                if (!branches$iv$iv.isNotEmpty()) {
                                    Modifier.Node node = child$iv$iv3;
                                    boolean z = success3;
                                    this_$iv = this_$iv5;
                                    i = i2;
                                    break;
                                }
                                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                                    Modifier.Node node$iv$iv = branch$iv$iv;
                                    while (true) {
                                        if (node$iv$iv == null) {
                                            boolean z2 = success3;
                                            MutableVector this_$iv6 = this_$iv2;
                                            int i3 = i2;
                                            child$iv$iv3 = child$iv$iv;
                                            this_$iv5 = this_$iv6;
                                            break;
                                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                            MutableVector mutableVector2 = null;
                                            Modifier.Node this_$iv$iv$iv = node$iv$iv;
                                            while (this_$iv$iv$iv != null) {
                                                MutableVector branches$iv$iv2 = branches$iv$iv;
                                                if (this_$iv$iv$iv instanceof FocusTargetNode) {
                                                    child$iv$iv2 = child$iv$iv;
                                                    if (onFound.invoke((FocusTargetNode) this_$iv$iv$iv).booleanValue()) {
                                                        success3 = true;
                                                        this_$iv = this_$iv2;
                                                        i = 0;
                                                        break;
                                                    }
                                                    success = success3;
                                                    this_$iv3 = this_$iv2;
                                                } else {
                                                    child$iv$iv2 = child$iv$iv;
                                                    Function1<? super FocusTargetNode, Boolean> function1 = onFound;
                                                    if (!((this_$iv$iv$iv.getKindSet$ui_release() & type$iv) != 0) || !(this_$iv$iv$iv instanceof DelegatingNode)) {
                                                        success = success3;
                                                        this_$iv3 = this_$iv2;
                                                    } else {
                                                        int count$iv$iv2 = 0;
                                                        Modifier.Node node$iv$iv$iv = ((DelegatingNode) this_$iv$iv$iv).getDelegate$ui_release();
                                                        while (node$iv$iv$iv != null) {
                                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                            if ((next$iv$iv.getKindSet$ui_release() & type$iv) != 0) {
                                                                count$iv$iv2++;
                                                                if (count$iv$iv2 == 1) {
                                                                    this_$iv$iv$iv = next$iv$iv;
                                                                    success2 = success3;
                                                                    this_$iv4 = this_$iv2;
                                                                    Modifier.Node node2 = next$iv$iv;
                                                                } else {
                                                                    if (mutableVector2 == null) {
                                                                        count$iv$iv = count$iv$iv2;
                                                                        success2 = success3;
                                                                        this_$iv4 = this_$iv2;
                                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        count$iv$iv = count$iv$iv2;
                                                                        success2 = success3;
                                                                        this_$iv4 = this_$iv2;
                                                                        mutableVector = mutableVector2;
                                                                    }
                                                                    MutableVector mutableVector3 = mutableVector;
                                                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv;
                                                                    if (theNode$iv$iv != null) {
                                                                        if (mutableVector3 != null) {
                                                                            mutableVector3.add(theNode$iv$iv);
                                                                        }
                                                                        this_$iv$iv$iv = null;
                                                                    }
                                                                    if (mutableVector3 != null) {
                                                                        mutableVector3.add(next$iv$iv);
                                                                    }
                                                                    mutableVector2 = mutableVector3;
                                                                    count$iv$iv2 = count$iv$iv;
                                                                }
                                                            } else {
                                                                success2 = success3;
                                                                this_$iv4 = this_$iv2;
                                                                Modifier.Node node3 = next$iv$iv;
                                                            }
                                                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                                            Function1<? super FocusTargetNode, Boolean> function12 = onFound;
                                                            success3 = success2;
                                                            this_$iv2 = this_$iv4;
                                                        }
                                                        success = success3;
                                                        this_$iv3 = this_$iv2;
                                                        if (count$iv$iv2 == 1) {
                                                            branches$iv$iv = branches$iv$iv2;
                                                            child$iv$iv = child$iv$iv2;
                                                            success3 = success;
                                                            this_$iv2 = this_$iv3;
                                                        }
                                                    }
                                                }
                                                this_$iv$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                                                branches$iv$iv = branches$iv$iv2;
                                                child$iv$iv = child$iv$iv2;
                                                success3 = success;
                                                this_$iv2 = this_$iv3;
                                            }
                                            boolean z3 = success3;
                                            i2 = 0;
                                            child$iv$iv3 = child$iv$iv;
                                            this_$iv5 = this_$iv2;
                                        } else {
                                            boolean z4 = success3;
                                            MutableVector this_$iv7 = this_$iv2;
                                            int i4 = i2;
                                            node$iv$iv = node$iv$iv.getChild$ui_release();
                                            child$iv$iv3 = child$iv$iv;
                                            this_$iv5 = this_$iv7;
                                        }
                                    }
                                } else {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                                }
                            }
                            i$iv++;
                            if (i$iv >= size$iv) {
                                break;
                            }
                            i2 = i;
                            $i$f$findFocusTarget = $i$f$findFocusTarget2;
                            this_$iv5 = this_$iv;
                        } else {
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                    }
                } else {
                    MutableVector mutableVector4 = this_$iv5;
                }
                return success3;
            } else {
                throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
            }
        } else {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        }
    }
}
