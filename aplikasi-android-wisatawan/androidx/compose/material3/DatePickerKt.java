package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010.\u001a9\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u0002012\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u00102\u001a]\u00103\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001an\u0010:\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010;\u001a\u00020,2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010C\u001a9\u0010D\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010E\u001a\u00020F2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00140*H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001ad\u0010J\u001a\u00020\u00142!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u00140*2\u0006\u00100\u001a\u0002012\u0006\u0010O\u001a\u00020P2\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010Q\u001at\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020T2!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010?\u001a\u00020U2\u0006\u00100\u001a\u0002012\u0006\u0010V\u001a\u00020,2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010W\u001a_\u0010X\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020B2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0003¢\u0006\u0002\u0010`\u001a9\u0010a\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010b\u001a\u001d\u0010c\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020eH\u0001¢\u0006\u0002\u0010f\u001aV\u0010g\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010;\u001a\u00020,2\u0006\u0010h\u001a\u00020,2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010i\u001aH\u0010j\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162!\u0010k\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0003¢\u0006\u0002\u0010m\u001a@\u0010n\u001a\u00020\u00142\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010o\u001a\u00020,2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010p\u001a.\u0010q\u001a\b\u0012\u0004\u0012\u00020s0r2\u0006\u0010%\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020BH\u0002\u001a7\u0010y\u001a\u0004\u0018\u00010B2\u0006\u0010V\u001a\u00020,2\u0006\u0010z\u001a\u00020,2\u0006\u0010{\u001a\u00020,2\u0006\u0010|\u001a\u00020,2\u0006\u0010}\u001a\u00020,H\u0003¢\u0006\u0002\u0010~\u001aH\u0010\u001a\u00020&2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010+2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020FH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a#\u0010\u0001\u001a\u00020\u00142\u0006\u0010O\u001a\u00020P2\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001\u001a\r\u0010\u0001\u001a\u00020B*\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0001"}, d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "showModeToggle", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "stateData", "Landroidx/compose/material3/StateData;", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "Landroidx/compose/material3/DisplayMode;", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "onDateSelected", "Lkotlin/ParameterName;", "name", "dateInMillis", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/StateData;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/CalendarMonth;", "Landroidx/compose/material3/CalendarDate;", "rangeSelectionEnabled", "(Landroidx/compose/material3/CalendarMonth;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarDate;Landroidx/compose/material3/StateData;ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/StateData;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberDatePickerState", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "rememberDatePickerState-NVmSL94", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/StateData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLocalString", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public final class DatePickerKt {
    /* access modifiers changed from: private */
    public static final PaddingValues DatePickerHeadlinePadding = PaddingKt.m535PaddingValuesa9UjIt4$default(Dp.m5844constructorimpl((float) 24), 0.0f, Dp.m5844constructorimpl((float) 12), Dp.m5844constructorimpl((float) 12), 2, (Object) null);
    private static final float DatePickerHorizontalPadding = Dp.m5844constructorimpl((float) 12);
    private static final PaddingValues DatePickerModeTogglePadding = PaddingKt.m535PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m5844constructorimpl((float) 12), Dp.m5844constructorimpl((float) 12), 3, (Object) null);
    /* access modifiers changed from: private */
    public static final PaddingValues DatePickerTitlePadding = PaddingKt.m535PaddingValuesa9UjIt4$default(Dp.m5844constructorimpl((float) 24), Dp.m5844constructorimpl((float) 16), Dp.m5844constructorimpl((float) 12), 0.0f, 8, (Object) null);
    private static final int MaxCalendarRows = 6;
    private static final float MonthYearHeight = Dp.m5844constructorimpl((float) 56);
    private static final float RecommendedSizeForAccessibility = Dp.m5844constructorimpl((float) 48);
    private static final int YearsInRow = 3;
    /* access modifiers changed from: private */
    public static final float YearsVerticalPadding = Dp.m5844constructorimpl((float) 16);

    public static final void DatePicker(DatePickerState state, Modifier modifier, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> headline, boolean showModeToggle, DatePickerColors colors, Composer $composer, int $changed, int i) {
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
        DatePickerState datePickerState = state;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(datePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(-1765097918);
        ComposerKt.sourceInformation($composer2, "C(DatePicker)P(6,4,1,2,7,3,5)152@7324L34,168@7901L8,189@8580L10,170@7918L1043:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) datePickerState) ? 4 : 2;
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
                    dateValidator2 = DatePickerKt$DatePicker$2.INSTANCE;
                }
                if (i8 != 0) {
                    z = true;
                    title3 = ComposableLambdaKt.composableLambda($composer2, 448469326, true, new DatePickerKt$DatePicker$3(datePickerState, $dirty));
                } else {
                    z = true;
                    title3 = function2;
                }
                if (i9 != 0) {
                    headline3 = ComposableLambdaKt.composableLambda($composer2, 1578326756, z, new DatePickerKt$DatePicker$4(datePickerState, dateFormatter2, $dirty));
                } else {
                    headline3 = headline;
                }
                if (i10 != 0) {
                    showModeToggle3 = true;
                } else {
                    showModeToggle3 = showModeToggle;
                }
                if ((i4 & 128) != 0) {
                    colors3 = DatePickerDefaults.INSTANCE.m1706colors1m2CgY(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, 805306368, 524287);
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
                ComposerKt.traceEventStart(-1765097918, $dirty, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
            }
            if (showModeToggle3) {
                function23 = ComposableLambdaKt.composableLambda($composer2, -1702543532, z, new DatePickerKt$DatePicker$5(datePickerState, $dirty));
            } else {
                function23 = null;
            }
            m1709DateEntryContainerau3_HiA(modifier2, title3, headline3, function23, colors3, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m2391getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda($composer2, 173769747, z, new DatePickerKt$DatePicker$6(state, dateFormatter2, dateValidator2, colors3, $dirty)), $composer2, (($dirty >> 3) & 14) | 14155776 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 57344));
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
        endRestartGroup.updateScope(new DatePickerKt$DatePicker$7(state, modifier2, dateFormatter3, dateValidator3, title2, headline2, showModeToggle2, colors2, $changed, i));
    }

    /* renamed from: rememberDatePickerState-NVmSL94  reason: not valid java name */
    public static final DatePickerState m1712rememberDatePickerStateNVmSL94(Long initialSelectedDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1574672255);
        ComposerKt.sourceInformation($composer, "C(rememberDatePickerState)P(2,1,3,0:c#material3.DisplayMode)224@10177L295:DatePicker.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialSelectedDateMillis = null;
        }
        if ((i & 2) != 0) {
            initialDisplayedMonthMillis = initialSelectedDateMillis;
        }
        if ((i & 4) != 0) {
            yearRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i & 8) != 0) {
            initialDisplayMode = DisplayMode.Companion.m1739getPickerjFl4v0();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1574672255, $changed, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:219)");
        }
        DatePickerState datePickerState = (DatePickerState) RememberSaveableKt.rememberSaveable(new Object[0], DatePickerState.Companion.Saver(), (String) null, new DatePickerKt$rememberDatePickerState$1(initialSelectedDateMillis, initialDisplayedMonthMillis, yearRange, initialDisplayMode), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return datePickerState;
    }

    /* renamed from: DateEntryContainer-au3_HiA  reason: not valid java name */
    public static final void m1709DateEntryContainerau3_HiA(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> headline, Function2<? super Composer, ? super Integer, Unit> modeToggleButton, DatePickerColors colors, TextStyle headlineTextStyle, float headerMinHeight, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Modifier modifier2 = modifier;
        DatePickerColors datePickerColors = colors;
        TextStyle textStyle = headlineTextStyle;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(datePickerColors, "colors");
        Intrinsics.checkNotNullParameter(textStyle, "headlineTextStyle");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(1507356255);
        ComposerKt.sourceInformation($composer2, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1021@43152L1610:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(title) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = title;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(headline) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = headline;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changedInstance(modeToggleButton) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = modeToggleButton;
        }
        if ((i & 57344) == 0) {
            $dirty |= $composer2.changed((Object) datePickerColors) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changed((Object) textStyle) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            $dirty |= $composer2.changed(headerMinHeight) ? 1048576 : 524288;
        } else {
            float f = headerMinHeight;
        }
        if ((29360128 & i) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int $dirty2 = $dirty;
        if ((23967451 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, $dirty2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1011)");
            }
            int $dirty3 = $dirty2;
            Modifier modifier$iv = SemanticsModifierKt.semantics$default(SizeKt.m616sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m2385getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, (Object) null), false, DatePickerKt$DateEntryContainer$1.INSTANCE, 1, (Object) null);
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function0<ComposeUiNode> function0 = constructor;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(function0);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer2);
            Function0<ComposeUiNode> function02 = function0;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int i3 = ((0 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -916081480, "C1026@43319L1419,1059@44747L9:DatePicker.kt#uh7d8r");
            long r23 = colors.m1703getTitleContentColor0d7_KjU$material3_release();
            long r39 = colors.m1701getHeadlineContentColor0d7_KjU$material3_release();
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer4 = $composer3;
            DatePickerKt$DateEntryContainer$2$1 datePickerKt$DateEntryContainer$2$1 = r0;
            Density density = density$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            Alignment.Horizontal horizontal = horizontalAlignment$iv2;
            Arrangement.Vertical vertical = verticalArrangement$iv2;
            Function0<ComposeUiNode> function03 = function02;
            DatePickerKt$DateEntryContainer$2$1 datePickerKt$DateEntryContainer$2$12 = new DatePickerKt$DateEntryContainer$2$1(headline, modeToggleButton, title, headlineTextStyle, $dirty3);
            m1710DatePickerHeaderpc5RIQQ(Modifier.Companion, title, r23, r39, headerMinHeight, ComposableLambdaKt.composableLambda($composer4, -229007058, true, datePickerKt$DateEntryContainer$2$1), $composer4, ($dirty3 & 112) | 196614 | (($dirty3 >> 6) & 57344));
            function2.invoke($composer4, Integer.valueOf(($dirty3 >> 21) & 14));
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
            int i4 = $dirty2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DateEntryContainer$3(modifier, title, headline, modeToggleButton, colors, headlineTextStyle, headerMinHeight, content, $changed));
        }
    }

    /* renamed from: DisplayModeToggleButton-tER2X8s  reason: not valid java name */
    public static final void m1711DisplayModeToggleButtontER2X8s(Modifier modifier, int displayMode, Function1<? super DisplayMode, Unit> onDisplayModeChange, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onDisplayModeChange, "onDisplayModeChange");
        Composer $composer2 = $composer.startRestartGroup(1393846115);
        ComposerKt.sourceInformation($composer2, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(displayMode) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(onDisplayModeChange) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, $dirty2, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1065)");
            }
            if (DisplayMode.m1734equalsimpl0(displayMode, DisplayMode.Companion.m1739getPickerjFl4v0())) {
                $composer2.startReplaceableGroup(-1814971324);
                ComposerKt.sourceInformation($composer2, "1071@45035L42,1071@45014L262");
                int i = ($dirty2 >> 6) & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) onDisplayModeChange);
                Composer $this$cache$iv$iv = $composer2;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                    value$iv$iv2 = (Function0) new DatePickerKt$DisplayModeToggleButton$1$1(onDisplayModeChange);
                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) value$iv$iv2, modifier, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1679getLambda1$material3_release(), $composer2, (($dirty2 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(-1814971040);
                ComposerKt.sourceInformation($composer2, "1078@45319L43,1078@45298L271");
                int i2 = ($dirty2 >> 6) & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed((Object) onDisplayModeChange);
                Composer $this$cache$iv$iv2 = $composer2;
                Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                    value$iv$iv = (Function0) new DatePickerKt$DisplayModeToggleButton$2$1(onDisplayModeChange);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) value$iv$iv, modifier, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableSingletons$DatePickerKt.INSTANCE.m1680getLambda2$material3_release(), $composer2, (($dirty2 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$DisplayModeToggleButton$3(modifier, displayMode, onDisplayModeChange, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void SwitchableDateEntryContent(DatePickerState state, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, DatePickerColors colors, Composer $composer, int $changed) {
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(1613036224);
        ComposerKt.sourceInformation($composer2, "C(SwitchableDateEntryContent)P(3,1,2)1101@46104L638:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 4 : 2;
        } else {
            DatePickerState datePickerState = state;
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
                ComposerKt.traceEventStart(1613036224, $dirty, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1093)");
            }
            int r0 = state.m1715getDisplayModejFl4v0();
            SpringSpec spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, DatePickerKt$SwitchableDateEntryContent$1.INSTANCE, 1, (Object) null);
            DisplayMode r02 = DisplayMode.m1731boximpl(r0);
            DatePickerKt$SwitchableDateEntryContent$2 datePickerKt$SwitchableDateEntryContent$2 = r7;
            DatePickerKt$SwitchableDateEntryContent$2 datePickerKt$SwitchableDateEntryContent$22 = new DatePickerKt$SwitchableDateEntryContent$2(state, dateFormatter, dateValidator, colors, $dirty);
            CrossfadeKt.Crossfade(r02, semantics$default, (FiniteAnimationSpec<Float>) spring$default, (String) null, ComposableLambdaKt.composableLambda($composer2, 1854706084, true, datePickerKt$SwitchableDateEntryContent$2), $composer2, 24960, 8);
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
        endRestartGroup.updateScope(new DatePickerKt$SwitchableDateEntryContent$3(state, dateFormatter, dateValidator, colors, $changed));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0539  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x053d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x06c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DatePickerContent(androidx.compose.material3.StateData r84, androidx.compose.material3.DatePickerFormatter r85, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r86, androidx.compose.material3.DatePickerColors r87, androidx.compose.runtime.Composer r88, int r89) {
        /*
            r8 = r84
            r9 = r85
            r10 = r87
            r11 = r89
            r0 = -1512850300(0xffffffffa5d3bc84, float:-3.6730408E-16)
            r1 = r88
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DatePickerContent)P(3,1,2)1131@47000L83,1132@47109L24,1134@47160L140,1139@47331L42,1140@47398L15,1141@47418L4106:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r89
            r2 = r11 & 14
            r13 = 2
            if (r2 != 0) goto L_0x0027
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = r13
        L_0x0026:
            r1 = r1 | r2
        L_0x0027:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0037
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0034
            r2 = 32
            goto L_0x0036
        L_0x0034:
            r2 = 16
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x004a
            r14 = r86
            boolean r2 = r12.changedInstance(r14)
            if (r2 == 0) goto L_0x0046
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r1 = r1 | r2
            goto L_0x004c
        L_0x004a:
            r14 = r86
        L_0x004c:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x005c
            boolean r2 = r12.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0059
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005b
        L_0x0059:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005b:
            r1 = r1 | r2
        L_0x005c:
            r15 = r1
            r1 = r15 & 5851(0x16db, float:8.199E-42)
            r2 = 1170(0x492, float:1.64E-42)
            if (r1 != r2) goto L_0x0074
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            r12.skipToGroupEnd()
            r9 = r10
            r56 = r12
            r32 = r15
            goto L_0x06ca
        L_0x0074:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0080
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DatePickerContent (DatePicker.kt:1124)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x0080:
            int r0 = r84.getDisplayedMonthIndex()
            r7 = 0
            androidx.compose.foundation.lazy.LazyListState r0 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r0, r7, r12, r7, r13)
            r1 = r7
            r2 = 0
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = r12
            r4 = r7
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            r6 = 0
            r88 = r12
            r16 = 0
            java.lang.Object r13 = r88.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r19.getEmpty()
            if (r13 != r7) goto L_0x00d8
            r7 = 0
            r19 = 0
            kotlin.coroutines.EmptyCoroutineContext r19 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r21 = r1
            r1 = r19
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r3)
            r19 = r2
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r1 = r2
            r2 = r88
            r2.updateRememberedValue(r1)
            goto L_0x00df
        L_0x00d8:
            r21 = r1
            r19 = r2
            r2 = r88
            r1 = r13
        L_0x00df:
            r12.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r2 = r1.getCoroutineScope()
            r12.endReplaceableGroup()
            r13 = r2
            r1 = r15 & 14
            r2 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r7)
            java.lang.String r6 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r6)
            boolean r3 = r12.changed((java.lang.Object) r8)
            r4 = r12
            r5 = 0
            java.lang.Object r7 = r4.rememberedValue()
            r16 = 0
            if (r3 != 0) goto L_0x0118
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r7 != r1) goto L_0x0116
            goto L_0x011a
        L_0x0116:
            r1 = r7
            goto L_0x0129
        L_0x0118:
            r19 = r1
        L_0x011a:
            r1 = 0
            r18 = r1
            androidx.compose.material3.DatePickerKt$DatePickerContent$onDateSelected$1$1 r1 = new androidx.compose.material3.DatePickerKt$DatePickerContent$onDateSelected$1$1
            r1.<init>(r8)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.updateRememberedValue(r1)
        L_0x0129:
            r12.endReplaceableGroup()
            r16 = r1
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            r7 = 0
            java.lang.Object[] r1 = new java.lang.Object[r7]
            androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2 r2 = androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2.INSTANCE
            r4 = r2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r18 = 3080(0xc08, float:4.316E-42)
            r19 = 6
            r2 = 0
            r3 = 0
            r5 = r12
            r22 = r6
            r6 = r18
            r8 = r7
            r7 = r19
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.util.Locale r6 = androidx.compose.material3.CalendarModel_androidKt.defaultLocale(r12, r8)
            r18 = r8
            r19 = 0
            r1 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r12.startReplaceableGroup(r1)
            java.lang.String r2 = "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r20 = r3
            androidx.compose.ui.Modifier r20 = (androidx.compose.ui.Modifier) r20
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = r3.getTop()
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r3.getStart()
            int r3 = r18 >> 3
            r3 = r3 & 14
            int r21 = r18 >> 3
            r21 = r21 & 112(0x70, float:1.57E-43)
            r3 = r3 | r21
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r4, r12, r3)
            int r21 = r18 << 3
            r21 = r21 & 112(0x70, float:1.57E-43)
            r23 = 0
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r26 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r8 = r26
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r26 = 6
            r28 = 0
            r29 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            r30 = r5
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r31 = r12.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r8 = r31
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r26 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r4 = r26
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r26 = 6
            r31 = 0
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r11, r5)
            java.lang.Object r11 = r12.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r26 = 6
            r31 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r14, r5)
            java.lang.Object r14 = r12.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            kotlin.jvm.functions.Function3 r26 = androidx.compose.ui.layout.LayoutKt.materializerOf(r20)
            int r10 = r21 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 6
            r31 = r26
            r26 = 0
            r32 = r15
            androidx.compose.runtime.Applier r15 = r12.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x020d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x020d:
            r12.startReusableNode()
            boolean r15 = r12.getInserting()
            if (r15 == 0) goto L_0x021a
            r12.createNode(r4)
            goto L_0x021d
        L_0x021a:
            r12.useNode()
        L_0x021d:
            r12.disableReusing()
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r33 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r34 = androidx.compose.ui.node.ComposeUiNode.Companion
            r35 = r4
            kotlin.jvm.functions.Function2 r4 = r34.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r3, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r8, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r11, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r14, r4)
            r12.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r4)
            int r15 = r10 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r33 = r8
            r8 = r31
            r8.invoke(r4, r12, r15)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r4)
            int r15 = r10 >> 9
            r15 = r15 & 14
            r31 = r12
            r34 = r31
            r31 = 0
            r4 = 276693704(0x107e02c8, float:5.009481E-29)
            r37 = r3
            java.lang.String r3 = "C79@4027L9:Column.kt#2w3rfo"
            r38 = r8
            r8 = r34
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r3)
            androidx.compose.foundation.layout.ColumnScopeInstance r34 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r39 = r18 >> 6
            r39 = r39 & 112(0x70, float:1.57E-43)
            r39 = r39 | 6
            androidx.compose.foundation.layout.ColumnScope r34 = (androidx.compose.foundation.layout.ColumnScope) r34
            r50 = r8
            r51 = 0
            r4 = -269675982(0xffffffffefed1232, float:-1.4673989E29)
            r53 = r10
            java.lang.String r10 = "C1166@48484L42,1142@47435L1101,1169@48546L2972:DatePicker.kt#uh7d8r"
            r54 = r11
            r11 = r50
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r10)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            float r10 = DatePickerHorizontalPadding
            r50 = r14
            r14 = 0
            r55 = r15
            r15 = 0
            r56 = r12
            r12 = 2
            androidx.compose.ui.Modifier r40 = androidx.compose.foundation.layout.PaddingKt.m540paddingVpY3zN4$default(r4, r10, r14, r12, r15)
            boolean r41 = r0.getCanScrollForward()
            boolean r42 = r0.getCanScrollBackward()
            boolean r43 = DatePickerContent$lambda$5(r7)
            androidx.compose.material3.CalendarMonth r4 = r84.getDisplayedMonth()
            androidx.compose.material3.CalendarModel r12 = r84.getCalendarModel()
            java.lang.String r4 = r9.formatMonthYear$material3_release(r4, r12, r6)
            if (r4 != 0) goto L_0x02d5
            java.lang.String r4 = "-"
            r44 = r4
            goto L_0x02d7
        L_0x02d5:
            r44 = r4
        L_0x02d7:
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$1 r4 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$1
            r4.<init>(r13, r0)
            r45 = r4
            kotlin.jvm.functions.Function0 r45 = (kotlin.jvm.functions.Function0) r45
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$2 r4 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$2
            r4.<init>(r13, r0)
            r46 = r4
            kotlin.jvm.functions.Function0 r46 = (kotlin.jvm.functions.Function0) r46
            r4 = 0
            r12 = r4
            r4 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r14)
            r14 = r22
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r14)
            boolean r14 = r11.changed((java.lang.Object) r7)
            r88 = r11
            r22 = 0
            java.lang.Object r15 = r88.rememberedValue()
            r47 = 0
            if (r14 != 0) goto L_0x0318
            androidx.compose.runtime.Composer$Companion r48 = androidx.compose.runtime.Composer.Companion
            r57 = r0
            java.lang.Object r0 = r48.getEmpty()
            if (r15 != r0) goto L_0x0312
            goto L_0x031a
        L_0x0312:
            r48 = r4
            r0 = r15
            r4 = r88
            goto L_0x032d
        L_0x0318:
            r57 = r0
        L_0x031a:
            r0 = 0
            r48 = r0
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1 r0 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1
            r0.<init>(r7)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r48 = r4
            r4 = r88
            r4.updateRememberedValue(r0)
        L_0x032d:
            r11.endReplaceableGroup()
            r47 = r0
            kotlin.jvm.functions.Function0 r47 = (kotlin.jvm.functions.Function0) r47
            r49 = 6
            r48 = r11
            MonthsNavigation(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)
            r0 = 0
            r12 = r0
            r14 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r15 = r0
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r0.getTopStart()
            r0 = 0
            int r22 = r12 >> 3
            r22 = r22 & 14
            int r27 = r12 >> 3
            r27 = r27 & 112(0x70, float:1.57E-43)
            r88 = r6
            r6 = r22 | r27
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r0, r11, r6)
            int r22 = r12 << 3
            r22 = r22 & 112(0x70, float:1.57E-43)
            r27 = 0
            r40 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r41 = 6
            r42 = 0
            r43 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r5)
            java.lang.Object r4 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r41 = 6
            r42 = 0
            r44 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r5)
            java.lang.Object r7 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r41 = 6
            r42 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r9, r5)
            java.lang.Object r9 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r0 = r0.getConstructor()
            kotlin.jvm.functions.Function3 r41 = androidx.compose.ui.layout.LayoutKt.materializerOf(r15)
            r42 = r14
            int r14 = r22 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r45 = r41
            r41 = 0
            r46 = r15
            androidx.compose.runtime.Applier r15 = r11.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x03ec
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03ec:
            r11.startReusableNode()
            boolean r15 = r11.getInserting()
            if (r15 == 0) goto L_0x03f9
            r11.createNode(r0)
            goto L_0x03fc
        L_0x03f9:
            r11.useNode()
        L_0x03fc:
            r11.disableReusing()
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r47 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r48 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r0
            kotlin.jvm.functions.Function2 r0 = r48.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r7, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r9, r0)
            r11.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r15 = r14 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r47 = r9
            r9 = r45
            r9.invoke(r0, r11, r15)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r0)
            int r0 = r14 >> 9
            r15 = r0 & 14
            r0 = r11
            r45 = 0
            r48 = r4
            r4 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r58 = r6
            java.lang.String r6 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r6)
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r12 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r59 = r6 | 6
            r60 = r4
            androidx.compose.foundation.layout.BoxScope r60 = (androidx.compose.foundation.layout.BoxScope) r60
            r6 = r0
            r70 = 0
            r4 = 1767568956(0x695af63c, float:1.654429E25)
            r61 = r0
            java.lang.String r0 = "C1170@48564L494,1181@49098L2410:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r17 = r7
            r71 = r9
            r4 = 0
            r7 = 2
            r9 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.PaddingKt.m540paddingVpY3zN4$default(r0, r10, r4, r7, r9)
            r9 = 6
            r62 = 0
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r6.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r0.getTop()
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r0.getStart()
            int r0 = r9 >> 3
            r0 = r0 & 14
            int r2 = r9 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r7, r4, r6, r0)
            int r0 = r9 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r24 = r0
            r63 = 0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r25 = 0
            r64 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r5)
            java.lang.Object r1 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r25 = 6
            r64 = 0
            r65 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r5)
            java.lang.Object r4 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r25 = 6
            r64 = 0
            r66 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r7, r5)
            java.lang.Object r5 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r7 = r5
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r0 = r0.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r10)
            r25 = r10
            int r10 = r24 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 6
            r28 = 0
            r72 = r12
            androidx.compose.runtime.Applier r12 = r6.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0530
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0530:
            r6.startReusableNode()
            boolean r12 = r6.getInserting()
            if (r12 == 0) goto L_0x053d
            r6.createNode(r0)
            goto L_0x0540
        L_0x053d:
            r6.useNode()
        L_0x0540:
            r6.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m2865constructorimpl(r6)
            r64 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r67 = androidx.compose.ui.node.ComposeUiNode.Companion
            r68 = r0
            kotlin.jvm.functions.Function2 r0 = r67.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r12, r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r12, r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r12, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r12, r7, r0)
            r6.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r12 = r10 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r5.invoke(r0, r6, r12)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r0)
            int r0 = r10 >> 9
            r12 = r0 & 14
            r0 = r6
            r36 = 0
            r64 = r1
            r1 = 276693704(0x107e02c8, float:5.009481E-29)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r1, r3)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r3 = r9 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r52 = r3 | 6
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r3 = r0
            r67 = r1
            r69 = 0
            r1 = 1247374525(0x4a596cbd, float:3562287.2)
            r73 = r0
            java.lang.String r0 = "C1171@48660L41,1172@48718L326:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r0)
            androidx.compose.material3.CalendarModel r0 = r84.getCalendarModel()
            int r1 = r32 >> 9
            r1 = r1 & 14
            r74 = r9
            r9 = r87
            WeekDays(r9, r0, r3, r1)
            int r0 = r32 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            int r1 = r32 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r32 << 6
            r75 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r75
            r0 = r0 | r1
            int r1 = r32 << 6
            r75 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r75
            r75 = r0 | r1
            r82 = r49
            r49 = r40
            r40 = r57
            r57 = r82
            r83 = r73
            r73 = r61
            r61 = r68
            r68 = r83
            r0 = r16
            r1 = r84
            r76 = r2
            r2 = r40
            r77 = r3
            r3 = r85
            r78 = r4
            r4 = r86
            r79 = r5
            r5 = r87
            r80 = r58
            r58 = r88
            r88 = r6
            r6 = r77
            r81 = r7
            r82 = r44
            r44 = r17
            r17 = r82
            r7 = r75
            HorizontalMonthsList(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r77)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r68)
            r88.endReplaceableGroup()
            r88.endNode()
            r88.endReplaceableGroup()
            r88.endReplaceableGroup()
            boolean r61 = DatePickerContent$lambda$5(r17)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r62 = androidx.compose.ui.draw.ClipKt.clipToBounds(r0)
            r4 = 15
            r5 = 0
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            androidx.compose.animation.EnterTransition r0 = androidx.compose.animation.EnterExitTransitionKt.expandVertically$default(r0, r1, r2, r3, r4, r5)
            r1 = 1058642330(0x3f19999a, float:0.6)
            r2 = 1
            r3 = 0
            androidx.compose.animation.EnterTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r3, r1, r2, r3)
            androidx.compose.animation.EnterTransition r63 = r0.plus(r1)
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            androidx.compose.animation.ExitTransition r0 = androidx.compose.animation.EnterExitTransitionKt.shrinkVertically$default(r0, r1, r2, r3, r4, r5)
            r1 = 3
            r2 = 0
            r3 = 0
            androidx.compose.animation.ExitTransition r1 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r3, r2, r1, r3)
            androidx.compose.animation.ExitTransition r64 = r0.plus(r1)
            androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2 r7 = new androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2
            r0 = r7
            r1 = r87
            r2 = r84
            r3 = r32
            r4 = r13
            r5 = r17
            r6 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 760161496(0x2d4f24d8, float:1.1774769E-11)
            r1 = 1
            r2 = r88
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r1, r7)
            r66 = r0
            kotlin.jvm.functions.Function3 r66 = (kotlin.jvm.functions.Function3) r66
            r65 = 0
            r68 = 200112(0x30db0, float:2.80417E-40)
            r69 = 16
            r67 = r2
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r61, (androidx.compose.ui.Modifier) r62, (androidx.compose.animation.EnterTransition) r63, (androidx.compose.animation.ExitTransition) r64, (java.lang.String) r65, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r66, (androidx.compose.runtime.Composer) r67, (int) r68, (int) r69)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r73)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r56.endReplaceableGroup()
            r56.endNode()
            r56.endReplaceableGroup()
            r56.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06ca
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06ca:
            androidx.compose.runtime.ScopeUpdateScope r6 = r56.endRestartGroup()
            if (r6 != 0) goto L_0x06d1
            goto L_0x06e6
        L_0x06d1:
            androidx.compose.material3.DatePickerKt$DatePickerContent$2 r7 = new androidx.compose.material3.DatePickerKt$DatePickerContent$2
            r0 = r7
            r1 = r84
            r2 = r85
            r3 = r86
            r4 = r87
            r5 = r89
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x06e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePickerContent(androidx.compose.material3.StateData, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$5(MutableState<Boolean> $yearPickerVisible$delegate) {
        return ((Boolean) $yearPickerVisible$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void DatePickerContent$lambda$6(MutableState<Boolean> $yearPickerVisible$delegate, boolean value) {
        $yearPickerVisible$delegate.setValue(Boolean.valueOf(value));
    }

    /* renamed from: DatePickerHeader-pc5RIQQ  reason: not valid java name */
    public static final void m1710DatePickerHeaderpc5RIQQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, long titleContentColor, long headlineContentColor, float minHeight, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Modifier heightModifier;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function2 = title;
        float f = minHeight;
        Function2<? super Composer, ? super Integer, Unit> function22 = content;
        int i = $changed;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer $composer2 = $composer.startRestartGroup(-996037719);
        ComposerKt.sourceInformation($composer2, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1243@51983L784:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(titleContentColor) ? 256 : 128;
        } else {
            long j = titleContentColor;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed(headlineContentColor) ? 2048 : 1024;
        } else {
            long j2 = headlineContentColor;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer2.changed(f) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, $dirty2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1228)");
            }
            if (function2 != null) {
                heightModifier = SizeKt.m597defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f, 1, (Object) null);
            } else {
                heightModifier = Modifier.Companion;
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null).then(heightModifier);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Modifier modifier3 = heightModifier;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            Arrangement.Vertical vertical = verticalArrangement$iv;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
            Modifier modifier4 = modifier$iv;
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
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer2;
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Density density = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & 112) | 6;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1127524835, "C1262@52647L114:DatePicker.kt#uh7d8r");
            $composer3.startReplaceableGroup(1127524835);
            ComposerKt.sourceInformation($composer3, "1250@52175L453");
            if (function2 != null) {
                MeasurePolicy measurePolicy = measurePolicy$iv;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(titleContentColor))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, 1005061498, true, new DatePickerKt$DatePickerHeader$1$1(function2, $dirty2)), $composer3, 56);
            }
            $composer3.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(headlineContentColor))}, function22, $composer3, (($dirty2 >> 12) & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
        if (endRestartGroup == null) {
            int i4 = $dirty2;
            return;
        }
        int i5 = $dirty2;
        endRestartGroup.updateScope(new DatePickerKt$DatePickerHeader$2(modifier, title, titleContentColor, headlineContentColor, minHeight, content, $changed));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: androidx.compose.material3.CalendarMonth} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: kotlin.jvm.functions.Function2} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HorizontalMonthsList(kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r30, androidx.compose.material3.StateData r31, androidx.compose.foundation.lazy.LazyListState r32, androidx.compose.material3.DatePickerFormatter r33, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r34, androidx.compose.material3.DatePickerColors r35, androidx.compose.runtime.Composer r36, int r37) {
        /*
            r9 = r31
            r15 = r32
            r14 = r37
            r0 = 1933363608(0x733cc998, float:1.4957285E31)
            r1 = r36
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(HorizontalMonthsList)P(4,5,3,1,2)1282@53204L168,1298@53968L40,1299@54015L738,1288@53377L1376,1323@54789L62,1323@54759L92:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r37
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0027
            r12 = r30
            boolean r2 = r13.changedInstance(r12)
            if (r2 == 0) goto L_0x0024
            r2 = 4
            goto L_0x0025
        L_0x0024:
            r2 = 2
        L_0x0025:
            r1 = r1 | r2
            goto L_0x0029
        L_0x0027:
            r12 = r30
        L_0x0029:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0039
            boolean r2 = r13.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0036
            r2 = 32
            goto L_0x0038
        L_0x0036:
            r2 = 16
        L_0x0038:
            r1 = r1 | r2
        L_0x0039:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0049
            boolean r2 = r13.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0046
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r1 = r1 | r2
        L_0x0049:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x005c
            r11 = r33
            boolean r2 = r13.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0058
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005a
        L_0x0058:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005a:
            r1 = r1 | r2
            goto L_0x005e
        L_0x005c:
            r11 = r33
        L_0x005e:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x0073
            r10 = r34
            boolean r2 = r13.changedInstance(r10)
            if (r2 == 0) goto L_0x006f
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0071
        L_0x006f:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0071:
            r1 = r1 | r2
            goto L_0x0075
        L_0x0073:
            r10 = r34
        L_0x0075:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x0089
            r8 = r35
            boolean r2 = r13.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0085
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0087
        L_0x0085:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0087:
            r1 = r1 | r2
            goto L_0x008b
        L_0x0089:
            r8 = r35
        L_0x008b:
            r7 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r7
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x00a5
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x009c
            goto L_0x00a5
        L_0x009c:
            r13.skipToGroupEnd()
            r29 = r7
            r8 = r13
            r7 = r15
            goto L_0x0235
        L_0x00a5:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b1
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1273)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
        L_0x00b1:
            androidx.compose.material3.CalendarModel r0 = r31.getCalendarModel()
            androidx.compose.material3.CalendarDate r22 = r0.getToday()
            kotlin.ranges.IntRange r0 = r31.getYearRange()
            r1 = 8
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r3)
            java.lang.String r6 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            boolean r3 = r13.changed((java.lang.Object) r0)
            r4 = r13
            r5 = 0
            r36 = r0
            java.lang.Object r0 = r4.rememberedValue()
            r16 = 0
            r17 = r1
            if (r3 != 0) goto L_0x00eb
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x00e6
            goto L_0x00eb
        L_0x00e6:
            r18 = r0
            r20 = r2
            goto L_0x0109
        L_0x00eb:
            r1 = 0
            r18 = r0
            androidx.compose.material3.CalendarModel r0 = r31.getCalendarModel()
            kotlin.ranges.IntRange r20 = r31.getYearRange()
            r21 = r1
            int r1 = r20.getFirst()
            r20 = r2
            r2 = 1
            androidx.compose.material3.CalendarMonth r0 = r0.getMonth(r1, r2)
            r4.updateRememberedValue(r0)
        L_0x0109:
            r13.endReplaceableGroup()
            r23 = r0
            androidx.compose.material3.CalendarMonth r23 = (androidx.compose.material3.CalendarMonth) r23
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1 r1 = androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5 = 0
            r4 = 0
            r2 = 1
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r5, r1, r2, r4)
            androidx.compose.material3.DatePickerDefaults r0 = androidx.compose.material3.DatePickerDefaults.INSTANCE
            int r1 = r7 >> 6
            r1 = r1 & 14
            r3 = r1 | 384(0x180, float:5.38E-43)
            r17 = 2
            r2 = 0
            r1 = r32
            r18 = r3
            r3 = r13
            r4 = r18
            r18 = r5
            r5 = r17
            androidx.compose.foundation.gestures.FlingBehavior r17 = r0.rememberSnapFlingBehavior$material3_release(r1, r2, r3, r4, r5)
            r0 = r31
            r1 = r23
            r2 = r30
            r3 = r22
            r4 = r34
            r5 = r33
            r36 = r7
            r7 = r6
            r6 = r35
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1, r2, r3, r4, r5, r6}
            r19 = 8
            r6 = r0
            r20 = 0
            r0 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r13.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            r0 = 0
            int r1 = r6.length
            r5 = r18
            r18 = r0
        L_0x0165:
            if (r5 >= r1) goto L_0x0172
            r0 = r6[r5]
            boolean r2 = r13.changed((java.lang.Object) r0)
            r18 = r18 | r2
            int r5 = r5 + 1
            goto L_0x0165
        L_0x0172:
            r7 = r13
            r21 = 0
            java.lang.Object r5 = r7.rememberedValue()
            r24 = 0
            if (r18 != 0) goto L_0x018e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r5 != r0) goto L_0x0186
            goto L_0x018e
        L_0x0186:
            r29 = r36
            r27 = r5
            r28 = r6
            r10 = r7
            goto L_0x01b6
        L_0x018e:
            r25 = 0
            androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1 r26 = new androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1
            r0 = r26
            r1 = r31
            r2 = r23
            r3 = r30
            r4 = r22
            r27 = r5
            r5 = r34
            r28 = r6
            r6 = r33
            r29 = r36
            r10 = r7
            r7 = r35
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function1 r26 = (kotlin.jvm.functions.Function1) r26
            r5 = r26
            r10.updateRememberedValue(r5)
        L_0x01b6:
            r13.endReplaceableGroup()
            r18 = r5
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            int r0 = r29 >> 3
            r20 = r0 & 112(0x70, float:1.57E-43)
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r21 = 188(0xbc, float:2.63E-43)
            r10 = r16
            r11 = r32
            r12 = r0
            r8 = r13
            r13 = r1
            r14 = r2
            r7 = r15
            r15 = r3
            r16 = r17
            r17 = r4
            r19 = r8
            androidx.compose.foundation.lazy.LazyDslKt.LazyRow(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            int r0 = r29 >> 6
            r0 = r0 & 14
            r1 = r29 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            boolean r2 = r8.changed((java.lang.Object) r7)
            boolean r3 = r8.changed((java.lang.Object) r9)
            r2 = r2 | r3
            r3 = r8
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x020e
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r5 != r10) goto L_0x020c
            goto L_0x020e
        L_0x020c:
            r10 = r5
            goto L_0x021c
        L_0x020e:
            r10 = 0
            androidx.compose.material3.DatePickerKt$HorizontalMonthsList$3$1 r11 = new androidx.compose.material3.DatePickerKt$HorizontalMonthsList$3$1
            r12 = 0
            r11.<init>(r7, r9, r12)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10 = r11
            r3.updateRememberedValue(r10)
        L_0x021c:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            int r0 = r29 >> 6
            r0 = r0 & 14
            r0 = r0 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r10, (androidx.compose.runtime.Composer) r8, (int) r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0235
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0235:
            androidx.compose.runtime.ScopeUpdateScope r10 = r8.endRestartGroup()
            if (r10 != 0) goto L_0x023c
            goto L_0x0255
        L_0x023c:
            androidx.compose.material3.DatePickerKt$HorizontalMonthsList$4 r11 = new androidx.compose.material3.DatePickerKt$HorizontalMonthsList$4
            r0 = r11
            r1 = r30
            r2 = r31
            r3 = r32
            r4 = r33
            r5 = r34
            r6 = r35
            r7 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0255:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.HorizontalMonthsList(kotlin.jvm.functions.Function1, androidx.compose.material3.StateData, androidx.compose.foundation.lazy.LazyListState, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    public static final Object updateDisplayedMonth(LazyListState lazyListState, StateData stateData, Continuation<? super Unit> $completion) {
        Object collect = SnapshotStateKt.snapshotFlow(new DatePickerKt$updateDisplayedMonth$2(lazyListState)).collect(new DatePickerKt$updateDisplayedMonth$3(lazyListState, stateData), $completion);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final void WeekDays(DatePickerColors colors, CalendarModel calendarModel, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(calendarModel, "calendarModel");
        Composer $composer2 = $composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation($composer2, "C(WeekDays)P(1)1365@56132L1363:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) calendarModel) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, $changed, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1354)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List weekdays = calendarModel.getWeekdayNames();
            ArrayList dayNames = new ArrayList();
            int size = weekdays.size();
            for (int i = firstDayOfWeek - 1; i < size; i++) {
                dayNames.add(weekdays.get(i));
            }
            int i2 = firstDayOfWeek - 1;
            for (int i3 = 0; i3 < i2; i3++) {
                dayNames.add(weekdays.get(i3));
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(colors.m1705getWeekdayContentColor0d7_KjU$material3_release()))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1445541615, true, new DatePickerKt$WeekDays$1(dayNames)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$WeekDays$2(colors, calendarModel, $changed));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: androidx.compose.runtime.State} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x020f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Month(androidx.compose.material3.CalendarMonth r21, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r22, androidx.compose.material3.CalendarDate r23, androidx.compose.material3.StateData r24, boolean r25, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r26, androidx.compose.material3.DatePickerFormatter r27, androidx.compose.material3.DatePickerColors r28, androidx.compose.runtime.Composer r29, int r30) {
        /*
            r14 = r21
            r15 = r22
            r13 = r23
            r12 = r24
            r11 = r25
            r10 = r26
            r9 = r27
            r8 = r28
            r7 = r30
            java.lang.String r0 = "month"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "onDateSelected"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "today"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "stateData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "dateValidator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "dateFormatter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -1561090804(0xffffffffa2f3a50c, float:-6.6040032E-18)
            r1 = r29
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Month)P(3,4,7,6,5,2,1)1414@57986L377,1439@58703L15,1443@58865L10,1442@58825L5037:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r30
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0057
            boolean r2 = r6.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0055
            r2 = 4
            goto L_0x0056
        L_0x0055:
            r2 = 2
        L_0x0056:
            r1 = r1 | r2
        L_0x0057:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0067
            boolean r2 = r6.changedInstance(r15)
            if (r2 == 0) goto L_0x0064
            r2 = 32
            goto L_0x0066
        L_0x0064:
            r2 = 16
        L_0x0066:
            r1 = r1 | r2
        L_0x0067:
            r2 = r7 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0077
            boolean r2 = r6.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0074
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0076
        L_0x0074:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0076:
            r1 = r1 | r2
        L_0x0077:
            r2 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0087
            boolean r2 = r6.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0084
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r1 = r1 | r2
        L_0x0087:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x0099
            boolean r2 = r6.changed((boolean) r11)
            if (r2 == 0) goto L_0x0096
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r2
        L_0x0099:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x00aa
            boolean r2 = r6.changedInstance(r10)
            if (r2 == 0) goto L_0x00a7
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a9
        L_0x00a7:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x00a9:
            r1 = r1 | r2
        L_0x00aa:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x00bb
            boolean r2 = r6.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x00b8
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ba
        L_0x00b8:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x00ba:
            r1 = r1 | r2
        L_0x00bb:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x00cc
            boolean r2 = r6.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x00c9
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00cb
        L_0x00c9:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00cb:
            r1 = r1 | r2
        L_0x00cc:
            r5 = r1
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r5
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r2) goto L_0x00e5
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x00dd
            goto L_0x00e5
        L_0x00dd:
            r6.skipToGroupEnd()
            r20 = r5
            r15 = r6
            goto L_0x0212
        L_0x00e5:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00f1
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.Month (DatePicker.kt:1404)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r1, r2)
        L_0x00f1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r25)
            int r1 = r5 >> 12
            r1 = r1 & 14
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            boolean r3 = r6.changed((java.lang.Object) r0)
            r4 = r6
            r16 = 0
            r29 = r0
            java.lang.Object r0 = r4.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x0125
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0122
            goto L_0x0127
        L_0x0122:
            r18 = r0
            goto L_0x013a
        L_0x0125:
            r19 = r1
        L_0x0127:
            r1 = 0
            r18 = r0
            androidx.compose.material3.DatePickerKt$Month$rangeSelectionInfo$1$1 r0 = new androidx.compose.material3.DatePickerKt$Month$rangeSelectionInfo$1$1
            r0.<init>(r11, r14, r12)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r4.updateRememberedValue(r0)
        L_0x013a:
            r6.endReplaceableGroup()
            r4 = r0
            androidx.compose.runtime.State r4 = (androidx.compose.runtime.State) r4
            r0 = -2019479227(0xffffffff87a13145, float:-2.4253546E-34)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "1429@58464L177"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            if (r11 == 0) goto L_0x01ab
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            int r1 = r5 >> 18
            r1 = r1 & 112(0x70, float:1.57E-43)
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            boolean r3 = r6.changed((java.lang.Object) r4)
            boolean r16 = r6.changed((java.lang.Object) r8)
            r3 = r3 | r16
            r29 = r6
            r16 = 0
            r17 = r1
            java.lang.Object r1 = r29.rememberedValue()
            r18 = 0
            if (r3 != 0) goto L_0x018b
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r1 != r2) goto L_0x0186
            goto L_0x018d
        L_0x0186:
            r2 = r29
            r19 = r1
            goto L_0x019e
        L_0x018b:
            r20 = r2
        L_0x018d:
            r2 = 0
            r19 = r1
            androidx.compose.material3.DatePickerKt$Month$rangeSelectionDrawModifier$1$1 r1 = new androidx.compose.material3.DatePickerKt$Month$rangeSelectionDrawModifier$1$1
            r1.<init>(r4, r8)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = r29
            r2.updateRememberedValue(r1)
        L_0x019e:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.DrawModifierKt.drawWithContent(r0, r1)
            r1 = r0
            goto L_0x01b0
        L_0x01ab:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = r0
        L_0x01b0:
            r6.endReplaceableGroup()
            r0 = 0
            java.util.Locale r16 = androidx.compose.material3.CalendarModel_androidKt.defaultLocale(r6, r0)
            androidx.compose.runtime.MutableState r17 = r24.getSelectedStartDate()
            androidx.compose.runtime.MutableState r18 = r24.getSelectedEndDate()
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r6, r2)
            androidx.compose.material3.tokens.DatePickerModalTokens r2 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getDateLabelTextFont()
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.material3.TypographyKt.fromToken(r0, r2)
            androidx.compose.material3.DatePickerKt$Month$1 r2 = new androidx.compose.material3.DatePickerKt$Month$1
            r0 = r2
            r14 = r2
            r2 = r21
            r15 = r3
            r3 = r23
            r19 = r4
            r4 = r17
            r20 = r5
            r5 = r18
            r29 = r15
            r15 = r6
            r6 = r25
            r7 = r20
            r8 = r27
            r9 = r16
            r10 = r22
            r11 = r28
            r12 = r24
            r13 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = -1776200645(0xffffffff9621543b, float:-1.3032055E-25)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r2 = 48
            r3 = r29
            androidx.compose.material3.TextKt.ProvideTextStyle(r3, r0, r15, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0212
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0212:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 != 0) goto L_0x0219
            goto L_0x0236
        L_0x0219:
            androidx.compose.material3.DatePickerKt$Month$2 r11 = new androidx.compose.material3.DatePickerKt$Month$2
            r0 = r11
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0236:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Month(androidx.compose.material3.CalendarMonth, kotlin.jvm.functions.Function1, androidx.compose.material3.CalendarDate, androidx.compose.material3.StateData, boolean, kotlin.jvm.functions.Function1, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final String dayContentDescription(boolean rangeSelectionEnabled, boolean isToday, boolean isStartDate, boolean isEndDate, boolean isInRange, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(502032503);
        ComposerKt.sourceInformation($composer, "C(dayContentDescription)P(4,3,2)1563@64712L54:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, $changed, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1538)");
        }
        StringBuilder descriptionBuilder = new StringBuilder();
        $composer.startReplaceableGroup(-852204210);
        ComposerKt.sourceInformation($composer, "");
        if (rangeSelectionEnabled) {
            if (isStartDate) {
                $composer.startReplaceableGroup(-852204120);
                ComposerKt.sourceInformation($composer, "1549@64220L56");
                descriptionBuilder.append(Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2026getDateRangePickerStartHeadlineadMyvUU(), $composer, 6));
                $composer.endReplaceableGroup();
            } else if (isEndDate) {
                $composer.startReplaceableGroup(-852203980);
                ComposerKt.sourceInformation($composer, "1553@64360L54");
                descriptionBuilder.append(Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2023getDateRangePickerEndHeadlineadMyvUU(), $composer, 6));
                $composer.endReplaceableGroup();
            } else if (isInRange) {
                $composer.startReplaceableGroup(-852203842);
                ComposerKt.sourceInformation($composer, "1557@64498L53");
                descriptionBuilder.append(Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2022getDateRangePickerDayInRangeadMyvUU(), $composer, 6));
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(-852203741);
                $composer.endReplaceableGroup();
            }
        }
        $composer.endReplaceableGroup();
        boolean z = true;
        if (isToday) {
            if (descriptionBuilder.length() > 0) {
                descriptionBuilder.append(", ");
            }
            descriptionBuilder.append(Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2018getDatePickerTodayDescriptionadMyvUU(), $composer, 6));
        }
        if (descriptionBuilder.length() != 0) {
            z = false;
        }
        String sb = z ? null : descriptionBuilder.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sb;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0245  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Day(androidx.compose.ui.Modifier r27, boolean r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, boolean r30, boolean r31, boolean r32, boolean r33, java.lang.String r34, androidx.compose.material3.DatePickerColors r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38) {
        /*
            r14 = r28
            r11 = r32
            r7 = r34
            r8 = r36
            r12 = r38
            r0 = -1434777861(0xffffffffaa7b06fb, float:-2.22957E-13)
            r1 = r37
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Day)P(6,8,7!1,4,9,5,3)1594@65783L102,1599@65971L9,1600@66005L129,1605@66172L150,1582@65195L1472:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r38
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002b
            r9 = r27
            boolean r2 = r10.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r1 = r1 | r2
            goto L_0x002d
        L_0x002b:
            r9 = r27
        L_0x002d:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003d
            boolean r2 = r10.changed((boolean) r14)
            if (r2 == 0) goto L_0x003a
            r2 = 32
            goto L_0x003c
        L_0x003a:
            r2 = 16
        L_0x003c:
            r1 = r1 | r2
        L_0x003d:
            r2 = r12 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0050
            r15 = r29
            boolean r2 = r10.changedInstance(r15)
            if (r2 == 0) goto L_0x004c
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004e
        L_0x004c:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004e:
            r1 = r1 | r2
            goto L_0x0052
        L_0x0050:
            r15 = r29
        L_0x0052:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0065
            r13 = r30
            boolean r2 = r10.changed((boolean) r13)
            if (r2 == 0) goto L_0x0061
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0063
        L_0x0061:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0063:
            r1 = r1 | r2
            goto L_0x0067
        L_0x0065:
            r13 = r30
        L_0x0067:
            r6 = 57344(0xe000, float:8.0356E-41)
            r2 = r12 & r6
            if (r2 != 0) goto L_0x007d
            r5 = r31
            boolean r2 = r10.changed((boolean) r5)
            if (r2 == 0) goto L_0x0079
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007b
        L_0x0079:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x007b:
            r1 = r1 | r2
            goto L_0x007f
        L_0x007d:
            r5 = r31
        L_0x007f:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x0090
            boolean r2 = r10.changed((boolean) r11)
            if (r2 == 0) goto L_0x008d
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x008f
        L_0x008d:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x008f:
            r1 = r1 | r2
        L_0x0090:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00a4
            r4 = r33
            boolean r2 = r10.changed((boolean) r4)
            if (r2 == 0) goto L_0x00a0
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00a2
        L_0x00a0:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x00a2:
            r1 = r1 | r2
            goto L_0x00a6
        L_0x00a4:
            r4 = r33
        L_0x00a6:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00b7
            boolean r2 = r10.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x00b4
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b6
        L_0x00b4:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b6:
            r1 = r1 | r2
        L_0x00b7:
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00cb
            r3 = r35
            boolean r2 = r10.changed((java.lang.Object) r3)
            if (r2 == 0) goto L_0x00c7
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00c9
        L_0x00c7:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00c9:
            r1 = r1 | r2
            goto L_0x00cd
        L_0x00cb:
            r3 = r35
        L_0x00cd:
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00de
            boolean r2 = r10.changedInstance(r8)
            if (r2 == 0) goto L_0x00db
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00dd
        L_0x00db:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00dd:
            r1 = r1 | r2
        L_0x00de:
            r2 = r1
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r2
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r6) goto L_0x00f8
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x00ef
            goto L_0x00f8
        L_0x00ef:
            r10.skipToGroupEnd()
            r26 = r2
            r25 = r10
            goto L_0x0248
        L_0x00f8:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0104
            r1 = -1
            java.lang.String r6 = "androidx.compose.material3.Day (DatePicker.kt:1570)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r6)
        L_0x0104:
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r27)
            androidx.compose.material3.tokens.DatePickerModalTokens r1 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r1 = r1.m2389getDateStateLayerWidthD9Ej5fM()
            androidx.compose.material3.tokens.DatePickerModalTokens r6 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r6 = r6.m2388getDateStateLayerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m606requiredSizeVpY3zN4(r0, r1, r6)
            int r1 = r2 >> 21
            r1 = r1 & 14
            r6 = 0
            r16 = r1
            r1 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r7)
            r17 = r10
            r18 = 0
            java.lang.Object r3 = r17.rememberedValue()
            r19 = 0
            if (r1 != 0) goto L_0x014e
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r3 != r1) goto L_0x0148
            goto L_0x0150
        L_0x0148:
            r1 = r3
            r20 = r1
            r3 = r17
            goto L_0x0163
        L_0x014e:
            r21 = r1
        L_0x0150:
            r1 = 0
            r20 = r1
            androidx.compose.material3.DatePickerKt$Day$1$1 r1 = new androidx.compose.material3.DatePickerKt$Day$1$1
            r1.<init>(r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r20 = r3
            r3 = r17
            r3.updateRememberedValue(r1)
        L_0x0163:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6 = 1
            androidx.compose.ui.Modifier r18 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r0, r6, r1)
            androidx.compose.material3.tokens.DatePickerModalTokens r0 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r0 = r0.getDateContainerShape()
            r1 = 6
            androidx.compose.ui.graphics.Shape r19 = androidx.compose.material3.ShapesKt.toShape(r0, r10, r1)
            int r0 = r2 >> 3
            r0 = r0 & 14
            int r1 = r2 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r2 >> 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r2 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r16 = r0 | r1
            r0 = r35
            r1 = r28
            r3 = r2
            r2 = r31
            r12 = r3
            r3 = r30
            r4 = r10
            r5 = r16
            androidx.compose.runtime.State r0 = r0.dayContainerColor$material3_release(r1, r2, r3, r4, r5)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r20 = r0.m3263unboximpl()
            int r0 = r12 >> 15
            r0 = r0 & 14
            r1 = r12 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r12 >> 12
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r12 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r12 >> 12
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r16 = r0 | r1
            r0 = r35
            r1 = r32
            r2 = r28
            r3 = r33
            r4 = r31
            r5 = r10
            r7 = r6
            r6 = r16
            androidx.compose.runtime.State r0 = r0.dayContentColor$material3_release(r1, r2, r3, r4, r5, r6)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r22 = r0.m3263unboximpl()
            if (r11 == 0) goto L_0x01fb
            if (r14 != 0) goto L_0x01fb
            androidx.compose.material3.tokens.DatePickerModalTokens r0 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            float r0 = r0.m2390getDateTodayContainerOutlineWidthD9Ej5fM()
            long r1 = r35.m1704getTodayDateBorderColor0d7_KjU$material3_release()
            androidx.compose.foundation.BorderStroke r0 = androidx.compose.foundation.BorderStrokeKt.m194BorderStrokecXLIe8U(r0, r1)
            r24 = r0
            goto L_0x01fe
        L_0x01fb:
            r0 = 0
            r24 = r0
        L_0x01fe:
            androidx.compose.material3.DatePickerKt$Day$2 r0 = new androidx.compose.material3.DatePickerKt$Day$2
            r0.<init>(r8, r12)
            r1 = -2031780827(0xffffffff86e57c25, float:-8.632264E-35)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r1, r7, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13 = r0
            int r0 = r12 >> 3
            r0 = r0 & 14
            int r1 = r12 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r12 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r15 = r0
            r0 = 0
            r9 = r0
            r25 = r10
            r10 = r0
            r0 = 0
            r26 = r12
            r12 = r0
            r16 = 48
            r17 = 1408(0x580, float:1.973E-42)
            r0 = r28
            r1 = r29
            r2 = r18
            r3 = r31
            r4 = r19
            r5 = r20
            r7 = r22
            r11 = r24
            r14 = r25
            androidx.compose.material3.SurfaceKt.m2063Surfaced85dljk((boolean) r0, (kotlin.jvm.functions.Function0<kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (androidx.compose.ui.graphics.Shape) r4, (long) r5, (long) r7, (float) r9, (float) r10, (androidx.compose.foundation.BorderStroke) r11, (androidx.compose.foundation.interaction.MutableInteractionSource) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16, (int) r17)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0248
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0248:
            androidx.compose.runtime.ScopeUpdateScope r12 = r25.endRestartGroup()
            if (r12 != 0) goto L_0x024f
            goto L_0x0270
        L_0x024f:
            androidx.compose.material3.DatePickerKt$Day$3 r13 = new androidx.compose.material3.DatePickerKt$Day$3
            r0 = r13
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = r36
            r11 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0270:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Day(androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, boolean, boolean, boolean, boolean, java.lang.String, androidx.compose.material3.DatePickerColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void YearPicker(Modifier modifier, Function1<? super Integer, Unit> onYearSelected, DatePickerColors colors, StateData stateData, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1038904873);
        ComposerKt.sourceInformation($composer2, "C(YearPicker)P(1,2)1635@66923L10,1634@66875L4042:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(onYearSelected) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed((Object) stateData) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1038904873, $dirty, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1628)");
            }
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont()), ComposableLambdaKt.composableLambda($composer2, -145469688, true, new DatePickerKt$YearPicker$1(stateData, colors, modifier, onYearSelected, $dirty)), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerKt$YearPicker$2(modifier, onYearSelected, colors, stateData, $changed));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Year(androidx.compose.ui.Modifier r28, boolean r29, boolean r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, java.lang.String r32, androidx.compose.material3.DatePickerColors r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36) {
        /*
            r9 = r28
            r8 = r29
            r7 = r30
            r6 = r32
            r5 = r33
            r4 = r34
            r3 = r36
            r0 = -1441573940(0xffffffffaa1353cc, float:-1.3085296E-13)
            r1 = r35
            androidx.compose.runtime.Composer r2 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Year)P(4,6,2,5,3)1725@71201L353,1742@71917L90,1746@72076L9,1747@72110L39,1748@72187L98,1736@71559L891:DatePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r36
            r10 = r3 & 14
            if (r10 != 0) goto L_0x002c
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x002a
            r10 = 4
            goto L_0x002b
        L_0x002a:
            r10 = 2
        L_0x002b:
            r1 = r1 | r10
        L_0x002c:
            r10 = r3 & 112(0x70, float:1.57E-43)
            if (r10 != 0) goto L_0x003c
            boolean r10 = r2.changed((boolean) r8)
            if (r10 == 0) goto L_0x0039
            r10 = 32
            goto L_0x003b
        L_0x0039:
            r10 = 16
        L_0x003b:
            r1 = r1 | r10
        L_0x003c:
            r10 = r3 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x004c
            boolean r10 = r2.changed((boolean) r7)
            if (r10 == 0) goto L_0x0049
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x004b
        L_0x0049:
            r10 = 128(0x80, float:1.794E-43)
        L_0x004b:
            r1 = r1 | r10
        L_0x004c:
            r10 = r3 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x005f
            r11 = r31
            boolean r10 = r2.changedInstance(r11)
            if (r10 == 0) goto L_0x005b
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x005d
        L_0x005b:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x005d:
            r1 = r1 | r10
            goto L_0x0061
        L_0x005f:
            r11 = r31
        L_0x0061:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r3
            if (r10 != 0) goto L_0x0073
            boolean r10 = r2.changed((java.lang.Object) r6)
            if (r10 == 0) goto L_0x0070
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0072
        L_0x0070:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0072:
            r1 = r1 | r10
        L_0x0073:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r3
            if (r10 != 0) goto L_0x0084
            boolean r10 = r2.changed((java.lang.Object) r5)
            if (r10 == 0) goto L_0x0081
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0083
        L_0x0081:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x0083:
            r1 = r1 | r10
        L_0x0084:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r3
            if (r10 != 0) goto L_0x0095
            boolean r10 = r2.changedInstance(r4)
            if (r10 == 0) goto L_0x0092
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0094
        L_0x0092:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x0094:
            r1 = r1 | r10
        L_0x0095:
            r10 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r10 & r1
            r12 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r12) goto L_0x00aa
            boolean r10 = r2.getSkipping()
            if (r10 != 0) goto L_0x00a5
            goto L_0x00aa
        L_0x00a5:
            r2.skipToGroupEnd()
            goto L_0x01e1
        L_0x00aa:
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00b6
            r10 = -1
            java.lang.String r12 = "androidx.compose.material3.Year (DatePicker.kt:1716)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r10, r12)
        L_0x00b6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r30)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r29)
            int r12 = r1 >> 6
            r12 = r12 & 14
            r13 = r1 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            r13 = 0
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r2.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            boolean r14 = r2.changed((java.lang.Object) r0)
            boolean r15 = r2.changed((java.lang.Object) r10)
            r14 = r14 | r15
            r15 = r2
            r16 = 0
            r35 = r0
            java.lang.Object r0 = r15.rememberedValue()
            r17 = 0
            if (r14 != 0) goto L_0x00f6
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r0 != r3) goto L_0x00f1
            goto L_0x00f6
        L_0x00f1:
            r19 = r0
            r18 = r10
            goto L_0x0119
        L_0x00f6:
            r3 = 0
            if (r7 == 0) goto L_0x010e
            if (r8 != 0) goto L_0x010e
            androidx.compose.material3.tokens.DatePickerModalTokens r18 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            r19 = r0
            float r0 = r18.m2390getDateTodayContainerOutlineWidthD9Ej5fM()
            r18 = r10
            long r10 = r33.m1704getTodayDateBorderColor0d7_KjU$material3_release()
            androidx.compose.foundation.BorderStroke r0 = androidx.compose.foundation.BorderStrokeKt.m194BorderStrokecXLIe8U(r0, r10)
            goto L_0x0113
        L_0x010e:
            r19 = r0
            r18 = r10
            r0 = 0
        L_0x0113:
            r15.updateRememberedValue(r0)
        L_0x0119:
            r2.endReplaceableGroup()
            androidx.compose.foundation.BorderStroke r0 = (androidx.compose.foundation.BorderStroke) r0
            int r3 = r1 >> 12
            r3 = r3 & 14
            r10 = 0
            r11 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            boolean r11 = r2.changed((java.lang.Object) r6)
            r12 = r2
            r13 = 0
            java.lang.Object r14 = r12.rememberedValue()
            r15 = 0
            if (r11 != 0) goto L_0x014c
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r35 = r3
            java.lang.Object r3 = r16.getEmpty()
            if (r14 != r3) goto L_0x014a
            goto L_0x014e
        L_0x014a:
            r3 = r14
            goto L_0x015d
        L_0x014c:
            r35 = r3
        L_0x014e:
            r3 = 0
            r16 = r3
            androidx.compose.material3.DatePickerKt$Year$1$1 r3 = new androidx.compose.material3.DatePickerKt$Year$1$1
            r3.<init>(r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r12.updateRememberedValue(r3)
        L_0x015d:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10 = 1
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r9, r10, r3)
            androidx.compose.material3.tokens.DatePickerModalTokens r3 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getSelectionYearStateLayerShape()
            r11 = 6
            androidx.compose.ui.graphics.Shape r14 = androidx.compose.material3.ShapesKt.toShape(r3, r2, r11)
            int r3 = r1 >> 3
            r3 = r3 & 14
            int r11 = r1 >> 12
            r11 = r11 & 112(0x70, float:1.57E-43)
            r3 = r3 | r11
            androidx.compose.runtime.State r3 = r5.yearContainerColor$material3_release(r8, r2, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r15 = r3.m3263unboximpl()
            int r3 = r1 >> 6
            r3 = r3 & 14
            r11 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 | r11
            int r11 = r1 >> 9
            r11 = r11 & 896(0x380, float:1.256E-42)
            r3 = r3 | r11
            androidx.compose.runtime.State r3 = r5.yearContentColor$material3_release(r7, r8, r2, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r17 = r3.m3263unboximpl()
            androidx.compose.material3.DatePickerKt$Year$2 r3 = new androidx.compose.material3.DatePickerKt$Year$2
            r3.<init>(r4, r1)
            r11 = -68753950(0xfffffffffbe6e5e2, float:-2.3977817E36)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r11, r10, r3)
            r23 = r3
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            int r3 = r1 >> 3
            r3 = r3 & 14
            int r10 = r1 >> 6
            r10 = r10 & 112(0x70, float:1.57E-43)
            r25 = r3 | r10
            r13 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r26 = 48
            r27 = 1416(0x588, float:1.984E-42)
            r10 = r29
            r11 = r31
            r21 = r0
            r24 = r2
            androidx.compose.material3.SurfaceKt.m2063Surfaced85dljk((boolean) r10, (kotlin.jvm.functions.Function0<kotlin.Unit>) r11, (androidx.compose.ui.Modifier) r12, (boolean) r13, (androidx.compose.ui.graphics.Shape) r14, (long) r15, (long) r17, (float) r19, (float) r20, (androidx.compose.foundation.BorderStroke) r21, (androidx.compose.foundation.interaction.MutableInteractionSource) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e1:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 != 0) goto L_0x01ea
            r12 = r1
            r13 = r2
            goto L_0x0207
        L_0x01ea:
            androidx.compose.material3.DatePickerKt$Year$3 r11 = new androidx.compose.material3.DatePickerKt$Year$3
            r0 = r11
            r12 = r1
            r1 = r28
            r13 = r2
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r33
            r7 = r34
            r8 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0207:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Year(androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.material3.DatePickerColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void MonthsNavigation(Modifier modifier, boolean nextAvailable, boolean previousAvailable, boolean yearPickerVisible, String yearPickerText, Function0<Unit> onNextClicked, Function0<Unit> onPreviousClicked, Function0<Unit> onYearPickerButtonClicked, Composer $composer, int $changed) {
        int $dirty;
        Arrangement.Horizontal horizontal;
        Function0<ComposeUiNode> function0;
        Modifier modifier2 = modifier;
        boolean z = yearPickerVisible;
        String str = yearPickerText;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1127095896);
        ComposerKt.sourceInformation($composer2, "C(MonthsNavigation)P(!2,5,7,6)1775@72887L2078:DatePicker.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 14) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty2 |= $composer2.changed(nextAvailable) ? 32 : 16;
        } else {
            boolean z2 = nextAvailable;
        }
        if ((i & 896) == 0) {
            $dirty2 |= $composer2.changed(previousAvailable) ? 256 : 128;
        } else {
            boolean z3 = previousAvailable;
        }
        if ((i & 7168) == 0) {
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            $dirty2 |= $composer2.changed((Object) str) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty2 |= $composer2.changedInstance(onNextClicked) ? 131072 : 65536;
        } else {
            Function0<Unit> function02 = onNextClicked;
        }
        if ((3670016 & i) == 0) {
            $dirty2 |= $composer2.changedInstance(onPreviousClicked) ? 1048576 : 524288;
        } else {
            Function0<Unit> function03 = onPreviousClicked;
        }
        if ((29360128 & i) == 0) {
            $dirty2 |= $composer2.changedInstance(onYearPickerButtonClicked) ? 8388608 : 4194304;
        } else {
            Function0<Unit> function04 = onYearPickerButtonClicked;
        }
        int $dirty3 = $dirty2;
        if ((23967451 & $dirty3) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1127095896, $dirty3, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:1765)");
            }
            Modifier r0 = SizeKt.m601requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), MonthYearHeight);
            if (z) {
                horizontal = Arrangement.INSTANCE.getStart();
            } else {
                horizontal = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = horizontal;
            Modifier modifier$iv = r0;
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            String str2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            Alignment.Vertical verticalAlignment$iv2 = verticalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            String str3 = "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            int $changed$iv$iv$iv = ((((384 << 3) & 112) << 9) & 7168) | 6;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            String str4 = "C:CompositionLocal.kt#9igjgp";
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Function0<ComposeUiNode> function05 = function0;
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer2);
            Arrangement.Horizontal horizontal2 = horizontalArrangement$iv;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer3 = $composer2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            int i3 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope rowScope = RowScopeInstance.INSTANCE;
            Composer composer = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1911928903, "C1787@73264L536:DatePicker.kt#uh7d8r");
            Density density = density$iv$iv;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            String str5 = str3;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Composer $composer4 = $composer3;
            String str6 = str4;
            Function0<ComposeUiNode> function06 = function05;
            Composer $composer$iv = $composer3;
            Alignment.Vertical vertical = verticalAlignment$iv2;
            int $dirty4 = $dirty3;
            String str7 = str2;
            YearPickerMenuButton(onYearPickerButtonClicked, yearPickerVisible, (Modifier) null, ComposableLambdaKt.composableLambda($composer3, -1156508456, true, new DatePickerKt$MonthsNavigation$1$1(str, $dirty3)), $composer4, (($dirty3 >> 21) & 14) | 3072 | (($dirty3 >> 6) & 112), 4);
            Composer $composer5 = $composer4;
            $composer5.startReplaceableGroup(979007906);
            ComposerKt.sourceInformation($composer5, "1801@73938L1011");
            if (!z) {
                $composer5.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer5, str5);
                Modifier modifier$iv2 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv3, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer5.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer5, str7);
                Arrangement.Horizontal horizontal3 = horizontalArrangement$iv2;
                String str8 = str6;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str8);
                Object consume4 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Density density$iv$iv2 = (Density) consume4;
                Alignment.Vertical vertical2 = verticalAlignment$iv3;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str8);
                Object consume5 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str8);
                Object consume6 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier3 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    $composer5.createNode(constructor2);
                } else {
                    $composer5.useNode();
                }
                $composer5.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer5);
                Function0<ComposeUiNode> function07 = constructor2;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer5.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer5.startReplaceableGroup(2058660585);
                int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv2 = $composer5;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                int i6 = ((0 >> 6) & 112) | 6;
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i7 = $changed$iv$iv$iv2;
                Composer $composer6 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer6, 479941280, "C1802@73991L7,1803@74038L446,1813@74501L434:DatePicker.kt#uh7d8r");
                Density density2 = density$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer6);
                boolean rtl = consume7 == LayoutDirection.Rtl;
                LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                $dirty = $dirty4;
                Composer composer2 = $composer6;
                IconButtonKt.IconButton(onPreviousClicked, (Modifier) null, previousAvailable, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda($composer6, -1143715416, true, new DatePickerKt$MonthsNavigation$1$2$1(rtl)), composer2, (($dirty >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty & 896), 26);
                IconButtonKt.IconButton(onNextClicked, (Modifier) null, nextAvailable, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda($composer6, 1336532191, true, new DatePickerKt$MonthsNavigation$1$2$2(rtl)), composer2, (($dirty >> 15) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty << 3) & 896), 26);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer5.endReplaceableGroup();
                $composer5.endNode();
                $composer5.endReplaceableGroup();
                $composer5.endReplaceableGroup();
            } else {
                $dirty = $dirty4;
            }
            $composer5.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
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
            $dirty = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i8 = $dirty;
            return;
        }
        int i9 = $dirty;
        endRestartGroup.updateScope(new DatePickerKt$MonthsNavigation$2(modifier, nextAvailable, previousAvailable, yearPickerVisible, yearPickerText, onNextClicked, onPreviousClicked, onYearPickerButtonClicked, $changed));
    }

    /* access modifiers changed from: private */
    public static final void YearPickerMenuButton(Function0<Unit> onClick, boolean expanded, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        boolean z = expanded;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(409654418);
        ComposerKt.sourceInformation($composer2, "C(YearPickerMenuButton)P(3,1,2)1841@75389L11,1841@75343L75,1836@75206L690:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            Function0<Unit> function0 = onClick;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 4 : 2;
        } else {
            Function0<Unit> function02 = onClick;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed(z) ? 32 : 16;
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
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(409654418, $dirty2, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:1830)");
            }
            ButtonKt.TextButton(onClick, modifier4, false, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m1578textButtonColorsro_MJ88(0, MaterialTheme.INSTANCE.getColorScheme($composer2, 6).m1613getOnSurfaceVariant0d7_KjU(), 0, 0, $composer2, 24576, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda($composer2, 1899012021, true, new DatePickerKt$YearPickerMenuButton$1(function2, $dirty2, z)), $composer2, 807075840 | ($dirty2 & 14) | (($dirty2 >> 3) & 112), 388);
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
            int i4 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i5 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new DatePickerKt$YearPickerMenuButton$2(onClick, expanded, modifier3, content, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyGridState state, CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        return CollectionsKt.listOf(new CustomAccessibilityAction(scrollUpLabel, new DatePickerKt$customScrollActions$scrollUpAction$1(state, coroutineScope)), new CustomAccessibilityAction(scrollDownLabel, new DatePickerKt$customScrollActions$scrollDownAction$1(state, coroutineScope)));
    }

    public static final String toLocalString(int $this$toLocalString) {
        NumberFormat formatter = NumberFormat.getIntegerInstance();
        formatter.setGroupingUsed(false);
        String format = formatter.format(Integer.valueOf($this$toLocalString));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }
}
