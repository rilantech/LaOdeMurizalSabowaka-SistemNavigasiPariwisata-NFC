package androidx.compose.material3.internal;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Function2<Composer, Integer, Unit>> $currentContent$delegate;
    final /* synthetic */ PopupLayout $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1(PopupLayout popupLayout, State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        super(2);
        this.$this_apply = popupLayout;
        this.$currentContent$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C102@4119L533:ExposedDropdownMenuPopup.kt#mqatfk");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(686046343, i, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:101)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, (Object) null);
            final PopupLayout popupLayout = this.$this_apply;
            Modifier modifier$iv = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, new Function1<IntSize, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    m3989invokeozmzZPI(((IntSize) p1).m7718unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI  reason: not valid java name */
                public final void m3989invokeozmzZPI(long it) {
                    popupLayout.m3992setPopupContentSizefhxjrPA(IntSize.m7706boximpl(it));
                    popupLayout.updatePosition();
                }
            }), this.$this_apply.getCanCalculatePosition() ? 1.0f : 0.0f);
            final State<Function2<Composer, Integer, Unit>> state = this.$currentContent$delegate;
            Function2 content$iv = ComposableLambdaKt.composableLambda(composer, 588819933, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C113@4618L16:ExposedDropdownMenuPopup.kt#mqatfk");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(588819933, $changed, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:112)");
                        }
                        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup$lambda$0(state).invoke($composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            });
            composer.startReplaceableGroup(-483170785);
            ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)179@6807L979:ExposedDropdownMenuPopup.kt#mqatfk");
            MeasurePolicy measurePolicy$iv$iv = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (((((48 >> 3) & 14) | ((48 << 3) & 112)) << 9) & 7168) | 6;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                composer.createNode(factory$iv$iv$iv);
            } else {
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m4575constructorimpl($composer);
            Updater.m4582setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u240$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u240$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u240$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            content$iv.invoke(composer, Integer.valueOf(($changed$iv$iv$iv >> 9) & 14));
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
