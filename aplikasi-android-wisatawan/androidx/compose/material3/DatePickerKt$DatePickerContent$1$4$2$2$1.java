package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$4$2$2$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$4$2$2$1(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, StateData stateData, LazyListState lazyListState) {
        super(1);
        this.$coroutineScope = coroutineScope;
        this.$yearPickerVisible$delegate = mutableState;
        this.$stateData = stateData;
        this.$monthsListState = lazyListState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int year) {
        MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        DatePickerKt.DatePickerContent$lambda$6(mutableState, !DatePickerKt.DatePickerContent$lambda$5(mutableState));
        CoroutineScope coroutineScope = this.$coroutineScope;
        final StateData stateData = this.$stateData;
        final LazyListState lazyListState = this.$monthsListState;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1", f = "DatePicker.kt", i = {}, l = {1212}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1  reason: invalid class name */
    /* compiled from: DatePicker.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(stateData, lazyListState, year, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StateData $this$invokeSuspend_u24lambda_u240 = stateData;
                    LazyListState lazyListState = lazyListState;
                    this.label = 1;
                    if (LazyListState.scrollToItem$default(lazyListState, (((year - $this$invokeSuspend_u24lambda_u240.getYearRange().getFirst()) * 12) + $this$invokeSuspend_u24lambda_u240.getDisplayedMonth().getMonth()) - 1, 0, this, 2, (Object) null) != coroutine_suspended) {
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
