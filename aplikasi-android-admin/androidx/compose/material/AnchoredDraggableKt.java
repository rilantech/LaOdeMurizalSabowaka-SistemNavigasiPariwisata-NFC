package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0001¢\u0006\u0002\u0010\u000e\u001aH\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0001\u001a3\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001a\u001a\u0002H\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a7\u0010\u001d\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\rH\u0002¢\u0006\u0002\u0010!\u001a%\u0010\"\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u001eH\u0002¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u001eH\u0002¢\u0006\u0002\u0010#\u001a)\u0010%\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001a\u001a\u0002H\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"rememberAnchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/AnchoredDraggableState;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "animateTo", "", "targetValue", "velocity", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closestAnchor", "", "offset", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "snapTo", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableKt {
    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z3, z4, (i & 16) != 0 ? null : mutableInteractionSource);
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource) {
        AnchoredDraggableState<T> anchoredDraggableState = state;
        Modifier modifier = $this$anchoredDraggable;
        Intrinsics.checkNotNullParameter($this$anchoredDraggable, "<this>");
        Intrinsics.checkNotNullParameter(anchoredDraggableState, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return DraggableKt.draggable$default($this$anchoredDraggable, state.getDraggableState$material_release(), orientation, enabled, interactionSource, state.isAnimationRunning(), (Function3) null, new AnchoredDraggableKt$anchoredDraggable$1(anchoredDraggableState, (Continuation<? super AnchoredDraggableKt$anchoredDraggable$1>) null), reverseDirection, 32, (Object) null);
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> $this$snapTo, T targetValue, Continuation<? super Unit> $completion) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default($this$snapTo, targetValue, (MutatePriority) null, new AnchoredDraggableKt$snapTo$2(targetValue, (Continuation<? super AnchoredDraggableKt$snapTo$2>) null), $completion, 2, (Object) null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, continuation);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> $this$animateTo, T targetValue, float velocity, Continuation<? super Unit> $completion) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default($this$animateTo, targetValue, (MutatePriority) null, new AnchoredDraggableKt$animateTo$2(targetValue, $this$animateTo, velocity, (Continuation<? super AnchoredDraggableKt$animateTo$2>) null), $completion, 2, (Object) null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    public static final <T> AnchoredDraggableState<T> rememberAnchoredDraggableState(T initialValue, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1812391462);
        ComposerKt.sourceInformation($composer, "C(rememberAnchoredDraggableState)P(2)611@25092L19,612@25166L17,613@25195L670:AnchoredDraggable.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            confirmValueChange = AnchoredDraggableKt$rememberAnchoredDraggableState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1812391462, $changed, -1, "androidx.compose.material.rememberAnchoredDraggableState (AnchoredDraggable.kt:606)");
        }
        Function1 positionalThreshold = AnchoredDraggableDefaults.INSTANCE.getPositionalThreshold($composer, 6);
        Function0 velocityThreshold = AnchoredDraggableDefaults.INSTANCE.getVelocityThreshold($composer, 6);
        AnchoredDraggableState<T> anchoredDraggableState = (AnchoredDraggableState) RememberSaveableKt.rememberSaveable(new Object[]{initialValue, animationSpec, confirmValueChange, positionalThreshold, velocityThreshold}, AnchoredDraggableState.Companion.Saver(animationSpec, confirmValueChange, positionalThreshold, velocityThreshold), (String) null, new AnchoredDraggableKt$rememberAnchoredDraggableState$2(initialValue, positionalThreshold, velocityThreshold, animationSpec, confirmValueChange), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return anchoredDraggableState;
    }

    static /* synthetic */ Object closestAnchor$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestAnchor(map, f, z);
    }

    /* access modifiers changed from: private */
    public static final <T> T closestAnchor(Map<T, Float> $this$closestAnchor, float offset, boolean searchUpwards) {
        if (!$this$closestAnchor.isEmpty()) {
            Iterator it = $this$closestAnchor.entrySet().iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    float anchor = ((Number) ((Map.Entry) next).getValue()).floatValue();
                    float delta = searchUpwards ? anchor - offset : offset - anchor;
                    if (delta < 0.0f) {
                        delta = Float.POSITIVE_INFINITY;
                    }
                    do {
                        Object next2 = it.next();
                        float anchor2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                        float delta2 = searchUpwards ? anchor2 - offset : offset - anchor2;
                        if (delta2 < 0.0f) {
                            delta2 = Float.POSITIVE_INFINITY;
                        }
                        if (Float.compare(delta, delta2) > 0) {
                            next = next2;
                            delta = delta2;
                        }
                    } while (it.hasNext());
                }
                return ((Map.Entry) next).getKey();
            }
            throw new NoSuchElementException();
        }
        throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
    }

    /* access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> $this$minOrNull) {
        Iterator it = $this$minOrNull.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext() != 0) {
            floatValue = Math.min(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> $this$maxOrNull) {
        Iterator it = $this$maxOrNull.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext() != 0) {
            floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }
}
