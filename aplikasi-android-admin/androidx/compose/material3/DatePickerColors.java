package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B¢\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0016J0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u0010(\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010.\u001a\u00020/H\u0016J \u00100\u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u0010\"\u001a\u00020#H\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u00103\u001a\u00020#2\u0006\u0010\"\u001a\u00020#H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u001f\u0010\u0014\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u0015\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0011\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u001f\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u001f\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u001f\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u001f\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u001f\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "yearContentColor", "currentYearContentColor", "selectedYearContentColor", "selectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "(JJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU$material3_release", "()J", "J", "getDayInSelectionRangeContainerColor-0d7_KjU$material3_release", "getHeadlineContentColor-0d7_KjU$material3_release", "getSubheadContentColor-0d7_KjU$material3_release", "getTitleContentColor-0d7_KjU$material3_release", "getTodayDateBorderColor-0d7_KjU$material3_release", "getWeekdayContentColor-0d7_KjU$material3_release", "dayContainerColor", "Landroidx/compose/runtime/State;", "selected", "", "enabled", "animate", "dayContainerColor$material3_release", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isToday", "inRange", "dayContentColor$material3_release", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "yearContainerColor", "yearContainerColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long headlineContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    private DatePickerColors(long containerColor2, long titleContentColor2, long headlineContentColor2, long weekdayContentColor2, long subheadContentColor2, long yearContentColor2, long currentYearContentColor2, long selectedYearContentColor2, long selectedYearContainerColor2, long dayContentColor2, long disabledDayContentColor2, long selectedDayContentColor2, long disabledSelectedDayContentColor2, long selectedDayContainerColor2, long disabledSelectedDayContainerColor2, long todayContentColor2, long todayDateBorderColor2, long dayInSelectionRangeContainerColor2, long dayInSelectionRangeContentColor2) {
        this.containerColor = containerColor2;
        this.titleContentColor = titleContentColor2;
        this.headlineContentColor = headlineContentColor2;
        this.weekdayContentColor = weekdayContentColor2;
        this.subheadContentColor = subheadContentColor2;
        this.yearContentColor = yearContentColor2;
        this.currentYearContentColor = currentYearContentColor2;
        this.selectedYearContentColor = selectedYearContentColor2;
        this.selectedYearContainerColor = selectedYearContainerColor2;
        this.dayContentColor = dayContentColor2;
        this.disabledDayContentColor = disabledDayContentColor2;
        this.selectedDayContentColor = selectedDayContentColor2;
        this.disabledSelectedDayContentColor = disabledSelectedDayContentColor2;
        this.selectedDayContainerColor = selectedDayContainerColor2;
        this.disabledSelectedDayContainerColor = disabledSelectedDayContainerColor2;
        this.todayContentColor = todayContentColor2;
        this.todayDateBorderColor = todayDateBorderColor2;
        this.dayInSelectionRangeContainerColor = dayInSelectionRangeContainerColor2;
        this.dayInSelectionRangeContentColor = dayInSelectionRangeContentColor2;
    }

    /* renamed from: getContainerColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3409getContainerColor0d7_KjU$material3_release() {
        return this.containerColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3413getTitleContentColor0d7_KjU$material3_release() {
        return this.titleContentColor;
    }

    /* renamed from: getHeadlineContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3411getHeadlineContentColor0d7_KjU$material3_release() {
        return this.headlineContentColor;
    }

    /* renamed from: getWeekdayContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3415getWeekdayContentColor0d7_KjU$material3_release() {
        return this.weekdayContentColor;
    }

    /* renamed from: getSubheadContentColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3412getSubheadContentColor0d7_KjU$material3_release() {
        return this.subheadContentColor;
    }

    /* renamed from: getTodayDateBorderColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3414getTodayDateBorderColor0d7_KjU$material3_release() {
        return this.todayDateBorderColor;
    }

    /* renamed from: getDayInSelectionRangeContainerColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m3410getDayInSelectionRangeContainerColor0d7_KjU$material3_release() {
        return this.dayInSelectionRangeContainerColor;
    }

    public final State<Color> dayContentColor$material3_release(boolean isToday, boolean selected, boolean inRange, boolean enabled, Composer $composer, int $changed) {
        long target;
        State<Color> state;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1233694918);
        ComposerKt.sourceInformation(composer, "C(dayContentColor)P(2,3,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233694918, $changed, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:576)");
        } else {
            int i = $changed;
        }
        if (selected && enabled) {
            target = this.selectedDayContentColor;
        } else if (selected && !enabled) {
            target = this.disabledSelectedDayContentColor;
        } else if (inRange && enabled) {
            target = this.dayInSelectionRangeContentColor;
        } else if (inRange && !enabled) {
            target = this.disabledDayContentColor;
        } else if (isToday) {
            target = this.todayContentColor;
        } else if (enabled) {
            target = this.dayContentColor;
        } else {
            target = this.disabledDayContentColor;
        }
        if (inRange) {
            composer.startReplaceableGroup(379006271);
            ComposerKt.sourceInformation(composer, "593@26356L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(target), composer, 0);
            $composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(379006329);
            ComposerKt.sourceInformation(composer, "596@26492L134");
            state = SingleValueAnimationKt.m1782animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, $composer, 0, 12);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    public final State<Color> dayContainerColor$material3_release(boolean selected, boolean enabled, boolean animate, Composer $composer, int $changed) {
        long target;
        State<Color> state;
        $composer.startReplaceableGroup(-1240482658);
        ComposerKt.sourceInformation($composer, "C(dayContainerColor)P(2,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1240482658, $changed, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:611)");
        }
        if (selected) {
            target = enabled ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor;
        } else {
            target = Color.Companion.m4998getTransparent0d7_KjU();
        }
        if (animate) {
            $composer.startReplaceableGroup(1577406023);
            ComposerKt.sourceInformation($composer, "622@27316L134");
            state = SingleValueAnimationKt.m1782animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, $composer, 0, 12);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(1577406187);
            ComposerKt.sourceInformation($composer, "627@27480L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4953boximpl(target), $composer, 0);
            $composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    public final State<Color> yearContentColor$material3_release(boolean currentYear, boolean selected, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceableGroup(-1749254827);
        ComposerKt.sourceInformation($composer, "C(yearContentColor)647@28098L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749254827, $changed, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:638)");
        }
        if (selected) {
            target = this.selectedYearContentColor;
        } else if (currentYear) {
            target = this.currentYearContentColor;
        } else {
            target = this.yearContentColor;
        }
        State<Color> r0 = SingleValueAnimationKt.m1782animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, $composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    public final State<Color> yearContainerColor$material3_release(boolean selected, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(488208633);
        ComposerKt.sourceInformation($composer, "C(yearContainerColor)661@28567L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(488208633, $changed, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:659)");
        }
        State<Color> r0 = SingleValueAnimationKt.m1782animateColorAsStateeuL9pac(selected ? this.selectedYearContainerColor : Color.Companion.m4998getTransparent0d7_KjU(), AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, $composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    public boolean equals(Object other) {
        if ((other instanceof DatePickerColors) && Color.m4964equalsimpl0(this.containerColor, ((DatePickerColors) other).containerColor) && Color.m4964equalsimpl0(this.titleContentColor, ((DatePickerColors) other).titleContentColor) && Color.m4964equalsimpl0(this.headlineContentColor, ((DatePickerColors) other).headlineContentColor) && Color.m4964equalsimpl0(this.weekdayContentColor, ((DatePickerColors) other).weekdayContentColor) && Color.m4964equalsimpl0(this.subheadContentColor, ((DatePickerColors) other).subheadContentColor) && Color.m4964equalsimpl0(this.yearContentColor, ((DatePickerColors) other).yearContentColor) && Color.m4964equalsimpl0(this.currentYearContentColor, ((DatePickerColors) other).currentYearContentColor) && Color.m4964equalsimpl0(this.selectedYearContentColor, ((DatePickerColors) other).selectedYearContentColor) && Color.m4964equalsimpl0(this.selectedYearContainerColor, ((DatePickerColors) other).selectedYearContainerColor) && Color.m4964equalsimpl0(this.dayContentColor, ((DatePickerColors) other).dayContentColor) && Color.m4964equalsimpl0(this.disabledDayContentColor, ((DatePickerColors) other).disabledDayContentColor) && Color.m4964equalsimpl0(this.selectedDayContentColor, ((DatePickerColors) other).selectedDayContentColor) && Color.m4964equalsimpl0(this.disabledSelectedDayContentColor, ((DatePickerColors) other).disabledSelectedDayContentColor) && Color.m4964equalsimpl0(this.selectedDayContainerColor, ((DatePickerColors) other).selectedDayContainerColor) && Color.m4964equalsimpl0(this.disabledSelectedDayContainerColor, ((DatePickerColors) other).disabledSelectedDayContainerColor) && Color.m4964equalsimpl0(this.todayContentColor, ((DatePickerColors) other).todayContentColor) && Color.m4964equalsimpl0(this.todayDateBorderColor, ((DatePickerColors) other).todayDateBorderColor) && Color.m4964equalsimpl0(this.dayInSelectionRangeContainerColor, ((DatePickerColors) other).dayInSelectionRangeContainerColor) && Color.m4964equalsimpl0(this.dayInSelectionRangeContentColor, ((DatePickerColors) other).dayInSelectionRangeContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((Color.m4970hashCodeimpl(this.containerColor) * 31) + Color.m4970hashCodeimpl(this.titleContentColor)) * 31) + Color.m4970hashCodeimpl(this.headlineContentColor)) * 31) + Color.m4970hashCodeimpl(this.weekdayContentColor)) * 31) + Color.m4970hashCodeimpl(this.subheadContentColor)) * 31) + Color.m4970hashCodeimpl(this.yearContentColor)) * 31) + Color.m4970hashCodeimpl(this.currentYearContentColor)) * 31) + Color.m4970hashCodeimpl(this.selectedYearContentColor)) * 31) + Color.m4970hashCodeimpl(this.selectedYearContainerColor)) * 31) + Color.m4970hashCodeimpl(this.dayContentColor)) * 31) + Color.m4970hashCodeimpl(this.disabledDayContentColor)) * 31) + Color.m4970hashCodeimpl(this.selectedDayContentColor)) * 31) + Color.m4970hashCodeimpl(this.disabledSelectedDayContentColor)) * 31) + Color.m4970hashCodeimpl(this.selectedDayContainerColor)) * 31) + Color.m4970hashCodeimpl(this.disabledSelectedDayContainerColor)) * 31) + Color.m4970hashCodeimpl(this.todayContentColor)) * 31) + Color.m4970hashCodeimpl(this.todayDateBorderColor)) * 31) + Color.m4970hashCodeimpl(this.dayInSelectionRangeContainerColor)) * 31) + Color.m4970hashCodeimpl(this.dayInSelectionRangeContentColor);
    }
}
