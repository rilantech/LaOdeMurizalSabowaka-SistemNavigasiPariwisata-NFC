package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00101\u001a\u0001\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001a]\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aE\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u0014\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010P\u001a\u00020QH\u0000\u001at\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u000207H\u0002\u001aZ\u0010^\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010_\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m7554constructorimpl((float) 20);
    private static final float TextFieldBottomPadding = Dp.m7554constructorimpl((float) 10);
    private static final float TextFieldTopPadding = Dp.m7554constructorimpl((float) 4);

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d7, code lost:
        if (r7.changed((java.lang.Object) r84) != false) goto L_0x01de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(java.lang.String r71, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r13 = r71
            r11 = r72
            r10 = r92
            r9 = r93
            r8 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1504264404(0xffffffffa656bf2c, float:-7.450525E-16)
            r1 = r91
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)164@8542L7,176@9142L39,178@9224L6,179@9349L17,191@9767L24,201@10205L20,188@9669L1571:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r92
            r1 = r93
            r2 = r8 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r7.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r8 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r7.changedInstance(r11)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r8 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r15 = r73
            goto L_0x0073
        L_0x005d:
            r15 = r10 & 896(0x380, float:1.256E-42)
            if (r15 != 0) goto L_0x0071
            r15 = r73
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r15 = r73
        L_0x0073:
            r16 = r8 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r74
            goto L_0x0096
        L_0x0080:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r74
            boolean r19 = r7.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r74
        L_0x0096:
            r19 = r8 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r62 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r75
            goto L_0x00bc
        L_0x00a6:
            r22 = r10 & r62
            if (r22 != 0) goto L_0x00ba
            r4 = r75
            boolean r23 = r7.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r75
        L_0x00bc:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r10 & r23
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = 65536(0x10000, float:9.18355E-41)
            if (r23 != 0) goto L_0x00dc
            r23 = r8 & 32
            if (r23 != 0) goto L_0x00d5
            r5 = r76
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00d7
            r26 = r24
            goto L_0x00d9
        L_0x00d5:
            r5 = r76
        L_0x00d7:
            r26 = r25
        L_0x00d9:
            r0 = r0 | r26
            goto L_0x00de
        L_0x00dc:
            r5 = r76
        L_0x00de:
            r26 = r8 & 64
            r63 = 3670016(0x380000, float:5.142788E-39)
            r27 = 524288(0x80000, float:7.34684E-40)
            if (r26 == 0) goto L_0x00ed
            r28 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r28
            r6 = r77
            goto L_0x0103
        L_0x00ed:
            r28 = r10 & r63
            if (r28 != 0) goto L_0x0101
            r6 = r77
            boolean r29 = r7.changedInstance(r6)
            if (r29 == 0) goto L_0x00fc
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r29 = r27
        L_0x00fe:
            r0 = r0 | r29
            goto L_0x0103
        L_0x0101:
            r6 = r77
        L_0x0103:
            r12 = r8 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x010e
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r30
            r14 = r78
            goto L_0x0126
        L_0x010e:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r10 & r30
            if (r30 != 0) goto L_0x0124
            r14 = r78
            boolean r31 = r7.changedInstance(r14)
            if (r31 == 0) goto L_0x011f
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0121
        L_0x011f:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0121:
            r0 = r0 | r31
            goto L_0x0126
        L_0x0124:
            r14 = r78
        L_0x0126:
            r3 = r8 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0131
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r31
            r4 = r79
            goto L_0x0149
        L_0x0131:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r10 & r31
            if (r31 != 0) goto L_0x0147
            r4 = r79
            boolean r31 = r7.changedInstance(r4)
            if (r31 == 0) goto L_0x0142
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0144
        L_0x0142:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0144:
            r0 = r0 | r31
            goto L_0x0149
        L_0x0147:
            r4 = r79
        L_0x0149:
            r4 = r8 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0154
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r31
            r5 = r80
            goto L_0x016c
        L_0x0154:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r10 & r31
            if (r31 != 0) goto L_0x016a
            r5 = r80
            boolean r31 = r7.changedInstance(r5)
            if (r31 == 0) goto L_0x0165
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r0 = r0 | r31
            goto L_0x016c
        L_0x016a:
            r5 = r80
        L_0x016c:
            r5 = r8 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0175
            r1 = r1 | 6
            r6 = r81
            goto L_0x018b
        L_0x0175:
            r31 = r9 & 14
            if (r31 != 0) goto L_0x0189
            r6 = r81
            boolean r31 = r7.changed((boolean) r6)
            if (r31 == 0) goto L_0x0184
            r22 = 4
            goto L_0x0186
        L_0x0184:
            r22 = 2
        L_0x0186:
            r1 = r1 | r22
            goto L_0x018b
        L_0x0189:
            r6 = r81
        L_0x018b:
            r6 = r8 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0194
            r1 = r1 | 48
            r11 = r82
            goto L_0x01aa
        L_0x0194:
            r22 = r9 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a8
            r11 = r82
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01a3
            r28 = 32
            goto L_0x01a5
        L_0x01a3:
            r28 = 16
        L_0x01a5:
            r1 = r1 | r28
            goto L_0x01aa
        L_0x01a8:
            r11 = r82
        L_0x01aa:
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01b3
            r1 = r1 | 384(0x180, float:5.38E-43)
            r13 = r83
            goto L_0x01c9
        L_0x01b3:
            r13 = r9 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x01c7
            r13 = r83
            boolean r22 = r7.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x01c2
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01c4
        L_0x01c2:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01c4:
            r1 = r1 | r29
            goto L_0x01c9
        L_0x01c7:
            r13 = r83
        L_0x01c9:
            r13 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e1
            r13 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r13 != 0) goto L_0x01da
            r13 = r84
            boolean r22 = r7.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01da:
            r13 = r84
        L_0x01dc:
            r17 = r18
        L_0x01de:
            r1 = r1 | r17
            goto L_0x01e3
        L_0x01e1:
            r13 = r84
        L_0x01e3:
            r13 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x01ec
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r85
            goto L_0x0200
        L_0x01ec:
            r17 = r9 & r62
            if (r17 != 0) goto L_0x01fe
            r14 = r85
            boolean r17 = r7.changed((boolean) r14)
            if (r17 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r20 = r21
        L_0x01fb:
            r1 = r1 | r20
            goto L_0x0200
        L_0x01fe:
            r14 = r85
        L_0x0200:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            if (r17 != 0) goto L_0x021f
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r8 & r17
            if (r17 != 0) goto L_0x0218
            r14 = r86
            boolean r17 = r7.changed((int) r14)
            if (r17 == 0) goto L_0x021a
            r17 = r24
            goto L_0x021c
        L_0x0218:
            r14 = r86
        L_0x021a:
            r17 = r25
        L_0x021c:
            r1 = r1 | r17
            goto L_0x0221
        L_0x021f:
            r14 = r86
        L_0x0221:
            r17 = r8 & r25
            if (r17 == 0) goto L_0x022c
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r14 = r87
            goto L_0x0242
        L_0x022c:
            r18 = r9 & r63
            if (r18 != 0) goto L_0x0240
            r14 = r87
            boolean r18 = r7.changed((int) r14)
            if (r18 == 0) goto L_0x023b
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023d
        L_0x023b:
            r18 = r27
        L_0x023d:
            r1 = r1 | r18
            goto L_0x0242
        L_0x0240:
            r14 = r87
        L_0x0242:
            r18 = r8 & r24
            if (r18 == 0) goto L_0x024d
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r20
            r14 = r88
            goto L_0x0265
        L_0x024d:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x0263
            r14 = r88
            boolean r20 = r7.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x025e
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0260
        L_0x025e:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0260:
            r1 = r1 | r20
            goto L_0x0265
        L_0x0263:
            r14 = r88
        L_0x0265:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x0283
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r8 & r20
            if (r20 != 0) goto L_0x027c
            r14 = r89
            boolean r20 = r7.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x027e
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0280
        L_0x027c:
            r14 = r89
        L_0x027e:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0280:
            r1 = r1 | r20
            goto L_0x0285
        L_0x0283:
            r14 = r89
        L_0x0285:
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x02a1
            r20 = r8 & r27
            if (r20 != 0) goto L_0x029a
            r15 = r90
            boolean r20 = r7.changed((java.lang.Object) r15)
            if (r20 == 0) goto L_0x029c
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x029e
        L_0x029a:
            r15 = r90
        L_0x029c:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x029e:
            r1 = r1 | r20
            goto L_0x02a3
        L_0x02a1:
            r15 = r90
        L_0x02a3:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r20
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r14) goto L_0x02ec
            r9 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r9 & r1
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r14) goto L_0x02ec
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x02bd
            goto L_0x02ec
        L_0x02bd:
            r7.skipToGroupEnd()
            r38 = r73
            r37 = r74
            r64 = r75
            r36 = r76
            r65 = r77
            r24 = r78
            r25 = r79
            r26 = r80
            r34 = r81
            r27 = r82
            r28 = r83
            r29 = r84
            r30 = r85
            r66 = r86
            r67 = r87
            r31 = r88
            r33 = r89
            r39 = r0
            r68 = r1
            r35 = r7
            r32 = r15
            goto L_0x06ee
        L_0x02ec:
            r7.startDefaults()
            r9 = r10 & 1
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r9 == 0) goto L_0x034c
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02fd
            goto L_0x034c
        L_0x02fd:
            r7.skipToGroupEnd()
            r2 = r8 & 32
            if (r2 == 0) goto L_0x0305
            r0 = r0 & r14
        L_0x0305:
            r2 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x030b
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x030b:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r8
            if (r2 == 0) goto L_0x0312
            r1 = r1 & r14
        L_0x0312:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r8
            if (r2 == 0) goto L_0x031b
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
        L_0x031b:
            r2 = r8 & r27
            if (r2 == 0) goto L_0x0323
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r2
        L_0x0323:
            r13 = r73
            r11 = r74
            r64 = r75
            r9 = r76
            r65 = r77
            r20 = r78
            r21 = r79
            r22 = r80
            r6 = r81
            r23 = r82
            r24 = r83
            r25 = r84
            r26 = r85
            r66 = r86
            r67 = r87
            r27 = r88
            r4 = r89
            r3 = r90
            r12 = r1
            r1 = r0
            r0 = 1
            goto L_0x052e
        L_0x034c:
            if (r2 == 0) goto L_0x0353
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0355
        L_0x0353:
            r2 = r73
        L_0x0355:
            if (r16 == 0) goto L_0x0359
            r9 = 1
            goto L_0x035b
        L_0x0359:
            r9 = r74
        L_0x035b:
            if (r19 == 0) goto L_0x0362
            r16 = 0
            r64 = r16
            goto L_0x0364
        L_0x0362:
            r64 = r75
        L_0x0364:
            r16 = r8 & 32
            if (r16 == 0) goto L_0x038c
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r15 = r16
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r16 = 6
            r19 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r73 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r14, r2)
            java.lang.Object r2 = r7.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r14
            goto L_0x0390
        L_0x038c:
            r73 = r2
            r2 = r76
        L_0x0390:
            if (r26 == 0) goto L_0x0396
            r14 = 0
            r65 = r14
            goto L_0x0398
        L_0x0396:
            r65 = r77
        L_0x0398:
            if (r12 == 0) goto L_0x039c
            r12 = 0
            goto L_0x039e
        L_0x039c:
            r12 = r78
        L_0x039e:
            if (r3 == 0) goto L_0x03a2
            r3 = 0
            goto L_0x03a4
        L_0x03a2:
            r3 = r79
        L_0x03a4:
            if (r4 == 0) goto L_0x03a8
            r4 = 0
            goto L_0x03aa
        L_0x03a8:
            r4 = r80
        L_0x03aa:
            if (r5 == 0) goto L_0x03ae
            r5 = 0
            goto L_0x03b0
        L_0x03ae:
            r5 = r81
        L_0x03b0:
            if (r6 == 0) goto L_0x03b9
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03bb
        L_0x03b9:
            r6 = r82
        L_0x03bb:
            if (r11 == 0) goto L_0x03c4
            androidx.compose.foundation.text.KeyboardOptions$Companion r11 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r11 = r11.getDefault()
            goto L_0x03c6
        L_0x03c4:
            r11 = r83
        L_0x03c6:
            r14 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x03f9
            androidx.compose.foundation.text.KeyboardActions r14 = new androidx.compose.foundation.text.KeyboardActions
            r15 = 63
            r16 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r74 = r14
            r75 = r19
            r76 = r21
            r77 = r22
            r78 = r23
            r79 = r24
            r80 = r25
            r81 = r15
            r82 = r16
            r74.<init>(r75, r76, r77, r78, r79, r80, r81, r82)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r70 = r14
            r14 = r1
            r1 = r70
            goto L_0x03fc
        L_0x03f9:
            r14 = r1
            r1 = r84
        L_0x03fc:
            if (r13 == 0) goto L_0x0400
            r13 = 0
            goto L_0x0402
        L_0x0400:
            r13 = r85
        L_0x0402:
            r15 = 32768(0x8000, float:4.5918E-41)
            r15 = r15 & r8
            if (r15 == 0) goto L_0x0417
            if (r13 == 0) goto L_0x040c
            r15 = 1
            goto L_0x040f
        L_0x040c:
            r15 = 2147483647(0x7fffffff, float:NaN)
        L_0x040f:
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = r14 & r16
            r66 = r15
            goto L_0x0419
        L_0x0417:
            r66 = r86
        L_0x0419:
            if (r17 == 0) goto L_0x041f
            r15 = 1
            r67 = r15
            goto L_0x0421
        L_0x041f:
            r67 = r87
        L_0x0421:
            if (r18 == 0) goto L_0x0468
            r15 = 0
            r16 = 0
            r74 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = 0
            r75 = r7
            r17 = 0
            r76 = r0
            java.lang.Object r0 = r75.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r77 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x0459
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r78 = r0
            r0 = r75
            r0.updateRememberedValue(r1)
            goto L_0x045f
        L_0x0459:
            r78 = r0
            r0 = r75
            r1 = r78
        L_0x045f:
            r7.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x046e
        L_0x0468:
            r74 = r0
            r77 = r1
            r0 = r88
        L_0x046e:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x04a9
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r15 = 6
            androidx.compose.material.Shapes r1 = r1.getShapes(r7, r15)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getSmall()
            androidx.compose.foundation.shape.CornerSize r15 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            androidx.compose.foundation.shape.CornerSize r16 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            r17 = 3
            r18 = 0
            r19 = 0
            r20 = 0
            r78 = r1
            r79 = r19
            r80 = r20
            r81 = r15
            r82 = r16
            r83 = r17
            r84 = r18
            androidx.compose.foundation.shape.CornerBasedShape r1 = androidx.compose.foundation.shape.CornerBasedShape.copy$default(r78, r79, r80, r81, r82, r83, r84)
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            r15 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r14 = r14 & r15
            r68 = r14
            goto L_0x04ad
        L_0x04a9:
            r1 = r89
            r68 = r14
        L_0x04ad:
            r14 = r8 & r27
            if (r14 == 0) goto L_0x050f
            androidx.compose.material.TextFieldDefaults r14 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r60 = 48
            r61 = 2097151(0x1fffff, float:2.938734E-39)
            r15 = 0
            r75 = r0
            r0 = 1
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
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r58 = 0
            r59 = 0
            r57 = r7
            androidx.compose.material.TextFieldColors r14 = r14.m3180textFieldColorsdx8h9Zs(r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r58, r59, r60, r61)
            r15 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r15 = r68 & r15
            r27 = r75
            r25 = r77
            r21 = r3
            r22 = r4
            r23 = r6
            r24 = r11
            r20 = r12
            r26 = r13
            r3 = r14
            r12 = r15
            r13 = r73
            r4 = r1
            r6 = r5
            r11 = r9
            r1 = r74
            r9 = r2
            goto L_0x052e
        L_0x050f:
            r75 = r0
            r0 = 1
            r27 = r75
            r25 = r77
            r21 = r3
            r22 = r4
            r23 = r6
            r24 = r11
            r20 = r12
            r26 = r13
            r12 = r68
            r13 = r73
            r3 = r90
            r4 = r1
            r6 = r5
            r11 = r9
            r1 = r74
            r9 = r2
        L_0x052e:
            r7.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x053f
            r2 = -1504264404(0xffffffffa656bf2c, float:-7.450525E-16)
            java.lang.String r5 = "androidx.compose.material.TextField (TextField.kt:158)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r12, r5)
        L_0x053f:
            r2 = -833027253(0xffffffffce59034b, float:-9.1021792E8)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "*183@9518L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            long r14 = r9.m7056getColor0d7_KjU()
            r2 = 0
            r16 = r14
            r5 = 0
            androidx.compose.ui.graphics.Color$Companion r18 = androidx.compose.ui.graphics.Color.Companion
            long r18 = r18.m4999getUnspecified0d7_KjU()
            int r18 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r18 == 0) goto L_0x055f
            r18 = r0
            goto L_0x0561
        L_0x055f:
            r18 = 0
        L_0x0561:
            if (r18 == 0) goto L_0x0566
            r29 = r14
            goto L_0x0581
        L_0x0566:
            r5 = 0
            int r16 = r1 >> 9
            r16 = r16 & 14
            int r17 = r12 >> 24
            r17 = r17 & 112(0x70, float:1.57E-43)
            r0 = r16 | r17
            androidx.compose.runtime.State r0 = r3.textColor(r11, r7, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r16 = r0.m4973unboximpl()
            r29 = r16
        L_0x0581:
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r28 = r0
            r58 = 16777214(0xfffffe, float:2.3509884E-38)
            r59 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r28.<init>((long) r29, (long) r31, (androidx.compose.ui.text.font.FontWeight) r33, (androidx.compose.ui.text.font.FontStyle) r34, (androidx.compose.ui.text.font.FontSynthesis) r35, (androidx.compose.ui.text.font.FontFamily) r36, (java.lang.String) r37, (long) r38, (androidx.compose.ui.text.style.BaselineShift) r40, (androidx.compose.ui.text.style.TextGeometricTransform) r41, (androidx.compose.ui.text.intl.LocaleList) r42, (long) r43, (androidx.compose.ui.text.style.TextDecoration) r45, (androidx.compose.ui.graphics.Shadow) r46, (androidx.compose.ui.graphics.drawscope.DrawStyle) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (androidx.compose.ui.text.PlatformTextStyle) r53, (androidx.compose.ui.text.style.LineHeightStyle) r54, (androidx.compose.ui.text.style.LineBreak) r55, (androidx.compose.ui.text.style.Hyphens) r56, (androidx.compose.ui.text.style.TextMotion) r57, (int) r58, (kotlin.jvm.internal.DefaultConstructorMarker) r59)
            androidx.compose.ui.text.TextStyle r28 = r9.merge((androidx.compose.ui.text.TextStyle) r0)
            r5 = r28
            androidx.compose.material.TextFieldDefaults r0 = androidx.compose.material.TextFieldDefaults.INSTANCE
            int r2 = r1 >> 9
            r2 = r2 & 14
            int r14 = r12 >> 24
            r14 = r14 & 112(0x70, float:1.57E-43)
            r2 = r2 | r14
            androidx.compose.runtime.State r2 = r3.backgroundColor(r11, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r14 = r2.m4973unboximpl()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r13, r14, r4)
            r14 = r27
            androidx.compose.foundation.interaction.InteractionSource r14 = (androidx.compose.foundation.interaction.InteractionSource) r14
            r15 = 48
            r16 = 0
            r17 = 0
            r18 = 0
            r73 = r0
            r74 = r2
            r75 = r11
            r76 = r6
            r77 = r14
            r78 = r3
            r79 = r17
            r80 = r18
            r81 = r15
            r82 = r16
            androidx.compose.ui.Modifier r0 = androidx.compose.material.TextFieldDefaults.m3168indicatorLinegv0btCI$default(r73, r74, r75, r76, r77, r78, r79, r80, r81, r82)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r2 = r2.m3175getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r14 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r14 = r14.m3174getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2306defaultMinSizeVpY3zN4(r0, r2, r14)
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            r14 = r12 & 14
            int r15 = r12 >> 24
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.runtime.State r14 = r3.cursorColor(r6, r7, r14)
            java.lang.Object r14 = r14.getValue()
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r14 = r14.m4973unboximpl()
            r16 = r4
            r4 = 0
            r0.<init>(r14, r4)
            r14 = r0
            androidx.compose.ui.graphics.Brush r14 = (androidx.compose.ui.graphics.Brush) r14
            androidx.compose.material.TextFieldKt$TextField$2 r0 = new androidx.compose.material.TextFieldKt$TextField$2
            r73 = r0
            r74 = r71
            r76 = r26
            r77 = r23
            r78 = r27
            r79 = r6
            r80 = r65
            r81 = r20
            r82 = r21
            r83 = r22
            r84 = r3
            r85 = r1
            r86 = r12
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)
            r4 = 989834338(0x3affac62, float:0.001950633)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r4, r15, r0)
            r15 = r0
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r0 = r1 & 14
            r4 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = r1 & r62
            r0 = r0 | r4
            int r4 = r12 << 12
            r4 = r4 & r63
            r0 = r0 | r4
            int r4 = r12 << 12
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r17
            r0 = r0 | r4
            int r4 = r12 << 12
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r17
            r0 = r0 | r4
            int r4 = r12 << 12
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r17
            r17 = r0 | r4
            int r0 = r12 >> 18
            r0 = r0 & 14
            r4 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r4
            r4 = r12 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            int r4 = r12 >> 12
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r18 = r0 | r4
            r0 = 0
            r68 = r12
            r12 = r0
            r19 = 4096(0x1000, float:5.74E-42)
            r0 = r71
            r31 = r1
            r1 = r72
            r32 = r3
            r3 = r11
            r33 = r16
            r4 = r64
            r34 = r6
            r6 = r24
            r35 = r7
            r7 = r25
            r8 = r26
            r36 = r9
            r9 = r66
            r10 = r67
            r37 = r11
            r11 = r23
            r38 = r13
            r13 = r27
            r16 = r35
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06dc:
            r28 = r24
            r29 = r25
            r30 = r26
            r39 = r31
            r24 = r20
            r25 = r21
            r26 = r22
            r31 = r27
            r27 = r23
        L_0x06ee:
            androidx.compose.runtime.ScopeUpdateScope r15 = r35.endRestartGroup()
            if (r15 != 0) goto L_0x06f5
            goto L_0x0735
        L_0x06f5:
            androidx.compose.material.TextFieldKt$TextField$3 r40 = new androidx.compose.material.TextFieldKt$TextField$3
            r0 = r40
            r1 = r71
            r2 = r72
            r3 = r38
            r4 = r37
            r5 = r64
            r6 = r36
            r7 = r65
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r34
            r12 = r27
            r13 = r28
            r14 = r29
            r69 = r15
            r15 = r30
            r16 = r66
            r17 = r67
            r18 = r31
            r19 = r33
            r20 = r32
            r21 = r92
            r22 = r93
            r23 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r40
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r69
            r1.updateScope(r0)
        L_0x0735:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v2, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d3, code lost:
        if (r10.changed((java.lang.Object) r85) != false) goto L_0x01da;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void TextField(java.lang.String r72, kotlin.jvm.functions.Function1 r73, androidx.compose.ui.Modifier r74, boolean r75, boolean r76, androidx.compose.ui.text.TextStyle r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, boolean r82, androidx.compose.ui.text.input.VisualTransformation r83, androidx.compose.foundation.text.KeyboardOptions r84, androidx.compose.foundation.text.KeyboardActions r85, boolean r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r15 = r72
            r14 = r73
            r13 = r92
            r12 = r93
            r11 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1690895095(0xffffffff9b36fd09, float:-1.5136447E-22)
            r1 = r91
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)240@11593L7,251@12147L39,253@12229L6,254@12354L17,256@12380L408:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r92
            r1 = r93
            r2 = r11 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r10.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r9 = r74
            goto L_0x0073
        L_0x005d:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0071
            r9 = r74
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r9 = r74
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r75
            goto L_0x0096
        L_0x0080:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r75
            boolean r19 = r10.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r75
        L_0x0096:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r76
            goto L_0x00bc
        L_0x00a6:
            r22 = r13 & r64
            if (r22 != 0) goto L_0x00ba
            r4 = r76
            boolean r23 = r10.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r76
        L_0x00bc:
            r65 = 458752(0x70000, float:6.42848E-40)
            r23 = r13 & r65
            r24 = 131072(0x20000, float:1.83671E-40)
            if (r23 != 0) goto L_0x00da
            r23 = r11 & 32
            if (r23 != 0) goto L_0x00d3
            r5 = r77
            boolean r25 = r10.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00d5
            r25 = r24
            goto L_0x00d7
        L_0x00d3:
            r5 = r77
        L_0x00d5:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00d7:
            r0 = r0 | r25
            goto L_0x00dc
        L_0x00da:
            r5 = r77
        L_0x00dc:
            r25 = r11 & 64
            r66 = 1572864(0x180000, float:2.204052E-39)
            r67 = 3670016(0x380000, float:5.142788E-39)
            if (r25 == 0) goto L_0x00e9
            r0 = r0 | r66
            r6 = r78
            goto L_0x00ff
        L_0x00e9:
            r26 = r13 & r67
            if (r26 != 0) goto L_0x00fd
            r6 = r78
            boolean r27 = r10.changedInstance(r6)
            if (r27 == 0) goto L_0x00f8
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fa
        L_0x00f8:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r6 = r78
        L_0x00ff:
            r7 = r11 & 128(0x80, float:1.794E-43)
            r68 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x010c
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r28
            r8 = r79
            goto L_0x0122
        L_0x010c:
            r28 = r13 & r68
            if (r28 != 0) goto L_0x0120
            r8 = r79
            boolean r29 = r10.changedInstance(r8)
            if (r29 == 0) goto L_0x011b
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011d
        L_0x011b:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x011d:
            r0 = r0 | r29
            goto L_0x0122
        L_0x0120:
            r8 = r79
        L_0x0122:
            r3 = r11 & 256(0x100, float:3.59E-43)
            r69 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x012f
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r29
            r4 = r80
            goto L_0x0145
        L_0x012f:
            r29 = r13 & r69
            if (r29 != 0) goto L_0x0143
            r4 = r80
            boolean r29 = r10.changedInstance(r4)
            if (r29 == 0) goto L_0x013e
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0140
        L_0x013e:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0140:
            r0 = r0 | r29
            goto L_0x0145
        L_0x0143:
            r4 = r80
        L_0x0145:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0150
            r29 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r29
            r5 = r81
            goto L_0x0168
        L_0x0150:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0166
            r5 = r81
            boolean r29 = r10.changedInstance(r5)
            if (r29 == 0) goto L_0x0161
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r0 = r0 | r29
            goto L_0x0168
        L_0x0166:
            r5 = r81
        L_0x0168:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0171
            r1 = r1 | 6
            r6 = r82
            goto L_0x0187
        L_0x0171:
            r29 = r12 & 14
            if (r29 != 0) goto L_0x0185
            r6 = r82
            boolean r29 = r10.changed((boolean) r6)
            if (r29 == 0) goto L_0x0180
            r22 = 4
            goto L_0x0182
        L_0x0180:
            r22 = 2
        L_0x0182:
            r1 = r1 | r22
            goto L_0x0187
        L_0x0185:
            r6 = r82
        L_0x0187:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0190
            r1 = r1 | 48
            r8 = r83
            goto L_0x01a6
        L_0x0190:
            r22 = r12 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a4
            r8 = r83
            boolean r22 = r10.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x019f
            r26 = 32
            goto L_0x01a1
        L_0x019f:
            r26 = 16
        L_0x01a1:
            r1 = r1 | r26
            goto L_0x01a6
        L_0x01a4:
            r8 = r83
        L_0x01a6:
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r84
            goto L_0x01c5
        L_0x01af:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01c3
            r9 = r84
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01be
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r1 = r1 | r27
            goto L_0x01c5
        L_0x01c3:
            r9 = r84
        L_0x01c5:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01dd
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01d6
            r9 = r85
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d6:
            r9 = r85
        L_0x01d8:
            r17 = r18
        L_0x01da:
            r1 = r1 | r17
            goto L_0x01df
        L_0x01dd:
            r9 = r85
        L_0x01df:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01e8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r86
            goto L_0x01fc
        L_0x01e8:
            r17 = r12 & r64
            if (r17 != 0) goto L_0x01fa
            r14 = r86
            boolean r17 = r10.changed((boolean) r14)
            if (r17 == 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r20 = r21
        L_0x01f7:
            r1 = r1 | r20
            goto L_0x01fc
        L_0x01fa:
            r14 = r86
        L_0x01fc:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020a
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r14 = r87
            goto L_0x0220
        L_0x020a:
            r18 = r12 & r65
            if (r18 != 0) goto L_0x021e
            r14 = r87
            boolean r18 = r10.changed((int) r14)
            if (r18 == 0) goto L_0x0219
            r18 = r24
            goto L_0x021b
        L_0x0219:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x021b:
            r1 = r1 | r18
            goto L_0x0220
        L_0x021e:
            r14 = r87
        L_0x0220:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r11 & r18
            if (r18 == 0) goto L_0x022b
            r1 = r1 | r66
            r14 = r88
            goto L_0x0241
        L_0x022b:
            r20 = r12 & r67
            if (r20 != 0) goto L_0x023f
            r14 = r88
            boolean r20 = r10.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x023a
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023c
        L_0x023a:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x023c:
            r1 = r1 | r20
            goto L_0x0241
        L_0x023f:
            r14 = r88
        L_0x0241:
            r20 = r12 & r68
            if (r20 != 0) goto L_0x025b
            r20 = r11 & r24
            if (r20 != 0) goto L_0x0254
            r14 = r89
            boolean r20 = r10.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x0256
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0258
        L_0x0254:
            r14 = r89
        L_0x0256:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0258:
            r1 = r1 | r20
            goto L_0x025d
        L_0x025b:
            r14 = r89
        L_0x025d:
            r20 = r12 & r69
            if (r20 != 0) goto L_0x0279
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r11 & r20
            if (r20 != 0) goto L_0x0272
            r12 = r90
            boolean r20 = r10.changed((java.lang.Object) r12)
            if (r20 == 0) goto L_0x0274
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0276
        L_0x0272:
            r12 = r90
        L_0x0274:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0276:
            r1 = r1 | r20
            goto L_0x027b
        L_0x0279:
            r12 = r90
        L_0x027b:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r0 & r20
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x02c2
            r12 = 191739611(0xb6db6db, float:4.5782105E-32)
            r12 = r12 & r1
            r14 = 38347922(0x2492492, float:1.4777643E-37)
            if (r12 != r14) goto L_0x02c2
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x0295
            goto L_0x02c2
        L_0x0295:
            r10.skipToGroupEnd()
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r42 = r0
            r41 = r1
            r40 = r10
            goto L_0x05b6
        L_0x02c2:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x033f
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x02d1
            goto L_0x033f
        L_0x02d1:
            r10.skipToGroupEnd()
            r2 = r11 & 32
            if (r2 == 0) goto L_0x02dc
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r2
        L_0x02dc:
            r2 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x02e2
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02e2:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x02ea
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
        L_0x02ea:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0319
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r14 = r0
            r13 = r1
            goto L_0x0511
        L_0x0319:
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r14 = r0
            r13 = r1
            goto L_0x0511
        L_0x033f:
            if (r2 == 0) goto L_0x0346
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0348
        L_0x0346:
            r2 = r74
        L_0x0348:
            if (r16 == 0) goto L_0x034c
            r12 = 1
            goto L_0x034e
        L_0x034c:
            r12 = r75
        L_0x034e:
            if (r19 == 0) goto L_0x0352
            r14 = 0
            goto L_0x0354
        L_0x0352:
            r14 = r76
        L_0x0354:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x037f
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r74 = r2
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 6
            r19 = 0
            r75 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r12, r13)
            java.lang.Object r12 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r2 = r12
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r12
            goto L_0x0385
        L_0x037f:
            r74 = r2
            r75 = r12
            r2 = r77
        L_0x0385:
            if (r25 == 0) goto L_0x0389
            r12 = 0
            goto L_0x038b
        L_0x0389:
            r12 = r78
        L_0x038b:
            if (r7 == 0) goto L_0x038f
            r7 = 0
            goto L_0x0391
        L_0x038f:
            r7 = r79
        L_0x0391:
            if (r3 == 0) goto L_0x0395
            r3 = 0
            goto L_0x0397
        L_0x0395:
            r3 = r80
        L_0x0397:
            if (r4 == 0) goto L_0x039b
            r4 = 0
            goto L_0x039d
        L_0x039b:
            r4 = r81
        L_0x039d:
            if (r5 == 0) goto L_0x03a1
            r5 = 0
            goto L_0x03a3
        L_0x03a1:
            r5 = r82
        L_0x03a3:
            if (r6 == 0) goto L_0x03ac
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03ae
        L_0x03ac:
            r6 = r83
        L_0x03ae:
            if (r8 == 0) goto L_0x03b7
            androidx.compose.foundation.text.KeyboardOptions$Companion r8 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r8 = r8.getDefault()
            goto L_0x03b9
        L_0x03b7:
            r8 = r84
        L_0x03b9:
            r13 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x03e7
            androidx.compose.foundation.text.KeyboardActions r13 = new androidx.compose.foundation.text.KeyboardActions
            r16 = 63
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r76 = r13
            r77 = r20
            r78 = r21
            r79 = r22
            r80 = r23
            r81 = r25
            r82 = r26
            r83 = r16
            r84 = r19
            r76.<init>(r77, r78, r79, r80, r81, r82, r83, r84)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03e9
        L_0x03e7:
            r13 = r85
        L_0x03e9:
            if (r9 == 0) goto L_0x03ed
            r9 = 0
            goto L_0x03ef
        L_0x03ed:
            r9 = r86
        L_0x03ef:
            if (r17 == 0) goto L_0x03f7
            r16 = 2147483647(0x7fffffff, float:NaN)
            r70 = r16
            goto L_0x03f9
        L_0x03f7:
            r70 = r87
        L_0x03f9:
            if (r18 == 0) goto L_0x0441
            r16 = 0
            r17 = 0
            r76 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r77 = r10
            r18 = 0
            r78 = r0
            java.lang.Object r0 = r77.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r91 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x0432
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r79 = r0
            r0 = r77
            r0.updateRememberedValue(r2)
            goto L_0x0438
        L_0x0432:
            r79 = r0
            r0 = r77
            r2 = r79
        L_0x0438:
            r10.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0447
        L_0x0441:
            r76 = r0
            r91 = r2
            r0 = r88
        L_0x0447:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x0481
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r77 = r0
            r0 = 6
            androidx.compose.material.Shapes r0 = r2.getShapes(r10, r0)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getSmall()
            androidx.compose.foundation.shape.CornerSize r2 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            androidx.compose.foundation.shape.CornerSize r16 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            r17 = 3
            r18 = 0
            r19 = 0
            r20 = 0
            r78 = r0
            r79 = r19
            r80 = r20
            r81 = r2
            r82 = r16
            r83 = r17
            r84 = r18
            androidx.compose.foundation.shape.CornerBasedShape r0 = androidx.compose.foundation.shape.CornerBasedShape.copy$default(r78, r79, r80, r81, r82, r83, r84)
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
            goto L_0x0485
        L_0x0481:
            r77 = r0
            r0 = r89
        L_0x0485:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x04ee
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
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
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r59 = r10
            androidx.compose.material.TextFieldColors r2 = r16.m3180textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r16
            r24 = r74
            r25 = r75
            r37 = r77
            r27 = r91
            r38 = r0
            r39 = r2
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r36 = r9
            r28 = r12
            r35 = r13
            r26 = r14
            r14 = r76
            r13 = r1
            goto L_0x0511
        L_0x04ee:
            r24 = r74
            r25 = r75
            r37 = r77
            r39 = r90
            r27 = r91
            r38 = r0
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r36 = r9
            r28 = r12
            r35 = r13
            r26 = r14
            r14 = r76
            r13 = r1
        L_0x0511:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0522
            r0 = -1690895095(0xffffffff9b36fd09, float:-1.5136447E-22)
            java.lang.String r1 = "androidx.compose.material.TextField (TextField.kt:234)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r13, r1)
        L_0x0522:
            r0 = r14 & 14
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r14 & r64
            r0 = r0 | r1
            r1 = r14 & r65
            r0 = r0 | r1
            r1 = r14 & r67
            r0 = r0 | r1
            r1 = r14 & r68
            r0 = r0 | r1
            r1 = r14 & r69
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r14
            r21 = r0 | r1
            r0 = r13 & 14
            r0 = r0 | r66
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r13 & r64
            r0 = r0 | r1
            r1 = r13 & r65
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & r68
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & r69
            r0 = r0 | r1
            int r1 = r13 << 3
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r22 = r0 | r1
            r16 = 1
            r23 = 0
            r0 = r72
            r1 = r73
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r40 = r10
            r10 = r32
            r11 = r33
            r12 = r34
            r41 = r13
            r13 = r35
            r42 = r14
            r14 = r36
            r15 = r70
            r17 = r37
            r18 = r38
            r19 = r39
            r20 = r40
            TextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (boolean) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (androidx.compose.foundation.text.KeyboardOptions) r12, (androidx.compose.foundation.text.KeyboardActions) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Shape) r18, (androidx.compose.material.TextFieldColors) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05b6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05b6:
            androidx.compose.runtime.ScopeUpdateScope r15 = r40.endRestartGroup()
            if (r15 != 0) goto L_0x05bd
            goto L_0x05fb
        L_0x05bd:
            androidx.compose.material.TextFieldKt$TextField$5 r23 = new androidx.compose.material.TextFieldKt$TextField$5
            r0 = r23
            r1 = r72
            r2 = r73
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r71 = r15
            r15 = r36
            r16 = r70
            r17 = r37
            r18 = r38
            r19 = r39
            r20 = r92
            r21 = r93
            r22 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r71
            r1.updateScope(r0)
        L_0x05fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d7, code lost:
        if (r7.changed((java.lang.Object) r84) != false) goto L_0x01de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(androidx.compose.ui.text.input.TextFieldValue r71, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r13 = r71
            r11 = r72
            r10 = r92
            r9 = r93
            r8 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -359119489(0xffffffffea98457f, float:-9.2042455E25)
            r1 = r91
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)353@17674L7,365@18274L39,366@18352L14,367@18416L17,379@18834L24,389@19272L20,376@18736L1576:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r92
            r1 = r93
            r2 = r8 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r7.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r8 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r7.changedInstance(r11)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r8 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r15 = r73
            goto L_0x0073
        L_0x005d:
            r15 = r10 & 896(0x380, float:1.256E-42)
            if (r15 != 0) goto L_0x0071
            r15 = r73
            boolean r16 = r7.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r15 = r73
        L_0x0073:
            r16 = r8 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r74
            goto L_0x0096
        L_0x0080:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r74
            boolean r19 = r7.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r74
        L_0x0096:
            r19 = r8 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r62 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r75
            goto L_0x00bc
        L_0x00a6:
            r22 = r10 & r62
            if (r22 != 0) goto L_0x00ba
            r4 = r75
            boolean r23 = r7.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r75
        L_0x00bc:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r10 & r23
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = 65536(0x10000, float:9.18355E-41)
            if (r23 != 0) goto L_0x00dc
            r23 = r8 & 32
            if (r23 != 0) goto L_0x00d5
            r5 = r76
            boolean r26 = r7.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x00d7
            r26 = r24
            goto L_0x00d9
        L_0x00d5:
            r5 = r76
        L_0x00d7:
            r26 = r25
        L_0x00d9:
            r0 = r0 | r26
            goto L_0x00de
        L_0x00dc:
            r5 = r76
        L_0x00de:
            r26 = r8 & 64
            r63 = 3670016(0x380000, float:5.142788E-39)
            r27 = 524288(0x80000, float:7.34684E-40)
            if (r26 == 0) goto L_0x00ed
            r28 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r28
            r6 = r77
            goto L_0x0103
        L_0x00ed:
            r28 = r10 & r63
            if (r28 != 0) goto L_0x0101
            r6 = r77
            boolean r29 = r7.changedInstance(r6)
            if (r29 == 0) goto L_0x00fc
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r29 = r27
        L_0x00fe:
            r0 = r0 | r29
            goto L_0x0103
        L_0x0101:
            r6 = r77
        L_0x0103:
            r12 = r8 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x010e
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r30
            r14 = r78
            goto L_0x0126
        L_0x010e:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r10 & r30
            if (r30 != 0) goto L_0x0124
            r14 = r78
            boolean r31 = r7.changedInstance(r14)
            if (r31 == 0) goto L_0x011f
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0121
        L_0x011f:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0121:
            r0 = r0 | r31
            goto L_0x0126
        L_0x0124:
            r14 = r78
        L_0x0126:
            r3 = r8 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0131
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r31
            r4 = r79
            goto L_0x0149
        L_0x0131:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r10 & r31
            if (r31 != 0) goto L_0x0147
            r4 = r79
            boolean r31 = r7.changedInstance(r4)
            if (r31 == 0) goto L_0x0142
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0144
        L_0x0142:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0144:
            r0 = r0 | r31
            goto L_0x0149
        L_0x0147:
            r4 = r79
        L_0x0149:
            r4 = r8 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0154
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r31
            r5 = r80
            goto L_0x016c
        L_0x0154:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r10 & r31
            if (r31 != 0) goto L_0x016a
            r5 = r80
            boolean r31 = r7.changedInstance(r5)
            if (r31 == 0) goto L_0x0165
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r0 = r0 | r31
            goto L_0x016c
        L_0x016a:
            r5 = r80
        L_0x016c:
            r5 = r8 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0175
            r1 = r1 | 6
            r6 = r81
            goto L_0x018b
        L_0x0175:
            r31 = r9 & 14
            if (r31 != 0) goto L_0x0189
            r6 = r81
            boolean r31 = r7.changed((boolean) r6)
            if (r31 == 0) goto L_0x0184
            r22 = 4
            goto L_0x0186
        L_0x0184:
            r22 = 2
        L_0x0186:
            r1 = r1 | r22
            goto L_0x018b
        L_0x0189:
            r6 = r81
        L_0x018b:
            r6 = r8 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0194
            r1 = r1 | 48
            r11 = r82
            goto L_0x01aa
        L_0x0194:
            r22 = r9 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a8
            r11 = r82
            boolean r22 = r7.changed((java.lang.Object) r11)
            if (r22 == 0) goto L_0x01a3
            r28 = 32
            goto L_0x01a5
        L_0x01a3:
            r28 = 16
        L_0x01a5:
            r1 = r1 | r28
            goto L_0x01aa
        L_0x01a8:
            r11 = r82
        L_0x01aa:
            r11 = r8 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01b3
            r1 = r1 | 384(0x180, float:5.38E-43)
            r13 = r83
            goto L_0x01c9
        L_0x01b3:
            r13 = r9 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x01c7
            r13 = r83
            boolean r22 = r7.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x01c2
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01c4
        L_0x01c2:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01c4:
            r1 = r1 | r29
            goto L_0x01c9
        L_0x01c7:
            r13 = r83
        L_0x01c9:
            r13 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01e1
            r13 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r13 != 0) goto L_0x01da
            r13 = r84
            boolean r22 = r7.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01da:
            r13 = r84
        L_0x01dc:
            r17 = r18
        L_0x01de:
            r1 = r1 | r17
            goto L_0x01e3
        L_0x01e1:
            r13 = r84
        L_0x01e3:
            r13 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x01ec
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r85
            goto L_0x0200
        L_0x01ec:
            r17 = r9 & r62
            if (r17 != 0) goto L_0x01fe
            r14 = r85
            boolean r17 = r7.changed((boolean) r14)
            if (r17 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r20 = r21
        L_0x01fb:
            r1 = r1 | r20
            goto L_0x0200
        L_0x01fe:
            r14 = r85
        L_0x0200:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            if (r17 != 0) goto L_0x021f
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r8 & r17
            if (r17 != 0) goto L_0x0218
            r14 = r86
            boolean r17 = r7.changed((int) r14)
            if (r17 == 0) goto L_0x021a
            r17 = r24
            goto L_0x021c
        L_0x0218:
            r14 = r86
        L_0x021a:
            r17 = r25
        L_0x021c:
            r1 = r1 | r17
            goto L_0x0221
        L_0x021f:
            r14 = r86
        L_0x0221:
            r17 = r8 & r25
            if (r17 == 0) goto L_0x022c
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r14 = r87
            goto L_0x0242
        L_0x022c:
            r18 = r9 & r63
            if (r18 != 0) goto L_0x0240
            r14 = r87
            boolean r18 = r7.changed((int) r14)
            if (r18 == 0) goto L_0x023b
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023d
        L_0x023b:
            r18 = r27
        L_0x023d:
            r1 = r1 | r18
            goto L_0x0242
        L_0x0240:
            r14 = r87
        L_0x0242:
            r18 = r8 & r24
            if (r18 == 0) goto L_0x024d
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r20
            r14 = r88
            goto L_0x0265
        L_0x024d:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x0263
            r14 = r88
            boolean r20 = r7.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x025e
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0260
        L_0x025e:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0260:
            r1 = r1 | r20
            goto L_0x0265
        L_0x0263:
            r14 = r88
        L_0x0265:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x0283
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r8 & r20
            if (r20 != 0) goto L_0x027c
            r14 = r89
            boolean r20 = r7.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x027e
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0280
        L_0x027c:
            r14 = r89
        L_0x027e:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0280:
            r1 = r1 | r20
            goto L_0x0285
        L_0x0283:
            r14 = r89
        L_0x0285:
            r20 = 1879048192(0x70000000, float:1.58456325E29)
            r20 = r9 & r20
            if (r20 != 0) goto L_0x02a1
            r20 = r8 & r27
            if (r20 != 0) goto L_0x029a
            r15 = r90
            boolean r20 = r7.changed((java.lang.Object) r15)
            if (r20 == 0) goto L_0x029c
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x029e
        L_0x029a:
            r15 = r90
        L_0x029c:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x029e:
            r1 = r1 | r20
            goto L_0x02a3
        L_0x02a1:
            r15 = r90
        L_0x02a3:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r0 & r20
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r14) goto L_0x02ec
            r9 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r9 & r1
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r14) goto L_0x02ec
            boolean r9 = r7.getSkipping()
            if (r9 != 0) goto L_0x02bd
            goto L_0x02ec
        L_0x02bd:
            r7.skipToGroupEnd()
            r38 = r73
            r37 = r74
            r64 = r75
            r36 = r76
            r65 = r77
            r24 = r78
            r25 = r79
            r26 = r80
            r34 = r81
            r27 = r82
            r28 = r83
            r29 = r84
            r30 = r85
            r66 = r86
            r67 = r87
            r31 = r88
            r33 = r89
            r39 = r0
            r68 = r1
            r35 = r7
            r32 = r15
            goto L_0x06c6
        L_0x02ec:
            r7.startDefaults()
            r9 = r10 & 1
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r9 == 0) goto L_0x034c
            boolean r9 = r7.getDefaultsInvalid()
            if (r9 == 0) goto L_0x02fd
            goto L_0x034c
        L_0x02fd:
            r7.skipToGroupEnd()
            r2 = r8 & 32
            if (r2 == 0) goto L_0x0305
            r0 = r0 & r14
        L_0x0305:
            r2 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x030b
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x030b:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r8
            if (r2 == 0) goto L_0x0312
            r1 = r1 & r14
        L_0x0312:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r8
            if (r2 == 0) goto L_0x031b
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
        L_0x031b:
            r2 = r8 & r27
            if (r2 == 0) goto L_0x0323
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r2
        L_0x0323:
            r13 = r73
            r11 = r74
            r64 = r75
            r9 = r76
            r65 = r77
            r20 = r78
            r21 = r79
            r22 = r80
            r6 = r81
            r23 = r82
            r24 = r83
            r25 = r84
            r26 = r85
            r66 = r86
            r67 = r87
            r27 = r88
            r4 = r89
            r3 = r90
            r12 = r1
            r1 = r0
            r0 = 1
            goto L_0x0506
        L_0x034c:
            if (r2 == 0) goto L_0x0353
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0355
        L_0x0353:
            r2 = r73
        L_0x0355:
            if (r16 == 0) goto L_0x0359
            r9 = 1
            goto L_0x035b
        L_0x0359:
            r9 = r74
        L_0x035b:
            if (r19 == 0) goto L_0x0362
            r16 = 0
            r64 = r16
            goto L_0x0364
        L_0x0362:
            r64 = r75
        L_0x0364:
            r16 = r8 & 32
            if (r16 == 0) goto L_0x038c
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r15 = r16
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r16 = 6
            r19 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            r73 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r14, r2)
            java.lang.Object r2 = r7.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r14
            goto L_0x0390
        L_0x038c:
            r73 = r2
            r2 = r76
        L_0x0390:
            if (r26 == 0) goto L_0x0396
            r14 = 0
            r65 = r14
            goto L_0x0398
        L_0x0396:
            r65 = r77
        L_0x0398:
            if (r12 == 0) goto L_0x039c
            r12 = 0
            goto L_0x039e
        L_0x039c:
            r12 = r78
        L_0x039e:
            if (r3 == 0) goto L_0x03a2
            r3 = 0
            goto L_0x03a4
        L_0x03a2:
            r3 = r79
        L_0x03a4:
            if (r4 == 0) goto L_0x03a8
            r4 = 0
            goto L_0x03aa
        L_0x03a8:
            r4 = r80
        L_0x03aa:
            if (r5 == 0) goto L_0x03ae
            r5 = 0
            goto L_0x03b0
        L_0x03ae:
            r5 = r81
        L_0x03b0:
            if (r6 == 0) goto L_0x03b9
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03bb
        L_0x03b9:
            r6 = r82
        L_0x03bb:
            if (r11 == 0) goto L_0x03c4
            androidx.compose.foundation.text.KeyboardOptions$Companion r11 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r11 = r11.getDefault()
            goto L_0x03c6
        L_0x03c4:
            r11 = r83
        L_0x03c6:
            r14 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x03f9
            androidx.compose.foundation.text.KeyboardActions r14 = new androidx.compose.foundation.text.KeyboardActions
            r15 = 63
            r16 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r74 = r14
            r75 = r19
            r76 = r21
            r77 = r22
            r78 = r23
            r79 = r24
            r80 = r25
            r81 = r15
            r82 = r16
            r74.<init>(r75, r76, r77, r78, r79, r80, r81, r82)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r70 = r14
            r14 = r1
            r1 = r70
            goto L_0x03fc
        L_0x03f9:
            r14 = r1
            r1 = r84
        L_0x03fc:
            if (r13 == 0) goto L_0x0400
            r13 = 0
            goto L_0x0402
        L_0x0400:
            r13 = r85
        L_0x0402:
            r15 = 32768(0x8000, float:4.5918E-41)
            r15 = r15 & r8
            if (r15 == 0) goto L_0x0417
            if (r13 == 0) goto L_0x040c
            r15 = 1
            goto L_0x040f
        L_0x040c:
            r15 = 2147483647(0x7fffffff, float:NaN)
        L_0x040f:
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = r14 & r16
            r66 = r15
            goto L_0x0419
        L_0x0417:
            r66 = r86
        L_0x0419:
            if (r17 == 0) goto L_0x041f
            r15 = 1
            r67 = r15
            goto L_0x0421
        L_0x041f:
            r67 = r87
        L_0x0421:
            if (r18 == 0) goto L_0x0468
            r15 = 0
            r16 = 0
            r74 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = 0
            r75 = r7
            r17 = 0
            r76 = r0
            java.lang.Object r0 = r75.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r77 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x0459
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r78 = r0
            r0 = r75
            r0.updateRememberedValue(r1)
            goto L_0x045f
        L_0x0459:
            r78 = r0
            r0 = r75
            r1 = r78
        L_0x045f:
            r7.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x046e
        L_0x0468:
            r74 = r0
            r77 = r1
            r0 = r88
        L_0x046e:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r8
            if (r1 == 0) goto L_0x0481
            androidx.compose.material.TextFieldDefaults r1 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r15 = 6
            androidx.compose.ui.graphics.Shape r1 = r1.getTextFieldShape(r7, r15)
            r15 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r14 = r14 & r15
            r68 = r14
            goto L_0x0485
        L_0x0481:
            r1 = r89
            r68 = r14
        L_0x0485:
            r14 = r8 & r27
            if (r14 == 0) goto L_0x04e7
            androidx.compose.material.TextFieldDefaults r14 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r60 = 48
            r61 = 2097151(0x1fffff, float:2.938734E-39)
            r15 = 0
            r75 = r0
            r0 = 1
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
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r58 = 0
            r59 = 0
            r57 = r7
            androidx.compose.material.TextFieldColors r14 = r14.m3180textFieldColorsdx8h9Zs(r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r58, r59, r60, r61)
            r15 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r15 = r68 & r15
            r27 = r75
            r25 = r77
            r21 = r3
            r22 = r4
            r23 = r6
            r24 = r11
            r20 = r12
            r26 = r13
            r3 = r14
            r12 = r15
            r13 = r73
            r4 = r1
            r6 = r5
            r11 = r9
            r1 = r74
            r9 = r2
            goto L_0x0506
        L_0x04e7:
            r75 = r0
            r0 = 1
            r27 = r75
            r25 = r77
            r21 = r3
            r22 = r4
            r23 = r6
            r24 = r11
            r20 = r12
            r26 = r13
            r12 = r68
            r13 = r73
            r3 = r90
            r4 = r1
            r6 = r5
            r11 = r9
            r1 = r74
            r9 = r2
        L_0x0506:
            r7.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0517
            r2 = -359119489(0xffffffffea98457f, float:-9.2042455E25)
            java.lang.String r5 = "androidx.compose.material.TextField (TextField.kt:347)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r12, r5)
        L_0x0517:
            r2 = -833018186(0xffffffffce5926b6, float:-9.1079821E8)
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "*371@18585L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            long r14 = r9.m7056getColor0d7_KjU()
            r2 = 0
            r16 = r14
            r5 = 0
            androidx.compose.ui.graphics.Color$Companion r18 = androidx.compose.ui.graphics.Color.Companion
            long r18 = r18.m4999getUnspecified0d7_KjU()
            int r18 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r18 == 0) goto L_0x0537
            r18 = r0
            goto L_0x0539
        L_0x0537:
            r18 = 0
        L_0x0539:
            if (r18 == 0) goto L_0x053e
            r29 = r14
            goto L_0x0559
        L_0x053e:
            r5 = 0
            int r16 = r1 >> 9
            r16 = r16 & 14
            int r17 = r12 >> 24
            r17 = r17 & 112(0x70, float:1.57E-43)
            r0 = r16 | r17
            androidx.compose.runtime.State r0 = r3.textColor(r11, r7, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r16 = r0.m4973unboximpl()
            r29 = r16
        L_0x0559:
            r7.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r28 = r0
            r58 = 16777214(0xfffffe, float:2.3509884E-38)
            r59 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r28.<init>((long) r29, (long) r31, (androidx.compose.ui.text.font.FontWeight) r33, (androidx.compose.ui.text.font.FontStyle) r34, (androidx.compose.ui.text.font.FontSynthesis) r35, (androidx.compose.ui.text.font.FontFamily) r36, (java.lang.String) r37, (long) r38, (androidx.compose.ui.text.style.BaselineShift) r40, (androidx.compose.ui.text.style.TextGeometricTransform) r41, (androidx.compose.ui.text.intl.LocaleList) r42, (long) r43, (androidx.compose.ui.text.style.TextDecoration) r45, (androidx.compose.ui.graphics.Shadow) r46, (androidx.compose.ui.graphics.drawscope.DrawStyle) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (androidx.compose.ui.text.PlatformTextStyle) r53, (androidx.compose.ui.text.style.LineHeightStyle) r54, (androidx.compose.ui.text.style.LineBreak) r55, (androidx.compose.ui.text.style.Hyphens) r56, (androidx.compose.ui.text.style.TextMotion) r57, (int) r58, (kotlin.jvm.internal.DefaultConstructorMarker) r59)
            androidx.compose.ui.text.TextStyle r28 = r9.merge((androidx.compose.ui.text.TextStyle) r0)
            r5 = r28
            androidx.compose.material.TextFieldDefaults r0 = androidx.compose.material.TextFieldDefaults.INSTANCE
            int r2 = r1 >> 9
            r2 = r2 & 14
            int r14 = r12 >> 24
            r14 = r14 & 112(0x70, float:1.57E-43)
            r2 = r2 | r14
            androidx.compose.runtime.State r2 = r3.backgroundColor(r11, r7, r2)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r14 = r2.m4973unboximpl()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r13, r14, r4)
            r14 = r27
            androidx.compose.foundation.interaction.InteractionSource r14 = (androidx.compose.foundation.interaction.InteractionSource) r14
            r15 = 48
            r16 = 0
            r17 = 0
            r18 = 0
            r73 = r0
            r74 = r2
            r75 = r11
            r76 = r6
            r77 = r14
            r78 = r3
            r79 = r17
            r80 = r18
            r81 = r15
            r82 = r16
            androidx.compose.ui.Modifier r0 = androidx.compose.material.TextFieldDefaults.m3168indicatorLinegv0btCI$default(r73, r74, r75, r76, r77, r78, r79, r80, r81, r82)
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r2 = r2.m3175getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r14 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r14 = r14.m3174getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2306defaultMinSizeVpY3zN4(r0, r2, r14)
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            r14 = r12 & 14
            int r15 = r12 >> 24
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.runtime.State r14 = r3.cursorColor(r6, r7, r14)
            java.lang.Object r14 = r14.getValue()
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r14 = r14.m4973unboximpl()
            r16 = r4
            r4 = 0
            r0.<init>(r14, r4)
            r14 = r0
            androidx.compose.ui.graphics.Brush r14 = (androidx.compose.ui.graphics.Brush) r14
            androidx.compose.material.TextFieldKt$TextField$7 r0 = new androidx.compose.material.TextFieldKt$TextField$7
            r73 = r0
            r74 = r71
            r76 = r26
            r77 = r23
            r78 = r27
            r79 = r6
            r80 = r65
            r81 = r20
            r82 = r21
            r83 = r22
            r84 = r3
            r85 = r1
            r86 = r12
            r73.<init>(r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)
            r4 = -126640971(0xfffffffff8739cb5, float:-1.9764165E34)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r7, r4, r15, r0)
            r15 = r0
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r0 = r1 & 14
            r4 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            r4 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = r1 & r62
            r0 = r0 | r4
            int r4 = r12 << 12
            r4 = r4 & r63
            r0 = r0 | r4
            int r4 = r12 << 12
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r17
            r0 = r0 | r4
            int r4 = r12 << 12
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r4 = r4 & r17
            r0 = r0 | r4
            int r4 = r12 << 12
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r17
            r17 = r0 | r4
            int r0 = r12 >> 18
            r0 = r0 & 14
            r4 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r4
            r4 = r12 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            int r4 = r12 >> 12
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r18 = r0 | r4
            r0 = 0
            r68 = r12
            r12 = r0
            r19 = 4096(0x1000, float:5.74E-42)
            r0 = r71
            r31 = r1
            r1 = r72
            r32 = r3
            r3 = r11
            r33 = r16
            r4 = r64
            r34 = r6
            r6 = r24
            r35 = r7
            r7 = r25
            r8 = r26
            r36 = r9
            r9 = r66
            r10 = r67
            r37 = r11
            r11 = r23
            r38 = r13
            r13 = r27
            r16 = r35
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06b4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06b4:
            r28 = r24
            r29 = r25
            r30 = r26
            r39 = r31
            r24 = r20
            r25 = r21
            r26 = r22
            r31 = r27
            r27 = r23
        L_0x06c6:
            androidx.compose.runtime.ScopeUpdateScope r15 = r35.endRestartGroup()
            if (r15 != 0) goto L_0x06cd
            goto L_0x070d
        L_0x06cd:
            androidx.compose.material.TextFieldKt$TextField$8 r40 = new androidx.compose.material.TextFieldKt$TextField$8
            r0 = r40
            r1 = r71
            r2 = r72
            r3 = r38
            r4 = r37
            r5 = r64
            r6 = r36
            r7 = r65
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r34
            r12 = r27
            r13 = r28
            r14 = r29
            r69 = r15
            r15 = r30
            r16 = r66
            r17 = r67
            r18 = r31
            r19 = r33
            r20 = r32
            r21 = r92
            r22 = r93
            r23 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r40
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r69
            r1.updateScope(r0)
        L_0x070d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d3, code lost:
        if (r10.changed((java.lang.Object) r85) != false) goto L_0x01da;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void TextField(androidx.compose.ui.text.input.TextFieldValue r72, kotlin.jvm.functions.Function1 r73, androidx.compose.ui.Modifier r74, boolean r75, boolean r76, androidx.compose.ui.text.TextStyle r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, boolean r82, androidx.compose.ui.text.input.VisualTransformation r83, androidx.compose.foundation.text.KeyboardOptions r84, androidx.compose.foundation.text.KeyboardActions r85, boolean r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r15 = r72
            r14 = r73
            r13 = r92
            r12 = r93
            r11 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1576622884(0xffffffffa206a4dc, float:-1.8247662E-18)
            r1 = r91
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)428@20681L7,439@21235L39,440@21313L14,441@21377L17,443@21403L408:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r92
            r1 = r93
            r2 = r11 & 1
            if (r2 == 0) goto L_0x002f
            r0 = r0 | 6
            goto L_0x003d
        L_0x002f:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003d
            boolean r2 = r10.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r0 = r0 | r2
        L_0x003d:
            r2 = r11 & 2
            if (r2 == 0) goto L_0x0044
            r0 = r0 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r0 = r0 | r2
        L_0x0054:
            r2 = r11 & 4
            if (r2 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            r9 = r74
            goto L_0x0073
        L_0x005d:
            r9 = r13 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0071
            r9 = r74
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r0 = r0 | r16
            goto L_0x0073
        L_0x0071:
            r9 = r74
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r3 = r75
            goto L_0x0096
        L_0x0080:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0094
            r3 = r75
            boolean r19 = r10.changed((boolean) r3)
            if (r19 == 0) goto L_0x008f
            r19 = r17
            goto L_0x0091
        L_0x008f:
            r19 = r18
        L_0x0091:
            r0 = r0 | r19
            goto L_0x0096
        L_0x0094:
            r3 = r75
        L_0x0096:
            r19 = r11 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x00a6
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r76
            goto L_0x00bc
        L_0x00a6:
            r22 = r13 & r64
            if (r22 != 0) goto L_0x00ba
            r4 = r76
            boolean r23 = r10.changed((boolean) r4)
            if (r23 == 0) goto L_0x00b5
            r23 = r20
            goto L_0x00b7
        L_0x00b5:
            r23 = r21
        L_0x00b7:
            r0 = r0 | r23
            goto L_0x00bc
        L_0x00ba:
            r4 = r76
        L_0x00bc:
            r65 = 458752(0x70000, float:6.42848E-40)
            r23 = r13 & r65
            r24 = 131072(0x20000, float:1.83671E-40)
            if (r23 != 0) goto L_0x00da
            r23 = r11 & 32
            if (r23 != 0) goto L_0x00d3
            r5 = r77
            boolean r25 = r10.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00d5
            r25 = r24
            goto L_0x00d7
        L_0x00d3:
            r5 = r77
        L_0x00d5:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00d7:
            r0 = r0 | r25
            goto L_0x00dc
        L_0x00da:
            r5 = r77
        L_0x00dc:
            r25 = r11 & 64
            r66 = 1572864(0x180000, float:2.204052E-39)
            r67 = 3670016(0x380000, float:5.142788E-39)
            if (r25 == 0) goto L_0x00e9
            r0 = r0 | r66
            r6 = r78
            goto L_0x00ff
        L_0x00e9:
            r26 = r13 & r67
            if (r26 != 0) goto L_0x00fd
            r6 = r78
            boolean r27 = r10.changedInstance(r6)
            if (r27 == 0) goto L_0x00f8
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fa
        L_0x00f8:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00fa:
            r0 = r0 | r27
            goto L_0x00ff
        L_0x00fd:
            r6 = r78
        L_0x00ff:
            r7 = r11 & 128(0x80, float:1.794E-43)
            r68 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x010c
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r28
            r8 = r79
            goto L_0x0122
        L_0x010c:
            r28 = r13 & r68
            if (r28 != 0) goto L_0x0120
            r8 = r79
            boolean r29 = r10.changedInstance(r8)
            if (r29 == 0) goto L_0x011b
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011d
        L_0x011b:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x011d:
            r0 = r0 | r29
            goto L_0x0122
        L_0x0120:
            r8 = r79
        L_0x0122:
            r3 = r11 & 256(0x100, float:3.59E-43)
            r69 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x012f
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r29
            r4 = r80
            goto L_0x0145
        L_0x012f:
            r29 = r13 & r69
            if (r29 != 0) goto L_0x0143
            r4 = r80
            boolean r29 = r10.changedInstance(r4)
            if (r29 == 0) goto L_0x013e
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0140
        L_0x013e:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0140:
            r0 = r0 | r29
            goto L_0x0145
        L_0x0143:
            r4 = r80
        L_0x0145:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0150
            r29 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r29
            r5 = r81
            goto L_0x0168
        L_0x0150:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0166
            r5 = r81
            boolean r29 = r10.changedInstance(r5)
            if (r29 == 0) goto L_0x0161
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0163
        L_0x0161:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0163:
            r0 = r0 | r29
            goto L_0x0168
        L_0x0166:
            r5 = r81
        L_0x0168:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0171
            r1 = r1 | 6
            r6 = r82
            goto L_0x0187
        L_0x0171:
            r29 = r12 & 14
            if (r29 != 0) goto L_0x0185
            r6 = r82
            boolean r29 = r10.changed((boolean) r6)
            if (r29 == 0) goto L_0x0180
            r22 = 4
            goto L_0x0182
        L_0x0180:
            r22 = 2
        L_0x0182:
            r1 = r1 | r22
            goto L_0x0187
        L_0x0185:
            r6 = r82
        L_0x0187:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0190
            r1 = r1 | 48
            r8 = r83
            goto L_0x01a6
        L_0x0190:
            r22 = r12 & 112(0x70, float:1.57E-43)
            if (r22 != 0) goto L_0x01a4
            r8 = r83
            boolean r22 = r10.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x019f
            r26 = 32
            goto L_0x01a1
        L_0x019f:
            r26 = 16
        L_0x01a1:
            r1 = r1 | r26
            goto L_0x01a6
        L_0x01a4:
            r8 = r83
        L_0x01a6:
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01af
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r84
            goto L_0x01c5
        L_0x01af:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01c3
            r9 = r84
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01be
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01c0
        L_0x01be:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01c0:
            r1 = r1 | r27
            goto L_0x01c5
        L_0x01c3:
            r9 = r84
        L_0x01c5:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01dd
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01d6
            r9 = r85
            boolean r22 = r10.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d6:
            r9 = r85
        L_0x01d8:
            r17 = r18
        L_0x01da:
            r1 = r1 | r17
            goto L_0x01df
        L_0x01dd:
            r9 = r85
        L_0x01df:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01e8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r86
            goto L_0x01fc
        L_0x01e8:
            r17 = r12 & r64
            if (r17 != 0) goto L_0x01fa
            r14 = r86
            boolean r17 = r10.changed((boolean) r14)
            if (r17 == 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r20 = r21
        L_0x01f7:
            r1 = r1 | r20
            goto L_0x01fc
        L_0x01fa:
            r14 = r86
        L_0x01fc:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020a
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r14 = r87
            goto L_0x0220
        L_0x020a:
            r18 = r12 & r65
            if (r18 != 0) goto L_0x021e
            r14 = r87
            boolean r18 = r10.changed((int) r14)
            if (r18 == 0) goto L_0x0219
            r18 = r24
            goto L_0x021b
        L_0x0219:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x021b:
            r1 = r1 | r18
            goto L_0x0220
        L_0x021e:
            r14 = r87
        L_0x0220:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r11 & r18
            if (r18 == 0) goto L_0x022b
            r1 = r1 | r66
            r14 = r88
            goto L_0x0241
        L_0x022b:
            r20 = r12 & r67
            if (r20 != 0) goto L_0x023f
            r14 = r88
            boolean r20 = r10.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x023a
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023c
        L_0x023a:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x023c:
            r1 = r1 | r20
            goto L_0x0241
        L_0x023f:
            r14 = r88
        L_0x0241:
            r20 = r12 & r68
            if (r20 != 0) goto L_0x025b
            r20 = r11 & r24
            if (r20 != 0) goto L_0x0254
            r14 = r89
            boolean r20 = r10.changed((java.lang.Object) r14)
            if (r20 == 0) goto L_0x0256
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0258
        L_0x0254:
            r14 = r89
        L_0x0256:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0258:
            r1 = r1 | r20
            goto L_0x025d
        L_0x025b:
            r14 = r89
        L_0x025d:
            r20 = r12 & r69
            if (r20 != 0) goto L_0x0279
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r11 & r20
            if (r20 != 0) goto L_0x0272
            r12 = r90
            boolean r20 = r10.changed((java.lang.Object) r12)
            if (r20 == 0) goto L_0x0274
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0276
        L_0x0272:
            r12 = r90
        L_0x0274:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0276:
            r1 = r1 | r20
            goto L_0x027b
        L_0x0279:
            r12 = r90
        L_0x027b:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r0 & r20
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x02c2
            r12 = 191739611(0xb6db6db, float:4.5782105E-32)
            r12 = r12 & r1
            r14 = 38347922(0x2492492, float:1.4777643E-37)
            if (r12 != r14) goto L_0x02c2
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x0295
            goto L_0x02c2
        L_0x0295:
            r10.skipToGroupEnd()
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r42 = r0
            r41 = r1
            r40 = r10
            goto L_0x058e
        L_0x02c2:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x033f
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x02d1
            goto L_0x033f
        L_0x02d1:
            r10.skipToGroupEnd()
            r2 = r11 & 32
            if (r2 == 0) goto L_0x02dc
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r2
        L_0x02dc:
            r2 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x02e2
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02e2:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x02ea
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
        L_0x02ea:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0319
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r14 = r0
            r13 = r1
            goto L_0x04e9
        L_0x0319:
            r24 = r74
            r25 = r75
            r26 = r76
            r27 = r77
            r28 = r78
            r29 = r79
            r30 = r80
            r31 = r81
            r32 = r82
            r33 = r83
            r34 = r84
            r35 = r85
            r36 = r86
            r70 = r87
            r37 = r88
            r38 = r89
            r39 = r90
            r14 = r0
            r13 = r1
            goto L_0x04e9
        L_0x033f:
            if (r2 == 0) goto L_0x0346
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0348
        L_0x0346:
            r2 = r74
        L_0x0348:
            if (r16 == 0) goto L_0x034c
            r12 = 1
            goto L_0x034e
        L_0x034c:
            r12 = r75
        L_0x034e:
            if (r19 == 0) goto L_0x0352
            r14 = 0
            goto L_0x0354
        L_0x0352:
            r14 = r76
        L_0x0354:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x037f
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material.TextKt.getLocalTextStyle()
            r74 = r2
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 6
            r19 = 0
            r75 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r12, r13)
            java.lang.Object r12 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r2 = r12
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r12 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r12
            goto L_0x0385
        L_0x037f:
            r74 = r2
            r75 = r12
            r2 = r77
        L_0x0385:
            if (r25 == 0) goto L_0x0389
            r12 = 0
            goto L_0x038b
        L_0x0389:
            r12 = r78
        L_0x038b:
            if (r7 == 0) goto L_0x038f
            r7 = 0
            goto L_0x0391
        L_0x038f:
            r7 = r79
        L_0x0391:
            if (r3 == 0) goto L_0x0395
            r3 = 0
            goto L_0x0397
        L_0x0395:
            r3 = r80
        L_0x0397:
            if (r4 == 0) goto L_0x039b
            r4 = 0
            goto L_0x039d
        L_0x039b:
            r4 = r81
        L_0x039d:
            if (r5 == 0) goto L_0x03a1
            r5 = 0
            goto L_0x03a3
        L_0x03a1:
            r5 = r82
        L_0x03a3:
            if (r6 == 0) goto L_0x03ac
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x03ae
        L_0x03ac:
            r6 = r83
        L_0x03ae:
            if (r8 == 0) goto L_0x03b7
            androidx.compose.foundation.text.KeyboardOptions$Companion r8 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r8 = r8.getDefault()
            goto L_0x03b9
        L_0x03b7:
            r8 = r84
        L_0x03b9:
            r13 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r13 == 0) goto L_0x03e7
            androidx.compose.foundation.text.KeyboardActions r13 = new androidx.compose.foundation.text.KeyboardActions
            r16 = 63
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r76 = r13
            r77 = r20
            r78 = r21
            r79 = r22
            r80 = r23
            r81 = r25
            r82 = r26
            r83 = r16
            r84 = r19
            r76.<init>(r77, r78, r79, r80, r81, r82, r83, r84)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03e9
        L_0x03e7:
            r13 = r85
        L_0x03e9:
            if (r9 == 0) goto L_0x03ed
            r9 = 0
            goto L_0x03ef
        L_0x03ed:
            r9 = r86
        L_0x03ef:
            if (r17 == 0) goto L_0x03f7
            r16 = 2147483647(0x7fffffff, float:NaN)
            r70 = r16
            goto L_0x03f9
        L_0x03f7:
            r70 = r87
        L_0x03f9:
            if (r18 == 0) goto L_0x0441
            r16 = 0
            r17 = 0
            r76 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r77 = r10
            r18 = 0
            r78 = r0
            java.lang.Object r0 = r77.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r91 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x0432
            r2 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r79 = r0
            r0 = r77
            r0.updateRememberedValue(r2)
            goto L_0x0438
        L_0x0432:
            r79 = r0
            r0 = r77
            r2 = r79
        L_0x0438:
            r10.endReplaceableGroup()
            r0 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0447
        L_0x0441:
            r76 = r0
            r91 = r2
            r0 = r88
        L_0x0447:
            r2 = r11 & r24
            if (r2 == 0) goto L_0x0459
            androidx.compose.material.TextFieldDefaults r2 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r77 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r2.getTextFieldShape(r10, r0)
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r2
            goto L_0x045d
        L_0x0459:
            r77 = r0
            r0 = r89
        L_0x045d:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r11
            if (r2 == 0) goto L_0x04c6
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
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
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r59 = r10
            androidx.compose.material.TextFieldColors r2 = r16.m3180textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r16
            r24 = r74
            r25 = r75
            r37 = r77
            r27 = r91
            r38 = r0
            r39 = r2
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r36 = r9
            r28 = r12
            r35 = r13
            r26 = r14
            r14 = r76
            r13 = r1
            goto L_0x04e9
        L_0x04c6:
            r24 = r74
            r25 = r75
            r37 = r77
            r39 = r90
            r27 = r91
            r38 = r0
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r29 = r7
            r34 = r8
            r36 = r9
            r28 = r12
            r35 = r13
            r26 = r14
            r14 = r76
            r13 = r1
        L_0x04e9:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04fa
            r0 = -1576622884(0xffffffffa206a4dc, float:-1.8247662E-18)
            java.lang.String r1 = "androidx.compose.material.TextField (TextField.kt:422)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r13, r1)
        L_0x04fa:
            r0 = r14 & 14
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r14 & r64
            r0 = r0 | r1
            r1 = r14 & r65
            r0 = r0 | r1
            r1 = r14 & r67
            r0 = r0 | r1
            r1 = r14 & r68
            r0 = r0 | r1
            r1 = r14 & r69
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r14
            r21 = r0 | r1
            r0 = r13 & 14
            r0 = r0 | r66
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r13 & r64
            r0 = r0 | r1
            r1 = r13 & r65
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & r68
            r0 = r0 | r1
            int r1 = r13 << 3
            r1 = r1 & r69
            r0 = r0 | r1
            int r1 = r13 << 3
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r22 = r0 | r1
            r16 = 1
            r23 = 0
            r0 = r72
            r1 = r73
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r40 = r10
            r10 = r32
            r11 = r33
            r12 = r34
            r41 = r13
            r13 = r35
            r42 = r14
            r14 = r36
            r15 = r70
            r17 = r37
            r18 = r38
            r19 = r39
            r20 = r40
            TextField((androidx.compose.ui.text.input.TextFieldValue) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (boolean) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (androidx.compose.foundation.text.KeyboardOptions) r12, (androidx.compose.foundation.text.KeyboardActions) r13, (boolean) r14, (int) r15, (int) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Shape) r18, (androidx.compose.material.TextFieldColors) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x058e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x058e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r40.endRestartGroup()
            if (r15 != 0) goto L_0x0595
            goto L_0x05d3
        L_0x0595:
            androidx.compose.material.TextFieldKt$TextField$10 r23 = new androidx.compose.material.TextFieldKt$TextField$10
            r0 = r23
            r1 = r72
            r2 = r73
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r71 = r15
            r15 = r36
            r16 = r70
            r17 = r37
            r18 = r38
            r19 = r39
            r20 = r92
            r21 = r93
            r22 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r71
            r1.updateScope(r0)
        L_0x05d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0551  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0556  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x05b9  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0707  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x077f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x078b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0791  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x07c4  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x07da  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0874  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0266  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextFieldLayout(androidx.compose.ui.Modifier r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, boolean r58, float r59, androidx.compose.foundation.layout.PaddingValues r60, androidx.compose.runtime.Composer r61, int r62) {
        /*
            r11 = r52
            r12 = r53
            r13 = r54
            r14 = r55
            r15 = r56
            r10 = r57
            r9 = r58
            r8 = r59
            r7 = r60
            r6 = r62
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "textField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "paddingValues"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -2112507061(0xffffffff8215b34b, float:-1.0998246E-37)
            r1 = r61
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TextFieldLayout)P(3,7,1,5,2,8,6)483@22341L139,486@22528L7,487@22540L1853:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r62
            r2 = r6 & 14
            if (r2 != 0) goto L_0x0044
            boolean r2 = r5.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0042
            r2 = 4
            goto L_0x0043
        L_0x0042:
            r2 = 2
        L_0x0043:
            r1 = r1 | r2
        L_0x0044:
            r2 = r6 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r5.changedInstance(r12)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r6 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0064
            boolean r2 = r5.changedInstance(r13)
            if (r2 == 0) goto L_0x0061
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r2
        L_0x0064:
            r2 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0074
            boolean r2 = r5.changedInstance(r14)
            if (r2 == 0) goto L_0x0071
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r1 = r1 | r2
        L_0x0074:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x0086
            boolean r2 = r5.changedInstance(r15)
            if (r2 == 0) goto L_0x0083
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0085
        L_0x0083:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0085:
            r1 = r1 | r2
        L_0x0086:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x0097
            boolean r2 = r5.changedInstance(r10)
            if (r2 == 0) goto L_0x0094
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0096
        L_0x0094:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x0096:
            r1 = r1 | r2
        L_0x0097:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x00a8
            boolean r2 = r5.changed((boolean) r9)
            if (r2 == 0) goto L_0x00a5
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00a7
        L_0x00a5:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x00a7:
            r1 = r1 | r2
        L_0x00a8:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x00b9
            boolean r2 = r5.changed((float) r8)
            if (r2 == 0) goto L_0x00b6
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b8
        L_0x00b6:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b8:
            r1 = r1 | r2
        L_0x00b9:
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x00ca
            boolean r2 = r5.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x00c7
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00c9
        L_0x00c7:
            r2 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00c9:
            r1 = r1 | r2
        L_0x00ca:
            r4 = r1
            r1 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r1 & r4
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r2) goto L_0x00e3
            boolean r1 = r5.getSkipping()
            if (r1 != 0) goto L_0x00db
            goto L_0x00e3
        L_0x00db:
            r5.skipToGroupEnd()
            r36 = r5
            r1 = r12
            goto L_0x0877
        L_0x00e3:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00ef
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.TextFieldLayout (TextField.kt:472)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r1, r2)
        L_0x00ef:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r58)
            java.lang.Float r1 = java.lang.Float.valueOf(r59)
            int r2 = r4 >> 18
            r2 = r2 & 14
            int r3 = r4 >> 18
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r4 >> 18
            r3 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = 0
            r61 = r2
            r2 = 1618982084(0x607fb4c4, float:7.370227E19)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            boolean r2 = r5.changed((java.lang.Object) r0)
            boolean r16 = r5.changed((java.lang.Object) r1)
            r2 = r2 | r16
            boolean r16 = r5.changed((java.lang.Object) r7)
            r2 = r2 | r16
            r16 = r5
            r17 = 0
            r18 = r0
            java.lang.Object r0 = r16.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x0142
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r0 != r1) goto L_0x013d
            goto L_0x0144
        L_0x013d:
            r20 = r0
            r1 = r16
            goto L_0x0153
        L_0x0142:
            r21 = r1
        L_0x0144:
            r1 = 0
            r20 = r0
            androidx.compose.material.TextFieldMeasurePolicy r0 = new androidx.compose.material.TextFieldMeasurePolicy
            r0.<init>(r9, r8, r7)
            r1 = r16
            r1.updateRememberedValue(r0)
        L_0x0153:
            r5.endReplaceableGroup()
            androidx.compose.material.TextFieldMeasurePolicy r0 = (androidx.compose.material.TextFieldMeasurePolicy) r0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            r61 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            r16 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r3)
            java.lang.Object r2 = r5.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r1 = r2
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            int r2 = r4 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r3 = 0
            r61 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            r6 = 0
            int r17 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r19 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r20 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r52)
            int r8 = r2 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r21 = r20
            r20 = r19
            r19 = 0
            r22 = r2
            androidx.compose.runtime.Applier r2 = r5.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x01b7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b7:
            r5.startReusableNode()
            boolean r2 = r5.getInserting()
            if (r2 == 0) goto L_0x01c6
            r2 = r20
            r5.createNode(r2)
            goto L_0x01cb
        L_0x01c6:
            r2 = r20
            r5.useNode()
        L_0x01cb:
            r20 = r2
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r5)
            r23 = 0
            r9 = r0
            androidx.compose.ui.layout.MeasurePolicy r9 = (androidx.compose.ui.layout.MeasurePolicy) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r24 = androidx.compose.ui.node.ComposeUiNode.Companion
            r25 = r0
            kotlin.jvm.functions.Function2 r0 = r24.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r9, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetCompositeKeyHash()
            r9 = 0
            r24 = r2
            r26 = 0
            boolean r27 = r24.getInserting()
            if (r27 != 0) goto L_0x0211
            r27 = r6
            java.lang.Object r6 = r24.rememberedValue()
            r28 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)
            if (r6 != 0) goto L_0x020e
            goto L_0x0215
        L_0x020e:
            r9 = r24
            goto L_0x0225
        L_0x0211:
            r27 = r6
            r28 = r9
        L_0x0215:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            r9 = r24
            r9.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            r2.apply(r6, r0)
        L_0x0225:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r2 = r8 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6 = r21
            r6.invoke(r0, r5, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r0)
            int r2 = r8 >> 9
            r2 = r2 & 14
            r9 = r5
            r21 = 0
            r0 = 254819681(0xf303d61, float:8.689291E-30)
            r24 = r2
            java.lang.String r2 = "C529@24155L183:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r0, r2)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "491@22648L219"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            java.lang.String r2 = "C71@3331L9:Box.kt#2w3rfo"
            java.lang.String r0 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            r29 = r6
            if (r15 == 0) goto L_0x03ba
            androidx.compose.ui.Modifier$Companion r30 = androidx.compose.ui.Modifier.Companion
            r6 = r30
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r30 = r8
            java.lang.String r8 = "Leading"
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r6, r8)
            androidx.compose.ui.Modifier r8 = androidx.compose.material.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r6 = r6.then(r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getCenter()
            r26 = 48
            r32 = r26
            r33 = 0
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r11 = 0
            int r34 = r32 >> 3
            r34 = r34 & 14
            int r35 = r32 >> 3
            r35 = r35 & 112(0x70, float:1.57E-43)
            r36 = r5
            r5 = r34 | r35
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r11, r9, r5)
            int r34 = r32 << 3
            r34 = r34 & 112(0x70, float:1.57E-43)
            r35 = 0
            r37 = r8
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            r8 = 0
            int r38 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r8)
            androidx.compose.runtime.CompositionLocalMap r8 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r39 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r39 = r39.getConstructor()
            kotlin.jvm.functions.Function3 r40 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r6)
            r41 = r6
            int r6 = r34 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | 6
            r42 = r39
            r39 = r40
            r40 = 0
            r43 = r11
            androidx.compose.runtime.Applier r11 = r9.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x02e2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02e2:
            r9.startReusableNode()
            boolean r11 = r9.getInserting()
            if (r11 == 0) goto L_0x02f1
            r11 = r42
            r9.createNode(r11)
            goto L_0x02f6
        L_0x02f1:
            r11 = r42
            r9.useNode()
        L_0x02f6:
            r42 = r11
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r44 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r45 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r45.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r5, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r8, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetCompositeKeyHash()
            r45 = 0
            r46 = r11
            r47 = 0
            boolean r48 = r46.getInserting()
            if (r48 != 0) goto L_0x0338
            r48 = r5
            java.lang.Object r5 = r46.rememberedValue()
            r49 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r38)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 != 0) goto L_0x0335
            goto L_0x033c
        L_0x0335:
            r8 = r46
            goto L_0x034c
        L_0x0338:
            r48 = r5
            r49 = r8
        L_0x033c:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r38)
            r8 = r46
            r8.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r38)
            r11.apply(r5, r12)
        L_0x034c:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r5)
            int r8 = r6 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r11 = r39
            r11.invoke(r5, r9, r8)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r5)
            int r5 = r6 >> 9
            r5 = r5 & 14
            r8 = r9
            r12 = 0
            r39 = r5
            r5 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r5, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r44 = r32 >> 6
            r44 = r44 & 112(0x70, float:1.57E-43)
            r44 = r44 | 6
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r45 = r8
            r46 = 0
            r47 = r5
            r5 = -1767364503(0xffffffff96a82869, float:-2.7167366E-25)
            r50 = r6
            java.lang.String r6 = "C495@22840L9:TextField.kt#jmzs0o"
            r51 = r11
            r11 = r45
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            int r5 = r4 >> 12
            r5 = r5 & 14
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r15.invoke(r11, r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            goto L_0x03be
        L_0x03ba:
            r36 = r5
            r30 = r8
        L_0x03be:
            r9.endReplaceableGroup()
            r5 = 254819966(0xf303e7e, float:8.6895055E-30)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "499@22934L221"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            if (r10 == 0) goto L_0x051d
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            java.lang.String r6 = "Trailing"
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r5, r6)
            androidx.compose.ui.Modifier r6 = androidx.compose.material.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r5 = r5.then(r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getCenter()
            r8 = 48
            r11 = 0
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r12 = 0
            int r26 = r8 >> 3
            r26 = r26 & 14
            int r32 = r8 >> 3
            r32 = r32 & 112(0x70, float:1.57E-43)
            r33 = r11
            r11 = r26 | r32
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r12, r9, r11)
            int r26 = r8 << 3
            r26 = r26 & 112(0x70, float:1.57E-43)
            r32 = 0
            r34 = r6
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            r6 = 0
            int r35 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r37 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r37 = r37.getConstructor()
            kotlin.jvm.functions.Function3 r38 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r5)
            r39 = r5
            int r5 = r26 << 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | 6
            r40 = r37
            r37 = r38
            r38 = 0
            r41 = r12
            androidx.compose.runtime.Applier r12 = r9.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0443
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0443:
            r9.startReusableNode()
            boolean r12 = r9.getInserting()
            if (r12 == 0) goto L_0x0452
            r12 = r40
            r9.createNode(r12)
            goto L_0x0457
        L_0x0452:
            r12 = r40
            r9.useNode()
        L_0x0457:
            r40 = r12
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r42 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r43 = androidx.compose.ui.node.ComposeUiNode.Companion
            r44 = r3
            kotlin.jvm.functions.Function2 r3 = r43.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r11, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r6, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r43 = 0
            r45 = r12
            r46 = 0
            boolean r47 = r45.getInserting()
            if (r47 != 0) goto L_0x049b
            r47 = r6
            java.lang.Object r6 = r45.rememberedValue()
            r48 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r35)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r11)
            if (r6 != 0) goto L_0x0498
            goto L_0x049f
        L_0x0498:
            r11 = r45
            goto L_0x04af
        L_0x049b:
            r47 = r6
            r48 = r11
        L_0x049f:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r35)
            r11 = r45
            r11.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r35)
            r12.apply(r6, r3)
        L_0x04af:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r6 = r5 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r11 = r37
            r11.invoke(r3, r9, r6)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r3)
            int r3 = r5 >> 9
            r3 = r3 & 14
            r6 = r9
            r12 = 0
            r37 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r42 = r8 >> 6
            r42 = r42 & 112(0x70, float:1.57E-43)
            r42 = r42 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r43 = r6
            r45 = 0
            r46 = r3
            r3 = -1767364216(0xffffffff96a82988, float:-2.7168074E-25)
            r49 = r5
            java.lang.String r5 = "C503@23127L10:TextField.kt#jmzs0o"
            r50 = r8
            r8 = r43
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r5)
            int r3 = r4 >> 15
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r10.invoke(r8, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            goto L_0x051f
        L_0x051d:
            r44 = r3
        L_0x051f:
            r9.endReplaceableGroup()
            float r3 = androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(r7, r1)
            float r5 = androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(r7, r1)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r37 = r6
            androidx.compose.ui.Modifier r37 = (androidx.compose.ui.Modifier) r37
            if (r15 == 0) goto L_0x0551
            float r6 = androidx.compose.material.TextFieldImplKt.getHorizontalIconPadding()
            r8 = 0
            float r11 = r3 - r6
            float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r11)
            r8 = 0
            r11 = 0
            float r12 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r12)
            r11 = 0
            float r12 = kotlin.ranges.RangesKt.coerceAtLeast((float) r6, (float) r8)
            float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r12)
            r38 = r6
            goto L_0x0553
        L_0x0551:
            r38 = r3
        L_0x0553:
            if (r10 == 0) goto L_0x0575
            float r6 = androidx.compose.material.TextFieldImplKt.getHorizontalIconPadding()
            r8 = 0
            float r11 = r5 - r6
            float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r11)
            r8 = 0
            r11 = 0
            float r12 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r12)
            r11 = 0
            float r12 = kotlin.ranges.RangesKt.coerceAtLeast((float) r6, (float) r8)
            float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r12)
            r40 = r6
            goto L_0x0577
        L_0x0575:
            r40 = r5
        L_0x0577:
            r42 = 10
            r43 = 0
            r39 = 0
            r41 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r37, r38, r39, r40, r41, r42, r43)
            r8 = 254820977(0xf304271, float:8.690266E-30)
            r9.startReplaceableGroup(r8)
            java.lang.String r8 = "524@23948L59"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r8)
            if (r14 == 0) goto L_0x05a9
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            java.lang.String r11 = "Hint"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r11)
            androidx.compose.ui.Modifier r8 = r8.then(r6)
            int r11 = r4 >> 6
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r14.invoke(r8, r9, r11)
        L_0x05a9:
            r9.endReplaceableGroup()
            r8 = 254821106(0xf3042f2, float:8.690363E-30)
            r9.startReplaceableGroup(r8)
            java.lang.String r8 = "527@24071L57"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r8)
            if (r13 == 0) goto L_0x0707
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            java.lang.String r11 = "Label"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r8, r11)
            androidx.compose.ui.Modifier r8 = r8.then(r6)
            r11 = 0
            r12 = 0
            r26 = r1
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r32 = r3
            r3 = 0
            int r33 = r11 >> 3
            r33 = r33 & 14
            int r34 = r11 >> 3
            r34 = r34 & 112(0x70, float:1.57E-43)
            r35 = r5
            r5 = r33 | r34
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r3, r9, r5)
            int r33 = r11 << 3
            r33 = r33 & 112(0x70, float:1.57E-43)
            r34 = 0
            r37 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r1)
            r1 = r44
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r38 = r3
            r3 = 0
            int r39 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r3)
            androidx.compose.runtime.CompositionLocalMap r3 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r40 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r40 = r40.getConstructor()
            kotlin.jvm.functions.Function3 r41 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r8)
            int r7 = r33 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 6
            r42 = r40
            r40 = r41
            r41 = 0
            r43 = r8
            androidx.compose.runtime.Applier r8 = r9.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0630
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0630:
            r9.startReusableNode()
            boolean r8 = r9.getInserting()
            if (r8 == 0) goto L_0x063f
            r8 = r42
            r9.createNode(r8)
            goto L_0x0644
        L_0x063f:
            r8 = r42
            r9.useNode()
        L_0x0644:
            r42 = r8
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r44 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r45 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r45.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r8, r3, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetCompositeKeyHash()
            r45 = 0
            r46 = r8
            r47 = 0
            boolean r48 = r46.getInserting()
            if (r48 != 0) goto L_0x0686
            r48 = r3
            java.lang.Object r3 = r46.rememberedValue()
            r49 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r39)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x0683
            goto L_0x068a
        L_0x0683:
            r5 = r46
            goto L_0x069a
        L_0x0686:
            r48 = r3
            r49 = r5
        L_0x068a:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r39)
            r5 = r46
            r5.updateRememberedValue(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r39)
            r8.apply(r3, r10)
        L_0x069a:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r5 = r7 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8 = r40
            r8.invoke(r3, r9, r5)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r3)
            int r3 = r7 >> 9
            r3 = r3 & 14
            r5 = r9
            r10 = 0
            r40 = r3
            r3 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r44 = r11 >> 6
            r44 = r44 & 112(0x70, float:1.57E-43)
            r44 = r44 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r45 = r5
            r46 = 0
            r47 = r3
            r3 = -1767363224(0xffffffff96a82d68, float:-2.717052E-25)
            r50 = r7
            java.lang.String r7 = "C527@24119L7:TextField.kt#jmzs0o"
            r51 = r8
            r8 = r45
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r7)
            int r3 = r4 >> 6
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r13.invoke(r8, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            goto L_0x070f
        L_0x0707:
            r26 = r1
            r32 = r3
            r35 = r5
            r1 = r44
        L_0x070f:
            r9.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            java.lang.String r5 = "TextField"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r5)
            androidx.compose.ui.Modifier r3 = r3.then(r6)
            r5 = 384(0x180, float:5.38E-43)
            r7 = 1
            r8 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            int r10 = r5 >> 3
            r10 = r10 & 14
            int r11 = r5 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r7, r9, r10)
            int r11 = r5 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 0
            r31 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r0 = 0
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r0)
            androidx.compose.runtime.CompositionLocalMap r1 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r18 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            r33 = r3
            int r3 = r11 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | 6
            r34 = r16
            r16 = r18
            r18 = 0
            r37 = r6
            androidx.compose.runtime.Applier r6 = r9.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0782
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0782:
            r9.startReusableNode()
            boolean r6 = r9.getInserting()
            if (r6 == 0) goto L_0x0791
            r6 = r34
            r9.createNode(r6)
            goto L_0x0796
        L_0x0791:
            r6 = r34
            r9.useNode()
        L_0x0796:
            r34 = r6
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r38 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r39 = androidx.compose.ui.node.ComposeUiNode.Companion
            r40 = r7
            kotlin.jvm.functions.Function2 r7 = r39.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r10, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r39 = 0
            r41 = r6
            r42 = 0
            boolean r43 = r41.getInserting()
            if (r43 != 0) goto L_0x07da
            r43 = r1
            java.lang.Object r1 = r41.rememberedValue()
            r44 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r8)
            if (r1 != 0) goto L_0x07d7
            goto L_0x07de
        L_0x07d7:
            r8 = r41
            goto L_0x07ee
        L_0x07da:
            r43 = r1
            r44 = r8
        L_0x07de:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r8 = r41
            r8.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r6.apply(r1, r7)
        L_0x07ee:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r6 = r3 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = r16
            r7.invoke(r1, r9, r6)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r1)
            int r1 = r3 >> 9
            r1 = r1 & 14
            r6 = r9
            r8 = 0
            r16 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r5 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r23 = r6
            r28 = 0
            r38 = r0
            r0 = -1767363030(0xffffffff96a82e2a, float:-2.7170997E-25)
            r39 = r1
            java.lang.String r1 = "C533@24313L11:TextField.kt#jmzs0o"
            r41 = r2
            r2 = r23
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            int r0 = r4 >> 3
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r53
            r1.invoke(r2, r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r36.endReplaceableGroup()
            r36.endNode()
            r36.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0877
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0877:
            androidx.compose.runtime.ScopeUpdateScope r11 = r36.endRestartGroup()
            if (r11 != 0) goto L_0x0882
            r16 = r4
            r17 = r36
            goto L_0x08a5
        L_0x0882:
            androidx.compose.material.TextFieldKt$TextFieldLayout$2 r12 = new androidx.compose.material.TextFieldKt$TextFieldLayout$2
            r0 = r12
            r1 = r52
            r2 = r53
            r3 = r54
            r16 = r4
            r4 = r55
            r17 = r36
            r5 = r56
            r6 = r57
            r7 = r58
            r8 = r59
            r9 = r60
            r10 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x08a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m3192calculateWidthVsPV1Ek(int leadingWidth, int trailingWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        return Math.max(leadingWidth + Math.max(textFieldWidth, Math.max(labelWidth, placeholderWidth)) + trailingWidth, Constraints.m7500getMinWidthimpl(constraints));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw  reason: not valid java name */
    public static final int m3191calculateHeightO3s9Psw(int textFieldHeight, boolean hasLabel, int labelBaseline, int leadingHeight, int trailingHeight, int placeholderHeight, long constraints, float density, PaddingValues paddingValues) {
        float middleSectionHeight;
        float paddingToLabel = TextFieldTopPadding * density;
        float topPaddingValue = paddingValues.m2265calculateTopPaddingD9Ej5fM() * density;
        float bottomPaddingValue = paddingValues.m2262calculateBottomPaddingD9Ej5fM() * density;
        int i = textFieldHeight;
        int inputFieldHeight = Math.max(textFieldHeight, placeholderHeight);
        if (hasLabel) {
            middleSectionHeight = ((float) labelBaseline) + paddingToLabel + ((float) inputFieldHeight) + bottomPaddingValue;
        } else {
            int i2 = labelBaseline;
            middleSectionHeight = ((float) inputFieldHeight) + topPaddingValue + bottomPaddingValue;
        }
        return Math.max(MathKt.roundToInt(middleSectionHeight), Math.max(Math.max(leadingHeight, trailingHeight), Constraints.m7499getMinHeightimpl(constraints)));
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int height, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int i;
        int i2 = height;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i2), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i2), 0.0f, 4, (Object) null);
        }
        if (labelPlaceable != null) {
            Placeable it = labelPlaceable;
            if (singleLine) {
                i = Alignment.Companion.getCenterVertically().align(it.getHeight(), i2);
            } else {
                i = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int startPosition = i;
            Placeable.PlacementScope placementScope = $this$placeWithLabel;
            Placeable.PlacementScope.placeRelative$default(placementScope, it, TextFieldImplKt.widthOrZero(leadingPlaceable), startPosition - MathKt.roundToInt(((float) (startPosition - labelEndPosition)) * animationProgress), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int height, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        int textVerticalPosition;
        int placeholderVerticalPosition;
        int i = height;
        int topPadding = MathKt.roundToInt(paddingValues.m2265calculateTopPaddingD9Ej5fM() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), i), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), i), 0.0f, 4, (Object) null);
        }
        if (singleLine) {
            textVerticalPosition = Alignment.Companion.getCenterVertically().align(textPlaceable.getHeight(), i);
        } else {
            textVerticalPosition = topPadding;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable it = placeholderPlaceable;
            if (singleLine) {
                placeholderVerticalPosition = Alignment.Companion.getCenterVertically().align(placeholderPlaceable.getHeight(), i);
            } else {
                placeholderVerticalPosition = topPadding;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, it, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, (Object) null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter($this$drawIndicatorLine, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new TextFieldKt$drawIndicatorLine$1(indicatorBorder.m1903getWidthD9Ej5fM(), indicatorBorder));
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
