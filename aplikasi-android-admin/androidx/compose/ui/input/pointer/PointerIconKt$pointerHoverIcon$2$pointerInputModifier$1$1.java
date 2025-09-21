package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1", f = "PointerIcon.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PointerIcon.kt */
final class PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(PointerIconModifierLocal pointerIconModifierLocal, Continuation<? super PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1> continuation) {
        super(2, continuation);
        this.$pointerIconModifierLocal = pointerIconModifierLocal;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(this.$pointerIconModifierLocal, continuation);
        pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.L$0 = obj;
        return pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1", f = "PointerIcon.kt", i = {0}, l = {112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1  reason: invalid class name */
    /* compiled from: PointerIcon.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(pointerIconModifierLocal, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                switch(r1) {
                    case 0: goto L_0x001e;
                    case 1: goto L_0x0011;
                    default: goto L_0x0009;
                }
            L_0x0009:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0011:
                r1 = r7
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r8)
                r3 = r2
                r2 = r1
                r1 = r0
                r0 = r8
                goto L_0x003e
            L_0x001e:
                kotlin.ResultKt.throwOnFailure(r8)
                r1 = r7
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            L_0x0026:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.L$0 = r2
                r5 = 1
                r1.label = r5
                java.lang.Object r3 = r2.awaitPointerEvent(r3, r4)
                if (r3 != r0) goto L_0x0038
                return r0
            L_0x0038:
                r6 = r0
                r0 = r8
                r8 = r3
                r3 = r2
                r2 = r1
                r1 = r6
            L_0x003e:
                androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
                int r4 = r8.m6133getType7fucELk()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r5 = r5.m6144getEnter7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m6140equalsimpl0(r4, r5)
                if (r4 == 0) goto L_0x0056
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r8 = r4
                r8.enter()
                goto L_0x006b
            L_0x0056:
                int r4 = r8.m6133getType7fucELk()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r5 = r5.m6145getExit7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m6140equalsimpl0(r4, r5)
                if (r4 == 0) goto L_0x006b
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r8 = r4
                r8.exit()
            L_0x006b:
                r8 = r0
                r0 = r1
                r1 = r2
                r2 = r3
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PointerIconModifierLocal pointerIconModifierLocal = this.$pointerIconModifierLocal;
                this.label = 1;
                if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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
