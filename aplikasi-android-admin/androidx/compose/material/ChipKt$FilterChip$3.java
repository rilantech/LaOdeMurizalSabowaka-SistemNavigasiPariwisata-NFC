package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$FilterChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $selectedIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$FilterChip$3(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i, SelectableChipColors selectableChipColors, boolean z2, int i2) {
        super(2);
        this.$contentColor = state;
        this.$leadingIcon = function2;
        this.$selected = z;
        this.$selectedIcon = function22;
        this.$trailingIcon = function23;
        this.$content = function3;
        this.$$dirty1 = i;
        this.$colors = selectableChipColors;
        this.$enabled = z2;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C210@9687L3645:Chip.kt#jmzs0o");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(722126431, i, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:209)");
            }
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4965getAlphaimpl(this.$contentColor.getValue().m4973unboximpl())))};
            final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
            final boolean z = this.$selected;
            final Function2<Composer, Integer, Unit> function22 = this.$selectedIcon;
            final Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            final int i2 = this.$$dirty1;
            final SelectableChipColors selectableChipColors = this.$colors;
            final boolean z2 = this.$enabled;
            int i3 = this.$$dirty;
            final State<Color> state = this.$contentColor;
            final int i4 = i3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1582291359, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C212@9835L10,211@9779L3543:Chip.kt#jmzs0o");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1582291359, $changed, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:210)");
                        }
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final boolean z = z;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        final Function2<Composer, Integer, Unit> function23 = function23;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i = i2;
                        final SelectableChipColors selectableChipColors = selectableChipColors;
                        final boolean z2 = z2;
                        final int i2 = i4;
                        final State<Color> state = state;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer, -1543702066, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:41:0x024a  */
                            /* JADX WARNING: Removed duplicated region for block: B:44:0x0256  */
                            /* JADX WARNING: Removed duplicated region for block: B:45:0x025c  */
                            /* JADX WARNING: Removed duplicated region for block: B:48:0x028f  */
                            /* JADX WARNING: Removed duplicated region for block: B:51:0x02a5  */
                            /* JADX WARNING: Removed duplicated region for block: B:55:0x0313  */
                            /* JADX WARNING: Removed duplicated region for block: B:56:0x0366  */
                            /* JADX WARNING: Removed duplicated region for block: B:59:0x0378 A[ADDED_TO_REGION] */
                            /* JADX WARNING: Removed duplicated region for block: B:83:0x057d  */
                            /* JADX WARNING: Removed duplicated region for block: B:86:0x05c7  */
                            /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(androidx.compose.runtime.Composer r77, int r78) {
                                /*
                                    r76 = this;
                                    r0 = r76
                                    r1 = r77
                                    r2 = r78
                                    java.lang.String r3 = "C214@9884L3424:Chip.kt#jmzs0o"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
                                    r3 = r2 & 11
                                    r4 = 2
                                    if (r3 != r4) goto L_0x001c
                                    boolean r3 = r77.getSkipping()
                                    if (r3 != 0) goto L_0x0017
                                    goto L_0x001c
                                L_0x0017:
                                    r77.skipToGroupEnd()
                                    goto L_0x05ca
                                L_0x001c:
                                    boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r3 == 0) goto L_0x002b
                                    r3 = -1
                                    java.lang.String r5 = "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:213)"
                                    r6 = -1543702066(0xffffffffa3fcf9ce, float:-2.7427691E-17)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
                                L_0x002b:
                                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                                    androidx.compose.material.ChipDefaults r5 = androidx.compose.material.ChipDefaults.INSTANCE
                                    float r5 = r5.m2937getMinHeightD9Ej5fM()
                                    r6 = 0
                                    r7 = 0
                                    r8 = 1
                                    androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m2307defaultMinSizeVpY3zN4$default(r3, r7, r5, r8, r6)
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r2
                                    if (r3 != 0) goto L_0x0050
                                    boolean r3 = r3
                                    if (r3 == 0) goto L_0x004a
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r4
                                    if (r3 == 0) goto L_0x004a
                                    goto L_0x0050
                                L_0x004a:
                                    float r3 = androidx.compose.material.ChipKt.HorizontalPadding
                                    r10 = r3
                                    goto L_0x0058
                                L_0x0050:
                                    r3 = 0
                                    r5 = 0
                                    float r6 = (float) r3
                                    float r3 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r6)
                                    r10 = r3
                                L_0x0058:
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r5
                                    if (r3 != 0) goto L_0x0063
                                    float r3 = androidx.compose.material.ChipKt.HorizontalPadding
                                    r12 = r3
                                    goto L_0x006b
                                L_0x0063:
                                    r3 = 0
                                    r5 = 0
                                    float r6 = (float) r3
                                    float r6 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r6)
                                    r12 = r6
                                L_0x006b:
                                    r14 = 10
                                    r15 = 0
                                    r11 = 0
                                    r13 = 0
                                    androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m2252paddingqDBjuR0$default(r9, r10, r11, r12, r13, r14, r15)
                                    androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
                                    androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
                                    androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
                                    androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r2
                                    boolean r9 = r3
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r4
                                    kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r6
                                    int r12 = r7
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r13 = r5
                                    androidx.compose.material.SelectableChipColors r14 = r8
                                    boolean r15 = r9
                                    int r8 = r10
                                    androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> r4 = r11
                                    r18 = 432(0x1b0, float:6.05E-43)
                                    r19 = 0
                                    r0 = 693286680(0x2952b718, float:4.6788176E-14)
                                    r1.startReplaceableGroup(r0)
                                    java.lang.String r0 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
                                    int r0 = r18 >> 3
                                    r0 = r0 & 14
                                    int r20 = r18 >> 3
                                    r20 = r20 & 112(0x70, float:1.57E-43)
                                    r0 = r0 | r20
                                    androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r1, r0)
                                    int r20 = r18 << 3
                                    r20 = r20 & 112(0x70, float:1.57E-43)
                                    r21 = 0
                                    r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    r1.startReplaceableGroup(r2)
                                    java.lang.String r2 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
                                    r23 = r5
                                    r5 = 0
                                    int r24 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r5)
                                    androidx.compose.runtime.CompositionLocalMap r5 = r77.getCurrentCompositionLocalMap()
                                    androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r25 = r25.getConstructor()
                                    kotlin.jvm.functions.Function3 r26 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
                                    r27 = r3
                                    int r3 = r20 << 9
                                    r3 = r3 & 7168(0x1c00, float:1.0045E-41)
                                    r28 = r6
                                    r6 = 6
                                    r3 = r3 | r6
                                    r29 = r26
                                    r26 = r25
                                    r25 = 0
                                    androidx.compose.runtime.Applier r6 = r77.getApplier()
                                    boolean r6 = r6 instanceof androidx.compose.runtime.Applier
                                    if (r6 != 0) goto L_0x00f4
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x00f4:
                                    r77.startReusableNode()
                                    boolean r6 = r77.getInserting()
                                    if (r6 == 0) goto L_0x0103
                                    r6 = r26
                                    r1.createNode(r6)
                                    goto L_0x0108
                                L_0x0103:
                                    r6 = r26
                                    r77.useNode()
                                L_0x0108:
                                    r26 = r6
                                    androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m4575constructorimpl(r77)
                                    r31 = 0
                                    androidx.compose.ui.node.ComposeUiNode$Companion r32 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    r33 = r13
                                    kotlin.jvm.functions.Function2 r13 = r32.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r0, r13)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r6, r5, r13)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
                                    r32 = 0
                                    r34 = r6
                                    r35 = 0
                                    boolean r36 = r34.getInserting()
                                    if (r36 != 0) goto L_0x014c
                                    r36 = r0
                                    java.lang.Object r0 = r34.rememberedValue()
                                    r37 = r5
                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r24)
                                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
                                    if (r0 != 0) goto L_0x0149
                                    goto L_0x0150
                                L_0x0149:
                                    r5 = r34
                                    goto L_0x0160
                                L_0x014c:
                                    r36 = r0
                                    r37 = r5
                                L_0x0150:
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r24)
                                    r5 = r34
                                    r5.updateRememberedValue(r0)
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r24)
                                    r6.apply(r0, r13)
                                L_0x0160:
                                    androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r77)
                                    androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
                                    int r5 = r3 >> 3
                                    r5 = r5 & 112(0x70, float:1.57E-43)
                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                    r6 = r29
                                    r6.invoke(r0, r1, r5)
                                    r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                                    r1.startReplaceableGroup(r0)
                                    int r5 = r3 >> 9
                                    r5 = r5 & 14
                                    r13 = r77
                                    r29 = 0
                                    r0 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
                                    java.lang.String r1 = "C78@3887L9:Row.kt#2w3rfo"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r0, r1)
                                    androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
                                    int r1 = r18 >> 6
                                    r1 = r1 & 112(0x70, float:1.57E-43)
                                    r30 = 6
                                    r1 = r1 | 6
                                    androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
                                    r32 = r13
                                    r34 = 0
                                    r35 = r3
                                    r3 = -1943412047(0xffffffff8c29e2b1, float:-1.3087504E-31)
                                    r38 = r5
                                    java.lang.String r5 = "C276@13036L9:Chip.kt#jmzs0o"
                                    r39 = r6
                                    r6 = r32
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r5)
                                    r6.startReplaceableGroup(r3)
                                    java.lang.String r3 = "237@10896L47,238@10968L1955,274@12948L45"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
                                    if (r7 != 0) goto L_0x01cc
                                    if (r9 == 0) goto L_0x01bf
                                    if (r10 == 0) goto L_0x01bf
                                    goto L_0x01cc
                                L_0x01bf:
                                    r42 = r0
                                    r56 = r1
                                    r1 = r6
                                    r46 = r11
                                    r53 = r12
                                    r43 = r13
                                    goto L_0x055d
                                L_0x01cc:
                                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                                    float r5 = androidx.compose.material.ChipKt.LeadingIconStartSpacing
                                    androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m2327width3ABfNKs(r3, r5)
                                    r5 = 6
                                    androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r6, r5)
                                    r3 = 0
                                    r5 = r3
                                    r3 = 0
                                    r32 = r3
                                    r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                                    r6.startReplaceableGroup(r3)
                                    java.lang.String r3 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
                                    androidx.compose.ui.Modifier$Companion r41 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r41 = (androidx.compose.ui.Modifier) r41
                                    androidx.compose.ui.Alignment$Companion r42 = androidx.compose.ui.Alignment.Companion
                                    r43 = r13
                                    androidx.compose.ui.Alignment r13 = r42.getTopStart()
                                    r42 = r0
                                    r0 = 0
                                    int r44 = r5 >> 3
                                    r44 = r44 & 14
                                    int r45 = r5 >> 3
                                    r45 = r45 & 112(0x70, float:1.57E-43)
                                    r46 = r11
                                    r11 = r44 | r45
                                    androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r13, r0, r6, r11)
                                    int r44 = r5 << 3
                                    r44 = r44 & 112(0x70, float:1.57E-43)
                                    r45 = 0
                                    r47 = r0
                                    r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    r6.startReplaceableGroup(r0)
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
                                    r0 = 0
                                    int r48 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r6, r0)
                                    androidx.compose.runtime.CompositionLocalMap r0 = r6.getCurrentCompositionLocalMap()
                                    androidx.compose.ui.node.ComposeUiNode$Companion r49 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r49 = r49.getConstructor()
                                    kotlin.jvm.functions.Function3 r50 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r41)
                                    r51 = r13
                                    int r13 = r44 << 9
                                    r13 = r13 & 7168(0x1c00, float:1.0045E-41)
                                    r30 = 6
                                    r13 = r13 | 6
                                    r52 = r49
                                    r49 = r50
                                    r50 = 0
                                    r53 = r12
                                    androidx.compose.runtime.Applier r12 = r6.getApplier()
                                    boolean r12 = r12 instanceof androidx.compose.runtime.Applier
                                    if (r12 != 0) goto L_0x024d
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x024d:
                                    r6.startReusableNode()
                                    boolean r12 = r6.getInserting()
                                    if (r12 == 0) goto L_0x025c
                                    r12 = r52
                                    r6.createNode(r12)
                                    goto L_0x0261
                                L_0x025c:
                                    r12 = r52
                                    r6.useNode()
                                L_0x0261:
                                    r52 = r12
                                    androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m4575constructorimpl(r6)
                                    r54 = 0
                                    androidx.compose.ui.node.ComposeUiNode$Companion r55 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    r56 = r1
                                    kotlin.jvm.functions.Function2 r1 = r55.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r11, r1)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r1 = r1.getSetResolvedCompositionLocals()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r12, r0, r1)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r1 = r1.getSetCompositeKeyHash()
                                    r55 = 0
                                    r57 = r12
                                    r58 = 0
                                    boolean r59 = r57.getInserting()
                                    if (r59 != 0) goto L_0x02a5
                                    r59 = r0
                                    java.lang.Object r0 = r57.rememberedValue()
                                    r60 = r11
                                    java.lang.Integer r11 = java.lang.Integer.valueOf(r48)
                                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)
                                    if (r0 != 0) goto L_0x02a2
                                    goto L_0x02a9
                                L_0x02a2:
                                    r11 = r57
                                    goto L_0x02b9
                                L_0x02a5:
                                    r59 = r0
                                    r60 = r11
                                L_0x02a9:
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r48)
                                    r11 = r57
                                    r11.updateRememberedValue(r0)
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r48)
                                    r12.apply(r0, r1)
                                L_0x02b9:
                                    androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r6)
                                    androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r0)
                                    int r1 = r13 >> 3
                                    r1 = r1 & 112(0x70, float:1.57E-43)
                                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                                    r11 = r49
                                    r11.invoke(r0, r6, r1)
                                    r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                                    r6.startReplaceableGroup(r0)
                                    int r0 = r13 >> 9
                                    r0 = r0 & 14
                                    r1 = r6
                                    r12 = 0
                                    r49 = r0
                                    r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
                                    r54 = r11
                                    java.lang.String r11 = "C71@3331L9:Box.kt#2w3rfo"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r0, r11)
                                    androidx.compose.foundation.layout.BoxScopeInstance r55 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                                    int r57 = r5 >> 6
                                    r57 = r57 & 112(0x70, float:1.57E-43)
                                    r30 = 6
                                    r57 = r57 | 6
                                    androidx.compose.foundation.layout.BoxScope r55 = (androidx.compose.foundation.layout.BoxScope) r55
                                    r58 = r1
                                    r61 = 0
                                    r0 = 649985685(0x26bdfe95, float:1.3183514E-15)
                                    r63 = r5
                                    java.lang.String r5 = "C:Chip.kt#jmzs0o"
                                    r64 = r12
                                    r12 = r58
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r5)
                                    r12.startReplaceableGroup(r0)
                                    java.lang.String r0 = "240@11091L141,244@11265L297"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
                                    if (r7 == 0) goto L_0x0366
                                    int r0 = r8 >> 9
                                    r0 = r0 & 14
                                    int r5 = r8 << 3
                                    r5 = r5 & 112(0x70, float:1.57E-43)
                                    r0 = r0 | r5
                                    int r5 = r8 >> 15
                                    r5 = r5 & 896(0x380, float:1.256E-42)
                                    r0 = r0 | r5
                                    androidx.compose.runtime.State r0 = r14.leadingIconColor(r15, r9, r12, r0)
                                    androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material.ContentColorKt.getLocalContentColor()
                                    r58 = r13
                                    java.lang.Object r13 = r0.getValue()
                                    androidx.compose.runtime.ProvidedValue r5 = r5.provides(r13)
                                    androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
                                    java.lang.Object r65 = r0.getValue()
                                    androidx.compose.ui.graphics.Color r65 = (androidx.compose.ui.graphics.Color) r65
                                    long r65 = r65.m4973unboximpl()
                                    float r65 = androidx.compose.ui.graphics.Color.m4965getAlphaimpl(r65)
                                    r66 = r0
                                    java.lang.Float r0 = java.lang.Float.valueOf(r65)
                                    androidx.compose.runtime.ProvidedValue r0 = r13.provides(r0)
                                    r13 = 2
                                    androidx.compose.runtime.ProvidedValue[] r13 = new androidx.compose.runtime.ProvidedValue[r13]
                                    r17 = 0
                                    r13[r17] = r5
                                    r5 = 1
                                    r13[r5] = r0
                                    int r0 = r8 >> 21
                                    r0 = r0 & 112(0x70, float:1.57E-43)
                                    r0 = r0 | 8
                                    androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r13, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (androidx.compose.runtime.Composer) r12, (int) r0)
                                    goto L_0x0368
                                L_0x0366:
                                    r58 = r13
                                L_0x0368:
                                    r12.endReplaceableGroup()
                                    r0 = -1943411233(0xffffffff8c29e5df, float:-1.3088461E-31)
                                    r12.startReplaceableGroup(r0)
                                    java.lang.String r0 = "263@12416L451"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
                                    if (r9 == 0) goto L_0x0531
                                    if (r10 == 0) goto L_0x0531
                                    androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
                                    r65 = 0
                                    java.lang.Object r5 = r4.getValue()
                                    androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
                                    long r65 = r5.m4973unboximpl()
                                    r5 = 649986516(0x26be01d4, float:1.3184394E-15)
                                    r12.startReplaceableGroup(r5)
                                    java.lang.String r5 = "261@12309L34"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r12, r5)
                                    if (r7 == 0) goto L_0x03e1
                                    androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
                                    float r7 = androidx.compose.material.ChipKt.SelectedIconContainerSize
                                    androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m2314requiredSize3ABfNKs(r5, r7)
                                    java.lang.Object r4 = r4.getValue()
                                    androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
                                    r13 = r6
                                    long r6 = r4.m4973unboximpl()
                                    androidx.compose.foundation.shape.RoundedCornerShape r4 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
                                    androidx.compose.ui.graphics.Shape r4 = (androidx.compose.ui.graphics.Shape) r4
                                    androidx.compose.ui.Modifier r4 = androidx.compose.foundation.BackgroundKt.m1876backgroundbw27NRU(r5, r6, r4)
                                    androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
                                    androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
                                    androidx.compose.ui.Modifier r4 = androidx.compose.ui.draw.ClipKt.clip(r4, r5)
                                    r0 = r4
                                    int r4 = r8 >> 9
                                    r4 = r4 & 14
                                    int r5 = r8 << 3
                                    r5 = r5 & 112(0x70, float:1.57E-43)
                                    r4 = r4 | r5
                                    int r5 = r8 >> 15
                                    r5 = r5 & 896(0x380, float:1.256E-42)
                                    r4 = r4 | r5
                                    androidx.compose.runtime.State r4 = r14.backgroundColor(r15, r9, r12, r4)
                                    java.lang.Object r4 = r4.getValue()
                                    androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
                                    long r65 = r4.m4973unboximpl()
                                    goto L_0x03e2
                                L_0x03e1:
                                    r13 = r6
                                L_0x03e2:
                                    r12.endReplaceableGroup()
                                    androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
                                    androidx.compose.ui.Alignment r4 = r4.getCenter()
                                    r5 = 48
                                    r6 = 0
                                    r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                                    r12.startReplaceableGroup(r7)
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
                                    r3 = 0
                                    int r7 = r5 >> 3
                                    r7 = r7 & 14
                                    int r9 = r5 >> 3
                                    r9 = r9 & 112(0x70, float:1.57E-43)
                                    r7 = r7 | r9
                                    androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r3, r12, r7)
                                    int r9 = r5 << 3
                                    r9 = r9 & 112(0x70, float:1.57E-43)
                                    r14 = 0
                                    r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    r12.startReplaceableGroup(r15)
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
                                    r2 = 0
                                    int r15 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r2)
                                    androidx.compose.runtime.CompositionLocalMap r2 = r12.getCurrentCompositionLocalMap()
                                    androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
                                    kotlin.jvm.functions.Function3 r22 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
                                    r40 = r0
                                    int r0 = r9 << 9
                                    r0 = r0 & 7168(0x1c00, float:1.0045E-41)
                                    r30 = 6
                                    r0 = r0 | 6
                                    r67 = r17
                                    r17 = r22
                                    r22 = 0
                                    r68 = r3
                                    androidx.compose.runtime.Applier r3 = r12.getApplier()
                                    boolean r3 = r3 instanceof androidx.compose.runtime.Applier
                                    if (r3 != 0) goto L_0x0444
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x0444:
                                    r12.startReusableNode()
                                    boolean r3 = r12.getInserting()
                                    if (r3 == 0) goto L_0x0453
                                    r3 = r67
                                    r12.createNode(r3)
                                    goto L_0x0458
                                L_0x0453:
                                    r3 = r67
                                    r12.useNode()
                                L_0x0458:
                                    r67 = r3
                                    androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r12)
                                    r69 = 0
                                    androidx.compose.ui.node.ComposeUiNode$Companion r70 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    r71 = r4
                                    kotlin.jvm.functions.Function2 r4 = r70.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r7, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
                                    androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r2, r4)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
                                    r70 = 0
                                    r72 = r3
                                    r73 = 0
                                    boolean r74 = r72.getInserting()
                                    if (r74 != 0) goto L_0x049c
                                    r74 = r2
                                    java.lang.Object r2 = r72.rememberedValue()
                                    r75 = r6
                                    java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
                                    boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
                                    if (r2 != 0) goto L_0x0499
                                    goto L_0x04a0
                                L_0x0499:
                                    r6 = r72
                                    goto L_0x04b0
                                L_0x049c:
                                    r74 = r2
                                    r75 = r6
                                L_0x04a0:
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
                                    r6 = r72
                                    r6.updateRememberedValue(r2)
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
                                    r3.apply(r2, r4)
                                L_0x04b0:
                                    androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r12)
                                    androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r2)
                                    int r3 = r0 >> 3
                                    r3 = r3 & 112(0x70, float:1.57E-43)
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                                    r4 = r17
                                    r4.invoke(r2, r12, r3)
                                    r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                                    r12.startReplaceableGroup(r2)
                                    int r2 = r0 >> 9
                                    r2 = r2 & 14
                                    r3 = r12
                                    r6 = 0
                                    r17 = r0
                                    r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r11)
                                    androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                                    int r11 = r5 >> 6
                                    r11 = r11 & 112(0x70, float:1.57E-43)
                                    r30 = 6
                                    r11 = r11 | 6
                                    androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
                                    r31 = r3
                                    r62 = 0
                                    r69 = r0
                                    r0 = 333805201(0x13e57691, float:5.7924643E-27)
                                    r70 = r2
                                    java.lang.String r2 = "C267@12629L204:Chip.kt#jmzs0o"
                                    r72 = r4
                                    r4 = r31
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r2)
                                    androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
                                    androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m4953boximpl(r65)
                                    androidx.compose.runtime.ProvidedValue r0 = r0.provides(r2)
                                    r2 = 1
                                    androidx.compose.runtime.ProvidedValue[] r2 = new androidx.compose.runtime.ProvidedValue[r2]
                                    r16 = 0
                                    r2[r16] = r0
                                    int r0 = r8 >> 24
                                    r0 = r0 & 112(0x70, float:1.57E-43)
                                    r0 = r0 | 8
                                    androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (androidx.compose.runtime.Composer) r4, (int) r0)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                                    r12.endReplaceableGroup()
                                    r12.endNode()
                                    r12.endReplaceableGroup()
                                    r12.endReplaceableGroup()
                                    goto L_0x0532
                                L_0x0531:
                                    r13 = r6
                                L_0x0532:
                                    r12.endReplaceableGroup()
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
                                    r13.endReplaceableGroup()
                                    r13.endNode()
                                    r13.endReplaceableGroup()
                                    r13.endReplaceableGroup()
                                    androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
                                    float r1 = androidx.compose.material.ChipKt.LeadingIconEndSpacing
                                    androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2327width3ABfNKs(r0, r1)
                                    r1 = r13
                                    r2 = 6
                                    androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r2)
                                L_0x055d:
                                    r1.endReplaceableGroup()
                                    r0 = r56 & 14
                                    r2 = r53 & 112(0x70, float:1.57E-43)
                                    r0 = r0 | r2
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                                    r3 = r42
                                    r2 = r46
                                    r2.invoke(r3, r1, r0)
                                    r0 = -1181292829(0xffffffffb996e6e3, float:-2.8782254E-4)
                                    r1.startReplaceableGroup(r0)
                                    java.lang.String r0 = "278@13118L43,279@13186L14,280@13225L43"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
                                    if (r33 == 0) goto L_0x05a7
                                    androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
                                    float r2 = androidx.compose.material.ChipKt.TrailingIconSpacing
                                    androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2327width3ABfNKs(r0, r2)
                                    r2 = 6
                                    androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r2)
                                    r0 = r53 & 14
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                                    r4 = r33
                                    r4.invoke(r1, r0)
                                    androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
                                    float r4 = androidx.compose.material.ChipKt.TrailingIconSpacing
                                    androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2327width3ABfNKs(r0, r4)
                                    androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r2)
                                L_0x05a7:
                                    r1.endReplaceableGroup()
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r43)
                                    r77.endReplaceableGroup()
                                    r77.endNode()
                                    r77.endReplaceableGroup()
                                    r77.endReplaceableGroup()
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L_0x05ca
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L_0x05ca:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt$FilterChip$3.AnonymousClass1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }), $composer, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
