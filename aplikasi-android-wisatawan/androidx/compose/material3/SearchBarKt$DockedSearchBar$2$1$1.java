package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$DockedSearchBar$2$1$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$DockedSearchBar$2$1$1(SearchBarColors searchBarColors, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(3);
        this.$colors = searchBarColors;
        this.$content = function3;
        this.$$dirty1 = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((AnimatedVisibilityScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C*390@18696L7,391@18754L115,394@18902L110,398@19030L166:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(393964167, $changed, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:389)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        float screenHeight = Dp.m5844constructorimpl((float) ((Configuration) consume).screenHeightDp);
        Object key1$iv = Dp.m5842boximpl(screenHeight);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = Dp.m5842boximpl(Dp.m5844constructorimpl(screenHeight * 0.6666667f));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        float maxHeight = ((Dp) value$iv$iv).m5858unboximpl();
        Object key1$iv2 = Dp.m5842boximpl(maxHeight);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed(key1$iv2);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
            float f = screenHeight;
            value$iv$iv2 = Dp.m5842boximpl(((Dp) RangesKt.coerceAtMost(Dp.m5842boximpl(SearchBarKt.getDockedActiveTableMinHeight()), Dp.m5842boximpl(maxHeight))).m5858unboximpl());
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            float f2 = screenHeight;
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        float minHeight = ((Dp) value$iv$iv2).m5858unboximpl();
        Modifier modifier$iv = SizeKt.m599heightInVpY3zN4(Modifier.Companion, minHeight, maxHeight);
        SearchBarColors searchBarColors = this.$colors;
        Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
        int i2 = this.$$dirty1;
        composer.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        float f3 = minHeight;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density$iv$iv = (Density) consume2;
        float f4 = maxHeight;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
        Modifier modifier = modifier$iv;
        int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2865constructorimpl($composer);
        Function0<ComposeUiNode> function0 = constructor;
        Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        $composer.enableReusing();
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        Composer $composer$iv = $composer;
        Density density = density$iv$iv;
        ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
        ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
        LayoutDirection layoutDirection = layoutDirection$iv$iv;
        int i3 = ($changed$iv$iv$iv >> 9) & 14;
        Composer $composer2 = $composer$iv;
        ComposerKt.sourceInformationMarkerStart($composer2, 1001846230, "C399@19112L36,400@19169L9:SearchBar.kt#uh7d8r");
        DividerKt.m1741Divider9IZ8Weo((Modifier) null, 0.0f, searchBarColors.m1942getDividerColor0d7_KjU(), $composer2, 0, 3);
        function3.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf(((((0 >> 6) & 112) | 6) & 14) | ((i2 >> 9) & 112)));
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
