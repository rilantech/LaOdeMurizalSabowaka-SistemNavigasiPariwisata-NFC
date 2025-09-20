package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "value", "Landroidx/compose/material3/SheetValue;", "sheetSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-O0kMr_c", "(Landroidx/compose/material3/SheetValue;J)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2 extends Lambda implements Function2<SheetValue, IntSize, Float> {
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ SheetState $sheetState;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2(float f, SheetState sheetState) {
        super(2);
        this.$screenHeight = f;
        this.$sheetState = sheetState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1860invokeO0kMr_c((SheetValue) p1, ((IntSize) p2).m6008unboximpl());
    }

    /* renamed from: invoke-O0kMr_c  reason: not valid java name */
    public final Float m1860invokeO0kMr_c(SheetValue value, long sheetSize) {
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return Float.valueOf(this.$screenHeight);
            case 2:
                if (((float) IntSize.m6003getHeightimpl(sheetSize)) >= this.$screenHeight / ((float) 2) && !this.$sheetState.getSkipPartiallyExpanded$material3_release()) {
                    return Float.valueOf(this.$screenHeight / 2.0f);
                }
                return null;
            case 3:
                if (IntSize.m6003getHeightimpl(sheetSize) != 0) {
                    return Float.valueOf(Math.max(0.0f, this.$screenHeight - ((float) IntSize.m6003getHeightimpl(sheetSize))));
                }
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
