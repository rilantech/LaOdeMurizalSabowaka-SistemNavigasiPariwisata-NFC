package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $sheetPeekHeight;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(Modifier modifier, long j, long j2, int i, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, float f) {
        super(2);
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$$dirty = i;
        this.$body = function3;
        this.$sheetPeekHeight = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C347@15198L194:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459220575, i, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:346)");
            }
            Modifier modifier = this.$modifier;
            long j = this.$containerColor;
            long j2 = this.$contentColor;
            final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$body;
            final float f = this.$sheetPeekHeight;
            final int i2 = this.$$dirty;
            int i3 = this.$$dirty;
            SurfaceKt.m2062SurfaceT9BRK9s(modifier, (Shape) null, j, j2, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(composer, 1725620860, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C351@15345L45:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725620860, $changed, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:351)");
                        }
                        function3.invoke(PaddingKt.m535PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, (Object) null), $composer, Integer.valueOf((i2 >> 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, (i3 & 14) | 12582912 | ((i3 >> 18) & 896) | ((i3 >> 18) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
