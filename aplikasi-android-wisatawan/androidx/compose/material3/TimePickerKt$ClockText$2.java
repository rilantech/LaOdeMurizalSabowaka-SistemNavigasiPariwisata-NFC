package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockText$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ MutableState<Offset> $center$delegate;
    final /* synthetic */ float $maxDist;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockText$2(boolean z, CoroutineScope coroutineScope, TimePickerState timePickerState, float f, boolean z2, MutableState<Offset> mutableState) {
        super(1);
        this.$selected = z;
        this.$scope = coroutineScope;
        this.$state = timePickerState;
        this.$maxDist = f;
        this.$autoSwitchToMinute = z2;
        this.$center$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        final CoroutineScope coroutineScope = this.$scope;
        final TimePickerState timePickerState = this.$state;
        final float f = this.$maxDist;
        final boolean z = this.$autoSwitchToMinute;
        final MutableState<Offset> mutableState = this.$center$delegate;
        SemanticsPropertiesKt.onClick$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                CoroutineScope coroutineScope = coroutineScope;
                final TimePickerState timePickerState = timePickerState;
                final float f = f;
                final boolean z = z;
                final MutableState<Offset> mutableState = mutableState;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                return true;
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1", f = "TimePicker.kt", i = {}, l = {1317}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1  reason: invalid class name */
            /* compiled from: TimePicker.kt */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(timePickerState, f, z, mutableState, continuation);
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
                            if (timePickerState.onTap$material3_release(Offset.m3003getXimpl(TimePickerKt.access$ClockText$lambda$29(mutableState)), Offset.m3004getYimpl(TimePickerKt.access$ClockText$lambda$29(mutableState)), f, z, this) != coroutine_suspended) {
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
        }, 1, (Object) null);
        SemanticsPropertiesKt.setSelected($this$semantics, this.$selected);
    }
}
