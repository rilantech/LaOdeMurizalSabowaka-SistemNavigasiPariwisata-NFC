package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SnackbarHostKt$animatedOpacity$2", f = "SnackbarHost.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$animatedOpacity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $alpha;
    final /* synthetic */ AnimationSpec<Float> $animation;
    final /* synthetic */ Function0<Unit> $onAnimationFinish;
    final /* synthetic */ boolean $visible;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$animatedOpacity$2(Animatable<Float, AnimationVector1D> animatable, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Continuation<? super SnackbarHostKt$animatedOpacity$2> continuation) {
        super(2, continuation);
        this.$alpha = animatable;
        this.$visible = z;
        this.$animation = animationSpec;
        this.$onAnimationFinish = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarHostKt$animatedOpacity$2(this.$alpha, this.$visible, this.$animation, this.$onAnimationFinish, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$animatedOpacity$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SnackbarHostKt$animatedOpacity$2 snackbarHostKt$animatedOpacity$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> animatable = this.$alpha;
                float f = this.$visible ? 1.0f : 0.0f;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, Boxing.boxFloat(f), this.$animation, (Object) null, (Function1) null, this, 12, (Object) null) != coroutine_suspended) {
                    snackbarHostKt$animatedOpacity$2 = this;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                snackbarHostKt$animatedOpacity$2 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        snackbarHostKt$animatedOpacity$2.$onAnimationFinish.invoke();
        return Unit.INSTANCE;
    }
}
