package androidx.compose.material3;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.KeyboardArrowLeftKt;
import androidx.compose.material.icons.filled.KeyboardArrowRightKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$MonthsNavigation$1$2$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $rtl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$MonthsNavigation$1$2$2(boolean z) {
        super(2);
        this.$rtl = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ImageVector imageVector;
        ComposerKt.sourceInformation($composer, "C1820@74849L46,1814@74584L333:DatePicker.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1336532191, $changed, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1813)");
            }
            if (this.$rtl) {
                imageVector = KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.Filled.INSTANCE);
            } else {
                imageVector = KeyboardArrowRightKt.getKeyboardArrowRight(Icons.Filled.INSTANCE);
            }
            IconKt.m3518Iconww6aTOc(imageVector, Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3724getDatePickerSwitchToNextMonthadMyvUU(), $composer, 6), (Modifier) null, 0, $composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
