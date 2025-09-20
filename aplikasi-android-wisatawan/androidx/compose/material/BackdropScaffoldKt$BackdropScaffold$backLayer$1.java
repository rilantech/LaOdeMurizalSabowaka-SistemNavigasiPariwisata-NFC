package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$backLayer$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $appBar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $backLayerContent;
    final /* synthetic */ boolean $persistentAppBar;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$backLayer$1(boolean z, BackdropScaffoldState backdropScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i) {
        super(2);
        this.$persistentAppBar = z;
        this.$scaffoldState = backdropScaffoldState;
        this.$appBar = function2;
        this.$backLayerContent = function22;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Function0<ComposeUiNode> function0;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C:BackdropScaffold.kt#jmzs0o");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1744778315, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:278)");
            }
            if (this.$persistentAppBar) {
                composer.startReplaceableGroup(-1017265331);
                ComposerKt.sourceInformation(composer, "280@12876L82");
                Function2<Composer, Integer, Unit> function2 = this.$appBar;
                int i2 = this.$$dirty;
                Function2<Composer, Integer, Unit> function22 = this.$backLayerContent;
                composer.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                composer.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function0 = constructor;
                    composer.createNode(function0);
                } else {
                    function0 = constructor;
                    $composer.useNode();
                }
                Function0<ComposeUiNode> function02 = function0;
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2865constructorimpl($composer);
                Modifier modifier = modifier$iv;
                Updater.m2872setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                if (!$this$set_impl_u24lambda_u240$iv$iv$iv.getInserting()) {
                    Arrangement.Vertical vertical = verticalArrangement$iv;
                    Alignment.Horizontal horizontal = horizontalAlignment$iv;
                    if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv$iv))) {
                        Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv$iv;
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        composer.startReplaceableGroup(2058660585);
                        Composer $composer$iv = $composer;
                        int i3 = $changed$iv$iv$iv;
                        int i4 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, 276693570, "C77@3893L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i5 = ((0 >> 6) & 112) | 6;
                        Composer $composer2 = $composer$iv;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1993300203, "C281@12901L8,282@12926L18:BackdropScaffold.kt#jmzs0o");
                        function2.invoke($composer2, Integer.valueOf(i2 & 14));
                        function22.invoke($composer2, Integer.valueOf((i2 >> 3) & 14));
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                    }
                } else {
                    Alignment.Horizontal horizontal2 = horizontalAlignment$iv;
                }
                $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                Composer $composer$iv2 = $composer;
                int i32 = $changed$iv$iv$iv;
                int i42 = ($changed$iv$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 276693570, "C77@3893L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i52 = ((0 >> 6) & 112) | 6;
                Composer $composer22 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer22, -1993300203, "C281@12901L8,282@12926L18:BackdropScaffold.kt#jmzs0o");
                function2.invoke($composer22, Integer.valueOf(i2 & 14));
                function22.invoke($composer22, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer22);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1017265219);
                ComposerKt.sourceInformation(composer, "285@12988L72");
                Function2<Composer, Integer, Unit> function23 = this.$appBar;
                Function2<Composer, Integer, Unit> function24 = this.$backLayerContent;
                int i6 = this.$$dirty;
                BackdropScaffoldKt.BackLayerTransition((BackdropValue) this.$scaffoldState.getTargetValue(), function23, function24, composer, ((i6 << 3) & 896) | ((i6 << 3) & 112));
                $composer.endReplaceableGroup();
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
