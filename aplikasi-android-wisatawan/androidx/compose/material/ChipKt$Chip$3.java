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
final class ChipKt$Chip$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor$delegate;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$Chip$3(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, ChipColors chipColors, boolean z, int i, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$contentColor$delegate = state;
        this.$leadingIcon = function2;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C109@4894L1442:Chip.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(139076687, $changed, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
            }
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3255getAlphaimpl(ChipKt.Chip$lambda$1(this.$contentColor$delegate))))};
            final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
            final ChipColors chipColors = this.$colors;
            final boolean z = this.$enabled;
            final int i = this.$$dirty;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, 667535631, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C111@5036L10,110@4980L1346:Chip.kt#jmzs0o");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(667535631, $changed, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                        }
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final ChipColors chipColors = chipColors;
                        final boolean z = z;
                        final int i = i;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer, -1131213696, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:28:0x0190  */
                            /* JADX WARNING: Removed duplicated region for block: B:31:0x0223  */
                            /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(androidx.compose.runtime.Composer r34, int r35) {
                                /*
                                    r33 = this;
                                    r0 = r33
                                    r1 = r34
                                    r2 = r35
                                    java.lang.String r3 = "C113@5085L1227:Chip.kt#jmzs0o"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
                                    r3 = r2 & 11
                                    r4 = 2
                                    if (r3 != r4) goto L_0x001c
                                    boolean r3 = r34.getSkipping()
                                    if (r3 != 0) goto L_0x0017
                                    goto L_0x001c
                                L_0x0017:
                                    r34.skipToGroupEnd()
                                    goto L_0x0226
                                L_0x001c:
                                    boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r3 == 0) goto L_0x002b
                                    r3 = -1
                                    java.lang.String r5 = "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)"
                                    r6 = -1131213696(0xffffffffbc930c80, float:-0.017950296)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r6, r2, r3, r5)
                                L_0x002b:
                                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                                    androidx.compose.material.ChipDefaults r5 = androidx.compose.material.ChipDefaults.INSTANCE
                                    float r5 = r5.m1227getMinHeightD9Ej5fM()
                                    r6 = 0
                                    r7 = 0
                                    r8 = 1
                                    androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m597defaultMinSizeVpY3zN4$default(r3, r7, r5, r8, r6)
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r2
                                    if (r3 != 0) goto L_0x0047
                                    float r3 = androidx.compose.material.ChipKt.HorizontalPadding
                                    r10 = r3
                                    goto L_0x004f
                                L_0x0047:
                                    r3 = 0
                                    r5 = 0
                                    float r6 = (float) r3
                                    float r6 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r6)
                                    r10 = r6
                                L_0x004f:
                                    float r12 = androidx.compose.material.ChipKt.HorizontalPadding
                                    r14 = 10
                                    r15 = 0
                                    r11 = 0
                                    r13 = 0
                                    androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m542paddingqDBjuR0$default(r9, r10, r11, r12, r13, r14, r15)
                                    androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
                                    androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
                                    androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
                                    androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
                                    kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r2
                                    androidx.compose.material.ChipColors r9 = r3
                                    boolean r10 = r4
                                    int r11 = r5
                                    kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r6
                                    r13 = 432(0x1b0, float:6.05E-43)
                                    r14 = 0
                                    r15 = 693286680(0x2952b718, float:4.6788176E-14)
                                    r1.startReplaceableGroup(r15)
                                    java.lang.String r15 = "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r15)
                                    int r15 = r13 >> 3
                                    r15 = r15 & 14
                                    int r16 = r13 >> 3
                                    r16 = r16 & 112(0x70, float:1.57E-43)
                                    r15 = r15 | r16
                                    androidx.compose.ui.layout.MeasurePolicy r15 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r1, r15)
                                    int r16 = r13 << 3
                                    r16 = r16 & 112(0x70, float:1.57E-43)
                                    r17 = 0
                                    r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                                    r1.startReplaceableGroup(r8)
                                    java.lang.String r8 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
                                    r8 = 0
                                    int r18 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r1, r8)
                                    androidx.compose.runtime.CompositionLocalMap r8 = r34.getCurrentCompositionLocalMap()
                                    androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function0 r20 = r20.getConstructor()
                                    kotlin.jvm.functions.Function3 r21 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r3)
                                    int r4 = r16 << 9
                                    r4 = r4 & 7168(0x1c00, float:1.0045E-41)
                                    r0 = 6
                                    r4 = r4 | r0
                                    r22 = r21
                                    r21 = r20
                                    r20 = 0
                                    androidx.compose.runtime.Applier r0 = r34.getApplier()
                                    boolean r0 = r0 instanceof androidx.compose.runtime.Applier
                                    if (r0 != 0) goto L_0x00cb
                                    androidx.compose.runtime.ComposablesKt.invalidApplier()
                                L_0x00cb:
                                    r34.startReusableNode()
                                    boolean r0 = r34.getInserting()
                                    if (r0 == 0) goto L_0x00da
                                    r0 = r21
                                    r1.createNode(r0)
                                    goto L_0x00df
                                L_0x00da:
                                    r0 = r21
                                    r34.useNode()
                                L_0x00df:
                                    r21 = r0
                                    androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2865constructorimpl(r34)
                                    r24 = 0
                                    androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r2 = r25.getSetMeasurePolicy()
                                    androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r15, r2)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
                                    androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r0, r8, r2)
                                    androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                                    kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
                                    r25 = 0
                                    r26 = r0
                                    r27 = 0
                                    boolean r28 = r26.getInserting()
                                    if (r28 != 0) goto L_0x0121
                                    r28 = r3
                                    java.lang.Object r3 = r26.rememberedValue()
                                    r29 = r5
                                    java.lang.Integer r5 = java.lang.Integer.valueOf(r18)
                                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
                                    if (r3 != 0) goto L_0x011e
                                    goto L_0x0125
                                L_0x011e:
                                    r5 = r26
                                    goto L_0x0135
                                L_0x0121:
                                    r28 = r3
                                    r29 = r5
                                L_0x0125:
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
                                    r5 = r26
                                    r5.updateRememberedValue(r3)
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
                                    r0.apply(r3, r2)
                                L_0x0135:
                                    androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r34)
                                    androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r0)
                                    int r2 = r4 >> 3
                                    r2 = r2 & 112(0x70, float:1.57E-43)
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                    r3 = r22
                                    r3.invoke(r0, r1, r2)
                                    r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                                    r1.startReplaceableGroup(r0)
                                    int r0 = r4 >> 9
                                    r0 = r0 & 14
                                    r2 = r34
                                    r5 = 0
                                    r22 = r0
                                    r0 = -326682417(0xffffffffec8738cf, float:-1.307786E27)
                                    java.lang.String r1 = "C78@3887L9:Row.kt#2w3rfo"
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
                                    androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
                                    int r1 = r13 >> 6
                                    r1 = r1 & 112(0x70, float:1.57E-43)
                                    r23 = 6
                                    r1 = r1 | 6
                                    androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
                                    r24 = r2
                                    r25 = 0
                                    r26 = r3
                                    r3 = 2084788937(0x7c435ac9, float:4.057357E36)
                                    r27 = r4
                                    java.lang.String r4 = "C137@6285L9:Chip.kt#jmzs0o"
                                    r30 = r5
                                    r5 = r24
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r3, r4)
                                    r5.startReplaceableGroup(r3)
                                    java.lang.String r3 = "128@5738L47,129@5848L32,130@5905L267,135@6197L45"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
                                    if (r7 == 0) goto L_0x01f5
                                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                                    float r4 = androidx.compose.material.ChipKt.LeadingIconStartSpacing
                                    androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m617width3ABfNKs(r3, r4)
                                    r4 = 6
                                    androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r5, r4)
                                    int r3 = r11 >> 6
                                    r3 = r3 & 14
                                    int r4 = r11 >> 15
                                    r4 = r4 & 112(0x70, float:1.57E-43)
                                    r3 = r3 | r4
                                    androidx.compose.runtime.State r3 = r9.leadingIconContentColor(r10, r5, r3)
                                    androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.material.ContentColorKt.getLocalContentColor()
                                    long r9 = invoke$lambda$1$lambda$0(r3)
                                    androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m3243boximpl(r9)
                                    androidx.compose.runtime.ProvidedValue r4 = r4.provides(r9)
                                    androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
                                    long r31 = invoke$lambda$1$lambda$0(r3)
                                    float r10 = androidx.compose.ui.graphics.Color.m3255getAlphaimpl(r31)
                                    java.lang.Float r10 = java.lang.Float.valueOf(r10)
                                    androidx.compose.runtime.ProvidedValue r9 = r9.provides(r10)
                                    r10 = 2
                                    androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r10]
                                    r19 = 0
                                    r10[r19] = r4
                                    r4 = 1
                                    r10[r4] = r9
                                    int r4 = r11 >> 18
                                    r4 = r4 & 112(0x70, float:1.57E-43)
                                    r4 = r4 | 8
                                    androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r10, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (androidx.compose.runtime.Composer) r5, (int) r4)
                                    androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
                                    androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
                                    float r7 = androidx.compose.material.ChipKt.LeadingIconEndSpacing
                                    androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m617width3ABfNKs(r4, r7)
                                    r7 = 6
                                    androidx.compose.foundation.layout.SpacerKt.Spacer(r4, r5, r7)
                                L_0x01f5:
                                    r5.endReplaceableGroup()
                                    r3 = r1 & 14
                                    int r4 = r11 >> 21
                                    r4 = r4 & 112(0x70, float:1.57E-43)
                                    r3 = r3 | r4
                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                                    r12.invoke(r0, r5, r3)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
                                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
                                    r34.endReplaceableGroup()
                                    r34.endNode()
                                    r34.endReplaceableGroup()
                                    r34.endReplaceableGroup()
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L_0x0226
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L_0x0226:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt$Chip$3.AnonymousClass1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }

                            private static final long invoke$lambda$1$lambda$0(State<Color> $leadingIconContentColor$delegate) {
                                return ((Color) $leadingIconContentColor$delegate.getValue()).m3263unboximpl();
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
            }), $composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
