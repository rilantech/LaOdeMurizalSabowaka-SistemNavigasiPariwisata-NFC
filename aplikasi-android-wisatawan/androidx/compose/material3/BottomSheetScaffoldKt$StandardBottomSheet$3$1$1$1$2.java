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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SheetState $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2(CoroutineScope coroutineScope, SheetState sheetState) {
        super(0);
        this.$scope = coroutineScope;
        this.$this_with = sheetState;
    }

    public final Boolean invoke() {
        CoroutineScope coroutineScope = this.$scope;
        final SheetState sheetState = this.$this_with;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        return true;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2$1  reason: invalid class name */
    /* compiled from: BottomSheetScaffold.kt */
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
                    if (sheetState.partialExpand(this) != coroutine_suspended) {
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
