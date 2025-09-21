package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0002\u001a3\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010*\u001a\u00020\u0015H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00150\fH\u0007\u001a\u0014\u00102\u001a\u0002032\n\u0010$\u001a\u0006\u0012\u0002\b\u000304H\u0002\u001a\u0001\u00105\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u0002062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001aA\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00152\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010(\u001a\u00020\u001aH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a.\u0010?\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u00020@2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0015H\u0002\u001a \u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u0002H\u0002\u001a+\u0010H\u001a\u00020\u00132\u0006\u0010.\u001a\u00020#2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010I\u001a+\u0010J\u001a\u0002062\u0006\u0010.\u001a\u00020K2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010L\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020\u0002X\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerAnchorChangeCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "Landroidx/compose/material/BottomDrawerValue;", "state", "scope", "Lkotlinx/coroutines/CoroutineScope;", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BottomDrawerState", "initialValue", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateAnchors", "", "fullHeight", "drawerHeight", "isLandscape", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
public final class DrawerKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float BottomDrawerOpenFraction = 0.5f;
    /* access modifiers changed from: private */
    public static final float DrawerPositionalThreshold = Dp.m5844constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final float DrawerVelocityThreshold = Dp.m5844constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float EndDrawerPadding = Dp.m5844constructorimpl((float) 56);

    public static /* synthetic */ BottomDrawerState BottomDrawerState$default(BottomDrawerValue bottomDrawerValue, Density density, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = DrawerKt$BottomDrawerState$1.INSTANCE;
        }
        return BottomDrawerState(bottomDrawerValue, density, function1);
    }

    public static final BottomDrawerState BottomDrawerState(BottomDrawerValue initialValue, Density density, Function1<? super BottomDrawerValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        BottomDrawerState it = new BottomDrawerState(initialValue, confirmStateChange);
        it.setDensity$material_release(density);
        return it;
    }

    public static final DrawerState rememberDrawerState(DrawerValue initialValue, Function1<? super DrawerValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1435874229);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)455@15934L61,455@15870L125:Drawer.kt#jmzs0o");
        Function1<? super DrawerValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 2) != 0) {
            confirmStateChange2 = DrawerKt$rememberDrawerState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, $changed, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:451)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(confirmStateChange2);
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) initialValue) | $composer.changed((Object) confirmStateChange2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new DrawerKt$rememberDrawerState$2$1(initialValue, confirmStateChange2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return drawerState;
    }

    public static final BottomDrawerState rememberBottomDrawerState(BottomDrawerValue initialValue, Function1<? super BottomDrawerValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-598115156);
        ComposerKt.sourceInformation($composer, "C(rememberBottomDrawerState)P(1)472@16436L7,473@16543L76,473@16455L164:Drawer.kt#jmzs0o");
        Function1<? super BottomDrawerValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 2) != 0) {
            confirmStateChange2 = DrawerKt$rememberBottomDrawerState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, $changed, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:468)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(density, confirmStateChange2);
        int i2 = ($changed & 14) | (($changed << 3) & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) initialValue) | $composer.changed((Object) density) | $composer.changed((Object) confirmStateChange2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new DrawerKt$rememberBottomDrawerState$2$1(initialValue, density, confirmStateChange2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.rememberSaveable(objArr, Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0328  */
    /* renamed from: ModalDrawer-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1284ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.material.DrawerState r34, boolean r35, androidx.compose.ui.graphics.Shape r36, float r37, long r38, long r40, long r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r15 = r32
            r14 = r44
            r12 = r46
            r11 = r47
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1305806945(0x4dd50861, float:4.46762016E8)
            r1 = r45
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)512@18429L39,514@18546L6,516@18661L6,517@18709L38,518@18788L10,521@18856L24,522@18885L3435:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r46
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 6
            goto L_0x0037
        L_0x0029:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0037
            boolean r2 = r9.changedInstance(r15)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0040
            r1 = r1 | 48
            r4 = r33
            goto L_0x0055
        L_0x0040:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0053
            r4 = r33
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004f
            r5 = 32
            goto L_0x0051
        L_0x004f:
            r5 = 16
        L_0x0051:
            r1 = r1 | r5
            goto L_0x0055
        L_0x0053:
            r4 = r33
        L_0x0055:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006e
            r5 = r11 & 4
            if (r5 != 0) goto L_0x0068
            r5 = r34
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006a
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x0068:
            r5 = r34
        L_0x006a:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r1 = r1 | r6
            goto L_0x0070
        L_0x006e:
            r5 = r34
        L_0x0070:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0079
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r35
            goto L_0x008e
        L_0x0079:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008c
            r7 = r35
            boolean r8 = r9.changed((boolean) r7)
            if (r8 == 0) goto L_0x0088
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0088:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r8
            goto L_0x008e
        L_0x008c:
            r7 = r35
        L_0x008e:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00a9
            r8 = r11 & 16
            if (r8 != 0) goto L_0x00a3
            r8 = r36
            boolean r10 = r9.changed((java.lang.Object) r8)
            if (r10 == 0) goto L_0x00a5
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r8 = r36
        L_0x00a5:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r10
            goto L_0x00ab
        L_0x00a9:
            r8 = r36
        L_0x00ab:
            r10 = r11 & 32
            if (r10 == 0) goto L_0x00b5
            r13 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r13
            r13 = r37
            goto L_0x00cc
        L_0x00b5:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r12
            if (r13 != 0) goto L_0x00ca
            r13 = r37
            boolean r16 = r9.changed((float) r13)
            if (r16 == 0) goto L_0x00c5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r1 = r1 | r16
            goto L_0x00cc
        L_0x00ca:
            r13 = r37
        L_0x00cc:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00e8
            r16 = r11 & 64
            if (r16 != 0) goto L_0x00e1
            r3 = r38
            boolean r16 = r9.changed((long) r3)
            if (r16 == 0) goto L_0x00e3
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e1:
            r3 = r38
        L_0x00e3:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r1 = r1 | r16
            goto L_0x00ea
        L_0x00e8:
            r3 = r38
        L_0x00ea:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x0105
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00ff
            r3 = r40
            boolean r0 = r9.changed((long) r3)
            if (r0 == 0) goto L_0x0101
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0103
        L_0x00ff:
            r3 = r40
        L_0x0101:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x0103:
            r1 = r1 | r0
            goto L_0x0107
        L_0x0105:
            r3 = r40
        L_0x0107:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0121
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x011b
            r3 = r42
            boolean r0 = r9.changed((long) r3)
            if (r0 == 0) goto L_0x011d
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011b:
            r3 = r42
        L_0x011d:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r1 = r1 | r0
            goto L_0x0123
        L_0x0121:
            r3 = r42
        L_0x0123:
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x012b
            r0 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0129:
            r1 = r1 | r0
            goto L_0x013c
        L_0x012b:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r12
            if (r0 != 0) goto L_0x013c
            boolean r0 = r9.changedInstance(r14)
            if (r0 == 0) goto L_0x0139
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0129
        L_0x0139:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0129
        L_0x013c:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x0164
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x014c
            goto L_0x0164
        L_0x014c:
            r9.skipToGroupEnd()
            r30 = r33
            r21 = r38
            r23 = r40
            r25 = r42
            r27 = r1
            r17 = r5
            r18 = r7
            r19 = r8
            r14 = r9
            r20 = r13
            goto L_0x031f
        L_0x0164:
            r9.startDefaults()
            r0 = r12 & 1
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = 0
            if (r0 == 0) goto L_0x01c4
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x017c
            goto L_0x01c4
        L_0x017c:
            r9.skipToGroupEnd()
            r0 = r11 & 4
            if (r0 == 0) goto L_0x0185
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0185:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x018b
            r1 = r1 & r18
        L_0x018b:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0191
            r1 = r1 & r17
        L_0x0191:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0196
            r1 = r1 & r4
        L_0x0196:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b1
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
            r10 = r33
            r21 = r38
            r23 = r40
            r25 = r42
            r17 = r5
            r18 = r7
            r19 = r8
            r20 = r13
            r7 = r0
            goto L_0x025b
        L_0x01b1:
            r10 = r33
            r21 = r38
            r23 = r40
            r25 = r42
            r17 = r5
            r18 = r7
            r19 = r8
            r20 = r13
            r7 = r1
            goto L_0x025b
        L_0x01c4:
            if (r2 == 0) goto L_0x01cb
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01cd
        L_0x01cb:
            r0 = r33
        L_0x01cd:
            r2 = r11 & 4
            r4 = 6
            if (r2 == 0) goto L_0x01de
            androidx.compose.material.DrawerValue r2 = androidx.compose.material.DrawerValue.Closed
            r33 = r0
            r0 = 2
            androidx.compose.material.DrawerState r0 = rememberDrawerState(r2, r3, r9, r4, r0)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01e1
        L_0x01de:
            r33 = r0
            r0 = r5
        L_0x01e1:
            if (r6 == 0) goto L_0x01e5
            r2 = 1
            goto L_0x01e6
        L_0x01e5:
            r2 = r7
        L_0x01e6:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x01f9
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r5 = r5.getShapes(r9, r4)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getLarge()
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            r1 = r1 & r18
            goto L_0x01fa
        L_0x01f9:
            r5 = r8
        L_0x01fa:
            if (r10 == 0) goto L_0x0203
            androidx.compose.material.DrawerDefaults r6 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r6 = r6.m1281getElevationD9Ej5fM()
            goto L_0x0204
        L_0x0203:
            r6 = r13
        L_0x0204:
            r7 = r11 & 64
            if (r7 == 0) goto L_0x0215
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r9, r4)
            long r7 = r7.m1245getSurface0d7_KjU()
            r1 = r1 & r17
            goto L_0x0217
        L_0x0215:
            r7 = r38
        L_0x0217:
            r10 = r11 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0228
            int r10 = r1 >> 18
            r10 = r10 & 14
            long r17 = androidx.compose.material.ColorsKt.m1259contentColorForek8zF_U(r7, r9, r10)
            r10 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r10
            goto L_0x022a
        L_0x0228:
            r17 = r40
        L_0x022a:
            r10 = r11 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x024a
            androidx.compose.material.DrawerDefaults r10 = androidx.compose.material.DrawerDefaults.INSTANCE
            long r20 = r10.getScrimColor(r9, r4)
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r4
            r10 = r33
            r19 = r5
            r23 = r17
            r25 = r20
            r17 = r0
            r18 = r2
            r20 = r6
            r21 = r7
            r7 = r1
            goto L_0x025b
        L_0x024a:
            r10 = r33
            r25 = r42
            r19 = r5
            r20 = r6
            r21 = r7
            r23 = r17
            r17 = r0
            r7 = r1
            r18 = r2
        L_0x025b:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x026d
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.ModalDrawer (Drawer.kt:509)"
            r2 = 1305806945(0x4dd50861, float:4.46762016E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x026d:
            r0 = 0
            r1 = r0
            r2 = 0
            r4 = 773894976(0x2e20b340, float:3.6538994E-11)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            r4 = r9
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r6)
            r6 = 0
            r8 = r9
            r13 = 0
            java.lang.Object r3 = r8.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            r33 = r0
            java.lang.Object r0 = r27.getEmpty()
            if (r3 != r0) goto L_0x02bb
            r0 = 0
            r27 = 0
            kotlin.coroutines.EmptyCoroutineContext r27 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r34 = r0
            r0 = r27
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r4)
            r35 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r8.updateRememberedValue(r0)
            goto L_0x02be
        L_0x02bb:
            r35 = r1
            r0 = r3
        L_0x02be:
            r9.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r13 = r0.getCoroutineScope()
            r9.endReplaceableGroup()
            r0 = 0
            r8 = 1
            r1 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r10, r0, r8, r1)
            androidx.compose.material.DrawerKt$ModalDrawer$1 r6 = new androidx.compose.material.DrawerKt$ModalDrawer$1
            r0 = r6
            r1 = r17
            r2 = r18
            r3 = r7
            r4 = r25
            r15 = r6
            r6 = r19
            r27 = r7
            r7 = r21
            r29 = r9
            r30 = r10
            r9 = r23
            r11 = r20
            r12 = r44
            r14 = r32
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14)
            r0 = 816674999(0x30ad78b7, float:1.2621716E-9)
            r14 = r29
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r1, r15)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 6
            r3 = 0
            r4 = 0
            r33 = r16
            r34 = r3
            r35 = r4
            r36 = r0
            r37 = r14
            r38 = r1
            r39 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r33, r34, r35, r36, r37, r38, r39)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x031f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031f:
            androidx.compose.runtime.ScopeUpdateScope r15 = r14.endRestartGroup()
            if (r15 != 0) goto L_0x0328
            r28 = r14
            goto L_0x0354
        L_0x0328:
            androidx.compose.material.DrawerKt$ModalDrawer$2 r16 = new androidx.compose.material.DrawerKt$ModalDrawer$2
            r0 = r16
            r1 = r32
            r2 = r30
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r9 = r23
            r11 = r25
            r13 = r44
            r28 = r14
            r14 = r46
            r31 = r15
            r15 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r31
            r1.updateScope(r0)
        L_0x0354:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1284ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x034c  */
    /* renamed from: BottomDrawer-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1282BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.material.BottomDrawerState r34, boolean r35, androidx.compose.ui.graphics.Shape r36, float r37, long r38, long r40, long r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r15 = r32
            r14 = r44
            r13 = r46
            r11 = r47
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 625649286(0x254aa686, float:1.7577127E-16)
            r1 = r45
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)643@24199L33,645@24310L6,647@24425L6,648@24473L38,649@24552L10,659@24864L24,661@24894L3701:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r46
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0029
            r1 = r1 | 6
            goto L_0x0037
        L_0x0029:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0037
            boolean r2 = r12.changedInstance(r15)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r1 = r1 | r2
        L_0x0037:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0040
            r1 = r1 | 48
            r5 = r33
            goto L_0x0055
        L_0x0040:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0053
            r5 = r33
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r1 = r1 | r6
            goto L_0x0055
        L_0x0053:
            r5 = r33
        L_0x0055:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x005b
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x005b:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x0064
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r8 = r35
            goto L_0x0079
        L_0x0064:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0077
            r8 = r35
            boolean r9 = r12.changed((boolean) r8)
            if (r9 == 0) goto L_0x0073
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0075
        L_0x0073:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0075:
            r1 = r1 | r9
            goto L_0x0079
        L_0x0077:
            r8 = r35
        L_0x0079:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x0094
            r9 = r11 & 16
            if (r9 != 0) goto L_0x008e
            r9 = r36
            boolean r10 = r12.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0090
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r9 = r36
        L_0x0090:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r1 = r1 | r10
            goto L_0x0096
        L_0x0094:
            r9 = r36
        L_0x0096:
            r10 = r11 & 32
            if (r10 == 0) goto L_0x00a1
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r0 = r37
            goto L_0x00b9
        L_0x00a1:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00b7
            r0 = r37
            boolean r17 = r12.changed((float) r0)
            if (r17 == 0) goto L_0x00b2
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r17
            goto L_0x00b9
        L_0x00b7:
            r0 = r37
        L_0x00b9:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00d5
            r17 = r11 & 64
            if (r17 != 0) goto L_0x00ce
            r4 = r38
            boolean r17 = r12.changed((long) r4)
            if (r17 == 0) goto L_0x00d0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00ce:
            r4 = r38
        L_0x00d0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r1 = r1 | r17
            goto L_0x00d7
        L_0x00d5:
            r4 = r38
        L_0x00d7:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00ec
            r3 = r40
            boolean r5 = r12.changed((long) r3)
            if (r5 == 0) goto L_0x00ee
            r5 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ec:
            r3 = r40
        L_0x00ee:
            r5 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r1 = r1 | r5
            goto L_0x00f4
        L_0x00f2:
            r3 = r40
        L_0x00f4:
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x010e
            r5 = r11 & 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x0108
            r3 = r42
            boolean r5 = r12.changed((long) r3)
            if (r5 == 0) goto L_0x010a
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010c
        L_0x0108:
            r3 = r42
        L_0x010a:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010c:
            r1 = r1 | r5
            goto L_0x0110
        L_0x010e:
            r3 = r42
        L_0x0110:
            r5 = r11 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0118
            r5 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0116:
            r1 = r1 | r5
            goto L_0x0129
        L_0x0118:
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x0129
            boolean r5 = r12.changedInstance(r14)
            if (r5 == 0) goto L_0x0126
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0116
        L_0x0126:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0116
        L_0x0129:
            r5 = 4
            if (r6 != r5) goto L_0x0154
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r1
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r0) goto L_0x0154
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x013c
            goto L_0x0154
        L_0x013c:
            r12.skipToGroupEnd()
            r29 = r33
            r28 = r34
            r19 = r37
            r20 = r38
            r22 = r40
            r26 = r1
            r24 = r3
            r17 = r8
            r18 = r9
            r14 = r12
            goto L_0x0343
        L_0x0154:
            r12.startDefaults()
            r0 = r13 & 1
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = 0
            if (r0 == 0) goto L_0x01b3
            boolean r0 = r12.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016c
            goto L_0x01b3
        L_0x016c:
            r12.skipToGroupEnd()
            if (r6 == 0) goto L_0x0173
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0173:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0179
            r1 = r1 & r19
        L_0x0179:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x017f
            r1 = r1 & r18
        L_0x017f:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0185
            r1 = r1 & r17
        L_0x0185:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01a0
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
            r10 = r34
            r19 = r37
            r20 = r38
            r22 = r40
            r24 = r3
            r17 = r8
            r18 = r9
            r9 = r33
            r8 = r0
            goto L_0x0246
        L_0x01a0:
            r10 = r34
            r19 = r37
            r20 = r38
            r22 = r40
            r24 = r3
            r17 = r8
            r18 = r9
            r9 = r33
            r8 = r1
            goto L_0x0246
        L_0x01b3:
            if (r2 == 0) goto L_0x01ba
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01bc
        L_0x01ba:
            r0 = r33
        L_0x01bc:
            r2 = 6
            if (r6 == 0) goto L_0x01cb
            androidx.compose.material.BottomDrawerValue r6 = androidx.compose.material.BottomDrawerValue.Closed
            r33 = r0
            r0 = 2
            androidx.compose.material.BottomDrawerState r0 = rememberBottomDrawerState(r6, r5, r12, r2, r0)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01cf
        L_0x01cb:
            r33 = r0
            r0 = r34
        L_0x01cf:
            if (r7 == 0) goto L_0x01d3
            r6 = 1
            goto L_0x01d4
        L_0x01d3:
            r6 = r8
        L_0x01d4:
            r7 = r11 & 16
            if (r7 == 0) goto L_0x01e7
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r7 = r7.getShapes(r12, r2)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getLarge()
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            r1 = r1 & r19
            goto L_0x01e8
        L_0x01e7:
            r7 = r9
        L_0x01e8:
            if (r10 == 0) goto L_0x01f1
            androidx.compose.material.DrawerDefaults r8 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r8 = r8.m1281getElevationD9Ej5fM()
            goto L_0x01f3
        L_0x01f1:
            r8 = r37
        L_0x01f3:
            r9 = r11 & 64
            if (r9 == 0) goto L_0x0204
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r9 = r9.getColors(r12, r2)
            long r9 = r9.m1245getSurface0d7_KjU()
            r1 = r1 & r18
            goto L_0x0206
        L_0x0204:
            r9 = r38
        L_0x0206:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0215
            int r5 = r1 >> 18
            r5 = r5 & 14
            long r18 = androidx.compose.material.ColorsKt.m1259contentColorForek8zF_U(r9, r12, r5)
            r1 = r1 & r17
            goto L_0x0217
        L_0x0215:
            r18 = r40
        L_0x0217:
            r5 = r11 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0236
            androidx.compose.material.DrawerDefaults r5 = androidx.compose.material.DrawerDefaults.INSTANCE
            long r2 = r5.getScrimColor(r12, r2)
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r4
            r24 = r2
            r17 = r6
            r20 = r9
            r22 = r18
            r9 = r33
            r10 = r0
            r18 = r7
            r19 = r8
            r8 = r1
            goto L_0x0246
        L_0x0236:
            r24 = r3
            r17 = r6
            r20 = r9
            r22 = r18
            r9 = r33
            r10 = r0
            r18 = r7
            r19 = r8
            r8 = r1
        L_0x0246:
            r12.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0258
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.BottomDrawer (Drawer.kt:640)"
            r2 = 625649286(0x254aa686, float:1.7577127E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r0, r1)
        L_0x0258:
            r0 = -1561647407(0xffffffffa2eb26d1, float:-6.3737976E-18)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "654@24761L7,655@24777L64"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.ui.unit.Density r0 = r10.getDensity$material_release()
            r1 = 0
            if (r0 != 0) goto L_0x028e
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r4, r5)
            java.lang.Object r4 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r0 = r4
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.material.DrawerKt$BottomDrawer$1 r2 = new androidx.compose.material.DrawerKt$BottomDrawer$1
            r2.<init>(r10, r0)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            androidx.compose.runtime.EffectsKt.SideEffect(r2, r12, r1)
        L_0x028e:
            r12.endReplaceableGroup()
            r0 = r1
            r2 = 0
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = r12
            r4 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r5)
            r5 = 0
            r6 = r12
            r7 = 0
            r33 = r0
            java.lang.Object r0 = r6.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r34 = r1
            java.lang.Object r1 = r26.getEmpty()
            if (r0 != r1) goto L_0x02df
            r1 = 0
            r26 = 0
            kotlin.coroutines.EmptyCoroutineContext r26 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r35 = r0
            r0 = r26
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r3)
            r36 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r6.updateRememberedValue(r0)
            goto L_0x02e1
        L_0x02df:
            r35 = r0
        L_0x02e1:
            r12.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r7 = r0.getCoroutineScope()
            r12.endReplaceableGroup()
            r0 = 0
            r5 = 1
            r1 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r9, r0, r5, r1)
            androidx.compose.material.DrawerKt$BottomDrawer$2 r6 = new androidx.compose.material.DrawerKt$BottomDrawer$2
            r0 = r6
            r1 = r17
            r2 = r10
            r3 = r44
            r4 = r8
            r15 = r6
            r5 = r24
            r26 = r8
            r8 = r18
            r29 = r9
            r28 = r10
            r9 = r20
            r30 = r12
            r11 = r22
            r13 = r19
            r14 = r32
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9, r11, r13, r14)
            r0 = 1220102512(0x48b94970, float:379467.5)
            r14 = r30
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r1, r15)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 6
            r3 = 0
            r4 = 0
            r33 = r16
            r34 = r3
            r35 = r4
            r36 = r0
            r37 = r14
            r38 = r1
            r39 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r33, r34, r35, r36, r37, r38, r39)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0343
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0343:
            androidx.compose.runtime.ScopeUpdateScope r15 = r14.endRestartGroup()
            if (r15 != 0) goto L_0x034c
            r27 = r14
            goto L_0x0378
        L_0x034c:
            androidx.compose.material.DrawerKt$BottomDrawer$3 r16 = new androidx.compose.material.DrawerKt$BottomDrawer$3
            r0 = r16
            r1 = r32
            r2 = r29
            r3 = r28
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r9 = r22
            r11 = r24
            r13 = r44
            r27 = r14
            r14 = r46
            r31 = r15
            r15 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r31
            r1.updateScope(r0)
        L_0x0378:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1282BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Map<BottomDrawerValue, Float> calculateAnchors(float fullHeight, float drawerHeight, boolean isLandscape) {
        float peekHeight = 0.5f * fullHeight;
        float expandedHeight = Math.max(0.0f, fullHeight - drawerHeight);
        Float f = null;
        boolean z = true;
        boolean z2 = false;
        if (drawerHeight < peekHeight || isLandscape) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to(BottomDrawerValue.Closed, Float.valueOf(fullHeight));
            BottomDrawerValue bottomDrawerValue = BottomDrawerValue.Expanded;
            if (drawerHeight == 0.0f) {
                z2 = true;
            }
            if (!z2) {
                f = Float.valueOf(expandedHeight);
            }
            pairArr[1] = TuplesKt.to(bottomDrawerValue, f);
            return MapsKt.mapOf(pairArr);
        }
        Pair[] pairArr2 = new Pair[3];
        pairArr2[0] = TuplesKt.to(BottomDrawerValue.Closed, Float.valueOf(fullHeight));
        pairArr2[1] = TuplesKt.to(BottomDrawerValue.Open, Float.valueOf(peekHeight));
        BottomDrawerValue bottomDrawerValue2 = BottomDrawerValue.Expanded;
        if (drawerHeight != 0.0f) {
            z = false;
        }
        if (!z) {
            f = Float.valueOf(expandedHeight);
        }
        pairArr2[2] = TuplesKt.to(bottomDrawerValue2, f);
        return MapsKt.mapOf(pairArr2);
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M  reason: not valid java name */
    public static final void m1283BottomDrawerScrim3JVO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        Modifier dismissModifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        long j = color;
        Function0<Unit> function0 = onDismiss;
        boolean z = visible;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation($composer2, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)805@29975L121,809@30123L30,827@30676L62,823@30567L171:Drawer.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-513067266, $dirty2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:799)");
            }
            if (color != Color.Companion.m3289getUnspecified0d7_KjU()) {
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28);
                String closeDrawer = Strings_androidKt.m1418getString4foXLRw(Strings.Companion.m1411getCloseDrawerUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(-1298942364);
                ComposerKt.sourceInformation($composer2, "812@30261L73,815@30387L122");
                if (z) {
                    Modifier modifier = Modifier.Companion;
                    int i2 = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = (Function2) new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, (Continuation<? super DrawerKt$BottomDrawerScrim$dismissModifier$1$1>) null);
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Composer composer = $this$cache$iv$iv;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv);
                    int $changed$iv = $dirty2 & 112;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer2.changed((Object) closeDrawer) | $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv2 = $composer2;
                    Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                    if (!invalid$iv$iv2) {
                        int i3 = $changed$iv;
                        if (it$iv$iv2 != Composer.Companion.getEmpty()) {
                            value$iv$iv2 = it$iv$iv2;
                            $composer2.endReplaceableGroup();
                            dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                        }
                    }
                    value$iv$iv2 = (Function1) new DrawerKt$BottomDrawerScrim$dismissModifier$2$1(closeDrawer, function0);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                } else {
                    dismissModifier = Modifier.Companion;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(dismissModifier);
                Object r3 = Color.m3243boximpl(color);
                int i4 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed(r3) | $composer2.changed((Object) alpha$delegate);
                Composer $this$cache$iv$iv3 = $composer2;
                Modifier modifier2 = dismissModifier;
                Object value$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (!invalid$iv$iv3) {
                    Color color2 = r3;
                    if (value$iv$iv3 != Composer.Companion.getEmpty()) {
                        Object obj = value$iv$iv3;
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
                    }
                } else {
                    Object key1$iv = r3;
                }
                Object obj2 = value$iv$iv3;
                value$iv$iv3 = new DrawerKt$BottomDrawerScrim$1$1(j, alpha$delegate);
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
            }
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
        endRestartGroup.updateScope(new DrawerKt$BottomDrawerScrim$2(color, onDismiss, visible, $changed));
    }

    /* access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$3(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a5  */
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1285ScrimBx497Mc(boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, kotlin.jvm.functions.Function0<java.lang.Float> r24, long r25, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r12 = r28
            r0 = 1983403750(0x763856e6, float:9.3471204E32)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)840@30893L30,856@31337L51,852@31246L142:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r28
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r13.changed((boolean) r7)
            if (r2 == 0) goto L_0x0026
            r2 = 4
            goto L_0x0027
        L_0x0026:
            r2 = 2
        L_0x0027:
            r1 = r1 | r2
        L_0x0028:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0038
            boolean r2 = r13.changedInstance(r8)
            if (r2 == 0) goto L_0x0035
            r2 = 32
            goto L_0x0037
        L_0x0035:
            r2 = 16
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r12 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0048
            boolean r2 = r13.changedInstance(r9)
            if (r2 == 0) goto L_0x0045
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0047
        L_0x0045:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0058
            boolean r2 = r13.changed((long) r10)
            if (r2 == 0) goto L_0x0055
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0057
        L_0x0055:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0057:
            r1 = r1 | r2
        L_0x0058:
            r14 = r1
            r1 = r14 & 5851(0x16db, float:8.199E-42)
            r2 = 1170(0x492, float:1.64E-42)
            if (r1 != r2) goto L_0x006b
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x0066
            goto L_0x006b
        L_0x0066:
            r13.skipToGroupEnd()
            goto L_0x01a8
        L_0x006b:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0077
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.Scrim (Drawer.kt:834)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0077:
            androidx.compose.material.Strings$Companion r0 = androidx.compose.material.Strings.Companion
            int r0 = r0.m1411getCloseDrawerUdPEhr4()
            r1 = 6
            java.lang.String r0 = androidx.compose.material.Strings_androidKt.m1418getString4foXLRw(r0, r13, r1)
            r1 = 1010561092(0x3c3bf044, float:0.011470858)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "843@31012L35,844@31096L108"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            if (r7 == 0) goto L_0x0130
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            int r6 = r14 >> 3
            r6 = r6 & 14
            r15 = 0
            r4 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r4 = r13.changed((java.lang.Object) r8)
            r16 = r13
            r17 = 0
            java.lang.Object r2 = r16.rememberedValue()
            r19 = 0
            if (r4 != 0) goto L_0x00c3
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r20.getEmpty()
            if (r2 != r3) goto L_0x00be
            goto L_0x00c3
        L_0x00be:
            r20 = r2
            r3 = r16
            goto L_0x00d7
        L_0x00c3:
            r3 = 0
            r20 = r2
            androidx.compose.material.DrawerKt$Scrim$dismissDrawer$1$1 r2 = new androidx.compose.material.DrawerKt$Scrim$dismissDrawer$1$1
            r21 = r3
            r3 = 0
            r2.<init>(r8, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = r16
            r3.updateRememberedValue(r2)
        L_0x00d7:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r5, (java.lang.Object) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r2)
            r3 = r14 & 112(0x70, float:1.57E-43)
            r4 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r5 = r13.changed((java.lang.Object) r0)
            boolean r6 = r13.changed((java.lang.Object) r8)
            r5 = r5 | r6
            r6 = r13
            r15 = 0
            r16 = r3
            java.lang.Object r3 = r6.rememberedValue()
            r17 = 0
            if (r5 != 0) goto L_0x0112
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r4
            java.lang.Object r4 = r19.getEmpty()
            if (r3 != r4) goto L_0x010f
            goto L_0x0114
        L_0x010f:
            r19 = r3
            goto L_0x0123
        L_0x0112:
            r20 = r4
        L_0x0114:
            r4 = 0
            r19 = r3
            androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1 r3 = new androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
            r3.<init>(r0, r8)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6.updateRememberedValue(r3)
        L_0x0123:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r2, r4, r3)
            goto L_0x0134
        L_0x0130:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x0134:
            r13.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r3, r4, r6, r5)
            androidx.compose.ui.Modifier r3 = r3.then(r2)
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m3243boximpl(r25)
            int r5 = r14 >> 9
            r5 = r5 & 14
            int r6 = r14 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = 0
            r15 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = r13.changed((java.lang.Object) r4)
            boolean r15 = r13.changed((java.lang.Object) r9)
            r1 = r1 | r15
            r15 = r13
            r16 = 0
            r27 = r0
            java.lang.Object r0 = r15.rememberedValue()
            r17 = 0
            if (r1 != 0) goto L_0x0183
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0180
            goto L_0x0185
        L_0x0180:
            r18 = r0
            goto L_0x0194
        L_0x0183:
            r19 = r1
        L_0x0185:
            r1 = 0
            r18 = r0
            androidx.compose.material.DrawerKt$Scrim$1$1 r0 = new androidx.compose.material.DrawerKt$Scrim$1$1
            r0.<init>(r10, r9)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r15.updateRememberedValue(r0)
        L_0x0194:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r0, r13, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a8:
            androidx.compose.runtime.ScopeUpdateScope r15 = r13.endRestartGroup()
            if (r15 != 0) goto L_0x01af
            goto L_0x01c7
        L_0x01af:
            androidx.compose.material.DrawerKt$Scrim$2 r16 = new androidx.compose.material.DrawerKt$Scrim$2
            r0 = r16
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r6 = r28
            r0.<init>(r1, r2, r3, r4, r6)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1285ScrimBx497Mc(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, long, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> state) {
        return new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(state);
    }

    /* access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> BottomDrawerAnchorChangeCallback(BottomDrawerState state, CoroutineScope scope) {
        return new DrawerKt$BottomDrawerAnchorChangeCallback$1(state, scope);
    }
}
