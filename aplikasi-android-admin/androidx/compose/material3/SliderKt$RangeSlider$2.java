package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<SliderPositions, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z, int i) {
        super(3);
        this.$startInteractionSource = mutableInteractionSource;
        this.$colors = sliderColors;
        this.$enabled = z;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((SliderPositions) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SliderPositions it, Composer $composer, int $changed) {
        int i = $changed;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "C346@15726L147:Slider.kt#uh7d8r");
        if ((i & 81) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1361279243, i, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:345)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
            SliderColors sliderColors = this.$colors;
            boolean z = this.$enabled;
            int i2 = this.$$dirty;
            sliderDefaults.m3676Thumb9LiSoMs(mutableInteractionSource, (Modifier) null, sliderColors, z, 0, $composer, ((i2 >> 15) & 896) | 196614 | (i2 & 7168), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
