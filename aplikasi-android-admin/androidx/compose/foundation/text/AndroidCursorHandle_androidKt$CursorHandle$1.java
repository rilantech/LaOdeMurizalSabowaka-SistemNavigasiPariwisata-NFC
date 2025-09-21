package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
final class AndroidCursorHandle_androidKt$CursorHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCursorHandle_androidKt$CursorHandle$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, int i) {
        super(2);
        this.$content = function2;
        this.$modifier = modifier;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:AndroidCursorHandle.android.kt#423gt5");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1458480226, $changed, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:46)");
            }
            if (this.$content == null) {
                $composer.startReplaceableGroup(1275643833);
                ComposerKt.sourceInformation($composer, "48@1835L40");
                AndroidCursorHandle_androidKt.DefaultCursorHandle(this.$modifier, $composer, (this.$$dirty >> 3) & 14);
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(1275643903);
                ComposerKt.sourceInformation($composer, "50@1905L9");
                this.$content.invoke($composer, Integer.valueOf((this.$$dirty >> 6) & 14));
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
}
