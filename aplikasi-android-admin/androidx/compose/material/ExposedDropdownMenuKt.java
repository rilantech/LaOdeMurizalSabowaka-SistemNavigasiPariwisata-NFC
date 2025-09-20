package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0013X\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0013X\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release", "width", "menuHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x042c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r38, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r39, androidx.compose.ui.Modifier r40, kotlin.jvm.functions.Function3<? super androidx.compose.material.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r7 = r38
            r8 = r39
            r9 = r41
            r10 = r43
            java.lang.String r0 = "onExpandedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1456052980(0x56c99af4, float:1.10833678E14)
            r1 = r42
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExposedDropdownMenuBox)P(1,3,2)96@4191L7,97@4224L7,98@4249L33,99@4305L33,101@4439L37,103@4494L486,116@5006L29,130@5417L31,131@5474L38,118@5041L550,137@5608L59,137@5597L70,141@5673L441:ExposedDropdownMenu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r43
            r2 = r44 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((boolean) r7)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r44 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            goto L_0x004f
        L_0x003f:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            boolean r2 = r11.changedInstance(r8)
            if (r2 == 0) goto L_0x004c
            r2 = 32
            goto L_0x004e
        L_0x004c:
            r2 = 16
        L_0x004e:
            r1 = r1 | r2
        L_0x004f:
            r2 = r44 & 4
            if (r2 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r40
            goto L_0x006d
        L_0x0058:
            r3 = r10 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006b
            r3 = r40
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0067
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r4
            goto L_0x006d
        L_0x006b:
            r3 = r40
        L_0x006d:
            r4 = r44 & 8
            if (r4 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0074:
            r4 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0084
            boolean r4 = r11.changedInstance(r9)
            if (r4 == 0) goto L_0x0081
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r4
        L_0x0084:
            r12 = r1
            r1 = r12 & 5851(0x16db, float:8.199E-42)
            r4 = 1170(0x492, float:1.64E-42)
            if (r1 != r4) goto L_0x0099
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0092
            goto L_0x0099
        L_0x0092:
            r11.skipToGroupEnd()
            r17 = r3
            goto L_0x046c
        L_0x0099:
            if (r2 == 0) goto L_0x00a0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00a1
        L_0x00a0:
            r1 = r3
        L_0x00a1:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ad
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:90)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r2, r3)
        L_0x00ad:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r5)
            java.lang.Object r6 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = r6
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r6 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r5)
            java.lang.Object r4 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r2 = r4
            android.view.View r2 = (android.view.View) r2
            r3 = 0
            r4 = r3
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            java.lang.String r13 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            r14 = 0
            r15 = r11
            r16 = 0
            java.lang.Object r6 = r15.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r6 != r3) goto L_0x0109
            r3 = 0
            r18 = 0
            androidx.compose.runtime.MutableIntState r3 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r18)
            r15.updateRememberedValue(r3)
            goto L_0x010a
        L_0x0109:
            r3 = r6
        L_0x010a:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableIntState r3 = (androidx.compose.runtime.MutableIntState) r3
            r4 = 0
            r5 = r4
            r4 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            r6 = 0
            r14 = r11
            r15 = 0
            r16 = r4
            java.lang.Object r4 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r19 = r5
            java.lang.Object r5 = r18.getEmpty()
            if (r4 != r5) goto L_0x013f
            r5 = 0
            r18 = 0
            androidx.compose.runtime.MutableIntState r5 = androidx.compose.runtime.SnapshotIntStateKt.mutableIntStateOf(r18)
            r14.updateRememberedValue(r5)
            goto L_0x0140
        L_0x013f:
            r5 = r4
        L_0x0140:
            r11.endReplaceableGroup()
            r4 = r5
            androidx.compose.runtime.MutableIntState r4 = (androidx.compose.runtime.MutableIntState) r4
            r5 = r0
            r6 = 0
            float r14 = androidx.compose.material.MenuKt.getMenuVerticalMargin()
            int r5 = r5.m7529roundToPx0680j_4(r14)
            r6 = 0
            r14 = r6
            r6 = 0
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            r15 = 0
            r16 = r11
            r17 = 0
            r18 = r6
            java.lang.Object r6 = r16.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r20.getEmpty()
            if (r6 != r10) goto L_0x0184
            r10 = 0
            androidx.compose.ui.node.Ref r20 = new androidx.compose.ui.node.Ref
            r20.<init>()
            r10 = r20
            r20 = r6
            r6 = r16
            r6.updateRememberedValue(r10)
            goto L_0x018a
        L_0x0184:
            r20 = r6
            r6 = r16
            r10 = r20
        L_0x018a:
            r11.endReplaceableGroup()
            r6 = r10
            androidx.compose.ui.node.Ref r6 = (androidx.compose.ui.node.Ref) r6
            int r10 = ExposedDropdownMenuBox$lambda$4(r4)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r14 = ExposedDropdownMenuBox$lambda$1(r3)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r15 = 0
            r16 = 0
            r17 = r15
            r15 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            boolean r15 = r11.changed((java.lang.Object) r0)
            boolean r18 = r11.changed((java.lang.Object) r10)
            r15 = r15 | r18
            boolean r18 = r11.changed((java.lang.Object) r14)
            r15 = r15 | r18
            r18 = r11
            r19 = 0
            r20 = r10
            java.lang.Object r10 = r18.rememberedValue()
            r21 = 0
            if (r15 != 0) goto L_0x01e0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r14
            java.lang.Object r14 = r22.getEmpty()
            if (r10 != r14) goto L_0x01db
            goto L_0x01e2
        L_0x01db:
            r22 = r10
            r14 = r18
            goto L_0x01f1
        L_0x01e0:
            r23 = r14
        L_0x01e2:
            r14 = 0
            r22 = r10
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r10 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
            r10.<init>(r0, r4, r3)
            r14 = r18
            r14.updateRememberedValue(r10)
        L_0x01f1:
            r11.endReplaceableGroup()
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r10 = (androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) r10
            r14 = 0
            r15 = r14
            r14 = 0
            r19 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            r0 = 0
            r13 = r11
            r16 = 0
            r40 = r0
            java.lang.Object r0 = r13.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r20 = r14
            java.lang.Object r14 = r18.getEmpty()
            if (r0 != r14) goto L_0x0229
            r14 = 0
            androidx.compose.ui.focus.FocusRequester r18 = new androidx.compose.ui.focus.FocusRequester
            r18.<init>()
            r14 = r18
            r13.updateRememberedValue(r14)
            goto L_0x022a
        L_0x0229:
            r14 = r0
        L_0x022a:
            r11.endReplaceableGroup()
            r0 = r14
            androidx.compose.ui.focus.FocusRequester r0 = (androidx.compose.ui.focus.FocusRequester) r0
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 r20 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1
            r13 = r20
            r14 = r6
            r15 = r2
            r16 = r5
            r17 = r3
            r18 = r4
            r13.<init>(r14, r15, r16, r17, r18)
            r13 = r20
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r13)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r38)
            int r15 = r12 >> 3
            r15 = r15 & 14
            int r16 = r12 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r15 = r15 | r16
            r16 = 0
            r17 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r18 = r11.changed((java.lang.Object) r8)
            boolean r20 = r11.changed((java.lang.Object) r14)
            r18 = r18 | r20
            r20 = r11
            r21 = 0
            r22 = r3
            java.lang.Object r3 = r20.rememberedValue()
            r23 = 0
            if (r18 != 0) goto L_0x028f
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r14
            java.lang.Object r14 = r24.getEmpty()
            if (r3 != r14) goto L_0x028a
            goto L_0x0291
        L_0x028a:
            r24 = r3
            r14 = r20
            goto L_0x02a2
        L_0x028f:
            r25 = r14
        L_0x0291:
            r14 = 0
            r24 = r3
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1 r3 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
            r3.<init>(r8, r7)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r14 = r20
            r14.updateRememberedValue(r3)
        L_0x02a2:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.material.Strings$Companion r14 = androidx.compose.material.Strings.Companion
            int r14 = r14.m3124getExposedDropdownMenuUdPEhr4()
            r15 = 6
            java.lang.String r14 = androidx.compose.material.Strings_androidKt.m3128getString4foXLRw(r14, r11, r15)
            androidx.compose.ui.Modifier r3 = expandable(r13, r3, r14)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r3, r0)
            r13 = 0
            r14 = r13
            r13 = 0
            r15 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r15 = r15.getTopStart()
            r8 = 0
            int r18 = r14 >> 3
            r18 = r18 & 14
            int r20 = r14 >> 3
            r20 = r20 & 112(0x70, float:1.57E-43)
            r21 = r13
            r13 = r18 | r20
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r15, r8, r11, r13)
            int r18 = r14 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r20 = 0
            r23 = r8
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r8)
            r8 = 0
            int r24 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r8)
            androidx.compose.runtime.CompositionLocalMap r8 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r25 = r25.getConstructor()
            kotlin.jvm.functions.Function3 r26 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            r27 = r3
            int r3 = r18 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r16 = 6
            r3 = r3 | 6
            r28 = r25
            r25 = r26
            r26 = 0
            r29 = r15
            androidx.compose.runtime.Applier r15 = r11.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0326
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0326:
            r11.startReusableNode()
            boolean r15 = r11.getInserting()
            if (r15 == 0) goto L_0x0335
            r15 = r28
            r11.createNode(r15)
            goto L_0x033a
        L_0x0335:
            r15 = r28
            r11.useNode()
        L_0x033a:
            r28 = r15
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m4575constructorimpl(r11)
            r30 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r31 = androidx.compose.ui.node.ComposeUiNode.Companion
            r32 = r2
            kotlin.jvm.functions.Function2 r2 = r31.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r13, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r15, r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            r31 = 0
            r33 = r15
            r34 = 0
            boolean r35 = r33.getInserting()
            if (r35 != 0) goto L_0x037e
            r35 = r8
            java.lang.Object r8 = r33.rememberedValue()
            r36 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r24)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r13)
            if (r8 != 0) goto L_0x037b
            goto L_0x0382
        L_0x037b:
            r13 = r33
            goto L_0x0392
        L_0x037e:
            r35 = r8
            r36 = r13
        L_0x0382:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r24)
            r13 = r33
            r13.updateRememberedValue(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r24)
            r15.apply(r8, r2)
        L_0x0392:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r8 = r3 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r13 = r25
            r13.invoke(r2, r11, r8)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r2)
            int r2 = r3 >> 9
            r2 = r2 & 14
            r8 = r11
            r15 = 0
            r25 = r2
            r2 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r30 = r3
            java.lang.String r3 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r14 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r16 = 6
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r16 = r8
            r31 = 0
            r33 = r2
            r2 = 1560854722(0x5d08c0c2, float:6.1588058E17)
            r34 = r3
            java.lang.String r3 = "C134@5576L9:ExposedDropdownMenu.kt#jmzs0o"
            r37 = r13
            r13 = r16
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r2, r3)
            int r2 = r12 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r9.invoke(r10, r13, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r38)
            r3 = r12 & 14
            r3 = r3 | 48
            r8 = 0
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = r11.changed((java.lang.Object) r2)
            boolean r13 = r11.changed((java.lang.Object) r0)
            r1 = r1 | r13
            r13 = r11
            r14 = 0
            java.lang.Object r15 = r13.rememberedValue()
            r16 = 0
            if (r1 != 0) goto L_0x0439
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r40 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r15 != r1) goto L_0x0437
            goto L_0x043b
        L_0x0437:
            r1 = r15
            goto L_0x044a
        L_0x0439:
            r40 = r1
        L_0x043b:
            r1 = 0
            r18 = r1
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4$1 r1 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4$1
            r1.<init>(r7, r0)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r13.updateRememberedValue(r1)
        L_0x044a:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r11, r2)
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5 r1 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
            r2 = r32
            r1.<init>(r2, r6, r5, r4)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r11, (int) r3)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x046c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x046c:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 != 0) goto L_0x0473
            goto L_0x048a
        L_0x0473:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6 r10 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6
            r0 = r10
            r1 = r38
            r2 = r39
            r3 = r17
            r4 = r41
            r5 = r43
            r6 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r8.updateScope(r10)
        L_0x048a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableIntState $width$delegate) {
        return $width$delegate.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$2(MutableIntState $width$delegate, int value) {
        $width$delegate.setIntValue(value);
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableIntState $menuHeight$delegate) {
        return $menuHeight$delegate.getIntValue();
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$5(MutableIntState $menuHeight$delegate, int value) {
        $menuHeight$delegate.setIntValue(value);
    }

    private static final Modifier expandable(Modifier $this$expandable, Function0<Unit> onExpandedChange, String menuLabel) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ExposedDropdownMenuKt$expandable$1(onExpandedChange, (Continuation<? super ExposedDropdownMenuKt$expandable$1>) null)), false, new ExposedDropdownMenuKt$expandable$2(menuLabel, onExpandedChange), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> onHeightUpdate) {
        if (coordinates != null) {
            Rect visibleWindowBounds = new Rect();
            view.getWindowVisibleDisplayFrame(visibleWindowBounds);
            onHeightUpdate.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(coordinates).getTop() - ((float) visibleWindowBounds.top), ((float) (visibleWindowBounds.bottom - visibleWindowBounds.top)) - LayoutCoordinatesKt.boundsInWindow(coordinates).getBottom())) - verticalMarginInPx));
        }
    }
}
