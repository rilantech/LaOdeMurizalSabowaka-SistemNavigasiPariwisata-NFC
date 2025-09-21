package androidx.compose.runtime;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public DerivedSnapshotState(Function0<? extends T> calculation2, SnapshotMutationPolicy<T> policy2) {
        Intrinsics.checkNotNullParameter(calculation2, "calculation");
        this.calculation = calculation2;
        this.policy = policy2;
    }

    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 /*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001/B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u001a\u0010(\u001a\u00020)2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\b2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00028\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u00060"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "_dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "get_dependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "set_dependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "result", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DerivedState.kt */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Object Unset = new Object();
        private IdentityArrayMap<StateObject, Integer> _dependencies;
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DerivedState.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public final IdentityArrayMap<StateObject, Integer> get_dependencies() {
            return this._dependencies;
        }

        public final void set_dependencies(IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this._dependencies = identityArrayMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord other = (ResultRecord) value;
            this._dependencies = other._dependencies;
            this.result = other.result;
            this.resultHash = other.resultHash;
        }

        public StateRecord create() {
            return new ResultRecord();
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            int i;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                z = false;
                i = (this.validSnapshotId == snapshot.getId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) ? 0 : 1;
            }
            int snapshotChanged = i;
            if (this.result != Unset && (snapshotChanged == 0 || this.resultHash == readableHash(derivedState, snapshot))) {
                z = true;
            }
            boolean isValid = z;
            if (isValid && snapshotChanged != 0) {
                synchronized (SnapshotKt.getLock()) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return isValid;
        }

        /* JADX INFO: finally extract failed */
        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap identityArrayMap;
            StateRecord record;
            DerivedState<?> derivedState2 = derivedState;
            Snapshot snapshot2 = snapshot;
            Intrinsics.checkNotNullParameter(derivedState2, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot2, "snapshot");
            int hash = 7;
            synchronized (SnapshotKt.getLock()) {
                try {
                    identityArrayMap = this._dependencies;
                } catch (Throwable th) {
                    throw th;
                }
            }
            IdentityArrayMap dependencies = identityArrayMap;
            if (dependencies != null) {
                MutableVector derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                MutableVector this_$iv$iv = derivedStateObservers;
                int size$iv$iv = this_$iv$iv.getSize();
                int i = 1;
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    do {
                        ((DerivedStateObserver) content$iv$iv[i$iv$iv]).start(derivedState2);
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                IdentityArrayMap this_$iv = dependencies;
                int index$iv = 0;
                try {
                    int size = this_$iv.getSize();
                    while (index$iv < size) {
                        Object obj = this_$iv.getKeys()[index$iv];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) this_$iv.getValues()[index$iv]).intValue() == i) {
                            if (stateObject instanceof DerivedSnapshotState) {
                                record = ((DerivedSnapshotState) stateObject).current(snapshot2);
                            } else {
                                record = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot2);
                            }
                            hash = (((hash * 31) + ActualJvm_jvmKt.identityHashCode(record)) * 31) + record.getSnapshotId$runtime_release();
                        }
                        index$iv++;
                        i = 1;
                    }
                    Unit unit = Unit.INSTANCE;
                    MutableVector this_$iv$iv2 = derivedStateObservers;
                    int size$iv$iv2 = this_$iv$iv2.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = 0;
                        Object[] content$iv$iv2 = this_$iv$iv2.getContent();
                        do {
                            ((DerivedStateObserver) content$iv$iv2[i$iv$iv2]).done(derivedState2);
                            i$iv$iv2++;
                        } while (i$iv$iv2 < size$iv$iv2);
                    }
                } catch (Throwable th2) {
                    MutableVector this_$iv$iv3 = derivedStateObservers;
                    int size$iv$iv3 = this_$iv$iv3.getSize();
                    if (size$iv$iv3 > 0) {
                        int i$iv$iv3 = 0;
                        Object[] content$iv$iv3 = this_$iv$iv3.getContent();
                        do {
                            ((DerivedStateObserver) content$iv$iv3[i$iv$iv3]).done(derivedState2);
                            i$iv$iv3++;
                        } while (i$iv$iv3 < size$iv$iv3);
                    }
                    throw th2;
                }
            }
            return hash;
        }

        public T getCurrentValue() {
            return this.result;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = r0.getKeys();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object[] getDependencies() {
            /*
                r2 = this;
                androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.snapshots.StateObject, java.lang.Integer> r0 = r2._dependencies
                if (r0 == 0) goto L_0x000a
                java.lang.Object[] r0 = r0.getKeys()
                if (r0 != 0) goto L_0x000f
            L_0x000a:
                r0 = 0
                r1 = 0
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r0 = r1
            L_0x000f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.ResultRecord.getDependencies():java.lang.Object[]");
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x021f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> currentRecord(androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> r19, androidx.compose.runtime.snapshots.Snapshot r20, boolean r21, kotlin.jvm.functions.Function0<? extends T> r22) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r1
            androidx.compose.runtime.DerivedState r0 = (androidx.compose.runtime.DerivedState) r0
            r3 = r20
            boolean r0 = r2.isValid(r0, r3)
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x00eb
            if (r21 == 0) goto L_0x00ea
            r6 = 0
            androidx.compose.runtime.collection.MutableVector r7 = androidx.compose.runtime.SnapshotStateKt.derivedStateObservers()
            r0 = r7
            r8 = 0
            int r9 = r0.getSize()
            if (r9 <= 0) goto L_0x0035
            r10 = 0
            java.lang.Object[] r11 = r0.getContent()
        L_0x0026:
            r12 = r11[r10]
            androidx.compose.runtime.DerivedStateObserver r12 = (androidx.compose.runtime.DerivedStateObserver) r12
            r13 = 0
            r14 = r1
            androidx.compose.runtime.DerivedState r14 = (androidx.compose.runtime.DerivedState) r14
            r12.start(r14)
            int r10 = r10 + r5
            if (r10 < r9) goto L_0x0026
        L_0x0035:
            r0 = 0
            androidx.compose.runtime.collection.IdentityArrayMap r8 = r19.get_dependencies()     // Catch:{ all -> 0x00c8 }
            androidx.compose.runtime.SnapshotThreadLocal r9 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00c8 }
            java.lang.Object r9 = r9.get()     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x00c8 }
            if (r9 == 0) goto L_0x004c
            int r4 = r9.intValue()     // Catch:{ all -> 0x00c8 }
        L_0x004c:
            if (r8 == 0) goto L_0x0096
            r9 = r8
            r10 = 0
            r11 = 0
            int r12 = r9.getSize()     // Catch:{ all -> 0x00c8 }
        L_0x0055:
            if (r11 >= r12) goto L_0x0092
            java.lang.Object[] r13 = r9.getKeys()     // Catch:{ all -> 0x00c8 }
            r13 = r13[r11]     // Catch:{ all -> 0x00c8 }
            java.lang.String r14 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r14)     // Catch:{ all -> 0x00c8 }
            java.lang.Object[] r14 = r9.getValues()     // Catch:{ all -> 0x00c8 }
            r14 = r14[r11]     // Catch:{ all -> 0x00c8 }
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ all -> 0x00c8 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x00c8 }
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13     // Catch:{ all -> 0x00c8 }
            r15 = 0
            androidx.compose.runtime.SnapshotThreadLocal r5 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00c8 }
            int r16 = r14 + r4
            r17 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x00c8 }
            r5.set(r0)     // Catch:{ all -> 0x00c8 }
            kotlin.jvm.functions.Function1 r0 = r20.getReadObserver$runtime_release()     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x008a
            r0.invoke(r13)     // Catch:{ all -> 0x00c8 }
        L_0x008a:
            int r11 = r11 + 1
            r0 = r17
            r5 = 1
            goto L_0x0055
        L_0x0092:
            r17 = r0
            goto L_0x0098
        L_0x0096:
            r17 = r0
        L_0x0098:
            androidx.compose.runtime.SnapshotThreadLocal r0 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00c8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00c8 }
            r0.set(r5)     // Catch:{ all -> 0x00c8 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c8 }
            r0 = r7
            r4 = 0
            int r5 = r0.getSize()
            if (r5 <= 0) goto L_0x00c5
            r8 = 0
            java.lang.Object[] r9 = r0.getContent()
        L_0x00b5:
            r10 = r9[r8]
            androidx.compose.runtime.DerivedStateObserver r10 = (androidx.compose.runtime.DerivedStateObserver) r10
            r11 = 0
            r12 = r1
            androidx.compose.runtime.DerivedState r12 = (androidx.compose.runtime.DerivedState) r12
            r10.done(r12)
            r10 = 1
            int r8 = r8 + r10
            if (r8 < r5) goto L_0x00b5
        L_0x00c5:
            goto L_0x00ea
        L_0x00c8:
            r0 = move-exception
            r4 = r7
            r5 = 0
            int r8 = r4.getSize()
            if (r8 <= 0) goto L_0x00e8
            r9 = 0
            java.lang.Object[] r10 = r4.getContent()
        L_0x00d7:
            r11 = r10[r9]
            androidx.compose.runtime.DerivedStateObserver r11 = (androidx.compose.runtime.DerivedStateObserver) r11
            r12 = 0
            r13 = r1
            androidx.compose.runtime.DerivedState r13 = (androidx.compose.runtime.DerivedState) r13
            r11.done(r13)
            r11 = 1
            int r9 = r9 + r11
            if (r9 >= r8) goto L_0x00e8
            goto L_0x00d7
        L_0x00e8:
            throw r0
        L_0x00ea:
            return r2
        L_0x00eb:
            androidx.compose.runtime.SnapshotThreadLocal r0 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel
            java.lang.Object r0 = r0.get()
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x00fc
            int r0 = r0.intValue()
            goto L_0x00fd
        L_0x00fc:
            r0 = r4
        L_0x00fd:
            r5 = r0
            androidx.compose.runtime.collection.IdentityArrayMap r0 = new androidx.compose.runtime.collection.IdentityArrayMap
            r6 = 0
            r7 = 1
            r0.<init>(r4, r7, r6)
            r7 = r0
            r8 = 0
            androidx.compose.runtime.collection.MutableVector r9 = androidx.compose.runtime.SnapshotStateKt.derivedStateObservers()
            r0 = r9
            r10 = 0
            int r11 = r0.getSize()
            if (r11 <= 0) goto L_0x012c
            r12 = 0
            java.lang.Object[] r13 = r0.getContent()
        L_0x0119:
            r14 = r13[r12]
            androidx.compose.runtime.DerivedStateObserver r14 = (androidx.compose.runtime.DerivedStateObserver) r14
            r15 = 0
            r4 = r1
            androidx.compose.runtime.DerivedState r4 = (androidx.compose.runtime.DerivedState) r4
            r14.start(r4)
            r4 = 1
            int r12 = r12 + r4
            if (r12 < r11) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r4 = 0
            goto L_0x0119
        L_0x012c:
            r0 = 0
            androidx.compose.runtime.SnapshotThreadLocal r4 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x0213 }
            int r10 = r5 + 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0213 }
            r4.set(r10)     // Catch:{ all -> 0x0213 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0213 }
            androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1 r10 = new androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1     // Catch:{ all -> 0x0213 }
            r10.<init>(r1, r7, r5)     // Catch:{ all -> 0x0213 }
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch:{ all -> 0x0213 }
            r11 = r22
            java.lang.Object r4 = r4.observe(r10, r6, r11)     // Catch:{ all -> 0x0211 }
            androidx.compose.runtime.SnapshotThreadLocal r6 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x0211 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0211 }
            r6.set(r10)     // Catch:{ all -> 0x0211 }
            r0 = r9
            r6 = 0
            int r10 = r0.getSize()
            if (r10 <= 0) goto L_0x017d
            r12 = 0
            java.lang.Object[] r13 = r0.getContent()
        L_0x0167:
            r14 = r13[r12]
            androidx.compose.runtime.DerivedStateObserver r14 = (androidx.compose.runtime.DerivedStateObserver) r14
            r15 = 0
            r17 = r0
            r0 = r1
            androidx.compose.runtime.DerivedState r0 = (androidx.compose.runtime.DerivedState) r0
            r14.done(r0)
            r14 = 1
            int r12 = r12 + r14
            if (r12 < r10) goto L_0x017a
            goto L_0x017f
        L_0x017a:
            r0 = r17
            goto L_0x0167
        L_0x017d:
            r17 = r0
        L_0x017f:
            r6 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r10 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x020e }
            androidx.compose.runtime.snapshots.Snapshot r10 = r10.getCurrent()     // Catch:{ all -> 0x020e }
            java.lang.Object r12 = r19.getResult()     // Catch:{ all -> 0x020e }
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion r13 = androidx.compose.runtime.DerivedSnapshotState.ResultRecord.Companion     // Catch:{ all -> 0x020e }
            java.lang.Object r13 = r13.getUnset()     // Catch:{ all -> 0x020e }
            if (r12 == r13) goto L_0x01d6
            androidx.compose.runtime.SnapshotMutationPolicy r12 = r18.getPolicy()     // Catch:{ all -> 0x020e }
            if (r12 == 0) goto L_0x01b5
            java.lang.Object r13 = r19.getResult()     // Catch:{ all -> 0x020e }
            boolean r12 = r12.equivalent(r4, r13)     // Catch:{ all -> 0x020e }
            r13 = 1
            if (r12 != r13) goto L_0x01b2
            r16 = 1
            goto L_0x01b7
        L_0x01b2:
            r16 = 0
            goto L_0x01b7
        L_0x01b5:
            r16 = 0
        L_0x01b7:
            if (r16 == 0) goto L_0x01d6
            r2.set_dependencies(r7)     // Catch:{ all -> 0x020e }
            r12 = r1
            androidx.compose.runtime.DerivedState r12 = (androidx.compose.runtime.DerivedState) r12     // Catch:{ all -> 0x020e }
            int r12 = r2.readableHash(r12, r10)     // Catch:{ all -> 0x020e }
            r2.setResultHash(r12)     // Catch:{ all -> 0x020e }
            int r12 = r20.getId()     // Catch:{ all -> 0x020e }
            r2.setValidSnapshotId(r12)     // Catch:{ all -> 0x020e }
            int r12 = r20.getWriteCount$runtime_release()     // Catch:{ all -> 0x020e }
            r2.setValidSnapshotWriteCount(r12)     // Catch:{ all -> 0x020e }
            r12 = r2
            goto L_0x0202
        L_0x01d6:
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord<T> r12 = r1.first     // Catch:{ all -> 0x020e }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x020e }
            r13 = r1
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13     // Catch:{ all -> 0x020e }
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.newWritableRecord(r12, r13, r10)     // Catch:{ all -> 0x020e }
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord r12 = (androidx.compose.runtime.DerivedSnapshotState.ResultRecord) r12     // Catch:{ all -> 0x020e }
            r12.set_dependencies(r7)     // Catch:{ all -> 0x020e }
            r13 = r1
            androidx.compose.runtime.DerivedState r13 = (androidx.compose.runtime.DerivedState) r13     // Catch:{ all -> 0x020e }
            int r13 = r12.readableHash(r13, r10)     // Catch:{ all -> 0x020e }
            r12.setResultHash(r13)     // Catch:{ all -> 0x020e }
            int r13 = r20.getId()     // Catch:{ all -> 0x020e }
            r12.setValidSnapshotId(r13)     // Catch:{ all -> 0x020e }
            int r13 = r20.getWriteCount$runtime_release()     // Catch:{ all -> 0x020e }
            r12.setValidSnapshotWriteCount(r13)     // Catch:{ all -> 0x020e }
            r12.setResult(r4)     // Catch:{ all -> 0x020e }
        L_0x0202:
            monitor-exit(r8)
            r0 = r12
            if (r5 != 0) goto L_0x020d
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r6.notifyObjectsInitialized()
        L_0x020d:
            return r0
        L_0x020e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x0211:
            r0 = move-exception
            goto L_0x0216
        L_0x0213:
            r0 = move-exception
            r11 = r22
        L_0x0216:
            r4 = r9
            r6 = 0
            int r10 = r4.getSize()
            if (r10 <= 0) goto L_0x0237
            r12 = 0
            java.lang.Object[] r13 = r4.getContent()
        L_0x0224:
            r14 = r13[r12]
            androidx.compose.runtime.DerivedStateObserver r14 = (androidx.compose.runtime.DerivedStateObserver) r14
            r15 = 0
            r2 = r1
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            r14.done(r2)
            r2 = 1
            int r12 = r12 + r2
            if (r12 >= r10) goto L_0x0237
            r2 = r19
            goto L_0x0224
        L_0x0237:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.currentRecord(androidx.compose.runtime.DerivedSnapshotState$ResultRecord, androidx.compose.runtime.snapshots.Snapshot, boolean, kotlin.jvm.functions.Function0):androidx.compose.runtime.DerivedSnapshotState$ResultRecord");
    }

    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.Companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), true, this.calculation).getResult();
    }

    public DerivedState.Record<T> getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation);
    }

    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord it = (ResultRecord) SnapshotKt.current(this.first);
        if (it.isValid(this, Snapshot.Companion.getCurrent())) {
            return it.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord it = (ResultRecord) SnapshotKt.current(this.first);
        if (it.isValid(this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(it.getResult());
        }
        return "<Not calculated>";
    }
}
