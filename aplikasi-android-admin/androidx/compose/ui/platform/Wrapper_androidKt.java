package androidx.compose.ui.platform;

import android.util.Log;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001\u001a0\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\b\u0010\u0012\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a,\u0010\u0015\u001a\u00020\u0005*\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0000¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "TAG", "", "createSubcomposition", "Landroidx/compose/runtime/Composition;", "container", "Landroidx/compose/ui/node/LayoutNode;", "parent", "Landroidx/compose/runtime/CompositionContext;", "doSetContent", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "enableDebugInspectorInfo", "inspectionWanted", "", "setContent", "Landroidx/compose/ui/platform/AbstractComposeView;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Wrapper.android.kt */
public final class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    private static final String TAG = "Wrapper";

    public static final Composition createSubcomposition(LayoutNode container, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return CompositionKt.Composition(new UiApplier(container), parent);
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.Composition setContent(androidx.compose.ui.platform.AbstractComposeView r5, androidx.compose.runtime.CompositionContext r6, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.compose.ui.platform.GlobalSnapshotManager r0 = androidx.compose.ui.platform.GlobalSnapshotManager.INSTANCE
            r0.ensureStarted()
            int r0 = r5.getChildCount()
            r1 = 0
            if (r0 <= 0) goto L_0x0029
            r0 = 0
            android.view.View r0 = r5.getChildAt(r0)
            boolean r2 = r0 instanceof androidx.compose.ui.platform.AndroidComposeView
            if (r2 == 0) goto L_0x002c
            r1 = r0
            androidx.compose.ui.platform.AndroidComposeView r1 = (androidx.compose.ui.platform.AndroidComposeView) r1
            goto L_0x002c
        L_0x0029:
            r5.removeAllViews()
        L_0x002c:
            if (r1 != 0) goto L_0x004d
            androidx.compose.ui.platform.AndroidComposeView r1 = new androidx.compose.ui.platform.AndroidComposeView
            android.content.Context r0 = r5.getContext()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.coroutines.CoroutineContext r2 = r6.getEffectCoroutineContext()
            r1.<init>(r0, r2)
            r0 = r1
            r2 = 0
            android.view.View r3 = r0.getView()
            android.view.ViewGroup$LayoutParams r4 = DefaultLayoutParams
            r5.addView((android.view.View) r3, (android.view.ViewGroup.LayoutParams) r4)
        L_0x004d:
            r0 = r1
            androidx.compose.runtime.Composition r1 = doSetContent(r0, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.Wrapper_androidKt.setContent(androidx.compose.ui.platform.AbstractComposeView, androidx.compose.runtime.CompositionContext, kotlin.jvm.functions.Function2):androidx.compose.runtime.Composition");
    }

    private static final Composition doSetContent(AndroidComposeView owner, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        if (inspectionWanted(owner)) {
            owner.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
            enableDebugInspectorInfo();
        }
        Composition original = CompositionKt.Composition(new UiApplier(owner.getRoot()), parent);
        Object tag = owner.getView().getTag(R.id.wrapped_composition_tag);
        WrappedComposition wrapped = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrapped == null) {
            wrapped = new WrappedComposition(owner, original);
            owner.getView().setTag(R.id.wrapped_composition_tag, wrapped);
        }
        wrapped.setContent(content);
        return wrapped;
    }

    private static final void enableDebugInspectorInfo() {
        if (!InspectableValueKt.isDebugInspectorInfoEnabled()) {
            try {
                Field field = Class.forName("androidx.compose.ui.platform.InspectableValueKt").getDeclaredField("isDebugInspectorInfoEnabled");
                field.setAccessible(true);
                field.setBoolean((Object) null, true);
            } catch (Exception e) {
                Log.w(TAG, "Could not access isDebugInspectorInfoEnabled. Please set explicitly.");
            }
        }
    }

    private static final boolean inspectionWanted(AndroidComposeView owner) {
        return WrapperVerificationHelperMethods.INSTANCE.attributeSourceResourceMap(owner).isEmpty() ^ true;
    }
}
