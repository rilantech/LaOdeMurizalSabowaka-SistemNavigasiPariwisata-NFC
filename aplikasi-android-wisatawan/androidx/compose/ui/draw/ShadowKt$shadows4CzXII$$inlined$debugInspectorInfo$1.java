package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class ShadowKt$shadows4CzXII$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ long $ambientColor$inlined;
    final /* synthetic */ boolean $clip$inlined;
    final /* synthetic */ float $elevation$inlined;
    final /* synthetic */ Shape $shape$inlined;
    final /* synthetic */ long $spotColor$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowKt$shadows4CzXII$$inlined$debugInspectorInfo$1(float f, Shape shape, boolean z, long j, long j2) {
        super(1);
        this.$elevation$inlined = f;
        this.$shape$inlined = shape;
        this.$clip$inlined = z;
        this.$ambientColor$inlined = j;
        this.$spotColor$inlined = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$shadow_s4CzXII_u24lambda_u240 = $this$null;
        $this$shadow_s4CzXII_u24lambda_u240.setName("shadow");
        $this$shadow_s4CzXII_u24lambda_u240.getProperties().set("elevation", Dp.m5842boximpl(this.$elevation$inlined));
        $this$shadow_s4CzXII_u24lambda_u240.getProperties().set("shape", this.$shape$inlined);
        $this$shadow_s4CzXII_u24lambda_u240.getProperties().set("clip", Boolean.valueOf(this.$clip$inlined));
        $this$shadow_s4CzXII_u24lambda_u240.getProperties().set("ambientColor", Color.m3243boximpl(this.$ambientColor$inlined));
        $this$shadow_s4CzXII_u24lambda_u240.getProperties().set("spotColor", Color.m3243boximpl(this.$spotColor$inlined));
    }
}
