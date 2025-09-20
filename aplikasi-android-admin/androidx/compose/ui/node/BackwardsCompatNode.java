package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000fB\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020\u001eH\u0002J\b\u0010A\u001a\u00020\u001eH\u0016J\b\u0010B\u001a\u00020<H\u0016J\b\u0010C\u001a\u00020<H\u0016J\b\u0010D\u001a\u00020<H\u0016J\r\u0010E\u001a\u00020<H\u0000¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\"H\u0016J\b\u0010L\u001a\u00020<H\u0016J\u0010\u0010M\u001a\u00020<2\u0006\u0010K\u001a\u00020\"H\u0016J-\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001d\u0010W\u001a\u00020<2\u0006\u00103\u001a\u00020TH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020\u001eH\u0016J\b\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020<H\u0002J\b\u0010^\u001a\u00020<H\u0002J\u0006\u0010_\u001a\u00020<J\u0014\u0010`\u001a\u00020<2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030aH\u0002J\f\u0010b\u001a\u00020<*\u00020cH\u0016J\f\u0010d\u001a\u00020<*\u00020eH\u0016J\u001c\u0010f\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020gH\u0016J\u001c\u0010l\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010m\u001a\u00020gH\u0016J)\u0010n\u001a\u00020o*\u00020p2\u0006\u0010i\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bt\u0010uJ\u001c\u0010v\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020gH\u0016J\u001c\u0010w\u001a\u00020g*\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010m\u001a\u00020gH\u0016J\u0018\u0010x\u001a\u0004\u0018\u00010y*\u00020\u00162\b\u0010z\u001a\u0004\u0018\u00010yH\u0016R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0012R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R2\u0010+\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0,j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-`.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001d\u00103\u001a\u0002048VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b5\u00106R$\u00107\u001a\u0002H8\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u0002H80-8VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006{"}, d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "invalidateCache", "", "isValidOwnerScope", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "initializeModifier", "duringAttach", "interceptOutOfBoundsChildEvents", "onAttach", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "onMeasureResultChanged", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "sharePointerInputWithSiblings", "toString", "", "unInitializeModifier", "updateDrawCache", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    private boolean invalidateCache = true;
    /* access modifiers changed from: private */
    public LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues = new HashSet<>();

    public BackwardsCompatNode(Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element2, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        this.element = element2;
    }

    public final Modifier.Element getElement() {
        return this.element;
    }

    public final void setElement(Modifier.Element value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = value;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(value));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public void onAttach() {
        initializeModifier(true);
    }

    public void onDetach() {
        unInitializeModifier();
    }

    private final void unInitializeModifier() {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            boolean z = true;
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(32)) != 0 ? 1 : null) != null) {
                if (element2 instanceof ModifierLocalProvider) {
                    DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element2).getKey());
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    ((ModifierLocalConsumer) element2).onModifierLocalsUpdated(BackwardsCompatNodeKt.DetachedModifierLocalReadScope);
                }
            }
            if ((getKindSet$ui_release() & NodeKind.m6666constructorimpl(8)) == 0) {
                z = false;
            }
            if (z) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
            }
            if (element2 instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element2).getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void initializeModifier(boolean duringAttach) {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            boolean z = false;
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(32)) != 0 ? 1 : null) != null) {
                if (element2 instanceof ModifierLocalConsumer) {
                    sideEffect(new BackwardsCompatNode$initializeModifier$1(this));
                }
                if (element2 instanceof ModifierLocalProvider) {
                    updateModifierLocalProvider((ModifierLocalProvider) element2);
                }
            }
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(4)) != 0 ? 1 : null) != null) {
                if (element2 instanceof DrawCacheModifier) {
                    this.invalidateCache = true;
                }
                if (!duringAttach) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                }
            }
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(2)) != 0 ? 1 : null) != null) {
                if (BackwardsCompatNodeKt.isChainUpdate(this)) {
                    NodeCoordinator coordinator = getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator);
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator;
                    ((LayoutModifierNodeCoordinator) coordinator).setLayoutModifierNode$ui_release(this);
                    coordinator.onLayoutModifierNodeChanged();
                }
                if (!duringAttach) {
                    LayoutModifierNodeKt.invalidateLayer(this);
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
            }
            if (element2 instanceof RemeasurementModifier) {
                ((RemeasurementModifier) element2).onRemeasurementAvailable(DelegatableNodeKt.requireLayoutNode(this));
            }
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(128)) != 0 ? 1 : null) != null) {
                if ((element2 instanceof OnRemeasuredModifier) && BackwardsCompatNodeKt.isChainUpdate(this)) {
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
                if (element2 instanceof OnPlacedModifier) {
                    this.lastOnPlacedCoordinates = null;
                    if (BackwardsCompatNodeKt.isChainUpdate(this)) {
                        DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new BackwardsCompatNode$initializeModifier$2(this));
                    }
                }
            }
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(256)) != 0 ? 1 : null) != null && (element2 instanceof OnGloballyPositionedModifier) && BackwardsCompatNodeKt.isChainUpdate(this)) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (element2 instanceof FocusRequesterModifier) {
                ((FocusRequesterModifier) element2).getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
            }
            if (((getKindSet$ui_release() & NodeKind.m6666constructorimpl(16)) != 0 ? 1 : null) != null && (element2 instanceof PointerInputModifier)) {
                ((PointerInputModifier) element2).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
            }
            if ((getKindSet$ui_release() & NodeKind.m6666constructorimpl(8)) != 0) {
                z = true;
            }
            if (z) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m6484getSizeNHjbRc() {
        return IntSizeKt.m7724toSizeozmzZPI(DelegatableNodeKt.m6502requireCoordinator64DMado(this, NodeKind.m6666constructorimpl(128)).m6640getSizeYbymL2g());
    }

    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final void updateDrawCache() {
        Modifier.Element element2 = this.element;
        if (element2 instanceof DrawCacheModifier) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.onDrawCacheReadsChanged, new BackwardsCompatNode$updateDrawCache$1(element2, this));
        }
        this.invalidateCache = false;
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalModifierNodeKt.modifierLocalMapOf();
    }

    public <T> T getCurrent(ModifierLocal<T> $this$current) {
        int type$iv;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        NodeChain nodes$ui_release;
        int type$iv2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int type$iv3;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
        int type$iv4;
        int count$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$current, "<this>");
        ModifierLocal key = $this$current;
        this.readValues.add(key);
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = this;
        int type$iv5 = NodeKind.m6666constructorimpl(32);
        int mask$iv$iv = type$iv5;
        DelegatableNode $this$visitAncestors$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
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
                                if (node instanceof ModifierLocalModifierNode) {
                                    ModifierLocalModifierNode it = (ModifierLocalModifierNode) node;
                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                                    if (it.getProvidedValues().contains$ui_release(key)) {
                                        return it.getProvidedValues().get$ui_release(key);
                                    }
                                    type$iv3 = type$iv2;
                                } else {
                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
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
                                                        count$iv$iv = count$iv$iv2;
                                                        type$iv4 = type$iv2;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        count$iv$iv = count$iv$iv2;
                                                        type$iv4 = type$iv2;
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
                                            ModifierLocal<T> modifierLocal = $this$current;
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                                            type$iv2 = type$iv3;
                                        }
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                                ModifierLocal<T> modifierLocal2 = $this$current;
                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                                type$iv2 = type$iv3;
                            }
                            continue;
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                        ModifierLocal<T> modifierLocal3 = $this$current;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        type$iv5 = type$iv2;
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv = type$iv2;
                } else {
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4;
                    type$iv = type$iv5;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                ModifierLocal<T> modifierLocal4 = $this$current;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                type$iv5 = type$iv;
            }
            return key.getDefaultFactory$ui_release().invoke();
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public final void updateModifierLocalConsumer() {
        if (isAttached()) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateModifierLocalConsumer, new BackwardsCompatNode$updateModifierLocalConsumer$1(this));
        }
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider<?> element2) {
        BackwardsCompatLocalMap providedValues = this._providedValues;
        if (providedValues == null || !providedValues.contains$ui_release(element2.getKey())) {
            this._providedValues = new BackwardsCompatLocalMap(element2);
            if (BackwardsCompatNodeKt.isChainUpdate(this)) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, element2.getKey());
                return;
            }
            return;
        }
        providedValues.setElement(element2);
        DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, element2.getKey());
    }

    public boolean isValidOwnerScope() {
        return isAttached();
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m6485measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).m6369measure3p2s80s($this$measure_u2d3p2s80s, measurable, constraints);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicWidth($this$minIntrinsicWidth, measurable, height);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicHeight($this$minIntrinsicHeight, measurable, width);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicWidth($this$maxIntrinsicWidth, measurable, height);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicHeight($this$maxIntrinsicHeight, measurable, width);
    }

    public void draw(ContentDrawScope $this$draw) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier $this$draw_u24lambda_u246 = (DrawModifier) element2;
        if (this.invalidateCache && (element2 instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        $this$draw_u24lambda_u246.draw($this$draw);
    }

    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Intrinsics.checkNotNullParameter($this$applySemantics, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        ((SemanticsConfiguration) $this$applySemantics).collapsePeer$ui_release(((SemanticsModifier) element2).getSemanticsConfiguration());
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m6486onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().m6211onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    public void onCancelPointerInput() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().onCancel();
    }

    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getShareWithSiblings();
    }

    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element2).modifyParentData($this$modifyParentData, parentData);
    }

    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element2).onGloballyPositioned(coordinates);
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m6487onRemeasuredozmzZPI(long size) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element2).m6429onRemeasuredozmzZPI(size);
        }
    }

    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.lastOnPlacedCoordinates = coordinates;
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element2).onPlaced(coordinates);
        }
    }

    public void onFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Modifier.Element focusEventModifier = this.element;
        if (focusEventModifier instanceof FocusEventModifier) {
            ((FocusEventModifier) focusEventModifier).onFocusEvent(focusState);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        Modifier.Element focusOrderModifier = this.element;
        if (focusOrderModifier instanceof FocusOrderModifier) {
            new FocusOrderModifierToProperties((FocusOrderModifier) focusOrderModifier).invoke(focusProperties);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public String toString() {
        return this.element.toString();
    }
}
