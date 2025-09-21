package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\rH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0014X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds = new MutableVector<>(new PointerId[16], 0);
    private final Map<PointerId, PointerInputChange> relevantChanges = new LinkedHashMap();
    private boolean wasIn;

    public Node(Modifier.Node modifierNode2) {
        Intrinsics.checkNotNullParameter(modifierNode2, "modifierNode");
        this.modifierNode = modifierNode2;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean z;
        MutableVector mutableVector;
        Node this_$iv;
        int count$iv;
        MutableVector mutableVector2;
        InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent2, "internalPointerEvent");
        Node this_$iv2 = this;
        if (this_$iv2.relevantChanges.isEmpty() || !this_$iv2.modifierNode.isAttached()) {
            return false;
        }
        PointerEvent event = this.pointerEvent;
        Intrinsics.checkNotNull(event);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long size = layoutCoordinates.m4650getSizeYbymL2g();
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.modifierNode;
        int kind$iv = NodeKind.m4956constructorimpl(16);
        MutableVector mutableVector3 = null;
        Modifier.Node this_$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (this_$iv$iv != null) {
            if (this_$iv$iv instanceof PointerInputModifierNode) {
                this_$iv = this_$iv2;
                ((PointerInputModifierNode) this_$iv$iv).m5015onPointerEventH0pRuoY(event, PointerEventPass.Initial, size);
            } else {
                this_$iv = this_$iv2;
                if (((this_$iv$iv.getKindSet$ui_release() & kind$iv) != 0) && (this_$iv$iv instanceof DelegatingNode)) {
                    int count$iv2 = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet$ui_release() & kind$iv) != 0) {
                            count$iv2++;
                            if (count$iv2 == 1) {
                                this_$iv$iv = next$iv;
                                Modifier.Node node = next$iv;
                            } else {
                                if (mutableVector3 == null) {
                                    count$iv = count$iv2;
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    count$iv = count$iv2;
                                    mutableVector2 = mutableVector3;
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv = this_$iv$iv;
                                if (theNode$iv != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv);
                                    }
                                    this_$iv$iv = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv);
                                }
                                count$iv2 = count$iv;
                            }
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        Map<PointerId, PointerInputChange> map = changes;
                        LayoutCoordinates layoutCoordinates2 = parentCoordinates;
                    }
                    if (count$iv2 == 1) {
                        Map<PointerId, PointerInputChange> map2 = changes;
                        LayoutCoordinates layoutCoordinates3 = parentCoordinates;
                        this_$iv2 = this_$iv;
                    }
                }
            }
            this_$iv$iv = DelegatableNodeKt.pop(mutableVector3);
            Map<PointerId, PointerInputChange> map3 = changes;
            LayoutCoordinates layoutCoordinates4 = parentCoordinates;
            this_$iv2 = this_$iv;
        }
        if (this.modifierNode.isAttached()) {
            MutableVector this_$iv3 = getChildren();
            int size$iv = this_$iv3.getSize();
            if (size$iv > 0) {
                int i$iv = 0;
                Object[] content$iv = this_$iv3.getContent();
                while (true) {
                    Map<PointerId, PointerInputChange> map4 = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates5 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates5);
                    MutableVector this_$iv4 = this_$iv3;
                    ((Node) content$iv[i$iv]).dispatchMainEventPass(map4, layoutCoordinates5, internalPointerEvent2, isInBounds);
                    i$iv++;
                    if (i$iv >= size$iv) {
                        break;
                    }
                    this_$iv3 = this_$iv4;
                }
            } else {
                boolean z2 = isInBounds;
            }
        } else {
            boolean z3 = isInBounds;
        }
        if (this.modifierNode.isAttached()) {
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2 = this.modifierNode;
            int kind$iv2 = NodeKind.m4956constructorimpl(16);
            MutableVector mutableVector4 = null;
            Modifier.Node this_$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
            while (this_$iv$iv2 != null) {
                if (this_$iv$iv2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) this_$iv$iv2).m5015onPointerEventH0pRuoY(event, PointerEventPass.Main, size);
                } else {
                    if (((this_$iv$iv2.getKindSet$ui_release() & kind$iv2) != 0) && (this_$iv$iv2 instanceof DelegatingNode)) {
                        int count$iv3 = 0;
                        Modifier.Node node$iv$iv2 = ((DelegatingNode) this_$iv$iv2).getDelegate$ui_release();
                        while (node$iv$iv2 != null) {
                            Modifier.Node next$iv2 = node$iv$iv2;
                            if ((next$iv2.getKindSet$ui_release() & kind$iv2) != 0) {
                                count$iv3++;
                                if (count$iv3 == 1) {
                                    this_$iv$iv2 = next$iv2;
                                    Modifier.Node node2 = next$iv2;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    } else {
                                        mutableVector = mutableVector4;
                                    }
                                    mutableVector4 = mutableVector;
                                    Modifier.Node theNode$iv2 = this_$iv$iv2;
                                    if (theNode$iv2 != null) {
                                        if (mutableVector4 != null) {
                                            mutableVector4.add(theNode$iv2);
                                        }
                                        this_$iv$iv2 = null;
                                    }
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(next$iv2);
                                    }
                                }
                            }
                            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                            InternalPointerEvent internalPointerEvent3 = internalPointerEvent;
                            boolean z4 = isInBounds;
                        }
                        if (count$iv3 == 1) {
                            InternalPointerEvent internalPointerEvent4 = internalPointerEvent;
                            boolean z5 = isInBounds;
                        }
                    }
                }
                this_$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                InternalPointerEvent internalPointerEvent5 = internalPointerEvent;
                boolean z6 = isInBounds;
            }
            z = true;
        } else {
            z = true;
        }
        return z;
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        boolean z;
        boolean z2;
        int i;
        int $i$f$dispatchIfNeeded;
        Node this_$iv;
        int i2;
        int $i$f$dispatchIfNeeded2;
        Node this_$iv2;
        MutableVector mutableVector;
        InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        Intrinsics.checkNotNullParameter(internalPointerEvent2, "internalPointerEvent");
        Node this_$iv3 = this;
        int $i$f$dispatchIfNeeded3 = false;
        if (this_$iv3.relevantChanges.isEmpty()) {
            z = false;
        } else if (!this_$iv3.modifierNode.isAttached()) {
            z = false;
        } else {
            int i3 = false;
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.m4650getSizeYbymL2g();
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.modifierNode;
            int kind$iv = NodeKind.m4956constructorimpl(16);
            MutableVector mutableVector2 = null;
            Modifier.Node this_$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
            while (true) {
                int i4 = 1;
                if (this_$iv$iv == null) {
                    break;
                }
                if (this_$iv$iv instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) this_$iv$iv).m5015onPointerEventH0pRuoY(event, PointerEventPass.Final, size);
                    this_$iv = this_$iv3;
                    $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded3;
                    i = i3;
                } else {
                    if (((this_$iv$iv.getKindSet$ui_release() & kind$iv) != 0 ? 1 : null) == null || !(this_$iv$iv instanceof DelegatingNode)) {
                        this_$iv = this_$iv3;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded3;
                        i = i3;
                    } else {
                        int count$iv = 0;
                        Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if (((next$iv.getKindSet$ui_release() & kind$iv) != 0 ? i4 : 0) != 0) {
                                count$iv++;
                                if (count$iv == i4) {
                                    this_$iv$iv = next$iv;
                                    this_$iv2 = this_$iv3;
                                    $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                    i2 = i3;
                                    Modifier.Node node = next$iv;
                                } else {
                                    if (mutableVector2 == null) {
                                        this_$iv2 = this_$iv3;
                                        $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                        i2 = i3;
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    } else {
                                        this_$iv2 = this_$iv3;
                                        $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                        i2 = i3;
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
                                this_$iv2 = this_$iv3;
                                $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded3;
                                i2 = i3;
                                Modifier.Node node2 = next$iv;
                            }
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            this_$iv3 = this_$iv2;
                            $i$f$dispatchIfNeeded3 = $i$f$dispatchIfNeeded2;
                            i3 = i2;
                            i4 = 1;
                        }
                        this_$iv = this_$iv3;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded3;
                        i = i3;
                        if (count$iv == 1) {
                            this_$iv3 = this_$iv;
                            $i$f$dispatchIfNeeded3 = $i$f$dispatchIfNeeded;
                            i3 = i;
                        }
                    }
                }
                this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
                this_$iv3 = this_$iv;
                $i$f$dispatchIfNeeded3 = $i$f$dispatchIfNeeded;
                i3 = i;
            }
            int i5 = $i$f$dispatchIfNeeded3;
            int i6 = i3;
            if (this.modifierNode.isAttached()) {
                MutableVector this_$iv4 = getChildren();
                int size$iv = this_$iv4.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv4.getContent();
                    do {
                        ((Node) content$iv[i$iv]).dispatchFinalEventPass(internalPointerEvent2);
                        z2 = true;
                        i$iv++;
                    } while (i$iv < size$iv);
                } else {
                    z2 = true;
                }
            } else {
                z2 = true;
            }
            z = z2;
        }
        boolean result = z;
        cleanUpHits(internalPointerEvent);
        clearCache();
        return result;
    }

    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Object it$iv;
        boolean z;
        boolean z2;
        int i;
        int kind$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int kind$iv2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        MutableVector mutableVector;
        Map<PointerId, PointerInputChange> map = changes;
        LayoutCoordinates layoutCoordinates = parentCoordinates;
        InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        Intrinsics.checkNotNullParameter(map, "changes");
        Intrinsics.checkNotNullParameter(layoutCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent2, "internalPointerEvent");
        boolean childChanged = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        int i2 = 1;
        if (!this.modifierNode.isAttached()) {
            return true;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3 = this.modifierNode;
        int kind$iv3 = NodeKind.m4956constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node this_$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
        while (this_$iv$iv != null) {
            if (this_$iv$iv instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) this_$iv$iv);
                $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                kind$iv = kind$iv3;
            } else {
                if (((this_$iv$iv.getKindSet$ui_release() & kind$iv3) != 0 ? i2 : 0) == 0 || !(this_$iv$iv instanceof DelegatingNode)) {
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    kind$iv = kind$iv3;
                } else {
                    int count$iv = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet$ui_release() & kind$iv3) != 0 ? i2 : 0) != 0) {
                            count$iv++;
                            if (count$iv == i2) {
                                this_$iv$iv = next$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                kind$iv2 = kind$iv3;
                                Modifier.Node node = next$iv;
                            } else {
                                if (mutableVector2 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                    kind$iv2 = kind$iv3;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
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
                            $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                            kind$iv2 = kind$iv3;
                            Modifier.Node node2 = next$iv;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                        kind$iv3 = kind$iv2;
                        i2 = 1;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    kind$iv = kind$iv3;
                    if (count$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv;
                        kind$iv3 = kind$iv;
                        i2 = 1;
                    }
                }
            }
            this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
            $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv;
            kind$iv3 = kind$iv;
            i2 = 1;
        }
        int i3 = kind$iv3;
        Iterator<Map.Entry<PointerId, PointerInputChange>> it = changes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            long key = ((PointerId) next.getKey()).m4466unboximpl();
            PointerInputChange change = (PointerInputChange) next.getValue();
            long keyValue = key;
            boolean keyInPointerIds = false;
            int i4 = 0;
            int size = this.pointerIds.getSize() - 1;
            if (0 <= size) {
                while (true) {
                    if (((PointerId) this.pointerIds.getContent()[i4]).m4466unboximpl() != keyValue) {
                        if (i4 == size) {
                            break;
                        }
                        i4++;
                    } else {
                        keyInPointerIds = true;
                        break;
                    }
                }
            }
            if (keyInPointerIds) {
                ArrayList historical = new ArrayList(change.getHistorical().size());
                List $this$fastForEach$iv = change.getHistorical();
                int size2 = $this$fastForEach$iv.size();
                Iterator<Map.Entry<PointerId, PointerInputChange>> it2 = it;
                int index$iv = 0;
                while (index$iv < size2) {
                    HistoricalChange it3 = $this$fastForEach$iv.get(index$iv);
                    long uptimeMillis = it3.getUptimeMillis();
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    historical.add(new HistoricalChange(uptimeMillis, layoutCoordinates2.m4651localPositionOfR5De75A(layoutCoordinates, it3.m4408getPositionF1C5BW0()), (DefaultConstructorMarker) null));
                    index$iv++;
                    size2 = size2;
                    keyValue = keyValue;
                    keyInPointerIds = keyInPointerIds;
                }
                boolean z3 = keyInPointerIds;
                Map<PointerId, PointerInputChange> map2 = this.relevantChanges;
                PointerId r9 = PointerId.m4460boximpl(key);
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                long r30 = layoutCoordinates3.m4651localPositionOfR5De75A(layoutCoordinates, change.m4481getPreviousPositionF1C5BW0());
                LayoutCoordinates layoutCoordinates4 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates4);
                map2.put(r9, PointerInputChange.m4470copyOHpmEuE$default(change, 0, 0, layoutCoordinates4.m4651localPositionOfR5De75A(layoutCoordinates, change.m4480getPositionF1C5BW0()), false, 0, r30, false, 0, historical, 0, 731, (Object) null));
                it = it2;
            } else {
                Iterator<Map.Entry<PointerId, PointerInputChange>> it4 = it;
                long j = keyValue;
                boolean z4 = keyInPointerIds;
            }
        }
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        for (int i5 = this.pointerIds.getSize() - 1; -1 < i5; i5--) {
            if (!map.containsKey(PointerId.m4460boximpl(((PointerId) this.pointerIds.getContent()[i5]).m4466unboximpl()))) {
                this.pointerIds.removeAt(i5);
            }
        }
        PointerEvent event = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent2);
        List $this$fastForEach$iv$iv = event.getChanges();
        int index$iv$iv = 0;
        int size3 = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size3) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (internalPointerEvent2.m4410issuesEnterExitEvent0FcD4WY(((PointerInputChange) it$iv).m4479getIdJ3iCeTQ())) {
                break;
            }
            index$iv$iv++;
            Map<PointerId, PointerInputChange> map3 = changes;
            LayoutCoordinates layoutCoordinates5 = parentCoordinates;
        }
        PointerInputChange enterExitChange = (PointerInputChange) it$iv;
        if (enterExitChange != null) {
            if (!isInBounds) {
                z2 = false;
                this.isIn = false;
                z = true;
            } else {
                z2 = false;
                if (this.isIn) {
                    z = true;
                } else if (enterExitChange.getPressed() || enterExitChange.getPreviousPressed()) {
                    LayoutCoordinates layoutCoordinates6 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates6);
                    z = true;
                    this.isIn = !PointerEventKt.m4425isOutOfBoundsO0kMr_c(enterExitChange, layoutCoordinates6.m4650getSizeYbymL2g());
                } else {
                    z = true;
                }
            }
            if (this.isIn != this.wasIn && (PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4436getMove7fucELk()) || PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4434getEnter7fucELk()) || PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4435getExit7fucELk()))) {
                if (this.isIn) {
                    i = PointerEventType.Companion.m4434getEnter7fucELk();
                } else {
                    i = PointerEventType.Companion.m4435getExit7fucELk();
                }
                event.m4424setTypeEhbLWgg$ui_release(i);
            } else if (PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4434getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                event.m4424setTypeEhbLWgg$ui_release(PointerEventType.Companion.m4436getMove7fucELk());
            } else if (PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4435getExit7fucELk()) && this.isIn && enterExitChange.getPressed()) {
                event.m4424setTypeEhbLWgg$ui_release(PointerEventType.Companion.m4436getMove7fucELk());
            }
        } else {
            z2 = false;
            z = true;
        }
        boolean changed = (childChanged || !PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4436getMove7fucELk()) || hasPositionChanged(this.pointerEvent, event)) ? z : z2;
        this.pointerEvent = event;
        return changed;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m3000equalsimpl0(oldEvent.getChanges().get(i).m4480getPositionF1C5BW0(), newEvent.getChanges().get(i).m4480getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.isAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    public void dispatchCancel() {
        int i;
        MutableVector mutableVector;
        MutableVector this_$iv = getChildren();
        int size$iv = this_$iv.getSize();
        int i2 = 1;
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                ((Node) content$iv[i$iv]).dispatchCancel();
                i$iv++;
            } while (i$iv < size$iv);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.modifierNode;
        int kind$iv = NodeKind.m4956constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node this_$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (this_$iv$iv != null) {
            if (this_$iv$iv instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) this_$iv$iv).onCancelPointerInput();
                i = i2;
            } else {
                if (((this_$iv$iv.getKindSet$ui_release() & kind$iv) != 0 ? i2 : 0) == 0 || !(this_$iv$iv instanceof DelegatingNode)) {
                    i = i2;
                } else {
                    int count$iv = 0;
                    Modifier.Node node$iv$iv = ((DelegatingNode) this_$iv$iv).getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet$ui_release() & kind$iv) != 0 ? i2 : 0) != 0) {
                            count$iv++;
                            if (count$iv == i2) {
                                this_$iv$iv = next$iv;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                } else {
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
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        i2 = 1;
                    }
                    i = 1;
                    if (count$iv == 1) {
                        i2 = 1;
                    }
                }
            }
            this_$iv$iv = DelegatableNodeKt.pop(mutableVector2);
            i2 = i;
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent event = this.pointerEvent;
        if (event != null) {
            this.wasIn = this.isIn;
            List $this$fastForEach$iv = event.getChanges();
            int index$iv = 0;
            int size = $this$fastForEach$iv.size();
            while (true) {
                boolean remove = false;
                if (index$iv < size) {
                    PointerInputChange change = $this$fastForEach$iv.get(index$iv);
                    if (!change.getPressed() && (!internalPointerEvent.m4410issuesEnterExitEvent0FcD4WY(change.m4479getIdJ3iCeTQ()) || !this.isIn)) {
                        remove = true;
                    }
                    if (remove) {
                        this.pointerIds.remove(PointerId.m4460boximpl(change.m4479getIdJ3iCeTQ()));
                    }
                    index$iv++;
                } else {
                    this.isIn = false;
                    this.hasExited = PointerEventType.m4430equalsimpl0(event.m4423getType7fucELk(), PointerEventType.Companion.m4435getExit7fucELk());
                    return;
                }
            }
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
