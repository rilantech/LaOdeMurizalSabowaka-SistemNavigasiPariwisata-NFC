package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"SkippableItem", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "saveableStateHolder", "Landroidx/compose/foundation/lazy/layout/StableValue;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "index", "", "key", "", "SkippableItem-JVlU9Rs", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Ljava/lang/Object;ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
public final class LazyLayoutItemContentFactoryKt {
    /* access modifiers changed from: private */
    /* renamed from: SkippableItem-JVlU9Rs  reason: not valid java name */
    public static final void m2444SkippableItemJVlU9Rs(LazyLayoutItemProvider itemProvider, Object saveableStateHolder, int index, Object key, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1439843069);
        ComposerKt.sourceInformation($composer2, "C(SkippableItem)P(1,3:c#foundation.lazy.layout.StableValue!,2:c#foundation.lazy.layout.StableValue)133@4709L84:LazyLayoutItemContentFactory.kt#wow0x6");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) itemProvider) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(saveableStateHolder) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(index) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(key) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1439843069, $dirty, -1, "androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:127)");
            }
            ((SaveableStateHolder) saveableStateHolder).SaveableStateProvider(key, ComposableLambdaKt.composableLambda($composer2, 980966366, true, new LazyLayoutItemContentFactoryKt$SkippableItem$1(itemProvider, index, key, $dirty)), $composer2, 568);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutItemContentFactoryKt$SkippableItem$2(itemProvider, saveableStateHolder, index, key, $changed));
        }
    }
}
