package androidx.compose.ui.window;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b&¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/ui/window/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;)V", "defaultSoftInputMode", "", "dialogLayout", "Landroidx/compose/ui/window/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "cancel", "disposeComposition", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {
    private final View composeView;
    private final int defaultSoftInputMode;
    private final DialogLayout dialogLayout;
    private final float maxSupportedElevation;
    /* access modifiers changed from: private */
    public Function0<Unit> onDismissRequest;
    /* access modifiers changed from: private */
    public DialogProperties properties;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidDialog.android.kt */
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogWrapper(Function0<Unit> onDismissRequest2, DialogProperties properties2, View composeView2, LayoutDirection layoutDirection, Density density, UUID dialogId) {
        super(new ContextThemeWrapper(composeView2.getContext(), R.style.DialogWindowTheme), 0, 2, (DefaultConstructorMarker) null);
        Function0<Unit> function0 = onDismissRequest2;
        DialogProperties dialogProperties = properties2;
        View view = composeView2;
        LayoutDirection layoutDirection2 = layoutDirection;
        UUID uuid = dialogId;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(dialogProperties, "properties");
        Intrinsics.checkNotNullParameter(view, "composeView");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(uuid, "dialogId");
        this.onDismissRequest = function0;
        this.properties = dialogProperties;
        this.composeView = view;
        float r6 = Dp.m7554constructorimpl((float) 8);
        this.maxSupportedElevation = r6;
        Window window = getWindow();
        if (window != null) {
            this.defaultSoftInputMode = window.getAttributes().softInputMode & 240;
            window.requestFeature(1);
            window.setBackgroundDrawableResource(17170445);
            WindowCompat.setDecorFitsSystemWindows(window, this.properties.getDecorFitsSystemWindows());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            DialogLayout dialogLayout2 = new DialogLayout(context, window);
            DialogLayout $this$_init__u24lambda_u241 = dialogLayout2;
            $this$_init__u24lambda_u241.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + uuid);
            $this$_init__u24lambda_u241.setClipChildren(false);
            $this$_init__u24lambda_u241.setElevation(density.m7535toPx0680j_4(r6));
            $this$_init__u24lambda_u241.setOutlineProvider(new DialogWrapper$1$2());
            this.dialogLayout = dialogLayout2;
            View decorView = window.getDecorView();
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null) {
                _init_$disableClipping(viewGroup);
            }
            setContentView((View) dialogLayout2);
            ViewTreeLifecycleOwner.set(dialogLayout2, ViewTreeLifecycleOwner.get(composeView2));
            ViewTreeViewModelStoreOwner.set(dialogLayout2, ViewTreeViewModelStoreOwner.get(composeView2));
            ViewTreeSavedStateRegistryOwner.set(dialogLayout2, ViewTreeSavedStateRegistryOwner.get(composeView2));
            updateParameters(this.onDismissRequest, this.properties, layoutDirection2);
            OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Function1<OnBackPressedCallback, Unit>(this) {
                final /* synthetic */ DialogWrapper this$0;

                {
                    this.this$0 = r2;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((OnBackPressedCallback) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(OnBackPressedCallback $this$addCallback) {
                    Intrinsics.checkNotNullParameter($this$addCallback, "$this$addCallback");
                    if (this.this$0.properties.getDismissOnBackPress()) {
                        this.this$0.onDismissRequest.invoke();
                    }
                }
            }, 2, (Object) null);
            return;
        }
        throw new IllegalStateException("Dialog has no window".toString());
    }

    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    private static final void _init_$disableClipping(ViewGroup $this$_init__u24disableClipping) {
        $this$_init__u24disableClipping.setClipChildren(false);
        if (!($this$_init__u24disableClipping instanceof DialogLayout)) {
            int childCount = $this$_init__u24disableClipping.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = $this$_init__u24disableClipping.getChildAt(i);
                ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
                if (viewGroup != null) {
                    _init_$disableClipping(viewGroup);
                }
            }
        }
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        int i;
        DialogLayout dialogLayout2 = this.dialogLayout;
        switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        dialogLayout2.setLayoutDirection(i);
    }

    public final void setContent(CompositionContext parentComposition, Function2<? super Composer, ? super Integer, Unit> children) {
        Intrinsics.checkNotNullParameter(parentComposition, "parentComposition");
        Intrinsics.checkNotNullParameter(children, "children");
        this.dialogLayout.setContent(parentComposition, children);
    }

    private final void setSecurePolicy(SecureFlagPolicy securePolicy) {
        int i;
        boolean secureFlagEnabled = SecureFlagPolicy_androidKt.shouldApplySecureFlag(securePolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        if (secureFlagEnabled) {
            i = 8192;
        } else {
            i = -8193;
        }
        window.setFlags(i, 8192);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest2, DialogProperties properties2, LayoutDirection layoutDirection) {
        Window window;
        Intrinsics.checkNotNullParameter(onDismissRequest2, "onDismissRequest");
        Intrinsics.checkNotNullParameter(properties2, "properties");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.onDismissRequest = onDismissRequest2;
        this.properties = properties2;
        setSecurePolicy(properties2.getSecurePolicy());
        setLayoutDirection(layoutDirection);
        if (properties2.getUsePlatformDefaultWidth() && !this.dialogLayout.getUsePlatformDefaultWidth() && (window = getWindow()) != null) {
            window.setLayout(-2, -2);
        }
        this.dialogLayout.setUsePlatformDefaultWidth(properties2.getUsePlatformDefaultWidth());
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        boolean result = super.onTouchEvent(event);
        if (result && this.properties.getDismissOnClickOutside()) {
            this.onDismissRequest.invoke();
        }
        return result;
    }

    public void cancel() {
    }
}
