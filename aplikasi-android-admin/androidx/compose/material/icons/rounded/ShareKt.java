package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_share", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Share", "Landroidx/compose/material/icons/Icons$Rounded;", "getShare", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Share.kt */
public final class ShareKt {
    private static ImageVector _share;

    public static final ImageVector getShare(Icons.Rounded $this$Share) {
        Intrinsics.checkNotNullParameter($this$Share, "<this>");
        ImageVector imageVector = _share;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Share__u24lambda_u241 = new ImageVector.Builder("Rounded.Share", Dp.m7554constructorimpl(24.0f), Dp.m7554constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv = $this$_get_Share__u24lambda_u241;
        int strokeLineCap$iv$iv = StrokeCap.Companion.m5351getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m5361getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.Share";
        ImageVector.Builder builder = $this$_get_Share__u24lambda_u241;
        PathBuilder $this$_get_Share__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        $this$_get_Share__u24lambda_u241_u24lambda_u240.moveTo(18.0f, 16.08f);
        PathBuilder pathBuilder = $this$_get_Share__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(-0.76f, 0.0f, -1.44f, 0.3f, -1.96f, 0.77f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.lineTo(8.91f, 12.7f);
        pathBuilder.curveToRelative(0.05f, -0.23f, 0.09f, -0.46f, 0.09f, -0.7f);
        ImageVector.Builder builder2 = $this$materialPath_u2dYwgOQQI_u24default$iv;
        $this$_get_Share__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-0.04f, -0.47f, -0.09f, -0.7f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.lineToRelative(7.05f, -4.11f);
        pathBuilder.curveToRelative(0.54f, 0.5f, 1.25f, 0.81f, 2.04f, 0.81f);
        pathBuilder.curveToRelative(1.66f, 0.0f, 3.0f, -1.34f, 3.0f, -3.0f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-1.34f, -3.0f, -3.0f, -3.0f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-3.0f, 1.34f, -3.0f, 3.0f);
        pathBuilder.curveToRelative(0.0f, 0.24f, 0.04f, 0.47f, 0.09f, 0.7f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.lineTo(8.04f, 9.81f);
        pathBuilder.curveTo(7.5f, 9.31f, 6.79f, 9.0f, 6.0f, 9.0f);
        pathBuilder.curveToRelative(-1.66f, 0.0f, -3.0f, 1.34f, -3.0f, 3.0f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(1.34f, 3.0f, 3.0f, 3.0f);
        pathBuilder.curveToRelative(0.79f, 0.0f, 1.5f, -0.31f, 2.04f, -0.81f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.lineToRelative(7.12f, 4.16f);
        pathBuilder.curveToRelative(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f);
        pathBuilder.curveToRelative(0.0f, 1.61f, 1.31f, 2.92f, 2.92f, 2.92f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(2.92f, -1.31f, 2.92f, -2.92f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-1.31f, -2.92f, -2.92f, -2.92f);
        $this$_get_Share__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m5677addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m4989getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _share = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
