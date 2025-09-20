package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001ax\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u001c\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001b0)¢\u0006\u0002\b\u001e¢\u0006\u0002\b+H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a0\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u0001\u00102\u001a\u00020\u001b2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u0002042\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\u0002\b\u001e2\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\u0002\b\u001e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00107\u001a\u0002082\u001c\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001b0)¢\u0006\u0002\b\u001e¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00109\u001aR\u0010:\u001a\u00020\u001b2\u0006\u00107\u001a\u0002082\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001e2\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\u0002\b\u001e2\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d¢\u0006\u0002\b\u001eH\u0003¢\u0006\u0002\u0010;\u001a~\u0010<\u001a\u00020\u001b2\u0011\u0010=\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0002\b\u001e2\u0006\u0010>\u001a\u00020?2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020@2\u0006\u0010%\u001a\u00020&2\u0006\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u00012\u001c\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001b0)¢\u0006\u0002\b\u001e¢\u0006\u0002\b+H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u001a\u0010E\u001a\u00020 *\u00020 2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GH\u0002\u001a\u001c\u0010I\u001a\u00020 *\u00020 2\u0006\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020HH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u000f\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0010\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0016\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0017\u0010\r\"\u0019\u0010\u0018\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0019\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "()F", "RichTooltipMaxWidth", "TextBottomPadding", "TooltipAnchorPadding", "TooltipDuration", "", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "PlainTooltipBox", "", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "tooltipState", "Landroidx/compose/material3/PlainTooltipState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipBoxScope;", "Lkotlin/ExtensionFunctionType;", "PlainTooltipBox-nBX6wN0", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/PlainTooltipState;Landroidx/compose/ui/graphics/Shape;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PlainTooltipImpl", "textColor", "PlainTooltipImpl-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "RichTooltipBox", "text", "Landroidx/compose/material3/RichTooltipState;", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RichTooltipState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RichTooltipImpl", "(Landroidx/compose/material3/RichTooltipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TooltipBox", "tooltipContent", "tooltipPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "Landroidx/compose/material3/TooltipState;", "elevation", "maxWidth", "TooltipBox-XDn_Kpo", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TooltipState;JFFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "", "textVerticalPadding", "subheadExists", "actionExists", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class TooltipKt {
    private static final float ActionLabelBottomPadding = Dp.m5844constructorimpl((float) 8);
    private static final float ActionLabelMinHeight = Dp.m5844constructorimpl((float) 36);
    private static final float HeightFromSubheadToTextFirstLine = Dp.m5844constructorimpl((float) 24);
    private static final float HeightToSubheadFirstLine = Dp.m5844constructorimpl((float) 28);
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipMaxWidth = Dp.m5844constructorimpl((float) 200);
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding = Dp.m5844constructorimpl((float) 16);
    private static final float RichTooltipMaxWidth = Dp.m5844constructorimpl((float) 320);
    private static final float TextBottomPadding = Dp.m5844constructorimpl((float) 16);
    private static final float TooltipAnchorPadding = Dp.m5844constructorimpl((float) 4);
    public static final long TooltipDuration = 1500;
    public static final int TooltipFadeInDuration = 150;
    private static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight = Dp.m5844constructorimpl((float) 24);
    private static final float TooltipMinWidth = Dp.m5844constructorimpl((float) 40);

    /* JADX WARNING: Removed duplicated region for block: B:126:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0106  */
    /* renamed from: PlainTooltipBox-nBX6wN0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2262PlainTooltipBoxnBX6wN0(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.material3.PlainTooltipState r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r28
            r13 = r36
            r14 = r38
            java.lang.String r0 = "tooltip"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -531325137(0xffffffffe0549f2f, float:-6.1284065E19)
            r1 = r37
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(PlainTooltipBox)P(5,3,6,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)97@4379L32,98@4448L26,99@4520L26,100@4590L24,*103@4721L7,104@4794L63,106@4863L450:Tooltip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r15.changedInstance(r12)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r29
            goto L_0x0054
        L_0x003f:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r29
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r29
        L_0x0054:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r30
            goto L_0x0072
        L_0x005d:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r30
            boolean r6 = r15.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r30
        L_0x0072:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008b
            r6 = r39 & 8
            if (r6 != 0) goto L_0x0085
            r6 = r31
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0087
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0085:
            r6 = r31
        L_0x0087:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r1 = r1 | r7
            goto L_0x008d
        L_0x008b:
            r6 = r31
        L_0x008d:
            r7 = 57344(0xe000, float:8.0356E-41)
            r8 = r14 & r7
            if (r8 != 0) goto L_0x00a9
            r8 = r39 & 16
            if (r8 != 0) goto L_0x00a3
            r8 = r32
            boolean r10 = r15.changed((long) r8)
            if (r10 == 0) goto L_0x00a5
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r8 = r32
        L_0x00a5:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r10
            goto L_0x00ab
        L_0x00a9:
            r8 = r32
        L_0x00ab:
            r10 = 458752(0x70000, float:6.42848E-40)
            r11 = r14 & r10
            if (r11 != 0) goto L_0x00c7
            r11 = r39 & 32
            if (r11 != 0) goto L_0x00c0
            r10 = r34
            boolean r16 = r15.changed((long) r10)
            if (r16 == 0) goto L_0x00c2
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r10 = r34
        L_0x00c2:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r16
            goto L_0x00c9
        L_0x00c7:
            r10 = r34
        L_0x00c9:
            r16 = r39 & 64
            if (r16 == 0) goto L_0x00d2
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cf:
            r1 = r1 | r16
            goto L_0x00e4
        L_0x00d2:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00e4
            boolean r16 = r15.changedInstance(r13)
            if (r16 == 0) goto L_0x00e1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00e1:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cf
        L_0x00e4:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r7 = r1 & r16
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r7 != r0) goto L_0x0106
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00f5
            goto L_0x0106
        L_0x00f5:
            r15.skipToGroupEnd()
            r22 = r1
            r25 = r3
            r18 = r5
            r19 = r6
            r20 = r8
            r26 = r10
            goto L_0x0298
        L_0x0106:
            r15.startDefaults()
            r0 = r14 & 1
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            if (r0 == 0) goto L_0x0149
            boolean r0 = r15.getDefaultsInvalid()
            if (r0 == 0) goto L_0x011c
            goto L_0x0149
        L_0x011c:
            r15.skipToGroupEnd()
            r0 = r39 & 8
            if (r0 == 0) goto L_0x0125
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0125:
            r0 = r39 & 16
            if (r0 == 0) goto L_0x012b
            r1 = r1 & r18
        L_0x012b:
            r0 = r39 & 32
            if (r0 == 0) goto L_0x013e
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
            r25 = r29
            r18 = r5
            r19 = r6
            r20 = r8
            r9 = r0
            goto L_0x01cc
        L_0x013e:
            r25 = r29
            r18 = r5
            r19 = r6
            r20 = r8
            r9 = r1
            goto L_0x01cc
        L_0x0149:
            if (r2 == 0) goto L_0x0150
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0152
        L_0x0150:
            r0 = r29
        L_0x0152:
            if (r4 == 0) goto L_0x0191
            r2 = 0
            r4 = 0
            r15.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r7)
            r20 = 0
            r29 = r15
            r21 = 0
            java.lang.Object r3 = r29.rememberedValue()
            r23 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r0
            java.lang.Object r0 = r24.getEmpty()
            if (r3 != r0) goto L_0x0183
            r0 = 0
            androidx.compose.material3.PlainTooltipState r24 = new androidx.compose.material3.PlainTooltipState
            r24.<init>()
            r0 = r24
            r24 = r2
            r2 = r29
            r2.updateRememberedValue(r0)
            goto L_0x0188
        L_0x0183:
            r24 = r2
            r2 = r29
            r0 = r3
        L_0x0188:
            r15.endReplaceableGroup()
            androidx.compose.material3.PlainTooltipState r0 = (androidx.compose.material3.PlainTooltipState) r0
            r5 = r0
            goto L_0x0193
        L_0x0191:
            r25 = r0
        L_0x0193:
            r0 = r39 & 8
            r2 = 6
            if (r0 == 0) goto L_0x01a1
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getPlainTooltipContainerShape(r15, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r0
        L_0x01a1:
            r0 = r39 & 16
            if (r0 == 0) goto L_0x01ae
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            long r3 = r0.getPlainTooltipContainerColor(r15, r2)
            r1 = r1 & r18
            r8 = r3
        L_0x01ae:
            r0 = r39 & 32
            if (r0 == 0) goto L_0x01c5
            androidx.compose.material3.TooltipDefaults r0 = androidx.compose.material3.TooltipDefaults.INSTANCE
            long r2 = r0.getPlainTooltipContentColor(r15, r2)
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
            r10 = r2
            r18 = r5
            r19 = r6
            r20 = r8
            r9 = r0
            goto L_0x01cc
        L_0x01c5:
            r18 = r5
            r19 = r6
            r20 = r8
            r9 = r1
        L_0x01cc:
            r15.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01de
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.PlainTooltipBox (Tooltip.kt:94)"
            r2 = -531325137(0xffffffffe0549f2f, float:-6.1284065E19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r9, r0, r1)
        L_0x01de:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r3, r4)
            java.lang.Object r3 = r15.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r0 = r3
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 0
            float r2 = TooltipAnchorPadding
            int r8 = r0.m5819roundToPx0680j_4(r2)
            r0 = 0
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r7)
            r2 = 0
            r3 = r15
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x0228
            r7 = 0
            r29 = r0
            androidx.compose.material3.PlainTooltipPositionProvider r0 = new androidx.compose.material3.PlainTooltipPositionProvider
            r0.<init>(r8)
            r3.updateRememberedValue(r0)
            goto L_0x022b
        L_0x0228:
            r29 = r0
            r0 = r5
        L_0x022b:
            r15.endReplaceableGroup()
            r16 = r0
            androidx.compose.material3.PlainTooltipPositionProvider r16 = (androidx.compose.material3.PlainTooltipPositionProvider) r16
            r0 = 0
            r1 = 0
            float r2 = (float) r0
            float r7 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r2)
            float r22 = PlainTooltipMaxWidth
            androidx.compose.material3.TooltipKt$PlainTooltipBox$2 r0 = new androidx.compose.material3.TooltipKt$PlainTooltipBox$2
            r0.<init>(r10, r12, r9)
            r1 = -785135750(0xffffffffd133c77a, float:-4.8259113E10)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r2, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r16
            androidx.compose.ui.window.PopupPositionProvider r1 = (androidx.compose.ui.window.PopupPositionProvider) r1
            r4 = r18
            androidx.compose.material3.TooltipState r4 = (androidx.compose.material3.TooltipState) r4
            int r2 = r9 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r3 = 14155830(0xd80036, float:1.9836543E-38)
            r2 = r2 | r3
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r9 << 6
            r5 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r5
            r2 = r2 | r3
            int r3 = r9 << 3
            r5 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r5
            r2 = r2 | r3
            int r3 = r9 << 6
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r5
            r17 = r2 | r3
            r2 = r25
            r3 = r19
            r5 = r20
            r23 = r8
            r8 = r22
            r22 = r9
            r9 = r36
            r26 = r10
            r10 = r15
            r11 = r17
            m2264TooltipBoxXDn_Kpo(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0298
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0298:
            androidx.compose.runtime.ScopeUpdateScope r11 = r15.endRestartGroup()
            if (r11 != 0) goto L_0x029f
            goto L_0x02c0
        L_0x029f:
            androidx.compose.material3.TooltipKt$PlainTooltipBox$3 r16 = new androidx.compose.material3.TooltipKt$PlainTooltipBox$3
            r0 = r16
            r1 = r28
            r2 = r25
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r26
            r9 = r36
            r10 = r38
            r12 = r11
            r11 = r39
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x02c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.m2262PlainTooltipBoxnBX6wN0(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.PlainTooltipState, androidx.compose.ui.graphics.Shape, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RichTooltipBox(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.material3.RichTooltipState r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.graphics.Shape r31, androidx.compose.material3.RichTooltipColors r32, kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r26
            r10 = r33
            r9 = r35
            r8 = r36
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 180959998(0xac93afe, float:1.9377786E-32)
            r1 = r34
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(RichTooltipBox)P(5,3,7,6!1,4)151@6531L31,154@6690L25,155@6765L19,*158@6891L7,159@6964L62,161@7043L130,161@7032L141,166@7179L536:Tooltip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r35
            r2 = r8 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r7.changedInstance(r11)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r8 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r3 = r27
            goto L_0x0056
        L_0x0041:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r27
            boolean r4 = r7.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0050
            r4 = 32
            goto L_0x0052
        L_0x0050:
            r4 = 16
        L_0x0052:
            r1 = r1 | r4
            goto L_0x0056
        L_0x0054:
            r3 = r27
        L_0x0056:
            r4 = r8 & 4
            if (r4 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r28
            goto L_0x0074
        L_0x005f:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0072
            r5 = r28
            boolean r6 = r7.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r6
            goto L_0x0074
        L_0x0072:
            r5 = r28
        L_0x0074:
            r6 = r8 & 8
            if (r6 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r12 = r29
            goto L_0x0092
        L_0x007d:
            r12 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0090
            r12 = r29
            boolean r13 = r7.changedInstance(r12)
            if (r13 == 0) goto L_0x008c
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r13
            goto L_0x0092
        L_0x0090:
            r12 = r29
        L_0x0092:
            r13 = r8 & 16
            r24 = 57344(0xe000, float:8.0356E-41)
            if (r13 == 0) goto L_0x009e
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r30
            goto L_0x00b3
        L_0x009e:
            r14 = r9 & r24
            if (r14 != 0) goto L_0x00b1
            r14 = r30
            boolean r15 = r7.changedInstance(r14)
            if (r15 == 0) goto L_0x00ad
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x00ad:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00af:
            r1 = r1 | r15
            goto L_0x00b3
        L_0x00b1:
            r14 = r30
        L_0x00b3:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00ce
            r15 = r8 & 32
            if (r15 != 0) goto L_0x00c7
            r15 = r31
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cb
        L_0x00c7:
            r15 = r31
        L_0x00c9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00cb:
            r1 = r1 | r16
            goto L_0x00d0
        L_0x00ce:
            r15 = r31
        L_0x00d0:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00ec
            r16 = r8 & 64
            if (r16 != 0) goto L_0x00e5
            r0 = r32
            boolean r16 = r7.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00e7
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e5:
            r0 = r32
        L_0x00e7:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r1 = r1 | r16
            goto L_0x00ee
        L_0x00ec:
            r0 = r32
        L_0x00ee:
            r0 = r8 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f6
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f4:
            r1 = r1 | r0
            goto L_0x0107
        L_0x00f6:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x0107
            boolean r0 = r7.changedInstance(r10)
            if (r0 == 0) goto L_0x0104
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x0104:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f4
        L_0x0107:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0124
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x0117
            goto L_0x0124
        L_0x0117:
            r7.skipToGroupEnd()
            r25 = r27
            r16 = r32
            r17 = r1
            r13 = r12
            r12 = r5
            goto L_0x0323
        L_0x0124:
            r7.startDefaults()
            r0 = r9 & 1
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            java.lang.String r15 = "CC(remember):Composables.kt#9igjgp"
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            if (r0 == 0) goto L_0x0168
            boolean r0 = r7.getDefaultsInvalid()
            if (r0 == 0) goto L_0x013d
            goto L_0x0168
        L_0x013d:
            r7.skipToGroupEnd()
            r0 = r8 & 32
            if (r0 == 0) goto L_0x0146
            r1 = r1 & r16
        L_0x0146:
            r0 = r8 & 64
            if (r0 == 0) goto L_0x015a
            r0 = r1 & r3
            r25 = r27
            r2 = r30
            r3 = r31
            r1 = r32
            r4 = r14
            r6 = r15
            r15 = r0
            r0 = r12
            goto L_0x01fc
        L_0x015a:
            r25 = r27
            r2 = r30
            r3 = r31
            r0 = r12
            r4 = r14
            r6 = r15
            r15 = r1
            r1 = r32
            goto L_0x01fc
        L_0x0168:
            if (r2 == 0) goto L_0x016f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0171
        L_0x016f:
            r0 = r27
        L_0x0171:
            if (r4 == 0) goto L_0x01af
            r2 = 0
            r4 = 0
            r7.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r15)
            r17 = 0
            r27 = r7
            r18 = 0
            java.lang.Object r14 = r27.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r20.getEmpty()
            if (r14 != r3) goto L_0x01a0
            r3 = 0
            androidx.compose.material3.RichTooltipState r20 = new androidx.compose.material3.RichTooltipState
            r20.<init>()
            r3 = r20
            r25 = r0
            r0 = r27
            r0.updateRememberedValue(r3)
            goto L_0x01a5
        L_0x01a0:
            r25 = r0
            r0 = r27
            r3 = r14
        L_0x01a5:
            r7.endReplaceableGroup()
            r0 = r3
            androidx.compose.material3.RichTooltipState r0 = (androidx.compose.material3.RichTooltipState) r0
            r5 = r0
            goto L_0x01b1
        L_0x01af:
            r25 = r0
        L_0x01b1:
            if (r6 == 0) goto L_0x01b5
            r0 = 0
            goto L_0x01b6
        L_0x01b5:
            r0 = r12
        L_0x01b6:
            if (r13 == 0) goto L_0x01ba
            r2 = 0
            goto L_0x01bc
        L_0x01ba:
            r2 = r30
        L_0x01bc:
            r3 = r8 & 32
            if (r3 == 0) goto L_0x01ca
            androidx.compose.material3.TooltipDefaults r3 = androidx.compose.material3.TooltipDefaults.INSTANCE
            r4 = 6
            androidx.compose.ui.graphics.Shape r3 = r3.getRichTooltipContainerShape(r7, r4)
            r1 = r1 & r16
            goto L_0x01cc
        L_0x01ca:
            r3 = r31
        L_0x01cc:
            r4 = r8 & 64
            if (r4 == 0) goto L_0x01f5
            androidx.compose.material3.TooltipDefaults r12 = androidx.compose.material3.TooltipDefaults.INSTANCE
            r22 = 24576(0x6000, float:3.4438E-41)
            r23 = 15
            r13 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6 = r15
            r15 = r16
            r17 = r18
            r19 = r20
            r21 = r7
            androidx.compose.material3.RichTooltipColors r12 = r12.m2261richTooltipColorsro_MJ88(r13, r15, r17, r19, r21, r22, r23)
            r13 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r13
            r15 = r1
            r1 = r12
            goto L_0x01fc
        L_0x01f5:
            r6 = r15
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15 = r1
            r1 = r32
        L_0x01fc:
            r7.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x020e
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.RichTooltipBox (Tooltip.kt:148)"
            r14 = 180959998(0xac93afe, float:1.9377786E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r15, r12, r13)
        L_0x020e:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 0
            r14 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r4, r8)
            java.lang.Object r4 = r7.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            r8 = 0
            float r12 = TooltipAnchorPadding
            int r4 = r4.m5819roundToPx0680j_4(r12)
            r8 = 0
            r12 = r8
            r13 = 0
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r6)
            r6 = 0
            r14 = r7
            r16 = 0
            java.lang.Object r8 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r28 = r6
            java.lang.Object r6 = r18.getEmpty()
            if (r8 != r6) goto L_0x025c
            r6 = 0
            r29 = r6
            androidx.compose.material3.RichTooltipPositionProvider r6 = new androidx.compose.material3.RichTooltipPositionProvider
            r6.<init>(r4)
            r14.updateRememberedValue(r6)
            goto L_0x025d
        L_0x025c:
            r6 = r8
        L_0x025d:
            r7.endReplaceableGroup()
            androidx.compose.material3.RichTooltipPositionProvider r6 = (androidx.compose.material3.RichTooltipPositionProvider) r6
            int r8 = r15 >> 6
            r8 = r8 & 14
            int r12 = r15 >> 9
            r12 = r12 & 112(0x70, float:1.57E-43)
            r8 = r8 | r12
            r12 = 0
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r13)
            boolean r13 = r7.changed((java.lang.Object) r5)
            boolean r14 = r7.changed((java.lang.Object) r2)
            r13 = r13 | r14
            r14 = r7
            r16 = 0
            r34 = r4
            java.lang.Object r4 = r14.rememberedValue()
            r17 = 0
            if (r13 != 0) goto L_0x029e
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r28 = r8
            java.lang.Object r8 = r18.getEmpty()
            if (r4 != r8) goto L_0x029b
            goto L_0x02a0
        L_0x029b:
            r29 = r4
            goto L_0x02af
        L_0x029e:
            r28 = r8
        L_0x02a0:
            r8 = 0
            r29 = r4
            androidx.compose.material3.TooltipKt$RichTooltipBox$2$1 r4 = new androidx.compose.material3.TooltipKt$RichTooltipBox$2$1
            r4.<init>(r5, r2)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r14.updateRememberedValue(r4)
        L_0x02af:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r8 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r4, r7, r8)
            long r17 = r1.m1933getContainerColor0d7_KjU()
            androidx.compose.material3.tokens.RichTooltipTokens r4 = androidx.compose.material3.tokens.RichTooltipTokens.INSTANCE
            float r19 = r4.m2702getContainerElevationD9Ej5fM()
            float r20 = RichTooltipMaxWidth
            androidx.compose.material3.TooltipKt$RichTooltipBox$3 r4 = new androidx.compose.material3.TooltipKt$RichTooltipBox$3
            r27 = r4
            r28 = r1
            r29 = r26
            r30 = r0
            r31 = r2
            r32 = r15
            r27.<init>(r28, r29, r30, r31, r32)
            r8 = 1423372873(0x54d6f249, float:7.385503E12)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r8, r12, r4)
            r12 = r4
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = r6
            androidx.compose.ui.window.PopupPositionProvider r13 = (androidx.compose.ui.window.PopupPositionProvider) r13
            r16 = r5
            androidx.compose.material3.TooltipState r16 = (androidx.compose.material3.TooltipState) r16
            int r4 = r15 << 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r8 = 14155830(0xd80036, float:1.9836543E-38)
            r4 = r4 | r8
            int r8 = r15 >> 6
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r8
            int r8 = r15 << 6
            r8 = r8 & r24
            r4 = r4 | r8
            r8 = 234881024(0xe000000, float:1.5777218E-30)
            int r14 = r15 << 3
            r8 = r8 & r14
            r23 = r4 | r8
            r14 = r25
            r4 = r15
            r15 = r3
            r21 = r33
            r22 = r7
            m2264TooltipBoxXDn_Kpo(r12, r13, r14, r15, r16, r17, r19, r20, r21, r22, r23)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x031b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031b:
            r13 = r0
            r16 = r1
            r14 = r2
            r15 = r3
            r17 = r4
            r12 = r5
        L_0x0323:
            androidx.compose.runtime.ScopeUpdateScope r8 = r7.endRestartGroup()
            if (r8 != 0) goto L_0x032c
            r19 = r7
            goto L_0x034d
        L_0x032c:
            androidx.compose.material3.TooltipKt$RichTooltipBox$4 r18 = new androidx.compose.material3.TooltipKt$RichTooltipBox$4
            r0 = r18
            r1 = r26
            r2 = r25
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r19 = r7
            r7 = r16
            r11 = r8
            r8 = r33
            r9 = r35
            r10 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x034d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.RichTooltipBox(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.RichTooltipState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.RichTooltipColors, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TooltipBox-XDn_Kpo  reason: not valid java name */
    public static final void m2264TooltipBoxXDn_Kpo(Function2<? super Composer, ? super Integer, Unit> tooltipContent, PopupPositionProvider tooltipPositionProvider, Modifier modifier, Shape shape, TooltipState tooltipState, long containerColor, float elevation, float maxWidth, Function3<? super TooltipBoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        PopupPositionProvider popupPositionProvider = tooltipPositionProvider;
        TooltipState tooltipState2 = tooltipState;
        Function3<? super TooltipBoxScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1415647894);
        ComposerKt.sourceInformation($composer2, "C(TooltipBox)P(6,7,4,5,8,0:c#ui.graphics.Color,2:c#ui.unit.Dp,3:c#ui.unit.Dp)199@8111L24,200@8161L49,202@8228L1804,245@10038L1263:Tooltip.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(tooltipContent) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = tooltipContent;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed((Object) popupPositionProvider) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier2 = modifier;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer2.changed((Object) shape) ? 2048 : 1024;
        } else {
            Shape shape2 = shape;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer2.changed((Object) tooltipState2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer2.changed(containerColor) ? 131072 : 65536;
        } else {
            long j = containerColor;
        }
        if ((3670016 & i) == 0) {
            $dirty |= $composer2.changed(elevation) ? 1048576 : 524288;
        } else {
            float f = elevation;
        }
        if ((29360128 & i) == 0) {
            $dirty |= $composer2.changed(maxWidth) ? 8388608 : 4194304;
        } else {
            float f2 = maxWidth;
        }
        if ((234881024 & i) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((191739611 & $dirty2) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415647894, $dirty2, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:188)");
            }
            $composer2.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer2, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer2;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer2;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = it$iv$iv$iv;
                Composer composer = composer$iv;
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext) EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                Object it$iv$iv$iv2 = it$iv$iv$iv;
                Object it$iv$iv$iv3 = $this$cache$iv$iv$iv;
                value$iv$iv$iv = it$iv$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer2.endReplaceableGroup();
            CoroutineScope coroutineScope2 = coroutineScope;
            String longPressLabel = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2051getTooltipLongPressLabeladMyvUU(), $composer2, 6);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj2 = value$iv$iv;
                value$iv$iv = new TooltipKt$TooltipBox$scope$1$1(tooltipState2, coroutineScope2, longPressLabel);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object it$iv$iv = value$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TooltipKt$TooltipBox$scope$1$1 scope = (TooltipKt$TooltipBox$scope$1$1) value$iv$iv;
            String str = longPressLabel;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier3 = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i3 = $changed$iv$iv$iv;
            Density density = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1995827622, "C246@10069L70,275@11286L9:Tooltip.kt#uh7d8r");
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Transition transition = TransitionKt.updateTransition(Boolean.valueOf(tooltipState.isVisible()), "Tooltip transition", $composer3, 48, 0);
            $composer3.startReplaceableGroup(-1995827526);
            ComposerKt.sourceInformation($composer3, "248@10246L41,249@10300L960");
            if (((Boolean) transition.getCurrentState()).booleanValue() || ((Boolean) transition.getTargetState()).booleanValue()) {
                CoroutineScope coroutineScope3 = coroutineScope2;
                Transition transition2 = transition;
                TooltipPopup_androidKt.TooltipPopup(popupPositionProvider, new TooltipKt$TooltipBox$1$1(tooltipState2, coroutineScope2), ComposableLambdaKt.composableLambda($composer3, -442150991, true, new TooltipKt$TooltipBox$1$2(modifier, maxWidth, transition, Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2052getTooltipPaneDescriptionadMyvUU(), $composer3, 6), shape, containerColor, elevation, tooltipContent, $dirty2)), $composer3, (($dirty2 >> 3) & 14) | 384);
            } else {
                CoroutineScope coroutineScope4 = coroutineScope2;
                Transition transition3 = transition;
            }
            $composer3.endReplaceableGroup();
            function3.invoke(scope, $composer3, Integer.valueOf((($dirty2 >> 21) & 112) | 6));
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
            int i5 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i6 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new TooltipKt$TooltipBox$2(tooltipContent, tooltipPositionProvider, modifier, shape, tooltipState, containerColor, elevation, maxWidth, content, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: PlainTooltipImpl-Iv8Zu3U  reason: not valid java name */
    public static final void m2263PlainTooltipImplIv8Zu3U(long textColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        long j = textColor;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(893340370);
        ComposerKt.sourceInformation($composer2, "C(PlainTooltipImpl)P(1:c#ui.graphics.Color)284@11413L337:Tooltip.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(893340370, $dirty, -1, "androidx.compose.material3.PlainTooltipImpl (Tooltip.kt:280)");
            }
            Modifier modifier$iv = PaddingKt.padding(Modifier.Companion, PlainTooltipContentPadding);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            Alignment alignment = contentAlignment$iv;
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
            Modifier modifier = modifier$iv;
            int i2 = $changed$iv$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
            int i3 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            int i4 = $changed$iv$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1000468479, "C285@11514L10,286@11582L162:Tooltip.kt#uh7d8r");
            TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), PlainTooltipTokens.INSTANCE.getSupportingTextFont());
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            TextStyle textStyle2 = textStyle;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(textColor)), TextKt.getLocalTextStyle().provides(textStyle)}, function2, $composer3, ($dirty & 112) | 8);
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
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TooltipKt$PlainTooltipImpl$2(j, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void RichTooltipImpl(RichTooltipColors colors, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> action, Composer $composer, int $changed) {
        Composer $composer2;
        TextStyle supportingTextStyle;
        int $dirty;
        Composer $composer$iv;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = title;
        Function2<? super Composer, ? super Integer, Unit> function23 = action;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-878950288);
        ComposerKt.sourceInformation($composer3, "C(RichTooltipImpl)P(1,2,3)303@12033L10,305@12142L10,307@12246L10,308@12309L1298:Tooltip.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) colors) ? 4 : 2;
        } else {
            RichTooltipColors richTooltipColors = colors;
        }
        if ((i & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function23) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 5851) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-878950288, $dirty3, -1, "androidx.compose.material3.RichTooltipImpl (Tooltip.kt:296)");
            }
            TextStyle actionLabelTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
            TextStyle subheadTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
            TextStyle supportingTextStyle2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
            Modifier modifier$iv = PaddingKt.m540paddingVpY3zN4$default(Modifier.Companion, RichTooltipHorizontalPadding, 0.0f, 2, (Object) null);
            $composer3.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Arrangement.Vertical vertical = verticalArrangement$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume;
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            TextStyle actionLabelTextStyle2 = actionLabelTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer3);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv2 = $composer3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            Density density = density$iv$iv;
            Composer $composer$iv3 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = $changed$iv$iv$iv;
            int i3 = ((6 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer4, 51873561, "C322@12806L317:Tooltip.kt#uh7d8r");
            $composer4.startReplaceableGroup(51873568);
            ComposerKt.sourceInformation($composer4, "*312@12437L350");
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            if (function22 == null) {
                TextStyle textStyle = subheadTextStyle;
                $composer$iv = $composer$iv3;
                supportingTextStyle = supportingTextStyle2;
                $composer2 = $composer3;
                $dirty = $dirty3;
                int i4 = $changed$iv;
                MeasurePolicy measurePolicy = measurePolicy$iv;
            } else {
                Function2 it = title;
                $composer2 = $composer3;
                int i5 = $changed$iv;
                MeasurePolicy measurePolicy2 = measurePolicy$iv;
                Modifier modifier$iv2 = AlignmentLineKt.m395paddingFromBaselineVpY3zN4$default(Modifier.Companion, HeightToSubheadFirstLine, 0.0f, 2, (Object) null);
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv2 = (Density) consume4;
                $composer$iv = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                $dirty = $dirty3;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
                supportingTextStyle = supportingTextStyle2;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(constructor2);
                } else {
                    $composer4.useNode();
                }
                $composer4.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer4);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer4.enableReusing();
                LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                function35.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                Composer $composer$iv4 = $composer4;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i6 = ((6 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
                int i8 = $changed$iv$iv$iv2;
                Composer $composer5 = $composer$iv4;
                ComposerKt.sourceInformationMarkerStart($composer5, -1242326159, "C315@12562L211:Tooltip.kt#uh7d8r");
                TextStyle textStyle2 = subheadTextStyle;
                MeasurePolicy measurePolicy3 = measurePolicy$iv2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(colors.m1935getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(subheadTextStyle)}, (Function2<? super Composer, ? super Integer, Unit>) it, $composer5, 8);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            $composer4.endReplaceableGroup();
            Modifier modifier$iv3 = textVerticalPadding(Modifier.Companion, function22 != null, function23 != null);
            $composer4.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
            Alignment alignment2 = contentAlignment$iv2;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier$iv3);
            Modifier modifier3 = modifier$iv3;
            int $changed$iv$iv$iv3 = (($changed$iv$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = materializerOf3;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                $composer4.useNode();
            }
            $composer4.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2865constructorimpl($composer4);
            int i9 = $changed$iv$iv;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            Density density2 = density$iv$iv3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function37;
            function38.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int i10 = ($changed$iv$iv$iv3 >> 9) & 14;
            Composer $composer$iv5 = $composer4;
            int i11 = $changed$iv$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i12 = ((0 >> 6) & 112) | 6;
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function39 = function38;
            Composer $composer6 = $composer$iv5;
            ComposerKt.sourceInformationMarkerStart($composer6, 471369652, "C325@12918L195:Tooltip.kt#uh7d8r");
            LayoutDirection layoutDirection3 = layoutDirection$iv$iv3;
            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(colors.m1934getContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(supportingTextStyle)}, text, $composer6, ($dirty & 112) | 8);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            $composer4.startReplaceableGroup(75391440);
            ComposerKt.sourceInformation($composer4, "*332@13158L433");
            if (function23 != null) {
                Function2 it2 = action;
                Modifier modifier$iv4 = PaddingKt.m542paddingqDBjuR0$default(SizeKt.m603requiredHeightInVpY3zN4$default(Modifier.Companion, ActionLabelMinHeight, 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, ActionLabelBottomPadding, 7, (Object) null);
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                Alignment alignment3 = contentAlignment$iv3;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv4 = (Density) consume10;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume11 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume12 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv4);
                Modifier modifier4 = modifier$iv4;
                int $changed$iv$iv$iv4 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(constructor3);
                } else {
                    $composer4.useNode();
                }
                $composer4.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m2865constructorimpl($composer4);
                Function0<ComposeUiNode> function03 = constructor3;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer4.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                int i13 = ($changed$iv$iv$iv4 >> 9) & 14;
                Composer $composer$iv6 = $composer4;
                Density density3 = density$iv$iv4;
                ComposerKt.sourceInformationMarkerStart($composer$iv6, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i14 = ((6 >> 6) & 112) | 6;
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                LayoutDirection layoutDirection4 = layoutDirection$iv$iv4;
                ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv4;
                Composer $composer7 = $composer$iv6;
                ComposerKt.sourceInformationMarkerStart($composer7, -1242325360, "C337@13361L216:Tooltip.kt#uh7d8r");
                int i15 = $changed$iv$iv$iv4;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(colors.m1932getActionContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(actionLabelTextStyle2)}, (Function2<? super Composer, ? super Integer, Unit>) it2, $composer7, 8);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            $composer4.endReplaceableGroup();
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
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            int i16 = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TooltipKt$RichTooltipImpl$2(colors, text, title, action, $changed));
        }
    }

    private static final Modifier textVerticalPadding(Modifier $this$textVerticalPadding, boolean subheadExists, boolean actionExists) {
        if (subheadExists || actionExists) {
            return PaddingKt.m542paddingqDBjuR0$default(AlignmentLineKt.m395paddingFromBaselineVpY3zN4$default($this$textVerticalPadding, HeightFromSubheadToTextFirstLine, 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, (Object) null);
        }
        return PaddingKt.m540paddingVpY3zN4$default($this$textVerticalPadding, 0.0f, PlainTooltipVerticalPadding, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Modifier animateTooltip(Modifier $this$animateTooltip, Transition<Boolean> transition) {
        return ComposedModifierKt.composed($this$animateTooltip, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1(transition) : InspectableValueKt.getNoInspectorInfo(), new TooltipKt$animateTooltip$2(transition));
    }

    static {
        float r0 = Dp.m5844constructorimpl((float) 4);
        PlainTooltipVerticalPadding = r0;
        float r1 = Dp.m5844constructorimpl((float) 8);
        PlainTooltipHorizontalPadding = r1;
        PlainTooltipContentPadding = PaddingKt.m532PaddingValuesYgX7TsA(r1, r0);
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }
}
