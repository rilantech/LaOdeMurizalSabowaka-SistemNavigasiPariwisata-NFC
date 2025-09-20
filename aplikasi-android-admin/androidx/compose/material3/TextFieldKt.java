package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010-\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010/\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001aì\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001au\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001aU\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020\f*\u00020\f2\u0006\u0010V\u001a\u00020WH\u0000\u001a\u0001\u0010X\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010H\u001a\u000206H\u0002\u001a\u0001\u0010h\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010i\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelFocused", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m7554constructorimpl((float) 8);

    public static final void TextField(String value, Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        int i2;
        int i3;
        int maxLines2;
        int minLines2;
        boolean singleLine2;
        KeyboardActions keyboardActions2;
        KeyboardOptions keyboardOptions2;
        VisualTransformation visualTransformation2;
        boolean readOnly2;
        TextStyle textStyle2;
        TextFieldColors colors2;
        Shape shape2;
        MutableInteractionSource interactionSource2;
        int maxLines3;
        boolean isError2;
        Function2 supportingText2;
        Function2 supportingText3;
        Function2 suffix2;
        Function2 prefix2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Function2 placeholder2;
        boolean enabled2;
        Modifier modifier2;
        Composer $composer2;
        int $dirty2;
        Shape shape3;
        MutableInteractionSource interactionSource3;
        int maxLines4;
        boolean isError3;
        Function2 supportingText4;
        Function2 suffix3;
        Function2 prefix3;
        Function2 trailingIcon3;
        Function2 leadingIcon3;
        Function2 placeholder3;
        Function2 label2;
        boolean enabled3;
        Modifier modifier3;
        TextStyle textStyle3;
        TextFieldColors colors3;
        int $dirty;
        int $dirty1;
        long textColor;
        Modifier modifier4;
        boolean enabled4;
        boolean enabled5;
        Modifier modifier5;
        TextStyle textStyle4;
        Function2 label3;
        Function2 placeholder4;
        Function2 leadingIcon4;
        Function2 trailingIcon4;
        Function2 prefix4;
        Function2 suffix4;
        Function2 supportingText5;
        boolean isError4;
        int $dirty12;
        int $dirty3;
        MutableInteractionSource interactionSource4;
        MutableInteractionSource interactionSource5;
        Shape shape4;
        Object value$iv$iv;
        int i4;
        int i5;
        int i6;
        int i7;
        String str = value;
        Function1<? super String, Unit> function1 = onValueChange;
        int i8 = $changed;
        int i9 = $changed1;
        int i10 = $changed2;
        int i11 = i;
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)171@8945L7,186@9697L39,187@9775L5,188@9830L8,196@10192L15,196@10126L1825:TextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        int $dirty22 = $changed2;
        if ((i11 & 1) != 0) {
            $dirty4 |= 6;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed((Object) str) ? 4 : 2;
        }
        if ((i11 & 2) != 0) {
            $dirty4 |= 48;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i12 = i11 & 4;
        if (i12 != 0) {
            $dirty4 |= 384;
            Modifier modifier6 = modifier;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier7 = modifier;
        }
        int i13 = i11 & 8;
        int i14 = 2048;
        if (i13 != 0) {
            $dirty4 |= 3072;
            boolean z = enabled;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : true;
        } else {
            boolean z2 = enabled;
        }
        int i15 = i11 & 16;
        int i16 = 16384;
        if (i15 != 0) {
            $dirty4 |= 24576;
            boolean z3 = readOnly;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : true;
        } else {
            boolean z4 = readOnly;
        }
        if (i8 == false || !true) {
            if ((i11 & 32) != 0) {
                TextStyle textStyle5 = textStyle;
            } else if ($composer3.changed((Object) textStyle)) {
                i7 = 131072;
                $dirty4 |= i7;
            }
            i7 = 65536;
            $dirty4 |= i7;
        } else {
            TextStyle textStyle6 = textStyle;
        }
        int i17 = i11 & 64;
        if (i17 != 0) {
            $dirty4 |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function2 = label;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(label) ? 1048576 : true;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = label;
        }
        int i18 = i11 & 128;
        if (i18 != 0) {
            $dirty4 |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function23 = placeholder;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(placeholder) ? 8388608 : 0;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = placeholder;
        }
        int i19 = i11 & 256;
        if (i19 != 0) {
            $dirty4 |= 100663296;
            Function2<? super Composer, ? super Integer, Unit> function25 = leadingIcon;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = leadingIcon;
        }
        int i20 = i11 & 512;
        if (i20 != 0) {
            $dirty4 |= 805306368;
            Function2<? super Composer, ? super Integer, Unit> function27 = trailingIcon;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = trailingIcon;
        }
        int i21 = i11 & 1024;
        if (i21 != 0) {
            $dirty13 |= 6;
            Function2<? super Composer, ? super Integer, Unit> function29 = prefix;
        } else if ((i9 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(prefix) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function210 = prefix;
        }
        int i22 = i11 & 2048;
        if (i22 != 0) {
            $dirty13 |= 48;
            Function2<? super Composer, ? super Integer, Unit> function211 = suffix;
        } else if ((i9 & 112) == 0) {
            $dirty13 |= $composer3.changedInstance(suffix) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function212 = suffix;
        }
        int i23 = i11 & 4096;
        if (i23 != 0) {
            $dirty13 |= 384;
            Function2<? super Composer, ? super Integer, Unit> function213 = supportingText;
        } else if ((i9 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(supportingText) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function214 = supportingText;
        }
        int i24 = i11 & 8192;
        if (i24 != 0) {
            $dirty13 |= 3072;
            i2 = i24;
            boolean z5 = isError;
        } else {
            i2 = i24;
            if ((i9 & 7168) == 0) {
                if (!$composer3.changed(isError)) {
                    i14 = 1024;
                }
                $dirty13 |= i14;
            } else {
                boolean z6 = isError;
            }
        }
        int i25 = i11 & 16384;
        if (i25 != 0) {
            $dirty13 |= 24576;
            i3 = i25;
            VisualTransformation visualTransformation3 = visualTransformation;
        } else if ((i9 & 57344) == 0) {
            i3 = i25;
            if (!$composer3.changed((Object) visualTransformation)) {
                i16 = 8192;
            }
            $dirty13 |= i16;
        } else {
            i3 = i25;
            VisualTransformation visualTransformation4 = visualTransformation;
        }
        int i26 = i11 & 32768;
        if (i26 != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            KeyboardOptions keyboardOptions3 = keyboardOptions;
        } else if ((i9 & 458752) == 0) {
            $dirty13 |= $composer3.changed((Object) keyboardOptions) ? 131072 : 65536;
        } else {
            KeyboardOptions keyboardOptions4 = keyboardOptions;
        }
        int i27 = i11 & 65536;
        if (i27 != 0) {
            $dirty13 |= 1572864;
            KeyboardActions keyboardActions3 = keyboardActions;
        } else if ((i9 & 3670016) == 0) {
            $dirty13 |= $composer3.changed((Object) keyboardActions) ? 1048576 : 524288;
        } else {
            KeyboardActions keyboardActions4 = keyboardActions;
        }
        int i28 = i11 & 131072;
        if (i28 != 0) {
            $dirty13 |= 12582912;
            boolean z7 = singleLine;
        } else if ((i9 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        } else {
            boolean z8 = singleLine;
        }
        if ((i9 & 234881024) == 0) {
            if ((i11 & 262144) == 0) {
                maxLines2 = maxLines;
                if ($composer3.changed(maxLines2)) {
                    i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty13 |= i6;
                }
            } else {
                maxLines2 = maxLines;
            }
            i6 = 33554432;
            $dirty13 |= i6;
        } else {
            maxLines2 = maxLines;
        }
        int i29 = i11 & 524288;
        if (i29 != 0) {
            $dirty13 |= 805306368;
            int i30 = minLines;
        } else if ((i9 & 1879048192) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        } else {
            int i31 = minLines;
        }
        int i32 = i11 & 1048576;
        if (i32 != 0) {
            $dirty22 |= 6;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i10 & 14) == 0) {
            $dirty22 |= $composer3.changed((Object) interactionSource) ? 4 : 2;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i10 & 112) == 0) {
            if ((i11 & 2097152) != 0) {
                Shape shape5 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i5 = 32;
                $dirty22 |= i5;
            }
            i5 = 16;
            $dirty22 |= i5;
        } else {
            Shape shape6 = shape;
        }
        if ((i10 & 896) == 0) {
            if ((i11 & 4194304) != 0) {
                TextFieldColors textFieldColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i4 = 256;
                $dirty22 |= i4;
            }
            i4 = 128;
            $dirty22 |= i4;
        } else {
            TextFieldColors textFieldColors2 = colors;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && ($dirty22 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            placeholder2 = label;
            leadingIcon2 = placeholder;
            trailingIcon2 = leadingIcon;
            prefix2 = trailingIcon;
            suffix2 = prefix;
            supportingText3 = suffix;
            supportingText2 = supportingText;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource2 = interactionSource;
            shape2 = shape;
            colors2 = colors;
            int i33 = $dirty4;
            int i34 = $dirty13;
            int i35 = $dirty22;
            maxLines3 = maxLines2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i8 == false || !true) || $composer3.getDefaultsInvalid()) {
                if (i12 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
                }
                if (i13 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i15 != 0) {
                    readOnly2 = false;
                } else {
                    readOnly2 = readOnly;
                }
                if ((i11 & 32) != 0) {
                    modifier5 = modifier4;
                    enabled5 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(TextKt.getLocalTextStyle());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle4 = (TextStyle) consume;
                    $dirty4 &= -458753;
                } else {
                    modifier5 = modifier4;
                    enabled5 = enabled4;
                    textStyle4 = textStyle;
                }
                if (i17 != 0) {
                    label3 = null;
                } else {
                    label3 = label;
                }
                if (i18 != 0) {
                    placeholder4 = null;
                } else {
                    placeholder4 = placeholder;
                }
                if (i19 != 0) {
                    leadingIcon4 = null;
                } else {
                    leadingIcon4 = leadingIcon;
                }
                if (i20 != 0) {
                    trailingIcon4 = null;
                } else {
                    trailingIcon4 = trailingIcon;
                }
                if (i21 != 0) {
                    prefix4 = null;
                } else {
                    prefix4 = prefix;
                }
                if (i22 != 0) {
                    suffix4 = null;
                } else {
                    suffix4 = suffix;
                }
                if (i23 != 0) {
                    supportingText5 = null;
                } else {
                    supportingText5 = supportingText;
                }
                if (i2 != 0) {
                    isError4 = false;
                } else {
                    isError4 = isError;
                }
                if (i3 != 0) {
                    visualTransformation2 = VisualTransformation.Companion.getNone();
                } else {
                    visualTransformation2 = visualTransformation;
                }
                if (i26 != 0) {
                    keyboardOptions2 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i27 != 0) {
                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i28 != 0) {
                    singleLine2 = false;
                } else {
                    singleLine2 = singleLine;
                }
                if ((i11 & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty13 &= -234881025;
                }
                if (i29 != 0) {
                    minLines2 = 1;
                } else {
                    minLines2 = minLines;
                }
                if (i32 != 0) {
                    $dirty3 = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    $dirty12 = $dirty13;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty3 = $dirty4;
                    $dirty12 = $dirty13;
                    interactionSource4 = interactionSource;
                }
                if ((2097152 & i11) != 0) {
                    interactionSource5 = interactionSource4;
                    shape4 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty22 &= -113;
                } else {
                    interactionSource5 = interactionSource4;
                    shape4 = shape;
                }
                if ((i11 & 4194304) != 0) {
                    modifier3 = modifier5;
                    enabled3 = enabled5;
                    interactionSource3 = interactionSource5;
                    shape3 = shape4;
                    $dirty2 = $dirty22 & -897;
                    placeholder3 = placeholder4;
                    leadingIcon3 = leadingIcon4;
                    trailingIcon3 = trailingIcon4;
                    prefix3 = prefix4;
                    suffix3 = suffix4;
                    label2 = label3;
                    supportingText4 = supportingText5;
                    isError3 = isError4;
                    maxLines4 = maxLines2;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    colors3 = TextFieldDefaults.INSTANCE.m3827colors0hiis_0(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (TextSelectionColors) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    textStyle3 = textStyle4;
                } else {
                    modifier3 = modifier5;
                    enabled3 = enabled5;
                    interactionSource3 = interactionSource5;
                    shape3 = shape4;
                    $dirty2 = $dirty22;
                    placeholder3 = placeholder4;
                    leadingIcon3 = leadingIcon4;
                    trailingIcon3 = trailingIcon4;
                    prefix3 = prefix4;
                    suffix3 = suffix4;
                    label2 = label3;
                    supportingText4 = supportingText5;
                    isError3 = isError4;
                    maxLines4 = maxLines2;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    colors3 = colors;
                    textStyle3 = textStyle4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i11 & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i11 & 262144) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((2097152 & i11) != 0) {
                    $dirty22 &= -113;
                }
                if ((i11 & 4194304) != 0) {
                    $dirty22 &= -897;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                label2 = label;
                placeholder3 = placeholder;
                leadingIcon3 = leadingIcon;
                trailingIcon3 = trailingIcon;
                prefix3 = prefix;
                suffix3 = suffix;
                supportingText4 = supportingText;
                isError3 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors3 = colors;
                $dirty = $dirty4;
                $dirty1 = $dirty13;
                $dirty2 = $dirty22;
                maxLines4 = maxLines2;
                textStyle3 = textStyle;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-676242365, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:165)");
            }
            $composer3.startReplaceableGroup(-1263331616);
            ComposerKt.sourceInformation($composer3, "*192@9990L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m7056getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m4999getUnspecified0d7_KjU()) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                textColor = colors3.textColor$material3_release(enabled3, isError3, interactionSource3, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m4973unboximpl();
            }
            $composer3.endReplaceableGroup();
            TextFieldKt$TextField$2 textFieldKt$TextField$2 = r0;
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors3.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            int i36 = $dirty1;
            colors2 = colors3;
            textStyle2 = textStyle3;
            TextFieldKt$TextField$2 textFieldKt$TextField$22 = new TextFieldKt$TextField$2(modifier3, colors3, isError3, $dirty1, $dirty2, value, onValueChange, enabled3, readOnly2, textStyle3.merge(new TextStyle(textColor, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null)), keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, visualTransformation2, interactionSource3, $dirty, label2, placeholder3, leadingIcon3, trailingIcon3, prefix3, suffix3, supportingText4, shape3);
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 1859145987, true, textFieldKt$TextField$2), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i37 = $dirty2;
            shape2 = shape3;
            interactionSource2 = interactionSource3;
            maxLines3 = maxLines4;
            isError2 = isError3;
            supportingText2 = supportingText4;
            supportingText3 = suffix3;
            suffix2 = prefix3;
            prefix2 = trailingIcon3;
            trailingIcon2 = leadingIcon3;
            leadingIcon2 = placeholder3;
            placeholder2 = label2;
            enabled2 = enabled3;
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TextFieldKt$TextField$3(value, onValueChange, modifier2, enabled2, readOnly2, textStyle2, placeholder2, leadingIcon2, trailingIcon2, prefix2, suffix2, supportingText3, supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource2, shape2, colors2, $changed, $changed1, $changed2, i));
    }

    public static final void TextField(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function2<? super Composer, ? super Integer, Unit> prefix, Function2<? super Composer, ? super Integer, Unit> suffix, Function2<? super Composer, ? super Integer, Unit> supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        int i2;
        int i3;
        int maxLines2;
        int minLines2;
        boolean singleLine2;
        KeyboardActions keyboardActions2;
        KeyboardOptions keyboardOptions2;
        VisualTransformation visualTransformation2;
        boolean readOnly2;
        TextStyle textStyle2;
        TextFieldColors colors2;
        Shape shape2;
        MutableInteractionSource interactionSource2;
        int maxLines3;
        boolean isError2;
        Function2 supportingText2;
        Function2 supportingText3;
        Function2 suffix2;
        Function2 prefix2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Function2 placeholder2;
        boolean enabled2;
        Modifier modifier2;
        Composer $composer2;
        int $dirty2;
        Shape shape3;
        MutableInteractionSource interactionSource3;
        int maxLines4;
        boolean isError3;
        Function2 supportingText4;
        Function2 suffix3;
        Function2 prefix3;
        Function2 trailingIcon3;
        Function2 leadingIcon3;
        Function2 placeholder3;
        Function2 label2;
        boolean enabled3;
        Modifier modifier3;
        TextStyle textStyle3;
        TextFieldColors colors3;
        int $dirty;
        int $dirty1;
        long textColor;
        Modifier modifier4;
        boolean enabled4;
        boolean enabled5;
        Modifier modifier5;
        TextStyle textStyle4;
        Function2 label3;
        Function2 placeholder4;
        Function2 leadingIcon4;
        Function2 trailingIcon4;
        Function2 prefix4;
        Function2 suffix4;
        Function2 supportingText5;
        boolean isError4;
        int $dirty12;
        int $dirty3;
        MutableInteractionSource interactionSource4;
        MutableInteractionSource interactionSource5;
        Shape shape4;
        Object value$iv$iv;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldValue textFieldValue = value;
        Function1<? super TextFieldValue, Unit> function1 = onValueChange;
        int i8 = $changed;
        int i9 = $changed1;
        int i10 = $changed2;
        int i11 = i;
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)316@17035L7,331@17787L39,332@17865L5,333@17920L8,341@18282L15,341@18216L1830:TextField.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty13 = $changed1;
        int $dirty22 = $changed2;
        if ((i11 & 1) != 0) {
            $dirty4 |= 6;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed((Object) textFieldValue) ? 4 : 2;
        }
        if ((i11 & 2) != 0) {
            $dirty4 |= 48;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i12 = i11 & 4;
        if (i12 != 0) {
            $dirty4 |= 384;
            Modifier modifier6 = modifier;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier7 = modifier;
        }
        int i13 = i11 & 8;
        int i14 = 2048;
        if (i13 != 0) {
            $dirty4 |= 3072;
            boolean z = enabled;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed(enabled) ? 2048 : true;
        } else {
            boolean z2 = enabled;
        }
        int i15 = i11 & 16;
        int i16 = 16384;
        if (i15 != 0) {
            $dirty4 |= 24576;
            boolean z3 = readOnly;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changed(readOnly) ? 16384 : true;
        } else {
            boolean z4 = readOnly;
        }
        if (i8 == false || !true) {
            if ((i11 & 32) != 0) {
                TextStyle textStyle5 = textStyle;
            } else if ($composer3.changed((Object) textStyle)) {
                i7 = 131072;
                $dirty4 |= i7;
            }
            i7 = 65536;
            $dirty4 |= i7;
        } else {
            TextStyle textStyle6 = textStyle;
        }
        int i17 = i11 & 64;
        if (i17 != 0) {
            $dirty4 |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function2 = label;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(label) ? 1048576 : true;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = label;
        }
        int i18 = i11 & 128;
        if (i18 != 0) {
            $dirty4 |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function23 = placeholder;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(placeholder) ? 8388608 : 0;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = placeholder;
        }
        int i19 = i11 & 256;
        if (i19 != 0) {
            $dirty4 |= 100663296;
            Function2<? super Composer, ? super Integer, Unit> function25 = leadingIcon;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = leadingIcon;
        }
        int i20 = i11 & 512;
        if (i20 != 0) {
            $dirty4 |= 805306368;
            Function2<? super Composer, ? super Integer, Unit> function27 = trailingIcon;
        } else if (i8 == false || !true) {
            $dirty4 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = trailingIcon;
        }
        int i21 = i11 & 1024;
        if (i21 != 0) {
            $dirty13 |= 6;
            Function2<? super Composer, ? super Integer, Unit> function29 = prefix;
        } else if ((i9 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(prefix) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function210 = prefix;
        }
        int i22 = i11 & 2048;
        if (i22 != 0) {
            $dirty13 |= 48;
            Function2<? super Composer, ? super Integer, Unit> function211 = suffix;
        } else if ((i9 & 112) == 0) {
            $dirty13 |= $composer3.changedInstance(suffix) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function212 = suffix;
        }
        int i23 = i11 & 4096;
        if (i23 != 0) {
            $dirty13 |= 384;
            Function2<? super Composer, ? super Integer, Unit> function213 = supportingText;
        } else if ((i9 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(supportingText) ? 256 : 128;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function214 = supportingText;
        }
        int i24 = i11 & 8192;
        if (i24 != 0) {
            $dirty13 |= 3072;
            i2 = i24;
            boolean z5 = isError;
        } else {
            i2 = i24;
            if ((i9 & 7168) == 0) {
                if (!$composer3.changed(isError)) {
                    i14 = 1024;
                }
                $dirty13 |= i14;
            } else {
                boolean z6 = isError;
            }
        }
        int i25 = i11 & 16384;
        if (i25 != 0) {
            $dirty13 |= 24576;
            i3 = i25;
            VisualTransformation visualTransformation3 = visualTransformation;
        } else if ((i9 & 57344) == 0) {
            i3 = i25;
            if (!$composer3.changed((Object) visualTransformation)) {
                i16 = 8192;
            }
            $dirty13 |= i16;
        } else {
            i3 = i25;
            VisualTransformation visualTransformation4 = visualTransformation;
        }
        int i26 = i11 & 32768;
        if (i26 != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            KeyboardOptions keyboardOptions3 = keyboardOptions;
        } else if ((i9 & 458752) == 0) {
            $dirty13 |= $composer3.changed((Object) keyboardOptions) ? 131072 : 65536;
        } else {
            KeyboardOptions keyboardOptions4 = keyboardOptions;
        }
        int i27 = i11 & 65536;
        if (i27 != 0) {
            $dirty13 |= 1572864;
            KeyboardActions keyboardActions3 = keyboardActions;
        } else if ((i9 & 3670016) == 0) {
            $dirty13 |= $composer3.changed((Object) keyboardActions) ? 1048576 : 524288;
        } else {
            KeyboardActions keyboardActions4 = keyboardActions;
        }
        int i28 = i11 & 131072;
        if (i28 != 0) {
            $dirty13 |= 12582912;
            boolean z7 = singleLine;
        } else if ((i9 & 29360128) == 0) {
            $dirty13 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        } else {
            boolean z8 = singleLine;
        }
        if ((i9 & 234881024) == 0) {
            if ((i11 & 262144) == 0) {
                maxLines2 = maxLines;
                if ($composer3.changed(maxLines2)) {
                    i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty13 |= i6;
                }
            } else {
                maxLines2 = maxLines;
            }
            i6 = 33554432;
            $dirty13 |= i6;
        } else {
            maxLines2 = maxLines;
        }
        int i29 = i11 & 524288;
        if (i29 != 0) {
            $dirty13 |= 805306368;
            int i30 = minLines;
        } else if ((i9 & 1879048192) == 0) {
            $dirty13 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        } else {
            int i31 = minLines;
        }
        int i32 = i11 & 1048576;
        if (i32 != 0) {
            $dirty22 |= 6;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i10 & 14) == 0) {
            $dirty22 |= $composer3.changed((Object) interactionSource) ? 4 : 2;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i10 & 112) == 0) {
            if ((i11 & 2097152) != 0) {
                Shape shape5 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i5 = 32;
                $dirty22 |= i5;
            }
            i5 = 16;
            $dirty22 |= i5;
        } else {
            Shape shape6 = shape;
        }
        if ((i10 & 896) == 0) {
            if ((i11 & 4194304) != 0) {
                TextFieldColors textFieldColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i4 = 256;
                $dirty22 |= i4;
            }
            i4 = 128;
            $dirty22 |= i4;
        } else {
            TextFieldColors textFieldColors2 = colors;
        }
        if (($dirty4 & 1533916891) == 306783378 && (1533916891 & $dirty13) == 306783378 && ($dirty22 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            placeholder2 = label;
            leadingIcon2 = placeholder;
            trailingIcon2 = leadingIcon;
            prefix2 = trailingIcon;
            suffix2 = prefix;
            supportingText3 = suffix;
            supportingText2 = supportingText;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource2 = interactionSource;
            shape2 = shape;
            colors2 = colors;
            int i33 = $dirty4;
            int i34 = $dirty13;
            int i35 = $dirty22;
            maxLines3 = maxLines2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i8 == false || !true) || $composer3.getDefaultsInvalid()) {
                if (i12 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
                }
                if (i13 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i15 != 0) {
                    readOnly2 = false;
                } else {
                    readOnly2 = readOnly;
                }
                if ((i11 & 32) != 0) {
                    modifier5 = modifier4;
                    enabled5 = enabled4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(TextKt.getLocalTextStyle());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle4 = (TextStyle) consume;
                    $dirty4 &= -458753;
                } else {
                    modifier5 = modifier4;
                    enabled5 = enabled4;
                    textStyle4 = textStyle;
                }
                if (i17 != 0) {
                    label3 = null;
                } else {
                    label3 = label;
                }
                if (i18 != 0) {
                    placeholder4 = null;
                } else {
                    placeholder4 = placeholder;
                }
                if (i19 != 0) {
                    leadingIcon4 = null;
                } else {
                    leadingIcon4 = leadingIcon;
                }
                if (i20 != 0) {
                    trailingIcon4 = null;
                } else {
                    trailingIcon4 = trailingIcon;
                }
                if (i21 != 0) {
                    prefix4 = null;
                } else {
                    prefix4 = prefix;
                }
                if (i22 != 0) {
                    suffix4 = null;
                } else {
                    suffix4 = suffix;
                }
                if (i23 != 0) {
                    supportingText5 = null;
                } else {
                    supportingText5 = supportingText;
                }
                if (i2 != 0) {
                    isError4 = false;
                } else {
                    isError4 = isError;
                }
                if (i3 != 0) {
                    visualTransformation2 = VisualTransformation.Companion.getNone();
                } else {
                    visualTransformation2 = visualTransformation;
                }
                if (i26 != 0) {
                    keyboardOptions2 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                if (i27 != 0) {
                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i28 != 0) {
                    singleLine2 = false;
                } else {
                    singleLine2 = singleLine;
                }
                if ((i11 & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty13 &= -234881025;
                }
                if (i29 != 0) {
                    minLines2 = 1;
                } else {
                    minLines2 = minLines;
                }
                if (i32 != 0) {
                    $dirty3 = $dirty4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    $dirty12 = $dirty13;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    $dirty3 = $dirty4;
                    $dirty12 = $dirty13;
                    interactionSource4 = interactionSource;
                }
                if ((2097152 & i11) != 0) {
                    interactionSource5 = interactionSource4;
                    shape4 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty22 &= -113;
                } else {
                    interactionSource5 = interactionSource4;
                    shape4 = shape;
                }
                if ((i11 & 4194304) != 0) {
                    modifier3 = modifier5;
                    enabled3 = enabled5;
                    interactionSource3 = interactionSource5;
                    shape3 = shape4;
                    $dirty2 = $dirty22 & -897;
                    placeholder3 = placeholder4;
                    leadingIcon3 = leadingIcon4;
                    trailingIcon3 = trailingIcon4;
                    prefix3 = prefix4;
                    suffix3 = suffix4;
                    label2 = label3;
                    supportingText4 = supportingText5;
                    isError3 = isError4;
                    maxLines4 = maxLines2;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    colors3 = TextFieldDefaults.INSTANCE.m3827colors0hiis_0(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (TextSelectionColors) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 0, 0, 0, 3072, Integer.MAX_VALUE, 4095);
                    textStyle3 = textStyle4;
                } else {
                    modifier3 = modifier5;
                    enabled3 = enabled5;
                    interactionSource3 = interactionSource5;
                    shape3 = shape4;
                    $dirty2 = $dirty22;
                    placeholder3 = placeholder4;
                    leadingIcon3 = leadingIcon4;
                    trailingIcon3 = trailingIcon4;
                    prefix3 = prefix4;
                    suffix3 = suffix4;
                    label2 = label3;
                    supportingText4 = supportingText5;
                    isError3 = isError4;
                    maxLines4 = maxLines2;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    colors3 = colors;
                    textStyle3 = textStyle4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i11 & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i11 & 262144) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((2097152 & i11) != 0) {
                    $dirty22 &= -113;
                }
                if ((i11 & 4194304) != 0) {
                    $dirty22 &= -897;
                }
                modifier3 = modifier;
                enabled3 = enabled;
                readOnly2 = readOnly;
                label2 = label;
                placeholder3 = placeholder;
                leadingIcon3 = leadingIcon;
                trailingIcon3 = trailingIcon;
                prefix3 = prefix;
                suffix3 = suffix;
                supportingText4 = supportingText;
                isError3 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors3 = colors;
                $dirty = $dirty4;
                $dirty1 = $dirty13;
                $dirty2 = $dirty22;
                maxLines4 = maxLines2;
                textStyle3 = textStyle;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1268528240, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:310)");
            }
            $composer3.startReplaceableGroup(-1263323526);
            ComposerKt.sourceInformation($composer3, "*337@18080L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m7056getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m4999getUnspecified0d7_KjU()) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                textColor = colors3.textColor$material3_release(enabled3, isError3, interactionSource3, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m4973unboximpl();
            }
            $composer3.endReplaceableGroup();
            TextFieldKt$TextField$5 textFieldKt$TextField$5 = r0;
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors3.getSelectionColors($composer3, ($dirty2 >> 6) & 14))};
            int i36 = $dirty1;
            colors2 = colors3;
            textStyle2 = textStyle3;
            TextFieldKt$TextField$5 textFieldKt$TextField$52 = new TextFieldKt$TextField$5(modifier3, colors3, isError3, $dirty1, $dirty2, value, onValueChange, enabled3, readOnly2, textStyle3.merge(new TextStyle(textColor, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4194302, (DefaultConstructorMarker) null)), keyboardOptions2, keyboardActions2, singleLine2, maxLines4, minLines2, visualTransformation2, interactionSource3, $dirty, label2, placeholder3, leadingIcon3, trailingIcon3, prefix3, suffix3, supportingText4, shape3);
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1163788208, true, textFieldKt$TextField$5), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i37 = $dirty2;
            shape2 = shape3;
            interactionSource2 = interactionSource3;
            maxLines3 = maxLines4;
            isError2 = isError3;
            supportingText2 = supportingText4;
            supportingText3 = suffix3;
            suffix2 = prefix3;
            prefix2 = trailingIcon3;
            trailingIcon2 = leadingIcon3;
            leadingIcon2 = placeholder3;
            placeholder2 = label2;
            enabled2 = enabled3;
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TextFieldKt$TextField$6(value, onValueChange, modifier2, enabled2, readOnly2, textStyle2, placeholder2, leadingIcon2, trailingIcon2, prefix2, suffix2, supportingText3, supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource2, shape2, colors2, $changed, $changed1, $changed2, i));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r128v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void TextField(java.lang.String r120, kotlin.jvm.functions.Function1 r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2 r126, kotlin.jvm.functions.Function2 r127, kotlin.jvm.functions.Function2 r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, boolean r131, androidx.compose.ui.text.input.VisualTransformation r132, androidx.compose.foundation.text.KeyboardOptions r133, androidx.compose.foundation.text.KeyboardActions r134, boolean r135, int r136, int r137, androidx.compose.foundation.interaction.MutableInteractionSource r138, androidx.compose.ui.graphics.Shape r139, androidx.compose.material3.TextFieldColors r140, androidx.compose.runtime.Composer r141, int r142, int r143, int r144, int r145) {
        /*
            r15 = r120
            r14 = r121
            r13 = r142
            r12 = r143
            r9 = r145
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1500728277(0xffffffffa68cb42b, float:-9.763286E-16)
            r1 = r141
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)395@20391L7,408@21051L39,409@21129L5,410@21184L8,412@21201L763:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r142
            r1 = r143
            r2 = r144
            r3 = r9 & 1
            if (r3 == 0) goto L_0x0031
            r0 = r0 | 6
            goto L_0x003f
        L_0x0031:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003f
            boolean r3 = r8.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x003d
            r3 = 4
            goto L_0x003e
        L_0x003d:
            r3 = 2
        L_0x003e:
            r0 = r0 | r3
        L_0x003f:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x0046
            r0 = r0 | 48
            goto L_0x0056
        L_0x0046:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0056
            boolean r3 = r8.changedInstance(r14)
            if (r3 == 0) goto L_0x0053
            r3 = 32
            goto L_0x0055
        L_0x0053:
            r3 = 16
        L_0x0055:
            r0 = r0 | r3
        L_0x0056:
            r3 = r9 & 4
            if (r3 == 0) goto L_0x005f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r4 = r122
            goto L_0x0075
        L_0x005f:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0073
            r4 = r122
            boolean r16 = r8.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x006e
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r0 = r0 | r16
            goto L_0x0075
        L_0x0073:
            r4 = r122
        L_0x0075:
            r16 = r9 & 8
            r17 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r6 = r123
            goto L_0x0096
        L_0x0080:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0094
            r6 = r123
            boolean r19 = r8.changed((boolean) r6)
            if (r19 == 0) goto L_0x008f
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x0091
        L_0x008f:
            r19 = r17
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r6 = r123
        L_0x0096:
            r19 = r9 & 16
            r110 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x00a2
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r7 = r124
            goto L_0x00b8
        L_0x00a2:
            r20 = r13 & r110
            if (r20 != 0) goto L_0x00b6
            r7 = r124
            boolean r21 = r8.changed((boolean) r7)
            if (r21 == 0) goto L_0x00b1
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b3
        L_0x00b1:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x00b3:
            r0 = r0 | r21
            goto L_0x00b8
        L_0x00b6:
            r7 = r124
        L_0x00b8:
            r111 = 458752(0x70000, float:6.42848E-40)
            r21 = r13 & r111
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r21 != 0) goto L_0x00d6
            r21 = r9 & 32
            if (r21 != 0) goto L_0x00cf
            r10 = r125
            boolean r23 = r8.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00d1
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d3
        L_0x00cf:
            r10 = r125
        L_0x00d1:
            r23 = r22
        L_0x00d3:
            r0 = r0 | r23
            goto L_0x00d8
        L_0x00d6:
            r10 = r125
        L_0x00d8:
            r23 = r9 & 64
            r112 = 3670016(0x380000, float:5.142788E-39)
            r24 = 1048576(0x100000, float:1.469368E-39)
            r25 = 524288(0x80000, float:7.34684E-40)
            if (r23 == 0) goto L_0x00e9
            r26 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r26
            r11 = r126
            goto L_0x00ff
        L_0x00e9:
            r26 = r13 & r112
            if (r26 != 0) goto L_0x00fd
            r11 = r126
            boolean r27 = r8.changedInstance(r11)
            if (r27 == 0) goto L_0x00f8
            r27 = r24
            goto L_0x00fa
        L_0x00f8:
            r27 = r25
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r11 = r126
        L_0x00ff:
            r5 = r9 & 128(0x80, float:1.794E-43)
            r113 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x010c
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r28
            r4 = r127
            goto L_0x0122
        L_0x010c:
            r28 = r13 & r113
            if (r28 != 0) goto L_0x0120
            r4 = r127
            boolean r28 = r8.changedInstance(r4)
            if (r28 == 0) goto L_0x011b
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011d
        L_0x011b:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x011d:
            r0 = r0 | r28
            goto L_0x0122
        L_0x0120:
            r4 = r127
        L_0x0122:
            r4 = r9 & 256(0x100, float:3.59E-43)
            r114 = 234881024(0xe000000, float:1.5777218E-30)
            if (r4 == 0) goto L_0x012f
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r6 = r128
            goto L_0x0145
        L_0x012f:
            r28 = r13 & r114
            if (r28 != 0) goto L_0x0143
            r6 = r128
            boolean r28 = r8.changedInstance(r6)
            if (r28 == 0) goto L_0x013e
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0140
        L_0x013e:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0140:
            r0 = r0 | r28
            goto L_0x0145
        L_0x0143:
            r6 = r128
        L_0x0145:
            r6 = r9 & 512(0x200, float:7.175E-43)
            r115 = 1879048192(0x70000000, float:1.58456325E29)
            if (r6 == 0) goto L_0x0152
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r7 = r129
            goto L_0x0168
        L_0x0152:
            r28 = r13 & r115
            if (r28 != 0) goto L_0x0166
            r7 = r129
            boolean r28 = r8.changedInstance(r7)
            if (r28 == 0) goto L_0x0161
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r0 = r0 | r28
            goto L_0x0168
        L_0x0166:
            r7 = r129
        L_0x0168:
            r7 = r9 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0171
            r1 = r1 | 6
            r10 = r130
            goto L_0x0187
        L_0x0171:
            r28 = r12 & 14
            if (r28 != 0) goto L_0x0185
            r10 = r130
            boolean r28 = r8.changedInstance(r10)
            if (r28 == 0) goto L_0x0180
            r28 = 4
            goto L_0x0182
        L_0x0180:
            r28 = 2
        L_0x0182:
            r1 = r1 | r28
            goto L_0x0187
        L_0x0185:
            r10 = r130
        L_0x0187:
            r10 = r9 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0190
            r1 = r1 | 48
            r11 = r131
            goto L_0x01a6
        L_0x0190:
            r28 = r12 & 112(0x70, float:1.57E-43)
            if (r28 != 0) goto L_0x01a4
            r11 = r131
            boolean r28 = r8.changed((boolean) r11)
            if (r28 == 0) goto L_0x019f
            r18 = 32
            goto L_0x01a1
        L_0x019f:
            r18 = 16
        L_0x01a1:
            r1 = r1 | r18
            goto L_0x01a6
        L_0x01a4:
            r11 = r131
        L_0x01a6:
            r11 = r9 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01af
            r1 = r1 | 384(0x180, float:5.38E-43)
            r14 = r132
            goto L_0x01c5
        L_0x01af:
            r14 = r12 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x01c3
            r14 = r132
            boolean r18 = r8.changed((java.lang.Object) r14)
            if (r18 == 0) goto L_0x01be
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r1 = r1 | r26
            goto L_0x01c5
        L_0x01c3:
            r14 = r132
        L_0x01c5:
            r14 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x01ce
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r15 = r133
            goto L_0x01e1
        L_0x01ce:
            r15 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r15 != 0) goto L_0x01df
            r15 = r133
            boolean r18 = r8.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x01dc
            r17 = 2048(0x800, float:2.87E-42)
        L_0x01dc:
            r1 = r1 | r17
            goto L_0x01e1
        L_0x01df:
            r15 = r133
        L_0x01e1:
            r15 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x01ec
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r17 = r15
            r15 = r134
            goto L_0x0206
        L_0x01ec:
            r17 = r12 & r110
            if (r17 != 0) goto L_0x0202
            r17 = r15
            r15 = r134
            boolean r18 = r8.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x01fd
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x01ff
        L_0x01fd:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x01ff:
            r1 = r1 | r18
            goto L_0x0206
        L_0x0202:
            r17 = r15
            r15 = r134
        L_0x0206:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r9 & r18
            if (r18 == 0) goto L_0x0214
            r20 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r20
            r15 = r135
            goto L_0x022a
        L_0x0214:
            r20 = r12 & r111
            if (r20 != 0) goto L_0x0228
            r15 = r135
            boolean r20 = r8.changed((boolean) r15)
            if (r20 == 0) goto L_0x0223
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0225
        L_0x0223:
            r20 = r22
        L_0x0225:
            r1 = r1 | r20
            goto L_0x022a
        L_0x0228:
            r15 = r135
        L_0x022a:
            r20 = r12 & r112
            if (r20 != 0) goto L_0x0244
            r20 = r9 & r22
            if (r20 != 0) goto L_0x023d
            r15 = r136
            boolean r20 = r8.changed((int) r15)
            if (r20 == 0) goto L_0x023f
            r20 = r24
            goto L_0x0241
        L_0x023d:
            r15 = r136
        L_0x023f:
            r20 = r25
        L_0x0241:
            r1 = r1 | r20
            goto L_0x0246
        L_0x0244:
            r15 = r136
        L_0x0246:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r9 & r20
            if (r20 == 0) goto L_0x0253
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r21
            r15 = r137
            goto L_0x0269
        L_0x0253:
            r21 = r12 & r113
            if (r21 != 0) goto L_0x0267
            r15 = r137
            boolean r21 = r8.changed((int) r15)
            if (r21 == 0) goto L_0x0262
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0264
        L_0x0262:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x0264:
            r1 = r1 | r21
            goto L_0x0269
        L_0x0267:
            r15 = r137
        L_0x0269:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r9 & r21
            if (r21 == 0) goto L_0x0276
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r26
            r15 = r138
            goto L_0x028c
        L_0x0276:
            r26 = r12 & r114
            if (r26 != 0) goto L_0x028a
            r15 = r138
            boolean r26 = r8.changed((java.lang.Object) r15)
            if (r26 == 0) goto L_0x0285
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0287
        L_0x0285:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0287:
            r1 = r1 | r26
            goto L_0x028c
        L_0x028a:
            r15 = r138
        L_0x028c:
            r26 = r12 & r115
            if (r26 != 0) goto L_0x02a6
            r26 = r9 & r25
            if (r26 != 0) goto L_0x029f
            r12 = r139
            boolean r26 = r8.changed((java.lang.Object) r12)
            if (r26 == 0) goto L_0x02a1
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x02a3
        L_0x029f:
            r12 = r139
        L_0x02a1:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x02a3:
            r1 = r1 | r26
            goto L_0x02a8
        L_0x02a6:
            r12 = r139
        L_0x02a8:
            r26 = r144 & 14
            if (r26 != 0) goto L_0x02c2
            r26 = r9 & r24
            if (r26 != 0) goto L_0x02bb
            r12 = r140
            boolean r26 = r8.changed((java.lang.Object) r12)
            if (r26 == 0) goto L_0x02bd
            r26 = 4
            goto L_0x02bf
        L_0x02bb:
            r12 = r140
        L_0x02bd:
            r26 = 2
        L_0x02bf:
            r2 = r2 | r26
            goto L_0x02c4
        L_0x02c2:
            r12 = r140
        L_0x02c4:
            r26 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r0 & r26
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r15) goto L_0x0316
            r12 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r12 & r1
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r15) goto L_0x0316
            r12 = r2 & 11
            r15 = 2
            if (r12 != r15) goto L_0x0316
            boolean r12 = r8.getSkipping()
            if (r12 != 0) goto L_0x02e3
            goto L_0x0316
        L_0x02e3:
            r8.skipToGroupEnd()
            r28 = r122
            r29 = r123
            r30 = r124
            r31 = r125
            r32 = r126
            r33 = r127
            r34 = r128
            r35 = r129
            r36 = r130
            r37 = r131
            r38 = r132
            r39 = r133
            r40 = r134
            r116 = r135
            r41 = r136
            r117 = r137
            r42 = r138
            r43 = r139
            r44 = r140
            r48 = r0
            r47 = r1
            r45 = r2
            r46 = r8
            goto L_0x0615
        L_0x0316:
            r8.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x0371
            boolean r12 = r8.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0324
            goto L_0x0371
        L_0x0324:
            r8.skipToGroupEnd()
            r3 = r9 & 32
            if (r3 == 0) goto L_0x032f
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r3
        L_0x032f:
            r3 = r9 & r22
            if (r3 == 0) goto L_0x0337
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r3
        L_0x0337:
            r3 = r9 & r25
            if (r3 == 0) goto L_0x033f
            r3 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r3
        L_0x033f:
            r3 = r9 & r24
            if (r3 == 0) goto L_0x0345
            r2 = r2 & -15
        L_0x0345:
            r28 = r122
            r29 = r123
            r30 = r124
            r31 = r125
            r32 = r126
            r33 = r127
            r34 = r128
            r35 = r129
            r36 = r130
            r37 = r131
            r38 = r132
            r39 = r133
            r40 = r134
            r116 = r135
            r41 = r136
            r117 = r137
            r42 = r138
            r43 = r139
            r44 = r140
            r15 = r0
            r14 = r1
            r45 = r2
            goto L_0x0555
        L_0x0371:
            if (r3 == 0) goto L_0x0378
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x037a
        L_0x0378:
            r3 = r122
        L_0x037a:
            if (r16 == 0) goto L_0x037e
            r12 = 1
            goto L_0x0380
        L_0x037e:
            r12 = r123
        L_0x0380:
            if (r19 == 0) goto L_0x0384
            r15 = 0
            goto L_0x0386
        L_0x0384:
            r15 = r124
        L_0x0386:
            r16 = r9 & 32
            if (r16 == 0) goto L_0x03b1
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r122 = r3
            r3 = r16
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r16 = 6
            r19 = 0
            r123 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            java.lang.Object r12 = r8.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r3 = r12
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r12
            goto L_0x03b7
        L_0x03b1:
            r122 = r3
            r123 = r12
            r3 = r125
        L_0x03b7:
            if (r23 == 0) goto L_0x03bb
            r12 = 0
            goto L_0x03bd
        L_0x03bb:
            r12 = r126
        L_0x03bd:
            if (r5 == 0) goto L_0x03c1
            r5 = 0
            goto L_0x03c3
        L_0x03c1:
            r5 = r127
        L_0x03c3:
            if (r4 == 0) goto L_0x03c7
            r4 = 0
            goto L_0x03c9
        L_0x03c7:
            r4 = r128
        L_0x03c9:
            if (r6 == 0) goto L_0x03cd
            r6 = 0
            goto L_0x03cf
        L_0x03cd:
            r6 = r129
        L_0x03cf:
            if (r7 == 0) goto L_0x03d3
            r7 = 0
            goto L_0x03d5
        L_0x03d3:
            r7 = r130
        L_0x03d5:
            if (r10 == 0) goto L_0x03d9
            r10 = 0
            goto L_0x03db
        L_0x03d9:
            r10 = r131
        L_0x03db:
            if (r11 == 0) goto L_0x03e4
            androidx.compose.ui.text.input.VisualTransformation$Companion r11 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r11 = r11.getNone()
            goto L_0x03e6
        L_0x03e4:
            r11 = r132
        L_0x03e6:
            if (r14 == 0) goto L_0x03ef
            androidx.compose.foundation.text.KeyboardOptions$Companion r13 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r13 = r13.getDefault()
            goto L_0x03f1
        L_0x03ef:
            r13 = r133
        L_0x03f1:
            if (r17 == 0) goto L_0x03fa
            androidx.compose.foundation.text.KeyboardActions$Companion r14 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r14 = r14.getDefault()
            goto L_0x03fc
        L_0x03fa:
            r14 = r134
        L_0x03fc:
            if (r18 == 0) goto L_0x0403
            r16 = 0
            r116 = r16
            goto L_0x0405
        L_0x0403:
            r116 = r135
        L_0x0405:
            r16 = r9 & r22
            if (r16 == 0) goto L_0x041d
            if (r116 == 0) goto L_0x040e
            r16 = 1
            goto L_0x0411
        L_0x040e:
            r16 = 2147483647(0x7fffffff, float:NaN)
        L_0x0411:
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r17
            r119 = r16
            r16 = r1
            r1 = r119
            goto L_0x0421
        L_0x041d:
            r16 = r1
            r1 = r136
        L_0x0421:
            if (r20 == 0) goto L_0x0428
            r17 = 1
            r117 = r17
            goto L_0x042a
        L_0x0428:
            r117 = r137
        L_0x042a:
            if (r21 == 0) goto L_0x0472
            r17 = 0
            r18 = 0
            r124 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = 0
            r125 = r8
            r19 = 0
            r126 = r0
            java.lang.Object r0 = r125.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r127 = r1
            java.lang.Object r1 = r21.getEmpty()
            if (r0 != r1) goto L_0x0463
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r128 = r0
            r0 = r125
            r0.updateRememberedValue(r1)
            goto L_0x0469
        L_0x0463:
            r128 = r0
            r0 = r125
            r1 = r128
        L_0x0469:
            r8.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0478
        L_0x0472:
            r124 = r0
            r127 = r1
            r0 = r138
        L_0x0478:
            r1 = r9 & r25
            if (r1 == 0) goto L_0x048d
            androidx.compose.material3.TextFieldDefaults r1 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r125 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getShape(r8, r0)
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r16 = r16 & r1
            r1 = r16
            goto L_0x0493
        L_0x048d:
            r125 = r0
            r0 = r139
            r1 = r16
        L_0x0493:
            r16 = r9 & r24
            if (r16 == 0) goto L_0x052e
            androidx.compose.material3.TextFieldDefaults r16 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r107 = 3072(0xc00, float:4.305E-42)
            r102 = r8
            androidx.compose.material3.TextFieldColors r16 = r16.m3827colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r2 = r2 & -15
            r28 = r122
            r29 = r123
            r42 = r125
            r41 = r127
            r43 = r0
            r45 = r2
            r31 = r3
            r34 = r4
            r33 = r5
            r35 = r6
            r36 = r7
            r37 = r10
            r38 = r11
            r32 = r12
            r39 = r13
            r40 = r14
            r30 = r15
            r44 = r16
            r15 = r124
            r14 = r1
            goto L_0x0555
        L_0x052e:
            r28 = r122
            r29 = r123
            r42 = r125
            r41 = r127
            r44 = r140
            r43 = r0
            r45 = r2
            r31 = r3
            r34 = r4
            r33 = r5
            r35 = r6
            r36 = r7
            r37 = r10
            r38 = r11
            r32 = r12
            r39 = r13
            r40 = r14
            r30 = r15
            r15 = r124
            r14 = r1
        L_0x0555:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0566
            r0 = -1500728277(0xffffffffa68cb42b, float:-9.763286E-16)
            java.lang.String r1 = "androidx.compose.material3.TextField (TextField.kt:389)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r14, r1)
        L_0x0566:
            r0 = r15 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r15 & r110
            r0 = r0 | r1
            r1 = r15 & r111
            r0 = r0 | r1
            r1 = r15 & r112
            r0 = r0 | r1
            r1 = r15 & r113
            r0 = r0 | r1
            r1 = r15 & r114
            r0 = r0 | r1
            r1 = r15 & r115
            r24 = r0 | r1
            int r0 = r14 << 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | 54
            int r1 = r14 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r110
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r111
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r112
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r113
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r114
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r115
            r25 = r0 | r1
            int r0 = r14 >> 24
            r0 = r0 & 14
            int r1 = r14 >> 24
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r45 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r26 = r0 | r1
            r10 = 0
            r11 = 0
            r27 = 0
            r0 = r120
            r1 = r121
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r46 = r8
            r8 = r34
            r9 = r35
            r12 = r36
            r13 = r37
            r47 = r14
            r14 = r38
            r48 = r15
            r15 = r39
            r16 = r40
            r17 = r116
            r18 = r41
            r19 = r117
            r20 = r42
            r21 = r43
            r22 = r44
            r23 = r46
            TextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r11, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r12, (boolean) r13, (androidx.compose.ui.text.input.VisualTransformation) r14, (androidx.compose.foundation.text.KeyboardOptions) r15, (androidx.compose.foundation.text.KeyboardActions) r16, (boolean) r17, (int) r18, (int) r19, (androidx.compose.foundation.interaction.MutableInteractionSource) r20, (androidx.compose.ui.graphics.Shape) r21, (androidx.compose.material3.TextFieldColors) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25, (int) r26, (int) r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0615
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0615:
            androidx.compose.runtime.ScopeUpdateScope r15 = r46.endRestartGroup()
            if (r15 != 0) goto L_0x061c
            goto L_0x0660
        L_0x061c:
            androidx.compose.material3.TextFieldKt$TextField$8 r26 = new androidx.compose.material3.TextFieldKt$TextField$8
            r0 = r26
            r1 = r120
            r2 = r121
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r39
            r118 = r15
            r15 = r40
            r16 = r116
            r17 = r41
            r18 = r117
            r19 = r42
            r20 = r43
            r21 = r44
            r22 = r142
            r23 = r143
            r24 = r144
            r25 = r145
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r118
            r1.updateScope(r0)
        L_0x0660:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r128v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void TextField(androidx.compose.ui.text.input.TextFieldValue r120, kotlin.jvm.functions.Function1 r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2 r126, kotlin.jvm.functions.Function2 r127, kotlin.jvm.functions.Function2 r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, boolean r131, androidx.compose.ui.text.input.VisualTransformation r132, androidx.compose.foundation.text.KeyboardOptions r133, androidx.compose.foundation.text.KeyboardActions r134, boolean r135, int r136, int r137, androidx.compose.foundation.interaction.MutableInteractionSource r138, androidx.compose.ui.graphics.Shape r139, androidx.compose.material3.TextFieldColors r140, androidx.compose.runtime.Composer r141, int r142, int r143, int r144, int r145) {
        /*
            r15 = r120
            r14 = r121
            r13 = r142
            r12 = r143
            r9 = r145
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1523846136(0x5ad40bf8, float:2.98429274E16)
            r1 = r141
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)448@22325L7,461@22985L39,462@23063L5,463@23118L8,465@23135L763:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r142
            r1 = r143
            r2 = r144
            r3 = r9 & 1
            if (r3 == 0) goto L_0x0031
            r0 = r0 | 6
            goto L_0x003f
        L_0x0031:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003f
            boolean r3 = r8.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x003d
            r3 = 4
            goto L_0x003e
        L_0x003d:
            r3 = 2
        L_0x003e:
            r0 = r0 | r3
        L_0x003f:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x0046
            r0 = r0 | 48
            goto L_0x0056
        L_0x0046:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0056
            boolean r3 = r8.changedInstance(r14)
            if (r3 == 0) goto L_0x0053
            r3 = 32
            goto L_0x0055
        L_0x0053:
            r3 = 16
        L_0x0055:
            r0 = r0 | r3
        L_0x0056:
            r3 = r9 & 4
            if (r3 == 0) goto L_0x005f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r4 = r122
            goto L_0x0075
        L_0x005f:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0073
            r4 = r122
            boolean r16 = r8.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x006e
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r0 = r0 | r16
            goto L_0x0075
        L_0x0073:
            r4 = r122
        L_0x0075:
            r16 = r9 & 8
            r17 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r6 = r123
            goto L_0x0096
        L_0x0080:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0094
            r6 = r123
            boolean r19 = r8.changed((boolean) r6)
            if (r19 == 0) goto L_0x008f
            r19 = 2048(0x800, float:2.87E-42)
            goto L_0x0091
        L_0x008f:
            r19 = r17
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r6 = r123
        L_0x0096:
            r19 = r9 & 16
            r110 = 57344(0xe000, float:8.0356E-41)
            if (r19 == 0) goto L_0x00a2
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r7 = r124
            goto L_0x00b8
        L_0x00a2:
            r20 = r13 & r110
            if (r20 != 0) goto L_0x00b6
            r7 = r124
            boolean r21 = r8.changed((boolean) r7)
            if (r21 == 0) goto L_0x00b1
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b3
        L_0x00b1:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x00b3:
            r0 = r0 | r21
            goto L_0x00b8
        L_0x00b6:
            r7 = r124
        L_0x00b8:
            r111 = 458752(0x70000, float:6.42848E-40)
            r21 = r13 & r111
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r21 != 0) goto L_0x00d6
            r21 = r9 & 32
            if (r21 != 0) goto L_0x00cf
            r10 = r125
            boolean r23 = r8.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00d1
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d3
        L_0x00cf:
            r10 = r125
        L_0x00d1:
            r23 = r22
        L_0x00d3:
            r0 = r0 | r23
            goto L_0x00d8
        L_0x00d6:
            r10 = r125
        L_0x00d8:
            r23 = r9 & 64
            r112 = 3670016(0x380000, float:5.142788E-39)
            r24 = 1048576(0x100000, float:1.469368E-39)
            r25 = 524288(0x80000, float:7.34684E-40)
            if (r23 == 0) goto L_0x00e9
            r26 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r26
            r11 = r126
            goto L_0x00ff
        L_0x00e9:
            r26 = r13 & r112
            if (r26 != 0) goto L_0x00fd
            r11 = r126
            boolean r27 = r8.changedInstance(r11)
            if (r27 == 0) goto L_0x00f8
            r27 = r24
            goto L_0x00fa
        L_0x00f8:
            r27 = r25
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r11 = r126
        L_0x00ff:
            r5 = r9 & 128(0x80, float:1.794E-43)
            r113 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x010c
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r28
            r4 = r127
            goto L_0x0122
        L_0x010c:
            r28 = r13 & r113
            if (r28 != 0) goto L_0x0120
            r4 = r127
            boolean r28 = r8.changedInstance(r4)
            if (r28 == 0) goto L_0x011b
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011d
        L_0x011b:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x011d:
            r0 = r0 | r28
            goto L_0x0122
        L_0x0120:
            r4 = r127
        L_0x0122:
            r4 = r9 & 256(0x100, float:3.59E-43)
            r114 = 234881024(0xe000000, float:1.5777218E-30)
            if (r4 == 0) goto L_0x012f
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r6 = r128
            goto L_0x0145
        L_0x012f:
            r28 = r13 & r114
            if (r28 != 0) goto L_0x0143
            r6 = r128
            boolean r28 = r8.changedInstance(r6)
            if (r28 == 0) goto L_0x013e
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0140
        L_0x013e:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0140:
            r0 = r0 | r28
            goto L_0x0145
        L_0x0143:
            r6 = r128
        L_0x0145:
            r6 = r9 & 512(0x200, float:7.175E-43)
            r115 = 1879048192(0x70000000, float:1.58456325E29)
            if (r6 == 0) goto L_0x0152
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r7 = r129
            goto L_0x0168
        L_0x0152:
            r28 = r13 & r115
            if (r28 != 0) goto L_0x0166
            r7 = r129
            boolean r28 = r8.changedInstance(r7)
            if (r28 == 0) goto L_0x0161
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r0 = r0 | r28
            goto L_0x0168
        L_0x0166:
            r7 = r129
        L_0x0168:
            r7 = r9 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0171
            r1 = r1 | 6
            r10 = r130
            goto L_0x0187
        L_0x0171:
            r28 = r12 & 14
            if (r28 != 0) goto L_0x0185
            r10 = r130
            boolean r28 = r8.changedInstance(r10)
            if (r28 == 0) goto L_0x0180
            r28 = 4
            goto L_0x0182
        L_0x0180:
            r28 = 2
        L_0x0182:
            r1 = r1 | r28
            goto L_0x0187
        L_0x0185:
            r10 = r130
        L_0x0187:
            r10 = r9 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0190
            r1 = r1 | 48
            r11 = r131
            goto L_0x01a6
        L_0x0190:
            r28 = r12 & 112(0x70, float:1.57E-43)
            if (r28 != 0) goto L_0x01a4
            r11 = r131
            boolean r28 = r8.changed((boolean) r11)
            if (r28 == 0) goto L_0x019f
            r18 = 32
            goto L_0x01a1
        L_0x019f:
            r18 = 16
        L_0x01a1:
            r1 = r1 | r18
            goto L_0x01a6
        L_0x01a4:
            r11 = r131
        L_0x01a6:
            r11 = r9 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01af
            r1 = r1 | 384(0x180, float:5.38E-43)
            r14 = r132
            goto L_0x01c5
        L_0x01af:
            r14 = r12 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x01c3
            r14 = r132
            boolean r18 = r8.changed((java.lang.Object) r14)
            if (r18 == 0) goto L_0x01be
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r1 = r1 | r26
            goto L_0x01c5
        L_0x01c3:
            r14 = r132
        L_0x01c5:
            r14 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x01ce
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r15 = r133
            goto L_0x01e1
        L_0x01ce:
            r15 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r15 != 0) goto L_0x01df
            r15 = r133
            boolean r18 = r8.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x01dc
            r17 = 2048(0x800, float:2.87E-42)
        L_0x01dc:
            r1 = r1 | r17
            goto L_0x01e1
        L_0x01df:
            r15 = r133
        L_0x01e1:
            r15 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x01ec
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r17 = r15
            r15 = r134
            goto L_0x0206
        L_0x01ec:
            r17 = r12 & r110
            if (r17 != 0) goto L_0x0202
            r17 = r15
            r15 = r134
            boolean r18 = r8.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x01fd
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x01ff
        L_0x01fd:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x01ff:
            r1 = r1 | r18
            goto L_0x0206
        L_0x0202:
            r17 = r15
            r15 = r134
        L_0x0206:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r9 & r18
            if (r18 == 0) goto L_0x0214
            r20 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r20
            r15 = r135
            goto L_0x022a
        L_0x0214:
            r20 = r12 & r111
            if (r20 != 0) goto L_0x0228
            r15 = r135
            boolean r20 = r8.changed((boolean) r15)
            if (r20 == 0) goto L_0x0223
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0225
        L_0x0223:
            r20 = r22
        L_0x0225:
            r1 = r1 | r20
            goto L_0x022a
        L_0x0228:
            r15 = r135
        L_0x022a:
            r20 = r12 & r112
            if (r20 != 0) goto L_0x0244
            r20 = r9 & r22
            if (r20 != 0) goto L_0x023d
            r15 = r136
            boolean r20 = r8.changed((int) r15)
            if (r20 == 0) goto L_0x023f
            r20 = r24
            goto L_0x0241
        L_0x023d:
            r15 = r136
        L_0x023f:
            r20 = r25
        L_0x0241:
            r1 = r1 | r20
            goto L_0x0246
        L_0x0244:
            r15 = r136
        L_0x0246:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r9 & r20
            if (r20 == 0) goto L_0x0253
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r21
            r15 = r137
            goto L_0x0269
        L_0x0253:
            r21 = r12 & r113
            if (r21 != 0) goto L_0x0267
            r15 = r137
            boolean r21 = r8.changed((int) r15)
            if (r21 == 0) goto L_0x0262
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0264
        L_0x0262:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x0264:
            r1 = r1 | r21
            goto L_0x0269
        L_0x0267:
            r15 = r137
        L_0x0269:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r9 & r21
            if (r21 == 0) goto L_0x0276
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r26
            r15 = r138
            goto L_0x028c
        L_0x0276:
            r26 = r12 & r114
            if (r26 != 0) goto L_0x028a
            r15 = r138
            boolean r26 = r8.changed((java.lang.Object) r15)
            if (r26 == 0) goto L_0x0285
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0287
        L_0x0285:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0287:
            r1 = r1 | r26
            goto L_0x028c
        L_0x028a:
            r15 = r138
        L_0x028c:
            r26 = r12 & r115
            if (r26 != 0) goto L_0x02a6
            r26 = r9 & r25
            if (r26 != 0) goto L_0x029f
            r12 = r139
            boolean r26 = r8.changed((java.lang.Object) r12)
            if (r26 == 0) goto L_0x02a1
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x02a3
        L_0x029f:
            r12 = r139
        L_0x02a1:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x02a3:
            r1 = r1 | r26
            goto L_0x02a8
        L_0x02a6:
            r12 = r139
        L_0x02a8:
            r26 = r144 & 14
            if (r26 != 0) goto L_0x02c2
            r26 = r9 & r24
            if (r26 != 0) goto L_0x02bb
            r12 = r140
            boolean r26 = r8.changed((java.lang.Object) r12)
            if (r26 == 0) goto L_0x02bd
            r26 = 4
            goto L_0x02bf
        L_0x02bb:
            r12 = r140
        L_0x02bd:
            r26 = 2
        L_0x02bf:
            r2 = r2 | r26
            goto L_0x02c4
        L_0x02c2:
            r12 = r140
        L_0x02c4:
            r26 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r0 & r26
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r15) goto L_0x0316
            r12 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r12 & r1
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r15) goto L_0x0316
            r12 = r2 & 11
            r15 = 2
            if (r12 != r15) goto L_0x0316
            boolean r12 = r8.getSkipping()
            if (r12 != 0) goto L_0x02e3
            goto L_0x0316
        L_0x02e3:
            r8.skipToGroupEnd()
            r28 = r122
            r29 = r123
            r30 = r124
            r31 = r125
            r32 = r126
            r33 = r127
            r34 = r128
            r35 = r129
            r36 = r130
            r37 = r131
            r38 = r132
            r39 = r133
            r40 = r134
            r116 = r135
            r41 = r136
            r117 = r137
            r42 = r138
            r43 = r139
            r44 = r140
            r48 = r0
            r47 = r1
            r45 = r2
            r46 = r8
            goto L_0x0615
        L_0x0316:
            r8.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x0371
            boolean r12 = r8.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0324
            goto L_0x0371
        L_0x0324:
            r8.skipToGroupEnd()
            r3 = r9 & 32
            if (r3 == 0) goto L_0x032f
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r3
        L_0x032f:
            r3 = r9 & r22
            if (r3 == 0) goto L_0x0337
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r3
        L_0x0337:
            r3 = r9 & r25
            if (r3 == 0) goto L_0x033f
            r3 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r3
        L_0x033f:
            r3 = r9 & r24
            if (r3 == 0) goto L_0x0345
            r2 = r2 & -15
        L_0x0345:
            r28 = r122
            r29 = r123
            r30 = r124
            r31 = r125
            r32 = r126
            r33 = r127
            r34 = r128
            r35 = r129
            r36 = r130
            r37 = r131
            r38 = r132
            r39 = r133
            r40 = r134
            r116 = r135
            r41 = r136
            r117 = r137
            r42 = r138
            r43 = r139
            r44 = r140
            r15 = r0
            r14 = r1
            r45 = r2
            goto L_0x0555
        L_0x0371:
            if (r3 == 0) goto L_0x0378
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x037a
        L_0x0378:
            r3 = r122
        L_0x037a:
            if (r16 == 0) goto L_0x037e
            r12 = 1
            goto L_0x0380
        L_0x037e:
            r12 = r123
        L_0x0380:
            if (r19 == 0) goto L_0x0384
            r15 = 0
            goto L_0x0386
        L_0x0384:
            r15 = r124
        L_0x0386:
            r16 = r9 & 32
            if (r16 == 0) goto L_0x03b1
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r122 = r3
            r3 = r16
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r16 = 6
            r19 = 0
            r123 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
            java.lang.Object r12 = r8.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r3 = r12
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r12
            goto L_0x03b7
        L_0x03b1:
            r122 = r3
            r123 = r12
            r3 = r125
        L_0x03b7:
            if (r23 == 0) goto L_0x03bb
            r12 = 0
            goto L_0x03bd
        L_0x03bb:
            r12 = r126
        L_0x03bd:
            if (r5 == 0) goto L_0x03c1
            r5 = 0
            goto L_0x03c3
        L_0x03c1:
            r5 = r127
        L_0x03c3:
            if (r4 == 0) goto L_0x03c7
            r4 = 0
            goto L_0x03c9
        L_0x03c7:
            r4 = r128
        L_0x03c9:
            if (r6 == 0) goto L_0x03cd
            r6 = 0
            goto L_0x03cf
        L_0x03cd:
            r6 = r129
        L_0x03cf:
            if (r7 == 0) goto L_0x03d3
            r7 = 0
            goto L_0x03d5
        L_0x03d3:
            r7 = r130
        L_0x03d5:
            if (r10 == 0) goto L_0x03d9
            r10 = 0
            goto L_0x03db
        L_0x03d9:
            r10 = r131
        L_0x03db:
            if (r11 == 0) goto L_0x03e4
            androidx.compose.ui.text.input.VisualTransformation$Companion r11 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r11 = r11.getNone()
            goto L_0x03e6
        L_0x03e4:
            r11 = r132
        L_0x03e6:
            if (r14 == 0) goto L_0x03ef
            androidx.compose.foundation.text.KeyboardOptions$Companion r13 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r13 = r13.getDefault()
            goto L_0x03f1
        L_0x03ef:
            r13 = r133
        L_0x03f1:
            if (r17 == 0) goto L_0x03fa
            androidx.compose.foundation.text.KeyboardActions$Companion r14 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r14 = r14.getDefault()
            goto L_0x03fc
        L_0x03fa:
            r14 = r134
        L_0x03fc:
            if (r18 == 0) goto L_0x0403
            r16 = 0
            r116 = r16
            goto L_0x0405
        L_0x0403:
            r116 = r135
        L_0x0405:
            r16 = r9 & r22
            if (r16 == 0) goto L_0x041d
            if (r116 == 0) goto L_0x040e
            r16 = 1
            goto L_0x0411
        L_0x040e:
            r16 = 2147483647(0x7fffffff, float:NaN)
        L_0x0411:
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r17
            r119 = r16
            r16 = r1
            r1 = r119
            goto L_0x0421
        L_0x041d:
            r16 = r1
            r1 = r136
        L_0x0421:
            if (r20 == 0) goto L_0x0428
            r17 = 1
            r117 = r17
            goto L_0x042a
        L_0x0428:
            r117 = r137
        L_0x042a:
            if (r21 == 0) goto L_0x0472
            r17 = 0
            r18 = 0
            r124 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = 0
            r125 = r8
            r19 = 0
            r126 = r0
            java.lang.Object r0 = r125.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r127 = r1
            java.lang.Object r1 = r21.getEmpty()
            if (r0 != r1) goto L_0x0463
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r128 = r0
            r0 = r125
            r0.updateRememberedValue(r1)
            goto L_0x0469
        L_0x0463:
            r128 = r0
            r0 = r125
            r1 = r128
        L_0x0469:
            r8.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0478
        L_0x0472:
            r124 = r0
            r127 = r1
            r0 = r138
        L_0x0478:
            r1 = r9 & r25
            if (r1 == 0) goto L_0x048d
            androidx.compose.material3.TextFieldDefaults r1 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r125 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getShape(r8, r0)
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r16 = r16 & r1
            r1 = r16
            goto L_0x0493
        L_0x048d:
            r125 = r0
            r0 = r139
            r1 = r16
        L_0x0493:
            r16 = r9 & r24
            if (r16 == 0) goto L_0x052e
            androidx.compose.material3.TextFieldDefaults r16 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r108 = 2147483647(0x7fffffff, float:NaN)
            r109 = 4095(0xfff, float:5.738E-42)
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r72 = 0
            r74 = 0
            r76 = 0
            r78 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r86 = 0
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 0
            r96 = 0
            r98 = 0
            r100 = 0
            r103 = 0
            r104 = 0
            r105 = 0
            r106 = 0
            r107 = 3072(0xc00, float:4.305E-42)
            r102 = r8
            androidx.compose.material3.TextFieldColors r16 = r16.m3827colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r2 = r2 & -15
            r28 = r122
            r29 = r123
            r42 = r125
            r41 = r127
            r43 = r0
            r45 = r2
            r31 = r3
            r34 = r4
            r33 = r5
            r35 = r6
            r36 = r7
            r37 = r10
            r38 = r11
            r32 = r12
            r39 = r13
            r40 = r14
            r30 = r15
            r44 = r16
            r15 = r124
            r14 = r1
            goto L_0x0555
        L_0x052e:
            r28 = r122
            r29 = r123
            r42 = r125
            r41 = r127
            r44 = r140
            r43 = r0
            r45 = r2
            r31 = r3
            r34 = r4
            r33 = r5
            r35 = r6
            r36 = r7
            r37 = r10
            r38 = r11
            r32 = r12
            r39 = r13
            r40 = r14
            r30 = r15
            r15 = r124
            r14 = r1
        L_0x0555:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0566
            r0 = 1523846136(0x5ad40bf8, float:2.98429274E16)
            java.lang.String r1 = "androidx.compose.material3.TextField (TextField.kt:442)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r14, r1)
        L_0x0566:
            r0 = r15 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r15 & r110
            r0 = r0 | r1
            r1 = r15 & r111
            r0 = r0 | r1
            r1 = r15 & r112
            r0 = r0 | r1
            r1 = r15 & r113
            r0 = r0 | r1
            r1 = r15 & r114
            r0 = r0 | r1
            r1 = r15 & r115
            r24 = r0 | r1
            int r0 = r14 << 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | 54
            int r1 = r14 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r110
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r111
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r112
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r113
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r114
            r0 = r0 | r1
            int r1 = r14 << 6
            r1 = r1 & r115
            r25 = r0 | r1
            int r0 = r14 >> 24
            r0 = r0 & 14
            int r1 = r14 >> 24
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r45 << 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r26 = r0 | r1
            r10 = 0
            r11 = 0
            r27 = 0
            r0 = r120
            r1 = r121
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r46 = r8
            r8 = r34
            r9 = r35
            r12 = r36
            r13 = r37
            r47 = r14
            r14 = r38
            r48 = r15
            r15 = r39
            r16 = r40
            r17 = r116
            r18 = r41
            r19 = r117
            r20 = r42
            r21 = r43
            r22 = r44
            r23 = r46
            TextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r11, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r12, (boolean) r13, (androidx.compose.ui.text.input.VisualTransformation) r14, (androidx.compose.foundation.text.KeyboardOptions) r15, (androidx.compose.foundation.text.KeyboardActions) r16, (boolean) r17, (int) r18, (int) r19, (androidx.compose.foundation.interaction.MutableInteractionSource) r20, (androidx.compose.ui.graphics.Shape) r21, (androidx.compose.material3.TextFieldColors) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25, (int) r26, (int) r27)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0615
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0615:
            androidx.compose.runtime.ScopeUpdateScope r15 = r46.endRestartGroup()
            if (r15 != 0) goto L_0x061c
            goto L_0x0660
        L_0x061c:
            androidx.compose.material3.TextFieldKt$TextField$10 r26 = new androidx.compose.material3.TextFieldKt$TextField$10
            r0 = r26
            r1 = r120
            r2 = r121
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r39
            r118 = r15
            r15 = r40
            r16 = r116
            r17 = r41
            r18 = r117
            r19 = r42
            r20 = r43
            r21 = r44
            r22 = r142
            r23 = r143
            r24 = r144
            r25 = r145
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r0 = r26
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r118
            r1.updateScope(r0)
        L_0x0660:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x060a  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0629  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x062e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x064d  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0661  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x07e9  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0803  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0997  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0b22  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0b3e  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0b41  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0b4d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0b50  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0b75  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0c48  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0c54  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0c58  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0d0b  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0e8a  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0ea5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextFieldLayout(androidx.compose.ui.Modifier r63, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, boolean r71, float r72, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, androidx.compose.foundation.layout.PaddingValues r75, androidx.compose.runtime.Composer r76, int r77, int r78) {
        /*
            r15 = r63
            r14 = r64
            r13 = r65
            r12 = r66
            r11 = r67
            r10 = r68
            r9 = r69
            r8 = r70
            r7 = r71
            r6 = r72
            r5 = r73
            r4 = r74
            r3 = r75
            r2 = r77
            r1 = r78
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "textField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "paddingValues"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = -1830307184(0xffffffff92e7ba90, float:-1.4624141E-27)
            r3 = r76
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)512@24588L139,515@24775L7,516@24787L3994:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            r0 = r77
            r17 = r78
            r18 = r2 & 14
            if (r18 != 0) goto L_0x0058
            boolean r18 = r3.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x0054
            r18 = 4
            goto L_0x0056
        L_0x0054:
            r18 = 2
        L_0x0056:
            r0 = r0 | r18
        L_0x0058:
            r18 = r2 & 112(0x70, float:1.57E-43)
            if (r18 != 0) goto L_0x0069
            boolean r18 = r3.changedInstance(r14)
            if (r18 == 0) goto L_0x0065
            r18 = 32
            goto L_0x0067
        L_0x0065:
            r18 = 16
        L_0x0067:
            r0 = r0 | r18
        L_0x0069:
            r4 = r2 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0079
            boolean r4 = r3.changedInstance(r13)
            if (r4 == 0) goto L_0x0076
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0078
        L_0x0076:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0078:
            r0 = r0 | r4
        L_0x0079:
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0089
            boolean r4 = r3.changedInstance(r12)
            if (r4 == 0) goto L_0x0086
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r0 = r0 | r4
        L_0x0089:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            if (r4 != 0) goto L_0x009b
            boolean r4 = r3.changedInstance(r11)
            if (r4 == 0) goto L_0x0098
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r0 = r0 | r4
        L_0x009b:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r2
            if (r4 != 0) goto L_0x00ac
            boolean r4 = r3.changedInstance(r10)
            if (r4 == 0) goto L_0x00a9
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ab
        L_0x00a9:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00ab:
            r0 = r0 | r4
        L_0x00ac:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r2
            if (r4 != 0) goto L_0x00bd
            boolean r4 = r3.changedInstance(r9)
            if (r4 == 0) goto L_0x00ba
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bc
        L_0x00ba:
            r4 = 524288(0x80000, float:7.34684E-40)
        L_0x00bc:
            r0 = r0 | r4
        L_0x00bd:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r2
            if (r4 != 0) goto L_0x00ce
            boolean r4 = r3.changedInstance(r8)
            if (r4 == 0) goto L_0x00cb
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00cd
        L_0x00cb:
            r4 = 4194304(0x400000, float:5.877472E-39)
        L_0x00cd:
            r0 = r0 | r4
        L_0x00ce:
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r2
            if (r4 != 0) goto L_0x00df
            boolean r4 = r3.changed((boolean) r7)
            if (r4 == 0) goto L_0x00dc
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00de
        L_0x00dc:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00de:
            r0 = r0 | r4
        L_0x00df:
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r2
            if (r4 != 0) goto L_0x00f0
            boolean r4 = r3.changed((float) r6)
            if (r4 == 0) goto L_0x00ed
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00ef
        L_0x00ed:
            r4 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00ef:
            r0 = r0 | r4
        L_0x00f0:
            r4 = r0
            r0 = r1 & 14
            if (r0 != 0) goto L_0x0100
            boolean r0 = r3.changedInstance(r5)
            if (r0 == 0) goto L_0x00fd
            r0 = 4
            goto L_0x00fe
        L_0x00fd:
            r0 = 2
        L_0x00fe:
            r17 = r17 | r0
        L_0x0100:
            r0 = r1 & 112(0x70, float:1.57E-43)
            if (r0 != 0) goto L_0x0115
            r0 = r74
            r2 = 2
            boolean r18 = r3.changedInstance(r0)
            if (r18 == 0) goto L_0x0110
            r18 = 32
            goto L_0x0112
        L_0x0110:
            r18 = 16
        L_0x0112:
            r17 = r17 | r18
            goto L_0x0118
        L_0x0115:
            r0 = r74
            r2 = 2
        L_0x0118:
            r2 = r1 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x012c
            r2 = r75
            boolean r18 = r3.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x0127
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x0129
        L_0x0127:
            r18 = 128(0x80, float:1.794E-43)
        L_0x0129:
            r17 = r17 | r18
            goto L_0x012e
        L_0x012c:
            r2 = r75
        L_0x012e:
            r15 = r17
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r4 & r17
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r0) goto L_0x0156
            r0 = r15 & 731(0x2db, float:1.024E-42)
            r1 = 146(0x92, float:2.05E-43)
            if (r0 != r1) goto L_0x0156
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0147
            goto L_0x0156
        L_0x0147:
            r3.skipToGroupEnd()
            r1 = r74
            r41 = r3
            r76 = r4
            r14 = r13
            r42 = r15
            r15 = r9
            goto L_0x0ea8
        L_0x0156:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0164
            java.lang.String r0 = "androidx.compose.material3.TextFieldLayout (TextField.kt:497)"
            r1 = -1830307184(0xffffffff92e7ba90, float:-1.4624141E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r4, r15, r0)
        L_0x0164:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r71)
            java.lang.Float r1 = java.lang.Float.valueOf(r72)
            int r16 = r4 >> 24
            r16 = r16 & 14
            int r17 = r4 >> 24
            r17 = r17 & 112(0x70, float:1.57E-43)
            r16 = r16 | r17
            r14 = r15 & 896(0x380, float:1.256E-42)
            r14 = r16 | r14
            r16 = 0
            r17 = r14
            r14 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r14)
            boolean r14 = r3.changed((java.lang.Object) r0)
            boolean r18 = r3.changed((java.lang.Object) r1)
            r14 = r14 | r18
            boolean r18 = r3.changed((java.lang.Object) r2)
            r14 = r14 | r18
            r18 = r3
            r19 = 0
            r20 = r0
            java.lang.Object r0 = r18.rememberedValue()
            r21 = 0
            if (r14 != 0) goto L_0x01b9
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r1
            java.lang.Object r1 = r22.getEmpty()
            if (r0 != r1) goto L_0x01b4
            goto L_0x01bb
        L_0x01b4:
            r22 = r0
            r1 = r18
            goto L_0x01ca
        L_0x01b9:
            r23 = r1
        L_0x01bb:
            r1 = 0
            r22 = r0
            androidx.compose.material3.TextFieldMeasurePolicy r0 = new androidx.compose.material3.TextFieldMeasurePolicy
            r0.<init>(r7, r6, r2)
            r1 = r18
            r1.updateRememberedValue(r0)
        L_0x01ca:
            r3.endReplaceableGroup()
            androidx.compose.material3.TextFieldMeasurePolicy r0 = (androidx.compose.material3.TextFieldMeasurePolicy) r0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r14 = 0
            r16 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            r17 = r14
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r14)
            java.lang.Object r18 = r3.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r1 = r18
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            int r16 = r4 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r17 = 0
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r20 = 6
            r21 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r12, r14)
            java.lang.Object r12 = r3.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r7 = r12
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r20 = 6
            r21 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r14)
            java.lang.Object r6 = r3.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r20 = 6
            r21 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r13, r14)
            java.lang.Object r13 = r3.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r12 = r13
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r14 = androidx.compose.ui.layout.LayoutKt.materializerOf(r63)
            int r8 = r16 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r20 = 0
            androidx.compose.runtime.Applier r9 = r3.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x026c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x026c:
            r3.startReusableNode()
            boolean r9 = r3.getInserting()
            if (r9 == 0) goto L_0x0279
            r3.createNode(r13)
            goto L_0x027c
        L_0x0279:
            r3.useNode()
        L_0x027c:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r3)
            r21 = 0
            r22 = r13
            r13 = r0
            androidx.compose.ui.layout.MeasurePolicy r13 = (androidx.compose.ui.layout.MeasurePolicy) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            r24 = r0
            kotlin.jvm.functions.Function2 r0 = r23.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r13, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r7, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r12, r0)
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r9 = r8 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r14.invoke(r0, r3, r9)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            int r9 = r8 >> 9
            r9 = r9 & 14
            r13 = r3
            r21 = 0
            r0 = -95272033(0xfffffffffa52439f, float:-2.7293846E35)
            r25 = r6
            java.lang.String r6 = "C522@25106L11,605@28102L229:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r6)
            r0 = r15 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.invoke(r13, r0)
            r0 = -95272008(0xfffffffffa5243b8, float:-2.7293896E35)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "525@25170L269"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            java.lang.String r5 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            r27 = r7
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            if (r11 == 0) goto L_0x0470
            androidx.compose.ui.Modifier$Companion r29 = androidx.compose.ui.Modifier.Companion
            r30 = r8
            r8 = r29
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r29 = r9
            java.lang.String r9 = "Leading"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r9)
            androidx.compose.ui.Modifier r9 = androidx.compose.material3.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r8 = r8.then(r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getCenter()
            r31 = 48
            r32 = 0
            r33 = r12
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r12 = 0
            int r34 = r31 >> 3
            r34 = r34 & 14
            int r35 = r31 >> 3
            r35 = r35 & 112(0x70, float:1.57E-43)
            r36 = r14
            r14 = r34 | r35
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r12, r13, r14)
            int r34 = r31 << 3
            r34 = r34 & 112(0x70, float:1.57E-43)
            r35 = 0
            r37 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r38 = 6
            r39 = 0
            r40 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r12, r7)
            java.lang.Object r12 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r12
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r38 = 6
            r39 = 0
            r41 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r7)
            java.lang.Object r3 = r13.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r38 = 6
            r39 = 0
            r42 = r15
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r15, r7)
            java.lang.Object r15 = r13.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r12 = r15
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r38 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            r39 = r8
            int r8 = r34 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r43 = r38
            r38 = 0
            r44 = r1
            androidx.compose.runtime.Applier r1 = r13.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x03c1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03c1:
            r13.startReusableNode()
            boolean r1 = r13.getInserting()
            if (r1 == 0) goto L_0x03ce
            r13.createNode(r15)
            goto L_0x03d1
        L_0x03ce:
            r13.useNode()
        L_0x03d1:
            r13.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r45 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r46 = androidx.compose.ui.node.ComposeUiNode.Companion
            r47 = r15
            kotlin.jvm.functions.Function2 r15 = r46.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r14, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r3, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r12, r15)
            r13.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r15 = r8 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r45 = r3
            r3 = r43
            r3.invoke(r1, r13, r15)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r1)
            int r1 = r8 >> 9
            r1 = r1 & 14
            r15 = r13
            r43 = 0
            r46 = r1
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r48 = r31 >> 6
            r48 = r48 & 112(0x70, float:1.57E-43)
            r48 = r48 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r49 = r15
            r50 = 0
            r51 = r1
            r1 = 1219124082(0x48aa5b72, float:348891.56)
            r52 = r3
            java.lang.String r3 = "C531@25412L9:TextField.kt#uh7d8r"
            r53 = r8
            r8 = r49
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r3)
            int r1 = r4 >> 12
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.invoke(r8, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            goto L_0x047e
        L_0x0470:
            r44 = r1
            r41 = r3
            r30 = r8
            r29 = r9
            r33 = r12
            r36 = r14
            r42 = r15
        L_0x047e:
            r13.endReplaceableGroup()
            r1 = -95271673(0xfffffffffa524507, float:-2.729456E35)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "535@25506L271"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            if (r10 == 0) goto L_0x05f9
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            java.lang.String r3 = "Trailing"
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.material3.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r1 = r1.then(r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            r8 = 48
            r9 = 0
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r12 = 0
            int r14 = r8 >> 3
            r14 = r14 & 14
            int r15 = r8 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r12, r13, r14)
            int r15 = r8 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r31 = 0
            r32 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r34 = 6
            r35 = 0
            r37 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r7)
            java.lang.Object r9 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = r9
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r34 = 6
            r35 = 0
            r38 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r12, r7)
            java.lang.Object r12 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r12
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r34 = 6
            r35 = 0
            r39 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r7)
            java.lang.Object r6 = r13.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r34 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r35 = r1
            int r1 = r15 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r40 = r34
            r34 = 0
            r43 = r15
            androidx.compose.runtime.Applier r15 = r13.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x054a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x054a:
            r13.startReusableNode()
            boolean r15 = r13.getInserting()
            if (r15 == 0) goto L_0x0557
            r13.createNode(r12)
            goto L_0x055a
        L_0x0557:
            r13.useNode()
        L_0x055a:
            r13.disableReusing()
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r45 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r46 = androidx.compose.ui.node.ComposeUiNode.Companion
            r47 = r12
            kotlin.jvm.functions.Function2 r12 = r46.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r14, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r3, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r9, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r6, r12)
            r13.enableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r12 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r12)
            int r15 = r1 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r45 = r3
            r3 = r40
            r3.invoke(r12, r13, r15)
            r12 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r12)
            int r12 = r1 >> 9
            r12 = r12 & 14
            r15 = r13
            r40 = 0
            r46 = r1
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r48 = r8 >> 6
            r48 = r48 & 112(0x70, float:1.57E-43)
            r48 = r48 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r49 = r15
            r50 = 0
            r51 = r1
            r1 = 1219124419(0x48aa5cc3, float:348902.1)
            r52 = r3
            java.lang.String r3 = "C541@25749L10:TextField.kt#uh7d8r"
            r53 = r6
            r6 = r49
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r3)
            int r1 = r4 >> 15
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.invoke(r6, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            goto L_0x05fb
        L_0x05f9:
            r39 = r6
        L_0x05fb:
            r13.endReplaceableGroup()
            r1 = r44
            float r3 = androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(r2, r1)
            float r6 = androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(r2, r1)
            if (r11 == 0) goto L_0x0629
            float r8 = androidx.compose.material3.TextFieldImplKt.getHorizontalIconPadding()
            r9 = 0
            float r12 = r3 - r8
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r12)
            r9 = 0
            r12 = 0
            float r14 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r14)
            r12 = 0
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r8, (float) r9)
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r14)
            r44 = r8
            goto L_0x062b
        L_0x0629:
            r44 = r3
        L_0x062b:
            if (r10 == 0) goto L_0x064d
            float r8 = androidx.compose.material3.TextFieldImplKt.getHorizontalIconPadding()
            r9 = 0
            float r12 = r6 - r8
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r12)
            r9 = 0
            r12 = 0
            float r14 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r14)
            r12 = 0
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r8, (float) r9)
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r14)
            r53 = r8
            goto L_0x064f
        L_0x064d:
            r53 = r6
        L_0x064f:
            r8 = -95270733(0xfffffffffa5248b3, float:-2.7296421E35)
            r13.startReplaceableGroup(r8)
            java.lang.String r8 = "560@26444L334"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r8)
            r8 = 0
            r12 = 0
            r15 = r69
            if (r15 == 0) goto L_0x07e9
            androidx.compose.ui.Modifier$Companion r31 = androidx.compose.ui.Modifier.Companion
            r9 = r31
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            java.lang.String r14 = "Prefix"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r9, r14)
            float r14 = androidx.compose.material3.TextFieldImplKt.getMinTextLineHeight()
            r34 = r1
            r1 = 2
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m2310heightInVpY3zN4$default(r9, r14, r8, r1, r12)
            r1 = 0
            r14 = 3
            androidx.compose.ui.Modifier r43 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r9, r12, r1, r14, r12)
            float r46 = androidx.compose.material3.TextFieldImplKt.getPrefixSuffixTextPadding()
            r48 = 10
            r49 = 0
            r45 = 0
            r47 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r43, r44, r45, r46, r47, r48, r49)
            r9 = 0
            r14 = r9
            r9 = 0
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            r12 = 0
            int r38 = r14 >> 3
            r38 = r38 & 14
            int r40 = r14 >> 3
            r40 = r40 & 112(0x70, float:1.57E-43)
            r2 = r38 | r40
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r12, r13, r2)
            int r38 = r14 << 3
            r38 = r38 & 112(0x70, float:1.57E-43)
            r40 = 0
            r43 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r3)
            r3 = r39
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r39 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r45 = r6
            r6 = r39
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r39 = 6
            r46 = 0
            r47 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r7)
            java.lang.Object r8 = r13.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r6 = r8
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r39 = 6
            r46 = 0
            r48 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r7)
            java.lang.Object r9 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r8 = r9
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r39 = 6
            r46 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r7)
            java.lang.Object r10 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r10
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r39 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r46 = r1
            int r1 = r38 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r49 = r39
            r39 = 0
            androidx.compose.runtime.Applier r11 = r13.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x073a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x073a:
            r13.startReusableNode()
            boolean r11 = r13.getInserting()
            if (r11 == 0) goto L_0x0747
            r13.createNode(r10)
            goto L_0x074a
        L_0x0747:
            r13.useNode()
        L_0x074a:
            r13.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r50 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r51 = androidx.compose.ui.node.ComposeUiNode.Companion
            r52 = r10
            kotlin.jvm.functions.Function2 r10 = r51.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r2, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r6, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r8, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r9, r10)
            r13.enableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r10 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r10)
            int r11 = r1 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r50 = r2
            r2 = r49
            r2.invoke(r10, r13, r11)
            r10 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r10)
            int r10 = r1 >> 9
            r10 = r10 & 14
            r11 = r13
            r49 = 0
            r51 = r1
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r54 = r14 >> 6
            r54 = r54 & 112(0x70, float:1.57E-43)
            r54 = r54 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r55 = r11
            r56 = 0
            r57 = r1
            r1 = 1219125422(0x48aa60ae, float:348933.44)
            r58 = r2
            java.lang.String r2 = "C567@26752L8:TextField.kt#uh7d8r"
            r59 = r6
            r6 = r55
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r2)
            int r1 = r4 >> 18
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.invoke(r6, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            goto L_0x07f1
        L_0x07e9:
            r34 = r1
            r43 = r3
            r45 = r6
            r3 = r39
        L_0x07f1:
            r13.endReplaceableGroup()
            r1 = -95270334(0xfffffffffa524a42, float:-2.7297212E35)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "571@26843L332"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r8 = r70
            if (r8 == 0) goto L_0x0985
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            java.lang.String r2 = "Suffix"
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r2)
            float r2 = androidx.compose.material3.TextFieldImplKt.getMinTextLineHeight()
            r6 = 0
            r9 = 2
            r10 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m2310heightInVpY3zN4$default(r1, r2, r6, r9, r10)
            r2 = 0
            r6 = 3
            androidx.compose.ui.Modifier r50 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r1, r10, r2, r6, r10)
            float r51 = androidx.compose.material3.TextFieldImplKt.getPrefixSuffixTextPadding()
            r55 = 10
            r56 = 0
            r52 = 0
            r54 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r50, r51, r52, r53, r54, r55, r56)
            r2 = 0
            r6 = r2
            r2 = 0
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            r10 = 0
            int r11 = r6 >> 3
            r11 = r11 & 14
            int r12 = r6 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r10, r13, r11)
            int r12 = r6 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r14 = 0
            r38 = r2
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r39 = 6
            r40 = 0
            r46 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r7)
            java.lang.Object r9 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r2 = r9
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r39 = 6
            r40 = 0
            r47 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r7)
            java.lang.Object r10 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r10
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r39 = 6
            r40 = 0
            r48 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r14, r7)
            java.lang.Object r14 = r13.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r10 = r14
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r39 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r40 = r1
            int r1 = r12 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r49 = r39
            r39 = 0
            r50 = r12
            androidx.compose.runtime.Applier r12 = r13.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x08d6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x08d6:
            r13.startReusableNode()
            boolean r12 = r13.getInserting()
            if (r12 == 0) goto L_0x08e3
            r13.createNode(r14)
            goto L_0x08e6
        L_0x08e3:
            r13.useNode()
        L_0x08e6:
            r13.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r51 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r52 = androidx.compose.ui.node.ComposeUiNode.Companion
            r54 = r14
            kotlin.jvm.functions.Function2 r14 = r52.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r11, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r2, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r10, r14)
            r13.enableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r12 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r12)
            int r14 = r1 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r51 = r2
            r2 = r49
            r2.invoke(r12, r13, r14)
            r12 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r12)
            int r12 = r1 >> 9
            r12 = r12 & 14
            r14 = r13
            r49 = 0
            r52 = r1
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r55 = r6 >> 6
            r55 = r55 & 112(0x70, float:1.57E-43)
            r55 = r55 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r56 = r14
            r57 = 0
            r58 = r1
            r1 = 1219125819(0x48aa623b, float:348945.84)
            r59 = r2
            java.lang.String r2 = "C578@27149L8:TextField.kt#uh7d8r"
            r60 = r6
            r6 = r56
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r2)
            int r1 = r4 >> 21
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8.invoke(r6, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
        L_0x0985:
            r13.endReplaceableGroup()
            r1 = -95269936(0xfffffffffa524bd0, float:-2.7298E35)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "583@27240L347"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r14 = r65
            if (r14 == 0) goto L_0x0b22
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            java.lang.String r2 = "Label"
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r2)
            float r2 = androidx.compose.material3.TextFieldImplKt.getMinTextLineHeight()
            float r6 = androidx.compose.material3.TextFieldImplKt.getMinFocusedLabelLineHeight()
            r9 = r72
            float r2 = androidx.compose.ui.unit.DpKt.m7597lerpMdfbLM(r2, r6, r9)
            r6 = 0
            r10 = 2
            r11 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m2310heightInVpY3zN4$default(r1, r2, r6, r10, r11)
            r2 = 0
            r6 = 3
            androidx.compose.ui.Modifier r46 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r1, r11, r2, r6, r11)
            r51 = 10
            r52 = 0
            r48 = 0
            r50 = 0
            r47 = r44
            r49 = r53
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r46, r47, r48, r49, r50, r51, r52)
            r2 = 0
            r6 = r2
            r2 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            r11 = 0
            int r12 = r6 >> 3
            r12 = r12 & 14
            int r38 = r6 >> 3
            r38 = r38 & 112(0x70, float:1.57E-43)
            r12 = r12 | r38
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r11, r13, r12)
            int r38 = r6 << 3
            r38 = r38 & 112(0x70, float:1.57E-43)
            r39 = 0
            r40 = r2
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r46 = 6
            r47 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r7)
            java.lang.Object r9 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r2 = r9
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r46 = 6
            r47 = 0
            r48 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r7)
            java.lang.Object r10 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r10
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r46 = 6
            r47 = 0
            r49 = r11
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r11, r7)
            java.lang.Object r11 = r13.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r10 = r11
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r46 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r47 = r1
            int r1 = r38 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r50 = r46
            r46 = 0
            r51 = r7
            androidx.compose.runtime.Applier r7 = r13.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0a74
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0a74:
            r13.startReusableNode()
            boolean r7 = r13.getInserting()
            if (r7 == 0) goto L_0x0a81
            r13.createNode(r11)
            goto L_0x0a84
        L_0x0a81:
            r13.useNode()
        L_0x0a84:
            r13.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r52 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r54 = androidx.compose.ui.node.ComposeUiNode.Companion
            r55 = r11
            kotlin.jvm.functions.Function2 r11 = r54.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r12, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r2, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r9, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r10, r11)
            r13.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r7)
            int r11 = r1 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r52 = r2
            r2 = r50
            r2.invoke(r7, r13, r11)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r7)
            int r7 = r1 >> 9
            r7 = r7 & 14
            r11 = r13
            r50 = 0
            r54 = r1
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r56 = r6 >> 6
            r56 = r56 & 112(0x70, float:1.57E-43)
            r56 = r56 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r57 = r11
            r58 = 0
            r59 = r1
            r1 = 1219126248(0x48aa63e8, float:348959.25)
            r60 = r2
            java.lang.String r2 = "C589@27578L7:TextField.kt#uh7d8r"
            r61 = r6
            r6 = r57
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r2)
            int r1 = r4 >> 6
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r14.invoke(r6, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            goto L_0x0b24
        L_0x0b22:
            r51 = r7
        L_0x0b24:
            r13.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.material3.TextFieldImplKt.getMinTextLineHeight()
            r6 = 0
            r7 = 2
            r9 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m2310heightInVpY3zN4$default(r1, r2, r6, r7, r9)
            r2 = 0
            r6 = 3
            androidx.compose.ui.Modifier r54 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r1, r9, r2, r6, r9)
            if (r15 != 0) goto L_0x0b41
            r55 = r44
            goto L_0x0b4a
        L_0x0b41:
            r1 = 0
            r2 = 0
            float r6 = (float) r1
            float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r6)
            r55 = r6
        L_0x0b4a:
            if (r8 != 0) goto L_0x0b50
            r57 = r53
            goto L_0x0b59
        L_0x0b50:
            r1 = 0
            r2 = 0
            float r6 = (float) r1
            float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r6)
            r57 = r6
        L_0x0b59:
            r59 = 10
            r60 = 0
            r56 = 0
            r58 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r54, r55, r56, r57, r58, r59, r60)
            r2 = -95269212(0xfffffffffa524ea4, float:-2.7299434E35)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "601@27970L105"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r12 = r66
            if (r12 == 0) goto L_0x0b8e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            java.lang.String r6 = "Hint"
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r2, r6)
            androidx.compose.ui.Modifier r2 = r2.then(r1)
            int r6 = r4 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r12.invoke(r2, r13, r6)
        L_0x0b8e:
            r13.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            java.lang.String r6 = "TextField"
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r2, r6)
            androidx.compose.ui.Modifier r2 = r2.then(r1)
            r6 = 1
            r7 = 384(0x180, float:5.38E-43)
            r9 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            int r11 = r7 >> 3
            r11 = r11 & 14
            int r38 = r7 >> 3
            r38 = r38 & 112(0x70, float:1.57E-43)
            r11 = r11 | r38
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r6, r13, r11)
            int r38 = r7 << 3
            r38 = r38 & 112(0x70, float:1.57E-43)
            r39 = 0
            r40 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r46 = 6
            r47 = 0
            r48 = r6
            r6 = r51
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r6)
            java.lang.Object r8 = r13.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r1 = r8
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r46 = 6
            r47 = 0
            r49 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r6)
            java.lang.Object r9 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r8 = r9
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r46 = 6
            r47 = 0
            r50 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r10, r6)
            java.lang.Object r10 = r13.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r9 = r10
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r46 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r47 = r2
            int r2 = r38 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r51 = r46
            r46 = 0
            androidx.compose.runtime.Applier r12 = r13.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0c4b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0c4b:
            r13.startReusableNode()
            boolean r12 = r13.getInserting()
            if (r12 == 0) goto L_0x0c58
            r13.createNode(r10)
            goto L_0x0c5b
        L_0x0c58:
            r13.useNode()
        L_0x0c5b:
            r13.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r52 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r54 = androidx.compose.ui.node.ComposeUiNode.Companion
            r55 = r10
            kotlin.jvm.functions.Function2 r10 = r54.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r11, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r1, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r8, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r9, r10)
            r13.enableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r10 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r10)
            int r12 = r2 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r52 = r1
            r1 = r51
            r1.invoke(r10, r13, r12)
            r10 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r10)
            int r10 = r2 >> 9
            r10 = r10 & 14
            r12 = r13
            r51 = 0
            r54 = r1
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r56 = r7 >> 6
            r56 = r56 & 112(0x70, float:1.57E-43)
            r56 = r56 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r57 = r12
            r58 = 0
            r59 = r1
            r1 = 1219126976(0x48aa66c0, float:348982.0)
            r60 = r2
            java.lang.String r2 = "C611@28306L11:TextField.kt#uh7d8r"
            r61 = r7
            r7 = r57
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r1, r2)
            int r1 = r4 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r64
            r2.invoke(r7, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r1 = 243142693(0xe7e1025, float:3.131569E-30)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "616@28443L269"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r74
            if (r1 == 0) goto L_0x0e8a
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            java.lang.String r8 = "Supporting"
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r7, r8)
            float r8 = androidx.compose.material3.TextFieldImplKt.getMinSupportingTextLineHeight()
            r9 = 0
            r10 = 2
            r11 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m2310heightInVpY3zN4$default(r7, r8, r9, r10, r11)
            r8 = 0
            r9 = 3
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r7, r11, r8, r9, r11)
            androidx.compose.material3.TextFieldDefaults r46 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r51 = 15
            r52 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            androidx.compose.foundation.layout.PaddingValues r8 = androidx.compose.material3.TextFieldDefaults.m3823supportingTextPaddinga9UjIt4$material3_release$default(r46, r47, r48, r49, r50, r51, r52)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.padding(r7, r8)
            r8 = 0
            r9 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r10 = 0
            int r11 = r8 >> 3
            r11 = r11 & 14
            int r12 = r8 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r10, r13, r11)
            int r12 = r8 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r28 = 0
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 6
            r19 = 0
            r76 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r6)
            java.lang.Object r3 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r2 = r3
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r19 = 6
            r31 = 0
            r76 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r6)
            java.lang.Object r4 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = r4
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r19 = 6
            r31 = 0
            r32 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r5 = r13.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r4 = r5
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            r18 = r7
            int r7 = r12 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 6
            r19 = 0
            r31 = r9
            androidx.compose.runtime.Applier r9 = r13.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0de0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0de0:
            r13.startReusableNode()
            boolean r9 = r13.getInserting()
            if (r9 == 0) goto L_0x0ded
            r13.createNode(r5)
            goto L_0x0df0
        L_0x0ded:
            r13.useNode()
        L_0x0df0:
            r13.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r13)
            r35 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r37 = androidx.compose.ui.node.ComposeUiNode.Companion
            r38 = r5
            kotlin.jvm.functions.Function2 r5 = r37.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r11, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r2, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r3, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r4, r5)
            r13.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r5)
            int r9 = r7 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r6.invoke(r5, r13, r9)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r5)
            int r5 = r7 >> 9
            r5 = r5 & 14
            r9 = r13
            r23 = 0
            r35 = r2
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r8 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r26 = r9
            r37 = 0
            r39 = r0
            r0 = 1219127368(0x48aa6848, float:348994.25)
            r46 = r2
            java.lang.String r2 = "C621@28698L12:TextField.kt#uh7d8r"
            r47 = r3
            r3 = r26
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r2)
            int r0 = r42 >> 3
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.invoke(r3, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            goto L_0x0e8c
        L_0x0e8a:
            r76 = r4
        L_0x0e8c:
            r13.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r41.endReplaceableGroup()
            r41.endNode()
            r41.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0ea8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0ea8:
            androidx.compose.runtime.ScopeUpdateScope r13 = r41.endRestartGroup()
            if (r13 != 0) goto L_0x0eb5
            r18 = r76
            r17 = r41
            r19 = r42
            goto L_0x0eec
        L_0x0eb5:
            androidx.compose.material3.TextFieldKt$TextFieldLayout$2 r16 = new androidx.compose.material3.TextFieldKt$TextFieldLayout$2
            r0 = r16
            r1 = r63
            r2 = r64
            r17 = r41
            r3 = r65
            r18 = r76
            r4 = r66
            r5 = r67
            r6 = r68
            r7 = r69
            r8 = r70
            r9 = r71
            r10 = r72
            r11 = r73
            r12 = r74
            r15 = r13
            r13 = r75
            r14 = r77
            r62 = r15
            r19 = r42
            r15 = r78
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r62
            r1.updateScope(r0)
        L_0x0eec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y  reason: not valid java name */
    public static final int m3854calculateWidthyeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int affixTotalWidth = prefixWidth + suffixWidth;
        return Math.max(leadingWidth + Math.max(textFieldWidth + affixTotalWidth, Math.max(placeholderWidth + affixTotalWidth, labelWidth)) + trailingWidth, Constraints.m7500getMinWidthimpl(constraints));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc  reason: not valid java name */
    public static final int m3853calculateHeightmKXJcVc(int textFieldHeight, int labelHeight, int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int placeholderHeight, int supportingHeight, boolean isLabelFocused, long constraints, float density, PaddingValues paddingValues) {
        float f;
        float middleSectionHeight;
        int i = textFieldHeight;
        int i2 = labelHeight;
        int i3 = placeholderHeight;
        boolean hasLabel = i2 > 0;
        if (!hasLabel || isLabelFocused) {
            f = Dp.m7554constructorimpl(paddingValues.m2265calculateTopPaddingD9Ej5fM() + paddingValues.m2262calculateBottomPaddingD9Ej5fM());
        } else {
            f = Dp.m7554constructorimpl(((float) 2) * TextFieldImplKt.getTextFieldPadding());
        }
        float verticalPadding = density * f;
        if (!hasLabel || !isLabelFocused) {
            middleSectionHeight = ((float) Math.max(labelHeight, Math.max(textFieldHeight, i3))) + verticalPadding;
        } else {
            middleSectionHeight = ((float) i2) + verticalPadding + ((float) Math.max(textFieldHeight, i3));
        }
        int i4 = trailingHeight;
        int i5 = leadingHeight;
        return Math.max(Constraints.m7499getMinHeightimpl(constraints), ComparisonsKt.maxOf(leadingHeight, trailingHeight, prefixHeight, suffixHeight, MathKt.roundToInt(middleSectionHeight)) + supportingHeight);
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int i;
        Placeable.PlacementScope.m6439place70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.Companion.m7682getZeronOccac(), 0.0f, 2, (Object) null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (labelPlaceable != null) {
            Placeable it = labelPlaceable;
            if (singleLine) {
                i = Alignment.Companion.getCenterVertically().align(it.getHeight(), height);
            } else {
                i = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int startPosition = i;
            Placeable.PlacementScope placementScope = $this$placeWithLabel;
            Placeable.PlacementScope.placeRelative$default(placementScope, it, TextFieldImplKt.widthOrZero(leadingPlaceable), startPosition - MathKt.roundToInt(((float) (startPosition - labelEndPosition)) * animationProgress), 0.0f, 4, (Object) null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, (Object) null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), textPosition, 0.0f, 4, (Object) null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, (Object) null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, supportingPlaceable, 0, height, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        Placeable placeable = placeholderPlaceable;
        Placeable placeable2 = prefixPlaceable;
        Placeable placeable3 = suffixPlaceable;
        boolean z = singleLine;
        Placeable.PlacementScope.m6439place70tqf50$default($this$placeWithoutLabel, containerPlaceable, IntOffset.Companion.m7682getZeronOccac(), 0.0f, 2, (Object) null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.m2265calculateTopPaddingD9Ej5fM() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeWithoutLabel$calculateVerticalPosition(z, height, topPadding, placeable2), 0.0f, 4, (Object) null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), placeWithoutLabel$calculateVerticalPosition(z, height, topPadding, placeable3), 0.0f, 4, (Object) null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(z, height, topPadding, textPlaceable), 0.0f, 4, (Object) null);
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(z, height, topPadding, placeable), 0.0f, 4, (Object) null);
        }
        if (supportingPlaceable != null) {
            int i = topPadding;
            int i2 = height;
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, supportingPlaceable, 0, height, 0.0f, 4, (Object) null);
            return;
        }
        int i3 = height;
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable placeable) {
        if ($singleLine) {
            return Alignment.Companion.getCenterVertically().align(placeable.getHeight(), height);
        }
        return topPadding;
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter($this$drawIndicatorLine, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new TextFieldKt$drawIndicatorLine$1(indicatorBorder.m1903getWidthD9Ej5fM(), indicatorBorder));
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
