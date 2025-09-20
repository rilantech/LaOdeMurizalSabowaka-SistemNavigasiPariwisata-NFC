package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
/* compiled from: TextField.kt */
final class TextFieldKt$TextField$2 extends Lambda implements Function2<Composer, Integer, Unit> {
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
    TextFieldKt$TextField$2(Modifier modifier, TextFieldColors textFieldColors, boolean z, int i, int i2, String str, Function1<? super String, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i3, int i4, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i5, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
        super(2);
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
        this.$label = function2;
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
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C208@10657L20,197@10219L1726:TextField.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1859145987, i, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:196)");
            }
            Modifier r3 = SizeKt.m596defaultMinSizeVpY3zN4(this.$modifier, TextFieldDefaults.INSTANCE.m2123getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2122getMinHeightD9Ej5fM());
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
            final Shape shape = this.$shape;
            final TextFieldColors textFieldColors = this.$colors;
            final int i2 = this.$$dirty;
            final int i3 = this.$$dirty1;
            final int i4 = this.$$dirty2;
            AnonymousClass1 r17 = new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
                    Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
                    Composer composer = $composer;
                    Intrinsics.checkNotNullParameter(function2, "innerTextField");
                    ComposerKt.sourceInformation(composer, "C218@11178L743:TextField.kt#uh7d8r");
                    int $dirty = $changed;
                    if (($changed & 14) == 0) {
                        $dirty |= composer.changedInstance(function2) ? 4 : 2;
                    }
                    int $dirty2 = $dirty;
                    if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-288211827, $dirty2, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:216)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = str3;
                        boolean z = z;
                        boolean z2 = z3;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        Function2<Composer, Integer, Unit> function23 = function22;
                        Function2<Composer, Integer, Unit> function24 = function23;
                        Function2<Composer, Integer, Unit> function25 = function24;
                        Function2<Composer, Integer, Unit> function26 = function25;
                        int $dirty3 = $dirty2;
                        Function2<Composer, Integer, Unit> function27 = function26;
                        Function2<Composer, Integer, Unit> function28 = function27;
                        Shape shape = shape;
                        TextFieldColors textFieldColors = textFieldColors;
                        int i = i2;
                        String str2 = str;
                        int i2 = i3;
                        boolean z3 = z;
                        int i3 = i4;
                        int i4 = (i & 14) | (($dirty3 << 3) & 112) | ((i >> 3) & 896) | ((i2 >> 12) & 7168) | (i2 & 57344) | ((i3 << 15) & 458752) | ((i2 << 9) & 3670016) | ((i << 3) & 29360128) | ((i << 3) & 234881024) | ((i << 3) & 1879048192);
                        int i5 = ((i >> 27) & 14) | 100663296 | ((i2 << 3) & 112) | ((i2 << 3) & 896) | ((i2 << 3) & 7168) | ((i3 << 9) & 57344) | ((i3 << 9) & 458752);
                        textFieldDefaults.DecorationBox(str2, innerTextField, z3, z2, visualTransformation, mutableInteractionSource, z2, function22, function23, function24, function25, function26, function27, function28, shape, textFieldColors, (PaddingValues) null, (Function2<? super Composer, ? super Integer, Unit>) null, $composer, i4, i5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                    int i6 = $dirty2;
                }
            };
            int i5 = this.$$dirty;
            int i6 = this.$$dirty1;
            int i7 = (i5 & 57344) | (i5 & 14) | (i5 & 112) | (i5 & 7168) | ((i6 << 3) & 3670016) | ((i6 << 3) & 29360128) | ((i6 << 3) & 234881024) | ((i6 << 3) & 1879048192);
            int i8 = ((i6 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i6 >> 9) & 112) | ((this.$$dirty2 << 9) & 7168);
            Modifier modifier = r3;
            String str4 = str2;
            Function1<String, Unit> function12 = function1;
            BasicTextFieldKt.BasicTextField(str4, (Function1<? super String, Unit>) function12, modifier, this.$enabled, this.$readOnly, this.$mergedTextStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$minLines, this.$visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, this.$interactionSource, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -288211827, true, r17), $composer, i7, i8, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
