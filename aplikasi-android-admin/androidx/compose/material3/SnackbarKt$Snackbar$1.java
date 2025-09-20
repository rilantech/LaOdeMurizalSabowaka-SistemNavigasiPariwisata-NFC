package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ long $actionContentColor;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissAction;
    final /* synthetic */ long $dismissActionContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j, long j2, int i, boolean z) {
        super(2);
        this.$action = function2;
        this.$content = function22;
        this.$dismissAction = function23;
        this.$actionContentColor = j;
        this.$dismissActionContentColor = j2;
        this.$$dirty = i;
        this.$actionOnNewLine = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C113@5390L10,114@5490L10,115@5555L1013:Snackbar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829663446, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:112)");
            }
            TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
            TextStyle actionTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
            ProvidedValue[] providedValueArr = {TextKt.getLocalTextStyle().provides(textStyle)};
            final Function2<Composer, Integer, Unit> function2 = this.$action;
            final Function2<Composer, Integer, Unit> function22 = this.$content;
            final Function2<Composer, Integer, Unit> function23 = this.$dismissAction;
            final long j = this.$actionContentColor;
            TextStyle textStyle2 = textStyle;
            long j2 = this.$dismissActionContentColor;
            int i2 = this.$$dirty;
            final boolean z = this.$actionOnNewLine;
            final TextStyle textStyle3 = actionTextStyle;
            ProvidedValue[] providedValueArr2 = providedValueArr;
            final long j3 = j2;
            final int i3 = i2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 835891690, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C:Snackbar.kt#uh7d8r");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(835891690, $changed, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:115)");
                        }
                        if (function2 == null) {
                            $composer.startReplaceableGroup(-2104362496);
                            ComposerKt.sourceInformation($composer, "117@5670L278");
                            Function2<Composer, Integer, Unit> function2 = function22;
                            Function2<Composer, Integer, Unit> function22 = function23;
                            TextStyle textStyle = textStyle3;
                            long j = j;
                            long j2 = j3;
                            int i = i3;
                            Composer composer = $composer;
                            SnackbarKt.m3685OneRowSnackbarkKq0p4A(function2, (Function2<? super Composer, ? super Integer, Unit>) null, function22, textStyle, j, j2, composer, (57344 & (i >> 9)) | ((i >> 27) & 14) | 48 | (i & 896) | ((i >> 9) & 458752));
                            $composer.endReplaceableGroup();
                        } else if (z) {
                            $composer.startReplaceableGroup(-2104362182);
                            ComposerKt.sourceInformation($composer, "125@5984L255");
                            Function2<Composer, Integer, Unit> function23 = function22;
                            Function2<Composer, Integer, Unit> function24 = function2;
                            Function2<Composer, Integer, Unit> function25 = function23;
                            TextStyle textStyle2 = textStyle3;
                            long j3 = j;
                            long j4 = j3;
                            int i2 = i3;
                            Composer composer2 = $composer;
                            SnackbarKt.m3684NewLineButtonSnackbarkKq0p4A(function23, function24, function25, textStyle2, j3, j4, composer2, (57344 & (i2 >> 9)) | ((i2 >> 27) & 14) | (i2 & 112) | (i2 & 896) | ((i2 >> 9) & 458752));
                            $composer.endReplaceableGroup();
                        } else {
                            $composer.startReplaceableGroup(-2104361902);
                            ComposerKt.sourceInformation($composer, "133@6264L280");
                            Function2<Composer, Integer, Unit> function26 = function22;
                            Function2<Composer, Integer, Unit> function27 = function2;
                            Function2<Composer, Integer, Unit> function28 = function23;
                            TextStyle textStyle3 = textStyle3;
                            long j5 = j;
                            long j6 = j3;
                            int i3 = i3;
                            Composer composer3 = $composer;
                            SnackbarKt.m3685OneRowSnackbarkKq0p4A(function26, function27, function28, textStyle3, j5, j6, composer3, (57344 & (i3 >> 9)) | ((i3 >> 27) & 14) | (i3 & 112) | (i3 & 896) | ((i3 >> 9) & 458752));
                            $composer.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
