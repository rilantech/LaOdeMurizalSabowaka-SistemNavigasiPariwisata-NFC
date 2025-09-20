package androidx.compose.material3;

import androidx.compose.ui.focus.FocusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarKt$DockedSearchBar$3", f = "SearchBar.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SearchBar.kt */
final class SearchBarKt$DockedSearchBar$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ FocusManager $focusManager;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$DockedSearchBar$3(boolean z, FocusManager focusManager, Continuation<? super SearchBarKt$DockedSearchBar$3> continuation) {
        super(2, continuation);
        this.$active = z;
        this.$focusManager = focusManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchBarKt$DockedSearchBar$3(this.$active, this.$focusManager, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchBarKt$DockedSearchBar$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            switch(r1) {
                case 0: goto L_0x0017;
                case 1: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0012:
            r0 = r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x002e
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r6
            boolean r3 = r1.$active
            if (r3 != 0) goto L_0x0036
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r1.label = r2
            r4 = 100
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r3)
            if (r3 != r0) goto L_0x002d
            return r0
        L_0x002d:
            r0 = r1
        L_0x002e:
            androidx.compose.ui.focus.FocusManager r1 = r0.$focusManager
            r3 = 0
            r4 = 0
            androidx.compose.ui.focus.FocusManager.clearFocus$default(r1, r3, r2, r4)
            r1 = r0
        L_0x0036:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt$DockedSearchBar$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
