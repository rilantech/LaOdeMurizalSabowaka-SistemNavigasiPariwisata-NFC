package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$DockedSearchBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ boolean $active;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;
    final /* synthetic */ Function1<String, Unit> $onQueryChange;
    final /* synthetic */ Function1<String, Unit> $onSearch;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$DockedSearchBar$2(String str, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z, Function1<? super Boolean, Unit> function13, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, SearchBarColors searchBarColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$query = str;
        this.$onQueryChange = function1;
        this.$onSearch = function12;
        this.$active = z;
        this.$onActiveChange = function13;
        this.$enabled = z2;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$colors = searchBarColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C370@17943L1277:SearchBar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1764436203, i, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:369)");
            }
            String str = this.$query;
            Function1<String, Unit> function1 = this.$onQueryChange;
            Function1<String, Unit> function12 = this.$onSearch;
            boolean z = this.$active;
            Function1<Boolean, Unit> function13 = this.$onActiveChange;
            boolean z2 = this.$enabled;
            Function2<Composer, Integer, Unit> function2 = this.$placeholder;
            Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            SearchBarColors searchBarColors = this.$colors;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            int i2 = this.$$dirty;
            int i3 = this.$$dirty1;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Function2<Composer, Integer, Unit> function24 = function23;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Arrangement.Vertical vertical = verticalArrangement$iv;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            Function2<Composer, Integer, Unit> function25 = function22;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            Function2<Composer, Integer, Unit> function26 = function2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            boolean z3 = z2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function1<Boolean, Unit> function14 = function13;
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
            materializerOf.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            int i5 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            Composer $composer2 = $composer$iv;
            Density density = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 1253284504, "C371@17964L502,385@18480L730:SearchBar.kt#uh7d8r");
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Composer $composer3 = $composer2;
            Composer $composer$iv2 = $composer$iv;
            boolean z4 = z3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
            Function2<Composer, Integer, Unit> function27 = function26;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            SearchBarKt.SearchBarInputField(str, function1, function12, z, function14, (Modifier) null, z4, function27, function25, function24, searchBarColors.getInputFieldColors(), mutableInteractionSource2, $composer3, (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2), (i3 >> 6) & 112, 32);
            EnterTransition access$getDockedEnterTransition$p = SearchBarKt.DockedEnterTransition;
            ExitTransition access$getDockedExitTransition$p = SearchBarKt.DockedExitTransition;
            SearchBarKt$DockedSearchBar$2$1$1 searchBarKt$DockedSearchBar$2$1$1 = new SearchBarKt$DockedSearchBar$2$1$1(searchBarColors, function32, i3);
            Composer $composer4 = $composer3;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            boolean z5 = z;
            Composer composer2 = $composer4;
            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z5, (Modifier) null, access$getDockedEnterTransition$p, access$getDockedExitTransition$p, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer4, 393964167, true, searchBarKt$DockedSearchBar$2$1$1), composer2, ((((0 >> 6) & 112) | 6) & 14) | 1600512 | ((i2 >> 6) & 112), 18);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
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
