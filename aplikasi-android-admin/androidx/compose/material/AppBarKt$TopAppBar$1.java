package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TopAppBar$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$navigationIcon = function2;
        this.$$dirty = i;
        this.$title = function22;
        this.$actions = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.RowScope r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            r41 = this;
            r0 = r41
            r7 = r42
            r8 = r43
            r9 = r44
            java.lang.String r1 = "$this$AppBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r44
            r2 = r9 & 14
            if (r2 != 0) goto L_0x0022
            boolean r2 = r8.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0020
            r2 = 4
            goto L_0x0021
        L_0x0020:
            r2 = 2
        L_0x0021:
            r1 = r1 | r2
        L_0x0022:
            r10 = r1
            r1 = r10 & 91
            r2 = 18
            if (r1 != r2) goto L_0x0035
            boolean r1 = r43.getSkipping()
            if (r1 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r43.skipToGroupEnd()
            goto L_0x0382
        L_0x0035:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0044
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)"
            r3 = -1484077694(0xffffffffa78ac582, float:-3.8516833E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r9, r1, r2)
        L_0x0044:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$navigationIcon
            java.lang.String r11 = "C78@3887L9:Row.kt#2w3rfo"
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            java.lang.String r6 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r4 = 0
            r2 = 6
            if (r1 != 0) goto L_0x006f
            r1 = -512812651(0xffffffffe16f1995, float:-2.7566345E20)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "94@4259L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.material.AppBarKt.TitleInsetWithoutIcon
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r8, r2)
            r43.endReplaceableGroup()
            r29 = r4
            goto L_0x01da
        L_0x006f:
            r1 = -512812592(0xffffffffe16f19d0, float:-2.7566449E20)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "96@4318L257"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.material.AppBarKt.TitleIconModifier
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r16.getCenterVertically()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.$navigationIcon
            int r13 = r0.$$dirty
            r19 = 390(0x186, float:5.47E-43)
            r20 = 0
            r8.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            androidx.compose.foundation.layout.Arrangement r21 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r21.getStart()
            int r21 = r19 >> 3
            r21 = r21 & 14
            int r23 = r19 >> 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r2 = r21 | r23
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r3, r8, r2)
            int r21 = r19 << 3
            r21 = r21 & 112(0x70, float:1.57E-43)
            r23 = 0
            r8.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r14)
            int r25 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r4)
            androidx.compose.runtime.CompositionLocalMap r15 = r43.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r27 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r27 = r27.getConstructor()
            kotlin.jvm.functions.Function3 r28 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            int r4 = r21 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r24 = 6
            r4 = r4 | 6
            r30 = r27
            r27 = r28
            r28 = 0
            r31 = r1
            androidx.compose.runtime.Applier r1 = r43.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x00e0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00e0:
            r43.startReusableNode()
            boolean r1 = r43.getInserting()
            if (r1 == 0) goto L_0x00ef
            r1 = r30
            r8.createNode(r1)
            goto L_0x00f4
        L_0x00ef:
            r1 = r30
            r43.useNode()
        L_0x00f4:
            r30 = r1
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m4575constructorimpl(r43)
            r32 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r33 = androidx.compose.ui.node.ComposeUiNode.Companion
            r34 = r3
            kotlin.jvm.functions.Function2 r3 = r33.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r2, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r1, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r33 = 0
            r35 = r1
            r36 = 0
            boolean r37 = r35.getInserting()
            if (r37 != 0) goto L_0x0138
            r37 = r2
            java.lang.Object r2 = r35.rememberedValue()
            r38 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r25)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x0135
            goto L_0x013c
        L_0x0135:
            r5 = r35
            goto L_0x014c
        L_0x0138:
            r37 = r2
            r38 = r5
        L_0x013c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r25)
            r5 = r35
            r5.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r25)
            r1.apply(r2, r3)
        L_0x014c:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r43)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r2 = r4 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r27
            r3.invoke(r1, r8, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r1)
            int r1 = r4 >> 9
            r1 = r1 & 14
            r2 = r43
            r5 = 0
            r27 = r1
            r1 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r11)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r32 = r19 >> 6
            r32 = r32 & 112(0x70, float:1.57E-43)
            r24 = 6
            r32 = r32 | 6
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r33 = r2
            r35 = 0
            r36 = r1
            r1 = -2027905960(0xffffffff87209c58, float:-1.2083007E-34)
            r39 = r3
            java.lang.String r3 = "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o"
            r40 = r4
            r4 = r33
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.material.ContentAlpha r3 = androidx.compose.material.ContentAlpha.INSTANCE
            r33 = r5
            r5 = 6
            float r3 = r3.getHigh(r4, r5)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r3)
            r3 = 1
            androidx.compose.runtime.ProvidedValue[] r5 = new androidx.compose.runtime.ProvidedValue[r3]
            r29 = 0
            r5[r29] = r1
            int r1 = r13 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r5, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r12, (androidx.compose.runtime.Composer) r4, (int) r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r43.endReplaceableGroup()
            r43.endNode()
            r43.endReplaceableGroup()
            r43.endReplaceableGroup()
            r43.endReplaceableGroup()
        L_0x01da:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 0
            r3 = 0
            r4 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r1, r2, r4, r3)
            r5 = 2
            r12 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r1 = r42
            r15 = 6
            r15 = r29
            r4 = r13
            r13 = 693286680(0x2952b718, float:4.6788176E-14)
            r15 = r6
            r6 = r12
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.RowScope.weight$default(r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getCenterVertically()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$title
            int r4 = r0.$$dirty
            r5 = 384(0x180, float:5.38E-43)
            r6 = 0
            r8.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r15)
            androidx.compose.foundation.layout.Arrangement r12 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r12 = r12.getStart()
            int r13 = r5 >> 3
            r13 = r13 & 14
            int r15 = r5 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r13 = r13 | r15
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r12, r2, r8, r13)
            int r15 = r5 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r17 = 0
            r19 = r2
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r8.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r14)
            r2 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r8, r2)
            androidx.compose.runtime.CompositionLocalMap r2 = r43.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r20 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r21 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r22 = r1
            int r1 = r15 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r23 = 6
            r1 = r1 | 6
            r23 = r20
            r20 = r21
            r21 = 0
            r25 = r6
            androidx.compose.runtime.Applier r6 = r43.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0261
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0261:
            r43.startReusableNode()
            boolean r6 = r43.getInserting()
            if (r6 == 0) goto L_0x0270
            r6 = r23
            r8.createNode(r6)
            goto L_0x0275
        L_0x0270:
            r6 = r23
            r43.useNode()
        L_0x0275:
            r23 = r6
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m4575constructorimpl(r43)
            r26 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r27 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r27.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r13, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetCompositeKeyHash()
            r27 = 0
            r28 = r6
            r30 = 0
            boolean r31 = r28.getInserting()
            if (r31 != 0) goto L_0x02b5
            r31 = r2
            java.lang.Object r2 = r28.rememberedValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r9)
            if (r2 != 0) goto L_0x02b2
            goto L_0x02b7
        L_0x02b2:
            r9 = r28
            goto L_0x02c7
        L_0x02b5:
            r31 = r2
        L_0x02b7:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            r9 = r28
            r9.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            r6.apply(r2, r7)
        L_0x02c7:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r43)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r6 = r1 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7 = r20
            r7.invoke(r2, r8, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r2)
            int r2 = r1 >> 9
            r2 = r2 & 14
            r6 = r43
            r9 = 0
            r18 = r1
            r1 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r11)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r11 = r5 >> 6
            r11 = r11 & 112(0x70, float:1.57E-43)
            r16 = r2
            r2 = 6
            r11 = r11 | r2
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r20 = r6
            r26 = 0
            r2 = -2027905635(0xffffffff87209d9d, float:-1.208338E-34)
            r27 = r1
            java.lang.String r1 = "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o"
            r28 = r5
            r5 = r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r1)
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Typography r1 = r1.getTypography(r5, r2)
            androidx.compose.ui.text.TextStyle r1 = r1.getH6()
            androidx.compose.material.AppBarKt$TopAppBar$1$2$1 r2 = new androidx.compose.material.AppBarKt$TopAppBar$1$2$1
            r2.<init>(r3, r4)
            r3 = -2021518195(0xffffffff8782148d, float:-1.9572305E-34)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r3, r4, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = 48
            androidx.compose.material.TextKt.ProvideTextStyle(r1, r2, r5, r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r43.endReplaceableGroup()
            r43.endNode()
            r43.endReplaceableGroup()
            r43.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.material.ContentAlpha r2 = androidx.compose.material.ContentAlpha.INSTANCE
            r3 = 6
            float r2 = r2.getMedium(r8, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r2)
            androidx.compose.runtime.ProvidedValue[] r2 = new androidx.compose.runtime.ProvidedValue[r4]
            r3 = 0
            r2[r3] = r1
            androidx.compose.material.AppBarKt$TopAppBar$1$3 r1 = new androidx.compose.material.AppBarKt$TopAppBar$1$3
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$actions
            int r5 = r0.$$dirty
            r1.<init>(r3, r5)
            r3 = 1157662914(0x450088c2, float:2056.5474)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r3, r4, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = 56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r8, (int) r3)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0382
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0382:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt$TopAppBar$1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
    }
}
