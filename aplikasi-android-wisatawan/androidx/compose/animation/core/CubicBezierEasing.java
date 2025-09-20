package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "(FFFF)V", "equals", "", "other", "", "evaluateCubic", "m", "hashCode", "", "transform", "fraction", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Easing.kt */
public final class CubicBezierEasing implements Easing {
    public static final int $stable = 0;
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    public CubicBezierEasing(float a2, float b2, float c2, float d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        if (!(!Float.isNaN(a2) && !Float.isNaN(b2) && !Float.isNaN(c2) && !Float.isNaN(d2))) {
            throw new IllegalArgumentException(("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + a2 + ", " + b2 + ", " + c2 + ", " + d2 + '.').toString());
        }
    }

    private final float evaluateCubic(float a2, float b2, float m) {
        float f = (float) 3;
        float f2 = (float) 1;
        return (f * a2 * (f2 - m) * (f2 - m) * m) + (f * b2 * (f2 - m) * m * m) + (m * m * m);
    }

    public float transform(float fraction) {
        if (fraction <= 0.0f || fraction >= 1.0f) {
            return fraction;
        }
        float start = 0.0f;
        float end = 1.0f;
        while (true) {
            float midpoint = (start + end) / ((float) 2);
            float estimate = evaluateCubic(this.a, this.c, midpoint);
            if (Math.abs(fraction - estimate) < 0.001f) {
                return evaluateCubic(this.b, this.d, midpoint);
            }
            if (estimate < fraction) {
                start = midpoint;
            } else {
                end = midpoint;
            }
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof CubicBezierEasing)) {
            return false;
        }
        if (!(this.a == ((CubicBezierEasing) other).a)) {
            return false;
        }
        if (!(this.b == ((CubicBezierEasing) other).b)) {
            return false;
        }
        if (!(this.c == ((CubicBezierEasing) other).c)) {
            return false;
        }
        if (this.d == ((CubicBezierEasing) other).d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }
}
