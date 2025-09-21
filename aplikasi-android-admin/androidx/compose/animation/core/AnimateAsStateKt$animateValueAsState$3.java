package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3", f = "AnimateAsState.kt", i = {0}, l = {419}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
/* compiled from: AnimateAsState.kt */
final class AnimateAsStateKt$animateValueAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
    final /* synthetic */ Animatable<T, V> $animatable;
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimateAsStateKt$animateValueAsState$3(Channel<T> channel, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnimateAsStateKt$animateValueAsState$3> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$animatable = animatable;
        this.$animSpec$delegate = state;
        this.$listener$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimateAsStateKt$animateValueAsState$3 animateAsStateKt$animateValueAsState$3 = new AnimateAsStateKt$animateValueAsState$3(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        animateAsStateKt$animateValueAsState$3.L$0 = obj;
        return animateAsStateKt$animateValueAsState$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimateAsStateKt$animateValueAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r19
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x0026;
                case 1: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0013:
            r1 = r19
            r2 = r20
            java.lang.Object r3 = r1.L$1
            kotlinx.coroutines.channels.ChannelIterator r3 = (kotlinx.coroutines.channels.ChannelIterator) r3
            java.lang.Object r4 = r1.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r2)
            r11 = r4
            r4 = r3
            r3 = r2
            goto L_0x0051
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r20)
            r1 = r19
            r2 = r20
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlinx.coroutines.channels.Channel<T> r4 = r1.$channel
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r18 = r4
            r4 = r3
            r3 = r18
        L_0x003c:
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.L$0 = r4
            r1.L$1 = r3
            r6 = 1
            r1.label = r6
            java.lang.Object r5 = r3.hasNext(r5)
            if (r5 != r0) goto L_0x004d
            return r0
        L_0x004d:
            r11 = r4
            r4 = r3
            r3 = r2
            r2 = r5
        L_0x0051:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x008b
            java.lang.Object r2 = r4.next()
            kotlinx.coroutines.channels.Channel<T> r5 = r1.$channel
            java.lang.Object r5 = r5.m1674tryReceivePtdJZtk()
            java.lang.Object r5 = kotlinx.coroutines.channels.ChannelResult.m1659getOrNullimpl(r5)
            if (r5 != 0) goto L_0x006b
            r13 = r2
            goto L_0x006c
        L_0x006b:
            r13 = r5
        L_0x006c:
            androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1 r2 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1
            androidx.compose.animation.core.Animatable<T, V> r14 = r1.$animatable
            androidx.compose.runtime.State<androidx.compose.animation.core.AnimationSpec<T>> r15 = r1.$animSpec$delegate
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<T, kotlin.Unit>> r5 = r1.$listener$delegate
            r17 = 0
            r12 = r2
            r16 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            r8 = r2
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            r5 = r11
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)
            r2 = r3
            r3 = r4
            r4 = r11
            goto L_0x003c
        L_0x008b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
