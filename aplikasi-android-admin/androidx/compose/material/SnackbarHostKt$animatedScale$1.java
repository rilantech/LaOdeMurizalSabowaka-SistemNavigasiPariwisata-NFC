package androidx.compose.material;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SnackbarHostKt$animatedScale$1", f = "SnackbarHost.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$animatedScale$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animation;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ boolean $visible;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$animatedScale$1(Animatable<Float, AnimationVector1D> animatable, boolean z, AnimationSpec<Float> animationSpec, Continuation<? super SnackbarHostKt$animatedScale$1> continuation) {
        super(2, continuation);
        this.$scale = animatable;
        this.$visible = z;
        this.$animation = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarHostKt$animatedScale$1(this.$scale, this.$visible, this.$animation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$animatedScale$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Animatable<Float, AnimationVector1D> animatable = this.$scale;
                float f = this.$visible ? 1.0f : 0.8f;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, Boxing.boxFloat(f), this.$animation, (Object) null, (Function1) null, this, 12, (Object) null) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
