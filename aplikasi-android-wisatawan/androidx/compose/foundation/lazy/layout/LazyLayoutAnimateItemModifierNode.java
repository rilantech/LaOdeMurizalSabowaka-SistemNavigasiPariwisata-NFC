package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001b\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0015J\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020\u001fH\u0016R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R4\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00048F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R%\u0010\u001a\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "placementAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "<set-?>", "", "isAnimationInProgress", "()Z", "setAnimationInProgress", "(Z)V", "isAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "getPlacementAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setPlacementAnimationSpec", "placementDelta", "getPlacementDelta-nOcc-ac", "()J", "setPlacementDelta--gyyYBs", "(J)V", "placementDelta$delegate", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "rawOffset", "getRawOffset-nOcc-ac", "setRawOffset--gyyYBs", "J", "animatePlacementDelta", "", "delta", "animatePlacementDelta--gyyYBs", "cancelAnimation", "onDetach", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
public final class LazyLayoutAnimateItemModifierNode extends Modifier.Node {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final MutableState isAnimationInProgress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private FiniteAnimationSpec<IntOffset> placementAnimationSpec;
    private final MutableState placementDelta$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5953boximpl(IntOffset.Companion.m5972getZeronOccac()), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation = new Animatable(IntOffset.m5953boximpl(IntOffset.Companion.m5972getZeronOccac()), VectorConvertersKt.getVectorConverter(IntOffset.Companion), (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
    private long rawOffset = NotInitialized;

    public final FiniteAnimationSpec<IntOffset> getPlacementAnimationSpec() {
        return this.placementAnimationSpec;
    }

    public final void setPlacementAnimationSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "<set-?>");
        this.placementAnimationSpec = finiteAnimationSpec;
    }

    public LazyLayoutAnimateItemModifierNode(FiniteAnimationSpec<IntOffset> placementAnimationSpec2) {
        Intrinsics.checkNotNullParameter(placementAnimationSpec2, "placementAnimationSpec");
        this.placementAnimationSpec = placementAnimationSpec2;
    }

    /* access modifiers changed from: private */
    public final void setAnimationInProgress(boolean z) {
        this.isAnimationInProgress$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isAnimationInProgress() {
        return ((Boolean) this.isAnimationInProgress$delegate.getValue()).booleanValue();
    }

    /* renamed from: getRawOffset-nOcc-ac  reason: not valid java name */
    public final long m725getRawOffsetnOccac() {
        return this.rawOffset;
    }

    /* renamed from: setRawOffset--gyyYBs  reason: not valid java name */
    public final void m726setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: setPlacementDelta--gyyYBs  reason: not valid java name */
    public final void m722setPlacementDeltagyyYBs(long j) {
        this.placementDelta$delegate.setValue(IntOffset.m5953boximpl(j));
    }

    /* renamed from: getPlacementDelta-nOcc-ac  reason: not valid java name */
    public final long m724getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta$delegate.getValue()).m5971unboximpl();
    }

    public final void cancelAnimation() {
        if (isAnimationInProgress()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimateItemModifierNode$cancelAnimation$1(this, (Continuation<? super LazyLayoutAnimateItemModifierNode$cancelAnimation$1>) null), 3, (Object) null);
        }
    }

    /* renamed from: animatePlacementDelta--gyyYBs  reason: not valid java name */
    public final void m723animatePlacementDeltagyyYBs(long delta) {
        long arg0$iv = m724getPlacementDeltanOccac();
        long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(arg0$iv) - IntOffset.m5962getXimpl(delta), IntOffset.m5963getYimpl(arg0$iv) - IntOffset.m5963getYimpl(delta));
        m722setPlacementDeltagyyYBs(arg0$iv2);
        setAnimationInProgress(true);
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this, arg0$iv2, (Continuation<? super LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1>) null), 3, (Object) null);
    }

    public void onDetach() {
        m722setPlacementDeltagyyYBs(IntOffset.Companion.m5972getZeronOccac());
        setAnimationInProgress(false);
        this.rawOffset = NotInitialized;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutAnimateItemModifierNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNotInitialized-nOcc-ac  reason: not valid java name */
        public final long m727getNotInitializednOccac() {
            return LazyLayoutAnimateItemModifierNode.NotInitialized;
        }
    }
}
