package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimePickerTextField$1$1$2 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextFieldColors $textFieldColors;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimePickerTextField$1$1$2(TextFieldValue textFieldValue, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors) {
        super(3);
        this.$value = textFieldValue;
        this.$interactionSource = mutableInteractionSource;
        this.$textFieldColors = textFieldColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> it, Composer $composer, int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function2 = it;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function2, "it");
        ComposerKt.sourceInformation(composer, "C1447@55040L864:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changedInstance(function2) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2133555260, $dirty2, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1446)");
            }
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
            String text = this.$value.getText();
            VisualTransformation none = VisualTransformation.Companion.getNone();
            PaddingValues r17 = PaddingKt.m2241PaddingValues0680j_4(Dp.m7554constructorimpl((float) 0));
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final TextFieldColors textFieldColors = this.$textFieldColors;
            int i = $dirty2;
            outlinedTextFieldDefaults.DecorationBox(text, it, true, true, none, this.$interactionSource, false, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, this.$textFieldColors, r17, ComposableLambdaKt.composableLambda(composer, -968963953, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    Composer composer = $composer;
                    int i = $changed;
                    ComposerKt.sourceInformation($composer, "C1461@55774L9,1457@55528L336:TimePicker.kt#uh7d8r");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-968963953, i, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1456)");
                        }
                        OutlinedTextFieldDefaults.INSTANCE.m3603ContainerBoxnbWgWpA(true, false, mutableInteractionSource, textFieldColors, ShapesKt.toShape(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer, 6), 0.0f, 0.0f, $composer, 12583350, 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, (($dirty2 << 3) & 112) | 224640, 14352384, 16320);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
        int i2 = $dirty2;
    }
}
