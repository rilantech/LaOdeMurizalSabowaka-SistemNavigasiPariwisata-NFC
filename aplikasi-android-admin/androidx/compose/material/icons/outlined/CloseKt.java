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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_close", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Close", "Landroidx/compose/material/icons/Icons$Outlined;", "getClose", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Close.kt */
public final class CloseKt {
    private static ImageVector _close;

    public static final ImageVector getClose(Icons.Outlined $this$Close) {
        Intrinsics.checkNotNullParameter($this$Close, "<this>");
        ImageVector imageVector = _close;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Close__u24lambda_u241 = new ImageVector.Builder("Outlined.Close", Dp.m7554constructorimpl(24.0f), Dp.m7554constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m5351getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m5361getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        Object obj = "Outlined.Close";
        ImageVector.Builder builder = $this$_get_Close__u24lambda_u241;
        PathBuilder $this$_get_Close__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        $this$_get_Close__u24lambda_u241_u24lambda_u240.moveTo(19.0f, 6.41f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(17.59f, 5.0f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(12.0f, 10.59f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(6.41f, 5.0f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(5.0f, 6.41f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(10.59f, 12.0f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(5.0f, 17.59f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(6.41f, 19.0f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(12.0f, 13.41f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(17.59f, 19.0f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(19.0f, 17.59f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(13.41f, 12.0f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.lineTo(19.0f, 6.41f);
        $this$_get_Close__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m5677addPathoIyEayM$default($this$_get_Close__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m4989getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _close = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
