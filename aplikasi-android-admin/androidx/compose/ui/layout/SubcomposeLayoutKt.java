package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "intermediateMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "measurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class SubcomposeLayoutKt {
    public static final void SubcomposeLayout(Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(-1298353104);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(1)77@3566L36,76@3532L144:SubcomposeLayout.kt#80mrfh");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298353104, $dirty2, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:72)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new SubcomposeLayoutState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayout((SubcomposeLayoutState) value$iv$iv, modifier, measurePolicy, $composer2, (($dirty2 << 3) & 112) | 8 | (($dirty2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$2(modifier, measurePolicy, $changed, i));
        }
    }

    public static final void SubcomposeLayout(Modifier modifier, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> intermediateMeasurePolicy, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(159215138);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(2)139@6954L36,138@6920L207:SubcomposeLayout.kt#80mrfh");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(intermediateMeasurePolicy) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.Companion;
            }
            if (i3 != 0) {
                intermediateMeasurePolicy = SubcomposeLayoutKt$SubcomposeLayout$3.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(159215138, $dirty2, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:130)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new SubcomposeLayoutState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayout((SubcomposeLayoutState) value$iv$iv, modifier, intermediateMeasurePolicy, measurePolicy, $composer2, (($dirty2 << 3) & 112) | 8 | (($dirty2 << 3) & 896) | (($dirty2 << 3) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$5(modifier, intermediateMeasurePolicy, measurePolicy, $changed, i));
        }
    }

    public static final void SubcomposeLayout(SubcomposeLayoutState state, Modifier modifier, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(-511989831);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(2,1)260@13431L80:SubcomposeLayout.kt#80mrfh");
        int $dirty = $changed;
        if ((i & 2) != 0) {
            modifier = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511989831, $dirty, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:254)");
        }
        SubcomposeLayoutState subcomposeLayoutState = state;
        Modifier modifier2 = modifier;
        SubcomposeLayout(subcomposeLayoutState, modifier2, SubcomposeLayoutKt$SubcomposeLayout$6.INSTANCE, measurePolicy, $composer2, ($dirty & 112) | 392 | (($dirty << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$7(state, modifier, measurePolicy, $changed, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SubcomposeLayout(androidx.compose.ui.layout.SubcomposeLayoutState r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r7 = r20
            r8 = r23
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 2129414763(0x7eec4a6b, float:1.570421E38)
            r1 = r24
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SubcomposeLayout)P(3,2)319@16791L23,320@16844L28,323@17000L604,344@17744L27,345@17799L89,345@17776L112:SubcomposeLayout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r26 & 2
            if (r1 == 0) goto L_0x0028
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r10 = r1
            goto L_0x002a
        L_0x0028:
            r10 = r21
        L_0x002a:
            r1 = r26 & 4
            if (r1 == 0) goto L_0x0034
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$8 r1 = androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$8.INSTANCE
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r11 = r1
            goto L_0x0036
        L_0x0034:
            r11 = r22
        L_0x0036:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0045
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:310)"
            r12 = r25
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
            goto L_0x0047
        L_0x0045:
            r12 = r25
        L_0x0047:
            r0 = 0
            int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r0)
            androidx.compose.runtime.CompositionContext r14 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r9, r0)
            androidx.compose.ui.Modifier r15 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r9, r10)
            androidx.compose.runtime.CompositionLocalMap r6 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.LayoutNode$Companion r1 = androidx.compose.ui.node.LayoutNode.Companion
            kotlin.jvm.functions.Function0 r1 = r1.getConstructor$ui_release()
            r2 = 6
            r3 = r2
            r4 = 0
            r5 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r9.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r5)
            androidx.compose.runtime.Applier r5 = r9.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x0078
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0078:
            r9.startNode()
            boolean r5 = r9.getInserting()
            if (r5 == 0) goto L_0x008c
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1 r5 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1
            r5.<init>(r1)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r9.createNode(r5)
            goto L_0x008f
        L_0x008c:
            r9.useNode()
        L_0x008f:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r16 = 0
            kotlin.jvm.functions.Function2 r2 = r20.getSetRoot$ui_release()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r7, r2)
            kotlin.jvm.functions.Function2 r2 = r20.getSetCompositionContext$ui_release()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r14, r2)
            kotlin.jvm.functions.Function2 r2 = r20.getSetMeasurePolicy$ui_release()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r8, r2)
            kotlin.jvm.functions.Function2 r2 = r20.getSetIntermediateMeasurePolicy$ui_release()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r11, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetModifier()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r5, r15, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
            r17 = 0
            r22 = r5
            r18 = 0
            boolean r19 = r22.getInserting()
            if (r19 != 0) goto L_0x00eb
            java.lang.Object r0 = r22.rememberedValue()
            r19 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ed
        L_0x00e8:
            r1 = r22
            goto L_0x00fd
        L_0x00eb:
            r19 = r1
        L_0x00ed:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r1 = r22
            r1.updateRememberedValue(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r5.apply(r0, r2)
        L_0x00fd:
            r9.endNode()
            r9.endReplaceableGroup()
            r0 = -607836798(0xffffffffdbc52582, float:-1.10983621E17)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "340@17650L65"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0125
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$10 r0 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$10
            r0.<init>(r7)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r9, r1)
        L_0x0125:
            r9.endReplaceableGroup()
            r0 = 8
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r7, r9, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1 = 0
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r3)
            boolean r3 = r9.changed((java.lang.Object) r5)
            r4 = r9
            r16 = 0
            r22 = r1
            java.lang.Object r1 = r4.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x015c
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r24 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r1 != r2) goto L_0x0159
            goto L_0x015e
        L_0x0159:
            r18 = r1
            goto L_0x016d
        L_0x015c:
            r24 = r2
        L_0x015e:
            r2 = 0
            r18 = r1
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$11$1 r1 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$11$1
            r1.<init>(r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.updateRememberedValue(r1)
        L_0x016d:
            r9.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = 6
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r9, (int) r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0181
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0181:
            androidx.compose.runtime.ScopeUpdateScope r4 = r9.endRestartGroup()
            if (r4 != 0) goto L_0x018c
            r17 = r5
            r18 = r6
            goto L_0x01a9
        L_0x018c:
            androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$12 r16 = new androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$12
            r0 = r16
            r1 = r20
            r2 = r10
            r3 = r11
            r7 = r4
            r4 = r23
            r17 = r5
            r5 = r25
            r18 = r6
            r6 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r7.updateScope(r0)
        L_0x01a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(androidx.compose.ui.layout.SubcomposeLayoutState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int maxSlotsToRetainForReuse) {
        return new FixedCountSubcomposeSlotReusePolicy(maxSlotsToRetainForReuse);
    }
}
