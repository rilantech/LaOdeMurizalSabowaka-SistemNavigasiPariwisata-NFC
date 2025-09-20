package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1", f = "Transformable.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Transformable.kt */
final class TransformableKt$transformable$3$block$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<TransformEvent> $channel;
    final /* synthetic */ State<Boolean> $updatePanZoomLock;
    final /* synthetic */ State<Function0<Boolean>> $updatedCanPan;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableKt$transformable$3$block$1$1(State<Boolean> state, Channel<TransformEvent> channel, State<? extends Function0<Boolean>> state2, Continuation<? super TransformableKt$transformable$3$block$1$1> continuation) {
        super(2, continuation);
        this.$updatePanZoomLock = state;
        this.$channel = channel;
        this.$updatedCanPan = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$transformable$3$block$1$1 transformableKt$transformable$3$block$1$1 = new TransformableKt$transformable$3$block$1$1(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, continuation);
        transformableKt$transformable$3$block$1$1.L$0 = obj;
        return transformableKt$transformable$3$block$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$transformable$3$block$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1", f = "Transformable.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1  reason: invalid class name */
    /* compiled from: Transformable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(pointerInputScope, state, channel, state2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope pointerInputScope = pointerInputScope;
                    final State<Boolean> state = state;
                    final Channel<TransformEvent> channel = channel;
                    final State<Function0<Boolean>> state2 = state2;
                    final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                        private /* synthetic */ Object L$0;
                        int label;

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 r0 = 

                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        final State<Boolean> state = this.$updatePanZoomLock;
                                        final Channel<TransformEvent> channel = this.$channel;
                                        final State<Function0<Boolean>> state2 = this.$updatedCanPan;
                                        final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                                        this.label = 1;
                                        if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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
