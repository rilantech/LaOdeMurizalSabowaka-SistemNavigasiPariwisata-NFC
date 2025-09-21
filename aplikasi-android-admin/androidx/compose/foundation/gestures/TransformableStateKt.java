package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003ø\u0001\u0000\u001a]\u0010\f\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a5\u0010\u000e\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0019\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\bH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001d\u0010\u001c\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animatePanBy", "offset", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateZoomBy", "zoomFactor", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zoomBy", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformableState.kt */
public final class TransformableStateKt {
    public static final TransformableState TransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> onTransformation) {
        Intrinsics.checkNotNullParameter(onTransformation, "onTransformation");
        return new DefaultTransformableState(onTransformation);
    }

    public static final TransformableState rememberTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> onTransformation, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onTransformation, "onTransformation");
        $composer.startReplaceableGroup(1681419281);
        ComposerKt.sourceInformation($composer, "C(rememberTransformableState)117@5191L38,118@5241L80:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, $changed, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:114)");
        }
        State lambdaState = SnapshotStateKt.rememberUpdatedState(onTransformation, $composer, $changed & 14);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = TransformableState(new TransformableStateKt$rememberTransformableState$1$1(lambdaState));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        TransformableState transformableState = (TransformableState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transformableState;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, (Object) null, 5, (DefaultConstructorMarker) null);
        }
        return animateZoomBy(transformableState, f, animationSpec, continuation);
    }

    public static final Object animateZoomBy(TransformableState $this$animateZoomBy, float zoomFactor, AnimationSpec<Float> animationSpec, Continuation<? super Unit> $completion) {
        if (zoomFactor > 0.0f) {
            Ref.FloatRef previous = new Ref.FloatRef();
            previous.element = 1.0f;
            Object transform$default = TransformableState.transform$default($this$animateZoomBy, (MutatePriority) null, new TransformableStateKt$animateZoomBy$3(previous, zoomFactor, animationSpec, (Continuation<? super TransformableStateKt$animateZoomBy$3>) null), $completion, 1, (Object) null);
            return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
        }
        throw new IllegalArgumentException("zoom value should be greater than 0".toString());
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, (Object) null, 5, (DefaultConstructorMarker) null);
        }
        return animateRotateBy(transformableState, f, animationSpec, continuation);
    }

    public static final Object animateRotateBy(TransformableState $this$animateRotateBy, float degrees, AnimationSpec<Float> animationSpec, Continuation<? super Unit> $completion) {
        Object transform$default = TransformableState.transform$default($this$animateRotateBy, (MutatePriority) null, new TransformableStateKt$animateRotateBy$2(new Ref.FloatRef(), degrees, animationSpec, (Continuation<? super TransformableStateKt$animateRotateBy$2>) null), $completion, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    /* renamed from: animatePanBy-ubNVwUQ$default  reason: not valid java name */
    public static /* synthetic */ Object m2094animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, (Object) null, 5, (DefaultConstructorMarker) null);
        }
        return m2093animatePanByubNVwUQ(transformableState, j, animationSpec, continuation);
    }

    /* renamed from: animatePanBy-ubNVwUQ  reason: not valid java name */
    public static final Object m2093animatePanByubNVwUQ(TransformableState $this$animatePanBy_u2dubNVwUQ, long offset, AnimationSpec<Offset> animationSpec, Continuation<? super Unit> $completion) {
        Ref.LongRef previous = new Ref.LongRef();
        previous.element = Offset.Companion.m4729getZeroF1C5BW0();
        Object transform$default = TransformableState.transform$default($this$animatePanBy_u2dubNVwUQ, (MutatePriority) null, new TransformableStateKt$animatePanBy$2(previous, offset, animationSpec, (Continuation<? super TransformableStateKt$animatePanBy$2>) null), $completion, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static final Object zoomBy(TransformableState $this$zoomBy, float zoomFactor, Continuation<? super Unit> $completion) {
        Object transform$default = TransformableState.transform$default($this$zoomBy, (MutatePriority) null, new TransformableStateKt$zoomBy$2(zoomFactor, (Continuation<? super TransformableStateKt$zoomBy$2>) null), $completion, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static final Object rotateBy(TransformableState $this$rotateBy, float degrees, Continuation<? super Unit> $completion) {
        Object transform$default = TransformableState.transform$default($this$rotateBy, (MutatePriority) null, new TransformableStateKt$rotateBy$2(degrees, (Continuation<? super TransformableStateKt$rotateBy$2>) null), $completion, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    /* renamed from: panBy-d-4ec7I  reason: not valid java name */
    public static final Object m2095panByd4ec7I(TransformableState $this$panBy_u2dd_u2d4ec7I, long offset, Continuation<? super Unit> $completion) {
        Object transform$default = TransformableState.transform$default($this$panBy_u2dd_u2d4ec7I, (MutatePriority) null, new TransformableStateKt$panBy$2(offset, (Continuation<? super TransformableStateKt$panBy$2>) null), $completion, 1, (Object) null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    public static final Object stopTransformation(TransformableState $this$stopTransformation, MutatePriority terminationPriority, Continuation<? super Unit> $completion) {
        Object transform = $this$stopTransformation.transform(terminationPriority, new TransformableStateKt$stopTransformation$2((Continuation<? super TransformableStateKt$stopTransformation$2>) null), $completion);
        return transform == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform : Unit.INSTANCE;
    }
}
