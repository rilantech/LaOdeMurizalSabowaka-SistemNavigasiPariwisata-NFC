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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$Rounded;", "getStar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Star.kt */
public final class StarKt {
    private static ImageVector _star;

    public static final ImageVector getStar(Icons.Rounded $this$Star) {
        Intrinsics.checkNotNullParameter($this$Star, "<this>");
        ImageVector imageVector = _star;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Star__u24lambda_u241 = new ImageVector.Builder("Rounded.Star", Dp.m7554constructorimpl(24.0f), Dp.m7554constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m5351getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m5361getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.Star";
        ImageVector.Builder builder = $this$_get_Star__u24lambda_u241;
        PathBuilder $this$_get_Star__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        $this$_get_Star__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 17.27f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(4.15f, 2.51f);
        PathBuilder pathBuilder = $this$_get_Star__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(0.76f, 0.46f, 1.69f, -0.22f, 1.49f, -1.08f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(-1.1f, -4.72f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(3.67f, -3.18f);
        pathBuilder.curveToRelative(0.67f, -0.58f, 0.31f, -1.68f, -0.57f, -1.75f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(-4.83f, -0.41f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(-1.89f, -4.46f);
        pathBuilder.curveToRelative(-0.34f, -0.81f, -1.5f, -0.81f, -1.84f, 0.0f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(9.19f, 8.63f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(4.36f, 9.04f);
        pathBuilder.curveToRelative(-0.88f, 0.07f, -1.24f, 1.17f, -0.57f, 1.75f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(3.67f, 3.18f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineToRelative(-1.1f, 4.72f);
        pathBuilder.curveToRelative(-0.2f, 0.86f, 0.73f, 1.54f, 1.49f, 1.08f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.lineTo(12.0f, 17.27f);
        $this$_get_Star__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m5677addPathoIyEayM$default($this$_get_Star__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m4989getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _star = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
