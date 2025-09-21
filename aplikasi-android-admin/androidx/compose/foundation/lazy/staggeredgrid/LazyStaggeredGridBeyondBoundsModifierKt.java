package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"lazyStaggeredGridBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridBeyondBoundsModifier.kt */
public final class LazyStaggeredGridBeyondBoundsModifierKt {
    public static final Modifier lazyStaggeredGridBeyondBoundsModifier(Modifier $this$lazyStaggeredGridBeyondBoundsModifier, LazyStaggeredGridState state, boolean reverseLayout, Orientation orientation, Composer $composer, int $changed) {
        LazyStaggeredGridBeyondBoundsState value$iv$iv;
        Modifier modifier = $this$lazyStaggeredGridBeyondBoundsModifier;
        LazyStaggeredGridState lazyStaggeredGridState = state;
        Orientation orientation2 = orientation;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        composer.startReplaceableGroup(-1763226771);
        ComposerKt.sourceInformation(composer, "C(lazyStaggeredGridBeyondBoundsModifier)P(2,1)37@1484L7,38@1520L73,41@1615L335:LazyStaggeredGridBeyondBoundsModifier.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763226771, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.lazyStaggeredGridBeyondBoundsModifier (LazyStaggeredGridBeyondBoundsModifier.kt:32)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) lazyStaggeredGridState);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new LazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        LazyStaggeredGridBeyondBoundsState beyondBoundsState = value$iv$iv;
        Object[] keys$iv = {beyondBoundsState, lazyStaggeredGridState, Boolean.valueOf(reverseLayout), layoutDirection, orientation2};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv2 = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            value$iv$iv2 = new LazyLayoutBeyondBoundsModifierLocal(beyondBoundsState, state.getBeyondBoundsInfo$foundation_release(), reverseLayout, layoutDirection, orientation);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) value$iv$iv2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }
}
