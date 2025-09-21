package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2", f = "Recomposer.kt", i = {0}, l = {68, 70}, m = "invokeSuspend", n = {"recomposer"}, s = {"L$0"})
/* compiled from: Recomposer.kt */
final class RecomposerKt$withRunningRecomposer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecomposerKt$withRunningRecomposer$2(Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super RecomposerKt$withRunningRecomposer$2> continuation) {
        super(2, continuation);
        this.$block = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RecomposerKt$withRunningRecomposer$2 recomposerKt$withRunningRecomposer$2 = new RecomposerKt$withRunningRecomposer$2(this.$block, continuation);
        recomposerKt$withRunningRecomposer$2.L$0 = obj;
        return recomposerKt$withRunningRecomposer$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((RecomposerKt$withRunningRecomposer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Recomposer recomposer;
        Object obj;
        RecomposerKt$withRunningRecomposer$2 recomposerKt$withRunningRecomposer$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                recomposerKt$withRunningRecomposer$2 = this;
                CoroutineScope $this$coroutineScope = (CoroutineScope) recomposerKt$withRunningRecomposer$2.L$0;
                recomposer = new Recomposer($this$coroutineScope.getCoroutineContext());
                Job unused = BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> function3 = recomposerKt$withRunningRecomposer$2.$block;
                recomposerKt$withRunningRecomposer$2.L$0 = recomposer;
                recomposerKt$withRunningRecomposer$2.label = 1;
                obj = function3.invoke($this$coroutineScope, recomposer, recomposerKt$withRunningRecomposer$2);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                recomposerKt$withRunningRecomposer$2 = this;
                ResultKt.throwOnFailure($result);
                recomposer = (Recomposer) recomposerKt$withRunningRecomposer$2.L$0;
                obj = $result;
                break;
            case 2:
                Object obj2 = this.L$0;
                ResultKt.throwOnFailure($result);
                return obj2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        recomposer.close();
        recomposerKt$withRunningRecomposer$2.L$0 = obj;
        recomposerKt$withRunningRecomposer$2.label = 2;
        if (recomposer.join(recomposerKt$withRunningRecomposer$2) == coroutine_suspended) {
            return coroutine_suspended;
        }
        RecomposerKt$withRunningRecomposer$2 recomposerKt$withRunningRecomposer$22 = recomposerKt$withRunningRecomposer$2;
        return obj;
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1", f = "Recomposer.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1  reason: invalid class name */
    /* compiled from: Recomposer.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(recomposer, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (recomposer.runRecomposeAndApplyChanges(this) != coroutine_suspended) {
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
}
