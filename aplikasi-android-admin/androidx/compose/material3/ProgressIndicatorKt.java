package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aG\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a;\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aO\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a3\u00105\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a=\u00105\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a;\u00105\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001aE\u00105\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a)\u0010F\u001a\u00020#*\u00020?2\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a9\u0010I\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010E\u001aA\u0010K\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001aA\u0010N\u001a\u00020#*\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a1\u0010S\u001a\u00020#*\u00020?2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010U\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m7554constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m4029getSizeD9Ej5fM() - Dp.m7554constructorimpl(((float) 2) * CircularProgressIndicatorTokens.INSTANCE.m4028getActiveIndicatorWidthD9Ej5fM()));
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m4257getTrackHeightD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m7554constructorimpl((float) 240);
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARNING: Removed duplicated region for block: B:97:0x01b7  */
    /* renamed from: LinearProgressIndicator-_5eSR-E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3628LinearProgressIndicator_5eSRE(float r23, androidx.compose.ui.Modifier r24, long r25, long r27, int r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r23
            r11 = r31
            r0 = 905419617(0x35f79b61, float:1.8448155E-6)
            r1 = r30
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)75@3530L11,76@3593L16,84@3883L194,80@3741L336:ProgressIndicator.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r31
            r2 = r32 & 1
            if (r2 == 0) goto L_0x001b
            r1 = r1 | 6
            goto L_0x0029
        L_0x001b:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0029
            boolean r2 = r12.changed((float) r10)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r1 = r1 | r2
        L_0x0029:
            r2 = r32 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            r3 = r24
            goto L_0x0047
        L_0x0032:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r24
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r24
        L_0x0047:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0060
            r4 = r32 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r25
            boolean r6 = r12.changed((long) r4)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r25
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r6
            goto L_0x0062
        L_0x0060:
            r4 = r25
        L_0x0062:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007b
            r6 = r32 & 8
            if (r6 != 0) goto L_0x0075
            r6 = r27
            boolean r8 = r12.changed((long) r6)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r6 = r27
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r6 = r27
        L_0x007d:
            r8 = r32 & 16
            if (r8 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r29
            goto L_0x009d
        L_0x0086:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x009b
            r9 = r29
            boolean r13 = r12.changed((int) r9)
            if (r13 == 0) goto L_0x0097
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r1 = r1 | r13
            goto L_0x009d
        L_0x009b:
            r9 = r29
        L_0x009d:
            r13 = 46811(0xb6db, float:6.5596E-41)
            r13 = r13 & r1
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00b9
            boolean r13 = r12.getSkipping()
            if (r13 != 0) goto L_0x00ac
            goto L_0x00b9
        L_0x00ac:
            r12.skipToGroupEnd()
            r19 = r1
            r17 = r3
            r13 = r4
            r15 = r6
            r18 = r9
            goto L_0x01c0
        L_0x00b9:
            r12.startDefaults()
            r13 = r11 & 1
            if (r13 == 0) goto L_0x00d9
            boolean r13 = r12.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00c7
            goto L_0x00d9
        L_0x00c7:
            r12.skipToGroupEnd()
            r2 = r32 & 4
            if (r2 == 0) goto L_0x00d0
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d0:
            r2 = r32 & 8
            if (r2 == 0) goto L_0x00d6
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00d6:
            r2 = r3
            r3 = r4
            goto L_0x0106
        L_0x00d9:
            if (r2 == 0) goto L_0x00e0
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00e1
        L_0x00e0:
            r2 = r3
        L_0x00e1:
            r3 = r32 & 4
            r13 = 6
            if (r3 == 0) goto L_0x00ef
            androidx.compose.material3.ProgressIndicatorDefaults r3 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r3 = r3.getLinearColor(r12, r13)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00f0
        L_0x00ef:
            r3 = r4
        L_0x00f0:
            r5 = r32 & 8
            if (r5 == 0) goto L_0x00fd
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r5 = r5.getLinearTrackColor(r12, r13)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r5
        L_0x00fd:
            if (r8 == 0) goto L_0x0106
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            int r5 = r5.m3621getLinearStrokeCapKaPHkGw()
            r9 = r5
        L_0x0106:
            r12.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0115
            r5 = -1
            java.lang.String r8 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:72)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r5, r8)
        L_0x0115:
            r0 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            float r0 = kotlin.ranges.RangesKt.coerceIn((float) r10, (float) r0, (float) r5)
            r5 = 6
            r8 = 0
            r13 = 0
            r14 = 0
            r24 = r2
            r25 = r0
            r26 = r13
            r27 = r14
            r28 = r5
            r29 = r8
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r24, r25, r26, r27, r28, r29)
            float r8 = LinearIndicatorWidth
            float r13 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m2324sizeVpY3zN4(r5, r8, r13)
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m4953boximpl(r6)
            androidx.compose.ui.graphics.StrokeCap r13 = androidx.compose.ui.graphics.StrokeCap.m5344boximpl(r9)
            java.lang.Float r14 = java.lang.Float.valueOf(r0)
            androidx.compose.ui.graphics.Color r15 = androidx.compose.ui.graphics.Color.m4953boximpl(r3)
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r13, r14, r15}
            r13 = 8
            r14 = 0
            r15 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r12.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            r15 = 0
            r16 = r1
            int r1 = r8.length
            r17 = r2
            r2 = 0
        L_0x0162:
            if (r2 >= r1) goto L_0x0173
            r24 = r1
            r1 = r8[r2]
            boolean r19 = r12.changed((java.lang.Object) r1)
            r15 = r15 | r19
            int r2 = r2 + 1
            r1 = r24
            goto L_0x0162
        L_0x0173:
            r1 = r12
            r2 = 0
            r19 = r2
            java.lang.Object r2 = r1.rememberedValue()
            r20 = 0
            if (r15 != 0) goto L_0x018c
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r8
            java.lang.Object r8 = r21.getEmpty()
            if (r2 != r8) goto L_0x018a
            goto L_0x018e
        L_0x018a:
            r8 = r2
            goto L_0x01a6
        L_0x018c:
            r22 = r8
        L_0x018e:
            r8 = 0
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1 r21 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r24 = r21
            r25 = r6
            r27 = r9
            r28 = r0
            r29 = r3
            r24.<init>(r25, r27, r28, r29)
            kotlin.jvm.functions.Function1 r21 = (kotlin.jvm.functions.Function1) r21
            r8 = r21
            r1.updateRememberedValue(r8)
        L_0x01a6:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r8, r12, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ba
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ba:
            r13 = r3
            r18 = r9
            r19 = r16
            r15 = r6
        L_0x01c0:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x01c7
            goto L_0x01e2
        L_0x01c7:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2 r20 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2
            r0 = r20
            r1 = r23
            r2 = r17
            r3 = r13
            r5 = r15
            r7 = r18
            r8 = r31
            r10 = r9
            r9 = r32
            r0.<init>(r1, r2, r3, r5, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3628LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: LinearProgressIndicator-2cYBFYY  reason: not valid java name */
    public static final void m3626LinearProgressIndicator2cYBFYY(Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long j2;
        int i2;
        int strokeCap2;
        long trackColor2;
        long color2;
        Modifier modifier3;
        int i3;
        Modifier modifier4;
        long color3;
        long trackColor3;
        int i4;
        int i5;
        int i6 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-476865359);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)109@5065L11,110@5128L16,113@5249L28,117@5531L319,128@5894L319,139@6258L323,150@6626L323,165@7081L660,161@6954L787:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i7 = i & 1;
        if (i7 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i6 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i6 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i5 = 32;
                    $dirty |= i5;
                }
            } else {
                j = color;
            }
            i5 = 16;
            $dirty |= i5;
        } else {
            j = color;
        }
        if ((i6 & 896) == 0) {
            if ((i & 4) == 0) {
                j2 = trackColor;
                if ($composer2.changed(j2)) {
                    i4 = 256;
                    $dirty |= i4;
                }
            } else {
                j2 = trackColor;
            }
            i4 = 128;
            $dirty |= i4;
        } else {
            j2 = trackColor;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty |= 3072;
            i2 = strokeCap;
        } else if ((i6 & 7168) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 2048 : 1024;
        } else {
            i2 = strokeCap;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i6 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                if ((i & 4) != 0) {
                    trackColor3 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    trackColor3 = j2;
                }
                if (i8 != 0) {
                    int i9 = $dirty;
                    modifier3 = modifier4;
                    color2 = color3;
                    trackColor2 = trackColor3;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m3621getLinearStrokeCapKaPHkGw();
                } else {
                    int i10 = $dirty;
                    color2 = color3;
                    trackColor2 = trackColor3;
                    strokeCap2 = i2;
                    modifier3 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                int i11 = $dirty;
                color2 = j;
                trackColor2 = j2;
                strokeCap2 = i2;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476865359, i6, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:107)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, $composer2, 0, 1);
            State firstLineHead = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            State firstLineTail = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            State secondLineHead = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            State secondLineTail = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier r2 = SizeKt.m2324sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] keys$iv = {Color.m4953boximpl(trackColor2), StrokeCap.m5344boximpl(strokeCap2), firstLineHead, firstLineTail, Color.m4953boximpl(color2), secondLineHead, secondLineTail};
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
                InfiniteTransition infiniteTransition2 = infiniteTransition;
                i3 = 0;
                value$iv$iv = new ProgressIndicatorKt$LinearProgressIndicator$3$1(trackColor2, strokeCap2, firstLineHead, firstLineTail, color2, secondLineHead, secondLineTail);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                InfiniteTransition infiniteTransition3 = infiniteTransition;
                Object obj2 = value$iv$iv;
                i3 = 0;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(r2, (Function1) value$iv$iv, $composer2, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            int i12 = $dirty;
            color2 = j;
            trackColor2 = j2;
            strokeCap2 = i2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$4(modifier3, color2, trackColor2, strokeCap2, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    public static final /* synthetic */ void m3629LinearProgressIndicatoreaDK9VM(float progress, Modifier modifier, long color, long trackColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long j2;
        long trackColor2;
        long color2;
        Modifier modifier3;
        long trackColor3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-372717133);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)194@7971L11,195@8034L16,196@8056L140:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            float f = progress;
        } else if ((i4 & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        } else {
            float f2 = progress;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i4 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            j = color;
        }
        if ((i4 & 7168) == 0) {
            if ((i & 8) == 0) {
                j2 = trackColor;
                if ($composer2.changed(j2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                j2 = trackColor;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            j2 = trackColor;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    color3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color3 = j;
                }
                if ((i & 8) != 0) {
                    trackColor3 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -7169;
                } else {
                    trackColor3 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
                color3 = j;
                trackColor3 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-372717133, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:191)");
            }
            m3628LinearProgressIndicator_5eSRE(progress, modifier4, color3, trackColor3, ProgressIndicatorDefaults.INSTANCE.m3621getLinearStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            trackColor2 = trackColor3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            trackColor2 = j2;
            modifier3 = modifier2;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$5(progress, modifier3, color2, trackColor2, $changed, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    public static final /* synthetic */ void m3627LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long trackColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long j2;
        long trackColor2;
        long color2;
        Modifier modifier3;
        long trackColor3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)208@8403L11,209@8466L16,210@8488L126:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = color;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                j2 = trackColor;
                if ($composer2.changed(j2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j2 = trackColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j2 = trackColor;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                if ((i & 4) != 0) {
                    trackColor3 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    trackColor3 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                color3 = j;
                trackColor3 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:206)");
            }
            m3626LinearProgressIndicator2cYBFYY(modifier4, color3, trackColor3, ProgressIndicatorDefaults.INSTANCE.m3621getLinearStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            trackColor2 = trackColor3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            trackColor2 = j2;
            modifier3 = modifier2;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$6(modifier3, color2, trackColor2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g  reason: not valid java name */
    public static final void m3639drawLinearIndicatorqYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        float width = Size.m4782getWidthimpl($this$drawLinearIndicator_u2dqYKTg0g.m5576getSizeNHjbRc());
        float height = Size.m4779getHeightimpl($this$drawLinearIndicator_u2dqYKTg0g.m5576getSizeNHjbRc());
        float f = (float) 2;
        float yOffset = height / f;
        boolean isLtr = $this$drawLinearIndicator_u2dqYKTg0g.getLayoutDirection() == LayoutDirection.Ltr;
        float barStart = (isLtr ? startFraction : 1.0f - endFraction) * width;
        float barEnd = (isLtr ? endFraction : 1.0f - startFraction) * width;
        if (StrokeCap.m5347equalsimpl0(strokeCap, StrokeCap.Companion.m5351getButtKaPHkGw()) || height > width) {
            DrawScope.m5544drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(barStart, yOffset), OffsetKt.Offset(barEnd, yOffset), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            return;
        }
        float strokeCapOffset = strokeWidth / f;
        ClosedFloatingPointRange coerceRange = RangesKt.rangeTo(strokeCapOffset, width - strokeCapOffset);
        float adjustedBarStart = ((Number) RangesKt.coerceIn(Float.valueOf(barStart), coerceRange)).floatValue();
        float adjustedBarEnd = ((Number) RangesKt.coerceIn(Float.valueOf(barEnd), coerceRange)).floatValue();
        if (Math.abs(endFraction - startFraction) > 0.0f) {
            float f2 = adjustedBarStart;
            float f3 = adjustedBarEnd;
            DrawScope.m5544drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(adjustedBarStart, yOffset), OffsetKt.Offset(adjustedBarEnd, yOffset), strokeWidth, strokeCap, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            return;
        }
        float f4 = adjustedBarEnd;
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorTrack-AZGd3zU  reason: not valid java name */
    public static final void m3640drawLinearIndicatorTrackAZGd3zU(DrawScope $this$drawLinearIndicatorTrack_u2dAZGd3zU, long color, float strokeWidth, int strokeCap) {
        m3639drawLinearIndicatorqYKTg0g($this$drawLinearIndicatorTrack_u2dAZGd3zU, 0.0f, 1.0f, color, strokeWidth, strokeCap);
    }

    /* renamed from: CircularProgressIndicator-DUhRLBM  reason: not valid java name */
    public static final void m3622CircularProgressIndicatorDUhRLBM(float progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long color2;
        float strokeWidth2;
        long trackColor2;
        int i2;
        int strokeCap2;
        long trackColor3;
        float strokeWidth3;
        long color3;
        Modifier modifier3;
        int $dirty;
        int strokeCap3;
        long trackColor4;
        float strokeWidth4;
        long trackColor5;
        Modifier modifier4;
        int i3;
        int i4;
        float f = progress;
        int i5 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)289@11687L13,291@11821L18,*295@12015L7,298@12096L365:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changed(f) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if ((i5 & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                if ($composer2.changed(color2)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                color2 = color;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            color2 = color;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if ((i5 & 7168) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if ((57344 & i5) == 0) {
            if ((i & 16) == 0) {
                trackColor2 = trackColor;
                if ($composer2.changed(trackColor2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                trackColor2 = trackColor;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            trackColor2 = trackColor;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = strokeCap;
        } else if ((458752 & i5) == 0) {
            i2 = strokeCap;
            $dirty2 |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = strokeCap;
        }
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if (i7 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m3620getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6);
                }
                if (i8 != 0) {
                    $dirty = $dirty2;
                    strokeCap3 = ProgressIndicatorDefaults.INSTANCE.m3618getCircularDeterminateStrokeCapKaPHkGw();
                    strokeWidth4 = strokeWidth2;
                    trackColor4 = trackColor2;
                    trackColor5 = color2;
                } else {
                    $dirty = $dirty2;
                    strokeWidth4 = strokeWidth2;
                    strokeCap3 = i2;
                    trackColor4 = trackColor2;
                    trackColor5 = color2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & -57345;
                    modifier4 = modifier2;
                    strokeWidth4 = strokeWidth2;
                    strokeCap3 = i2;
                    trackColor4 = trackColor2;
                    trackColor5 = color2;
                } else {
                    $dirty = $dirty2;
                    modifier4 = modifier2;
                    strokeWidth4 = strokeWidth2;
                    strokeCap3 = i2;
                    trackColor4 = trackColor2;
                    trackColor5 = color2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1472321743, i5, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:286)");
            }
            float coercedProgress = RangesKt.coerceIn(f, 0.0f, 1.0f);
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = modifier4;
            CanvasKt.Canvas(SizeKt.m2322size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier5, coercedProgress, (ClosedFloatingPointRange) null, 0, 6, (Object) null), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$1(coercedProgress, trackColor4, new Stroke(((Density) consume).m7535toPx0680j_4(strokeWidth4), 0.0f, strokeCap3, 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), trackColor5), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeCap2 = strokeCap3;
            int i9 = $dirty;
            strokeWidth3 = strokeWidth4;
            trackColor3 = trackColor4;
            modifier3 = modifier5;
            color3 = trackColor5;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty2;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
            trackColor3 = trackColor2;
            strokeCap2 = i2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$2(progress, modifier3, color3, strokeWidth3, trackColor3, strokeCap2, $changed, i));
        }
    }

    /* renamed from: CircularProgressIndicator-LxG7B9w  reason: not valid java name */
    public static final void m3623CircularProgressIndicatorLxG7B9w(Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long trackColor2;
        int i2;
        int strokeCap2;
        long trackColor3;
        long color2;
        float strokeWidth3;
        Modifier modifier3;
        float strokeWidth4;
        Modifier modifier4;
        long color3;
        int i3;
        int i4;
        int i5 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-115871647);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)330@13521L13,332@13655L18,*335@13799L7,339@13898L28,341@14055L278,353@14447L230,364@14794L345,375@15172L354,386@15531L737:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i5 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i5 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i4 = 32;
                    $dirty |= i4;
                }
            } else {
                j = color;
            }
            i4 = 16;
            $dirty |= i4;
        } else {
            j = color;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty |= 384;
            strokeWidth2 = strokeWidth;
        } else if ((i5 & 896) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if ((i5 & 7168) == 0) {
            if ((i & 8) == 0) {
                trackColor2 = trackColor;
                if ($composer2.changed(trackColor2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                trackColor2 = trackColor;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            trackColor2 = trackColor;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            i2 = strokeCap;
        } else if ((57344 & i5) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = strokeCap;
        }
        if ((46811 & $dirty) != 9362 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                if (i7 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m3620getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6);
                }
                if (i8 != 0) {
                    int i9 = $dirty;
                    modifier3 = modifier4;
                    color2 = color3;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m3619getCircularIndeterminateStrokeCapKaPHkGw();
                    strokeWidth4 = strokeWidth2;
                    trackColor3 = trackColor2;
                } else {
                    int i10 = $dirty;
                    modifier3 = modifier4;
                    color2 = color3;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                    strokeWidth4 = strokeWidth2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                int i11 = $dirty;
                modifier3 = modifier2;
                color2 = j;
                trackColor3 = trackColor2;
                strokeCap2 = i2;
                strokeWidth4 = strokeWidth2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115871647, i5, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:328)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Stroke stroke = new Stroke(((Density) consume).m7535toPx0680j_4(strokeWidth4), 0.0f, strokeCap2, 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, $composer2, 0, 1);
            float strokeWidth5 = strokeWidth4;
            CanvasKt.Canvas(SizeKt.m2322size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new ProgressIndicatorKt$CircularProgressIndicator$3(trackColor3, stroke, InfiniteTransitionKt.animateValue(transition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12), 16), InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$endAngle$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8), InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$CircularProgressIndicator$startAngle$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8), InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m1808infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0, 6, (Object) null), (String) null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8), strokeWidth5, color2), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeWidth3 = strokeWidth5;
        } else {
            $composer2.skipToGroupEnd();
            int i12 = $dirty;
            modifier3 = modifier2;
            color2 = j;
            strokeWidth3 = strokeWidth2;
            trackColor3 = trackColor2;
            strokeCap2 = i2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$4(modifier3, color2, strokeWidth3, trackColor3, strokeCap2, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    public static final /* synthetic */ void m3624CircularProgressIndicatorMBs18nI(float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float f;
        float strokeWidth2;
        long color2;
        Modifier modifier3;
        float strokeWidth3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)415@16500L13,422@16713L18,417@16587L219:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            float f2 = progress;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        } else {
            float f3 = progress;
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
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            f = strokeWidth;
        } else if ((i3 & 7168) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = strokeWidth;
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
                    color3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color3 = j;
                }
                strokeWidth3 = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m3620getCircularStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                color3 = j;
                strokeWidth3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402841196, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:412)");
            }
            m3622CircularProgressIndicatorDUhRLBM(progress, modifier4, color3, strokeWidth3, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6), ProgressIndicatorDefaults.INSTANCE.m3618getCircularDeterminateStrokeCapKaPHkGw(), $composer2, 196608 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            strokeWidth2 = strokeWidth3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            modifier3 = modifier2;
            strokeWidth2 = f;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$5(progress, modifier3, color2, strokeWidth2, $changed, i));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    public static final /* synthetic */ void m3625CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float f;
        float strokeWidth2;
        long color2;
        Modifier modifier3;
        float strokeWidth3;
        long color3;
        Modifier modifier4;
        int i2;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)430@17015L13,436@17214L18,432@17102L207:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i3 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            f = strokeWidth;
        } else if ((i3 & 896) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                strokeWidth3 = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m3620getCircularStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier4 = modifier2;
                color3 = j;
                strokeWidth3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(947193756, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:428)");
            }
            m3623CircularProgressIndicatorLxG7B9w(modifier4, color3, strokeWidth3, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6), ProgressIndicatorDefaults.INSTANCE.m3619getCircularIndeterminateStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            strokeWidth2 = strokeWidth3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            modifier3 = modifier2;
            strokeWidth2 = f;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new ProgressIndicatorKt$CircularProgressIndicator$6(modifier3, color2, strokeWidth2, $changed, i));
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m3635drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = (float) 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m4782getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.m5576getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.m5537drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU  reason: not valid java name */
    public static final void m3636drawCircularIndicatorTrackbw27NRU(DrawScope $this$drawCircularIndicatorTrack_u2dbw27NRU, long color, Stroke stroke) {
        m3635drawCircularIndicator42QJj7c($this$drawCircularIndicatorTrack_u2dbw27NRU, 0.0f, 360.0f, color, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m3637drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m3635drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m3638drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        float strokeCapOffset;
        if (StrokeCap.m5347equalsimpl0(stroke.m5656getCapKaPHkGw(), StrokeCap.Companion.m5351getButtKaPHkGw())) {
            strokeCapOffset = 0.0f;
        } else {
            strokeCapOffset = ((strokeWidth / Dp.m7554constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f;
        }
        m3635drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, startAngle + strokeCapOffset, Math.max(sweep, 0.1f), color, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }
}
