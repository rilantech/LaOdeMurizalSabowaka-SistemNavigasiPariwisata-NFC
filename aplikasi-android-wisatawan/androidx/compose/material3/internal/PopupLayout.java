package androidx.compose.material3.internal;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B=\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\r\u0010P\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020)H\u0002J\u0006\u0010S\u001a\u00020\u0006J\u0010\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\u0006H\u0016J\u0012\u0010X\u001a\u00020\u00132\b\u0010U\u001a\u0004\u0018\u00010YH\u0016J&\u0010\u001d\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0019¢\u0006\u0002\u0010\\J\u0010\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_H\u0016J\u0006\u0010`\u001a\u00020\u0006J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010^\u001a\u000201H\u0002J&\u0010b\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010^\u001a\u000201J\u0006\u0010c\u001a\u00020\u0006J\f\u0010d\u001a\u00020$*\u00020CH\u0002R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RA\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00198B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR%\u0010!\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00130\"X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010%\u001a\u00020&X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R/\u0010*\u001a\u0004\u0018\u00010$2\b\u0010\u0018\u001a\u0004\u0018\u00010$8F@FX\u0002¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R8\u00107\u001a\u0004\u0018\u0001062\b\u0010\u0018\u001a\u0004\u0018\u0001068F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010 \u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0015R\u0014\u0010F\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/material3/internal/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onDismissRequest", "Lkotlin/Function0;", "", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;)V", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "dismissOnOutsideClick", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/IntRect;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "params", "Landroid/view/WindowManager$LayoutParams;", "parentBounds", "getParentBounds", "()Landroidx/compose/ui/unit/IntRect;", "setParentBounds", "(Landroidx/compose/ui/unit/IntRect;)V", "parentBounds$delegate", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "tmpWindowVisibleFrame", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createLayoutParams", "dismiss", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onGlobalLayout", "onTouchEvent", "Landroid/view/MotionEvent;", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "layoutDirection", "", "show", "superSetLayoutDirection", "updateParameters", "updatePosition", "toIntBounds", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {
    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final Function2<Offset, IntRect, Boolean> dismissOnOutsideClick;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params = createLayoutParams();
    private final MutableState parentBounds$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private String testTag;
    private final Rect tmpWindowVisibleFrame;
    private final WindowManager windowManager;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ExposedDropdownMenuPopup.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public final void setTestTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testTag = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PopupLayout(kotlin.jvm.functions.Function0<kotlin.Unit> r8, java.lang.String r9, android.view.View r10, androidx.compose.ui.unit.Density r11, androidx.compose.ui.window.PopupPositionProvider r12, java.util.UUID r13) {
        /*
            r7 = this;
            java.lang.String r0 = "testTag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "composeView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "initialPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            android.content.Context r2 = r10.getContext()
            java.lang.String r0 = "composeView.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r7.onDismissRequest = r8
            r7.testTag = r9
            r7.composeView = r10
            android.content.Context r0 = r10.getContext()
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            java.lang.String r1 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            r7.windowManager = r0
            android.view.WindowManager$LayoutParams r0 = r7.createLayoutParams()
            r7.params = r0
            r7.positionProvider = r12
            androidx.compose.ui.unit.LayoutDirection r0 = androidx.compose.ui.unit.LayoutDirection.Ltr
            r7.parentLayoutDirection = r0
            r0 = 0
            r1 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r1, r0)
            r7.parentBounds$delegate = r2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r1, r0)
            r7.popupContentSize$delegate = r2
            androidx.compose.material3.internal.PopupLayout$canCalculatePosition$2 r2 = new androidx.compose.material3.internal.PopupLayout$canCalculatePosition$2
            r2.<init>(r7)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r2)
            r7.canCalculatePosition$delegate = r2
            r2 = 8
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r4)
            r7.maxSupportedElevation = r2
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r7.previousWindowVisibleFrame = r3
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r7.tmpWindowVisibleFrame = r3
            androidx.compose.material3.internal.PopupLayout$dismissOnOutsideClick$1 r3 = androidx.compose.material3.internal.PopupLayout$dismissOnOutsideClick$1.INSTANCE
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r7.dismissOnOutsideClick = r3
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            r7.setId(r3)
            r3 = r7
            android.view.View r3 = (android.view.View) r3
            androidx.lifecycle.LifecycleOwner r4 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r10)
            androidx.lifecycle.ViewTreeLifecycleOwner.set(r3, r4)
            r3 = r7
            android.view.View r3 = (android.view.View) r3
            androidx.lifecycle.ViewModelStoreOwner r4 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r10)
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(r3, r4)
            r3 = r7
            android.view.View r3 = (android.view.View) r3
            androidx.savedstate.SavedStateRegistryOwner r4 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r10)
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(r3, r4)
            android.view.ViewTreeObserver r3 = r10.getViewTreeObserver()
            r4 = r7
            android.view.ViewTreeObserver$OnGlobalLayoutListener r4 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r4
            r3.addOnGlobalLayoutListener(r4)
            int r3 = androidx.compose.ui.R.id.compose_view_saveable_id_tag
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Popup:"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r13)
            java.lang.String r4 = r4.toString()
            r7.setTag(r3, r4)
            r3 = 0
            r7.setClipChildren(r3)
            r3 = r11
            r4 = 0
            float r2 = r3.m5825toPx0680j_4(r2)
            r7.setElevation(r2)
            androidx.compose.material3.internal.PopupLayout$2 r2 = new androidx.compose.material3.internal.PopupLayout$2
            r2.<init>()
            android.view.ViewOutlineProvider r2 = (android.view.ViewOutlineProvider) r2
            r7.setOutlineProvider(r2)
            androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt r2 = androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt.INSTANCE
            kotlin.jvm.functions.Function2 r2 = r2.m2277getLambda1$material3_release()
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r0, r1, r0)
            r7.content$delegate = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.PopupLayout.<init>(kotlin.jvm.functions.Function0, java.lang.String, android.view.View, androidx.compose.ui.unit.Density, androidx.compose.ui.window.PopupPositionProvider, java.util.UUID):void");
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        Intrinsics.checkNotNullParameter(popupPositionProvider, "<set-?>");
        this.positionProvider = popupPositionProvider;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.parentLayoutDirection = layoutDirection;
    }

    public final IntRect getParentBounds() {
        return (IntRect) this.parentBounds$delegate.getValue();
    }

    public final void setParentBounds(IntRect intRect) {
        this.parentBounds$delegate.setValue(intRect);
    }

    /* renamed from: getPopupContentSize-bOM6tXw  reason: not valid java name */
    public final IntSize m2281getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    /* renamed from: setPopupContentSize-fhxjrPA  reason: not valid java name */
    public final void m2282setPopupContentSizefhxjrPA(IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    /* access modifiers changed from: protected */
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(content, "content");
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public void Content(Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-797839545);
        ComposerKt.sourceInformation($composer2, "C(Content)303@11874L9:ExposedDropdownMenuPopup.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-797839545, $changed, -1, "androidx.compose.material3.internal.PopupLayout.Content (ExposedDropdownMenuPopup.kt:302)");
        }
        getContent().invoke($composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PopupLayout$Content$4(this, $changed));
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        KeyEvent.DispatcherState state;
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event.getKeyCode() == 4) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state2 = getKeyDispatcherState();
                if (state2 != null) {
                    state2.startTracking(event, this);
                }
                return true;
            } else if (event.getAction() == 1 && (state = getKeyDispatcherState()) != null && state.isTracking(event) && !event.isCanceled()) {
                Function0<Unit> function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest2, String testTag2, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(testTag2, "testTag");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.onDismissRequest = onDismissRequest2;
        this.testTag = testTag2;
        superSetLayoutDirection(layoutDirection);
    }

    public final void updatePosition() {
        IntSize r0;
        IntRect parentBounds = getParentBounds();
        if (parentBounds != null && (r0 = m2281getPopupContentSizebOM6tXw()) != null) {
            long popupContentSize = r0.m6008unboximpl();
            Rect it = this.previousWindowVisibleFrame;
            this.composeView.getWindowVisibleDisplayFrame(it);
            IntRect bounds = toIntBounds(it);
            long popupPosition = this.positionProvider.m6094calculatePositionllwVHH4(parentBounds, IntSizeKt.IntSize(bounds.getWidth(), bounds.getHeight()), this.parentLayoutDirection, popupContentSize);
            this.params.x = IntOffset.m5962getXimpl(popupPosition);
            this.params.y = IntOffset.m5963getYimpl(popupPosition);
            this.windowManager.updateViewLayout(this, this.params);
        }
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, (LifecycleOwner) null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        if (r3.invoke(r1, r0).booleanValue() == false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0007
            boolean r0 = super.onTouchEvent(r9)
            return r0
        L_0x0007:
            int r0 = r9.getAction()
            r1 = 0
            if (r0 != 0) goto L_0x0039
            float r0 = r9.getX()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0040
            float r0 = r9.getX()
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
            float r0 = r9.getY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0040
            float r0 = r9.getY()
            int r2 = r8.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
        L_0x0039:
            int r0 = r9.getAction()
            r2 = 4
            if (r0 != r2) goto L_0x009c
        L_0x0040:
            androidx.compose.ui.unit.IntRect r0 = r8.getParentBounds()
            r2 = 1
            if (r0 == 0) goto L_0x0090
            kotlin.jvm.functions.Function2<androidx.compose.ui.geometry.Offset, androidx.compose.ui.unit.IntRect, java.lang.Boolean> r3 = r8.dismissOnOutsideClick
            float r4 = r9.getX()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto L_0x0054
            r4 = r2
            goto L_0x0055
        L_0x0054:
            r4 = r5
        L_0x0055:
            if (r4 == 0) goto L_0x0067
            float r4 = r9.getY()
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0061
            r1 = r2
            goto L_0x0062
        L_0x0061:
            r1 = r5
        L_0x0062:
            if (r1 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = 0
            goto L_0x0083
        L_0x0067:
            android.view.WindowManager$LayoutParams r1 = r8.params
            int r1 = r1.x
            float r1 = (float) r1
            float r4 = r9.getX()
            float r1 = r1 + r4
            android.view.WindowManager$LayoutParams r4 = r8.params
            int r4 = r4.y
            float r4 = (float) r4
            float r6 = r9.getY()
            float r4 = r4 + r6
            long r6 = androidx.compose.ui.geometry.OffsetKt.Offset(r1, r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m2992boximpl(r6)
        L_0x0083:
            java.lang.Object r1 = r3.invoke(r1, r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0091
        L_0x0090:
            r5 = r2
        L_0x0091:
            r1 = r5
            if (r1 == 0) goto L_0x009c
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r8.onDismissRequest
            if (r3 == 0) goto L_0x009b
            r3.invoke()
        L_0x009b:
            return r2
        L_0x009c:
            boolean r0 = super.onTouchEvent(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.PopupLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setLayoutDirection(int layoutDirection) {
    }

    private final void superSetLayoutDirection(LayoutDirection layoutDirection) {
        int direction;
        switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
            case 1:
                direction = 0;
                break;
            case 2:
                direction = 1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(direction);
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        WindowManager.LayoutParams $this$createLayoutParams_u24lambda_u242 = layoutParams;
        $this$createLayoutParams_u24lambda_u242.gravity = 8388659;
        $this$createLayoutParams_u24lambda_u242.flags = 393248;
        $this$createLayoutParams_u24lambda_u242.softInputMode = 1;
        $this$createLayoutParams_u24lambda_u242.type = 1000;
        $this$createLayoutParams_u24lambda_u242.token = this.composeView.getApplicationWindowToken();
        $this$createLayoutParams_u24lambda_u242.width = -2;
        $this$createLayoutParams_u24lambda_u242.height = -2;
        $this$createLayoutParams_u24lambda_u242.format = -3;
        $this$createLayoutParams_u24lambda_u242.setTitle(this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return layoutParams;
    }

    private final IntRect toIntBounds(Rect $this$toIntBounds) {
        return new IntRect($this$toIntBounds.left, $this$toIntBounds.top, $this$toIntBounds.right, $this$toIntBounds.bottom);
    }

    public void onGlobalLayout() {
        this.composeView.getWindowVisibleDisplayFrame(this.tmpWindowVisibleFrame);
        if (!Intrinsics.areEqual((Object) this.tmpWindowVisibleFrame, (Object) this.previousWindowVisibleFrame)) {
            updatePosition();
        }
    }
}
