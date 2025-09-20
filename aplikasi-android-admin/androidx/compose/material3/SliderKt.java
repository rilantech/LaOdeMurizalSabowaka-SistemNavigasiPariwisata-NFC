package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aä\u0001\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010.\u001aÈ\u0001\u0010/\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u00100\u001a³\u0001\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020$2\u0019\b\u0002\u00103\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00104\u001a}\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020$H\u0007¢\u0006\u0002\u00105\u001a\u0001\u00106\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020$2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u00107\u001a1\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010>\u001a \u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002\u001a0\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a<\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a(\u0010J\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a\u0010\u0010O\u001a\u00020L2\u0006\u0010+\u001a\u00020,H\u0002\u001a;\u0010P\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\b\u0018\u00010Q*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u0001\u0010Z\u001a\u00020\u0001*\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\b0\\2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\b0\\2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020,2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a0\\2\u001e\u0010`\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160a0\\H\u0002\u001a\\\u0010b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,H\u0002\u001ad\u0010c\u001a\u00020\u0001*\u00020\u00012\u0006\u00109\u001a\u00020:2\u0006\u00102\u001a\u00020$2\u0006\u0010N\u001a\u00020,2\u0006\u0010^\u001a\u00020\u001d2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0\\2\u0012\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0\\2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "RangeSlider", "", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChange", "Lkotlin/Function1;", "modifier", "enabled", "", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Landroidx/compose/material3/SliderPositions;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Slider", "interactionSource", "thumb", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IFLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "Landroidx/compose/runtime/MutableState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float ThumbDefaultElevation = Dp.m7554constructorimpl((float) 1);
    private static final float ThumbHeight;
    /* access modifiers changed from: private */
    public static final float ThumbPressedElevation = Dp.m7554constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final long ThumbSize;
    private static final float ThumbWidth;
    /* access modifiers changed from: private */
    public static final float TickSize = SliderTokens.INSTANCE.m4433getTickMarksContainerSizeD9Ej5fM();
    private static final float TrackHeight = SliderTokens.INSTANCE.m4428getInactiveTrackHeightD9Ej5fM();

    public static final void Slider(float value, Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, SliderColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        ClosedFloatingPointRange closedFloatingPointRange;
        int i2;
        Function0 function0;
        SliderColors colors2;
        SliderColors colors3;
        MutableInteractionSource interactionSource2;
        Composer $composer2;
        boolean enabled2;
        Function0 onValueChangeFinished2;
        int steps2;
        ClosedFloatingPointRange valueRange2;
        Modifier modifier2;
        boolean enabled3;
        SliderColors colors4;
        MutableInteractionSource interactionSource3;
        int $dirty;
        Modifier modifier3;
        boolean enabled4;
        ClosedFloatingPointRange valueRange3;
        int steps3;
        Function0 onValueChangeFinished3;
        MutableInteractionSource mutableInteractionSource;
        int i3;
        int i4;
        Function1<? super Float, Unit> function1 = onValueChange;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation($composer3, "C(Slider)P(7,4,3,1,8,6,5)155@7443L8,156@7503L39,160@7603L705:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i6 & 1) != 0) {
            $dirty2 |= 6;
            float f = value;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        } else {
            float f2 = value;
        }
        if ((i6 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i5 & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i6 & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i5 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            boolean z = enabled;
        } else if ((i5 & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z2 = enabled;
        }
        if ((i5 & 57344) == 0) {
            if ((i6 & 16) == 0) {
                closedFloatingPointRange = valueRange;
                if ($composer3.changed((Object) closedFloatingPointRange)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                closedFloatingPointRange = valueRange;
            }
            i4 = 8192;
            $dirty2 |= i4;
        } else {
            closedFloatingPointRange = valueRange;
        }
        int i9 = i6 & 32;
        if (i9 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = steps;
        } else if ((i5 & 458752) == 0) {
            i2 = steps;
            $dirty2 |= $composer3.changed(i2) ? 131072 : 65536;
        } else {
            i2 = steps;
        }
        int i10 = i6 & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
            function0 = onValueChangeFinished;
        } else if ((i5 & 3670016) == 0) {
            function0 = onValueChangeFinished;
            $dirty2 |= $composer3.changedInstance(function0) ? 1048576 : 524288;
        } else {
            function0 = onValueChangeFinished;
        }
        if ((i5 & 29360128) == 0) {
            if ((i6 & 128) == 0) {
                colors2 = colors;
                if ($composer3.changed((Object) colors2)) {
                    i3 = 8388608;
                    $dirty2 |= i3;
                }
            } else {
                colors2 = colors;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        } else {
            colors2 = colors;
        }
        int i11 = i6 & 256;
        if (i11 != 0) {
            $dirty2 |= 100663296;
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        } else if ((i5 & 234881024) == 0) {
            $dirty2 |= $composer3.changed((Object) interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource3 = interactionSource;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if ((i6 & 16) != 0) {
                    valueRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                } else {
                    valueRange3 = closedFloatingPointRange;
                }
                if (i9 != 0) {
                    steps3 = 0;
                } else {
                    steps3 = i2;
                }
                if (i10 != 0) {
                    onValueChangeFinished3 = null;
                } else {
                    onValueChangeFinished3 = function0;
                }
                if ((i6 & 128) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m3677colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 6, 1023);
                    $dirty2 &= -29360129;
                }
                if (i11 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                    } else {
                        mutableInteractionSource = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier3;
                    enabled3 = enabled4;
                    valueRange2 = valueRange3;
                    steps2 = steps3;
                    colors4 = colors2;
                    onValueChangeFinished2 = onValueChangeFinished3;
                    $dirty = $dirty3;
                    interactionSource3 = mutableInteractionSource;
                } else {
                    modifier2 = modifier3;
                    enabled3 = enabled4;
                    valueRange2 = valueRange3;
                    steps2 = steps3;
                    colors4 = colors2;
                    onValueChangeFinished2 = onValueChangeFinished3;
                    $dirty = $dirty2;
                    interactionSource3 = interactionSource;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i6 & 128) != 0) {
                    colors4 = colors2;
                    valueRange2 = closedFloatingPointRange;
                    onValueChangeFinished2 = function0;
                    steps2 = i2;
                    modifier2 = modifier;
                    enabled3 = enabled;
                    interactionSource3 = interactionSource;
                    $dirty = $dirty2 & -29360129;
                } else {
                    colors4 = colors2;
                    valueRange2 = closedFloatingPointRange;
                    onValueChangeFinished2 = function0;
                    steps2 = i2;
                    modifier2 = modifier;
                    enabled3 = enabled;
                    interactionSource3 = interactionSource;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202044027, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:146)");
            }
            if (steps2 >= 0) {
                int i12 = $dirty;
                interactionSource2 = interactionSource3;
                colors3 = colors4;
                enabled2 = enabled3;
                $composer2 = $composer3;
                SliderImpl(modifier2, enabled3, interactionSource3, onValueChange, onValueChangeFinished2, steps2, value, valueRange2, ComposableLambdaKt.composableLambda($composer3, -1522452856, true, new SliderKt$Slider$3(interactionSource3, colors4, enabled3, $dirty)), ComposableLambdaKt.composableLambda($composer3, 686671625, true, new SliderKt$Slider$4(colors4, enabled3, $dirty)), $composer3, (($dirty >> 6) & 14) | 905969664 | (($dirty >> 6) & 112) | (($dirty >> 18) & 896) | (($dirty << 6) & 7168) | (($dirty >> 6) & 57344) | (458752 & $dirty) | (($dirty << 18) & 3670016) | (($dirty << 9) & 29360128));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        } else {
            $composer3.skipToGroupEnd();
            enabled2 = enabled;
            interactionSource2 = interactionSource;
            int i13 = $dirty2;
            colors3 = colors2;
            valueRange2 = closedFloatingPointRange;
            onValueChangeFinished2 = function0;
            $composer2 = $composer3;
            steps2 = i2;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$Slider$5(value, onValueChange, modifier2, enabled2, valueRange2, steps2, onValueChangeFinished2, colors3, interactionSource2, $changed, i));
        }
    }

    public static final void Slider(float value, Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, Function0<Unit> onValueChangeFinished, SliderColors colors, MutableInteractionSource interactionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> thumb, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> track, int steps, Composer $composer, int $changed, int $changed1, int i) {
        ClosedFloatingPointRange closedFloatingPointRange;
        int steps2;
        Function3 track2;
        Function3 thumb2;
        MutableInteractionSource interactionSource2;
        SliderColors colors2;
        Function0 onValueChangeFinished2;
        ClosedFloatingPointRange valueRange2;
        boolean enabled2;
        Modifier modifier2;
        int $dirty;
        boolean z;
        Modifier modifier3;
        boolean enabled3;
        ClosedFloatingPointRange valueRange3;
        Function0 onValueChangeFinished3;
        SliderColors colors3;
        Modifier modifier4;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource interactionSource4;
        Function3 thumb3;
        Function3 track3;
        Object value$iv$iv;
        int i2;
        int i3;
        Function1<? super Float, Unit> function1 = onValueChange;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(251663723);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(9,4,3,1,10,5!2,7,8)250@11737L8,251@11797L39,271@12381L338:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
            float f = value;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer2.changed(value) ? 4 : 2;
        } else {
            float f2 = value;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i6 = i5 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            Modifier modifier5 = modifier;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier6 = modifier;
        }
        int i7 = i5 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            boolean z2 = enabled;
        } else if ((i4 & 7168) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z3 = enabled;
        }
        if ((i4 & 57344) == 0) {
            if ((i5 & 16) == 0) {
                closedFloatingPointRange = valueRange;
                if ($composer2.changed((Object) closedFloatingPointRange)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                closedFloatingPointRange = valueRange;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            closedFloatingPointRange = valueRange;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function0<Unit> function0 = onValueChangeFinished;
        } else if ((i4 & 458752) == 0) {
            $dirty2 |= $composer2.changedInstance(onValueChangeFinished) ? 131072 : 65536;
        } else {
            Function0<Unit> function02 = onValueChangeFinished;
        }
        if ((i4 & 3670016) == 0) {
            if ((i5 & 64) != 0) {
                SliderColors sliderColors = colors;
            } else if ($composer2.changed((Object) colors)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            SliderColors sliderColors2 = colors;
        }
        int i9 = i5 & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 29360128) == 0) {
            $dirty2 |= $composer2.changed((Object) interactionSource) ? 8388608 : 4194304;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        int i10 = i5 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3 = thumb;
        } else if ((i4 & 234881024) == 0) {
            $dirty2 |= $composer2.changedInstance(thumb) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32 = thumb;
        }
        int i11 = i5 & 512;
        if (i11 != 0) {
            $dirty2 |= 805306368;
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33 = track;
        } else if ((i4 & 1879048192) == 0) {
            $dirty2 |= $composer2.changedInstance(track) ? 536870912 : 268435456;
        } else {
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function34 = track;
        }
        int i12 = i5 & 1024;
        if (i12 != 0) {
            $dirty1 |= 6;
            int i13 = steps;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changed(steps) ? 4 : 2;
        } else {
            int i14 = steps;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            onValueChangeFinished2 = onValueChangeFinished;
            colors2 = colors;
            interactionSource2 = interactionSource;
            thumb2 = thumb;
            track2 = track;
            steps2 = steps;
            int i15 = $dirty2;
            int i16 = $dirty1;
            valueRange2 = closedFloatingPointRange;
        } else {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = enabled;
                }
                if ((i5 & 16) != 0) {
                    valueRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                } else {
                    valueRange3 = closedFloatingPointRange;
                }
                if (i8 != 0) {
                    onValueChangeFinished3 = null;
                } else {
                    onValueChangeFinished3 = onValueChangeFinished;
                }
                if ((i5 & 64) != 0) {
                    colors3 = SliderDefaults.INSTANCE.m3677colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer2, 0, 6, 1023);
                    $dirty2 &= -3670017;
                } else {
                    colors3 = colors;
                }
                if (i9 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    modifier4 = modifier3;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource3 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier4 = modifier3;
                    interactionSource3 = interactionSource;
                }
                if (i10 != 0) {
                    SliderKt$Slider$7 sliderKt$Slider$7 = new SliderKt$Slider$7(interactionSource3, colors3, enabled3, $dirty2);
                    interactionSource4 = interactionSource3;
                    z = true;
                    thumb3 = ComposableLambdaKt.composableLambda($composer2, 1998248322, true, sliderKt$Slider$7);
                } else {
                    interactionSource4 = interactionSource3;
                    z = true;
                    thumb3 = thumb;
                }
                if (i11 != 0) {
                    track3 = ComposableLambdaKt.composableLambda($composer2, 1543282935, z, new SliderKt$Slider$8(colors3, enabled3, $dirty2));
                } else {
                    track3 = track;
                }
                if (i12 != 0) {
                    thumb2 = thumb3;
                    track2 = track3;
                    steps2 = 0;
                    enabled2 = enabled3;
                    valueRange2 = valueRange3;
                    onValueChangeFinished2 = onValueChangeFinished3;
                    colors2 = colors3;
                    interactionSource2 = interactionSource4;
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                } else {
                    steps2 = steps;
                    thumb2 = thumb3;
                    track2 = track3;
                    enabled2 = enabled3;
                    valueRange2 = valueRange3;
                    onValueChangeFinished2 = onValueChangeFinished3;
                    colors2 = colors3;
                    interactionSource2 = interactionSource4;
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i5 & 64) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    onValueChangeFinished2 = onValueChangeFinished;
                    colors2 = colors;
                    interactionSource2 = interactionSource;
                    thumb2 = thumb;
                    track2 = track;
                    steps2 = steps;
                    valueRange2 = closedFloatingPointRange;
                    $dirty = -3670017 & $dirty2;
                    z = true;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    onValueChangeFinished2 = onValueChangeFinished;
                    colors2 = colors;
                    interactionSource2 = interactionSource;
                    thumb2 = thumb;
                    track2 = track;
                    steps2 = steps;
                    valueRange2 = closedFloatingPointRange;
                    z = true;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(251663723, $dirty, $dirty1, "androidx.compose.material3.Slider (Slider.kt:243)");
            }
            if (steps2 >= 0 ? z : false) {
                int i17 = $dirty1;
                int i18 = $dirty;
                SliderImpl(modifier2, enabled2, interactionSource2, onValueChange, onValueChangeFinished2, steps2, value, valueRange2, thumb2, track2, $composer2, (($dirty >> 6) & 14) | (($dirty >> 6) & 112) | (($dirty >> 15) & 896) | (($dirty << 6) & 7168) | (($dirty >> 3) & 57344) | (($dirty1 << 15) & 458752) | (($dirty << 18) & 3670016) | (($dirty << 9) & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SliderKt$Slider$10(value, onValueChange, modifier2, enabled2, valueRange2, onValueChangeFinished2, colors2, interactionSource2, thumb2, track2, steps2, $changed, $changed1, i));
    }

    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, SliderColors colors, Composer $composer, int $changed, int i) {
        boolean enabled2;
        ClosedFloatingPointRange valueRange2;
        int steps2;
        Function0 onValueChangeFinished2;
        SliderColors sliderColors;
        SliderColors colors2;
        Composer $composer2;
        boolean enabled3;
        Function0 onValueChangeFinished3;
        int steps3;
        ClosedFloatingPointRange valueRange3;
        Modifier modifier2;
        boolean enabled4;
        SliderColors colors3;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        Modifier modifier3;
        int i2;
        int i3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = value;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function1 = onValueChange;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(6,3,2,1,7,5,4)328@15054L8,330@15126L39,331@15223L39,335@15320L988:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) closedFloatingPointRange) ? 4 : 2;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i6 = i5 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i5 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if ((i4 & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if ((i4 & 57344) == 0) {
            if ((i5 & 16) == 0) {
                valueRange2 = valueRange;
                if ($composer3.changed((Object) valueRange2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                valueRange2 = valueRange;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            valueRange2 = valueRange;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            steps2 = steps;
        } else if ((i4 & 458752) == 0) {
            steps2 = steps;
            $dirty2 |= $composer3.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i9 = i5 & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            onValueChangeFinished2 = onValueChangeFinished;
        } else if ((i4 & 3670016) == 0) {
            onValueChangeFinished2 = onValueChangeFinished;
            $dirty2 |= $composer3.changedInstance(onValueChangeFinished2) ? 1048576 : 524288;
        } else {
            onValueChangeFinished2 = onValueChangeFinished;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) == 0) {
                sliderColors = colors;
                if ($composer3.changed((Object) sliderColors)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                sliderColors = colors;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            sliderColors = colors;
        }
        if (($dirty2 & 23967451) != 4793490 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    enabled2 = true;
                }
                if ((i5 & 16) != 0) {
                    $dirty2 &= -57345;
                    valueRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i8 != 0) {
                    steps2 = 0;
                }
                if (i9 != 0) {
                    onValueChangeFinished2 = null;
                }
                if ((i5 & 128) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & -29360129;
                    valueRange3 = valueRange2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    steps3 = steps2;
                    colors3 = SliderDefaults.INSTANCE.m3677colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 6, 1023);
                    enabled4 = enabled2;
                } else {
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    valueRange3 = valueRange2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    steps3 = steps2;
                    enabled4 = enabled2;
                    colors3 = sliderColors;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i5 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i5 & 128) != 0) {
                    modifier2 = modifier;
                    $dirty = $dirty2 & -29360129;
                    valueRange3 = valueRange2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    steps3 = steps2;
                    enabled4 = enabled2;
                    colors3 = sliderColors;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    valueRange3 = valueRange2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    steps3 = steps2;
                    enabled4 = enabled2;
                    colors3 = sliderColors;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743091416, $dirty, -1, "androidx.compose.material3.RangeSlider (Slider.kt:319)");
            }
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer3;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv$iv;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer3;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv$iv2;
            if (steps3 >= 0) {
                MutableInteractionSource mutableInteractionSource = startInteractionSource;
                int i10 = $dirty;
                colors2 = colors3;
                enabled3 = enabled4;
                $composer2 = $composer3;
                RangeSliderImpl(modifier2, value, onValueChange, enabled4, valueRange3, steps3, onValueChangeFinished3, startInteractionSource, endInteractionSource, ComposableLambdaKt.composableLambda($composer3, 1361279243, true, new SliderKt$RangeSlider$2(startInteractionSource, colors3, enabled4, $dirty)), ComposableLambdaKt.composableLambda($composer3, 741565023, true, new SliderKt$RangeSlider$3(endInteractionSource, colors3, enabled4, $dirty)), ComposableLambdaKt.composableLambda($composer3, -298726816, true, new SliderKt$RangeSlider$4(colors3, enabled4, $dirty)), $composer2, (($dirty >> 6) & 14) | 918552576 | (($dirty << 3) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016), 54, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            int i11 = $dirty2;
            enabled3 = enabled2;
            colors2 = sliderColors;
            valueRange3 = valueRange2;
            onValueChangeFinished3 = onValueChangeFinished2;
            steps3 = steps2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSlider$5(value, onValueChange, modifier2, enabled3, valueRange3, steps3, onValueChangeFinished3, colors2, $changed, i));
        }
    }

    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, Function0<Unit> onValueChangeFinished, SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> startThumb, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> endThumb, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> track, int steps, Composer $composer, int $changed, int $changed1, int i) {
        Composer $composer2;
        int steps2;
        Function3 track2;
        Function3 track3;
        Function3 endThumb2;
        MutableInteractionSource endInteractionSource2;
        MutableInteractionSource endInteractionSource3;
        SliderColors colors2;
        Function0 onValueChangeFinished2;
        ClosedFloatingPointRange valueRange2;
        boolean enabled2;
        Modifier modifier2;
        int steps3;
        Function3 track4;
        Function3 endThumb3;
        Function3 startThumb2;
        MutableInteractionSource endInteractionSource4;
        MutableInteractionSource startInteractionSource2;
        SliderColors colors3;
        Function0 onValueChangeFinished3;
        ClosedFloatingPointRange valueRange3;
        boolean enabled3;
        Modifier modifier3;
        int $dirty;
        boolean z;
        Modifier modifier4;
        boolean enabled4;
        Modifier modifier5;
        ClosedFloatingPointRange valueRange4;
        Function0 onValueChangeFinished4;
        ClosedFloatingPointRange valueRange5;
        int $dirty2;
        SliderColors colors4;
        MutableInteractionSource startInteractionSource3;
        MutableInteractionSource endInteractionSource5;
        MutableInteractionSource startInteractionSource4;
        Function3 startThumb3;
        Function3 endThumb4;
        Function3 track5;
        Object value$iv$iv;
        Object value$iv$iv2;
        int i2;
        int i3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = value;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function1 = onValueChange;
        int i4 = $changed;
        int i5 = $changed1;
        int i6 = i;
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)435@20161L8,436@20226L39,437@20320L39,464@21150L445:Slider.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty3 |= $composer3.changed((Object) closedFloatingPointRange) ? 4 : 2;
        }
        if ((i6 & 2) != 0) {
            $dirty3 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i6 & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            Modifier modifier6 = modifier;
        } else if ((i4 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier7 = modifier;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            $dirty3 |= 3072;
            boolean z2 = enabled;
        } else if ((i4 & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z3 = enabled;
        }
        if ((i4 & 57344) == 0) {
            if ((i6 & 16) != 0) {
                ClosedFloatingPointRange<Float> closedFloatingPointRange2 = valueRange;
            } else if ($composer3.changed((Object) valueRange)) {
                i3 = 16384;
                $dirty3 |= i3;
            }
            i3 = 8192;
            $dirty3 |= i3;
        } else {
            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = valueRange;
        }
        int i9 = i6 & 32;
        if (i9 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function0<Unit> function0 = onValueChangeFinished;
        } else if ((i4 & 458752) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChangeFinished) ? 131072 : 65536;
        } else {
            Function0<Unit> function02 = onValueChangeFinished;
        }
        if ((i4 & 3670016) == 0) {
            if ((i6 & 64) != 0) {
                SliderColors sliderColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i2 = 1048576;
                $dirty3 |= i2;
            }
            i2 = 524288;
            $dirty3 |= i2;
        } else {
            SliderColors sliderColors2 = colors;
        }
        int i10 = i6 & 128;
        if (i10 != 0) {
            $dirty3 |= 12582912;
            MutableInteractionSource mutableInteractionSource = startInteractionSource;
        } else if ((i4 & 29360128) == 0) {
            $dirty3 |= $composer3.changed((Object) startInteractionSource) ? 8388608 : 4194304;
        } else {
            MutableInteractionSource mutableInteractionSource2 = startInteractionSource;
        }
        int i11 = i6 & 256;
        if (i11 != 0) {
            $dirty3 |= 100663296;
            MutableInteractionSource mutableInteractionSource3 = endInteractionSource;
        } else if ((i4 & 234881024) == 0) {
            $dirty3 |= $composer3.changed((Object) endInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource4 = endInteractionSource;
        }
        int i12 = i6 & 512;
        if (i12 != 0) {
            $dirty3 |= 805306368;
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3 = startThumb;
        } else if ((i4 & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(startThumb) ? 536870912 : 268435456;
        } else {
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32 = startThumb;
        }
        int i13 = i6 & 1024;
        if (i13 != 0) {
            $dirty1 |= 6;
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33 = endThumb;
        } else if ((i5 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(endThumb) ? 4 : 2;
        } else {
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function34 = endThumb;
        }
        int i14 = i6 & 2048;
        if (i14 != 0) {
            $dirty1 |= 48;
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function35 = track;
        } else if ((i5 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(track) ? 32 : 16;
        } else {
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function36 = track;
        }
        int i15 = i6 & 4096;
        if (i15 != 0) {
            $dirty1 |= 384;
            int i16 = steps;
        } else if ((i5 & 896) == 0) {
            $dirty1 |= $composer3.changed(steps) ? 256 : 128;
        } else {
            int i17 = steps;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty1 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            valueRange2 = valueRange;
            onValueChangeFinished2 = onValueChangeFinished;
            colors2 = colors;
            endInteractionSource3 = startInteractionSource;
            endInteractionSource2 = endInteractionSource;
            endThumb2 = startThumb;
            track3 = endThumb;
            track2 = track;
            steps2 = steps;
            int i18 = $dirty3;
            int i19 = $dirty1;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
                }
                if (i8 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if ((i6 & 16) != 0) {
                    modifier5 = modifier4;
                    valueRange4 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty3 &= -57345;
                } else {
                    modifier5 = modifier4;
                    valueRange4 = valueRange;
                }
                if (i9 != 0) {
                    onValueChangeFinished4 = null;
                } else {
                    onValueChangeFinished4 = onValueChangeFinished;
                }
                if ((i6 & 64) != 0) {
                    valueRange5 = valueRange4;
                    $dirty2 = $dirty3 & -3670017;
                    colors4 = SliderDefaults.INSTANCE.m3677colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 6, 1023);
                } else {
                    valueRange5 = valueRange4;
                    $dirty2 = $dirty3;
                    colors4 = colors;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv2 = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    startInteractionSource3 = (MutableInteractionSource) value$iv$iv2;
                } else {
                    startInteractionSource3 = startInteractionSource;
                }
                if (i11 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv2 = $composer3;
                    Object it$iv$iv3 = $this$cache$iv$iv2.rememberedValue();
                    if (it$iv$iv3 == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj3 = it$iv$iv3;
                        $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj4 = it$iv$iv3;
                        Object it$iv$iv4 = $this$cache$iv$iv2;
                        value$iv$iv = obj4;
                    }
                    $composer3.endReplaceableGroup();
                    endInteractionSource5 = (MutableInteractionSource) value$iv$iv;
                } else {
                    endInteractionSource5 = endInteractionSource;
                }
                if (i12 != 0) {
                    SliderKt$RangeSlider$8 sliderKt$RangeSlider$8 = new SliderKt$RangeSlider$8(startInteractionSource3, colors4, enabled4, $dirty2);
                    startInteractionSource4 = startInteractionSource3;
                    z = true;
                    startThumb3 = ComposableLambdaKt.composableLambda($composer3, 585242822, true, sliderKt$RangeSlider$8);
                } else {
                    startInteractionSource4 = startInteractionSource3;
                    z = true;
                    startThumb3 = startThumb;
                }
                if (i13 != 0) {
                    endThumb4 = ComposableLambdaKt.composableLambda($composer3, 1397395775, z, new SliderKt$RangeSlider$9(endInteractionSource5, colors4, enabled4, $dirty2));
                } else {
                    endThumb4 = endThumb;
                }
                if (i14 != 0) {
                    track5 = ComposableLambdaKt.composableLambda($composer3, -2139066097, z, new SliderKt$RangeSlider$10(colors4, enabled4, $dirty2));
                } else {
                    track5 = track;
                }
                if (i15 != 0) {
                    valueRange3 = valueRange5;
                    endInteractionSource4 = endInteractionSource5;
                    colors3 = colors4;
                    startThumb2 = startThumb3;
                    endThumb3 = endThumb4;
                    track4 = track5;
                    steps3 = 0;
                    enabled3 = enabled4;
                    onValueChangeFinished3 = onValueChangeFinished4;
                    startInteractionSource2 = startInteractionSource4;
                    modifier3 = modifier5;
                    $dirty = $dirty2;
                } else {
                    valueRange3 = valueRange5;
                    steps3 = steps;
                    endInteractionSource4 = endInteractionSource5;
                    colors3 = colors4;
                    startThumb2 = startThumb3;
                    endThumb3 = endThumb4;
                    track4 = track5;
                    enabled3 = enabled4;
                    onValueChangeFinished3 = onValueChangeFinished4;
                    startInteractionSource2 = startInteractionSource4;
                    modifier3 = modifier5;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i6 & 64) != 0) {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    valueRange3 = valueRange;
                    onValueChangeFinished3 = onValueChangeFinished;
                    colors3 = colors;
                    startInteractionSource2 = startInteractionSource;
                    endInteractionSource4 = endInteractionSource;
                    startThumb2 = startThumb;
                    endThumb3 = endThumb;
                    track4 = track;
                    steps3 = steps;
                    $dirty = -3670017 & $dirty3;
                    z = true;
                } else {
                    modifier3 = modifier;
                    enabled3 = enabled;
                    valueRange3 = valueRange;
                    onValueChangeFinished3 = onValueChangeFinished;
                    colors3 = colors;
                    startInteractionSource2 = startInteractionSource;
                    endInteractionSource4 = endInteractionSource;
                    startThumb2 = startThumb;
                    endThumb3 = endThumb;
                    track4 = track;
                    steps3 = steps;
                    $dirty = $dirty3;
                    z = true;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048796133, $dirty, $dirty1, "androidx.compose.material3.RangeSlider (Slider.kt:428)");
            }
            if (steps3 >= 0 ? z : false) {
                int i20 = $dirty1;
                $composer2 = $composer3;
                int i21 = $dirty;
                RangeSliderImpl(modifier3, value, onValueChange, enabled3, valueRange3, steps3, onValueChangeFinished3, startInteractionSource2, endInteractionSource4, startThumb2, endThumb3, track4, $composer2, (($dirty >> 6) & 14) | (($dirty << 3) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | ($dirty & 57344) | (($dirty1 << 9) & 458752) | (($dirty << 3) & 3670016) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), ($dirty1 & 14) | ($dirty1 & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                steps2 = steps3;
                track2 = track4;
                track3 = endThumb3;
                endThumb2 = startThumb2;
                endInteractionSource2 = endInteractionSource4;
                endInteractionSource3 = startInteractionSource2;
                colors2 = colors3;
                onValueChangeFinished2 = onValueChangeFinished3;
                valueRange2 = valueRange3;
                enabled2 = enabled3;
                modifier2 = modifier3;
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSlider$12(value, onValueChange, modifier2, enabled2, valueRange2, onValueChangeFinished2, colors2, endInteractionSource3, endInteractionSource2, endThumb2, track3, track2, steps2, $changed, $changed1, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x045e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0572  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0696  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x06a2  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x06a6  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0805  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0811  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0815  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x08d0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SliderImpl(androidx.compose.ui.Modifier r61, boolean r62, androidx.compose.foundation.interaction.MutableInteractionSource r63, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r64, kotlin.jvm.functions.Function0<kotlin.Unit> r65, int r66, float r67, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r68, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.runtime.Composer r71, int r72) {
        /*
            r15 = r62
            r14 = r63
            r13 = r64
            r12 = r65
            r11 = r67
            r10 = r68
            r9 = r69
            r8 = r70
            r7 = r72
            r0 = 851260148(0x32bd32f4, float:2.2025667E-8)
            r1 = r71
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SliderImpl)P(2!5,8,9)493@22061L74,493@22023L112,499@22161L59,503@22243L45,504@22310L30,512@22682L7,513@22733L57,514@22813L31,518@23040L77,524@23249L492,535@23770L217,558@24427L40,563@24569L2021:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r72
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0033
            r5 = r61
            boolean r2 = r6.changed((java.lang.Object) r5)
            if (r2 == 0) goto L_0x0030
            r2 = 4
            goto L_0x0031
        L_0x0030:
            r2 = 2
        L_0x0031:
            r1 = r1 | r2
            goto L_0x0035
        L_0x0033:
            r5 = r61
        L_0x0035:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0045
            boolean r2 = r6.changed((boolean) r15)
            if (r2 == 0) goto L_0x0042
            r2 = 32
            goto L_0x0044
        L_0x0042:
            r2 = 16
        L_0x0044:
            r1 = r1 | r2
        L_0x0045:
            r2 = r7 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0055
            boolean r2 = r6.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0052
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0054
        L_0x0052:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0054:
            r1 = r1 | r2
        L_0x0055:
            r2 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0065
            boolean r2 = r6.changedInstance(r13)
            if (r2 == 0) goto L_0x0062
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r1 = r1 | r2
        L_0x0065:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x0077
            boolean r2 = r6.changedInstance(r12)
            if (r2 == 0) goto L_0x0074
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0076
        L_0x0074:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0076:
            r1 = r1 | r2
        L_0x0077:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x008b
            r2 = r66
            boolean r4 = r6.changed((int) r2)
            if (r4 == 0) goto L_0x0087
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0089
        L_0x0087:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x0089:
            r1 = r1 | r4
            goto L_0x008d
        L_0x008b:
            r2 = r66
        L_0x008d:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r7
            if (r4 != 0) goto L_0x009e
            boolean r4 = r6.changed((float) r11)
            if (r4 == 0) goto L_0x009b
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x009d
        L_0x009b:
            r4 = 524288(0x80000, float:7.34684E-40)
        L_0x009d:
            r1 = r1 | r4
        L_0x009e:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r7
            if (r4 != 0) goto L_0x00af
            boolean r4 = r6.changed((java.lang.Object) r10)
            if (r4 == 0) goto L_0x00ac
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ae
        L_0x00ac:
            r4 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ae:
            r1 = r1 | r4
        L_0x00af:
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r7
            if (r4 != 0) goto L_0x00c0
            boolean r4 = r6.changedInstance(r9)
            if (r4 == 0) goto L_0x00bd
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00bf
        L_0x00bd:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00bf:
            r1 = r1 | r4
        L_0x00c0:
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r7
            if (r4 != 0) goto L_0x00d1
            boolean r4 = r6.changedInstance(r8)
            if (r4 == 0) goto L_0x00ce
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00d0
        L_0x00ce:
            r4 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00d0:
            r1 = r1 | r4
        L_0x00d1:
            r4 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r4 = r4 & r1
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r3) goto L_0x00eb
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x00e1
            goto L_0x00eb
        L_0x00e1:
            r6.skipToGroupEnd()
            r16 = r1
            r4 = r6
            r2 = r8
            r13 = r14
            goto L_0x08d3
        L_0x00eb:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x00f7
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.SliderImpl (Slider.kt:481)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r3, r4)
        L_0x00f7:
            java.lang.Float r0 = java.lang.Float.valueOf(r67)
            int r3 = r1 >> 18
            r3 = r3 & 14
            int r4 = r1 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            boolean r2 = r6.changed((java.lang.Object) r0)
            boolean r16 = r6.changed((java.lang.Object) r13)
            r2 = r2 | r16
            r16 = r6
            r17 = 0
            r18 = r0
            java.lang.Object r0 = r16.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x0139
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x0134
            goto L_0x013b
        L_0x0134:
            r20 = r0
            r2 = r16
            goto L_0x014c
        L_0x0139:
            r21 = r2
        L_0x013b:
            r2 = 0
            r20 = r0
            androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1
            r0.<init>(r11, r13)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = r16
            r2.updateRememberedValue(r0)
        L_0x014c:
            r6.endReplaceableGroup()
            r3 = 0
            androidx.compose.runtime.State r24 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r6, r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r66)
            int r2 = r1 >> 15
            r2 = r2 & 14
            r4 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            boolean r16 = r6.changed((java.lang.Object) r0)
            r17 = r6
            r18 = 0
            r19 = r0
            java.lang.Object r0 = r17.rememberedValue()
            r20 = 0
            if (r16 != 0) goto L_0x018e
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r2
            java.lang.Object r2 = r21.getEmpty()
            if (r0 != r2) goto L_0x0188
            goto L_0x0190
        L_0x0188:
            r2 = r0
            r21 = r2
            r0 = r17
            goto L_0x019e
        L_0x018e:
            r22 = r2
        L_0x0190:
            r2 = 0
            float[] r2 = stepsToTickFractions(r66)
            r21 = r0
            r0 = r17
            r0.updateRememberedValue(r2)
        L_0x019e:
            r6.endReplaceableGroup()
            float[] r2 = (float[]) r2
            r0 = 0
            r4 = r0
            r0 = 0
            r16 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r18 = 0
            r19 = r6
            r20 = 0
            r21 = r4
            java.lang.Object r4 = r19.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r23.getEmpty()
            r9 = 0
            if (r4 != r5) goto L_0x01e6
            r5 = 0
            float r23 = getThumbWidth()
            r27 = r4
            java.lang.Float r4 = java.lang.Float.valueOf(r23)
            r23 = r5
            r5 = 2
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r9, r5, r9)
            r5 = r19
            r5.updateRememberedValue(r4)
            goto L_0x01ea
        L_0x01e6:
            r27 = r4
            r5 = r19
        L_0x01ea:
            r6.endReplaceableGroup()
            r5 = r4
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            r4 = 0
            r16 = r4
            r4 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r9 = 0
            r18 = r6
            r19 = 0
            r20 = r4
            java.lang.Object r4 = r18.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r22.getEmpty()
            if (r4 != r7) goto L_0x022d
            r7 = 0
            r23 = r4
            r22 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            r28 = r7
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r8, r7, r8)
            r7 = r18
            r7.updateRememberedValue(r4)
            goto L_0x0231
        L_0x022d:
            r23 = r4
            r7 = r18
        L_0x0231:
            r6.endReplaceableGroup()
            r9 = r4
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r7 = 0
            r8 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r15, r14)
            java.lang.Object r15 = r6.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r15 != r4) goto L_0x0256
            r4 = 1
            goto L_0x0257
        L_0x0256:
            r4 = 0
        L_0x0257:
            r7 = 0
            r8 = r7
            r7 = 0
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r15 = 0
            r16 = r6
            r18 = 0
            r19 = r7
            java.lang.Object r7 = r16.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r8
            java.lang.Object r8 = r21.getEmpty()
            r13 = 0
            if (r7 != r8) goto L_0x0296
            r8 = 0
            float r21 = SliderImpl$scaleToOffset(r10, r13, r13, r11)
            java.lang.Float r13 = java.lang.Float.valueOf(r21)
            r21 = r7
            r71 = r8
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r8, r7, r8)
            r7 = r13
            r8 = r16
            r8.updateRememberedValue(r7)
            goto L_0x029a
        L_0x0296:
            r21 = r7
            r8 = r16
        L_0x029a:
            r6.endReplaceableGroup()
            r29 = r7
            androidx.compose.runtime.MutableState r29 = (androidx.compose.runtime.MutableState) r29
            r7 = 0
            r8 = r7
            r7 = 0
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r13 = 0
            r15 = r6
            r16 = 0
            r18 = r7
            java.lang.Object r7 = r15.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r8
            java.lang.Object r8 = r20.getEmpty()
            if (r7 != r8) goto L_0x02de
            r8 = 0
            r22 = r7
            r20 = 0
            java.lang.Float r7 = java.lang.Float.valueOf(r20)
            r30 = r8
            r71 = r13
            r8 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r7, r13, r8, r13)
            r15.updateRememberedValue(r7)
            goto L_0x02e2
        L_0x02de:
            r22 = r7
            r71 = r13
        L_0x02e2:
            r6.endReplaceableGroup()
            r30 = r7
            androidx.compose.runtime.MutableState r30 = (androidx.compose.runtime.MutableState) r30
            java.lang.Comparable r7 = r68.getStart()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            java.lang.Comparable r8 = r68.getEndInclusive()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r15 = kotlin.ranges.RangesKt.coerceIn((float) r11, (float) r7, (float) r8)
            java.lang.Comparable r7 = r68.getStart()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            java.lang.Comparable r8 = r68.getEndInclusive()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r13 = calcFraction(r7, r8, r15)
            r7 = 0
            r8 = r7
            r7 = 0
            r71 = r7
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = 0
            r7 = r6
            r16 = 0
            r17 = r0
            java.lang.Object r0 = r7.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r8
            java.lang.Object r8 = r19.getEmpty()
            if (r0 != r8) goto L_0x0354
            r8 = 0
            r19 = r0
            androidx.compose.material3.SliderPositions r0 = new androidx.compose.material3.SliderPositions
            r21 = r8
            r8 = 0
            kotlin.ranges.ClosedFloatingPointRange r11 = kotlin.ranges.RangesKt.rangeTo((float) r8, (float) r13)
            r0.<init>(r11, r2)
            r7.updateRememberedValue(r0)
            goto L_0x0356
        L_0x0354:
            r19 = r0
        L_0x0356:
            r6.endReplaceableGroup()
            r11 = r0
            androidx.compose.material3.SliderPositions r11 = (androidx.compose.material3.SliderPositions) r11
            r0 = 0
            kotlin.ranges.ClosedFloatingPointRange r0 = kotlin.ranges.RangesKt.rangeTo((float) r0, (float) r13)
            r11.setActiveRange$material3_release(r0)
            r11.setTickFractions$material3_release(r2)
            int r0 = r1 >> 21
            r0 = r0 & 14
            r7 = 0
            r8 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            boolean r16 = r6.changed((java.lang.Object) r10)
            r71 = r6
            r26 = r16
            r31 = 0
            java.lang.Object r8 = r71.rememberedValue()
            r33 = 0
            if (r26 != 0) goto L_0x039b
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r34 = r0
            java.lang.Object r0 = r16.getEmpty()
            if (r8 != r0) goto L_0x0395
            goto L_0x039d
        L_0x0395:
            r16 = r1
            r0 = r8
            r1 = r71
            goto L_0x03c7
        L_0x039b:
            r34 = r0
        L_0x039d:
            r0 = 0
            r35 = r0
            androidx.compose.material3.SliderDraggableState r0 = new androidx.compose.material3.SliderDraggableState
            androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1 r36 = new androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1
            r16 = r36
            r17 = r9
            r18 = r5
            r19 = r29
            r20 = r30
            r21 = r2
            r22 = r24
            r23 = r68
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r16 = r1
            r1 = r36
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.<init>(r1)
            r1 = r71
            r1.updateRememberedValue(r0)
        L_0x03c7:
            r6.endReplaceableGroup()
            r8 = r0
            androidx.compose.material3.SliderDraggableState r8 = (androidx.compose.material3.SliderDraggableState) r8
            androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1
            r0.<init>(r8, r12)
            r7 = 0
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r6, r7)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r17 = r8
            androidx.compose.foundation.gestures.DraggableState r17 = (androidx.compose.foundation.gestures.DraggableState) r17
            java.lang.Object r18 = r9.getValue()
            java.lang.Number r18 = (java.lang.Number) r18
            int r18 = r18.intValue()
            r19 = r29
            androidx.compose.runtime.State r19 = (androidx.compose.runtime.State) r19
            r71 = r1
            r1 = r17
            r17 = r2
            r2 = r63
            r21 = r7
            r20 = r9
            r9 = 1157296644(0x44faf204, float:2007.563)
            r7 = r3
            r3 = r18
            r37 = r5
            r5 = r19
            r18 = r15
            r15 = r6
            r6 = r71
            r38 = r7
            r7 = r30
            r19 = r8
            r8 = r62
            androidx.compose.ui.Modifier r0 = sliderTapModifier(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r7 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r2 = r19.isDragging()
            r5 = r1
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = r19
            androidx.compose.foundation.gestures.DraggableState r6 = (androidx.compose.foundation.gestures.DraggableState) r6
            r1 = r21
            r3 = 0
            r15.startReplaceableGroup(r9)
            r8 = r38
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            r9 = r71
            boolean r8 = r15.changed((java.lang.Object) r9)
            r71 = r15
            r22 = 0
            r23 = r1
            java.lang.Object r1 = r71.rememberedValue()
            r25 = 0
            if (r8 != 0) goto L_0x045e
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r31 = r3
            java.lang.Object r3 = r26.getEmpty()
            if (r1 != r3) goto L_0x0459
            goto L_0x0460
        L_0x0459:
            r3 = r71
            r26 = r1
            goto L_0x0474
        L_0x045e:
            r31 = r3
        L_0x0460:
            r3 = 0
            r26 = r1
            androidx.compose.material3.SliderKt$SliderImpl$drag$1$1 r1 = new androidx.compose.material3.SliderKt$SliderImpl$drag$1$1
            r32 = r3
            r3 = 0
            r1.<init>(r9, r3)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = r71
            r3.updateRememberedValue(r1)
        L_0x0474:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = 32
            r22 = 0
            r23 = 0
            r8 = r62
            r39 = r20
            r20 = r9
            r9 = r63
            r10 = r2
            r2 = r11
            r11 = r23
            r12 = r1
            r1 = r13
            r13 = r4
            r40 = r14
            r14 = r3
            r3 = r62
            r23 = r2
            r71 = r4
            r4 = r15
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r15 = r22
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.compose.ui.Modifier r5 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r61)
            androidx.compose.material3.tokens.SliderTokens r6 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r6 = r6.m4427getHandleWidthD9Ej5fM()
            androidx.compose.material3.tokens.SliderTokens r7 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r7 = r7.m4426getHandleHeightD9Ej5fM()
            r10 = 12
            r11 = 0
            r8 = 0
            r9 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m2318requiredSizeInqDBjuR0$default(r5, r6, r7, r8, r9, r10, r11)
            r6 = r67
            r7 = r62
            r8 = r64
            r9 = r65
            r10 = r68
            r11 = r66
            androidx.compose.ui.Modifier r5 = sliderSemantics(r5, r6, r7, r8, r9, r10, r11)
            r13 = r63
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.FocusableKt.focusable(r5, r3, r13)
            androidx.compose.ui.Modifier r5 = r5.then(r0)
            androidx.compose.ui.Modifier r5 = r5.then(r12)
            androidx.compose.material3.SliderKt$SliderImpl$2 r6 = new androidx.compose.material3.SliderKt$SliderImpl$2
            r7 = r37
            r8 = r39
            r6.<init>(r7, r8, r1)
            androidx.compose.ui.layout.MeasurePolicy r6 = (androidx.compose.ui.layout.MeasurePolicy) r6
            r9 = r21
            r10 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r11)
            java.lang.String r14 = "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 6
            r21 = 0
            r11 = r40
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r11)
            java.lang.Object r25 = r4.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r14 = r25
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r21 = 6
            r25 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r11)
            java.lang.Object r26 = r4.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r15 = r26
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r21 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r2 = r21
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r21 = 6
            r25 = 0
            r26 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r11)
            java.lang.Object r0 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r0 = (androidx.compose.ui.platform.ViewConfiguration) r0
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r2 = r2.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            r21 = r1
            int r1 = r9 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r25 = 0
            androidx.compose.runtime.Applier r3 = r4.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x0569
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0569:
            r4.startReusableNode()
            boolean r3 = r4.getInserting()
            if (r3 == 0) goto L_0x0576
            r4.createNode(r2)
            goto L_0x0579
        L_0x0576:
            r4.useNode()
        L_0x0579:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r4)
            r27 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r31 = androidx.compose.ui.node.ComposeUiNode.Companion
            r32 = r2
            kotlin.jvm.functions.Function2 r2 = r31.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r14, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r15, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r0, r2)
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r11.invoke(r2, r4, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r2)
            int r3 = r1 >> 9
            r3 = r3 & 14
            r27 = r4
            r31 = 0
            r2 = 1541256180(0x5bddb3f4, float:1.24807661E17)
            r34 = r0
            java.lang.String r0 = "C565@24599L84,566@24696L84:Slider.kt#uh7d8r"
            r35 = r1
            r1 = r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r2, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.SliderComponents r2 = androidx.compose.material3.SliderComponents.THUMB
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r0, r2)
            r2 = 6
            r27 = 0
            r36 = r3
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r38 = r5
            r5 = 0
            int r39 = r2 >> 3
            r39 = r39 & 14
            int r40 = r2 >> 3
            r40 = r40 & 112(0x70, float:1.57E-43)
            r41 = r6
            r6 = r39 | r40
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r5, r1, r6)
            int r39 = r2 << 3
            r39 = r39 & 112(0x70, float:1.57E-43)
            r40 = 0
            r42 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r43 = 6
            r44 = 0
            r45 = r5
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            r46 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r5)
            java.lang.Object r7 = r1.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r3 = r7
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r43 = 6
            r44 = 0
            r47 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r5)
            java.lang.Object r8 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r7 = r8
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r43 = 6
            r44 = 0
            r48 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r5)
            java.lang.Object r9 = r1.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r8 = r9
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r43 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r44 = r0
            int r0 = r39 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r49 = r43
            r43 = 0
            r50 = r10
            androidx.compose.runtime.Applier r10 = r1.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0699
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0699:
            r1.startReusableNode()
            boolean r10 = r1.getInserting()
            if (r10 == 0) goto L_0x06a6
            r1.createNode(r9)
            goto L_0x06a9
        L_0x06a6:
            r1.useNode()
        L_0x06a9:
            r1.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m4575constructorimpl(r1)
            r51 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r52 = androidx.compose.ui.node.ComposeUiNode.Companion
            r53 = r9
            kotlin.jvm.functions.Function2 r9 = r52.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r6, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r7, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r8, r9)
            r1.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r9)
            int r10 = r0 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r51 = r3
            r3 = r49
            r3.invoke(r9, r1, r10)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r9)
            int r9 = r0 >> 9
            r9 = r9 & 14
            r10 = r1
            r49 = 0
            r52 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r54 = r3
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r2 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r55 = r10
            r56 = 0
            r57 = r0
            r0 = -1819487535(0xffffffff938cd2d1, float:-3.554885E-27)
            r58 = r2
            java.lang.String r2 = "C565@24659L22:Slider.kt#uh7d8r"
            r59 = r3
            r3 = r55
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            int r0 = r16 >> 21
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = r69
            r60 = r23
            r23 = r6
            r6 = r60
            r2.invoke(r6, r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.SliderComponents r3 = androidx.compose.material3.SliderComponents.TRACK
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r0, r3)
            r3 = 6
            r7 = 0
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            r9 = 0
            int r10 = r3 >> 3
            r10 = r10 & 14
            int r23 = r3 >> 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r10 = r10 | r23
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r9, r1, r10)
            int r23 = r3 << 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r27 = 0
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r22 = 6
            r37 = 0
            r39 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r5)
            java.lang.Object r7 = r1.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r2 = r7
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r22 = 6
            r37 = 0
            r40 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r8, r5)
            java.lang.Object r8 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r7 = r8
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r22 = 6
            r37 = 0
            r42 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r5)
            java.lang.Object r5 = r1.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r22 = r0
            int r0 = r23 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r28 = 0
            r37 = r11
            androidx.compose.runtime.Applier r11 = r1.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0808
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0808:
            r1.startReusableNode()
            boolean r11 = r1.getInserting()
            if (r11 == 0) goto L_0x0815
            r1.createNode(r8)
            goto L_0x0818
        L_0x0815:
            r1.useNode()
        L_0x0818:
            r1.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r1)
            r43 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r44 = androidx.compose.ui.node.ComposeUiNode.Companion
            r45 = r8
            kotlin.jvm.functions.Function2 r8 = r44.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r10, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r7, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r5, r8)
            r1.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r8)
            int r11 = r0 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9.invoke(r8, r1, r11)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r8)
            int r8 = r0 >> 9
            r8 = r8 & 14
            r11 = r1
            r33 = 0
            r43 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r44 = r2
            java.lang.String r2 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r3 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r49 = r11
            r51 = 0
            r52 = r0
            r0 = -1819487438(0xffffffff938cd332, float:-3.5549223E-27)
            r53 = r2
            java.lang.String r2 = "C566@24756L22:Slider.kt#uh7d8r"
            r54 = r3
            r3 = r49
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            int r0 = r16 >> 24
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = r70
            r2.invoke(r6, r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x08d3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x08d3:
            androidx.compose.runtime.ScopeUpdateScope r12 = r4.endRestartGroup()
            if (r12 != 0) goto L_0x08db
            r15 = r4
            goto L_0x08fd
        L_0x08db:
            androidx.compose.material3.SliderKt$SliderImpl$3 r14 = new androidx.compose.material3.SliderKt$SliderImpl$3
            r0 = r14
            r1 = r61
            r2 = r62
            r3 = r63
            r15 = r4
            r4 = r64
            r5 = r65
            r6 = r66
            r7 = r67
            r8 = r68
            r9 = r69
            r10 = r70
            r11 = r72
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r12.updateScope(r14)
        L_0x08fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.SliderImpl(androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, int, float, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float SliderImpl$scaleToUserValue(ClosedFloatingPointRange<Float> $valueRange, float minPx, float maxPx, float offset) {
        return scale(minPx, maxPx, offset, $valueRange.getStart().floatValue(), $valueRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float SliderImpl$scaleToOffset(ClosedFloatingPointRange<Float> $valueRange, float minPx, float maxPx, float userValue) {
        return scale($valueRange.getStart().floatValue(), $valueRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v123, resolved type: float[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0438  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0477  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x059d  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x067d  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x079d  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x07a9  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x07ad  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0839  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0849  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x092c  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0938  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x093c  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0a08  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0a15  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0ae5  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0af1  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0af5  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0c4d  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0c59  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0c5d  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0d17  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0d20  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0d23  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSliderImpl(androidx.compose.ui.Modifier r75, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r76, kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r77, boolean r78, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r79, int r80, kotlin.jvm.functions.Function0<kotlin.Unit> r81, androidx.compose.foundation.interaction.MutableInteractionSource r82, androidx.compose.foundation.interaction.MutableInteractionSource r83, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, androidx.compose.runtime.Composer r87, int r88, int r89, int r90) {
        /*
            r15 = r76
            r14 = r77
            r13 = r78
            r12 = r81
            r11 = r82
            r10 = r83
            r9 = r84
            r8 = r85
            r7 = r86
            r6 = r88
            r5 = r90
            r0 = 2067530570(0x7b3c034a, float:9.762185E35)
            r1 = r87
            androidx.compose.runtime.Composer r4 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(RangeSliderImpl)P(3,10,4!1,11,8,5,6!1,7)641@27264L74,641@27200L138,647@27364L59,651@27452L45,652@27523L45,653@27591L30,655@27660L7,665@28240L34,666@28300L31,667@28355L31,669@28455L47,669@28415L87,673@28521L1112,718@30413L133,733@30914L73,741@31182L75,747@31395L35,748@31463L33,750@31502L4199:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            r0 = r88
            r1 = r89
            r2 = r5 & 1
            if (r2 == 0) goto L_0x0031
            r0 = r0 | 6
            r2 = r75
            goto L_0x0047
        L_0x0031:
            r2 = r6 & 14
            if (r2 != 0) goto L_0x0045
            r2 = r75
            boolean r16 = r4.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x0040
            r16 = 4
            goto L_0x0042
        L_0x0040:
            r16 = 2
        L_0x0042:
            r0 = r0 | r16
            goto L_0x0047
        L_0x0045:
            r2 = r75
        L_0x0047:
            r16 = r5 & 2
            r17 = 32
            r18 = 16
            if (r16 == 0) goto L_0x0052
            r0 = r0 | 48
            goto L_0x0063
        L_0x0052:
            r16 = r6 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x0063
            boolean r16 = r4.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x005f
            r16 = r17
            goto L_0x0061
        L_0x005f:
            r16 = r18
        L_0x0061:
            r0 = r0 | r16
        L_0x0063:
            r16 = r5 & 4
            if (r16 == 0) goto L_0x006a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x007a
        L_0x006a:
            r3 = r6 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x007a
            boolean r3 = r4.changedInstance(r14)
            if (r3 == 0) goto L_0x0077
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0079
        L_0x0077:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0079:
            r0 = r0 | r3
        L_0x007a:
            r3 = r5 & 8
            if (r3 == 0) goto L_0x0081
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0091
        L_0x0081:
            r3 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0091
            boolean r3 = r4.changed((boolean) r13)
            if (r3 == 0) goto L_0x008e
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0090
        L_0x008e:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0090:
            r0 = r0 | r3
        L_0x0091:
            r3 = r5 & 16
            if (r3 == 0) goto L_0x009a
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r3 = r79
            goto L_0x00b2
        L_0x009a:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r6
            if (r3 != 0) goto L_0x00b0
            r3 = r79
            boolean r19 = r4.changed((java.lang.Object) r3)
            if (r19 == 0) goto L_0x00ab
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r0 = r0 | r19
            goto L_0x00b2
        L_0x00b0:
            r3 = r79
        L_0x00b2:
            r19 = r5 & 32
            if (r19 == 0) goto L_0x00bd
            r20 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r20
            r2 = r80
            goto L_0x00d5
        L_0x00bd:
            r20 = 458752(0x70000, float:6.42848E-40)
            r20 = r6 & r20
            if (r20 != 0) goto L_0x00d3
            r2 = r80
            boolean r20 = r4.changed((int) r2)
            if (r20 == 0) goto L_0x00ce
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d0
        L_0x00ce:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00d0:
            r0 = r0 | r20
            goto L_0x00d5
        L_0x00d3:
            r2 = r80
        L_0x00d5:
            r20 = r5 & 64
            if (r20 == 0) goto L_0x00de
            r20 = 1572864(0x180000, float:2.204052E-39)
        L_0x00db:
            r0 = r0 | r20
            goto L_0x00f0
        L_0x00de:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r6 & r20
            if (r20 != 0) goto L_0x00f0
            boolean r20 = r4.changedInstance(r12)
            if (r20 == 0) goto L_0x00ed
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00ed:
            r20 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00db
        L_0x00f0:
            r2 = r5 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00f8
            r2 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f6:
            r0 = r0 | r2
            goto L_0x0109
        L_0x00f8:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x0109
            boolean r2 = r4.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0106
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f6
        L_0x0106:
            r2 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f6
        L_0x0109:
            r2 = r5 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0111
            r2 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x010f:
            r0 = r0 | r2
            goto L_0x0122
        L_0x0111:
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x0122
            boolean r2 = r4.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x011f
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x011f:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x010f
        L_0x0122:
            r2 = r5 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x012a
            r2 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0128:
            r0 = r0 | r2
            goto L_0x013b
        L_0x012a:
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x013b
            boolean r2 = r4.changedInstance(r9)
            if (r2 == 0) goto L_0x0138
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0138:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0128
        L_0x013b:
            r2 = r0
            r0 = r5 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0143
            r1 = r1 | 6
            goto L_0x0151
        L_0x0143:
            r0 = r89 & 14
            if (r0 != 0) goto L_0x0151
            boolean r0 = r4.changedInstance(r8)
            if (r0 == 0) goto L_0x014f
            r0 = 4
            goto L_0x0150
        L_0x014f:
            r0 = 2
        L_0x0150:
            r1 = r1 | r0
        L_0x0151:
            r0 = r5 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0158
            r1 = r1 | 48
            goto L_0x0167
        L_0x0158:
            r0 = r89 & 112(0x70, float:1.57E-43)
            if (r0 != 0) goto L_0x0167
            boolean r0 = r4.changedInstance(r7)
            if (r0 == 0) goto L_0x0163
            goto L_0x0165
        L_0x0163:
            r17 = r18
        L_0x0165:
            r1 = r1 | r17
        L_0x0167:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r2
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x018a
            r0 = r1 & 91
            r3 = 18
            if (r0 != r3) goto L_0x018a
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x017d
            goto L_0x018a
        L_0x017d:
            r4.skipToGroupEnd()
            r24 = r80
            r35 = r1
            r36 = r2
            r13 = r4
            r1 = r7
            goto L_0x0d1a
        L_0x018a:
            if (r19 == 0) goto L_0x018f
            r0 = 0
            r3 = r0
            goto L_0x0191
        L_0x018f:
            r3 = r80
        L_0x0191:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019f
            r0 = 2067530570(0x7b3c034a, float:9.762185E35)
            java.lang.String r5 = "androidx.compose.material3.RangeSliderImpl (Slider.kt:627)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r1, r5)
        L_0x019f:
            int r0 = r2 >> 3
            r0 = r0 & 14
            int r5 = r2 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r0 = r0 | r5
            r5 = 0
            r80 = r0
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            boolean r0 = r4.changed((java.lang.Object) r15)
            boolean r17 = r4.changed((java.lang.Object) r14)
            r0 = r0 | r17
            r87 = r4
            r17 = 0
            r18 = r1
            java.lang.Object r1 = r87.rememberedValue()
            r19 = 0
            if (r0 != 0) goto L_0x01e1
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r0
            java.lang.Object r0 = r20.getEmpty()
            if (r1 != r0) goto L_0x01db
            goto L_0x01e3
        L_0x01db:
            r0 = r1
            r20 = r0
            r1 = r87
            goto L_0x01f6
        L_0x01e1:
            r21 = r0
        L_0x01e3:
            r0 = 0
            r20 = r0
            androidx.compose.material3.SliderKt$RangeSliderImpl$onValueChangeState$1$1 r0 = new androidx.compose.material3.SliderKt$RangeSliderImpl$onValueChangeState$1$1
            r0.<init>(r15, r14)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r20 = r1
            r1 = r87
            r1.updateRememberedValue(r0)
        L_0x01f6:
            r4.endReplaceableGroup()
            r5 = 0
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r4, r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            int r17 = r2 >> 15
            r17 = r17 & 14
            r19 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r4.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            boolean r20 = r4.changed((java.lang.Object) r0)
            r21 = r4
            r22 = 0
            r23 = r0
            java.lang.Object r0 = r21.rememberedValue()
            r24 = 0
            if (r20 != 0) goto L_0x0239
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            r26 = r1
            java.lang.Object r1 = r25.getEmpty()
            if (r0 != r1) goto L_0x0233
            goto L_0x023b
        L_0x0233:
            r1 = r0
            r25 = r1
            r0 = r21
            goto L_0x0249
        L_0x0239:
            r26 = r1
        L_0x023b:
            r1 = 0
            float[] r1 = stepsToTickFractions(r3)
            r25 = r0
            r0 = r21
            r0.updateRememberedValue(r1)
        L_0x0249:
            r4.endReplaceableGroup()
            float[] r1 = (float[]) r1
            r0 = 0
            r17 = r0
            r0 = 0
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            r19 = 0
            r20 = r4
            r21 = 0
            r22 = r0
            java.lang.Object r0 = r20.rememberedValue()
            r23 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r1
            java.lang.Object r1 = r24.getEmpty()
            r24 = r3
            r3 = 0
            if (r0 != r1) goto L_0x0294
            r1 = 0
            float r28 = getThumbWidth()
            r29 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r28)
            r28 = r1
            r1 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r1 = r20
            r1.updateRememberedValue(r0)
            goto L_0x0298
        L_0x0294:
            r29 = r0
            r1 = r20
        L_0x0298:
            r4.endReplaceableGroup()
            r28 = r0
            androidx.compose.runtime.MutableState r28 = (androidx.compose.runtime.MutableState) r28
            r0 = 0
            r1 = r0
            r0 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            r3 = 0
            r19 = r4
            r20 = 0
            r21 = r0
            java.lang.Object r0 = r19.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r29 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r0 != r1) goto L_0x02e1
            r1 = 0
            float r23 = getThumbWidth()
            r30 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r23)
            r23 = r1
            r31 = r3
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r1 = r19
            r1.updateRememberedValue(r0)
            goto L_0x02e7
        L_0x02e1:
            r30 = r0
            r31 = r3
            r1 = r19
        L_0x02e7:
            r4.endReplaceableGroup()
            r29 = r0
            androidx.compose.runtime.MutableState r29 = (androidx.compose.runtime.MutableState) r29
            r0 = 0
            r1 = r0
            r0 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            r3 = 0
            r19 = r4
            r20 = 0
            r21 = r0
            java.lang.Object r0 = r19.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r30 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r0 != r1) goto L_0x032e
            r1 = 0
            r31 = r0
            r23 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r23)
            r32 = r1
            r23 = r3
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r1 = r19
            r1.updateRememberedValue(r0)
            goto L_0x0334
        L_0x032e:
            r31 = r0
            r23 = r3
            r1 = r19
        L_0x0334:
            r4.endReplaceableGroup()
            r30 = r0
            androidx.compose.runtime.MutableState r30 = (androidx.compose.runtime.MutableState) r30
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r3 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r15)
            java.lang.Object r14 = r4.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.LayoutDirection r0 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r14 != r0) goto L_0x035b
            r22 = 1
            goto L_0x035d
        L_0x035b:
            r22 = 0
        L_0x035d:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r14 = r0
            r0 = 0
            r1 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            r3 = 0
            r20 = r4
            r21 = 0
            r23 = r0
            java.lang.Object r0 = r20.rememberedValue()
            r32 = 0
            androidx.compose.runtime.Composer$Companion r33 = androidx.compose.runtime.Composer.Companion
            r34 = r1
            java.lang.Object r1 = r33.getEmpty()
            if (r0 != r1) goto L_0x03a0
            r1 = 0
            r35 = r0
            r33 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r33)
            r36 = r1
            r33 = r3
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r1 = r20
            r1.updateRememberedValue(r0)
            goto L_0x03a6
        L_0x03a0:
            r35 = r0
            r33 = r3
            r1 = r20
        L_0x03a6:
            r4.endReplaceableGroup()
            r14.element = r0
            r0 = 0
            r1 = r0
            r0 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            r3 = 0
            r20 = r4
            r21 = 0
            r23 = r0
            java.lang.Object r0 = r20.rememberedValue()
            r32 = 0
            androidx.compose.runtime.Composer$Companion r33 = androidx.compose.runtime.Composer.Companion
            r34 = r1
            java.lang.Object r1 = r33.getEmpty()
            if (r0 != r1) goto L_0x03eb
            r1 = 0
            r33 = 0
            r35 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r33)
            r33 = r1
            r36 = r3
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r1 = r20
            r1.updateRememberedValue(r0)
            goto L_0x03f1
        L_0x03eb:
            r35 = r0
            r36 = r3
            r1 = r20
        L_0x03f1:
            r4.endReplaceableGroup()
            r32 = r0
            androidx.compose.runtime.MutableState r32 = (androidx.compose.runtime.MutableState) r32
            r0 = 0
            r1 = r0
            r0 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r10)
            r3 = 0
            r20 = r4
            r21 = 0
            r23 = r0
            java.lang.Object r0 = r20.rememberedValue()
            r33 = 0
            androidx.compose.runtime.Composer$Companion r34 = androidx.compose.runtime.Composer.Companion
            r35 = r1
            java.lang.Object r1 = r34.getEmpty()
            if (r0 != r1) goto L_0x0438
            r1 = 0
            r34 = 0
            r36 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r34)
            r34 = r1
            r16 = r3
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r1 = r20
            r1.updateRememberedValue(r0)
            goto L_0x043e
        L_0x0438:
            r36 = r0
            r16 = r3
            r1 = r20
        L_0x043e:
            r4.endReplaceableGroup()
            r33 = r0
            androidx.compose.runtime.MutableState r33 = (androidx.compose.runtime.MutableState) r33
            int r0 = r2 >> 18
            r0 = r0 & 14
            r1 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            boolean r16 = r4.changed((java.lang.Object) r12)
            r87 = r4
            r17 = 0
            java.lang.Object r3 = r87.rememberedValue()
            r21 = 0
            if (r16 != 0) goto L_0x0477
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r34 = r0
            java.lang.Object r0 = r23.getEmpty()
            if (r3 != r0) goto L_0x0471
            goto L_0x0479
        L_0x0471:
            r23 = r1
            r0 = r3
            r1 = r87
            goto L_0x048c
        L_0x0477:
            r34 = r0
        L_0x0479:
            r0 = 0
            r23 = r0
            androidx.compose.material3.SliderKt$RangeSliderImpl$gestureEndAction$1$1 r0 = new androidx.compose.material3.SliderKt$RangeSliderImpl$gestureEndAction$1$1
            r0.<init>(r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r23 = r1
            r1 = r87
            r1.updateRememberedValue(r0)
        L_0x048c:
            r4.endReplaceableGroup()
            r3 = 0
            androidx.compose.runtime.State r34 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r4, r3)
            androidx.compose.material3.SliderKt$RangeSliderImpl$onDrag$1 r1 = new androidx.compose.material3.SliderKt$RangeSliderImpl$onDrag$1
            r0 = r1
            r12 = r1
            r35 = r18
            r87 = r25
            r80 = r26
            r1 = r32
            r36 = r2
            r2 = r33
            r17 = r3
            r11 = r24
            r13 = 1
            r16 = 1157296644(0x44faf204, float:2007.563)
            r3 = r76
            r13 = r4
            r4 = r87
            r38 = r5
            r40 = r15
            r15 = r17
            r5 = r80
            r6 = r30
            r7 = r29
            r8 = r28
            r9 = r79
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.runtime.State r12 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r13, r15)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r16 = r0
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r19 = r32
            androidx.compose.runtime.State r19 = (androidx.compose.runtime.State) r19
            r20 = r33
            androidx.compose.runtime.State r20 = (androidx.compose.runtime.State) r20
            int r23 = RangeSliderImpl$lambda$31(r30)
            r17 = r82
            r18 = r83
            r21 = r78
            r24 = r79
            r25 = r34
            r26 = r12
            androidx.compose.ui.Modifier r9 = rangeSliderPressDragModifier(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            java.lang.Comparable r0 = r76.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Comparable r1 = r79.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Comparable r2 = r76.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r8 = kotlin.ranges.RangesKt.coerceIn((float) r0, (float) r1, (float) r2)
            java.lang.Comparable r0 = r76.getEndInclusive()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Comparable r1 = r76.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Comparable r2 = r79.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r7 = kotlin.ranges.RangesKt.coerceIn((float) r0, (float) r1, (float) r2)
            java.lang.Comparable r0 = r79.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Comparable r1 = r79.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r6 = calcFraction(r0, r1, r8)
            java.lang.Comparable r0 = r79.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Comparable r1 = r79.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r5 = calcFraction(r0, r1, r7)
            r0 = r15
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            r2 = 0
            r3 = r13
            r4 = 0
            java.lang.Object r10 = r3.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r17.getEmpty()
            if (r10 != r15) goto L_0x059d
            r15 = 0
            r17 = r0
            androidx.compose.material3.SliderPositions r0 = new androidx.compose.material3.SliderPositions
            r18 = r1
            kotlin.ranges.ClosedFloatingPointRange r1 = kotlin.ranges.RangesKt.rangeTo((float) r6, (float) r5)
            r19 = r12
            r12 = r87
            r0.<init>(r1, r12)
            r3.updateRememberedValue(r0)
            goto L_0x05a6
        L_0x059d:
            r17 = r0
            r18 = r1
            r19 = r12
            r12 = r87
            r0 = r10
        L_0x05a6:
            r13.endReplaceableGroup()
            r15 = r0
            androidx.compose.material3.SliderPositions r15 = (androidx.compose.material3.SliderPositions) r15
            kotlin.ranges.ClosedFloatingPointRange r0 = kotlin.ranges.RangesKt.rangeTo((float) r6, (float) r5)
            r15.setActiveRange$material3_release(r0)
            r15.setTickFractions$material3_release(r12)
            float r0 = (float) r11
            float r0 = r0 * r5
            double r0 = (double) r0
            double r0 = java.lang.Math.floor(r0)
            float r0 = (float) r0
            int r10 = (int) r0
            float r0 = (float) r11
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r6
            float r0 = r0 * r1
            double r0 = (double) r0
            double r0 = java.lang.Math.floor(r0)
            float r0 = (float) r0
            int r4 = (int) r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            java.lang.Float r1 = java.lang.Float.valueOf(r7)
            r2 = 0
            r3 = r2
            r2 = 0
            r87 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r80
            boolean r16 = r13.changed((java.lang.Object) r2)
            boolean r17 = r13.changed((java.lang.Object) r1)
            r16 = r16 | r17
            r80 = r13
            r17 = 0
            r18 = r1
            java.lang.Object r1 = r80.rememberedValue()
            r20 = 0
            if (r16 != 0) goto L_0x0610
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r24 = r3
            java.lang.Object r3 = r21.getEmpty()
            if (r1 != r3) goto L_0x060b
            goto L_0x0612
        L_0x060b:
            r3 = r80
            r21 = r1
            goto L_0x0623
        L_0x0610:
            r24 = r3
        L_0x0612:
            r3 = 0
            r21 = r1
            androidx.compose.material3.SliderKt$RangeSliderImpl$startThumbSemantics$1$1 r1 = new androidx.compose.material3.SliderKt$RangeSliderImpl$startThumbSemantics$1$1
            r1.<init>(r2, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = r80
            r3.updateRememberedValue(r1)
        L_0x0623:
            r13.endReplaceableGroup()
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Comparable r1 = r79.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r16 = kotlin.ranges.RangesKt.rangeTo((float) r1, (float) r7)
            r1 = r8
            r24 = r11
            r11 = r2
            r2 = r78
            r17 = r4
            r4 = r81
            r18 = r5
            r5 = r16
            r16 = r6
            r6 = r10
            androidx.compose.ui.Modifier r6 = sliderSemantics(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            java.lang.Float r1 = java.lang.Float.valueOf(r8)
            r2 = 0
            r3 = r2
            r2 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r4 = r13.changed((java.lang.Object) r11)
            boolean r5 = r13.changed((java.lang.Object) r1)
            r4 = r4 | r5
            r5 = r13
            r20 = 0
            r80 = r1
            java.lang.Object r1 = r5.rememberedValue()
            r21 = 0
            if (r4 != 0) goto L_0x068b
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            r87 = r2
            java.lang.Object r2 = r25.getEmpty()
            if (r1 != r2) goto L_0x0688
            goto L_0x068d
        L_0x0688:
            r25 = r1
            goto L_0x069c
        L_0x068b:
            r87 = r2
        L_0x068d:
            r2 = 0
            r25 = r1
            androidx.compose.material3.SliderKt$RangeSliderImpl$endThumbSemantics$1$1 r1 = new androidx.compose.material3.SliderKt$RangeSliderImpl$endThumbSemantics$1$1
            r1.<init>(r11, r8)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5.updateRememberedValue(r1)
        L_0x069c:
            r13.endReplaceableGroup()
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Comparable r1 = r79.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r5 = kotlin.ranges.RangesKt.rangeTo((float) r8, (float) r1)
            r1 = r7
            r2 = r78
            r4 = r81
            r80 = r11
            r11 = r6
            r6 = r17
            androidx.compose.ui.Modifier r6 = sliderSemantics(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3746getSliderRangeStartadMyvUU()
            r5 = 6
            java.lang.String r4 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r13, r5)
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m3745getSliderRangeEndadMyvUU()
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r0, r13, r5)
            androidx.compose.ui.Modifier r41 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r75)
            androidx.compose.material3.tokens.SliderTokens r0 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r42 = r0.m4427getHandleWidthD9Ej5fM()
            androidx.compose.material3.tokens.SliderTokens r0 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r43 = r0.m4426getHandleHeightD9Ej5fM()
            r46 = 12
            r47 = 0
            r44 = 0
            r45 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2318requiredSizeInqDBjuR0$default(r41, r42, r43, r44, r45, r46, r47)
            androidx.compose.ui.Modifier r20 = r0.then(r9)
            androidx.compose.material3.SliderKt$RangeSliderImpl$2 r21 = new androidx.compose.material3.SliderKt$RangeSliderImpl$2
            r0 = r21
            r1 = r14
            r2 = r32
            r87 = r12
            r12 = r3
            r3 = r76
            r25 = r14
            r14 = r4
            r4 = r33
            r26 = r5
            r5 = r16
            r48 = r6
            r6 = r18
            r27 = r7
            r7 = r28
            r41 = r8
            r8 = r29
            r42 = r9
            r9 = r30
            r43 = r10
            r10 = r79
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.layout.MeasurePolicy r21 = (androidx.compose.ui.layout.MeasurePolicy) r21
            r0 = r20
            r1 = r21
            r2 = 0
            r3 = r2
            r2 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r4)
            java.lang.String r5 = "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 6
            r7 = 0
            r8 = r40
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r8)
            java.lang.Object r9 = r13.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r5 = r9
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 6
            r9 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r8)
            java.lang.Object r10 = r13.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r6 = r10
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r9 = 6
            r10 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r8)
            java.lang.Object r4 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r9 = r3 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r10 = 0
            r21 = r0
            androidx.compose.runtime.Applier r0 = r13.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x07a0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x07a0:
            r13.startReusableNode()
            boolean r0 = r13.getInserting()
            if (r0 == 0) goto L_0x07ad
            r13.createNode(r7)
            goto L_0x07b0
        L_0x07ad:
            r13.useNode()
        L_0x07b0:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r40 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r44 = androidx.compose.ui.node.ComposeUiNode.Companion
            r45 = r2
            kotlin.jvm.functions.Function2 r2 = r44.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r1, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r4, r2)
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r2 = r9 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.invoke(r0, r13, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            int r2 = r9 >> 9
            r2 = r2 & 14
            r40 = r13
            r44 = 0
            r0 = -2040262222(0xffffffff866411b2, float:-4.2895034E-35)
            r47 = r1
            java.lang.String r1 = "C754@31668L84,752@31532L369,762@32048L82,760@31914L359,768@32286L117:Slider.kt#uh7d8r"
            r49 = r2
            r2 = r40
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.RangeSliderComponents r1 = androidx.compose.material3.RangeSliderComponents.STARTTHUMB
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r0, r1)
            r1 = 0
            r40 = 0
            r50 = r1
            r1 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r1)
            r1 = r38
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            boolean r38 = r2.changed((java.lang.Object) r14)
            r51 = r2
            r52 = 0
            r53 = r3
            java.lang.Object r3 = r51.rememberedValue()
            r54 = 0
            if (r38 != 0) goto L_0x0849
            androidx.compose.runtime.Composer$Companion r55 = androidx.compose.runtime.Composer.Companion
            r56 = r4
            java.lang.Object r4 = r55.getEmpty()
            if (r3 != r4) goto L_0x0844
            goto L_0x084b
        L_0x0844:
            r55 = r3
            r4 = r51
            goto L_0x085c
        L_0x0849:
            r56 = r4
        L_0x084b:
            r4 = 0
            r55 = r3
            androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1 r3 = new androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1
            r3.<init>(r14)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = r51
            r4.updateRememberedValue(r3)
        L_0x085c:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r0, r4, r3)
            r3 = r82
            r37 = r5
            r5 = r4
            r4 = r78
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.FocusableKt.focusable(r0, r4, r3)
            androidx.compose.ui.Modifier r0 = r0.then(r11)
            r23 = 0
            r38 = r23
            r40 = 0
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r3 = 0
            int r51 = r38 >> 3
            r51 = r51 & 14
            int r52 = r38 >> 3
            r52 = r52 & 112(0x70, float:1.57E-43)
            r54 = r6
            r6 = r51 | r52
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r3, r2, r6)
            int r51 = r38 << 3
            r51 = r51 & 112(0x70, float:1.57E-43)
            r52 = 0
            r55 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r57 = 6
            r58 = 0
            r59 = r5
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            r60 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r5)
            java.lang.Object r7 = r2.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r3 = r7
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r57 = 6
            r58 = 0
            r61 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r5)
            java.lang.Object r8 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r7 = r8
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r57 = 6
            r58 = 0
            r62 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r5)
            java.lang.Object r9 = r2.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r8 = r9
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r57 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r58 = r0
            int r0 = r51 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r63 = r57
            r57 = 0
            r64 = r10
            androidx.compose.runtime.Applier r10 = r2.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x092f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x092f:
            r2.startReusableNode()
            boolean r10 = r2.getInserting()
            if (r10 == 0) goto L_0x093c
            r2.createNode(r9)
            goto L_0x093f
        L_0x093c:
            r2.useNode()
        L_0x093f:
            r2.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m4575constructorimpl(r2)
            r65 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r66 = androidx.compose.ui.node.ComposeUiNode.Companion
            r67 = r9
            kotlin.jvm.functions.Function2 r9 = r66.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r6, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r7, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r10, r8, r9)
            r2.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r9)
            int r10 = r0 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r65 = r3
            r3 = r63
            r3.invoke(r9, r2, r10)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r9)
            int r9 = r0 >> 9
            r9 = r9 & 14
            r10 = r2
            r63 = 0
            r66 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r68 = r3
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r38 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r69 = r10
            r70 = 0
            r71 = r0
            r0 = 1631550503(0x613f7c27, float:2.2076714E20)
            r72 = r3
            java.lang.String r3 = "C759@31872L27:Slider.kt#uh7d8r"
            r73 = r6
            r6 = r69
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r3)
            int r0 = r36 >> 24
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3 = r84
            r3.invoke(r15, r6, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.RangeSliderComponents r6 = androidx.compose.material3.RangeSliderComponents.ENDTHUMB
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r0, r6)
            r6 = 0
            r7 = 0
            r8 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            boolean r1 = r2.changed((java.lang.Object) r12)
            r8 = r2
            r9 = 0
            java.lang.Object r10 = r8.rememberedValue()
            r38 = 0
            if (r1 != 0) goto L_0x0a15
            androidx.compose.runtime.Composer$Companion r39 = androidx.compose.runtime.Composer.Companion
            r40 = r1
            java.lang.Object r1 = r39.getEmpty()
            if (r10 != r1) goto L_0x0a13
            goto L_0x0a17
        L_0x0a13:
            r1 = r10
            goto L_0x0a26
        L_0x0a15:
            r40 = r1
        L_0x0a17:
            r1 = 0
            r39 = r1
            androidx.compose.material3.SliderKt$RangeSliderImpl$1$3$1 r1 = new androidx.compose.material3.SliderKt$RangeSliderImpl$1$3$1
            r1.<init>(r12)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r8.updateRememberedValue(r1)
        L_0x0a26:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r0, r6, r1)
            r10 = r83
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.FocusableKt.focusable(r0, r4, r10)
            r1 = r48
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            r6 = 0
            r7 = 0
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            r9 = 0
            int r23 = r6 >> 3
            r23 = r23 & 14
            int r38 = r6 >> 3
            r38 = r38 & 112(0x70, float:1.57E-43)
            r1 = r23 | r38
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r9, r2, r1)
            int r23 = r6 << 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r38 = 0
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r39 = 6
            r40 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r5)
            java.lang.Object r4 = r2.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r3 = r4
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r39 = 6
            r40 = 0
            r50 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r5)
            java.lang.Object r7 = r2.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r4 = r7
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r39 = 6
            r40 = 0
            r51 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r8, r5)
            java.lang.Object r8 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r7 = r8
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r39 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r40 = r0
            int r0 = r23 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r52 = r39
            r39 = 0
            r55 = r9
            androidx.compose.runtime.Applier r9 = r2.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0ae8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0ae8:
            r2.startReusableNode()
            boolean r9 = r2.getInserting()
            if (r9 == 0) goto L_0x0af5
            r2.createNode(r8)
            goto L_0x0af8
        L_0x0af5:
            r2.useNode()
        L_0x0af8:
            r2.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r2)
            r57 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r58 = androidx.compose.ui.node.ComposeUiNode.Companion
            r59 = r8
            kotlin.jvm.functions.Function2 r8 = r58.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r4, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r7, r8)
            r2.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r8)
            int r9 = r0 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r57 = r1
            r1 = r52
            r1.invoke(r8, r2, r9)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r8)
            int r8 = r0 >> 9
            r8 = r8 & 14
            r9 = r2
            r52 = 0
            r58 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r63 = r1
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r6 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r65 = r9
            r66 = 0
            r67 = r0
            r0 = 1631550877(0x613f7d9d, float:2.2077372E20)
            r68 = r1
            java.lang.String r1 = "C767@32246L25:Slider.kt#uh7d8r"
            r69 = r3
            r3 = r65
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            int r0 = r35 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r85
            r1.invoke(r15, r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material3.RangeSliderComponents r3 = androidx.compose.material3.RangeSliderComponents.TRACK
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r0, r3)
            r3 = 6
            r4 = 0
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r7 = 0
            int r8 = r3 >> 3
            r8 = r8 & 14
            int r9 = r3 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r7, r2, r8)
            int r9 = r3 << 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r23 = 0
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r20 = 6
            r38 = 0
            r39 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r4, r5)
            java.lang.Object r4 = r2.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r1 = r4
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r20 = 6
            r38 = 0
            r40 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r6, r5)
            java.lang.Object r6 = r2.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r4 = r6
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r20 = 6
            r38 = 0
            r50 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r5)
            java.lang.Object r5 = r2.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            r20 = r0
            int r0 = r9 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r31 = 0
            r38 = r9
            androidx.compose.runtime.Applier r9 = r2.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0c50
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0c50:
            r2.startReusableNode()
            boolean r9 = r2.getInserting()
            if (r9 == 0) goto L_0x0c5d
            r2.createNode(r6)
            goto L_0x0c60
        L_0x0c5d:
            r2.useNode()
        L_0x0c60:
            r2.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r2)
            r51 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r52 = androidx.compose.ui.node.ComposeUiNode.Companion
            r55 = r6
            kotlin.jvm.functions.Function2 r6 = r52.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r4, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r5, r6)
            r2.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r6)
            int r9 = r0 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7.invoke(r6, r2, r9)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r6)
            int r6 = r0 >> 9
            r6 = r6 & 14
            r9 = r2
            r46 = 0
            r51 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r52 = r1
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r3 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r57 = r9
            r58 = 0
            r59 = r0
            r0 = 1631550998(0x613f7e16, float:2.2077585E20)
            r63 = r1
            java.lang.String r1 = "C769@32367L22:Slider.kt#uh7d8r"
            r65 = r3
            r3 = r57
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            r0 = r35 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r86
            r1.invoke(r15, r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0d1a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0d1a:
            androidx.compose.runtime.ScopeUpdateScope r15 = r13.endRestartGroup()
            if (r15 != 0) goto L_0x0d23
            r17 = r13
            goto L_0x0d55
        L_0x0d23:
            androidx.compose.material3.SliderKt$RangeSliderImpl$3 r16 = new androidx.compose.material3.SliderKt$RangeSliderImpl$3
            r0 = r16
            r1 = r75
            r2 = r76
            r3 = r77
            r4 = r78
            r5 = r79
            r6 = r24
            r7 = r81
            r8 = r82
            r9 = r83
            r10 = r84
            r11 = r85
            r12 = r86
            r17 = r13
            r13 = r88
            r14 = r89
            r74 = r15
            r15 = r90
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r74
            r1.updateScope(r0)
        L_0x0d55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSliderImpl(androidx.compose.ui.Modifier, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float RangeSliderImpl$lambda$25(MutableState<Float> $startThumbWidth$delegate) {
        return ((Number) $startThumbWidth$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$26(MutableState<Float> $startThumbWidth$delegate, float value) {
        $startThumbWidth$delegate.setValue(Float.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final float RangeSliderImpl$lambda$28(MutableState<Float> $endThumbWidth$delegate) {
        return ((Number) $endThumbWidth$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$29(MutableState<Float> $endThumbWidth$delegate, float value) {
        $endThumbWidth$delegate.setValue(Float.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final int RangeSliderImpl$lambda$31(MutableState<Integer> $totalWidth$delegate) {
        return ((Number) $totalWidth$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$32(MutableState<Integer> $totalWidth$delegate, int value) {
        $totalWidth$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> RangeSliderImpl$scaleToUserValue$33(ClosedFloatingPointRange<Float> $valueRange, float minPx, float maxPx, ClosedFloatingPointRange<Float> offset) {
        return scale(minPx, maxPx, offset, $valueRange.getStart().floatValue(), $valueRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float RangeSliderImpl$scaleToOffset$34(ClosedFloatingPointRange<Float> $valueRange, float minPx, float maxPx, float userValue) {
        return scale($valueRange.getStart().floatValue(), $valueRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* access modifiers changed from: private */
    public static final float snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        Float f;
        float[] $this$minByOrNull$iv = tickFractions;
        if ($this$minByOrNull$iv.length == 0) {
            f = null;
        } else {
            float minElem$iv = $this$minByOrNull$iv[0];
            int lastIndex$iv = ArraysKt.getLastIndex($this$minByOrNull$iv);
            if (lastIndex$iv == 0) {
                f = Float.valueOf(minElem$iv);
            } else {
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, minElem$iv) - current);
                IntIterator it = new IntRange(1, lastIndex$iv).iterator();
                while (it.hasNext()) {
                    float e$iv = $this$minByOrNull$iv[it.nextInt()];
                    float it2 = Math.abs(MathHelpersKt.lerp(minPx, maxPx, e$iv) - current);
                    if (Float.compare(minValue$iv, it2) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = it2;
                    }
                }
                f = Float.valueOf(minElem$iv);
            }
        }
        if (f != null) {
            return MathHelpersKt.lerp(minPx, maxPx, f.floatValue());
        }
        return current;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m3679awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r6 = r12.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r12.label
            switch(r0) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            java.lang.Object r8 = r12.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r6)
            r9 = r6
            goto L_0x0056
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r8
            r1 = r9
            r3 = r11
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r9 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r9.<init>(r8)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r12.L$0 = r8
            r10 = 1
            r12.label = r10
            r4 = r9
            r5 = r12
            java.lang.Object r9 = androidx.compose.material3.DragGestureDetectorCopyKt.m3452awaitHorizontalPointerSlopOrCancellationgDDlDlE(r0, r1, r3, r4, r5)
            if (r9 != r7) goto L_0x0056
            return r7
        L_0x0056:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L_0x0065
            float r10 = r8.element
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r9, r10)
            goto L_0x0066
        L_0x0065:
            r10 = 0
        L_0x0066:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m3679awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int steps) {
        if (steps == 0) {
            return new float[0];
        }
        int i = steps + 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = ((float) i2) / ((float) (steps + 1));
        }
        return fArr;
    }

    private static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    private static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> x, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, x.getStart().floatValue(), a2, b2), scale(a1, b1, x.getEndInclusive().floatValue(), a2, b2));
    }

    private static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, Function1 function1, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, Object obj) {
        Function0 function02;
        if ((i2 & 8) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        return sliderSemantics(modifier, f, z, function1, function02, (i2 & 16) != 0 ? RangesKt.rangeTo(0.0f, 1.0f) : closedFloatingPointRange, (i2 & 32) != 0 ? 0 : i);
    }

    private static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, boolean enabled, Function1<? super Float, Unit> onValueChange, Function0<Unit> onValueChangeFinished, ClosedFloatingPointRange<Float> valueRange, int steps) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new SliderKt$sliderSemantics$1(enabled, valueRange, steps, RangesKt.coerceIn(value, valueRange.getStart().floatValue(), valueRange.getEndInclusive().floatValue()), onValueChange, onValueChangeFinished), 1, (Object) null), value, valueRange, steps);
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, DraggableState draggableState, MutableInteractionSource interactionSource, int maxPx, boolean isRtl, State<Float> rawOffset, State<? extends Function0<Unit>> gestureEndAction, MutableState<Float> pressOffset, boolean enabled) {
        Modifier modifier = $this$sliderTapModifier;
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(draggableState, interactionSource, maxPx, isRtl, rawOffset, gestureEndAction, pressOffset, enabled) : InspectableValueKt.getNoInspectorInfo(), new SliderKt$sliderTapModifier$2(enabled, draggableState, interactionSource, maxPx, isRtl, pressOffset, rawOffset, gestureEndAction));
    }

    /* access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> $completion) {
        Object drag$default = DraggableState.drag$default(draggableState, (MutatePriority) null, new SliderKt$animateToTarget$2(current, target, velocity, (Continuation<? super SliderKt$animateToTarget$2>) null), $completion, 1, (Object) null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> rawOffsetStart, State<Float> rawOffsetEnd, boolean enabled, boolean isRtl, int maxPx, ClosedFloatingPointRange<Float> valueRange, State<? extends Function1<? super Boolean, Unit>> gestureEndAction, State<? extends Function2<? super Boolean, ? super Float, Unit>> onDrag) {
        if (enabled) {
            Modifier modifier = $this$rangeSliderPressDragModifier;
            return SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Integer.valueOf(maxPx), Boolean.valueOf(isRtl), valueRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(startInteractionSource, endInteractionSource, rawOffsetStart, rawOffsetEnd, onDrag, isRtl, maxPx, gestureEndAction, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null));
        }
        MutableInteractionSource mutableInteractionSource = startInteractionSource;
        MutableInteractionSource mutableInteractionSource2 = endInteractionSource;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = valueRange;
        return $this$rangeSliderPressDragModifier;
    }

    static {
        float r0 = SliderTokens.INSTANCE.m4427getHandleWidthD9Ej5fM();
        ThumbWidth = r0;
        float r1 = SliderTokens.INSTANCE.m4426getHandleHeightD9Ej5fM();
        ThumbHeight = r1;
        ThumbSize = DpKt.m7576DpSizeYgX7TsA(r0, r1);
        float r02 = Dp.m7554constructorimpl((float) 48);
        SliderHeight = r02;
        float r12 = Dp.m7554constructorimpl((float) 144);
        SliderMinWidth = r12;
        DefaultSliderConstraints = SizeKt.m2310heightInVpY3zN4$default(SizeKt.m2329widthInVpY3zN4$default(Modifier.Companion, r12, 0.0f, 2, (Object) null), 0.0f, r02, 1, (Object) null);
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}
