package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$7 extends Lambda implements Function3<SliderPositions, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$7(MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z, int i) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
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
        ComposerKt.sourceInformation($composer, "C253@11914L126:Slider.kt#uh7d8r");
        if ((i & 81) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1998248322, i, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:252)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            SliderColors sliderColors = this.$colors;
            boolean z = this.$enabled;
            int i2 = this.$$dirty;
            sliderDefaults.m1966Thumb9LiSoMs(mutableInteractionSource, (Modifier) null, sliderColors, z, 0, $composer, ((i2 >> 21) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i2 >> 12) & 896) | (i2 & 7168), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
