package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/material/InputPhase;", "invoke", "(Landroidx/compose/animation/core/Transition$Segment;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/FiniteAnimationSpec;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope$Transition$placeholderOpacity$2 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldTransitionScope$Transition$placeholderOpacity$2 INSTANCE = new TextFieldTransitionScope$Transition$placeholderOpacity$2();

    TextFieldTransitionScope$Transition$placeholderOpacity$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Transition.Segment<InputPhase>) (Transition.Segment) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceableGroup(-1079955085);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1079955085, $changed, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:293)");
        }
        if ($this$animateFloat.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        } else if ($this$animateFloat.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || $this$animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
            finiteAnimationSpec = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
        } else {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
