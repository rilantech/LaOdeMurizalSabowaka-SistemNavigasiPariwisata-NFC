package androidx.compose.material3;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1", f = "TimePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimePickerTextField$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ int $selection;
    final /* synthetic */ TimePickerState $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimePickerTextField$2$1(TimePickerState timePickerState, int i, FocusRequester focusRequester, Continuation<? super TimePickerKt$TimePickerTextField$2$1> continuation) {
        super(2, continuation);
        this.$state = timePickerState;
        this.$selection = i;
        this.$focusRequester = focusRequester;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TimePickerKt$TimePickerTextField$2$1(this.$state, this.$selection, this.$focusRequester, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TimePickerKt$TimePickerTextField$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (Selection.m1956equalsimpl0(this.$state.m2191getSelectionJiIwxys$material3_release(), this.$selection)) {
                    this.$focusRequester.requestFocus();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
