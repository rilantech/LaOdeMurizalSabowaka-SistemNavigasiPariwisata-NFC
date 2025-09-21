package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\f\u0010\u001f\u001a\u00020\u000b*\u00020\nH\u0016R\u001c\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\"\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetDpElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AlignmentLineOffsetDpNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/AlignmentLine;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-D9Ej5fM", "()F", "F", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-D9Ej5fM", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlignmentLine.kt */
final class AlignmentLineOffsetDpElement extends ModifierNodeElement<AlignmentLineOffsetDpNode> {
    private final float after;
    private final AlignmentLine alignmentLine;
    private final float before;
    private final Function1<InspectorInfo, Unit> inspectorInfo;

    public /* synthetic */ AlignmentLineOffsetDpElement(AlignmentLine alignmentLine2, float f, float f2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine2, f, f2, function1);
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* renamed from: getBefore-D9Ej5fM  reason: not valid java name */
    public final float m2109getBeforeD9Ej5fM() {
        return this.before;
    }

    /* renamed from: getAfter-D9Ej5fM  reason: not valid java name */
    public final float m2108getAfterD9Ej5fM() {
        return this.after;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    private AlignmentLineOffsetDpElement(AlignmentLine alignmentLine2, float before2, float after2, Function1<? super InspectorInfo, Unit> inspectorInfo2) {
        Intrinsics.checkNotNullParameter(alignmentLine2, "alignmentLine");
        Intrinsics.checkNotNullParameter(inspectorInfo2, "inspectorInfo");
        this.alignmentLine = alignmentLine2;
        this.before = before2;
        this.after = after2;
        this.inspectorInfo = inspectorInfo2;
        if (!((before2 >= 0.0f || Dp.m7559equalsimpl0(before2, Dp.Companion.m7574getUnspecifiedD9Ej5fM())) && (after2 >= 0.0f || Dp.m7559equalsimpl0(after2, Dp.Companion.m7574getUnspecifiedD9Ej5fM())))) {
            throw new IllegalArgumentException("Padding from alignment line must be a non-negative number".toString());
        }
    }

    public AlignmentLineOffsetDpNode create() {
        return new AlignmentLineOffsetDpNode(this.alignmentLine, this.before, this.after, (DefaultConstructorMarker) null);
    }

    public void update(AlignmentLineOffsetDpNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setAlignmentLine(this.alignmentLine);
        node.m2114setBefore0680j_4(this.before);
        node.m2113setAfter0680j_4(this.after);
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        AlignmentLineOffsetDpElement otherModifier = other instanceof AlignmentLineOffsetDpElement ? (AlignmentLineOffsetDpElement) other : null;
        if (otherModifier == null) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.alignmentLine, (Object) otherModifier.alignmentLine) || !Dp.m7559equalsimpl0(this.before, otherModifier.before) || !Dp.m7559equalsimpl0(this.after, otherModifier.after)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.alignmentLine.hashCode() * 31) + Dp.m7560hashCodeimpl(this.before)) * 31) + Dp.m7560hashCodeimpl(this.after);
    }
}
