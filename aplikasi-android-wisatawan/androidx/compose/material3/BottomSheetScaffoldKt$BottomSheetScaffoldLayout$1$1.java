package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $bottomSheet;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SheetValue.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(Function0<Float> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, SheetState sheetState, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i, Modifier modifier, long j, long j2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, float f) {
        super(2);
        this.$sheetOffset = function0;
        this.$topBar = function2;
        this.$snackbarHost = function22;
        this.$sheetState = sheetState;
        this.$bottomSheet = function3;
        this.$$dirty = i;
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$body = function32;
        this.$sheetPeekHeight = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1565invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5794unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1565invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        Placeable placeable;
        Object obj;
        final int snackbarOffsetY;
        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int layoutWidth = Constraints.m5788getMaxWidthimpl(constraints);
        int layoutHeight = Constraints.m5787getMaxHeightimpl(constraints);
        long looseConstraints = Constraints.m5779copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        final Placeable sheetPlaceable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(this.$bottomSheet, layoutHeight, this.$$dirty))).get(0).m4689measureBRTryo0(looseConstraints);
        int sheetOffsetY = MathKt.roundToInt(this.$sheetOffset.invoke().floatValue());
        int sheetOffsetX = Integer.max(0, (layoutWidth - sheetPlaceable.getWidth()) / 2);
        Function2<Composer, Integer, Unit> function2 = this.$topBar;
        if (function2 != null) {
            Function2<Composer, Integer, Unit> function22 = function2;
            placeable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(function2, this.$$dirty))).get(0).m4689measureBRTryo0(looseConstraints);
        } else {
            placeable = null;
        }
        Placeable topBarPlaceable = placeable;
        int topBarHeight = topBarPlaceable != null ? topBarPlaceable.getHeight() : 0;
        long bodyConstraints = Constraints.m5779copyZbe2FdA$default(looseConstraints, 0, 0, 0, layoutHeight - topBarHeight, 7, (Object) null);
        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Body;
        int sheetOffsetX2 = sheetOffsetX;
        Placeable topBarPlaceable2 = topBarPlaceable;
        int sheetOffsetY2 = sheetOffsetY;
        new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(this.$modifier, this.$containerColor, this.$contentColor, this.$$dirty, this.$body, this.$sheetPeekHeight);
        final Placeable bodyPlaceable = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, obj)).get(0).m4689measureBRTryo0(bodyConstraints);
        final Placeable snackbarPlaceable = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost).get(0).m4689measureBRTryo0(looseConstraints);
        int snackbarOffsetX = (layoutWidth - snackbarPlaceable.getWidth()) / 2;
        switch (WhenMappings.$EnumSwitchMapping$0[this.$sheetState.getCurrentValue().ordinal()]) {
            case 1:
                snackbarOffsetY = sheetOffsetY2 - snackbarPlaceable.getHeight();
                break;
            case 2:
            case 3:
                snackbarOffsetY = layoutHeight - snackbarPlaceable.getHeight();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        final int i = topBarHeight;
        final Placeable placeable2 = topBarPlaceable2;
        final int i2 = sheetOffsetX2;
        final int i3 = sheetOffsetY2;
        final int i4 = snackbarOffsetX;
        long j = bodyConstraints;
        return MeasureScope.layout$default(subcomposeMeasureScope, layoutWidth, layoutHeight, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default($this$layout, bodyPlaceable, 0, i, 0.0f, 4, (Object) null);
                Placeable placeable = placeable2;
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, 0, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope placementScope = $this$layout;
                Placeable.PlacementScope.placeRelative$default(placementScope, sheetPlaceable, i2, i3, 0.0f, 4, (Object) null);
                Placeable.PlacementScope.placeRelative$default(placementScope, snackbarPlaceable, i4, snackbarOffsetY, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
