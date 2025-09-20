package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001aM\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    public static final void LazyLayout(LazyLayoutItemProvider itemProvider, Modifier modifier, LazyLayoutPrefetchState prefetchState, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState;
        LazyLayoutPrefetchState prefetchState2;
        Modifier modifier3;
        Object value$iv$iv;
        LazyLayoutItemProvider lazyLayoutItemProvider = itemProvider;
        Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2 = measurePolicy;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(function2, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(852831187);
        ComposerKt.sourceInformation($composer2, "C(LazyLayout)P(!1,2,3)47@1918L16,47@1907L68:LazyLayout.kt#wow0x6");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) lazyLayoutItemProvider) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            lazyLayoutPrefetchState = prefetchState;
        } else if ((i2 & 896) == 0) {
            lazyLayoutPrefetchState = prefetchState;
            $dirty |= $composer2.changed((Object) lazyLayoutPrefetchState) ? 256 : 128;
        } else {
            lazyLayoutPrefetchState = prefetchState;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                prefetchState2 = null;
            } else {
                prefetchState2 = lazyLayoutPrefetchState;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(852831187, $dirty2, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:41)");
            }
            int i5 = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) lazyLayoutItemProvider);
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function0) new LazyLayoutKt$LazyLayout$1$1(lazyLayoutItemProvider);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            LazyLayout((Function0<? extends LazyLayoutItemProvider>) (Function0) value$iv$iv, modifier3, prefetchState2, measurePolicy, $composer2, ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            prefetchState2 = lazyLayoutPrefetchState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutKt$LazyLayout$2(itemProvider, modifier3, prefetchState2, measurePolicy, $changed, i));
        }
    }

    public static final void LazyLayout(Function0<? extends LazyLayoutItemProvider> itemProvider, Modifier modifier, LazyLayoutPrefetchState prefetchState, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState;
        LazyLayoutPrefetchState prefetchState2;
        Modifier modifier3;
        Modifier modifier4;
        LazyLayoutPrefetchState prefetchState3;
        Function0<? extends LazyLayoutItemProvider> function0 = itemProvider;
        Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2 = measurePolicy;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function0, "itemProvider");
        Intrinsics.checkNotNullParameter(function2, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(2002163445);
        ComposerKt.sourceInformation($composer2, "C(LazyLayout)P(!1,2,3)58@2285L34,60@2325L1039:LazyLayout.kt#wow0x6");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            lazyLayoutPrefetchState = prefetchState;
        } else if ((i2 & 896) == 0) {
            lazyLayoutPrefetchState = prefetchState;
            $dirty |= $composer2.changed((Object) lazyLayoutPrefetchState) ? 256 : 128;
        } else {
            lazyLayoutPrefetchState = prefetchState;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                prefetchState3 = null;
            } else {
                prefetchState3 = lazyLayoutPrefetchState;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, $dirty2, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
            }
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda($composer2, -1488997347, true, new LazyLayoutKt$LazyLayout$3(prefetchState3, modifier4, measurePolicy, $dirty2, SnapshotStateKt.rememberUpdatedState(function0, $composer2, $dirty2 & 14))), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            prefetchState2 = prefetchState3;
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            prefetchState2 = lazyLayoutPrefetchState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutKt$LazyLayout$4(itemProvider, modifier3, prefetchState2, measurePolicy, $changed, i));
        }
    }
}
