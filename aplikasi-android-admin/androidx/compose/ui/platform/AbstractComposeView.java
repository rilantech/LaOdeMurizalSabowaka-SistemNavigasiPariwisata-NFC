package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.Owner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010*\u001a\u00020\u0012H'¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001c\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u0007H\u0016J$\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\"\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J$\u00104\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0014J,\u00104\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00105\u001a\u00020\u000fH\u0014J\b\u00106\u001a\u00020\u0012H\u0002J\u0006\u00107\u001a\u00020\u0012J\u0006\u00108\u001a\u00020\u0012J\b\u00109\u001a\u00020\u0012H\u0002J5\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0010¢\u0006\u0002\b@J\u001d\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0010¢\u0006\u0002\bDJ\b\u0010E\u001a\u00020\u000fH\u0016J\b\u0010F\u001a\u00020\u0012H\u0014J0\u0010G\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0004J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0004J\u0010\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0007H\u0016J\b\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010N\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u000fH\u0016J\u000e\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020\u000fH\u0016J\f\u0010S\u001a\u00020\u000b*\u00020\u000bH\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001d@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0017R,\u0010#\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f8F@FX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010'R\u0018\u0010(\u001a\u00020\u000f*\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006T"}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "composition", "Landroidx/compose/runtime/Composition;", "creatingComposition", "", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "", "getDisposeViewCompositionStrategy$annotations", "()V", "hasComposition", "getHasComposition", "()Z", "isTransitionGroupSet", "value", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "addView", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "addViewInLayout", "preventRequestLayout", "checkAddView", "createComposition", "disposeComposition", "ensureCompositionCreated", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "isTransitionGroup", "onAttachedToWindow", "onLayout", "onMeasure", "onRtlPropertiesChanged", "layoutDirection", "resolveParentCompositionContext", "setParentCompositionContext", "parent", "setTransitionGroup", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldDelayChildPressedState", "cacheIfAlive", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeView.android.kt */
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbstractComposeView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public abstract void Content(Composer composer, int i);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractComposeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipChildren(false);
        setClipToPadding(false);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.Companion.getDefault().installFor(this);
    }

    private final void setPreviousAttachedWindowToken(IBinder value) {
        if (this.previousAttachedWindowToken != value) {
            this.previousAttachedWindowToken = value;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    private final void setParentContext(CompositionContext value) {
        if (this.parentContext != value) {
            this.parentContext = value;
            if (value != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition old = this.composition;
            if (old != null) {
                old.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    public final void setParentCompositionContext(CompositionContext parent) {
        setParentContext(parent);
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.installFor(this);
    }

    /* access modifiers changed from: protected */
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public final void setShowLayoutBounds(boolean value) {
        this.showLayoutBounds = value;
        View it = getChildAt(0);
        if (it != null) {
            ((Owner) it).setShowLayoutBounds(value);
        }
    }

    public final void createComposition() {
        if (this.parentContext != null || isAttachedToWindow()) {
            ensureCompositionCreated();
            return;
        }
        throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
    }

    private final void checkAddView() {
        if (!this.creatingComposition) {
            throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
        }
    }

    private final boolean isAlive(CompositionContext $this$isAlive) {
        return !($this$isAlive instanceof Recomposer) || ((Recomposer) $this$isAlive).getCurrentState().getValue().compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    private final CompositionContext cacheIfAlive(CompositionContext $this$cacheIfAlive) {
        CompositionContext context = $this$cacheIfAlive;
        CompositionContext it = isAlive(context) ? context : null;
        if (it != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(it);
        }
        return $this$cacheIfAlive;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext it;
        CompositionContext compositionContext = this.parentContext;
        if (compositionContext != null) {
            return compositionContext;
        }
        CompositionContext findViewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(this);
        CompositionContext compositionContext2 = null;
        CompositionContext cacheIfAlive = findViewTreeCompositionContext != null ? cacheIfAlive(findViewTreeCompositionContext) : null;
        if (cacheIfAlive != null) {
            return cacheIfAlive;
        }
        WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
        if (!(weakReference == null || (it = (CompositionContext) weakReference.get()) == null || !isAlive(it))) {
            compositionContext2 = it;
        }
        CompositionContext compositionContext3 = compositionContext2;
        return compositionContext3 == null ? cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(this)) : compositionContext3;
    }

    /* JADX INFO: finally extract failed */
    private final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), ComposableLambdaKt.composableLambdaInstance(-656146368, true, new AbstractComposeView$ensureCompositionCreated$1(this)));
                this.creatingComposition = false;
            } catch (Throwable th) {
                this.creatingComposition = false;
                throw th;
            }
        }
    }

    public final void disposeComposition() {
        Composition composition2 = this.composition;
        if (composition2 != null) {
            composition2.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            ensureCompositionCreated();
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
    }

    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        View child = getChildAt(0);
        if (child == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        child.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(widthMeasureSpec)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(heightMeasureSpec)));
        setMeasuredDimension(child.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), child.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        internalOnLayout$ui_release(changed, left, top, right, bottom);
    }

    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
        }
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(layoutDirection);
        }
    }

    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
        this.isTransitionGroupSet = true;
    }

    public void addView(View child) {
        checkAddView();
        super.addView(child);
    }

    public void addView(View child, int index) {
        checkAddView();
        super.addView(child, index);
    }

    public void addView(View child, int width, int height) {
        checkAddView();
        super.addView(child, width, height);
    }

    public void addView(View child, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, params);
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, index, params);
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        return super.addViewInLayout(child, index, params);
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkAddView();
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
