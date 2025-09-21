package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.BasicText_androidKt;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eR\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "draw", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionController implements RememberObserver {
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    /* access modifiers changed from: private */
    public StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    public /* synthetic */ SelectionController(SelectionRegistrar selectionRegistrar2, long j, StaticTextSelectionParams staticTextSelectionParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(selectionRegistrar2, j, staticTextSelectionParams);
    }

    private SelectionController(SelectionRegistrar selectionRegistrar2, long backgroundSelectionColor2, StaticTextSelectionParams params2) {
        Intrinsics.checkNotNullParameter(selectionRegistrar2, "selectionRegistrar");
        Intrinsics.checkNotNullParameter(params2, "params");
        this.selectionRegistrar = selectionRegistrar2;
        this.backgroundSelectionColor = backgroundSelectionColor2;
        this.params = params2;
        long nextSelectableId = selectionRegistrar2.nextSelectableId();
        this.selectableId = nextSelectableId;
        this.modifier = BasicText_androidKt.textPointerHoverIcon(SelectionControllerKt.makeSelectionModifier(selectionRegistrar2, nextSelectableId, new SelectionController$modifier$1(this), new SelectionController$modifier$2(this), TouchMode_androidKt.isInTouchMode()), selectionRegistrar2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SelectionController(androidx.compose.foundation.text.selection.SelectionRegistrar r7, long r8, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r11 = r11 & 4
            if (r11 == 0) goto L_0x000c
            androidx.compose.foundation.text.modifiers.StaticTextSelectionParams$Companion r10 = androidx.compose.foundation.text.modifiers.StaticTextSelectionParams.Companion
            androidx.compose.foundation.text.modifiers.StaticTextSelectionParams r10 = r10.getEmpty()
            r4 = r10
            goto L_0x000d
        L_0x000c:
            r4 = r10
        L_0x000d:
            r5 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.SelectionController.<init>(androidx.compose.foundation.text.selection.SelectionRegistrar, long, androidx.compose.foundation.text.modifiers.StaticTextSelectionParams, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new SelectionController$onRemembered$1(this), new SelectionController$onRemembered$2(this)));
    }

    public void onForgotten() {
        Selectable localSelectable = this.selectable;
        if (localSelectable != null) {
            this.selectionRegistrar.unsubscribe(localSelectable);
            this.selectable = null;
        }
    }

    public void onAbandoned() {
        Selectable localSelectable = this.selectable;
        if (localSelectable != null) {
            this.selectionRegistrar.unsubscribe(localSelectable);
            this.selectable = null;
        }
    }

    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        this.params = StaticTextSelectionParams.copy$default(this.params, (LayoutCoordinates) null, textLayoutResult, 1, (Object) null);
    }

    public final void updateGlobalPosition(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.params = StaticTextSelectionParams.copy$default(this.params, coordinates, (TextLayoutResult) null, 2, (Object) null);
    }

    public final void draw(DrawScope drawScope) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(this.selectableId));
        if (selection != null) {
            if (!selection.getHandlesCrossed()) {
                i = selection.getStart().getOffset();
            } else {
                i = selection.getEnd().getOffset();
            }
            int start = i;
            if (!selection.getHandlesCrossed()) {
                i2 = selection.getEnd().getOffset();
            } else {
                i2 = selection.getStart().getOffset();
            }
            int end = i2;
            if (start != end) {
                Selectable selectable2 = this.selectable;
                int lastOffset = selectable2 != null ? selectable2.getLastVisibleOffset() : 0;
                int clippedStart = RangesKt.coerceAtMost(start, lastOffset);
                int clippedEnd = RangesKt.coerceAtMost(end, lastOffset);
                Path selectionPath = this.params.getPathForRange(clippedStart, clippedEnd);
                if (selectionPath != null) {
                    DrawScope $this$draw_u24lambda_u241 = drawScope;
                    if (this.params.getShouldClip()) {
                        DrawScope $this$clipRect_u2drOu3jXo_u24default$iv = $this$draw_u24lambda_u241;
                        float right$iv = Size.m3072getWidthimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3866getSizeNHjbRc());
                        float bottom$iv = Size.m3069getHeightimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3866getSizeNHjbRc());
                        int clipOp$iv = ClipOp.Companion.m3242getIntersectrtfAjoo();
                        DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv;
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
                        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3809getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
                        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3921clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
                        DrawScope.m3838drawPathLG529CI$default($this$withTransform$iv$iv, selectionPath, this.backgroundSelectionColor, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
                        $this$withTransform_u24lambda_u246$iv$iv2.m3810setSizeuvyYCjk(previousSize$iv$iv);
                        int i3 = clippedStart;
                        int i4 = clippedEnd;
                        return;
                    }
                    int i5 = clippedEnd;
                    int i6 = clippedStart;
                    DrawScope.m3838drawPathLG529CI$default($this$draw_u24lambda_u241, selectionPath, this.backgroundSelectionColor, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                }
            }
        }
    }
}
