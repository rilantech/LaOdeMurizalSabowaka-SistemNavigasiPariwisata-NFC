package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
public final class AlertDialogKt {
    /* access modifiers changed from: private */
    public static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    /* access modifiers changed from: private */
    public static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    private static final Modifier TextPadding = PaddingKt.m542paddingqDBjuR0$default(Modifier.Companion, Dp.m5844constructorimpl((float) 24), 0.0f, Dp.m5844constructorimpl((float) 24), Dp.m5844constructorimpl((float) 28), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final Modifier TitlePadding = PaddingKt.m542paddingqDBjuR0$default(Modifier.Companion, Dp.m5844constructorimpl((float) 24), 0.0f, Dp.m5844constructorimpl((float) 24), 0.0f, 10, (Object) null);

    /* renamed from: AlertDialogContent-WMdw5o4  reason: not valid java name */
    public static final void m1153AlertDialogContentWMdw5o4(Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, Composer $composer, int $changed, int i) {
        Function2 title2;
        Function2 text2;
        Shape shape2;
        long backgroundColor2;
        long j;
        long contentColor2;
        long backgroundColor3;
        Shape shape3;
        Function2 text3;
        Function2 title3;
        Modifier modifier2;
        int $dirty;
        long contentColor3;
        Modifier modifier3;
        int i2;
        int i3;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2 = buttons;
        int i5 = $changed;
        Intrinsics.checkNotNullParameter(function2, "buttons");
        Composer $composer2 = $composer.startRestartGroup(-453679601);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)48@1896L6,49@1954L6,50@1996L32,52@2038L1047:AlertDialog.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            Modifier modifier4 = modifier;
        } else if ((i5 & 112) == 0) {
            $dirty2 |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            title2 = title;
        } else if ((i5 & 896) == 0) {
            title2 = title;
            $dirty2 |= $composer2.changedInstance(title2) ? 256 : 128;
        } else {
            title2 = title;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            text2 = text;
        } else if ((i5 & 7168) == 0) {
            text2 = text;
            $dirty2 |= $composer2.changedInstance(text2) ? 2048 : 1024;
        } else {
            text2 = text;
        }
        if ((57344 & i5) == 0) {
            if ((i & 16) == 0) {
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
        if ((458752 & i5) == 0) {
            if ((i & 32) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((3670016 & i5) == 0) {
            if ((i & 64) == 0) {
                j = contentColor;
                if ($composer2.changed(j)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                j = contentColor;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            j = contentColor;
        }
        if (($dirty2 & 2995931) != 599186 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    title2 = null;
                }
                if (i8 != 0) {
                    text2 = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                }
                if ((i & 32) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1245getSurface0d7_KjU();
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & -3670017;
                    contentColor3 = ColorsKt.m1259contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 15) & 14);
                } else {
                    $dirty = $dirty2;
                    contentColor3 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & -3670017;
                    contentColor3 = j;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    $dirty = $dirty2;
                    contentColor3 = j;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453679601, $dirty, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
            }
            SurfaceKt.m1420SurfaceFjzlyU(modifier3, shape2, backgroundColor2, contentColor3, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda($composer2, 629950291, true, new AlertDialogKt$AlertDialogContent$1(title2, text2, function2, $dirty)), $composer2, (($dirty >> 3) & 14) | 1572864 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            contentColor2 = contentColor3;
            int i9 = $dirty;
            title3 = title2;
            text3 = text2;
            shape3 = shape2;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty2;
            text3 = text2;
            shape3 = shape2;
            backgroundColor3 = backgroundColor2;
            contentColor2 = j;
            modifier2 = modifier;
            title3 = title2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(buttons, modifier2, title3, text3, shape3, backgroundColor3, contentColor2, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x043d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AlertDialogBaselineLayout(androidx.compose.foundation.layout.ColumnScope r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, int r56) {
        /*
            r0 = r52
            r1 = r53
            r2 = r54
            r3 = r56
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            r4 = -555573207(0xffffffffdee2a029, float:-8.1650487E18)
            r5 = r55
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(AlertDialogBaselineLayout)P(1)96@3561L3479:AlertDialog.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r56
            r7 = r3 & 14
            if (r7 != 0) goto L_0x002b
            boolean r7 = r5.changed((java.lang.Object) r0)
            if (r7 == 0) goto L_0x0029
            r7 = 4
            goto L_0x002a
        L_0x0029:
            r7 = 2
        L_0x002a:
            r6 = r6 | r7
        L_0x002b:
            r7 = r3 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x003b
            boolean r7 = r5.changedInstance(r1)
            if (r7 == 0) goto L_0x0038
            r7 = 32
            goto L_0x003a
        L_0x0038:
            r7 = 16
        L_0x003a:
            r6 = r6 | r7
        L_0x003b:
            r7 = r3 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x004b
            boolean r7 = r5.changedInstance(r2)
            if (r7 == 0) goto L_0x0048
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x004a
        L_0x0048:
            r7 = 128(0x80, float:1.794E-43)
        L_0x004a:
            r6 = r6 | r7
        L_0x004b:
            r7 = r6 & 731(0x2db, float:1.024E-42)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L_0x005f
            boolean r7 = r5.getSkipping()
            if (r7 != 0) goto L_0x0058
            goto L_0x005f
        L_0x0058:
            r5.skipToGroupEnd()
            r24 = r6
            goto L_0x0440
        L_0x005f:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x006b
            r7 = -1
            java.lang.String r8 = "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:92)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r7, r8)
        L_0x006b:
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            androidx.compose.ui.Modifier r4 = r0.weight(r4, r7, r8)
            androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2 r7 = androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r7 = (androidx.compose.ui.layout.MeasurePolicy) r7
            r9 = r8
            r10 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r11)
            java.lang.String r12 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r8)
            androidx.compose.runtime.CompositionLocalMap r14 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r4)
            int r8 = r9 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 6
            r17 = r16
            r16 = 0
            androidx.compose.runtime.Applier r11 = r5.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x00b0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00b0:
            r5.startReusableNode()
            boolean r11 = r5.getInserting()
            if (r11 == 0) goto L_0x00bd
            r5.createNode(r15)
            goto L_0x00c0
        L_0x00bd:
            r5.useNode()
        L_0x00c0:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2865constructorimpl(r5)
            r19 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            r21 = r4
            kotlin.jvm.functions.Function2 r4 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r7, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r11, r14, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r20 = 0
            r22 = r11
            r23 = 0
            boolean r24 = r22.getInserting()
            if (r24 != 0) goto L_0x0102
            r24 = r6
            java.lang.Object r6 = r22.rememberedValue()
            r25 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x00ff
            goto L_0x0106
        L_0x00ff:
            r7 = r22
            goto L_0x0116
        L_0x0102:
            r24 = r6
            r25 = r7
        L_0x0106:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)
            r7 = r22
            r7.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)
            r11.apply(r6, r4)
        L_0x0116:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r4)
            int r6 = r8 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = r17
            r7.invoke(r4, r5, r6)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r4)
            int r6 = r8 >> 9
            r6 = r6 & 14
            r11 = r5
            r17 = 0
            r4 = -1160646213(0xffffffffbad1f1bb, float:-0.0016017476)
            r20 = r6
            java.lang.String r6 = "C:AlertDialog.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r6)
            r4 = -1160646206(0xffffffffbad1f1c2, float:-0.0016017484)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "*99@3629L106"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.String r4 = "C71@3331L9:Box.kt#2w3rfo"
            java.lang.String r6 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            r23 = r7
            if (r1 != 0) goto L_0x0166
            r29 = r8
            r31 = r9
            r32 = r10
            r35 = r13
            r45 = r14
            goto L_0x02c1
        L_0x0166:
            r26 = r53
            r27 = 0
            androidx.compose.ui.Modifier r7 = TitlePadding
            r29 = r8
            java.lang.String r8 = "title"
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r7, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r8.getStart()
            androidx.compose.ui.Modifier r7 = r0.align(r7, r8)
            r8 = 0
            r30 = 0
            r31 = r9
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            r32 = r10
            r10 = 0
            int r33 = r8 >> 3
            r33 = r33 & 14
            int r34 = r8 >> 3
            r34 = r34 & 112(0x70, float:1.57E-43)
            r35 = r13
            r13 = r33 | r34
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r10, r11, r13)
            int r33 = r8 << 3
            r33 = r33 & 112(0x70, float:1.57E-43)
            r34 = 0
            r36 = r9
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r9 = 0
            int r37 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r9)
            androidx.compose.runtime.CompositionLocalMap r9 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r38 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r38 = r38.getConstructor()
            kotlin.jvm.functions.Function3 r39 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r7)
            r40 = r7
            int r7 = r33 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 6
            r41 = r38
            r38 = r39
            r39 = 0
            r42 = r10
            androidx.compose.runtime.Applier r10 = r11.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x01e6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01e6:
            r11.startReusableNode()
            boolean r10 = r11.getInserting()
            if (r10 == 0) goto L_0x01f5
            r10 = r41
            r11.createNode(r10)
            goto L_0x01fa
        L_0x01f5:
            r10 = r41
            r11.useNode()
        L_0x01fa:
            r41 = r10
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r43 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r44 = androidx.compose.ui.node.ComposeUiNode.Companion
            r45 = r14
            kotlin.jvm.functions.Function2 r14 = r44.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r10, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r44 = 0
            r46 = r10
            r47 = 0
            boolean r48 = r46.getInserting()
            if (r48 != 0) goto L_0x023e
            r48 = r9
            java.lang.Object r9 = r46.rememberedValue()
            r49 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r37)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r9 != 0) goto L_0x023b
            goto L_0x0242
        L_0x023b:
            r13 = r46
            goto L_0x0252
        L_0x023e:
            r48 = r9
            r49 = r13
        L_0x0242:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r37)
            r13 = r46
            r13.updateRememberedValue(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r37)
            r10.apply(r9, r14)
        L_0x0252:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r9)
            int r10 = r7 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13 = r38
            r13.invoke(r9, r11, r10)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r9)
            int r9 = r7 >> 9
            r9 = r9 & 14
            r10 = r11
            r14 = 0
            r38 = r7
            r7 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r7, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r7 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r43 = r8 >> 6
            r43 = r43 & 112(0x70, float:1.57E-43)
            r43 = r43 | 6
            androidx.compose.foundation.layout.BoxScope r7 = (androidx.compose.foundation.layout.BoxScope) r7
            r44 = r10
            r46 = 0
            r47 = r7
            r7 = -630329100(0xffffffffda6df0f4, float:-1.67436251E16)
            r50 = r8
            java.lang.String r8 = "C100@3710L7:AlertDialog.kt#jmzs0o"
            r51 = r9
            r9 = r44
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r7, r8)
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r7 = r26
            r7.invoke(r9, r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
        L_0x02c1:
            r11.endReplaceableGroup()
            r7 = -1735756597(0xffffffff988a74cb, float:-3.5790095E-24)
            r11.startReplaceableGroup(r7)
            java.lang.String r7 = "*104@3798L103"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            if (r2 != 0) goto L_0x02d3
            goto L_0x0424
        L_0x02d3:
            r7 = r54
            r8 = 0
            androidx.compose.ui.Modifier r9 = TextPadding
            java.lang.String r10 = "text"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r9, r10)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r10.getStart()
            androidx.compose.ui.Modifier r9 = r0.align(r9, r10)
            r10 = 0
            r13 = 0
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r14 = 0
            int r26 = r10 >> 3
            r26 = r26 & 14
            int r27 = r10 >> 3
            r27 = r27 & 112(0x70, float:1.57E-43)
            r28 = r8
            r8 = r26 | r27
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r14, r11, r8)
            int r26 = r10 << 3
            r26 = r26 & 112(0x70, float:1.57E-43)
            r27 = 0
            r30 = r6
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r6 = 0
            int r12 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r6)
            androidx.compose.runtime.CompositionLocalMap r6 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r18 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r33 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r9)
            r34 = r9
            int r9 = r26 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r36 = r18
            r18 = r33
            r33 = 0
            r37 = r13
            androidx.compose.runtime.Applier r13 = r11.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x034b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x034b:
            r11.startReusableNode()
            boolean r13 = r11.getInserting()
            if (r13 == 0) goto L_0x035a
            r13 = r36
            r11.createNode(r13)
            goto L_0x035f
        L_0x035a:
            r13 = r36
            r11.useNode()
        L_0x035f:
            r36 = r13
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m2865constructorimpl(r11)
            r38 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r39 = androidx.compose.ui.node.ComposeUiNode.Companion
            r40 = r14
            kotlin.jvm.functions.Function2 r14 = r39.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r13, r8, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r13, r6, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r39 = 0
            r41 = r13
            r42 = 0
            boolean r43 = r41.getInserting()
            if (r43 != 0) goto L_0x03a3
            r43 = r6
            java.lang.Object r6 = r41.rememberedValue()
            r44 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 != 0) goto L_0x03a0
            goto L_0x03a7
        L_0x03a0:
            r8 = r41
            goto L_0x03b7
        L_0x03a3:
            r43 = r6
            r44 = r8
        L_0x03a7:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r8 = r41
            r8.updateRememberedValue(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r13.apply(r6, r14)
        L_0x03b7:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r6)
            int r8 = r9 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r13 = r18
            r13.invoke(r6, r11, r8)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r6)
            int r6 = r9 >> 9
            r6 = r6 & 14
            r8 = r11
            r14 = 0
            r18 = r6
            r6 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r6, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r10 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            androidx.compose.foundation.layout.BoxScope r4 = (androidx.compose.foundation.layout.BoxScope) r4
            r19 = r8
            r22 = 0
            r38 = r4
            r4 = -630328933(0xffffffffda6df19b, float:-1.67438044E16)
            r39 = r6
            java.lang.String r6 = "C105@3877L6:AlertDialog.kt#jmzs0o"
            r41 = r9
            r9 = r19
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r6)
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.invoke(r9, r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
        L_0x0424:
            r11.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0440
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0440:
            androidx.compose.runtime.ScopeUpdateScope r4 = r5.endRestartGroup()
            if (r4 != 0) goto L_0x0447
            goto L_0x0451
        L_0x0447:
            androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$3 r6 = new androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$3
            r6.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r4.updateScope(r6)
        L_0x0451:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout(androidx.compose.foundation.layout.ColumnScope, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x014e  */
    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1154AlertDialogFlowRowixp7dh8(float r23, float r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r27
            java.lang.String r4 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = 73434452(0x4608554, float:2.6392295E-36)
            r5 = r26
            androidx.compose.runtime.Composer r5 = r5.startRestartGroup(r4)
            java.lang.String r6 = "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)192@7298L3537:AlertDialog.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r6 = r27
            r7 = r3 & 14
            if (r7 != 0) goto L_0x002b
            boolean r7 = r5.changed((float) r0)
            if (r7 == 0) goto L_0x0029
            r7 = 4
            goto L_0x002a
        L_0x0029:
            r7 = 2
        L_0x002a:
            r6 = r6 | r7
        L_0x002b:
            r7 = r3 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x003b
            boolean r7 = r5.changed((float) r1)
            if (r7 == 0) goto L_0x0038
            r7 = 32
            goto L_0x003a
        L_0x0038:
            r7 = 16
        L_0x003a:
            r6 = r6 | r7
        L_0x003b:
            r7 = r3 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x004b
            boolean r7 = r5.changedInstance(r2)
            if (r7 == 0) goto L_0x0048
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x004a
        L_0x0048:
            r7 = 128(0x80, float:1.794E-43)
        L_0x004a:
            r6 = r6 | r7
        L_0x004b:
            r7 = r6 & 731(0x2db, float:1.024E-42)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L_0x005f
            boolean r7 = r5.getSkipping()
            if (r7 != 0) goto L_0x0058
            goto L_0x005f
        L_0x0058:
            r5.skipToGroupEnd()
            r26 = r6
            goto L_0x0151
        L_0x005f:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x006b
            r7 = -1
            java.lang.String r8 = "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:187)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r6, r7, r8)
        L_0x006b:
            androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1 r4 = new androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1
            r4.<init>(r0, r1)
            androidx.compose.ui.layout.MeasurePolicy r4 = (androidx.compose.ui.layout.MeasurePolicy) r4
            int r7 = r6 >> 6
            r7 = r7 & 14
            r8 = 0
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r10 = 0
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r5, r10)
            androidx.compose.runtime.CompositionLocalMap r11 = r5.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r9)
            int r14 = r7 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r15 = 0
            r26 = r6
            androidx.compose.runtime.Applier r6 = r5.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x00ae
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ae:
            r5.startReusableNode()
            boolean r6 = r5.getInserting()
            if (r6 == 0) goto L_0x00bb
            r5.createNode(r12)
            goto L_0x00be
        L_0x00bb:
            r5.useNode()
        L_0x00be:
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2865constructorimpl(r5)
            r16 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            r18 = r7
            kotlin.jvm.functions.Function2 r7 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r6, r4, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r6, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r17 = 0
            r19 = r6
            r20 = 0
            boolean r21 = r19.getInserting()
            if (r21 != 0) goto L_0x0100
            r21 = r4
            java.lang.Object r4 = r19.rememberedValue()
            r22 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r8)
            if (r4 != 0) goto L_0x00fd
            goto L_0x0104
        L_0x00fd:
            r8 = r19
            goto L_0x0114
        L_0x0100:
            r21 = r4
            r22 = r8
        L_0x0104:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r8 = r19
            r8.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r6.apply(r4, r7)
        L_0x0114:
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r4)
            int r6 = r14 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r13.invoke(r4, r5, r6)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r4)
            int r4 = r14 >> 9
            r4 = r4 & 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r5, r4)
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0151
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0151:
            androidx.compose.runtime.ScopeUpdateScope r4 = r5.endRestartGroup()
            if (r4 != 0) goto L_0x0158
            goto L_0x0162
        L_0x0158:
            androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2 r6 = new androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
            r6.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r4.updateScope(r6)
        L_0x0162:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.m1154AlertDialogFlowRowixp7dh8(float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
