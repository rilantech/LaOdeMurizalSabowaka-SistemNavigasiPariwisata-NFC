package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ float $bottomTitleAlpha;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ boolean $hideBottomRowSemantics;
    final /* synthetic */ boolean $hideTopRowSemantics;
    final /* synthetic */ Ref.FloatRef $maxHeightPx;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ Ref.FloatRef $pinnedHeightPx;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ Ref.IntRef $titleBottomPaddingPx;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ float $topTitleAlpha;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$3(WindowInsets windowInsets, Ref.FloatRef floatRef, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, Ref.FloatRef floatRef2, TopAppBarScrollBehavior topAppBarScrollBehavior, Function2<? super Composer, ? super Integer, Unit> function24, TextStyle textStyle2, float f2, Ref.IntRef intRef, boolean z2) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$pinnedHeightPx = floatRef;
        this.$colors = topAppBarColors;
        this.$smallTitle = function2;
        this.$smallTitleTextStyle = textStyle;
        this.$topTitleAlpha = f;
        this.$hideTopRowSemantics = z;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
        this.$$dirty = i;
        this.$maxHeightPx = floatRef2;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$title = function24;
        this.$titleTextStyle = textStyle2;
        this.$bottomTitleAlpha = f2;
        this.$titleBottomPaddingPx = intRef;
        this.$hideBottomRowSemantics = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        float f;
        TopAppBarState state;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1204@54309L2201:AppBar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1985938853, i, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1203)");
            }
            WindowInsets windowInsets = this.$windowInsets;
            Ref.FloatRef floatRef = this.$pinnedHeightPx;
            TopAppBarColors topAppBarColors = this.$colors;
            Function2<Composer, Integer, Unit> function2 = this.$smallTitle;
            TextStyle textStyle = this.$smallTitleTextStyle;
            float f2 = this.$topTitleAlpha;
            boolean z = this.$hideTopRowSemantics;
            Function2<Composer, Integer, Unit> function22 = this.$navigationIcon;
            Function2<Composer, Integer, Unit> function23 = this.$actionsRow;
            int i2 = this.$$dirty;
            Ref.FloatRef floatRef2 = this.$maxHeightPx;
            TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
            Function2<Composer, Integer, Unit> function24 = this.$title;
            TextStyle textStyle2 = this.$titleTextStyle;
            float f3 = this.$bottomTitleAlpha;
            Ref.IntRef intRef = this.$titleBottomPaddingPx;
            boolean z2 = this.$hideBottomRowSemantics;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            boolean z3 = z2;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            TextStyle textStyle3 = textStyle;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Function2<Composer, Integer, Unit> function25 = function24;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Arrangement.Vertical vertical = verticalArrangement$iv;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            Ref.FloatRef floatRef3 = floatRef2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Function2<Composer, Integer, Unit> function26 = function22;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function2<Composer, Integer, Unit> function27 = function23;
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
            materializerOf.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            int i5 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            Composer $composer2 = $composer$iv;
            Composer composer2 = $composer2;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1863905175, "C1205@54330L982,1226@55325L1175:AppBar.kt#uh7d8r");
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function2<Composer, Integer, Unit> function28 = function25;
            Composer $composer3 = $composer2;
            Function0<ComposeUiNode> function02 = function0;
            TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
            Density density = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            int i7 = i3;
            Ref.FloatRef floatRef4 = floatRef3;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            Composer $composer$iv2 = $composer$iv;
            Function2<Composer, Integer, Unit> function29 = function27;
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            int i8 = i7 << 3;
            int i9 = (i8 & 458752) | 905969664 | (i8 & 3670016);
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            TextStyle textStyle4 = textStyle3;
            float f4 = f2;
            AppBarKt.m3252TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, windowInsets)), floatRef.element, topAppBarColors.m3979getNavigationIconContentColor0d7_KjU$material3_release(), topAppBarColors.m3980getTitleContentColor0d7_KjU$material3_release(), topAppBarColors.m3978getActionIconContentColor0d7_KjU$material3_release(), function2, textStyle4, f4, Arrangement.INSTANCE.getCenter(), start, 0, z, function26, function29, composer2, i9, ((i7 >> 12) & 896) | 3078);
            Modifier clipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, WindowInsetsKt.m2351onlybOOhFvg(windowInsets, WindowInsetsSides.Companion.m2375getHorizontalJoeWqyM())));
            float f5 = floatRef4.element - floatRef.element;
            if (topAppBarScrollBehavior3 == null || (state = topAppBarScrollBehavior3.getState()) == null) {
                f = 0.0f;
            } else {
                f = state.getHeightOffset();
            }
            int i10 = i7 << 12;
            AppBarKt.m3252TopAppBarLayoutkXwM9vE(clipToBounds, f5 + f, topAppBarColors.m3979getNavigationIconContentColor0d7_KjU$material3_release(), topAppBarColors.m3980getTitleContentColor0d7_KjU$material3_release(), topAppBarColors.m3978getActionIconContentColor0d7_KjU$material3_release(), function28, textStyle2, f3, Arrangement.INSTANCE.getBottom(), Arrangement.INSTANCE.getStart(), intRef.element, z3, ComposableSingletons$AppBarKt.INSTANCE.m3377getLambda11$material3_release(), ComposableSingletons$AppBarKt.INSTANCE.m3378getLambda12$material3_release(), $composer3, (i10 & 458752) | 905969664 | (i10 & 3670016), 3456);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
