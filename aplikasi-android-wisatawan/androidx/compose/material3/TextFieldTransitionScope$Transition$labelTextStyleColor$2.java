package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope$Transition$labelTextStyleColor$2 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>> {
    public static final TextFieldTransitionScope$Transition$labelTextStyleColor$2 INSTANCE = new TextFieldTransitionScope$Transition$labelTextStyleColor$2();

    TextFieldTransitionScope$Transition$labelTextStyleColor$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Transition.Segment<InputPhase>) (Transition.Segment) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> $this$animateColor, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$animateColor, "$this$animateColor");
        $composer.startReplaceableGroup(2041936647);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2041936647, $changed, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:363)");
        }
        TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return tween$default;
    }
}
