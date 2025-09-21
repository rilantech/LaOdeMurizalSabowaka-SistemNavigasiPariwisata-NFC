package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 n2\u00020\u0001:\u0001nJs\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Js\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J[\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J[\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-JQ\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102Jo\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H'ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jy\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020<H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>Jm\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJm\u0010?\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ[\u0010K\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ[\u0010K\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJO\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJO\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010VJs\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]Js\u0010W\u001a\u00020\u00122\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_J[\u0010`\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010MJ[\u0010`\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010OJe\u0010c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gJe\u0010c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010d\u001a\u00020e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ!\u0010j\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010k\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mR\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006oÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", "offset", "offsetSize-PENXr5M", "(JJ)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@DrawScopeMarker
/* compiled from: DrawScope.kt */
public interface DrawScope extends Density {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    void m5556drawArcillE91I(Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    void m5557drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    void m5558drawCircleV9BoPsw(Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    void m5559drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    /* synthetic */ void m5560drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    void m5562drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    void m5563drawLine1RTmtNc(Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2);

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    void m5564drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2);

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    void m5565drawOvalAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    void m5566drawOvalnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    void m5567drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    void m5568drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    void m5569drawPointsF8ZwMP8(List<Offset> list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3);

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    void m5570drawPointsGsft0Ws(List<Offset> list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3);

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    void m5571drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    void m5572drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    void m5573drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    void m5574drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i);

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DrawScope.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m5601roundToPxR2X_6o(DrawScope $this, long $receiver) {
            return DrawScope.super.m7528roundToPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m5602roundToPx0680j_4(DrawScope $this, float $receiver) {
            return DrawScope.super.m7529roundToPx0680j_4($receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m5603toDpGaN1DYA(DrawScope $this, long $receiver) {
            return DrawScope.super.m7530toDpGaN1DYA($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5604toDpu2uoSUM(DrawScope $this, float $receiver) {
            return DrawScope.super.m7531toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m5605toDpu2uoSUM(DrawScope $this, int $receiver) {
            return DrawScope.super.m7532toDpu2uoSUM($receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m5606toDpSizekrfVVM(DrawScope $this, long $receiver) {
            return DrawScope.super.m7533toDpSizekrfVVM($receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m5607toPxR2X_6o(DrawScope $this, long $receiver) {
            return DrawScope.super.m7534toPxR2X_6o($receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m5608toPx0680j_4(DrawScope $this, float $receiver) {
            return DrawScope.super.m7535toPx0680j_4($receiver);
        }

        @Deprecated
        public static Rect toRect(DrawScope $this, DpRect $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return DrawScope.super.toRect($receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m5609toSizeXkaWNTQ(DrawScope $this, long $receiver) {
            return DrawScope.super.m7536toSizeXkaWNTQ($receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m5610toSp0xMU5do(DrawScope $this, float $receiver) {
            return DrawScope.super.m7537toSp0xMU5do($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5611toSpkPz2Gy4(DrawScope $this, float $receiver) {
            return DrawScope.super.m7538toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m5612toSpkPz2Gy4(DrawScope $this, int $receiver) {
            return DrawScope.super.m7539toSpkPz2Gy4($receiver);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m5599getCenterF1C5BW0(DrawScope $this) {
            return DrawScope.super.m5575getCenterF1C5BW0();
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m5600getSizeNHjbRc(DrawScope $this) {
            return DrawScope.super.m5576getSizeNHjbRc();
        }

        @Deprecated
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m5584drawImageAZ2fEMs(DrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(style, "style");
            DrawScope.super.m5561drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
        }
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    long m5575getCenterF1C5BW0() {
        return SizeKt.m4792getCenteruvyYCjk(getDrawContext().m5519getSizeNHjbRc());
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    long m5576getSizeNHjbRc() {
        return getDrawContext().m5519getSizeNHjbRc();
    }

    /* renamed from: drawLine-1RTmtNc$default  reason: not valid java name */
    static /* synthetic */ void m5543drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        float f3;
        PathEffect pathEffect2;
        ColorFilter colorFilter2;
        int i4 = i3;
        if (obj == null) {
            if ((i4 & 8) != 0) {
                f3 = 0.0f;
            } else {
                f3 = f;
            }
            int r9 = (i4 & 16) != 0 ? Stroke.Companion.m5658getDefaultCapKaPHkGw() : i;
            if ((i4 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            float f4 = (i4 & 64) != 0 ? 1.0f : f2;
            if ((i4 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5563drawLine1RTmtNc(brush, j, j2, f3, r9, pathEffect2, f4, colorFilter2, (i4 & 256) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
    }

    /* renamed from: drawLine-NGM6Ib0$default  reason: not valid java name */
    static /* synthetic */ void m5544drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int i, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i2, int i3, Object obj) {
        float f3;
        PathEffect pathEffect2;
        ColorFilter colorFilter2;
        int i4 = i3;
        if (obj == null) {
            if ((i4 & 8) != 0) {
                f3 = 0.0f;
            } else {
                f3 = f;
            }
            int r10 = (i4 & 16) != 0 ? Stroke.Companion.m5658getDefaultCapKaPHkGw() : i;
            if ((i4 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            float f4 = (i4 & 64) != 0 ? 1.0f : f2;
            if ((i4 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5564drawLineNGM6Ib0(j, j2, j3, f3, r10, pathEffect2, f4, colorFilter2, (i4 & 256) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
    }

    /* renamed from: drawRect-AsUm42w$default  reason: not valid java name */
    static /* synthetic */ void m5551drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j3;
        long j4;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j3 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j3 = j;
            }
            if ((i2 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j4 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), j3);
            } else {
                DrawScope drawScope3 = drawScope;
                j4 = j2;
            }
            if ((i2 & 8) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i2 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i2 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5571drawRectAsUm42w(brush, j3, j4, f2, drawStyle2, colorFilter2, (i2 & 64) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
    }

    /* renamed from: drawRect-n-J9OG0$default  reason: not valid java name */
    static /* synthetic */ void m5552drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j4;
        long j5;
        DrawStyle drawStyle2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j4 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j4 = j2;
            }
            if ((i2 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j5 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), j4);
            } else {
                DrawScope drawScope3 = drawScope;
                j5 = j3;
            }
            float f2 = (i2 & 8) != 0 ? 1.0f : f;
            if ((i2 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5572drawRectnJ9OG0(j, j4, j5, f2, drawStyle2, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
    }

    /* renamed from: drawImage-gbVJVH8$default  reason: not valid java name */
    static /* synthetic */ void m5542drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j2;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j2 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j2 = j;
            }
            if ((i2 & 4) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i2 & 8) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i2 & 16) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5562drawImagegbVJVH8(imageBitmap, j2, f2, drawStyle2, colorFilter2, (i2 & 32) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
    }

    /* renamed from: drawImage-9jGpkUE$default  reason: not valid java name */
    static /* synthetic */ void m5540drawImage9jGpkUE$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j5;
        long j6;
        long j7;
        long j8;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i3 = i2;
        if (obj == null) {
            if ((i3 & 2) != 0) {
                j5 = IntOffset.Companion.m7682getZeronOccac();
            } else {
                j5 = j;
            }
            if ((i3 & 4) != 0) {
                j6 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
            } else {
                j6 = j2;
            }
            if ((i3 & 8) != 0) {
                j7 = IntOffset.Companion.m7682getZeronOccac();
            } else {
                j7 = j3;
            }
            if ((i3 & 16) != 0) {
                j8 = j6;
            } else {
                j8 = j4;
            }
            if ((i3 & 32) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i3 & 64) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i3 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5560drawImage9jGpkUE(imageBitmap, j5, j6, j7, j8, f2, drawStyle2, colorFilter2, (i3 & 256) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
    }

    /* renamed from: drawImage-AZ2fEMs$default  reason: not valid java name */
    static /* synthetic */ void m5541drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        long j5;
        long j6;
        long j7;
        long j8;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i4 = i3;
        if (obj == null) {
            if ((i4 & 2) != 0) {
                j5 = IntOffset.Companion.m7682getZeronOccac();
            } else {
                j5 = j;
            }
            if ((i4 & 4) != 0) {
                j6 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
            } else {
                j6 = j2;
            }
            if ((i4 & 8) != 0) {
                j7 = IntOffset.Companion.m7682getZeronOccac();
            } else {
                j7 = j3;
            }
            if ((i4 & 16) != 0) {
                j8 = j6;
            } else {
                j8 = j4;
            }
            if ((i4 & 32) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i4 & 64) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i4 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5561drawImageAZ2fEMs(imageBitmap, j5, j6, j7, j8, f2, drawStyle2, colorFilter2, (i4 & 256) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i, (i4 & 512) != 0 ? Companion.m5578getDefaultFilterQualityfv9h1I() : i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    void m5561drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        m5541drawImageAZ2fEMs$default(this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, 0, 512, (Object) null);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ$default  reason: not valid java name */
    static /* synthetic */ void m5553drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j4;
        long j5;
        long j6;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i3 = i2;
        if (obj == null) {
            if ((i3 & 2) != 0) {
                j4 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j4 = j;
            }
            if ((i3 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j5 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), j4);
            } else {
                DrawScope drawScope3 = drawScope;
                j5 = j2;
            }
            if ((i3 & 8) != 0) {
                j6 = CornerRadius.Companion.m4698getZerokKHJgLs();
            } else {
                j6 = j3;
            }
            if ((i3 & 16) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i3 & 32) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i3 & 64) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5573drawRoundRectZuiqVtQ(brush, j4, j5, j6, f2, drawStyle2, colorFilter2, (i3 & 128) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
    }

    /* renamed from: drawRoundRect-u-Aw5IA$default  reason: not valid java name */
    static /* synthetic */ void m5554drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j5;
        long j6;
        long j7;
        DrawStyle drawStyle2;
        int i3 = i2;
        if (obj == null) {
            if ((i3 & 2) != 0) {
                j5 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j5 = j2;
            }
            if ((i3 & 4) != 0) {
                j6 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), j5);
            } else {
                DrawScope drawScope2 = drawScope;
                j6 = j3;
            }
            if ((i3 & 8) != 0) {
                j7 = CornerRadius.Companion.m4698getZerokKHJgLs();
            } else {
                j7 = j4;
            }
            if ((i3 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5574drawRoundRectuAw5IA(j, j5, j6, j7, drawStyle2, (i3 & 32) != 0 ? 1.0f : f, (i3 & 64) != 0 ? null : colorFilter, (i3 & 128) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
    }

    /* renamed from: drawCircle-V9BoPsw$default  reason: not valid java name */
    static /* synthetic */ void m5538drawCircleV9BoPsw$default(DrawScope drawScope, Brush brush, float f, long j, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f3;
        long j2;
        float f4;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f3 = Size.m4781getMinDimensionimpl(drawScope.m5576getSizeNHjbRc()) / 2.0f;
            } else {
                f3 = f;
            }
            if ((i2 & 4) != 0) {
                j2 = drawScope.m5575getCenterF1C5BW0();
            } else {
                j2 = j;
            }
            if ((i2 & 8) != 0) {
                f4 = 1.0f;
            } else {
                f4 = f2;
            }
            if ((i2 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i2 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5558drawCircleV9BoPsw(brush, f3, j2, f4, drawStyle2, colorFilter2, (i2 & 64) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
    }

    /* renamed from: drawCircle-VaOC9Bg$default  reason: not valid java name */
    static /* synthetic */ void m5539drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f3;
        long j3;
        DrawStyle drawStyle2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                f3 = Size.m4781getMinDimensionimpl(drawScope.m5576getSizeNHjbRc()) / 2.0f;
            } else {
                f3 = f;
            }
            if ((i2 & 4) != 0) {
                j3 = drawScope.m5575getCenterF1C5BW0();
            } else {
                j3 = j2;
            }
            float f4 = (i2 & 8) != 0 ? 1.0f : f2;
            if ((i2 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5559drawCircleVaOC9Bg(j, f3, j3, f4, drawStyle2, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
    }

    /* renamed from: drawOval-AsUm42w$default  reason: not valid java name */
    static /* synthetic */ void m5545drawOvalAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j3;
        long j4;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j3 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j3 = j;
            }
            if ((i2 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j4 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), j3);
            } else {
                DrawScope drawScope3 = drawScope;
                j4 = j2;
            }
            if ((i2 & 8) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i2 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i2 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5565drawOvalAsUm42w(brush, j3, j4, f2, drawStyle2, colorFilter2, (i2 & 64) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
    }

    /* renamed from: drawOval-n-J9OG0$default  reason: not valid java name */
    static /* synthetic */ void m5546drawOvalnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j4;
        long j5;
        DrawStyle drawStyle2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                j4 = Offset.Companion.m4729getZeroF1C5BW0();
            } else {
                j4 = j2;
            }
            if ((i2 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j5 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), j4);
            } else {
                DrawScope drawScope3 = drawScope;
                j5 = j3;
            }
            float f2 = (i2 & 8) != 0 ? 1.0f : f;
            if ((i2 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5566drawOvalnJ9OG0(j, j4, j5, f2, drawStyle2, (i2 & 32) != 0 ? null : colorFilter, (i2 & 64) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
    }

    /* renamed from: drawArc-illE91I$default  reason: not valid java name */
    static /* synthetic */ void m5536drawArcillE91I$default(DrawScope drawScope, Brush brush, float f, float f2, boolean z, long j, long j2, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j3;
        DrawStyle drawStyle2;
        int i3 = i2;
        if (obj == null) {
            long r8 = (i3 & 16) != 0 ? Offset.Companion.m4729getZeroF1C5BW0() : j;
            if ((i3 & 32) != 0) {
                j3 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), r8);
            } else {
                DrawScope drawScope2 = drawScope;
                j3 = j2;
            }
            float f4 = (i3 & 64) != 0 ? 1.0f : f3;
            if ((i3 & 128) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5556drawArcillE91I(brush, f, f2, z, r8, j3, f4, drawStyle2, (i3 & 256) != 0 ? null : colorFilter, (i3 & 512) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
    }

    /* renamed from: drawArc-yD3GUKo$default  reason: not valid java name */
    static /* synthetic */ void m5537drawArcyD3GUKo$default(DrawScope drawScope, long j, float f, float f2, boolean z, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        long j4;
        DrawStyle drawStyle2;
        int i3 = i2;
        if (obj == null) {
            long r9 = (i3 & 16) != 0 ? Offset.Companion.m4729getZeroF1C5BW0() : j2;
            if ((i3 & 32) != 0) {
                j4 = drawScope.m5555offsetSizePENXr5M(drawScope.m5576getSizeNHjbRc(), r9);
            } else {
                DrawScope drawScope2 = drawScope;
                j4 = j3;
            }
            float f4 = (i3 & 64) != 0 ? 1.0f : f3;
            if ((i3 & 128) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5557drawArcyD3GUKo(j, f, f2, z, r9, j4, f4, drawStyle2, (i3 & 256) != 0 ? null : colorFilter, (i3 & 512) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
    }

    /* renamed from: drawPath-LG529CI$default  reason: not valid java name */
    static /* synthetic */ void m5548drawPathLG529CI$default(DrawScope drawScope, Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f2;
        DrawStyle drawStyle2;
        if (obj == null) {
            if ((i2 & 4) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i2 & 8) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5568drawPathLG529CI(path, j, f2, drawStyle2, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
    }

    /* renamed from: drawPath-GBMwjPU$default  reason: not valid java name */
    static /* synthetic */ void m5547drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f2;
        DrawStyle drawStyle2;
        if (obj == null) {
            if ((i2 & 4) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i2 & 8) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            drawScope.m5567drawPathGBMwjPU(path, brush, f2, drawStyle2, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
    }

    /* renamed from: drawPoints-F8ZwMP8$default  reason: not valid java name */
    static /* synthetic */ void m5549drawPointsF8ZwMP8$default(DrawScope drawScope, List list, int i, long j, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        float f3;
        PathEffect pathEffect2;
        ColorFilter colorFilter2;
        int i5 = i4;
        if (obj == null) {
            if ((i5 & 8) != 0) {
                f3 = 0.0f;
            } else {
                f3 = f;
            }
            int r8 = (i5 & 16) != 0 ? StrokeCap.Companion.m5351getButtKaPHkGw() : i2;
            if ((i5 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            float f4 = (i5 & 64) != 0 ? 1.0f : f2;
            if ((i5 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5569drawPointsF8ZwMP8(list, i, j, f3, r8, pathEffect2, f4, colorFilter2, (i5 & 256) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
    }

    /* renamed from: drawPoints-Gsft0Ws$default  reason: not valid java name */
    static /* synthetic */ void m5550drawPointsGsft0Ws$default(DrawScope drawScope, List list, int i, Brush brush, float f, int i2, PathEffect pathEffect, float f2, ColorFilter colorFilter, int i3, int i4, Object obj) {
        float f3;
        PathEffect pathEffect2;
        ColorFilter colorFilter2;
        int i5 = i4;
        if (obj == null) {
            if ((i5 & 8) != 0) {
                f3 = 0.0f;
            } else {
                f3 = f;
            }
            int r7 = (i5 & 16) != 0 ? StrokeCap.Companion.m5351getButtKaPHkGw() : i2;
            if ((i5 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            float f4 = (i5 & 64) != 0 ? 1.0f : f2;
            if ((i5 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            drawScope.m5570drawPointsGsft0Ws(list, i, brush, f3, r7, pathEffect2, f4, colorFilter2, (i5 & 256) != 0 ? Companion.m5577getDefaultBlendMode0nO6VwU() : i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
    }

    /* renamed from: offsetSize-PENXr5M  reason: not valid java name */
    private long m5555offsetSizePENXr5M(long $this$offsetSize_u2dPENXr5M, long offset) {
        return SizeKt.Size(Size.m4782getWidthimpl($this$offsetSize_u2dPENXr5M) - Offset.m4713getXimpl(offset), Size.m4779getHeightimpl($this$offsetSize_u2dPENXr5M) - Offset.m4714getYimpl(offset));
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DrawScope.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m4896getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m5060getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU  reason: not valid java name */
        public final int m5577getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I  reason: not valid java name */
        public final int m5578getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }
}
