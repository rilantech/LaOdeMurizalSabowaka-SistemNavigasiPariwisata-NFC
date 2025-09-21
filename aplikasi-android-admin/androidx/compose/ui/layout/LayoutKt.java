package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\b¢\u0006\u0002\u0010\u000b\u001a>\u0010\u0000\u001a\u00020\u00012\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\b¢\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\rH\u0001¢\u0006\u0002\u0010\u0013\u001a6\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a6\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u001a\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class LayoutKt {
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0094, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r15.rememberedValue(), (java.lang.Object) java.lang.Integer.valueOf(r5)) == false) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Layout(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.layout.MeasurePolicy r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            java.lang.String r3 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r3 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r23 & 2
            if (r4 == 0) goto L_0x0026
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0028
        L_0x0026:
            r4 = r19
        L_0x0028:
            r5 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r21.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = modifierMaterializerOf(r4)
            int r9 = r22 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r10 = 0
            androidx.compose.runtime.Applier r11 = r21.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x004f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x004f:
            r21.startReusableNode()
            boolean r11 = r21.getInserting()
            if (r11 == 0) goto L_0x005c
            r2.createNode(r7)
            goto L_0x005f
        L_0x005c:
            r21.useNode()
        L_0x005f:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m4575constructorimpl(r21)
            r12 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r1, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r11, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r14 = 0
            r15 = r11
            r16 = 0
            boolean r17 = r15.getInserting()
            if (r17 != 0) goto L_0x0097
            java.lang.Object r1 = r15.rememberedValue()
            r17 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x00a7
            goto L_0x0099
        L_0x0097:
            r17 = r3
        L_0x0099:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r15.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r11.apply(r1, r13)
        L_0x00a7:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r21)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r3 = r9 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r8.invoke(r1, r2, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            int r1 = r9 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.invoke(r2, r1)
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.Layout(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        MeasurePolicy measurePolicy2 = measurePolicy;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(measurePolicy2, "measurePolicy");
        composer.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        Modifier materialized = ComposedModifierKt.materializeModifier(composer, modifier2);
        CompositionLocalMap localMap = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv = ComposeUiNode.Companion.getConstructor();
        composer.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(composer, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(factory$iv));
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u241 = Updater.m4575constructorimpl($composer);
        Updater.m4582setimpl($this$Layout_u24lambda_u241, measurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4582setimpl($this$Layout_u24lambda_u241, localMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m4582setimpl($this$Layout_u24lambda_u241, materialized, ComposeUiNode.Companion.getSetModifier());
        Function2 block$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv = $this$Layout_u24lambda_u241;
        if ($this$set_impl_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash))) {
            $this$set_impl_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash));
            $this$Layout_u24lambda_u241.apply(Integer.valueOf(compositeKeyHash), block$iv);
        }
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final void Layout(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents, Modifier modifier, MultiContentMeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        MultiContentMeasurePolicy multiContentMeasurePolicy = measurePolicy;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(contents, "contents");
        Intrinsics.checkNotNullParameter(multiContentMeasurePolicy, "measurePolicy");
        composer.startReplaceableGroup(1399185516);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.Companion : modifier;
        Function2 content$iv = combineAsVirtualLayouts(contents);
        int i2 = ($changed >> 6) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) multiContentMeasurePolicy);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv$iv;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = modifierMaterializerOf(modifier2);
        int $changed$iv$iv = ((($changed & 112) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m4575constructorimpl($composer);
        Updater.m4582setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4582setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u240$iv;
        if (!$this$set_impl_u24lambda_u240$iv$iv.getInserting()) {
            if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv;
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                content$iv.invoke(composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            }
        }
        $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content$iv.invoke(composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new LayoutKt$combineAsVirtualLayouts$1(contents));
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new LayoutKt$materializerOf$1(modifier));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Needed only for backwards compatibility. Do not use.")
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-55743822, true, new LayoutKt$materializerOfWithCompositionLocalInjection$1(modifier));
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0155  */
    @kotlin.Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MultiMeasureLayout(androidx.compose.ui.Modifier r18, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.ui.layout.MeasurePolicy r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r6 = r19
            r7 = r20
            r8 = r22
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1949933075(0x74399e13, float:5.8824527E31)
            r1 = r21
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(MultiMeasureLayout)P(2)246@9516L23,250@9668L491:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r22
            r2 = r23 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r3 = r18
            goto L_0x003d
        L_0x002a:
            r3 = r8 & 14
            if (r3 != 0) goto L_0x003b
            r3 = r18
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0038
            r4 = 4
            goto L_0x0039
        L_0x0038:
            r4 = 2
        L_0x0039:
            r1 = r1 | r4
            goto L_0x003d
        L_0x003b:
            r3 = r18
        L_0x003d:
            r4 = r23 & 2
            if (r4 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r4 = r8 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0054
            boolean r4 = r9.changedInstance(r6)
            if (r4 == 0) goto L_0x0051
            r4 = 32
            goto L_0x0053
        L_0x0051:
            r4 = 16
        L_0x0053:
            r1 = r1 | r4
        L_0x0054:
            r4 = r23 & 4
            if (r4 == 0) goto L_0x005b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x005b:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006b
            boolean r4 = r9.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0068
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r4
        L_0x006b:
            r10 = r1
            r1 = r10 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r1 != r4) goto L_0x0080
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0079
            goto L_0x0080
        L_0x0079:
            r9.skipToGroupEnd()
            r17 = r3
            goto L_0x0158
        L_0x0080:
            if (r2 == 0) goto L_0x0087
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0088
        L_0x0087:
            r1 = r3
        L_0x0088:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0094
            r2 = -1
            java.lang.String r3 = "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:241)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r2, r3)
        L_0x0094:
            r0 = 0
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r0)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r1)
            androidx.compose.runtime.CompositionLocalMap r3 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.LayoutNode$Companion r4 = androidx.compose.ui.node.LayoutNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor$ui_release()
            int r5 = r10 << 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r5 = r5 | 6
            r11 = 0
            r12 = -692256719(0xffffffffd6bd0031, float:-1.0390426E14)
            r9.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            androidx.compose.runtime.Applier r12 = r9.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x00c6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00c6:
            r9.startReusableNode()
            boolean r12 = r9.getInserting()
            if (r12 == 0) goto L_0x00d3
            r9.createNode(r4)
            goto L_0x00d6
        L_0x00d3:
            r9.useNode()
        L_0x00d6:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r13 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r7, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r3, r14)
            androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$1$1 r14 = androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$1$1.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.runtime.Updater.m4579initimpl(r12, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetModifier()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r2, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetCompositeKeyHash()
            r15 = 0
            r18 = r12
            r16 = 0
            boolean r17 = r18.getInserting()
            if (r17 != 0) goto L_0x0124
            r17 = r1
            java.lang.Object r1 = r18.rememberedValue()
            r21 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0121
            goto L_0x0128
        L_0x0121:
            r2 = r18
            goto L_0x0138
        L_0x0124:
            r17 = r1
            r21 = r2
        L_0x0128:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = r18
            r2.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r12.apply(r1, r14)
        L_0x0138:
            int r1 = r5 >> 6
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.invoke(r9, r1)
            r9.endNode()
            r9.endReplaceableGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0158
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0158:
            androidx.compose.runtime.ScopeUpdateScope r11 = r9.endRestartGroup()
            if (r11 != 0) goto L_0x015f
            goto L_0x0174
        L_0x015f:
            androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$2 r12 = new androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$2
            r0 = r12
            r1 = r17
            r2 = r19
            r3 = r20
            r4 = r22
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }
}
