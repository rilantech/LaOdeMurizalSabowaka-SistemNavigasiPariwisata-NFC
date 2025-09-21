package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001Bz\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0011J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001cJ \u0010#\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u001cJ \u0010%\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001cJ \u0010'\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u001cR\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u001f\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001f\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u001f\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/material3/TimePickerColors;", "", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "selectorColor", "containerColor", "periodSelectorBorderColor", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClockDialColor-0d7_KjU$material3_release", "()J", "J", "getContainerColor-0d7_KjU$material3_release", "getPeriodSelectorBorderColor-0d7_KjU$material3_release", "getSelectorColor-0d7_KjU$material3_release", "clockDialContentColor", "selected", "", "clockDialContentColor-vNxB06k$material3_release", "(Z)J", "equals", "other", "hashCode", "", "periodSelectorContainerColor", "periodSelectorContainerColor-vNxB06k$material3_release", "periodSelectorContentColor", "periodSelectorContentColor-vNxB06k$material3_release", "timeSelectorContainerColor", "timeSelectorContainerColor-vNxB06k$material3_release", "timeSelectorContentColor", "timeSelectorContentColor-vNxB06k$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerColors {
    public static final int $stable = 0;
    private final long clockDialColor;
    private final long clockDialSelectedContentColor;
    private final long clockDialUnselectedContentColor;
    private final long containerColor;
    private final long periodSelectorBorderColor;
    private final long periodSelectorSelectedContainerColor;
    private final long periodSelectorSelectedContentColor;
    private final long periodSelectorUnselectedContainerColor;
    private final long periodSelectorUnselectedContentColor;
    private final long selectorColor;
    private final long timeSelectorSelectedContainerColor;
    private final long timeSelectorSelectedContentColor;
    private final long timeSelectorUnselectedContainerColor;
    private final long timeSelectorUnselectedContentColor;

    public /* synthetic */ TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    private TimePickerColors(long clockDialColor2, long selectorColor2, long containerColor2, long periodSelectorBorderColor2, long clockDialSelectedContentColor2, long clockDialUnselectedContentColor2, long periodSelectorSelectedContainerColor2, long periodSelectorUnselectedContainerColor2, long periodSelectorSelectedContentColor2, long periodSelectorUnselectedContentColor2, long timeSelectorSelectedContainerColor2, long timeSelectorUnselectedContainerColor2, long timeSelectorSelectedContentColor2, long timeSelectorUnselectedContentColor2) {
        this.clockDialColor = clockDialColor2;
        this.selectorColor = selectorColor2;
        this.containerColor = containerColor2;
        this.periodSelectorBorderColor = periodSelectorBorderColor2;
        this.clockDialSelectedContentColor = clockDialSelectedContentColor2;
        this.clockDialUnselectedContentColor = clockDialUnselectedContentColor2;
        this.periodSelectorSelectedContainerColor = periodSelectorSelectedContainerColor2;
        this.periodSelectorUnselectedContainerColor = periodSelectorUnselectedContainerColor2;
        this.periodSelectorSelectedContentColor = periodSelectorSelectedContentColor2;
        this.periodSelectorUnselectedContentColor = periodSelectorUnselectedContentColor2;
        this.timeSelectorSelectedContainerColor = timeSelectorSelectedContainerColor2;
        this.timeSelectorUnselectedContainerColor = timeSelectorUnselectedContainerColor2;
        this.timeSelectorSelectedContentColor = timeSelectorSelectedContentColor2;
        this.timeSelectorUnselectedContentColor = timeSelectorUnselectedContentColor2;
    }

    /* renamed from: getClockDialColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2152getClockDialColor0d7_KjU$material3_release() {
        return this.clockDialColor;
    }

    /* renamed from: getSelectorColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2155getSelectorColor0d7_KjU$material3_release() {
        return this.selectorColor;
    }

    /* renamed from: getContainerColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2153getContainerColor0d7_KjU$material3_release() {
        return this.containerColor;
    }

    /* renamed from: getPeriodSelectorBorderColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m2154getPeriodSelectorBorderColor0d7_KjU$material3_release() {
        return this.periodSelectorBorderColor;
    }

    /* renamed from: periodSelectorContainerColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2156periodSelectorContainerColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.periodSelectorSelectedContainerColor;
        }
        return this.periodSelectorUnselectedContainerColor;
    }

    /* renamed from: periodSelectorContentColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2157periodSelectorContentColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.periodSelectorSelectedContentColor;
        }
        return this.periodSelectorUnselectedContentColor;
    }

    /* renamed from: timeSelectorContainerColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2158timeSelectorContainerColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.timeSelectorSelectedContainerColor;
        }
        return this.timeSelectorUnselectedContainerColor;
    }

    /* renamed from: timeSelectorContentColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2159timeSelectorContentColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.timeSelectorSelectedContentColor;
        }
        return this.timeSelectorUnselectedContentColor;
    }

    /* renamed from: clockDialContentColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m2151clockDialContentColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.clockDialSelectedContentColor;
        }
        return this.clockDialUnselectedContentColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.material3.TimePickerColors");
        TimePickerColors timePickerColors = (TimePickerColors) other;
        if (Color.m3254equalsimpl0(this.clockDialColor, ((TimePickerColors) other).clockDialColor) && Color.m3254equalsimpl0(this.selectorColor, ((TimePickerColors) other).selectorColor) && Color.m3254equalsimpl0(this.containerColor, ((TimePickerColors) other).containerColor) && Color.m3254equalsimpl0(this.periodSelectorBorderColor, ((TimePickerColors) other).periodSelectorBorderColor) && Color.m3254equalsimpl0(this.periodSelectorSelectedContainerColor, ((TimePickerColors) other).periodSelectorSelectedContainerColor) && Color.m3254equalsimpl0(this.periodSelectorUnselectedContainerColor, ((TimePickerColors) other).periodSelectorUnselectedContainerColor) && Color.m3254equalsimpl0(this.periodSelectorSelectedContentColor, ((TimePickerColors) other).periodSelectorSelectedContentColor) && Color.m3254equalsimpl0(this.periodSelectorUnselectedContentColor, ((TimePickerColors) other).periodSelectorUnselectedContentColor) && Color.m3254equalsimpl0(this.timeSelectorSelectedContainerColor, ((TimePickerColors) other).timeSelectorSelectedContainerColor) && Color.m3254equalsimpl0(this.timeSelectorUnselectedContainerColor, ((TimePickerColors) other).timeSelectorUnselectedContainerColor) && Color.m3254equalsimpl0(this.timeSelectorSelectedContentColor, ((TimePickerColors) other).timeSelectorSelectedContentColor) && Color.m3254equalsimpl0(this.timeSelectorUnselectedContentColor, ((TimePickerColors) other).timeSelectorUnselectedContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m3260hashCodeimpl(this.clockDialColor) * 31) + Color.m3260hashCodeimpl(this.selectorColor)) * 31) + Color.m3260hashCodeimpl(this.containerColor)) * 31) + Color.m3260hashCodeimpl(this.periodSelectorBorderColor)) * 31) + Color.m3260hashCodeimpl(this.periodSelectorSelectedContainerColor)) * 31) + Color.m3260hashCodeimpl(this.periodSelectorUnselectedContainerColor)) * 31) + Color.m3260hashCodeimpl(this.periodSelectorSelectedContentColor)) * 31) + Color.m3260hashCodeimpl(this.periodSelectorUnselectedContentColor)) * 31) + Color.m3260hashCodeimpl(this.timeSelectorSelectedContainerColor)) * 31) + Color.m3260hashCodeimpl(this.timeSelectorUnselectedContainerColor)) * 31) + Color.m3260hashCodeimpl(this.timeSelectorSelectedContentColor)) * 31) + Color.m3260hashCodeimpl(this.timeSelectorUnselectedContentColor);
    }
}
