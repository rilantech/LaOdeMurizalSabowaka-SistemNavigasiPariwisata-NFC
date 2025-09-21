package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010F\u001a\u00020GH@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0003H\u0000¢\u0006\u0002\bLJ%\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u0013H\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0013H\u0002J3\u0010T\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020G2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020G2\u0006\u00100\u001a\u00020\u0003H\u0000¢\u0006\u0002\b[J\u0011\u0010\\\u001a\u00020GH@ø\u0001\u0000¢\u0006\u0002\u0010IJ%\u0010]\u001a\u00020G2\u0006\u0010K\u001a\u00020\u00132\b\b\u0002\u0010^\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\f\u0010a\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b$\u0010#R+\u0010'\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b(\u0010#\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b-\u0010#\"\u0004\b.\u0010*R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R+\u00102\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R4\u00109\u001a\u0002082\u0006\u0010\b\u001a\u0002088@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0010\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010<R$\u0010>\u001a\u00020?8@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\b@\u0010\fR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030C8@X\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableState center$delegate;
    private final Animatable<Float, AnimationVector1D> currentAngle;
    private final MutableState hourAngle$delegate;
    private final boolean is24hour;
    private final State isAfternoon$delegate;
    private final MutableState isAfternoonToggle$delegate;
    private final MutableState isInnerCircle$delegate;
    private final MutableState minuteAngle$delegate;
    private final MutatorMutex mutex;
    private final MutableState selection$delegate;
    private final State selectorPos$delegate;

    public TimePickerState(int initialHour, int initialMinute, boolean is24Hour) {
        boolean z = true;
        if (initialHour >= 0 && initialHour < 24) {
            if (initialMinute >= 0 && initialMinute < 60) {
                this.is24hour = is24Hour;
                this.selectorPos$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new TimePickerState$selectorPos$2(this, is24Hour));
                this.center$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m7663boximpl(IntOffset.Companion.m7682getZeronOccac()), (SnapshotMutationPolicy) null, 2, (Object) null);
                this.selection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m3663boximpl(Selection.Companion.m3670getHourJiIwxys()), (SnapshotMutationPolicy) null, 2, (Object) null);
                this.isAfternoonToggle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialHour >= 12 && !is24Hour), (SnapshotMutationPolicy) null, 2, (Object) null);
                this.isInnerCircle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialHour < 12 ? false : z), (SnapshotMutationPolicy) null, 2, (Object) null);
                this.hourAngle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf((((float) (initialHour % 12)) * 0.5235988f) - 1.5707964f), (SnapshotMutationPolicy) null, 2, (Object) null);
                this.minuteAngle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf((((float) initialMinute) * 0.10471976f) - 1.5707964f), (SnapshotMutationPolicy) null, 2, (Object) null);
                this.mutex = new MutatorMutex();
                this.isAfternoon$delegate = SnapshotStateKt.derivedStateOf(new TimePickerState$isAfternoon$2(this));
                this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, (Object) null);
                return;
            }
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    public final boolean is24hour() {
        return this.is24hour;
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* renamed from: getSelectorPos-RKDOV3M$material3_release  reason: not valid java name */
    public final long m3902getSelectorPosRKDOV3M$material3_release() {
        return ((DpOffset) this.selectorPos$delegate.getValue()).m7623unboximpl();
    }

    /* renamed from: getCenter-nOcc-ac$material3_release  reason: not valid java name */
    public final long m3900getCenternOccac$material3_release() {
        return ((IntOffset) this.center$delegate.getValue()).m7681unboximpl();
    }

    /* renamed from: setCenter--gyyYBs$material3_release  reason: not valid java name */
    public final void m3903setCentergyyYBs$material3_release(long j) {
        this.center$delegate.setValue(IntOffset.m7663boximpl(j));
    }

    public final List<Integer> getValues$material3_release() {
        return Selection.m3666equalsimpl0(m3901getSelectionJiIwxys$material3_release(), Selection.Companion.m3671getMinuteJiIwxys()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    /* renamed from: getSelection-JiIwxys$material3_release  reason: not valid java name */
    public final int m3901getSelectionJiIwxys$material3_release() {
        return ((Selection) this.selection$delegate.getValue()).m3669unboximpl();
    }

    /* renamed from: setSelection-iHAOin8$material3_release  reason: not valid java name */
    public final void m3904setSelectioniHAOin8$material3_release(int i) {
        this.selection$delegate.setValue(Selection.m3663boximpl(i));
    }

    public final boolean isAfternoonToggle$material3_release() {
        return ((Boolean) this.isAfternoonToggle$delegate.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        this.isAfternoonToggle$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isInnerCircle$material3_release() {
        return ((Boolean) this.isInnerCircle$delegate.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        this.isInnerCircle$delegate.setValue(Boolean.valueOf(z));
    }

    public final float getHourAngle$material3_release() {
        return ((Number) this.hourAngle$delegate.getValue()).floatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        this.hourAngle$delegate.setValue(Float.valueOf(f));
    }

    public final float getMinuteAngle$material3_release() {
        return ((Number) this.minuteAngle$delegate.getValue()).floatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        this.minuteAngle$delegate.setValue(Float.valueOf(f));
    }

    private final boolean isAfternoon() {
        return ((Boolean) this.isAfternoon$delegate.getValue()).booleanValue();
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final void setMinute$material3_release(int minute) {
        setMinuteAngle$material3_release((((float) minute) * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int hour) {
        setInnerCircle$material3_release(hour >= 12);
        setHourAngle$material3_release((((float) (hour % 12)) * 0.5235988f) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float x, float y, float maxDist) {
        if (Selection.m3666equalsimpl0(m3901getSelectionJiIwxys$material3_release(), Selection.Companion.m3670getHourJiIwxys()) && this.is24hour) {
            setInnerCircle$material3_release(TimePickerKt.dist(x, y, IntOffset.m7672getXimpl(m3900getCenternOccac$material3_release()), IntOffset.m7673getYimpl(m3900getCenternOccac$material3_release())) < maxDist);
        }
    }

    public final boolean isSelected$material3_release(int value) {
        if (!Selection.m3666equalsimpl0(m3901getSelectionJiIwxys$material3_release(), Selection.Companion.m3671getMinuteJiIwxys())) {
            if (getHour() == (isAfternoon() ? 12 : 0) + value) {
                return true;
            }
            return false;
        } else if (value == getMinute()) {
            return true;
        } else {
            return false;
        }
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float value, boolean fromTap, Continuation<? super Unit> $completion) {
        Object mutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, value, fromTap, (Continuation<? super TimePickerState$update$2>) null), $completion);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToCurrent$material3_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.TimePickerState$animateToCurrent$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = (androidx.compose.material3.TimePickerState$animateToCurrent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = new androidx.compose.material3.TimePickerState$animateToCurrent$1
            r0.<init>(r12, r13)
        L_0x0019:
            r13 = r0
            java.lang.Object r8 = r13.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            switch(r0) {
                case 0: goto L_0x003e;
                case 1: goto L_0x0032;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00b8
        L_0x0032:
            float r0 = r13.F$0
            java.lang.Object r1 = r13.L$0
            androidx.compose.material3.TimePickerState r1 = (androidx.compose.material3.TimePickerState) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r10 = r0
            r11 = r1
            goto L_0x0095
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r12
            int r0 = r1.m3901getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r2 = androidx.compose.material3.Selection.Companion
            int r2 = r2.m3670getHourJiIwxys()
            boolean r0 = androidx.compose.material3.Selection.m3666equalsimpl0(r0, r2)
            if (r0 == 0) goto L_0x005f
            float r0 = r1.getMinuteAngle$material3_release()
            float r2 = r1.getHourAngle$material3_release()
            kotlin.Pair r0 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r0, r2)
            goto L_0x006b
        L_0x005f:
            float r0 = r1.getHourAngle$material3_release()
            float r2 = r1.getMinuteAngle$material3_release()
            kotlin.Pair r0 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r0, r2)
        L_0x006b:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r3 = r1.currentAngle
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r13.L$0 = r1
            r13.F$0 = r0
            r5 = 1
            r13.label = r5
            java.lang.Object r2 = r3.snapTo(r4, r13)
            if (r2 != r9) goto L_0x0093
            return r9
        L_0x0093:
            r10 = r0
            r11 = r1
        L_0x0095:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r11.currentAngle
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            r2 = 0
            r3 = 6
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r2, r5, r3, r5)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r13.L$0 = r5
            r3 = 2
            r13.label = r3
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = r13
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x00b8
            return r9
        L_0x00b8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.animateToCurrent$material3_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int hourForDisplay(int hour) {
        if (this.is24hour) {
            return hour % 24;
        }
        if (hour % 12 == 0) {
            return 12;
        }
        if (isAfternoon()) {
            return hour - 12;
        }
        return hour;
    }

    /* access modifiers changed from: private */
    public final float offsetHour(float angle) {
        float ret = 1.5707964f + angle;
        return ret < 0.0f ? 6.2831855f + ret : ret;
    }

    /* access modifiers changed from: private */
    public final int toHour(float $this$toHour) {
        return ((int) ((((double) $this$toHour) + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    /* access modifiers changed from: private */
    public final int toMinute(float $this$toMinute) {
        return ((int) ((((double) $this$toMinute) + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object settle(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.TimePickerState$settle$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.compose.material3.TimePickerState$settle$1 r0 = (androidx.compose.material3.TimePickerState$settle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.TimePickerState$settle$1 r0 = new androidx.compose.material3.TimePickerState$settle$1
            r0.<init>(r12, r13)
        L_0x0019:
            r13 = r0
            java.lang.Object r8 = r13.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            switch(r0) {
                case 0: goto L_0x003f;
                case 1: goto L_0x0031;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0092
        L_0x0031:
            java.lang.Object r0 = r13.L$1
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r1 = r13.L$0
            androidx.compose.material3.TimePickerState r1 = (androidx.compose.material3.TimePickerState) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r10 = r0
            r11 = r1
            goto L_0x006d
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r12
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r1.currentAngle
            java.lang.Object r0 = r0.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r2 = r1.getMinuteAngle$material3_release()
            kotlin.Pair r0 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r0, r2)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r2 = r1.currentAngle
            java.lang.Object r3 = r0.getFirst()
            r13.L$0 = r1
            r13.L$1 = r0
            r4 = 1
            r13.label = r4
            java.lang.Object r2 = r2.snapTo(r3, r13)
            if (r2 != r9) goto L_0x006b
            return r9
        L_0x006b:
            r10 = r0
            r11 = r1
        L_0x006d:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r11.currentAngle
            java.lang.Object r1 = r10.getSecond()
            r2 = 0
            r3 = 6
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r2, r5, r3, r5)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r13.L$0 = r5
            r13.L$1 = r5
            r3 = 2
            r13.label = r3
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = r13
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x0092
            return r9
        L_0x0092:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.settle(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onTap$material3_release(float r15, float r16, float r17, boolean r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r14 = this;
            r0 = r19
            boolean r1 = r0 instanceof androidx.compose.material3.TimePickerState$onTap$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            androidx.compose.material3.TimePickerState$onTap$1 r1 = (androidx.compose.material3.TimePickerState$onTap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r14
            goto L_0x001f
        L_0x0018:
            androidx.compose.material3.TimePickerState$onTap$1 r1 = new androidx.compose.material3.TimePickerState$onTap$1
            r2 = r14
            r1.<init>(r14, r0)
            r0 = r1
        L_0x001f:
            java.lang.Object r9 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r3 = 0
            switch(r1) {
                case 0: goto L_0x005a;
                case 1: goto L_0x0047;
                case 2: goto L_0x0038;
                case 3: goto L_0x0033;
                case 4: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b5
        L_0x0038:
            java.lang.Object r1 = r0.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r2 = r0.L$0
            androidx.compose.material3.TimePickerState r2 = (androidx.compose.material3.TimePickerState) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r11 = r1
            r12 = r2
            goto L_0x00e2
        L_0x0047:
            boolean r1 = r0.Z$0
            float r2 = r0.F$2
            float r4 = r0.F$1
            float r5 = r0.F$0
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.TimePickerState r6 = (androidx.compose.material3.TimePickerState) r6
            kotlin.ResultKt.throwOnFailure(r9)
            r13 = r6
            r6 = r2
            r2 = r13
            goto L_0x0096
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r14
            r4 = r16
            r2 = r18
            r5 = r15
            r6 = r17
            long r7 = r1.m3900getCenternOccac$material3_release()
            int r7 = androidx.compose.ui.unit.IntOffset.m7673getYimpl(r7)
            float r7 = (float) r7
            float r7 = r4 - r7
            long r11 = r1.m3900getCenternOccac$material3_release()
            int r8 = androidx.compose.ui.unit.IntOffset.m7672getXimpl(r11)
            float r8 = (float) r8
            float r8 = r5 - r8
            float r7 = androidx.compose.material3.TimePickerKt.atan(r7, r8)
            r0.L$0 = r1
            r0.F$0 = r5
            r0.F$1 = r4
            r0.F$2 = r6
            r0.Z$0 = r2
            r8 = 1
            r0.label = r8
            java.lang.Object r7 = r1.update$material3_release(r7, r8, r0)
            if (r7 != r10) goto L_0x0093
            return r10
        L_0x0093:
            r13 = r2
            r2 = r1
            r1 = r13
        L_0x0096:
            r2.moveSelector$material3_release(r5, r4, r6)
            int r4 = r2.m3901getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r5 = androidx.compose.material3.Selection.Companion
            int r5 = r5.m3670getHourJiIwxys()
            boolean r4 = androidx.compose.material3.Selection.m3666equalsimpl0(r4, r5)
            if (r4 == 0) goto L_0x0109
            if (r1 == 0) goto L_0x00b8
            androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.Companion
            int r1 = r1.m3671getMinuteJiIwxys()
            r2.m3904setSelectioniHAOin8$material3_release(r1)
        L_0x00b5:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00b8:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r2.currentAngle
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r4 = r2.getHourAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r1, r4)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r2.currentAngle
            java.lang.Object r5 = r1.getFirst()
            r0.L$0 = r2
            r0.L$1 = r1
            r6 = 2
            r0.label = r6
            java.lang.Object r4 = r4.snapTo(r5, r0)
            if (r4 != r10) goto L_0x00e0
            return r10
        L_0x00e0:
            r11 = r1
            r12 = r2
        L_0x00e2:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r12.currentAngle
            java.lang.Object r2 = r11.getSecond()
            r4 = 0
            r5 = 6
            r6 = 200(0xc8, float:2.8E-43)
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r4, r3, r5, r3)
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r0.L$0 = r3
            r0.L$1 = r3
            r3 = 3
            r0.label = r3
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            java.lang.Object r1 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r10) goto L_0x00b5
            return r10
        L_0x0109:
            r0.L$0 = r3
            r1 = 4
            r0.label = r1
            java.lang.Object r1 = r2.settle(r0)
            if (r1 != r10) goto L_0x00b5
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.onTap$material3_release(float, float, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TimePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(TimePickerState$Companion$Saver$1.INSTANCE, TimePickerState$Companion$Saver$2.INSTANCE);
        }
    }
}
