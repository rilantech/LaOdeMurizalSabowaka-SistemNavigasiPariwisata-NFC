package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Animatable.kt */
final class Animatable$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ T $targetValue;
    int label;
    final /* synthetic */ Animatable<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Animatable$snapTo$2(Animatable<T, V> animatable, T t, Continuation<? super Animatable$snapTo$2> continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$targetValue = t;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Animatable$snapTo$2(this.this$0, this.$targetValue, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((Animatable$snapTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.this$0.endAnimation();
                Object clampedValue = this.this$0.clampToBounds(this.$targetValue);
                this.this$0.getInternalState$animation_core_release().setValue$animation_core_release(clampedValue);
                this.this$0.setTargetValue(clampedValue);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
