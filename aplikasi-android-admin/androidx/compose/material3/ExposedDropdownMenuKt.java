package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\bH\u0002\u001aE\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001e\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuDescription", "", "expandedDescription", "collapsedDescription", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt {
    /* access modifiers changed from: private */
    public static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m7554constructorimpl((float) 16);

    public static final void ExposedDropdownMenuBox(boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        FocusRequester focusRequester;
        int $dirty;
        MutableState menuHeight$delegate;
        View view;
        int verticalMarginInPx;
        Ref coordinates;
        int i2;
        Object value$iv$iv5;
        boolean z = expanded;
        Function1<? super Boolean, Unit> function1 = onExpandedChange;
        Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i3 = $changed;
        Intrinsics.checkNotNullParameter(function1, "onExpandedChange");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-1990697039);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenuBox)P(1,3,2)106@5045L7,107@5078L7,108@5103L30,109@5156L30,111@5287L37,113@5351L29,115@5398L1392,149@6796L45,153@6858L59,153@6847L70,157@6923L379:ExposedDropdownMenu.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer2.changed(z) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if ((i3 & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i4 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990697039, $dirty3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:100)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view2 = (View) consume2;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            MutableState width$delegate = (MutableState) value$iv$iv;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            MutableState menuHeight$delegate2 = (MutableState) value$iv$iv2;
            int verticalMarginInPx2 = density.m7529roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv3 = $composer2;
            Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
            if (it$iv$iv3 == Composer.Companion.getEmpty()) {
                value$iv$iv3 = new Ref();
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            Ref coordinates2 = (Ref) value$iv$iv3;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv4 = $composer2;
            Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
            if (it$iv$iv4 == Composer.Companion.getEmpty()) {
                value$iv$iv4 = new FocusRequester();
                $this$cache$iv$iv4.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv4;
            }
            $composer2.endReplaceableGroup();
            FocusRequester focusRequester2 = (FocusRequester) value$iv$iv4;
            Object[] keys$iv = {Boolean.valueOf(expanded), function1, density, Integer.valueOf(ExposedDropdownMenuBox$lambda$4(menuHeight$delegate2)), Integer.valueOf(ExposedDropdownMenuBox$lambda$1(width$delegate))};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv5 = $composer2;
            Object value$iv$iv6 = $this$cache$iv$iv5.rememberedValue();
            if (invalid$iv || value$iv$iv6 == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv6;
                Object[] objArr = keys$iv;
                focusRequester = focusRequester2;
                coordinates = coordinates2;
                verticalMarginInPx = verticalMarginInPx2;
                view = view2;
                menuHeight$delegate = menuHeight$delegate2;
                i2 = 2023513938;
                $dirty = $dirty3;
                value$iv$iv6 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(expanded, onExpandedChange, $dirty3, focusRequester2, coordinates2, view2, verticalMarginInPx, width$delegate, menuHeight$delegate2, density);
                $this$cache$iv$iv5.updateRememberedValue(value$iv$iv6);
            } else {
                Object obj2 = value$iv$iv6;
                Composer composer = $this$cache$iv$iv5;
                Object[] objArr2 = keys$iv;
                focusRequester = focusRequester2;
                coordinates = coordinates2;
                verticalMarginInPx = verticalMarginInPx2;
                view = view2;
                Density density2 = density;
                menuHeight$delegate = menuHeight$delegate2;
                $dirty = $dirty3;
                i2 = 2023513938;
            }
            $composer2.endReplaceableGroup();
            ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 scope = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) value$iv$iv6;
            int $changed$iv = ($dirty >> 6) & 14;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume3;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier3);
            int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
            Alignment alignment = contentAlignment$iv;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer2);
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer2;
            int i5 = $changed$iv$iv$iv;
            int i6 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i7 = $changed$iv;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = (($changed$iv >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 1004941959, "C150@6826L9:ExposedDropdownMenu.kt#uh7d8r");
            function3.invoke(scope, $composer3, Integer.valueOf(($dirty >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Object key1$iv = Boolean.valueOf(expanded);
            int i9 = ($dirty & 14) | 48;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            FocusRequester focusRequester3 = focusRequester;
            boolean invalid$iv$iv = $composer2.changed(key1$iv) | $composer2.changed((Object) focusRequester3);
            Composer $this$cache$iv$iv6 = $composer2;
            Object it$iv$iv5 = $this$cache$iv$iv6.rememberedValue();
            if (invalid$iv$iv || it$iv$iv5 == Composer.Companion.getEmpty()) {
                value$iv$iv5 = (Function0) new ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1(z, focusRequester3);
                $this$cache$iv$iv6.updateRememberedValue(value$iv$iv5);
            } else {
                value$iv$iv5 = it$iv$iv5;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv5, $composer2, 0);
            View view3 = view;
            EffectsKt.DisposableEffect((Object) view3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new ExposedDropdownMenuKt$ExposedDropdownMenuBox$3(view3, coordinates, verticalMarginInPx, menuHeight$delegate), $composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            int i10 = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuKt$ExposedDropdownMenuBox$4(expanded, onExpandedChange, modifier3, content, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableState<Integer> $width$delegate) {
        return ((Number) $width$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$2(MutableState<Integer> $width$delegate, int value) {
        $width$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableState<Integer> $menuHeight$delegate) {
        return ((Number) $menuHeight$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$5(MutableState<Integer> $menuHeight$delegate, int value) {
        $menuHeight$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final Modifier expandable(Modifier $this$expandable, boolean expanded, Function0<Unit> onExpandedChange, String menuDescription, String expandedDescription, String collapsedDescription, Composer $composer, int $changed, int i) {
        String expandedDescription2;
        String collapsedDescription2;
        Object value$iv$iv;
        boolean z;
        Function0<Unit> function0 = onExpandedChange;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1006563320);
        ComposerKt.sourceInformation(composer, "C(expandable)P(1,4,3,2)1017@60116L38,1018@60190L31,1019@60258L32,1020@60315L365,1030@60691L187:ExposedDropdownMenu.kt#uh7d8r");
        String menuDescription2 = (i & 4) != 0 ? Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3740getExposedDropdownMenuadMyvUU(), composer, 6) : menuDescription;
        if ((i & 8) != 0) {
            expandedDescription2 = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3742getMenuExpandedadMyvUU(), composer, 6);
        } else {
            expandedDescription2 = expandedDescription;
        }
        if ((i & 16) != 0) {
            collapsedDescription2 = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3741getMenuCollapsedadMyvUU(), composer, 6);
        } else {
            collapsedDescription2 = collapsedDescription;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006563320, i2, -1, "androidx.compose.material3.expandable (ExposedDropdownMenu.kt:1014)");
        }
        Unit unit = Unit.INSTANCE;
        int $changed$iv = (i2 >> 6) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) function0);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            int i3 = $changed$iv;
            value$iv$iv = (Function2) new ExposedDropdownMenuKt$expandable$1$1(function0, (Continuation<? super ExposedDropdownMenuKt$expandable$1$1>) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            int i4 = $changed$iv;
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$expandable, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv);
        Object[] keys$iv = {Boolean.valueOf(expanded), expandedDescription2, collapsedDescription2, menuDescription2, function0};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv2 = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            z = false;
            value$iv$iv2 = new ExposedDropdownMenuKt$expandable$2$1(expanded, expandedDescription2, collapsedDescription2, menuDescription2, onExpandedChange);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
            z = false;
        }
        $composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(pointerInput, z, (Function1) value$iv$iv2, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return semantics$default;
    }

    /* access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> onHeightUpdate) {
        if (coordinates != null) {
            Rect visibleWindowBounds = new Rect();
            view.getWindowVisibleDisplayFrame(visibleWindowBounds);
            onHeightUpdate.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(coordinates).getTop() - ((float) visibleWindowBounds.top), ((float) (visibleWindowBounds.bottom - visibleWindowBounds.top)) - LayoutCoordinatesKt.boundsInWindow(coordinates).getBottom())) - verticalMarginInPx));
        }
    }
}
