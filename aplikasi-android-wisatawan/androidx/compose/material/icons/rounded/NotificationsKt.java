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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_notifications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Notifications", "Landroidx/compose/material/icons/Icons$Rounded;", "getNotifications", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Notifications.kt */
public final class NotificationsKt {
    private static ImageVector _notifications;

    public static final ImageVector getNotifications(Icons.Rounded $this$Notifications) {
        Intrinsics.checkNotNullParameter($this$Notifications, "<this>");
        ImageVector imageVector = _notifications;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Notifications__u24lambda_u241 = new ImageVector.Builder("Rounded.Notifications", Dp.m5844constructorimpl(24.0f), Dp.m5844constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, (DefaultConstructorMarker) null);
        int strokeLineCap$iv$iv = StrokeCap.Companion.m3641getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.Companion.m3651getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        Object obj = "Rounded.Notifications";
        ImageVector.Builder builder = $this$_get_Notifications__u24lambda_u241;
        PathBuilder $this$_get_Notifications__u24lambda_u241_u24lambda_u240 = $this$PathData_u24lambda_u240$iv$iv$iv;
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.moveTo(12.0f, 22.0f);
        PathBuilder pathBuilder = $this$_get_Notifications__u24lambda_u241_u24lambda_u240;
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(-4.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.close();
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.moveTo(18.0f, 16.0f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.verticalLineToRelative(-5.0f);
        pathBuilder.curveToRelative(0.0f, -3.07f, -1.64f, -5.64f, -4.5f, -6.32f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.lineTo(13.5f, 4.0f);
        pathBuilder.curveToRelative(0.0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.verticalLineToRelative(0.68f);
        pathBuilder.curveTo(7.63f, 5.36f, 6.0f, 7.92f, 6.0f, 11.0f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.verticalLineToRelative(5.0f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.lineToRelative(-1.29f, 1.29f);
        pathBuilder.curveToRelative(-0.63f, 0.63f, -0.19f, 1.71f, 0.7f, 1.71f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.horizontalLineToRelative(13.17f);
        pathBuilder.curveToRelative(0.89f, 0.0f, 1.34f, -1.08f, 0.71f, -1.71f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.lineTo(18.0f, 16.0f);
        $this$_get_Notifications__u24lambda_u241_u24lambda_u240.close();
        List<PathNode> nodes = $this$PathData_u24lambda_u240$iv$iv$iv.getNodes();
        ImageVector build = ImageVector.Builder.m3967addPathoIyEayM$default($this$_get_Notifications__u24lambda_u241, nodes, VectorKt.getDefaultFillType(), "", new SolidColor(Color.Companion.m3279getBlack0d7_KjU(), (DefaultConstructorMarker) null), 1.0f, (Brush) null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _notifications = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
