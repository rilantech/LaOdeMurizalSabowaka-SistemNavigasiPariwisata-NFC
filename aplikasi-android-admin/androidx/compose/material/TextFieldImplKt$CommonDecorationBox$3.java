package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "labelProgress", "", "labelTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "labelContentColor", "placeholderAlphaProgress", "invoke-RIQooxk", "(FJJFLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $border;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
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
    TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, String str, boolean z, int i, TextFieldColors textFieldColors, boolean z2, InteractionSource interactionSource, int i2, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function25, boolean z3, PaddingValues paddingValues, boolean z4, Function2<? super Composer, ? super Integer, Unit> function26) {
        super(6);
        this.$label = function2;
        this.$placeholder = function22;
        this.$transformedText = str;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$colors = textFieldColors;
        this.$enabled = z2;
        this.$interactionSource = interactionSource;
        this.$$dirty = i2;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$type = textFieldType;
        this.$innerTextField = function25;
        this.$singleLine = z3;
        this.$contentPadding = paddingValues;
        this.$shouldOverrideTextStyleColor = z4;
        this.$border = function26;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        m3186invokeRIQooxk(((Number) p1).floatValue(), ((Color) p2).m4973unboximpl(), ((Color) p3).m4973unboximpl(), ((Number) p4).floatValue(), (Composer) p5, ((Number) p6).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* renamed from: invoke-RIQooxk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3186invokeRIQooxk(float r34, long r35, long r37, float r39, androidx.compose.runtime.Composer r40, int r41) {
        /*
            r33 = this;
            r0 = r33
            r15 = r34
            r14 = r39
            r13 = r40
            r12 = r41
            java.lang.String r1 = "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)151@6394L30,152@6480L43:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r41
            r2 = r12 & 14
            r11 = 2
            if (r2 != 0) goto L_0x0020
            boolean r2 = r13.changed((float) r15)
            if (r2 == 0) goto L_0x001e
            r2 = 4
            goto L_0x001f
        L_0x001e:
            r2 = r11
        L_0x001f:
            r1 = r1 | r2
        L_0x0020:
            r2 = r12 & 112(0x70, float:1.57E-43)
            r8 = r35
            if (r2 != 0) goto L_0x0032
            boolean r2 = r13.changed((long) r8)
            if (r2 == 0) goto L_0x002f
            r2 = 32
            goto L_0x0031
        L_0x002f:
            r2 = 16
        L_0x0031:
            r1 = r1 | r2
        L_0x0032:
            r2 = r12 & 896(0x380, float:1.256E-42)
            r6 = r37
            if (r2 != 0) goto L_0x0044
            boolean r2 = r13.changed((long) r6)
            if (r2 == 0) goto L_0x0041
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0043
        L_0x0041:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0043:
            r1 = r1 | r2
        L_0x0044:
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r13.changed((float) r14)
            if (r2 == 0) goto L_0x0051
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0053
        L_0x0051:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r10 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r10
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x006c
            boolean r1 = r40.getSkipping()
            if (r1 != 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            r40.skipToGroupEnd()
            r18 = r10
            r2 = r13
            goto L_0x03f9
        L_0x006c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x007b
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:118)"
            r3 = 341865432(0x146073d8, float:1.1331956E-26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r10, r1, r2)
        L_0x007b:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$label
            r3 = 1
            r4 = 0
            if (r5 == 0) goto L_0x00a5
            boolean r2 = r0.$shouldOverrideTextStyleColor
            r16 = 0
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r1 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r17 = r1
            r18 = r2
            r2 = r34
            r12 = r3
            r3 = r37
            r6 = r10
            r7 = r18
            r8 = r35
            r1.<init>(r2, r3, r5, r6, r7, r8)
            r1 = 362863774(0x15a0dc9e, float:6.497156E-26)
            r2 = r17
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r1, r12, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r1
            goto L_0x00a7
        L_0x00a5:
            r12 = r3
            r4 = 0
        L_0x00a7:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$placeholder
            if (r1 == 0) goto L_0x00e3
            java.lang.String r1 = r0.$transformedText
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00b7
            r3 = r12
            goto L_0x00b8
        L_0x00b7:
            r3 = 0
        L_0x00b8:
            if (r3 == 0) goto L_0x00e3
            r1 = 0
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e3
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r1 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            androidx.compose.material.TextFieldColors r7 = r0.$colors
            boolean r8 = r0.$enabled
            int r9 = r0.$$dirty
            int r3 = r0.$$dirty1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$placeholder
            r5 = r1
            r16 = r6
            r6 = r39
            r18 = r10
            r10 = r3
            r3 = r11
            r11 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r5 = 1120552650(0x42ca46ca, float:101.13826)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r5, r12, r1)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            goto L_0x00e7
        L_0x00e3:
            r18 = r10
            r3 = r11
            r1 = 0
        L_0x00e7:
            r11 = r3
            r3 = r1
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m3123getDefaultErrorMessageUdPEhr4()
            r10 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m3128getString4foXLRw(r1, r13, r10)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            boolean r6 = r0.$isError
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r7 = r0.$isError
            int r8 = r0.$$dirty1
            r8 = r8 & 14
            r9 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            boolean r20 = r13.changed((java.lang.Object) r6)
            boolean r21 = r13.changed((java.lang.Object) r1)
            r20 = r20 | r21
            r21 = r40
            r22 = 0
            java.lang.Object r10 = r21.rememberedValue()
            r24 = 0
            if (r20 != 0) goto L_0x0135
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r25.getEmpty()
            if (r10 != r11) goto L_0x0131
            goto L_0x0135
        L_0x0131:
            r7 = r10
            r11 = r21
            goto L_0x0144
        L_0x0135:
            r11 = 0
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 r12 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
            r12.<init>(r7, r1)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r7 = r12
            r11 = r21
            r11.updateRememberedValue(r7)
        L_0x0144:
            r40.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r6 = 0
            r8 = 1
            r12 = 0
            androidx.compose.ui.Modifier r19 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r6, r7, r8, r12)
            androidx.compose.material.TextFieldColors r5 = r0.$colors
            boolean r5 = r5 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r5 == 0) goto L_0x0195
            r5 = -1083197701(0xffffffffbf6fb6fb, float:-0.9363858)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "155@6617L53"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.material.TextFieldColors r5 = r0.$colors
            androidx.compose.material.TextFieldColorsWithIcons r5 = (androidx.compose.material.TextFieldColorsWithIcons) r5
            boolean r6 = r0.$enabled
            boolean r7 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r8 = r0.$interactionSource
            int r9 = r0.$$dirty
            int r9 = r9 >> 27
            r9 = r9 & 14
            int r10 = r0.$$dirty1
            int r11 = r10 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r9 = r9 | r11
            int r10 = r10 << 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r10 = r10 | r9
            r9 = r40
            r20 = 6
            androidx.compose.runtime.State r5 = r5.leadingIconColor(r6, r7, r8, r9, r10)
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r5 = r5.m4973unboximpl()
            r40.endReplaceableGroup()
            goto L_0x01cb
        L_0x0195:
            r20 = 6
            r5 = -1083197605(0xffffffffbf6fb75b, float:-0.93639153)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "157@6713L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.material.TextFieldColors r5 = r0.$colors
            boolean r6 = r0.$enabled
            boolean r7 = r0.$isError
            int r8 = r0.$$dirty
            int r8 = r8 >> 27
            r8 = r8 & 14
            int r9 = r0.$$dirty1
            int r10 = r9 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r8 = r8 | r10
            int r9 = r9 >> 3
            r9 = r9 & 896(0x380, float:1.256E-42)
            r8 = r8 | r9
            androidx.compose.runtime.State r5 = r5.leadingIconColor(r6, r7, r13, r8)
            java.lang.Object r5 = r5.getValue()
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r5 = r5.m4973unboximpl()
            r40.endReplaceableGroup()
        L_0x01cb:
            r10 = r5
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$leadingIcon
            if (r5 == 0) goto L_0x01e2
            r6 = 0
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r7 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r7.<init>(r10, r5)
            r8 = 1505327088(0x59b977f0, float:6.5255929E15)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r8, r9, r7)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r5 = r7
            goto L_0x01e3
        L_0x01e2:
            r5 = r12
        L_0x01e3:
            androidx.compose.material.TextFieldColors r6 = r0.$colors
            boolean r6 = r6 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r6 == 0) goto L_0x022b
            r6 = -1083197259(0xffffffffbf6fb8b5, float:-0.93641216)
            r13.startReplaceableGroup(r6)
            java.lang.String r6 = "166@7059L54"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.material.TextFieldColors r6 = r0.$colors
            androidx.compose.material.TextFieldColorsWithIcons r6 = (androidx.compose.material.TextFieldColorsWithIcons) r6
            boolean r7 = r0.$enabled
            boolean r8 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r9 = r0.$interactionSource
            int r12 = r0.$$dirty
            int r12 = r12 >> 27
            r12 = r12 & 14
            r22 = r1
            int r1 = r0.$$dirty1
            int r23 = r1 << 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r12 = r12 | r23
            int r1 = r1 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r12
            r23 = r10
            r10 = r40
            r12 = 2
            r11 = r1
            androidx.compose.runtime.State r1 = r6.trailingIconColor(r7, r8, r9, r10, r11)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r6 = r1.m4973unboximpl()
            r40.endReplaceableGroup()
            goto L_0x0264
        L_0x022b:
            r22 = r1
            r23 = r10
            r12 = 2
            r1 = -1083197162(0xffffffffbf6fb916, float:-0.93641794)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "168@7156L35"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r6 = r0.$enabled
            boolean r7 = r0.$isError
            int r8 = r0.$$dirty
            int r8 = r8 >> 27
            r8 = r8 & 14
            int r9 = r0.$$dirty1
            int r10 = r9 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r8 = r8 | r10
            int r9 = r9 >> 3
            r9 = r9 & 896(0x380, float:1.256E-42)
            r8 = r8 | r9
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r6, r7, r13, r8)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r6 = r1.m4973unboximpl()
            r40.endReplaceableGroup()
        L_0x0264:
            r10 = r6
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$trailingIcon
            if (r1 == 0) goto L_0x027b
            r6 = 0
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r7 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r7.<init>(r10, r1)
            r8 = -1894727196(0xffffffff8f10c1e4, float:-7.13709E-30)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r8, r9, r7)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6 = r7
            goto L_0x027c
        L_0x027b:
            r6 = 0
        L_0x027c:
            androidx.compose.material.TextFieldType r1 = r0.$type
            int[] r7 = androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r7[r1]
            switch(r1) {
                case 1: goto L_0x03a9;
                case 2: goto L_0x0297;
                default: goto L_0x0289;
            }
        L_0x0289:
            r25 = r10
            r2 = r13
            r1 = -1083194783(0xffffffffbf6fc261, float:-0.93655974)
            r2.startReplaceableGroup(r1)
            r40.endReplaceableGroup()
            goto L_0x03f0
        L_0x0297:
            r1 = -1083196270(0xffffffffbf6fbc92, float:-0.9364711)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "192@8096L38,210@8904L420,202@8496L994"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = 0
            r9 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            r7 = 0
            r26 = r40
            r27 = 0
            java.lang.Object r8 = r26.rememberedValue()
            r28 = 0
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r29.getEmpty()
            if (r8 != r12) goto L_0x02e1
            r12 = 0
            androidx.compose.ui.geometry.Size$Companion r29 = androidx.compose.ui.geometry.Size.Companion
            long r31 = r29.m4791getZeroNHjbRc()
            r29 = r1
            androidx.compose.ui.geometry.Size r1 = androidx.compose.ui.geometry.Size.m4770boximpl(r31)
            r31 = r7
            r21 = r8
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r8, r7, r8)
            r7 = r26
            r7.updateRememberedValue(r1)
            goto L_0x02eb
        L_0x02e1:
            r29 = r1
            r31 = r7
            r21 = r8
            r7 = r26
            r1 = r21
        L_0x02eb:
            r40.endReplaceableGroup()
            r12 = r1
            androidx.compose.runtime.MutableState r12 = (androidx.compose.runtime.MutableState) r12
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1 r1 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
            androidx.compose.foundation.layout.PaddingValues r7 = r0.$contentPadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$border
            int r9 = r0.$$dirty1
            r1.<init>(r12, r7, r8, r9)
            r7 = 139886979(0x8568183, float:6.4550523E-34)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r7, r8, r1)
            r21 = r1
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$innerTextField
            boolean r8 = r0.$singleLine
            java.lang.Float r1 = java.lang.Float.valueOf(r34)
            r9 = r18 & 14
            r9 = r9 | 48
            r25 = 0
            r26 = r9
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            boolean r2 = r13.changed((java.lang.Object) r1)
            boolean r9 = r13.changed((java.lang.Object) r12)
            r2 = r2 | r9
            r9 = r40
            r17 = 0
            r27 = r1
            java.lang.Object r1 = r9.rememberedValue()
            r28 = 0
            if (r2 != 0) goto L_0x034e
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r30 = r2
            java.lang.Object r2 = r29.getEmpty()
            if (r1 != r2) goto L_0x034b
            goto L_0x0350
        L_0x034b:
            r29 = r1
            goto L_0x035f
        L_0x034e:
            r30 = r2
        L_0x0350:
            r2 = 0
            r29 = r1
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1 r1 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
            r1.<init>(r15, r12)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.updateRememberedValue(r1)
        L_0x035f:
            r40.endReplaceableGroup()
            r9 = r1
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.foundation.layout.PaddingValues r2 = r0.$contentPadding
            int r1 = r0.$$dirty
            int r17 = r1 >> 3
            r17 = r17 & 112(0x70, float:1.57E-43)
            r25 = 805306368(0x30000000, float:4.656613E-10)
            r17 = r17 | r25
            int r1 = r1 >> 6
            r25 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r25
            r1 = r17 | r1
            int r17 = r18 << 21
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r17 & r16
            r16 = r1 | r16
            int r1 = r0.$$dirty1
            int r1 = r1 >> 6
            r17 = r1 & 14
            r1 = r19
            r20 = r2
            r2 = r7
            r7 = r8
            r8 = r34
            r25 = r10
            r10 = r21
            r11 = r20
            r20 = r12
            r12 = r40
            r15 = r13
            r13 = r16
            r14 = r17
            androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r40.endReplaceableGroup()
            r2 = r15
            goto L_0x03f0
        L_0x03a9:
            r25 = r10
            r15 = r13
            r1 = -1083196826(0xffffffffbf6fba66, float:-0.93643796)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "178@7489L485"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$innerTextField
            boolean r13 = r0.$singleLine
            androidx.compose.foundation.layout.PaddingValues r1 = r0.$contentPadding
            int r2 = r0.$$dirty
            int r7 = r2 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            int r2 = r2 >> 6
            r9 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r9
            r2 = r2 | r7
            int r7 = r18 << 21
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r9
            r2 = r2 | r7
            int r7 = r0.$$dirty1
            int r7 = r7 << 18
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r7 = r7 & r9
            r17 = r2 | r7
            r7 = r19
            r9 = r4
            r10 = r3
            r11 = r5
            r12 = r6
            r14 = r34
            r2 = r15
            r15 = r1
            r16 = r40
            androidx.compose.material.TextFieldKt.TextFieldLayout(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r40.endReplaceableGroup()
        L_0x03f0:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03f9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.m3186invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
    }
}
