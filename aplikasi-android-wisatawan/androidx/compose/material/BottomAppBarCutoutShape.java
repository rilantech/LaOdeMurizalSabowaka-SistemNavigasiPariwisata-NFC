package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\"\u001a\u00020 *\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0002R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/material/BottomAppBarCutoutShape;", "Landroidx/compose/ui/graphics/Shape;", "cutoutShape", "fabPlacement", "Landroidx/compose/material/FabPlacement;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/FabPlacement;)V", "getCutoutShape", "()Landroidx/compose/ui/graphics/Shape;", "getFabPlacement", "()Landroidx/compose/material/FabPlacement;", "component1", "component2", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "addCutoutShape", "", "Landroidx/compose/ui/graphics/Path;", "addRoundedEdges", "cutoutStartPosition", "", "cutoutEndPosition", "cutoutRadius", "roundedEdgeRadius", "verticalOffset", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class BottomAppBarCutoutShape implements Shape {
    private final Shape cutoutShape;
    private final FabPlacement fabPlacement;

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement2, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i & 2) != 0) {
            fabPlacement2 = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement2);
    }

    public final Shape component1() {
        return this.cutoutShape;
    }

    public final FabPlacement component2() {
        return this.fabPlacement;
    }

    public final BottomAppBarCutoutShape copy(Shape shape, FabPlacement fabPlacement2) {
        Intrinsics.checkNotNullParameter(shape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement2, "fabPlacement");
        return new BottomAppBarCutoutShape(shape, fabPlacement2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) obj;
        return Intrinsics.areEqual((Object) this.cutoutShape, (Object) bottomAppBarCutoutShape.cutoutShape) && Intrinsics.areEqual((Object) this.fabPlacement, (Object) bottomAppBarCutoutShape.fabPlacement);
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }

    public BottomAppBarCutoutShape(Shape cutoutShape2, FabPlacement fabPlacement2) {
        Intrinsics.checkNotNullParameter(cutoutShape2, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement2, "fabPlacement");
        this.cutoutShape = cutoutShape2;
        this.fabPlacement = fabPlacement2;
    }

    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m1181createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path boundingRectangle = AndroidPath_androidKt.Path();
        boundingRectangle.addRect(new Rect(0.0f, 0.0f, Size.m3072getWidthimpl(size), Size.m3069getHeightimpl(size)));
        Path path = AndroidPath_androidKt.Path();
        Path $this$createOutline_Pq9zytI_u24lambda_u241 = path;
        addCutoutShape($this$createOutline_Pq9zytI_u24lambda_u241, layoutDirection, density);
        $this$createOutline_Pq9zytI_u24lambda_u241.m3536opN5in7k0(boundingRectangle, $this$createOutline_Pq9zytI_u24lambda_u241, PathOperation.Companion.m3562getDifferenceb3I0S0c());
        return new Outline.Generic(path);
    }

    private final void addCutoutShape(Path $this$addCutoutShape, LayoutDirection layoutDirection, Density density) {
        Path path = $this$addCutoutShape;
        float cutoutOffset = density.m5825toPx0680j_4(AppBarKt.BottomAppBarCutoutOffset);
        float f = (float) 2;
        long cutoutSize = SizeKt.Size(((float) this.fabPlacement.getWidth()) + (cutoutOffset * f), ((float) this.fabPlacement.getHeight()) + (f * cutoutOffset));
        float cutoutStartX = ((float) this.fabPlacement.getLeft()) - cutoutOffset;
        float cutoutEndX = cutoutStartX + Size.m3072getWidthimpl(cutoutSize);
        float cutoutRadius = Size.m3069getHeightimpl(cutoutSize) / 2.0f;
        OutlineKt.addOutline(path, this.cutoutShape.m3612createOutlinePq9zytI(cutoutSize, layoutDirection, density));
        path.m3539translatek4lQ0M(OffsetKt.Offset(cutoutStartX, -cutoutRadius));
        if (Intrinsics.areEqual((Object) this.cutoutShape, (Object) RoundedCornerShapeKt.getCircleShape())) {
            addRoundedEdges($this$addCutoutShape, cutoutStartX, cutoutEndX, cutoutRadius, density.m5825toPx0680j_4(AppBarKt.BottomAppBarRoundedEdgeRadius), 0.0f);
        }
    }

    private final void addRoundedEdges(Path $this$addRoundedEdges, float cutoutStartPosition, float cutoutEndPosition, float cutoutRadius, float roundedEdgeRadius, float verticalOffset) {
        Path path = $this$addRoundedEdges;
        float f = cutoutRadius;
        float f2 = verticalOffset;
        float appBarInterceptOffset = -((float) Math.sqrt((double) ((f * f) - (f2 * f2))));
        float appBarInterceptStartX = cutoutStartPosition + f + appBarInterceptOffset;
        float appBarInterceptEndX = cutoutEndPosition - (f + appBarInterceptOffset);
        Pair<Float, Float> calculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(appBarInterceptOffset - 1.0f, f2, f);
        float curveInterceptXOffset = calculateRoundedEdgeIntercept.component1().floatValue();
        float curveInterceptY = calculateRoundedEdgeIntercept.component2().floatValue() - f2;
        path.moveTo(appBarInterceptStartX - roundedEdgeRadius, 0.0f);
        path.quadraticBezierTo(appBarInterceptStartX - 1.0f, 0.0f, cutoutStartPosition + curveInterceptXOffset + f, curveInterceptY);
        path.lineTo(cutoutEndPosition - (curveInterceptXOffset + f), curveInterceptY);
        path.quadraticBezierTo(appBarInterceptEndX + 1.0f, 0.0f, appBarInterceptEndX + roundedEdgeRadius, 0.0f);
        $this$addRoundedEdges.close();
    }
}
