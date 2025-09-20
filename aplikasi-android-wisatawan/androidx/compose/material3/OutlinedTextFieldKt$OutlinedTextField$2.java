package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextField$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextField$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, TextFieldColors textFieldColors, boolean z, int i, int i2, String str, Function1<? super String, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i3, int i4, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i5, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
        super(2);
        this.$label = function2;
        this.$modifier = modifier;
        this.$colors = textFieldColors;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$$dirty2 = i2;
        this.$value = str;
        this.$onValueChange = function1;
        this.$enabled = z2;
        this.$readOnly = z3;
        this.$mergedTextStyle = textStyle;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$singleLine = z4;
        this.$maxLines = i3;
        this.$minLines = i4;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$$dirty = i5;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$prefix = function25;
        this.$suffix = function26;
        this.$supportingText = function27;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Modifier modifier;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C190@10308L20,171@9477L2337:OutlinedTextField.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1886965181, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:170)");
            }
            if (this.$label != null) {
                modifier = PaddingKt.m542paddingqDBjuR0$default(SemanticsModifierKt.semantics(this.$modifier, true, AnonymousClass1.INSTANCE), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, (Object) null);
            } else {
                modifier = this.$modifier;
            }
            Modifier r3 = SizeKt.m596defaultMinSizeVpY3zN4(modifier, OutlinedTextFieldDefaults.INSTANCE.m1898getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m1897getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.cursorColor$material3_release(this.$isError, composer, ((this.$$dirty1 >> 9) & 14) | ((this.$$dirty2 >> 3) & 112)).getValue().m3263unboximpl(), (DefaultConstructorMarker) null);
            String str = this.$value;
            String str2 = str;
            Function1<String, Unit> function1 = this.$onValueChange;
            final String str3 = this.$value;
            final boolean z = this.$enabled;
            final boolean z2 = this.$singleLine;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final boolean z3 = this.$isError;
            final Function2<Composer, Integer, Unit> function2 = this.$label;
            final Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function25 = this.$prefix;
            final Function2<Composer, Integer, Unit> function26 = this.$suffix;
            final Function2<Composer, Integer, Unit> function27 = this.$supportingText;
            final TextFieldColors textFieldColors = this.$colors;
            final int i2 = this.$$dirty;
            final int i3 = this.$$dirty1;
            final int i4 = this.$$dirty2;
            final Shape shape = this.$shape;
            int i5 = this.$$dirty;
            int i6 = this.$$dirty1;
            int i7 = (i5 & 57344) | (i5 & 14) | (i5 & 112) | (i5 & 7168) | ((i6 << 3) & 3670016) | ((i6 << 3) & 29360128) | ((i6 << 3) & 234881024) | ((i6 << 3) & 1879048192);
            int i8 = ((i6 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i6 >> 9) & 112) | ((this.$$dirty2 << 9) & 7168);
            String str4 = str2;
            Modifier modifier2 = r3;
            Function1<String, Unit> function12 = function1;
            BasicTextFieldKt.BasicTextField(str4, (Function1<? super String, Unit>) function12, modifier2, this.$enabled, this.$readOnly, this.$mergedTextStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$minLines, this.$visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, this.$interactionSource, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1474611661, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
                    Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
                    Composer composer = $composer;
                    Intrinsics.checkNotNullParameter(function2, "innerTextField");
                    ComposerKt.sourceInformation(composer, "C199@10744L1046:OutlinedTextField.kt#uh7d8r");
                    int $dirty = $changed;
                    if (($changed & 14) == 0) {
                        $dirty |= composer.changedInstance(function2) ? 4 : 2;
                    }
                    int $dirty2 = $dirty;
                    if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1474611661, $dirty2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:198)");
                        }
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        String str = str3;
                        boolean z = z;
                        boolean z2 = z2;
                        VisualTransformation visualTransformation = visualTransformation;
                        boolean z3 = z3;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        Function2<Composer, Integer, Unit> function23 = function22;
                        String str2 = str;
                        boolean z4 = z;
                        boolean z5 = z;
                        boolean z6 = z3;
                        boolean z7 = z2;
                        MutableInteractionSource mutableInteractionSource = mutableInteractionSource;
                        VisualTransformation visualTransformation2 = visualTransformation;
                        TextFieldColors textFieldColors = textFieldColors;
                        InteractionSource interactionSource = mutableInteractionSource;
                        Shape shape = shape;
                        boolean z8 = z3;
                        final boolean z9 = z4;
                        final boolean z10 = z6;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final Shape shape2 = shape;
                        final int i = i2;
                        final int i2 = i3;
                        final int i3 = i4;
                        int i4 = i2;
                        int i5 = i3;
                        int i6 = i4;
                        int i7 = (i4 & 14) | (($dirty2 << 3) & 112) | ((i4 >> 3) & 896) | ((i5 >> 12) & 7168) | (i5 & 57344) | ((i6 << 15) & 458752) | ((i5 << 9) & 3670016) | ((i4 << 3) & 29360128) | ((i4 << 3) & 234881024) | ((i4 << 3) & 1879048192);
                        int i8 = ((i4 >> 27) & 14) | 14155776 | ((i5 << 3) & 112) | ((i5 << 3) & 896) | ((i5 << 3) & 7168) | ((i6 << 6) & 57344);
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = outlinedTextFieldDefaults;
                        String str3 = str2;
                        outlinedTextFieldDefaults2.DecorationBox(str3, innerTextField, z5, z7, visualTransformation2, interactionSource, z8, function22, function23, function23, function24, function25, function26, function27, textFieldColors, (PaddingValues) null, ComposableLambdaKt.composableLambda(composer, 2108828640, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                int i = $changed;
                                ComposerKt.sourceInformation($composer, "C216@11520L230:OutlinedTextField.kt#uh7d8r");
                                if ((i & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2108828640, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:215)");
                                    }
                                    TextFieldColors textFieldColors = textFieldColors2;
                                    Shape shape = shape2;
                                    int i2 = ((i >> 9) & 14) | 12582912 | ((i2 >> 6) & 112);
                                    int i3 = i3;
                                    OutlinedTextFieldDefaults.INSTANCE.m1893ContainerBoxnbWgWpA(z9, z10, mutableInteractionSource2, textFieldColors, shape, 0.0f, 0.0f, $composer, i2 | ((i3 << 6) & 896) | ((i3 << 3) & 7168) | ((i3 << 9) & 57344), 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }), $composer, i7, i8, 32768);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                    int i9 = $dirty2;
                }
            }), $composer, i7, i8, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
