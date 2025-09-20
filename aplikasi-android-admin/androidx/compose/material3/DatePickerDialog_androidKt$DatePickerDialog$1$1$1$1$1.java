package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePickerDialog.android.kt */
final class DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$dismissButton = function2;
        this.$$dirty = i;
        this.$confirmButton = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C100@4769L10,101@4848L438:DatePickerDialog.android.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-926980325, $changed, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:98)");
            }
            TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer, 6), DialogTokens.INSTANCE.getActionLabelTextFont());
            final Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            final int i = this.$$dirty;
            final Function2<Composer, Integer, Unit> function22 = this.$confirmButton;
            TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer, -2020639284, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C102@4914L346:DatePickerDialog.android.kt#uh7d8r");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2020639284, $changed, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:101)");
                        }
                        float access$getDialogButtonsMainAxisSpacing$p = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                        float access$getDialogButtonsCrossAxisSpacing$p = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i = i;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        AlertDialogKt.m3242AlertDialogFlowRowixp7dh8(access$getDialogButtonsMainAxisSpacing$p, access$getDialogButtonsCrossAxisSpacing$p, ComposableLambdaKt.composableLambda($composer, -1863712509, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                ComposerKt.sourceInformation($composer, "C107@5215L15:DatePickerDialog.android.kt#uh7d8r");
                                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1863712509, $changed, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:105)");
                                    }
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    $composer.startReplaceableGroup(1710961622);
                                    ComposerKt.sourceInformation($composer, "106@5174L8");
                                    if (function2 != null) {
                                        function2.invoke($composer, Integer.valueOf((i >> 9) & 14));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    $composer.endReplaceableGroup();
                                    function22.invoke($composer, Integer.valueOf((i >> 3) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }), $composer, 438);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
