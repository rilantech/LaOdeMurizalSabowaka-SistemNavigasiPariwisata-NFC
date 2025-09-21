package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RepeatOnLifecycle.kt */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> continuation) {
        super(2, continuation);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    /* compiled from: RepeatOnLifecycle.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(lifecycle, state, coroutineScope, function2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cf, code lost:
            r0 = (kotlinx.coroutines.Job) r6.element;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d4, code lost:
            if (r0 == null) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d6, code lost:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00da, code lost:
            r0 = (androidx.lifecycle.LifecycleEventObserver) r5.element;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00de, code lost:
            if (r0 == null) goto L_0x00eb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e0, code lost:
            r4.removeObserver(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ee, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r21
                int r2 = r1.label
                r3 = 1
                r4 = 0
                switch(r2) {
                    case 0: goto L_0x003a;
                    case 1: goto L_0x0015;
                    default: goto L_0x000d;
                }
            L_0x000d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0015:
                r1 = r21
                r2 = r22
                r0 = 0
                java.lang.Object r5 = r1.L$5
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                java.lang.Object r5 = r1.L$4
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                java.lang.Object r5 = r1.L$3
                androidx.lifecycle.Lifecycle r5 = (androidx.lifecycle.Lifecycle) r5
                java.lang.Object r5 = r1.L$2
                androidx.lifecycle.Lifecycle$State r5 = (androidx.lifecycle.Lifecycle.State) r5
                java.lang.Object r5 = r1.L$1
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
                java.lang.Object r6 = r1.L$0
                kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
                kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0037 }
                goto L_0x00cf
            L_0x0037:
                r0 = move-exception
                goto L_0x00f2
            L_0x003a:
                kotlin.ResultKt.throwOnFailure(r22)
                r1 = r21
                r2 = r22
                androidx.lifecycle.Lifecycle r5 = r4
                androidx.lifecycle.Lifecycle$State r5 = r5.getCurrentState()
                androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r5 != r6) goto L_0x004e
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x004e:
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                r14 = r6
                androidx.lifecycle.Lifecycle$State r6 = r5     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.Lifecycle r15 = r4     // Catch:{ all -> 0x00ef }
                kotlinx.coroutines.CoroutineScope r9 = r6     // Catch:{ all -> 0x00ef }
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r13 = r7     // Catch:{ all -> 0x00ef }
                r16 = 0
                r1.L$0 = r5     // Catch:{ all -> 0x00ef }
                r1.L$1 = r14     // Catch:{ all -> 0x00ef }
                r1.L$2 = r6     // Catch:{ all -> 0x00ef }
                r1.L$3 = r15     // Catch:{ all -> 0x00ef }
                r1.L$4 = r9     // Catch:{ all -> 0x00ef }
                r1.L$5 = r13     // Catch:{ all -> 0x00ef }
                r1.label = r3     // Catch:{ all -> 0x00ef }
                r7 = r1
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ all -> 0x00ef }
                r17 = r7
                r18 = 0
                kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00ef }
                kotlin.coroutines.Continuation r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r17)     // Catch:{ all -> 0x00ef }
                r7.<init>(r8, r3)     // Catch:{ all -> 0x00ef }
                r19 = r7
                r19.initCancellability()     // Catch:{ all -> 0x00ef }
                r11 = r19
                kotlinx.coroutines.CancellableContinuation r11 = (kotlinx.coroutines.CancellableContinuation) r11     // Catch:{ all -> 0x00ef }
                r20 = 0
                androidx.lifecycle.Lifecycle$Event$Companion r7 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.Lifecycle$Event r7 = r7.upTo(r6)     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.Lifecycle$Event$Companion r8 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.Lifecycle$Event r10 = r8.downFrom(r6)     // Catch:{ all -> 0x00ef }
                r6 = 0
                kotlinx.coroutines.sync.Mutex r12 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r6, r3, r4)     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r8 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00ef }
                r6 = r8
                r3 = r8
                r8 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00ef }
                r14.element = r3     // Catch:{ all -> 0x00ef }
                T r3 = r14.element     // Catch:{ all -> 0x00ef }
                java.lang.String r6 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r6)     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.LifecycleEventObserver r3 = (androidx.lifecycle.LifecycleEventObserver) r3     // Catch:{ all -> 0x00ef }
                androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3     // Catch:{ all -> 0x00ef }
                r15.addObserver(r3)     // Catch:{ all -> 0x00ef }
                java.lang.Object r3 = r19.getResult()     // Catch:{ all -> 0x00ef }
                java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00ef }
                if (r3 != r6) goto L_0x00c8
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x00ef }
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6)     // Catch:{ all -> 0x00ef }
            L_0x00c8:
                if (r3 != r0) goto L_0x00cb
                return r0
            L_0x00cb:
                r6 = r5
                r5 = r14
                r0 = r16
            L_0x00cf:
                T r0 = r6.element
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                if (r0 == 0) goto L_0x00da
                r3 = 1
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
            L_0x00da:
                T r0 = r5.element
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L_0x00eb
                androidx.lifecycle.Lifecycle r3 = r4
                r4 = 0
                r5 = r0
                androidx.lifecycle.LifecycleObserver r5 = (androidx.lifecycle.LifecycleObserver) r5
                r3.removeObserver(r5)
            L_0x00eb:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x00ef:
                r0 = move-exception
                r6 = r5
                r5 = r14
            L_0x00f2:
                T r3 = r6.element
                kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
                if (r3 == 0) goto L_0x00fc
                r6 = 1
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r3, (java.util.concurrent.CancellationException) r4, (int) r6, (java.lang.Object) r4)
            L_0x00fc:
                T r3 = r5.element
                androidx.lifecycle.LifecycleEventObserver r3 = (androidx.lifecycle.LifecycleEventObserver) r3
                if (r3 == 0) goto L_0x010d
                androidx.lifecycle.Lifecycle r4 = r4
                r5 = 0
                r6 = r3
                androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
                r4.removeObserver(r6)
            L_0x010d:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                final Lifecycle.State state = this.$state;
                final Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$block;
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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
