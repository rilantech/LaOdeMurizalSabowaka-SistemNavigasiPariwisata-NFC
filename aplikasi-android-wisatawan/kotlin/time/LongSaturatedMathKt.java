package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: longSaturatedMath.kt */
public final class LongSaturatedMathKt {
    /* renamed from: saturatingAdd-NuflL3o  reason: not valid java name */
    public static final long m7689saturatingAddNuflL3o(long value, DurationUnit unit, long duration) {
        DurationUnit durationUnit = unit;
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        long durationInUnit = Duration.m7606toLongimpl(duration, durationUnit);
        boolean z = true;
        if (((value - 1) | 1) == Long.MAX_VALUE) {
            return m7688checkInfiniteSumDefinedPjuGub4(value, duration, durationInUnit);
        }
        if ((1 | (durationInUnit - 1)) != Long.MAX_VALUE) {
            z = false;
        }
        if (z) {
            return m7690saturatingAddInHalvesNuflL3o(value, unit, duration);
        }
        long result = value + durationInUnit;
        if (((value ^ result) & (durationInUnit ^ result)) >= 0) {
            return result;
        }
        if (value < 0) {
            return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: checkInfiniteSumDefined-PjuGub4  reason: not valid java name */
    private static final long m7688checkInfiniteSumDefinedPjuGub4(long value, long duration, long durationInUnit) {
        if (!Duration.m7592isInfiniteimpl(duration) || (value ^ durationInUnit) >= 0) {
            return value;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAddInHalves-NuflL3o  reason: not valid java name */
    private static final long m7690saturatingAddInHalvesNuflL3o(long value, DurationUnit unit, long duration) {
        long half = Duration.m7563divUwyO8pc(duration, 2);
        long halfInUnit = Duration.m7606toLongimpl(half, unit);
        if ((1 | (halfInUnit - 1)) == Long.MAX_VALUE) {
            return halfInUnit;
        }
        return m7689saturatingAddNuflL3o(m7689saturatingAddNuflL3o(value, unit, half), unit, Duration.m7595minusLRDsOJo(duration, half));
    }

    private static final long infinityOfSign(long value) {
        return value < 0 ? Duration.Companion.m7662getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.Companion.m7661getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long valueNs, long origin, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (origin - 1)) == Long.MAX_VALUE) {
            return Duration.m7613unaryMinusUwyO8pc(infinityOfSign(origin));
        }
        return saturatingFiniteDiff(valueNs, origin, unit);
    }

    public static final long saturatingOriginsDiff(long origin1, long origin2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        boolean z = true;
        if ((((origin2 - 1) | 1) == Long.MAX_VALUE ? 1 : 0) == 0) {
            if ((1 | (origin1 - 1)) != Long.MAX_VALUE) {
                z = false;
            }
            if (z) {
                return infinityOfSign(origin1);
            }
            return saturatingFiniteDiff(origin1, origin2, unit);
        } else if (origin1 == origin2) {
            return Duration.Companion.m7663getZEROUwyO8pc();
        } else {
            return Duration.m7613unaryMinusUwyO8pc(infinityOfSign(origin2));
        }
    }

    private static final long saturatingFiniteDiff(long value1, long value2, DurationUnit unit) {
        DurationUnit durationUnit = unit;
        long result = value1 - value2;
        if (((result ^ value1) & (~(result ^ value2))) >= 0) {
            return DurationKt.toDuration(result, durationUnit);
        }
        if (durationUnit.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return Duration.m7613unaryMinusUwyO8pc(infinityOfSign(result));
        }
        long unitsInMilli = DurationUnitKt.convertDurationUnit(1, DurationUnit.MILLISECONDS, durationUnit);
        long resultMs = (value1 / unitsInMilli) - (value2 / unitsInMilli);
        long resultUnit = (value1 % unitsInMilli) - (value2 % unitsInMilli);
        Duration.Companion companion = Duration.Companion;
        return Duration.m7596plusLRDsOJo(DurationKt.toDuration(resultMs, DurationUnit.MILLISECONDS), DurationKt.toDuration(resultUnit, durationUnit));
    }

    public static final boolean isSaturated(long $this$isSaturated) {
        return (1 | ($this$isSaturated - 1)) == Long.MAX_VALUE;
    }
}
