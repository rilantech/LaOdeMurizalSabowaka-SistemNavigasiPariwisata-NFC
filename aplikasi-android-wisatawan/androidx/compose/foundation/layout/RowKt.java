package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0015\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Row.kt */
public final class RowKt {
    private static final MeasurePolicy DefaultRowMeasurePolicy;

    public static /* synthetic */ void getDefaultRowMeasurePolicy$annotations() {
    }

    public static final void Row(Modifier modifier, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Horizontal horizontalArrangement2;
        Alignment.Vertical verticalAlignment2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        if ((i & 2) != 0) {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if ((i & 4) != 0) {
            verticalAlignment2 = Alignment.Companion.getTop();
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        MeasurePolicy measurePolicy = rowMeasurePolicy(horizontalArrangement2, verticalAlignment2, composer, (($changed >> 3) & 14) | (($changed >> 3) & 112));
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
            Arrangement.Horizontal horizontal = horizontalArrangement2;
            if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv;
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                int i2 = ($changed$iv$iv >> 9) & 14;
                Composer $composer2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer2, -326682417, "C78@3887L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            }
        } else {
            Arrangement.Horizontal horizontal2 = horizontalArrangement2;
        }
        $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        int i22 = ($changed$iv$iv >> 9) & 14;
        Composer $composer22 = $composer;
        ComposerKt.sourceInformationMarkerStart($composer22, -326682417, "C78@3887L9:Row.kt#2w3rfo");
        function3.invoke(RowScopeInstance.INSTANCE, $composer22, Integer.valueOf((($changed >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer22);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
        float r1 = Arrangement.INSTANCE.getStart().m430getSpacingD9Ej5fM();
        CrossAxisAlignment vertical$foundation_layout_release = CrossAxisAlignment.Companion.vertical$foundation_layout_release(Alignment.Companion.getTop());
        DefaultRowMeasurePolicy = RowColumnImplKt.m581rowColumnMeasurePolicyTDGSqEk(layoutOrientation, RowKt$DefaultRowMeasurePolicy$1.INSTANCE, r1, SizeMode.Wrap, vertical$foundation_layout_release);
    }

    public static final MeasurePolicy getDefaultRowMeasurePolicy() {
        return DefaultRowMeasurePolicy;
    }

    public static final MeasurePolicy rowMeasurePolicy(Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, Composer $composer, int $changed) {
        MeasurePolicy measurePolicy;
        MeasurePolicy measurePolicy2;
        Arrangement.Horizontal horizontal = horizontalArrangement;
        Alignment.Vertical vertical = verticalAlignment;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(horizontal, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(vertical, "verticalAlignment");
        composer.startReplaceableGroup(-837807694);
        ComposerKt.sourceInformation(composer, "C(rowMeasurePolicy)106@4837L639:Row.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-837807694, i, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:100)");
        }
        if (!Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getStart()) || !Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop())) {
            int i2 = (i & 14) | (i & 112);
            composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) horizontal) | composer.changed((Object) vertical);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
                float r13 = horizontalArrangement.m430getSpacingD9Ej5fM();
                CrossAxisAlignment vertical$foundation_layout_release = CrossAxisAlignment.Companion.vertical$foundation_layout_release(vertical);
                measurePolicy2 = RowColumnImplKt.m581rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new RowKt$rowMeasurePolicy$1$1(horizontal), r13, SizeMode.Wrap, vertical$foundation_layout_release);
                $this$cache$iv$iv.updateRememberedValue(measurePolicy2);
            } else {
                measurePolicy2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            measurePolicy = measurePolicy2;
        } else {
            measurePolicy = DefaultRowMeasurePolicy;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }
}
