package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/LayoutWeightNode;", "weight", "", "fill", "", "(FZ)V", "getFill", "()Z", "getWeight", "()F", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class LayoutWeightElement extends ModifierNodeElement<LayoutWeightNode> {
    private final boolean fill;
    private final float weight;

    public final float getWeight() {
        return this.weight;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public LayoutWeightElement(float weight2, boolean fill2) {
        this.weight = weight2;
        this.fill = fill2;
    }

    public LayoutWeightNode create() {
        return new LayoutWeightNode(this.weight, this.fill);
    }

    public void update(LayoutWeightNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setWeight(this.weight);
        node.setFill(this.fill);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("weight");
        $this$inspectableProperties.setValue(Float.valueOf(this.weight));
        $this$inspectableProperties.getProperties().set("weight", Float.valueOf(this.weight));
        $this$inspectableProperties.getProperties().set("fill", Boolean.valueOf(this.fill));
    }

    public int hashCode() {
        return (Float.hashCode(this.weight) * 31) + Boolean.hashCode(this.fill);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        LayoutWeightElement otherModifier = other instanceof LayoutWeightElement ? (LayoutWeightElement) other : null;
        if (otherModifier == null) {
            return false;
        }
        if (!(this.weight == otherModifier.weight) || this.fill != otherModifier.fill) {
            return false;
        }
        return true;
    }
}
