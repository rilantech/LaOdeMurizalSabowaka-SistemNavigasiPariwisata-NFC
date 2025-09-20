package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$1 extends Lambda implements Function2<DismissValue, IntSize, Float> {
    final /* synthetic */ Set<DismissDirection> $directions;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SwipeToDismiss.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DismissValue.values().length];
            try {
                iArr[DismissValue.DismissedToEnd.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DismissValue.DismissedToStart.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DismissValue.Default.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$1(Set<? extends DismissDirection> set) {
        super(2);
        this.$directions = set;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m2073invokeO0kMr_c((DismissValue) p1, ((IntSize) p2).m6008unboximpl());
    }

    /* renamed from: invoke-O0kMr_c  reason: not valid java name */
    public final Float m2073invokeO0kMr_c(DismissValue value, long layoutSize) {
        Intrinsics.checkNotNullParameter(value, "value");
        float width = (float) IntSize.m6004getWidthimpl(layoutSize);
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                if (this.$directions.contains(DismissDirection.StartToEnd)) {
                    return Float.valueOf(width);
                }
                return null;
            case 2:
                if (this.$directions.contains(DismissDirection.EndToStart)) {
                    return Float.valueOf(-width);
                }
                return null;
            case 3:
                return Float.valueOf(0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
