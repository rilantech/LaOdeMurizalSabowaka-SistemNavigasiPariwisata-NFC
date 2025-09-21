package androidx.compose.ui.semantics;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B&\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001a\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nHÆ\u0003J.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nHÆ\u0001J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0016J\f\u0010!\u001a\u00020\t*\u00020\"H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Landroidx/compose/ui/semantics/AppendedSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "mergeDescendants", "", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;)V", "getMergeDescendants", "()Z", "getProperties", "()Lkotlin/jvm/functions/Function1;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsModifier.kt */
public final class AppendedSemanticsElement extends ModifierNodeElement<CoreSemanticsModifierNode> implements SemanticsModifier {
    private final boolean mergeDescendants;
    private final Function1<SemanticsPropertyReceiver, Unit> properties;

    public static /* synthetic */ AppendedSemanticsElement copy$default(AppendedSemanticsElement appendedSemanticsElement, boolean z, Function1<SemanticsPropertyReceiver, Unit> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appendedSemanticsElement.mergeDescendants;
        }
        if ((i & 2) != 0) {
            function1 = appendedSemanticsElement.properties;
        }
        return appendedSemanticsElement.copy(z, function1);
    }

    public final boolean component1() {
        return this.mergeDescendants;
    }

    public final Function1<SemanticsPropertyReceiver, Unit> component2() {
        return this.properties;
    }

    public final AppendedSemanticsElement copy(boolean z, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "properties");
        return new AppendedSemanticsElement(z, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        return this.mergeDescendants == appendedSemanticsElement.mergeDescendants && Intrinsics.areEqual((Object) this.properties, (Object) appendedSemanticsElement.properties);
    }

    public int hashCode() {
        boolean z = this.mergeDescendants;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.properties.hashCode();
    }

    public String toString() {
        return "AppendedSemanticsElement(mergeDescendants=" + this.mergeDescendants + ", properties=" + this.properties + ')';
    }

    public final boolean getMergeDescendants() {
        return this.mergeDescendants;
    }

    public final Function1<SemanticsPropertyReceiver, Unit> getProperties() {
        return this.properties;
    }

    public AppendedSemanticsElement(boolean mergeDescendants2, Function1<? super SemanticsPropertyReceiver, Unit> properties2) {
        Intrinsics.checkNotNullParameter(properties2, "properties");
        this.mergeDescendants = mergeDescendants2;
        this.properties = properties2;
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        SemanticsConfiguration $this$_get_semanticsConfiguration__u24lambda_u240 = semanticsConfiguration;
        $this$_get_semanticsConfiguration__u24lambda_u240.setMergingSemanticsOfDescendants(this.mergeDescendants);
        this.properties.invoke($this$_get_semanticsConfiguration__u24lambda_u240);
        return semanticsConfiguration;
    }

    public CoreSemanticsModifierNode create() {
        return new CoreSemanticsModifierNode(this.mergeDescendants, false, this.properties);
    }

    public void update(CoreSemanticsModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setMergeDescendants(this.mergeDescendants);
        node.setProperties(this.properties);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("semantics");
        $this$inspectableProperties.getProperties().set("mergeDescendants", Boolean.valueOf(this.mergeDescendants));
        SemanticsModifierKt.addSemanticsPropertiesFrom($this$inspectableProperties, getSemanticsConfiguration());
    }
}
