package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextStyle $bodyLarge;
    final /* synthetic */ TextStyle $bodySmall;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $container;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $transformedText;
    final /* synthetic */ TextFieldType $type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, String str, TextFieldColors textFieldColors, boolean z, boolean z2, InteractionSource interactionSource, int i, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function28, boolean z3, PaddingValues paddingValues, int i2, boolean z4, TextStyle textStyle, TextStyle textStyle2, Function2<? super Composer, ? super Integer, Unit> function29) {
        super(7);
        this.$label = function2;
        this.$placeholder = function22;
        this.$transformedText = str;
        this.$colors = textFieldColors;
        this.$enabled = z;
        this.$isError = z2;
        this.$interactionSource = interactionSource;
        this.$$dirty1 = i;
        this.$prefix = function23;
        this.$suffix = function24;
        this.$leadingIcon = function25;
        this.$trailingIcon = function26;
        this.$supportingText = function27;
        this.$type = textFieldType;
        this.$innerTextField = function28;
        this.$singleLine = z3;
        this.$contentPadding = paddingValues;
        this.$$dirty = i2;
        this.$shouldOverrideTextStyleColor = z4;
        this.$bodyLarge = textStyle;
        this.$bodySmall = textStyle2;
        this.$container = function29;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        m3848invokeeopBjH0(((Number) p1).floatValue(), ((Color) p2).m4973unboximpl(), ((Color) p3).m4973unboximpl(), ((Number) p4).floatValue(), ((Number) p5).floatValue(), (Composer) p6, ((Number) p7).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0336  */
    /* renamed from: invoke-eopBjH0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3848invokeeopBjH0(float r45, long r46, long r48, float r50, float r51, androidx.compose.runtime.Composer r52, int r53) {
        /*
            r44 = this;
            r0 = r44
            r15 = r45
            r14 = r50
            r13 = r51
            r12 = r52
            r11 = r53
            java.lang.String r1 = "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)146@6118L48,160@6710L48,177@7510L30,178@7596L43,180@7679L53,187@7980L54,195@8299L56:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r53
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0021
            boolean r2 = r12.changed((float) r15)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r1 = r1 | r2
        L_0x0021:
            r2 = r11 & 112(0x70, float:1.57E-43)
            r8 = r46
            if (r2 != 0) goto L_0x0033
            boolean r2 = r12.changed((long) r8)
            if (r2 == 0) goto L_0x0030
            r2 = 32
            goto L_0x0032
        L_0x0030:
            r2 = 16
        L_0x0032:
            r1 = r1 | r2
        L_0x0033:
            r2 = r11 & 896(0x380, float:1.256E-42)
            r6 = r48
            if (r2 != 0) goto L_0x0045
            boolean r2 = r12.changed((long) r6)
            if (r2 == 0) goto L_0x0042
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0044
        L_0x0042:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0044:
            r1 = r1 | r2
        L_0x0045:
            r2 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0055
            boolean r2 = r12.changed((float) r14)
            if (r2 == 0) goto L_0x0052
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0054
        L_0x0052:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0054:
            r1 = r1 | r2
        L_0x0055:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x0067
            boolean r2 = r12.changed((float) r13)
            if (r2 == 0) goto L_0x0064
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0066
        L_0x0064:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0066:
            r1 = r1 | r2
        L_0x0067:
            r3 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r3
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x0080
            boolean r1 = r52.getSkipping()
            if (r1 != 0) goto L_0x0078
            goto L_0x0080
        L_0x0078:
            r52.skipToGroupEnd()
            r30 = r3
            r9 = r12
            goto L_0x04da
        L_0x0080:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x008f
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:113)"
            r4 = 1290853831(0x4cf0ddc7, float:1.2628332E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r1, r2)
        L_0x008f:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$label
            r4 = 0
            r2 = 1
            if (r5 == 0) goto L_0x00b9
            boolean r1 = r0.$shouldOverrideTextStyleColor
            r16 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r10 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r18 = r1
            r1 = r10
            r15 = r2
            r2 = r45
            r30 = r3
            r3 = r48
            r6 = r30
            r7 = r18
            r8 = r46
            r1.<init>(r2, r3, r5, r6, r7, r8)
            r1 = -382297919(0xffffffffe93698c1, float:-1.3796616E25)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r1, r15, r10)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r1
            goto L_0x00bd
        L_0x00b9:
            r15 = r2
            r30 = r3
            r4 = 0
        L_0x00bd:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$placeholder
            r2 = 0
            if (r1 == 0) goto L_0x0100
            java.lang.String r1 = r0.$transformedText
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00ce
            r1 = r15
            goto L_0x00cf
        L_0x00ce:
            r1 = 0
        L_0x00cf:
            if (r1 == 0) goto L_0x0100
            int r1 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0100
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            androidx.compose.material3.TextFieldColors r7 = r0.$colors
            boolean r8 = r0.$enabled
            boolean r9 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r10 = r0.$interactionSource
            int r6 = r0.$$dirty1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$placeholder
            int r3 = r0.$$dirty
            r18 = r5
            r5 = r1
            r19 = r6
            r6 = r50
            r11 = r19
            r2 = r12
            r12 = r18
            r13 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r3 = -524658155(0xffffffffe0ba5a15, float:-1.0742455E20)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r3, r15, r1)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = r1
            goto L_0x0102
        L_0x0100:
            r2 = r12
            r3 = 0
        L_0x0102:
            r1 = 0
            androidx.compose.material3.TextFieldColors r5 = r0.$colors
            boolean r6 = r0.$enabled
            boolean r7 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r8 = r0.$interactionSource
            int r9 = r0.$$dirty1
            int r10 = r9 >> 6
            r10 = r10 & 14
            int r11 = r9 >> 6
            r11 = r11 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            int r11 = r9 >> 6
            r11 = r11 & 896(0x380, float:1.256E-42)
            r10 = r10 | r11
            int r9 = r9 >> 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r9
            r9 = r52
            androidx.compose.runtime.State r5 = r5.prefixColor$material3_release(r6, r7, r8, r9, r10)
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r33 = r5.m4973unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$prefix
            if (r5 == 0) goto L_0x0155
            r5 = 0
            int r6 = (r51 > r5 ? 1 : (r51 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x0155
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1 r12 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
            androidx.compose.ui.text.TextStyle r9 = r0.$bodyLarge
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.$prefix
            int r11 = r0.$$dirty
            r5 = r12
            r6 = r51
            r7 = r33
            r5.<init>(r6, r7, r9, r10, r11)
            r5 = 1824482619(0x6cbf653b, float:1.851063E27)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r5, r15, r12)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r7 = r5
            goto L_0x0156
        L_0x0155:
            r7 = 0
        L_0x0156:
            androidx.compose.material3.TextFieldColors r8 = r0.$colors
            boolean r9 = r0.$enabled
            boolean r10 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r11 = r0.$interactionSource
            int r5 = r0.$$dirty1
            int r6 = r5 >> 6
            r6 = r6 & 14
            int r12 = r5 >> 6
            r12 = r12 & 112(0x70, float:1.57E-43)
            r6 = r6 | r12
            int r12 = r5 >> 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            int r5 = r5 >> 9
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r13 = r6 | r5
            r12 = r52
            androidx.compose.runtime.State r5 = r8.suffixColor$material3_release(r9, r10, r11, r12, r13)
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r35 = r5.m4973unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$suffix
            if (r5 == 0) goto L_0x01b1
            r5 = 0
            int r5 = (r51 > r5 ? 1 : (r51 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b1
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1 r5 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
            androidx.compose.ui.text.TextStyle r6 = r0.$bodyLarge
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$suffix
            int r9 = r0.$$dirty
            r16 = r5
            r17 = r51
            r18 = r35
            r20 = r6
            r21 = r8
            r22 = r9
            r16.<init>(r17, r18, r20, r21, r22)
            r6 = 907456412(0x3616af9c, float:2.245396E-6)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r6, r15, r5)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r8 = r5
            goto L_0x01b2
        L_0x01b1:
            r8 = 0
        L_0x01b2:
            androidx.compose.material3.Strings$Companion r5 = androidx.compose.material3.Strings.Companion
            int r5 = r5.m3738getDefaultErrorMessageadMyvUU()
            r9 = 6
            java.lang.String r12 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r5, r2, r9)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            boolean r6 = r0.$isError
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r10 = r0.$isError
            int r11 = r0.$$dirty1
            int r11 = r11 >> 9
            r11 = r11 & 14
            r13 = 0
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            boolean r16 = r2.changed((java.lang.Object) r6)
            boolean r17 = r2.changed((java.lang.Object) r12)
            r16 = r16 | r17
            r17 = r52
            r18 = 0
            java.lang.Object r1 = r17.rememberedValue()
            r19 = 0
            if (r16 != 0) goto L_0x0201
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r20.getEmpty()
            if (r1 != r15) goto L_0x01fc
            goto L_0x0201
        L_0x01fc:
            r20 = r1
            r10 = r17
            goto L_0x0212
        L_0x0201:
            r15 = 0
            r20 = r1
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
            r1.<init>(r10, r12)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r10 = r17
            r10.updateRememberedValue(r1)
        L_0x0212:
            r52.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6 = 0
            r10 = 0
            r11 = 1
            androidx.compose.ui.Modifier r31 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r6, r1, r11, r10)
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r5 = r0.$enabled
            boolean r6 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r11 = r0.$interactionSource
            int r13 = r0.$$dirty1
            int r15 = r13 >> 6
            r15 = r15 & 14
            int r16 = r13 >> 6
            r16 = r16 & 112(0x70, float:1.57E-43)
            r15 = r15 | r16
            int r10 = r13 >> 6
            r10 = r10 & 896(0x380, float:1.256E-42)
            r10 = r10 | r15
            int r13 = r13 >> 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r21 = r10 | r13
            r16 = r1
            r17 = r5
            r18 = r6
            r19 = r11
            r20 = r52
            androidx.compose.runtime.State r1 = r16.leadingIconColor$material3_release(r17, r18, r19, r20, r21)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r10 = r1.m4973unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$leadingIcon
            if (r1 == 0) goto L_0x026d
            r5 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r6 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r6.<init>(r10, r1)
            r13 = 90769583(0x56908af, float:1.0957202E-35)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r13, r15, r6)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r5 = r6
            goto L_0x026e
        L_0x026d:
            r5 = 0
        L_0x026e:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r6 = r0.$enabled
            boolean r13 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r15 = r0.$interactionSource
            r27 = r10
            int r10 = r0.$$dirty1
            int r11 = r10 >> 6
            r11 = r11 & 14
            int r16 = r10 >> 6
            r16 = r16 & 112(0x70, float:1.57E-43)
            r11 = r11 | r16
            r29 = r12
            int r12 = r10 >> 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r11 = r11 | r12
            int r10 = r10 >> 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r21 = r11 | r10
            r16 = r1
            r17 = r6
            r18 = r13
            r19 = r15
            r20 = r52
            androidx.compose.runtime.State r1 = r16.trailingIconColor$material3_release(r17, r18, r19, r20, r21)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r10 = r1.m4973unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$trailingIcon
            if (r1 == 0) goto L_0x02bf
            r6 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r12 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r12.<init>(r10, r1)
            r13 = 2077796155(0x7bd8a73b, float:2.2498559E36)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r13, r15, r12)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r6 = r12
            goto L_0x02c0
        L_0x02bf:
            r6 = 0
        L_0x02c0:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r12 = r0.$enabled
            boolean r13 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r15 = r0.$interactionSource
            r37 = r10
            int r10 = r0.$$dirty1
            int r11 = r10 >> 6
            r11 = r11 & 14
            int r16 = r10 >> 6
            r16 = r16 & 112(0x70, float:1.57E-43)
            r11 = r11 | r16
            int r14 = r10 >> 6
            r14 = r14 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            int r10 = r10 >> 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r21 = r11 | r10
            r16 = r1
            r17 = r12
            r18 = r13
            r19 = r15
            r20 = r52
            androidx.compose.runtime.State r1 = r16.supportingTextColor$material3_release(r17, r18, r19, r20, r21)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r10 = r1.m4973unboximpl()
            r14 = r10
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$supportingText
            if (r1 == 0) goto L_0x0312
            androidx.compose.ui.text.TextStyle r10 = r0.$bodySmall
            r11 = 0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1 r12 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
            r12.<init>(r14, r10, r1)
            r10 = -1531019900(0xffffffffa4be7d84, float:-8.2612E-17)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r10, r13, r12)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r13 = r10
            goto L_0x0313
        L_0x0312:
            r13 = 0
        L_0x0313:
            androidx.compose.material3.TextFieldType r1 = r0.$type
            int[] r10 = androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r10[r1]
            switch(r1) {
                case 1: goto L_0x0457;
                case 2: goto L_0x0336;
                default: goto L_0x0320;
            }
        L_0x0320:
            r9 = r2
            r41 = r14
            r43 = r29
            r39 = r37
            r37 = r27
            r1 = 404045731(0x18153fa3, float:1.9289927E-24)
            r9.startReplaceableGroup(r1)
            r52.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x04d1
        L_0x0336:
            r1 = 404044017(0x181538f1, float:1.9286547E-24)
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "229@9730L38,252@10751L420,241@10197L1154"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = 0
            r11 = 0
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r10 = 0
            r17 = r52
            r18 = 0
            java.lang.Object r12 = r17.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r24 = r1
            java.lang.Object r1 = r21.getEmpty()
            if (r12 != r1) goto L_0x0382
            r1 = 0
            androidx.compose.ui.geometry.Size$Companion r21 = androidx.compose.ui.geometry.Size.Companion
            long r39 = r21.m4791getZeroNHjbRc()
            r21 = r1
            androidx.compose.ui.geometry.Size r1 = androidx.compose.ui.geometry.Size.m4770boximpl(r39)
            r39 = r10
            r26 = r11
            r10 = 2
            r11 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r11, r10, r11)
            r10 = r17
            r10.updateRememberedValue(r1)
            goto L_0x0389
        L_0x0382:
            r39 = r10
            r26 = r11
            r10 = r17
            r1 = r12
        L_0x0389:
            r52.endReplaceableGroup()
            r12 = r1
            androidx.compose.runtime.MutableState r12 = (androidx.compose.runtime.MutableState) r12
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
            androidx.compose.foundation.layout.PaddingValues r10 = r0.$contentPadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$container
            r17 = r14
            int r14 = r0.$$dirty1
            r1.<init>(r12, r10, r11, r14)
            r10 = 1902535592(0x716663a8, float:1.1408325E30)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r10, r11, r1)
            r20 = r1
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.$innerTextField
            boolean r15 = r0.$singleLine
            java.lang.Float r1 = java.lang.Float.valueOf(r45)
            r11 = r30 & 14
            r11 = r11 | 48
            r14 = 0
            r21 = r11
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r2.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            boolean r9 = r2.changed((java.lang.Object) r1)
            boolean r11 = r2.changed((java.lang.Object) r12)
            r9 = r9 | r11
            r11 = r52
            r23 = 0
            r24 = r1
            java.lang.Object r1 = r11.rememberedValue()
            r25 = 0
            if (r9 != 0) goto L_0x03f1
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r26.getEmpty()
            if (r1 != r2) goto L_0x03ea
            goto L_0x03f1
        L_0x03ea:
            r26 = r1
            r32 = r3
            r3 = r45
            goto L_0x0404
        L_0x03f1:
            r2 = 0
            r26 = r1
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
            r32 = r3
            r3 = r45
            r1.<init>(r3, r12)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r11.updateRememberedValue(r1)
        L_0x0404:
            r52.endReplaceableGroup()
            r11 = r1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r39 = r37
            r37 = r27
            androidx.compose.foundation.layout.PaddingValues r14 = r0.$contentPadding
            r41 = r17
            int r1 = r0.$$dirty
            int r1 = r1 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            int r2 = r0.$$dirty1
            int r9 = r2 << 21
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r17
            r1 = r1 | r9
            int r9 = r30 << 27
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r9 = r9 & r16
            r16 = r1 | r9
            r1 = 6
            int r1 = r2 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r17 = r1 | 48
            r1 = r31
            r9 = r52
            r2 = r10
            r10 = r9
            r9 = r15
            r15 = r10
            r10 = r45
            r18 = r12
            r43 = r29
            r12 = r20
            r3 = r15
            r15 = r52
            r0 = r3
            r3 = r32
            androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r52.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r9 = r0
            r0 = r44
            goto L_0x04d1
        L_0x0457:
            r0 = r2
            r41 = r14
            r43 = r29
            r39 = r37
            r1 = 1
            r37 = r27
            r2 = 404043011(0x18153503, float:1.9284563E-24)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "211@8928L680"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1 r2 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
            r9 = r0
            r0 = r44
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r0.$container
            int r11 = r0.$$dirty1
            r2.<init>(r10, r11)
            r10 = -2124779163(0xffffffff815a7165, float:-4.0121633E-38)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r10, r1, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.$innerTextField
            boolean r2 = r0.$singleLine
            androidx.compose.foundation.layout.PaddingValues r10 = r0.$contentPadding
            int r11 = r0.$$dirty
            int r11 = r11 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            int r12 = r0.$$dirty1
            int r14 = r12 << 21
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r14 = r14 & r17
            r11 = r11 | r14
            int r14 = r30 << 27
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r14 = r14 & r16
            r28 = r11 | r14
            int r11 = r12 >> 9
            r11 = r11 & 896(0x380, float:1.256E-42)
            r12 = 6
            r29 = r11 | 6
            r14 = r31
            r16 = r4
            r17 = r3
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r2
            r23 = r45
            r24 = r1
            r25 = r13
            r26 = r10
            r27 = r52
            androidx.compose.material3.TextFieldKt.TextFieldLayout(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r52.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x04d1:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04da
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.m3848invokeeopBjH0(float, long, long, float, float, androidx.compose.runtime.Composer, int):void");
    }
}
