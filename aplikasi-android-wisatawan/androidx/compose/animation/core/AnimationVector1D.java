package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\r\u0010\u0016\u001a\u00020\u0000H\u0010¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H\u0010¢\u0006\u0002\b\u001aJ\u001e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationVector;", "initVal", "", "(F)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "value", "getValue", "()F", "setValue$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "set$animation_core_release", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationVectors.kt */
public final class AnimationVector1D extends AnimationVector {
    public static final int $stable = 8;
    private final int size = 1;
    private float value;

    public AnimationVector1D(float initVal) {
        super((DefaultConstructorMarker) null);
        this.value = initVal;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue$animation_core_release(float f) {
        this.value = f;
    }

    public void reset$animation_core_release() {
        this.value = 0.0f;
    }

    public AnimationVector1D newVector$animation_core_release() {
        return new AnimationVector1D(0.0f);
    }

    public float get$animation_core_release(int index) {
        if (index == 0) {
            return this.value;
        }
        return 0.0f;
    }

    public void set$animation_core_release(int index, float value2) {
        if (index == 0) {
            this.value = value2;
        }
    }

    public int getSize$animation_core_release() {
        return this.size;
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.value;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AnimationVector1D)) {
            return false;
        }
        return (((AnimationVector1D) other).value > this.value ? 1 : (((AnimationVector1D) other).value == this.value ? 0 : -1)) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.value);
    }
}
