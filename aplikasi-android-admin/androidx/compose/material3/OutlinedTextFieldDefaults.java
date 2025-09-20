package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0002\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00130#¢\u0006\u0002\b$2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010/\u001a\u0002002\u0013\b\u0002\u00101\u001a\r\u0012\u0004\u0012\u00020\u00130#¢\u0006\u0002\b$H\u0007¢\u0006\u0002\u00102JÃ\u0003\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002042\b\b\u0002\u00109\u001a\u0002042\b\b\u0002\u0010:\u001a\u0002042\b\b\u0002\u0010;\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010F\u001a\u0002042\b\b\u0002\u0010G\u001a\u0002042\b\b\u0002\u0010H\u001a\u0002042\b\b\u0002\u0010I\u001a\u0002042\b\b\u0002\u0010J\u001a\u0002042\b\b\u0002\u0010K\u001a\u0002042\b\b\u0002\u0010L\u001a\u0002042\b\b\u0002\u0010M\u001a\u0002042\b\b\u0002\u0010N\u001a\u0002042\b\b\u0002\u0010O\u001a\u0002042\b\b\u0002\u0010P\u001a\u0002042\b\b\u0002\u0010Q\u001a\u0002042\b\b\u0002\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u0002042\b\b\u0002\u0010T\u001a\u0002042\b\b\u0002\u0010U\u001a\u0002042\b\b\u0002\u0010V\u001a\u0002042\b\b\u0002\u0010W\u001a\u0002042\b\b\u0002\u0010X\u001a\u0002042\b\b\u0002\u0010Y\u001a\u0002042\b\b\u0002\u0010Z\u001a\u0002042\b\b\u0002\u0010[\u001a\u0002042\b\b\u0002\u0010\\\u001a\u0002042\b\b\u0002\u0010]\u001a\u0002042\b\b\u0002\u0010^\u001a\u0002042\b\b\u0002\u0010_\u001a\u000204H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ;\u0010/\u001a\u0002002\b\b\u0002\u0010b\u001a\u00020\u00042\b\b\u0002\u0010c\u001a\u00020\u00042\b\b\u0002\u0010d\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006h"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusedBorderThickness", "unfocusedBorderThickness", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness = Dp.m7554constructorimpl((float) 2);
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m7554constructorimpl((float) 56);
    private static final float MinWidth = Dp.m7554constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness = Dp.m7554constructorimpl((float) 1);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1066756961);
        ComposerKt.sourceInformation($composer, "C1347@74442L9:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:1347)");
        }
        Shape shape = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m3607getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m3608getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m3609getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m3606getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: ContainerBox-nbWgWpA  reason: not valid java name */
    public final void m3603ContainerBoxnbWgWpA(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed, int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        float unfocusedBorderThickness2;
        float unfocusedBorderThickness3;
        Shape shape3;
        float unfocusedBorderThickness4;
        float focusedBorderThickness3;
        Shape shape4;
        int $dirty;
        Shape shape5;
        int i2;
        int i3;
        int i4;
        InteractionSource interactionSource2 = interactionSource;
        TextFieldColors textFieldColors = colors;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(textFieldColors, "colors");
        Composer $composer2 = $composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation($composer2, "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1394@76327L9,1398@76498L203,1410@76843L51,1406@76710L199:TextFieldDefaults.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i6 & 1) != 0) {
            $dirty2 |= 6;
            boolean z = enabled;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        } else {
            boolean z2 = enabled;
        }
        if ((i6 & 2) != 0) {
            $dirty2 |= 48;
            boolean z3 = isError;
        } else if ((i5 & 112) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        } else {
            boolean z4 = isError;
        }
        if ((i6 & 4) != 0) {
            $dirty2 |= 384;
        } else if ((i5 & 896) == 0) {
            $dirty2 |= $composer2.changed((Object) interactionSource2) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            $dirty2 |= 3072;
        } else if ((i5 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) textFieldColors) ? 2048 : 1024;
        }
        if ((i5 & 57344) == 0) {
            if ((i6 & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                shape2 = shape;
            }
            i4 = 8192;
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32) == 0) {
                focusedBorderThickness2 = focusedBorderThickness;
                if ($composer2.changed(focusedBorderThickness2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if ((3670016 & i5) == 0) {
            if ((i6 & 64) == 0) {
                f = unfocusedBorderThickness;
                if ($composer2.changed(f)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                f = unfocusedBorderThickness;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            f = unfocusedBorderThickness;
        }
        if ((i6 & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & i5) == 0) {
            $dirty2 |= $composer2.changed((Object) this) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i6 & 16) != 0) {
                    shape5 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    shape5 = shape2;
                }
                if ((i6 & 32) != 0) {
                    $dirty2 &= -458753;
                    focusedBorderThickness2 = FocusedBorderThickness;
                }
                if ((i6 & 64) != 0) {
                    $dirty = $dirty2 & -3670017;
                    shape4 = shape5;
                    unfocusedBorderThickness4 = UnfocusedBorderThickness;
                    focusedBorderThickness3 = focusedBorderThickness2;
                } else {
                    shape4 = shape5;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness4 = f;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i6 & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i6 & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                shape4 = shape2;
                focusedBorderThickness3 = focusedBorderThickness2;
                unfocusedBorderThickness4 = f;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461761386, $dirty, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1389)");
            }
            int $dirty3 = $dirty;
            Shape shape6 = shape4;
            BoxKt.Box(BackgroundKt.m1876backgroundbw27NRU(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m3846animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness4, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752)).getValue(), shape6), colors.containerColor$material3_release(enabled, isError, interactionSource, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168)).getValue().m4973unboximpl(), shape6), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i7 = $dirty3;
            unfocusedBorderThickness2 = unfocusedBorderThickness4;
            unfocusedBorderThickness3 = focusedBorderThickness3;
            shape3 = shape6;
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty2;
            shape3 = shape2;
            unfocusedBorderThickness3 = focusedBorderThickness2;
            unfocusedBorderThickness2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OutlinedTextFieldDefaults$ContainerBox$1(this, enabled, isError, interactionSource, colors, shape3, unfocusedBorderThickness3, unfocusedBorderThickness2, $changed, i));
        }
    }

    /* renamed from: contentPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m3602contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m3605contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m3605contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m2244PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: colors-0hiis_0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material3.TextFieldColors m3604colors0hiis_0(long r176, long r178, long r180, long r182, long r184, long r186, long r188, long r190, long r192, long r194, androidx.compose.foundation.text.selection.TextSelectionColors r196, long r197, long r199, long r201, long r203, long r205, long r207, long r209, long r211, long r213, long r215, long r217, long r219, long r221, long r223, long r225, long r227, long r229, long r231, long r233, long r235, long r237, long r239, long r241, long r243, long r245, long r247, long r249, long r251, long r253, long r255, long r257, long r259, androidx.compose.runtime.Composer r261, int r262, int r263, int r264, int r265, int r266, int r267, int r268) {
        /*
            r175 = this;
            r0 = r261
            r1 = r267
            r2 = r268
            r3 = 1767617725(0x695bb4bd, float:1.6600517E25)
            r0.startReplaceableGroup(r3)
            java.lang.String r4 = "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1479@81602L9,1480@81684L9,1481@81773L9,1483@81928L9,1488@82236L9,1489@82326L9,1490@82409L7,1491@82496L9,1492@82582L9,1493@82675L9,1495@82836L9,1496@82934L9,1497@83029L9,1498@83131L9,1500@83305L9,1501@83405L9,1502@83502L9,1504@83619L9,1505@83783L9,1506@83869L9,1507@83952L9,1508@84042L9,1510@84198L9,1511@84296L9,1512@84396L9,1513@84492L9,1515@84660L9,1516@84760L9,1517@84857L9,1519@84974L9,1520@85136L9,1521@85224L9,1522@85314L9,1523@85403L9,1525@85561L9,1526@85649L9,1527@85739L9,1528@85828L9,1530@85986L9:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            r4 = r1 & 1
            r5 = 6
            if (r4 == 0) goto L_0x0021
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r4 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getFocusInputColor()
            long r6 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            goto L_0x0023
        L_0x0021:
            r6 = r176
        L_0x0023:
            r4 = r1 & 2
            if (r4 == 0) goto L_0x0034
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r4 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r95 = r8
            goto L_0x0036
        L_0x0034:
            r95 = r178
        L_0x0036:
            r4 = r1 & 4
            if (r4 == 0) goto L_0x0055
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r4 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getDisabledInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r14 = 14
            r15 = 0
            r10 = 1052938076(0x3ec28f5c, float:0.38)
            r11 = 0
            r12 = 0
            r13 = 0
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r8, r10, r11, r12, r13, r14, r15)
            r97 = r8
            goto L_0x0057
        L_0x0055:
            r97 = r180
        L_0x0057:
            r4 = r1 & 8
            if (r4 == 0) goto L_0x0068
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r4 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getErrorInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r99 = r8
            goto L_0x006a
        L_0x0068:
            r99 = r182
        L_0x006a:
            r4 = r1 & 16
            if (r4 == 0) goto L_0x0077
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r4.m4998getTransparent0d7_KjU()
            r101 = r8
            goto L_0x0079
        L_0x0077:
            r101 = r184
        L_0x0079:
            r4 = r1 & 32
            if (r4 == 0) goto L_0x0086
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r4.m4998getTransparent0d7_KjU()
            r103 = r8
            goto L_0x0088
        L_0x0086:
            r103 = r186
        L_0x0088:
            r4 = r1 & 64
            if (r4 == 0) goto L_0x0095
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r4.m4998getTransparent0d7_KjU()
            r105 = r8
            goto L_0x0097
        L_0x0095:
            r105 = r188
        L_0x0097:
            r4 = r1 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00a4
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r4.m4998getTransparent0d7_KjU()
            r107 = r8
            goto L_0x00a6
        L_0x00a4:
            r107 = r190
        L_0x00a6:
            r4 = r1 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x00b7
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r4 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getCaretColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r109 = r8
            goto L_0x00b9
        L_0x00b7:
            r109 = r192
        L_0x00b9:
            r4 = r1 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x00ca
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r4 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r4 = r4.getErrorFocusCaretColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r4, r0, r5)
            r111 = r8
            goto L_0x00cc
        L_0x00ca:
            r111 = r194
        L_0x00cc:
            r4 = r1 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x00eb
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r8 = 0
            r9 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r10 = r0.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r261)
            r4 = r10
            androidx.compose.foundation.text.selection.TextSelectionColors r4 = (androidx.compose.foundation.text.selection.TextSelectionColors) r4
            goto L_0x00ed
        L_0x00eb:
            r4 = r196
        L_0x00ed:
            r8 = r1 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x00fe
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusOutlineColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r113 = r8
            goto L_0x0100
        L_0x00fe:
            r113 = r197
        L_0x0100:
            r8 = r1 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x0111
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getOutlineColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r115 = r8
            goto L_0x0113
        L_0x0111:
            r115 = r199
        L_0x0113:
            r8 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x0140
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledOutlineColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1039516303(0x3df5c28f, float:0.12)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r117 = r8
            goto L_0x0142
        L_0x0140:
            r117 = r201
        L_0x0142:
            r8 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0153
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorOutlineColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r119 = r8
            goto L_0x0155
        L_0x0153:
            r119 = r203
        L_0x0155:
            r8 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0168
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r121 = r8
            goto L_0x016a
        L_0x0168:
            r121 = r205
        L_0x016a:
            r8 = 65536(0x10000, float:9.18355E-41)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x017c
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r123 = r8
            goto L_0x017e
        L_0x017c:
            r123 = r207
        L_0x017e:
            r8 = 131072(0x20000, float:1.83671E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01ac
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r125 = r8
            goto L_0x01ae
        L_0x01ac:
            r125 = r209
        L_0x01ae:
            r8 = 262144(0x40000, float:3.67342E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01c0
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorLeadingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r127 = r8
            goto L_0x01c2
        L_0x01c0:
            r127 = r211
        L_0x01c2:
            r8 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01d4
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r129 = r8
            goto L_0x01d6
        L_0x01d4:
            r129 = r213
        L_0x01d6:
            r8 = 1048576(0x100000, float:1.469368E-39)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x01e8
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r131 = r8
            goto L_0x01ea
        L_0x01e8:
            r131 = r215
        L_0x01ea:
            r8 = 2097152(0x200000, float:2.938736E-39)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0218
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r133 = r8
            goto L_0x021a
        L_0x0218:
            r133 = r217
        L_0x021a:
            r8 = 4194304(0x400000, float:5.877472E-39)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x022c
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorTrailingIconColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r135 = r8
            goto L_0x022e
        L_0x022c:
            r135 = r219
        L_0x022e:
            r8 = 8388608(0x800000, float:1.17549435E-38)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0240
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getFocusLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r137 = r8
            goto L_0x0242
        L_0x0240:
            r137 = r221
        L_0x0242:
            r8 = 16777216(0x1000000, float:2.3509887E-38)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0254
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r139 = r8
            goto L_0x0256
        L_0x0254:
            r139 = r223
        L_0x0256:
            r8 = 33554432(0x2000000, float:9.403955E-38)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0284
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r141 = r8
            goto L_0x0286
        L_0x0284:
            r141 = r225
        L_0x0286:
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x0298
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getErrorLabelColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r143 = r8
            goto L_0x029a
        L_0x0298:
            r143 = r227
        L_0x029a:
            r8 = 134217728(0x8000000, float:3.85186E-34)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x02ac
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getInputPlaceholderColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r145 = r8
            goto L_0x02ae
        L_0x02ac:
            r145 = r229
        L_0x02ae:
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x02c0
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getInputPlaceholderColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r147 = r8
            goto L_0x02c2
        L_0x02c0:
            r147 = r231
        L_0x02c2:
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r8 = r8 & r1
            if (r8 == 0) goto L_0x02f0
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r8 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r8 = r8.getDisabledInputColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r8, r0, r5)
            r10 = 14
            r11 = 0
            r12 = 1052938076(0x3ec28f5c, float:0.38)
            r13 = 0
            r14 = 0
            r15 = 0
            r176 = r8
            r178 = r12
            r179 = r13
            r180 = r14
            r181 = r15
            r182 = r10
            r183 = r11
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r149 = r8
            goto L_0x02f2
        L_0x02f0:
            r149 = r233
        L_0x02f2:
            r8 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0304
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPlaceholderColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r151 = r8
            goto L_0x0306
        L_0x0304:
            r151 = r235
        L_0x0306:
            r1 = r2 & 1
            if (r1 == 0) goto L_0x0317
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getFocusSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r153 = r8
            goto L_0x0319
        L_0x0317:
            r153 = r237
        L_0x0319:
            r1 = r2 & 2
            if (r1 == 0) goto L_0x032a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r155 = r8
            goto L_0x032c
        L_0x032a:
            r155 = r239
        L_0x032c:
            r1 = r2 & 4
            if (r1 == 0) goto L_0x0359
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getDisabledSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r1 = 14
            r10 = 0
            r11 = 1052938076(0x3ec28f5c, float:0.38)
            r12 = 0
            r13 = 0
            r14 = 0
            r176 = r8
            r178 = r11
            r179 = r12
            r180 = r13
            r181 = r14
            r182 = r1
            r183 = r10
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r157 = r8
            goto L_0x035b
        L_0x0359:
            r157 = r241
        L_0x035b:
            r1 = r2 & 8
            if (r1 == 0) goto L_0x036c
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getErrorSupportingColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r159 = r8
            goto L_0x036e
        L_0x036c:
            r159 = r243
        L_0x036e:
            r1 = r2 & 16
            if (r1 == 0) goto L_0x037f
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r161 = r8
            goto L_0x0381
        L_0x037f:
            r161 = r245
        L_0x0381:
            r1 = r2 & 32
            if (r1 == 0) goto L_0x0392
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r163 = r8
            goto L_0x0394
        L_0x0392:
            r163 = r247
        L_0x0394:
            r1 = r2 & 64
            if (r1 == 0) goto L_0x03c1
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r1 = 14
            r10 = 0
            r11 = 1052938076(0x3ec28f5c, float:0.38)
            r12 = 0
            r13 = 0
            r14 = 0
            r176 = r8
            r178 = r11
            r179 = r12
            r180 = r13
            r181 = r14
            r182 = r1
            r183 = r10
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r165 = r8
            goto L_0x03c3
        L_0x03c1:
            r165 = r249
        L_0x03c3:
            r1 = r2 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x03d4
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputPrefixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r167 = r8
            goto L_0x03d6
        L_0x03d4:
            r167 = r251
        L_0x03d6:
            r1 = r2 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03e7
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r169 = r8
            goto L_0x03e9
        L_0x03e7:
            r169 = r253
        L_0x03e9:
            r1 = r2 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x03fa
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r171 = r8
            goto L_0x03fc
        L_0x03fa:
            r171 = r255
        L_0x03fc:
            r1 = r2 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0429
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            r1 = 14
            r10 = 0
            r11 = 1052938076(0x3ec28f5c, float:0.38)
            r12 = 0
            r13 = 0
            r14 = 0
            r176 = r8
            r178 = r11
            r179 = r12
            r180 = r13
            r181 = r14
            r182 = r1
            r183 = r10
            long r8 = androidx.compose.ui.graphics.Color.m4962copywmQWz5c$default(r176, r178, r179, r180, r181, r182, r183)
            r173 = r8
            goto L_0x042b
        L_0x0429:
            r173 = r257
        L_0x042b:
            r1 = r2 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x043a
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r1 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r1 = r1.getInputSuffixColor()
            long r1 = androidx.compose.material3.ColorSchemeKt.toColor(r1, r0, r5)
            goto L_0x043c
        L_0x043a:
            r1 = r259
        L_0x043c:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x044c
            java.lang.String r5 = "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1478)"
            r15 = r262
            r13 = r263
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r15, r13, r5)
            goto L_0x0450
        L_0x044c:
            r15 = r262
            r13 = r263
        L_0x0450:
            androidx.compose.material3.TextFieldColors r3 = new androidx.compose.material3.TextFieldColors
            r8 = r3
            r94 = 0
            r9 = r6
            r11 = r95
            r13 = r97
            r15 = r99
            r17 = r101
            r19 = r103
            r21 = r105
            r23 = r107
            r25 = r109
            r27 = r111
            r29 = r4
            r30 = r113
            r32 = r115
            r34 = r117
            r36 = r119
            r38 = r121
            r40 = r123
            r42 = r125
            r44 = r127
            r46 = r129
            r48 = r131
            r50 = r133
            r52 = r135
            r54 = r137
            r56 = r139
            r58 = r141
            r60 = r143
            r62 = r145
            r64 = r147
            r66 = r149
            r68 = r151
            r70 = r153
            r72 = r155
            r74 = r157
            r76 = r159
            r78 = r161
            r80 = r163
            r82 = r165
            r84 = r167
            r86 = r169
            r88 = r171
            r90 = r173
            r92 = r1
            r8.<init>(r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x04e1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04e1:
            r261.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.m3604colors0hiis_0(long, long, long, long, long, long, long, long, long, long, androidx.compose.foundation.text.selection.TextSelectionColors, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, long, androidx.compose.runtime.Composer, int, int, int, int, int, int, int):androidx.compose.material3.TextFieldColors");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DecorationBox(java.lang.String r117, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r118, boolean r119, boolean r120, androidx.compose.ui.text.input.VisualTransformation r121, androidx.compose.foundation.interaction.InteractionSource r122, boolean r123, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r124, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, androidx.compose.material3.TextFieldColors r131, androidx.compose.foundation.layout.PaddingValues r132, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r133, androidx.compose.runtime.Composer r134, int r135, int r136, int r137) {
        /*
            r116 = this;
            r15 = r117
            r14 = r118
            r13 = r121
            r12 = r122
            r11 = r135
            r10 = r136
            r9 = r137
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -350442135(0xffffffffeb1cad69, float:-1.8941133E26)
            r1 = r134
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1652@93520L8,1663@93808L709:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r135
            r1 = r136
            r2 = r9 & 1
            if (r2 == 0) goto L_0x003f
            r0 = r0 | 6
            goto L_0x004d
        L_0x003f:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x004d
            boolean r2 = r8.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004b
            r2 = 4
            goto L_0x004c
        L_0x004b:
            r2 = 2
        L_0x004c:
            r0 = r0 | r2
        L_0x004d:
            r2 = r9 & 2
            if (r2 == 0) goto L_0x0054
            r0 = r0 | 48
            goto L_0x0064
        L_0x0054:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r8.changedInstance(r14)
            if (r2 == 0) goto L_0x0061
            r2 = 32
            goto L_0x0063
        L_0x0061:
            r2 = 16
        L_0x0063:
            r0 = r0 | r2
        L_0x0064:
            r2 = r9 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x006f
            r0 = r0 | 384(0x180, float:5.38E-43)
            r2 = r119
            goto L_0x0085
        L_0x006f:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0083
            r2 = r119
            boolean r17 = r8.changed((boolean) r2)
            if (r17 == 0) goto L_0x007e
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0080
        L_0x007e:
            r17 = r16
        L_0x0080:
            r0 = r0 | r17
            goto L_0x0085
        L_0x0083:
            r2 = r119
        L_0x0085:
            r17 = r9 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0092
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r120
            goto L_0x00a8
        L_0x0092:
            r3 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            r3 = r120
            boolean r17 = r8.changed((boolean) r3)
            if (r17 == 0) goto L_0x00a1
            r17 = r18
            goto L_0x00a3
        L_0x00a1:
            r17 = r19
        L_0x00a3:
            r0 = r0 | r17
            goto L_0x00a8
        L_0x00a6:
            r3 = r120
        L_0x00a8:
            r17 = r9 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            r110 = 57344(0xe000, float:8.0356E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r17 == 0) goto L_0x00b6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c7
        L_0x00b6:
            r17 = r11 & r110
            if (r17 != 0) goto L_0x00c7
            boolean r17 = r8.changed((java.lang.Object) r13)
            if (r17 == 0) goto L_0x00c3
            r17 = r21
            goto L_0x00c5
        L_0x00c3:
            r17 = r20
        L_0x00c5:
            r0 = r0 | r17
        L_0x00c7:
            r17 = r9 & 32
            r111 = 458752(0x70000, float:6.42848E-40)
            if (r17 == 0) goto L_0x00d2
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00cf:
            r0 = r0 | r17
            goto L_0x00e2
        L_0x00d2:
            r17 = r11 & r111
            if (r17 != 0) goto L_0x00e2
            boolean r17 = r8.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00df
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00df:
            r17 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00cf
        L_0x00e2:
            r17 = r9 & 64
            r112 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00ef
            r22 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r22
            r4 = r123
            goto L_0x0105
        L_0x00ef:
            r22 = r11 & r112
            if (r22 != 0) goto L_0x0103
            r4 = r123
            boolean r23 = r8.changed((boolean) r4)
            if (r23 == 0) goto L_0x00fe
            r23 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0100
        L_0x00fe:
            r23 = 524288(0x80000, float:7.34684E-40)
        L_0x0100:
            r0 = r0 | r23
            goto L_0x0105
        L_0x0103:
            r4 = r123
        L_0x0105:
            r5 = r9 & 128(0x80, float:1.794E-43)
            r113 = 29360128(0x1c00000, float:7.052966E-38)
            if (r5 == 0) goto L_0x0112
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r24
            r6 = r124
            goto L_0x0128
        L_0x0112:
            r24 = r11 & r113
            if (r24 != 0) goto L_0x0126
            r6 = r124
            boolean r25 = r8.changedInstance(r6)
            if (r25 == 0) goto L_0x0121
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0123
        L_0x0121:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x0123:
            r0 = r0 | r25
            goto L_0x0128
        L_0x0126:
            r6 = r124
        L_0x0128:
            r7 = r9 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x0133
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r26
            r2 = r125
            goto L_0x014b
        L_0x0133:
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x0149
            r2 = r125
            boolean r26 = r8.changedInstance(r2)
            if (r26 == 0) goto L_0x0144
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0146
        L_0x0144:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0146:
            r0 = r0 | r26
            goto L_0x014b
        L_0x0149:
            r2 = r125
        L_0x014b:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0156
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r26
            r3 = r126
            goto L_0x016e
        L_0x0156:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x016c
            r3 = r126
            boolean r26 = r8.changedInstance(r3)
            if (r26 == 0) goto L_0x0167
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0169
        L_0x0167:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0169:
            r0 = r0 | r26
            goto L_0x016e
        L_0x016c:
            r3 = r126
        L_0x016e:
            r3 = r9 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0177
            r1 = r1 | 6
            r4 = r127
            goto L_0x018d
        L_0x0177:
            r26 = r10 & 14
            if (r26 != 0) goto L_0x018b
            r4 = r127
            boolean r26 = r8.changedInstance(r4)
            if (r26 == 0) goto L_0x0186
            r22 = 4
            goto L_0x0188
        L_0x0186:
            r22 = 2
        L_0x0188:
            r1 = r1 | r22
            goto L_0x018d
        L_0x018b:
            r4 = r127
        L_0x018d:
            r4 = r9 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0196
            r1 = r1 | 48
            r6 = r128
            goto L_0x01ac
        L_0x0196:
            r22 = r10 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01aa
            r6 = r128
            boolean r22 = r8.changedInstance(r6)
            if (r22 == 0) goto L_0x01a5
            r23 = 32
            goto L_0x01a7
        L_0x01a5:
            r23 = 16
        L_0x01a7:
            r1 = r1 | r23
            goto L_0x01ac
        L_0x01aa:
            r6 = r128
        L_0x01ac:
            r6 = r9 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x01b5
            r1 = r1 | 384(0x180, float:5.38E-43)
            r12 = r129
            goto L_0x01c8
        L_0x01b5:
            r12 = r10 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01c6
            r12 = r129
            boolean r22 = r8.changedInstance(r12)
            if (r22 == 0) goto L_0x01c3
            r16 = 256(0x100, float:3.59E-43)
        L_0x01c3:
            r1 = r1 | r16
            goto L_0x01c8
        L_0x01c6:
            r12 = r129
        L_0x01c8:
            r12 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x01d1
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r13 = r130
            goto L_0x01e5
        L_0x01d1:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e3
            r13 = r130
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r18 = r19
        L_0x01e0:
            r1 = r1 | r18
            goto L_0x01e5
        L_0x01e3:
            r13 = r130
        L_0x01e5:
            r16 = r10 & r110
            if (r16 != 0) goto L_0x01fd
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 != 0) goto L_0x01f8
            r13 = r131
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x01fa
            r20 = r21
            goto L_0x01fa
        L_0x01f8:
            r13 = r131
        L_0x01fa:
            r1 = r1 | r20
            goto L_0x01ff
        L_0x01fd:
            r13 = r131
        L_0x01ff:
            r16 = r10 & r111
            if (r16 != 0) goto L_0x021c
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x0215
            r13 = r132
            boolean r16 = r8.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0217
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0219
        L_0x0215:
            r13 = r132
        L_0x0217:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x0219:
            r1 = r1 | r16
            goto L_0x021e
        L_0x021c:
            r13 = r132
        L_0x021e:
            r16 = 65536(0x10000, float:9.18355E-41)
            r114 = r9 & r16
            if (r114 == 0) goto L_0x022b
            r16 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r16
            r13 = r133
            goto L_0x0241
        L_0x022b:
            r16 = r10 & r112
            if (r16 != 0) goto L_0x023f
            r13 = r133
            boolean r16 = r8.changedInstance(r13)
            if (r16 == 0) goto L_0x023a
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023c
        L_0x023a:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x023c:
            r1 = r1 | r16
            goto L_0x0241
        L_0x023f:
            r13 = r133
        L_0x0241:
            r16 = 131072(0x20000, float:1.83671E-40)
            r16 = r9 & r16
            if (r16 == 0) goto L_0x024e
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r15 = r116
            goto L_0x0264
        L_0x024e:
            r16 = r10 & r113
            if (r16 != 0) goto L_0x0262
            r15 = r116
            boolean r16 = r8.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x025d
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x025f
        L_0x025d:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x025f:
            r1 = r1 | r16
            goto L_0x0264
        L_0x0262:
            r15 = r116
        L_0x0264:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r0 & r16
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r13) goto L_0x029f
            r10 = 23967451(0x16db6db, float:4.3661218E-38)
            r10 = r10 & r1
            r13 = 4793490(0x492492, float:6.71711E-39)
            if (r10 != r13) goto L_0x029f
            boolean r10 = r8.getSkipping()
            if (r10 != 0) goto L_0x027e
            goto L_0x029f
        L_0x027e:
            r8.skipToGroupEnd()
            r22 = r123
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r34 = r0
            r35 = r1
            r33 = r8
            goto L_0x04c3
        L_0x029f:
            r8.startDefaults()
            r10 = r11 & 1
            if (r10 == 0) goto L_0x02db
            boolean r10 = r8.getDefaultsInvalid()
            if (r10 == 0) goto L_0x02ad
            goto L_0x02db
        L_0x02ad:
            r8.skipToGroupEnd()
            r2 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02b8
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
        L_0x02b8:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r9
            if (r2 == 0) goto L_0x02c2
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r2
        L_0x02c2:
            r22 = r123
            r23 = r124
            r24 = r125
            r25 = r126
            r26 = r127
            r27 = r128
            r28 = r129
            r29 = r130
            r30 = r131
            r31 = r132
            r32 = r133
            r13 = r1
            goto L_0x0411
        L_0x02db:
            if (r17 == 0) goto L_0x02df
            r10 = 0
            goto L_0x02e1
        L_0x02df:
            r10 = r123
        L_0x02e1:
            if (r5 == 0) goto L_0x02e5
            r5 = 0
            goto L_0x02e7
        L_0x02e5:
            r5 = r124
        L_0x02e7:
            if (r7 == 0) goto L_0x02eb
            r7 = 0
            goto L_0x02ed
        L_0x02eb:
            r7 = r125
        L_0x02ed:
            if (r2 == 0) goto L_0x02f1
            r2 = 0
            goto L_0x02f3
        L_0x02f1:
            r2 = r126
        L_0x02f3:
            if (r3 == 0) goto L_0x02f7
            r3 = 0
            goto L_0x02f9
        L_0x02f7:
            r3 = r127
        L_0x02f9:
            if (r4 == 0) goto L_0x02fd
            r4 = 0
            goto L_0x02ff
        L_0x02fd:
            r4 = r128
        L_0x02ff:
            if (r6 == 0) goto L_0x0303
            r6 = 0
            goto L_0x0305
        L_0x0303:
            r6 = r129
        L_0x0305:
            if (r12 == 0) goto L_0x0309
            r12 = 0
            goto L_0x030b
        L_0x0309:
            r12 = r130
        L_0x030b:
            r13 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x0386
            int r13 = r1 >> 12
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r107 = r13
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
            r16 = r116
            r102 = r8
            androidx.compose.material3.TextFieldColors r13 = r16.m3604colors0hiis_0(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90, r92, r94, r96, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r16
            goto L_0x0388
        L_0x0386:
            r13 = r131
        L_0x0388:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r9 & r16
            if (r16 == 0) goto L_0x03b3
            r16 = 15
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r123 = r116
            r124 = r18
            r125 = r19
            r126 = r20
            r127 = r21
            r128 = r16
            r129 = r17
            androidx.compose.foundation.layout.PaddingValues r16 = m3602contentPaddinga9UjIt4$default(r123, r124, r125, r126, r127, r128, r129)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r17
            goto L_0x03b5
        L_0x03b3:
            r16 = r132
        L_0x03b5:
            if (r114 == 0) goto L_0x03f3
            r134 = r2
            androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1 r2 = new androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1
            r123 = r2
            r124 = r119
            r125 = r10
            r126 = r122
            r127 = r13
            r128 = r0
            r129 = r1
            r123.<init>(r124, r125, r126, r127, r128, r129)
            r123 = r1
            r1 = -1448570018(0xffffffffa9a8935e, float:-7.486263E-14)
            r124 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r1, r3, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r26 = r124
            r25 = r134
            r32 = r1
            r27 = r4
            r23 = r5
            r28 = r6
            r24 = r7
            r22 = r10
            r29 = r12
            r30 = r13
            r31 = r16
            r13 = r123
            goto L_0x0411
        L_0x03f3:
            r123 = r1
            r134 = r2
            r124 = r3
            r26 = r124
            r32 = r133
            r25 = r134
            r27 = r4
            r23 = r5
            r28 = r6
            r24 = r7
            r22 = r10
            r29 = r12
            r30 = r13
            r31 = r16
            r13 = r123
        L_0x0411:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0422
            r1 = -350442135(0xffffffffeb1cad69, float:-1.8941133E26)
            java.lang.String r2 = "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r13, r2)
        L_0x0422:
            androidx.compose.material3.TextFieldType r1 = androidx.compose.material3.TextFieldType.Outlined
            r12 = r0
            r0 = r1
            int r1 = r12 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            int r2 = r12 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r12 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r110
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r111
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & r112
            r1 = r1 | r2
            int r2 = r13 << 21
            r2 = r2 & r113
            r1 = r1 | r2
            int r2 = r13 << 21
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r1 = r1 | r2
            int r2 = r13 << 21
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r3
            r19 = r1 | r2
            int r1 = r13 >> 9
            r1 = r1 & 14
            int r2 = r12 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r12 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r12 >> 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r12 >> 3
            r2 = r2 & r110
            r1 = r1 | r2
            r2 = r13 & r111
            r1 = r1 | r2
            int r2 = r13 << 6
            r2 = r2 & r112
            r1 = r1 | r2
            int r2 = r13 << 3
            r2 = r2 & r113
            r20 = r1 | r2
            r21 = 0
            r1 = r117
            r2 = r118
            r3 = r121
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r33 = r8
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r120
            r34 = r12
            r12 = r119
            r35 = r13
            r13 = r22
            r14 = r122
            r15 = r31
            r16 = r30
            r17 = r32
            r18 = r33
            androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04c3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04c3:
            androidx.compose.runtime.ScopeUpdateScope r15 = r33.endRestartGroup()
            if (r15 != 0) goto L_0x04ca
            goto L_0x0506
        L_0x04ca:
            androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2 r36 = new androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2
            r0 = r36
            r1 = r116
            r2 = r117
            r3 = r118
            r4 = r119
            r5 = r120
            r6 = r121
            r7 = r122
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r28
            r115 = r15
            r15 = r29
            r16 = r30
            r17 = r31
            r18 = r32
            r19 = r135
            r20 = r136
            r21 = r137
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r36
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r115
            r1.updateScope(r0)
        L_0x0506:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
