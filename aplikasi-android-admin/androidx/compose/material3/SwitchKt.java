package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0013\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float SwitchHeight = SwitchTokens.INSTANCE.m4457getTrackHeightD9Ej5fM();
    private static final float SwitchWidth = SwitchTokens.INSTANCE.m4459getTrackWidthD9Ej5fM();
    private static final float ThumbDiameter = SwitchTokens.INSTANCE.m4454getSelectedHandleWidthD9Ej5fM();
    private static final float ThumbPadding = Dp.m7554constructorimpl(Dp.m7554constructorimpl(SwitchHeight - ThumbDiameter) / ((float) 2));
    private static final float ThumbPathLength = Dp.m7554constructorimpl(Dp.m7554constructorimpl(SwitchWidth - ThumbDiameter) - ThumbPadding);
    private static final float UncheckedThumbDiameter = SwitchTokens.INSTANCE.m4461getUnselectedHandleWidthD9Ej5fM();

    /* JADX WARNING: Removed duplicated region for block: B:124:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0577  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r53, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r54, androidx.compose.ui.Modifier r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, boolean r57, androidx.compose.material3.SwitchColors r58, androidx.compose.foundation.interaction.MutableInteractionSource r59, androidx.compose.runtime.Composer r60, int r61, int r62) {
        /*
            r10 = r54
            r11 = r61
            r0 = 1580463220(0x5e33f474, float:3.24177919E18)
            r1 = r60
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Switch)P(!1,5,4,6,2)96@4503L8,97@4563L39,*106@4851L7,107@4926L7,108@4986L111,113@5161L36,114@5214L24,116@5244L156,121@5406L216,145@6082L848:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r61
            r2 = r62 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            r8 = r53
            goto L_0x0030
        L_0x001d:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002e
            r8 = r53
            boolean r2 = r9.changed((boolean) r8)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r1 = r1 | r2
            goto L_0x0030
        L_0x002e:
            r8 = r53
        L_0x0030:
            r2 = r62 & 2
            if (r2 == 0) goto L_0x0037
            r1 = r1 | 48
            goto L_0x0047
        L_0x0037:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0047
            boolean r2 = r9.changedInstance(r10)
            if (r2 == 0) goto L_0x0044
            r2 = 32
            goto L_0x0046
        L_0x0044:
            r2 = 16
        L_0x0046:
            r1 = r1 | r2
        L_0x0047:
            r2 = r62 & 4
            if (r2 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r55
            goto L_0x0065
        L_0x0050:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0063
            r3 = r55
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005f
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r1 = r1 | r4
            goto L_0x0065
        L_0x0063:
            r3 = r55
        L_0x0065:
            r4 = r62 & 8
            if (r4 == 0) goto L_0x006e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r56
            goto L_0x0083
        L_0x006e:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0081
            r5 = r56
            boolean r6 = r9.changedInstance(r5)
            if (r6 == 0) goto L_0x007d
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r1 = r1 | r6
            goto L_0x0083
        L_0x0081:
            r5 = r56
        L_0x0083:
            r6 = r62 & 16
            if (r6 == 0) goto L_0x008c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r12 = r57
            goto L_0x00a3
        L_0x008c:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r11
            if (r12 != 0) goto L_0x00a1
            r12 = r57
            boolean r13 = r9.changed((boolean) r12)
            if (r13 == 0) goto L_0x009d
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r1 = r1 | r13
            goto L_0x00a3
        L_0x00a1:
            r12 = r57
        L_0x00a3:
            r49 = 458752(0x70000, float:6.42848E-40)
            r13 = r11 & r49
            if (r13 != 0) goto L_0x00be
            r13 = r62 & 32
            if (r13 != 0) goto L_0x00b8
            r15 = r58
            boolean r13 = r9.changed((java.lang.Object) r15)
            if (r13 == 0) goto L_0x00ba
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00b8:
            r15 = r58
        L_0x00ba:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r1 = r1 | r13
            goto L_0x00c0
        L_0x00be:
            r15 = r58
        L_0x00c0:
            r50 = r62 & 64
            r51 = 3670016(0x380000, float:5.142788E-39)
            if (r50 == 0) goto L_0x00cc
            r13 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r13
            r13 = r59
            goto L_0x00e1
        L_0x00cc:
            r13 = r11 & r51
            if (r13 != 0) goto L_0x00df
            r13 = r59
            boolean r14 = r9.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00db
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r1 = r1 | r14
            goto L_0x00e1
        L_0x00df:
            r13 = r59
        L_0x00e1:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r7 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r7) goto L_0x0100
            boolean r7 = r9.getSkipping()
            if (r7 != 0) goto L_0x00f1
            goto L_0x0100
        L_0x00f1:
            r9.skipToGroupEnd()
            r47 = r1
            r48 = r3
            r26 = r5
            r27 = r12
            r28 = r15
            goto L_0x057c
        L_0x0100:
            r9.startDefaults()
            r7 = r11 & 1
            r52 = -458753(0xfffffffffff8ffff, float:NaN)
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            if (r7 == 0) goto L_0x012c
            boolean r7 = r9.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0116
            goto L_0x012c
        L_0x0116:
            r9.skipToGroupEnd()
            r2 = r62 & 32
            if (r2 == 0) goto L_0x011f
            r1 = r1 & r52
        L_0x011f:
            r26 = r5
            r27 = r12
            r29 = r13
            r7 = r14
            r28 = r15
            r14 = r1
            r15 = r3
            goto L_0x01c2
        L_0x012c:
            if (r2 == 0) goto L_0x0133
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0134
        L_0x0133:
            r2 = r3
        L_0x0134:
            if (r4 == 0) goto L_0x0138
            r3 = 0
            goto L_0x0139
        L_0x0138:
            r3 = r5
        L_0x0139:
            if (r6 == 0) goto L_0x013d
            r4 = 1
            goto L_0x013e
        L_0x013d:
            r4 = r12
        L_0x013e:
            r5 = r62 & 32
            if (r5 == 0) goto L_0x0175
            androidx.compose.material3.SwitchDefaults r12 = androidx.compose.material3.SwitchDefaults.INSTANCE
            r47 = 1572864(0x180000, float:2.204052E-39)
            r48 = 65535(0xffff, float:9.1834E-41)
            r5 = 0
            r7 = r14
            r13 = r5
            r15 = r5
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
            r46 = 0
            r45 = r9
            androidx.compose.material3.SwitchColors r5 = r12.m3798colorsV1nXRL4(r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r46, r47, r48)
            r1 = r1 & r52
            goto L_0x0178
        L_0x0175:
            r7 = r14
            r5 = r58
        L_0x0178:
            if (r50 == 0) goto L_0x01b5
            r6 = 0
            r12 = 0
            r9.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r7)
            r13 = 0
            r14 = r9
            r15 = 0
            java.lang.Object r0 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r55 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x01a0
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r14.updateRememberedValue(r1)
            goto L_0x01a1
        L_0x01a0:
            r1 = r0
        L_0x01a1:
            r9.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r14 = r55
            r29 = r0
            r15 = r2
            r26 = r3
            r27 = r4
            r28 = r5
            goto L_0x01c2
        L_0x01b5:
            r55 = r1
            r14 = r55
            r29 = r59
            r15 = r2
            r26 = r3
            r27 = r4
            r28 = r5
        L_0x01c2:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d4
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.Switch (Switch.kt:90)"
            r2 = 1580463220(0x5e33f474, float:3.24177919E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
        L_0x01d4:
            if (r26 != 0) goto L_0x01d9
            float r0 = UncheckedThumbDiameter
            goto L_0x01db
        L_0x01d9:
            float r0 = ThumbDiameter
        L_0x01db:
            r30 = r0
            float r0 = SwitchHeight
            r1 = 0
            float r2 = r0 - r30
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r2)
            r1 = 2
            r2 = 0
            float r3 = (float) r1
            float r3 = r0 / r3
            float r0 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r3)
            r13 = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r12, r3)
            java.lang.Object r4 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r4
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 0
            float r6 = r0.m7535toPx0680j_4(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r12, r3)
            java.lang.Object r3 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r3
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 0
            float r5 = ThumbPathLength
            float r4 = r0.m7535toPx0680j_4(r5)
            java.lang.Float r0 = java.lang.Float.valueOf(r6)
            java.lang.Float r1 = java.lang.Float.valueOf(r4)
            r3 = 0
            r2 = r3
            r17 = 0
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            boolean r12 = r9.changed((java.lang.Object) r0)
            boolean r18 = r9.changed((java.lang.Object) r1)
            r12 = r12 | r18
            r56 = r9
            r18 = 0
            java.lang.Object r3 = r56.rememberedValue()
            r19 = 0
            if (r12 != 0) goto L_0x026b
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r58 = r0
            java.lang.Object r0 = r20.getEmpty()
            if (r3 != r0) goto L_0x0265
            goto L_0x026d
        L_0x0265:
            r59 = r1
            r0 = r3
            r1 = r56
            goto L_0x0280
        L_0x026b:
            r58 = r0
        L_0x026d:
            r0 = 0
            r59 = r0
            androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1 r0 = new androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
            r0.<init>(r4, r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r59 = r1
            r1 = r56
            r1.updateRememberedValue(r0)
        L_0x0280:
            r9.endReplaceableGroup()
            r12 = r0
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r53)
            java.lang.Object r0 = r12.invoke(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            float r3 = r0.floatValue()
            r0 = 0
            r1 = r0
            r0 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r7)
            r2 = 0
            r56 = r9
            r17 = 0
            r58 = r0
            java.lang.Object r0 = r56.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r59 = r1
            java.lang.Object r1 = r19.getEmpty()
            r8 = 0
            if (r0 != r1) goto L_0x02cd
            r1 = 0
            r19 = r0
            r0 = 0
            r20 = r1
            r1 = 2
            androidx.compose.animation.core.Animatable r0 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r3, r0, r1, r8)
            r1 = r56
            r1.updateRememberedValue(r0)
            goto L_0x02d1
        L_0x02cd:
            r1 = r56
            r19 = r0
        L_0x02d1:
            r9.endReplaceableGroup()
            r2 = r0
            androidx.compose.animation.core.Animatable r2 = (androidx.compose.animation.core.Animatable) r2
            r0 = 0
            r1 = r0
            r17 = 0
            r8 = 773894976(0x2e20b340, float:3.6538994E-11)
            r9.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r8)
            r8 = r9
            r18 = r0
            r0 = 0
            r58 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r7)
            r0 = 0
            r7 = r9
            r16 = 0
            r59 = r0
            java.lang.Object r0 = r7.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r0 != r1) goto L_0x032b
            r1 = 0
            r20 = 0
            kotlin.coroutines.EmptyCoroutineContext r20 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r22 = r0
            r0 = r20
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r8)
            r20 = r1
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r0 = r1
            r7.updateRememberedValue(r0)
            goto L_0x032d
        L_0x032b:
            r22 = r0
        L_0x032d:
            r9.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r9.endReplaceableGroup()
            r7 = r1
            androidx.compose.material3.SwitchKt$Switch$2 r0 = new androidx.compose.material3.SwitchKt$Switch$2
            r0.<init>(r2, r6)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r8 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r9, r8)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r53)
            androidx.compose.material3.SwitchKt$Switch$3 r1 = new androidx.compose.material3.SwitchKt$Switch$3
            r1.<init>(r2, r3, r7)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r8 = r14 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r9, (int) r8)
            if (r10 == 0) goto L_0x038a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m6877getSwitcho7Vup1c()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.semantics.Role r8 = androidx.compose.ui.semantics.Role.m6865boximpl(r1)
            r16 = 0
            r1 = r53
            r31 = r2
            r2 = r29
            r32 = r3
            r57 = r7
            r7 = 0
            r3 = r16
            r33 = r4
            r4 = r27
            r22 = r5
            r5 = r8
            r8 = r6
            r6 = r54
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m2547toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x039a
        L_0x038a:
            r31 = r2
            r32 = r3
            r33 = r4
            r22 = r5
            r8 = r6
            r57 = r7
            r7 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x039a:
            if (r10 == 0) goto L_0x03a8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x03ac
        L_0x03a8:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x03ac:
            androidx.compose.ui.Modifier r1 = r15.then(r1)
            androidx.compose.ui.Modifier r1 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getCenter()
            r3 = 0
            r4 = 2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r2, r7, r4, r3)
            float r2 = SwitchWidth
            float r3 = SwitchHeight
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m2316requiredSizeVpY3zN4(r1, r2, r3)
            r2 = r7
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r5 = 0
            int r6 = r2 >> 3
            r6 = r6 & 14
            int r7 = r2 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r5, r9, r6)
            int r7 = r2 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r34 = 0
            r56 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r58 = r3
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            r59 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r3)
            java.lang.Object r4 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r4
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r16 = 6
            r17 = 0
            r60 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r3)
            java.lang.Object r5 = r9.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r4 = r5
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r16 = 6
            r17 = 0
            r35 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r3)
            java.lang.Object r3 = r9.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r55 = r1
            int r1 = r7 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r36 = r7
            r7 = 6
            r1 = r1 | r7
            r37 = 0
            androidx.compose.runtime.Applier r7 = r9.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0476
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0476:
            r9.startReusableNode()
            boolean r7 = r9.getInserting()
            if (r7 == 0) goto L_0x0483
            r9.createNode(r5)
            goto L_0x0486
        L_0x0483:
            r9.useNode()
        L_0x0486:
            r9.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r38 = r5
            kotlin.jvm.functions.Function2 r5 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r7, r3, r5)
            r9.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r5)
            int r7 = r1 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.invoke(r5, r9, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r5)
            int r5 = r1 >> 9
            r5 = r5 & 14
            r7 = r9
            r39 = 0
            r40 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r41 = r1
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r2 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r16 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r42 = r7
            r43 = 0
            r44 = r2
            r2 = -1873061389(0xffffffff905b59f3, float:-4.325943E-29)
            r45 = r3
            java.lang.String r3 = "C164@6720L9,158@6473L451:Switch.kt#uh7d8r"
            r46 = r4
            r4 = r42
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r3)
            androidx.compose.runtime.State r2 = r31.asState()
            androidx.compose.material3.tokens.SwitchTokens r3 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getHandleShape()
            r42 = r5
            r5 = 6
            androidx.compose.ui.graphics.Shape r19 = androidx.compose.material3.ShapesKt.toShape(r3, r4, r5)
            r18 = r29
            androidx.compose.foundation.interaction.InteractionSource r18 = (androidx.compose.foundation.interaction.InteractionSource) r18
            r3 = r1 & 14
            int r5 = r14 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r3 = r3 | r5
            int r5 = r14 >> 6
            r5 = r5 & 896(0x380, float:1.256E-42)
            r3 = r3 | r5
            int r5 = r14 >> 6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r5
            int r5 = r14 << 6
            r5 = r5 & r49
            r3 = r3 | r5
            r5 = r14 & r51
            r24 = r3 | r5
            r25 = 6
            r3 = r12
            r12 = r0
            r5 = r13
            r13 = r53
            r47 = r14
            r14 = r27
            r48 = r15
            r15 = r28
            r16 = r2
            r17 = r26
            r20 = r30
            r21 = r5
            r23 = r4
            m3800SwitchImpl0DmnUew(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x057a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x057a:
            r13 = r29
        L_0x057c:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 != 0) goto L_0x0584
            r15 = r9
            goto L_0x05a1
        L_0x0584:
            androidx.compose.material3.SwitchKt$Switch$5 r14 = new androidx.compose.material3.SwitchKt$Switch$5
            r0 = r14
            r1 = r53
            r2 = r54
            r3 = r48
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r13
            r8 = r61
            r15 = r9
            r9 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r12.updateScope(r14)
        L_0x05a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0523  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x05b0  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x05e2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x061d  */
    /* renamed from: SwitchImpl-0DmnUew  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3800SwitchImpl0DmnUew(androidx.compose.foundation.layout.BoxScope r63, boolean r64, boolean r65, androidx.compose.material3.SwitchColors r66, androidx.compose.runtime.State<java.lang.Float> r67, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, androidx.compose.foundation.interaction.InteractionSource r69, androidx.compose.ui.graphics.Shape r70, float r71, float r72, float r73, androidx.compose.runtime.Composer r74, int r75, int r76) {
        /*
            r14 = r63
            r15 = r64
            r13 = r65
            r12 = r66
            r11 = r68
            r10 = r69
            r9 = r70
            r8 = r71
            r7 = r72
            r6 = r73
            r5 = r75
            r0 = -1968109941(0xffffffff8ab1068b, float:-1.7046941E-32)
            r1 = r74
            androidx.compose.runtime.Composer r4 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwitchImpl)P(!1,2!1,8,6!1,7,9:c#ui.unit.Dp,5:c#ui.unit.Dp,4:c#ui.unit.Dp)187@7372L28,188@7440L25,*190@7508L7,210@8141L9,217@8350L29,222@8469L951:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r1)
            r1 = r75
            r2 = r76
            r3 = r5 & 14
            r16 = 4
            if (r3 != 0) goto L_0x0039
            boolean r3 = r4.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0037
            r3 = r16
            goto L_0x0038
        L_0x0037:
            r3 = 2
        L_0x0038:
            r1 = r1 | r3
        L_0x0039:
            r3 = r5 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            boolean r3 = r4.changed((boolean) r15)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r1 = r1 | r3
        L_0x0049:
            r3 = r5 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0059
            boolean r3 = r4.changed((boolean) r13)
            if (r3 == 0) goto L_0x0056
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r1 = r1 | r3
        L_0x0059:
            r3 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0069
            boolean r3 = r4.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0066
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0068
        L_0x0066:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0068:
            r1 = r1 | r3
        L_0x0069:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r5
            if (r3 != 0) goto L_0x007f
            r3 = r67
            boolean r18 = r4.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x007a
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007c
        L_0x007a:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x007c:
            r1 = r1 | r18
            goto L_0x0081
        L_0x007f:
            r3 = r67
        L_0x0081:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x0094
            boolean r18 = r4.changedInstance(r11)
            if (r18 == 0) goto L_0x0090
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0092
        L_0x0090:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x0092:
            r1 = r1 | r18
        L_0x0094:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00a7
            boolean r18 = r4.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00a3
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00a5
        L_0x00a3:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00a5:
            r1 = r1 | r18
        L_0x00a7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00ba
            boolean r18 = r4.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x00b6
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b8
        L_0x00b6:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b8:
            r1 = r1 | r18
        L_0x00ba:
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00cd
            boolean r18 = r4.changed((float) r8)
            if (r18 == 0) goto L_0x00c9
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00cb
        L_0x00c9:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00cb:
            r1 = r1 | r18
        L_0x00cd:
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00e0
            boolean r18 = r4.changed((float) r7)
            if (r18 == 0) goto L_0x00dc
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00de
        L_0x00dc:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00de:
            r1 = r1 | r18
        L_0x00e0:
            r18 = r76 & 14
            if (r18 != 0) goto L_0x00ef
            boolean r18 = r4.changed((float) r6)
            if (r18 == 0) goto L_0x00eb
            goto L_0x00ed
        L_0x00eb:
            r16 = 2
        L_0x00ed:
            r2 = r2 | r16
        L_0x00ef:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r1 & r16
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x010f
            r0 = r2 & 11
            r3 = 2
            if (r0 != r3) goto L_0x010f
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0105
            goto L_0x010f
        L_0x0105:
            r4.skipToGroupEnd()
            r74 = r2
            r35 = r4
            r2 = r11
            goto L_0x0620
        L_0x010f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x011d
            java.lang.String r0 = "androidx.compose.material3.SwitchImpl (Switch.kt:175)"
            r3 = -1968109941(0xffffffff8ab1068b, float:-1.7046941E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r2, r0)
        L_0x011d:
            int r0 = r1 >> 6
            r0 = r0 & 14
            r3 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            int r3 = r1 >> 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            androidx.compose.runtime.State r0 = r12.trackColor$material3_release(r13, r15, r4, r0)
            int r3 = r1 >> 18
            r3 = r3 & 14
            androidx.compose.runtime.State r3 = androidx.compose.foundation.interaction.PressInteractionKt.collectIsPressedAsState(r10, r4, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r74 = r2
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r16 = 0
            r17 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r11)
            java.lang.Object r18 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r2 = r18
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r16 = 0
            java.lang.Object r17 = r67.getValue()
            java.lang.Number r17 = (java.lang.Number) r17
            float r5 = r17.floatValue()
            float r2 = r2.m7531toDpu2uoSUM((float) r5)
            boolean r5 = SwitchImpl_0DmnUew$lambda$7(r3)
            if (r5 == 0) goto L_0x0173
            androidx.compose.material3.tokens.SwitchTokens r5 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r5 = r5.m4452getPressedHandleWidthD9Ej5fM()
            goto L_0x01a6
        L_0x0173:
            float r5 = ThumbDiameter
            r16 = 0
            float r17 = r5 - r8
            float r5 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r17)
            r16 = 0
            float r17 = r2 - r7
            float r16 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r17)
            r17 = 0
            float r19 = r6 - r7
            float r17 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r19)
            r19 = 0
            float r16 = r16 / r17
            r17 = 0
            float r19 = r5 * r16
            float r5 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r19)
            r16 = 0
            float r17 = r8 + r5
            float r17 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r17)
            r5 = r17
        L_0x01a6:
            r16 = r2
            r2 = -993794105(0xffffffffc4c3e7c7, float:-1567.243)
            r4.startReplaceableGroup(r2)
            java.lang.String r2 = "*199@7849L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            boolean r2 = SwitchImpl_0DmnUew$lambda$7(r3)
            if (r2 == 0) goto L_0x01f5
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r17 = 0
            r19 = 0
            r20 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r11)
            java.lang.Object r3 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r2 = r3
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 0
            if (r15 == 0) goto L_0x01ea
            float r11 = ThumbPathLength
            androidx.compose.material3.tokens.SwitchTokens r17 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r17 = r17.m4458getTrackOutlineWidthD9Ej5fM()
            r19 = 0
            float r21 = r11 - r17
            float r11 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r21)
            goto L_0x01f0
        L_0x01ea:
            androidx.compose.material3.tokens.SwitchTokens r11 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r11 = r11.m4458getTrackOutlineWidthD9Ej5fM()
        L_0x01f0:
            float r2 = r2.m7535toPx0680j_4(r11)
            goto L_0x0201
        L_0x01f5:
            r20 = r3
            java.lang.Object r2 = r67.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
        L_0x0201:
            r4.endReplaceableGroup()
            androidx.compose.material3.tokens.SwitchTokens r3 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getTrackShape()
            r11 = 6
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.material3.ShapesKt.toShape(r3, r4, r11)
            androidx.compose.ui.Modifier$Companion r17 = androidx.compose.ui.Modifier.Companion
            r11 = r17
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r17.getCenter()
            androidx.compose.ui.Modifier r6 = r14.align(r11, r6)
            float r11 = SwitchWidth
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m2327width3ABfNKs(r6, r11)
            float r11 = SwitchHeight
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m2308height3ABfNKs(r6, r11)
            androidx.compose.material3.tokens.SwitchTokens r11 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r11 = r11.m4458getTrackOutlineWidthD9Ej5fM()
            int r17 = r1 >> 6
            r17 = r17 & 14
            r21 = r1 & 112(0x70, float:1.57E-43)
            r17 = r17 | r21
            int r7 = r1 >> 3
            r7 = r7 & 896(0x380, float:1.256E-42)
            r7 = r17 | r7
            androidx.compose.runtime.State r7 = r12.borderColor$material3_release(r13, r15, r4, r7)
            java.lang.Object r7 = r7.getValue()
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r7 = r7.m4973unboximpl()
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BorderKt.m1888borderxT4_qwU(r6, r11, r7, r3)
            long r7 = SwitchImpl_0DmnUew$lambda$6(r0)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r6, r7, r3)
            r7 = 0
            r8 = r7
            r11 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            androidx.compose.ui.Alignment$Companion r22 = androidx.compose.ui.Alignment.Companion
            r23 = r0
            androidx.compose.ui.Alignment r0 = r22.getTopStart()
            r22 = r3
            r3 = 0
            int r24 = r8 >> 3
            r24 = r24 & 14
            int r25 = r8 >> 3
            r25 = r25 & 112(0x70, float:1.57E-43)
            r26 = r11
            r11 = r24 | r25
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r3, r4, r11)
            int r24 = r8 << 3
            r24 = r24 & 112(0x70, float:1.57E-43)
            r25 = 0
            r27 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r29 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r30 = r3
            r3 = r29
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r29 = 6
            r31 = 0
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            r32 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r14)
            java.lang.Object r0 = r4.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r29 = 6
            r31 = 0
            r33 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r7, r14)
            java.lang.Object r7 = r4.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = r7
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r29 = 6
            r31 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r14)
            java.lang.Object r9 = r4.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r7 = r9
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r29 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            r31 = r6
            int r6 = r24 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r19 = 6
            r6 = r6 | 6
            r34 = r29
            r29 = 0
            r35 = r14
            androidx.compose.runtime.Applier r14 = r4.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0315
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0315:
            r4.startReusableNode()
            boolean r14 = r4.getInserting()
            if (r14 == 0) goto L_0x0322
            r4.createNode(r9)
            goto L_0x0325
        L_0x0322:
            r4.useNode()
        L_0x0325:
            r4.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m4575constructorimpl(r4)
            r36 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r37 = androidx.compose.ui.node.ComposeUiNode.Companion
            r38 = r9
            kotlin.jvm.functions.Function2 r9 = r37.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r14, r11, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r14, r0, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r14, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r14, r7, r9)
            r4.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r9)
            int r14 = r6 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r36 = r0
            r0 = r34
            r0.invoke(r9, r4, r14)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r9)
            int r14 = r6 >> 9
            r14 = r14 & 14
            r34 = r4
            r37 = r34
            r34 = 0
            r9 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r40 = r0
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            r41 = r3
            r3 = r37
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r37 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r42 = r8 >> 6
            r42 = r42 & 112(0x70, float:1.57E-43)
            r19 = 6
            r42 = r42 | 6
            androidx.compose.foundation.layout.BoxScope r37 = (androidx.compose.foundation.layout.BoxScope) r37
            r43 = r37
            r37 = r3
            r51 = 0
            r9 = 1420969751(0x54b24717, float:6.1255749E12)
            r53 = r6
            java.lang.String r6 = "C223@8518L28,228@8706L42,231@8870L64,225@8599L815:Switch.kt#uh7d8r"
            r54 = r7
            r7 = r37
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r9, r6)
            int r6 = r1 >> 6
            r6 = r6 & 14
            r9 = r1 & 112(0x70, float:1.57E-43)
            r6 = r6 | r9
            int r9 = r1 >> 3
            r9 = r9 & 896(0x380, float:1.256E-42)
            r6 = r6 | r9
            androidx.compose.runtime.State r6 = r12.thumbColor$material3_release(r13, r15, r7, r6)
            r37 = r8
            long r8 = SwitchImpl_0DmnUew$lambda$13$lambda$10(r6)
            androidx.compose.ui.Modifier$Companion r44 = androidx.compose.ui.Modifier.Companion
            r55 = r6
            r6 = r44
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Alignment$Companion r44 = androidx.compose.ui.Alignment.Companion
            r56 = r11
            androidx.compose.ui.Alignment r11 = r44.getCenterStart()
            r57 = r14
            r14 = r43
            androidx.compose.ui.Modifier r6 = r14.align(r6, r11)
            java.lang.Float r11 = java.lang.Float.valueOf(r2)
            r17 = 0
            r43 = r17
            r44 = 0
            r58 = r14
            r14 = 1157296644(0x44faf204, float:2007.563)
            r7.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r14)
            boolean r14 = r7.changed((java.lang.Object) r11)
            r45 = r7
            r46 = 0
            r47 = r11
            java.lang.Object r11 = r45.rememberedValue()
            r48 = 0
            if (r14 != 0) goto L_0x0415
            androidx.compose.runtime.Composer$Companion r49 = androidx.compose.runtime.Composer.Companion
            r50 = r14
            java.lang.Object r14 = r49.getEmpty()
            if (r11 != r14) goto L_0x0410
            goto L_0x0417
        L_0x0410:
            r49 = r11
            r14 = r45
            goto L_0x0428
        L_0x0415:
            r50 = r14
        L_0x0417:
            r14 = 0
            r49 = r11
            androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1 r11 = new androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1
            r11.<init>(r2)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r14 = r45
            r14.updateRememberedValue(r11)
        L_0x0428:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.OffsetKt.offset(r6, r11)
            androidx.compose.material3.tokens.SwitchTokens r11 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r11 = r11.m4456getStateLayerSizeD9Ej5fM()
            r14 = 2
            r43 = 0
            r59 = r2
            float r2 = (float) r14
            float r2 = r11 / r2
            float r45 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r2)
            r44 = 0
            r46 = 0
            r49 = 54
            r50 = 4
            r48 = r7
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m3233rememberRipple9IZ8Weo(r44, r45, r46, r48, r49, r50)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.IndicationKt.indication(r6, r10, r2)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2314requiredSize3ABfNKs(r2, r5)
            r11 = r70
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r2, r8, r11)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getCenter()
            r14 = 48
            r43 = 0
            r44 = r5
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r7.startReplaceableGroup(r5)
            r5 = r33
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            r5 = 0
            int r21 = r14 >> 3
            r21 = r21 & 14
            int r33 = r14 >> 3
            r33 = r33 & 112(0x70, float:1.57E-43)
            r45 = r8
            r8 = r21 | r33
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r5, r7, r8)
            int r9 = r14 << 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r21 = 0
            r33 = r5
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r7.startReplaceableGroup(r5)
            r5 = r32
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r28 = 6
            r32 = 0
            r47 = r6
            r6 = r35
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r10, r6)
            java.lang.Object r10 = r7.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r5 = r10
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r28 = 6
            r32 = 0
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r11, r6)
            java.lang.Object r11 = r7.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r10 = r11
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r28 = 6
            r32 = 0
            r35 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r4, r6)
            java.lang.Object r4 = r7.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r18 = r2
            int r2 = r9 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r19 = 6
            r2 = r2 | 6
            r28 = 0
            r32 = r9
            androidx.compose.runtime.Applier r9 = r7.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0516
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0516:
            r7.startReusableNode()
            boolean r9 = r7.getInserting()
            if (r9 == 0) goto L_0x0523
            r7.createNode(r6)
            goto L_0x0526
        L_0x0523:
            r7.useNode()
        L_0x0526:
            r7.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m4575constructorimpl(r7)
            r48 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r49 = androidx.compose.ui.node.ComposeUiNode.Companion
            r50 = r6
            kotlin.jvm.functions.Function2 r6 = r49.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r5, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r9, r4, r6)
            r7.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r7)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r6)
            int r9 = r2 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r11.invoke(r6, r7, r9)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r7.startReplaceableGroup(r6)
            int r6 = r2 >> 9
            r6 = r6 & 14
            r9 = r7
            r39 = 0
            r48 = r2
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r2, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r14 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r19 = 6
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r19 = r9
            r49 = 0
            r52 = r0
            r0 = -2040677196(0xffffffff865dbcb4, float:-4.1704117E-35)
            r60 = r2
            java.lang.String r2 = "C:Switch.kt#uh7d8r"
            r61 = r4
            r4 = r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r2)
            r0 = 1420970387(0x54b24993, float:6.1259084E12)
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "238@9196L27,239@9240L150"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            r2 = r68
            if (r2 == 0) goto L_0x05e2
            int r0 = r1 >> 6
            r0 = r0 & 14
            r19 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r19
            r19 = r5
            int r5 = r1 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            androidx.compose.runtime.State r0 = r12.iconColor$material3_release(r13, r15, r4, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            r62 = r6
            java.lang.Object r6 = r0.getValue()
            androidx.compose.runtime.ProvidedValue r5 = r5.provides(r6)
            r6 = 1
            androidx.compose.runtime.ProvidedValue[] r6 = new androidx.compose.runtime.ProvidedValue[r6]
            r17 = 0
            r6[r17] = r5
            int r5 = r1 >> 12
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r2, (androidx.compose.runtime.Composer) r4, (int) r5)
            goto L_0x05e6
        L_0x05e2:
            r19 = r5
            r62 = r6
        L_0x05e6:
            r4.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r7.endReplaceableGroup()
            r7.endNode()
            r7.endReplaceableGroup()
            r7.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r35.endReplaceableGroup()
            r35.endNode()
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0620
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0620:
            androidx.compose.runtime.ScopeUpdateScope r14 = r35.endRestartGroup()
            if (r14 != 0) goto L_0x062d
            r18 = r74
            r17 = r1
            r19 = r35
            goto L_0x065b
        L_0x062d:
            androidx.compose.material3.SwitchKt$SwitchImpl$2 r16 = new androidx.compose.material3.SwitchKt$SwitchImpl$2
            r0 = r16
            r17 = r1
            r1 = r63
            r18 = r74
            r2 = r64
            r3 = r65
            r19 = r35
            r4 = r66
            r5 = r67
            r6 = r68
            r7 = r69
            r8 = r70
            r9 = r71
            r10 = r72
            r11 = r73
            r12 = r75
            r13 = r76
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x065b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.m3800SwitchImpl0DmnUew(androidx.compose.foundation.layout.BoxScope, boolean, boolean, androidx.compose.material3.SwitchColors, androidx.compose.runtime.State, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.graphics.Shape, float, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long SwitchImpl_0DmnUew$lambda$6(State<Color> $trackColor$delegate) {
        return ((Color) $trackColor$delegate.getValue()).m4973unboximpl();
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$7(State<Boolean> $isPressed$delegate) {
        return ((Boolean) $isPressed$delegate.getValue()).booleanValue();
    }

    private static final long SwitchImpl_0DmnUew$lambda$13$lambda$10(State<Color> $thumbColor$delegate) {
        return ((Color) $thumbColor$delegate.getValue()).m4973unboximpl();
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
