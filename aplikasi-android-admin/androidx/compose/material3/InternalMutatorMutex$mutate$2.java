package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.material3.InternalMutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.InternalMutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", i = {0, 0, 1, 1}, l = {177, 99}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: InternalMutatorMutex.kt */
final class InternalMutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InternalMutatorMutex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InternalMutatorMutex$mutate$2(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super InternalMutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = internalMutatorMutex;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$2 = new InternalMutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        internalMutatorMutex$mutate$2.L$0 = obj;
        return internalMutatorMutex$mutate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((InternalMutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throwable th;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Throwable th2;
        InternalMutatorMutex.Mutator mutator;
        InternalMutatorMutex internalMutatorMutex;
        boolean z;
        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$2;
        InternalMutatorMutex.Mutator mutator2;
        Mutex $this$withLock_u24default$iv2;
        Object owner$iv2;
        Function1<Continuation<? super R>, Object> function1;
        boolean z2;
        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$22;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                internalMutatorMutex$mutate$22 = this;
                MutatePriority mutatePriority = internalMutatorMutex$mutate$22.$priority;
                CoroutineContext.Element element = ((CoroutineScope) internalMutatorMutex$mutate$22.L$0).getCoroutineContext().get(Job.Key);
                Intrinsics.checkNotNull(element);
                InternalMutatorMutex.Mutator mutator3 = new InternalMutatorMutex.Mutator(mutatePriority, (Job) element);
                internalMutatorMutex$mutate$22.this$0.tryMutateOrCancel(mutator3);
                Mutex $this$withLock_u24default$iv3 = internalMutatorMutex$mutate$22.this$0.mutex;
                function1 = internalMutatorMutex$mutate$22.$block;
                InternalMutatorMutex internalMutatorMutex2 = internalMutatorMutex$mutate$22.this$0;
                internalMutatorMutex$mutate$22.L$0 = mutator3;
                internalMutatorMutex$mutate$22.L$1 = $this$withLock_u24default$iv3;
                internalMutatorMutex$mutate$22.L$2 = function1;
                internalMutatorMutex$mutate$22.L$3 = internalMutatorMutex2;
                internalMutatorMutex$mutate$22.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, internalMutatorMutex$mutate$22) != coroutine_suspended) {
                    mutator2 = mutator3;
                    z2 = false;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                    internalMutatorMutex = internalMutatorMutex2;
                    owner$iv2 = null;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                internalMutatorMutex$mutate$22 = this;
                z2 = false;
                internalMutatorMutex = (InternalMutatorMutex) internalMutatorMutex$mutate$22.L$3;
                function1 = (Function1) internalMutatorMutex$mutate$22.L$2;
                owner$iv2 = null;
                $this$withLock_u24default$iv2 = (Mutex) internalMutatorMutex$mutate$22.L$1;
                mutator2 = (InternalMutatorMutex.Mutator) internalMutatorMutex$mutate$22.L$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                internalMutatorMutex$mutate$2 = this;
                z = false;
                internalMutatorMutex = (InternalMutatorMutex) internalMutatorMutex$mutate$2.L$2;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) internalMutatorMutex$mutate$2.L$1;
                mutator = (InternalMutatorMutex.Mutator) internalMutatorMutex$mutate$2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$23 = internalMutatorMutex$mutate$2;
                    Object obj = $result;
                    break;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        internalMutatorMutex.currentMutator.compareAndSet(mutator, (Object) null);
                        throw th2;
                    } catch (Throwable th4) {
                        boolean z3 = z;
                        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$24 = internalMutatorMutex$mutate$2;
                        Object obj2 = $result;
                        th = th4;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        throw th;
                    }
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            internalMutatorMutex$mutate$22.L$0 = mutator2;
            internalMutatorMutex$mutate$22.L$1 = $this$withLock_u24default$iv2;
            internalMutatorMutex$mutate$22.L$2 = internalMutatorMutex;
            internalMutatorMutex$mutate$22.L$3 = null;
            internalMutatorMutex$mutate$22.label = 2;
            Object invoke = function1.invoke(internalMutatorMutex$mutate$22);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = $result;
            $result = invoke;
            owner$iv = owner$iv2;
            $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
            mutator = mutator2;
            try {
                internalMutatorMutex.currentMutator.compareAndSet(mutator, (Object) null);
                $this$withLock_u24default$iv.unlock(owner$iv);
                return $result;
            } catch (Throwable th5) {
                th = th5;
                $this$withLock_u24default$iv.unlock(owner$iv);
                throw th;
            }
        } catch (Throwable th6) {
            owner$iv = owner$iv2;
            $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
            mutator = mutator2;
            th2 = th6;
            internalMutatorMutex$mutate$2 = internalMutatorMutex$mutate$22;
            z = z2;
            internalMutatorMutex.currentMutator.compareAndSet(mutator, (Object) null);
            throw th2;
        }
    }
}
