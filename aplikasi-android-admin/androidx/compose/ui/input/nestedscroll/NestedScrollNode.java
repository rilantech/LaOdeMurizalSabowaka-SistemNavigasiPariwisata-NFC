package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J)\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J-\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b+\u0010,J%\u0010-\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u001cH\u0002J\u0012\u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u001f\u00104\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b5R\u001a\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentModifierLocal", "getParentModifierLocal", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "resolvedDispatcher", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollNode.kt */
public final class NestedScrollNode extends Modifier.Node implements ModifierLocalModifierNode, NestedScrollConnection, DelegatableNode {
    private NestedScrollConnection connection;
    private final ModifierLocalMap providedValues;
    private NestedScrollDispatcher resolvedDispatcher;

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "<set-?>");
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection connection2, NestedScrollDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(connection2, "connection");
        this.connection = connection2;
        this.resolvedDispatcher = dispatcher == null ? new NestedScrollDispatcher() : dispatcher;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(NestedScrollNodeKt.getModifierLocalNestedScroll(), this));
    }

    private final NestedScrollNode getParentModifierLocal() {
        if (isAttached()) {
            return (NestedScrollNode) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached()) {
            return (NestedScrollConnection) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    /* access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope coroutineScope;
        NestedScrollNode parentModifierLocal = getParentModifierLocal();
        if ((parentModifierLocal != null && (coroutineScope = parentModifierLocal.getNestedCoroutineScope()) != null) || (coroutineScope = this.resolvedDispatcher.getScope$ui_release()) != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m6078onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long parentPreConsumed = parentConnection != null ? parentConnection.m6066onPreScrollOzD1aCk(available, source) : Offset.Companion.m4729getZeroF1C5BW0();
        return Offset.m4718plusMKHz9U(parentPreConsumed, this.connection.m6066onPreScrollOzD1aCk(Offset.m4717minusMKHz9U(available, parentPreConsumed), source));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m6076onPostScrollDzOQY0M(long consumed, long available, int source) {
        long parentConsumed;
        long selfConsumed = this.connection.m6064onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            parentConsumed = parentConnection.m6064onPostScrollDzOQY0M(Offset.m4718plusMKHz9U(consumed, selfConsumed), Offset.m4717minusMKHz9U(available, selfConsumed), source);
        } else {
            parentConsumed = Offset.Companion.m4729getZeroF1C5BW0();
        }
        return Offset.m4718plusMKHz9U(selfConsumed, parentConsumed);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        r5 = r2.connection;
        r6 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r10, r3);
        r12.L$0 = null;
        r12.J$0 = r3;
        r12.label = 2;
        r10 = r5.m6065onPreFlingQWom1Mo(r6, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r10 != r1) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        return androidx.compose.ui.unit.Velocity.m7770boximpl(androidx.compose.ui.unit.Velocity.m7783plusAH228Gc(r3, ((androidx.compose.ui.unit.Velocity) r10).m7788unboximpl()));
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m6077onPreFlingQWom1Mo(long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r9, r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0035;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002d:
            long r10 = r12.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r10
            r10 = r0
            goto L_0x007a
        L_0x0035:
            long r10 = r12.J$0
            java.lang.Object r2 = r12.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r0
            goto L_0x0058
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r9
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r2.getParentConnection()
            if (r3 == 0) goto L_0x005f
            r12.L$0 = r2
            r12.J$0 = r10
            r4 = 1
            r12.label = r4
            java.lang.Object r3 = r3.m6065onPreFlingQWom1Mo(r10, r12)
            if (r3 != r1) goto L_0x0058
            return r1
        L_0x0058:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r3 = r3.m7788unboximpl()
            goto L_0x0065
        L_0x005f:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r3 = r3.m7790getZero9UxMQ8M()
        L_0x0065:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = r2.connection
            long r6 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r10, r3)
            r8 = 0
            r12.L$0 = r8
            r12.J$0 = r3
            r8 = 2
            r12.label = r8
            java.lang.Object r10 = r5.m6065onPreFlingQWom1Mo(r6, r12)
            if (r10 != r1) goto L_0x007a
            return r1
        L_0x007a:
            androidx.compose.ui.unit.Velocity r10 = (androidx.compose.ui.unit.Velocity) r10
            long r10 = r10.m7788unboximpl()
            long r1 = androidx.compose.ui.unit.Velocity.m7783plusAH228Gc(r3, r10)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m7770boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.m6077onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m6075onPostFlingRZ2iAVY(long r13, long r15, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r17) {
        /*
            r12 = this;
            r0 = r17
            boolean r1 = r0 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r12
            goto L_0x001f
        L_0x0018:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r1 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r2 = r12
            r1.<init>(r12, r0)
            r0 = r1
        L_0x001f:
            java.lang.Object r1 = r0.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r0.label
            switch(r4) {
                case 0: goto L_0x0047;
                case 1: goto L_0x003a;
                case 2: goto L_0x0032;
                default: goto L_0x002a;
            }
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            long r2 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r2
            r2 = r1
            goto L_0x008a
        L_0x003a:
            long r4 = r0.J$1
            long r6 = r0.J$0
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r1
            goto L_0x0062
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            r2 = r12
            r6 = r13
            r4 = r15
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r8 = r2.connection
            r0.L$0 = r2
            r0.J$0 = r6
            r0.J$1 = r4
            r9 = 1
            r0.label = r9
            r12 = r8
            r17 = r0
            java.lang.Object r8 = r12.m6063onPostFlingRZ2iAVY(r13, r15, r17)
            if (r8 != r3) goto L_0x0062
            return r3
        L_0x0062:
            androidx.compose.ui.unit.Velocity r8 = (androidx.compose.ui.unit.Velocity) r8
            long r8 = r8.m7788unboximpl()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = r2.getParentConnection()
            if (r2 == 0) goto L_0x0091
            long r6 = androidx.compose.ui.unit.Velocity.m7783plusAH228Gc(r6, r8)
            long r10 = androidx.compose.ui.unit.Velocity.m7782minusAH228Gc(r4, r8)
            r4 = 0
            r0.L$0 = r4
            r0.J$0 = r8
            r4 = 2
            r0.label = r4
            r12 = r2
            r13 = r6
            r15 = r10
            r17 = r0
            java.lang.Object r2 = r12.m6063onPostFlingRZ2iAVY(r13, r15, r17)
            if (r2 != r3) goto L_0x008a
            return r3
        L_0x008a:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r2 = r2.m7788unboximpl()
            goto L_0x0097
        L_0x0091:
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.Companion
            long r2 = r2.m7790getZero9UxMQ8M()
        L_0x0097:
            long r4 = androidx.compose.ui.unit.Velocity.m7783plusAH228Gc(r8, r2)
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.m7770boximpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.m6075onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual((Object) newDispatcher, (Object) this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    public void onAttach() {
        updateDispatcherFields();
    }

    public void onDetach() {
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setModifierLocalNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new NestedScrollNode$updateDispatcherFields$1(this));
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getModifierLocalNode$ui_release() == this) {
            this.resolvedDispatcher.setModifierLocalNode$ui_release((ModifierLocalModifierNode) null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection connection2, NestedScrollDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(connection2, "connection");
        this.connection = connection2;
        updateDispatcher(dispatcher);
    }
}
