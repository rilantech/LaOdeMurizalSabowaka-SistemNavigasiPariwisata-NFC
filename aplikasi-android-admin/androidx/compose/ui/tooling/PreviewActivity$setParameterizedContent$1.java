package androidx.compose.ui.tooling;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonElevation;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
final class PreviewActivity$setParameterizedContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;
    final /* synthetic */ Object[] $previewParameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewActivity$setParameterizedContent$1(Object[] objArr, String str, String str2) {
        super(2);
        this.$previewParameters = objArr;
        this.$className = str;
        this.$methodName = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C109@4593L33,111@4644L837:PreviewActivity.kt#hevd2p");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1735847170, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.kt:108)");
            }
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            final MutableIntState index = (MutableIntState) value$iv$iv;
            final Object[] objArr = this.$previewParameters;
            final String str = this.$className;
            final String str2 = this.$methodName;
            final Object[] objArr2 = this.$previewParameters;
            MutableIntState mutableIntState = index;
            ScaffoldKt.m3099Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(composer, 2137630662, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    int i = $changed;
                    ComposerKt.sourceInformation($composer, "C123@5168L273:PreviewActivity.kt#hevd2p");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2137630662, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.kt:122)");
                        }
                        Function2<Composer, Integer, Unit> r3 = ComposableSingletons$PreviewActivityKt.INSTANCE.m7472getLambda1$ui_tooling_release();
                        final MutableIntState mutableIntState = index;
                        final Object[] objArr = objArr;
                        FloatingActionButtonKt.m3034ExtendedFloatingActionButtonwqdebIU(r3, new Function0<Unit>() {
                            public final void invoke() {
                                MutableIntState mutableIntState = mutableIntState;
                                mutableIntState.setIntValue((mutableIntState.getIntValue() + 1) % objArr.length);
                            }
                        }, (Modifier) null, (Function2<? super Composer, ? super Integer, Unit>) null, (MutableInteractionSource) null, (Shape) null, 0, 0, (FloatingActionButtonElevation) null, $composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer, -1578412612, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((PaddingValues) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:31:0x019e  */
                /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.runtime.Composer r31, int r32) {
                    /*
                        r29 = this;
                        r0 = r29
                        r1 = r30
                        r2 = r31
                        r3 = r32
                        java.lang.String r4 = "padding"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
                        java.lang.String r4 = "C113@4721L354:PreviewActivity.kt#hevd2p"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
                        r4 = r32
                        r5 = r3 & 14
                        if (r5 != 0) goto L_0x0023
                        boolean r5 = r2.changed((java.lang.Object) r1)
                        if (r5 == 0) goto L_0x0021
                        r5 = 4
                        goto L_0x0022
                    L_0x0021:
                        r5 = 2
                    L_0x0022:
                        r4 = r4 | r5
                    L_0x0023:
                        r5 = r4 & 91
                        r6 = 18
                        if (r5 != r6) goto L_0x0037
                        boolean r5 = r31.getSkipping()
                        if (r5 != 0) goto L_0x0030
                        goto L_0x0037
                    L_0x0030:
                        r31.skipToGroupEnd()
                        r20 = r4
                        goto L_0x01a1
                    L_0x0037:
                        boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r5 == 0) goto L_0x0046
                        r5 = -1
                        java.lang.String r6 = "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.kt:112)"
                        r7 = -1578412612(0xffffffffa1eb55bc, float:-1.5946913E-18)
                        androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r5, r6)
                    L_0x0046:
                        androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
                        androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.padding(r5, r1)
                        java.lang.String r6 = r2
                        java.lang.String r7 = r4
                        java.lang.Object[] r8 = r5
                        androidx.compose.runtime.MutableIntState r9 = r14
                        r10 = 0
                        r11 = 0
                        r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                        r2.startReplaceableGroup(r12)
                        java.lang.String r12 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
                        androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r12 = r12.getTopStart()
                        r13 = 0
                        int r14 = r10 >> 3
                        r14 = r14 & 14
                        int r15 = r10 >> 3
                        r15 = r15 & 112(0x70, float:1.57E-43)
                        r14 = r14 | r15
                        androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r13, r2, r14)
                        int r15 = r10 << 3
                        r15 = r15 & 112(0x70, float:1.57E-43)
                        r16 = 0
                        r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                        r2.startReplaceableGroup(r0)
                        java.lang.String r0 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
                        r0 = 0
                        int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r0)
                        androidx.compose.runtime.CompositionLocalMap r1 = r31.getCurrentCompositionLocalMap()
                        androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
                        kotlin.jvm.functions.Function3 r18 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r5)
                        int r3 = r15 << 9
                        r3 = r3 & 7168(0x1c00, float:1.0045E-41)
                        r3 = r3 | 6
                        r19 = r17
                        r17 = r18
                        r18 = 0
                        r20 = r4
                        androidx.compose.runtime.Applier r4 = r31.getApplier()
                        boolean r4 = r4 instanceof androidx.compose.runtime.Applier
                        if (r4 != 0) goto L_0x00b5
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x00b5:
                        r31.startReusableNode()
                        boolean r4 = r31.getInserting()
                        if (r4 == 0) goto L_0x00c4
                        r4 = r19
                        r2.createNode(r4)
                        goto L_0x00c9
                    L_0x00c4:
                        r4 = r19
                        r31.useNode()
                    L_0x00c9:
                        r19 = r4
                        androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m4575constructorimpl(r31)
                        r21 = 0
                        androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
                        r23 = r5
                        kotlin.jvm.functions.Function2 r5 = r22.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r14, r5)
                        androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
                        androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r4, r1, r5)
                        androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
                        r22 = 0
                        r24 = r4
                        r25 = 0
                        boolean r26 = r24.getInserting()
                        if (r26 != 0) goto L_0x010d
                        r26 = r1
                        java.lang.Object r1 = r24.rememberedValue()
                        r27 = r11
                        java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
                        boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r11)
                        if (r1 != 0) goto L_0x010a
                        goto L_0x0111
                    L_0x010a:
                        r11 = r24
                        goto L_0x0121
                    L_0x010d:
                        r26 = r1
                        r27 = r11
                    L_0x0111:
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                        r11 = r24
                        r11.updateRememberedValue(r1)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                        r4.apply(r1, r5)
                    L_0x0121:
                        androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r31)
                        androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
                        int r4 = r3 >> 3
                        r4 = r4 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                        r5 = r17
                        r5.invoke(r1, r2, r4)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r2.startReplaceableGroup(r1)
                        int r1 = r3 >> 9
                        r1 = r1 & 14
                        r4 = r31
                        r11 = 0
                        r17 = r0
                        r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
                        r21 = r1
                        java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r1)
                        androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        int r1 = r10 >> 6
                        r1 = r1 & 112(0x70, float:1.57E-43)
                        r1 = r1 | 6
                        androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
                        r22 = r4
                        r24 = 0
                        r25 = r0
                        r0 = -513396381(0xffffffffe1663163, float:-2.6539436E20)
                        r28 = r1
                        java.lang.String r1 = "C:PreviewActivity.kt#hevd2p"
                        r2 = r22
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
                        androidx.compose.ui.tooling.ComposableInvoker r0 = androidx.compose.ui.tooling.ComposableInvoker.INSTANCE
                        int r1 = r9.getIntValue()
                        r1 = r8[r1]
                        java.lang.Object[] r1 = new java.lang.Object[]{r1}
                        r0.invokeComposable(r6, r7, r2, r1)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
                        r31.endReplaceableGroup()
                        r31.endNode()
                        r31.endReplaceableGroup()
                        r31.endReplaceableGroup()
                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r0 == 0) goto L_0x01a1
                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                    L_0x01a1:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1.AnonymousClass2.invoke(androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):void");
                }
            }), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 12582912, 131039);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
