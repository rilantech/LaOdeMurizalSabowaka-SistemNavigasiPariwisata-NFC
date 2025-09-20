package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
final class SimpleGraphicsLayerModifier$layerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ SimpleGraphicsLayerModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleGraphicsLayerModifier$layerBlock$1(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        super(1);
        this.this$0 = simpleGraphicsLayerModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        $this$null.setScaleX(this.this$0.getScaleX());
        $this$null.setScaleY(this.this$0.getScaleY());
        $this$null.setAlpha(this.this$0.getAlpha());
        $this$null.setTranslationX(this.this$0.getTranslationX());
        $this$null.setTranslationY(this.this$0.getTranslationY());
        $this$null.setShadowElevation(this.this$0.getShadowElevation());
        $this$null.setRotationX(this.this$0.getRotationX());
        $this$null.setRotationY(this.this$0.getRotationY());
        $this$null.setRotationZ(this.this$0.getRotationZ());
        $this$null.setCameraDistance(this.this$0.getCameraDistance());
        $this$null.m3443setTransformOrigin__ExYCQ(this.this$0.m3616getTransformOriginSzJe1aQ());
        $this$null.setShape(this.this$0.getShape());
        $this$null.setClip(this.this$0.getClip());
        $this$null.setRenderEffect(this.this$0.getRenderEffect());
        $this$null.m3440setAmbientShadowColor8_81llA(this.this$0.m3613getAmbientShadowColor0d7_KjU());
        $this$null.m3442setSpotShadowColor8_81llA(this.this$0.m3615getSpotShadowColor0d7_KjU());
        $this$null.m3441setCompositingStrategyaDBOjCE(this.this$0.m3614getCompositingStrategyNrFUSI());
    }
}
