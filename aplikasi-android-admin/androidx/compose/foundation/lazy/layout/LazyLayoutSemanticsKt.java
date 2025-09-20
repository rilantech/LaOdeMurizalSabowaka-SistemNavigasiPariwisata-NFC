package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"lazyLayoutSemantics", "Landroidx/compose/ui/Modifier;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
public final class LazyLayoutSemanticsKt {
    public static final Modifier lazyLayoutSemantics(Modifier $this$lazyLayoutSemantics, Function0<? extends LazyLayoutItemProvider> itemProviderLambda, LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Modifier modifier = $this$lazyLayoutSemantics;
        Function0<? extends LazyLayoutItemProvider> function0 = itemProviderLambda;
        LazyLayoutSemanticState lazyLayoutSemanticState = state;
        Orientation orientation2 = orientation;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function0, "itemProviderLambda");
        Intrinsics.checkNotNullParameter(lazyLayoutSemanticState, "state");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        composer.startReplaceableGroup(1070136913);
        ComposerKt.sourceInformation(composer, "C(lazyLayoutSemantics)P(!1,3!1,4)47@1936L24,49@1991L3667:LazyLayoutSemantics.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1070136913, $changed, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:40)");
        } else {
            int i = $changed;
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
        Composer composer$iv = $composer;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv$iv = $composer;
        Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
        $composer.endReplaceableGroup();
        CoroutineScope coroutineScope2 = coroutineScope;
        Object[] keys$iv = {function0, lazyLayoutSemanticState, orientation2, Boolean.valueOf(userScrollEnabled)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            Object[] objArr = keys$iv;
            boolean isVertical = orientation2 == Orientation.Vertical;
            boolean z = isVertical;
            value$iv$iv = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1(new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(function0), isVertical, new ScrollAxisRange(new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1(lazyLayoutSemanticState), new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2(function0, lazyLayoutSemanticState), reverseScrolling), userScrollEnabled ? new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1(isVertical, coroutineScope2, lazyLayoutSemanticState) : null, userScrollEnabled ? new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1(function0, coroutineScope2, lazyLayoutSemanticState) : null, state.collectionInfo()), 1, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object[] objArr2 = keys$iv;
            value$iv$iv = it$iv$iv;
            int $i$f$remember = reverseScrolling;
        }
        $composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) value$iv$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }
}
