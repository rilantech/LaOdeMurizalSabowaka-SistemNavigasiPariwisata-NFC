package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderModifierNode$drawWithCacheModifierNode$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ BorderModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderModifierNode$drawWithCacheModifierNode$1(BorderModifierNode borderModifierNode) {
        super(1);
        this.this$0 = borderModifierNode;
    }

    public final DrawResult invoke(CacheDrawScope $this$CacheDrawModifierNode) {
        CacheDrawScope cacheDrawScope = $this$CacheDrawModifierNode;
        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$CacheDrawModifierNode");
        if (!(cacheDrawScope.m7535toPx0680j_4(this.this$0.m1895getWidthD9Ej5fM()) >= 0.0f && Size.m4781getMinDimensionimpl($this$CacheDrawModifierNode.m4614getSizeNHjbRc()) > 0.0f)) {
            return BorderKt.drawContentWithoutBorder($this$CacheDrawModifierNode);
        }
        float f = (float) 2;
        float strokeWidthPx = Math.min(Dp.m7559equalsimpl0(this.this$0.m1895getWidthD9Ej5fM(), Dp.Companion.m7572getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil((double) cacheDrawScope.m7535toPx0680j_4(this.this$0.m1895getWidthD9Ej5fM())), (float) Math.ceil((double) (Size.m4781getMinDimensionimpl($this$CacheDrawModifierNode.m4614getSizeNHjbRc()) / f)));
        float halfStroke = strokeWidthPx / f;
        long topLeft = OffsetKt.Offset(halfStroke, halfStroke);
        long borderSize = SizeKt.Size(Size.m4782getWidthimpl($this$CacheDrawModifierNode.m4614getSizeNHjbRc()) - strokeWidthPx, Size.m4779getHeightimpl($this$CacheDrawModifierNode.m4614getSizeNHjbRc()) - strokeWidthPx);
        boolean fillArea = f * strokeWidthPx > Size.m4781getMinDimensionimpl($this$CacheDrawModifierNode.m4614getSizeNHjbRc());
        Outline outline = this.this$0.getShape().m5322createOutlinePq9zytI($this$CacheDrawModifierNode.m4614getSizeNHjbRc(), $this$CacheDrawModifierNode.getLayoutDirection(), cacheDrawScope);
        if (outline instanceof Outline.Generic) {
            BorderModifierNode borderModifierNode = this.this$0;
            return borderModifierNode.drawGenericBorder($this$CacheDrawModifierNode, borderModifierNode.getBrush(), (Outline.Generic) outline, fillArea, strokeWidthPx);
        } else if (outline instanceof Outline.Rounded) {
            BorderModifierNode borderModifierNode2 = this.this$0;
            Outline outline2 = outline;
            float f2 = halfStroke;
            return borderModifierNode2.m1894drawRoundRectBorderJqoCqck($this$CacheDrawModifierNode, borderModifierNode2.getBrush(), (Outline.Rounded) outline, topLeft, borderSize, fillArea, strokeWidthPx);
        } else {
            float f3 = halfStroke;
            if (outline instanceof Outline.Rectangle) {
                return BorderKt.m1891drawRectBorderNsqcLGU($this$CacheDrawModifierNode, this.this$0.getBrush(), topLeft, borderSize, fillArea, strokeWidthPx);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
