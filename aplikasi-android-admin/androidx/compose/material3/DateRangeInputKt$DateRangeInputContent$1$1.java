package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
final class DateRangeInputKt$DateRangeInputContent$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $pattern;
    final /* synthetic */ String $startRangeText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangeInputKt$DateRangeInputContent$1$1(String str, String str2) {
        super(2);
        this.$startRangeText = str;
        this.$pattern = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C67@2865L96,66@2794L168:DateRangeInput.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576559191, i, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:65)");
            }
            String str = this.$startRangeText;
            Modifier modifier = Modifier.Companion;
            Object key1$iv = this.$startRangeText;
            Object key2$iv = this.$pattern;
            String str2 = this.$startRangeText;
            String str3 = this.$pattern;
            composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed(key2$iv);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new DateRangeInputKt$DateRangeInputContent$1$1$1$1(str2, str3);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            TextKt.m3858Text4IGK_g(str, SemanticsModifierKt.semantics$default(modifier, false, (Function1) value$iv$iv, 1, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
