package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u00020\u000e2\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0002\b\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\u0010*\u001a \u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000ø\u0001\u0000¢\u0006\u0002\u0010/\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0019\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m7554constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m7554constructorimpl((float) 112);
    /* access modifiers changed from: private */
    public static final float DropdownMenuItemHorizontalPadding = Dp.m7554constructorimpl((float) 12);
    private static final float DropdownMenuVerticalPadding = Dp.m7554constructorimpl((float) 8);
    public static final int InTransitionDuration = 120;
    private static final float MenuVerticalMargin = Dp.m7554constructorimpl((float) 48);
    public static final int OutTransitionDuration = 75;

    public static final void DropdownMenuContent(MutableTransitionState<Boolean> expandedStates, MutableState<TransformOrigin> transformOriginState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        float f;
        String str;
        String str2;
        float f2;
        Modifier modifier5;
        float f3;
        float f4;
        Object value$iv$iv;
        MutableTransitionState<Boolean> mutableTransitionState = expandedStates;
        MutableState<TransformOrigin> mutableState = transformOriginState;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(mutableTransitionState, "expandedStates");
        Intrinsics.checkNotNullParameter(mutableState, "transformOriginState");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-159754260);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenuContent)P(1,3,2)72@3078L48,74@3156L666,100@3852L477,120@4385L153,126@4582L9,127@4623L11,119@4334L715:Menu.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) mutableTransitionState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) mutableState) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if ((i2 & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-159754260, $dirty2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:65)");
            }
            Transition $this$animateFloat$iv = TransitionKt.updateTransition(mutableTransitionState, "DropDownMenu", $composer2, MutableTransitionState.$stable | 48 | ($dirty2 & 14), 0);
            Function3 transitionSpec$iv = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv = $this$animateFloat$iv;
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            boolean it = ((Boolean) $this$animateValue$iv$iv.getCurrentState()).booleanValue();
            Composer $composer3 = $composer2;
            $composer3.startReplaceableGroup(1808111696);
            ComposerKt.sourceInformation($composer3, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808111696, $changed2, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)");
            }
            if (it) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            Object valueOf = Float.valueOf(f);
            String str3 = "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli";
            Object initialValue$iv$iv = valueOf;
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) $this$animateValue$iv$iv.getTargetState()).booleanValue();
            Composer $composer4 = $composer2;
            $composer4.startReplaceableGroup(1808111696);
            ComposerKt.sourceInformation($composer4, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                str = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
                str2 = "C:Menu.kt#uh7d8r";
                ComposerKt.traceEventStart(1808111696, $changed3, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)");
            } else {
                str = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
                str2 = "C:Menu.kt#uh7d8r";
            }
            if (it2) {
                f2 = 1.0f;
            } else {
                f2 = 0.8f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer4.endReplaceableGroup();
            String str4 = str;
            Function3 function32 = transitionSpec$iv;
            State createTransitionAnimation = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, Float.valueOf(f2), (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            State scale$delegate = createTransitionAnimation;
            Function3 transitionSpec$iv2 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, str4);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            Transition $this$animateValue$iv$iv2 = $this$animateFloat$iv;
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, str3);
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            boolean it3 = ((Boolean) $this$animateValue$iv$iv2.getCurrentState()).booleanValue();
            Composer $composer5 = $composer2;
            $composer5.startReplaceableGroup(1864763068);
            String str5 = str2;
            ComposerKt.sourceInformation($composer5, str5);
            if (ComposerKt.isTraceInProgress()) {
                Transition<T> transition = $this$animateFloat$iv;
                modifier5 = modifier4;
                ComposerKt.traceEventStart(1864763068, $changed4, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)");
            } else {
                Transition transition2 = $this$animateFloat$iv;
                modifier5 = modifier4;
            }
            if (it3) {
                f3 = 1.0f;
            } else {
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer5.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            boolean it4 = ((Boolean) $this$animateValue$iv$iv2.getTargetState()).booleanValue();
            Composer $composer6 = $composer2;
            $composer6.startReplaceableGroup(1864763068);
            ComposerKt.sourceInformation($composer6, str5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1864763068, $changed5, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)");
            }
            if (it4) {
                f4 = 1.0f;
            } else {
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer6.endReplaceableGroup();
            State createTransitionAnimation2 = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, Float.valueOf(f4), (FiniteAnimationSpec) transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            State alpha$delegate = createTransitionAnimation2;
            Modifier modifier6 = Modifier.Companion;
            int i4 = ($dirty2 << 3) & 896;
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) scale$delegate) | $composer2.changed((Object) alpha$delegate) | $composer2.changed((Object) mutableState);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new MenuKt$DropdownMenuContent$1$1(mutableState, scale$delegate, alpha$delegate);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Modifier modifier7 = modifier5;
            SurfaceKt.m3772SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(modifier6, (Function1) value$iv$iv), ShapesKt.toShape(MenuTokens.INSTANCE.getContainerShape(), $composer2, 6), ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer2, 6), MenuTokens.INSTANCE.getContainerColor()), 0, MenuTokens.INSTANCE.m4271getContainerElevationD9Ej5fM(), MenuTokens.INSTANCE.m4271getContainerElevationD9Ej5fM(), (BorderStroke) null, ComposableLambdaKt.composableLambda($composer2, -1651673913, true, new MenuKt$DropdownMenuContent$2(modifier7, function3, $dirty2)), $composer2, 12804096, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i5 = $dirty2;
            Composer composer = $composer2;
            return;
        }
        int i6 = $dirty2;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new MenuKt$DropdownMenuContent$3(expandedStates, transformOriginState, modifier3, content, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> $scale$delegate) {
        return ((Number) $scale$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    public static final void DropdownMenuItemContent(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean enabled, MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, int $changed) {
        Composer $composer2;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function0<Unit> function0 = onClick;
        Modifier modifier2 = modifier;
        MenuItemColors menuItemColors = colors;
        PaddingValues paddingValues = contentPadding;
        MutableInteractionSource mutableInteractionSource = interactionSource;
        int i = $changed;
        Intrinsics.checkNotNullParameter(function2, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(menuItemColors, "colors");
        Intrinsics.checkNotNullParameter(paddingValues, "contentPadding");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Composer $composer3 = $composer.startRestartGroup(-1564716777);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenuItemContent)P(7,6,5,4,8,2)159@5627L20,153@5416L2336:Menu.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer3.changedInstance(leadingIcon) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = leadingIcon;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer3.changedInstance(trailingIcon) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = trailingIcon;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer3.changed(enabled) ? 131072 : 65536;
        } else {
            boolean z = enabled;
        }
        if ((3670016 & i) == 0) {
            $dirty |= $composer3.changed((Object) menuItemColors) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            $dirty |= $composer3.changed((Object) paddingValues) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            $dirty |= $composer3.changed((Object) mutableInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((191739611 & $dirty2) != 38347922 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, $dirty2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:142)");
            }
            int $dirty3 = $dirty2;
            $composer2 = $composer3;
            Modifier padding = PaddingKt.padding(SizeKt.m2326sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m1908clickableO2vRcR0$default(modifier, interactionSource, RippleKt.m3233rememberRipple9IZ8Weo(true, 0.0f, 0, $composer3, 6, 6), enabled, (String) null, (Role) null, onClick, 24, (Object) null), 0.0f, 1, (Object) null), DropdownMenuItemDefaultMinWidth, MenuTokens.INSTANCE.m4272getListItemContainerHeightD9Ej5fM(), DropdownMenuItemDefaultMaxWidth, 0.0f, 8, (Object) null), paddingValues);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier$iv = padding;
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            int $changed$iv$iv$iv = ((((384 << 3) & 112) << 9) & 7168) | 6;
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
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer2);
            Function0<ComposeUiNode> function02 = constructor;
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            Density density = density$iv$iv;
            int i3 = ((384 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            RowScope $this$DropdownMenuItemContent_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1557318497, "C171@6130L10,171@6099L1647:Menu.kt#uh7d8r");
            MenuKt$DropdownMenuItemContent$1$1 menuKt$DropdownMenuItemContent$1$1 = r0;
            int i4 = $changed$iv$iv$iv;
            Composer $composer5 = $composer4;
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), MenuTokens.INSTANCE.getListItemLabelTextFont());
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Alignment.Vertical vertical = verticalAlignment$iv;
            MenuKt$DropdownMenuItemContent$1$1 menuKt$DropdownMenuItemContent$1$12 = new MenuKt$DropdownMenuItemContent$1$1(leadingIcon, colors, enabled, $dirty3, trailingIcon, $this$DropdownMenuItemContent_u24lambda_u245, text);
            TextKt.ProvideTextStyle(fromToken, ComposableLambdaKt.composableLambda($composer5, 1065051884, true, menuKt$DropdownMenuItemContent$1$1), $composer5, 48);
            ComposerKt.sourceInformationMarkerEnd($composer5);
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
            int i5 = $dirty2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new MenuKt$DropdownMenuItemContent$2(text, onClick, modifier, leadingIcon, trailingIcon, enabled, colors, contentPadding, interactionSource, $changed));
    }

    public static final long calculateTransformOrigin(IntRect parentBounds, IntRect menuBounds) {
        float f;
        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
        float pivotY = 1.0f;
        if (menuBounds.getLeft() >= parentBounds.getRight()) {
            f = 0.0f;
        } else if (menuBounds.getRight() <= parentBounds.getLeft()) {
            f = 1.0f;
        } else if (menuBounds.getWidth() == 0) {
            f = 0.0f;
        } else {
            f = ((float) (((Math.max(parentBounds.getLeft(), menuBounds.getLeft()) + Math.min(parentBounds.getRight(), menuBounds.getRight())) / 2) - menuBounds.getLeft())) / ((float) menuBounds.getWidth());
        }
        float pivotX = f;
        if (menuBounds.getTop() >= parentBounds.getBottom()) {
            pivotY = 0.0f;
        } else if (menuBounds.getBottom() > parentBounds.getTop()) {
            if (menuBounds.getHeight() == 0) {
                pivotY = 0.0f;
            } else {
                pivotY = ((float) (((Math.max(parentBounds.getTop(), menuBounds.getTop()) + Math.min(parentBounds.getBottom(), menuBounds.getBottom())) / 2) - menuBounds.getTop())) / ((float) menuBounds.getHeight());
            }
        }
        return TransformOriginKt.TransformOrigin(pivotX, pivotY);
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }
}
