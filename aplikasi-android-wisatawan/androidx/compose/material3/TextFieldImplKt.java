package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a<\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u0012\u0010R\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u0012\u0010U\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u0019\u0010\u0011\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0019\u0010\u0013\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0019\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007\"\u000e\u0010\u001b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u001d\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007\"\u000e\u0010\u001f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010 \u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007\"\u000e\u0010\"\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010#\u001a\u00020$X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    private static final float HorizontalIconPadding = Dp.m5844constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m596defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m5844constructorimpl((float) 48), Dp.m5844constructorimpl((float) 48));
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight = Dp.m5844constructorimpl((float) 16);
    private static final float MinSupportingTextLineHeight = Dp.m5844constructorimpl((float) 16);
    private static final float MinTextLineHeight = Dp.m5844constructorimpl((float) 24);
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    private static final float PrefixSuffixTextPadding = Dp.m5844constructorimpl((float) 2);
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = Dp.m5844constructorimpl((float) 4);
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = Dp.m5844constructorimpl((float) 16);
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    /* JADX WARNING: Removed duplicated region for block: B:166:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x052a  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0536  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CommonDecorationBox(androidx.compose.material3.TextFieldType r51, java.lang.String r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.ui.text.input.VisualTransformation r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, boolean r62, boolean r63, boolean r64, androidx.compose.foundation.interaction.InteractionSource r65, androidx.compose.foundation.layout.PaddingValues r66, androidx.compose.material3.TextFieldColors r67, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, androidx.compose.runtime.Composer r69, int r70, int r71, int r72) {
        /*
            r15 = r51
            r14 = r52
            r13 = r53
            r12 = r54
            r11 = r55
            r10 = r65
            r9 = r66
            r8 = r67
            r7 = r68
            r6 = r70
            r5 = r71
            r4 = r72
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -947035500(0xffffffffc78d6294, float:-72389.16)
            r1 = r69
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)81@3217L105,85@3372L25,96@3756L10,103@4099L7282:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r1 = r70
            r2 = r71
            r16 = r4 & 1
            r17 = 4
            r18 = 2
            if (r16 == 0) goto L_0x0062
            r1 = r1 | 6
            goto L_0x0073
        L_0x0062:
            r16 = r6 & 14
            if (r16 != 0) goto L_0x0073
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x006f
            r16 = r17
            goto L_0x0071
        L_0x006f:
            r16 = r18
        L_0x0071:
            r1 = r1 | r16
        L_0x0073:
            r16 = r4 & 2
            r19 = 32
            r20 = 16
            if (r16 == 0) goto L_0x007e
            r1 = r1 | 48
            goto L_0x008f
        L_0x007e:
            r16 = r6 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x008f
            boolean r16 = r3.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x008b
            r16 = r19
            goto L_0x008d
        L_0x008b:
            r16 = r20
        L_0x008d:
            r1 = r1 | r16
        L_0x008f:
            r16 = r4 & 4
            r21 = 256(0x100, float:3.59E-43)
            r22 = 128(0x80, float:1.794E-43)
            if (r16 == 0) goto L_0x009a
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x00aa
        L_0x009a:
            r0 = r6 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x00aa
            boolean r0 = r3.changedInstance(r13)
            if (r0 == 0) goto L_0x00a7
            r0 = r21
            goto L_0x00a9
        L_0x00a7:
            r0 = r22
        L_0x00a9:
            r1 = r1 | r0
        L_0x00aa:
            r0 = r4 & 8
            r23 = 2048(0x800, float:2.87E-42)
            r24 = 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x00b5
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00c5
        L_0x00b5:
            r0 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x00c5
            boolean r0 = r3.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x00c2
            r0 = r23
            goto L_0x00c4
        L_0x00c2:
            r0 = r24
        L_0x00c4:
            r1 = r1 | r0
        L_0x00c5:
            r0 = r4 & 16
            r25 = 16384(0x4000, float:2.2959E-41)
            r26 = 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x00d0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00e2
        L_0x00d0:
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r6
            if (r0 != 0) goto L_0x00e2
            boolean r0 = r3.changedInstance(r11)
            if (r0 == 0) goto L_0x00df
            r0 = r25
            goto L_0x00e1
        L_0x00df:
            r0 = r26
        L_0x00e1:
            r1 = r1 | r0
        L_0x00e2:
            r0 = r4 & 32
            r27 = 131072(0x20000, float:1.83671E-40)
            r28 = 65536(0x10000, float:9.18355E-41)
            if (r0 == 0) goto L_0x00f1
            r29 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r29
            r13 = r56
            goto L_0x0109
        L_0x00f1:
            r29 = 458752(0x70000, float:6.42848E-40)
            r29 = r6 & r29
            if (r29 != 0) goto L_0x0107
            r13 = r56
            boolean r29 = r3.changedInstance(r13)
            if (r29 == 0) goto L_0x0102
            r29 = r27
            goto L_0x0104
        L_0x0102:
            r29 = r28
        L_0x0104:
            r1 = r1 | r29
            goto L_0x0109
        L_0x0107:
            r13 = r56
        L_0x0109:
            r29 = r4 & 64
            if (r29 == 0) goto L_0x0114
            r30 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r30
            r13 = r57
            goto L_0x012c
        L_0x0114:
            r30 = 3670016(0x380000, float:5.142788E-39)
            r30 = r6 & r30
            if (r30 != 0) goto L_0x012a
            r13 = r57
            boolean r30 = r3.changedInstance(r13)
            if (r30 == 0) goto L_0x0125
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0127
        L_0x0125:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x0127:
            r1 = r1 | r30
            goto L_0x012c
        L_0x012a:
            r13 = r57
        L_0x012c:
            r13 = r4 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0137
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r30
            r15 = r58
            goto L_0x014f
        L_0x0137:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r6 & r30
            if (r30 != 0) goto L_0x014d
            r15 = r58
            boolean r30 = r3.changedInstance(r15)
            if (r30 == 0) goto L_0x0148
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x014a
        L_0x0148:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x014a:
            r1 = r1 | r30
            goto L_0x014f
        L_0x014d:
            r15 = r58
        L_0x014f:
            r15 = r4 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x015a
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r30
            r11 = r59
            goto L_0x0172
        L_0x015a:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r6 & r30
            if (r30 != 0) goto L_0x0170
            r11 = r59
            boolean r30 = r3.changedInstance(r11)
            if (r30 == 0) goto L_0x016b
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x016d
        L_0x016b:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x016d:
            r1 = r1 | r30
            goto L_0x0172
        L_0x0170:
            r11 = r59
        L_0x0172:
            r11 = r4 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x017d
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r30
            r6 = r60
            goto L_0x0195
        L_0x017d:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r6 & r30
            if (r30 != 0) goto L_0x0193
            r6 = r60
            boolean r30 = r3.changedInstance(r6)
            if (r30 == 0) goto L_0x018e
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0190
        L_0x018e:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0190:
            r1 = r1 | r30
            goto L_0x0195
        L_0x0193:
            r6 = r60
        L_0x0195:
            r6 = r4 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x019e
            r2 = r2 | 6
            r12 = r61
            goto L_0x01b2
        L_0x019e:
            r30 = r5 & 14
            if (r30 != 0) goto L_0x01b0
            r12 = r61
            boolean r30 = r3.changedInstance(r12)
            if (r30 == 0) goto L_0x01ab
            goto L_0x01ad
        L_0x01ab:
            r17 = r18
        L_0x01ad:
            r2 = r2 | r17
            goto L_0x01b2
        L_0x01b0:
            r12 = r61
        L_0x01b2:
            r12 = r4 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x01bb
            r2 = r2 | 48
            r14 = r62
            goto L_0x01cf
        L_0x01bb:
            r17 = r5 & 112(0x70, float:1.57E-43)
            if (r17 != 0) goto L_0x01cd
            r14 = r62
            boolean r17 = r3.changed((boolean) r14)
            if (r17 == 0) goto L_0x01c8
            goto L_0x01ca
        L_0x01c8:
            r19 = r20
        L_0x01ca:
            r2 = r2 | r19
            goto L_0x01cf
        L_0x01cd:
            r14 = r62
        L_0x01cf:
            r14 = r4 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x01da
            r2 = r2 | 384(0x180, float:5.38E-43)
            r17 = r14
            r14 = r63
            goto L_0x01f0
        L_0x01da:
            r17 = r14
            r14 = r5 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x01ee
            r14 = r63
            boolean r18 = r3.changed((boolean) r14)
            if (r18 == 0) goto L_0x01e9
            goto L_0x01eb
        L_0x01e9:
            r21 = r22
        L_0x01eb:
            r2 = r2 | r21
            goto L_0x01f0
        L_0x01ee:
            r14 = r63
        L_0x01f0:
            r14 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x01fb
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r18 = r14
            r14 = r64
            goto L_0x0211
        L_0x01fb:
            r18 = r14
            r14 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x020f
            r14 = r64
            boolean r19 = r3.changed((boolean) r14)
            if (r19 == 0) goto L_0x020a
            goto L_0x020c
        L_0x020a:
            r23 = r24
        L_0x020c:
            r2 = r2 | r23
            goto L_0x0211
        L_0x020f:
            r14 = r64
        L_0x0211:
            r14 = r4 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x0218
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0229
        L_0x0218:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x0229
            boolean r14 = r3.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x0225
            goto L_0x0227
        L_0x0225:
            r25 = r26
        L_0x0227:
            r2 = r2 | r25
        L_0x0229:
            r14 = 32768(0x8000, float:4.5918E-41)
            r14 = r14 & r4
            if (r14 == 0) goto L_0x0233
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x0231:
            r2 = r2 | r14
            goto L_0x0244
        L_0x0233:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x0244
            boolean r14 = r3.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x0241
            r14 = r27
            goto L_0x0231
        L_0x0241:
            r14 = r28
            goto L_0x0231
        L_0x0244:
            r14 = r4 & r28
            if (r14 == 0) goto L_0x024c
            r14 = 1572864(0x180000, float:2.204052E-39)
        L_0x024a:
            r2 = r2 | r14
            goto L_0x025d
        L_0x024c:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x025d
            boolean r14 = r3.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x025a
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x024a
        L_0x025a:
            r14 = 524288(0x80000, float:7.34684E-40)
            goto L_0x024a
        L_0x025d:
            r14 = r4 & r27
            if (r14 == 0) goto L_0x0265
            r14 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0263:
            r2 = r2 | r14
            goto L_0x0276
        L_0x0265:
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x0276
            boolean r14 = r3.changedInstance(r7)
            if (r14 == 0) goto L_0x0273
            r14 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0263
        L_0x0273:
            r14 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0263
        L_0x0276:
            r14 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r4) goto L_0x02ac
            r2 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r2 & r14
            r4 = 4793490(0x492492, float:6.71711E-39)
            if (r2 != r4) goto L_0x02ac
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x0290
            goto L_0x02ac
        L_0x0290:
            r3.skipToGroupEnd()
            r23 = r56
            r24 = r57
            r25 = r58
            r26 = r59
            r27 = r60
            r28 = r61
            r29 = r62
            r30 = r63
            r31 = r64
            r44 = r1
            r15 = r3
            r48 = r14
            goto L_0x052d
        L_0x02ac:
            if (r0 == 0) goto L_0x02b2
            r0 = 0
            r23 = r0
            goto L_0x02b4
        L_0x02b2:
            r23 = r56
        L_0x02b4:
            if (r29 == 0) goto L_0x02ba
            r0 = 0
            r24 = r0
            goto L_0x02bc
        L_0x02ba:
            r24 = r57
        L_0x02bc:
            if (r13 == 0) goto L_0x02c2
            r0 = 0
            r25 = r0
            goto L_0x02c4
        L_0x02c2:
            r25 = r58
        L_0x02c4:
            if (r15 == 0) goto L_0x02ca
            r0 = 0
            r26 = r0
            goto L_0x02cc
        L_0x02ca:
            r26 = r59
        L_0x02cc:
            if (r11 == 0) goto L_0x02d2
            r0 = 0
            r27 = r0
            goto L_0x02d4
        L_0x02d2:
            r27 = r60
        L_0x02d4:
            if (r6 == 0) goto L_0x02da
            r0 = 0
            r28 = r0
            goto L_0x02dc
        L_0x02da:
            r28 = r61
        L_0x02dc:
            if (r12 == 0) goto L_0x02e2
            r0 = 0
            r29 = r0
            goto L_0x02e4
        L_0x02e2:
            r29 = r62
        L_0x02e4:
            if (r17 == 0) goto L_0x02ea
            r0 = 1
            r30 = r0
            goto L_0x02ec
        L_0x02ea:
            r30 = r63
        L_0x02ec:
            if (r18 == 0) goto L_0x02f2
            r0 = 0
            r31 = r0
            goto L_0x02f4
        L_0x02f2:
            r31 = r64
        L_0x02f4:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0302
            java.lang.String r0 = "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)"
            r2 = -947035500(0xffffffffc78d6294, float:-72389.16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r14, r0)
        L_0x0302:
            int r0 = r1 >> 3
            r0 = r0 & 14
            int r2 = r1 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r15 = r52
            boolean r4 = r3.changed((java.lang.Object) r15)
            r12 = r54
            boolean r6 = r3.changed((java.lang.Object) r12)
            r4 = r4 | r6
            r6 = r3
            r11 = 0
            java.lang.Object r13 = r6.rememberedValue()
            r16 = 0
            if (r4 != 0) goto L_0x033d
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r62 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r13 != r0) goto L_0x033b
            goto L_0x033f
        L_0x033b:
            r0 = r13
            goto L_0x0364
        L_0x033d:
            r62 = r0
        L_0x033f:
            r0 = 0
            r63 = r0
            androidx.compose.ui.text.AnnotatedString r0 = new androidx.compose.ui.text.AnnotatedString
            r17 = 6
            r18 = 0
            r19 = 0
            r20 = 0
            r56 = r0
            r57 = r52
            r58 = r19
            r59 = r20
            r60 = r17
            r61 = r18
            r56.<init>(r57, r58, r59, r60, r61)
            androidx.compose.ui.text.input.TransformedText r0 = r12.filter(r0)
            r6.updateRememberedValue(r0)
        L_0x0364:
            r3.endReplaceableGroup()
            androidx.compose.ui.text.input.TransformedText r0 = (androidx.compose.ui.text.input.TransformedText) r0
            androidx.compose.ui.text.AnnotatedString r0 = r0.getText()
            java.lang.String r0 = r0.getText()
            r32 = r0
            int r0 = r14 >> 12
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r10, r3, r0)
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r33 = r0.booleanValue()
            if (r33 == 0) goto L_0x038d
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.Focused
            goto L_0x03a1
        L_0x038d:
            r2 = r32
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0399
            r2 = 1
            goto L_0x039a
        L_0x0399:
            r2 = 0
        L_0x039a:
            if (r2 == 0) goto L_0x039f
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.UnfocusedEmpty
            goto L_0x03a1
        L_0x039f:
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.UnfocusedNotEmpty
        L_0x03a1:
            r11 = r2
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1 r2 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
            r56 = r2
            r57 = r67
            r58 = r30
            r59 = r31
            r60 = r65
            r61 = r14
            r56.<init>(r57, r58, r59, r60, r61)
            r6 = r2
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material3.Typography r34 = r2.getTypography(r3, r4)
            androidx.compose.ui.text.TextStyle r35 = r34.getBodyLarge()
            androidx.compose.ui.text.TextStyle r36 = r34.getBodySmall()
            r69 = r14
            long r13 = r35.m5346getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            r16 = r1
            long r0 = r2.m3289getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3254equalsimpl0(r13, r0)
            if (r0 == 0) goto L_0x03e9
            long r0 = r36.m5346getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r2.m3289getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3254equalsimpl0(r0, r13)
            if (r0 == 0) goto L_0x0409
        L_0x03e9:
            long r0 = r35.m5346getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r2.m3289getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3254equalsimpl0(r0, r13)
            if (r0 != 0) goto L_0x040b
            long r0 = r36.m5346getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r2.m3289getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3254equalsimpl0(r0, r13)
            if (r0 == 0) goto L_0x040b
        L_0x0409:
            r0 = 1
            goto L_0x040c
        L_0x040b:
            r0 = 0
        L_0x040c:
            r37 = r0
            androidx.compose.material3.TextFieldTransitionScope r38 = androidx.compose.material3.TextFieldTransitionScope.INSTANCE
            r0 = -646388253(0xffffffffd978e5e3, float:-4.37865983E15)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "*105@4195L10,106@4289L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r0.getTypography(r3, r4)
            androidx.compose.ui.text.TextStyle r0 = r0.getBodySmall()
            long r0 = r0.m5346getColor0d7_KjU()
            r2 = 0
            if (r37 == 0) goto L_0x045c
            r13 = r0
            r17 = 0
            r18 = r13
            r20 = 0
            androidx.compose.ui.graphics.Color$Companion r21 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r21.m3289getUnspecified0d7_KjU()
            int r21 = (r18 > r21 ? 1 : (r18 == r21 ? 0 : -1))
            if (r21 == 0) goto L_0x0440
            r18 = 1
            goto L_0x0442
        L_0x0440:
            r18 = 0
        L_0x0442:
            if (r18 == 0) goto L_0x0445
            goto L_0x0459
        L_0x0445:
            r18 = 0
            r19 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            java.lang.Object r4 = r6.invoke(r11, r3, r4)
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r18 = r4.m3263unboximpl()
            r13 = r18
        L_0x0459:
            r39 = r13
            goto L_0x045e
        L_0x045c:
            r39 = r0
        L_0x045e:
            r3.endReplaceableGroup()
            r0 = -646388060(0xffffffffd978e6a4, float:-4.37871164E15)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "*108@4388L10,109@4482L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r3, r1)
            androidx.compose.ui.text.TextStyle r0 = r0.getBodyLarge()
            long r0 = r0.m5346getColor0d7_KjU()
            r2 = 0
            if (r37 == 0) goto L_0x04b2
            r13 = r0
            r4 = 0
            r17 = r13
            r19 = 0
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            long r20 = r20.m3289getUnspecified0d7_KjU()
            int r20 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1))
            if (r20 == 0) goto L_0x0491
            r19 = 1
            goto L_0x0493
        L_0x0491:
            r19 = 0
        L_0x0493:
            if (r19 == 0) goto L_0x049a
            r57 = r0
            r18 = 0
            goto L_0x04af
        L_0x049a:
            r17 = 0
            r57 = r0
            r18 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r6.invoke(r11, r3, r0)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m3263unboximpl()
            r13 = r0
        L_0x04af:
            r41 = r13
            goto L_0x04b8
        L_0x04b2:
            r57 = r0
            r18 = 0
            r41 = r57
        L_0x04b8:
            r3.endReplaceableGroup()
            if (r55 == 0) goto L_0x04c1
            r43 = 1
            goto L_0x04c3
        L_0x04c1:
            r43 = r18
        L_0x04c3:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3 r14 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3
            r0 = r14
            r44 = r16
            r1 = r55
            r2 = r23
            r13 = r3
            r3 = r32
            r4 = r67
            r5 = r30
            r45 = r6
            r6 = r31
            r7 = r65
            r8 = r69
            r9 = r26
            r10 = r27
            r46 = r11
            r11 = r24
            r12 = r25
            r47 = r13
            r13 = r28
            r48 = r69
            r15 = r14
            r14 = r51
            r49 = r15
            r15 = r53
            r16 = r29
            r17 = r66
            r18 = r44
            r19 = r37
            r20 = r35
            r21 = r36
            r22 = r68
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = 1290853831(0x4cf0ddc7, float:1.2628332E8)
            r15 = r47
            r1 = r49
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            r9 = r0
            kotlin.jvm.functions.Function7 r9 = (kotlin.jvm.functions.Function7) r9
            r11 = 1769472(0x1b0000, float:2.479558E-39)
            r1 = r38
            r2 = r46
            r3 = r39
            r5 = r41
            r7 = r45
            r8 = r43
            r10 = r15
            r1.m2146TransitionDTcfvLk(r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x052d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x052d:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x0536
            r32 = r15
            goto L_0x0574
        L_0x0536:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4 r22 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4
            r0 = r22
            r1 = r51
            r2 = r52
            r3 = r53
            r4 = r54
            r5 = r55
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r50 = r14
            r14 = r31
            r32 = r15
            r15 = r65
            r16 = r66
            r17 = r67
            r18 = r68
            r19 = r70
            r20 = r71
            r21 = r72
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r50
            r1.updateScope(r0)
        L_0x0574:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: Decoration-KTwxG1Y  reason: not valid java name */
    public static final void m2137DecorationKTwxG1Y(long contentColor, TextStyle typography, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        TextStyle typography2;
        TextStyle typography3;
        long j = contentColor;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1520066345);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(1:c#ui.graphics.Color,2):TextFieldImpl.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            textStyle = typography;
        } else if ((i2 & 112) == 0) {
            textStyle = typography;
            $dirty |= $composer2.changed((Object) textStyle) ? 32 : 16;
        } else {
            textStyle = typography;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                typography3 = null;
            } else {
                typography3 = textStyle;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, $dirty2, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:274)");
            }
            Function2 contentWithColor = ComposableLambdaKt.composableLambda($composer2, 1449369305, true, new TextFieldImplKt$Decoration$contentWithColor$1(j, function2, $dirty2));
            if (typography3 != null) {
                $composer2.startReplaceableGroup(1830468032);
                ComposerKt.sourceInformation($composer2, "285@11827L46");
                TextKt.ProvideTextStyle(typography3, contentWithColor, $composer2, (($dirty2 >> 3) & 14) | 48);
            } else {
                $composer2.startReplaceableGroup(1830468084);
                ComposerKt.sourceInformation($composer2, "285@11879L18");
                contentWithColor.invoke($composer2, 6);
            }
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
        } else {
            $composer2.skipToGroupEnd();
            typography2 = textStyle;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(contentColor, typography2, content, $changed, i));
        }
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Intrinsics.checkNotNullParameter($this$layoutId, "<this>");
        Object parentData = $this$layoutId.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
