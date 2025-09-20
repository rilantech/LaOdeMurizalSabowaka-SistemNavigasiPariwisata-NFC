package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$StandardBottomSheet$2$1 extends Lambda implements Function2<SheetValue, IntSize, Float> {
    final /* synthetic */ float $layoutHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ SheetState $state;

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
    BottomSheetScaffoldKt$StandardBottomSheet$2$1(SheetState sheetState, float f, float f2) {
        super(2);
        this.$state = sheetState;
        this.$layoutHeight = f;
        this.$peekHeightPx = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1566invokeO0kMr_c((SheetValue) p1, ((IntSize) p2).m6008unboximpl());
    }

    /* renamed from: invoke-O0kMr_c  reason: not valid java name */
    public final Float m1566invokeO0kMr_c(SheetValue value, long sheetSize) {
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                if (this.$state.getSkipPartiallyExpanded$material3_release()) {
                    return null;
                }
                return Float.valueOf(this.$layoutHeight - this.$peekHeightPx);
            case 2:
                if (IntSize.m6003getHeightimpl(sheetSize) == MathKt.roundToInt(this.$peekHeightPx)) {
                    return null;
                }
                return Float.valueOf(Float.max(0.0f, this.$layoutHeight - ((float) IntSize.m6003getHeightimpl(sheetSize))));
            case 3:
                if (this.$state.getSkipHiddenState$material3_release()) {
                    return null;
                }
                return Float.valueOf(this.$layoutHeight);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
