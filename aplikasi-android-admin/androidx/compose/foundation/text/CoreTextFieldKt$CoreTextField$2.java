package androidx.compose.foundation.text;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2", f = "CoreTextField.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ State<Boolean> $writeable$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$2(TextFieldState textFieldState, State<Boolean> state, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, Continuation<? super CoreTextFieldKt$CoreTextField$2> continuation) {
        super(2, continuation);
        this.$state = textFieldState;
        this.$writeable$delegate = state;
        this.$textInputService = textInputService;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
        this.$offsetMapping = offsetMapping;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$2(this.$state, this.$writeable$delegate, this.$textInputService, this.$value, this.$imeOptions, this.$offsetMapping, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        androidx.compose.foundation.text.CoreTextFieldKt.endInputSession(r0.$state);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            switch(r1) {
                case 0: goto L_0x0018;
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
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0016 }
            goto L_0x004a
        L_0x0016:
            r1 = move-exception
            goto L_0x0057
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r11
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1     // Catch:{ all -> 0x0053 }
            androidx.compose.runtime.State<java.lang.Boolean> r3 = r1.$writeable$delegate     // Catch:{ all -> 0x0053 }
            r2.<init>(r3)     // Catch:{ all -> 0x0053 }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch:{ all -> 0x0053 }
            kotlinx.coroutines.flow.Flow r2 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r2)     // Catch:{ all -> 0x0053 }
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$2 r9 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$2     // Catch:{ all -> 0x0053 }
            androidx.compose.foundation.text.TextFieldState r4 = r1.$state     // Catch:{ all -> 0x0053 }
            androidx.compose.ui.text.input.TextInputService r5 = r1.$textInputService     // Catch:{ all -> 0x0053 }
            androidx.compose.ui.text.input.TextFieldValue r6 = r1.$value     // Catch:{ all -> 0x0053 }
            androidx.compose.ui.text.input.ImeOptions r7 = r1.$imeOptions     // Catch:{ all -> 0x0053 }
            androidx.compose.ui.text.input.OffsetMapping r8 = r1.$offsetMapping     // Catch:{ all -> 0x0053 }
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0053 }
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9     // Catch:{ all -> 0x0053 }
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ all -> 0x0053 }
            r4 = 1
            r1.label = r4     // Catch:{ all -> 0x0053 }
            java.lang.Object r2 = r2.collect(r9, r3)     // Catch:{ all -> 0x0053 }
            if (r2 != r0) goto L_0x0049
            return r0
        L_0x0049:
            r0 = r1
        L_0x004a:
            androidx.compose.foundation.text.TextFieldState r1 = r0.$state
            androidx.compose.foundation.text.CoreTextFieldKt.endInputSession(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0053:
            r0 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L_0x0057:
            androidx.compose.foundation.text.TextFieldState r2 = r0.$state
            androidx.compose.foundation.text.CoreTextFieldKt.endInputSession(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
