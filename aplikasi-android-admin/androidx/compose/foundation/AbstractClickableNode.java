package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.core.app.NotificationCompat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B<\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u001c\u001a\u00020\u000eH\u0004J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u001d\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J-\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010#JG\u0010/\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b0R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000\u0001\u000223\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;)V", "clickablePointerInputNode", "Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "getClickablePointerInputNode", "()Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "clickableSemanticsNode", "Landroidx/compose/foundation/ClickableSemanticsNode;", "getClickableSemanticsNode", "()Landroidx/compose/foundation/ClickableSemanticsNode;", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "getInteractionData", "()Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "disposeInteractionSource", "onCancelPointerInput", "onDetach", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "updateCommon", "updateCommon-XHw0xAI", "InteractionData", "Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/CombinedClickableNode;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode {
    private boolean enabled;
    private final InteractionData interactionData;
    /* access modifiers changed from: private */
    public MutableInteractionSource interactionSource;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private Role role;

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role2, function0);
    }

    public abstract AbstractClickablePointerInputNode getClickablePointerInputNode();

    public abstract ClickableSemanticsNode getClickableSemanticsNode();

    private AbstractClickableNode(MutableInteractionSource interactionSource2, boolean enabled2, String onClickLabel2, Role role2, Function0<Unit> onClick2) {
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick2, "onClick");
        this.interactionSource = interactionSource2;
        this.enabled = enabled2;
        this.onClickLabel = onClickLabel2;
        this.role = role2;
        this.onClick = onClick2;
        this.interactionData = new InteractionData();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "", "()V", "centreOffset", "Landroidx/compose/ui/geometry/Offset;", "getCentreOffset-F1C5BW0", "()J", "setCentreOffset-k-4lQ0M", "(J)V", "J", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getCurrentKeyPressInteractions", "()Ljava/util/Map;", "pressInteraction", "getPressInteraction", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "setPressInteraction", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Clickable.kt */
    public static final class InteractionData {
        public static final int $stable = 8;
        private long centreOffset = Offset.Companion.m4729getZeroF1C5BW0();
        private final Map<Key, PressInteraction.Press> currentKeyPressInteractions = new LinkedHashMap();
        private PressInteraction.Press pressInteraction;

        public final Map<Key, PressInteraction.Press> getCurrentKeyPressInteractions() {
            return this.currentKeyPressInteractions;
        }

        public final PressInteraction.Press getPressInteraction() {
            return this.pressInteraction;
        }

        public final void setPressInteraction(PressInteraction.Press press) {
            this.pressInteraction = press;
        }

        /* renamed from: getCentreOffset-F1C5BW0  reason: not valid java name */
        public final long m1862getCentreOffsetF1C5BW0() {
            return this.centreOffset;
        }

        /* renamed from: setCentreOffset-k-4lQ0M  reason: not valid java name */
        public final void m1863setCentreOffsetk4lQ0M(long j) {
            this.centreOffset = j;
        }
    }

    /* access modifiers changed from: protected */
    public final InteractionData getInteractionData() {
        return this.interactionData;
    }

    /* renamed from: updateCommon-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ void m1857updateCommonXHw0xAI$default(AbstractClickableNode abstractClickableNode, MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, int i, Object obj) {
        Role role3;
        if (obj == null) {
            if ((i & 8) != 0) {
                role3 = null;
            } else {
                role3 = role2;
            }
            abstractClickableNode.m1861updateCommonXHw0xAI(mutableInteractionSource, z, str, role3, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCommon-XHw0xAI");
    }

    /* access modifiers changed from: protected */
    /* renamed from: updateCommon-XHw0xAI  reason: not valid java name */
    public final void m1861updateCommonXHw0xAI(MutableInteractionSource interactionSource2, boolean enabled2, String onClickLabel2, Role role2, Function0<Unit> onClick2) {
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick2, "onClick");
        if (!Intrinsics.areEqual((Object) this.interactionSource, (Object) interactionSource2)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource2;
        }
        if (this.enabled != enabled2) {
            if (!enabled2) {
                disposeInteractionSource();
            }
            this.enabled = enabled2;
        }
        this.onClickLabel = onClickLabel2;
        this.role = role2;
        this.onClick = onClick2;
    }

    public void onDetach() {
        disposeInteractionSource();
    }

    /* access modifiers changed from: protected */
    public final void disposeInteractionSource() {
        PressInteraction.Press oldValue = this.interactionData.getPressInteraction();
        if (oldValue != null) {
            this.interactionSource.tryEmit(new PressInteraction.Cancel(oldValue));
        }
        for (PressInteraction.Press it : this.interactionData.getCurrentKeyPressInteractions().values()) {
            this.interactionSource.tryEmit(new PressInteraction.Cancel(it));
        }
        this.interactionData.setPressInteraction((PressInteraction.Press) null);
        this.interactionData.getCurrentKeyPressInteractions().clear();
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m1859onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        getClickablePointerInputNode().m1865onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    public void onCancelPointerInput() {
        getClickablePointerInputNode().onCancelPointerInput();
    }

    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m1858onKeyEventZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (!this.enabled || !Clickable_androidKt.m1925isPressZmokQxo(event)) {
            if (!this.enabled || !Clickable_androidKt.m1923isClickZmokQxo(event)) {
                return false;
            }
            PressInteraction.Press it = this.interactionData.getCurrentKeyPressInteractions().remove(Key.m5732boximpl(KeyEvent_androidKt.m6043getKeyZmokQxo(event)));
            if (it != null) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AbstractClickableNode$onKeyEvent$2$1(this, it, (Continuation<? super AbstractClickableNode$onKeyEvent$2$1>) null), 3, (Object) null);
            }
            this.onClick.invoke();
            return true;
        } else if (this.interactionData.getCurrentKeyPressInteractions().containsKey(Key.m5732boximpl(KeyEvent_androidKt.m6043getKeyZmokQxo(event)))) {
            return false;
        } else {
            PressInteraction.Press press = new PressInteraction.Press(this.interactionData.m1862getCentreOffsetF1C5BW0(), (DefaultConstructorMarker) null);
            this.interactionData.getCurrentKeyPressInteractions().put(Key.m5732boximpl(KeyEvent_androidKt.m6043getKeyZmokQxo(event)), press);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AbstractClickableNode$onKeyEvent$1(this, press, (Continuation<? super AbstractClickableNode$onKeyEvent$1>) null), 3, (Object) null);
            return true;
        }
    }

    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m1860onPreKeyEventZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        return false;
    }
}
