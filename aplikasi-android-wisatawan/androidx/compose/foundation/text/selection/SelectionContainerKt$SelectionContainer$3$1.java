package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $children;
    final /* synthetic */ SelectionManager $manager;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$3$1(Modifier modifier, SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$manager = selectionManager;
        this.$children = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C98@3620L1677:SelectionContainer.kt#eksfi3");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(935424596, $changed, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:95)");
            }
            Modifier then = this.$modifier.then(this.$manager.getModifier());
            final Function2<Composer, Integer, Unit> function2 = this.$children;
            final int i = this.$$dirty;
            final SelectionManager selectionManager = this.$manager;
            SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda($composer, 1375295262, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    Selection selection;
                    Object value$iv$iv;
                    Offset offset;
                    ResolvedTextDirection direction;
                    List $this$fastForEach$iv;
                    int i;
                    int index$iv;
                    Composer composer = $composer;
                    int i2 = $changed;
                    ComposerKt.sourceInformation(composer, "C99@3695L10,*103@3926L129,119@4623L564:SelectionContainer.kt#eksfi3");
                    if ((i2 & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1375295262, i2, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:98)");
                        }
                        function2.invoke(composer, Integer.valueOf((i >> 9) & 14));
                        if (TouchMode_androidKt.isInTouchMode() && selectionManager.getHasFocus() && (selection = selectionManager.getSelection()) != null) {
                            SelectionManager selectionManager = selectionManager;
                            Selection it = selection;
                            boolean z = false;
                            List $this$fastForEach$iv2 = CollectionsKt.listOf(true, false);
                            int size = $this$fastForEach$iv2.size();
                            int index$iv2 = 0;
                            while (index$iv2 < size) {
                                boolean isStartHandle = ((Boolean) $this$fastForEach$iv2.get(index$iv2)).booleanValue();
                                Object key1$iv = Boolean.valueOf(isStartHandle);
                                boolean z2 = z;
                                composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean invalid$iv$iv = composer.changed(key1$iv);
                                Composer $this$cache$iv$iv = $composer;
                                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                                    value$iv$iv = selectionManager.handleDragObserver(isStartHandle);
                                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                                } else {
                                    value$iv$iv = it$iv$iv;
                                }
                                $composer.endReplaceableGroup();
                                TextDragObserver observer = (TextDragObserver) value$iv$iv;
                                if (isStartHandle) {
                                    offset = selectionManager.m1098getStartHandlePosition_m7T9E();
                                } else {
                                    offset = selectionManager.m1097getEndHandlePosition_m7T9E();
                                }
                                Offset position = offset;
                                if (isStartHandle) {
                                    direction = it.getStart().getDirection();
                                } else {
                                    direction = it.getEnd().getDirection();
                                }
                                if (position != null) {
                                    index$iv = index$iv2;
                                    i = size;
                                    boolean z3 = isStartHandle;
                                    $this$fastForEach$iv = $this$fastForEach$iv2;
                                    AndroidSelectionHandles_androidKt.m1037SelectionHandle8fL75g(position.m3013unboximpl(), isStartHandle, direction, it.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(observer, (Continuation<? super SelectionContainerKt$SelectionContainer$3$1$1$1$1$1>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                } else {
                                    index$iv = index$iv2;
                                    i = size;
                                    $this$fastForEach$iv = $this$fastForEach$iv2;
                                }
                                index$iv2 = index$iv + 1;
                                z = false;
                                size = i;
                                $this$fastForEach$iv2 = $this$fastForEach$iv;
                            }
                            int i3 = index$iv2;
                            List list = $this$fastForEach$iv2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
