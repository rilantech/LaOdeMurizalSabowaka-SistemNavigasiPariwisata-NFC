package androidx.compose.material.icons.outlined;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_moreVert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MoreVert", "Landroidx/compose/material/icons/Icons$Outlined;", "getMoreVert", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MoreVert.kt */
public final class MoreVertKt {
    private static ImageVector _moreVert;

    public static final ImageVector getMoreVert(Icons.Outlined $this$MoreVert) {
        Intrinsics.checkNotNullParameter($this$MoreVert, "<this>");
        ImageVector imageVector = _moreVert;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_MoreVert__u24lambda_u241 = new ImageVector.Builder("Outlined.MoreVert", Dp.m5844constructorimpl(24.0f), Dp.m5844constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3641getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3651getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        Object obj = "Outlined.MoreVert";
        ImageVector.Builder builder = $this$_get_MoreVert__u24lambda_u241;
        PathBuilder $this$_get_MoreVert__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 8.0f);
        PathBuilder pathBuilder = $this$_get_MoreVert__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.close();
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 10.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.close();
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 16.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$_get_MoreVert__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3967addPathoIyEayM$default($this$_get_MoreVert__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3279getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _moreVert = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
