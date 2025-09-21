package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010!\u001am\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0019\u001ac\u0010'\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0001\u0010+\u001a\u00020\b2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\u0006\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001ao\u00107\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a=\u00109\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010:\u001aA\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010?\u001a\u00020\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a \u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\u0002\u001a+\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020H2\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 0\u0014H\u0007¢\u0006\u0002\u0010J\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(256, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float DrawerVelocityThreshold = Dp.m5844constructorimpl((float) 400);
    /* access modifiers changed from: private */
    public static final float MinimumDrawerWidth = Dp.m5844constructorimpl((float) 240);

    public static final DrawerState rememberDrawerState(DrawerValue initialValue, Function1<? super DrawerValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(2098699222);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)227@8145L61,227@8081L125:NavigationDrawer.kt#uh7d8r");
        Function1<? super DrawerValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 2) != 0) {
            confirmStateChange2 = NavigationDrawerKt$rememberDrawerState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, $changed, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:223)");
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
            value$iv$iv = (Function0) new NavigationDrawerKt$rememberDrawerState$2$1(initialValue, confirmStateChange2);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x05b7  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0694  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x06a0  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x06a4  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0761  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x076e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e3  */
    /* renamed from: ModalNavigationDrawer-FHprtrg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1876ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, androidx.compose.ui.Modifier r68, androidx.compose.material3.DrawerState r69, boolean r70, long r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, androidx.compose.runtime.Composer r74, int r75, int r76) {
        /*
            r10 = r67
            r11 = r73
            r12 = r75
            java.lang.String r0 = "drawerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            r1 = r74
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)256@9399L39,258@9516L10,261@9584L24,262@9634L33,*263@9706L7,267@9910L7,268@9945L1722:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r75
            r2 = r76 & 1
            r3 = 2
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r13.changedInstance(r10)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r76 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r4 = r68
            goto L_0x0054
        L_0x003f:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0052
            r4 = r68
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004e
            r5 = 32
            goto L_0x0050
        L_0x004e:
            r5 = 16
        L_0x0050:
            r1 = r1 | r5
            goto L_0x0054
        L_0x0052:
            r4 = r68
        L_0x0054:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006d
            r5 = r76 & 4
            if (r5 != 0) goto L_0x0067
            r5 = r69
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0069
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0067:
            r5 = r69
        L_0x0069:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r1 = r1 | r6
            goto L_0x006f
        L_0x006d:
            r5 = r69
        L_0x006f:
            r6 = r76 & 8
            if (r6 == 0) goto L_0x0078
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r70
            goto L_0x008d
        L_0x0078:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008b
            r7 = r70
            boolean r8 = r13.changed((boolean) r7)
            if (r8 == 0) goto L_0x0087
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r1 = r1 | r8
            goto L_0x008d
        L_0x008b:
            r7 = r70
        L_0x008d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00a8
            r8 = r76 & 16
            if (r8 != 0) goto L_0x00a2
            r8 = r71
            boolean r14 = r13.changed((long) r8)
            if (r14 == 0) goto L_0x00a4
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a2:
            r8 = r71
        L_0x00a4:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r14
            goto L_0x00aa
        L_0x00a8:
            r8 = r71
        L_0x00aa:
            r14 = r76 & 32
            if (r14 == 0) goto L_0x00b2
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b0:
            r1 = r1 | r14
            goto L_0x00c3
        L_0x00b2:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r12
            if (r14 != 0) goto L_0x00c3
            boolean r14 = r13.changedInstance(r11)
            if (r14 == 0) goto L_0x00c0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00c0:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b0
        L_0x00c3:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r1
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00e3
            boolean r14 = r13.getSkipping()
            if (r14 != 0) goto L_0x00d3
            goto L_0x00e3
        L_0x00d3:
            r13.skipToGroupEnd()
            r12 = r1
            r16 = r4
            r35 = r7
            r33 = r8
            r2 = r10
            r53 = r13
            r10 = r5
            goto L_0x0767
        L_0x00e3:
            r13.startDefaults()
            r14 = r12 & 1
            r15 = 0
            r0 = 6
            if (r14 == 0) goto L_0x0107
            boolean r14 = r13.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00f3
            goto L_0x0107
        L_0x00f3:
            r13.skipToGroupEnd()
            r2 = r76 & 4
            if (r2 == 0) goto L_0x00fc
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00fc:
            r2 = r76 & 16
            if (r2 == 0) goto L_0x0104
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x0104:
            r2 = r4
            r4 = r5
            goto L_0x0130
        L_0x0107:
            if (r2 == 0) goto L_0x010e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x010f
        L_0x010e:
            r2 = r4
        L_0x010f:
            r4 = r76 & 4
            if (r4 == 0) goto L_0x011c
            androidx.compose.material3.DrawerValue r4 = androidx.compose.material3.DrawerValue.Closed
            androidx.compose.material3.DrawerState r4 = rememberDrawerState(r4, r15, r13, r0, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x011d
        L_0x011c:
            r4 = r5
        L_0x011d:
            if (r6 == 0) goto L_0x0121
            r5 = 1
            r7 = r5
        L_0x0121:
            r5 = r76 & 16
            if (r5 == 0) goto L_0x0130
            androidx.compose.material3.DrawerDefaults r5 = androidx.compose.material3.DrawerDefaults.INSTANCE
            long r5 = r5.getScrimColor(r13, r0)
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r8
            r8 = r5
        L_0x0130:
            r13.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0142
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)"
            r14 = -1169303680(0xffffffffba4dd780, float:-7.8522414E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r1, r5, r6)
        L_0x0142:
            r5 = 0
            r6 = r5
            r14 = 0
            r15 = 773894976(0x2e20b340, float:3.6538994E-11)
            r13.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            r15 = r13
            r16 = r5
            r17 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r5 = 0
            r69 = r13
            r18 = 0
            java.lang.Object r3 = r69.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r21.getEmpty()
            if (r3 != r0) goto L_0x0194
            r0 = 0
            r21 = 0
            kotlin.coroutines.EmptyCoroutineContext r21 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r70 = r0
            r0 = r21
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r15)
            r71 = r3
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r0)
            r0 = r3
            r3 = r69
            r3.updateRememberedValue(r0)
            goto L_0x019a
        L_0x0194:
            r71 = r3
            r3 = r69
            r0 = r71
        L_0x019a:
            r13.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r3 = r0.getCoroutineScope()
            r13.endReplaceableGroup()
            r0 = r3
            androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
            int r3 = r3.m2033getNavigationMenuadMyvUU()
            r5 = 6
            java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r3, r13, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 0
            r14 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r69 = r6
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r15, r6)
            java.lang.Object r6 = r13.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r5 = r6
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            r6 = 0
            androidx.compose.material3.tokens.NavigationDrawerTokens r14 = androidx.compose.material3.tokens.NavigationDrawerTokens.INSTANCE
            float r14 = r14.m2572getContainerWidthD9Ej5fM()
            float r5 = r5.m5825toPx0680j_4(r14)
            float r5 = -r5
            r6 = 0
            java.lang.Float r14 = java.lang.Float.valueOf(r5)
            androidx.compose.material3.DrawerValue r15 = androidx.compose.material3.DrawerValue.Closed
            kotlin.Pair r14 = kotlin.TuplesKt.to(r14, r15)
            java.lang.Float r15 = java.lang.Float.valueOf(r6)
            androidx.compose.material3.DrawerValue r12 = androidx.compose.material3.DrawerValue.Open
            kotlin.Pair r12 = kotlin.TuplesKt.to(r15, r12)
            r15 = 2
            kotlin.Pair[] r15 = new kotlin.Pair[r15]
            r16 = 0
            r15[r16] = r14
            r14 = 1
            r15[r14] = r12
            java.util.Map r12 = kotlin.collections.MapsKt.mapOf(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r16 = 0
            r17 = 0
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r14)
            java.lang.Object r10 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r14 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r10 != r14) goto L_0x021f
            r22 = 1
            goto L_0x0221
        L_0x021f:
            r22 = 0
        L_0x0221:
            r10 = 0
            r14 = 0
            r15 = 1
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r10, r15, r14)
            androidx.compose.material3.SwipeableState r18 = r4.getSwipeableState$material3_release()
            androidx.compose.foundation.gestures.Orientation r20 = androidx.compose.foundation.gestures.Orientation.Horizontal
            float r26 = DrawerVelocityThreshold
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1 r10 = androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE
            r24 = r10
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            r27 = 32
            r28 = 0
            r23 = 0
            r25 = 0
            r19 = r12
            r21 = r7
            androidx.compose.ui.Modifier r10 = androidx.compose.material3.SwipeableKt.m2077swipeablepPrIpRY$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r14 = 0
            r15 = r14
            r14 = 0
            r16 = r2
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            r72 = r12
            androidx.compose.ui.Alignment r12 = r17.getTopStart()
            r17 = r14
            r14 = 0
            int r18 = r15 >> 3
            r18 = r18 & 14
            int r19 = r15 >> 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r20 = r3
            r3 = r18 | r19
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r14, r13, r3)
            int r18 = r15 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r19 = 0
            r21 = r12
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r23 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r32 = r14
            r14 = r23
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r23 = 6
            r24 = 0
            r33 = r8
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r8)
            java.lang.Object r9 = r13.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r23 = 6
            r24 = 0
            r35 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r8)
            java.lang.Object r6 = r13.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r23 = 6
            r24 = 0
            r36 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r8)
            java.lang.Object r5 = r13.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r23 = androidx.compose.ui.layout.LayoutKt.materializerOf(r10)
            r37 = r10
            int r10 = r18 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r24 = 6
            r10 = r10 | 6
            r38 = r23
            r39 = 0
            r40 = r0
            androidx.compose.runtime.Applier r0 = r13.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x030b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x030b:
            r13.startReusableNode()
            boolean r0 = r13.getInserting()
            if (r0 == 0) goto L_0x0318
            r13.createNode(r14)
            goto L_0x031b
        L_0x0318:
            r13.useNode()
        L_0x031b:
            r13.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r13)
            r23 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r24 = androidx.compose.ui.node.ComposeUiNode.Companion
            r41 = r14
            kotlin.jvm.functions.Function2 r14 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r6, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r5, r14)
            r13.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r14 = r10 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r42 = r3
            r3 = r38
            r3.invoke(r0, r13, r14)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            int r14 = r10 >> 9
            r14 = r14 & 14
            r38 = r13
            r43 = 0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r44 = r3
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            r45 = r5
            r5 = r38
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r23 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r24 = r15 >> 6
            r24 = r24 & 112(0x70, float:1.57E-43)
            r25 = 6
            r38 = r24 | 6
            androidx.compose.foundation.layout.BoxScope r23 = (androidx.compose.foundation.layout.BoxScope) r23
            r46 = r23
            r47 = r5
            r48 = 0
            r0 = 2009205847(0x77c20c57, float:7.87153E33)
            r49 = r6
            java.lang.String r6 = "C282@10437L37,295@10832L95,285@10483L486,302@11028L55,300@10978L683:NavigationDrawer.kt#uh7d8r"
            r50 = r9
            r9 = r47
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r6)
            r0 = 0
            r6 = 0
            r23 = r6
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Alignment$Companion r24 = androidx.compose.ui.Alignment.Companion
            r47 = r10
            androidx.compose.ui.Alignment r10 = r24.getTopStart()
            r51 = r14
            r14 = 0
            int r24 = r0 >> 3
            r24 = r24 & 14
            int r25 = r0 >> 3
            r25 = r25 & 112(0x70, float:1.57E-43)
            r52 = r15
            r15 = r24 | r25
            androidx.compose.ui.layout.MeasurePolicy r15 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r14, r9, r15)
            int r24 = r0 << 3
            r24 = r24 & 112(0x70, float:1.57E-43)
            r25 = 0
            r26 = r10
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r27 = 6
            r28 = 0
            r29 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r14, r8)
            java.lang.Object r14 = r9.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r10 = r14
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r27 = 6
            r28 = 0
            r53 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r8)
            java.lang.Object r13 = r9.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r27 = 6
            r28 = 0
            r54 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r8)
            java.lang.Object r5 = r9.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r27 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            r28 = r6
            int r6 = r24 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r30 = 6
            r6 = r6 | 6
            r55 = r27
            r27 = 0
            r56 = r8
            androidx.compose.runtime.Applier r8 = r9.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0457
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0457:
            r9.startReusableNode()
            boolean r8 = r9.getInserting()
            if (r8 == 0) goto L_0x0464
            r9.createNode(r14)
            goto L_0x0467
        L_0x0464:
            r9.useNode()
        L_0x0467:
            r9.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2865constructorimpl(r9)
            r57 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r58 = androidx.compose.ui.node.ComposeUiNode.Companion
            r59 = r14
            kotlin.jvm.functions.Function2 r14 = r58.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r8, r15, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r8, r10, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r8, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r8, r5, r14)
            r9.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r8)
            int r14 = r6 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r57 = r5
            r5 = r55
            r5.invoke(r8, r9, r14)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r8)
            int r8 = r6 >> 9
            r8 = r8 & 14
            r14 = r9
            r55 = 0
            r58 = r5
            r5 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r60 = r0 >> 6
            r60 = r60 & 112(0x70, float:1.57E-43)
            r30 = 6
            r60 = r60 | 6
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r61 = r14
            r62 = 0
            r63 = r0
            r0 = -860470390(0xffffffffccb6438a, float:-9.5558736E7)
            r64 = r5
            java.lang.String r5 = "C283@10455L9:NavigationDrawer.kt#uh7d8r"
            r65 = r6
            r6 = r61
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r5)
            int r0 = r1 >> 15
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.invoke(r6, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            boolean r23 = r4.isOpen()
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2 r0 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2
            r5 = r40
            r0.<init>(r7, r4, r5)
            r24 = r0
            kotlin.jvm.functions.Function0 r24 = (kotlin.jvm.functions.Function0) r24
            java.lang.Float r0 = java.lang.Float.valueOf(r36)
            java.lang.Float r6 = java.lang.Float.valueOf(r35)
            r8 = r1 & 896(0x380, float:1.256E-42)
            r8 = r8 | 48
            r10 = 0
            r13 = 1618982084(0x607fb4c4, float:7.370227E19)
            r9.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r13)
            boolean r13 = r9.changed((java.lang.Object) r0)
            boolean r14 = r9.changed((java.lang.Object) r6)
            r13 = r13 | r14
            boolean r14 = r9.changed((java.lang.Object) r4)
            r13 = r13 | r14
            r14 = r9
            r15 = 0
            r25 = r0
            java.lang.Object r0 = r14.rememberedValue()
            r26 = 0
            if (r13 != 0) goto L_0x0561
            androidx.compose.runtime.Composer$Companion r27 = androidx.compose.runtime.Composer.Companion
            r28 = r6
            java.lang.Object r6 = r27.getEmpty()
            if (r0 != r6) goto L_0x0556
            goto L_0x0563
        L_0x0556:
            r27 = r0
            r6 = r36
            r66 = r35
            r35 = r7
            r7 = r66
            goto L_0x057c
        L_0x0561:
            r28 = r6
        L_0x0563:
            r6 = 0
            r27 = r0
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1 r0 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
            r29 = r6
            r6 = r36
            r66 = r35
            r35 = r7
            r7 = r66
            r0.<init>(r6, r7, r4)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14.updateRememberedValue(r0)
        L_0x057c:
            r9.endReplaceableGroup()
            r25 = r0
            kotlin.jvm.functions.Function0 r25 = (kotlin.jvm.functions.Function0) r25
            int r0 = r1 >> 3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r26 = r33
            r28 = r9
            r29 = r0
            m1878ScrimBx497Mc(r23, r24, r25, r26, r28, r29)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            int r8 = r1 >> 6
            r8 = r8 & 14
            r10 = 0
            r13 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r13)
            boolean r13 = r9.changed((java.lang.Object) r4)
            r14 = r9
            r15 = 0
            r36 = r6
            java.lang.Object r6 = r14.rememberedValue()
            r23 = 0
            if (r13 != 0) goto L_0x05c5
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r7
            java.lang.Object r7 = r24.getEmpty()
            if (r6 != r7) goto L_0x05c2
            goto L_0x05c7
        L_0x05c2:
            r24 = r6
            goto L_0x05d6
        L_0x05c5:
            r25 = r7
        L_0x05c7:
            r7 = 0
            r24 = r6
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1 r6 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
            r6.<init>(r4)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r14.updateRememberedValue(r6)
        L_0x05d6:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r6)
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5 r6 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5
            r7 = r20
            r6.<init>(r7, r4, r5)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r8 = 0
            r10 = 0
            r13 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r10, r6, r13, r8)
            r6 = r10
            r8 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r10 = 0
            int r13 = r6 >> 3
            r13 = r13 & 14
            int r14 = r6 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r10, r9, r13)
            int r14 = r6 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r15 = 0
            r68 = r2
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r12 = 6
            r20 = 0
            r70 = r4
            r40 = r5
            r4 = r56
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r4)
            java.lang.Object r5 = r9.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r2 = r5
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r12 = 6
            r20 = 0
            r23 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r7, r4)
            java.lang.Object r7 = r9.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r5 = r7
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r12 = 6
            r20 = 0
            r71 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r4)
            java.lang.Object r4 = r9.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r12 = r14 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r20 = 6
            r12 = r12 | 6
            r20 = 0
            r69 = r0
            androidx.compose.runtime.Applier r0 = r9.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x0697
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0697:
            r9.startReusableNode()
            boolean r0 = r9.getInserting()
            if (r0 == 0) goto L_0x06a4
            r9.createNode(r7)
            goto L_0x06a7
        L_0x06a4:
            r9.useNode()
        L_0x06a7:
            r9.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r9)
            r24 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            r74 = r7
            kotlin.jvm.functions.Function2 r7 = r26.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r13, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r5, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r4, r7)
            r9.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
            int r7 = r12 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.invoke(r0, r9, r7)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r0)
            int r0 = r12 >> 9
            r0 = r0 & 14
            r7 = r9
            r24 = 0
            r26 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r6 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r27 = 6
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r27 = r7
            r28 = 0
            r29 = r0
            r0 = -860469209(0xffffffffccb64827, float:-9.5568184E7)
            r30 = r2
            java.lang.String r2 = "C317@11636L15:NavigationDrawer.kt#uh7d8r"
            r31 = r3
            r3 = r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            r0 = r1 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = r67
            r2.invoke(r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r54)
            r53.endReplaceableGroup()
            r53.endNode()
            r53.endReplaceableGroup()
            r53.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0764
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0764:
            r10 = r70
            r12 = r1
        L_0x0767:
            androidx.compose.runtime.ScopeUpdateScope r13 = r53.endRestartGroup()
            if (r13 != 0) goto L_0x076e
            goto L_0x0788
        L_0x076e:
            androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3 r14 = new androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
            r0 = r14
            r1 = r67
            r2 = r16
            r3 = r10
            r4 = r35
            r5 = r33
            r7 = r73
            r8 = r75
            r9 = r76
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0788:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1876ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DismissibleNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, DrawerState drawerState, boolean gesturesEnabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        DrawerState drawerState2;
        boolean gesturesEnabled2;
        Composer $composer2;
        boolean gesturesEnabled3;
        DrawerState drawerState3;
        Modifier modifier3;
        DrawerState drawerState4;
        Modifier modifier4;
        Object value$iv$iv$iv;
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function2 = drawerContent;
        Function2<? super Composer, ? super Integer, Unit> function22 = content;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(function2, "drawerContent");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer $composer3 = $composer.startRestartGroup(398812198);
        ComposerKt.sourceInformation($composer3, "C(DismissibleNavigationDrawer)P(1,4,2,3)347@12931L39,*352@13151L7,356@13256L24,357@13306L33,360@13464L7,361@13499L1566:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                drawerState2 = drawerState;
                if ($composer3.changed((Object) drawerState2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                drawerState2 = drawerState;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            drawerState2 = drawerState;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            gesturesEnabled2 = gesturesEnabled;
        } else if ((i3 & 7168) == 0) {
            gesturesEnabled2 = gesturesEnabled;
            $dirty |= $composer3.changed(gesturesEnabled2) ? 2048 : 1024;
        } else {
            gesturesEnabled2 = gesturesEnabled;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i3) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        if ((46811 & $dirty) != 9362 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i3 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    drawerState4 = rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, $composer3, 6, 2);
                    $dirty &= -897;
                } else {
                    drawerState4 = drawerState2;
                }
                if (i5 != 0) {
                    gesturesEnabled2 = true;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                drawerState4 = drawerState2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398812198, $dirty, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
            }
            float drawerWidth = NavigationDrawerTokens.INSTANCE.m2572getContainerWidthD9Ej5fM();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float drawerWidthPx = ((Density) consume).m5825toPx0680j_4(drawerWidth);
            float minValue = -drawerWidthPx;
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer3;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer3;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            float f = drawerWidth;
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                Composer composer = composer$iv;
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                Composer composer$iv2 = $this$cache$iv$iv$iv;
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer3.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer3.endReplaceableGroup();
            CoroutineScope scope = coroutineScope;
            String navigationMenu = Strings_androidKt.m2053getStringNWtq28(Strings.Companion.m2033getNavigationMenuadMyvUU(), $composer3, 6);
            float f2 = drawerWidthPx;
            Map anchors = MapsKt.mapOf(TuplesKt.to(Float.valueOf(minValue), DrawerValue.Closed), TuplesKt.to(Float.valueOf(0.0f), DrawerValue.Open));
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean isRtl = consume2 == LayoutDirection.Rtl;
            String str = "CC:CompositionLocal.kt#9igjgp";
            Modifier modifier5 = modifier4;
            Modifier modifier$iv = SwipeableKt.m2077swipeablepPrIpRY$default(modifier4, drawerState4.getSwipeableState$material3_release(), anchors, Orientation.Horizontal, gesturesEnabled2, isRtl, (MutableInteractionSource) null, NavigationDrawerKt$DismissibleNavigationDrawer$1.INSTANCE, (ResistanceConfig) null, DrawerVelocityThreshold, 32, (Object) null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Map map = anchors;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            float f3 = minValue;
            gesturesEnabled3 = gesturesEnabled2;
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & true) | ((0 >> 3) & true));
            Alignment alignment = contentAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier6 = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            int $dirty2 = $dirty;
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
            Density density = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 973028062, "C373@13915L1144:NavigationDrawer.kt#uh7d8r");
            MeasurePolicy measurePolicy$iv2 = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2(drawerState4);
            int i7 = ($changed$iv$iv$iv >> 9) & 14;
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv2 = Modifier.Companion;
            int i8 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, str);
            Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv = (Density) consume6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, str);
            Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume7;
            Composer $composer$iv2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, str);
            Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume8;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier7 = modifier$iv2;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor2);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer4);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            Composer $composer5 = $composer4;
            MeasurePolicy measurePolicy2 = measurePolicy$iv2;
            ViewConfiguration viewConfiguration2 = viewConfiguration$iv;
            ComposerKt.sourceInformationMarkerStart($composer5, 94146718, "C374@13946L523,389@14482L45:NavigationDrawer.kt#uh7d8r");
            CoroutineScope coroutineScope2 = scope;
            String str2 = navigationMenu;
            DrawerState drawerState5 = drawerState4;
            Modifier modifier$iv3 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(navigationMenu, drawerState4, scope), 1, (Object) null);
            $composer5.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer5.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment2 = contentAlignment$iv2;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Density density$iv$iv2 = (Density) consume9;
            int i9 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume10 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume10;
            LayoutDirection layoutDirection2 = layoutDirection$iv;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume11 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume11;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv3);
            Modifier modifier8 = modifier$iv3;
            int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
            int i10 = $changed$iv$iv;
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(constructor3);
            } else {
                $composer5.useNode();
            }
            $composer5.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer5);
            Function0<ComposeUiNode> function03 = constructor3;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer5.enableReusing();
            Density density2 = density$iv$iv2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            function35.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer5.startReplaceableGroup(2058660585);
            int i11 = ($changed$iv$iv$iv2 >> 9) & 14;
            Composer $composer$iv3 = $composer5;
            int i12 = $changed$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i13 = ((0 >> 6) & 112) | 6;
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
            Composer $composer6 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer6, -817267027, "C387@14440L15:NavigationDrawer.kt#uh7d8r");
            drawerContent.invoke($composer6, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer5.endReplaceableGroup();
            $composer5.endNode();
            $composer5.endReplaceableGroup();
            $composer5.endReplaceableGroup();
            $composer5.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer5.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume12 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Density density$iv$iv3 = (Density) consume12;
            Alignment alignment3 = contentAlignment$iv3;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume13 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume13;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume14 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume14;
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv4);
            Modifier modifier9 = modifier$iv4;
            int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(constructor4);
            } else {
                $composer5.useNode();
            }
            $composer5.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2865constructorimpl($composer5);
            Function0<ComposeUiNode> function04 = constructor4;
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer5.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer5.startReplaceableGroup(2058660585);
            int i14 = ($changed$iv$iv$iv3 >> 9) & 14;
            Composer $composer$iv4 = $composer5;
            Density density3 = density$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i15 = ((0 >> 6) & 112) | 6;
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i16 = $changed$iv$iv$iv3;
            Composer $composer7 = $composer$iv4;
            ComposerKt.sourceInformationMarkerStart($composer7, -817266963, "C390@14504L9:NavigationDrawer.kt#uh7d8r");
            content.invoke($composer7, Integer.valueOf(($dirty2 >> 12) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer5.endReplaceableGroup();
            $composer5.endNode();
            $composer5.endReplaceableGroup();
            $composer5.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            drawerState3 = drawerState5;
        } else {
            $composer3.skipToGroupEnd();
            int i17 = $dirty;
            modifier3 = modifier2;
            gesturesEnabled3 = gesturesEnabled2;
            Function2<? super Composer, ? super Integer, Unit> function23 = function22;
            $composer2 = $composer3;
            drawerState3 = drawerState2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$DismissibleNavigationDrawer$3(drawerContent, modifier3, drawerState3, gesturesEnabled3, content, $changed, i));
        }
    }

    public static final void PermanentNavigationDrawer(Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function2 = drawerContent;
        Function2<? super Composer, ? super Integer, Unit> function22 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function2, "drawerContent");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer $composer2 = $composer.startRestartGroup(-276843608);
        ComposerKt.sourceInformation($composer2, "C(PermanentNavigationDrawer)P(1,2)429@16096L105:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, $dirty2, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:424)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
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
            Modifier modifier6 = modifier$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
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
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer2;
            int i4 = $changed$iv$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            Composer $composer$iv2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1153996105, "C430@16134L15,431@16158L37:NavigationDrawer.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            int i5 = ((0 >> 6) & 112) | 6;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            int i6 = ($changed$iv$iv$iv >> 9) & 14;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv2 = (Density) consume4;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
            int i7 = $changed$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Modifier modifier7 = modifier$iv2;
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
            Composer $composer$iv3 = $composer3;
            int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer4, 1146973058, "C432@16176L9:NavigationDrawer.kt#uh7d8r");
            function22.invoke($composer4, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
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
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationDrawerKt$PermanentNavigationDrawer$2(drawerContent, modifier3, content, $changed, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0103  */
    /* renamed from: ModalDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1875ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r33
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1001163336(0x3bac8a48, float:0.005265508)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)456@17304L5,457@17359L11,458@17412L37,460@17567L12,463@17637L183:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r25
        L_0x0035:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r36 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r26
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r26
        L_0x004a:
            r5 = 16
        L_0x004c:
            r1 = r1 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r26
        L_0x0050:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r36 & 4
            if (r5 != 0) goto L_0x0063
            r5 = r27
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0065
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r5 = r27
        L_0x0065:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r1 = r1 | r7
            goto L_0x006b
        L_0x0069:
            r5 = r27
        L_0x006b:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0084
            r7 = r36 & 8
            if (r7 != 0) goto L_0x007e
            r7 = r29
            boolean r9 = r14.changed((long) r7)
            if (r9 == 0) goto L_0x0080
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x007e:
            r7 = r29
        L_0x0080:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r1 = r1 | r9
            goto L_0x0086
        L_0x0084:
            r7 = r29
        L_0x0086:
            r9 = r36 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r11 = r31
            goto L_0x00a7
        L_0x0092:
            r11 = r13 & r10
            if (r11 != 0) goto L_0x00a5
            r11 = r31
            boolean r15 = r14.changed((float) r11)
            if (r15 == 0) goto L_0x00a1
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r15
            goto L_0x00a7
        L_0x00a5:
            r11 = r31
        L_0x00a7:
            r15 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r15
            if (r16 != 0) goto L_0x00c3
            r16 = r36 & 32
            if (r16 != 0) goto L_0x00bc
            r15 = r32
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00be
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00bc:
            r15 = r32
        L_0x00be:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r1 = r1 | r16
            goto L_0x00c5
        L_0x00c3:
            r15 = r32
        L_0x00c5:
            r16 = r36 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d0
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cd:
            r1 = r1 | r16
            goto L_0x00e0
        L_0x00d0:
            r16 = r13 & r17
            if (r16 != 0) goto L_0x00e0
            boolean r16 = r14.changedInstance(r12)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cd
        L_0x00e0:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r1 & r16
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r0) goto L_0x0103
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f1
            goto L_0x0103
        L_0x00f1:
            r14.skipToGroupEnd()
            r17 = r1
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r15 = r3
            goto L_0x0208
        L_0x0103:
            r14.startDefaults()
            r0 = r13 & 1
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x014b
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0114
            goto L_0x014b
        L_0x0114:
            r14.skipToGroupEnd()
            r0 = r36 & 2
            if (r0 == 0) goto L_0x011d
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x011d:
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0123
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0123:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0129
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0129:
            r0 = r36 & 32
            if (r0 == 0) goto L_0x013d
            r0 = r1 & r10
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r11 = r0
            r15 = r3
            goto L_0x01ac
        L_0x013d:
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r11 = r1
            r15 = r3
            goto L_0x01ac
        L_0x014b:
            if (r2 == 0) goto L_0x0152
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0153
        L_0x0152:
            r0 = r3
        L_0x0153:
            r2 = r36 & 2
            r3 = 6
            if (r2 == 0) goto L_0x0161
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r14, r3)
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
            r4 = r2
        L_0x0161:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x0171
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r14, r3)
            long r5 = r2.m1623getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0171:
            r2 = r36 & 8
            if (r2 == 0) goto L_0x017f
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1659contentColorForek8zF_U(r5, r14, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x017f:
            if (r9 == 0) goto L_0x0188
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1748getModalDrawerElevationD9Ej5fM()
            r11 = r2
        L_0x0188:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x01a0
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r14, r3)
            r1 = r1 & r10
            r15 = r0
            r24 = r2
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r11 = r1
            goto L_0x01ac
        L_0x01a0:
            r18 = r4
            r19 = r5
            r21 = r7
            r23 = r11
            r24 = r15
            r15 = r0
            r11 = r1
        L_0x01ac:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01be
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)"
            r2 = 1001163336(0x3bac8a48, float:0.005265508)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x01be:
            int r0 = r11 >> 15
            r0 = r0 & 14
            int r1 = r11 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r11 << 3
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r11 << 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r0 = r0 | r1
            r1 = r11 & r17
            r10 = r0 | r1
            r16 = 0
            r0 = r24
            r1 = r15
            r2 = r18
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r33
            r9 = r14
            r17 = r11
            r11 = r16
            m1874DrawerSheetvywBR7E(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0208
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0208:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x020f
            goto L_0x022f
        L_0x020f:
            androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1 r16 = new androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
            r0 = r16
            r1 = r15
            r2 = r18
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r24
            r9 = r33
            r10 = r35
            r12 = r11
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x022f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1875ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0108  */
    /* renamed from: DismissibleDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1873DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r33
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)494@18990L11,495@19043L37,497@19204L12,500@19274L183:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r25
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r25
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r25
        L_0x0035:
            r4 = r36 & 2
            if (r4 == 0) goto L_0x003e
            r1 = r1 | 48
            r5 = r26
            goto L_0x0053
        L_0x003e:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r26
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r1 = r1 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r26
        L_0x0053:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006c
            r6 = r36 & 4
            if (r6 != 0) goto L_0x0066
            r6 = r27
            boolean r8 = r14.changed((long) r6)
            if (r8 == 0) goto L_0x0068
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r6 = r27
        L_0x0068:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r8
            goto L_0x006e
        L_0x006c:
            r6 = r27
        L_0x006e:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0087
            r8 = r36 & 8
            if (r8 != 0) goto L_0x0081
            r8 = r29
            boolean r10 = r14.changed((long) r8)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0081:
            r8 = r29
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r8 = r29
        L_0x0089:
            r10 = r36 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r31
            goto L_0x00ab
        L_0x0095:
            r15 = r13 & r11
            if (r15 != 0) goto L_0x00a9
            r15 = r31
            boolean r16 = r14.changed((float) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r31
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r16
            if (r17 != 0) goto L_0x00c7
            r17 = r36 & 32
            if (r17 != 0) goto L_0x00c0
            r11 = r32
            boolean r17 = r14.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00c2
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r11 = r32
        L_0x00c2:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r17
            goto L_0x00c9
        L_0x00c7:
            r11 = r32
        L_0x00c9:
            r17 = r36 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00d4
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00e4
        L_0x00d4:
            r17 = r13 & r18
            if (r17 != 0) goto L_0x00e4
            boolean r17 = r14.changedInstance(r12)
            if (r17 == 0) goto L_0x00e1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00e1:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d1
        L_0x00e4:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0108
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f5
            goto L_0x0108
        L_0x00f5:
            r14.skipToGroupEnd()
            r18 = r1
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r25
            goto L_0x0203
        L_0x0108:
            r14.startDefaults()
            r0 = r13 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x014c
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0119
            goto L_0x014c
        L_0x0119:
            r14.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0122
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0122:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0128
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0128:
            r0 = r36 & 32
            if (r0 == 0) goto L_0x013d
            r0 = r1 & r3
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r25
            r11 = r0
            goto L_0x01a8
        L_0x013d:
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r25
            r11 = r1
            goto L_0x01a8
        L_0x014c:
            if (r2 == 0) goto L_0x0153
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0153:
            r0 = r25
        L_0x0155:
            if (r4 == 0) goto L_0x015c
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r2
        L_0x015c:
            r2 = r36 & 4
            r4 = 6
            if (r2 == 0) goto L_0x016d
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r14, r4)
            long r6 = r2.m1623getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x016d:
            r2 = r36 & 8
            if (r2 == 0) goto L_0x017b
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1659contentColorForek8zF_U(r6, r14, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x017b:
            if (r10 == 0) goto L_0x0184
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1746getDismissibleDrawerElevationD9Ej5fM()
            r15 = r2
        L_0x0184:
            r2 = r36 & 32
            if (r2 == 0) goto L_0x019c
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r14, r4)
            r1 = r1 & r3
            r11 = r1
            r24 = r2
            r17 = r5
            r19 = r6
            r21 = r8
            r23 = r15
            r15 = r0
            goto L_0x01a8
        L_0x019c:
            r17 = r5
            r19 = r6
            r21 = r8
            r24 = r11
            r23 = r15
            r15 = r0
            r11 = r1
        L_0x01a8:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ba
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)"
            r2 = -588600583(0xffffffffdceaaaf9, float:-5.28425048E17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x01ba:
            int r0 = r11 >> 15
            r0 = r0 & 14
            int r1 = r11 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r11 << 3
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r11 << 3
            r1 = r1 & r16
            r0 = r0 | r1
            r1 = r11 & r18
            r10 = r0 | r1
            r16 = 0
            r0 = r24
            r1 = r15
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r33
            r9 = r14
            r18 = r11
            r11 = r16
            m1874DrawerSheetvywBR7E(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0203
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0203:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x020a
            goto L_0x022a
        L_0x020a:
            androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1 r16 = new androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
            r0 = r16
            r1 = r15
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r24
            r9 = r33
            r10 = r35
            r12 = r11
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1873DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0108  */
    /* renamed from: PermanentDrawerSheet-afqeVBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1877PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier r26, androidx.compose.ui.graphics.Shape r27, long r28, long r30, float r32, androidx.compose.foundation.layout.WindowInsets r33, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r12 = r34
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            r1 = r35
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)531@20618L11,532@20671L37,534@20830L12,537@20921L33,540@21021L50,538@20959L244:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r36
            r2 = r37 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r3 = r26
            goto L_0x0035
        L_0x0022:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x0033
            r3 = r26
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0030
            r4 = 4
            goto L_0x0031
        L_0x0030:
            r4 = 2
        L_0x0031:
            r1 = r1 | r4
            goto L_0x0035
        L_0x0033:
            r3 = r26
        L_0x0035:
            r4 = r37 & 2
            if (r4 == 0) goto L_0x003e
            r1 = r1 | 48
            r5 = r27
            goto L_0x0053
        L_0x003e:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r1 = r1 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r27
        L_0x0053:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006c
            r6 = r37 & 4
            if (r6 != 0) goto L_0x0066
            r6 = r28
            boolean r8 = r14.changed((long) r6)
            if (r8 == 0) goto L_0x0068
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r6 = r28
        L_0x0068:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r8
            goto L_0x006e
        L_0x006c:
            r6 = r28
        L_0x006e:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0087
            r8 = r37 & 8
            if (r8 != 0) goto L_0x0081
            r8 = r30
            boolean r10 = r14.changed((long) r8)
            if (r10 == 0) goto L_0x0083
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0081:
            r8 = r30
        L_0x0083:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r10
            goto L_0x0089
        L_0x0087:
            r8 = r30
        L_0x0089:
            r10 = r37 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r32
            goto L_0x00ab
        L_0x0095:
            r15 = r13 & r11
            if (r15 != 0) goto L_0x00a9
            r15 = r32
            boolean r16 = r14.changed((float) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r1 = r1 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r32
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r16
            if (r17 != 0) goto L_0x00c7
            r17 = r37 & 32
            if (r17 != 0) goto L_0x00c0
            r11 = r33
            boolean r17 = r14.changed((java.lang.Object) r11)
            if (r17 == 0) goto L_0x00c2
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r11 = r33
        L_0x00c2:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r17
            goto L_0x00c9
        L_0x00c7:
            r11 = r33
        L_0x00c9:
            r17 = r37 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00d4
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00e4
        L_0x00d4:
            r17 = r13 & r18
            if (r17 != 0) goto L_0x00e4
            boolean r17 = r14.changedInstance(r12)
            if (r17 == 0) goto L_0x00e1
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00e1:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d1
        L_0x00e4:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0108
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f5
            goto L_0x0108
        L_0x00f5:
            r14.skipToGroupEnd()
            r16 = r1
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r26
            goto L_0x024c
        L_0x0108:
            r14.startDefaults()
            r0 = r13 & 1
            r3 = 6
            if (r0 == 0) goto L_0x014c
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0117
            goto L_0x014c
        L_0x0117:
            r14.skipToGroupEnd()
            r0 = r37 & 4
            if (r0 == 0) goto L_0x0120
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0120:
            r0 = r37 & 8
            if (r0 == 0) goto L_0x0126
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0126:
            r0 = r37 & 32
            if (r0 == 0) goto L_0x013d
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r26
            r11 = r0
            goto L_0x01aa
        L_0x013d:
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r26
            r11 = r1
            goto L_0x01aa
        L_0x014c:
            if (r2 == 0) goto L_0x0153
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0155
        L_0x0153:
            r0 = r26
        L_0x0155:
            if (r4 == 0) goto L_0x015c
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r2
        L_0x015c:
            r2 = r37 & 4
            if (r2 == 0) goto L_0x016c
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r14, r3)
            long r6 = r2.m1623getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x016c:
            r2 = r37 & 8
            if (r2 == 0) goto L_0x017a
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1659contentColorForek8zF_U(r6, r14, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x017a:
            if (r10 == 0) goto L_0x0183
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1749getPermanentDrawerElevationD9Ej5fM()
            r15 = r2
        L_0x0183:
            r2 = r37 & 32
            if (r2 == 0) goto L_0x019e
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r14, r3)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            r11 = r1
            r25 = r2
            r17 = r5
            r20 = r6
            r22 = r8
            r24 = r15
            r15 = r0
            goto L_0x01aa
        L_0x019e:
            r17 = r5
            r20 = r6
            r22 = r8
            r25 = r11
            r24 = r15
            r15 = r0
            r11 = r1
        L_0x01aa:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01bc
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)"
            r2 = -1733353241(0xffffffff98af20e7, float:-4.5269663E-24)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
        L_0x01bc:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m2033getNavigationMenuadMyvUU()
            java.lang.String r10 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r14, r3)
            r0 = 0
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r2 = r14.changed((java.lang.Object) r10)
            r3 = r14
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x01ec
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x01ea
            goto L_0x01ec
        L_0x01ea:
            r7 = r5
            goto L_0x01f9
        L_0x01ec:
            r7 = 0
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1 r8 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
            r8.<init>(r10)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r7 = r8
            r3.updateRememberedValue(r7)
        L_0x01f9:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0 = 0
            r1 = 0
            r2 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r15, r1, r7, r2, r0)
            int r0 = r11 >> 15
            r0 = r0 & 14
            int r2 = r11 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r11 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r11 << 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r3
            r0 = r0 | r2
            int r2 = r11 << 3
            r2 = r2 & r16
            r0 = r0 | r2
            r2 = r11 & r18
            r16 = r0 | r2
            r18 = 0
            r0 = r25
            r2 = r17
            r3 = r20
            r5 = r22
            r7 = r24
            r8 = r34
            r9 = r14
            r19 = r10
            r10 = r16
            r16 = r11
            r11 = r18
            m1874DrawerSheetvywBR7E(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x024c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x024c:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0253
            goto L_0x0273
        L_0x0253:
            androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2 r18 = new androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
            r0 = r18
            r1 = r15
            r2 = r17
            r3 = r20
            r5 = r22
            r7 = r24
            r8 = r25
            r9 = r34
            r10 = r36
            r12 = r11
            r11 = r37
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0273:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1877PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0100  */
    /* renamed from: DrawerSheet-vywBR7E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1874DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r28
            r13 = r36
            r14 = r38
            r0 = 175072821(0xa6f6635, float:1.15266544E-32)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DrawerSheet)P(6,5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp)556@21400L11,557@21453L37,561@21620L667:NavigationDrawer.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            goto L_0x002b
        L_0x001d:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r11.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
        L_0x002b:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            r3 = r29
            goto L_0x0049
        L_0x0034:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0047
            r3 = r29
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r29
        L_0x0049:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x0052
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r30
            goto L_0x0067
        L_0x0052:
            r5 = r14 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0065
            r5 = r30
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0061
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r6
            goto L_0x0067
        L_0x0065:
            r5 = r30
        L_0x0067:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0080
            r6 = r39 & 8
            if (r6 != 0) goto L_0x007a
            r6 = r31
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x007c
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007a:
            r6 = r31
        L_0x007c:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r1 = r1 | r8
            goto L_0x0082
        L_0x0080:
            r6 = r31
        L_0x0082:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r14 & r8
            if (r9 != 0) goto L_0x009e
            r9 = r39 & 16
            if (r9 != 0) goto L_0x0098
            r9 = r33
            boolean r15 = r11.changed((long) r9)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r9 = r33
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r1 = r1 | r15
            goto L_0x00a0
        L_0x009e:
            r9 = r33
        L_0x00a0:
            r15 = r39 & 32
            if (r15 == 0) goto L_0x00ab
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r8 = r35
            goto L_0x00c3
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00c1
            r8 = r35
            boolean r16 = r11.changed((float) r8)
            if (r16 == 0) goto L_0x00bc
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r1 = r1 | r16
            goto L_0x00c3
        L_0x00c1:
            r8 = r35
        L_0x00c3:
            r16 = r39 & 64
            if (r16 == 0) goto L_0x00cc
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c9:
            r1 = r1 | r16
            goto L_0x00de
        L_0x00cc:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00de
            boolean r16 = r11.changedInstance(r13)
            if (r16 == 0) goto L_0x00db
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c9
        L_0x00db:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c9
        L_0x00de:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0100
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00ef
            goto L_0x0100
        L_0x00ef:
            r11.skipToGroupEnd()
            r15 = r29
            r22 = r1
            r16 = r5
            r17 = r6
            r21 = r8
            r19 = r9
            goto L_0x01ef
        L_0x0100:
            r11.startDefaults()
            r0 = r14 & 1
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0127
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0111
            goto L_0x0127
        L_0x0111:
            r11.skipToGroupEnd()
            r0 = r39 & 8
            if (r0 == 0) goto L_0x011a
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x011a:
            r0 = r39 & 16
            if (r0 == 0) goto L_0x0124
            r0 = r1 & r3
            r1 = r0
            r0 = r29
            goto L_0x015e
        L_0x0124:
            r0 = r29
            goto L_0x015e
        L_0x0127:
            if (r2 == 0) goto L_0x012e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0130
        L_0x012e:
            r0 = r29
        L_0x0130:
            if (r4 == 0) goto L_0x0137
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r2
        L_0x0137:
            r2 = r39 & 8
            if (r2 == 0) goto L_0x0148
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material3.ColorScheme r2 = r2.getColorScheme(r11, r4)
            long r6 = r2.m1623getSurface0d7_KjU()
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0148:
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0155
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r9 = androidx.compose.material3.ColorSchemeKt.m1659contentColorForek8zF_U(r6, r11, r2)
            r1 = r1 & r3
        L_0x0155:
            if (r15 == 0) goto L_0x015e
            androidx.compose.material3.DrawerDefaults r2 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r2 = r2.m1749getPermanentDrawerElevationD9Ej5fM()
            r8 = r2
        L_0x015e:
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0170
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)"
            r4 = 175072821(0xa6f6635, float:1.15266544E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x0170:
            float r2 = MinimumDrawerWidth
            androidx.compose.material3.DrawerDefaults r3 = androidx.compose.material3.DrawerDefaults.INSTANCE
            float r3 = r3.m1747getMaximumDrawerWidthD9Ej5fM()
            r4 = 10
            r15 = 0
            r16 = 0
            r17 = 0
            r29 = r0
            r30 = r2
            r31 = r16
            r32 = r3
            r33 = r17
            r34 = r4
            r35 = r15
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m616sizeInqDBjuR0$default(r29, r30, r31, r32, r33, r34, r35)
            r3 = 0
            r4 = 0
            r15 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r2, r3, r15, r4)
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1 r3 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
            r3.<init>(r12, r13, r1)
            r4 = 959363152(0x392eb850, float:1.6662595E-4)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r4, r15, r3)
            r24 = r3
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r4
            int r4 = r1 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            int r4 = r1 >> 3
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            int r4 = r1 >> 3
            r15 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r15
            r26 = r3 | r4
            r22 = 0
            r23 = 0
            r27 = 96
            r15 = r2
            r16 = r5
            r17 = r6
            r19 = r9
            r21 = r8
            r25 = r11
            androidx.compose.material3.SurfaceKt.m2062SurfaceT9BRK9s(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01e4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01e4:
            r15 = r0
            r22 = r1
            r16 = r5
            r17 = r6
            r21 = r8
            r19 = r9
        L_0x01ef:
            androidx.compose.runtime.ScopeUpdateScope r10 = r11.endRestartGroup()
            if (r10 != 0) goto L_0x01f8
            r24 = r11
            goto L_0x021a
        L_0x01f8:
            androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2 r23 = new androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
            r0 = r23
            r1 = r28
            r2 = r15
            r3 = r16
            r4 = r17
            r6 = r19
            r8 = r21
            r9 = r36
            r12 = r10
            r10 = r38
            r24 = r11
            r11 = r39
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x021a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1874DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void NavigationDrawerItem(Function2<? super Composer, ? super Integer, Unit> label, boolean selected, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> badge, Shape shape, NavigationDrawerItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Function2 icon2;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource;
        MutableInteractionSource interactionSource2;
        NavigationDrawerItemColors colors2;
        Shape shape3;
        Function2 badge2;
        Function2 icon3;
        Modifier modifier2;
        int $dirty;
        Shape shape4;
        Function2 badge3;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        NavigationDrawerItemColors colors3;
        NavigationDrawerItemColors colors4;
        MutableInteractionSource mutableInteractionSource2;
        int i2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function2 = label;
        boolean z = selected;
        Function0<Unit> function0 = onClick;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function2, "label");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation($composer2, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)657@25365L9,658@25446L8,659@25506L39,668@25818L24,661@25554L1233:NavigationDrawer.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i6 = i5 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            Modifier modifier4 = modifier;
        } else if ((i4 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 2048 : 1024;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i5 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            icon2 = icon;
        } else if ((i4 & 57344) == 0) {
            icon2 = icon;
            $dirty2 |= $composer2.changedInstance(icon2) ? 16384 : 8192;
        } else {
            icon2 = icon;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function22 = badge;
        } else if ((458752 & i4) == 0) {
            $dirty2 |= $composer2.changedInstance(badge) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = badge;
        }
        if ((3670016 & i4) == 0) {
            if ((i5 & 64) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                shape2 = shape;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            shape2 = shape;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) != 0) {
                NavigationDrawerItemColors navigationDrawerItemColors = colors;
            } else if ($composer2.changed((Object) colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            NavigationDrawerItemColors navigationDrawerItemColors2 = colors;
        }
        int i9 = i5 & 256;
        if (i9 != 0) {
            $dirty2 |= 100663296;
            mutableInteractionSource = interactionSource;
        } else if ((i4 & 234881024) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed((Object) mutableInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    icon2 = null;
                }
                if (i8 != 0) {
                    badge3 = null;
                } else {
                    badge3 = badge;
                }
                if ((i5 & 64) != 0) {
                    shape4 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), $composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    shape4 = shape2;
                }
                if ((i5 & 128) != 0) {
                    colors4 = NavigationDrawerItemDefaults.INSTANCE.m1872colorsoq7We08(0, 0, 0, 0, 0, 0, 0, 0, $composer2, 100663296, 255);
                    $dirty2 &= -29360129;
                } else {
                    colors4 = colors;
                }
                if (i9 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource2);
                    } else {
                        mutableInteractionSource2 = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    $dirty = $dirty3;
                    interactionSource3 = mutableInteractionSource2;
                    colors3 = colors4;
                } else {
                    $dirty = $dirty2;
                    interactionSource3 = interactionSource;
                    colors3 = colors4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i5 & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i5 & 128) != 0) {
                    modifier3 = modifier;
                    badge3 = badge;
                    $dirty = $dirty2 & -29360129;
                    interactionSource3 = mutableInteractionSource;
                    shape4 = shape2;
                    colors3 = colors;
                } else {
                    modifier3 = modifier;
                    badge3 = badge;
                    colors3 = colors;
                    $dirty = $dirty2;
                    interactionSource3 = mutableInteractionSource;
                    shape4 = shape2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304626543, $dirty, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
            }
            SurfaceKt.m2063Surfaced85dljk(selected, onClick, SizeKt.fillMaxWidth$default(SizeKt.m598height3ABfNKs(SemanticsModifierKt.semantics$default(modifier3, false, NavigationDrawerKt$NavigationDrawerItem$2.INSTANCE, 1, (Object) null), NavigationDrawerTokens.INSTANCE.m2570getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, (Object) null), false, shape4, colors3.containerColor(z, $composer2, (($dirty >> 3) & 14) | (($dirty >> 18) & 112)).getValue().m3263unboximpl(), 0, 0.0f, 0.0f, (BorderStroke) null, interactionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 191488423, true, new NavigationDrawerKt$NavigationDrawerItem$3(icon2, colors3, selected, $dirty, badge3, label)), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 57344), (($dirty >> 24) & 14) | 48, 968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors2 = colors3;
            interactionSource2 = interactionSource3;
            modifier2 = modifier3;
            badge2 = badge3;
            shape3 = shape4;
            int i10 = $dirty;
            icon3 = icon2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            colors2 = colors;
            int i11 = $dirty2;
            interactionSource2 = mutableInteractionSource;
            shape3 = shape2;
            badge2 = badge;
            icon3 = icon2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new NavigationDrawerKt$NavigationDrawerItem$4(label, selected, onClick, modifier2, icon3, badge2, shape3, colors2, interactionSource2, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a5  */
    /* renamed from: Scrim-Bx497Mc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1878ScrimBx497Mc(boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, kotlin.jvm.functions.Function0<java.lang.Float> r24, long r25, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r12 = r28
            r0 = 2106487387(0x7d8e725b, float:2.3668018E37)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)848@32851L30,864@33295L51,860@33204L142:NavigationDrawer.kt#uh7d8r"
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
            java.lang.String r2 = "androidx.compose.material3.Scrim (NavigationDrawer.kt:842)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r1, r2)
        L_0x0077:
            androidx.compose.material3.Strings$Companion r0 = androidx.compose.material3.Strings.Companion
            int r0 = r0.m1995getCloseDraweradMyvUU()
            r1 = 6
            java.lang.String r0 = androidx.compose.material3.Strings_androidKt.m2053getStringNWtq28(r0, r13, r1)
            r1 = -1858703321(0xffffffff91367027, float:-1.4391828E-28)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "851@32970L35,852@33054L108"
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
            androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$1$1 r2 = new androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$1$1
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
            androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1 r3 = new androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1
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
            androidx.compose.material3.NavigationDrawerKt$Scrim$1$1 r0 = new androidx.compose.material3.NavigationDrawerKt$Scrim$1$1
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
            androidx.compose.material3.NavigationDrawerKt$Scrim$2 r16 = new androidx.compose.material3.NavigationDrawerKt$Scrim$2
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1878ScrimBx497Mc(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, long, androidx.compose.runtime.Composer, int):void");
    }
}
