package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u0010\u001c\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'\u001ak\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a}\u00104\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00106\u001aK\u00107\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u00105\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00109\u001aS\u0010:\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0003¢\u0006\u0002\u0010=\u001a1\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010D\u001a \u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a0\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a<\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a.\u0010P\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010!\u001a\u00020\"H\u0002\u001aI\u0010T\u001a\u00020\u0012*\u00020U2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u00032\u0006\u00105\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a;\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\b\u0018\u00010[*\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a\u0001\u0010d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010h\u001a\u00020 2\u0006\u0010R\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u00140f2\u001e\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120k0fH\u0002\u001a\\\u0010l\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"H\u0002\u001aj\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020@2\u0006\u00105\u001a\u00020/2\u0006\u0010R\u001a\u00020\b2\u0006\u0010h\u001a\u00020 2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140f2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006p"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float ThumbDefaultElevation = Dp.m5844constructorimpl((float) 1);
    private static final float ThumbPressedElevation = Dp.m5844constructorimpl((float) 6);
    private static final float ThumbRadius = Dp.m5844constructorimpl((float) 10);
    private static final float ThumbRippleRadius = Dp.m5844constructorimpl((float) 24);
    private static final float TrackHeight = Dp.m5844constructorimpl((float) 4);

    /* JADX WARNING: Removed duplicated region for block: B:157:0x031c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r40, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, boolean r43, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r44, int r45, kotlin.jvm.functions.Function0<kotlin.Unit> r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.material.SliderColors r48, androidx.compose.runtime.Composer r49, int r50, int r51) {
        /*
            r12 = r41
            r13 = r50
            r11 = r51
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1962335196(0xffffffff8b092424, float:-2.641243E-32)
            r1 = r49
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Slider)P(7,4,3,1,8,6,5,2)154@7436L39,155@7519L8,158@7612L35,159@7672L59,162@7736L3444:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r50
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0025
            r1 = r1 | 6
            r9 = r40
            goto L_0x0038
        L_0x0025:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0036
            r9 = r40
            boolean r2 = r10.changed((float) r9)
            if (r2 == 0) goto L_0x0033
            r2 = 4
            goto L_0x0034
        L_0x0033:
            r2 = 2
        L_0x0034:
            r1 = r1 | r2
            goto L_0x0038
        L_0x0036:
            r9 = r40
        L_0x0038:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            goto L_0x004f
        L_0x003f:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            boolean r2 = r10.changedInstance(r12)
            if (r2 == 0) goto L_0x004c
            r2 = 32
            goto L_0x004e
        L_0x004c:
            r2 = 16
        L_0x004e:
            r1 = r1 | r2
        L_0x004f:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r42
            goto L_0x006d
        L_0x0058:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006b
            r3 = r42
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0067
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r4
            goto L_0x006d
        L_0x006b:
            r3 = r42
        L_0x006d:
            r4 = r11 & 8
            if (r4 == 0) goto L_0x0076
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r43
            goto L_0x008b
        L_0x0076:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0089
            r5 = r43
            boolean r6 = r10.changed((boolean) r5)
            if (r6 == 0) goto L_0x0085
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r1 = r1 | r6
            goto L_0x008b
        L_0x0089:
            r5 = r43
        L_0x008b:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00a6
            r6 = r11 & 16
            if (r6 != 0) goto L_0x00a0
            r6 = r44
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00a2
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a0:
            r6 = r44
        L_0x00a2:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r1 = r1 | r7
            goto L_0x00a8
        L_0x00a6:
            r6 = r44
        L_0x00a8:
            r7 = r11 & 32
            if (r7 == 0) goto L_0x00b2
            r8 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r8
            r8 = r45
            goto L_0x00c8
        L_0x00b2:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00c6
            r8 = r45
            boolean r14 = r10.changed((int) r8)
            if (r14 == 0) goto L_0x00c2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r14
            goto L_0x00c8
        L_0x00c6:
            r8 = r45
        L_0x00c8:
            r14 = r11 & 64
            if (r14 == 0) goto L_0x00d2
            r15 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r15
            r15 = r46
            goto L_0x00e9
        L_0x00d2:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r13
            if (r15 != 0) goto L_0x00e7
            r15 = r46
            boolean r16 = r10.changedInstance(r15)
            if (r16 == 0) goto L_0x00e2
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e4
        L_0x00e2:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e4:
            r1 = r1 | r16
            goto L_0x00e9
        L_0x00e7:
            r15 = r46
        L_0x00e9:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f4
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r3 = r47
            goto L_0x010c
        L_0x00f4:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x010a
            r3 = r47
            boolean r16 = r10.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x0105
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r1 = r1 | r16
            goto L_0x010c
        L_0x010a:
            r3 = r47
        L_0x010c:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0128
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x0121
            r3 = r48
            boolean r16 = r10.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x0123
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0121:
            r3 = r48
        L_0x0123:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r1 = r1 | r16
            goto L_0x012a
        L_0x0128:
            r3 = r48
        L_0x012a:
            r16 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r1 & r16
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r5) goto L_0x014e
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L_0x013b
            goto L_0x014e
        L_0x013b:
            r10.skipToGroupEnd()
            r39 = r42
            r12 = r43
            r17 = r47
            r18 = r48
            r19 = r1
            r14 = r6
            r16 = r15
            r15 = r8
            goto L_0x032a
        L_0x014e:
            r10.startDefaults()
            r3 = r13 & 1
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x018c
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0162
            goto L_0x018c
        L_0x0162:
            r10.skipToGroupEnd()
            r0 = r11 & 16
            if (r0 == 0) goto L_0x016b
            r1 = r1 & r16
        L_0x016b:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x017f
            r0 = r1 & r5
            r39 = r42
            r3 = r43
            r2 = r48
            r1 = r0
            r4 = r6
            r5 = r8
            r6 = r15
            r0 = r47
            goto L_0x021e
        L_0x017f:
            r39 = r42
            r3 = r43
            r0 = r47
            r2 = r48
            r4 = r6
            r5 = r8
            r6 = r15
            goto L_0x021e
        L_0x018c:
            if (r2 == 0) goto L_0x0193
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0195
        L_0x0193:
            r2 = r42
        L_0x0195:
            if (r4 == 0) goto L_0x0199
            r3 = 1
            goto L_0x019b
        L_0x0199:
            r3 = r43
        L_0x019b:
            r4 = r11 & 16
            if (r4 == 0) goto L_0x01a9
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            r1 = r1 & r16
            goto L_0x01aa
        L_0x01a9:
            r4 = r6
        L_0x01aa:
            if (r7 == 0) goto L_0x01ae
            r5 = 0
            goto L_0x01af
        L_0x01ae:
            r5 = r8
        L_0x01af:
            if (r14 == 0) goto L_0x01b3
            r6 = 0
            goto L_0x01b4
        L_0x01b3:
            r6 = r15
        L_0x01b4:
            if (r0 == 0) goto L_0x01ed
            r0 = 0
            r7 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            r8 = 0
            r14 = r10
            r15 = 0
            r42 = r0
            java.lang.Object r0 = r14.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r39 = r2
            java.lang.Object r2 = r17.getEmpty()
            if (r0 != r2) goto L_0x01e3
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r14.updateRememberedValue(r2)
            goto L_0x01e4
        L_0x01e3:
            r2 = r0
        L_0x01e4:
            r10.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x01f1
        L_0x01ed:
            r39 = r2
            r0 = r47
        L_0x01f1:
            r2 = r11 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x021c
            androidx.compose.material.SliderDefaults r14 = androidx.compose.material.SliderDefaults.INSTANCE
            r37 = 6
            r38 = 1023(0x3ff, float:1.434E-42)
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r36 = 0
            r35 = r10
            androidx.compose.material.SliderColors r2 = r14.m1393colorsq0g_0yA(r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r36, r37, r38)
            r7 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r7
            goto L_0x021e
        L_0x021c:
            r2 = r48
        L_0x021e:
            r10.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0230
            r7 = -1
            java.lang.String r8 = "androidx.compose.material.Slider (Slider.kt:145)"
            r14 = -1962335196(0xffffffff8b092424, float:-2.641243E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r1, r7, r8)
        L_0x0230:
            if (r5 < 0) goto L_0x0234
            r8 = 1
            goto L_0x0235
        L_0x0234:
            r8 = 0
        L_0x0235:
            if (r8 == 0) goto L_0x035c
            int r8 = r1 >> 3
            r8 = r8 & 14
            androidx.compose.runtime.State r8 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r10, r8)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            int r15 = r1 >> 15
            r15 = r15 & 14
            r16 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            boolean r7 = r10.changed((java.lang.Object) r14)
            r42 = r10
            r17 = 0
            java.lang.Object r9 = r42.rememberedValue()
            r18 = 0
            if (r7 != 0) goto L_0x0277
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r43 = r7
            java.lang.Object r7 = r19.getEmpty()
            if (r9 != r7) goto L_0x0270
            goto L_0x0279
        L_0x0270:
            r44 = r9
            r7 = r44
            r9 = r42
            goto L_0x0287
        L_0x0277:
            r43 = r7
        L_0x0279:
            r7 = 0
            java.util.List r7 = stepsToTickFractions(r5)
            r44 = r9
            r9 = r42
            r9.updateRememberedValue(r7)
        L_0x0287:
            r10.endReplaceableGroup()
            java.util.List r7 = (java.util.List) r7
            androidx.compose.ui.Modifier r9 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r39)
            float r14 = ThumbRadius
            r15 = 2
            r16 = 0
            float r11 = (float) r15
            float r11 = r11 * r14
            float r11 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r11)
            float r14 = ThumbRadius
            r15 = 2
            r16 = 0
            float r12 = (float) r15
            float r12 = r12 * r14
            float r12 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r12)
            r14 = 12
            r15 = 0
            r16 = 0
            r17 = 0
            r42 = r9
            r43 = r11
            r44 = r12
            r45 = r16
            r46 = r17
            r47 = r14
            r48 = r15
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m608requiredSizeInqDBjuR0$default(r42, r43, r44, r45, r46, r47, r48)
            r42 = r9
            r43 = r40
            r44 = r3
            r45 = r41
            r46 = r6
            r47 = r4
            r48 = r5
            androidx.compose.ui.Modifier r9 = sliderSemantics(r42, r43, r44, r45, r46, r47, r48)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.FocusableKt.focusable(r9, r3, r0)
            androidx.compose.material.SliderKt$Slider$3 r11 = new androidx.compose.material.SliderKt$Slider$3
            r14 = r11
            r15 = r4
            r16 = r1
            r17 = r40
            r18 = r0
            r19 = r3
            r20 = r7
            r21 = r2
            r22 = r8
            r23 = r6
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r12 = 2085116814(0x7c485b8e, float:4.1612653E36)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r12, r14, r11)
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r12 = 0
            r14 = 0
            r15 = 3072(0xc00, float:4.305E-42)
            r16 = 6
            r42 = r9
            r43 = r12
            r44 = r14
            r45 = r11
            r46 = r10
            r47 = r15
            r48 = r16
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r42, r43, r44, r45, r46, r47, r48)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x031f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031f:
            r17 = r0
            r19 = r1
            r18 = r2
            r12 = r3
            r14 = r4
            r15 = r5
            r16 = r6
        L_0x032a:
            androidx.compose.runtime.ScopeUpdateScope r11 = r10.endRestartGroup()
            if (r11 != 0) goto L_0x0335
            r21 = r10
            r42 = r12
            goto L_0x035b
        L_0x0335:
            androidx.compose.material.SliderKt$Slider$4 r20 = new androidx.compose.material.SliderKt$Slider$4
            r0 = r20
            r1 = r40
            r2 = r41
            r3 = r39
            r4 = r12
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r21 = r10
            r10 = r50
            r42 = r12
            r12 = r11
            r11 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x035b:
            return
        L_0x035c:
            r7 = 0
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "steps should be >= 0"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, SliderColors colors, Composer $composer, int $changed, int i) {
        boolean enabled2;
        ClosedFloatingPointRange valueRange2;
        int steps2;
        Function0 onValueChangeFinished2;
        SliderColors colors2;
        Function0 onValueChangeFinished3;
        int steps3;
        ClosedFloatingPointRange valueRange3;
        boolean enabled3;
        Modifier modifier2;
        Composer $composer2;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        List value$iv$iv3;
        Modifier modifier3;
        int i2;
        int i3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = value;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function1 = onValueChange;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(6,3,2,1,7,5,4)299@13521L8,301@13593L39,302@13690L39,305@13811L35,306@13871L59,310@13936L5142:Slider.kt#jmzs0o");
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
        if ((57344 & i4) == 0) {
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
        } else if ((458752 & i4) == 0) {
            steps2 = steps;
            $dirty2 |= $composer3.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i9 = i5 & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            onValueChangeFinished2 = onValueChangeFinished;
        } else if ((3670016 & i4) == 0) {
            onValueChangeFinished2 = onValueChangeFinished;
            $dirty2 |= $composer3.changedInstance(onValueChangeFinished2) ? 1048576 : 524288;
        } else {
            onValueChangeFinished2 = onValueChangeFinished;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) != 0) {
                SliderColors sliderColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            SliderColors sliderColors2 = colors;
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
                    colors2 = SliderDefaults.INSTANCE.m1393colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 6, 1023);
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2 & -29360129;
                } else {
                    colors2 = colors;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i5 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i5 & 128) != 0) {
                    modifier2 = modifier;
                    colors2 = colors;
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2 & -29360129;
                } else {
                    modifier2 = modifier;
                    colors2 = colors;
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556183027, $dirty, -1, "androidx.compose.material.RangeSlider (Slider.kt:290)");
            }
            boolean z = false;
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
                z = true;
            }
            if (z) {
                State onValueChangeState = SnapshotStateKt.rememberUpdatedState(function1, $composer3, ($dirty >> 3) & 14);
                Object key1$iv = Integer.valueOf(steps3);
                int i10 = ($dirty >> 15) & 14;
                $composer3.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer3.changed(key1$iv);
                Composer $this$cache$iv$iv3 = $composer3;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (invalid$iv$iv || it$iv$iv3 == Composer.Companion.getEmpty()) {
                    value$iv$iv3 = stepsToTickFractions(steps3);
                    $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer3.endReplaceableGroup();
                Modifier r26 = SizeKt.m608requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), Dp.m5844constructorimpl(((float) 4) * ThumbRadius), Dp.m5844constructorimpl(((float) 2) * ThumbRadius), 0.0f, 0.0f, 12, (Object) null);
                SliderKt$RangeSlider$2 sliderKt$RangeSlider$2 = r0;
                int i11 = $dirty;
                $composer2 = $composer3;
                SliderKt$RangeSlider$2 sliderKt$RangeSlider$22 = new SliderKt$RangeSlider$2(valueRange3, value, $dirty, onValueChangeState, startInteractionSource, endInteractionSource, enabled3, steps3, onValueChangeFinished3, value$iv$iv3, colors2);
                BoxWithConstraintsKt.BoxWithConstraints(r26, (Alignment) null, false, ComposableLambdaKt.composableLambda($composer2, 652589923, true, sliderKt$RangeSlider$2), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            colors2 = colors;
            int i12 = $dirty2;
            enabled3 = enabled2;
            valueRange3 = valueRange2;
            steps3 = steps2;
            onValueChangeFinished3 = onValueChangeFinished2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSlider$3(value, onValueChange, modifier2, enabled3, valueRange3, steps3, onValueChangeFinished3, colors2, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SliderImpl(boolean r46, float r47, java.util.List<java.lang.Float> r48, androidx.compose.material.SliderColors r49, float r50, androidx.compose.foundation.interaction.MutableInteractionSource r51, androidx.compose.ui.Modifier r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            r0 = 1679682785(0x641dece1, float:1.1652831E22)
            r1 = r53
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(SliderImpl)P(1,4,5!1,6)588@24897L712:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r54
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001c
            r3 = -1
            java.lang.String r4 = "androidx.compose.material.SliderImpl (Slider.kt:579)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x001c:
            androidx.compose.ui.Modifier r0 = DefaultSliderConstraints
            r12 = r52
            androidx.compose.ui.Modifier r0 = r12.then(r0)
            r3 = 0
            r4 = 0
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r6 = 0
            int r7 = r3 >> 3
            r7 = r7 & 14
            int r8 = r3 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r6, r1, r7)
            int r8 = r3 << 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r9 = 0
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            r10 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r10)
            androidx.compose.runtime.CompositionLocalMap r11 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r14 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            int r15 = r8 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r15 = r15 | 6
            r16 = 0
            r53 = r0
            androidx.compose.runtime.Applier r0 = r1.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x007f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x007f:
            r1.startReusableNode()
            boolean r0 = r1.getInserting()
            if (r0 == 0) goto L_0x008c
            r1.createNode(r13)
            goto L_0x008f
        L_0x008c:
            r1.useNode()
        L_0x008f:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r1)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r19 = r4
            kotlin.jvm.functions.Function2 r4 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r7, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r11, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r18 = 0
            r20 = r0
            r21 = 0
            boolean r22 = r20.getInserting()
            if (r22 != 0) goto L_0x00d1
            r22 = r5
            java.lang.Object r5 = r20.rememberedValue()
            r23 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x00ce
            goto L_0x00d5
        L_0x00ce:
            r6 = r20
            goto L_0x00e5
        L_0x00d1:
            r22 = r5
            r23 = r6
        L_0x00d5:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            r6 = r20
            r6.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            r0.apply(r5, r4)
        L_0x00e5:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r4 = r15 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r14.invoke(r0, r1, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r0)
            int r0 = r15 >> 9
            r0 = r0 & 14
            r4 = r1
            r5 = 0
            r6 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r17 = r0
            java.lang.String r0 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r3 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            r24 = r0
            androidx.compose.foundation.layout.BoxScope r24 = (androidx.compose.foundation.layout.BoxScope) r24
            r0 = r4
            r18 = 0
            r20 = r3
            r3 = 618023922(0x24d64bf2, float:9.293636E-17)
            r21 = r5
            java.lang.String r5 = "C*592@25057L7,601@25302L216,611@25527L76:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r5)
            r3 = 0
            r5 = 0
            r25 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r26 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r27 = r3
            r3 = r26
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r26 = 0
            r28 = 0
            r29 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            r41 = r7
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r7)
            java.lang.Object r5 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r3 = r5
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            r5 = 0
            float r7 = TrackHeight
            float r7 = r3.m5825toPx0680j_4(r7)
            r26 = r5
            float r5 = ThumbRadius
            float r5 = r3.m5825toPx0680j_4(r5)
            r12 = r50
            float r42 = r3.m5821toDpu2uoSUM((float) r12)
            float r3 = ThumbRadius
            r25 = 2
            r26 = r25
            r25 = 0
            r43 = r8
            r44 = r9
            r8 = r26
            float r9 = (float) r8
            float r9 = r9 * r3
            float r30 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r9)
            r3 = r42
            r8 = 0
            float r9 = r3 * r47
            float r26 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r9)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r8 = 1
            r9 = 0
            r45 = r10
            r10 = 0
            androidx.compose.ui.Modifier r31 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r3, r10, r8, r9)
            int r3 = r2 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r8 = 265222(0x40c06, float:3.71655E-40)
            r3 = r3 | r8
            int r8 = r2 << 6
            r8 = r8 & 896(0x380, float:1.256E-42)
            r3 = r3 | r8
            int r8 = r2 << 9
            r9 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r9
            r40 = r3 | r8
            r34 = 0
            r32 = r49
            r33 = r46
            r35 = r47
            r36 = r48
            r37 = r5
            r38 = r7
            r39 = r0
            Track(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r25 = r3
            androidx.compose.ui.Modifier r25 = (androidx.compose.ui.Modifier) r25
            r3 = r6 & 14
            r8 = 1572912(0x180030, float:2.204119E-39)
            r3 = r3 | r8
            int r8 = r2 >> 6
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r8
            int r8 = r2 << 3
            r8 = r8 & r9
            r3 = r3 | r8
            int r8 = r2 << 15
            r9 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r9
            r32 = r3 | r8
            r27 = r51
            r28 = r49
            r29 = r46
            r31 = r0
            m1394SliderThumbPcYyNuk(r24, r25, r26, r27, r28, r29, r30, r31, r32)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x020e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x020e:
            androidx.compose.runtime.ScopeUpdateScope r0 = r1.endRestartGroup()
            if (r0 != 0) goto L_0x0215
            goto L_0x0230
        L_0x0215:
            androidx.compose.material.SliderKt$SliderImpl$2 r13 = new androidx.compose.material.SliderKt$SliderImpl$2
            r3 = r13
            r4 = r46
            r5 = r47
            r6 = r48
            r7 = r49
            r8 = r50
            r9 = r51
            r10 = r52
            r11 = r54
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r0.updateScope(r13)
        L_0x0230:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.SliderImpl(boolean, float, java.util.List, androidx.compose.material.SliderColors, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSliderImpl(boolean r61, float r62, float r63, java.util.List<java.lang.Float> r64, androidx.compose.material.SliderColors r65, float r66, androidx.compose.foundation.interaction.MutableInteractionSource r67, androidx.compose.foundation.interaction.MutableInteractionSource r68, androidx.compose.ui.Modifier r69, androidx.compose.ui.Modifier r70, androidx.compose.ui.Modifier r71, androidx.compose.runtime.Composer r72, int r73, int r74) {
        /*
            r0 = -278895713(0xffffffffef60639f, float:-6.9445077E28)
            r1 = r72
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(RangeSliderImpl)P(1,6,5,9!1,10,7!1,4,8)630@26054L35,631@26122L33,632@26160L1522:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r73
            r3 = r74
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x001d
            java.lang.String r4 = "androidx.compose.material.RangeSliderImpl (Slider.kt:616)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r3, r4)
        L_0x001d:
            androidx.compose.material.Strings$Companion r0 = androidx.compose.material.Strings.Companion
            int r0 = r0.m1417getSliderRangeStartUdPEhr4()
            r4 = 6
            java.lang.String r0 = androidx.compose.material.Strings_androidKt.m1418getString4foXLRw(r0, r1, r4)
            androidx.compose.material.Strings$Companion r5 = androidx.compose.material.Strings.Companion
            int r5 = r5.m1416getSliderRangeEndUdPEhr4()
            java.lang.String r5 = androidx.compose.material.Strings_androidKt.m1418getString4foXLRw(r5, r1, r4)
            androidx.compose.ui.Modifier r6 = DefaultSliderConstraints
            r15 = r69
            androidx.compose.ui.Modifier r6 = r15.then(r6)
            r7 = 0
            r8 = 0
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r1.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            r10 = 0
            int r11 = r7 >> 3
            r11 = r11 & 14
            int r12 = r7 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r10, r1, r11)
            int r12 = r7 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r13 = 0
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r14 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r14)
            androidx.compose.runtime.CompositionLocalMap r4 = r1.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r6)
            r21 = r3
            int r3 = r12 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r18 = 6
            r3 = r3 | 6
            r18 = r17
            r17 = r16
            r16 = 0
            r19 = r6
            androidx.compose.runtime.Applier r6 = r1.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x009c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x009c:
            r1.startReusableNode()
            boolean r6 = r1.getInserting()
            if (r6 == 0) goto L_0x00ab
            r6 = r17
            r1.createNode(r6)
            goto L_0x00b0
        L_0x00ab:
            r6 = r17
            r1.useNode()
        L_0x00b0:
            r17 = r6
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2865constructorimpl(r1)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r8
            kotlin.jvm.functions.Function2 r8 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r6, r11, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r6, r4, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            r22 = 0
            r24 = r6
            r25 = 0
            boolean r26 = r24.getInserting()
            if (r26 != 0) goto L_0x00f4
            r26 = r4
            java.lang.Object r4 = r24.rememberedValue()
            r27 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r4 != 0) goto L_0x00f1
            goto L_0x00f8
        L_0x00f1:
            r9 = r24
            goto L_0x0108
        L_0x00f4:
            r26 = r4
            r27 = r9
        L_0x00f8:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r9 = r24
            r9.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r6.apply(r4, r8)
        L_0x0108:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r4)
            int r6 = r3 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r8 = r18
            r8.invoke(r4, r1, r6)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r4)
            int r4 = r3 >> 9
            r4 = r4 & 14
            r6 = r1
            r9 = 0
            r18 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r20 = r4
            java.lang.String r4 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r4 = r7 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r22 = 6
            r4 = r4 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r72 = r6
            r22 = 0
            r24 = r7
            r7 = -1690173328(0xffffffff9b420070, float:-1.6047445E-22)
            r25 = r8
            java.lang.String r8 = "C*636@26320L7,645@26628L301,660@27025L48,658@26939L369,671@27403L46,669@27317L359:Slider.kt#jmzs0o"
            r56 = r9
            r9 = r72
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r7, r8)
            r7 = 0
            r8 = 0
            r28 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r29 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r72 = r7
            r7 = r29
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r29 = 0
            r30 = 0
            r31 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            r57 = r10
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r10)
            java.lang.Object r8 = r9.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r7 = r8
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            r8 = 0
            float r10 = TrackHeight
            float r10 = r7.m5825toPx0680j_4(r10)
            r72 = r8
            float r8 = ThumbRadius
            float r8 = r7.m5825toPx0680j_4(r8)
            r15 = r66
            float r58 = r7.m5821toDpu2uoSUM((float) r15)
            float r7 = ThumbRadius
            r28 = 2
            r72 = r28
            r28 = 0
            r59 = r11
            r11 = r72
            r72 = r12
            float r12 = (float) r11
            float r12 = r12 * r7
            float r44 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r12)
            r7 = r58
            r11 = 0
            float r12 = r7 * r62
            float r40 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r12)
            r11 = 0
            float r12 = r7 * r63
            float r49 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r12)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getCenterStart()
            androidx.compose.ui.Modifier r7 = r3.align(r7, r11)
            r11 = 0
            r12 = 0
            r60 = r13
            r13 = 1
            androidx.compose.ui.Modifier r28 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r7, r11, r13, r12)
            int r7 = r2 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r11 = 262144(0x40000, float:3.67342E-40)
            r7 = r7 | r11
            int r11 = r2 << 6
            r11 = r11 & 896(0x380, float:1.256E-42)
            r7 = r7 | r11
            int r11 = r2 << 6
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r11
            int r11 = r2 << 6
            r12 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r12
            r37 = r7 | r11
            r29 = r65
            r30 = r61
            r31 = r62
            r32 = r63
            r33 = r64
            r34 = r8
            r35 = r10
            r36 = r9
            Track(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r11 = 0
            r28 = 0
            r12 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            boolean r31 = r9.changed((java.lang.Object) r0)
            r32 = r9
            r33 = 0
            java.lang.Object r13 = r32.rememberedValue()
            r35 = 0
            if (r31 != 0) goto L_0x023f
            androidx.compose.runtime.Composer$Companion r36 = androidx.compose.runtime.Composer.Companion
            r37 = r8
            java.lang.Object r8 = r36.getEmpty()
            if (r13 != r8) goto L_0x0239
            goto L_0x0241
        L_0x0239:
            r36 = r0
            r8 = r13
            r0 = r32
            goto L_0x0254
        L_0x023f:
            r37 = r8
        L_0x0241:
            r8 = 0
            r36 = r8
            androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1 r8 = new androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
            r8.<init>(r0)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r36 = r0
            r0 = r32
            r0.updateRememberedValue(r8)
        L_0x0254:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r0 = 1
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r7, r0, r8)
            r13 = r67
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.FocusableKt.focusable(r7, r0, r13)
            r0 = r70
            androidx.compose.ui.Modifier r39 = r7.then(r0)
            r7 = r4 & 14
            r8 = 1572864(0x180000, float:2.204052E-39)
            r7 = r7 | r8
            int r11 = r2 >> 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r28 = r2 & r11
            r7 = r7 | r28
            int r11 = r2 << 15
            r28 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r28
            r46 = r7 | r11
            r38 = r3
            r41 = r67
            r42 = r65
            r43 = r61
            r45 = r9
            m1394SliderThumbPcYyNuk(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r11 = 0
            r31 = 0
            r8 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            boolean r8 = r9.changed((java.lang.Object) r5)
            r12 = r9
            r30 = 0
            java.lang.Object r0 = r12.rememberedValue()
            r33 = 0
            if (r8 != 0) goto L_0x02c4
            androidx.compose.runtime.Composer$Companion r35 = androidx.compose.runtime.Composer.Companion
            r38 = r8
            java.lang.Object r8 = r35.getEmpty()
            if (r0 != r8) goto L_0x02c1
            goto L_0x02c6
        L_0x02c1:
            r35 = r0
            goto L_0x02d5
        L_0x02c4:
            r38 = r8
        L_0x02c6:
            r8 = 0
            r35 = r0
            androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1 r0 = new androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
            r0.<init>(r5)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r12.updateRememberedValue(r0)
        L_0x02d5:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r8 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r7, r8, r0)
            r12 = r68
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.FocusableKt.focusable(r0, r8, r12)
            r11 = r71
            androidx.compose.ui.Modifier r48 = r0.then(r11)
            r0 = r4 & 14
            r7 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r7
            int r7 = r2 >> 12
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r2
            r0 = r0 | r7
            int r7 = r2 << 15
            r7 = r7 & r28
            r55 = r0 | r7
            r47 = r3
            r50 = r68
            r51 = r65
            r52 = r61
            r53 = r44
            r54 = r9
            m1394SliderThumbPcYyNuk(r47, r48, r49, r50, r51, r52, r53, r54, r55)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0335
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0335:
            androidx.compose.runtime.ScopeUpdateScope r0 = r1.endRestartGroup()
            if (r0 != 0) goto L_0x033c
            goto L_0x0361
        L_0x033c:
            androidx.compose.material.SliderKt$RangeSliderImpl$2 r3 = new androidx.compose.material.SliderKt$RangeSliderImpl$2
            r7 = r3
            r8 = r61
            r9 = r62
            r10 = r63
            r11 = r64
            r12 = r65
            r13 = r66
            r14 = r67
            r15 = r68
            r16 = r69
            r17 = r70
            r18 = r71
            r19 = r73
            r20 = r74
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0.updateScope(r3)
        L_0x0361:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.RangeSliderImpl(boolean, float, float, java.util.List, androidx.compose.material.SliderColors, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.Modifier, androidx.compose.ui.Modifier, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x033f  */
    /* renamed from: SliderThumb-PcYyNuk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1394SliderThumbPcYyNuk(androidx.compose.foundation.layout.BoxScope r54, androidx.compose.ui.Modifier r55, float r56, androidx.compose.foundation.interaction.MutableInteractionSource r57, androidx.compose.material.SliderColors r58, boolean r59, float r60, androidx.compose.runtime.Composer r61, int r62) {
        /*
            r9 = r54
            r10 = r55
            r11 = r57
            r12 = r58
            r13 = r59
            r14 = r60
            r15 = r62
            r0 = 428907178(0x19909aaa, float:1.495172E-23)
            r1 = r61
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SliderThumb)P(3,4:c#ui.unit.Dp,2!,5:c#ui.unit.Dp)692@27895L1553:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r62
            r2 = r15 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r8.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r1 = r1 | r2
        L_0x002c:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003c
            boolean r2 = r8.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0039
            r2 = 32
            goto L_0x003b
        L_0x0039:
            r2 = 16
        L_0x003b:
            r1 = r1 | r2
        L_0x003c:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x004f
            r7 = r56
            boolean r2 = r8.changed((float) r7)
            if (r2 == 0) goto L_0x004b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004d
        L_0x004b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004d:
            r1 = r1 | r2
            goto L_0x0051
        L_0x004f:
            r7 = r56
        L_0x0051:
            r2 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0061
            boolean r2 = r8.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x005e
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0060
        L_0x005e:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0060:
            r1 = r1 | r2
        L_0x0061:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r15
            if (r2 != 0) goto L_0x0073
            boolean r2 = r8.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0070
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0072
        L_0x0070:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0072:
            r1 = r1 | r2
        L_0x0073:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r15
            if (r2 != 0) goto L_0x0084
            boolean r2 = r8.changed((boolean) r13)
            if (r2 == 0) goto L_0x0081
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0083
        L_0x0081:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0083:
            r1 = r1 | r2
        L_0x0084:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r15
            if (r2 != 0) goto L_0x0095
            boolean r2 = r8.changed((float) r14)
            if (r2 == 0) goto L_0x0092
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0094
        L_0x0092:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x0094:
            r1 = r1 | r2
        L_0x0095:
            r6 = r1
            r1 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r1 & r6
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r2) goto L_0x00ab
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x00a6
            goto L_0x00ab
        L_0x00a6:
            r8.skipToGroupEnd()
            goto L_0x0342
        L_0x00ab:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b7
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.SliderThumb (Slider.kt:684)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L_0x00b7:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r16 = r0
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r21 = 14
            r22 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r56
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m542paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenterStart()
            androidx.compose.ui.Modifier r0 = r9.align(r0, r1)
            r1 = 0
            r2 = r1
            r4 = 0
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r3 = 0
            int r16 = r2 >> 3
            r16 = r16 & 14
            int r17 = r2 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r1 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r3, r8, r1)
            int r16 = r2 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r17 = 0
            r19 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            r3 = 0
            int r20 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r21 = r21.getConstructor()
            kotlin.jvm.functions.Function3 r22 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r23 = r0
            int r0 = r16 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r24 = r22
            r22 = r21
            r21 = 0
            r25 = r4
            androidx.compose.runtime.Applier r4 = r8.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x013e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x013e:
            r8.startReusableNode()
            boolean r4 = r8.getInserting()
            if (r4 == 0) goto L_0x014d
            r4 = r22
            r8.createNode(r4)
            goto L_0x0152
        L_0x014d:
            r4 = r22
            r8.useNode()
        L_0x0152:
            r22 = r4
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2865constructorimpl(r8)
            r26 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r27 = androidx.compose.ui.node.ComposeUiNode.Companion
            r28 = r5
            kotlin.jvm.functions.Function2 r5 = r27.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r4, r3, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r27 = 0
            r29 = r4
            r30 = 0
            boolean r31 = r29.getInserting()
            if (r31 != 0) goto L_0x0196
            r31 = r1
            java.lang.Object r1 = r29.rememberedValue()
            r32 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x0193
            goto L_0x019a
        L_0x0193:
            r3 = r29
            goto L_0x01aa
        L_0x0196:
            r31 = r1
            r32 = r3
        L_0x019a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            r3 = r29
            r3.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            r4.apply(r1, r5)
        L_0x01aa:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r24
            r4.invoke(r1, r8, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r1)
            int r1 = r0 >> 9
            r1 = r1 & 14
            r3 = r8
            r5 = 0
            r24 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r26 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r2 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r27 = r3
            r29 = 0
            r30 = r0
            r0 = -528162279(0xffffffffe084e219, float:-7.660195E19)
            r40 = r1
            java.lang.String r1 = "C696@28026L46,697@28115L658,697@28081L692,720@29129L59,724@29393L19,715@28935L507:Slider.kt#jmzs0o"
            r41 = r2
            r2 = r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r0 = 0
            r1 = 0
            r27 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = 0
            r33 = r2
            r34 = 0
            r35 = r0
            java.lang.Object r0 = r33.rememberedValue()
            r36 = 0
            androidx.compose.runtime.Composer$Companion r37 = androidx.compose.runtime.Composer.Companion
            r38 = r1
            java.lang.Object r1 = r37.getEmpty()
            if (r0 != r1) goto L_0x022f
            r1 = 0
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r37 = r0
            r0 = r33
            r0.updateRememberedValue(r1)
            goto L_0x0235
        L_0x022f:
            r37 = r0
            r0 = r33
            r1 = r37
        L_0x0235:
            r2.endReplaceableGroup()
            r0 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
            int r1 = r6 >> 9
            r1 = r1 & 14
            r1 = r1 | 48
            r27 = 0
            r33 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            boolean r1 = r2.changed((java.lang.Object) r11)
            boolean r34 = r2.changed((java.lang.Object) r0)
            r1 = r1 | r34
            r34 = r2
            r35 = 0
            r42 = r4
            java.lang.Object r4 = r34.rememberedValue()
            r36 = 0
            r43 = r5
            if (r1 != 0) goto L_0x027d
            androidx.compose.runtime.Composer$Companion r37 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r37.getEmpty()
            if (r4 != r5) goto L_0x0275
            goto L_0x027d
        L_0x0275:
            r37 = r1
            r1 = r4
            r38 = r1
            r4 = r34
            goto L_0x0291
        L_0x027d:
            r5 = 0
            r37 = r1
            androidx.compose.material.SliderKt$SliderThumb$1$1$1 r1 = new androidx.compose.material.SliderKt$SliderThumb$1$1$1
            r38 = r4
            r4 = 0
            r1.<init>(r11, r0, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r34
            r4.updateRememberedValue(r1)
        L_0x0291:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r4 = r6 >> 9
            r4 = r4 & 14
            r4 = r4 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r2, (int) r4)
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x02af
            float r1 = ThumbPressedElevation
            goto L_0x02b1
        L_0x02af:
            float r1 = ThumbDefaultElevation
        L_0x02b1:
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m614sizeVpY3zN4(r10, r14, r14)
            r5 = r11
            androidx.compose.foundation.interaction.InteractionSource r5 = (androidx.compose.foundation.interaction.InteractionSource) r5
            float r34 = ThumbRippleRadius
            r38 = 54
            r39 = 4
            r33 = 0
            r35 = 0
            r37 = r2
            r27 = r0
            androidx.compose.foundation.Indication r0 = androidx.compose.material.ripple.RippleKt.m1523rememberRipple9IZ8Weo(r33, r34, r35, r37, r38, r39)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.IndicationKt.indication(r4, r5, r0)
            r61 = r1
            r1 = 0
            r4 = 0
            r5 = 2
            androidx.compose.ui.Modifier r44 = androidx.compose.foundation.HoverableKt.hoverable$default(r0, r11, r1, r5, r4)
            if (r13 == 0) goto L_0x02de
            r45 = r61
            goto L_0x02e7
        L_0x02de:
            r0 = 0
            r1 = 0
            float r4 = (float) r0
            float r4 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r4)
            r45 = r4
        L_0x02e7:
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            r46 = r0
            androidx.compose.ui.graphics.Shape r46 = (androidx.compose.ui.graphics.Shape) r46
            r52 = 24
            r53 = 0
            r47 = 0
            r48 = 0
            r50 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ShadowKt.m2912shadows4CzXII$default(r44, r45, r46, r47, r48, r50, r52, r53)
            int r1 = r6 >> 15
            r1 = r1 & 14
            int r4 = r6 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            androidx.compose.runtime.State r1 = r12.thumbColor(r13, r2, r1)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r4 = r1.m3263unboximpl()
            androidx.compose.foundation.shape.RoundedCornerShape r1 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m166backgroundbw27NRU(r0, r4, r1)
            r1 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r2, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r8.endReplaceableGroup()
            r8.endNode()
            r8.endReplaceableGroup()
            r8.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0342
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0342:
            androidx.compose.runtime.ScopeUpdateScope r5 = r8.endRestartGroup()
            if (r5 != 0) goto L_0x034d
            r17 = r6
            r18 = r8
            goto L_0x0370
        L_0x034d:
            androidx.compose.material.SliderKt$SliderThumb$2 r16 = new androidx.compose.material.SliderKt$SliderThumb$2
            r0 = r16
            r1 = r54
            r2 = r55
            r3 = r56
            r4 = r57
            r9 = r5
            r5 = r58
            r17 = r6
            r6 = r59
            r7 = r60
            r18 = r8
            r8 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0370:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.m1394SliderThumbPcYyNuk(androidx.compose.foundation.layout.BoxScope, androidx.compose.ui.Modifier, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, boolean, float, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void Track(Modifier modifier, SliderColors colors, boolean enabled, float positionFractionStart, float positionFractionEnd, List<Float> tickFractions, float thumbPx, float trackStrokeWidth, Composer $composer, int $changed) {
        SliderColors sliderColors = colors;
        boolean z = enabled;
        Composer $composer2 = $composer.startRestartGroup(1833126050);
        ComposerKt.sourceInformation($composer2, "C(Track)P(2!2,4!1,6)740@29741L35,741@29811L34,742@29881L34,743@29949L33,744@29987L1514:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1833126050, $dirty, -1, "androidx.compose.material.Track (Slider.kt:730)");
        }
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(modifier2, new SliderKt$Track$1(thumbPx, sliderColors.trackColor(z, false, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), trackStrokeWidth, positionFractionEnd, positionFractionStart, sliderColors.trackColor(z, true, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), tickFractions, sliderColors.tickColor(z, false, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), sliderColors.tickColor(z, true, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896))), $composer2, $dirty & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$Track$2(modifier, colors, enabled, positionFractionStart, positionFractionEnd, tickFractions, thumbPx, trackStrokeWidth, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final float snapValueToTick(float current, List<Float> tickFractions, float minPx, float maxPx) {
        Object minElem$iv;
        Iterator iterator$iv = tickFractions.iterator();
        if (!iterator$iv.hasNext()) {
            minElem$iv = null;
        } else {
            minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, ((Number) minElem$iv).floatValue()) - current);
                do {
                    Object e$iv = iterator$iv.next();
                    float it = Math.abs(MathHelpersKt.lerp(minPx, maxPx, ((Number) e$iv).floatValue()) - current);
                    if (Float.compare(minValue$iv, it) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = it;
                    }
                } while (iterator$iv.hasNext());
            }
        }
        Object minElem$iv2 = (Float) minElem$iv;
        if (minElem$iv2 != null) {
            return MathHelpersKt.lerp(minPx, maxPx, ((Number) minElem$iv2).floatValue());
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
    public static final java.lang.Object m1397awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = (androidx.compose.material.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = new androidx.compose.material.SliderKt$awaitSlop$1
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
            androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1 r9 = new androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
            r9.<init>(r8)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r12.L$0 = r8
            r10 = 1
            r12.label = r10
            r4 = r9
            r5 = r12
            java.lang.Object r9 = androidx.compose.material.DragGestureDetectorCopyKt.m1277awaitHorizontalPointerSlopOrCancellationgDDlDlE(r0, r1, r3, r4, r5)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.m1397awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final List<Float> stepsToTickFractions(int steps) {
        if (steps == 0) {
            return CollectionsKt.emptyList();
        }
        int i = steps + 2;
        ArrayList arrayList = new ArrayList(i);
        for (int it = 0; it < i; it++) {
            arrayList.add(Float.valueOf(((float) it) / ((float) (steps + 1))));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> x, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, x.getStart().floatValue(), a2, b2), scale(a1, b1, x.getEndInclusive().floatValue(), a2, b2));
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    public static final void CorrectValueSideEffect(Function1<? super Float, Float> scaleToOffset, ClosedFloatingPointRange<Float> valueRange, ClosedFloatingPointRange<Float> trackRange, MutableState<Float> valueState, float value, Composer $composer, int $changed) {
        int i;
        Function1<? super Float, Float> function1 = scaleToOffset;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = valueRange;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2 = trackRange;
        MutableState<Float> mutableState = valueState;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-743965752);
        ComposerKt.sourceInformation($composer2, "C(CorrectValueSideEffect)P(!1,3!1,4)839@33355L300,839@33344L311:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) closedFloatingPointRange) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed((Object) closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) mutableState) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed(value) ? 16384 : 8192;
        } else {
            float f = value;
        }
        if ((46811 & $dirty) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, i2, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:832)");
            }
            Object[] keys$iv = {closedFloatingPointRange, function1, Float.valueOf(value), mutableState, closedFloatingPointRange2};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                Object[] objArr = keys$iv;
                i = 0;
                value$iv$iv = new SliderKt$CorrectValueSideEffect$1$1(valueRange, scaleToOffset, value, valueState, trackRange);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object obj2 = value$iv$iv;
                i = 0;
                Object[] objArr2 = keys$iv;
                Composer composer = $this$cache$iv$iv;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv, $composer2, i);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$CorrectValueSideEffect$2(scaleToOffset, valueRange, trackRange, valueState, value, $changed));
        }
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

    /* access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, boolean enabled, Function1<? super Float, Unit> onValueChange, Function0<Unit> onValueChangeFinished, ClosedFloatingPointRange<Float> valueRange, int steps) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new SliderKt$sliderSemantics$1(enabled, valueRange, steps, RangesKt.coerceIn(value, valueRange.getStart().floatValue(), valueRange.getEndInclusive().floatValue()), onValueChange, onValueChangeFinished), 1, (Object) null), value, valueRange, steps);
    }

    /* access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, DraggableState draggableState, MutableInteractionSource interactionSource, float maxPx, boolean isRtl, State<Float> rawOffset, State<? extends Function1<? super Float, Unit>> gestureEndAction, MutableState<Float> pressOffset, boolean enabled) {
        Modifier modifier = $this$sliderTapModifier;
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(draggableState, interactionSource, maxPx, isRtl, rawOffset, gestureEndAction, pressOffset, enabled) : InspectableValueKt.getNoInspectorInfo(), new SliderKt$sliderTapModifier$2(enabled, draggableState, interactionSource, maxPx, isRtl, pressOffset, rawOffset, gestureEndAction));
    }

    /* access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> $completion) {
        Object drag$default = DraggableState.drag$default(draggableState, (MutatePriority) null, new SliderKt$animateToTarget$2(current, target, velocity, (Continuation<? super SliderKt$animateToTarget$2>) null), $completion, 1, (Object) null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> rawOffsetStart, State<Float> rawOffsetEnd, boolean enabled, boolean isRtl, float maxPx, ClosedFloatingPointRange<Float> valueRange, State<? extends Function1<? super Boolean, Unit>> gestureEndAction, State<? extends Function2<? super Boolean, ? super Float, Unit>> onDrag) {
        if (enabled) {
            Modifier modifier = $this$rangeSliderPressDragModifier;
            return SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Float.valueOf(maxPx), Boolean.valueOf(isRtl), valueRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(startInteractionSource, endInteractionSource, rawOffsetStart, rawOffsetEnd, onDrag, isRtl, maxPx, gestureEndAction, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null));
        }
        MutableInteractionSource mutableInteractionSource = startInteractionSource;
        MutableInteractionSource mutableInteractionSource2 = endInteractionSource;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = valueRange;
        return $this$rangeSliderPressDragModifier;
    }

    static {
        float r0 = Dp.m5844constructorimpl((float) 48);
        SliderHeight = r0;
        float r1 = Dp.m5844constructorimpl((float) 144);
        SliderMinWidth = r1;
        DefaultSliderConstraints = SizeKt.m600heightInVpY3zN4$default(SizeKt.m619widthInVpY3zN4$default(Modifier.Companion, r1, 0.0f, 2, (Object) null), 0.0f, r0, 1, (Object) null);
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}
