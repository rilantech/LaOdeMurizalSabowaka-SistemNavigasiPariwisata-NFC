package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
public final class LazySaveableStateHolderKt {
    public static final void LazySaveableStateHolderProvider(Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(674185128);
        ComposerKt.sourceInformation($composer2, "C(LazySaveableStateHolderProvider)42@2089L7,43@2114L172,48@2291L161:LazySaveableStateHolder.kt#wow0x6");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(674185128, $dirty2, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SaveableStateRegistry currentRegistry = (SaveableStateRegistry) consume;
            LazySaveableStateHolder holder = (LazySaveableStateHolder) RememberSaveableKt.rememberSaveable(new Object[]{currentRegistry}, LazySaveableStateHolder.Companion.saver(currentRegistry), (String) null, new LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1(currentRegistry), $composer2, 72, 4);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(holder)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 1863926504, true, new LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1(holder, content, $dirty2)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2(content, $changed));
        }
    }
}
