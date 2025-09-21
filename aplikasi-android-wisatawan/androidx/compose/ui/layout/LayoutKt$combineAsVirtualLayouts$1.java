package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
final class LayoutKt$combineAsVirtualLayouts$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<Function2<Composer, Integer, Unit>> $contents;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutKt$combineAsVirtualLayouts$1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        super(2);
        this.$contents = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        List $this$fastForEach$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C*180@7168L23,181@7200L298:Layout.kt#80mrfh");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953651383, i, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:178)");
            }
            List $this$fastForEach$iv2 = this.$contents;
            int index$iv = 0;
            int size = $this$fastForEach$iv2.size();
            while (index$iv < size) {
                Function2 content = $this$fastForEach$iv2.get(index$iv);
                int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                Function0 factory$iv = ComposeUiNode.Companion.getVirtualConstructor();
                composer.startReplaceableGroup(-692256719);
                ComposerKt.sourceInformation(composer, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    composer.createNode(factory$iv);
                } else {
                    $composer.useNode();
                }
                Composer $this$invoke_u24lambda_u241_u24lambda_u240 = Updater.m2865constructorimpl($composer);
                Function2 block$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                Composer $this$set_impl_u24lambda_u240$iv = $this$invoke_u24lambda_u241_u24lambda_u240;
                if (!$this$set_impl_u24lambda_u240$iv.getInserting()) {
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash))) {
                        Composer composer2 = $this$set_impl_u24lambda_u240$iv;
                        content.invoke(composer, Integer.valueOf((6 >> 6) & 14));
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        index$iv++;
                        int i2 = $changed;
                        $this$fastForEach$iv2 = $this$fastForEach$iv;
                    }
                } else {
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                }
                $this$set_impl_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                $this$invoke_u24lambda_u241_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                content.invoke(composer, Integer.valueOf((6 >> 6) & 14));
                $composer.endNode();
                $composer.endReplaceableGroup();
                index$iv++;
                int i22 = $changed;
                $this$fastForEach$iv2 = $this$fastForEach$iv;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
