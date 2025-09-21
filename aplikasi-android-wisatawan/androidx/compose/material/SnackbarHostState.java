package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2 A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(java.lang.String r20, java.lang.String r21, androidx.compose.material.SnackbarDuration r22, kotlin.coroutines.Continuation<? super androidx.compose.material.SnackbarResult> r23) {
        /*
            r19 = this;
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.material.SnackbarHostState$showSnackbar$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r1 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r19
            goto L_0x0021
        L_0x0019:
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r1 = new androidx.compose.material.SnackbarHostState$showSnackbar$1
            r2 = r19
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            r6 = 0
            switch(r4) {
                case 0: goto L_0x0085;
                case 1: goto L_0x0063;
                case 2: goto L_0x0038;
                default: goto L_0x002e;
            }
        L_0x002e:
            r17 = r1
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            r2 = 0
            r4 = 0
            r0 = 0
            java.lang.Object r5 = r1.L$5
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r5 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r5
            java.lang.Object r5 = r1.L$4
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r7 = r1.L$3
            androidx.compose.material.SnackbarDuration r7 = (androidx.compose.material.SnackbarDuration) r7
            java.lang.Object r7 = r1.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r1.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r1.L$0
            androidx.compose.material.SnackbarHostState r7 = (androidx.compose.material.SnackbarHostState) r7
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005d }
            r17 = r1
            r1 = r2
            r2 = r3
            r9 = r6
            goto L_0x00fd
        L_0x005d:
            r0 = move-exception
            r8 = r6
            r17 = r1
            goto L_0x0121
        L_0x0063:
            r2 = 0
            r4 = 0
            java.lang.Object r7 = r1.L$4
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r1.L$3
            androidx.compose.material.SnackbarDuration r8 = (androidx.compose.material.SnackbarDuration) r8
            java.lang.Object r9 = r1.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r1.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r1.L$0
            androidx.compose.material.SnackbarHostState r11 = (androidx.compose.material.SnackbarHostState) r11
            kotlin.ResultKt.throwOnFailure(r3)
            r18 = r9
            r9 = r4
            r4 = r7
            r7 = r11
            r11 = r10
            r10 = r18
            goto L_0x00b0
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r3)
            r2 = r19
            r9 = r21
            r10 = r20
            r8 = r22
            kotlinx.coroutines.sync.Mutex r4 = r2.mutex
            r7 = 0
            r11 = 0
            r1.L$0 = r2
            r1.L$1 = r10
            r1.L$2 = r9
            r1.L$3 = r8
            r1.L$4 = r4
            r1.label = r5
            java.lang.Object r12 = r4.lock(r7, r1)
            if (r12 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r18 = r7
            r7 = r2
            r2 = r11
            r11 = r10
            r10 = r9
            r9 = r18
        L_0x00b0:
            r12 = 0
            r13 = r1
            r14 = 0
            r1.L$0 = r7     // Catch:{ all -> 0x0119 }
            r1.L$1 = r11     // Catch:{ all -> 0x0119 }
            r1.L$2 = r10     // Catch:{ all -> 0x0119 }
            r1.L$3 = r8     // Catch:{ all -> 0x0119 }
            r1.L$4 = r4     // Catch:{ all -> 0x0119 }
            r1.L$5 = r13     // Catch:{ all -> 0x0119 }
            r15 = 2
            r1.label = r15     // Catch:{ all -> 0x0119 }
            r15 = r13
            r16 = 0
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0119 }
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r15)     // Catch:{ all -> 0x0119 }
            r17 = r1
            r1 = 1
            r6.<init>(r5, r1)     // Catch:{ all -> 0x0112 }
            r1 = r6
            r1.initCancellability()     // Catch:{ all -> 0x0112 }
            r5 = r1
            kotlinx.coroutines.CancellableContinuation r5 = (kotlinx.coroutines.CancellableContinuation) r5     // Catch:{ all -> 0x0112 }
            r6 = 0
            r19 = r2
            androidx.compose.material.SnackbarHostState$SnackbarDataImpl r2 = new androidx.compose.material.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x010b }
            r2.<init>(r11, r10, r8, r5)     // Catch:{ all -> 0x010b }
            androidx.compose.material.SnackbarData r2 = (androidx.compose.material.SnackbarData) r2     // Catch:{ all -> 0x010b }
            r7.setCurrentSnackbarData(r2)     // Catch:{ all -> 0x010b }
            java.lang.Object r2 = r1.getResult()     // Catch:{ all -> 0x010b }
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x010b }
            if (r2 != r1) goto L_0x00f5
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r13)     // Catch:{ all -> 0x010b }
        L_0x00f5:
            if (r2 != r0) goto L_0x00f8
            return r0
        L_0x00f8:
            r1 = r19
            r5 = r4
            r4 = r12
            r0 = r14
        L_0x00fd:
            r6 = 0
            r7.setCurrentSnackbarData(r6)     // Catch:{ all -> 0x0107 }
            r5.unlock(r9)
            return r2
        L_0x0107:
            r0 = move-exception
            r2 = r9
            r4 = r5
            goto L_0x012a
        L_0x010b:
            r0 = move-exception
            r2 = r19
            r5 = r4
            r8 = r9
            r4 = r12
            goto L_0x0121
        L_0x0112:
            r0 = move-exception
            r19 = r2
            r5 = r4
            r8 = r9
            r4 = r12
            goto L_0x0121
        L_0x0119:
            r0 = move-exception
            r17 = r1
            r19 = r2
            r5 = r4
            r8 = r9
            r4 = r12
        L_0x0121:
            r1 = 0
            r7.setCurrentSnackbarData(r1)     // Catch:{ all -> 0x0126 }
            throw r0     // Catch:{ all -> 0x0126 }
        L_0x0126:
            r0 = move-exception
            r1 = r2
            r4 = r5
            r2 = r8
        L_0x012a:
            r4.unlock(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostState.showSnackbar(java.lang.String, java.lang.String, androidx.compose.material.SnackbarDuration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "getMessage", "dismiss", "", "performAction", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final CancellableContinuation<SnackbarResult> continuation;
        private final SnackbarDuration duration;
        private final String message;

        public SnackbarDataImpl(String message2, String actionLabel2, SnackbarDuration duration2, CancellableContinuation<? super SnackbarResult> continuation2) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(duration2, TypedValues.TransitionType.S_DURATION);
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.message = message2;
            this.actionLabel = actionLabel2;
            this.duration = duration2;
            this.continuation = continuation2;
        }

        public String getMessage() {
            return this.message;
        }

        public String getActionLabel() {
            return this.actionLabel;
        }

        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public void performAction() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m6229constructorimpl(SnackbarResult.ActionPerformed));
            }
        }

        public void dismiss() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m6229constructorimpl(SnackbarResult.Dismissed));
            }
        }
    }
}
