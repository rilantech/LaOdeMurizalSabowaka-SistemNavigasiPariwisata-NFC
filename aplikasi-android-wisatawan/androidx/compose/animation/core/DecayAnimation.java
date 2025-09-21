package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B9\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bB9\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rB7\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000fJ\u0015\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010'R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0013\u0010\n\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001eR\u0016\u0010\u001f\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0017R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Landroidx/compose/animation/core/DecayAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)V", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "getInitialVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "isInfinite", "", "()Z", "targetValue", "getTargetValue", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Animation.kt */
public final class DecayAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;
    private final VectorizedDecayAnimationSpec<V> animationSpec;
    private final long durationNanos;
    private final V endVelocity;
    private final T initialValue;
    private final V initialValueVector;
    private final V initialVelocityVector;
    private final boolean isInfinite;
    private final T targetValue;
    private final TwoWayConverter<T, V> typeConverter;

    public DecayAnimation(VectorizedDecayAnimationSpec<V> animationSpec2, TwoWayConverter<T, V> typeConverter2, T initialValue2, V initialVelocityVector2) {
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector2, "initialVelocityVector");
        this.animationSpec = animationSpec2;
        this.typeConverter = typeConverter2;
        this.initialValue = initialValue2;
        V v = (AnimationVector) getTypeConverter().getConvertToVector().invoke(initialValue2);
        this.initialValueVector = v;
        this.initialVelocityVector = AnimationVectorsKt.copy(initialVelocityVector2);
        this.targetValue = getTypeConverter().getConvertFromVector().invoke(animationSpec2.getTargetValue(v, initialVelocityVector2));
        this.durationNanos = animationSpec2.getDurationNanos(v, initialVelocityVector2);
        V copy = AnimationVectorsKt.copy(animationSpec2.getVelocityFromNanos(getDurationNanos(), v, initialVelocityVector2));
        this.endVelocity = copy;
        int size$animation_core_release = copy.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v2 = this.endVelocity;
            v2.set$animation_core_release(i, RangesKt.coerceIn(v2.get$animation_core_release(i), -this.animationSpec.getAbsVelocityThreshold(), this.animationSpec.getAbsVelocityThreshold()));
        }
    }

    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public final V getInitialVelocityVector() {
        return this.initialVelocityVector;
    }

    public T getTargetValue() {
        return this.targetValue;
    }

    public long getDurationNanos() {
        return this.durationNanos;
    }

    public boolean isInfinite() {
        return this.isInfinite;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DecayAnimation(DecayAnimationSpec<T> animationSpec2, TwoWayConverter<T, V> typeConverter2, T initialValue2, V initialVelocityVector2) {
        this(animationSpec2.vectorize(typeConverter2), typeConverter2, initialValue2, initialVelocityVector2);
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector2, "initialVelocityVector");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DecayAnimation(DecayAnimationSpec<T> animationSpec2, TwoWayConverter<T, V> typeConverter2, T initialValue2, T initialVelocity) {
        this(animationSpec2.vectorize(typeConverter2), typeConverter2, initialValue2, (AnimationVector) typeConverter2.getConvertToVector().invoke(initialVelocity));
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
    }

    public T getValueFromNanos(long playTimeNanos) {
        if (!isFinishedFromNanos(playTimeNanos)) {
            return getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(playTimeNanos, this.initialValueVector, this.initialVelocityVector));
        }
        return getTargetValue();
    }

    public V getVelocityVectorFromNanos(long playTimeNanos) {
        if (!isFinishedFromNanos(playTimeNanos)) {
            return this.animationSpec.getVelocityFromNanos(playTimeNanos, this.initialValueVector, this.initialVelocityVector);
        }
        return this.endVelocity;
    }
}
