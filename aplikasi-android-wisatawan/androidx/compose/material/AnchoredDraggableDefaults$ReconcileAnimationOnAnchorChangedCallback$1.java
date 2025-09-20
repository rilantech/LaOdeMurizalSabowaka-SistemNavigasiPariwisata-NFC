package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "T", "previousTarget", "previousAnchors", "", "", "newAnchors"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1 implements AnchoredDraggableState.AnchorChangedCallback<T> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ AnchoredDraggableState<T> $state;

    AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1(CoroutineScope coroutineScope, AnchoredDraggableState<T> anchoredDraggableState) {
        this.$scope = coroutineScope;
        this.$state = anchoredDraggableState;
    }

    public final void onAnchorsChanged(T previousTarget, Map<T, Float> previousAnchors, Map<T, Float> newAnchors) {
        T t = previousTarget;
        Map<T, Float> map = previousAnchors;
        Map<T, Float> map2 = newAnchors;
        Intrinsics.checkNotNullParameter(map, "previousAnchors");
        Intrinsics.checkNotNullParameter(map2, "newAnchors");
        Float newTargetOffset = map2.get(t);
        if (Intrinsics.areEqual(map.get(t), newTargetOffset)) {
            return;
        }
        if (newTargetOffset != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$1(this.$state, t, (Continuation<? super AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$1>) null), 3, (Object) null);
        } else {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$2(this.$state, map2, (Continuation<? super AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$2>) null), 3, (Object) null);
        }
    }
}
