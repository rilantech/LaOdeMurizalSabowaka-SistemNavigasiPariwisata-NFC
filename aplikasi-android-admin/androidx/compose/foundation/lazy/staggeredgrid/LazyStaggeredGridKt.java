package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGrid.kt */
public final class LazyStaggeredGridKt {
    /* renamed from: LazyStaggeredGrid-LJWHXA8  reason: not valid java name */
    public static final void m2487LazyStaggeredGridLJWHXA8(LazyStaggeredGridState state, Orientation orientation, Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> slots, Modifier modifier, PaddingValues contentPadding, boolean reverseLayout, FlingBehavior flingBehavior, boolean userScrollEnabled, float mainAxisSpacing, float crossAxisSpacing, Function1<? super LazyStaggeredGridScope, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        FlingBehavior flingBehavior2;
        int $dirty;
        boolean userScrollEnabled2;
        float mainAxisSpacing2;
        float crossAxisSpacing2;
        LazyStaggeredGridState lazyStaggeredGridState = state;
        Orientation orientation2 = orientation;
        Function1<? super LazyStaggeredGridScope, Unit> function1 = content;
        int i2 = i;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(function1, "content");
        Composer $composer2 = $composer.startRestartGroup(1320541636);
        ComposerKt.sourceInformation($composer2, "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)53@2453L15,63@2869L18,65@2918L55,66@2998L218,76@3241L60,78@3307L48,84@3506L277,92@3847L172,101@4243L7,80@3361L1366:LazyStaggeredGrid.kt#fzvcnm");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i2 & 8) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i2 & 16) != 0) {
            contentPadding2 = PaddingKt.m2241PaddingValues0680j_4(Dp.m7554constructorimpl((float) 0));
        } else {
            contentPadding2 = contentPadding;
        }
        if ((i2 & 32) != 0) {
            reverseLayout2 = false;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((i2 & 64) != 0) {
            $dirty = $dirty2 & -3670017;
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
        } else {
            flingBehavior2 = flingBehavior;
            $dirty = $dirty2;
        }
        if ((i2 & 128) != 0) {
            userScrollEnabled2 = true;
        } else {
            userScrollEnabled2 = userScrollEnabled;
        }
        if ((i2 & 256) != 0) {
            mainAxisSpacing2 = Dp.m7554constructorimpl((float) 0);
        } else {
            mainAxisSpacing2 = mainAxisSpacing;
        }
        if ((i2 & 512) != 0) {
            crossAxisSpacing2 = Dp.m7554constructorimpl((float) 0);
        } else {
            crossAxisSpacing2 = crossAxisSpacing;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1320541636, $dirty, $dirty1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer2, 6);
        Function0<LazyStaggeredGridItemProvider> rememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, $composer2, (($dirty1 << 3) & 112) | 8);
        Function0<LazyStaggeredGridItemProvider> function0 = rememberStaggeredGridItemProviderLambda;
        int $dirty3 = $dirty;
        boolean reverseLayout3 = reverseLayout2;
        Modifier modifier3 = modifier2;
        int i3 = $dirty1;
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> r23 = LazyStaggeredGridMeasurePolicyKt.m2497rememberStaggeredGridMeasurePolicynbWgWpA(state, rememberStaggeredGridItemProviderLambda, contentPadding2, reverseLayout2, orientation, mainAxisSpacing2, crossAxisSpacing2, slots, $composer2, (($dirty >> 6) & 896) | 8 | (($dirty >> 6) & 7168) | (($dirty << 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty << 15) & 29360128));
        LazyLayoutSemanticState semanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, reverseLayout3, $composer2, (($dirty3 >> 12) & 112) | 8);
        ScrollPositionUpdater(function0, lazyStaggeredGridState, $composer2, 64);
        Composer composer = $composer2;
        OverscrollEffect overscrollEffect2 = overscrollEffect;
        Modifier overscroll = OverscrollKt.overscroll(LazyStaggeredGridBeyondBoundsModifierKt.lazyStaggeredGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(state.getRemeasurementModifier$foundation_release()).then(state.getAwaitLayoutModifier$foundation_release()), function0, semanticState, orientation, userScrollEnabled2, reverseLayout3, $composer2, (($dirty3 << 6) & 7168) | (($dirty3 >> 9) & 57344) | ($dirty3 & 458752)), orientation2), state, reverseLayout3, orientation, composer, (($dirty3 >> 9) & 896) | 64 | (($dirty3 << 6) & 7168)), overscrollEffect2);
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LazyLayoutKt.LazyLayout((Function0<? extends LazyLayoutItemProvider>) function0, ScrollableKt.scrollable(overscroll, lazyStaggeredGridState, orientation, overscrollEffect2, userScrollEnabled2, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation2, reverseLayout3), flingBehavior2, state.getMutableInteractionSource$foundation_release()), state.getPrefetchState$foundation_release(), (Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult>) r23, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            OverscrollEffect overscrollEffect3 = overscrollEffect2;
            Composer composer2 = $composer2;
            boolean z = reverseLayout3;
            Modifier modifier4 = modifier3;
            Function0<LazyStaggeredGridItemProvider> function02 = function0;
            return;
        }
        OverscrollEffect overscrollEffect4 = overscrollEffect2;
        Composer composer3 = $composer2;
        boolean z2 = reverseLayout3;
        Modifier modifier5 = modifier3;
        Function0<LazyStaggeredGridItemProvider> function03 = function0;
        endRestartGroup.updateScope(new LazyStaggeredGridKt$LazyStaggeredGrid$1(state, orientation, slots, modifier3, contentPadding2, reverseLayout3, flingBehavior2, userScrollEnabled2, mainAxisSpacing2, crossAxisSpacing2, content, $changed, $changed1, i));
    }

    /* access modifiers changed from: private */
    public static final void ScrollPositionUpdater(Function0<? extends LazyLayoutItemProvider> itemProviderLambda, LazyStaggeredGridState state, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(661612410);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyStaggeredGrid.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(661612410, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:120)");
        }
        LazyLayoutItemProvider itemProvider = (LazyLayoutItemProvider) itemProviderLambda.invoke();
        if (itemProvider.getItemCount() > 0) {
            LazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(state, itemProvider, (int[]) null, 2, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyStaggeredGridKt$ScrollPositionUpdater$1(itemProviderLambda, state, $changed));
        }
    }
}
