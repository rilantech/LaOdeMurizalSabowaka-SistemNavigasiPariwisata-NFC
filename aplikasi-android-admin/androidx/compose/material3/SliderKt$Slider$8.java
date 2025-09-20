package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$8 extends Lambda implements Function3<SliderPositions, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$8(SliderColors sliderColors, boolean z, int i) {
        super(3);
        this.$colors = sliderColors;
        this.$enabled = z;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((SliderPositions) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SliderPositions sliderPositions, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
        ComposerKt.sourceInformation($composer, "C260@12143L122:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) sliderPositions) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1543282935, $dirty, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:259)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            SliderColors sliderColors = this.$colors;
            boolean z = this.$enabled;
            int i = this.$$dirty;
            sliderDefaults.Track(sliderPositions, (Modifier) null, sliderColors, z, $composer, ($dirty & 14) | 24576 | ((i >> 12) & 896) | (i & 7168), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
