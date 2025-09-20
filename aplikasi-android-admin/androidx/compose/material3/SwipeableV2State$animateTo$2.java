package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableV2State$animateTo$2", f = "SwipeableV2.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$animateTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Float $targetOffset;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ float $velocity;
    int label;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$animateTo$2(SwipeableV2State<T> swipeableV2State, T t, Float f, float f2, Continuation<? super SwipeableV2State$animateTo$2> continuation) {
        super(1, continuation);
        this.this$0 = swipeableV2State;
        this.$targetValue = t;
        this.$targetOffset = f;
        this.$velocity = f2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SwipeableV2State$animateTo$2(this.this$0, this.$targetValue, this.$targetOffset, this.$velocity, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SwipeableV2State$animateTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SwipeableV2State$animateTo$2 swipeableV2State$animateTo$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.setAnimationTarget(this.$targetValue);
                final Ref.FloatRef prev = new Ref.FloatRef();
                Float offset = this.this$0.getOffset();
                prev.element = offset != null ? offset.floatValue() : 0.0f;
                float f = prev.element;
                float floatValue = this.$targetOffset.floatValue();
                float f2 = this.$velocity;
                AnimationSpec<Float> animationSpec$material3_release = this.this$0.getAnimationSpec$material3_release();
                final SwipeableV2State<T> swipeableV2State = this.this$0;
                this.label = 1;
                if (SuspendAnimationKt.animate(f, floatValue, f2, animationSpec$material3_release, new Function2<Float, Float, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke(((Number) p1).floatValue(), ((Number) p2).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float value, float velocity) {
                        swipeableV2State.setOffset(Float.valueOf(value));
                        prev.element = value;
                        swipeableV2State.setLastVelocity(velocity);
                    }
                }, this) != coroutine_suspended) {
                    swipeableV2State$animateTo$2 = this;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                swipeableV2State$animateTo$2 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        swipeableV2State$animateTo$2.this$0.setLastVelocity(0.0f);
        return Unit.INSTANCE;
    }
}
