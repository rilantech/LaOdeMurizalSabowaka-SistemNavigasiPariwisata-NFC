package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"toAndroidVertexMode", "Landroid/graphics/Canvas$VertexMode;", "Landroidx/compose/ui/graphics/VertexMode;", "toAndroidVertexMode-JOOmi9M", "(I)Landroid/graphics/Canvas$VertexMode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidVertexMode.android.kt */
public final class AndroidVertexMode_androidKt {
    /* renamed from: toAndroidVertexMode-JOOmi9M  reason: not valid java name */
    public static final Canvas.VertexMode m3150toAndroidVertexModeJOOmi9M(int $this$toAndroidVertexMode_u2dJOOmi9M) {
        if (VertexMode.m3684equalsimpl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.Companion.m3690getTrianglesc2xauaI())) {
            return Canvas.VertexMode.TRIANGLES;
        }
        if (VertexMode.m3684equalsimpl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.Companion.m3689getTriangleStripc2xauaI())) {
            return Canvas.VertexMode.TRIANGLE_STRIP;
        }
        if (VertexMode.m3684equalsimpl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.Companion.m3688getTriangleFanc2xauaI())) {
            return Canvas.VertexMode.TRIANGLE_FAN;
        }
        return Canvas.VertexMode.TRIANGLES;
    }
}
