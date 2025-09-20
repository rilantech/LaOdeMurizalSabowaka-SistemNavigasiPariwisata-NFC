package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048@@@X\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@PX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/RichTooltipState;", "Landroidx/compose/material3/TooltipState;", "()V", "<set-?>", "", "isPersistent", "isPersistent$material3_release", "()Z", "setPersistent$material3_release", "(Z)V", "isPersistent$delegate", "Landroidx/compose/runtime/MutableState;", "isVisible", "setVisible$material3_release", "isVisible$delegate", "dismiss", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class RichTooltipState implements TooltipState {
    public static final int $stable = 0;
    private final MutableState isPersistent$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState isVisible$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);

    public boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    public void setVisible$material3_release(boolean z) {
        this.isVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isPersistent$material3_release() {
        return ((Boolean) this.isPersistent$delegate.getValue()).booleanValue();
    }

    public final void setPersistent$material3_release(boolean z) {
        this.isPersistent$delegate.setValue(Boolean.valueOf(z));
    }

    public Object show(Continuation<? super Unit> $completion) {
        Object show = TooltipSync.INSTANCE.show(this, isPersistent$material3_release(), $completion);
        return show == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? show : Unit.INSTANCE;
    }

    public Object dismiss(Continuation<? super Unit> $completion) {
        Object dismissCurrentTooltip = TooltipSync.INSTANCE.dismissCurrentTooltip(this, $completion);
        return dismissCurrentTooltip == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dismissCurrentTooltip : Unit.INSTANCE;
    }
}
