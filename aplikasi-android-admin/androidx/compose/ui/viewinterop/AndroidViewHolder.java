package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010T\u001a\u00020\u00172\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u000e\u0010W\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`XJ\n\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020\tH\u0016J\u001e\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020\u0017H\u0016J \u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\tH\u0002J\b\u0010e\u001a\u000200H\u0014J\b\u0010f\u001a\u000200H\u0016J\u0018\u0010g\u001a\u0002002\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020\rH\u0016J\b\u0010j\u001a\u000200H\u0014J0\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020\tH\u0014J\u0018\u0010q\u001a\u0002002\u0006\u0010r\u001a\u00020\t2\u0006\u0010s\u001a\u00020\tH\u0014J(\u0010t\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\r2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020\u0017H\u0016J \u0010y\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\r2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020vH\u0016J0\u0010z\u001a\u0002002\u0006\u0010i\u001a\u00020\r2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\t2\u0006\u0010x\u001a\u00020%2\u0006\u0010}\u001a\u00020\tH\u0016J;\u0010~\u001a\u0002002\u0006\u0010i\u001a\u00020\r2\u0006\u0010\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010}\u001a\u00020\tH\u0016JC\u0010~\u001a\u0002002\u0006\u0010i\u001a\u00020\r2\u0006\u0010\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010x\u001a\u00020%H\u0016J*\u0010\u0001\u001a\u0002002\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010}\u001a\u00020\tH\u0016J\t\u0010\u0001\u001a\u000200H\u0016J\t\u0010\u0001\u001a\u000200H\u0016J*\u0010\u0001\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010}\u001a\u00020\tH\u0016J\u0019\u0010\u0001\u001a\u0002002\u0006\u0010i\u001a\u00020\r2\u0006\u0010}\u001a\u00020\tH\u0016J\u0012\u0010\u0001\u001a\u0002002\u0007\u0010\u0001\u001a\u00020\tH\u0014J\u0007\u0010\u0001\u001a\u000200J\u0012\u0010\u0001\u001a\u0002002\u0007\u0010\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0001\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020&@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002000/X\u0004¢\u0006\u0002\n\u0000R(\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000200\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00106\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u000200\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R(\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u000200\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R0\u0010>\u001a\b\u0012\u0004\u0012\u0002000=2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002000=@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR0\u0010C\u001a\b\u0012\u0004\u0012\u0002000=2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002000=@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u0014\u0010F\u001a\b\u0012\u0004\u0012\u0002000=X\u0004¢\u0006\u0002\n\u0000R(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\u000f\u001a\u0004\u0018\u00010G@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R0\u0010O\u001a\b\u0012\u0004\u0012\u0002000=2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002000=@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010@\"\u0004\bQ\u0010BR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHash", "", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "view", "Landroid/view/View;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "<set-?>", "Lkotlin/Function0;", "release", "getRelease", "()Lkotlin/jvm/functions/Function0;", "setRelease", "(Lkotlin/jvm/functions/Function0;)V", "reset", "getReset", "setReset", "runUpdate", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "setUpdate", "getView", "()Landroid/view/View;", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDeactivate", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onRelease", "onReuse", "onStartNestedScroll", "onStopNestedScroll", "onWindowVisibilityChanged", "visibility", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback {
    private final int compositeKeyHash;
    private Density density;
    /* access modifiers changed from: private */
    public final NestedScrollDispatcher dispatcher;
    /* access modifiers changed from: private */
    public boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    /* access modifiers changed from: private */
    public final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private Function0<Unit> release;
    private Function0<Unit> reset;
    /* access modifiers changed from: private */
    public final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    /* access modifiers changed from: private */
    public final SnapshotStateObserver snapshotObserver;
    private Function0<Unit> update;
    private final View view;

    public final View getView() {
        return this.view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(Context context, CompositionContext parentContext, int compositeKeyHash2, NestedScrollDispatcher dispatcher2, View view2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.compositeKeyHash = compositeKeyHash2;
        this.dispatcher = dispatcher2;
        this.view = view2;
        if (parentContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, parentContext);
        }
        setSaveFromParentEnabled(false);
        addView(view2);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        this.reset = AndroidViewHolder$reset$1.INSTANCE;
        this.release = AndroidViewHolder$release$1.INSTANCE;
        this.modifier = Modifier.Companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        AndroidViewHolder $this$layoutNode_u24lambda_u241 = this;
        LayoutNode layoutNode2 = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        layoutNode2.setInteropViewFactoryHolder$ui_release(this);
        Modifier coreModifier = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(Modifier.Companion, AndroidViewHolder_androidKt.NoOpScrollConnection, $this$layoutNode_u24lambda_u241.dispatcher), true, AndroidViewHolder$layoutNode$1$coreModifier$1.INSTANCE), $this$layoutNode_u24lambda_u241), new AndroidViewHolder$layoutNode$1$coreModifier$2(layoutNode2, this)), new AndroidViewHolder$layoutNode$1$coreModifier$3($this$layoutNode_u24lambda_u241, layoutNode2));
        layoutNode2.setCompositeKeyHash($this$layoutNode_u24lambda_u241.compositeKeyHash);
        layoutNode2.setModifier($this$layoutNode_u24lambda_u241.modifier.then(coreModifier));
        $this$layoutNode_u24lambda_u241.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(layoutNode2, coreModifier);
        layoutNode2.setDensity($this$layoutNode_u24lambda_u241.density);
        $this$layoutNode_u24lambda_u241.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(layoutNode2);
        layoutNode2.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3($this$layoutNode_u24lambda_u241, layoutNode2));
        layoutNode2.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4($this$layoutNode_u24lambda_u241));
        layoutNode2.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5($this$layoutNode_u24lambda_u241, layoutNode2));
        this.layoutNode = layoutNode2;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    /* access modifiers changed from: protected */
    public final void setUpdate(Function0<Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.update = value;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Function0<Unit> getReset() {
        return this.reset;
    }

    /* access modifiers changed from: protected */
    public final void setReset(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.reset = function0;
    }

    public final Function0<Unit> getRelease() {
        return this.release;
    }

    /* access modifiers changed from: protected */
    public final void setRelease(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.release = function0;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.modifier) {
            this.modifier = value;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.density) {
            this.density = value;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner value) {
        if (value != this.lifecycleOwner) {
            this.lifecycleOwner = value;
            ViewTreeLifecycleOwner.set(this, value);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner value) {
        if (value != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = value;
            ViewTreeSavedStateRegistryOwner.set(this, value);
        }
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    public void onReuse() {
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    public void onRelease() {
        this.release.invoke();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            return;
        }
        this.view.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = widthMeasureSpec;
        this.lastHeightMeasureSpec = heightMeasureSpec;
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 != Integer.MIN_VALUE && (i = this.lastHeightMeasureSpec) != Integer.MIN_VALUE) {
            measure(i2, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        this.view.layout(0, 0, r - l, b - t);
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-1, -1);
        }
        return layoutParams;
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(disallowIntercept));
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    public ViewParent invalidateChildInParent(int[] location2, Rect dirty) {
        super.invalidateChildInParent(location2, dirty);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    public void onDescendantInvalidated(View child, View target) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        super.onDescendantInvalidated(child, target);
        this.layoutNode.invalidateLayer$ui_release();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i = iArr[0];
        region.op(i, iArr[1], i + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* access modifiers changed from: private */
    public final int obtainMeasureSpec(int min, int max, int preferred) {
        if (preferred >= 0 || min == max) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(preferred, min, max), BasicMeasure.EXACTLY);
        }
        if (preferred == -2 && max != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
        }
        if (preferred != -1 || max == Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY);
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        return ((axes & 2) == 0 && (axes & 1) == 0) ? false : true;
    }

    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    public void onStopNestedScroll(View target, int type) {
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            long consumedByParent = this.dispatcher.m6072dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(dxConsumed), AndroidViewHolder_androidKt.toComposeOffset(dyConsumed)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed), AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m4713getXimpl(consumedByParent));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m4714getYimpl(consumedByParent));
        }
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m6072dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(dxConsumed), AndroidViewHolder_androidKt.toComposeOffset(dyConsumed)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed), AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
        }
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            long consumedByParent = this.dispatcher.m6074dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(dx), AndroidViewHolder_androidKt.toComposeOffset(dy)), AndroidViewHolder_androidKt.toNestedScrollSource(type));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m4713getXimpl(consumedByParent));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m4714getYimpl(consumedByParent));
        }
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedFling$1(consumed, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(velocityX), AndroidViewHolder_androidKt.toComposeVelocity(velocityY)), (Continuation<? super AndroidViewHolder$onNestedFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, TypedValues.AttributesType.S_TARGET);
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(velocityX), AndroidViewHolder_androidKt.toComposeVelocity(velocityY)), (Continuation<? super AndroidViewHolder$onNestedPreFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }
}
