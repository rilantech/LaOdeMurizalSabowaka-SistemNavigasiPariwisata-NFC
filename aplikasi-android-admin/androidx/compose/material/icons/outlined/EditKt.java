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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$Outlined;", "getEdit", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Edit.kt */
public final class EditKt {
    private static ImageVector _edit;

    public static final ImageVector getEdit(Icons.Outlined $this$Edit) {
        Intrinsics.checkNotNullParameter($this$Edit, "<this>");
        ImageVector imageVector = _edit;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Edit__u24lambda_u241 = new ImageVector.Builder("Outlined.Edit", Dp.m7554constructorimpl(24.0f), Dp.m7554constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m5351getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m5361getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        Object obj = "Outlined.Edit";
        ImageVector.Builder builder = $this$_get_Edit__u24lambda_u241;
        PathBuilder $this$_get_Edit__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.moveTo(14.06f, 9.02f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(0.92f, 0.92f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineTo(5.92f, 19.0f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineTo(5.0f, 19.0f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.verticalLineToRelative(-0.92f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(9.06f, -9.06f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.moveTo(17.66f, 3.0f);
        PathBuilder pathBuilder = $this$_get_Edit__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(-0.25f, 0.0f, -0.51f, 0.1f, -0.7f, 0.29f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(-1.83f, 1.83f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(3.75f, 3.75f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(1.83f, -1.83f);
        pathBuilder.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(-2.34f, -2.34f);
        pathBuilder.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.close();
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.moveTo(14.06f, 6.19f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineTo(3.0f, 17.25f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineTo(3.0f, 21.0f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(3.75f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineTo(17.81f, 9.94f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.lineToRelative(-3.75f, -3.75f);
        $this$_get_Edit__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m5677addPathoIyEayM$default($this$_get_Edit__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m4989getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _edit = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
