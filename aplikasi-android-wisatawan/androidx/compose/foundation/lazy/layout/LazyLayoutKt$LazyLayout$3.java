package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "invoke", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$3 extends Lambda implements Function3<SaveableStateHolder, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ State<Function0<LazyLayoutItemProvider>> $currentItemProvider;
    final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$3(LazyLayoutPrefetchState lazyLayoutPrefetchState, Modifier modifier, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, int i, State<? extends Function0<? extends LazyLayoutItemProvider>> state) {
        super(3);
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$modifier = modifier;
        this.$measurePolicy = function2;
        this.$$dirty = i;
        this.$currentItemProvider = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((SaveableStateHolder) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SaveableStateHolder saveableStateHolder, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Function2 value$iv$iv3;
        SaveableStateHolder saveableStateHolder2 = saveableStateHolder;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(saveableStateHolder2, "saveableStateHolder");
        ComposerKt.sourceInformation(composer, "C61@2415L114,64@2566L101,78@2956L392,75@2869L489:LazyLayout.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1488997347, $changed, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:60)");
        } else {
            int i = $changed;
        }
        State<Function0<LazyLayoutItemProvider>> state = this.$currentItemProvider;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new LazyLayoutItemContentFactory(saveableStateHolder2, new LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1(state));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        LazyLayoutItemContentFactory itemContentFactory = (LazyLayoutItemContentFactory) value$iv$iv;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = new SubcomposeLayoutState((SubcomposeSlotReusePolicy) new LazyLayoutItemReusePolicy(itemContentFactory));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) value$iv$iv2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState = this.$prefetchState;
        composer.startReplaceableGroup(-1523808190);
        ComposerKt.sourceInformation(composer, "*68@2709L140");
        if (lazyLayoutPrefetchState != null) {
            LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.$prefetchState, itemContentFactory, subcomposeLayoutState, composer, ((this.$$dirty >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
            Unit unit = Unit.INSTANCE;
        }
        $composer.endReplaceableGroup();
        Modifier modifier = this.$modifier;
        Object key2$iv = this.$measurePolicy;
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = this.$measurePolicy;
        int i2 = ((this.$$dirty >> 6) & 112) | 8;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) itemContentFactory) | composer.changed(key2$iv);
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (invalid$iv$iv || it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = new LazyLayoutKt$LazyLayout$3$2$1(itemContentFactory, function2);
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        SubcomposeLayoutState subcomposeLayoutState2 = subcomposeLayoutState;
        SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState2, modifier, (Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>) value$iv$iv3, $composer, SubcomposeLayoutState.$stable | (this.$$dirty & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
