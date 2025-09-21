package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0001\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00120%¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a@\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u00142\b\b\u0002\u0010.\u001a\u00020\u001cH\u0007\u001aH\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u00142\b\b\u0002\u0010.\u001a\u00020\u001cH\u0007\u001a3\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120%2\u0006\u00104\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a9\u00107\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u0014H\u0007¢\u0006\u0002\u00109\u001aE\u00107\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u00142\b\b\u0002\u0010:\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010;\u001aA\u00107\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010:\u001a\u00020\u001c2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u0014H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020,X\u0002"}, d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ModalBottomSheetPositionalThreshold", "ModalBottomSheetVelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetAnchorChangeCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "Landroidx/compose/material/ModalBottomSheetValue;", "Landroidx/compose/material/ModalBottomSheetState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalBottomSheetState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "isSkipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
public final class ModalBottomSheetKt {
    /* access modifiers changed from: private */
    public static final float MaxModalBottomSheetWidth = Dp.m7554constructorimpl((float) 640);
    /* access modifiers changed from: private */
    public static final float ModalBottomSheetPositionalThreshold = Dp.m7554constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final float ModalBottomSheetVelocityThreshold = Dp.m7554constructorimpl((float) 125);

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = ModalBottomSheetKt$ModalBottomSheetState$1.INSTANCE;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, density, animationSpec, function1, z);
    }

    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean isSkipHalfExpanded) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        ModalBottomSheetState it = new ModalBottomSheetState(initialValue, animationSpec, isSkipHalfExpanded, confirmValueChange);
        it.setDensity$material_release(density);
        return it;
    }

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            function1 = ModalBottomSheetKt$ModalBottomSheetState$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, animationSpec, function1, z);
    }

    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            ModalBottomSheetState(\n                initialValue = initialValue,\n                density =,\n                animationSpec = animationSpec,\n                isSkipHalfExpanded = isSkipHalfExpanded,\n                confirmStateChange = confirmValueChange\n            )\n            ", imports = {}))
    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean isSkipHalfExpanded) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        return new ModalBottomSheetState(initialValue, animationSpec, isSkipHalfExpanded, confirmValueChange);
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean skipHalfExpanded, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-126412120);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2)442@17797L7:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            confirmValueChange = ModalBottomSheetKt$rememberModalBottomSheetState$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            skipHalfExpanded = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:436)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        $composer.startMovableGroup(170051607, initialValue);
        ComposerKt.sourceInformation($composer, "447@18058L646");
        Saver<ModalBottomSheetState, ?> Saver = ModalBottomSheetState.Companion.Saver(animationSpec, confirmValueChange, skipHalfExpanded, density);
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{initialValue, animationSpec, Boolean.valueOf(skipHalfExpanded), confirmValueChange, density}, Saver, (String) null, new ModalBottomSheetKt$rememberModalBottomSheetState$2(initialValue, density, animationSpec, confirmValueChange, skipHalfExpanded), $composer, 72, 4);
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, boolean skipHalfExpanded, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        $composer.startReplaceableGroup(-409288536);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2!1,3)495@20118L185:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:490)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, skipHalfExpanded, $composer, ($changed & 14) | 64 | (($changed >> 3) & 896) | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmValueChange = confirmStateChange)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        $composer.startReplaceableGroup(-1928569212);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2)523@21187L174:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:519)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false, $composer, ($changed & 14) | 3136 | ($changed & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x039a  */
    /* renamed from: ModalBottomSheetLayout-Gs3lGvM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3052ModalBottomSheetLayoutGs3lGvM(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, androidx.compose.material.ModalBottomSheetState r37, boolean r38, androidx.compose.ui.graphics.Shape r39, float r40, long r41, long r43, long r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r14 = r35
            r12 = r47
            r13 = r49
            r11 = r50
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -92970288(0xfffffffffa7562d0, float:-3.1852922E35)
            r1 = r48
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ModalBottomSheetLayout)P(4,1,9,7,8,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)565@23318L37,567@23437L6,569@23560L6,570@23607L37,571@23695L10,581@24005L24,583@24104L99,586@24208L4785:ModalBottomSheet.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r49
            r2 = r11 & 1
            r3 = 4
            if (r2 == 0) goto L_0x002b
            r1 = r1 | 6
            goto L_0x0039
        L_0x002b:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0039
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0037
            r2 = r3
            goto L_0x0038
        L_0x0037:
            r2 = 2
        L_0x0038:
            r1 = r1 | r2
        L_0x0039:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0042
            r1 = r1 | 48
            r4 = r36
            goto L_0x0057
        L_0x0042:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0055
            r4 = r36
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0051
            r5 = 32
            goto L_0x0053
        L_0x0051:
            r5 = 16
        L_0x0053:
            r1 = r1 | r5
            goto L_0x0057
        L_0x0055:
            r4 = r36
        L_0x0057:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x005d
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x005d:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r38
            goto L_0x007b
        L_0x0066:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0079
            r9 = r38
            boolean r6 = r10.changed((boolean) r9)
            if (r6 == 0) goto L_0x0075
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r6
            goto L_0x007b
        L_0x0079:
            r9 = r38
        L_0x007b:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x0096
            r6 = r11 & 16
            if (r6 != 0) goto L_0x0090
            r15 = r39
            boolean r6 = r10.changed((java.lang.Object) r15)
            if (r6 == 0) goto L_0x0092
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r15 = r39
        L_0x0092:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r6
            goto L_0x0098
        L_0x0096:
            r15 = r39
        L_0x0098:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x00a2
            r6 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r6
            r7 = r40
            goto L_0x00b8
        L_0x00a2:
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00b6
            r7 = r40
            boolean r6 = r10.changed((float) r7)
            if (r6 == 0) goto L_0x00b2
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b2:
            r6 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r6
            goto L_0x00b8
        L_0x00b6:
            r7 = r40
        L_0x00b8:
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00d6
            r6 = r11 & 64
            if (r6 != 0) goto L_0x00ce
            r48 = r8
            r7 = r41
            boolean r6 = r10.changed((long) r7)
            if (r6 == 0) goto L_0x00d2
            r6 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00ce:
            r48 = r8
            r7 = r41
        L_0x00d2:
            r6 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r1 = r1 | r6
            goto L_0x00da
        L_0x00d6:
            r48 = r8
            r7 = r41
        L_0x00da:
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00f4
            r6 = r11 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x00ee
            r7 = r43
            boolean r6 = r10.changed((long) r7)
            if (r6 == 0) goto L_0x00f0
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00ee:
            r7 = r43
        L_0x00f0:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r1 = r1 | r6
            goto L_0x00f6
        L_0x00f4:
            r7 = r43
        L_0x00f6:
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x0110
            r6 = r11 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x010a
            r7 = r45
            boolean r6 = r10.changed((long) r7)
            if (r6 == 0) goto L_0x010c
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010a:
            r7 = r45
        L_0x010c:
            r6 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r1 = r1 | r6
            goto L_0x0112
        L_0x0110:
            r7 = r45
        L_0x0112:
            r6 = r11 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x011a
            r6 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0118:
            r1 = r1 | r6
            goto L_0x012b
        L_0x011a:
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x012b
            boolean r6 = r10.changedInstance(r12)
            if (r6 == 0) goto L_0x0128
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0118
        L_0x0128:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0118
        L_0x012b:
            r6 = r1
            if (r5 != r3) goto L_0x0156
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r6
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r3) goto L_0x0156
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x013e
            goto L_0x0156
        L_0x013e:
            r10.skipToGroupEnd()
            r32 = r37
            r19 = r40
            r22 = r41
            r25 = r43
            r21 = r4
            r30 = r6
            r27 = r7
            r17 = r9
            r18 = r15
            r15 = r10
            goto L_0x0391
        L_0x0156:
            r10.startDefaults()
            r1 = r13 & 1
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x01b5
            boolean r1 = r10.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0170
            goto L_0x01b5
        L_0x0170:
            r10.skipToGroupEnd()
            if (r5 == 0) goto L_0x0177
            r6 = r6 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0177:
            r1 = r11 & 16
            if (r1 == 0) goto L_0x017d
            r6 = r6 & r20
        L_0x017d:
            r1 = r11 & 64
            if (r1 == 0) goto L_0x0183
            r6 = r6 & r19
        L_0x0183:
            r1 = r11 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0189
            r6 = r6 & r18
        L_0x0189:
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01a2
            r1 = r6 & r17
            r19 = r40
            r22 = r41
            r25 = r43
            r21 = r4
            r27 = r7
            r17 = r9
            r18 = r15
            r9 = r37
            r7 = r1
            goto L_0x024d
        L_0x01a2:
            r19 = r40
            r22 = r41
            r25 = r43
            r21 = r4
            r27 = r7
            r17 = r9
            r18 = r15
            r9 = r37
            r7 = r6
            goto L_0x024d
        L_0x01b5:
            if (r2 == 0) goto L_0x01be
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r21 = r1
            goto L_0x01c0
        L_0x01be:
            r21 = r4
        L_0x01c0:
            if (r5 == 0) goto L_0x01d8
            androidx.compose.material.ModalBottomSheetValue r1 = androidx.compose.material.ModalBottomSheetValue.Hidden
            r22 = 6
            r23 = 14
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = r10
            r0 = r6
            r6 = r22
            r7 = r23
            androidx.compose.material.ModalBottomSheetState r1 = rememberModalBottomSheetState((androidx.compose.material.ModalBottomSheetValue) r1, (androidx.compose.animation.core.AnimationSpec<java.lang.Float>) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.material.ModalBottomSheetValue, java.lang.Boolean>) r3, (boolean) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r6 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01db
        L_0x01d8:
            r0 = r6
            r1 = r37
        L_0x01db:
            if (r48 == 0) goto L_0x01df
            r0 = 1
            goto L_0x01e0
        L_0x01df:
            r0 = r9
        L_0x01e0:
            r2 = r11 & 16
            r3 = 6
            if (r2 == 0) goto L_0x01f4
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r10, r3)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getLarge()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r6 = r6 & r20
            goto L_0x01f5
        L_0x01f4:
            r2 = r15
        L_0x01f5:
            if (r16 == 0) goto L_0x01fe
            androidx.compose.material.ModalBottomSheetDefaults r4 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            float r4 = r4.m3051getElevationD9Ej5fM()
            goto L_0x0200
        L_0x01fe:
            r4 = r40
        L_0x0200:
            r5 = r11 & 64
            if (r5 == 0) goto L_0x0211
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r10, r3)
            long r7 = r5.m2955getSurface0d7_KjU()
            r6 = r6 & r19
            goto L_0x0213
        L_0x0211:
            r7 = r41
        L_0x0213:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0222
            int r5 = r6 >> 18
            r5 = r5 & 14
            long r15 = androidx.compose.material.ColorsKt.m2969contentColorForek8zF_U(r7, r10, r5)
            r6 = r6 & r18
            goto L_0x0224
        L_0x0222:
            r15 = r43
        L_0x0224:
            r5 = r11 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x023f
            androidx.compose.material.ModalBottomSheetDefaults r5 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            long r18 = r5.getScrimColor(r10, r3)
            r3 = r6 & r17
            r17 = r0
            r9 = r1
            r22 = r7
            r25 = r15
            r27 = r18
            r18 = r2
            r7 = r3
            r19 = r4
            goto L_0x024d
        L_0x023f:
            r27 = r45
            r17 = r0
            r9 = r1
            r18 = r2
            r19 = r4
            r22 = r7
            r25 = r15
            r7 = r6
        L_0x024d:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x025f
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)"
            r2 = -92970288(0xfffffffffa7562d0, float:-3.1852922E35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x025f:
            r0 = 502769027(0x1df7a583, float:6.555149E-21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "576@23903L7,577@23919L63"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.ui.unit.Density r0 = r9.getDensity$material_release()
            r1 = 0
            if (r0 != 0) goto L_0x0295
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r4, r5)
            java.lang.Object r4 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r0 = r4
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1 r2 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
            r2.<init>(r9, r0)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            androidx.compose.runtime.EffectsKt.SideEffect(r2, r10, r1)
        L_0x0295:
            r10.endReplaceableGroup()
            r0 = r1
            r2 = 0
            r3 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            r3 = r10
            r4 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            r5 = 0
            r6 = r10
            r8 = 0
            java.lang.Object r15 = r6.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r36 = r0
            java.lang.Object r0 = r20.getEmpty()
            if (r15 != r0) goto L_0x02e4
            r0 = 0
            r20 = 0
            kotlin.coroutines.EmptyCoroutineContext r20 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r37 = r0
            r0 = r20
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r3)
            r38 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r6.updateRememberedValue(r0)
            goto L_0x02e7
        L_0x02e4:
            r38 = r1
            r0 = r15
        L_0x02e7:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r8 = r1
            androidx.compose.foundation.gestures.Orientation r20 = androidx.compose.foundation.gestures.Orientation.Vertical
            r0 = 72
            r1 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r9)
            boolean r3 = r10.changed((java.lang.Object) r8)
            r2 = r2 | r3
            r3 = r10
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x0324
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r5 != r15) goto L_0x0322
            goto L_0x0324
        L_0x0322:
            r15 = r5
            goto L_0x032e
        L_0x0324:
            r15 = 0
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback r15 = ModalBottomSheetAnchorChangeCallback(r9, r8)
            r3.updateRememberedValue(r15)
        L_0x032e:
            r10.endReplaceableGroup()
            r24 = r15
            androidx.compose.material.AnchoredDraggableState$AnchorChangedCallback r24 = (androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback) r24
            r15 = r24
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2 r5 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
            r0 = r5
            r1 = r17
            r2 = r9
            r3 = r20
            r4 = r18
            r29 = r5
            r5 = r22
            r30 = r7
            r31 = r8
            r7 = r25
            r32 = r9
            r9 = r19
            r33 = r10
            r10 = r30
            r11 = r47
            r12 = r27
            r14 = r31
            r16 = r35
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r14, r15, r16)
            r0 = -1731958854(0xffffffff98c467ba, float:-5.076955E-24)
            r1 = 1
            r2 = r29
            r15 = r33
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r1, r2)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r1 = r30 >> 3
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r2 = 6
            r3 = 0
            r4 = 0
            r36 = r21
            r37 = r3
            r38 = r4
            r39 = r0
            r40 = r15
            r41 = r1
            r42 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r36, r37, r38, r39, r40, r41, r42)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0391
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0391:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x039a
            r20 = r15
            goto L_0x03c6
        L_0x039a:
            androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$3 r16 = new androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$3
            r0 = r16
            r1 = r35
            r2 = r21
            r3 = r32
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r22
            r9 = r25
            r11 = r27
            r13 = r47
            r34 = r14
            r14 = r49
            r20 = r15
            r15 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x03c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m3052ModalBottomSheetLayoutGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m3053Scrim3JVO9M(long color, Function0<Unit> onDismiss, boolean visible, Composer $composer, int $changed) {
        Modifier dismissModifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        long j = color;
        Function0<Unit> function0 = onDismiss;
        boolean z = visible;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)700@29148L121,704@29295L29,720@29810L62,716@29701L171:ModalBottomSheet.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-526532668, $dirty2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:694)");
            }
            if (color != Color.Companion.m4999getUnspecified0d7_KjU()) {
                State alpha$delegate = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (String) null, (Function1<? super Float, Unit>) null, $composer2, 48, 28);
                String closeSheet = Strings_androidKt.m3128getString4foXLRw(Strings.Companion.m3122getCloseSheetUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(1010559499);
                ComposerKt.sourceInformation($composer2, "707@29432L37,708@29522L121");
                if (z) {
                    Modifier modifier = Modifier.Companion;
                    int i2 = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed((Object) function0);
                    Composer $this$cache$iv$iv = $composer2;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = (Function2) new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, (Continuation<? super ModalBottomSheetKt$Scrim$dismissModifier$1$1>) null);
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
                    boolean invalid$iv$iv2 = $composer2.changed((Object) closeSheet) | $composer2.changed((Object) function0);
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
                    value$iv$iv2 = (Function1) new ModalBottomSheetKt$Scrim$dismissModifier$2$1(closeSheet, function0);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                } else {
                    dismissModifier = Modifier.Companion;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(dismissModifier);
                Object r3 = Color.m4953boximpl(color);
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
                value$iv$iv3 = new ModalBottomSheetKt$Scrim$1$1(j, alpha$delegate);
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
        endRestartGroup.updateScope(new ModalBottomSheetKt$Scrim$2(color, onDismiss, visible, $changed));
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$2(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> state, Orientation orientation) {
        return new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(state, orientation);
    }

    /* access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue> ModalBottomSheetAnchorChangeCallback(ModalBottomSheetState state, CoroutineScope scope) {
        return new ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1(state, scope);
    }
}
