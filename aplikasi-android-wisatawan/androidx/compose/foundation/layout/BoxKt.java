package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001aM\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\f2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0000\u001a\u001d\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0001¢\u0006\u0002\u0010 \u001a<\u0010!\u001a\u00020\u0010*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"DefaultBoxMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "boxChildDataNode", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "Landroidx/compose/ui/layout/Measurable;", "getBoxChildDataNode", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildDataNode;", "matchesParentSize", "", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "boxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Box.kt */
public final class BoxKt {
    private static final MeasurePolicy DefaultBoxMeasurePolicy = boxMeasurePolicy(Alignment.Companion.getTopStart(), false);
    private static final MeasurePolicy EmptyBoxMeasurePolicy = BoxKt$EmptyBoxMeasurePolicy$1.INSTANCE;

    public static final void Box(Modifier modifier, Alignment contentAlignment, boolean propagateMinConstraints, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Alignment contentAlignment2;
        boolean propagateMinConstraints2;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3 = content;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        if ((i & 2) != 0) {
            contentAlignment2 = Alignment.Companion.getTopStart();
        } else {
            contentAlignment2 = contentAlignment;
        }
        if ((i & 4) != 0) {
            propagateMinConstraints2 = false;
        } else {
            propagateMinConstraints2 = propagateMinConstraints;
        }
        MeasurePolicy measurePolicy = rememberBoxMeasurePolicy(contentAlignment2, propagateMinConstraints2, composer, (($changed >> 3) & 14) | (($changed >> 3) & 112));
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier2);
        int $changed$iv$iv = (((($changed << 3) & 112) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer);
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u240$iv;
        if (!$this$set_impl_u24lambda_u240$iv$iv.getInserting()) {
            Modifier modifier3 = modifier2;
            Alignment alignment = contentAlignment2;
            if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv;
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                int i2 = ($changed$iv$iv >> 9) & 14;
                Composer $composer2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
                function3.invoke(BoxScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            }
        } else {
            Alignment alignment2 = contentAlignment2;
        }
        $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        int i22 = ($changed$iv$iv >> 9) & 14;
        Composer $composer22 = $composer;
        ComposerKt.sourceInformationMarkerStart($composer22, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
        function3.invoke(BoxScopeInstance.INSTANCE, $composer22, Integer.valueOf((($changed >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer22);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints, Composer $composer, int $changed) {
        MeasurePolicy measurePolicy;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        $composer.startReplaceableGroup(56522820);
        ComposerKt.sourceInformation($composer, "C(rememberBoxMeasurePolicy)85@3660L113:Box.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56522820, $changed, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:79)");
        }
        if (!Intrinsics.areEqual((Object) alignment, (Object) Alignment.Companion.getTopStart()) || propagateMinConstraints) {
            Object key2$iv = Boolean.valueOf(propagateMinConstraints);
            int i = ($changed & 14) | ($changed & 112);
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed((Object) alignment) | $composer.changed(key2$iv);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = boxMeasurePolicy(alignment, propagateMinConstraints);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            measurePolicy = (MeasurePolicy) value$iv$iv;
        } else {
            measurePolicy = DefaultBoxMeasurePolicy;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final MeasurePolicy getDefaultBoxMeasurePolicy() {
        return DefaultBoxMeasurePolicy;
    }

    public static final MeasurePolicy boxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new BoxKt$boxMeasurePolicy$1(propagateMinConstraints, alignment);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getAlignment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void placeInBox(androidx.compose.ui.layout.Placeable.PlacementScope r13, androidx.compose.ui.layout.Placeable r14, androidx.compose.ui.layout.Measurable r15, androidx.compose.ui.unit.LayoutDirection r16, int r17, int r18, androidx.compose.ui.Alignment r19) {
        /*
            androidx.compose.foundation.layout.BoxChildDataNode r0 = getBoxChildDataNode(r15)
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.Alignment r0 = r0.getAlignment()
            if (r0 != 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r1 = r0
            goto L_0x0011
        L_0x000f:
            r1 = r19
        L_0x0011:
            int r0 = r14.getWidth()
            int r2 = r14.getHeight()
            long r2 = androidx.compose.ui.unit.IntSizeKt.IntSize(r0, r2)
            long r4 = androidx.compose.ui.unit.IntSizeKt.IntSize(r17, r18)
            r6 = r16
            long r2 = r1.m2884alignKFBX0sM(r2, r4, r6)
            r11 = 2
            r12 = 0
            r10 = 0
            r6 = r13
            r7 = r14
            r8 = r2
            androidx.compose.ui.layout.Placeable.PlacementScope.m4729place70tqf50$default(r6, r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxKt.placeInBox(androidx.compose.ui.layout.Placeable$PlacementScope, androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measurable, androidx.compose.ui.unit.LayoutDirection, int, int, androidx.compose.ui.Alignment):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Box(androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r0 = r19
            r1 = r21
            java.lang.String r2 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -211209833(0xfffffffff3693197, float:-1.8475509E31)
            r3 = r20
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(Box)199@7940L70:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r21
            r5 = r1 & 14
            r6 = 2
            if (r5 != 0) goto L_0x0029
            boolean r5 = r3.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x0027
            r5 = 4
            goto L_0x0028
        L_0x0027:
            r5 = r6
        L_0x0028:
            r4 = r4 | r5
        L_0x0029:
            r5 = r4 & 11
            if (r5 != r6) goto L_0x003b
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L_0x0034
            goto L_0x003b
        L_0x0034:
            r3.skipToGroupEnd()
            r17 = r4
            goto L_0x0127
        L_0x003b:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0047
            r5 = -1
            java.lang.String r6 = "androidx.compose.foundation.layout.Box (Box.kt:198)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r5, r6)
        L_0x0047:
            androidx.compose.ui.layout.MeasurePolicy r2 = EmptyBoxMeasurePolicy
            int r5 = r4 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 384(0x180, float:5.38E-43)
            r6 = 0
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r7)
            r7 = 0
            int r7 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r7)
            androidx.compose.runtime.CompositionLocalMap r8 = r3.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r19)
            int r11 = r5 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | 6
            r12 = 0
            androidx.compose.runtime.Applier r13 = r3.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0081
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0081:
            r3.startReusableNode()
            boolean r13 = r3.getInserting()
            if (r13 == 0) goto L_0x008e
            r3.createNode(r9)
            goto L_0x0091
        L_0x008e:
            r3.useNode()
        L_0x0091:
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m2865constructorimpl(r3)
            r14 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r13, r2, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r13, r8, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            r15 = 0
            r20 = r13
            r16 = 0
            boolean r17 = r20.getInserting()
            if (r17 != 0) goto L_0x00cf
            r17 = r4
            java.lang.Object r4 = r20.rememberedValue()
            r18 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x00cc
            goto L_0x00d3
        L_0x00cc:
            r5 = r20
            goto L_0x00e3
        L_0x00cf:
            r17 = r4
            r18 = r5
        L_0x00d3:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r5 = r20
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r13.apply(r4, r2)
        L_0x00e3:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r2)
            int r4 = r11 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r10.invoke(r2, r3, r4)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r2)
            int r2 = r11 >> 9
            r2 = r2 & 14
            r4 = r3
            r5 = 0
            r13 = -1253624724(0xffffffffb547346c, float:-7.420956E-7)
            java.lang.String r14 = "C:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r13, r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0127
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0127:
            androidx.compose.runtime.ScopeUpdateScope r2 = r3.endRestartGroup()
            if (r2 != 0) goto L_0x012e
            goto L_0x0138
        L_0x012e:
            androidx.compose.foundation.layout.BoxKt$Box$3 r4 = new androidx.compose.foundation.layout.BoxKt$Box$3
            r4.<init>(r0, r1)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateScope(r4)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxKt.Box(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):void");
    }

    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return EmptyBoxMeasurePolicy;
    }

    private static final BoxChildDataNode getBoxChildDataNode(Measurable $this$boxChildDataNode) {
        Object parentData = $this$boxChildDataNode.getParentData();
        if (parentData instanceof BoxChildDataNode) {
            return (BoxChildDataNode) parentData;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean getMatchesParentSize(Measurable $this$matchesParentSize) {
        BoxChildDataNode boxChildDataNode = getBoxChildDataNode($this$matchesParentSize);
        if (boxChildDataNode != null) {
            return boxChildDataNode.getMatchParentSize();
        }
        return false;
    }
}
