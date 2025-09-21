package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBar$3$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ State<Dp> $topPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBar$3$1(State<Dp> state, State<Float> state2) {
        super(3);
        this.$topPadding = state;
        this.$animationProgress = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return m3660invoke3p2s80s((MeasureScope) p1, (Measurable) p2, ((Constraints) p3).m7504unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m3660invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
        MeasureScope measureScope = $this$layout;
        Measurable measurable2 = measurable;
        Intrinsics.checkNotNullParameter(measureScope, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        final int animatedTopPadding = measureScope.m7529roundToPx0680j_4(DpKt.m7597lerpMdfbLM(this.$topPadding.getValue().m7568unboximpl(), Dp.m7554constructorimpl((float) 0), this.$animationProgress.getValue().floatValue()));
        int startWidth = RangesKt.coerceAtMost(Math.max(Constraints.m7500getMinWidthimpl(constraints), measureScope.m7529roundToPx0680j_4(SearchBarKt.getSearchBarMinWidth())), Math.min(Constraints.m7498getMaxWidthimpl(constraints), measureScope.m7529roundToPx0680j_4(SearchBarKt.SearchBarMaxWidth)));
        int startHeight = RangesKt.coerceAtMost(Math.max(Constraints.m7499getMinHeightimpl(constraints), measureScope.m7529roundToPx0680j_4(SearchBarDefaults.INSTANCE.m3655getInputFieldHeightD9Ej5fM())), Constraints.m7497getMaxHeightimpl(constraints));
        int endWidth = Constraints.m7498getMaxWidthimpl(constraints);
        int endHeight = Constraints.m7497getMaxHeightimpl(constraints);
        int width = MathHelpersKt.lerp(startWidth, endWidth, this.$animationProgress.getValue().floatValue());
        int height = MathHelpersKt.lerp(startHeight, endHeight, this.$animationProgress.getValue().floatValue()) + animatedTopPadding;
        final Placeable placeable = measurable2.m6399measureBRTryo0(ConstraintsKt.m7515offsetNN6EwU$default(Constraints.Companion.m7506fixedJhjzzOo(width, height), 0, -animatedTopPadding, 1, (Object) null));
        Placeable placeable2 = placeable;
        int i = height;
        return MeasureScope.layout$default($this$layout, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, animatedTopPadding, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
