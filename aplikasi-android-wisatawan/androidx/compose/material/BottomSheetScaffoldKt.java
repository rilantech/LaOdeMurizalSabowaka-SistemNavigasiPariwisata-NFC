package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2-\u0010\u000b\u001a)\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aá\u0002\u0010\"\u001a\u00020\u00062\u001c\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020%2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u00012 \b\u0002\u0010.\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u00012\b\b\u0002\u00102\u001a\u00020\u00182\b\b\u0002\u00103\u001a\u00020\u00182\b\b\u0002\u00104\u001a\u00020\u00182\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u00182\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120;2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0002\u001aÈ\u0001\u0010>\u001a\u00020\u00062\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2&\u0010?\u001a\"\u0012\u0013\u0012\u001107¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e2&\u0010A\u001a\"\u0012\u0013\u0012\u00110B¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u001e2\u0013\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010'¢\u0006\u0002\b\u001e2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00060'¢\u0006\u0002\b\u001e2\u0006\u0010-\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130'2\u0006\u0010E\u001a\u00020\bH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a4\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00122\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130K2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\fH\u0007\u001a>\u0010M\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010N\u001a\u00020O2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130K2\u0014\b\u0002\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\fH\u0007\u001a\u001c\u0010Q\u001a\u00020R2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030S2\u0006\u0010T\u001a\u00020UH\u0002\u001a+\u0010V\u001a\u00020%2\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020\b2\b\b\u0002\u0010Z\u001a\u00020)H\u0007¢\u0006\u0002\u0010[\u001a;\u0010\\\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u00122\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130K2\u0014\b\u0002\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\fH\u0007¢\u0006\u0002\u0010]\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006^"}, d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "calculateAnchors", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "sheetSize", "", "Landroidx/compose/material/BottomSheetValue;", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-0cLKjW4", "(Landroidx/compose/material/BottomSheetState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;FJJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldAnchorChangeCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILkotlin/jvm/functions/Function0;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "BottomSheetState", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* access modifiers changed from: private */
    public static final float BottomSheetScaffoldPositionalThreshold = Dp.m5844constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final float BottomSheetScaffoldVelocityThreshold = Dp.m5844constructorimpl((float) 125);
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m5844constructorimpl((float) 16);

    public static /* synthetic */ BottomSheetState BottomSheetScaffoldState$default(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        return BottomSheetScaffoldState(bottomSheetValue, animationSpec, function1);
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "BottomSheetScaffoldState(initialValue, animationSpec, confirmStateChange)", imports = {}))
    public static final BottomSheetState BottomSheetScaffoldState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        return new BottomSheetState(initialValue, animationSpec, confirmStateChange);
    }

    public static /* synthetic */ BottomSheetState BottomSheetState$default(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = BottomSheetScaffoldKt$BottomSheetState$1.INSTANCE;
        }
        return BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }

    public static final BottomSheetState BottomSheetState(BottomSheetValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmValueChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        BottomSheetState it = new BottomSheetState(initialValue, animationSpec, confirmValueChange);
        it.setDensity$material_release(density);
        return it;
    }

    public static final BottomSheetState rememberBottomSheetState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetState)P(2)308@11241L7,309@11260L433:BottomSheetScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BottomSheetValue, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 4) != 0) {
            confirmStateChange2 = BottomSheetScaffoldKt$rememberBottomSheetState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:303)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2}, BottomSheetState.Companion.Saver(animationSpec2, confirmStateChange2, density), (String) null, new BottomSheetScaffoldKt$rememberBottomSheetState$2(initialValue, density, animationSpec2, confirmStateChange2), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)P(1)351@12567L39,352@12649L35,353@12729L32,355@12803L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, (AnimationSpec<Float>) null, (Function1<? super BottomSheetValue, Boolean>) null, $composer, 6, 6);
        }
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:350)");
        }
        int i2 = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) drawerState) | $composer.changed((Object) bottomSheetState) | $composer.changed((Object) snackbarHostState);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: BottomSheetScaffold-bGncdBI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1195BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, androidx.compose.material.BottomSheetScaffoldState r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, int r75, boolean r76, androidx.compose.ui.graphics.Shape r77, float r78, long r79, long r81, float r83, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, boolean r85, androidx.compose.ui.graphics.Shape r86, float r87, long r88, long r90, long r92, long r94, long r96, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r98, androidx.compose.runtime.Composer r99, int r100, int r101, int r102, int r103) {
        /*
            r15 = r69
            r13 = r98
            r14 = r100
            r11 = r101
            r12 = r102
            r10 = r103
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 46422755(0x2c45ae3, float:2.8851778E-37)
            r1 = r99
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)417@16492L34,423@16861L6,425@16992L6,426@17039L37,430@17296L6,432@17411L6,433@17459L38,434@17544L10,435@17599L6,436@17644L32,*447@18055L7,499@20525L713:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = r100
            r1 = r101
            r2 = r102
            r3 = r10 & 1
            if (r3 == 0) goto L_0x0032
            r0 = r0 | 6
            goto L_0x0040
        L_0x0032:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0040
            boolean r3 = r9.changedInstance(r15)
            if (r3 == 0) goto L_0x003e
            r3 = 4
            goto L_0x003f
        L_0x003e:
            r3 = 2
        L_0x003f:
            r0 = r0 | r3
        L_0x0040:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0049
            r0 = r0 | 48
            r8 = r70
            goto L_0x005f
        L_0x0049:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x005d
            r8 = r70
            boolean r16 = r9.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x0058
            r16 = 32
            goto L_0x005a
        L_0x0058:
            r16 = 16
        L_0x005a:
            r0 = r0 | r16
            goto L_0x005f
        L_0x005d:
            r8 = r70
        L_0x005f:
            r4 = r14 & 896(0x380, float:1.256E-42)
            r16 = 128(0x80, float:1.794E-43)
            r17 = 256(0x100, float:3.59E-43)
            if (r4 != 0) goto L_0x007d
            r4 = r10 & 4
            if (r4 != 0) goto L_0x0076
            r4 = r71
            boolean r18 = r9.changed((java.lang.Object) r4)
            if (r18 == 0) goto L_0x0078
            r18 = r17
            goto L_0x007a
        L_0x0076:
            r4 = r71
        L_0x0078:
            r18 = r16
        L_0x007a:
            r0 = r0 | r18
            goto L_0x007f
        L_0x007d:
            r4 = r71
        L_0x007f:
            r18 = r10 & 8
            r19 = 2048(0x800, float:2.87E-42)
            r20 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x008c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r5 = r72
            goto L_0x00a2
        L_0x008c:
            r5 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x00a0
            r5 = r72
            boolean r22 = r9.changedInstance(r5)
            if (r22 == 0) goto L_0x009b
            r22 = r19
            goto L_0x009d
        L_0x009b:
            r22 = r20
        L_0x009d:
            r0 = r0 | r22
            goto L_0x00a2
        L_0x00a0:
            r5 = r72
        L_0x00a2:
            r22 = r10 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            if (r22 == 0) goto L_0x00af
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r7 = r73
            goto L_0x00c8
        L_0x00af:
            r25 = 57344(0xe000, float:8.0356E-41)
            r25 = r14 & r25
            if (r25 != 0) goto L_0x00c6
            r7 = r73
            boolean r26 = r9.changedInstance(r7)
            if (r26 == 0) goto L_0x00c1
            r26 = r23
            goto L_0x00c3
        L_0x00c1:
            r26 = r24
        L_0x00c3:
            r0 = r0 | r26
            goto L_0x00c8
        L_0x00c6:
            r7 = r73
        L_0x00c8:
            r26 = r10 & 32
            r27 = 131072(0x20000, float:1.83671E-40)
            if (r26 == 0) goto L_0x00d5
            r28 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r28
            r6 = r74
            goto L_0x00ed
        L_0x00d5:
            r28 = 458752(0x70000, float:6.42848E-40)
            r28 = r14 & r28
            if (r28 != 0) goto L_0x00eb
            r6 = r74
            boolean r29 = r9.changedInstance(r6)
            if (r29 == 0) goto L_0x00e6
            r29 = r27
            goto L_0x00e8
        L_0x00e6:
            r29 = 65536(0x10000, float:9.18355E-41)
        L_0x00e8:
            r0 = r0 | r29
            goto L_0x00ed
        L_0x00eb:
            r6 = r74
        L_0x00ed:
            r29 = r10 & 64
            r30 = 1048576(0x100000, float:1.469368E-39)
            r31 = 524288(0x80000, float:7.34684E-40)
            if (r29 == 0) goto L_0x00fc
            r32 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r32
            r6 = r75
            goto L_0x0114
        L_0x00fc:
            r32 = 3670016(0x380000, float:5.142788E-39)
            r32 = r14 & r32
            if (r32 != 0) goto L_0x0112
            r6 = r75
            boolean r32 = r9.changed((int) r6)
            if (r32 == 0) goto L_0x010d
            r32 = r30
            goto L_0x010f
        L_0x010d:
            r32 = r31
        L_0x010f:
            r0 = r0 | r32
            goto L_0x0114
        L_0x0112:
            r6 = r75
        L_0x0114:
            r6 = r10 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0121
            r32 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r32
            r32 = r6
            r6 = r76
            goto L_0x013d
        L_0x0121:
            r32 = 29360128(0x1c00000, float:7.052966E-38)
            r32 = r14 & r32
            if (r32 != 0) goto L_0x0139
            r32 = r6
            r6 = r76
            boolean r33 = r9.changed((boolean) r6)
            if (r33 == 0) goto L_0x0134
            r33 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0136
        L_0x0134:
            r33 = 4194304(0x400000, float:5.877472E-39)
        L_0x0136:
            r0 = r0 | r33
            goto L_0x013d
        L_0x0139:
            r32 = r6
            r6 = r76
        L_0x013d:
            r33 = 234881024(0xe000000, float:1.5777218E-30)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x0159
            r4 = r10 & 256(0x100, float:3.59E-43)
            if (r4 != 0) goto L_0x0152
            r4 = r77
            boolean r33 = r9.changed((java.lang.Object) r4)
            if (r33 == 0) goto L_0x0154
            r33 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0156
        L_0x0152:
            r4 = r77
        L_0x0154:
            r33 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0156:
            r0 = r0 | r33
            goto L_0x015b
        L_0x0159:
            r4 = r77
        L_0x015b:
            r6 = r10 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0168
            r33 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r33
            r33 = r6
            r6 = r78
            goto L_0x0184
        L_0x0168:
            r33 = 1879048192(0x70000000, float:1.58456325E29)
            r33 = r14 & r33
            if (r33 != 0) goto L_0x0180
            r33 = r6
            r6 = r78
            boolean r34 = r9.changed((float) r6)
            if (r34 == 0) goto L_0x017b
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x017d
        L_0x017b:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x017d:
            r0 = r0 | r34
            goto L_0x0184
        L_0x0180:
            r33 = r6
            r6 = r78
        L_0x0184:
            r34 = r11 & 14
            if (r34 != 0) goto L_0x019b
            r4 = r10 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x0196
            r6 = r79
            boolean r4 = r9.changed((long) r6)
            if (r4 == 0) goto L_0x0198
            r4 = 4
            goto L_0x0199
        L_0x0196:
            r6 = r79
        L_0x0198:
            r4 = 2
        L_0x0199:
            r1 = r1 | r4
            goto L_0x019d
        L_0x019b:
            r6 = r79
        L_0x019d:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x01b6
            r4 = r10 & 2048(0x800, float:2.87E-42)
            if (r4 != 0) goto L_0x01b0
            r6 = r81
            boolean r4 = r9.changed((long) r6)
            if (r4 == 0) goto L_0x01b2
            r4 = 32
            goto L_0x01b4
        L_0x01b0:
            r6 = r81
        L_0x01b2:
            r4 = 16
        L_0x01b4:
            r1 = r1 | r4
            goto L_0x01b8
        L_0x01b6:
            r6 = r81
        L_0x01b8:
            r4 = r10 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x01c3
            r1 = r1 | 384(0x180, float:5.38E-43)
            r34 = r4
            r4 = r83
            goto L_0x01db
        L_0x01c3:
            r34 = r4
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x01d9
            r4 = r83
            boolean r35 = r9.changed((float) r4)
            if (r35 == 0) goto L_0x01d4
            r35 = r17
            goto L_0x01d6
        L_0x01d4:
            r35 = r16
        L_0x01d6:
            r1 = r1 | r35
            goto L_0x01db
        L_0x01d9:
            r4 = r83
        L_0x01db:
            r6 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x01e4
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r84
            goto L_0x01f8
        L_0x01e4:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x01f6
            r7 = r84
            boolean r35 = r9.changedInstance(r7)
            if (r35 == 0) goto L_0x01f1
            goto L_0x01f3
        L_0x01f1:
            r19 = r20
        L_0x01f3:
            r1 = r1 | r19
            goto L_0x01f8
        L_0x01f6:
            r7 = r84
        L_0x01f8:
            r19 = r6
            r6 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0205
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r20 = r6
            r6 = r85
            goto L_0x0220
        L_0x0205:
            r20 = 57344(0xe000, float:8.0356E-41)
            r20 = r11 & r20
            if (r20 != 0) goto L_0x021c
            r20 = r6
            r6 = r85
            boolean r35 = r9.changed((boolean) r6)
            if (r35 == 0) goto L_0x0217
            goto L_0x0219
        L_0x0217:
            r23 = r24
        L_0x0219:
            r1 = r1 | r23
            goto L_0x0220
        L_0x021c:
            r20 = r6
            r6 = r85
        L_0x0220:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r11 & r23
            if (r23 != 0) goto L_0x023f
            r23 = 32768(0x8000, float:4.5918E-41)
            r23 = r10 & r23
            if (r23 != 0) goto L_0x0238
            r6 = r86
            boolean r23 = r9.changed((java.lang.Object) r6)
            if (r23 == 0) goto L_0x023a
            r23 = r27
            goto L_0x023c
        L_0x0238:
            r6 = r86
        L_0x023a:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x023c:
            r1 = r1 | r23
            goto L_0x0241
        L_0x023f:
            r6 = r86
        L_0x0241:
            r23 = 65536(0x10000, float:9.18355E-41)
            r23 = r10 & r23
            if (r23 == 0) goto L_0x024e
            r24 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r24
            r6 = r87
            goto L_0x0266
        L_0x024e:
            r24 = 3670016(0x380000, float:5.142788E-39)
            r24 = r11 & r24
            if (r24 != 0) goto L_0x0264
            r6 = r87
            boolean r24 = r9.changed((float) r6)
            if (r24 == 0) goto L_0x025f
            r24 = r30
            goto L_0x0261
        L_0x025f:
            r24 = r31
        L_0x0261:
            r1 = r1 | r24
            goto L_0x0266
        L_0x0264:
            r6 = r87
        L_0x0266:
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            r24 = r11 & r24
            if (r24 != 0) goto L_0x0282
            r24 = r10 & r27
            if (r24 != 0) goto L_0x027b
            r6 = r88
            boolean r24 = r9.changed((long) r6)
            if (r24 == 0) goto L_0x027d
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x027f
        L_0x027b:
            r6 = r88
        L_0x027d:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x027f:
            r1 = r1 | r24
            goto L_0x0284
        L_0x0282:
            r6 = r88
        L_0x0284:
            r24 = 234881024(0xe000000, float:1.5777218E-30)
            r24 = r11 & r24
            if (r24 != 0) goto L_0x02a2
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r10 & r24
            if (r24 != 0) goto L_0x029b
            r6 = r90
            boolean r24 = r9.changed((long) r6)
            if (r24 == 0) goto L_0x029d
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x029f
        L_0x029b:
            r6 = r90
        L_0x029d:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x029f:
            r1 = r1 | r24
            goto L_0x02a4
        L_0x02a2:
            r6 = r90
        L_0x02a4:
            r24 = 1879048192(0x70000000, float:1.58456325E29)
            r24 = r11 & r24
            if (r24 != 0) goto L_0x02c0
            r24 = r10 & r31
            if (r24 != 0) goto L_0x02b9
            r6 = r92
            boolean r24 = r9.changed((long) r6)
            if (r24 == 0) goto L_0x02bb
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x02bd
        L_0x02b9:
            r6 = r92
        L_0x02bb:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x02bd:
            r1 = r1 | r24
            goto L_0x02c2
        L_0x02c0:
            r6 = r92
        L_0x02c2:
            r24 = r1
            r1 = r12 & 14
            if (r1 != 0) goto L_0x02de
            r1 = r10 & r30
            if (r1 != 0) goto L_0x02d7
            r6 = r94
            boolean r1 = r9.changed((long) r6)
            if (r1 == 0) goto L_0x02d9
            r21 = 4
            goto L_0x02db
        L_0x02d7:
            r6 = r94
        L_0x02d9:
            r21 = 2
        L_0x02db:
            r2 = r2 | r21
            goto L_0x02e0
        L_0x02de:
            r6 = r94
        L_0x02e0:
            r1 = r12 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x02fb
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r10
            if (r1 != 0) goto L_0x02f4
            r6 = r96
            boolean r1 = r9.changed((long) r6)
            if (r1 == 0) goto L_0x02f6
            r25 = 32
            goto L_0x02f8
        L_0x02f4:
            r6 = r96
        L_0x02f6:
            r25 = 16
        L_0x02f8:
            r2 = r2 | r25
            goto L_0x02fd
        L_0x02fb:
            r6 = r96
        L_0x02fd:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x0305
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0313
        L_0x0305:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0313
            boolean r1 = r9.changedInstance(r13)
            if (r1 == 0) goto L_0x0311
            r16 = r17
        L_0x0311:
            r2 = r2 | r16
        L_0x0313:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r4) goto L_0x0368
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r24 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r4) goto L_0x0368
            r1 = r2 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r1 != r4) goto L_0x0368
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0333
            goto L_0x0368
        L_0x0333:
            r9.skipToGroupEnd()
            r36 = r71
            r38 = r73
            r39 = r74
            r40 = r75
            r41 = r76
            r42 = r77
            r43 = r78
            r44 = r79
            r46 = r81
            r48 = r83
            r49 = r84
            r50 = r85
            r51 = r86
            r52 = r87
            r53 = r88
            r55 = r90
            r57 = r92
            r59 = r94
            r63 = r0
            r64 = r2
            r37 = r5
            r61 = r6
            r35 = r8
            r65 = r24
            goto L_0x0744
        L_0x0368:
            r9.startDefaults()
            r1 = r14 & 1
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r1 == 0) goto L_0x0420
            boolean r1 = r9.getDefaultsInvalid()
            if (r1 == 0) goto L_0x037a
            goto L_0x0420
        L_0x037a:
            r9.skipToGroupEnd()
            r1 = r10 & 4
            if (r1 == 0) goto L_0x0383
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0383:
            r1 = r10 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0389
            r0 = r0 & r16
        L_0x0389:
            r1 = r10 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x038f
            r24 = r24 & -15
        L_0x038f:
            r1 = r10 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0395
            r24 = r24 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0395:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x03a0
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r24 = r24 & r1
        L_0x03a0:
            r1 = r10 & r27
            if (r1 == 0) goto L_0x03a9
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r24 = r24 & r1
        L_0x03a9:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x03b0
            r24 = r24 & r16
        L_0x03b0:
            r1 = r10 & r31
            if (r1 == 0) goto L_0x03b9
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r24 = r24 & r1
        L_0x03b9:
            r1 = r10 & r30
            if (r1 == 0) goto L_0x03bf
            r2 = r2 & -15
        L_0x03bf:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x03f3
            r1 = r2 & -113(0xffffffffffffff8f, float:NaN)
            r4 = r74
            r2 = r75
            r17 = r78
            r28 = r79
            r21 = r81
            r3 = r83
            r18 = r84
            r19 = r85
            r16 = r86
            r20 = r87
            r31 = r88
            r26 = r90
            r33 = r94
            r10 = r0
            r25 = r1
            r35 = r6
            r11 = r24
            r0 = r71
            r1 = r73
            r6 = r76
            r7 = r77
            r23 = r92
            goto L_0x05b6
        L_0x03f3:
            r1 = r73
            r4 = r74
            r17 = r78
            r28 = r79
            r21 = r81
            r3 = r83
            r18 = r84
            r19 = r85
            r16 = r86
            r20 = r87
            r31 = r88
            r26 = r90
            r33 = r94
            r10 = r0
            r25 = r2
            r35 = r6
            r11 = r24
            r0 = r71
            r2 = r75
            r6 = r76
            r7 = r77
            r23 = r92
            goto L_0x05b6
        L_0x0420:
            if (r3 == 0) goto L_0x0427
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = r1
        L_0x0427:
            r1 = r10 & 4
            if (r1 == 0) goto L_0x0448
            r17 = 0
            r21 = 7
            r1 = 0
            r3 = 0
            r4 = 0
            r25 = r2
            r2 = r3
            r3 = r4
            r28 = r34
            r4 = r9
            r5 = r17
            r7 = r32
            r17 = r33
            r6 = r21
            androidx.compose.material.BottomSheetScaffoldState r1 = rememberBottomSheetScaffoldState(r1, r2, r3, r4, r5, r6)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0452
        L_0x0448:
            r25 = r2
            r7 = r32
            r17 = r33
            r28 = r34
            r1 = r71
        L_0x0452:
            if (r18 == 0) goto L_0x0456
            r2 = 0
            goto L_0x0458
        L_0x0456:
            r2 = r72
        L_0x0458:
            if (r22 == 0) goto L_0x0461
            androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt r3 = androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m1266getLambda1$material_release()
            goto L_0x0463
        L_0x0461:
            r3 = r73
        L_0x0463:
            if (r26 == 0) goto L_0x0467
            r4 = 0
            goto L_0x0469
        L_0x0467:
            r4 = r74
        L_0x0469:
            if (r29 == 0) goto L_0x0472
            androidx.compose.material.FabPosition$Companion r5 = androidx.compose.material.FabPosition.Companion
            int r5 = r5.m1318getEnd5ygKITE()
            goto L_0x0474
        L_0x0472:
            r5 = r75
        L_0x0474:
            if (r7 == 0) goto L_0x0478
            r6 = 1
            goto L_0x047a
        L_0x0478:
            r6 = r76
        L_0x047a:
            r7 = r10 & 256(0x100, float:3.59E-43)
            r70 = r1
            r1 = 6
            if (r7 == 0) goto L_0x0490
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r7 = r7.getShapes(r9, r1)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getLarge()
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            r0 = r0 & r16
            goto L_0x0492
        L_0x0490:
            r7 = r77
        L_0x0492:
            if (r17 == 0) goto L_0x049b
            androidx.compose.material.BottomSheetScaffoldDefaults r17 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r17 = r17.m1192getSheetElevationD9Ej5fM()
            goto L_0x049d
        L_0x049b:
            r17 = r78
        L_0x049d:
            r1 = r10 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x04b1
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r72 = r0
            r0 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r9, r0)
            long r0 = r1.m1245getSurface0d7_KjU()
            r24 = r24 & -15
            goto L_0x04b5
        L_0x04b1:
            r72 = r0
            r0 = r79
        L_0x04b5:
            r99 = r2
            r2 = r10 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x04c4
            r2 = r24 & 14
            long r21 = androidx.compose.material.ColorsKt.m1259contentColorForek8zF_U(r0, r9, r2)
            r24 = r24 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x04c6
        L_0x04c4:
            r21 = r81
        L_0x04c6:
            if (r28 == 0) goto L_0x04cf
            androidx.compose.material.BottomSheetScaffoldDefaults r2 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r2 = r2.m1193getSheetPeekHeightD9Ej5fM()
            goto L_0x04d1
        L_0x04cf:
            r2 = r83
        L_0x04d1:
            if (r19 == 0) goto L_0x04d6
            r18 = 0
            goto L_0x04d8
        L_0x04d6:
            r18 = r84
        L_0x04d8:
            if (r20 == 0) goto L_0x04dd
            r19 = 1
            goto L_0x04df
        L_0x04dd:
            r19 = r85
        L_0x04df:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r10 & r20
            if (r20 == 0) goto L_0x04fb
            r28 = r0
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Shapes r0 = r0.getShapes(r9, r1)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getLarge()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r24 = r24 & r1
            goto L_0x04ff
        L_0x04fb:
            r28 = r0
            r0 = r86
        L_0x04ff:
            if (r23 == 0) goto L_0x0508
            androidx.compose.material.DrawerDefaults r1 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r1 = r1.m1281getElevationD9Ej5fM()
            goto L_0x050a
        L_0x0508:
            r1 = r87
        L_0x050a:
            r20 = r10 & r27
            if (r20 == 0) goto L_0x0523
            r73 = r0
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r74 = r1
            r1 = 6
            androidx.compose.material.Colors r0 = r0.getColors(r9, r1)
            long r0 = r0.m1245getSurface0d7_KjU()
            r20 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r24 = r24 & r20
            goto L_0x0529
        L_0x0523:
            r73 = r0
            r74 = r1
            r0 = r88
        L_0x0529:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r10 & r20
            if (r20 == 0) goto L_0x053c
            int r20 = r24 >> 21
            r75 = r2
            r2 = r20 & 14
            long r26 = androidx.compose.material.ColorsKt.m1259contentColorForek8zF_U(r0, r9, r2)
            r24 = r24 & r16
            goto L_0x0540
        L_0x053c:
            r75 = r2
            r26 = r90
        L_0x0540:
            r2 = r10 & r31
            if (r2 == 0) goto L_0x0553
            androidx.compose.material.DrawerDefaults r2 = androidx.compose.material.DrawerDefaults.INSTANCE
            r31 = r0
            r0 = 6
            long r1 = r2.getScrimColor(r9, r0)
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r24 = r24 & r16
            goto L_0x0558
        L_0x0553:
            r31 = r0
            r0 = 6
            r1 = r92
        L_0x0558:
            r16 = r10 & r30
            if (r16 == 0) goto L_0x056b
            r76 = r1
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r0 = r1.getColors(r9, r0)
            long r0 = r0.m1234getBackground0d7_KjU()
            r2 = r25 & -15
            goto L_0x0571
        L_0x056b:
            r76 = r1
            r0 = r94
            r2 = r25
        L_0x0571:
            r16 = 2097152(0x200000, float:2.938736E-39)
            r16 = r10 & r16
            if (r16 == 0) goto L_0x059b
            r71 = r3
            r3 = r2 & 14
            long r33 = androidx.compose.material.ColorsKt.m1259contentColorForek8zF_U(r0, r9, r3)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            r10 = r72
            r16 = r73
            r20 = r74
            r3 = r75
            r25 = r2
            r2 = r5
            r11 = r24
            r35 = r33
            r23 = r76
            r5 = r99
            r33 = r0
            r0 = r70
            r1 = r71
            goto L_0x05b6
        L_0x059b:
            r71 = r3
            r10 = r72
            r16 = r73
            r20 = r74
            r3 = r75
            r35 = r96
            r33 = r0
            r25 = r2
            r2 = r5
            r11 = r24
            r0 = r70
            r1 = r71
            r23 = r76
            r5 = r99
        L_0x05b6:
            r9.endDefaults()
            boolean r30 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r30 == 0) goto L_0x05c7
            r12 = 46422755(0x2c45ae3, float:2.8851778E-37)
            java.lang.String r13 = "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:414)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r10, r11, r13)
        L_0x05c7:
            r12 = 1207995830(0x48008db6, float:131638.84)
            r9.startReplaceableGroup(r12)
            java.lang.String r12 = "441@17907L7,442@17934L72,442@17923L83"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            androidx.compose.material.BottomSheetState r12 = r0.getBottomSheetState()
            androidx.compose.ui.unit.Density r12 = r12.getDensity$material_release()
            if (r12 != 0) goto L_0x0655
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 0
            r30 = 0
            r70 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r14)
            java.lang.Object r13 = r9.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r12 = r13
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            int r13 = r10 >> 6
            r13 = r13 & 14
            r14 = 0
            r70 = r13
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r13)
            boolean r13 = r9.changed((java.lang.Object) r0)
            boolean r30 = r9.changed((java.lang.Object) r12)
            r13 = r13 | r30
            r71 = r9
            r30 = 0
            r72 = r14
            java.lang.Object r14 = r71.rememberedValue()
            r37 = 0
            if (r13 != 0) goto L_0x0635
            androidx.compose.runtime.Composer$Companion r38 = androidx.compose.runtime.Composer.Companion
            r73 = r13
            java.lang.Object r13 = r38.getEmpty()
            if (r14 != r13) goto L_0x062f
            goto L_0x0637
        L_0x062f:
            r74 = r12
            r13 = r14
            r12 = r71
            goto L_0x064a
        L_0x0635:
            r73 = r13
        L_0x0637:
            r13 = 0
            r74 = r13
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1 r13 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
            r13.<init>(r0, r12)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r74 = r12
            r12 = r71
            r12.updateRememberedValue(r13)
        L_0x064a:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r12 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r13, r9, r12)
        L_0x0655:
            r9.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 0
            r14 = 0
            r70 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            r71 = r14
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r13, r14)
            java.lang.Object r13 = r9.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r12 = r13
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            r13 = 0
            float r12 = r12.m5825toPx0680j_4(r3)
            r81 = r12
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1 r13 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1
            r70 = r13
            r71 = r0
            r72 = r5
            r73 = r98
            r74 = r4
            r75 = r3
            r76 = r2
            r77 = r10
            r78 = r25
            r79 = r11
            r80 = r6
            r82 = r7
            r83 = r17
            r84 = r28
            r86 = r21
            r88 = r69
            r89 = r1
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r86, r88, r89)
            r14 = 893101063(0x353ba407, float:6.990162E-7)
            r84 = r1
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r14, r1, r13)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 0
            r85 = r2
            r2 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r8, r14, r1, r2)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2 r14 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r70 = r14
            r71 = r18
            r72 = r13
            r73 = r0
            r74 = r19
            r75 = r16
            r76 = r20
            r77 = r31
            r79 = r26
            r81 = r23
            r83 = r11
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r79, r81, r83)
            r82 = r0
            r0 = 1273816607(0x4bece61f, float:3.1050814E7)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r1, r14)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r25 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            int r14 = r25 << 6
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r14
            r14 = 0
            r30 = 0
            r37 = 0
            r38 = 50
            r70 = r2
            r71 = r14
            r72 = r33
            r74 = r35
            r76 = r30
            r77 = r37
            r78 = r0
            r79 = r9
            r80 = r1
            r81 = r38
            androidx.compose.material.SurfaceKt.m1420SurfaceFjzlyU(r70, r71, r72, r74, r76, r77, r78, r79, r80, r81)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0714
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0714:
            r38 = r84
            r40 = r85
            r48 = r3
            r39 = r4
            r37 = r5
            r41 = r6
            r42 = r7
            r63 = r10
            r65 = r11
            r51 = r16
            r43 = r17
            r49 = r18
            r50 = r19
            r52 = r20
            r46 = r21
            r57 = r23
            r64 = r25
            r55 = r26
            r44 = r28
            r53 = r31
            r59 = r33
            r61 = r35
            r36 = r82
            r35 = r8
        L_0x0744:
            androidx.compose.runtime.ScopeUpdateScope r13 = r9.endRestartGroup()
            if (r13 != 0) goto L_0x074d
            r67 = r9
            goto L_0x0797
        L_0x074d:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$3 r66 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$3
            r0 = r66
            r1 = r69
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r7 = r40
            r8 = r41
            r67 = r9
            r9 = r42
            r10 = r43
            r11 = r44
            r68 = r13
            r13 = r46
            r15 = r48
            r16 = r49
            r17 = r50
            r18 = r51
            r19 = r52
            r20 = r53
            r22 = r55
            r24 = r57
            r26 = r59
            r28 = r61
            r30 = r98
            r31 = r100
            r32 = r101
            r33 = r102
            r34 = r103
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r22, r24, r26, r28, r30, r31, r32, r33, r34)
            r0 = r66
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r68
            r1.updateScope(r0)
        L_0x0797:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1195BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0297  */
    /* renamed from: BottomSheet-0cLKjW4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1194BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState r30, boolean r31, kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.IntSize, ? extends java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float>> r32, androidx.compose.ui.graphics.Shape r33, float r34, long r35, long r37, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r14 = r30
            r15 = r32
            r13 = r40
            r12 = r42
            r11 = r43
            r0 = 1407045933(0x53ddd12d, float:1.90539432E12)
            r1 = r41
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomSheet)P(8,6!1,7,5:c#ui.unit.Dp,3:c#ui.graphics.Color,4:c#ui.graphics.Color,2)536@21671L24,537@21727L92,540@21824L1599:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r42
            r2 = r11 & 1
            if (r2 == 0) goto L_0x0021
            r1 = r1 | 6
            goto L_0x002f
        L_0x0021:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r10.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r1 = r1 | r2
        L_0x002f:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0038
            r1 = r1 | 48
            r8 = r31
            goto L_0x004d
        L_0x0038:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004b
            r8 = r31
            boolean r2 = r10.changed((boolean) r8)
            if (r2 == 0) goto L_0x0047
            r2 = 32
            goto L_0x0049
        L_0x0047:
            r2 = 16
        L_0x0049:
            r1 = r1 | r2
            goto L_0x004d
        L_0x004b:
            r8 = r31
        L_0x004d:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x0054
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0054:
            r2 = r12 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r10.changedInstance(r15)
            if (r2 == 0) goto L_0x0061
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r2
        L_0x0064:
            r2 = r11 & 8
            if (r2 == 0) goto L_0x006d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r33
            goto L_0x0082
        L_0x006d:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0080
            r9 = r33
            boolean r2 = r10.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x007c
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r1 = r1 | r2
            goto L_0x0082
        L_0x0080:
            r9 = r33
        L_0x0082:
            r2 = r11 & 16
            if (r2 == 0) goto L_0x008b
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r34
            goto L_0x00a2
        L_0x008b:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00a0
            r6 = r34
            boolean r2 = r10.changed((float) r6)
            if (r2 == 0) goto L_0x009c
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r1 = r1 | r2
            goto L_0x00a2
        L_0x00a0:
            r6 = r34
        L_0x00a2:
            r2 = r11 & 32
            r3 = 458752(0x70000, float:6.42848E-40)
            if (r2 == 0) goto L_0x00ae
            r2 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r2
            r4 = r35
            goto L_0x00c3
        L_0x00ae:
            r2 = r12 & r3
            if (r2 != 0) goto L_0x00c1
            r4 = r35
            boolean r2 = r10.changed((long) r4)
            if (r2 == 0) goto L_0x00bd
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bf
        L_0x00bd:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x00bf:
            r1 = r1 | r2
            goto L_0x00c3
        L_0x00c1:
            r4 = r35
        L_0x00c3:
            r2 = r11 & 64
            r7 = 1572864(0x180000, float:2.204052E-39)
            if (r2 == 0) goto L_0x00cd
            r1 = r1 | r7
            r3 = r37
            goto L_0x00e3
        L_0x00cd:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00e1
            r3 = r37
            boolean r2 = r10.changed((long) r3)
            if (r2 == 0) goto L_0x00dd
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r1 = r1 | r2
            goto L_0x00e3
        L_0x00e1:
            r3 = r37
        L_0x00e3:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ed
            r5 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r5
            r5 = r39
            goto L_0x0104
        L_0x00ed:
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r12
            if (r5 != 0) goto L_0x0102
            r5 = r39
            boolean r16 = r10.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x00fd
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ff
        L_0x00fd:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ff:
            r1 = r1 | r16
            goto L_0x0104
        L_0x0102:
            r5 = r39
        L_0x0104:
            r7 = r11 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x010c
            r7 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x010a:
            r1 = r1 | r7
            goto L_0x011d
        L_0x010c:
            r7 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r7 & r12
            if (r7 != 0) goto L_0x011d
            boolean r7 = r10.changedInstance(r13)
            if (r7 == 0) goto L_0x011a
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010a
        L_0x011a:
            r7 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x010a
        L_0x011d:
            r7 = r1
            r1 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r1 & r7
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r0) goto L_0x0135
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x012e
            goto L_0x0135
        L_0x012e:
            r10.skipToGroupEnd()
            r16 = r5
            goto L_0x028c
        L_0x0135:
            if (r2 == 0) goto L_0x013c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x013c:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x014b
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:525)"
            r2 = 1407045933(0x53ddd12d, float:1.90539432E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x014b:
            r0 = 0
            r1 = r0
            r2 = 0
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r10
            r16 = 0
            r17 = r16
            r16 = 0
            r18 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = 0
            r19 = r10
            r20 = 0
            r21 = r1
            java.lang.Object r1 = r19.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r25 = r2
            java.lang.Object r2 = r23.getEmpty()
            if (r1 != r2) goto L_0x01a5
            r2 = 0
            r23 = 0
            kotlin.coroutines.EmptyCoroutineContext r23 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r26 = r1
            r1 = r23
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r0)
            r23 = r0
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r0.<init>(r1)
            r1 = r19
            r1.updateRememberedValue(r0)
            goto L_0x01ad
        L_0x01a5:
            r23 = r0
            r26 = r1
            r1 = r19
            r0 = r26
        L_0x01ad:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r0 = r1
            r1 = r7 & 14
            r1 = r1 | 64
            r2 = 0
            r16 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r14)
            boolean r17 = r10.changed((java.lang.Object) r0)
            r1 = r1 | r17
            r17 = r10
            r18 = 0
            r19 = r2
            java.lang.Object r2 = r17.rememberedValue()
            r20 = 0
            if (r1 != 0) goto L_0x01f8
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r1
            java.lang.Object r1 = r21.getEmpty()
            if (r2 != r1) goto L_0x01f2
            goto L_0x01fa
        L_0x01f2:
            r1 = r2
            r21 = r1
            r2 = r17
            goto L_0x0208
        L_0x01f8:
            r22 = r1
        L_0x01fa:
            r1 = 0
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback r1 = BottomSheetScaffoldAnchorChangeCallback(r14, r0)
            r21 = r2
            r2 = r17
            r2.updateRememberedValue(r1)
        L_0x0208:
            r10.endReplaceableGroup()
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback r1 = (androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback) r1
            androidx.compose.material.AnchoredDraggableState r17 = r30.getAnchoredDraggableState$material_release()
            androidx.compose.foundation.gestures.Orientation r18 = androidx.compose.foundation.gestures.Orientation.Vertical
            r22 = 24
            r23 = 0
            r20 = 0
            r21 = 0
            r16 = r5
            r19 = r31
            androidx.compose.ui.Modifier r2 = androidx.compose.material.AnchoredDraggableKt.anchoredDraggable$default(r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1 r3 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1
            r3.<init>(r14, r15, r1)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.OnRemeasuredModifierKt.onSizeChanged(r2, r3)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2 r3 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
            r3.<init>(r14, r0)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 0
            r28 = r0
            r0 = 1
            r29 = r1
            r1 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r1, r3, r0, r4)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3 r1 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
            r1.<init>(r13, r7)
            r2 = 1944994153(0x73ee4169, float:3.7753092E31)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r2, r0, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r7 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r2 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r2
            int r2 = r7 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r7 >> 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r7 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r3
            r26 = r1 | r2
            r22 = 0
            r27 = 16
            r17 = r33
            r18 = r35
            r20 = r37
            r23 = r34
            r24 = r0
            r25 = r10
            androidx.compose.material.SurfaceKt.m1420SurfaceFjzlyU(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x028a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x028a:
            r16 = r5
        L_0x028c:
            androidx.compose.runtime.ScopeUpdateScope r5 = r10.endRestartGroup()
            if (r5 != 0) goto L_0x0297
            r18 = r7
            r19 = r10
            goto L_0x02c0
        L_0x0297:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$4 r17 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$4
            r0 = r17
            r1 = r30
            r2 = r31
            r3 = r32
            r4 = r33
            r14 = r5
            r5 = r34
            r18 = r7
            r6 = r35
            r8 = r37
            r19 = r10
            r10 = r16
            r11 = r40
            r12 = r42
            r13 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x02c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1194BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, float, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w  reason: not valid java name */
    public static final void m1196BottomSheetScaffoldLayoutKCBPh4w(Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> body, Function3<? super Integer, ? super Composer, ? super Integer, Unit> bottomSheet, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, Function2<? super Composer, ? super Integer, Unit> snackbarHost, float sheetPeekHeight, int floatingActionButtonPosition, Function0<Float> sheetOffset, BottomSheetState sheetState, Composer $composer, int $changed) {
        int i;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1621720523);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)612@24340L2821,612@24323L2838:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(topBar) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = topBar;
        }
        if ((i2 & 112) == 0) {
            $dirty |= $composer2.changedInstance(body) ? 32 : 16;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3 = body;
        }
        if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(bottomSheet) ? 256 : 128;
        } else {
            Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32 = bottomSheet;
        }
        if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(floatingActionButton) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = floatingActionButton;
        }
        if ((57344 & i2) == 0) {
            $dirty |= $composer2.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = snackbarHost;
        }
        if ((458752 & i2) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        } else {
            float f = sheetPeekHeight;
        }
        if ((3670016 & i2) == 0) {
            $dirty |= $composer2.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        } else {
            int i3 = floatingActionButtonPosition;
        }
        if ((29360128 & i2) == 0) {
            $dirty |= $composer2.changedInstance(sheetOffset) ? 8388608 : 4194304;
        } else {
            Function0<Float> function0 = sheetOffset;
        }
        if ((234881024 & i2) == 0) {
            $dirty |= $composer2.changed((Object) sheetState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            BottomSheetState bottomSheetState = sheetState;
        }
        if ((191739611 & $dirty) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621720523, $dirty, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:601)");
            }
            Object[] keys$iv = {bottomSheet, sheetOffset, topBar, body, Dp.m5842boximpl(sheetPeekHeight), floatingActionButton, FabPosition.m1310boximpl(floatingActionButtonPosition), snackbarHost, sheetState};
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
                value$iv$iv = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(sheetOffset, topBar, floatingActionButton, floatingActionButtonPosition, sheetPeekHeight, snackbarHost, sheetState, bottomSheet, $dirty, body);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object[] objArr2 = keys$iv;
                Object obj2 = value$iv$iv;
                Composer composer = $this$cache$iv$iv;
                i = 0;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) value$iv$iv, $composer2, i, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty;
            return;
        }
        int i5 = $dirty;
        endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(topBar, body, bottomSheet, floatingActionButton, snackbarHost, sheetPeekHeight, floatingActionButtonPosition, sheetOffset, sheetState, $changed));
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> state, Orientation orientation) {
        return new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(state, orientation);
    }

    /* access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> BottomSheetScaffoldAnchorChangeCallback(BottomSheetState state, CoroutineScope scope) {
        return new BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1(state, scope);
    }
}
