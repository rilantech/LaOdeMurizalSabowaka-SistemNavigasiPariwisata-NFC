package androidx.compose.material3;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J9\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "SnackbarVisualsImpl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        String str3;
        boolean z2;
        SnackbarDuration snackbarDuration2;
        if ((i & 2) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i & 4) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i & 8) != 0) {
            snackbarDuration2 = str3 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
        } else {
            snackbarDuration2 = snackbarDuration;
        }
        return snackbarHostState.showSnackbar(str, str3, z2, snackbarDuration2, continuation);
    }

    public final Object showSnackbar(String message, String actionLabel, boolean withDismissAction, SnackbarDuration duration, Continuation<? super SnackbarResult> $completion) {
        return showSnackbar(new SnackbarVisualsImpl(message, actionLabel, withDismissAction, duration), $completion);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(androidx.compose.material3.SnackbarVisuals r19, kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult> r20) {
        /*
            r18 = this;
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.material3.SnackbarHostState$showSnackbar$2
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r1 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r18
            goto L_0x0021
        L_0x0019:
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r1 = new androidx.compose.material3.SnackbarHostState$showSnackbar$2
            r2 = r18
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            r6 = 0
            switch(r4) {
                case 0: goto L_0x0072;
                case 1: goto L_0x005a;
                case 2: goto L_0x0038;
                default: goto L_0x002e;
            }
        L_0x002e:
            r16 = r1
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            r2 = 0
            r4 = 0
            r0 = 0
            java.lang.Object r5 = r1.L$3
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r5 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r5
            java.lang.Object r5 = r1.L$2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r7 = r1.L$1
            androidx.compose.material3.SnackbarVisuals r7 = (androidx.compose.material3.SnackbarVisuals) r7
            java.lang.Object r7 = r1.L$0
            androidx.compose.material3.SnackbarHostState r7 = (androidx.compose.material3.SnackbarHostState) r7
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0054 }
            r16 = r1
            r1 = r3
            r9 = r6
            goto L_0x00d6
        L_0x0054:
            r0 = move-exception
            r8 = r6
            r16 = r1
            goto L_0x00ef
        L_0x005a:
            r2 = 0
            r4 = 0
            java.lang.Object r7 = r1.L$2
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r1.L$1
            androidx.compose.material3.SnackbarVisuals r8 = (androidx.compose.material3.SnackbarVisuals) r8
            java.lang.Object r9 = r1.L$0
            androidx.compose.material3.SnackbarHostState r9 = (androidx.compose.material3.SnackbarHostState) r9
            kotlin.ResultKt.throwOnFailure(r3)
            r17 = r9
            r9 = r4
            r4 = r7
            r7 = r17
            goto L_0x0093
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r3)
            r2 = r18
            r8 = r19
            kotlinx.coroutines.sync.Mutex r4 = r2.mutex
            r7 = 0
            r9 = 0
            r1.L$0 = r2
            r1.L$1 = r8
            r1.L$2 = r4
            r1.label = r5
            java.lang.Object r10 = r4.lock(r7, r1)
            if (r10 != r0) goto L_0x008d
            return r0
        L_0x008d:
            r17 = r7
            r7 = r2
            r2 = r9
            r9 = r17
        L_0x0093:
            r10 = 0
            r11 = r1
            r12 = 0
            r1.L$0 = r7     // Catch:{ all -> 0x00e9 }
            r1.L$1 = r8     // Catch:{ all -> 0x00e9 }
            r1.L$2 = r4     // Catch:{ all -> 0x00e9 }
            r1.L$3 = r11     // Catch:{ all -> 0x00e9 }
            r13 = 2
            r1.label = r13     // Catch:{ all -> 0x00e9 }
            r13 = r11
            r14 = 0
            kotlinx.coroutines.CancellableContinuationImpl r15 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00e9 }
            kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r13)     // Catch:{ all -> 0x00e9 }
            r15.<init>(r6, r5)     // Catch:{ all -> 0x00e9 }
            r5 = r15
            r5.initCancellability()     // Catch:{ all -> 0x00e9 }
            r6 = r5
            kotlinx.coroutines.CancellableContinuation r6 = (kotlinx.coroutines.CancellableContinuation) r6     // Catch:{ all -> 0x00e9 }
            r15 = 0
            r16 = r1
            androidx.compose.material3.SnackbarHostState$SnackbarDataImpl r1 = new androidx.compose.material3.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x00e4 }
            r1.<init>(r8, r6)     // Catch:{ all -> 0x00e4 }
            androidx.compose.material3.SnackbarData r1 = (androidx.compose.material3.SnackbarData) r1     // Catch:{ all -> 0x00e4 }
            r7.setCurrentSnackbarData(r1)     // Catch:{ all -> 0x00e4 }
            java.lang.Object r1 = r5.getResult()     // Catch:{ all -> 0x00e4 }
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00e4 }
            if (r1 != r5) goto L_0x00d0
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r11)     // Catch:{ all -> 0x00e4 }
        L_0x00d0:
            if (r1 != r0) goto L_0x00d3
            return r0
        L_0x00d3:
            r5 = r4
            r4 = r10
            r0 = r12
        L_0x00d6:
            r6 = 0
            r7.setCurrentSnackbarData(r6)     // Catch:{ all -> 0x00e0 }
            r5.unlock(r9)
            return r1
        L_0x00e0:
            r0 = move-exception
            r1 = r9
            r4 = r5
            goto L_0x00f7
        L_0x00e4:
            r0 = move-exception
            r5 = r4
            r8 = r9
            r4 = r10
            goto L_0x00ef
        L_0x00e9:
            r0 = move-exception
            r16 = r1
            r5 = r4
            r8 = r9
            r4 = r10
        L_0x00ef:
            r1 = 0
            r7.setCurrentSnackbarData(r1)     // Catch:{ all -> 0x00f4 }
            throw r0     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r0 = move-exception
            r4 = r5
            r1 = r8
        L_0x00f7:
            r4.unlock(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostState.showSnackbar(androidx.compose.material3.SnackbarVisuals, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getMessage", "getWithDismissAction", "()Z", "equals", "other", "", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(String message2, String actionLabel2, boolean withDismissAction2, SnackbarDuration duration2) {
            Intrinsics.checkNotNullParameter(message2, "message");
            Intrinsics.checkNotNullParameter(duration2, TypedValues.TransitionType.S_DURATION);
            this.message = message2;
            this.actionLabel = actionLabel2;
            this.withDismissAction = withDismissAction2;
            this.duration = duration2;
        }

        public String getMessage() {
            return this.message;
        }

        public String getActionLabel() {
            return this.actionLabel;
        }

        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) other;
            if (Intrinsics.areEqual((Object) getMessage(), (Object) ((SnackbarVisualsImpl) other).getMessage()) && Intrinsics.areEqual((Object) getActionLabel(), (Object) ((SnackbarVisualsImpl) other).getActionLabel()) && getWithDismissAction() == ((SnackbarVisualsImpl) other).getWithDismissAction() && getDuration() == ((SnackbarVisualsImpl) other).getDuration()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getMessage().hashCode() * 31;
            String actionLabel2 = getActionLabel();
            return ((((hashCode + (actionLabel2 != null ? actionLabel2.hashCode() : 0)) * 31) + Boolean.hashCode(getWithDismissAction())) * 31) + getDuration().hashCode();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "dismiss", "", "equals", "", "other", "", "hashCode", "", "performAction", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarDataImpl implements SnackbarData {
        private final CancellableContinuation<SnackbarResult> continuation;
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(SnackbarVisuals visuals2, CancellableContinuation<? super SnackbarResult> continuation2) {
            Intrinsics.checkNotNullParameter(visuals2, "visuals");
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.visuals = visuals2;
            this.continuation = continuation2;
        }

        public SnackbarVisuals getVisuals() {
            return this.visuals;
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

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) other;
            if (Intrinsics.areEqual((Object) getVisuals(), (Object) ((SnackbarDataImpl) other).getVisuals()) && Intrinsics.areEqual((Object) this.continuation, (Object) ((SnackbarDataImpl) other).continuation)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }
    }
}
