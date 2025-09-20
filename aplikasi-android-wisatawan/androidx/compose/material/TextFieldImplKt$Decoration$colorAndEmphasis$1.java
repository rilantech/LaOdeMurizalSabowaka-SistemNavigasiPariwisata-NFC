package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$Decoration$colorAndEmphasis$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Float $contentAlpha;
    final /* synthetic */ long $contentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$Decoration$colorAndEmphasis$1(long j, Float f, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$contentColor = j;
        this.$contentAlpha = f;
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C240@9912L476:TextFieldImpl.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(494684590, $changed, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:239)");
            }
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(this.$contentColor))};
            final Float f = this.$contentAlpha;
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            final int i = this.$$dirty;
            final long j = this.$contentColor;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, -1132188434, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#jmzs0o");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1132188434, $changed, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:240)");
                        }
                        if (f != null) {
                            $composer.startReplaceableGroup(-452621938);
                            ComposerKt.sourceInformation($composer, "242@10036L142");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f)}, (Function2<? super Composer, ? super Integer, Unit>) function2, $composer, ((i >> 6) & 112) | 8);
                            $composer.endReplaceableGroup();
                        } else {
                            $composer.startReplaceableGroup(-452621758);
                            ComposerKt.sourceInformation($composer, "247@10216L148");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3255getAlphaimpl(j)))}, (Function2<? super Composer, ? super Integer, Unit>) function2, $composer, ((i >> 6) & 112) | 8);
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
            }), $composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
