package androidx.compose.ui.input.key;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B4\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u001a\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003ø\u0001\u0000J\u001a\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003ø\u0001\u0000J<\u0010\u000e\u001a\u00020\u00002\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0001ø\u0001\u0000J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/key/KeyInputNode;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreKeyEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreKeyEvent", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyInputModifier.kt */
final class KeyInputElement extends ModifierNodeElement<KeyInputNode> {
    private final Function1<KeyEvent, Boolean> onKeyEvent;
    private final Function1<KeyEvent, Boolean> onPreKeyEvent;

    public static /* synthetic */ KeyInputElement copy$default(KeyInputElement keyInputElement, Function1<KeyEvent, Boolean> function1, Function1<KeyEvent, Boolean> function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = keyInputElement.onKeyEvent;
        }
        if ((i & 2) != 0) {
            function12 = keyInputElement.onPreKeyEvent;
        }
        return keyInputElement.copy(function1, function12);
    }

    public final Function1<KeyEvent, Boolean> component1() {
        return this.onKeyEvent;
    }

    public final Function1<KeyEvent, Boolean> component2() {
        return this.onPreKeyEvent;
    }

    public final KeyInputElement copy(Function1<? super KeyEvent, Boolean> function1, Function1<? super KeyEvent, Boolean> function12) {
        return new KeyInputElement(function1, function12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return Intrinsics.areEqual((Object) this.onKeyEvent, (Object) keyInputElement.onKeyEvent) && Intrinsics.areEqual((Object) this.onPreKeyEvent, (Object) keyInputElement.onPreKeyEvent);
    }

    public int hashCode() {
        Function1<KeyEvent, Boolean> function1 = this.onKeyEvent;
        int i = 0;
        int hashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1<KeyEvent, Boolean> function12 = this.onPreKeyEvent;
        if (function12 != null) {
            i = function12.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "KeyInputElement(onKeyEvent=" + this.onKeyEvent + ", onPreKeyEvent=" + this.onPreKeyEvent + ')';
    }

    public final Function1<KeyEvent, Boolean> getOnKeyEvent() {
        return this.onKeyEvent;
    }

    public final Function1<KeyEvent, Boolean> getOnPreKeyEvent() {
        return this.onPreKeyEvent;
    }

    public KeyInputElement(Function1<? super KeyEvent, Boolean> onKeyEvent2, Function1<? super KeyEvent, Boolean> onPreKeyEvent2) {
        this.onKeyEvent = onKeyEvent2;
        this.onPreKeyEvent = onPreKeyEvent2;
    }

    public KeyInputNode create() {
        return new KeyInputNode(this.onKeyEvent, this.onPreKeyEvent);
    }

    public void update(KeyInputNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setOnEvent(this.onKeyEvent);
        node.setOnPreEvent(this.onPreKeyEvent);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        Function1 it = this.onKeyEvent;
        if (it != null) {
            $this$inspectableProperties.setName("onKeyEvent");
            $this$inspectableProperties.getProperties().set("onKeyEvent", it);
        }
        Function1 it2 = this.onPreKeyEvent;
        if (it2 != null) {
            $this$inspectableProperties.setName("onPreviewKeyEvent");
            $this$inspectableProperties.getProperties().set("onPreviewKeyEvent", it2);
        }
    }
}
