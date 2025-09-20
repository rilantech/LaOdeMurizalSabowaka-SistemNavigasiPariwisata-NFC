package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/animation/core/FloatExponentialDecaySpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "frictionMultiplier", "", "absVelocityThreshold", "(FF)V", "getAbsVelocityThreshold", "()F", "friction", "getDurationNanos", "", "initialValue", "initialVelocity", "getTargetValue", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatDecayAnimationSpec.kt */
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final float absVelocityThreshold;
    private final float friction;

    public FloatExponentialDecaySpec() {
        this(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public FloatExponentialDecaySpec(float frictionMultiplier, float absVelocityThreshold2) {
        this.absVelocityThreshold = Math.max(1.0E-7f, Math.abs(absVelocityThreshold2));
        this.friction = Math.max(1.0E-4f, frictionMultiplier) * -4.2f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatExponentialDecaySpec(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 0.1f : f2);
    }

    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public float getValueFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
        long playTimeMillis = playTimeNanos / AnimationKt.MillisToNanos;
        float f = this.friction;
        return (initialValue - (initialVelocity / f)) + ((initialVelocity / f) * ((float) Math.exp((double) ((f * ((float) playTimeMillis)) / 1000.0f))));
    }

    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
        return ((float) Math.exp((double) ((((float) (playTimeNanos / AnimationKt.MillisToNanos)) / 1000.0f) * this.friction))) * initialVelocity;
    }

    public long getDurationNanos(float initialValue, float initialVelocity) {
        return ((long) ((((float) Math.log((double) (getAbsVelocityThreshold() / Math.abs(initialVelocity)))) * 1000.0f) / this.friction)) * AnimationKt.MillisToNanos;
    }

    public float getTargetValue(float initialValue, float initialVelocity) {
        if (Math.abs(initialVelocity) <= getAbsVelocityThreshold()) {
            return initialValue;
        }
        double log = Math.log((double) Math.abs(getAbsVelocityThreshold() / initialVelocity));
        float f = this.friction;
        return (initialValue - (initialVelocity / f)) + ((initialVelocity / f) * ((float) Math.exp((((double) f) * ((log / ((double) f)) * ((double) 1000))) / ((double) 1000.0f))));
    }
}
