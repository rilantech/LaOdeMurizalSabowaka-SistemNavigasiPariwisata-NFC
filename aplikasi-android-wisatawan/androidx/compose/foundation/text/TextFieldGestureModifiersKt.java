package androidx.compose.foundation.text;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a:\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0000¨\u0006\u0011"}, d2 = {"longPressDragGestureFilter", "Landroidx/compose/ui/Modifier;", "observer", "Landroidx/compose/foundation/text/TextDragObserver;", "enabled", "", "mouseDragGestureDetector", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textFieldFocusModifier", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onFocusChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldGestureModifiers.kt */
public final class TextFieldGestureModifiersKt {
    public static final Modifier longPressDragGestureFilter(Modifier $this$longPressDragGestureFilter, TextDragObserver observer, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$longPressDragGestureFilter, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput($this$longPressDragGestureFilter, (Object) observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextFieldGestureModifiersKt$longPressDragGestureFilter$1(observer, (Continuation<? super TextFieldGestureModifiersKt$longPressDragGestureFilter$1>) null));
        }
        return $this$longPressDragGestureFilter;
    }

    public static final Modifier textFieldFocusModifier(Modifier $this$textFieldFocusModifier, boolean enabled, FocusRequester focusRequester, MutableInteractionSource interactionSource, Function1<? super FocusState, Unit> onFocusChanged) {
        Intrinsics.checkNotNullParameter($this$textFieldFocusModifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return FocusableKt.focusable(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester($this$textFieldFocusModifier, focusRequester), onFocusChanged), enabled, interactionSource);
    }

    public static final Modifier mouseDragGestureDetector(Modifier $this$mouseDragGestureDetector, MouseSelectionObserver observer, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$mouseDragGestureDetector, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextFieldGestureModifiersKt$mouseDragGestureDetector$1(observer, (Continuation<? super TextFieldGestureModifiersKt$mouseDragGestureDetector$1>) null));
        }
        return $this$mouseDragGestureDetector;
    }
}
