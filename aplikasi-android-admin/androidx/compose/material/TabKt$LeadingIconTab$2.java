package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$LeadingIconTab$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Indication $ripple;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabKt$LeadingIconTab$2(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$modifier = modifier;
        this.$selected = z;
        this.$interactionSource = mutableInteractionSource;
        this.$ripple = indication;
        this.$enabled = z2;
        this.$onClick = function0;
        this.$icon = function2;
        this.$$dirty = i;
        this.$text = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r61, int r62) {
        /*
            r60 = this;
            r0 = r60
            r1 = r61
            r2 = r62
            java.lang.String r3 = "C168@7493L843:Tab.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r2 & 11
            r4 = 2
            if (r3 != r4) goto L_0x001c
            boolean r3 = r61.getSkipping()
            if (r3 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r61.skipToGroupEnd()
            goto L_0x0211
        L_0x001c:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x002b
            r3 = -1
            java.lang.String r5 = "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:167)"
            r6 = 866677691(0x33a873bb, float:7.844161E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
        L_0x002b:
            androidx.compose.ui.Modifier r3 = r0.$modifier
            float r5 = androidx.compose.material.TabKt.SmallTabHeight
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m2308height3ABfNKs(r3, r5)
            androidx.compose.ui.semantics.Role$Companion r3 = androidx.compose.ui.semantics.Role.Companion
            int r3 = r3.m6878getTabo7Vup1c()
            boolean r7 = r0.$selected
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r0.$interactionSource
            androidx.compose.foundation.Indication r9 = r0.$ripple
            boolean r10 = r0.$enabled
            androidx.compose.ui.semantics.Role r11 = androidx.compose.ui.semantics.Role.m6865boximpl(r3)
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r0.$onClick
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableKt.m2543selectableO2vRcR0(r6, r7, r8, r9, r10, r11, r12)
            float r5 = androidx.compose.material.TabKt.HorizontalTextPadding
            r6 = 0
            r7 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m2250paddingVpY3zN4$default(r3, r5, r6, r4, r7)
            r4 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r6, r4, r7)
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r4 = r4.getCenter()
            androidx.compose.foundation.layout.Arrangement$Horizontal r4 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r4
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r5 = r5.getCenterVertically()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$icon
            int r7 = r0.$$dirty
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r8 = r0.$text
            r9 = 432(0x1b0, float:6.05E-43)
            r10 = 0
            r11 = 693286680(0x2952b718, float:4.6788176E-14)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            int r11 = r9 >> 3
            r11 = r11 & 14
            int r12 = r9 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r4, r5, r1, r11)
            int r12 = r9 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r13 = 0
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            r14 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r14)
            androidx.compose.runtime.CompositionLocalMap r15 = r61.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r16 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r17 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
            int r0 = r12 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = 6
            r0 = r0 | r2
            r18 = r16
            r16 = r17
            r17 = 0
            androidx.compose.runtime.Applier r2 = r61.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x00c7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00c7:
            r61.startReusableNode()
            boolean r2 = r61.getInserting()
            if (r2 == 0) goto L_0x00d6
            r2 = r18
            r1.createNode(r2)
            goto L_0x00db
        L_0x00d6:
            r2 = r18
            r61.useNode()
        L_0x00db:
            r18 = r2
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m4575constructorimpl(r61)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r3
            kotlin.jvm.functions.Function2 r3 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r11, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r2, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            r21 = 0
            r23 = r2
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x011f
            r25 = r4
            java.lang.Object r4 = r23.rememberedValue()
            r26 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x011c
            goto L_0x0123
        L_0x011c:
            r5 = r23
            goto L_0x0133
        L_0x011f:
            r25 = r4
            r26 = r5
        L_0x0123:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r5 = r23
            r5.updateRememberedValue(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r2.apply(r4, r3)
        L_0x0133:
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r61)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
            int r3 = r0 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r16
            r4.invoke(r2, r1, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r3 = r61
            r5 = 0
            r16 = r0
            r0 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
            java.lang.String r1 = "C78@3887L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r9 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r19 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            r20 = r3
            r21 = 0
            r23 = r0
            r0 = 106889743(0x65f020f, float:4.194315E-35)
            r24 = r1
            java.lang.String r1 = "C184@8105L6,185@8124L59,186@8222L10,187@8287L39:Tab.kt#jmzs0o"
            r27 = r2
            r2 = r20
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            int r0 = r7 >> 9
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.invoke(r2, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            float r1 = androidx.compose.material.TabKt.TextDistanceFromLeadingIcon
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2319requiredWidth3ABfNKs(r0, r1)
            r1 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r2, r1)
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r0 = r0.getTypography(r2, r1)
            androidx.compose.ui.text.TextStyle r28 = r0.getButton()
            androidx.compose.ui.text.style.TextAlign$Companion r0 = androidx.compose.ui.text.style.TextAlign.Companion
            int r0 = r0.m7417getCentere0LSkKk()
            androidx.compose.ui.text.style.TextAlign r48 = androidx.compose.ui.text.style.TextAlign.m7410boximpl(r0)
            r58 = 16744447(0xff7fff, float:2.3463968E-38)
            r59 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            androidx.compose.ui.text.TextStyle r0 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r28, r29, r31, r33, r34, r35, r36, r37, r38, r40, r41, r42, r43, r45, r46, r47, r48, r49, r50, r52, r53, r54, r55, r56, r57, r58, r59)
            int r1 = r7 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            androidx.compose.material.TextKt.ProvideTextStyle(r0, r8, r2, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r61.endReplaceableGroup()
            r61.endNode()
            r61.endReplaceableGroup()
            r61.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0211
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt$LeadingIconTab$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
