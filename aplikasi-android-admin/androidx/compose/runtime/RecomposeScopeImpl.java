package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u00104\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u000eJ\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0010\u0018\u0001082\u0006\u0010:\u001a\u00020\u000fJ\b\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020=2\b\u0010\u0016\u001a\u0004\u0018\u00010,J\u0016\u0010>\u001a\u00020\u00122\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010@J\u000e\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020,J\u0006\u0010C\u001a\u00020\u0010J\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010E\u001a\u00020\u0010J\u000e\u0010F\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u000fJ\"\u0010G\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u001aR$\u0010#\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128B@BX\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u001aR$\u0010&\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128@@BX\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u001aR\"\u0010)\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030+\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R$\u0010/\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u001aR\u0011\u00102\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b3\u0010\u0014¨\u0006I"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "isConditional", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "recordRead", "instance", "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RecomposeScopeImpl.kt */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    /* access modifiers changed from: private */
    public int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    /* access modifiers changed from: private */
    public IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;
    /* access modifiers changed from: private */
    public IdentityArrayIntMap trackedInstances;

    public RecomposeScopeImpl(RecomposeScopeOwner owner2) {
        this.owner = owner2;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final void setAnchor(Anchor anchor2) {
        this.anchor = anchor2;
    }

    public final boolean getValid() {
        if (this.owner == null) {
            return false;
        }
        Anchor anchor2 = this.anchor;
        return anchor2 != null ? anchor2.getValid() : false;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final void setUsed(boolean value) {
        if (value) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final void setDefaultsInScope(boolean value) {
        if (value) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final void setDefaultsInvalid(boolean value) {
        if (value) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final void setRequiresRecompose(boolean value) {
        if (value) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void compose(Composer composer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invalidate(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.InvalidationResult invalidateForResult(java.lang.Object r2) {
        /*
            r1 = this;
            androidx.compose.runtime.RecomposeScopeOwner r0 = r1.owner
            if (r0 == 0) goto L_0x000a
            androidx.compose.runtime.InvalidationResult r0 = r0.invalidate(r1, r2)
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.IGNORED
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.invalidateForResult(java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void adoptedBy(RecomposeScopeOwner owner2) {
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, (Object) null);
        }
    }

    public void updateScope(Function2<? super Composer, ? super Integer, Unit> block2) {
        Intrinsics.checkNotNullParameter(block2, "block");
        this.block = block2;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean value) {
        if (value) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    private final void setSkipped(boolean value) {
        if (value) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final boolean recordRead(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (getRereading()) {
            return false;
        }
        IdentityArrayIntMap it = this.trackedInstances;
        if (it == null) {
            it = new IdentityArrayIntMap();
            this.trackedInstances = it;
        }
        if (it.add(instance, this.currentToken) == this.currentToken) {
            return true;
        }
        if (instance instanceof DerivedState) {
            IdentityArrayMap tracked = this.trackedDependencies;
            if (tracked == null) {
                tracked = new IdentityArrayMap(0, 1, (DefaultConstructorMarker) null);
                this.trackedDependencies = tracked;
            }
            tracked.set(instance, ((DerivedState) instance).getCurrentRecord().getCurrentValue());
        }
        return false;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r15) {
        /*
            r14 = this;
            r0 = 1
            if (r15 != 0) goto L_0x0004
            return r0
        L_0x0004:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r1 = r14.trackedDependencies
            if (r1 != 0) goto L_0x0009
            return r0
        L_0x0009:
            boolean r2 = r15.isNotEmpty()
            if (r2 == 0) goto L_0x0064
            r2 = r15
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            boolean r4 = r2 instanceof java.util.Collection
            r5 = 0
            if (r4 == 0) goto L_0x0024
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0024
            r2 = r0
            goto L_0x0061
        L_0x0024:
            java.util.Iterator r4 = r2.iterator()
        L_0x0028:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0060
            java.lang.Object r6 = r4.next()
            r7 = r6
            r8 = 0
            boolean r9 = r7 instanceof androidx.compose.runtime.DerivedState
            if (r9 == 0) goto L_0x005b
            r9 = r7
            androidx.compose.runtime.DerivedState r9 = (androidx.compose.runtime.DerivedState) r9
            r10 = 0
            androidx.compose.runtime.SnapshotMutationPolicy r11 = r9.getPolicy()
            if (r11 != 0) goto L_0x0047
            androidx.compose.runtime.SnapshotMutationPolicy r11 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
        L_0x0047:
            androidx.compose.runtime.DerivedState$Record r12 = r9.getCurrentRecord()
            java.lang.Object r12 = r12.getCurrentValue()
            java.lang.Object r13 = r1.get(r9)
            boolean r9 = r11.equivalent(r12, r13)
            if (r9 == 0) goto L_0x005b
            r9 = r0
            goto L_0x005c
        L_0x005b:
            r9 = r5
        L_0x005c:
            if (r9 != 0) goto L_0x0028
            r2 = r5
            goto L_0x0061
        L_0x0060:
            r2 = r0
        L_0x0061:
            if (r2 == 0) goto L_0x0064
            return r5
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet):boolean");
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap trackedInstances2;
        RecomposeScopeOwner owner2 = this.owner;
        if (owner2 != null && (trackedInstances2 = this.trackedInstances) != null) {
            setRereading(true);
            IdentityArrayIntMap this_$iv = trackedInstances2;
            try {
                Object[] keys$iv = this_$iv.getKeys();
                int[] values$iv = this_$iv.getValues();
                int size$iv = this_$iv.getSize();
                for (int i$iv = 0; i$iv < size$iv; i$iv++) {
                    Object value = keys$iv[i$iv];
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
                    int i = values$iv[i$iv];
                    owner2.recordReadOf(value);
                }
            } finally {
                setRereading(false);
            }
        }
    }

    public final Function1<Composition, Unit> end(int token) {
        boolean z;
        IdentityArrayIntMap instances = this.trackedInstances;
        if (instances == null || getSkipped$runtime_release()) {
            return null;
        }
        IdentityArrayIntMap this_$iv = instances;
        Object[] keys$iv = this_$iv.getKeys();
        int[] values$iv = this_$iv.getValues();
        int size$iv = this_$iv.getSize();
        int i$iv = 0;
        while (true) {
            z = false;
            if (i$iv >= size$iv) {
                break;
            }
            Intrinsics.checkNotNull(keys$iv[i$iv], "null cannot be cast to non-null type kotlin.Any");
            if (values$iv[i$iv] != token) {
                z = true;
            }
            if (z) {
                z = true;
                break;
            }
            i$iv++;
        }
        if (z) {
            return new RecomposeScopeImpl$end$1$2(this, token, instances);
        }
        return null;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime_release", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RecomposeScopeImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter slots, List<Anchor> anchors, RecomposeScopeOwner newOwner) {
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(anchors, "anchors");
            Intrinsics.checkNotNullParameter(newOwner, "newOwner");
            if (!anchors.isEmpty()) {
                List $this$fastForEach$iv = anchors;
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object slot = slots.slot($this$fastForEach$iv.get(index$iv), 0);
                    RecomposeScopeImpl recomposeScope = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                    if (recomposeScope != null) {
                        recomposeScope.adoptedBy(newOwner);
                    }
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime_release(SlotTable slots, List<Anchor> anchors) {
            List $this$fastAny$iv;
            SlotTable slotTable = slots;
            List<Anchor> list = anchors;
            Intrinsics.checkNotNullParameter(slotTable, "slots");
            Intrinsics.checkNotNullParameter(list, "anchors");
            if (!list.isEmpty()) {
                List $this$fastForEach$iv$iv = anchors;
                int index$iv$iv = 0;
                int size = $this$fastForEach$iv$iv.size();
                while (true) {
                    if (index$iv$iv >= size) {
                        $this$fastAny$iv = null;
                        break;
                    }
                    Anchor it = (Anchor) $this$fastForEach$iv$iv.get(index$iv$iv);
                    if (((!slotTable.ownsAnchor(it) || !(slotTable.slot$runtime_release(slotTable.anchorIndex(it), 0) instanceof RecomposeScopeImpl)) ? null : 1) != null) {
                        $this$fastAny$iv = 1;
                        break;
                    }
                    index$iv$iv++;
                }
                if ($this$fastAny$iv != null) {
                    return true;
                }
            }
            return false;
        }
    }
}
