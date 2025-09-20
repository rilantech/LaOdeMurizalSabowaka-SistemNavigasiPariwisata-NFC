package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 s*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001sB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b\u0012.\b\u0002\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010V\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u00002\b\b\u0002\u0010X\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010YJ%\u0010Z\u001a\u00028\u00002\u0006\u0010@\u001a\u00020\u00062\u0006\u0010(\u001a\u00028\u00002\u0006\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006J\u0013\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00028\u0000¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020\u000fH\u0002J\u0006\u0010b\u001a\u00020\u0006J\u0019\u0010c\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010dJ\u0015\u0010e\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\u0019\u0010f\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010gJ9\u0010h\u001a\u00020W2\b\b\u0002\u0010i\u001a\u00020j2\u001c\u0010k\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0l\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010mJ\u0017\u0010n\u001a\u00020\f2\u0006\u0010Q\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u0010`J!\u0010p\u001a\u00020\f2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0016H\u0000¢\u0006\u0002\brRC\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00162\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00168@@@X\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR/\u0010 \u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010,\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b1\u00102R+\u00103\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068F@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00109\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b:\u00105R\u001b\u0010=\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b>\u00105R/\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00068F@BX\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001b\u0010H\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bI\u00105R\u0014\u0010K\u001a\u00020LX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\bS\u0010<\u001a\u0004\bR\u0010\"R\u001f\u0010\u0012\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010U\u001a\u0004\bT\u00105\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, d2 = {"Landroidx/compose/material3/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "totalDistance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "", "anchors", "getAnchors$material3_release", "()Ljava/util/Map;", "setAnchors$material3_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material3_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "getConfirmValueChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "density", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxOffset", "getMaxOffset", "maxOffset$delegate", "Landroidx/compose/runtime/State;", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset", "()Ljava/lang/Float;", "setOffset", "(Ljava/lang/Float;)V", "offset$delegate", "getPositionalThreshold$material3_release", "()Lkotlin/jvm/functions/Function2;", "progress", "getProgress", "progress$delegate", "swipeDraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getSwipeDraggableState$material3_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "swipeMutex", "Landroidx/compose/material3/InternalMutatorMutex;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold-D9Ej5fM$material3_release", "F", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "requireDensity", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snap", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "swipe", "swipePriority", "Landroidx/compose/foundation/MutatePriority;", "action", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material3_release", "updateAnchors", "newAnchors", "updateAnchors$material3_release", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
public final class SwipeableV2State<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState animationTarget$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private Density density;
    private final MutableState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final MutableState offset$delegate;
    private final Function2<Density, Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final DraggableState swipeDraggableState;
    /* access modifiers changed from: private */
    public final InternalMutatorMutex swipeMutex;
    private final State targetValue$delegate;
    private final float velocityThreshold;

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec2, Function1 function1, Function2 function2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, animationSpec2, function1, function2, f);
    }

    private SwipeableV2State(T initialValue, AnimationSpec<Float> animationSpec2, Function1<? super T, Boolean> confirmValueChange2, Function2<? super Density, ? super Float, Float> positionalThreshold2, float velocityThreshold2) {
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange2, "confirmValueChange");
        Intrinsics.checkNotNullParameter(positionalThreshold2, "positionalThreshold");
        this.animationSpec = animationSpec2;
        this.confirmValueChange = confirmValueChange2;
        this.positionalThreshold = positionalThreshold2;
        this.velocityThreshold = velocityThreshold2;
        this.swipeMutex = new InternalMutatorMutex();
        this.swipeDraggableState = new SwipeableV2State$swipeDraggableState$1(this);
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$targetValue$2(this));
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$progress$2(this));
        this.lastVelocity$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$minOffset$2(this));
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$maxOffset$2(this));
        this.animationTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SwipeableV2State(java.lang.Object r8, androidx.compose.animation.core.AnimationSpec r9, kotlin.jvm.functions.Function1 r10, kotlin.jvm.functions.Function2 r11, float r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000e
            androidx.compose.material3.SwipeableV2Defaults r9 = androidx.compose.material3.SwipeableV2Defaults.INSTANCE
            androidx.compose.animation.core.SpringSpec r9 = r9.getAnimationSpec()
            androidx.compose.animation.core.AnimationSpec r9 = (androidx.compose.animation.core.AnimationSpec) r9
            r2 = r9
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x001a
            androidx.compose.material3.SwipeableV2State$1 r9 = androidx.compose.material3.SwipeableV2State.AnonymousClass1.INSTANCE
            r10 = r9
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r3 = r10
            goto L_0x001b
        L_0x001a:
            r3 = r10
        L_0x001b:
            r9 = r13 & 8
            if (r9 == 0) goto L_0x0027
            androidx.compose.material3.SwipeableV2Defaults r9 = androidx.compose.material3.SwipeableV2Defaults.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r9.getPositionalThreshold()
            r4 = r11
            goto L_0x0028
        L_0x0027:
            r4 = r11
        L_0x0028:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x0034
            androidx.compose.material3.SwipeableV2Defaults r9 = androidx.compose.material3.SwipeableV2Defaults.INSTANCE
            float r12 = r9.m2083getVelocityThresholdD9Ej5fM()
            r5 = r12
            goto L_0x0035
        L_0x0034:
            r5 = r12
        L_0x0035:
            r6 = 0
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableV2State.<init>(java.lang.Object, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material3_release() {
        return this.confirmValueChange;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$material3_release() {
        return this.positionalThreshold;
    }

    /* renamed from: getVelocityThreshold-D9Ej5fM$material3_release  reason: not valid java name */
    public final float m2086getVelocityThresholdD9Ej5fM$material3_release() {
        return this.velocityThreshold;
    }

    public final DraggableState getSwipeDraggableState$material3_release() {
        return this.swipeDraggableState;
    }

    private final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setOffset(Float f) {
        this.offset$delegate.setValue(f);
    }

    public final Float getOffset() {
        return (Float) this.offset$delegate.getValue();
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
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
        this.lastVelocity$delegate.setValue(Float.valueOf(f));
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity$delegate.getValue()).floatValue();
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

    public final Map<T, Float> getAnchors$material3_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final void setAnchors$material3_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    public final void setDensity$material3_release(Density density2) {
        this.density = density2;
    }

    public final boolean updateAnchors$material3_release(Map<T, Float> newAnchors) {
        boolean initialValueHasAnchor;
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean previousAnchorsEmpty = getAnchors$material3_release().isEmpty();
        setAnchors$material3_release(newAnchors);
        if (previousAnchorsEmpty) {
            Object initialValue = getCurrentValue();
            initialValueHasAnchor = ((Float) getAnchors$material3_release().get(initialValue)) != null;
            if (initialValueHasAnchor) {
                trySnapTo$material3_release(initialValue);
            }
        } else {
            initialValueHasAnchor = true;
        }
        if (!initialValueHasAnchor || !previousAnchorsEmpty) {
            return true;
        }
        return false;
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$material3_release().containsKey(value);
    }

    public final Object snapTo(T targetValue, Continuation<? super Unit> $completion) {
        Object swipe$default = swipe$default(this, (MutatePriority) null, new SwipeableV2State$snapTo$2(this, targetValue, (Continuation<? super SwipeableV2State$snapTo$2>) null), $completion, 1, (Object) null);
        return swipe$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? swipe$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: androidx.compose.material3.SwipeableV2State} */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        r1.setAnimationTarget((java.lang.Object) null);
        r0 = r1.requireOffset();
        r4 = r1.getAnchors$material3_release().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        if (r4.hasNext() == false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009f, code lost:
        r2 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b9, code lost:
        if (java.lang.Math.abs(((java.lang.Number) ((java.util.Map.Entry) r2).getValue()).floatValue() - r0) >= 0.5f) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bb, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bd, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
        if (r5 == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c2, code lost:
        r2 = (java.util.Map.Entry) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c4, code lost:
        if (r2 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c6, code lost:
        r12 = r2.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (r0 != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ce, code lost:
        r0 = r1.getCurrentValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d2, code lost:
        r1.setCurrentValue(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0137, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateTo(T r21, float r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r20 = this;
            r0 = r23
            boolean r1 = r0 instanceof androidx.compose.material3.SwipeableV2State$animateTo$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.material3.SwipeableV2State$animateTo$1 r1 = (androidx.compose.material3.SwipeableV2State$animateTo$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r20
            goto L_0x0021
        L_0x0019:
            androidx.compose.material3.SwipeableV2State$animateTo$1 r1 = new androidx.compose.material3.SwipeableV2State$animateTo$1
            r2 = r20
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            r7 = r0
            java.lang.Object r8 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r9 = 0
            r10 = 1056964608(0x3f000000, float:0.5)
            r11 = 1
            r12 = 0
            switch(r1) {
                case 0: goto L_0x0046;
                case 1: goto L_0x003a;
                default: goto L_0x0032;
            }
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            java.lang.Object r0 = r7.L$0
            r1 = r0
            androidx.compose.material3.SwipeableV2State r1 = (androidx.compose.material3.SwipeableV2State) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0043 }
            goto L_0x0082
        L_0x0043:
            r0 = move-exception
            goto L_0x00dc
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            r6 = r20
            r17 = r22
            r5 = r21
            java.util.Map r1 = r6.getAnchors$material3_release()
            java.lang.Object r1 = r1.get(r5)
            r19 = r1
            java.lang.Float r19 = (java.lang.Float) r19
            if (r19 == 0) goto L_0x0130
            androidx.compose.material3.SwipeableV2State$animateTo$2 r1 = new androidx.compose.material3.SwipeableV2State$animateTo$2     // Catch:{ all -> 0x00d9 }
            r18 = 0
            r13 = r1
            r14 = r6
            r15 = r5
            r16 = r19
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00d9 }
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x00d9 }
            r7.L$0 = r6     // Catch:{ all -> 0x00d9 }
            r7.label = r11     // Catch:{ all -> 0x00d9 }
            r2 = 0
            r13 = 1
            r14 = 0
            r1 = r6
            r4 = r7
            r15 = r5
            r5 = r13
            r13 = r6
            r6 = r14
            java.lang.Object r1 = swipe$default(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00d6 }
            if (r1 != r0) goto L_0x0081
            return r0
        L_0x0081:
            r1 = r13
        L_0x0082:
            r1.setAnimationTarget(r12)
            float r0 = r1.requireOffset()
            java.util.Map r2 = r1.getAnchors$material3_release()
            java.util.Set r2 = r2.entrySet()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r4 = r2.iterator()
        L_0x0099:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x00c1
            java.lang.Object r2 = r4.next()
            r5 = r2
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            r6 = 0
            java.lang.Object r5 = r5.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r13 = r5 - r0
            float r5 = java.lang.Math.abs(r13)
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x00bd
            r5 = r11
            goto L_0x00be
        L_0x00bd:
            r5 = r9
        L_0x00be:
            if (r5 == 0) goto L_0x0099
            goto L_0x00c2
        L_0x00c1:
            r2 = r12
        L_0x00c2:
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            if (r2 == 0) goto L_0x00cb
            java.lang.Object r12 = r2.getKey()
        L_0x00cb:
            r0 = r12
            if (r0 != 0) goto L_0x00d2
            java.lang.Object r0 = r1.getCurrentValue()
        L_0x00d2:
            r1.setCurrentValue(r0)
            goto L_0x0135
        L_0x00d6:
            r0 = move-exception
            r1 = r13
            goto L_0x00dc
        L_0x00d9:
            r0 = move-exception
            r13 = r6
            r1 = r13
        L_0x00dc:
            r1.setAnimationTarget(r12)
            float r2 = r1.requireOffset()
            java.util.Map r3 = r1.getAnchors$material3_release()
            java.util.Set r3 = r3.entrySet()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x00f3:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x011b
            java.lang.Object r3 = r5.next()
            r6 = r3
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            r13 = 0
            java.lang.Object r6 = r6.getValue()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r14 = r6 - r2
            float r6 = java.lang.Math.abs(r14)
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x0117
            r6 = r11
            goto L_0x0118
        L_0x0117:
            r6 = r9
        L_0x0118:
            if (r6 == 0) goto L_0x00f3
            goto L_0x011c
        L_0x011b:
            r3 = r12
        L_0x011c:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            if (r3 == 0) goto L_0x0125
            java.lang.Object r12 = r3.getKey()
        L_0x0125:
            r2 = r12
            if (r2 != 0) goto L_0x012c
            java.lang.Object r2 = r1.getCurrentValue()
        L_0x012c:
            r1.setCurrentValue(r2)
            throw r0
        L_0x0130:
            r15 = r5
            r13 = r6
            r13.setCurrentValue(r15)
        L_0x0135:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableV2State.animateTo(java.lang.Object, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object settle(float velocity, Continuation<? super Unit> $completion) {
        Object previousValue = getCurrentValue();
        Object targetValue = computeTarget(requireOffset(), previousValue, velocity);
        if (this.confirmValueChange.invoke(targetValue).booleanValue()) {
            Object animateTo = animateTo(targetValue, velocity, $completion);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = animateTo(previousValue, velocity, $completion);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        Float offset = getOffset();
        float f = 0.0f;
        float currentDragPosition = offset != null ? offset.floatValue() : 0.0f;
        float deltaToConsume = RangesKt.coerceIn(currentDragPosition + delta, getMinOffset(), getMaxOffset()) - currentDragPosition;
        if (Math.abs(deltaToConsume) >= 0.0f) {
            Float offset2 = getOffset();
            if (offset2 != null) {
                f = offset2.floatValue();
            }
            setOffset(Float.valueOf(RangesKt.coerceIn(f + deltaToConsume, getMinOffset(), getMaxOffset())));
        }
        return deltaToConsume;
    }

    /* access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Map currentAnchors = getAnchors$material3_release();
        Float currentAnchor = (Float) currentAnchors.get(currentValue);
        Density currentDensity = requireDensity();
        float velocityThresholdPx = currentDensity.m5825toPx0680j_4(this.velocityThreshold);
        if (Intrinsics.areEqual(currentAnchor, offset) == 0 && currentAnchor != null) {
            if (currentAnchor.floatValue() < offset) {
                if (velocity >= velocityThresholdPx) {
                    return SwipeableV2Kt.closestAnchor(currentAnchors, offset, true);
                }
                Object upper = SwipeableV2Kt.closestAnchor(currentAnchors, offset, true);
                if (offset >= Math.abs(currentAnchor.floatValue() + Math.abs(this.positionalThreshold.invoke(currentDensity, Float.valueOf(Math.abs(((Number) MapsKt.getValue(currentAnchors, upper)).floatValue() - currentAnchor.floatValue()))).floatValue()))) {
                    return upper;
                }
            } else if (velocity <= (-velocityThresholdPx)) {
                return SwipeableV2Kt.closestAnchor(currentAnchors, offset, false);
            } else {
                Object lower = SwipeableV2Kt.closestAnchor(currentAnchors, offset, false);
                float absoluteThreshold = Math.abs(currentAnchor.floatValue() - Math.abs(this.positionalThreshold.invoke(currentDensity, Float.valueOf(Math.abs(currentAnchor.floatValue() - ((Number) MapsKt.getValue(currentAnchors, lower)).floatValue()))).floatValue()));
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

    private final Density requireDensity() {
        Density density2 = this.density;
        if (density2 != null) {
            return density2;
        }
        throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
    }

    static /* synthetic */ Object swipe$default(SwipeableV2State swipeableV2State, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return swipeableV2State.swipe(mutatePriority, function1, continuation);
    }

    /* access modifiers changed from: private */
    public final Object swipe(MutatePriority swipePriority, Function1<? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new SwipeableV2State$swipe$2(this, swipePriority, action, (Continuation<? super SwipeableV2State$swipe$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material3_release(T targetValue) {
        return this.swipeMutex.tryMutate(new SwipeableV2State$trySnapTo$1(this, targetValue));
    }

    /* access modifiers changed from: private */
    public final void snap(T targetValue) {
        Float targetOffset = (Float) getAnchors$material3_release().get(targetValue);
        if (targetOffset != null) {
            float floatValue = targetOffset.floatValue();
            Float offset = getOffset();
            dispatchRawDelta(floatValue - (offset != null ? offset.floatValue() : 0.0f));
            setCurrentValue(targetValue);
            setAnimationTarget((Object) null);
            return;
        }
        setCurrentValue(targetValue);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "distance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "Saver-eqLRuRQ", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;F)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SwipeableV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Saver-eqLRuRQ  reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m2087SavereqLRuRQ(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function2<? super Density, ? super Float, Float> positionalThreshold, float velocityThreshold) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            return SaverKt.Saver(SwipeableV2State$Companion$Saver$1.INSTANCE, new SwipeableV2State$Companion$Saver$2(animationSpec, confirmValueChange, positionalThreshold, velocityThreshold));
        }
    }
}
