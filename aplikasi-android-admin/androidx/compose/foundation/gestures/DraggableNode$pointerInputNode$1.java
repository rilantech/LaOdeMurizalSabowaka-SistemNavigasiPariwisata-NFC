package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1", f = "Draggable.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable.kt */
final class DraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DraggableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableNode$pointerInputNode$1(DraggableNode draggableNode, Continuation<? super DraggableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = draggableNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this.this$0, continuation);
        draggableNode$pointerInputNode$1.L$0 = obj;
        return draggableNode$pointerInputNode$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                if (this.this$0.enabled) {
                    final DraggableNode draggableNode = this.this$0;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {326}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1  reason: invalid class name */
    /* compiled from: Draggable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1($this$SuspendingPointerInputModifierNode, draggableNode, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                switch(r1) {
                    case 0: goto L_0x001c;
                    case 1: goto L_0x0011;
                    default: goto L_0x0009;
                }
            L_0x0009:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0011:
                r0 = r11
                java.lang.Object r1 = r0.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x001a }
                goto L_0x0055
            L_0x001a:
                r2 = move-exception
                goto L_0x005b
            L_0x001c:
                kotlin.ResultKt.throwOnFailure(r12)
                r1 = r11
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                kotlinx.coroutines.CoroutineStart r5 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1 r3 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1
                androidx.compose.foundation.gestures.DraggableNode r4 = r4
                r9 = 0
                r3.<init>(r4, r9)
                r6 = r3
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r7 = 1
                r8 = 0
                r4 = 0
                r3 = r2
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
                androidx.compose.ui.input.pointer.PointerInputScope r3 = r2     // Catch:{ CancellationException -> 0x0056 }
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2 r4 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2     // Catch:{ CancellationException -> 0x0056 }
                androidx.compose.foundation.gestures.DraggableNode r5 = r4     // Catch:{ CancellationException -> 0x0056 }
                r4.<init>(r2, r5, r9)     // Catch:{ CancellationException -> 0x0056 }
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ CancellationException -> 0x0056 }
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x0056 }
                r1.L$0 = r2     // Catch:{ CancellationException -> 0x0056 }
                r6 = 1
                r1.label = r6     // Catch:{ CancellationException -> 0x0056 }
                java.lang.Object r3 = r3.awaitPointerEventScope(r4, r5)     // Catch:{ CancellationException -> 0x0056 }
                if (r3 != r0) goto L_0x0053
                return r0
            L_0x0053:
                r0 = r1
                r1 = r2
            L_0x0055:
                goto L_0x0061
            L_0x0056:
                r0 = move-exception
                r10 = r2
                r2 = r0
                r0 = r1
                r1 = r10
            L_0x005b:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r3 == 0) goto L_0x0064
            L_0x0061:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x0064:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
