package androidx.compose.material.icons.twotone;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Face.kt */
public final class FaceKt {
    private static ImageVector _face;

    public static final ImageVector getFace(Icons.TwoTone $this$Face) {
        Intrinsics.checkNotNullParameter($this$Face, "<this>");
        ImageVector imageVector = _face;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Face__u24lambda_u244 = new ImageVector.Builder("TwoTone.Face", Dp.m5844constructorimpl(24.0f), Dp.m5844constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3641getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3651getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        PathBuilder $this$_get_Face__u24lambda_u244_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        Object obj = "TwoTone.Face";
        $this$_get_Face__u24lambda_u244_u24lambda_u240.moveTo(17.5f, 8.0f);
        PathBuilder pathBuilder = $this$_get_Face__u24lambda_u244_u24lambda_u240;
        pathBuilder.curveToRelative(0.46f, 0.0f, 0.91f, -0.05f, 1.34f, -0.12f);
        pathBuilder.curveTo(17.44f, 5.56f, 14.9f, 4.0f, 12.0f, 4.0f);
        pathBuilder.curveToRelative(-0.46f, 0.0f, -0.91f, 0.05f, -1.34f, 0.12f);
        pathBuilder.curveTo(12.06f, 6.44f, 14.6f, 8.0f, 17.5f, 8.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u240.close();
        $this$_get_Face__u24lambda_u244_u24lambda_u240.moveTo(8.08f, 5.03f);
        pathBuilder.curveTo(6.37f, 6.0f, 5.05f, 7.58f, 4.42f, 9.47f);
        pathBuilder.curveToRelative(1.71f, -0.97f, 3.03f, -2.55f, 3.66f, -4.44f);
        $this$_get_Face__u24lambda_u244_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector.Builder.m3967addPathoIyEayM$default($this$_get_Face__u24lambda_u244, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3279getBlack0d7_KjU(), (DefaultConstructorMarker) null), 0.3f, (Brush) null, 0.3f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv = $this$_get_Face__u24lambda_u244;
        int strokeLineCap$iv$iv2 = StrokeCap.Companion.m3641getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.Companion.m3651getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        PathBuilder $this$_get_Face__u24lambda_u244_u24lambda_u241 = $this$PathData_u24lambda_u240$iv$iv$iv2;
        ImageVector.Builder builder = $this$materialPath_u2dYwgOQQI_u24default$iv;
        $this$_get_Face__u24lambda_u244_u24lambda_u241.moveTo(12.0f, 2.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.close();
        $this$_get_Face__u24lambda_u244_u24lambda_u241.moveTo(12.0f, 4.0f);
        PathBuilder pathBuilder2 = $this$_get_Face__u24lambda_u244_u24lambda_u241;
        pathBuilder2.curveToRelative(2.9f, 0.0f, 5.44f, 1.56f, 6.84f, 3.88f);
        pathBuilder2.curveToRelative(-0.43f, 0.07f, -0.88f, 0.12f, -1.34f, 0.12f);
        pathBuilder2.curveToRelative(-2.9f, 0.0f, -5.44f, -1.56f, -6.84f, -3.88f);
        pathBuilder2.curveToRelative(0.43f, -0.07f, 0.88f, -0.12f, 1.34f, -0.12f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.close();
        $this$_get_Face__u24lambda_u244_u24lambda_u241.moveTo(8.08f, 5.03f);
        pathBuilder2.curveTo(7.45f, 6.92f, 6.13f, 8.5f, 4.42f, 9.47f);
        pathBuilder2.curveTo(5.05f, 7.58f, 6.37f, 6.0f, 8.08f, 5.03f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.close();
        $this$_get_Face__u24lambda_u244_u24lambda_u241.moveTo(12.0f, 20.0f);
        pathBuilder2.curveToRelative(-4.41f, 0.0f, -8.0f, -3.59f, -8.0f, -8.0f);
        pathBuilder2.curveToRelative(0.0f, -0.05f, 0.01f, -0.1f, 0.01f, -0.15f);
        pathBuilder2.curveToRelative(2.6f, -0.98f, 4.68f, -2.99f, 5.74f, -5.55f);
        pathBuilder2.curveToRelative(1.83f, 2.26f, 4.62f, 3.7f, 7.75f, 3.7f);
        pathBuilder2.curveToRelative(0.75f, 0.0f, 1.47f, -0.09f, 2.17f, -0.24f);
        pathBuilder2.curveToRelative(0.21f, 0.71f, 0.33f, 1.46f, 0.33f, 2.24f);
        pathBuilder2.curveToRelative(0.0f, 4.41f, -3.59f, 8.0f, -8.0f, 8.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u241.close();
        List<PathNode> nodes2 = $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes();
        ImageVector.Builder.m3967addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv, nodes2, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3279getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv2 = $this$_get_Face__u24lambda_u244;
        int strokeLineCap$iv$iv3 = StrokeCap.Companion.m3641getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.Companion.m3651getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv3 = new PathBuilder();
        PathBuilder $this$_get_Face__u24lambda_u244_u24lambda_u242 = $this$PathData_u24lambda_u240$iv$iv$iv3;
        ImageVector.Builder builder2 = $this$materialPath_u2dYwgOQQI_u24default$iv2;
        $this$_get_Face__u24lambda_u244_u24lambda_u242.moveTo(9.0f, 13.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u242.moveToRelative(-1.25f, 0.0f);
        PathBuilder pathBuilder3 = $this$_get_Face__u24lambda_u244_u24lambda_u242;
        pathBuilder3.arcToRelative(1.25f, 1.25f, 0.0f, true, true, 2.5f, 0.0f);
        pathBuilder3.arcToRelative(1.25f, 1.25f, 0.0f, true, true, -2.5f, 0.0f);
        List<PathNode> nodes3 = $this$PathData_u24lambda_u240$iv$iv$iv3.getNodes();
        ImageVector.Builder.m3967addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv2, nodes3, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3279getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv3, strokeLineJoin$iv$iv3, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default$iv3 = $this$_get_Face__u24lambda_u244;
        int strokeLineCap$iv$iv4 = StrokeCap.Companion.m3641getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.Companion.m3651getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv4 = new PathBuilder();
        PathBuilder $this$_get_Face__u24lambda_u244_u24lambda_u243 = $this$PathData_u24lambda_u240$iv$iv$iv4;
        ImageVector.Builder builder3 = $this$materialPath_u2dYwgOQQI_u24default$iv3;
        $this$_get_Face__u24lambda_u244_u24lambda_u243.moveTo(15.0f, 13.0f);
        $this$_get_Face__u24lambda_u244_u24lambda_u243.moveToRelative(-1.25f, 0.0f);
        PathBuilder pathBuilder4 = $this$_get_Face__u24lambda_u244_u24lambda_u243;
        pathBuilder4.arcToRelative(1.25f, 1.25f, 0.0f, true, true, 2.5f, 0.0f);
        pathBuilder4.arcToRelative(1.25f, 1.25f, 0.0f, true, true, -2.5f, 0.0f);
        List<PathNode> nodes4 = $this$PathData_u24lambda_u240$iv$iv$iv4.getNodes();
        ImageVector build = ImageVector.Builder.m3967addPathoIyEayM$default($this$materialPath_u2dYwgOQQI_u24default$iv3, nodes4, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3279getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv4, strokeLineJoin$iv$iv4, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _face = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
