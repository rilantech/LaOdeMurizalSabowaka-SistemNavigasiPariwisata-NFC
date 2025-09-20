package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aS\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a1\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0010\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\r\"\u0019\u0010\u0013\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u0002²\u0006\n\u0010+\u001a\u00020,X\u0002²\u0006\n\u00105\u001a\u00020,X\u0002²\u0006\n\u00106\u001a\u00020,X\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float DefaultSwitchPadding = Dp.m7554constructorimpl((float) 2);
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold = Dp.m7554constructorimpl((float) 125);
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation = Dp.m7554constructorimpl((float) 1);
    private static final float ThumbDiameter;
    private static final float ThumbPathLength = Dp.m7554constructorimpl(TrackWidth - ThumbDiameter);
    private static final float ThumbPressedElevation = Dp.m7554constructorimpl((float) 6);
    private static final float ThumbRippleRadius = Dp.m7554constructorimpl((float) 24);
    private static final float TrackStrokeWidth = Dp.m7554constructorimpl((float) 14);
    private static final float TrackWidth;

    /* JADX WARNING: Removed duplicated region for block: B:110:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0315 A[LOOP:0: B:116:0x0313->B:117:0x0315, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0420  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x043a  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x044b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04da  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x062c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r44, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r45, androidx.compose.ui.Modifier r46, boolean r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.material.SwitchColors r49, androidx.compose.runtime.Composer r50, int r51, int r52) {
        /*
            r9 = r44
            r10 = r45
            r11 = r51
            r0 = 25866825(0x18ab249, float:5.094902E-38)
            r1 = r50
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Switch)P(!1,5,4,2,3)99@4619L39,100@4702L8,*103@4774L7,108@5156L34,109@5245L7,110@5322L314,118@5671L37,119@5735L29,120@5780L96,120@5769L107,123@5920L315,123@5881L354,132@6285L133,132@6240L178,137@6456L7,152@6897L1004:Switch.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r51
            r2 = r52 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            goto L_0x002b
        L_0x001d:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r8.changed((boolean) r9)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
        L_0x002b:
            r2 = r52 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0042
        L_0x0032:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0042
            boolean r2 = r8.changedInstance(r10)
            if (r2 == 0) goto L_0x003f
            r2 = 32
            goto L_0x0041
        L_0x003f:
            r2 = 16
        L_0x0041:
            r1 = r1 | r2
        L_0x0042:
            r2 = r52 & 4
            if (r2 == 0) goto L_0x004b
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r46
            goto L_0x0060
        L_0x004b:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005e
            r3 = r46
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005a
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r1 = r1 | r4
            goto L_0x0060
        L_0x005e:
            r3 = r46
        L_0x0060:
            r4 = r52 & 8
            if (r4 == 0) goto L_0x0069
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r47
            goto L_0x007e
        L_0x0069:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007c
            r5 = r47
            boolean r6 = r8.changed((boolean) r5)
            if (r6 == 0) goto L_0x0078
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r1 = r1 | r6
            goto L_0x007e
        L_0x007c:
            r5 = r47
        L_0x007e:
            r6 = r52 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r12 = r48
            goto L_0x009e
        L_0x0087:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r11
            if (r12 != 0) goto L_0x009c
            r12 = r48
            boolean r13 = r8.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0098
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r13
            goto L_0x009e
        L_0x009c:
            r12 = r48
        L_0x009e:
            r35 = 458752(0x70000, float:6.42848E-40)
            r13 = r11 & r35
            if (r13 != 0) goto L_0x00b9
            r13 = r52 & 32
            if (r13 != 0) goto L_0x00b3
            r15 = r49
            boolean r13 = r8.changed((java.lang.Object) r15)
            if (r13 == 0) goto L_0x00b5
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b3:
            r15 = r49
        L_0x00b5:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r1 = r1 | r13
            goto L_0x00bb
        L_0x00b9:
            r15 = r49
        L_0x00bb:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r1
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00d8
            boolean r13 = r8.getSkipping()
            if (r13 != 0) goto L_0x00cb
            goto L_0x00d8
        L_0x00cb:
            r8.skipToGroupEnd()
            r11 = r1
            r9 = r3
            r20 = r5
            r27 = r12
            r28 = r15
            goto L_0x0631
        L_0x00d8:
            r8.startDefaults()
            r13 = r11 & 1
            java.lang.String r14 = "CC(remember):Composables.kt#9igjgp"
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r36 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r13 == 0) goto L_0x0102
            boolean r13 = r8.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00ee
            goto L_0x0102
        L_0x00ee:
            r8.skipToGroupEnd()
            r2 = r52 & 32
            if (r2 == 0) goto L_0x00f7
            r1 = r1 & r36
        L_0x00f7:
            r7 = r3
            r20 = r5
            r27 = r12
            r6 = r14
            r28 = r15
            r15 = r1
            goto L_0x017b
        L_0x0102:
            if (r2 == 0) goto L_0x0109
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x010a
        L_0x0109:
            r2 = r3
        L_0x010a:
            if (r4 == 0) goto L_0x010e
            r3 = 1
            goto L_0x010f
        L_0x010e:
            r3 = r5
        L_0x010f:
            if (r6 == 0) goto L_0x013f
            r4 = 0
            r5 = 0
            r8.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r14)
            r6 = 0
            r13 = r8
            r16 = 0
            java.lang.Object r7 = r13.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r18.getEmpty()
            if (r7 != r0) goto L_0x0136
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r13.updateRememberedValue(r0)
            goto L_0x0137
        L_0x0136:
            r0 = r7
        L_0x0137:
            r8.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0140
        L_0x013f:
            r0 = r12
        L_0x0140:
            r4 = r52 & 32
            if (r4 == 0) goto L_0x0172
            androidx.compose.material.SwitchDefaults r12 = androidx.compose.material.SwitchDefaults.INSTANCE
            r33 = 6
            r34 = 1023(0x3ff, float:1.434E-42)
            r4 = 0
            r6 = r14
            r13 = r4
            r15 = r4
            r17 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r32 = 0
            r31 = r8
            androidx.compose.material.SwitchColors r4 = r12.m3146colorsSQMK_m0(r13, r15, r17, r18, r20, r22, r23, r25, r27, r29, r31, r32, r33, r34)
            r1 = r1 & r36
            r27 = r0
            r15 = r1
            r7 = r2
            r20 = r3
            r28 = r4
            goto L_0x017b
        L_0x0172:
            r6 = r14
            r28 = r49
            r27 = r0
            r15 = r1
            r7 = r2
            r20 = r3
        L_0x017b:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x018d
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.Switch (Switch.kt:94)"
            r2 = 25866825(0x18ab249, float:5.094902E-38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
        L_0x018d:
            r14 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r4)
            java.lang.Object r5 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r0 = r5
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 0
            float r2 = ThumbPathLength
            float r13 = r0.m7535toPx0680j_4(r2)
            r12 = 0
            r0 = r12
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            r2 = 0
            r5 = r8
            r6 = 0
            java.lang.Object r3 = r5.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r17.getEmpty()
            r11 = 0
            if (r3 != r12) goto L_0x01e3
            r12 = 0
            r48 = r0
            r17 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r17)
            r49 = r1
            r1 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r11, r1, r11)
            r5.updateRememberedValue(r0)
            goto L_0x01e8
        L_0x01e3:
            r48 = r0
            r49 = r1
            r0 = r3
        L_0x01e8:
            r8.endReplaceableGroup()
            r12 = r0
            androidx.compose.runtime.MutableState r12 = (androidx.compose.runtime.MutableState) r12
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r4)
            java.lang.Object r3 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r0 = r3
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r1 = 0
            float r2 = SwitchVelocityThreshold
            float r6 = r0.m7535toPx0680j_4(r2)
            java.lang.Float r0 = java.lang.Float.valueOf(r6)
            r1 = 0
            r2 = r1
            r1 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r3)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            boolean r3 = r8.changed((java.lang.Object) r0)
            r48 = r8
            r16 = 0
            java.lang.Object r11 = r48.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x0242
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r0
            java.lang.Object r0 = r18.getEmpty()
            if (r11 != r0) goto L_0x023c
            goto L_0x0244
        L_0x023c:
            r18 = r1
            r0 = r11
            r1 = r48
            goto L_0x0279
        L_0x0242:
            r19 = r0
        L_0x0244:
            r0 = 0
            androidx.compose.animation.core.TweenSpec r18 = AnimationSpec
            androidx.compose.material.AnchoredDraggableState r21 = new androidx.compose.material.AnchoredDraggableState
            java.lang.Boolean r37 = java.lang.Boolean.valueOf(r44)
            androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1 r22 = androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1.INSTANCE
            r38 = r22
            kotlin.jvm.functions.Function1 r38 = (kotlin.jvm.functions.Function1) r38
            r22 = r0
            androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2 r0 = new androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2
            r0.<init>(r6)
            r39 = r0
            kotlin.jvm.functions.Function0 r39 = (kotlin.jvm.functions.Function0) r39
            r40 = r18
            androidx.compose.animation.core.AnimationSpec r40 = (androidx.compose.animation.core.AnimationSpec) r40
            r42 = 16
            r43 = 0
            r41 = 0
            r36 = r21
            r36.<init>(r37, r38, r39, r40, r41, r42, r43)
            r0 = r21
            r18 = r1
            r1 = r48
            r1.updateRememberedValue(r0)
        L_0x0279:
            r8.endReplaceableGroup()
            r11 = r0
            androidx.compose.material.AnchoredDraggableState r11 = (androidx.compose.material.AnchoredDraggableState) r11
            int r0 = r15 >> 3
            r0 = r0 & 14
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r10, r8, r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r44)
            r1 = r15 & 14
            androidx.compose.runtime.State r2 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r8, r1)
            java.lang.Float r0 = java.lang.Float.valueOf(r14)
            java.lang.Float r1 = java.lang.Float.valueOf(r13)
            r16 = 48
            r17 = 0
            r48 = r6
            r6 = 1618982084(0x607fb4c4, float:7.370227E19)
            r8.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            boolean r6 = r8.changed((java.lang.Object) r11)
            boolean r18 = r8.changed((java.lang.Object) r0)
            r6 = r6 | r18
            boolean r18 = r8.changed((java.lang.Object) r1)
            r6 = r6 | r18
            r18 = r8
            r19 = 0
            r21 = r0
            java.lang.Object r0 = r18.rememberedValue()
            r22 = 0
            if (r6 != 0) goto L_0x02dc
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r0 != r1) goto L_0x02d7
            goto L_0x02de
        L_0x02d7:
            r23 = r0
            r1 = r18
            goto L_0x02ef
        L_0x02dc:
            r24 = r1
        L_0x02de:
            r1 = 0
            r23 = r0
            androidx.compose.material.SwitchKt$Switch$2$1 r0 = new androidx.compose.material.SwitchKt$Switch$2$1
            r0.<init>(r11, r14, r13)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = r18
            r1.updateRememberedValue(r0)
        L_0x02ef:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r8, r1)
            java.lang.Object[] r0 = new java.lang.Object[]{r11, r2, r3, r12}
            r1 = 8
            r6 = 0
            r16 = r1
            r1 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            r1 = 0
            r17 = r1
            int r1 = r0.length
            r18 = r5
            r5 = 0
        L_0x0313:
            if (r5 >= r1) goto L_0x0324
            r19 = r1
            r1 = r0[r5]
            boolean r21 = r8.changed((java.lang.Object) r1)
            r17 = r17 | r21
            int r5 = r5 + 1
            r1 = r19
            goto L_0x0313
        L_0x0324:
            r1 = r8
            r5 = 0
            r19 = r0
            java.lang.Object r0 = r1.rememberedValue()
            r29 = 0
            if (r17 != 0) goto L_0x033d
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r30 = r5
            java.lang.Object r5 = r21.getEmpty()
            if (r0 != r5) goto L_0x033b
            goto L_0x033f
        L_0x033b:
            r5 = r0
            goto L_0x0359
        L_0x033d:
            r30 = r5
        L_0x033f:
            r5 = 0
            androidx.compose.material.SwitchKt$Switch$3$1 r31 = new androidx.compose.material.SwitchKt$Switch$3$1
            r26 = 0
            r21 = r31
            r22 = r11
            r23 = r2
            r24 = r3
            r25 = r12
            r21.<init>(r22, r23, r24, r25, r26)
            kotlin.jvm.functions.Function2 r31 = (kotlin.jvm.functions.Function2) r31
            r5 = r31
            r1.updateRememberedValue(r5)
        L_0x0359:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0 = 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5, (androidx.compose.runtime.Composer) r8, (int) r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r44)
            boolean r1 = Switch$lambda$3(r12)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r44)
            r6 = r15 & 14
            r16 = 0
            r17 = r2
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            boolean r2 = r8.changed((java.lang.Object) r5)
            boolean r19 = r8.changed((java.lang.Object) r11)
            r2 = r2 | r19
            r19 = r8
            r21 = 0
            r22 = r3
            java.lang.Object r3 = r19.rememberedValue()
            r23 = 0
            if (r2 != 0) goto L_0x03b0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r2
            java.lang.Object r2 = r24.getEmpty()
            if (r3 != r2) goto L_0x03aa
            goto L_0x03b2
        L_0x03aa:
            r2 = r3
            r26 = r2
            r3 = r19
            goto L_0x03c6
        L_0x03b0:
            r25 = r2
        L_0x03b2:
            r2 = 0
            r24 = r2
            androidx.compose.material.SwitchKt$Switch$4$1 r2 = new androidx.compose.material.SwitchKt$Switch$4$1
            r26 = r3
            r3 = 0
            r2.<init>(r9, r11, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = r19
            r3.updateRememberedValue(r2)
        L_0x03c6:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = r15 & 14
            r3 = r3 | 512(0x200, float:7.175E-43)
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r0, r1, r2, r8, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r3, r4)
            java.lang.Object r3 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r0 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r16 = 1
            if (r3 != r0) goto L_0x03f2
            r25 = r16
            goto L_0x03f4
        L_0x03f2:
            r25 = 0
        L_0x03f4:
            if (r10 == 0) goto L_0x0420
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m6877getSwitcho7Vup1c()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m6865boximpl(r1)
            r3 = 0
            r1 = r44
            r29 = r17
            r2 = r27
            r30 = r22
            r4 = r20
            r6 = r18
            r31 = r48
            r9 = r6
            r6 = r45
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m2547toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x042c
        L_0x0420:
            r31 = r48
            r29 = r17
            r9 = r18
            r30 = r22
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x042c:
            if (r10 == 0) goto L_0x043a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x043e
        L_0x043a:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x043e:
            androidx.compose.ui.Modifier r1 = r7.then(r1)
            androidx.compose.ui.Modifier r21 = r1.then(r0)
            androidx.compose.foundation.gestures.Orientation r23 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r20 == 0) goto L_0x0450
            if (r10 == 0) goto L_0x0450
            r24 = r16
            goto L_0x0452
        L_0x0450:
            r24 = 0
        L_0x0452:
            r22 = r11
            r26 = r27
            androidx.compose.ui.Modifier r1 = androidx.compose.material.AnchoredDraggableKt.anchoredDraggable(r21, r22, r23, r24, r25, r26)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getCenter()
            r3 = 0
            r4 = 2
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r2, r5, r4, r3)
            float r2 = DefaultSwitchPadding
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m2248padding3ABfNKs(r1, r2)
            float r2 = SwitchWidth
            float r3 = SwitchHeight
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m2316requiredSizeVpY3zN4(r1, r2, r3)
            r2 = r5
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r8.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r5 = 0
            int r6 = r2 >> 3
            r6 = r6 & 14
            int r16 = r2 >> 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r6 = r6 | r16
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r5, r8, r6)
            int r16 = r2 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r21 = r16
            r22 = 0
            r46 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = 0
            int r23 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r0)
            androidx.compose.runtime.CompositionLocalMap r0 = r8.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r48 = r1
            int r1 = r21 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r49 = r16
            r50 = r17
            r24 = 0
            r26 = r3
            androidx.compose.runtime.Applier r3 = r8.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x04dd
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04dd:
            r8.startReusableNode()
            boolean r3 = r8.getInserting()
            if (r3 == 0) goto L_0x04ec
            r3 = r49
            r8.createNode(r3)
            goto L_0x04f1
        L_0x04ec:
            r3 = r49
            r8.useNode()
        L_0x04f1:
            r32 = r3
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r8)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r4
            kotlin.jvm.functions.Function2 r4 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r6, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r0, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r17 = 0
            r18 = r3
            r19 = 0
            boolean r33 = r18.getInserting()
            if (r33 != 0) goto L_0x0535
            r33 = r0
            java.lang.Object r0 = r18.rememberedValue()
            r34 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r23)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 != 0) goto L_0x0532
            goto L_0x0539
        L_0x0532:
            r5 = r18
            goto L_0x0549
        L_0x0535:
            r33 = r0
            r34 = r5
        L_0x0539:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r23)
            r5 = r18
            r5.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r23)
            r3.apply(r0, r4)
        L_0x0549:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r50
            r4.invoke(r0, r8, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r0)
            int r0 = r1 >> 9
            r0 = r0 & 14
            r3 = r8
            r5 = 0
            r50 = r0
            r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r36 = r1
            java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r2 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r37 = r12
            r16 = 0
            r12 = r0
            r0 = r3
            r38 = 0
            r47 = r2
            r2 = -1229337700(0xffffffffb6b9cb9c, float:-5.537133E-6)
            r39 = r4
            java.lang.String r4 = "C177@7792L42,173@7637L258:Switch.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r4)
            java.lang.Object r2 = r11.getTargetValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r4 = r16
            r16 = 0
            r17 = r4
            r4 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            boolean r4 = r0.changed((java.lang.Object) r11)
            r9 = r0
            r18 = 0
            r40 = r5
            java.lang.Object r5 = r9.rememberedValue()
            r19 = 0
            if (r4 != 0) goto L_0x05d2
            androidx.compose.runtime.Composer$Companion r41 = androidx.compose.runtime.Composer.Companion
            r42 = r4
            java.lang.Object r4 = r41.getEmpty()
            if (r5 != r4) goto L_0x05d0
            goto L_0x05d4
        L_0x05d0:
            r4 = r5
            goto L_0x05e3
        L_0x05d2:
            r42 = r4
        L_0x05d4:
            r4 = 0
            r41 = r4
            androidx.compose.material.SwitchKt$Switch$5$1$1 r4 = new androidx.compose.material.SwitchKt$Switch$5$1$1
            r4.<init>(r11)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r9.updateRememberedValue(r4)
        L_0x05e3:
            r0.endReplaceableGroup()
            r16 = r4
            kotlin.jvm.functions.Function0 r16 = (kotlin.jvm.functions.Function0) r16
            r17 = r27
            androidx.compose.foundation.interaction.InteractionSource r17 = (androidx.compose.foundation.interaction.InteractionSource) r17
            r4 = r1 & 14
            int r5 = r15 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            int r5 = r15 >> 6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            int r5 = r15 << 3
            r5 = r5 & r35
            r19 = r4 | r5
            r4 = r13
            r13 = r2
            r2 = r14
            r14 = r20
            r5 = r15
            r15 = r28
            r18 = r0
            SwitchImpl(r12, r13, r14, r15, r16, r17, r18, r19)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r8.endReplaceableGroup()
            r8.endNode()
            r8.endReplaceableGroup()
            r8.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x062f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x062f:
            r11 = r5
            r9 = r7
        L_0x0631:
            androidx.compose.runtime.ScopeUpdateScope r12 = r8.endRestartGroup()
            if (r12 != 0) goto L_0x0639
            r14 = r8
            goto L_0x0654
        L_0x0639:
            androidx.compose.material.SwitchKt$Switch$6 r13 = new androidx.compose.material.SwitchKt$Switch$6
            r0 = r13
            r1 = r44
            r2 = r45
            r3 = r9
            r4 = r20
            r5 = r27
            r6 = r28
            r7 = r51
            r14 = r8
            r8 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0654:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> $forceAnimationCheck$delegate) {
        return ((Boolean) $forceAnimationCheck$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> $forceAnimationCheck$delegate, boolean value) {
        $forceAnimationCheck$delegate.setValue(Boolean.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> $currentOnCheckedChange$delegate) {
        return (Function1) $currentOnCheckedChange$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> $currentChecked$delegate) {
        return ((Boolean) $currentChecked$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwitchImpl(androidx.compose.foundation.layout.BoxScope r39, boolean r40, boolean r41, androidx.compose.material.SwitchColors r42, kotlin.jvm.functions.Function0<java.lang.Float> r43, androidx.compose.foundation.interaction.InteractionSource r44, androidx.compose.runtime.Composer r45, int r46) {
        /*
            r8 = r39
            r9 = r40
            r10 = r41
            r11 = r42
            r12 = r43
            r13 = r44
            r14 = r46
            r0 = 70908914(0x439fbf2, float:2.1862333E-36)
            r1 = r45
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwitchImpl)P(!1,2!1,4)219@8983L46,221@9069L614,221@9035L648,240@9886L28,244@10009L81,241@9919L171,247@10120L28,248@10198L7,*249@10257L7,251@10368L6,250@10307L228,260@10627L43,263@10780L59,257@10540L475:Switch.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r46
            r2 = r14 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r7.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r1 = r1 | r2
        L_0x002c:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003c
            boolean r2 = r7.changed((boolean) r9)
            if (r2 == 0) goto L_0x0039
            r2 = 32
            goto L_0x003b
        L_0x0039:
            r2 = 16
        L_0x003b:
            r1 = r1 | r2
        L_0x003c:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x004c
            boolean r2 = r7.changed((boolean) r10)
            if (r2 == 0) goto L_0x0049
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x004b
        L_0x0049:
            r2 = 128(0x80, float:1.794E-43)
        L_0x004b:
            r1 = r1 | r2
        L_0x004c:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x005c
            boolean r2 = r7.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0059
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x005b
        L_0x0059:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x005b:
            r1 = r1 | r2
        L_0x005c:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x006e
            boolean r2 = r7.changedInstance(r12)
            if (r2 == 0) goto L_0x006b
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006d
        L_0x006b:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x006d:
            r1 = r1 | r2
        L_0x006e:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x007f
            boolean r2 = r7.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x007c
            r2 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007e
        L_0x007c:
            r2 = 65536(0x10000, float:9.18355E-41)
        L_0x007e:
            r1 = r1 | r2
        L_0x007f:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x0097
            boolean r1 = r7.getSkipping()
            if (r1 != 0) goto L_0x0090
            goto L_0x0097
        L_0x0090:
            r7.skipToGroupEnd()
            r38 = r15
            goto L_0x02fc
        L_0x0097:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00a3
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.SwitchImpl (Switch.kt:212)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x00a3:
            r0 = 0
            r1 = r0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            r3 = 0
            r4 = r7
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r17.getEmpty()
            if (r6 != r0) goto L_0x00cd
            r0 = 0
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r4.updateRememberedValue(r0)
            goto L_0x00ce
        L_0x00cd:
            r0 = r6
        L_0x00ce:
            r7.endReplaceableGroup()
            androidx.compose.runtime.snapshots.SnapshotStateList r0 = (androidx.compose.runtime.snapshots.SnapshotStateList) r0
            int r1 = r15 >> 15
            r1 = r1 & 14
            r1 = r1 | 48
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            boolean r3 = r7.changed((java.lang.Object) r13)
            boolean r4 = r7.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r7
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r16 = 0
            r17 = r1
            if (r3 != 0) goto L_0x0109
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r18.getEmpty()
            if (r6 != r1) goto L_0x0105
            goto L_0x0109
        L_0x0105:
            r20 = r2
            r1 = r6
            goto L_0x011b
        L_0x0109:
            r1 = 0
            r18 = r1
            androidx.compose.material.SwitchKt$SwitchImpl$1$1 r1 = new androidx.compose.material.SwitchKt$SwitchImpl$1$1
            r20 = r2
            r2 = 0
            r1.<init>(r13, r0, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4.updateRememberedValue(r1)
        L_0x011b:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            int r2 = r15 >> 15
            r2 = r2 & 14
            r2 = r2 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r7, (int) r2)
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r23 = r1
            if (r23 == 0) goto L_0x013b
            float r1 = ThumbPressedElevation
            goto L_0x013d
        L_0x013b:
            float r1 = ThumbDefaultElevation
        L_0x013d:
            r34 = r1
            int r1 = r15 >> 6
            r1 = r1 & 14
            r3 = r15 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r15 >> 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            androidx.compose.runtime.State r6 = r11.trackColor(r10, r9, r7, r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            androidx.compose.ui.Modifier r1 = r8.align(r1, r3)
            r3 = 0
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r1, r3, r2, r4)
            r2 = 0
            r3 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r7.startReplaceableGroup(r5)
            java.lang.String r4 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r4)
            boolean r16 = r7.changed((java.lang.Object) r6)
            r17 = r7
            r18 = 0
            java.lang.Object r5 = r17.rememberedValue()
            r20 = 0
            if (r16 != 0) goto L_0x0192
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r35 = r0
            java.lang.Object r0 = r21.getEmpty()
            if (r5 != r0) goto L_0x018c
            goto L_0x0194
        L_0x018c:
            r21 = r2
            r0 = r5
            r2 = r17
            goto L_0x01a7
        L_0x0192:
            r35 = r0
        L_0x0194:
            r0 = 0
            r21 = r0
            androidx.compose.material.SwitchKt$SwitchImpl$2$1 r0 = new androidx.compose.material.SwitchKt$SwitchImpl$2$1
            r0.<init>(r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r21 = r2
            r2 = r17
            r2.updateRememberedValue(r0)
        L_0x01a7:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r1, r0, r7, r2)
            int r0 = r15 >> 6
            r0 = r0 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r15 >> 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            androidx.compose.runtime.State r0 = r11.thumbColor(r10, r9, r7, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ElevationOverlayKt.getLocalElevationOverlay()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 6
            r3 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            r16 = r2
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r5, r2)
            java.lang.Object r17 = r7.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r36 = r17
            androidx.compose.material.ElevationOverlay r36 = (androidx.compose.material.ElevationOverlay) r36
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r3 = 6
            r16 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r5, r2)
            java.lang.Object r2 = r7.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r1 = r2.m7568unboximpl()
            r2 = 0
            float r3 = r1 + r34
            float r1 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r3)
            r5 = r4
            r4 = r1
            r1 = -539243578(0xffffffffdfdbcbc6, float:-3.167594E19)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "252@10443L36"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            long r1 = SwitchImpl$lambda$18(r0)
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r16 = r5
            r5 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r7, r5)
            r17 = r6
            long r5 = r3.m2955getSurface0d7_KjU()
            boolean r1 = androidx.compose.ui.graphics.Color.m4964equalsimpl0(r1, r5)
            if (r1 == 0) goto L_0x023c
            if (r36 == 0) goto L_0x023c
            long r2 = SwitchImpl$lambda$18(r0)
            r6 = 0
            r1 = r36
            r9 = r16
            r10 = 1157296644(0x44faf204, float:2007.563)
            r5 = r7
            r37 = r17
            long r1 = r1.m3014apply7g2Lkgo(r2, r4, r5, r6)
            goto L_0x0247
        L_0x023c:
            r9 = r16
            r37 = r17
            r10 = 1157296644(0x44faf204, float:2007.563)
            long r1 = SwitchImpl$lambda$18(r0)
        L_0x0247:
            r7.endReplaceableGroup()
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 14
            r38 = r15
            r15 = r1
            r20 = r7
            androidx.compose.runtime.State r1 = androidx.compose.animation.SingleValueAnimationKt.m1782animateColorAsStateeuL9pac(r15, r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenterStart()
            androidx.compose.ui.Modifier r2 = r8.align(r2, r3)
            int r3 = r38 >> 12
            r3 = r3 & 14
            r5 = 0
            r7.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r9)
            boolean r6 = r7.changed((java.lang.Object) r12)
            r9 = r7
            r10 = 0
            java.lang.Object r15 = r9.rememberedValue()
            r16 = 0
            if (r6 != 0) goto L_0x0293
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r22 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r15 != r0) goto L_0x0291
            goto L_0x0295
        L_0x0291:
            r0 = r15
            goto L_0x02a4
        L_0x0293:
            r22 = r0
        L_0x0295:
            r0 = 0
            r17 = r0
            androidx.compose.material.SwitchKt$SwitchImpl$3$1 r0 = new androidx.compose.material.SwitchKt$SwitchImpl$3$1
            r0.<init>(r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9.updateRememberedValue(r0)
        L_0x02a4:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r0)
            float r16 = ThumbRippleRadius
            r20 = 54
            r21 = 4
            r15 = 0
            r17 = 0
            r19 = r7
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m3233rememberRipple9IZ8Weo(r15, r16, r17, r19, r20, r21)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.IndicationKt.indication(r0, r13, r2)
            float r2 = ThumbDiameter
            androidx.compose.ui.Modifier r24 = androidx.compose.foundation.layout.SizeKt.m2314requiredSize3ABfNKs(r0, r2)
            androidx.compose.foundation.shape.RoundedCornerShape r0 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            r26 = r0
            androidx.compose.ui.graphics.Shape r26 = (androidx.compose.ui.graphics.Shape) r26
            r32 = 24
            r33 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r25 = r34
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ShadowKt.m4622shadows4CzXII$default(r24, r25, r26, r27, r28, r30, r32, r33)
            long r2 = SwitchImpl$lambda$19(r1)
            androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r0, r2, r5)
            r2 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r7, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02fc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02fc:
            androidx.compose.runtime.ScopeUpdateScope r9 = r7.endRestartGroup()
            if (r9 != 0) goto L_0x0304
            r15 = r7
            goto L_0x031e
        L_0x0304:
            androidx.compose.material.SwitchKt$SwitchImpl$4 r10 = new androidx.compose.material.SwitchKt$SwitchImpl$4
            r0 = r10
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r42
            r5 = r43
            r6 = r44
            r15 = r7
            r7 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x031e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.SwitchImpl(androidx.compose.foundation.layout.BoxScope, boolean, boolean, androidx.compose.material.SwitchColors, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final long SwitchImpl$lambda$16(State<Color> $trackColor$delegate) {
        return ((Color) $trackColor$delegate.getValue()).m4973unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> $thumbColor$delegate) {
        return ((Color) $thumbColor$delegate.getValue()).m4973unboximpl();
    }

    private static final long SwitchImpl$lambda$19(State<Color> $resolvedThumbColor$delegate) {
        return ((Color) $resolvedThumbColor$delegate.getValue()).m4973unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk  reason: not valid java name */
    public static final void m3148drawTrackRPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        float strokeRadius = strokeWidth / ((float) 2);
        DrawScope.m5544drawLineNGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, OffsetKt.Offset(strokeRadius, Offset.m4714getYimpl($this$drawTrack_u2dRPmYEkk.m5575getCenterF1C5BW0())), OffsetKt.Offset(trackWidth - strokeRadius, Offset.m4714getYimpl($this$drawTrack_u2dRPmYEkk.m5575getCenterF1C5BW0())), strokeWidth, StrokeCap.Companion.m5352getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
    }

    static {
        float r0 = Dp.m7554constructorimpl((float) 34);
        TrackWidth = r0;
        float r1 = Dp.m7554constructorimpl((float) 20);
        ThumbDiameter = r1;
        SwitchWidth = r0;
        SwitchHeight = r1;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }
}
