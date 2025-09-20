package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\"\u001ad\u0010#\u001a\u00020\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010*\u001a.\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u000b\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002\u001aM\u00103\u001a\u00020\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0013H\u0002\u001a)\u0010>\u001a\u00020\n*\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "stateData", "Landroidx/compose/material3/StateData;", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "onDateSelected", "Lkotlin/ParameterName;", "name", "dateInMillis", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/StateData;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "rememberDateRangePickerState-pMw4iz8", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m2245PaddingValuesa9UjIt4$default(Dp.m7554constructorimpl((float) 24), Dp.m7554constructorimpl((float) 20), 0.0f, Dp.m7554constructorimpl((float) 8), 4, (Object) null);
    /* access modifiers changed from: private */
    public static final PaddingValues DateRangePickerHeadlinePadding = PaddingKt.m2245PaddingValuesa9UjIt4$default(Dp.m7554constructorimpl((float) 64), 0.0f, Dp.m7554constructorimpl((float) 12), Dp.m7554constructorimpl((float) 12), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final PaddingValues DateRangePickerTitlePadding = PaddingKt.m2245PaddingValuesa9UjIt4$default(Dp.m7554constructorimpl((float) 64), 0.0f, Dp.m7554constructorimpl((float) 12), 0.0f, 10, (Object) null);
    private static final float HeaderHeightOffset = Dp.m7554constructorimpl((float) 60);

    public static final void DateRangePicker(DateRangePickerState state, Modifier modifier, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> headline, boolean showModeToggle, DatePickerColors colors, Composer $composer, int $changed, int i) {
        DatePickerFormatter dateFormatter2;
        Function1 dateValidator2;
        Function2 function2;
        Function2 function22;
        Modifier modifier2;
        DatePickerColors colors2;
        boolean showModeToggle2;
        Function2 headline2;
        Function2 title2;
        Function1 dateValidator3;
        DatePickerFormatter dateFormatter3;
        DatePickerColors colors3;
        boolean showModeToggle3;
        boolean z;
        Function2 headline3;
        Function2 title3;
        Function2 function23;
        Modifier modifier3;
        Object value$iv$iv;
        int i2;
        DateRangePickerState dateRangePickerState = state;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(dateRangePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(-1835392055);
        ComposerKt.sourceInformation($composer2, "C(DateRangePicker)P(6,4,1,2,7,3,5)87@4128L34,103@4743L8,124@5421L10,105@4760L1103:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) dateRangePickerState) ? 4 : 2;
        }
        int i5 = i4 & 2;
        if (i5 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i3 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            dateFormatter2 = dateFormatter;
        } else if ((i3 & 896) == 0) {
            dateFormatter2 = dateFormatter;
            $dirty |= $composer2.changed((Object) dateFormatter2) ? 256 : 128;
        } else {
            dateFormatter2 = dateFormatter;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            dateValidator2 = dateValidator;
        } else if ((i3 & 7168) == 0) {
            dateValidator2 = dateValidator;
            $dirty |= $composer2.changedInstance(dateValidator2) ? 2048 : 1024;
        } else {
            dateValidator2 = dateValidator;
        }
        int i8 = i4 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            function2 = title;
        } else if ((i3 & 57344) == 0) {
            function2 = title;
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        } else {
            function2 = title;
        }
        int i9 = i4 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function22 = headline;
        } else if ((458752 & i3) == 0) {
            function22 = headline;
            $dirty |= $composer2.changedInstance(function22) ? 131072 : 65536;
        } else {
            function22 = headline;
        }
        int i10 = i4 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            boolean z2 = showModeToggle;
        } else if ((i3 & 3670016) == 0) {
            $dirty |= $composer2.changed(showModeToggle) ? 1048576 : 524288;
        } else {
            boolean z3 = showModeToggle;
        }
        if ((i3 & 29360128) == 0) {
            if ((i4 & 128) != 0) {
                DatePickerColors datePickerColors = colors;
            } else if ($composer2.changed((Object) colors)) {
                i2 = 8388608;
                $dirty |= i2;
            }
            i2 = 4194304;
            $dirty |= i2;
        } else {
            DatePickerColors datePickerColors2 = colors;
        }
        if (($dirty & 23967451) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = new DatePickerFormatter((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Composer composer = $this$cache$iv$iv;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dateFormatter2 = (DatePickerFormatter) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                }
                if (i7 != 0) {
                    dateValidator2 = DateRangePickerKt$DateRangePicker$2.INSTANCE;
                }
                if (i8 != 0) {
                    z = true;
                    title3 = ComposableLambdaKt.composableLambda($composer2, 492752701, true, new DateRangePickerKt$DateRangePicker$3(dateRangePickerState, $dirty));
                } else {
                    z = true;
                    title3 = function2;
                }
                if (i9 != 0) {
                    headline3 = ComposableLambdaKt.composableLambda($composer2, -204181785, z, new DateRangePickerKt$DateRangePicker$4(dateRangePickerState, dateFormatter2, $dirty));
                } else {
                    headline3 = headline;
                }
                if (i10 != 0) {
                    showModeToggle3 = true;
                } else {
                    showModeToggle3 = showModeToggle;
                }
                if ((i4 & 128) != 0) {
                    colors3 = DatePickerDefaults.INSTANCE.m3416colors1m2CgY(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, 805306368, 524287);
                    $dirty &= -29360129;
                } else {
                    colors3 = colors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i4 & 128) != 0) {
                    modifier2 = modifier;
                    headline3 = headline;
                    showModeToggle3 = showModeToggle;
                    colors3 = colors;
                    $dirty &= -29360129;
                    title3 = function2;
                    z = true;
                } else {
                    modifier2 = modifier;
                    headline3 = headline;
                    showModeToggle3 = showModeToggle;
                    colors3 = colors;
                    title3 = function2;
                    z = true;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835392055, $dirty, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
            }
            if (showModeToggle3) {
                function23 = ComposableLambdaKt.composableLambda($composer2, -1062265737, z, new DateRangePickerKt$DateRangePicker$5(dateRangePickerState, $dirty));
            } else {
                function23 = null;
            }
            DatePickerKt.m3419DateEntryContainerau3_HiA(modifier2, title3, headline3, function23, colors3, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m7554constructorimpl(DatePickerModalTokens.INSTANCE.m4105getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda($composer2, -186850856, z, new DateRangePickerKt$DateRangePicker$6(state, dateFormatter2, dateValidator2, colors3, $dirty)), $composer2, (($dirty >> 3) & 14) | 14155776 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            title2 = title3;
            int i11 = $dirty;
            headline2 = headline3;
            showModeToggle2 = showModeToggle3;
            dateFormatter3 = dateFormatter2;
            colors2 = colors3;
            dateValidator3 = dateValidator2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            showModeToggle2 = showModeToggle;
            colors2 = colors;
            int i12 = $dirty;
            dateValidator3 = dateValidator2;
            headline2 = function22;
            title2 = function2;
            dateFormatter3 = dateFormatter2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer2 = $composer2;
            return;
        }
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new DateRangePickerKt$DateRangePicker$7(state, modifier2, dateFormatter3, dateValidator3, title2, headline2, showModeToggle2, colors2, $changed, i));
    }

    /* renamed from: rememberDateRangePickerState-pMw4iz8  reason: not valid java name */
    public static final DateRangePickerState m3428rememberDateRangePickerStatepMw4iz8(Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(501019096);
        ComposerKt.sourceInformation($composer, "C(rememberDateRangePickerState)P(3,2,1,4,0:c#material3.DisplayMode)164@7390L384:DateRangePicker.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialSelectedStartDateMillis = null;
        }
        if ((i & 2) != 0) {
            initialSelectedEndDateMillis = null;
        }
        if ((i & 4) != 0) {
            initialDisplayedMonthMillis = initialSelectedStartDateMillis;
        }
        if ((i & 8) != 0) {
            yearRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i & 16) != 0) {
            initialDisplayMode = DisplayMode.Companion.m3449getPickerjFl4v0();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(501019096, $changed, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:157)");
        }
        DateRangePickerState dateRangePickerState = (DateRangePickerState) RememberSaveableKt.rememberSaveable(new Object[0], DateRangePickerState.Companion.Saver(), (String) null, new DateRangePickerKt$rememberDateRangePickerState$1(initialSelectedStartDateMillis, initialSelectedEndDateMillis, initialDisplayedMonthMillis, yearRange, initialDisplayMode), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return dateRangePickerState;
    }

    /* access modifiers changed from: private */
    public static final void SwitchableDateEntryContent(DateRangePickerState state, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, DatePickerColors colors, Composer $composer, int $changed) {
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(984055784);
        ComposerKt.sourceInformation($composer2, "C(SwitchableDateEntryContent)P(3,1,2)455@19358L648:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 4 : 2;
        } else {
            DateRangePickerState dateRangePickerState = state;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) dateFormatter) ? 32 : 16;
        } else {
            DatePickerFormatter datePickerFormatter = dateFormatter;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(dateValidator) ? 256 : 128;
        } else {
            Function1<? super Long, Boolean> function1 = dateValidator;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 2048 : 1024;
        } else {
            DatePickerColors datePickerColors = colors;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(984055784, $dirty, -1, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:447)");
            }
            int r0 = state.m3431getDisplayModejFl4v0();
            SpringSpec spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, DateRangePickerKt$SwitchableDateEntryContent$1.INSTANCE, 1, (Object) null);
            DisplayMode r02 = DisplayMode.m3441boximpl(r0);
            DateRangePickerKt$SwitchableDateEntryContent$2 dateRangePickerKt$SwitchableDateEntryContent$2 = r7;
            DateRangePickerKt$SwitchableDateEntryContent$2 dateRangePickerKt$SwitchableDateEntryContent$22 = new DateRangePickerKt$SwitchableDateEntryContent$2(state, dateFormatter, dateValidator, colors, $dirty);
            CrossfadeKt.Crossfade(r02, semantics$default, (FiniteAnimationSpec<Float>) spring$default, (String) null, ComposableLambdaKt.composableLambda($composer2, 1354418636, true, dateRangePickerKt$SwitchableDateEntryContent$2), $composer2, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i2 = $dirty;
            return;
        }
        int i3 = $dirty;
        endRestartGroup.updateScope(new DateRangePickerKt$SwitchableDateEntryContent$3(state, dateFormatter, dateValidator, colors, $changed));
    }

    /* access modifiers changed from: private */
    public static final void DateRangePickerContent(StateData stateData, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, DatePickerColors colors, Composer $composer, int $changed) {
        Function1 function1;
        StateData stateData2 = stateData;
        DatePickerColors datePickerColors = colors;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1003501610);
        ComposerKt.sourceInformation($composer2, "C(DateRangePickerContent)P(3,1,2)485@20269L105,489@20401L82,492@20488L412:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) stateData2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) dateFormatter) ? 32 : 16;
        } else {
            DatePickerFormatter datePickerFormatter = dateFormatter;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(dateValidator) ? 256 : 128;
        } else {
            Function1<? super Long, Boolean> function12 = dateValidator;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) datePickerColors) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003501610, $dirty2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:478)");
            }
            LazyListState monthsListState = LazyListStateKt.rememberLazyListState(stateData.getDisplayedMonthIndex(), 0, $composer2, 0, 2);
            int $changed$iv = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) stateData2);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                int i2 = $changed$iv;
                function1 = new DateRangePickerKt$DateRangePickerContent$onDateSelected$1$1(stateData2);
                $this$cache$iv$iv.updateRememberedValue(function1);
            } else {
                int i3 = $changed$iv;
                function1 = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Function1 onDateSelected = function1;
            Modifier modifier$iv = PaddingKt.m2250paddingVpY3zN4$default(Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, (Object) null);
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int i5 = ((6 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Density density = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1265369378, "C493@20576L41,494@20626L268:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors, stateData.getCalendarModel(), $composer3, ($dirty2 >> 9) & 14);
            Composer $composer4 = $composer3;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Arrangement.Vertical vertical = verticalArrangement$iv2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            VerticalMonthsList(onDateSelected, stateData, monthsListState, dateFormatter, dateValidator, colors, $composer4, (($dirty2 << 3) & 112) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 57344) | (($dirty2 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerKt$DateRangePickerContent$2(stateData, dateFormatter, dateValidator, colors, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalMonthsList(Function1<? super Long, Unit> onDateSelected, StateData stateData, LazyListState lazyListState, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, DatePickerColors colors, Composer $composer, int $changed) {
        CalendarMonth key1$iv;
        Object value$iv$iv;
        StateData stateData2 = stateData;
        LazyListState lazyListState2 = lazyListState;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-837198453);
        ComposerKt.sourceInformation($composer2, "C(VerticalMonthsList)P(4,5,3,1,2)520@21434L168,527@21647L10,526@21607L2599,584@24241L62,584@24211L92:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(onDateSelected) ? 4 : 2;
        } else {
            Function1<? super Long, Unit> function1 = onDateSelected;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) stateData2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed((Object) lazyListState2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) dateFormatter) ? 2048 : 1024;
        } else {
            DatePickerFormatter datePickerFormatter = dateFormatter;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer2.changedInstance(dateValidator) ? 16384 : 8192;
        } else {
            Function1<? super Long, Boolean> function12 = dateValidator;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 131072 : 65536;
        } else {
            DatePickerColors datePickerColors = colors;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-837198453, $dirty2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:511)");
            }
            CalendarDate today = stateData.getCalendarModel().getToday();
            IntRange yearRange = stateData.getYearRange();
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) yearRange);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                IntRange intRange = yearRange;
                key1$iv = stateData.getCalendarModel().getMonth(stateData.getYearRange().getFirst(), 1);
                $this$cache$iv$iv.updateRememberedValue(key1$iv);
            } else {
                IntRange intRange2 = yearRange;
                key1$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            CalendarMonth firstMonth = key1$iv;
            CalendarMonth calendarMonth = firstMonth;
            CalendarMonth calendarMonth2 = firstMonth;
            DateRangePickerKt$VerticalMonthsList$1 dateRangePickerKt$VerticalMonthsList$1 = r0;
            int $dirty3 = $dirty2;
            DateRangePickerKt$VerticalMonthsList$1 dateRangePickerKt$VerticalMonthsList$12 = new DateRangePickerKt$VerticalMonthsList$1(lazyListState, $dirty2, stateData, calendarMonth, dateFormatter, colors, onDateSelected, today, dateValidator);
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont()), ComposableLambdaKt.composableLambda($composer2, 56792252, true, dateRangePickerKt$VerticalMonthsList$1), $composer2, 48);
            int i2 = (($dirty3 >> 6) & 14) | ($dirty3 & 112);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed((Object) lazyListState2) | $composer2.changed((Object) stateData2);
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function2) new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, stateData2, (Continuation<? super DateRangePickerKt$VerticalMonthsList$2$1>) null);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv, $composer2, (($dirty3 >> 6) & 14) | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i3 = $dirty2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DateRangePickerKt$VerticalMonthsList$3(onDateSelected, stateData, lazyListState, dateFormatter, dateValidator, colors, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void updateDateSelection(StateData stateData, long dateInMillis) {
        StateData $this$updateDateSelection_u24lambda_u245 = stateData;
        CalendarDate date = $this$updateDateSelection_u24lambda_u245.getCalendarModel().getCanonicalDate(dateInMillis);
        CalendarDate currentStart = $this$updateDateSelection_u24lambda_u245.getSelectedStartDate().getValue();
        CalendarDate currentEnd = $this$updateDateSelection_u24lambda_u245.getSelectedEndDate().getValue();
        if ((currentStart == null && currentEnd == null) || ((currentStart != null && currentEnd != null) || (currentStart != null && date.compareTo(currentStart) < 0))) {
            $this$updateDateSelection_u24lambda_u245.getSelectedStartDate().setValue(date);
            $this$updateDateSelection_u24lambda_u245.getSelectedEndDate().setValue(null);
        } else if (currentStart != null && date.compareTo(currentStart) >= 0) {
            $this$updateDateSelection_u24lambda_u245.getSelectedEndDate().setValue(date);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* renamed from: drawRangeBackground-mxwnekA  reason: not valid java name */
    public static final void m3427drawRangeBackgroundmxwnekA(ContentDrawScope $this$drawRangeBackground_u2dmxwnekA, SelectedRangeInfo selectedRangeInfo, long color) {
        float f;
        ContentDrawScope contentDrawScope = $this$drawRangeBackground_u2dmxwnekA;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawRangeBackground");
        Intrinsics.checkNotNullParameter(selectedRangeInfo, "selectedRangeInfo");
        float itemContainerWidth = contentDrawScope.m7535toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float itemContainerHeight = contentDrawScope.m7535toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float itemStateLayerHeight = contentDrawScope.m7535toPx0680j_4(DatePickerModalTokens.INSTANCE.m4098getDateStateLayerHeightD9Ej5fM());
        float f2 = (float) 2;
        float stateLayerVerticalPadding = (itemContainerHeight - itemStateLayerHeight) / f2;
        float f3 = (float) 7;
        float horizontalSpaceBetweenItems = (Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()) - (f3 * itemContainerWidth)) / f3;
        long r8 = selectedRangeInfo.getGridCoordinates().getFirst().m7681unboximpl();
        int x1 = IntOffset.m7664component1impl(r8);
        int y1 = IntOffset.m7665component2impl(r8);
        long r11 = selectedRangeInfo.getGridCoordinates().getSecond().m7681unboximpl();
        int x2 = IntOffset.m7664component1impl(r11);
        int y2 = IntOffset.m7665component2impl(r11);
        float startX = (((float) x1) * (itemContainerWidth + horizontalSpaceBetweenItems)) + (selectedRangeInfo.getFirstIsSelectionStart() ? itemContainerWidth / f2 : 0.0f) + (horizontalSpaceBetweenItems / f2);
        float startY = (((float) y1) * itemContainerHeight) + stateLayerVerticalPadding;
        float endX = (((float) x2) * (itemContainerWidth + horizontalSpaceBetweenItems)) + (selectedRangeInfo.getLastIsSelectionEnd() ? itemContainerWidth / f2 : itemContainerWidth) + (horizontalSpaceBetweenItems / f2);
        float endY = (((float) y2) * itemContainerHeight) + stateLayerVerticalPadding;
        float f4 = itemContainerWidth;
        boolean isRtl = $this$drawRangeBackground_u2dmxwnekA.getLayoutDirection() == LayoutDirection.Rtl;
        if (isRtl) {
            startX = Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()) - startX;
            endX = Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()) - endX;
        }
        DrawScope drawScope = contentDrawScope;
        long Offset = OffsetKt.Offset(startX, startY);
        if (y1 == y2) {
            f = endX - startX;
        } else if (isRtl) {
            f = -startX;
        } else {
            f = Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()) - startX;
        }
        DrawScope.m5552drawRectnJ9OG0$default(drawScope, color, Offset, SizeKt.Size(f, itemStateLayerHeight), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        if (y1 != y2) {
            int y = (y2 - y1) - 1;
            while (y > 0) {
                DrawScope.m5552drawRectnJ9OG0$default(contentDrawScope, color, OffsetKt.Offset(0.0f, (((float) y) * itemContainerHeight) + startY), SizeKt.Size(Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()), itemStateLayerHeight), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                y--;
                SelectedRangeInfo selectedRangeInfo2 = selectedRangeInfo;
                itemContainerHeight = itemContainerHeight;
            }
            DrawScope.m5552drawRectnJ9OG0$default(contentDrawScope, color, OffsetKt.Offset($this$drawRangeBackground_u2dmxwnekA.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()), endY), SizeKt.Size(isRtl ? endX - Size.m4782getWidthimpl($this$drawRangeBackground_u2dmxwnekA.m5576getSizeNHjbRc()) : endX, itemStateLayerHeight), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            return;
        }
    }

    /* access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyListState state, CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        return CollectionsKt.listOf(new CustomAccessibilityAction(scrollUpLabel, new DateRangePickerKt$customScrollActions$scrollUpAction$1(state, coroutineScope)), new CustomAccessibilityAction(scrollDownLabel, new DateRangePickerKt$customScrollActions$scrollDownAction$1(state, coroutineScope)));
    }
}
