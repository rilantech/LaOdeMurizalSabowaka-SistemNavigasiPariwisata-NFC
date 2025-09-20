package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aW\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000f\u001aE\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0010\u001a\u0001\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001aw\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0016\u001a¡\u0001\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b!\u001aC\u0010\"\u001a\u00020\u000e*\u00020#2\u0006\u0010$\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\rH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006*"}, d2 = {"clickable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-Kqv-Bsg", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m200clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m199clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m199clickableXHw0xAI(Modifier $this$clickable_u2dXHw0xAI, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$clickable_u2dXHw0xAI, "$this$clickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$clickable_u2dXHw0xAI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(enabled, onClickLabel, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(enabled, onClickLabel, role, onClick));
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m198clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        boolean z2;
        String str2;
        Role role2;
        if ((i & 4) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 16) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        return m197clickableO2vRcR0(modifier, mutableInteractionSource, indication, z2, str2, role2, function0);
    }

    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    public static final Modifier m197clickableO2vRcR0(Modifier $this$clickable_u2dO2vRcR0, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        MutableInteractionSource mutableInteractionSource = interactionSource;
        boolean z = enabled;
        Intrinsics.checkNotNullParameter($this$clickable_u2dO2vRcR0, "$this$clickable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(interactionSource, indication, enabled, onClickLabel, role, onClick) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper($this$clickable_u2dO2vRcR0, inspectorInfo$iv, FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(new ClickableElement(interactionSource, enabled, onClickLabel, role, onClick, (DefaultConstructorMarker) null)));
    }

    /* renamed from: combinedClickable-cJG_KMw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m204combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        boolean z2;
        String str3;
        Role role2;
        String str4;
        Function0 function04;
        Function0 function05;
        if ((i & 1) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i & 2) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i & 4) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if ((i & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i & 16) != 0) {
            function04 = null;
        } else {
            function04 = function0;
        }
        if ((i & 32) != 0) {
            function05 = null;
        } else {
            function05 = function02;
        }
        return m203combinedClickablecJG_KMw(modifier, z2, str3, role2, str4, function04, function05, function03);
    }

    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    public static final Modifier m203combinedClickablecJG_KMw(Modifier $this$combinedClickable_u2dcJG_KMw, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, Function0<Unit> onClick) {
        Modifier modifier = $this$combinedClickable_u2dcJG_KMw;
        Intrinsics.checkNotNullParameter($this$combinedClickable_u2dcJG_KMw, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed($this$combinedClickable_u2dcJG_KMw, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(enabled, onClickLabel, role, onClick, onDoubleClick, onLongClick, onLongClickLabel) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$2(enabled, onClickLabel, role, onLongClickLabel, onLongClick, onDoubleClick, onClick));
    }

    /* renamed from: combinedClickable-XVZzFYc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m202combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        boolean z2;
        String str3;
        Role role2;
        String str4;
        Function0 function04;
        Function0 function05;
        int i2 = i;
        if ((i2 & 4) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i2 & 16) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if ((i2 & 32) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i2 & 64) != 0) {
            function04 = null;
        } else {
            function04 = function0;
        }
        if ((i2 & 128) != 0) {
            function05 = null;
        } else {
            function05 = function02;
        }
        return m201combinedClickableXVZzFYc(modifier, mutableInteractionSource, indication, z2, str3, role2, str4, function04, function05, function03);
    }

    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    public static final Modifier m201combinedClickableXVZzFYc(Modifier $this$combinedClickable_u2dXVZzFYc, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, Function0<Unit> onClick) {
        MutableInteractionSource mutableInteractionSource = interactionSource;
        boolean z = enabled;
        Intrinsics.checkNotNullParameter($this$combinedClickable_u2dXVZzFYc, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(indication, interactionSource, enabled, onClickLabel, role, onClick, onDoubleClick, onLongClick, onLongClickLabel) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper($this$combinedClickable_u2dXVZzFYc, inspectorInfo$iv, FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(new CombinedClickableElement(interactionSource, enabled, onClickLabel, role, onClick, onLongClickLabel, onLongClick, onDoubleClick, (DefaultConstructorMarker) null)));
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePressInteraction-EPk0efs  reason: not valid java name */
    public static final Object m207handlePressInteractionEPk0efs(PressGestureScope $this$handlePressInteraction_u2dEPk0efs, long pressPoint, MutableInteractionSource interactionSource, AbstractClickableNode.InteractionData interactionData, Function0<Boolean> delayPressInteraction, Continuation<? super Unit> $completion) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2($this$handlePressInteraction_u2dEPk0efs, pressPoint, interactionSource, interactionData, delayPressInteraction, (Continuation<? super ClickableKt$handlePressInteraction$2>) null), $completion);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg$default  reason: not valid java name */
    public static /* synthetic */ Modifier m206genericClickableWithoutGestureKqvBsg$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map map, State state, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        String str3;
        Role role2;
        String str4;
        Function0 function03;
        int i2 = i;
        boolean z2 = (i2 & 32) != 0 ? true : z;
        if ((i2 & 64) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i2 & 128) != 0) {
            role2 = null;
        } else {
            role2 = role;
        }
        if ((i2 & 256) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i2 & 512) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        return m205genericClickableWithoutGestureKqvBsg(modifier, mutableInteractionSource, indication, coroutineScope, map, state, z2, str3, role2, str4, function03, function02);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier $this$genericClickableWithoutGesture_Kqv_Bsg_u24detectPressAndClickFromKey, boolean $enabled, Map<Key, PressInteraction.Press> $currentKeyPressInteractions, State<Offset> $keyClickOffset, CoroutineScope $indicationScope, Function0<Unit> $onClick, MutableInteractionSource $interactionSource) {
        return KeyInputModifierKt.onKeyEvent($this$genericClickableWithoutGesture_Kqv_Bsg_u24detectPressAndClickFromKey, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1($enabled, $currentKeyPressInteractions, $keyClickOffset, $indicationScope, $onClick, $interactionSource));
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg  reason: not valid java name */
    public static final Modifier m205genericClickableWithoutGestureKqvBsg(Modifier $this$genericClickableWithoutGesture_u2dKqv_u2dBsg, MutableInteractionSource interactionSource, Indication indication, CoroutineScope indicationScope, Map<Key, PressInteraction.Press> currentKeyPressInteractions, State<Offset> keyClickOffset, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onClick) {
        Modifier modifier = $this$genericClickableWithoutGesture_u2dKqv_u2dBsg;
        MutableInteractionSource mutableInteractionSource = interactionSource;
        Intrinsics.checkNotNullParameter(modifier, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(indicationScope, "indicationScope");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        State<Offset> state = keyClickOffset;
        Intrinsics.checkNotNullParameter(state, "keyClickOffset");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        boolean z = enabled;
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(enabled, role, onLongClickLabel, onLongClick, onClickLabel, onClick, (DefaultConstructorMarker) null), enabled, currentKeyPressInteractions, state, indicationScope, onClick, interactionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource));
    }
}
