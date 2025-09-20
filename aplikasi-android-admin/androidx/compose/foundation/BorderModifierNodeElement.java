package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u0011\u001a\u00020\u0004HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J4\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0016J\f\u0010$\u001a\u00020\"*\u00020%H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/BorderModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BorderModifierNode;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getWidth-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/foundation/BorderModifierNodeElement;", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
public final class BorderModifierNodeElement extends ModifierNodeElement<BorderModifierNode> {
    private final Brush brush;
    private final Shape shape;
    private final float width;

    public /* synthetic */ BorderModifierNodeElement(float f, Brush brush2, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush2, shape2);
    }

    /* renamed from: copy-8Feqmps$default  reason: not valid java name */
    public static /* synthetic */ BorderModifierNodeElement m1897copy8Feqmps$default(BorderModifierNodeElement borderModifierNodeElement, float f, Brush brush2, Shape shape2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = borderModifierNodeElement.width;
        }
        if ((i & 2) != 0) {
            brush2 = borderModifierNodeElement.brush;
        }
        if ((i & 4) != 0) {
            shape2 = borderModifierNodeElement.shape;
        }
        return borderModifierNodeElement.m1899copy8Feqmps(f, brush2, shape2);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m1898component1D9Ej5fM() {
        return this.width;
    }

    public final Brush component2() {
        return this.brush;
    }

    public final Shape component3() {
        return this.shape;
    }

    /* renamed from: copy-8Feqmps  reason: not valid java name */
    public final BorderModifierNodeElement m1899copy8Feqmps(float f, Brush brush2, Shape shape2) {
        Intrinsics.checkNotNullParameter(brush2, "brush");
        Intrinsics.checkNotNullParameter(shape2, "shape");
        return new BorderModifierNodeElement(f, brush2, shape2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        return Dp.m7559equalsimpl0(this.width, borderModifierNodeElement.width) && Intrinsics.areEqual((Object) this.brush, (Object) borderModifierNodeElement.brush) && Intrinsics.areEqual((Object) this.shape, (Object) borderModifierNodeElement.shape);
    }

    public int hashCode() {
        return (((Dp.m7560hashCodeimpl(this.width) * 31) + this.brush.hashCode()) * 31) + this.shape.hashCode();
    }

    public String toString() {
        return "BorderModifierNodeElement(width=" + Dp.m7565toStringimpl(this.width) + ", brush=" + this.brush + ", shape=" + this.shape + ')';
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m1900getWidthD9Ej5fM() {
        return this.width;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    private BorderModifierNodeElement(float width2, Brush brush2, Shape shape2) {
        Intrinsics.checkNotNullParameter(brush2, "brush");
        Intrinsics.checkNotNullParameter(shape2, "shape");
        this.width = width2;
        this.brush = brush2;
        this.shape = shape2;
    }

    public BorderModifierNode create() {
        return new BorderModifierNode(this.width, this.brush, this.shape, (DefaultConstructorMarker) null);
    }

    public void update(BorderModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m1896setWidth0680j_4(this.width);
        node.setBrush(this.brush);
        node.setShape(this.shape);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName(OutlinedTextFieldKt.BorderId);
        $this$inspectableProperties.getProperties().set("width", Dp.m7552boximpl(this.width));
        if (this.brush instanceof SolidColor) {
            $this$inspectableProperties.getProperties().set(TypedValues.Custom.S_COLOR, Color.m4953boximpl(((SolidColor) this.brush).m5333getValue0d7_KjU()));
            $this$inspectableProperties.setValue(Color.m4953boximpl(((SolidColor) this.brush).m5333getValue0d7_KjU()));
        } else {
            $this$inspectableProperties.getProperties().set("brush", this.brush);
        }
        $this$inspectableProperties.getProperties().set("shape", this.shape);
    }
}
