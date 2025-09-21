package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$animateTooltip$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Transition<Boolean> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$animateTooltip$2(Transition<Boolean> transition) {
        super(3);
        this.$transition = transition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    private static final float invoke$lambda$1(State<Float> $scale$delegate) {
        return ((Number) $scale$delegate.getValue()).floatValue();
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        String str;
        String str2;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(-1498516085);
        ComposerKt.sourceInformation(composer, "C700@25010L583,719@25623L561:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1498516085, $changed, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:699)");
        } else {
            int i = $changed;
        }
        Transition $this$animateFloat$iv = this.$transition;
        Function3 transitionSpec$iv = TooltipKt$animateTooltip$2$scale$2.INSTANCE;
        composer.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(composer, "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv$iv = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        Transition $this$animateValue$iv$iv = $this$animateFloat$iv;
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        int $changed2 = ($changed$iv$iv >> 9) & 112;
        boolean it = $this$animateValue$iv$iv.getCurrentState().booleanValue();
        Composer $composer2 = $composer;
        $composer2.startReplaceableGroup(-1553362193);
        ComposerKt.sourceInformation($composer2, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            str = "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli";
            ComposerKt.traceEventStart(-1553362193, $changed2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:717)");
        } else {
            str = "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli";
        }
        float f = 1.0f;
        float f2 = it ? 1.0f : 0.8f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer2.endReplaceableGroup();
        Object initialValue$iv$iv = Float.valueOf(f2);
        int $changed3 = ($changed$iv$iv >> 9) & 112;
        boolean it2 = $this$animateValue$iv$iv.getTargetState().booleanValue();
        Composer $composer3 = $composer;
        $composer3.startReplaceableGroup(-1553362193);
        ComposerKt.sourceInformation($composer3, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            str2 = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
            ComposerKt.traceEventStart(-1553362193, $changed3, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:717)");
        } else {
            str2 = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
        }
        float f3 = it2 ? 1.0f : 0.8f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer3.endReplaceableGroup();
        Object targetValue$iv$iv = Float.valueOf(f3);
        FiniteAnimationSpec animationSpec$iv$iv = (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        String str3 = str;
        FiniteAnimationSpec finiteAnimationSpec = animationSpec$iv$iv;
        State createTransitionAnimation = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, vectorConverter, "tooltip transition: scaling", $composer, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        State scale$delegate = createTransitionAnimation;
        Function3 transitionSpec$iv2 = TooltipKt$animateTooltip$2$alpha$2.INSTANCE;
        composer.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(composer, str2);
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        Transition $this$animateValue$iv$iv2 = this.$transition;
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, str3);
        int $changed4 = ($changed$iv$iv2 >> 9) & 112;
        boolean it3 = $this$animateValue$iv$iv2.getCurrentState().booleanValue();
        Composer $composer4 = $composer;
        $composer4.startReplaceableGroup(2073045083);
        ComposerKt.sourceInformation($composer4, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2073045083, $changed4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:736)");
        }
        float f4 = it3 ? 1.0f : 0.0f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer4.endReplaceableGroup();
        Object initialValue$iv$iv2 = Float.valueOf(f4);
        int $changed5 = ($changed$iv$iv2 >> 9) & 112;
        boolean it4 = $this$animateValue$iv$iv2.getTargetState().booleanValue();
        Composer $composer5 = $composer;
        $composer5.startReplaceableGroup(2073045083);
        ComposerKt.sourceInformation($composer5, "C:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2073045083, $changed5, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:736)");
        }
        if (!it4) {
            f = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer5.endReplaceableGroup();
        Function3 function3 = transitionSpec$iv2;
        State alpha$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, Float.valueOf(f), (FiniteAnimationSpec) transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), composer, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "tooltip transition: alpha", $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        Modifier r1 = GraphicsLayerModifierKt.m5121graphicsLayerAp8cVGQ$default($this$composed, invoke$lambda$1(scale$delegate), invoke$lambda$1(scale$delegate), invoke$lambda$3(alpha$delegate), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131064, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r1;
    }

    private static final float invoke$lambda$3(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }
}
