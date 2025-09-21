package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TooltipPopup", "", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismissRequest", "Lkotlin/Function0;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TooltipPopup.android.kt */
public final class TooltipPopup_androidKt {
    public static final void TooltipPopup(PopupPositionProvider popupPositionProvider, Function0<Unit> onDismissRequest, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Function0<Unit> function0 = onDismissRequest;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Intrinsics.checkNotNullParameter(popupPositionProvider2, "popupPositionProvider");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1507102480);
        ComposerKt.sourceInformation($composer2, "C(TooltipPopup)P(2,1)29@1039L174:TooltipPopup.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) popupPositionProvider2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1507102480, $dirty2, -1, "androidx.compose.material3.TooltipPopup (TooltipPopup.android.kt:25)");
            }
            AndroidPopup_androidKt.Popup(popupPositionProvider, onDismissRequest, new PopupProperties(true, false, false, (SecureFlagPolicy) null, false, false, 62, (DefaultConstructorMarker) null), content, $composer2, ($dirty2 & 14) | 384 | ($dirty2 & 112) | (($dirty2 << 3) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TooltipPopup_androidKt$TooltipPopup$1(popupPositionProvider2, function0, function2, i));
        }
    }
}
