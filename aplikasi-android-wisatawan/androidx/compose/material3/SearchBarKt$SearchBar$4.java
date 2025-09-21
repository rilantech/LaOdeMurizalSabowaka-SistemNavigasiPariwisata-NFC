package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.kt */
final class SearchBarKt$SearchBar$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ boolean $active;
    final /* synthetic */ State<Float> $animationProgress;
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
    final /* synthetic */ State<Dp> $topPadding;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBar$4(String str, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z, Function1<? super Boolean, Unit> function13, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, SearchBarColors searchBarColors, MutableInteractionSource mutableInteractionSource, int i, int i2, State<Float> state, State<Dp> state2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
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
        this.$animationProgress = state;
        this.$topPadding = state2;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C251@12445L1142:SearchBar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-867266817, i, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.kt:250)");
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
            State<Float> state = this.$animationProgress;
            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            State<Dp> state2 = this.$topPadding;
            Function2<Composer, Integer, Unit> function24 = function23;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            String str2 = "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo";
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Function2<Composer, Integer, Unit> function25 = function22;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Arrangement.Vertical vertical = verticalArrangement$iv;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
            String str3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            Function2<Composer, Integer, Unit> function26 = function2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            boolean z3 = z2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Function1<Boolean, Unit> function14 = function13;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            String str4 = "C:CompositionLocal.kt#9igjgp";
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            boolean z4 = z;
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
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            String str5 = "C79@4027L9:Column.kt#2w3rfo";
            Composer $composer2 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, -685095508, "C252@12498L93,255@12604L590,270@13227L115:SearchBar.kt#uh7d8r");
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Composer $composer$iv2 = $composer$iv;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = it$iv$iv;
                value$iv$iv = new AnimatedPaddingValues(state, state2);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object it$iv$iv2 = it$iv$iv;
                Object it$iv$iv3 = $this$cache$iv$iv;
                value$iv$iv = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            AnimatedPaddingValues animatedInputFieldPadding = (AnimatedPaddingValues) value$iv$iv;
            Modifier padding = PaddingKt.padding(Modifier.Companion, animatedInputFieldPadding);
            int i6 = (i3 >> 9) & 112;
            AnimatedPaddingValues animatedPaddingValues = animatedInputFieldPadding;
            Function1<Boolean, Unit> function15 = function14;
            int i7 = i3;
            Modifier modifier = padding;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            String str6 = str4;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
            Function2<Composer, Integer, Unit> function27 = function26;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Density density = density$iv$iv;
            Function3<ColumnScope, Composer, Integer, Unit> function34 = function32;
            Alignment.Horizontal horizontal = horizontalAlignment$iv2;
            SearchBarKt.SearchBarInputField(str, function1, function12, z4, function15, modifier, z3, function27, function25, function24, searchBarColors.getInputFieldColors(), mutableInteractionSource2, $composer2, (i2 & 1879048192) | (i2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2), i6, 0);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv4 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv4 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$4$1$showResults$2$1(state));
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv4;
            }
            $composer2.endReplaceableGroup();
            State showResults$delegate = (State) value$iv$iv2;
            $composer2.startReplaceableGroup(551421060);
            ComposerKt.sourceInformation($composer2, "274@13420L35,274@13390L173");
            if (invoke$lambda$5$lambda$2(showResults$delegate)) {
                Modifier modifier2 = Modifier.Companion;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed((Object) state);
                Composer $this$cache$iv$iv3 = $composer2;
                Object it$iv$iv5 = $this$cache$iv$iv3.rememberedValue();
                if (invalid$iv$iv || it$iv$iv5 == Composer.Companion.getEmpty()) {
                    value$iv$iv3 = (Function1) new SearchBarKt$SearchBar$4$1$1$1(state);
                    $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv5;
                }
                $composer2.endReplaceableGroup();
                Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier2, (Function1) value$iv$iv3);
                $composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation($composer2, str2);
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, Alignment.Companion.getStart(), $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, str3);
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str6);
                Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv2 = (Density) consume4;
                State state3 = showResults$delegate;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str6);
                Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str6);
                Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                Modifier modifier3 = modifier$iv;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(constructor2);
                } else {
                    $composer2.useNode();
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2865constructorimpl($composer2);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2872setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer2.startReplaceableGroup(2058660585);
                Composer $composer$iv3 = $composer2;
                LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 276693704, str5);
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                Arrangement.Vertical vertical2 = verticalArrangement$iv2;
                Composer $composer3 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer3, 1234674882, "C275@13479L36,276@13536L9:SearchBar.kt#uh7d8r");
                DividerKt.m1741Divider9IZ8Weo((Modifier) null, 0.0f, searchBarColors.m1942getDividerColor0d7_KjU(), $composer3, 0, 3);
                function34.invoke(ColumnScopeInstance.INSTANCE, $composer3, Integer.valueOf(((((0 >> 6) & 112) | 6) & 14) | ((i7 >> 12) & 112)));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
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

    private static final boolean invoke$lambda$5$lambda$2(State<Boolean> $showResults$delegate) {
        return ((Boolean) $showResults$delegate.getValue()).booleanValue();
    }
}
