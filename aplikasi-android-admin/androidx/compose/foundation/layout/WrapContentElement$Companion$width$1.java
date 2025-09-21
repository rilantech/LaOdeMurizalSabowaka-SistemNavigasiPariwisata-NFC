package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke-5SAbXVA", "(JLandroidx/compose/ui/unit/LayoutDirection;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class WrapContentElement$Companion$width$1 extends Lambda implements Function2<IntSize, LayoutDirection, IntOffset> {
    final /* synthetic */ Alignment.Horizontal $align;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrapContentElement$Companion$width$1(Alignment.Horizontal horizontal) {
        super(2);
        this.$align = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return IntOffset.m7663boximpl(m2383invoke5SAbXVA(((IntSize) p1).m7718unboximpl(), (LayoutDirection) p2));
    }

    /* renamed from: invoke-5SAbXVA  reason: not valid java name */
    public final long m2383invoke5SAbXVA(long size, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return IntOffsetKt.IntOffset(this.$align.align(0, IntSize.m7714getWidthimpl(size), layoutDirection), 0);
    }
}
