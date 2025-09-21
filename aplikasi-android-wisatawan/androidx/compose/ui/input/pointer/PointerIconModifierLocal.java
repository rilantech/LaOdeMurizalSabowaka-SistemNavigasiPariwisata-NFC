package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\tJ\u0012\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0000H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\tH\u0002J\u0006\u0010(\u001a\u00020\u0006J,\u0010)\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0004\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R/\u0010\u0016\u001a\u0004\u0018\u00010\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006*"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerIconModifierLocal;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "icon", "overrideDescendants", "", "onSetIcon", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLkotlin/jvm/functions/Function1;)V", "isHovered", "()Z", "setHovered", "(Z)V", "isPaused", "setPaused", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "<set-?>", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/input/pointer/PointerIconModifierLocal;", "setParentInfo", "(Landroidx/compose/ui/input/pointer/PointerIconModifierLocal;)V", "parentInfo$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "enter", "exit", "parent", "hasOverride", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "pause", "reassignIcon", "shouldUpdatePointerIcon", "updateValues", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
final class PointerIconModifierLocal implements PointerIcon, ModifierLocalProvider<PointerIconModifierLocal>, ModifierLocalConsumer {
    private PointerIcon icon;
    private boolean isHovered;
    private boolean isPaused;
    private final ProvidableModifierLocal<PointerIconModifierLocal> key = PointerIconKt.ModifierLocalPointerIcon;
    private Function1<? super PointerIcon, Unit> onSetIcon;
    private boolean overrideDescendants;
    private final MutableState parentInfo$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final PointerIconModifierLocal value = this;

    public PointerIconModifierLocal(PointerIcon icon2, boolean overrideDescendants2, Function1<? super PointerIcon, Unit> onSetIcon2) {
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(onSetIcon2, "onSetIcon");
        this.icon = icon2;
        this.overrideDescendants = overrideDescendants2;
        this.onSetIcon = onSetIcon2;
    }

    private final PointerIconModifierLocal getParentInfo() {
        return (PointerIconModifierLocal) this.parentInfo$delegate.getValue();
    }

    private final void setParentInfo(PointerIconModifierLocal pointerIconModifierLocal) {
        this.parentInfo$delegate.setValue(pointerIconModifierLocal);
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public final void setPaused(boolean z) {
        this.isPaused = z;
    }

    public final boolean isHovered() {
        return this.isHovered;
    }

    public final void setHovered(boolean z) {
        this.isHovered = z;
    }

    public ProvidableModifierLocal<PointerIconModifierLocal> getKey() {
        return this.key;
    }

    public PointerIconModifierLocal getValue() {
        return this.value;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        PointerIconModifierLocal oldParentInfo = getParentInfo();
        setParentInfo((PointerIconModifierLocal) scope.getCurrent(PointerIconKt.ModifierLocalPointerIcon));
        if (oldParentInfo != null && getParentInfo() == null) {
            exit(oldParentInfo);
            this.onSetIcon = PointerIconModifierLocal$onModifierLocalsUpdated$1$1.INSTANCE;
        }
    }

    public final boolean shouldUpdatePointerIcon() {
        PointerIconModifierLocal parentPointerInfo = getParentInfo();
        return parentPointerInfo == null || !parentPointerInfo.hasOverride();
    }

    private final boolean hasOverride() {
        if (this.overrideDescendants) {
            return true;
        }
        PointerIconModifierLocal parentInfo = getParentInfo();
        return parentInfo != null && parentInfo.hasOverride();
    }

    public final void enter() {
        this.isHovered = true;
        if (!this.isPaused) {
            PointerIconModifierLocal parentInfo = getParentInfo();
            if (parentInfo != null) {
                parentInfo.pause();
            }
            this.onSetIcon.invoke(this.icon);
        }
    }

    public final void exit() {
        exit(getParentInfo());
    }

    private final void exit(PointerIconModifierLocal parent) {
        if (this.isHovered) {
            if (parent == null) {
                this.onSetIcon.invoke(null);
            } else {
                parent.reassignIcon();
            }
        }
        this.isHovered = false;
    }

    private final void reassignIcon() {
        this.isPaused = false;
        if (this.isHovered) {
            this.onSetIcon.invoke(this.icon);
        } else if (getParentInfo() == null) {
            this.onSetIcon.invoke(null);
        } else {
            PointerIconModifierLocal parentInfo = getParentInfo();
            if (parentInfo != null) {
                parentInfo.reassignIcon();
            }
        }
    }

    private final void pause() {
        this.isPaused = true;
        PointerIconModifierLocal parentInfo = getParentInfo();
        if (parentInfo != null) {
            parentInfo.pause();
        }
    }

    public final void updateValues(PointerIcon icon2, boolean overrideDescendants2, Function1<? super PointerIcon, Unit> onSetIcon2) {
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(onSetIcon2, "onSetIcon");
        if (!Intrinsics.areEqual((Object) this.icon, (Object) icon2) && this.isHovered && !this.isPaused) {
            onSetIcon2.invoke(icon2);
        }
        this.icon = icon2;
        this.overrideDescendants = overrideDescendants2;
        this.onSetIcon = onSetIcon2;
    }
}
