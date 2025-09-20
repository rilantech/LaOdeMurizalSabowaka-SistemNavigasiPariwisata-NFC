package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import com.google.android.material.internal.ViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010\"\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@@X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Ljava/util/List;)V", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "()I", "I", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "<set-?>", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerEvent.android.kt */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> changes2, InternalPointerEvent internalPointerEvent2) {
        Intrinsics.checkNotNullParameter(changes2, "changes");
        this.changes = changes2;
        this.internalPointerEvent = internalPointerEvent2;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        int i = 0;
        this.buttons = PointerButtons.m4414constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m4543constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : i);
        this.type = m4420calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
        if (internalPointerEvent2 != null) {
            return internalPointerEvent2.getMotionEvent();
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PointerEvent(List<PointerInputChange> changes2) {
        this(changes2, (InternalPointerEvent) null);
        Intrinsics.checkNotNullParameter(changes2, "changes");
    }

    /* renamed from: getButtons-ry648PA  reason: not valid java name */
    public final int m4421getButtonsry648PA() {
        return this.buttons;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A  reason: not valid java name */
    public final int m4422getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    /* renamed from: getType-7fucELk  reason: not valid java name */
    public final int m4423getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release  reason: not valid java name */
    public final void m4424setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* renamed from: calculatePointerEventType-7fucELk  reason: not valid java name */
    private final int m4420calculatePointerEventType7fucELk() {
        MotionEvent motionEvent = getMotionEvent$ui_release();
        if (motionEvent != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    return PointerEventType.Companion.m4437getPress7fucELk();
                case 1:
                case 6:
                    return PointerEventType.Companion.m4438getRelease7fucELk();
                case 2:
                case 7:
                    return PointerEventType.Companion.m4436getMove7fucELk();
                case 8:
                    return PointerEventType.Companion.m4439getScroll7fucELk();
                case 9:
                    return PointerEventType.Companion.m4434getEnter7fucELk();
                case 10:
                    return PointerEventType.Companion.m4435getExit7fucELk();
                default:
                    return PointerEventType.Companion.m4440getUnknown7fucELk();
            }
        } else {
            List $this$fastForEach$iv = this.changes;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                PointerInputChange it = $this$fastForEach$iv.get(index$iv);
                if (PointerEventKt.changedToUpIgnoreConsumed(it)) {
                    return PointerEventType.Companion.m4438getRelease7fucELk();
                }
                if (PointerEventKt.changedToDownIgnoreConsumed(it)) {
                    return PointerEventType.Companion.m4437getPress7fucELk();
                }
            }
            return PointerEventType.Companion.m4436getMove7fucELk();
        }
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    public final PointerEvent copy(List<PointerInputChange> changes2, MotionEvent motionEvent) {
        int $i$f$fastForEach;
        List $this$fastForEach$iv;
        boolean z;
        List<PointerInputChange> list = changes2;
        MotionEvent motionEvent2 = motionEvent;
        Intrinsics.checkNotNullParameter(list, "changes");
        if (motionEvent2 == null) {
            return new PointerEvent(list, (InternalPointerEvent) null);
        }
        if (Intrinsics.areEqual((Object) motionEvent2, (Object) getMotionEvent$ui_release())) {
            return new PointerEvent(list, this.internalPointerEvent);
        }
        LinkedHashMap map = new LinkedHashMap(changes2.size());
        ArrayList pointerEventData = new ArrayList(changes2.size());
        List $this$fastForEach$iv2 = changes2;
        int $i$f$fastForEach2 = false;
        int index$iv = 0;
        int size = $this$fastForEach$iv2.size();
        while (index$iv < size) {
            PointerInputChange change = $this$fastForEach$iv2.get(index$iv);
            map.put(PointerId.m4460boximpl(change.m4479getIdJ3iCeTQ()), change);
            Collection collection = pointerEventData;
            long r15 = change.m4479getIdJ3iCeTQ();
            long uptimeMillis = change.getUptimeMillis();
            long r19 = change.m4480getPositionF1C5BW0();
            long r21 = change.m4480getPositionF1C5BW0();
            boolean pressed = change.getPressed();
            float pressure = change.getPressure();
            int r25 = change.m4483getTypeT8wyACA();
            InternalPointerEvent internalPointerEvent2 = this.internalPointerEvent;
            if (internalPointerEvent2 != null) {
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
                z = true;
                if (internalPointerEvent2.m4410issuesEnterExitEvent0FcD4WY(change.m4479getIdJ3iCeTQ())) {
                    PointerInputEventData pointerInputEventData = r13;
                    PointerInputEventData pointerInputEventData2 = new PointerInputEventData(r15, uptimeMillis, r19, r21, pressed, pressure, r25, z, (List) null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, (DefaultConstructorMarker) null);
                    collection.add(pointerInputEventData);
                    index$iv++;
                    $this$fastForEach$iv2 = $this$fastForEach$iv;
                    $i$f$fastForEach2 = $i$f$fastForEach;
                }
            } else {
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
            }
            z = false;
            PointerInputEventData pointerInputEventData3 = pointerInputEventData2;
            PointerInputEventData pointerInputEventData22 = new PointerInputEventData(r15, uptimeMillis, r19, r21, pressed, pressure, r25, z, (List) null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, (DefaultConstructorMarker) null);
            collection.add(pointerInputEventData3);
            index$iv++;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            $i$f$fastForEach2 = $i$f$fastForEach;
        }
        int i = $i$f$fastForEach2;
        return new PointerEvent(list, new InternalPointerEvent(map, new PointerInputEvent(motionEvent.getEventTime(), pointerEventData, motionEvent2)));
    }
}
