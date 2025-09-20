package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÊ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2z\u0010\u000f\u001av\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material3/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v8, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v74, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0537  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x057b  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x057e  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0586  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0619  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0627  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x06fb  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m3856TransitionDTcfvLk(androidx.compose.material3.InputPhase r36, long r37, long r39, kotlin.jvm.functions.Function3<? super androidx.compose.material3.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r41, boolean r42, kotlin.jvm.functions.Function7<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45) {
        /*
            r35 = this;
            r11 = r36
            r12 = r41
            r13 = r42
            r14 = r43
            r15 = r45
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "contentColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -995111872(0xffffffffc4afcc40, float:-1406.3828)
            r1 = r44
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)310@12822L59,312@12923L325,323@13295L1101,351@14444L354,362@14846L299,372@15191L186,378@15387L174:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r45
            r1 = r15 & 14
            if (r1 != 0) goto L_0x0038
            boolean r1 = r10.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0036
            r1 = 4
            goto L_0x0037
        L_0x0036:
            r1 = 2
        L_0x0037:
            r0 = r0 | r1
        L_0x0038:
            r1 = r15 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004b
            r8 = r37
            boolean r1 = r10.changed((long) r8)
            if (r1 == 0) goto L_0x0047
            r1 = 32
            goto L_0x0049
        L_0x0047:
            r1 = 16
        L_0x0049:
            r0 = r0 | r1
            goto L_0x004d
        L_0x004b:
            r8 = r37
        L_0x004d:
            r1 = r15 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0060
            r4 = r39
            boolean r1 = r10.changed((long) r4)
            if (r1 == 0) goto L_0x005c
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r1 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r0 = r0 | r1
            goto L_0x0062
        L_0x0060:
            r4 = r39
        L_0x0062:
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0072
            boolean r1 = r10.changedInstance(r12)
            if (r1 == 0) goto L_0x006f
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0071
        L_0x006f:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0071:
            r0 = r0 | r1
        L_0x0072:
            r16 = 57344(0xe000, float:8.0356E-41)
            r1 = r15 & r16
            if (r1 != 0) goto L_0x0085
            boolean r1 = r10.changed((boolean) r13)
            if (r1 == 0) goto L_0x0082
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r0 = r0 | r1
        L_0x0085:
            r17 = 458752(0x70000, float:6.42848E-40)
            r1 = r15 & r17
            if (r1 != 0) goto L_0x0097
            boolean r1 = r10.changedInstance(r14)
            if (r1 == 0) goto L_0x0094
            r1 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0096
        L_0x0094:
            r1 = 65536(0x10000, float:9.18355E-41)
        L_0x0096:
            r0 = r0 | r1
        L_0x0097:
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r0
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x00ad
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x00a7
            goto L_0x00ad
        L_0x00a7:
            r10.skipToGroupEnd()
            r12 = r0
            goto L_0x06fe
        L_0x00ad:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r7 = -1
            if (r1 == 0) goto L_0x00bc
            r1 = -995111872(0xffffffffc4afcc40, float:-1406.3828)
            java.lang.String r2 = "androidx.compose.material3.TextFieldTransitionScope.Transition (TextFieldImpl.kt:293)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r7, r2)
        L_0x00bc:
            r1 = r0 & 14
            r1 = r1 | 48
            r2 = 0
            java.lang.String r3 = "TextFieldInputState"
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r11, (java.lang.String) r3, (androidx.compose.runtime.Composer) r10, (int) r1, (int) r2)
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = r1
            r19 = r18
            java.lang.String r6 = "LabelProgress"
            r2 = 384(0x180, float:5.38E-43)
            r20 = r2
            r21 = 0
            r1 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r10.startReplaceableGroup(r1)
            java.lang.String r7 = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            kotlin.jvm.internal.FloatCompanionObject r22 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r22 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r22)
            r23 = r20 & 14
            int r1 = r20 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r23 | r1
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & r16
            r2 = r2 | r1
            r9 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r1 = r19
            r24 = r2
            r25 = 0
            r8 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r8)
            java.lang.String r2 = "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r26 = r1.getCurrentState()
            int r27 = r24 >> 9
            r8 = r27 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r26 = (androidx.compose.material3.InputPhase) r26
            r27 = r10
            r29 = 0
            r9 = 240378898(0xe53e412, float:2.611757E-30)
            r31 = r2
            r2 = r27
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "C:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            boolean r32 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r32 == 0) goto L_0x013d
            r32 = r3
            java.lang.String r3 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)"
            r4 = 240378898(0xe53e412, float:2.611757E-30)
            r5 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r8, r5, r3)
            goto L_0x013f
        L_0x013d:
            r32 = r3
        L_0x013f:
            int[] r3 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r4 = r26.ordinal()
            r3 = r3[r4]
            r33 = 0
            r34 = 1065353216(0x3f800000, float:1.0)
            switch(r3) {
                case 1: goto L_0x015b;
                case 2: goto L_0x0158;
                case 3: goto L_0x0155;
                default: goto L_0x014e;
            }
        L_0x014e:
            r12 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0155:
            r3 = r34
            goto L_0x015d
        L_0x0158:
            r3 = r33
            goto L_0x015d
        L_0x015b:
            r3 = r34
        L_0x015d:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0166
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0166:
            r2.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r3)
            r8 = r31
            r5 = 384(0x180, float:5.38E-43)
            java.lang.Object r3 = r1.getTargetState()
            int r4 = r24 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r3 = (androidx.compose.material3.InputPhase) r3
            r23 = r10
            r26 = 0
            r5 = r23
            r23 = r7
            r7 = 240378898(0xe53e412, float:2.611757E-30)
            r5.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            boolean r27 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r27 == 0) goto L_0x019b
            r31 = r8
            java.lang.String r8 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)"
            r11 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r11, r8)
            goto L_0x019e
        L_0x019b:
            r31 = r8
            r11 = -1
        L_0x019e:
            int[] r7 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r8 = r3.ordinal()
            r7 = r7[r8]
            switch(r7) {
                case 1: goto L_0x01b6;
                case 2: goto L_0x01b3;
                case 3: goto L_0x01b0;
                default: goto L_0x01a9;
            }
        L_0x01a9:
            r12 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01b0:
            r7 = r34
            goto L_0x01b8
        L_0x01b3:
            r7 = r33
            goto L_0x01b8
        L_0x01b6:
            r7 = r34
        L_0x01b8:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x01c1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c1:
            r5.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            r8 = r32
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r24 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r8.invoke(r4, r10, r5)
            r26 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r26 = (androidx.compose.animation.core.FiniteAnimationSpec) r26
            r4 = r24 & 14
            int r5 = r24 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r24 << 6
            r5 = r5 & r17
            r27 = r4 | r5
            r4 = r26
            r7 = 384(0x180, float:5.38E-43)
            r5 = r22
            r14 = r11
            r11 = r23
            r23 = r7
            r7 = r10
            r28 = r8
            r14 = r31
            r15 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r8 = r27
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r19 = r4
            androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r20 = r18
            r8 = r1
            java.lang.String r6 = "PlaceholderOpacity"
            r21 = r23
            r22 = 0
            r1 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r24 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = r21 & 14
            int r2 = r21 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r21 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r21 << 3
            r2 = r2 & r16
            r25 = r1 | r2
            r1 = r20
            r26 = 0
            r10.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r25 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r4 = r10
            r5 = 0
            r7 = 2067512179(0x7b3bbb73, float:9.747614E35)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            boolean r27 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r27 == 0) goto L_0x0269
            java.lang.String r15 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)"
            r28 = r5
            r5 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r15)
            goto L_0x026b
        L_0x0269:
            r28 = r5
        L_0x026b:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r15 = r2.ordinal()
            r5 = r5[r15]
            switch(r5) {
                case 1: goto L_0x0288;
                case 2: goto L_0x0280;
                case 3: goto L_0x027d;
                default: goto L_0x0276;
            }
        L_0x0276:
            r12 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x027d:
            r5 = r33
            goto L_0x028a
        L_0x0280:
            if (r13 == 0) goto L_0x0285
            r5 = r33
            goto L_0x028a
        L_0x0285:
            r5 = r34
            goto L_0x028a
        L_0x0288:
            r5 = r34
        L_0x028a:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0293
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0293:
            r4.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r5)
            java.lang.Object r3 = r1.getTargetState()
            int r4 = r25 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r3 = (androidx.compose.material3.InputPhase) r3
            r5 = r10
            r15 = 0
            r5.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            boolean r28 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r28 == 0) goto L_0x02bc
            r28 = r15
            java.lang.String r15 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:343)"
            r12 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r12, r15)
            goto L_0x02be
        L_0x02bc:
            r28 = r15
        L_0x02be:
            int[] r7 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r12 = r3.ordinal()
            r7 = r7[r12]
            switch(r7) {
                case 1: goto L_0x02db;
                case 2: goto L_0x02d3;
                case 3: goto L_0x02d0;
                default: goto L_0x02c9;
            }
        L_0x02c9:
            r12 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02d0:
            r7 = r33
            goto L_0x02dd
        L_0x02d3:
            if (r13 == 0) goto L_0x02d8
            r7 = r33
            goto L_0x02dd
        L_0x02d8:
            r7 = r34
            goto L_0x02dd
        L_0x02db:
            r7 = r34
        L_0x02dd:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x02e6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e6:
            r5.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r25 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r8.invoke(r4, r10, r5)
            r12 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r4 = r25 & 14
            int r5 = r25 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r25 << 6
            r5 = r5 & r17
            r15 = r4 | r5
            r4 = r12
            r5 = r24
            r7 = r10
            r29 = r8
            r8 = r15
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r12 = r4
            androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r15 = r18
            r8 = r1
            r20 = r23
            java.lang.String r6 = "PrefixSuffixOpacity"
            r21 = 0
            r1 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = r20 & 14
            int r2 = r20 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & r16
            r22 = r1 | r2
            r1 = r15
            r24 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r22 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r4 = r10
            r5 = 0
            r7 = 5829913(0x58f519, float:8.169448E-39)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            boolean r25 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r25 == 0) goto L_0x0381
            r25 = r5
            java.lang.String r5 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)"
            r26 = r15
            r15 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r15, r5)
            goto L_0x0385
        L_0x0381:
            r25 = r5
            r26 = r15
        L_0x0385:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r15 = r2.ordinal()
            r5 = r5[r15]
            switch(r5) {
                case 1: goto L_0x03a4;
                case 2: goto L_0x039c;
                case 3: goto L_0x0399;
                default: goto L_0x0390;
            }
        L_0x0390:
            r28 = r12
            r12 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0399:
            r5 = r34
            goto L_0x03a6
        L_0x039c:
            if (r13 == 0) goto L_0x03a1
            r5 = r33
            goto L_0x03a6
        L_0x03a1:
            r5 = r34
            goto L_0x03a6
        L_0x03a4:
            r5 = r34
        L_0x03a6:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x03af
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03af:
            r4.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r5)
            java.lang.Object r3 = r1.getTargetState()
            int r4 = r22 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r3 = (androidx.compose.material3.InputPhase) r3
            r5 = r10
            r15 = 0
            r5.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            boolean r25 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r25 == 0) goto L_0x03da
            r25 = r15
            java.lang.String r15 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:354)"
            r28 = r12
            r12 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r4, r12, r15)
            goto L_0x03de
        L_0x03da:
            r28 = r12
            r25 = r15
        L_0x03de:
            int[] r7 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r12 = r3.ordinal()
            r7 = r7[r12]
            switch(r7) {
                case 1: goto L_0x03f9;
                case 2: goto L_0x03f3;
                case 3: goto L_0x03f0;
                default: goto L_0x03e9;
            }
        L_0x03e9:
            r12 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x03f0:
            r33 = r34
            goto L_0x03fb
        L_0x03f3:
            if (r13 == 0) goto L_0x03f6
            goto L_0x03fb
        L_0x03f6:
            r33 = r34
            goto L_0x03fb
        L_0x03f9:
            r33 = r34
        L_0x03fb:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0404
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0404:
            r5.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r33)
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r22 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r8.invoke(r4, r10, r5)
            r12 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r4 = r22 & 14
            int r5 = r22 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r22 << 6
            r5 = r5 & r17
            r15 = r4 | r5
            r4 = r12
            r5 = r11
            r7 = r10
            r29 = r8
            r8 = r15
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r11 = r4
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r12 = r18
            java.lang.String r6 = "LabelTextStyleColor"
            r15 = r1
            r20 = r23
            r21 = 0
            r1 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r12.getTargetState()
            int r2 = r20 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r1 = (androidx.compose.material3.InputPhase) r1
            r3 = r10
            r4 = 0
            r5 = -1468066062(0xffffffffa87f16f2, float:-1.4160319E-14)
            r3.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0477
            java.lang.String r7 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)"
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r2, r8, r7)
        L_0x0477:
            int[] r7 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r8 = r1.ordinal()
            r7 = r7[r8]
            r8 = 1
            if (r7 != r8) goto L_0x0485
            r7 = r37
            goto L_0x0487
        L_0x0485:
            r7 = r39
        L_0x0487:
            boolean r22 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r22 == 0) goto L_0x0490
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0490:
            r3.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r8 = androidx.compose.ui.graphics.Color.m4967getColorSpaceimpl(r7)
            r1 = 8
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r8)
            r4 = r10
            r7 = 0
            java.lang.Object r5 = r4.rememberedValue()
            r24 = 0
            if (r3 != 0) goto L_0x04c0
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            r26 = r1
            java.lang.Object r1 = r25.getEmpty()
            if (r5 != r1) goto L_0x04be
            goto L_0x04c2
        L_0x04be:
            r1 = r5
            goto L_0x04d6
        L_0x04c0:
            r26 = r1
        L_0x04c2:
            r1 = 0
            androidx.compose.ui.graphics.Color$Companion r25 = androidx.compose.ui.graphics.Color.Companion
            r29 = r1
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r25)
            java.lang.Object r1 = r1.invoke(r8)
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            r4.updateRememberedValue(r1)
        L_0x04d6:
            r10.endReplaceableGroup()
            r24 = r1
            androidx.compose.animation.core.TwoWayConverter r24 = (androidx.compose.animation.core.TwoWayConverter) r24
            r1 = r20 & 14
            r1 = r1 | 64
            int r2 = r20 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & r16
            r25 = r1 | r2
            r1 = r12
            r26 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r25 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r2 = (androidx.compose.material3.InputPhase) r2
            r4 = r10
            r5 = 0
            r7 = -1468066062(0xffffffffa87f16f2, float:-1.4160319E-14)
            r4.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            boolean r22 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r22 == 0) goto L_0x0525
            r29 = r5
            java.lang.String r5 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)"
            r30 = r8
            r8 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r8, r5)
            goto L_0x0529
        L_0x0525:
            r29 = r5
            r30 = r8
        L_0x0529:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r7 = r2.ordinal()
            r5 = r5[r7]
            r7 = 1
            if (r5 != r7) goto L_0x0537
            r7 = r37
            goto L_0x0539
        L_0x0537:
            r7 = r39
        L_0x0539:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0542
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0542:
            r4.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4953boximpl(r7)
            java.lang.Object r3 = r1.getTargetState()
            int r4 = r25 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            androidx.compose.material3.InputPhase r3 = (androidx.compose.material3.InputPhase) r3
            r5 = r10
            r7 = 0
            r8 = -1468066062(0xffffffffa87f16f2, float:-1.4160319E-14)
            r5.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x056e
            java.lang.String r9 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:365)"
            r22 = r7
            r7 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r4, r7, r9)
            goto L_0x0570
        L_0x056e:
            r22 = r7
        L_0x0570:
            int[] r7 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r8 = r3.ordinal()
            r7 = r7[r8]
            r8 = 1
            if (r7 != r8) goto L_0x057e
            r8 = r37
            goto L_0x0580
        L_0x057e:
            r8 = r39
        L_0x0580:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0589
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0589:
            r5.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4953boximpl(r8)
            androidx.compose.animation.core.Transition$Segment r4 = r1.getSegment()
            int r5 = r25 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r4 = r15.invoke(r4, r10, r5)
            r9 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r4 = r25 & 14
            int r5 = r25 << 9
            r5 = r5 & r16
            r4 = r4 | r5
            int r5 = r25 << 6
            r5 = r5 & r17
            r8 = r4 | r5
            r4 = r9
            r5 = r24
            r7 = r10
            r22 = r30
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r9 = r4
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2 r1 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r3 = r23
            r2 = r2 | r3
            r12 = r1
            r15 = r18
            r20 = r2
            java.lang.String r6 = "LabelContentColor"
            r21 = 0
            r1 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            java.lang.Object r1 = r15.getTargetState()
            int r2 = r20 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8 = r41
            java.lang.Object r1 = r8.invoke(r1, r10, r2)
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m4973unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r7 = androidx.compose.ui.graphics.Color.m4967getColorSpaceimpl(r1)
            r1 = 8
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r7)
            r4 = r10
            r5 = 0
            r44 = r1
            java.lang.Object r1 = r4.rememberedValue()
            r22 = 0
            if (r3 != 0) goto L_0x0627
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r2
            java.lang.Object r2 = r23.getEmpty()
            if (r1 != r2) goto L_0x0624
            goto L_0x0629
        L_0x0624:
            r25 = r1
            goto L_0x063d
        L_0x0627:
            r24 = r2
        L_0x0629:
            r2 = 0
            androidx.compose.ui.graphics.Color$Companion r23 = androidx.compose.ui.graphics.Color.Companion
            r25 = r1
            kotlin.jvm.functions.Function1 r1 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r23)
            java.lang.Object r1 = r1.invoke(r7)
            androidx.compose.animation.core.TwoWayConverter r1 = (androidx.compose.animation.core.TwoWayConverter) r1
            r4.updateRememberedValue(r1)
        L_0x063d:
            r10.endReplaceableGroup()
            r22 = r1
            androidx.compose.animation.core.TwoWayConverter r22 = (androidx.compose.animation.core.TwoWayConverter) r22
            r1 = r20 & 14
            r1 = r1 | 64
            int r2 = r20 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r20 << 3
            r2 = r2 & r16
            r2 = r2 | r1
            r1 = r15
            r23 = r2
            r24 = 0
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r10.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r2 = r1.getCurrentState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r14 = r8.invoke(r2, r10, r3)
            java.lang.Object r2 = r1.getTargetState()
            int r3 = r23 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r25 = r8.invoke(r2, r10, r3)
            androidx.compose.animation.core.Transition$Segment r2 = r1.getSegment()
            int r3 = r23 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r12.invoke(r2, r10, r3)
            r26 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r26 = (androidx.compose.animation.core.FiniteAnimationSpec) r26
            r2 = r23 & 14
            int r3 = r23 << 9
            r3 = r3 & r16
            r2 = r2 | r3
            int r3 = r23 << 6
            r3 = r3 & r17
            r16 = r2 | r3
            r2 = r14
            r3 = r25
            r4 = r26
            r5 = r22
            r27 = r7
            r7 = r10
            r8 = r16
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r8 = r2
            float r1 = Transition_DTcfvLk$lambda$1(r19)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            long r2 = Transition_DTcfvLk$lambda$7(r9)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4953boximpl(r2)
            long r3 = Transition_DTcfvLk$lambda$8(r8)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m4953boximpl(r3)
            float r4 = Transition_DTcfvLk$lambda$3(r28)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            float r5 = Transition_DTcfvLk$lambda$5(r11)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r6 = r0 & r17
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r12 = r0
            r0 = r43
            r6 = r10
            r0.invoke(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06fe
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06fe:
            androidx.compose.runtime.ScopeUpdateScope r11 = r10.endRestartGroup()
            if (r11 != 0) goto L_0x0706
            r15 = r10
            goto L_0x0722
        L_0x0706:
            androidx.compose.material3.TextFieldTransitionScope$Transition$1 r14 = new androidx.compose.material3.TextFieldTransitionScope$Transition$1
            r0 = r14
            r1 = r35
            r2 = r36
            r3 = r37
            r5 = r39
            r7 = r41
            r8 = r42
            r9 = r43
            r15 = r10
            r10 = r45
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r11.updateScope(r14)
        L_0x0722:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldTransitionScope.m3856TransitionDTcfvLk(androidx.compose.material3.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> $labelProgress$delegate) {
        return ((Number) $labelProgress$delegate.getValue()).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> $placeholderOpacity$delegate) {
        return ((Number) $placeholderOpacity$delegate.getValue()).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> $prefixSuffixOpacity$delegate) {
        return ((Number) $prefixSuffixOpacity$delegate.getValue()).floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$7(State<Color> $labelTextStyleColor$delegate) {
        return ((Color) $labelTextStyleColor$delegate.getValue()).m4973unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> $labelContentColor$delegate) {
        return ((Color) $labelContentColor$delegate.getValue()).m4973unboximpl();
    }
}
