package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ListItem$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ Alignment.Vertical $boxAlignment;
    final /* synthetic */ Arrangement.Vertical $columnArrangement;
    final /* synthetic */ PaddingValues $contentPaddingValues;
    final /* synthetic */ Function2<Composer, Integer, Unit> $decoratedHeadlineContent;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $decoratedLeadingContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $decoratedOverlineContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $decoratedSupportingContent;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $decoratedTrailingContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, PaddingValues paddingValues, Alignment.Vertical vertical, Arrangement.Vertical vertical2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(3);
        this.$decoratedLeadingContent = function3;
        this.$contentPaddingValues = paddingValues;
        this.$boxAlignment = vertical;
        this.$columnArrangement = vertical2;
        this.$decoratedTrailingContent = function32;
        this.$decoratedOverlineContent = function2;
        this.$decoratedHeadlineContent = function22;
        this.$decoratedSupportingContent = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope $this$ListItem, Composer $composer, int $changed) {
        RowScope rowScope = $this$ListItem;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$ListItem");
        ComposerKt.sourceInformation(composer, "C165@6917L487,181@7465L26:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1813277157, $dirty2, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:161)");
            }
            composer.startReplaceableGroup(1316674963);
            ComposerKt.sourceInformation(composer, "163@6873L25");
            Function3<RowScope, Composer, Integer, Unit> function3 = this.$decoratedLeadingContent;
            if (function3 != null) {
                function3.invoke(rowScope, composer, Integer.valueOf($dirty2 & 14));
            }
            $composer.endReplaceableGroup();
            Modifier modifier$iv = rowScope.align(PaddingKt.padding(RowScope.weight$default($this$ListItem, Modifier.Companion, 1.0f, false, 2, (Object) null), this.$contentPaddingValues), this.$boxAlignment);
            Arrangement.Vertical verticalArrangement$iv = this.$columnArrangement;
            Function2<Composer, Integer, Unit> function2 = this.$decoratedOverlineContent;
            Function2<Composer, Integer, Unit> function22 = this.$decoratedHeadlineContent;
            Function2<Composer, Integer, Unit> function23 = this.$decoratedSupportingContent;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Arrangement.Vertical vertical = verticalArrangement$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            int i = $changed$iv$iv;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            int i3 = $changed$iv$iv$iv;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            Composer $composer2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 984343928, "C175@7255L26:ListItem.kt#uh7d8r");
            $composer2.startReplaceableGroup(984343928);
            ComposerKt.sourceInformation($composer2, "173@7202L26");
            if (function2 != null) {
                function2.invoke($composer2, 0);
            }
            $composer2.endReplaceableGroup();
            function22.invoke($composer2, 6);
            $composer2.startReplaceableGroup(1316675435);
            ComposerKt.sourceInformation($composer2, "177@7352L28");
            if (function23 != null) {
                function23.invoke($composer2, 0);
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            Function3<RowScope, Composer, Integer, Unit> function32 = this.$decoratedTrailingContent;
            if (function32 != null) {
                function32.invoke(rowScope, composer, Integer.valueOf($dirty2 & 14));
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
