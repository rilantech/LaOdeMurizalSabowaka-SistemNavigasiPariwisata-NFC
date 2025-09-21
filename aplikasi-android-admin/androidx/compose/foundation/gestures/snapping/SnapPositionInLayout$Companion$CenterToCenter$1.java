package androidx.compose.foundation.gestures.snapping;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/unit/Density;", "layoutSize", "itemSize", "<anonymous parameter 2>"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapPositionInLayout.kt */
final class SnapPositionInLayout$Companion$CenterToCenter$1 implements SnapPositionInLayout {
    public static final SnapPositionInLayout$Companion$CenterToCenter$1 INSTANCE = new SnapPositionInLayout$Companion$CenterToCenter$1();

    SnapPositionInLayout$Companion$CenterToCenter$1() {
    }

    public final int position(Density $this$SnapPositionInLayout, int layoutSize, int itemSize, int i) {
        Intrinsics.checkNotNullParameter($this$SnapPositionInLayout, "$this$SnapPositionInLayout");
        return (layoutSize / 2) - (itemSize / 2);
    }
}
