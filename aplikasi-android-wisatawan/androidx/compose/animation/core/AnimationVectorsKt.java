package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u001b\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a#\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000b2\u0006\u0010\u0010\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u0012\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r¨\u0006\u0013"}, d2 = {"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "copy", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "newInstance", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationVectors.kt */
public final class AnimationVectorsKt {
    public static final AnimationVector1D AnimationVector(float v1) {
        return new AnimationVector1D(v1);
    }

    public static final AnimationVector2D AnimationVector(float v1, float v2) {
        return new AnimationVector2D(v1, v2);
    }

    public static final AnimationVector3D AnimationVector(float v1, float v2, float v3) {
        return new AnimationVector3D(v1, v2, v3);
    }

    public static final AnimationVector4D AnimationVector(float v1, float v2, float v3, float v4) {
        return new AnimationVector4D(v1, v2, v3, v4);
    }

    public static final <T extends AnimationVector> T newInstance(T $this$newInstance) {
        Intrinsics.checkNotNullParameter($this$newInstance, "<this>");
        T newVector$animation_core_release = $this$newInstance.newVector$animation_core_release();
        Intrinsics.checkNotNull(newVector$animation_core_release, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return newVector$animation_core_release;
    }

    public static final <T extends AnimationVector> T copy(T $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        AnimationVector newVector = newInstance($this$copy);
        int size$animation_core_release = newVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            newVector.set$animation_core_release(i, $this$copy.get$animation_core_release(i));
        }
        return newVector;
    }

    public static final <T extends AnimationVector> void copyFrom(T $this$copyFrom, T source) {
        Intrinsics.checkNotNullParameter($this$copyFrom, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int size$animation_core_release = $this$copyFrom.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            $this$copyFrom.set$animation_core_release(i, source.get$animation_core_release(i));
        }
    }
}
