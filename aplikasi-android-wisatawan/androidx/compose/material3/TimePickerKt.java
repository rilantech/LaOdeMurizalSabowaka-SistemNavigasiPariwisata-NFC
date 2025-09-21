package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a:\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00190\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u00100\u001a\u001d\u00101\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u00104\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a=\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0003¢\u0006\u0002\u0010<\u001a)\u0010=\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010>\u001a%\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010@\u001a;\u0010A\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010B\u001a\u00020CH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001ae\u0010F\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00190I2\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a=\u0010R\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001aQ\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020:2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010%\u001a\u00020&2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00190I¢\u0006\u0002\b\u001f¢\u0006\u0002\bZH\u0003¢\u0006\u0002\u0010[\u001a\u001d\u0010\\\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010]\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u0010^\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a\u0018\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0002\u001a(\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002\u001a-\u0010g\u001a\u00020h2\u0006\u0010J\u001a\u00020K2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u0007H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a+\u0010m\u001a\u00020$2\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010i\u001a\u00020*H\u0007¢\u0006\u0002\u0010p\u001a`\u0010q\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020G2\u0006\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020\u00072!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00190IH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a$\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0z2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\tH\u0002\u001a\u001c\u0010}\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u001c\u0010~\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0015\u0010\u001a\u00020h*\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\u0001\u001a\u00020\u001b*\u00020\u001b2\u0007\u0010\u0001\u001a\u00020*H\u0003\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\f\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\r\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u000f\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0010\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0017\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0001"}, d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "", "", "FullCircle", "", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "Landroidx/compose/material3/TimePickerState;", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/material3/TimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/Selection;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-lxUZ_iY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-uXwN82Y", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "is24Hour", "number", "numberContentDescription-YKJpE6Y", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "initialHour", "initialMinute", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-gIWD5Rc", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "valuesForAnimation", "Lkotlin/Pair;", "current", "new", "clockDial", "drawSelector", "toLocalString", "minDigits", "visible", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerKt {
    private static final float ClockDisplayBottomMargin = Dp.m5844constructorimpl((float) 36);
    private static final float ClockFaceBottomMargin = Dp.m5844constructorimpl((float) 24);
    /* access modifiers changed from: private */
    public static final float DisplaySeparatorWidth = Dp.m5844constructorimpl((float) 24);
    /* access modifiers changed from: private */
    public static final List<Integer> ExtraHours;
    private static final float FullCircle = 6.2831855f;
    /* access modifiers changed from: private */
    public static final List<Integer> Hours;
    /* access modifiers changed from: private */
    public static final float InnerCircleRadius = Dp.m5844constructorimpl((float) 69);
    /* access modifiers changed from: private */
    public static final float MaxDistance = Dp.m5844constructorimpl((float) 74);
    private static final float MinimumInteractiveSize = Dp.m5844constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final List<Integer> Minutes = CollectionsKt.listOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);
    /* access modifiers changed from: private */
    public static final float OuterCircleSizeRadius = Dp.m5844constructorimpl((float) 101);
    private static final float PeriodToggleMargin = Dp.m5844constructorimpl((float) 12);
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float SupportLabelTop = Dp.m5844constructorimpl((float) 7);
    private static final float TimeInputBottomPadding = Dp.m5844constructorimpl((float) 24);

    /* renamed from: TimePicker-mT9BvqQ  reason: not valid java name */
    public static final void m2163TimePickermT9BvqQ(TimePickerState state, Modifier modifier, TimePickerColors colors, int layoutType, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        TimePickerColors timePickerColors;
        int i2;
        Composer $composer2;
        int layoutType2;
        TimePickerColors colors2;
        Modifier modifier3;
        int $dirty;
        Modifier modifier4;
        TimePickerColors colors3;
        int i3;
        int i4;
        TimePickerState timePickerState = state;
        int i5 = $changed;
        Intrinsics.checkNotNullParameter(timePickerState, "state");
        Composer $composer3 = $composer.startRestartGroup(-619286452);
        ComposerKt.sourceInformation($composer3, "C(TimePicker)P(3,2!,1:c#material3.TimePickerLayoutType)191@10184L8,192@10252L12,194@10313L23:TimePicker.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) timePickerState) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if ((i5 & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                timePickerColors = colors;
                if ($composer3.changed((Object) timePickerColors)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                timePickerColors = colors;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            timePickerColors = colors;
        }
        if ((i5 & 7168) == 0) {
            if ((i & 8) == 0) {
                i2 = layoutType;
                if ($composer3.changed(i2)) {
                    i3 = 2048;
                    $dirty2 |= i3;
                }
            } else {
                i2 = layoutType;
            }
            i3 = 1024;
            $dirty2 |= i3;
        } else {
            i2 = layoutType;
        }
        if (($dirty2 & 5851) != 1170 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    colors3 = TimePickerDefaults.INSTANCE.m2160colorsu3YEpmA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 24576, 16383);
                    $dirty2 &= -897;
                } else {
                    colors3 = timePickerColors;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & -7169;
                    modifier3 = modifier4;
                    colors2 = colors3;
                    layoutType2 = TimePickerDefaults.INSTANCE.m2161layoutTypesDNSZnc($composer3, 6);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    colors2 = colors3;
                    layoutType2 = i2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                colors2 = timePickerColors;
                layoutType2 = i2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619286452, $dirty, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:188)");
            }
            State touchExplorationServicesEnabled$delegate = TouchExplorationStateProvider_androidKt.touchExplorationState($composer3, 0);
            if (TimePickerLayoutType.m2184equalsimpl0(layoutType2, TimePickerLayoutType.Companion.m2189getVerticalQJTpgSE())) {
                $composer3.startReplaceableGroup(1318081657);
                ComposerKt.sourceInformation($composer3, "197@10401L184");
                $composer2 = $composer3;
                VerticalTimePicker(state, modifier3, colors2, !TimePicker_mT9BvqQ$lambda$0(touchExplorationServicesEnabled$delegate), $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896), 0);
                $composer2.endReplaceableGroup();
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceableGroup(1318081863);
                ComposerKt.sourceInformation($composer2, "204@10607L186");
                HorizontalTimePicker(state, modifier3, colors2, !TimePicker_mT9BvqQ$lambda$0(touchExplorationServicesEnabled$delegate), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896), 0);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            int i7 = $dirty2;
            modifier3 = modifier2;
            colors2 = timePickerColors;
            layoutType2 = i2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$TimePicker$1(state, modifier3, colors2, layoutType2, $changed, i));
        }
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> $touchExplorationServicesEnabled$delegate) {
        return ((Boolean) $touchExplorationServicesEnabled$delegate.getValue()).booleanValue();
    }

    public static final void TimeInput(TimePickerState state, Modifier modifier, TimePickerColors colors, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        TimePickerColors colors2;
        TimePickerColors colors3;
        Modifier modifier3;
        Modifier modifier4;
        int i2;
        TimePickerState timePickerState = state;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(timePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(-760850373);
        ComposerKt.sourceInformation($composer2, "C(TimeInput)P(2,1)233@11683L8,235@11701L38:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) timePickerState) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            colors2 = colors;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    colors2 = TimePickerDefaults.INSTANCE.m2160colorsu3YEpmA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, 24576, 16383);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-760850373, $dirty, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:230)");
            }
            TimeInputImpl(modifier4, colors2, timePickerState, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i5 = $dirty;
            modifier3 = modifier4;
            colors3 = colors2;
        } else {
            $composer2.skipToGroupEnd();
            int i6 = $dirty;
            modifier3 = modifier2;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TimePickerKt$TimeInput$1(state, modifier3, colors3, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.TimePickerState rememberTimePickerState(int r18, int r19, boolean r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r7 = r21
            r8 = r22
            r0 = 1237715277(0x49c6094d, float:1622313.6)
            r7.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberTimePickerState)441@21331L14,444@21424L133,442@21368L189:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x0016
            r1 = 0
            r9 = r1
            goto L_0x0018
        L_0x0016:
            r9 = r18
        L_0x0018:
            r1 = r23 & 2
            if (r1 == 0) goto L_0x001f
            r1 = 0
            r10 = r1
            goto L_0x0021
        L_0x001f:
            r10 = r19
        L_0x0021:
            r1 = r23 & 4
            r2 = 0
            if (r1 == 0) goto L_0x002c
            boolean r1 = androidx.compose.material3.TimeFormat_androidKt.is24HourFormat(r7, r2)
            r11 = r1
            goto L_0x002e
        L_0x002c:
            r11 = r20
        L_0x002e:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x003a
            r1 = -1
            java.lang.String r3 = "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:438)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r3)
        L_0x003a:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            androidx.compose.material3.TimePickerState$Companion r1 = androidx.compose.material3.TimePickerState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r1.Saver()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r11)
            r5 = r8 & 14
            r6 = r8 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = r8 & 896(0x380, float:1.256E-42)
            r5 = r5 | r6
            r6 = 0
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r7.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r12)
            boolean r12 = r7.changed((java.lang.Object) r2)
            boolean r13 = r7.changed((java.lang.Object) r3)
            r12 = r12 | r13
            boolean r13 = r7.changed((java.lang.Object) r4)
            r12 = r12 | r13
            r13 = r21
            r14 = 0
            java.lang.Object r15 = r13.rememberedValue()
            r16 = 0
            if (r12 != 0) goto L_0x0089
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r18 = r2
            java.lang.Object r2 = r17.getEmpty()
            if (r15 != r2) goto L_0x0087
            goto L_0x008b
        L_0x0087:
            r2 = r15
            goto L_0x009a
        L_0x0089:
            r18 = r2
        L_0x008b:
            r2 = 0
            r19 = r2
            androidx.compose.material3.TimePickerKt$rememberTimePickerState$1$1 r2 = new androidx.compose.material3.TimePickerKt$rememberTimePickerState$1$1
            r2.<init>(r9, r10, r11)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r13.updateRememberedValue(r2)
        L_0x009a:
            r21.endReplaceableGroup()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2 = 0
            r5 = 72
            r6 = 4
            r4 = r21
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.TimePickerState r0 = (androidx.compose.material3.TimePickerState) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b7:
            r21.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.rememberTimePickerState(int, int, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.TimePickerState");
    }

    public static final void VerticalTimePicker(TimePickerState state, Modifier modifier, TimePickerColors colors, boolean autoSwitchToMinute, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        TimePickerColors colors2;
        TimePickerColors colors3;
        Modifier modifier3;
        Modifier modifier4;
        int i2;
        TimePickerState timePickerState = state;
        boolean z = autoSwitchToMinute;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(timePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(310683247);
        ComposerKt.sourceInformation($composer2, "C(VerticalTimePicker)P(3,2,1)663@28817L8,666@28867L319:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) timePickerState) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            colors2 = colors;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i3 & 7168) == 0) {
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    colors2 = TimePickerDefaults.INSTANCE.m2160colorsu3YEpmA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, 24576, 16383);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(310683247, $dirty, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:660)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            int $changed$iv = (($dirty >> 3) & 14) | 384;
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
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
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier4);
            Modifier modifier5 = modifier4;
            Arrangement.Vertical vertical = verticalArrangement$iv;
            int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
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
            int i5 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            int i6 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = (($changed$iv >> 6) & 112) | 6;
            int i8 = $changed$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 37436106, "C667@28957L35,668@29001L60,669@29070L44,670@29123L57:TimePicker.kt#uh7d8r");
            VerticalClockDisplay(timePickerState, colors2, $composer3, ($dirty & 14) | (($dirty >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m598height3ABfNKs(Modifier.Companion, ClockDisplayBottomMargin), $composer3, 6);
            ClockFace(timePickerState, colors2, z, $composer3, ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896));
            SpacerKt.Spacer(SizeKt.m598height3ABfNKs(Modifier.Companion, ClockFaceBottomMargin), $composer3, 6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            int i9 = $dirty;
            colors3 = colors2;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty;
            modifier3 = modifier2;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TimePickerKt$VerticalTimePicker$2(state, modifier3, colors3, autoSwitchToMinute, $changed, i));
    }

    public static final void HorizontalTimePicker(TimePickerState state, Modifier modifier, TimePickerColors colors, boolean autoSwitchToMinute, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        TimePickerColors colors2;
        TimePickerColors colors3;
        Modifier modifier3;
        Modifier modifier4;
        int i2;
        TimePickerState timePickerState = state;
        boolean z = autoSwitchToMinute;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(timePickerState, "state");
        Composer $composer2 = $composer.startRestartGroup(5079681);
        ComposerKt.sourceInformation($composer2, "C(HorizontalTimePicker)P(3,2,1)678@29350L8,681@29400L309:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed((Object) timePickerState) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            colors2 = colors;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i3 & 7168) == 0) {
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    colors2 = TimePickerDefaults.INSTANCE.m2160colorsu3YEpmA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, 24576, 16383);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5079681, $dirty, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:675)");
            }
            Modifier modifier$iv = PaddingKt.m542paddingqDBjuR0$default(modifier4, 0.0f, 0.0f, 0.0f, ClockFaceBottomMargin, 7, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Modifier modifier5 = modifier4;
            Alignment.Vertical vertical = verticalAlignment$iv;
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
            Modifier modifier6 = modifier$iv;
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            int $changed$iv$iv$iv = ((((384 << 3) & 112) << 9) & 7168) | 6;
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
            int i5 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i6 = $changed$iv$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -321635992, "C685@29545L37,686@29591L59,687@29659L44:TimePicker.kt#uh7d8r");
            HorizontalClockDisplay(timePickerState, colors2, $composer3, ($dirty & 14) | (($dirty >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m617width3ABfNKs(Modifier.Companion, ClockDisplayBottomMargin), $composer3, 6);
            ClockFace(timePickerState, colors2, z, $composer3, ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            int i8 = $dirty;
            colors3 = colors2;
        } else {
            $composer2.skipToGroupEnd();
            int i9 = $dirty;
            modifier3 = modifier2;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TimePickerKt$HorizontalTimePicker$2(state, modifier3, colors3, autoSwitchToMinute, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl(Modifier modifier, TimePickerColors colors, TimePickerState state, Composer $composer, int $changed) {
        Composer $composer2;
        Function0 function0;
        Function0 function02;
        Modifier modifier2 = modifier;
        TimePickerColors timePickerColors = colors;
        TimePickerState timePickerState = state;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation($composer3, "C(TimeInputImpl)P(1)697@29911L92,697@29859L144,700@30079L84,700@30027L136,704@30169L3592:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed((Object) modifier2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changed((Object) timePickerColors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changed((Object) timePickerState) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, $dirty2, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:692)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.Companion.getSaver();
            int $changed$iv = ($dirty2 >> 6) & 14;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed((Object) timePickerState);
            Composer $this$cache$iv$iv = $composer3;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                int i2 = $changed$iv;
                function0 = new TimePickerKt$TimeInputImpl$hourValue$2$1(timePickerState);
                $this$cache$iv$iv.updateRememberedValue(function0);
            } else {
                int i3 = $changed$iv;
                function0 = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            MutableState hourValue$delegate = RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, function0, $composer3, 72, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.Companion.getSaver();
            int $changed$iv2 = ($dirty2 >> 6) & 14;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer3.changed((Object) timePickerState);
            Composer $this$cache$iv$iv2 = $composer3;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                int i4 = $changed$iv2;
                function02 = new TimePickerKt$TimeInputImpl$minuteValue$2$1(timePickerState);
                $this$cache$iv$iv2.updateRememberedValue(function02);
            } else {
                int i5 = $changed$iv2;
                function02 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            MutableState minuteValue$delegate = RememberSaveableKt.rememberSaveable(objArr2, saver2, (String) null, function02, $composer3, 72, 4);
            int $dirty3 = $dirty2;
            Composer $composer4 = $composer3;
            Modifier modifier$iv = PaddingKt.m542paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            $composer4.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer4, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            String str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            Modifier modifier3 = modifier$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((384 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor);
            } else {
                $composer4.useNode();
            }
            $composer4.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer4);
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int i6 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer4;
            Density density = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            Composer $composer5 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer5, -1230444795, "C708@30332L10,714@30543L2787:TimePicker.kt#uh7d8r");
            TextStyle textStyle = TextStyle.m5333copyCXVQc50$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer5, 6), TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont()), timePickerColors.m2159timeSelectorContentColorvNxB06k$material3_release(true), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, TextAlign.m5700boximpl(TextAlign.Companion.m5707getCentere0LSkKk()), (TextDirection) null, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4177918, (Object) null);
            ProvidedValue[] providedValueArr = {TextKt.getLocalTextStyle().provides(textStyle)};
            TextStyle textStyle2 = textStyle;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            String str2 = str;
            Function0<ComposeUiNode> function03 = constructor;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            $composer2 = $composer4;
            TimePickerKt$TimeInputImpl$1$1 timePickerKt$TimeInputImpl$1$1 = r0;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Composer $composer$iv2 = $composer$iv;
            Alignment.Vertical vertical = verticalAlignment$iv;
            TimePickerKt$TimeInputImpl$1$1 timePickerKt$TimeInputImpl$1$12 = new TimePickerKt$TimeInputImpl$1$1(hourValue$delegate, state, $dirty3, colors, minuteValue$delegate);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer5, 1306700887, true, timePickerKt$TimeInputImpl$1$1), $composer5, 56);
            $composer5.startReplaceableGroup(565119426);
            ComposerKt.sourceInformation($composer5, "785@33375L370");
            if (!state.is24hour()) {
                Modifier modifier$iv2 = PaddingKt.m542paddingqDBjuR0$default(Modifier.Companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                $composer5.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer5.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer5, str2);
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Density density$iv$iv2 = (Density) consume4;
                Alignment alignment = contentAlignment$iv;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Modifier modifier4 = modifier$iv2;
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
                Function0<ComposeUiNode> function04 = constructor2;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer5.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer5.startReplaceableGroup(2058660585);
                Composer $composer$iv3 = $composer5;
                int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
                Density density2 = density$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i9 = ((6 >> 6) & 112) | 6;
                Composer $composer6 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer6, -1645137173, "C786@33443L288:TimePicker.kt#uh7d8r");
                LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                VerticalPeriodToggle(SizeKt.m614sizeVpY3zN4(Modifier.Companion, TimeInputTokens.INSTANCE.m2757getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m2756getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState, timePickerColors, $composer6, (($dirty3 >> 3) & 112) | 6 | (($dirty3 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer5.endReplaceableGroup();
                $composer5.endNode();
                $composer5.endReplaceableGroup();
                $composer5.endReplaceableGroup();
            }
            $composer5.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            int i10 = $dirty2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Modifier modifier5 = modifier;
            int i11 = $changed;
            return;
        }
        endRestartGroup.updateScope(new TimePickerKt$TimeInputImpl$2(modifier, timePickerColors, timePickerState, $changed));
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$5(MutableState<TextFieldValue> $hourValue$delegate) {
        return (TextFieldValue) $hourValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl$lambda$6(MutableState<TextFieldValue> $hourValue$delegate, TextFieldValue value) {
        $hourValue$delegate.setValue(value);
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$8(MutableState<TextFieldValue> $minuteValue$delegate) {
        return (TextFieldValue) $minuteValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void TimeInputImpl$lambda$9(MutableState<TextFieldValue> $minuteValue$delegate, TextFieldValue value) {
        $minuteValue$delegate.setValue(value);
    }

    /* access modifiers changed from: private */
    public static final void HorizontalClockDisplay(TimePickerState state, TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerState timePickerState = state;
        TimePickerColors timePickerColors = colors;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation($composer2, "C(HorizontalClockDisplay)P(1)801@33868L554:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) timePickerState) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) timePickerColors) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, $dirty, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:800)");
            }
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Arrangement.Vertical vertical = verticalArrangement$iv;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            int i2 = $changed$iv$iv;
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
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            int i3 = $changed$iv$iv$iv;
            Composer $composer$iv2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int $changed2 = ((48 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -385990195, "C802@33927L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, $composer3, ($dirty & 14) | ($dirty & 112));
            $composer3.startReplaceableGroup(-552399017);
            ComposerKt.sourceInformation($composer3, "804@34005L401");
            if (!state.is24hour()) {
                Modifier modifier$iv2 = PaddingKt.m542paddingqDBjuR0$default(Modifier.Companion, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, (Object) null);
                MeasurePolicy measurePolicy = measurePolicy$iv;
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                int i4 = $changed2;
                int i5 = $changed$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume4;
                Function0<ComposeUiNode> function0 = constructor;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Density density = density$iv$iv;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer3);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i6 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv3 = $composer3;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                int i7 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((6 >> 6) & 112) | 6;
                Composer $composer4 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer4, 34966409, "C805@34082L310:TimePicker.kt#uh7d8r");
                Density density2 = density$iv$iv2;
                HorizontalPeriodToggle(SizeKt.m614sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2768getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2767getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, $composer4, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            } else {
                int i9 = $changed2;
                int i10 = $changed$iv;
                Function0<ComposeUiNode> function03 = constructor;
                Density density3 = density$iv$iv;
            }
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
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
            endRestartGroup.updateScope(new TimePickerKt$HorizontalClockDisplay$2(timePickerState, timePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalClockDisplay(TimePickerState state, TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerState timePickerState = state;
        TimePickerColors timePickerColors = colors;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation($composer2, "C(VerticalClockDisplay)P(1)820@34527L549:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) timePickerState) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) timePickerColors) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, $dirty, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:819)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Alignment.Vertical vertical = verticalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            int i2 = $changed$iv$iv;
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
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            int i3 = $changed$iv$iv$iv;
            Composer $composer$iv2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            int $changed2 = ((48 >> 6) & 112) | 6;
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1085478029, "C821@34585L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, $composer3, ($dirty & 14) | ($dirty & 112));
            $composer3.startReplaceableGroup(952907543);
            ComposerKt.sourceInformation($composer3, "823@34663L397");
            if (!state.is24hour()) {
                Modifier modifier$iv2 = PaddingKt.m542paddingqDBjuR0$default(Modifier.Companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                MeasurePolicy measurePolicy = measurePolicy$iv;
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                int i4 = $changed2;
                int i5 = $changed$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume4;
                Function0<ComposeUiNode> function0 = constructor;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Density density = density$iv$iv;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer3);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i6 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv3 = $composer3;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                int i7 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((6 >> 6) & 112) | 6;
                Composer $composer4 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer4, -1130526389, "C824@34742L304:TimePicker.kt#uh7d8r");
                Density density2 = density$iv$iv2;
                VerticalPeriodToggle(SizeKt.m614sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2771getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2770getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, $composer4, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            } else {
                int i9 = $changed2;
                int i10 = $changed$iv;
                Function0<ComposeUiNode> function03 = constructor;
                Density density3 = density$iv$iv;
            }
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
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
            endRestartGroup.updateScope(new TimePickerKt$VerticalClockDisplay$2(timePickerState, timePickerColors, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void ClockDisplayNumbers(TimePickerState state, TimePickerColors colors, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation($composer2, "C(ClockDisplayNumbers)P(1)843@35262L10,842@35190L1047:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, $dirty, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:838)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont()))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -477913269, true, new TimePickerKt$ClockDisplayNumbers$1(state, colors, $dirty)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockDisplayNumbers$2(state, colors, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState state, TimePickerColors colors, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation($composer2, "C(HorizontalPeriodToggle)P(1,2)882@36399L904,907@37350L9,909@37385L206:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, $dirty2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:877)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (MeasurePolicy) TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape2 = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, state, colors, (MeasurePolicy) value$iv$iv, ShapesKt.start(shape2), ShapesKt.end(shape2), $composer2, ($dirty2 & 14) | 3072 | ($dirty2 & 112) | ($dirty2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$HorizontalPeriodToggle$1(modifier, state, colors, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState state, TimePickerColors colors, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation($composer2, "C(VerticalPeriodToggle)P(1,2)925@37751L911,950@38709L9,952@38744L207:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, $dirty2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:920)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (MeasurePolicy) TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape2 = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, state, colors, (MeasurePolicy) value$iv$iv, ShapesKt.top(shape2), ShapesKt.bottom(shape2), $composer2, ($dirty2 & 14) | 3072 | ($dirty2 & 112) | ($dirty2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$VerticalPeriodToggle$1(modifier, state, colors, $changed));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0344  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PeriodToggleImpl(androidx.compose.ui.Modifier r36, androidx.compose.material3.TimePickerState r37, androidx.compose.material3.TimePickerColors r38, androidx.compose.ui.layout.MeasurePolicy r39, androidx.compose.ui.graphics.Shape r40, androidx.compose.ui.graphics.Shape r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            r8 = r36
            r9 = r37
            r10 = r39
            r11 = r43
            r0 = 1374241901(0x51e9446d, float:1.25234422E11)
            r1 = r42
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(PeriodToggleImpl)P(3,5!1,2,4)976@39344L9,977@39403L41,980@39508L111,978@39449L1257:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r43
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0026
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0024
            r2 = 4
            goto L_0x0025
        L_0x0024:
            r2 = 2
        L_0x0025:
            r1 = r1 | r2
        L_0x0026:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0036
            boolean r2 = r12.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x0033
            r2 = 32
            goto L_0x0035
        L_0x0033:
            r2 = 16
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0049
            r7 = r38
            boolean r2 = r12.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0045
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0047
        L_0x0045:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0047:
            r1 = r1 | r2
            goto L_0x004b
        L_0x0049:
            r7 = r38
        L_0x004b:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x005b
            boolean r2 = r12.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0058
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005a
        L_0x0058:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005a:
            r1 = r1 | r2
        L_0x005b:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x0070
            r6 = r40
            boolean r2 = r12.changed((java.lang.Object) r6)
            if (r2 == 0) goto L_0x006c
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006e
        L_0x006c:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006e:
            r1 = r1 | r2
            goto L_0x0072
        L_0x0070:
            r6 = r40
        L_0x0072:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x0086
            r5 = r41
            boolean r2 = r12.changed((java.lang.Object) r5)
            if (r2 == 0) goto L_0x0082
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0084
        L_0x0082:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0084:
            r1 = r1 | r2
            goto L_0x0088
        L_0x0086:
            r5 = r41
        L_0x0088:
            r4 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r4
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x009e
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x0099
            goto L_0x009e
        L_0x0099:
            r12.skipToGroupEnd()
            goto L_0x0347
        L_0x009e:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00aa
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:963)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r1, r2)
        L_0x00aa:
            androidx.compose.material3.tokens.TimePickerTokens r0 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            float r0 = r0.m2769getPeriodSelectorOutlineWidthD9Ej5fM()
            long r1 = r38.m2154getPeriodSelectorBorderColor0d7_KjU$material3_release()
            androidx.compose.foundation.BorderStroke r0 = androidx.compose.foundation.BorderStrokeKt.m194BorderStrokecXLIe8U(r0, r1)
            androidx.compose.material3.tokens.TimePickerTokens r1 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r1 = r1.getPeriodSelectorContainerShape()
            r2 = 6
            androidx.compose.ui.graphics.Shape r1 = androidx.compose.material3.ShapesKt.toShape(r1, r12, r2)
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            androidx.compose.foundation.shape.CornerBasedShape r1 = (androidx.compose.foundation.shape.CornerBasedShape) r1
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = r3.m2050getTimePickerPeriodToggleadMyvUU()
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r3, r12, r2)
            r13 = 0
            r14 = 0
            r15 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            boolean r16 = r12.changed((java.lang.Object) r3)
            r17 = r12
            r18 = 0
            java.lang.Object r2 = r17.rememberedValue()
            r19 = 0
            if (r16 != 0) goto L_0x0101
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r20.getEmpty()
            if (r2 != r5) goto L_0x00fc
            goto L_0x0101
        L_0x00fc:
            r20 = r2
            r5 = r17
            goto L_0x0112
        L_0x0101:
            r5 = 0
            r20 = r2
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1 r2 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
            r2.<init>(r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5 = r17
            r5.updateRememberedValue(r2)
        L_0x0112:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5 = 0
            r14 = 1
            r13 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r8, r5, r2, r14, r13)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r2)
            androidx.compose.ui.Modifier r2 = r2.then(r8)
            r13 = r1
            androidx.compose.ui.graphics.Shape r13 = (androidx.compose.ui.graphics.Shape) r13
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BorderKt.border(r2, r0, r13)
            int r13 = r4 >> 3
            r13 = r13 & 896(0x380, float:1.256E-42)
            r20 = r13
            r21 = 0
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r17 = 6
            r18 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r14)
            java.lang.Object r22 = r12.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r13 = r22
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r5 = r17
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r17 = 6
            r22 = 0
            r23 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r14)
            java.lang.Object r0 = r12.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r17 = 6
            r22 = 0
            r24 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r14)
            java.lang.Object r1 = r12.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            int r14 = r20 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r17 = 6
            r14 = r14 | 6
            r22 = r14
            r25 = 0
            androidx.compose.runtime.Applier r14 = r12.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x01b9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b9:
            r12.startReusableNode()
            boolean r14 = r12.getInserting()
            if (r14 == 0) goto L_0x01c6
            r12.createNode(r5)
            goto L_0x01c9
        L_0x01c6:
            r12.useNode()
        L_0x01c9:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2865constructorimpl(r12)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r26 = r3
            kotlin.jvm.functions.Function2 r3 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r14, r10, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r14, r13, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r14, r0, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r14, r1, r3)
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r3)
            int r14 = r22 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r2.invoke(r3, r12, r14)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r3)
            int r3 = r22 >> 9
            r3 = r3 & 14
            r14 = r12
            r27 = 0
            r28 = r0
            r0 = 1654470794(0x629d388a, float:1.4501064E21)
            r29 = r1
            java.lang.String r1 = "C992@39935L71,989@39809L303,1002@40345L9,997@40125L244,1008@40521L70,1004@40382L308:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
            boolean r0 = r37.isAfternoonToggle$material3_release()
            r1 = 1
            r0 = r0 ^ r1
            int r17 = r4 >> 3
            r17 = r17 & 14
            r18 = 0
            r1 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            boolean r30 = r14.changed((java.lang.Object) r9)
            r42 = r14
            r31 = 0
            java.lang.Object r1 = r42.rememberedValue()
            r32 = 0
            if (r30 != 0) goto L_0x0259
            androidx.compose.runtime.Composer$Companion r33 = androidx.compose.runtime.Composer.Companion
            r34 = r2
            java.lang.Object r2 = r33.getEmpty()
            if (r1 != r2) goto L_0x0254
            goto L_0x025b
        L_0x0254:
            r2 = r42
            r33 = r1
            goto L_0x026c
        L_0x0259:
            r34 = r2
        L_0x025b:
            r2 = 0
            r33 = r1
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1 r1 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = r42
            r2.updateRememberedValue(r1)
        L_0x026c:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.material3.ComposableSingletons$TimePickerKt r2 = androidx.compose.material3.ComposableSingletons$TimePickerKt.INSTANCE
            kotlin.jvm.functions.Function3 r17 = r2.m1694getLambda1$material3_release()
            int r2 = r4 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r42 = r3
            int r3 = r4 << 3
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r30 = r13
            r3 = 0
            r13 = r0
            r31 = r5
            r0 = r14
            r5 = 1
            r14 = r40
            r35 = r15
            r15 = r1
            r16 = r38
            r18 = r0
            r19 = r2
            ToggleItem(r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            java.lang.String r2 = "Spacer"
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r2)
            r2 = 1073741824(0x40000000, float:2.0)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ZIndexModifierKt.zIndex(r1, r2)
            r2 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r1, r2, r5, r3)
            androidx.compose.material3.tokens.TimePickerTokens r1 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getPeriodSelectorOutlineColor()
            r2 = 6
            long r14 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r2)
            r17 = 2
            r18 = 0
            r16 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m167backgroundbw27NRU$default(r13, r14, r16, r17, r18)
            r2 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r2)
            boolean r13 = r37.isAfternoonToggle$material3_release()
            int r1 = r4 >> 3
            r1 = r1 & 14
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r3)
            r3 = r35
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            boolean r3 = r0.changed((java.lang.Object) r9)
            r5 = r0
            r14 = 0
            java.lang.Object r15 = r5.rememberedValue()
            r16 = 0
            if (r3 != 0) goto L_0x02fa
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r18 = r1
            java.lang.Object r1 = r17.getEmpty()
            if (r15 != r1) goto L_0x02f8
            goto L_0x02fc
        L_0x02f8:
            r1 = r15
            goto L_0x030b
        L_0x02fa:
            r18 = r1
        L_0x02fc:
            r1 = 0
            r17 = r1
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1 r1 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5.updateRememberedValue(r1)
        L_0x030b:
            r0.endReplaceableGroup()
            r15 = r1
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            androidx.compose.material3.ComposableSingletons$TimePickerKt r1 = androidx.compose.material3.ComposableSingletons$TimePickerKt.INSTANCE
            kotlin.jvm.functions.Function3 r17 = r1.m1695getLambda2$material3_release()
            int r1 = r4 >> 12
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            int r2 = r4 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r19 = r1 | r2
            r14 = r41
            r16 = r38
            r18 = r0
            ToggleItem(r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0347
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0347:
            androidx.compose.runtime.ScopeUpdateScope r13 = r12.endRestartGroup()
            if (r13 != 0) goto L_0x034f
            r15 = r4
            goto L_0x0369
        L_0x034f:
            androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3 r14 = new androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3
            r0 = r14
            r1 = r36
            r2 = r37
            r3 = r38
            r15 = r4
            r4 = r39
            r5 = r40
            r6 = r41
            r7 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0369:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.PeriodToggleImpl(androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerState, androidx.compose.material3.TimePickerColors, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.ui.graphics.Shape, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ToggleItem(boolean checked, Shape shape, Function0<Unit> onClick, TimePickerColors colors, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        boolean z = checked;
        TimePickerColors timePickerColors = colors;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation($composer2, "C(ToggleItem)P(!1,4,3)1032@41167L22,1037@41346L112,1028@41032L432:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(z) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) shape) ? 32 : 16;
        } else {
            Shape shape2 = shape;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 256 : 128;
        } else {
            Function0<Unit> function0 = onClick;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) timePickerColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 16384 : 8192;
        } else {
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, $dirty2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1018)");
            }
            long contentColor = timePickerColors.m2157periodSelectorContentColorvNxB06k$material3_release(z);
            long containerColor = timePickerColors.m2156periodSelectorContainerColorvNxB06k$material3_release(z);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, z ? 0.0f : 1.0f), 0.0f, 1, (Object) null);
            Object key1$iv = Boolean.valueOf(checked);
            int i2 = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(key1$iv);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new TimePickerKt$ToggleItem$1$1(z);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
                Composer composer = $this$cache$iv$iv;
            }
            $composer2.endReplaceableGroup();
            ButtonKt.TextButton(onClick, SemanticsModifierKt.semantics$default(fillMaxSize$default, false, (Function1) value$iv$iv, 1, (Object) null), false, shape, ButtonDefaults.INSTANCE.m1578textButtonColorsro_MJ88(containerColor, contentColor, 0, 0, $composer2, 24576, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m531PaddingValues0680j_4(Dp.m5844constructorimpl((float) 0)), (MutableInteractionSource) null, content, $composer2, (($dirty2 >> 6) & 14) | 12582912 | (($dirty2 << 6) & 7168) | (($dirty2 << 15) & 1879048192), 356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i3 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i4 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new TimePickerKt$ToggleItem$2(checked, shape, onClick, colors, content, $changed));
    }

    /* access modifiers changed from: private */
    public static final void DisplaySeparator(Modifier modifier, Composer $composer, int $changed) {
        Modifier modifier2 = modifier;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation($composer2, "C(DisplaySeparator)1047@41601L7,1055@41862L245:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1045)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextAlign r28 = TextAlign.m5700boximpl(TextAlign.Companion.m5707getCentere0LSkKk());
            LineHeightStyle lineHeightStyle = r2;
            LineHeightStyle lineHeightStyle2 = new LineHeightStyle(LineHeightStyle.Alignment.Companion.m5684getCenterPIaL0Z0(), LineHeightStyle.Trim.Companion.m5696getBothEVpEnUU(), (DefaultConstructorMarker) null);
            TextStyle style = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(TextStyle.m5333copyCXVQc50$default((TextStyle) consume, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, r28, (TextDirection) null, 0, (TextIndent) null, (PlatformTextStyle) null, lineHeightStyle, (LineBreak) null, (Hyphens) null, 3653631, (Object) null), false);
            Modifier modifier$iv = SemanticsModifierKt.clearAndSetSemantics(modifier2, TimePickerKt$DisplaySeparator$1.INSTANCE);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
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
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i3 = $dirty;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i4 = ((48 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Modifier modifier3 = modifier$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -617594952, "C1061@42055L9,1059@41981L120:TimePicker.kt#uh7d8r");
            Function0<ComposeUiNode> function0 = constructor;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            Density density = density$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            TextKt.m2148Text4IGK_g(":", (Modifier) null, ColorSchemeKt.toColor(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), $composer3, 6), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, style, $composer3, 6, 0, 65530);
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
            int i5 = $dirty;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$DisplaySeparator$3(modifier2, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01cd  */
    /* renamed from: TimeSelector-uXwN82Y  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2165TimeSelectoruXwN82Y(androidx.compose.ui.Modifier r38, int r39, androidx.compose.material3.TimePickerState r40, int r41, androidx.compose.material3.TimePickerColors r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            r7 = r38
            r8 = r40
            r9 = r41
            r10 = r42
            r11 = r44
            r0 = 21099367(0x141f367, float:3.5623134E-38)
            r1 = r43
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TimeSelector)P(1,4,3,2:c#material3.Selection)1077@42402L176,1087@42730L24,1090@42844L124,1103@43273L9,1088@42759L1060:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r44
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r12.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0026
            r2 = 4
            goto L_0x0027
        L_0x0026:
            r2 = 2
        L_0x0027:
            r1 = r1 | r2
        L_0x0028:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003b
            r15 = r39
            boolean r2 = r12.changed((int) r15)
            if (r2 == 0) goto L_0x0037
            r2 = 32
            goto L_0x0039
        L_0x0037:
            r2 = 16
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r15 = r39
        L_0x003d:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x004d
            boolean r2 = r12.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x004a
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r1 = r1 | r2
        L_0x004d:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x005d
            boolean r2 = r12.changed((int) r9)
            if (r2 == 0) goto L_0x005a
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x005a:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005c:
            r1 = r1 | r2
        L_0x005d:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x006f
            boolean r2 = r12.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x006c
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006e
        L_0x006c:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006e:
            r1 = r1 | r2
        L_0x006f:
            r5 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r5
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x0087
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x007f
            goto L_0x0087
        L_0x007f:
            r12.skipToGroupEnd()
            r36 = r5
            r7 = r12
            goto L_0x01d0
        L_0x0087:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0093
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.TimeSelector (TimePicker.kt:1069)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r1, r2)
        L_0x0093:
            int r0 = r40.m2191getSelectionJiIwxys$material3_release()
            boolean r6 = androidx.compose.material3.Selection.m1956equalsimpl0(r0, r9)
            androidx.compose.material3.Selection$Companion r0 = androidx.compose.material3.Selection.Companion
            int r0 = r0.m1960getHourJiIwxys()
            boolean r0 = androidx.compose.material3.Selection.m1956equalsimpl0(r9, r0)
            if (r0 == 0) goto L_0x00ae
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2042getTimePickerHourSelectionadMyvUU()
            goto L_0x00b4
        L_0x00ae:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2046getTimePickerMinuteSelectionadMyvUU()
        L_0x00b4:
            r1 = 0
            java.lang.String r4 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r12, r1)
            long r30 = r10.m2158timeSelectorContainerColorvNxB06k$material3_release(r6)
            long r32 = r10.m2159timeSelectorContentColorvNxB06k$material3_release(r6)
            r0 = r1
            r2 = 0
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = r12
            r13 = 0
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r14)
            r14 = 0
            r43 = r12
            r16 = 0
            r17 = r0
            java.lang.Object r0 = r43.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x0114
            r1 = 0
            r19 = 0
            kotlin.coroutines.EmptyCoroutineContext r19 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r21 = r0
            r0 = r19
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r3)
            r19 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r1 = r43
            r1.updateRememberedValue(r0)
            goto L_0x0118
        L_0x0114:
            r1 = r43
            r21 = r0
        L_0x0118:
            r12.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r12.endReplaceableGroup()
            r3 = r1
            r0 = 0
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r2 = r12.changed((java.lang.Object) r4)
            r13 = r12
            r14 = 0
            r43 = r0
            java.lang.Object r0 = r13.rememberedValue()
            r16 = 0
            if (r2 != 0) goto L_0x0153
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r18 = r1
            java.lang.Object r1 = r17.getEmpty()
            if (r0 != r1) goto L_0x0150
            goto L_0x0155
        L_0x0150:
            r17 = r0
            goto L_0x0164
        L_0x0153:
            r18 = r1
        L_0x0155:
            r1 = 0
            r17 = r0
            androidx.compose.material3.TimePickerKt$TimeSelector$1$1 r0 = new androidx.compose.material3.TimePickerKt$TimeSelector$1$1
            r0.<init>(r4)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r13.updateRememberedValue(r0)
        L_0x0164:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 1
            androidx.compose.ui.Modifier r14 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r7, r2, r0)
            androidx.compose.material3.tokens.TimePickerTokens r0 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r0 = r0.getTimeSelectorContainerShape()
            r1 = 6
            androidx.compose.ui.graphics.Shape r16 = androidx.compose.material3.ShapesKt.toShape(r0, r12, r1)
            androidx.compose.material3.TimePickerKt$TimeSelector$2 r0 = new androidx.compose.material3.TimePickerKt$TimeSelector$2
            r0.<init>(r9, r8, r3)
            r13 = r0
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            androidx.compose.material3.TimePickerKt$TimeSelector$3 r1 = new androidx.compose.material3.TimePickerKt$TimeSelector$3
            r0 = r1
            r7 = r1
            r1 = r41
            r8 = r2
            r2 = r40
            r34 = r3
            r3 = r39
            r35 = r4
            r4 = r5
            r36 = r5
            r37 = r6
            r5 = r32
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = -1338709103(0xffffffffb034eb91, float:-6.581838E-10)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r8, r7)
            r25 = r0
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r0 = 0
            r15 = r0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 48
            r29 = 1992(0x7c8, float:2.791E-42)
            r7 = r12
            r12 = r37
            r17 = r30
            r26 = r7
            androidx.compose.material3.SurfaceKt.m2063Surfaced85dljk((boolean) r12, (kotlin.jvm.functions.Function0<kotlin.Unit>) r13, (androidx.compose.ui.Modifier) r14, (boolean) r15, (androidx.compose.ui.graphics.Shape) r16, (long) r17, (long) r19, (float) r21, (float) r22, (androidx.compose.foundation.BorderStroke) r23, (androidx.compose.foundation.interaction.MutableInteractionSource) r24, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (androidx.compose.runtime.Composer) r26, (int) r27, (int) r28, (int) r29)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d0:
            androidx.compose.runtime.ScopeUpdateScope r8 = r7.endRestartGroup()
            if (r8 != 0) goto L_0x01d7
            goto L_0x01ee
        L_0x01d7:
            androidx.compose.material3.TimePickerKt$TimeSelector$4 r12 = new androidx.compose.material3.TimePickerKt$TimeSelector$4
            r0 = r12
            r1 = r38
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r42
            r6 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r8.updateScope(r12)
        L_0x01ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2165TimeSelectoruXwN82Y(androidx.compose.ui.Modifier, int, androidx.compose.material3.TimePickerState, int, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    public static final void ClockFace(TimePickerState state, TimePickerColors colors, boolean autoSwitchToMinute, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer $composer2 = $composer.startRestartGroup(-1525091100);
        ComposerKt.sourceInformation($composer2, "C(ClockFace)P(2,1)1129@43957L1899:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) colors) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525091100, $dirty2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1124)");
            }
            CrossfadeKt.Crossfade(state.getValues$material3_release(), SemanticsModifierKt.semantics$default(SizeKt.m612size3ABfNKs(BackgroundKt.m166backgroundbw27NRU(Modifier.Companion, colors.m2152getClockDialColor0d7_KjU$material3_release(), RoundedCornerShapeKt.getCircleShape()), TimePickerTokens.INSTANCE.m2762getClockDialContainerSizeD9Ej5fM()), false, TimePickerKt$ClockFace$1.INSTANCE, 1, (Object) null), (FiniteAnimationSpec<Float>) AnimationSpecKt.tween$default(350, 0, (Easing) null, 6, (Object) null), (String) null, ComposableLambdaKt.composableLambda($composer2, 1628166511, true, new TimePickerKt$ClockFace$2(state, autoSwitchToMinute, colors, $dirty2)), $composer2, 24584, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$ClockFace$3(state, colors, autoSwitchToMinute, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier drawSelector(Modifier $this$drawSelector, TimePickerState state, TimePickerColors colors) {
        return DrawModifierKt.drawWithContent($this$drawSelector, new TimePickerKt$drawSelector$1(state, colors));
    }

    /* access modifiers changed from: private */
    public static final Modifier clockDial(Modifier $this$clockDial, TimePickerState state, boolean autoSwitchToMinute) {
        return ComposedModifierKt.composed($this$clockDial, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TimePickerKt$clockDial$$inlined$debugInspectorInfo$1(state) : InspectableValueKt.getNoInspectorInfo(), new TimePickerKt$clockDial$2(state, autoSwitchToMinute));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ClockText(androidx.compose.material3.TimePickerState r57, int r58, boolean r59, androidx.compose.runtime.Composer r60, int r61) {
        /*
            r7 = r57
            r8 = r58
            r9 = r59
            r10 = r61
            r0 = -1317232110(0xffffffffb17ca212, float:-3.6762953E-9)
            r1 = r60
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ClockText)P(1,2)*1286@49539L10,1290@49682L7,1291@49732L40,1292@49789L24,1294@49851L142,1312@50446L39,1307@50245L758:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r61
            r2 = r10 & 14
            r3 = 2
            if (r2 != 0) goto L_0x0027
            boolean r2 = r11.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            r1 = r1 | r2
        L_0x0027:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0037
            boolean r2 = r11.changed((int) r8)
            if (r2 == 0) goto L_0x0034
            r2 = 32
            goto L_0x0036
        L_0x0034:
            r2 = 16
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0047
            boolean r2 = r11.changed((boolean) r9)
            if (r2 == 0) goto L_0x0044
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0046
        L_0x0044:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0046:
            r1 = r1 | r2
        L_0x0047:
            r12 = r1
            r1 = r12 & 731(0x2db, float:1.024E-42)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 != r2) goto L_0x005c
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            r11.skipToGroupEnd()
            r40 = r12
            goto L_0x03d5
        L_0x005c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0068
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.ClockText (TimePicker.kt:1285)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
        L_0x0068:
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r11, r13)
            androidx.compose.material3.tokens.TimePickerTokens r1 = androidx.compose.material3.tokens.TimePickerTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r1 = r1.getClockDialLabelTextFont()
            androidx.compose.ui.text.TextStyle r0 = androidx.compose.material3.TypographyKt.fromToken(r0, r1)
            r1 = 0
            r4 = 0
            androidx.compose.ui.text.TextStyle r34 = androidx.compose.material3.IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(r0, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r14, r5)
            java.lang.Object r5 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = r5
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 0
            float r2 = MaxDistance
            float r39 = r0.m5825toPx0680j_4(r2)
            r0 = r4
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r2)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r6 = 0
            r15 = r11
            r16 = 0
            java.lang.Object r14 = r15.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r18.getEmpty()
            r2 = 0
            if (r14 != r13) goto L_0x00d6
            r13 = 0
            androidx.compose.ui.geometry.Offset$Companion r20 = androidx.compose.ui.geometry.Offset.Companion
            long r20 = r20.m3019getZeroF1C5BW0()
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2992boximpl(r20)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r2, r3, r2)
            r15.updateRememberedValue(r3)
            goto L_0x00d7
        L_0x00d6:
            r3 = r14
        L_0x00d7:
            r11.endReplaceableGroup()
            r13 = r3
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            r0 = 0
            r1 = r0
            r3 = 0
            r4 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r4 = r11
            r6 = r0
            r0 = 0
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r5 = 0
            r14 = r11
            r15 = 0
            java.lang.Object r2 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r0
            java.lang.Object r0 = r18.getEmpty()
            if (r2 != r0) goto L_0x012a
            r0 = 0
            r18 = 0
            kotlin.coroutines.EmptyCoroutineContext r18 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r21 = r0
            r0 = r18
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r4)
            r18 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r14.updateRememberedValue(r0)
            goto L_0x012d
        L_0x012a:
            r18 = r1
            r0 = r2
        L_0x012d:
            r11.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r2 = r0.getCoroutineScope()
            r11.endReplaceableGroup()
            r0 = 0
            int r1 = r57.m2191getSelectionJiIwxys$material3_release()
            boolean r3 = r57.is24hour()
            int r4 = r12 << 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            java.lang.String r1 = m2170numberContentDescriptionYKJpE6Y(r1, r3, r8, r11, r4)
            r14 = r1
            r15 = 1
            java.lang.String r6 = toLocalString(r8, r15)
            int r1 = r57.m2191getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r3 = androidx.compose.material3.Selection.Companion
            int r3 = r3.m1961getMinuteJiIwxys()
            boolean r1 = androidx.compose.material3.Selection.m1956equalsimpl0(r1, r3)
            if (r1 == 0) goto L_0x016f
            int r1 = r57.getMinute()
            java.lang.String r1 = toLocalString(r1, r15)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)
            goto L_0x017b
        L_0x016f:
            int r1 = r57.getHour()
            java.lang.String r1 = toLocalString(r1, r15)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)
        L_0x017b:
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r3.getCenter()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r3)
            float r4 = MinimumInteractiveSize
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m612size3ABfNKs(r3, r4)
            r4 = 6
            r16 = r4
            r4 = 0
            r15 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            boolean r20 = r11.changed((java.lang.Object) r13)
            r21 = r11
            r23 = 0
            java.lang.Object r0 = r21.rememberedValue()
            r25 = 0
            if (r20 != 0) goto L_0x01bf
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r27 = r4
            java.lang.Object r4 = r26.getEmpty()
            if (r0 != r4) goto L_0x01ba
            goto L_0x01c1
        L_0x01ba:
            r26 = r0
            r4 = r21
            goto L_0x01d2
        L_0x01bf:
            r27 = r4
        L_0x01c1:
            r4 = 0
            r26 = r0
            androidx.compose.material3.TimePickerKt$ClockText$1$1 r0 = new androidx.compose.material3.TimePickerKt$ClockText$1$1
            r0.<init>(r13)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4 = r21
            r4.updateRememberedValue(r0)
        L_0x01d2:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r3, r0)
            r3 = 3
            r16 = r5
            r4 = 0
            r5 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.FocusableKt.focusable$default(r0, r5, r4, r3, r4)
            androidx.compose.material3.TimePickerKt$ClockText$2 r20 = new androidx.compose.material3.TimePickerKt$ClockText$2
            r0 = r20
            r3 = r57
            r4 = r39
            r7 = r5
            r40 = r12
            r12 = r16
            r5 = r59
            r41 = r6
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r20
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r3 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r7, r3, r0)
            r3 = 48
            r4 = 0
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r5 = 0
            int r6 = r3 >> 3
            r6 = r6 & 14
            int r7 = r3 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r5, r11, r6)
            int r7 = r3 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r12 = 0
            r42 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r16 = 6
            r17 = 0
            r43 = r2
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            r44 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r2)
            java.lang.Object r4 = r11.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r1 = r4
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r16 = 6
            r17 = 0
            r45 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r2)
            java.lang.Object r5 = r11.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r4 = r5
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r16 = 6
            r17 = 0
            r46 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r12, r2)
            java.lang.Object r2 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r12 = r7 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r16 = 6
            r12 = r12 | 6
            r47 = 0
            r60 = r7
            androidx.compose.runtime.Applier r7 = r11.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x02ac
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02ac:
            r11.startReusableNode()
            boolean r7 = r11.getInserting()
            if (r7 == 0) goto L_0x02b9
            r11.createNode(r5)
            goto L_0x02bc
        L_0x02b9:
            r11.useNode()
        L_0x02bc:
            r11.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r48 = r5
            kotlin.jvm.functions.Function2 r5 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r7, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r7, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r7, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r7, r2, r5)
            r11.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r5)
            int r7 = r12 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.invoke(r5, r11, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r5)
            int r5 = r12 >> 9
            r5 = r5 & 14
            r7 = r11
            r49 = 0
            r50 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r51 = r1
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r3 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r16 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r52 = r7
            r53 = 0
            r54 = r0
            r0 = 859623352(0x333ccfb8, float:4.396108E-8)
            r55 = r1
            java.lang.String r1 = "C1323@50858L76,1322@50799L198:TimePicker.kt#uh7d8r"
            r56 = r2
            r2 = r52
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 0
            r16 = 0
            r17 = r1
            r1 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            boolean r1 = r2.changed((java.lang.Object) r14)
            r15 = r2
            r18 = 0
            r52 = r3
            java.lang.Object r3 = r15.rememberedValue()
            r19 = 0
            if (r1 != 0) goto L_0x036b
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r3 != r1) goto L_0x0369
            goto L_0x036d
        L_0x0369:
            r1 = r3
            goto L_0x037c
        L_0x036b:
            r21 = r1
        L_0x036d:
            r1 = 0
            r20 = r1
            androidx.compose.material3.TimePickerKt$ClockText$3$1$1 r1 = new androidx.compose.material3.TimePickerKt$ClockText$3$1$1
            r1.<init>(r14)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r15.updateRememberedValue(r1)
        L_0x037c:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r15 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r0, r1)
            r16 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r36 = 0
            r37 = 0
            r38 = 65532(0xfffc, float:9.183E-41)
            r0 = r14
            r14 = r41
            r35 = r2
            androidx.compose.material3.TextKt.m2148Text4IGK_g((java.lang.String) r14, (androidx.compose.ui.Modifier) r15, (long) r16, (long) r18, (androidx.compose.ui.text.font.FontStyle) r20, (androidx.compose.ui.text.font.FontWeight) r21, (androidx.compose.ui.text.font.FontFamily) r22, (long) r23, (androidx.compose.ui.text.style.TextDecoration) r25, (androidx.compose.ui.text.style.TextAlign) r26, (long) r27, (int) r29, (boolean) r30, (int) r31, (int) r32, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r33, (androidx.compose.ui.text.TextStyle) r34, (androidx.compose.runtime.Composer) r35, (int) r36, (int) r37, (int) r38)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03d5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03d5:
            androidx.compose.runtime.ScopeUpdateScope r0 = r11.endRestartGroup()
            if (r0 != 0) goto L_0x03de
            r2 = r57
            goto L_0x03ea
        L_0x03de:
            androidx.compose.material3.TimePickerKt$ClockText$4 r1 = new androidx.compose.material3.TimePickerKt$ClockText$4
            r2 = r57
            r1.<init>(r2, r8, r9, r10)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x03ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.ClockText(androidx.compose.material3.TimePickerState, int, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final long ClockText$lambda$29(MutableState<Offset> $center$delegate) {
        return ((Offset) $center$delegate.getValue()).m3013unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void ClockText$lambda$30(MutableState<Offset> $center$delegate, long value) {
        $center$delegate.setValue(Offset.m2992boximpl(value));
    }

    /* access modifiers changed from: private */
    /* renamed from: timeInputOnChange-gIWD5Rc  reason: not valid java name */
    public static final void m2171timeInputOnChangegIWD5Rc(int selection, TimePickerState state, TextFieldValue value, TextFieldValue prevValue, int max, Function1<? super TextFieldValue, Unit> onNewValue) {
        int newValue;
        TextFieldValue textFieldValue;
        if (Intrinsics.areEqual((Object) value.getText(), (Object) prevValue.getText())) {
            onNewValue.invoke(value);
            return;
        }
        if (value.getText().length() == 0) {
            if (Selection.m1956equalsimpl0(selection, Selection.Companion.m1960getHourJiIwxys())) {
                state.setHour$material3_release(0);
            } else {
                state.setMinute$material3_release(0);
            }
            onNewValue.invoke(TextFieldValue.m5551copy3r_uNRQ$default(value, "", 0, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            if (value.getText().length() == 3 && TextRange.m5325getStartimpl(value.m5555getSelectiond9O1mEE()) == 1) {
                newValue = CharsKt.digitToInt(value.getText().charAt(0));
            } else {
                newValue = Integer.parseInt(value.getText());
            }
            if (newValue <= max) {
                if (Selection.m1956equalsimpl0(selection, Selection.Companion.m1960getHourJiIwxys())) {
                    state.setHour$material3_release(newValue);
                    if (newValue > 1 && !state.is24hour()) {
                        state.m2194setSelectioniHAOin8$material3_release(Selection.Companion.m1961getMinuteJiIwxys());
                    }
                } else {
                    state.setMinute$material3_release(newValue);
                }
                if (value.getText().length() <= 2) {
                    textFieldValue = value;
                } else {
                    textFieldValue = TextFieldValue.m5551copy3r_uNRQ$default(value, String.valueOf(value.getText().charAt(0)), 0, (TextRange) null, 6, (Object) null);
                }
                onNewValue.invoke(textFieldValue);
            }
        } catch (IllegalArgumentException | NumberFormatException e) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x075b  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0762  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0815  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0817  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0836  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0842  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011c  */
    /* renamed from: TimePickerTextField-lxUZ_iY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2164TimePickerTextFieldlxUZ_iY(androidx.compose.ui.Modifier r115, androidx.compose.ui.text.input.TextFieldValue r116, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r117, androidx.compose.material3.TimePickerState r118, int r119, androidx.compose.foundation.text.KeyboardOptions r120, androidx.compose.foundation.text.KeyboardActions r121, androidx.compose.material3.TimePickerColors r122, androidx.compose.runtime.Composer r123, int r124, int r125) {
        /*
            r13 = r116
            r7 = r118
            r12 = r119
            r11 = r122
            r10 = r124
            r9 = r125
            r0 = -367523658(0xffffffffea1808b6, float:-4.5949465E25)
            r1 = r123
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TimePickerTextField)P(3,7,4,6,5:c#material3.Selection,2,1)1395@52814L39,1396@52879L29,1397@52961L227,1403@53241L3274,1487@56553L103,1487@56521L135:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r124
            r2 = r9 & 1
            r108 = 4
            r109 = 2
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 6
            r6 = r115
            goto L_0x003e
        L_0x0029:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x003c
            r6 = r115
            boolean r2 = r8.changed((java.lang.Object) r6)
            if (r2 == 0) goto L_0x0038
            r2 = r108
            goto L_0x003a
        L_0x0038:
            r2 = r109
        L_0x003a:
            r1 = r1 | r2
            goto L_0x003e
        L_0x003c:
            r6 = r115
        L_0x003e:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0045
            r1 = r1 | 48
            goto L_0x0055
        L_0x0045:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0055
            boolean r2 = r8.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0052
            r2 = 32
            goto L_0x0054
        L_0x0052:
            r2 = 16
        L_0x0054:
            r1 = r1 | r2
        L_0x0055:
            r2 = r9 & 4
            if (r2 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r117
            goto L_0x0073
        L_0x005e:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0071
            r5 = r117
            boolean r2 = r8.changedInstance(r5)
            if (r2 == 0) goto L_0x006d
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r2 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r2
            goto L_0x0073
        L_0x0071:
            r5 = r117
        L_0x0073:
            r2 = r9 & 8
            if (r2 == 0) goto L_0x007a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x007a:
            r2 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x008a
            boolean r2 = r8.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0087
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r1 = r1 | r2
        L_0x008a:
            r2 = r9 & 16
            r3 = 57344(0xe000, float:8.0356E-41)
            if (r2 == 0) goto L_0x0094
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x0094:
            r2 = r10 & r3
            if (r2 != 0) goto L_0x00a4
            boolean r2 = r8.changed((int) r12)
            if (r2 == 0) goto L_0x00a1
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r2
        L_0x00a4:
            r2 = r9 & 32
            if (r2 == 0) goto L_0x00ae
            r4 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r4
            r4 = r120
            goto L_0x00c4
        L_0x00ae:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r10
            if (r4 != 0) goto L_0x00c2
            r4 = r120
            boolean r14 = r8.changed((java.lang.Object) r4)
            if (r14 == 0) goto L_0x00be
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r1 = r1 | r14
            goto L_0x00c4
        L_0x00c2:
            r4 = r120
        L_0x00c4:
            r14 = r9 & 64
            r110 = 3670016(0x380000, float:5.142788E-39)
            if (r14 == 0) goto L_0x00d0
            r15 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r15
            r15 = r121
            goto L_0x00e6
        L_0x00d0:
            r15 = r10 & r110
            if (r15 != 0) goto L_0x00e4
            r15 = r121
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00df
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r1 = r1 | r16
            goto L_0x00e6
        L_0x00e4:
            r15 = r121
        L_0x00e6:
            r3 = r9 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00ee
            r3 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ec:
            r1 = r1 | r3
            goto L_0x00ff
        L_0x00ee:
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r10
            if (r3 != 0) goto L_0x00ff
            boolean r3 = r8.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x00fc
            r3 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ec
        L_0x00fc:
            r3 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ec
        L_0x00ff:
            r3 = r1
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r3
            r0 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r0) goto L_0x011c
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0110
            goto L_0x011c
        L_0x0110:
            r8.skipToGroupEnd()
            r61 = r3
            r111 = r4
            r13 = r7
            r11 = r12
            r12 = r8
            goto L_0x083b
        L_0x011c:
            if (r2 == 0) goto L_0x0127
            androidx.compose.foundation.text.KeyboardOptions$Companion r0 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r0 = r0.getDefault()
            r111 = r0
            goto L_0x0129
        L_0x0127:
            r111 = r4
        L_0x0129:
            if (r14 == 0) goto L_0x0134
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            r112 = r0
            goto L_0x0136
        L_0x0134:
            r112 = r15
        L_0x0136:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0145
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1385)"
            r2 = -367523658(0xffffffffea1808b6, float:-4.5949465E25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x0145:
            r4 = 0
            r0 = r4
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = 0
            r14 = r8
            r15 = 0
            java.lang.Object r4 = r14.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r121 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r4 != r0) goto L_0x0172
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r14.updateRememberedValue(r0)
            goto L_0x0173
        L_0x0172:
            r0 = r4
        L_0x0173:
            r8.endReplaceableGroup()
            r4 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r113 = 0
            r0 = r113
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = 0
            r14 = r8
            r15 = 0
            r120 = r0
            java.lang.Object r0 = r14.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r121 = r1
            java.lang.Object r1 = r17.getEmpty()
            if (r0 != r1) goto L_0x01ad
            r1 = 0
            androidx.compose.ui.focus.FocusRequester r17 = new androidx.compose.ui.focus.FocusRequester
            r17.<init>()
            r1 = r17
            r14.updateRememberedValue(r1)
            goto L_0x01ae
        L_0x01ad:
            r1 = r0
        L_0x01ae:
            r8.endReplaceableGroup()
            r2 = r1
            androidx.compose.ui.focus.FocusRequester r2 = (androidx.compose.ui.focus.FocusRequester) r2
            androidx.compose.material3.OutlinedTextFieldDefaults r14 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r0 = 1
            long r23 = r11.m2158timeSelectorContainerColorvNxB06k$material3_release(r0)
            long r25 = r11.m2158timeSelectorContainerColorvNxB06k$material3_release(r0)
            long r15 = r11.m2159timeSelectorContentColorvNxB06k$material3_release(r0)
            r17 = 0
            r19 = 0
            r21 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r101 = 0
            r102 = 0
            r103 = 0
            r104 = 0
            r105 = 3072(0xc00, float:4.305E-42)
            r106 = 2147483598(0x7fffffce, float:NaN)
            r107 = 4095(0xfff, float:5.738E-42)
            r100 = r8
            androidx.compose.material3.TextFieldColors r15 = r14.m1894colors0hiis_0(r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r101, r102, r103, r104, r105, r106, r107)
            int r0 = r118.m2191getSelectionJiIwxys$material3_release()
            boolean r14 = androidx.compose.material3.Selection.m1956equalsimpl0(r12, r0)
            r0 = r3 & 14
            r20 = r0
            r21 = 0
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            androidx.compose.foundation.layout.Arrangement r0 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r1 = r0.getTop()
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r0 = r0.getStart()
            int r16 = r20 >> 3
            r16 = r16 & 14
            int r17 = r20 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r120 = r2
            r2 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r1, r0, r8, r2)
            int r16 = r20 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r22 = r16
            r23 = 0
            r121 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r18 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r7)
            java.lang.Object r1 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r19 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r7)
            java.lang.Object r4 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r5, r7)
            java.lang.Object r5 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r0 = r0.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.materializerOf(r115)
            int r6 = r22 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | 6
            r24 = r6
            r6 = r16
            r25 = 0
            androidx.compose.runtime.Applier r9 = r8.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x02eb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02eb:
            r8.startReusableNode()
            boolean r9 = r8.getInserting()
            if (r9 == 0) goto L_0x02f8
            r8.createNode(r0)
            goto L_0x02fb
        L_0x02f8:
            r8.useNode()
        L_0x02fb:
            r8.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2865constructorimpl(r8)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r26 = r0
            kotlin.jvm.functions.Function2 r0 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r2, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r1, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r9, r5, r0)
            r8.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r9 = r24 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r6.invoke(r0, r8, r9)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r0)
            int r0 = r24 >> 9
            r27 = r0 & 14
            r9 = r8
            r28 = 0
            r0 = 276693704(0x107e02c8, float:5.009481E-29)
            r16 = r1
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r1 = r20 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r29 = r1 | 6
            r30 = r0
            androidx.compose.foundation.layout.ColumnScope r30 = (androidx.compose.foundation.layout.ColumnScope) r30
            r1 = r9
            r56 = 0
            r0 = 896149777(0x356a2911, float:8.723155E-7)
            r17 = r2
            java.lang.String r2 = "C1414@53673L202,1422@53885L2043,1473@56082L206,1480@56355L9,1482@56417L10,1469@55938L571:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r2)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "1405@53308L320"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            if (r14 != 0) goto L_0x03ea
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.tokens.TimeInputTokens r2 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r2 = r2.m2760getTimeFieldContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r31 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            r32 = r1
            float r1 = r31.m2759getTimeFieldContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m614sizeVpY3zN4(r0, r2, r1)
            androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.Companion
            int r1 = r1.m1960getHourJiIwxys()
            boolean r1 = androidx.compose.material3.Selection.m1956equalsimpl0(r12, r1)
            if (r1 == 0) goto L_0x03a2
            int r1 = r118.getHourForDisplay$material3_release()
            goto L_0x03a6
        L_0x03a2:
            int r1 = r118.getMinute()
        L_0x03a6:
            int r2 = r3 >> 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | 6
            r31 = r4
            int r4 = r3 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            int r4 = r3 >> 9
            r33 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r33
            r33 = r2 | r4
            r57 = r26
            r26 = r121
            r59 = r16
            r58 = r18
            r4 = r32
            r11 = r120
            r60 = r17
            r2 = r118
            r61 = r3
            r3 = r119
            r120 = r4
            r121 = r9
            r10 = r19
            r62 = r31
            r9 = r113
            r4 = r122
            r63 = r5
            r5 = r120
            r64 = r6
            r6 = r33
            m2165TimeSelectoruXwN82Y(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0406
        L_0x03ea:
            r11 = r120
            r120 = r1
            r61 = r3
            r62 = r4
            r63 = r5
            r64 = r6
            r59 = r16
            r60 = r17
            r58 = r18
            r10 = r19
            r57 = r26
            r26 = r121
            r121 = r9
            r9 = r113
        L_0x0406:
            r120.endReplaceableGroup()
            androidx.compose.material3.Selection$Companion r0 = androidx.compose.material3.Selection.Companion
            int r0 = r0.m1961getMinuteJiIwxys()
            boolean r0 = androidx.compose.material3.Selection.m1956equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x041c
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2048getTimePickerMinuteTextFieldadMyvUU()
            goto L_0x0422
        L_0x041c:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2044getTimePickerHourTextFieldadMyvUU()
        L_0x0422:
            r6 = r120
            java.lang.String r1 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r6, r9)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r31 = visible(r0, r14)
            r0 = 0
            r32 = r0
            r33 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r4 = 0
            int r2 = r32 >> 3
            r2 = r2 & 14
            int r3 = r32 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r4, r6, r2)
            int r2 = r32 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r34 = r2
            r35 = 0
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r6.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 6
            r16 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r9, r7)
            java.lang.Object r9 = r6.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 6
            r16 = 0
            r123 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r7)
            java.lang.Object r0 = r6.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 6
            r16 = 0
            r18 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r4, r7)
            java.lang.Object r4 = r6.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r7 = r4
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r2 = r2.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r31)
            int r5 = r34 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | 6
            r36 = r5
            r37 = 0
            androidx.compose.runtime.Applier r5 = r6.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x04d5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04d5:
            r6.startReusableNode()
            boolean r5 = r6.getInserting()
            if (r5 == 0) goto L_0x04e2
            r6.createNode(r2)
            goto L_0x04e5
        L_0x04e2:
            r6.useNode()
        L_0x04e5:
            r6.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2865constructorimpl(r6)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r19 = r2
            kotlin.jvm.functions.Function2 r2 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r5, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r5, r9, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r5, r0, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r5, r7, r2)
            r6.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r6)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r2)
            int r5 = r36 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.invoke(r2, r6, r5)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6.startReplaceableGroup(r2)
            int r2 = r36 >> 9
            r38 = r2 & 14
            r5 = r6
            r39 = 0
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r16 = r0
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r32 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r40 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r2 = r5
            r41 = r0
            r42 = 0
            r0 = -1694936386(0xffffffff9af952be, float:-1.03117663E-22)
            r43 = r3
            java.lang.String r3 = "C1429@54221L92,1435@54515L7,1441@54784L11,1442@54848L11,1423@53931L1987:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r0, r11)
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m2760getTimeFieldContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.TimeInputTokens r17 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            r44 = r4
            float r4 = r17.m2759getTimeFieldContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m614sizeVpY3zN4(r0, r3, r4)
            r3 = 0
            r4 = 0
            r17 = r3
            r3 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            boolean r3 = r2.changed((java.lang.Object) r1)
            r45 = r2
            r46 = 0
            r47 = r4
            java.lang.Object r4 = r45.rememberedValue()
            r48 = 0
            if (r3 != 0) goto L_0x05a7
            androidx.compose.runtime.Composer$Companion r49 = androidx.compose.runtime.Composer.Companion
            r50 = r3
            java.lang.Object r3 = r49.getEmpty()
            if (r4 != r3) goto L_0x05a1
            goto L_0x05a9
        L_0x05a1:
            r49 = r1
            r3 = r4
            r1 = r45
            goto L_0x05bc
        L_0x05a7:
            r50 = r3
        L_0x05a9:
            r3 = 0
            r49 = r3
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1 r3 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
            r3.<init>(r1)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r49 = r1
            r1 = r45
            r1.updateRememberedValue(r3)
        L_0x05bc:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1 = 1
            r4 = 0
            r17 = r2
            r2 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r2, r3, r1, r4)
            r1 = r17
            r45 = r19
            r2 = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 6
            r17 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            r46 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r4, r3)
            java.lang.Object r3 = r1.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r0 = r3
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r46 = r5
            r5 = r0
            androidx.compose.ui.graphics.Brush$Companion r65 = androidx.compose.ui.graphics.Brush.Companion
            r0 = 0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r3 = r3.m3288getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3243boximpl(r3)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r3)
            r3 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r47 = r4.m3288getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3243boximpl(r47)
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r47 = r6
            androidx.compose.material3.MaterialTheme r6 = androidx.compose.material3.MaterialTheme.INSTANCE
            r48 = r7
            r7 = 6
            androidx.compose.material3.ColorScheme r6 = r6.getColorScheme(r1, r7)
            long r6 = r6.m1618getPrimary0d7_KjU()
            androidx.compose.ui.graphics.Color r6 = androidx.compose.ui.graphics.Color.m3243boximpl(r6)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r6)
            r6 = 1063675494(0x3f666666, float:0.9)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            androidx.compose.material3.MaterialTheme r7 = androidx.compose.material3.MaterialTheme.INSTANCE
            r50 = r8
            r8 = 6
            androidx.compose.material3.ColorScheme r7 = r7.getColorScheme(r1, r8)
            long r7 = r7.m1618getPrimary0d7_KjU()
            androidx.compose.ui.graphics.Color r7 = androidx.compose.ui.graphics.Color.m3243boximpl(r7)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r7)
            r7 = 1063675494(0x3f666666, float:0.9)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r51 = r8.m3288getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m3243boximpl(r51)
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            r8 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            androidx.compose.ui.graphics.Color$Companion r17 = androidx.compose.ui.graphics.Color.Companion
            long r51 = r17.m3288getTransparent0d7_KjU()
            r53 = r9
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m3243boximpl(r51)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)
            r9 = 6
            kotlin.Pair[] r9 = new kotlin.Pair[r9]
            r51 = 0
            r9[r51] = r0
            r0 = 1
            r9[r0] = r3
            r9[r109] = r4
            r0 = 3
            r9[r0] = r6
            r9[r108] = r7
            r0 = 5
            r9[r0] = r8
            r70 = 14
            r71 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r66 = r9
            androidx.compose.ui.graphics.Brush r0 = androidx.compose.ui.graphics.Brush.Companion.m3201verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r65, (kotlin.Pair[]) r66, (float) r67, (float) r68, (int) r69, (int) r70, (java.lang.Object) r71)
            r65 = r14
            r14 = r0
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2 r0 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
            r0.<init>(r13, r10, r15)
            r3 = 1
            r4 = 2133555260(0x7f2b783c, float:2.2792228E38)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r4, r3, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r66 = r15
            r15 = r0
            int r0 = r61 >> 3
            r0 = r0 & 14
            r3 = 100666368(0x6000c00, float:2.408294E-35)
            r0 = r0 | r3
            int r3 = r61 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            int r3 = r61 << 3
            r3 = r3 & r110
            r0 = r0 | r3
            int r3 = r61 << 3
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r17 = r0 | r3
            r3 = 1
            r4 = 0
            r52 = r44
            r7 = 0
            r44 = r18
            r8 = 1
            r6 = r50
            r9 = 0
            r67 = r121
            r0 = r51
            r50 = r53
            r18 = 0
            r68 = r10
            r10 = r18
            r18 = 0
            r114 = r11
            r11 = r18
            r12 = r18
            r18 = 199680(0x30c00, float:2.79811E-40)
            r19 = 7696(0x1e10, float:1.0784E-41)
            r51 = r123
            r53 = r16
            r0 = r116
            r69 = r49
            r49 = r1
            r1 = r117
            r120 = r6
            r121 = r47
            r6 = r111
            r47 = r48
            r7 = r112
            r13 = r68
            r16 = r49
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r49)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r46)
            r121.endReplaceableGroup()
            r121.endNode()
            r121.endReplaceableGroup()
            r121.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 0
            float r2 = SupportLabelTop
            r4 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.m497offsetVpY3zN4$default(r0, r1, r2, r3, r4)
            androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2 r1 = androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.Modifier r32 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r0, r1)
            androidx.compose.material3.Selection$Companion r0 = androidx.compose.material3.Selection.Companion
            int r0 = r0.m1960getHourJiIwxys()
            r11 = r119
            boolean r0 = androidx.compose.material3.Selection.m1956equalsimpl0(r11, r0)
            if (r0 == 0) goto L_0x0762
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2041getTimePickerHouradMyvUU()
            goto L_0x0768
        L_0x0762:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2045getTimePickerMinuteadMyvUU()
        L_0x0768:
            r1 = r121
            r2 = 0
            java.lang.String r31 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r1, r2)
            androidx.compose.material3.tokens.TimeInputTokens r0 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r0 = r0.getTimeFieldSupportingTextColor()
            r2 = 6
            long r33 = androidx.compose.material3.ColorSchemeKt.toColor(r0, r1, r2)
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r0.getTypography(r1, r2)
            androidx.compose.material3.tokens.TimeInputTokens r2 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r2 = r2.getTimeFieldSupportingTextFont()
            androidx.compose.ui.text.TextStyle r51 = androidx.compose.material3.TypographyKt.fromToken(r0, r2)
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r53 = 0
            r54 = 0
            r55 = 65528(0xfff8, float:9.1824E-41)
            r52 = r1
            androidx.compose.material3.TextKt.m2148Text4IGK_g((java.lang.String) r31, (androidx.compose.ui.Modifier) r32, (long) r33, (long) r35, (androidx.compose.ui.text.font.FontStyle) r37, (androidx.compose.ui.text.font.FontWeight) r38, (androidx.compose.ui.text.font.FontFamily) r39, (long) r40, (androidx.compose.ui.text.style.TextDecoration) r42, (androidx.compose.ui.text.style.TextAlign) r43, (long) r44, (int) r46, (boolean) r47, (int) r48, (int) r49, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r50, (androidx.compose.ui.text.TextStyle) r51, (androidx.compose.runtime.Composer) r52, (int) r53, (int) r54, (int) r55)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r67)
            r120.endReplaceableGroup()
            r120.endNode()
            r120.endReplaceableGroup()
            r120.endReplaceableGroup()
            int r0 = r118.m2191getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection r0 = androidx.compose.material3.Selection.m1953boximpl(r0)
            androidx.compose.material3.Selection r1 = androidx.compose.material3.Selection.m1953boximpl(r119)
            int r2 = r61 >> 9
            r2 = r2 & 14
            r2 = r2 | 384(0x180, float:5.38E-43)
            int r3 = r61 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 0
            r5 = 1618982084(0x607fb4c4, float:7.370227E19)
            r12 = r120
            r12.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r5)
            r13 = r118
            boolean r5 = r12.changed((java.lang.Object) r13)
            boolean r6 = r12.changed((java.lang.Object) r1)
            r5 = r5 | r6
            r6 = r114
            boolean r7 = r12.changed((java.lang.Object) r6)
            r5 = r5 | r7
            r7 = r12
            r8 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r10 = 0
            if (r5 != 0) goto L_0x0817
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r9 != r14) goto L_0x0815
            goto L_0x0817
        L_0x0815:
            r4 = r9
            goto L_0x0824
        L_0x0817:
            r14 = 0
            androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1 r15 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$2$1
            r15.<init>(r13, r11, r6, r4)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r4 = r15
            r7.updateRememberedValue(r4)
        L_0x0824:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r1 = 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r4, (androidx.compose.runtime.Composer) r12, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0839
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0839:
            r15 = r112
        L_0x083b:
            androidx.compose.runtime.ScopeUpdateScope r14 = r12.endRestartGroup()
            if (r14 != 0) goto L_0x0842
            goto L_0x0863
        L_0x0842:
            androidx.compose.material3.TimePickerKt$TimePickerTextField$3 r16 = new androidx.compose.material3.TimePickerKt$TimePickerTextField$3
            r0 = r16
            r1 = r115
            r2 = r116
            r3 = r117
            r4 = r118
            r5 = r119
            r6 = r111
            r7 = r15
            r8 = r122
            r9 = r124
            r10 = r125
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0863:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2164TimePickerTextFieldlxUZ_iY(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularLayout-uFdPcIQ  reason: not valid java name */
    public static final void m2162CircularLayoutuFdPcIQ(Modifier modifier, float radius, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        float f = radius;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation($composer2, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1501@56854L1669:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, $dirty2, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1496)");
            }
            MeasurePolicy timePickerKt$CircularLayout$1 = new TimePickerKt$CircularLayout$1(f);
            int $changed$iv = (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112);
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier4);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            Modifier modifier5 = modifier4;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer2);
            int i4 = $changed$iv;
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, timePickerKt$CircularLayout$1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TimePickerKt$CircularLayout$2(modifier3, radius, content, $changed, i));
        }
    }

    /* renamed from: numberContentDescription-YKJpE6Y  reason: not valid java name */
    public static final String m2170numberContentDescriptionYKJpE6Y(int selection, boolean is24Hour, int number, Composer $composer, int $changed) {
        int id;
        ComposerKt.sourceInformationMarkerStart($composer, 1826155772, "C(numberContentDescription)P(2:c#material3.Selection)1554@58898L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826155772, $changed, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1541)");
        }
        if (Selection.m1956equalsimpl0(selection, Selection.Companion.m1961getMinuteJiIwxys())) {
            id = Strings.Companion.m2047getTimePickerMinuteSuffixadMyvUU();
        } else if (is24Hour) {
            id = Strings.Companion.m2039getTimePicker24HourSuffixadMyvUU();
        } else {
            id = Strings.Companion.m2043getTimePickerHourSuffixadMyvUU();
        }
        String r1 = Strings_androidKt.m2054getStringiSCLEhQ(id, new Object[]{Integer.valueOf(number)}, $composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return r1;
    }

    /* access modifiers changed from: private */
    public static final Pair<Float, Float> valuesForAnimation(float current, float f) {
        float start = current;
        float end = f;
        if (((double) Math.abs(start - end)) <= 3.141592653589793d) {
            return new Pair<>(Float.valueOf(start), Float.valueOf(end));
        }
        if (((double) start) > 3.141592653589793d && ((double) end) < 3.141592653589793d) {
            end += FullCircle;
        } else if (((double) start) < 3.141592653589793d && ((double) end) > 3.141592653589793d) {
            start += FullCircle;
        }
        return new Pair<>(Float.valueOf(start), Float.valueOf(end));
    }

    /* access modifiers changed from: private */
    public static final float dist(float x1, float y1, int x2, int y2) {
        return (float) Math.hypot((double) (((float) x2) - x1), (double) (((float) y2) - y1));
    }

    /* access modifiers changed from: private */
    public static final float atan(float y, float x) {
        float ret = ((float) Math.atan2((double) y, (double) x)) - 1.5707964f;
        return ret < 0.0f ? FullCircle + ret : ret;
    }

    static {
        List<Integer> listOf = CollectionsKt.listOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = listOf;
        Iterable<Number> $this$map$iv = listOf;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Number intValue : $this$map$iv) {
            destination$iv$iv.add(Integer.valueOf((intValue.intValue() % 12) + 12));
        }
        ExtraHours = (List) destination$iv$iv;
    }

    private static final Modifier visible(Modifier $this$visible, boolean visible) {
        return $this$visible.then(new VisibleModifier(visible, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TimePickerKt$visible$$inlined$debugInspectorInfo$1(visible) : InspectableValueKt.getNoInspectorInfo()));
    }

    /* access modifiers changed from: private */
    public static final String toLocalString(int $this$toLocalString, int minDigits) {
        NumberFormat formatter = NumberFormat.getIntegerInstance();
        formatter.setGroupingUsed(false);
        formatter.setMinimumIntegerDigits(minDigits);
        String format = formatter.format(Integer.valueOf($this$toLocalString));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }
}
