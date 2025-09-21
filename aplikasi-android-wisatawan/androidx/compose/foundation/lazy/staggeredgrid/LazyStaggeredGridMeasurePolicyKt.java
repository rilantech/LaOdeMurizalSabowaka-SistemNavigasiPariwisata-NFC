package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u001d\u0010\u0014\u001a\u0019\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0001¢\u0006\u0002\b\u0005H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a,\u0010\u0019\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a,\u0010\u001d\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a$\u0010\u001e\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "slots", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "rememberStaggeredGridMeasurePolicy-nbWgWpA", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
public final class LazyStaggeredGridMeasurePolicyKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: rememberStaggeredGridMeasurePolicy-nbWgWpA  reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m787rememberStaggeredGridMeasurePolicynbWgWpA(LazyStaggeredGridState state, Function0<? extends LazyStaggeredGridItemProvider> itemProviderLambda, PaddingValues contentPadding, boolean reverseLayout, Orientation orientation, float mainAxisSpacing, float crossAxisSpacing, Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> slots, Composer $composer, int $changed) {
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(itemProviderLambda, "itemProviderLambda");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(slots, "slots");
        composer.startReplaceableGroup(-2134671531);
        ComposerKt.sourceInformation(composer, "C(rememberStaggeredGridMeasurePolicy)P(7,2!1,5,4,3:c#ui.unit.Dp,1:c#ui.unit.Dp)47@2059L2713:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134671531, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:38)");
        } else {
            int i = $changed;
        }
        Object[] keys$iv = {state, itemProviderLambda, contentPadding, Boolean.valueOf(reverseLayout), orientation, Dp.m5842boximpl(mainAxisSpacing), Dp.m5842boximpl(crossAxisSpacing), slots};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(orientation, slots, itemProviderLambda, state, contentPadding, reverseLayout, mainAxisSpacing);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* access modifiers changed from: private */
    public static final float startPadding(PaddingValues $this$startPadding, Orientation orientation, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return PaddingKt.calculateStartPadding($this$startPadding, layoutDirection);
            case 2:
                return $this$startPadding.m555calculateTopPaddingD9Ej5fM();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final float beforePadding(PaddingValues $this$beforePadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$beforePadding.m552calculateBottomPaddingD9Ej5fM() : $this$beforePadding.m555calculateTopPaddingD9Ej5fM();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateEndPadding($this$beforePadding, layoutDirection);
                }
                return PaddingKt.calculateStartPadding($this$beforePadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final float afterPadding(PaddingValues $this$afterPadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$afterPadding.m555calculateTopPaddingD9Ej5fM() : $this$afterPadding.m552calculateBottomPaddingD9Ej5fM();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateStartPadding($this$afterPadding, layoutDirection);
                }
                return PaddingKt.calculateEndPadding($this$afterPadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
