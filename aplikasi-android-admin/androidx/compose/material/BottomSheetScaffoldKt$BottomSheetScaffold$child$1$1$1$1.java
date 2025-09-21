package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Landroidx/compose/material/BottomSheetValue;", "", "sheetSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)Ljava/util/Map;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1 extends Lambda implements Function1<IntSize, Map<BottomSheetValue, ? extends Float>> {
    final /* synthetic */ int $layoutHeight;
    final /* synthetic */ float $peekHeightPx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(int i, float f) {
        super(1);
        this.$layoutHeight = i;
        this.$peekHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m2910invokeozmzZPI(((IntSize) p1).m7718unboximpl());
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final Map<BottomSheetValue, Float> m2910invokeozmzZPI(long sheetSize) {
        float sheetHeight = (float) IntSize.m7713getHeightimpl(sheetSize);
        float f = this.$peekHeightPx;
        float collapsedHeight = ((float) this.$layoutHeight) - f;
        if (!(sheetHeight == 0.0f)) {
            if (!(sheetHeight == f)) {
                return MapsKt.mapOf(TuplesKt.to(BottomSheetValue.Collapsed, Float.valueOf(collapsedHeight)), TuplesKt.to(BottomSheetValue.Expanded, Float.valueOf(((float) this.$layoutHeight) - sheetHeight)));
            }
        }
        return MapsKt.mapOf(TuplesKt.to(BottomSheetValue.Collapsed, Float.valueOf(collapsedHeight)));
    }
}
