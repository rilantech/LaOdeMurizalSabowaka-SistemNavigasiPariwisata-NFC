package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFF)V", "getDampingRatio", "()F", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "getEndVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatAnimationSpec.kt */
public final class FloatSpringSpec implements FloatAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public FloatSpringSpec() {
        this(0.0f, 0.0f, 0.0f, 7, (DefaultConstructorMarker) null);
    }

    public FloatSpringSpec(float dampingRatio2, float stiffness2, float visibilityThreshold2) {
        this.dampingRatio = dampingRatio2;
        this.stiffness = stiffness2;
        this.visibilityThreshold = visibilityThreshold2;
        SpringSimulation springSimulation = new SpringSimulation(1.0f);
        SpringSimulation it = springSimulation;
        it.setDampingRatio(dampingRatio2);
        it.setStiffness(stiffness2);
        this.spring = springSimulation;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatSpringSpec(float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2, (i & 4) != 0 ? 0.01f : f3);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public float getValueFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        long playTimeMillis = playTimeNanos / AnimationKt.MillisToNanos;
        this.spring.setFinalPosition(targetValue);
        return Motion.m108getValueimpl(this.spring.m114updateValuesIJZedt4$animation_core_release(initialValue, initialVelocity, playTimeMillis));
    }

    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        long playTimeMillis = playTimeNanos / AnimationKt.MillisToNanos;
        this.spring.setFinalPosition(targetValue);
        return Motion.m109getVelocityimpl(this.spring.m114updateValuesIJZedt4$animation_core_release(initialValue, initialVelocity, playTimeMillis));
    }

    public float getEndVelocity(float initialValue, float targetValue, float initialVelocity) {
        return 0.0f;
    }

    public long getDurationNanos(float initialValue, float targetValue, float initialVelocity) {
        float stiffness2 = this.spring.getStiffness();
        float dampingRatio2 = this.spring.getDampingRatio();
        float f = this.visibilityThreshold;
        return SpringEstimationKt.estimateAnimationDurationMillis(stiffness2, dampingRatio2, initialVelocity / f, (initialValue - targetValue) / f, 1.0f) * AnimationKt.MillisToNanos;
    }
}
