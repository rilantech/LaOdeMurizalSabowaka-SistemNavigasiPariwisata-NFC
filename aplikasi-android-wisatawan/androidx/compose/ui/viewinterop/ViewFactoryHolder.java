package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004BA\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB?\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R<\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR<\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0016\u001a\u0004\u0018\u00010 @BX\u000e¢\u0006\b\n\u0000\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010&R<\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u0014\u0010*\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "factory", "Lkotlin/Function1;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "saveStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "compositeKeyHash", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/saveable/SaveableStateRegistry;I)V", "typedView", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroid/view/View;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/runtime/saveable/SaveableStateRegistry;I)V", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "value", "", "releaseBlock", "getReleaseBlock", "()Lkotlin/jvm/functions/Function1;", "setReleaseBlock", "(Lkotlin/jvm/functions/Function1;)V", "resetBlock", "getResetBlock", "setResetBlock", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "savableRegistryEntry", "setSavableRegistryEntry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;)V", "saveStateKey", "", "Landroid/view/View;", "updateBlock", "getUpdateBlock", "setUpdateBlock", "viewRoot", "getViewRoot", "()Landroid/view/View;", "registerSaveStateProvider", "unregisterSaveStateProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {
    private final int compositeKeyHash;
    private final NestedScrollDispatcher dispatcher;
    private Function1<? super T, Unit> releaseBlock;
    private Function1<? super T, Unit> resetBlock;
    private SaveableStateRegistry.Entry savableRegistryEntry;
    private final String saveStateKey;
    private final SaveableStateRegistry saveStateRegistry;
    /* access modifiers changed from: private */
    public final T typedView;
    private Function1<? super T, Unit> updateBlock;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ ViewFactoryHolder(android.content.Context r8, androidx.compose.runtime.CompositionContext r9, android.view.View r10, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r11, androidx.compose.runtime.saveable.SaveableStateRegistry r12, int r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 2
            if (r15 == 0) goto L_0x0007
            r9 = 0
            r2 = r9
            goto L_0x0008
        L_0x0007:
            r2 = r9
        L_0x0008:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x0013
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r11 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r11.<init>()
            r4 = r11
            goto L_0x0014
        L_0x0013:
            r4 = r11
        L_0x0014:
            r0 = r7
            r1 = r8
            r3 = r10
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.ViewFactoryHolder.<init>(android.content.Context, androidx.compose.runtime.CompositionContext, android.view.View, androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher, androidx.compose.runtime.saveable.SaveableStateRegistry, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    private ViewFactoryHolder(Context context, CompositionContext parentContext, T typedView2, NestedScrollDispatcher dispatcher2, SaveableStateRegistry saveStateRegistry2, int compositeKeyHash2) {
        super(context, parentContext, compositeKeyHash2, dispatcher2, typedView2);
        this.typedView = typedView2;
        this.dispatcher = dispatcher2;
        this.saveStateRegistry = saveStateRegistry2;
        this.compositeKeyHash = compositeKeyHash2;
        setClipChildren(false);
        String valueOf = String.valueOf(compositeKeyHash2);
        this.saveStateKey = valueOf;
        SparseArray sparseArray = null;
        Object consumeRestored = saveStateRegistry2 != null ? saveStateRegistry2.consumeRestored(valueOf) : null;
        SparseArray savedState = consumeRestored instanceof SparseArray ? (SparseArray) consumeRestored : sparseArray;
        if (savedState != null) {
            typedView2.restoreHierarchyState(savedState);
        }
        registerSaveStateProvider();
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
        this.resetBlock = AndroidView_androidKt.getNoOpUpdate();
        this.releaseBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ViewFactoryHolder(android.content.Context r7, kotlin.jvm.functions.Function1 r8, androidx.compose.runtime.CompositionContext r9, androidx.compose.runtime.saveable.SaveableStateRegistry r10, int r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 4
            if (r12 == 0) goto L_0x0007
            r9 = 0
            r3 = r9
            goto L_0x0008
        L_0x0007:
            r3 = r9
        L_0x0008:
            r0 = r6
            r1 = r7
            r2 = r8
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.ViewFactoryHolder.<init>(android.content.Context, kotlin.jvm.functions.Function1, androidx.compose.runtime.CompositionContext, androidx.compose.runtime.saveable.SaveableStateRegistry, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(Context context, Function1<? super Context, ? extends T> factory, CompositionContext parentContext, SaveableStateRegistry saveStateRegistry2, int compositeKeyHash2) {
        this(context, parentContext, (View) factory.invoke(context), (NestedScrollDispatcher) null, saveStateRegistry2, compositeKeyHash2, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public View getViewRoot() {
        return this;
    }

    private final void setSavableRegistryEntry(SaveableStateRegistry.Entry value) {
        SaveableStateRegistry.Entry entry = this.savableRegistryEntry;
        if (entry != null) {
            entry.unregister();
        }
        this.savableRegistryEntry = value;
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    public final void setUpdateBlock(Function1<? super T, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.updateBlock = value;
        setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }

    public final Function1<T, Unit> getResetBlock() {
        return this.resetBlock;
    }

    public final void setResetBlock(Function1<? super T, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.resetBlock = value;
        setReset(new ViewFactoryHolder$resetBlock$1(this));
    }

    public final Function1<T, Unit> getReleaseBlock() {
        return this.releaseBlock;
    }

    public final void setReleaseBlock(Function1<? super T, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.releaseBlock = value;
        setRelease(new ViewFactoryHolder$releaseBlock$1(this));
    }

    private final void registerSaveStateProvider() {
        SaveableStateRegistry saveableStateRegistry = this.saveStateRegistry;
        if (saveableStateRegistry != null) {
            setSavableRegistryEntry(saveableStateRegistry.registerProvider(this.saveStateKey, new ViewFactoryHolder$registerSaveStateProvider$1(this)));
        }
    }

    /* access modifiers changed from: private */
    public final void unregisterSaveStateProvider() {
        setSavableRegistryEntry((SaveableStateRegistry.Entry) null);
    }
}
