package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1(SheetState sheetState, CoroutineScope coroutineScope, Function0<Unit> function0) {
        super(0);
        this.$sheetState = sheetState;
        this.$scope = coroutineScope;
        this.$onDismissRequest = function0;
    }

    public final void invoke() {
        if (this.$sheetState.getSwipeableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
            CoroutineScope coroutineScope = this.$scope;
            final SheetState sheetState = this.$sheetState;
            Job launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            final SheetState sheetState2 = this.$sheetState;
            final Function0<Unit> function0 = this.$onDismissRequest;
            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((Throwable) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable it) {
                    if (!sheetState2.isVisible()) {
                        function0.invoke();
                    }
                }
            });
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1  reason: invalid class name */
    /* compiled from: ModalBottomSheet.android.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(sheetState, continuation);
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
                    if (sheetState.hide(this) != coroutine_suspended) {
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
