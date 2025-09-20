package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJn\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerTitle", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    public final void DateRangePickerTitle(DateRangePickerState state, Modifier modifier, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        DateRangePickerState dateRangePickerState = state;
        Intrinsics.checkNotNullParameter(dateRangePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(499073135);
        ComposerKt.sourceInformation($composer2, "C(DateRangePickerTitle)P(1):DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) dateRangePickerState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(499073135, $dirty2, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:302)");
            }
            int r0 = state.m3431getDisplayModejFl4v0();
            if (DisplayMode.m3444equalsimpl0(r0, DisplayMode.Companion.m3449getPickerjFl4v0())) {
                $composer2.startReplaceableGroup(585814427);
                ComposerKt.sourceInformation($composer2, "308@13262L48,307@13240L121");
                TextKt.m3858Text4IGK_g(Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3737getDateRangePickerTitleadMyvUU(), $composer2, 6), modifier4, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceableGroup();
            } else if (DisplayMode.m3444equalsimpl0(r0, DisplayMode.Companion.m3448getInputjFl4v0())) {
                $composer2.startReplaceableGroup(585814583);
                ComposerKt.sourceInformation($composer2, "313@13418L47,312@13396L120");
                TextKt.m3858Text4IGK_g(Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3731getDateRangeInputTitleadMyvUU(), $composer2, 6), modifier4, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(585814713);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i3 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i4 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new DateRangePickerDefaults$DateRangePickerTitle$1(this, state, modifier3, $changed, i));
    }

    public final void DateRangePickerHeadline(DateRangePickerState state, DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        DateRangePickerState dateRangePickerState = state;
        DatePickerFormatter datePickerFormatter = dateFormatter;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(dateRangePickerState, "state");
        Intrinsics.checkNotNullParameter(datePickerFormatter, "dateFormatter");
        Composer $composer2 = $composer.startRestartGroup(-332090137);
        ComposerKt.sourceInformation($composer2, "C(DateRangePickerHeadline)P(2)333@14138L47,334@14212L45,335@14266L400:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) dateRangePickerState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) datePickerFormatter) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if ((i2 & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-332090137, $dirty2, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:328)");
            }
            String startDateText = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3736getDateRangePickerStartHeadlineadMyvUU(), $composer2, 6);
            String endDateText = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3733getDateRangePickerEndHeadlineadMyvUU(), $composer2, 6);
            String str = endDateText;
            String str2 = startDateText;
            int i4 = $dirty2;
            DateRangePickerHeadline(state, dateFormatter, modifier3, startDateText, endDateText, ComposableLambdaKt.composableLambda($composer2, -1382084760, true, new DateRangePickerDefaults$DateRangePickerHeadline$1(startDateText)), ComposableLambdaKt.composableLambda($composer2, -199852025, true, new DateRangePickerDefaults$DateRangePickerHeadline$2(endDateText)), ComposableSingletons$DateRangePickerKt.INSTANCE.m3391getLambda1$material3_release(), $composer2, 14352384 | ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | (($dirty2 << 15) & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            int i5 = $dirty2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerDefaults$DateRangePickerHeadline$3(this, state, dateFormatter, modifier3, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x04a7  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x04de  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0383  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DateRangePickerHeadline(androidx.compose.material3.DateRangePickerState r63, androidx.compose.material3.DatePickerFormatter r64, androidx.compose.ui.Modifier r65, java.lang.String r66, java.lang.String r67, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.runtime.Composer r71, int r72) {
        /*
            r62 = this;
            r11 = r64
            r12 = r65
            r13 = r66
            r14 = r67
            r15 = r68
            r10 = r69
            r9 = r70
            r8 = r72
            r0 = -861159957(0xffffffffccabbdeb, float:-9.00422E7)
            r1 = r71
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DateRangePickerHeadline)P(7!1,4,6,3,5,2)*379@16359L15,418@18064L168,417@18002L796:DateRangePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r72
            r2 = r8 & 14
            if (r2 != 0) goto L_0x0031
            r6 = r63
            boolean r2 = r7.changed((java.lang.Object) r6)
            if (r2 == 0) goto L_0x002e
            r2 = 4
            goto L_0x002f
        L_0x002e:
            r2 = 2
        L_0x002f:
            r1 = r1 | r2
            goto L_0x0033
        L_0x0031:
            r6 = r63
        L_0x0033:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0043
            boolean r2 = r7.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0040
            r2 = 32
            goto L_0x0042
        L_0x0040:
            r2 = 16
        L_0x0042:
            r1 = r1 | r2
        L_0x0043:
            r2 = r8 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0053
            boolean r2 = r7.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0050
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0052
        L_0x0050:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0052:
            r1 = r1 | r2
        L_0x0053:
            r2 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0063
            boolean r2 = r7.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0060
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0062
        L_0x0060:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0062:
            r1 = r1 | r2
        L_0x0063:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r8
            if (r2 != 0) goto L_0x0075
            boolean r2 = r7.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0072
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0074
        L_0x0072:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0074:
            r1 = r1 | r2
        L_0x0075:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r8
            if (r2 != 0) goto L_0x0086
            boolean r2 = r7.changedInstance(r15)
            if (r2 == 0) goto L_0x0083
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0085
        L_0x0083:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0085:
            r1 = r1 | r2
        L_0x0086:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r8
            if (r2 != 0) goto L_0x0097
            boolean r2 = r7.changedInstance(r10)
            if (r2 == 0) goto L_0x0094
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0096
        L_0x0094:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x0096:
            r1 = r1 | r2
        L_0x0097:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r8
            if (r2 != 0) goto L_0x00a8
            boolean r2 = r7.changedInstance(r9)
            if (r2 == 0) goto L_0x00a5
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00a7
        L_0x00a5:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00a7:
            r1 = r1 | r2
        L_0x00a8:
            r5 = r1
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r5
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r2) goto L_0x00c0
            boolean r1 = r7.getSkipping()
            if (r1 != 0) goto L_0x00b9
            goto L_0x00c0
        L_0x00b9:
            r7.skipToGroupEnd()
            r20 = r5
            goto L_0x04e1
        L_0x00c0:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00cc
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:368)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r1, r2)
        L_0x00cc:
            androidx.compose.material3.StateData r16 = r63.getStateData$material3_release()
            r17 = 0
            r0 = 0
            java.util.Locale r4 = androidx.compose.material3.CalendarModel_androidKt.defaultLocale(r7, r0)
            androidx.compose.runtime.MutableState r0 = r16.getSelectedStartDate()
            java.lang.Object r0 = r0.getValue()
            r1 = r0
            androidx.compose.material3.CalendarDate r1 = (androidx.compose.material3.CalendarDate) r1
            androidx.compose.material3.CalendarModel r2 = r16.getCalendarModel()
            r18 = 8
            r19 = 0
            r20 = 0
            r0 = r64
            r3 = r4
            r71 = r4
            r4 = r20
            r20 = r5
            r5 = r18
            r6 = r19
            java.lang.String r18 = androidx.compose.material3.DatePickerFormatter.formatDate$material3_release$default(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.MutableState r0 = r16.getSelectedEndDate()
            java.lang.Object r0 = r0.getValue()
            r1 = r0
            androidx.compose.material3.CalendarDate r1 = (androidx.compose.material3.CalendarDate) r1
            androidx.compose.material3.CalendarModel r2 = r16.getCalendarModel()
            r5 = 8
            r6 = 0
            r4 = 0
            r0 = r64
            r3 = r71
            java.lang.String r0 = androidx.compose.material3.DatePickerFormatter.formatDate$material3_release$default(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.MutableState r1 = r16.getSelectedStartDate()
            java.lang.Object r1 = r1.getValue()
            androidx.compose.material3.CalendarDate r1 = (androidx.compose.material3.CalendarDate) r1
            androidx.compose.material3.CalendarModel r2 = r16.getCalendarModel()
            r3 = 1
            r4 = r71
            java.lang.String r1 = r11.formatDate$material3_release(r1, r2, r4, r3)
            r2 = -1212634278(0xffffffffb7b8ab5a, float:-2.2014301E-5)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r5 = 6
            if (r1 != 0) goto L_0x01a4
            androidx.compose.runtime.MutableState r1 = r16.getDisplayMode()
            java.lang.Object r1 = r1.getValue()
            androidx.compose.material3.DisplayMode r1 = (androidx.compose.material3.DisplayMode) r1
            int r1 = r1.m3447unboximpl()
            androidx.compose.material3.DisplayMode$Companion r6 = androidx.compose.material3.DisplayMode.Companion
            int r6 = r6.m3449getPickerjFl4v0()
            boolean r6 = androidx.compose.material3.DisplayMode.m3444equalsimpl0(r1, r6)
            if (r6 == 0) goto L_0x0175
            r1 = 1922096411(0x7290dd1b, float:5.738642E30)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "398@17129L51"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            androidx.compose.material3.Strings$Companion r1 = androidx.compose.material3.Strings.Companion
            int r1 = r1.m3718getDatePickerNoSelectionDescriptionadMyvUU()
            java.lang.String r1 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r1, r7, r5)
            r7.endReplaceableGroup()
            goto L_0x01a4
        L_0x0175:
            androidx.compose.material3.DisplayMode$Companion r6 = androidx.compose.material3.DisplayMode.Companion
            int r6 = r6.m3448getInputjFl4v0()
            boolean r1 = androidx.compose.material3.DisplayMode.m3444equalsimpl0(r1, r6)
            if (r1 == 0) goto L_0x019a
            r1 = 1922096500(0x7290dd74, float:5.738696E30)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "399@17218L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            androidx.compose.material3.Strings$Companion r1 = androidx.compose.material3.Strings.Companion
            int r1 = r1.m3713getDateInputNoInputDescriptionadMyvUU()
            java.lang.String r1 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r1, r7, r5)
            r7.endReplaceableGroup()
            goto L_0x01a4
        L_0x019a:
            r1 = -544548443(0xffffffffdf8ad9a5, float:-2.001042E19)
            r7.startReplaceableGroup(r1)
            r7.endReplaceableGroup()
            r1 = r2
        L_0x01a4:
            r7.endReplaceableGroup()
            androidx.compose.runtime.MutableState r6 = r16.getSelectedEndDate()
            java.lang.Object r6 = r6.getValue()
            androidx.compose.material3.CalendarDate r6 = (androidx.compose.material3.CalendarDate) r6
            androidx.compose.material3.CalendarModel r5 = r16.getCalendarModel()
            java.lang.String r3 = r11.formatDate$material3_release(r6, r5, r4, r3)
            r5 = -1212633768(0xffffffffb7b8ad58, float:-2.2015229E-5)
            r7.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            if (r3 != 0) goto L_0x022b
            androidx.compose.runtime.MutableState r3 = r16.getDisplayMode()
            java.lang.Object r3 = r3.getValue()
            androidx.compose.material3.DisplayMode r3 = (androidx.compose.material3.DisplayMode) r3
            int r3 = r3.m3447unboximpl()
            androidx.compose.material3.DisplayMode$Companion r5 = androidx.compose.material3.DisplayMode.Companion
            int r5 = r5.m3449getPickerjFl4v0()
            boolean r5 = androidx.compose.material3.DisplayMode.m3444equalsimpl0(r3, r5)
            if (r5 == 0) goto L_0x01fb
            r2 = 1922096919(0x7290df17, float:5.738949E30)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "409@17637L51"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = r2.m3718getDatePickerNoSelectionDescriptionadMyvUU()
            r3 = 6
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r2, r7, r3)
            r7.endReplaceableGroup()
            goto L_0x022c
        L_0x01fb:
            androidx.compose.material3.DisplayMode$Companion r5 = androidx.compose.material3.DisplayMode.Companion
            int r5 = r5.m3448getInputjFl4v0()
            boolean r3 = androidx.compose.material3.DisplayMode.m3444equalsimpl0(r3, r5)
            if (r3 == 0) goto L_0x0221
            r2 = 1922097008(0x7290df70, float:5.739003E30)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "410@17726L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
            int r2 = r2.m3713getDateInputNoInputDescriptionadMyvUU()
            r3 = 6
            java.lang.String r2 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r2, r7, r3)
            r7.endReplaceableGroup()
            goto L_0x022c
        L_0x0221:
            r3 = -544532695(0xffffffffdf8b1729, float:-2.004505E19)
            r7.startReplaceableGroup(r3)
            r7.endReplaceableGroup()
            goto L_0x022c
        L_0x022b:
            r2 = r3
        L_0x022c:
            r7.endReplaceableGroup()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r13)
            java.lang.String r5 = ": "
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r14)
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            r6 = 0
            r19 = 0
            r46 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            boolean r1 = r7.changed((java.lang.Object) r3)
            boolean r21 = r7.changed((java.lang.Object) r5)
            r1 = r1 | r21
            r21 = r7
            r22 = 0
            r47 = r2
            java.lang.Object r2 = r21.rememberedValue()
            r23 = 0
            if (r1 != 0) goto L_0x0295
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r1
            java.lang.Object r1 = r24.getEmpty()
            if (r2 != r1) goto L_0x028f
            goto L_0x0297
        L_0x028f:
            r1 = r2
            r24 = r1
            r2 = r21
            goto L_0x02aa
        L_0x0295:
            r25 = r1
        L_0x0297:
            r1 = 0
            r24 = r1
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1$1 r1 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1$1
            r1.<init>(r3, r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r24 = r2
            r2 = r21
            r2.updateRememberedValue(r1)
        L_0x02aa:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r12, r1)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r19 = r3
            r3 = 4
            r21 = 0
            r48 = r4
            float r4 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r4)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r3 = r6.m2132spacedBy0680j_4(r3)
            r4 = 432(0x1b0, float:6.05E-43)
            r6 = 0
            r49 = r5
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r7.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            androidx.compose.foundation.layout.Arrangement$Horizontal r3 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r3
            int r5 = r4 >> 3
            r5 = r5 & 14
            int r21 = r4 >> 3
            r21 = r21 & 112(0x70, float:1.57E-43)
            r5 = r5 | r21
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r3, r2, r7, r5)
            int r3 = r4 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r5 = 0
            r50 = r5
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r7.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r21 = 6
            r22 = 0
            r51 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r6, r8)
            java.lang.Object r23 = r7.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r5 = r23
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r21 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r6 = r21
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r21 = 6
            r23 = 0
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r11, r8)
            java.lang.Object r11 = r7.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r6 = r11
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r21 = 6
            r23 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r12, r8)
            java.lang.Object r8 = r7.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r12 = r3 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r21 = 6
            r12 = r12 | 6
            r52 = 0
            r53 = r3
            androidx.compose.runtime.Applier r3 = r7.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x0376
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0376:
            r7.startReusableNode()
            boolean r3 = r7.getInserting()
            if (r3 == 0) goto L_0x0383
            r7.createNode(r11)
            goto L_0x0386
        L_0x0383:
            r7.useNode()
        L_0x0386:
            r7.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r7)
            r21 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r54 = r11
            kotlin.jvm.functions.Function2 r11 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r2, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            r7.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r7)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r11 = r12 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r1.invoke(r3, r7, r11)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r7.startReplaceableGroup(r3)
            int r3 = r12 >> 9
            r3 = r3 & 14
            r11 = r7
            r55 = 0
            r56 = r1
            r1 = -326682283(0xffffffffec873955, float:-1.3078058E27)
            r57 = r2
            java.lang.String r2 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r2 = r4 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r21 = 6
            r2 = r2 | 6
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r71 = r11
            r58 = 0
            r59 = r1
            r1 = 990390577(0x3b082931, float:0.0020776505)
            r60 = r2
            java.lang.String r2 = "C430@18586L16:DateRangePicker.kt#uh7d8r"
            r61 = r3
            r3 = r71
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r2)
            if (r18 == 0) goto L_0x0444
            r1 = 990390609(0x3b082951, float:0.002077658)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "426@18452L31"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r44 = 0
            r45 = 131070(0x1fffe, float:1.83668E-40)
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r43 = 0
            r21 = r18
            r42 = r3
            androidx.compose.material3.TextKt.m3858Text4IGK_g((java.lang.String) r21, (androidx.compose.ui.Modifier) r22, (long) r23, (long) r25, (androidx.compose.ui.text.font.FontStyle) r27, (androidx.compose.ui.text.font.FontWeight) r28, (androidx.compose.ui.text.font.FontFamily) r29, (long) r30, (androidx.compose.ui.text.style.TextDecoration) r32, (androidx.compose.ui.text.style.TextAlign) r33, (long) r34, (int) r36, (boolean) r37, (int) r38, (int) r39, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r40, (androidx.compose.ui.text.TextStyle) r41, (androidx.compose.runtime.Composer) r42, (int) r43, (int) r44, (int) r45)
            r3.endReplaceableGroup()
            goto L_0x045d
        L_0x0444:
            r1 = 990390686(0x3b08299e, float:0.002077676)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "428@18529L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            int r1 = r20 >> 15
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.invoke(r3, r1)
            r3.endReplaceableGroup()
        L_0x045d:
            int r1 = r20 >> 21
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9.invoke(r3, r1)
            if (r0 == 0) goto L_0x04a7
            r1 = 990390828(0x3b082a2c, float:0.002077709)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "432@18671L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r44 = 0
            r45 = 131070(0x1fffe, float:1.83668E-40)
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r43 = 0
            r21 = r0
            r42 = r3
            androidx.compose.material3.TextKt.m3858Text4IGK_g((java.lang.String) r21, (androidx.compose.ui.Modifier) r22, (long) r23, (long) r25, (androidx.compose.ui.text.font.FontStyle) r27, (androidx.compose.ui.text.font.FontWeight) r28, (androidx.compose.ui.text.font.FontFamily) r29, (long) r30, (androidx.compose.ui.text.style.TextDecoration) r32, (androidx.compose.ui.text.style.TextAlign) r33, (long) r34, (int) r36, (boolean) r37, (int) r38, (int) r39, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r40, (androidx.compose.ui.text.TextStyle) r41, (androidx.compose.runtime.Composer) r42, (int) r43, (int) r44, (int) r45)
            r3.endReplaceableGroup()
            goto L_0x04c0
        L_0x04a7:
            r1 = 990390903(0x3b082a77, float:0.0020777264)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "434@18746L20"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            int r1 = r20 >> 18
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.invoke(r3, r1)
            r3.endReplaceableGroup()
        L_0x04c0:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r7.endReplaceableGroup()
            r7.endNode()
            r7.endReplaceableGroup()
            r7.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04e1:
            androidx.compose.runtime.ScopeUpdateScope r11 = r7.endRestartGroup()
            if (r11 != 0) goto L_0x04ea
            r16 = r7
            goto L_0x050b
        L_0x04ea:
            androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$5 r12 = new androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$5
            r0 = r12
            r1 = r62
            r2 = r63
            r3 = r64
            r4 = r65
            r5 = r66
            r6 = r67
            r16 = r7
            r7 = r68
            r8 = r69
            r9 = r70
            r10 = r72
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x050b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline(androidx.compose.material3.DateRangePickerState, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
