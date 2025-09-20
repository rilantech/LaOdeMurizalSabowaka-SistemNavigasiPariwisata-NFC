package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a8\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\b¨\u0006\u001d"}, d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "firstRoot", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "secondRoot", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpringEstimation.kt */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float stiffness, float dampingRatio, float initialVelocity, float initialDisplacement, float delta) {
        return estimateAnimationDurationMillis((double) stiffness, (double) dampingRatio, (double) initialVelocity, (double) initialDisplacement, (double) delta);
    }

    public static final long estimateAnimationDurationMillis(double stiffness, double dampingRatio, double initialVelocity, double initialDisplacement, double delta) {
        double dampingCoefficient = 2.0d * dampingRatio * Math.sqrt(stiffness);
        double partialRoot = (dampingCoefficient * dampingCoefficient) - (4.0d * stiffness);
        ComplexDouble other$iv = ComplexDoubleKt.complexSqrt(partialRoot);
        ComplexDouble this_$iv$iv = other$iv;
        this_$iv$iv._real = this_$iv$iv._real + (-dampingCoefficient);
        other$iv._real = other$iv._real * 0.5d;
        other$iv._imaginary = other$iv._imaginary * 0.5d;
        ComplexDouble this_$iv$iv2 = ComplexDoubleKt.complexSqrt(partialRoot);
        double d = (double) -1;
        this_$iv$iv2._real = this_$iv$iv2._real * d;
        this_$iv$iv2._imaginary = this_$iv$iv2._imaginary * d;
        ComplexDouble this_$iv$iv$iv = this_$iv$iv2;
        double d2 = dampingCoefficient;
        this_$iv$iv$iv._real = this_$iv$iv$iv._real + (-dampingCoefficient);
        ComplexDouble this_$iv = this_$iv$iv$iv;
        this_$iv._real = this_$iv._real * 0.5d;
        this_$iv._imaginary = this_$iv._imaginary * 0.5d;
        return estimateDurationInternal(other$iv, this_$iv, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    public static final long estimateAnimationDurationMillis(double springConstant, double dampingCoefficient, double mass, double initialVelocity, double initialDisplacement, double delta) {
        double d = dampingCoefficient;
        double dampingRatio = d / (Math.sqrt(springConstant * mass) * 2.0d);
        double partialRoot = (d * d) - ((4.0d * mass) * springConstant);
        double divisor = 1.0d / (2.0d * mass);
        ComplexDouble this_$iv$iv = ComplexDoubleKt.complexSqrt(partialRoot);
        this_$iv$iv._real = this_$iv$iv._real + (-d);
        ComplexDouble firstRoot = this_$iv$iv;
        firstRoot._real = firstRoot._real * divisor;
        firstRoot._imaginary = firstRoot._imaginary * divisor;
        double $this$minus$iv = -d;
        ComplexDouble this_$iv$iv2 = ComplexDoubleKt.complexSqrt(partialRoot);
        double d2 = (double) -1;
        this_$iv$iv2._real = this_$iv$iv2._real * d2;
        this_$iv$iv2._imaginary = this_$iv$iv2._imaginary * d2;
        ComplexDouble other$iv$iv = this_$iv$iv2;
        ComplexDouble this_$iv$iv$iv = other$iv$iv;
        ComplexDouble complexDouble = other$iv$iv;
        this_$iv$iv$iv._real = this_$iv$iv$iv._real + $this$minus$iv;
        ComplexDouble this_$iv = this_$iv$iv$iv;
        this_$iv._real = this_$iv._real * divisor;
        this_$iv._imaginary = this_$iv._imaginary * divisor;
        return estimateDurationInternal(firstRoot, this_$iv, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    private static final double estimateUnderDamped(ComplexDouble firstRoot, double p0, double v0, double delta) {
        double r = firstRoot.getReal();
        double c1 = p0;
        double c2 = (v0 - (r * c1)) / firstRoot.getImaginary();
        return Math.log(delta / Math.sqrt((c1 * c1) + (c2 * c2))) / r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e1 A[LOOP:1: B:42:0x00d4->B:46:0x00e1, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble r35, double r36, double r38, double r40) {
        /*
            r0 = r40
            double r2 = r35.getReal()
            r4 = r36
            double r6 = r2 * r4
            double r6 = r38 - r6
            double r8 = r0 / r4
            double r8 = java.lang.Math.abs(r8)
            double r8 = java.lang.Math.log(r8)
            double r8 = r8 / r2
            r10 = 0
            double r11 = r0 / r6
            double r11 = java.lang.Math.abs(r11)
            double r11 = java.lang.Math.log(r11)
            r13 = r11
            r15 = 0
        L_0x0024:
            r16 = r10
            r10 = 6
            if (r15 >= r10) goto L_0x003a
            double r17 = r13 / r2
            double r17 = java.lang.Math.abs(r17)
            double r17 = java.lang.Math.log(r17)
            double r13 = r11 - r17
            int r15 = r15 + 1
            r10 = r16
            goto L_0x0024
        L_0x003a:
            double r13 = r13 / r2
            r10 = r8
            r12 = 0
            boolean r15 = java.lang.Double.isInfinite(r10)
            r16 = 0
            r17 = r12
            r12 = 1
            if (r15 != 0) goto L_0x0054
            boolean r15 = java.lang.Double.isNaN(r10)
            if (r15 != 0) goto L_0x0054
            r15 = r12
            goto L_0x0056
        L_0x0054:
            r15 = r16
        L_0x0056:
            r15 = r15 ^ r12
            if (r15 == 0) goto L_0x005b
            r10 = r13
            goto L_0x0075
        L_0x005b:
            r10 = r13
            r15 = 0
            boolean r17 = java.lang.Double.isInfinite(r10)
            if (r17 != 0) goto L_0x006b
            boolean r17 = java.lang.Double.isNaN(r10)
            if (r17 != 0) goto L_0x006b
            r16 = r12
        L_0x006b:
            r16 = r16 ^ 1
            if (r16 == 0) goto L_0x0071
            r10 = r8
            goto L_0x0075
        L_0x0071:
            double r10 = java.lang.Math.max(r8, r13)
        L_0x0075:
            double r15 = r2 * r4
            r17 = r13
            double r12 = r15 + r6
            double r12 = -r12
            double r15 = r2 * r6
            double r12 = r12 / r15
            double r15 = r2 * r12
            double r15 = java.lang.Math.exp(r15)
            double r15 = r15 * r4
            double r19 = r6 * r12
            double r21 = r2 * r12
            double r21 = java.lang.Math.exp(r21)
            double r19 = r19 * r21
            double r14 = r15 + r19
            boolean r16 = java.lang.Double.isNaN(r12)
            if (r16 != 0) goto L_0x00c7
            r19 = 0
            int r16 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r16 > 0) goto L_0x00a2
            r22 = r8
            goto L_0x00c9
        L_0x00a2:
            int r16 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r16 <= 0) goto L_0x00ba
            r22 = r8
            double r8 = -r14
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x00bc
            int r8 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b8
            int r8 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r8 <= 0) goto L_0x00b8
            r8 = 0
            r10 = r8
        L_0x00b8:
            double r8 = -r0
            goto L_0x00ca
        L_0x00ba:
            r22 = r8
        L_0x00bc:
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = r8 / r2
            double r8 = -r8
            double r19 = r4 / r6
            double r8 = r8 - r19
            r10 = r8
            r8 = r0
            goto L_0x00ca
        L_0x00c7:
            r22 = r8
        L_0x00c9:
            double r8 = -r0
        L_0x00ca:
            r19 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r16 = 0
            r0 = r16
        L_0x00d4:
            r24 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r1 = (r19 > r24 ? 1 : (r19 == r24 ? 0 : -1))
            if (r1 <= 0) goto L_0x0123
            r1 = 100
            if (r0 >= r1) goto L_0x0123
            int r0 = r0 + 1
            r24 = r10
            r1 = 0
            r26 = r10
            r16 = 0
            double r28 = r6 * r26
            double r28 = r4 + r28
            double r30 = r2 * r26
            double r30 = java.lang.Math.exp(r30)
            double r28 = r28 * r30
            double r28 = r28 + r8
            r16 = 0
            double r30 = r2 * r26
            r32 = r0
            r33 = r8
            r0 = 1
            double r8 = (double) r0
            double r30 = r30 + r8
            double r30 = r30 * r6
            double r8 = r4 * r2
            double r30 = r30 + r8
            double r8 = r2 * r26
            double r8 = java.lang.Math.exp(r8)
            double r30 = r30 * r8
            double r28 = r28 / r30
            double r8 = r10 - r28
            r10 = r8
            double r8 = r24 - r10
            double r19 = java.lang.Math.abs(r8)
            r0 = r32
            r8 = r33
            goto L_0x00d4
        L_0x0123:
            r16 = r0
            r33 = r8
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ef A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble r38, androidx.compose.animation.core.ComplexDouble r39, double r40, double r42, double r44) {
        /*
            r0 = r44
            double r12 = r38.getReal()
            double r14 = r39.getReal()
            double r2 = r12 * r40
            double r2 = r2 - r42
            double r4 = r12 - r14
            double r10 = r2 / r4
            double r16 = r40 - r10
            double r2 = r0 / r16
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r8 = r2 / r12
            double r2 = r0 / r10
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r6 = r2 / r14
            r2 = r8
            r4 = 0
            boolean r5 = java.lang.Double.isInfinite(r2)
            r18 = 0
            r19 = 1
            if (r5 != 0) goto L_0x0042
            boolean r5 = java.lang.Double.isNaN(r2)
            if (r5 != 0) goto L_0x0042
            r5 = r19
            goto L_0x0044
        L_0x0042:
            r5 = r18
        L_0x0044:
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x004a
            r2 = r6
            goto L_0x0064
        L_0x004a:
            r2 = r6
            r4 = 0
            boolean r5 = java.lang.Double.isInfinite(r2)
            if (r5 != 0) goto L_0x005a
            boolean r5 = java.lang.Double.isNaN(r2)
            if (r5 != 0) goto L_0x005a
            r18 = r19
        L_0x005a:
            r5 = r18 ^ 1
            if (r5 == 0) goto L_0x0060
            r2 = r8
            goto L_0x0064
        L_0x0060:
            double r2 = java.lang.Math.max(r8, r6)
        L_0x0064:
            r18 = r2
            double r2 = r16 * r12
            double r4 = -r10
            double r4 = r4 * r14
            double r2 = r2 / r4
            double r2 = java.lang.Math.log(r2)
            double r4 = r14 - r12
            double r20 = r2 / r4
            boolean r2 = java.lang.Double.isNaN(r20)
            if (r2 != 0) goto L_0x00c7
            r22 = 0
            int r2 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r2 > 0) goto L_0x0086
            r24 = r6
            r26 = r8
            r28 = r10
            goto L_0x00cd
        L_0x0086:
            int r2 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x00ae
            r2 = r16
            r4 = r12
            r24 = r6
            r6 = r20
            r26 = r8
            r8 = r10
            r28 = r10
            r10 = r14
            double r2 = estimateOverDamped$xInflection(r2, r4, r6, r8, r10)
            double r2 = -r2
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x00b4
            int r2 = (r28 > r22 ? 1 : (r28 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x00ac
            int r2 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ac
            r2 = 0
            r18 = r2
        L_0x00ac:
            double r2 = -r0
            goto L_0x00ce
        L_0x00ae:
            r24 = r6
            r26 = r8
            r28 = r10
        L_0x00b4:
            double r10 = r28 * r14
            double r10 = r10 * r14
            double r2 = -r10
            double r4 = r16 * r12
            double r4 = r4 * r12
            double r2 = r2 / r4
            double r2 = java.lang.Math.log(r2)
            double r4 = r12 - r14
            double r2 = r2 / r4
            r18 = r2
            r2 = r0
            goto L_0x00ce
        L_0x00c7:
            r24 = r6
            r26 = r8
            r28 = r10
        L_0x00cd:
            double r2 = -r0
        L_0x00ce:
            double r4 = r16 * r12
            double r6 = r12 * r18
            double r6 = java.lang.Math.exp(r6)
            double r4 = r4 * r6
            double r10 = r28 * r14
            double r6 = r14 * r18
            double r6 = java.lang.Math.exp(r6)
            double r10 = r10 * r6
            double r4 = r4 + r10
            double r4 = java.lang.Math.abs(r4)
            r6 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f0
            return r18
        L_0x00f0:
            r4 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r6 = 0
        L_0x00f6:
            r7 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0146
            r7 = 100
            if (r6 >= r7) goto L_0x0146
            int r6 = r6 + 1
            r7 = r18
            r9 = 0
            r10 = r18
            r22 = 0
            double r30 = r12 * r10
            double r30 = java.lang.Math.exp(r30)
            double r30 = r30 * r16
            double r32 = r14 * r10
            double r32 = java.lang.Math.exp(r32)
            double r32 = r32 * r28
            double r30 = r30 + r32
            double r30 = r30 + r2
            r22 = 0
            double r32 = r16 * r12
            double r34 = r12 * r10
            double r34 = java.lang.Math.exp(r34)
            double r32 = r32 * r34
            double r34 = r28 * r14
            double r36 = r14 * r10
            double r36 = java.lang.Math.exp(r36)
            double r34 = r34 * r36
            double r32 = r32 + r34
            double r30 = r30 / r32
            double r9 = r18 - r30
            r18 = r9
            double r9 = r7 - r18
            double r4 = java.lang.Math.abs(r9)
            goto L_0x00f6
        L_0x0146:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double c1, double r1, double tInflection, double c2, double r2) {
        return (Math.exp(r1 * tInflection) * c1) + (Math.exp(r2 * tInflection) * c2);
    }

    private static final long estimateDurationInternal(ComplexDouble firstRoot, ComplexDouble secondRoot, double dampingRatio, double initialVelocity, double initialPosition, double delta) {
        double d;
        double d2 = initialVelocity;
        boolean z = true;
        if (initialPosition == 0.0d) {
            if (d2 != 0.0d) {
                z = false;
            }
            if (z) {
                return 0;
            }
        }
        double v0 = initialPosition < 0.0d ? -d2 : d2;
        double p0 = Math.abs(initialPosition);
        if (dampingRatio > 1.0d) {
            d = estimateOverDamped(firstRoot, secondRoot, p0, v0, delta);
        } else if (dampingRatio < 1.0d) {
            d = estimateUnderDamped(firstRoot, p0, v0, delta);
        } else {
            d = estimateCriticallyDamped(firstRoot, p0, v0, delta);
        }
        return (long) (d * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double x, Function1<? super Double, Double> fn, Function1<? super Double, Double> fnPrime) {
        return x - (fn.invoke(Double.valueOf(x)).doubleValue() / fnPrime.invoke(Double.valueOf(x)).doubleValue());
    }

    private static final boolean isNotFinite(double $this$isNotFinite) {
        return !(!Double.isInfinite($this$isNotFinite) && !Double.isNaN($this$isNotFinite));
    }
}
