package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$semanticsModifier$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ boolean $isPassword;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TransformedText $transformedText;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$semanticsModifier$1(ImeOptions imeOptions, TransformedText transformedText, TextFieldValue textFieldValue, boolean z, boolean z2, boolean z3, TextFieldState textFieldState, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, FocusRequester focusRequester) {
        super(1);
        this.$imeOptions = imeOptions;
        this.$transformedText = transformedText;
        this.$value = textFieldValue;
        this.$enabled = z;
        this.$isPassword = z2;
        this.$readOnly = z3;
        this.$state = textFieldState;
        this.$offsetMapping = offsetMapping;
        this.$manager = textFieldSelectionManager;
        this.$focusRequester = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(final SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.m6884setImeAction4L7nppU($this$semantics, this.$imeOptions.m7216getImeActioneUduSuo());
        SemanticsPropertiesKt.setEditableText($this$semantics, this.$transformedText.getText());
        SemanticsPropertiesKt.m6887setTextSelectionRangeFDrldGo($this$semantics, this.$value.m7265getSelectiond9O1mEE());
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled($this$semantics);
        }
        if (this.$isPassword) {
            SemanticsPropertiesKt.password($this$semantics);
        }
        final TextFieldState textFieldState = this.$state;
        SemanticsPropertiesKt.getTextLayoutResult$default($this$semantics, (String) null, new Function1<List<TextLayoutResult>, Boolean>() {
            public final Boolean invoke(List<TextLayoutResult> it) {
                boolean z;
                Intrinsics.checkNotNullParameter(it, "it");
                if (textFieldState.getLayoutResult() != null) {
                    TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                    Intrinsics.checkNotNull(layoutResult);
                    it.add(layoutResult.getValue());
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, 1, (Object) null);
        final boolean z = this.$readOnly;
        final boolean z2 = this.$enabled;
        final TextFieldState textFieldState2 = this.$state;
        SemanticsPropertiesKt.setText$default($this$semantics, (String) null, new Function1<AnnotatedString, Boolean>() {
            public final Boolean invoke(AnnotatedString text) {
                Unit unit;
                Intrinsics.checkNotNullParameter(text, "text");
                if (z || !z2) {
                    return false;
                }
                TextInputSession session = textFieldState2.getInputSession();
                if (session != null) {
                    TextFieldState textFieldState = textFieldState2;
                    TextFieldDelegate.Companion.onEditCommand$foundation_release(CollectionsKt.listOf(new DeleteAllCommand(), new CommitTextCommand(text, 1)), textFieldState.getProcessor(), textFieldState.getOnValueChange(), session);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                    textFieldState2.getOnValueChange().invoke(new TextFieldValue(text.getText(), TextRangeKt.TextRange(text.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                }
                return true;
            }
        }, 1, (Object) null);
        final boolean z3 = this.$readOnly;
        final boolean z4 = this.$enabled;
        final TextFieldState textFieldState3 = this.$state;
        final TextFieldValue textFieldValue = this.$value;
        final SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
        SemanticsPropertiesKt.insertTextAtCursor$default($this$semantics, (String) null, new Function1<AnnotatedString, Boolean>() {
            public final Boolean invoke(AnnotatedString text) {
                Unit unit;
                AnnotatedString annotatedString = text;
                Intrinsics.checkNotNullParameter(annotatedString, "text");
                if (z3 || !z4) {
                    return false;
                }
                TextInputSession session = textFieldState3.getInputSession();
                if (session != null) {
                    TextFieldState textFieldState = textFieldState3;
                    TextFieldDelegate.Companion.onEditCommand$foundation_release(CollectionsKt.listOf(new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)), textFieldState.getProcessor(), textFieldState.getOnValueChange(), session);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    SemanticsPropertyReceiver semanticsPropertyReceiver = semanticsPropertyReceiver;
                    TextFieldValue textFieldValue = textFieldValue;
                    textFieldState3.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue.getText(), TextRange.m7035getStartimpl(textFieldValue.m7265getSelectiond9O1mEE()), TextRange.m7030getEndimpl(textFieldValue.m7265getSelectiond9O1mEE()), (CharSequence) annotatedString).toString(), TextRangeKt.TextRange(TextRange.m7035getStartimpl(textFieldValue.m7265getSelectiond9O1mEE()) + text.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                }
                return true;
            }
        }, 1, (Object) null);
        final OffsetMapping offsetMapping = this.$offsetMapping;
        final boolean z5 = this.$enabled;
        final TextFieldValue textFieldValue2 = this.$value;
        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
        final TextFieldState textFieldState4 = this.$state;
        SemanticsPropertiesKt.setSelection$default($this$semantics, (String) null, new Function3<Integer, Integer, Boolean, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), ((Boolean) p3).booleanValue());
            }

            public final Boolean invoke(int selectionStart, int selectionEnd, boolean relativeToOriginalText) {
                int start;
                int end;
                if (relativeToOriginalText) {
                    start = selectionStart;
                } else {
                    start = offsetMapping.transformedToOriginal(selectionStart);
                }
                if (relativeToOriginalText) {
                    end = selectionEnd;
                } else {
                    end = offsetMapping.transformedToOriginal(selectionEnd);
                }
                boolean z = false;
                if (z5 && !(start == TextRange.m7035getStartimpl(textFieldValue2.m7265getSelectiond9O1mEE()) && end == TextRange.m7030getEndimpl(textFieldValue2.m7265getSelectiond9O1mEE()))) {
                    if (RangesKt.coerceAtMost(start, end) < 0 || RangesKt.coerceAtLeast(start, end) > textFieldValue2.getAnnotatedString().length()) {
                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                    } else {
                        if (relativeToOriginalText || start == end) {
                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                        } else {
                            textFieldSelectionManager.enterSelectionMode$foundation_release();
                        }
                        textFieldState4.getOnValueChange().invoke(new TextFieldValue(textFieldValue2.getAnnotatedString(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        }, 1, (Object) null);
        final TextFieldState textFieldState5 = this.$state;
        final ImeOptions imeOptions = this.$imeOptions;
        SemanticsPropertiesKt.performImeAction$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                textFieldState5.getOnImeActionPerformed().invoke(ImeAction.m7190boximpl(imeOptions.m7216getImeActioneUduSuo()));
                return true;
            }
        }, 1, (Object) null);
        final TextFieldState textFieldState6 = this.$state;
        final FocusRequester focusRequester = this.$focusRequester;
        final boolean z6 = this.$readOnly;
        SemanticsPropertiesKt.onClick$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                CoreTextFieldKt.tapToFocus(textFieldState6, focusRequester, !z6);
                return true;
            }
        }, 1, (Object) null);
        final TextFieldSelectionManager textFieldSelectionManager2 = this.$manager;
        SemanticsPropertiesKt.onLongClick$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                textFieldSelectionManager2.enterSelectionMode$foundation_release();
                return true;
            }
        }, 1, (Object) null);
        if (!TextRange.m7029getCollapsedimpl(this.$value.m7265getSelectiond9O1mEE()) && !this.$isPassword) {
            final TextFieldSelectionManager textFieldSelectionManager3 = this.$manager;
            SemanticsPropertiesKt.copyText$default($this$semantics, (String) null, new Function0<Boolean>() {
                public final Boolean invoke() {
                    TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, (Object) null);
                    return true;
                }
            }, 1, (Object) null);
            if (this.$enabled && !this.$readOnly) {
                final TextFieldSelectionManager textFieldSelectionManager4 = this.$manager;
                SemanticsPropertiesKt.cutText$default($this$semantics, (String) null, new Function0<Boolean>() {
                    public final Boolean invoke() {
                        textFieldSelectionManager4.cut$foundation_release();
                        return true;
                    }
                }, 1, (Object) null);
            }
        }
        if (this.$enabled && !this.$readOnly) {
            final TextFieldSelectionManager textFieldSelectionManager5 = this.$manager;
            SemanticsPropertiesKt.pasteText$default($this$semantics, (String) null, new Function0<Boolean>() {
                public final Boolean invoke() {
                    textFieldSelectionManager5.paste$foundation_release();
                    return true;
                }
            }, 1, (Object) null);
        }
    }
}
