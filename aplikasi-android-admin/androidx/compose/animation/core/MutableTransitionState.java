package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R+\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008F@@X\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR+\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8@@@X\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R+\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\u0004¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/core/MutableTransitionState;", "S", "", "initialState", "(Ljava/lang/Object;)V", "<set-?>", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "isIdle", "", "()Z", "isRunning", "isRunning$animation_core_release", "setRunning$animation_core_release", "(Z)V", "isRunning$delegate", "targetState", "getTargetState", "setTargetState", "targetState$delegate", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class MutableTransitionState<S> {
    public static final int $stable = 0;
    private final MutableState currentState$delegate;
    private final MutableState isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState targetState$delegate;

    public MutableTransitionState(S initialState) {
        this.currentState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialState, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialState, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final S getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    public final void setCurrentState$animation_core_release(S s) {
        this.currentState$delegate.setValue(s);
    }

    public final S getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final void setTargetState(S s) {
        this.targetState$delegate.setValue(s);
    }

    public final boolean isIdle() {
        return Intrinsics.areEqual(getCurrentState(), getTargetState()) && !isRunning$animation_core_release();
    }

    public final boolean isRunning$animation_core_release() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final void setRunning$animation_core_release(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }
}
