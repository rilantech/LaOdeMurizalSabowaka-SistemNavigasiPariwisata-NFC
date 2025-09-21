package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 u*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002tuBs\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r\u0012#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\u0010\u0011Jm\u0010S\u001a\u00020T2\u0006\u0010N\u001a\u00028\u00002\b\b\u0002\u0010U\u001a\u00020V2H\u0010W\u001aD\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Y\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\bZH@ø\u0001\u0000¢\u0006\u0002\u0010[Je\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020V2H\u0010W\u001aD\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Y\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\bZH@ø\u0001\u0000¢\u0006\u0002\u0010\\J%\u0010]\u001a\u00028\u00002\u0006\u0010D\u001a\u00020\u00062\u0006\u0010+\u001a\u00028\u00002\u0006\u0010^\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010_J\u001d\u0010`\u001a\u00028\u00002\u0006\u0010D\u001a\u00020\u00062\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010aJ\u000e\u0010b\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0006Jm\u0010d\u001a\u00020T2\b\u0010N\u001a\u0004\u0018\u00018\u00002\u0006\u0010U\u001a\u00020V2H\u0010W\u001aD\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Y\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\bZH@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0013\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00028\u0000¢\u0006\u0002\u0010gJ\u0015\u0010h\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0006H\u0000¢\u0006\u0002\biJ\u0006\u0010j\u001a\u00020\u0006J\u0019\u0010k\u001a\u00020T2\u0006\u0010^\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u0017\u0010m\u001a\u00020\u00102\u0006\u0010N\u001a\u00028\u0000H\u0000¢\u0006\u0004\bn\u0010gJ3\u0010o\u001a\u00020T2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00152\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010rH\u0000¢\u0006\u0002\bsR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000RC\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00152\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00158@@@X\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR/\u0010\u001f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00028\u00008@X\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b&\u0010!R/\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R+\u0010+\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b5\u00106R+\u00107\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068F@BX\u0002¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010>\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b@\u0010(\u001a\u0004\b?\u00109R\u001b\u0010A\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\bC\u0010(\u001a\u0004\bB\u00109R1\u0010D\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068F@BX\u0002¢\u0006\u0018\n\u0004\bI\u0010\u001c\u0012\u0004\bE\u0010F\u001a\u0004\bG\u00109\"\u0004\bH\u0010;R/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\bM\u0010(\u001a\u0004\bL\u00109R\u001b\u0010N\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\bP\u0010(\u001a\u0004\bO\u0010!R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010R\u0002\u0004\n\u0002\b\u0019¨\u0006v"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState;", "T", "", "initialValue", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "Landroidx/compose/material/AnchoredDragScope;", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "closestValue", "getClosestValue$material_release", "closestValue$delegate", "Landroidx/compose/runtime/State;", "getConfirmValueChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "dragMutex", "Landroidx/compose/material/InternalMutatorMutex;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "maxOffset", "getMaxOffset", "maxOffset$delegate", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset$annotations", "()V", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$material_release", "progress", "getProgress", "progress$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$material_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "doAnchoredDrag", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "newOffsetForDelta", "newOffsetForDelta$material_release", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material_release", "updateAnchors", "newAnchors", "onAnchorsChanged", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "updateAnchors$material_release", "AnchorChangedCallback", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableState<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState animationTarget$delegate;
    private final State closestValue$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    /* access modifiers changed from: private */
    public final InternalMutatorMutex dragMutex;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final MutableState offset$delegate;
    private final Function1<Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final Function0<Float> velocityThreshold;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0003\bç\u0001\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0002\u0010\nø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "T", "", "onAnchorsChanged", "", "previousTargetValue", "previousAnchors", "", "", "newAnchors", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnchoredDraggable.kt */
    public interface AnchorChangedCallback<T> {
        void onAnchorsChanged(T t, Map<T, Float> map, Map<T, Float> map2);
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    public AnchoredDraggableState(T initialValue, Function1<? super Float, Float> positionalThreshold2, Function0<Float> velocityThreshold2, AnimationSpec<Float> animationSpec2, Function1<? super T, Boolean> confirmValueChange2) {
        Intrinsics.checkNotNullParameter(positionalThreshold2, "positionalThreshold");
        Intrinsics.checkNotNullParameter(velocityThreshold2, "velocityThreshold");
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange2, "confirmValueChange");
        this.positionalThreshold = positionalThreshold2;
        this.velocityThreshold = velocityThreshold2;
        this.animationSpec = animationSpec2;
        this.confirmValueChange = confirmValueChange2;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$targetValue$2(this));
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$closestValue$2(this));
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new AnchoredDraggableState$progress$2(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$minOffset$2(this));
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$maxOffset$2(this));
        this.animationTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AnchoredDraggableState(java.lang.Object r7, kotlin.jvm.functions.Function1 r8, kotlin.jvm.functions.Function0 r9, androidx.compose.animation.core.AnimationSpec r10, kotlin.jvm.functions.Function1 r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 8
            if (r13 == 0) goto L_0x000e
            androidx.compose.material.AnchoredDraggableDefaults r10 = androidx.compose.material.AnchoredDraggableDefaults.INSTANCE
            androidx.compose.animation.core.SpringSpec r10 = r10.getAnimationSpec()
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
            r4 = r10
            goto L_0x000f
        L_0x000e:
            r4 = r10
        L_0x000f:
            r10 = r12 & 16
            if (r10 == 0) goto L_0x001a
            androidx.compose.material.AnchoredDraggableState$1 r10 = androidx.compose.material.AnchoredDraggableState.AnonymousClass1.INSTANCE
            r11 = r10
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r5 = r11
            goto L_0x001b
        L_0x001a:
            r5 = r11
        L_0x001b:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.<init>(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Function1<Float, Float> getPositionalThreshold$material_release() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$material_release() {
        return this.velocityThreshold;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    /* access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final T getClosestValue$material_release() {
        return this.closestValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setOffset(float f) {
        this.offset$delegate.setValue(Float.valueOf(f));
    }

    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    public final float requireOffset() {
        if (!Float.isNaN(getOffset())) {
            return getOffset();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset$delegate.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final T getAnimationTarget() {
        return this.animationTarget$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget$delegate.setValue(t);
    }

    public final Map<T, Float> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final void setAnchors$material_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public static /* synthetic */ void updateAnchors$material_release$default(AnchoredDraggableState anchoredDraggableState, Map map, AnchorChangedCallback anchorChangedCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            anchorChangedCallback = null;
        }
        anchoredDraggableState.updateAnchors$material_release(map, anchorChangedCallback);
    }

    public final void updateAnchors$material_release(Map<T, Float> newAnchors, AnchorChangedCallback<T> onAnchorsChanged) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        if (!Intrinsics.areEqual((Object) getAnchors$material_release(), (Object) newAnchors)) {
            Map previousAnchors = getAnchors$material_release();
            Object previousTarget = getTargetValue();
            boolean previousAnchorsEmpty = getAnchors$material_release().isEmpty();
            setAnchors$material_release(newAnchors);
            boolean currentValueHasAnchor = getAnchors$material_release().get(getCurrentValue()) != null;
            if (previousAnchorsEmpty && currentValueHasAnchor) {
                trySnapTo$material_release(getCurrentValue());
            } else if (onAnchorsChanged != null) {
                onAnchorsChanged.onAnchorsChanged(previousTarget, previousAnchors, newAnchors);
            }
        }
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$material_release().containsKey(value);
    }

    public final Object settle(float velocity, Continuation<? super Unit> $completion) {
        Object previousValue = getCurrentValue();
        Object targetValue = computeTarget(requireOffset(), previousValue, velocity);
        if (this.confirmValueChange.invoke(targetValue).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, targetValue, velocity, $completion);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, previousValue, velocity, $completion);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Map currentAnchors = getAnchors$material_release();
        Float currentAnchor = (Float) currentAnchors.get(currentValue);
        float velocityThresholdPx = this.velocityThreshold.invoke().floatValue();
        if (!Intrinsics.areEqual(currentAnchor, offset) && currentAnchor != null) {
            if (currentAnchor.floatValue() < offset) {
                if (velocity >= velocityThresholdPx) {
                    return AnchoredDraggableKt.closestAnchor(currentAnchors, offset, true);
                }
                Object upper = AnchoredDraggableKt.closestAnchor(currentAnchors, offset, true);
                if (offset >= Math.abs(currentAnchor.floatValue() + Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(((Number) MapsKt.getValue(currentAnchors, upper)).floatValue() - currentAnchor.floatValue()))).floatValue()))) {
                    return upper;
                }
            } else if (velocity <= (-velocityThresholdPx)) {
                return AnchoredDraggableKt.closestAnchor(currentAnchors, offset, false);
            } else {
                Object lower = AnchoredDraggableKt.closestAnchor(currentAnchors, offset, false);
                float absoluteThreshold = Math.abs(currentAnchor.floatValue() - Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(currentAnchor.floatValue() - ((Number) MapsKt.getValue(currentAnchors, lower)).floatValue()))).floatValue()));
                if (offset < 0.0f) {
                    if (Math.abs(offset) >= absoluteThreshold) {
                        return lower;
                    }
                } else if (offset <= absoluteThreshold) {
                    return lower;
                }
            }
        }
        return currentValue;
    }

    /* access modifiers changed from: private */
    public final T computeTargetWithoutThresholds(float offset, T currentValue) {
        Map currentAnchors = getAnchors$material_release();
        Float currentAnchor = (Float) currentAnchors.get(currentValue);
        if (Intrinsics.areEqual(currentAnchor, offset) || currentAnchor == null) {
            return currentValue;
        }
        if (currentAnchor.floatValue() < offset) {
            return AnchoredDraggableKt.closestAnchor(currentAnchors, offset, true);
        }
        return AnchoredDraggableKt.closestAnchor(currentAnchors, offset, false);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object doAnchoredDrag = doAnchoredDrag((Object) null, dragPriority, block, $completion);
        return doAnchoredDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doAnchoredDrag : Unit.INSTANCE;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(T targetValue, MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object doAnchoredDrag = doAnchoredDrag(targetValue, dragPriority, block, $completion);
        return doAnchoredDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doAnchoredDrag : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object doAnchoredDrag(T targetValue, MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnchoredDraggableState$doAnchoredDrag$2(targetValue, this, dragPriority, block, (Continuation<? super AnchoredDraggableState$doAnchoredDrag$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final float newOffsetForDelta$material_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getMinOffset(), getMaxOffset());
    }

    public final float dispatchRawDelta(float delta) {
        float newOffset = newOffsetForDelta$material_release(delta);
        float oldOffset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(newOffset);
        return newOffset - oldOffset;
    }

    public final boolean trySnapTo$material_release(T targetValue) {
        return this.dragMutex.tryMutate(new AnchoredDraggableState$trySnapTo$1(this, targetValue));
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jw\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/AnchoredDraggableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnchoredDraggable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            Intrinsics.checkNotNullParameter(velocityThreshold, "velocityThreshold");
            return SaverKt.Saver(AnchoredDraggableState$Companion$Saver$1.INSTANCE, new AnchoredDraggableState$Companion$Saver$2(positionalThreshold, velocityThreshold, animationSpec, confirmValueChange));
        }
    }
}
