package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020.X\u0002²\u0006\n\u0010?\u001a\u00020.X\u0002"}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m7554constructorimpl((float) 20);

    public static final BackdropScaffoldState rememberBackdropScaffoldState(BackdropValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> confirmStateChange, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation($composer, "C(rememberBackdropScaffoldState)P(2)171@6447L32,173@6518L538:BackdropScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BackdropValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 4) != 0) {
            confirmStateChange2 = BackdropScaffoldKt$rememberBackdropScaffoldState$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, $changed, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2, confirmStateChange2, snackbarHostState}, BackdropScaffoldState.Companion.Saver(animationSpec2, confirmStateChange2, snackbarHostState), (String) null, new BackdropScaffoldKt$rememberBackdropScaffoldState$3(initialValue, animationSpec2, confirmStateChange2, snackbarHostState), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01a9, code lost:
        if (r9.changed(r66) != false) goto L_0x01b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0597  */
    /* renamed from: BackdropScaffold-BZszfkY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2881BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, androidx.compose.ui.Modifier r57, androidx.compose.material.BackdropScaffoldState r58, boolean r59, float r60, float r61, boolean r62, boolean r63, long r64, long r66, androidx.compose.ui.graphics.Shape r68, float r69, long r70, long r72, long r74, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, androidx.compose.runtime.Composer r77, int r78, int r79, int r80) {
        /*
            r15 = r54
            r13 = r55
            r14 = r56
            r11 = r78
            r12 = r79
            r10 = r80
            java.lang.String r0 = "appBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "backLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "frontLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1397420093(0x534af03d, float:8.7161392E11)
            r1 = r77
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)260@11766L40,266@12093L6,267@12144L41,268@12241L15,270@12387L6,271@12439L42,272@12542L20,*275@12690L7,276@12764L7,288@13147L100,293@13271L3282:BackdropScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r78
            r2 = r79
            r3 = r10 & 1
            r5 = 2
            if (r3 == 0) goto L_0x0035
            r1 = r1 | 6
            goto L_0x0043
        L_0x0035:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x0043
            boolean r3 = r9.changedInstance(r15)
            if (r3 == 0) goto L_0x0041
            r3 = 4
            goto L_0x0042
        L_0x0041:
            r3 = r5
        L_0x0042:
            r1 = r1 | r3
        L_0x0043:
            r3 = r10 & 2
            r6 = 32
            if (r3 == 0) goto L_0x004c
            r1 = r1 | 48
            goto L_0x005b
        L_0x004c:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x005b
            boolean r3 = r9.changedInstance(r13)
            if (r3 == 0) goto L_0x0058
            r3 = r6
            goto L_0x005a
        L_0x0058:
            r3 = 16
        L_0x005a:
            r1 = r1 | r3
        L_0x005b:
            r3 = r10 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0064
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0074
        L_0x0064:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0074
            boolean r3 = r9.changedInstance(r14)
            if (r3 == 0) goto L_0x0071
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0073
        L_0x0071:
            r3 = r16
        L_0x0073:
            r1 = r1 | r3
        L_0x0074:
            r3 = r10 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0081
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r57
            goto L_0x0097
        L_0x0081:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0095
            r4 = r57
            boolean r19 = r9.changed((java.lang.Object) r4)
            if (r19 == 0) goto L_0x0090
            r19 = r17
            goto L_0x0092
        L_0x0090:
            r19 = r18
        L_0x0092:
            r1 = r1 | r19
            goto L_0x0097
        L_0x0095:
            r4 = r57
        L_0x0097:
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r11 & r19
            r20 = 8192(0x2000, float:1.14794E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r19 != 0) goto L_0x00b8
            r19 = r10 & 16
            if (r19 != 0) goto L_0x00b1
            r8 = r58
            boolean r22 = r9.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x00b3
            r22 = r21
            goto L_0x00b5
        L_0x00b1:
            r8 = r58
        L_0x00b3:
            r22 = r20
        L_0x00b5:
            r1 = r1 | r22
            goto L_0x00ba
        L_0x00b8:
            r8 = r58
        L_0x00ba:
            r22 = r10 & 32
            r23 = 131072(0x20000, float:1.83671E-40)
            r24 = 65536(0x10000, float:9.18355E-41)
            if (r22 == 0) goto L_0x00c9
            r25 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r25
            r0 = r59
            goto L_0x00e1
        L_0x00c9:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r11 & r25
            if (r25 != 0) goto L_0x00df
            r0 = r59
            boolean r26 = r9.changed((boolean) r0)
            if (r26 == 0) goto L_0x00da
            r26 = r23
            goto L_0x00dc
        L_0x00da:
            r26 = r24
        L_0x00dc:
            r1 = r1 | r26
            goto L_0x00e1
        L_0x00df:
            r0 = r59
        L_0x00e1:
            r26 = r10 & 64
            if (r26 == 0) goto L_0x00ec
            r27 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r27
            r7 = r60
            goto L_0x0104
        L_0x00ec:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r11 & r27
            if (r27 != 0) goto L_0x0102
            r7 = r60
            boolean r28 = r9.changed((float) r7)
            if (r28 == 0) goto L_0x00fd
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ff
        L_0x00fd:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00ff:
            r1 = r1 | r28
            goto L_0x0104
        L_0x0102:
            r7 = r60
        L_0x0104:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0111
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r28
            r28 = r7
            r7 = r61
            goto L_0x012d
        L_0x0111:
            r28 = 29360128(0x1c00000, float:7.052966E-38)
            r28 = r11 & r28
            if (r28 != 0) goto L_0x0129
            r28 = r7
            r7 = r61
            boolean r29 = r9.changed((float) r7)
            if (r29 == 0) goto L_0x0124
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0126
        L_0x0124:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0126:
            r1 = r1 | r29
            goto L_0x012d
        L_0x0129:
            r28 = r7
            r7 = r61
        L_0x012d:
            r7 = r10 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x013a
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r29
            r29 = r7
            r7 = r62
            goto L_0x0156
        L_0x013a:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r11 & r29
            if (r29 != 0) goto L_0x0152
            r29 = r7
            r7 = r62
            boolean r30 = r9.changed((boolean) r7)
            if (r30 == 0) goto L_0x014d
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x014f
        L_0x014d:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x014f:
            r1 = r1 | r30
            goto L_0x0156
        L_0x0152:
            r29 = r7
            r7 = r62
        L_0x0156:
            r7 = r10 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0165
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r31 = r1
            r30 = r7
            r7 = r63
            goto L_0x0183
        L_0x0165:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r11 & r30
            if (r30 != 0) goto L_0x017d
            r30 = r7
            r7 = r63
            boolean r31 = r9.changed((boolean) r7)
            if (r31 == 0) goto L_0x0178
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x017a
        L_0x0178:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x017a:
            r1 = r1 | r31
            goto L_0x0181
        L_0x017d:
            r30 = r7
            r7 = r63
        L_0x0181:
            r31 = r1
        L_0x0183:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0199
            r1 = r10 & 1024(0x400, float:1.435E-42)
            if (r1 != 0) goto L_0x0195
            r7 = r64
            boolean r1 = r9.changed((long) r7)
            if (r1 == 0) goto L_0x0197
            r5 = 4
            goto L_0x0197
        L_0x0195:
            r7 = r64
        L_0x0197:
            r2 = r2 | r5
            goto L_0x019b
        L_0x0199:
            r7 = r64
        L_0x019b:
            r1 = r12 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x01b2
            r1 = r10 & 2048(0x800, float:2.87E-42)
            if (r1 != 0) goto L_0x01ac
            r7 = r66
            boolean r1 = r9.changed((long) r7)
            if (r1 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ac:
            r7 = r66
        L_0x01ae:
            r6 = 16
        L_0x01b0:
            r2 = r2 | r6
            goto L_0x01b4
        L_0x01b2:
            r7 = r66
        L_0x01b4:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x01cc
            r1 = r10 & 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x01c7
            r6 = r68
            boolean r1 = r9.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x01c9
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x01c9
        L_0x01c7:
            r6 = r68
        L_0x01c9:
            r2 = r2 | r16
            goto L_0x01ce
        L_0x01cc:
            r6 = r68
        L_0x01ce:
            r5 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01d7
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r1 = r69
            goto L_0x01eb
        L_0x01d7:
            r1 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x01e9
            r1 = r69
            boolean r16 = r9.changed((float) r1)
            if (r16 == 0) goto L_0x01e4
            goto L_0x01e6
        L_0x01e4:
            r17 = r18
        L_0x01e6:
            r2 = r2 | r17
            goto L_0x01eb
        L_0x01e9:
            r1 = r69
        L_0x01eb:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x0206
            r0 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r0 != 0) goto L_0x0201
            r7 = r70
            boolean r0 = r9.changed((long) r7)
            if (r0 == 0) goto L_0x0203
            r20 = r21
            goto L_0x0203
        L_0x0201:
            r7 = r70
        L_0x0203:
            r2 = r2 | r20
            goto L_0x0208
        L_0x0206:
            r7 = r70
        L_0x0208:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r12
            r16 = 32768(0x8000, float:4.5918E-41)
            if (r0 != 0) goto L_0x0225
            r0 = r10 & r16
            if (r0 != 0) goto L_0x021f
            r7 = r72
            boolean r0 = r9.changed((long) r7)
            if (r0 == 0) goto L_0x0221
            r0 = r23
            goto L_0x0223
        L_0x021f:
            r7 = r72
        L_0x0221:
            r0 = r24
        L_0x0223:
            r2 = r2 | r0
            goto L_0x0227
        L_0x0225:
            r7 = r72
        L_0x0227:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0241
            r0 = r10 & r24
            if (r0 != 0) goto L_0x023b
            r7 = r74
            boolean r0 = r9.changed((long) r7)
            if (r0 == 0) goto L_0x023d
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023f
        L_0x023b:
            r7 = r74
        L_0x023d:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x023f:
            r2 = r2 | r0
            goto L_0x0243
        L_0x0241:
            r7 = r74
        L_0x0243:
            r0 = r10 & r23
            if (r0 == 0) goto L_0x024e
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r17
            r7 = r76
            goto L_0x0265
        L_0x024e:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x0263
            r7 = r76
            boolean r8 = r9.changedInstance(r7)
            if (r8 == 0) goto L_0x025f
            r8 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0261
        L_0x025f:
            r8 = 4194304(0x400000, float:5.877472E-39)
        L_0x0261:
            r2 = r2 | r8
            goto L_0x0265
        L_0x0263:
            r7 = r76
        L_0x0265:
            r8 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r31 & r2
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r1) goto L_0x02a7
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r8
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r2) goto L_0x02a7
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0280
            goto L_0x02a7
        L_0x0280:
            r9.skipToGroupEnd()
            r28 = r58
            r29 = r59
            r30 = r60
            r32 = r62
            r33 = r63
            r34 = r64
            r39 = r66
            r42 = r69
            r43 = r70
            r45 = r72
            r47 = r74
            r27 = r4
            r41 = r6
            r49 = r7
            r36 = r8
            r37 = r31
            r31 = r61
            goto L_0x05ae
        L_0x02a7:
            r9.startDefaults()
            r1 = r11 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x032c
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x02b9
            goto L_0x032c
        L_0x02b9:
            r9.skipToGroupEnd()
            r0 = r10 & 16
            if (r0 == 0) goto L_0x02c2
            r31 = r31 & r17
        L_0x02c2:
            r0 = r10 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x02c8
            r8 = r8 & -15
        L_0x02c8:
            r0 = r10 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02ce
            r8 = r8 & -113(0xffffffffffffff8f, float:NaN)
        L_0x02ce:
            r0 = r10 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x02d4
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02d4:
            r0 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02da
            r8 = r8 & r17
        L_0x02da:
            r0 = r10 & r16
            if (r0 == 0) goto L_0x02e2
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r8 & r0
        L_0x02e2:
            r0 = r10 & r24
            if (r0 == 0) goto L_0x030b
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r8
            r1 = r59
            r2 = r60
            r3 = r61
            r5 = r62
            r39 = r66
            r42 = r69
            r43 = r70
            r45 = r72
            r47 = r74
            r10 = r0
            r41 = r6
            r49 = r7
            r11 = r31
            r0 = r58
            r6 = r63
            r7 = r64
            goto L_0x0462
        L_0x030b:
            r0 = r58
            r1 = r59
            r2 = r60
            r3 = r61
            r5 = r62
            r39 = r66
            r42 = r69
            r43 = r70
            r45 = r72
            r47 = r74
            r41 = r6
            r49 = r7
            r10 = r8
            r11 = r31
            r6 = r63
            r7 = r64
            goto L_0x0462
        L_0x032c:
            if (r3 == 0) goto L_0x0335
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r18 = r1
            goto L_0x0337
        L_0x0335:
            r18 = r4
        L_0x0337:
            r1 = r10 & 16
            if (r1 == 0) goto L_0x0358
            androidx.compose.material.BackdropValue r1 = androidx.compose.material.BackdropValue.Concealed
            r19 = 6
            r20 = 14
            r2 = 0
            r3 = 0
            r4 = 0
            r21 = r5
            r5 = r9
            r6 = r19
            r19 = r28
            r23 = r29
            r27 = r30
            r7 = r20
            androidx.compose.material.BackdropScaffoldState r1 = rememberBackdropScaffoldState(r1, r2, r3, r4, r5, r6, r7)
            r31 = r31 & r17
            goto L_0x0362
        L_0x0358:
            r21 = r5
            r19 = r28
            r23 = r29
            r27 = r30
            r1 = r58
        L_0x0362:
            if (r22 == 0) goto L_0x0366
            r2 = 1
            goto L_0x0368
        L_0x0366:
            r2 = r59
        L_0x0368:
            if (r26 == 0) goto L_0x0371
            androidx.compose.material.BackdropScaffoldDefaults r3 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r3 = r3.m2880getPeekHeightD9Ej5fM()
            goto L_0x0373
        L_0x0371:
            r3 = r60
        L_0x0373:
            if (r19 == 0) goto L_0x037c
            androidx.compose.material.BackdropScaffoldDefaults r4 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r4 = r4.m2879getHeaderHeightD9Ej5fM()
            goto L_0x037e
        L_0x037c:
            r4 = r61
        L_0x037e:
            if (r23 == 0) goto L_0x0382
            r5 = 1
            goto L_0x0384
        L_0x0382:
            r5 = r62
        L_0x0384:
            if (r27 == 0) goto L_0x0388
            r6 = 1
            goto L_0x038a
        L_0x0388:
            r6 = r63
        L_0x038a:
            r7 = r10 & 1024(0x400, float:1.435E-42)
            r57 = r1
            r1 = 6
            if (r7 == 0) goto L_0x03a4
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r9, r1)
            long r19 = r7.m2951getPrimary0d7_KjU()
            r8 = r8 & -15
            r52 = r19
            r19 = r8
            r7 = r52
            goto L_0x03a8
        L_0x03a4:
            r19 = r8
            r7 = r64
        L_0x03a8:
            r1 = r10 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x03b7
            r1 = r19 & 14
            long r22 = androidx.compose.material.ColorsKt.m2969contentColorForek8zF_U(r7, r9, r1)
            r19 = r19 & -113(0xffffffffffffff8f, float:NaN)
            r1 = r19
            goto L_0x03bb
        L_0x03b7:
            r22 = r66
            r1 = r19
        L_0x03bb:
            r59 = r2
            r2 = r10 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x03cd
            androidx.compose.material.BackdropScaffoldDefaults r2 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r60 = r3
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getFrontLayerShape(r9, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x03d1
        L_0x03cd:
            r60 = r3
            r2 = r68
        L_0x03d1:
            if (r21 == 0) goto L_0x03da
            androidx.compose.material.BackdropScaffoldDefaults r3 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r3 = r3.m2878getFrontLayerElevationD9Ej5fM()
            goto L_0x03dc
        L_0x03da:
            r3 = r69
        L_0x03dc:
            r61 = r2
            r2 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x03f2
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r62 = r3
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r9, r3)
            long r2 = r2.m2955getSurface0d7_KjU()
            r1 = r1 & r17
            goto L_0x03f6
        L_0x03f2:
            r62 = r3
            r2 = r70
        L_0x03f6:
            r16 = r10 & r16
            if (r16 == 0) goto L_0x0409
            int r16 = r1 >> 12
            r77 = r4
            r4 = r16 & 14
            long r16 = androidx.compose.material.ColorsKt.m2969contentColorForek8zF_U(r2, r9, r4)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x040d
        L_0x0409:
            r77 = r4
            r16 = r72
        L_0x040d:
            r4 = r10 & r24
            if (r4 == 0) goto L_0x041f
            androidx.compose.material.BackdropScaffoldDefaults r4 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r19 = r2
            r2 = 6
            long r2 = r4.getFrontLayerScrimColor(r9, r2)
            r4 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x0423
        L_0x041f:
            r19 = r2
            r2 = r74
        L_0x0423:
            if (r0 == 0) goto L_0x0447
            androidx.compose.material.ComposableSingletons$BackdropScaffoldKt r0 = androidx.compose.material.ComposableSingletons$BackdropScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m2975getLambda1$material_release()
            r41 = r61
            r42 = r62
            r49 = r0
            r10 = r1
            r47 = r2
            r45 = r16
            r4 = r18
            r43 = r19
            r39 = r22
            r11 = r31
            r0 = r57
            r1 = r59
            r2 = r60
            r3 = r77
            goto L_0x0462
        L_0x0447:
            r0 = r57
            r41 = r61
            r42 = r62
            r49 = r76
            r10 = r1
            r47 = r2
            r45 = r16
            r4 = r18
            r43 = r19
            r39 = r22
            r11 = r31
            r1 = r59
            r2 = r60
            r3 = r77
        L_0x0462:
            r9.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0473
            java.lang.String r12 = "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)"
            r13 = 1397420093(0x534af03d, float:8.7161392E11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r11, r10, r12)
        L_0x0473:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 0
            r16 = 0
            r57 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r14)
            java.lang.Object r13 = r9.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r12 = r13
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            r13 = 0
            float r12 = r12.m7535toPx0680j_4(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 0
            r16 = 0
            r57 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r14, r15)
            java.lang.Object r14 = r9.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13 = r14
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            r14 = 0
            float r13 = r13.m7535toPx0680j_4(r3)
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1 r14 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
            r57 = r14
            r58 = r5
            r59 = r0
            r60 = r54
            r61 = r55
            r62 = r11
            r57.<init>(r58, r59, r60, r61, r62)
            r15 = 1744778315(0x67ff344b, float:2.4103362E24)
            r69 = r5
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r15, r5, r14)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            java.lang.Float r15 = java.lang.Float.valueOf(r13)
            r16 = 0
            r17 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            boolean r5 = r9.changed((java.lang.Object) r15)
            r58 = r9
            r18 = 0
            r59 = r15
            java.lang.Object r15 = r58.rememberedValue()
            r19 = 0
            if (r5 != 0) goto L_0x050c
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r60 = r5
            java.lang.Object r5 = r20.getEmpty()
            if (r15 != r5) goto L_0x0505
            goto L_0x050e
        L_0x0505:
            r61 = r15
            r5 = r61
            r15 = r58
            goto L_0x0521
        L_0x050c:
            r60 = r5
        L_0x050e:
            r5 = 0
            r61 = r5
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 r5 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
            r5.<init>(r13)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r61 = r15
            r15 = r58
            r15.updateRememberedValue(r5)
        L_0x0521:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r19 = r5
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1 r15 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
            r16 = r15
            r17 = r4
            r18 = r14
            r20 = r13
            r21 = r6
            r22 = r1
            r23 = r0
            r24 = r12
            r25 = r11
            r26 = r41
            r27 = r43
            r29 = r45
            r31 = r42
            r32 = r10
            r33 = r3
            r34 = r2
            r35 = r56
            r36 = r47
            r38 = r49
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r33, r34, r35, r36, r38)
            r70 = r0
            r0 = -1049909631(0xffffffffc16ba681, float:-14.72815)
            r71 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r1, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r10 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r15 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r15
            int r15 = r10 << 6
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r15
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 51
            r57 = r15
            r58 = r16
            r59 = r7
            r61 = r39
            r63 = r17
            r64 = r18
            r65 = r0
            r66 = r9
            r67 = r1
            r68 = r19
            androidx.compose.material.SurfaceKt.m3130SurfaceFjzlyU(r57, r58, r59, r61, r63, r64, r65, r66, r67, r68)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x059a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x059a:
            r32 = r69
            r28 = r70
            r29 = r71
            r30 = r2
            r31 = r3
            r27 = r4
            r33 = r6
            r34 = r7
            r36 = r10
            r37 = r11
        L_0x05ae:
            androidx.compose.runtime.ScopeUpdateScope r15 = r9.endRestartGroup()
            if (r15 != 0) goto L_0x05b7
            r50 = r9
            goto L_0x05f5
        L_0x05b7:
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2 r38 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
            r0 = r38
            r1 = r54
            r2 = r55
            r3 = r56
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r50 = r9
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r39
            r51 = r15
            r15 = r41
            r16 = r42
            r17 = r43
            r19 = r45
            r21 = r47
            r23 = r49
            r24 = r78
            r25 = r79
            r26 = r80
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r19, r21, r23, r24, r25, r26)
            r0 = r38
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r51
            r1.updateScope(r0)
        L_0x05f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m2881BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m2882Scrim3JVO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        Modifier dismissModifier;
        long j = color;
        Function0<Unit> function0 = onDismiss;
        boolean z = visible;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)388@16708L121,401@17118L62,397@17009L171:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, $dirty2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (color != Color.Companion.m4999getUnspecified0d7_KjU()) {
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28);
                $composer2.startReplaceableGroup(1010547004);
                ComposerKt.sourceInformation($composer2, "393@16915L37");
                if (z) {
                    Modifier modifier = Modifier.Companion;
                    Unit unit = Unit.INSTANCE;
                    int i2 = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv = $composer2;
                    Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv;
                        value$iv$iv = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, (Continuation<? super BackdropScaffoldKt$Scrim$dismissModifier$1$1>) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Composer composer = $this$cache$iv$iv;
                        Object obj2 = value$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv);
                } else {
                    dismissModifier = Modifier.Companion;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(dismissModifier);
                Object r3 = Color.m4953boximpl(color);
                int i3 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(r3) | $composer2.changed((Object) alpha$delegate);
                Composer $this$cache$iv$iv2 = $composer2;
                Modifier modifier2 = dismissModifier;
                Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (!invalid$iv$iv2) {
                    Color color2 = r3;
                    if (value$iv$iv2 != Composer.Companion.getEmpty()) {
                        Object obj3 = value$iv$iv2;
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
                    }
                } else {
                    Object key1$iv = r3;
                }
                Object obj4 = value$iv$iv2;
                value$iv$iv2 = new BackdropScaffoldKt$Scrim$1$1(j, alpha$delegate);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty2;
            Composer composer2 = $composer2;
            return;
        }
        int i5 = $dirty2;
        Composer composer3 = $composer2;
        endRestartGroup.updateScope(new BackdropScaffoldKt$Scrim$2(color, onDismiss, visible, $changed));
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x04f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BackLayerTransition(androidx.compose.material.BackdropValue r61, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, androidx.compose.runtime.Composer r64, int r65) {
        /*
            r0 = r61
            r1 = r62
            r2 = r63
            r3 = r65
            r4 = -950970976(0xffffffffc75155a0, float:-53589.625)
            r5 = r64
            androidx.compose.runtime.Composer r13 = r5.startRestartGroup(r4)
            java.lang.String r5 = "C(BackLayerTransition)P(2)421@17840L112,*424@18002L7,429@18176L486:BackdropScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r5 = r65
            r6 = r3 & 14
            if (r6 != 0) goto L_0x0026
            boolean r6 = r13.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x0024
            r6 = 4
            goto L_0x0025
        L_0x0024:
            r6 = 2
        L_0x0025:
            r5 = r5 | r6
        L_0x0026:
            r6 = r3 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0036
            boolean r6 = r13.changedInstance(r1)
            if (r6 == 0) goto L_0x0033
            r6 = 32
            goto L_0x0035
        L_0x0033:
            r6 = 16
        L_0x0035:
            r5 = r5 | r6
        L_0x0036:
            r6 = r3 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0046
            boolean r6 = r13.changedInstance(r2)
            if (r6 == 0) goto L_0x0043
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0045
        L_0x0043:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0045:
            r5 = r5 | r6
        L_0x0046:
            r14 = r5
            r5 = r14 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r5 != r6) goto L_0x005b
            boolean r5 = r13.getSkipping()
            if (r5 != 0) goto L_0x0054
            goto L_0x005b
        L_0x0054:
            r13.skipToGroupEnd()
            r60 = r13
            goto L_0x04f6
        L_0x005b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0067
            r5 = -1
            java.lang.String r6 = "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r5, r6)
        L_0x0067:
            androidx.compose.material.BackdropValue r4 = androidx.compose.material.BackdropValue.Revealed
            r15 = 0
            if (r0 != r4) goto L_0x006e
            r5 = r15
            goto L_0x0071
        L_0x006e:
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = r4
        L_0x0071:
            androidx.compose.animation.core.TweenSpec r4 = new androidx.compose.animation.core.TweenSpec
            r10 = 7
            r11 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11)
            r6 = r4
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6
            r7 = 0
            r8 = 0
            r11 = 48
            r12 = 28
            r10 = r13
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r5, r6, r7, r8, r9, r10, r11, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 0
            r7 = 0
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r9)
            java.lang.Object r8 = r13.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r5 = r8
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            r6 = 0
            float r7 = AnimationSlideOffset
            float r5 = r5.m7535toPx0680j_4(r7)
            float r6 = BackLayerTransition$lambda$7(r4)
            r7 = 1
            float r7 = (float) r7
            float r6 = r6 - r7
            r8 = 1065353216(0x3f800000, float:1.0)
            float r6 = kotlin.ranges.RangesKt.coerceIn((float) r6, (float) r15, (float) r8)
            float r9 = BackLayerTransition$lambda$7(r4)
            float r9 = r7 - r9
            float r8 = kotlin.ranges.RangesKt.coerceIn((float) r9, (float) r15, (float) r8)
            r9 = 0
            r10 = r9
            r11 = 0
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r12)
            java.lang.String r15 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            r39 = r16
            androidx.compose.ui.Modifier r39 = (androidx.compose.ui.Modifier) r39
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r16.getTopStart()
            r9 = 0
            int r16 = r10 >> 3
            r16 = r16 & 14
            int r17 = r10 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r40 = r4
            r4 = r16 | r17
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r9, r13, r4)
            int r16 = r10 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r41 = r16
            r42 = 0
            r43 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r9)
            r44 = r11
            r11 = 0
            int r45 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r13, r11)
            androidx.compose.runtime.CompositionLocalMap r11 = r13.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r39)
            r46 = r12
            int r12 = r41 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | 6
            r47 = r17
            r48 = r16
            r49 = 0
            androidx.compose.runtime.Applier r0 = r13.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x0131
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0131:
            r13.startReusableNode()
            boolean r0 = r13.getInserting()
            if (r0 == 0) goto L_0x0140
            r0 = r48
            r13.createNode(r0)
            goto L_0x0145
        L_0x0140:
            r0 = r48
            r13.useNode()
        L_0x0145:
            r48 = r0
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r4, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r0, r11, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r17 = 0
            r18 = r0
            r19 = 0
            boolean r20 = r18.getInserting()
            if (r20 != 0) goto L_0x0187
            r50 = r4
            java.lang.Object r4 = r18.rememberedValue()
            r51 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r45)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r11)
            if (r4 != 0) goto L_0x0184
            goto L_0x018b
        L_0x0184:
            r11 = r18
            goto L_0x019b
        L_0x0187:
            r50 = r4
            r51 = r11
        L_0x018b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r45)
            r11 = r18
            r11.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r45)
            r0.apply(r4, r3)
        L_0x019b:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r3 = r12 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r47
            r4.invoke(r0, r13, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            int r3 = r12 >> 9
            r3 = r3 & 14
            r11 = r13
            r47 = 0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r52 = r3
            java.lang.String r3 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r16 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r17 = r10 >> 6
            r17 = r17 & 112(0x70, float:1.57E-43)
            r53 = r17 | 6
            androidx.compose.foundation.layout.BoxScope r16 = (androidx.compose.foundation.layout.BoxScope) r16
            r54 = r16
            r55 = r11
            r56 = 0
            r0 = -1538629162(0xffffffffa44a61d6, float:-4.3884638E-17)
            r57 = r4
            java.lang.String r4 = "C430@18190L226,438@18425L231:BackdropScaffold.kt#jmzs0o"
            r58 = r10
            r10 = r55
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r4)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.ZIndexModifierKt.zIndex(r0, r6)
            float r0 = r7 - r6
            float r21 = r0 * r5
            r37 = 131051(0x1ffeb, float:1.83642E-40)
            r38 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r19 = r6
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m5121graphicsLayerAp8cVGQ$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r34, r36, r37, r38)
            r4 = 0
            r16 = r4
            r4 = 0
            r17 = r4
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r15)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r55 = r6
            r6 = 0
            int r18 = r16 >> 3
            r18 = r18 & 14
            int r19 = r16 >> 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r59 = r12
            r12 = r18 | r19
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r6, r10, r12)
            int r18 = r16 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r19 = 0
            r20 = r4
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            r4 = 0
            int r21 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r4)
            androidx.compose.runtime.CompositionLocalMap r4 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r22 = r22.getConstructor()
            kotlin.jvm.functions.Function3 r23 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r24 = r0
            int r0 = r18 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r25 = r22
            r22 = r23
            r23 = 0
            r26 = r6
            androidx.compose.runtime.Applier r6 = r10.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x028a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x028a:
            r10.startReusableNode()
            boolean r6 = r10.getInserting()
            if (r6 == 0) goto L_0x0299
            r6 = r25
            r10.createNode(r6)
            goto L_0x029e
        L_0x0299:
            r6 = r25
            r10.useNode()
        L_0x029e:
            r25 = r6
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m4575constructorimpl(r10)
            r27 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r28 = androidx.compose.ui.node.ComposeUiNode.Companion
            r60 = r13
            kotlin.jvm.functions.Function2 r13 = r28.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r12, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r4, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r28 = 0
            r29 = r6
            r30 = 0
            boolean r31 = r29.getInserting()
            if (r31 != 0) goto L_0x02e2
            r31 = r4
            java.lang.Object r4 = r29.rememberedValue()
            r32 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r21)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r12)
            if (r4 != 0) goto L_0x02df
            goto L_0x02e6
        L_0x02df:
            r12 = r29
            goto L_0x02f6
        L_0x02e2:
            r31 = r4
            r32 = r12
        L_0x02e6:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r21)
            r12 = r29
            r12.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r21)
            r6.apply(r4, r13)
        L_0x02f6:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r4)
            int r6 = r0 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r12 = r22
            r12.invoke(r4, r10, r6)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r4)
            int r4 = r0 >> 9
            r4 = r4 & 14
            r6 = r10
            r13 = 0
            r22 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r27 = r16 >> 6
            r27 = r27 & 112(0x70, float:1.57E-43)
            r27 = r27 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r28 = r6
            r29 = 0
            r30 = r0
            r0 = -481855289(0xffffffffe34778c7, float:-3.679605E21)
            r33 = r4
            java.lang.String r4 = "C436@18398L8:BackdropScaffold.kt#jmzs0o"
            r34 = r12
            r12 = r28
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r4)
            int r0 = r14 >> 3
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.invoke(r12, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.ZIndexModifierKt.zIndex(r0, r8)
            float r7 = r7 - r8
            float r0 = -r5
            float r21 = r7 * r0
            r37 = 131051(0x1ffeb, float:1.83642E-40)
            r38 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r19 = r8
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.m5121graphicsLayerAp8cVGQ$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r34, r36, r37, r38)
            r4 = 0
            r6 = r4
            r4 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r15)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            r12 = 0
            int r13 = r6 >> 3
            r13 = r13 & 14
            int r15 = r6 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r13 = r13 | r15
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r12, r10, r13)
            int r15 = r6 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r16 = 0
            r64 = r4
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            r4 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r4)
            androidx.compose.runtime.CompositionLocalMap r9 = r10.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r18 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            r19 = r0
            int r0 = r15 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r20 = r17
            r17 = r18
            r18 = 0
            r21 = r5
            androidx.compose.runtime.Applier r5 = r10.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x03fc
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03fc:
            r10.startReusableNode()
            boolean r5 = r10.getInserting()
            if (r5 == 0) goto L_0x040b
            r5 = r20
            r10.createNode(r5)
            goto L_0x0410
        L_0x040b:
            r5 = r20
            r10.useNode()
        L_0x0410:
            r20 = r5
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m4575constructorimpl(r10)
            r22 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r24 = r7
            kotlin.jvm.functions.Function2 r7 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r13, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r23 = 0
            r25 = r5
            r26 = 0
            boolean r27 = r25.getInserting()
            if (r27 != 0) goto L_0x0454
            r27 = r8
            java.lang.Object r8 = r25.rememberedValue()
            r28 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x0451
            goto L_0x0458
        L_0x0451:
            r9 = r25
            goto L_0x0468
        L_0x0454:
            r27 = r8
            r28 = r9
        L_0x0458:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r9 = r25
            r9.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r5.apply(r8, r7)
        L_0x0468:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r5)
            int r7 = r0 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8 = r17
            r8.invoke(r5, r10, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r5)
            int r5 = r0 >> 9
            r5 = r5 & 14
            r7 = r10
            r9 = 0
            r17 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r6 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r22 = r7
            r23 = 0
            r25 = r0
            r0 = -481855050(0xffffffffe34779b6, float:-3.6796723E21)
            r26 = r3
            java.lang.String r3 = "C444@18637L9:BackdropScaffold.kt#jmzs0o"
            r29 = r4
            r4 = r22
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r3)
            int r0 = r14 >> 6
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.invoke(r4, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r60.endReplaceableGroup()
            r60.endNode()
            r60.endReplaceableGroup()
            r60.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04f6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04f6:
            androidx.compose.runtime.ScopeUpdateScope r0 = r60.endRestartGroup()
            if (r0 != 0) goto L_0x0501
            r4 = r61
            r5 = r65
            goto L_0x050f
        L_0x0501:
            androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2 r3 = new androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2
            r4 = r61
            r5 = r65
            r3.<init>(r4, r1, r2, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0.updateScope(r3)
        L_0x050f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition(androidx.compose.material.BackdropValue, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    private static final float BackLayerTransition$lambda$7(State<Float> $animationProgress$delegate) {
        return ((Number) $animationProgress$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void BackdropStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> backLayer, Function1<? super Constraints, Constraints> calculateBackLayerConstraints, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> frontLayer, Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)457@18967L890,457@18940L917:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(backLayer) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(calculateBackLayerConstraints) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(frontLayer) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            int i = (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) backLayer) | $composer2.changed((Object) calculateBackLayerConstraints) | $composer2.changed((Object) frontLayer);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function2) new BackdropScaffoldKt$BackdropStack$1$1(backLayer, calculateBackLayerConstraints, frontLayer, $dirty);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv$iv, $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$BackdropStack$2(modifier, backLayer, calculateBackLayerConstraints, frontLayer, $changed));
        }
    }
}
