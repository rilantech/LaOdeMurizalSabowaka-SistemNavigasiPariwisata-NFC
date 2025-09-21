package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
final class ButtonKt$Button$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ PaddingValues $contentPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonKt$Button$3(long j, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$contentColor = j;
        this.$contentPadding = paddingValues;
        this.$content = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C132@6583L651:Button.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(956488494, $changed, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
            }
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m4953boximpl(this.$contentColor))};
            final PaddingValues paddingValues = this.$contentPadding;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            final int i = this.$$dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, 1582292974, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C133@6702L10,133@6663L561:Button.kt#uh7d8r");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1582292974, $changed, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:132)");
                        }
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer, 6).getLabelLarge();
                        final PaddingValues paddingValues = paddingValues;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i = i;
                        TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.composableLambda($composer, -2136309793, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                Composer composer = $composer;
                                int i = $changed;
                                ComposerKt.sourceInformation(composer, "C134@6743L467:Button.kt#uh7d8r");
                                if ((i & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2136309793, i, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:133)");
                                    }
                                    Modifier modifier$iv = PaddingKt.padding(SizeKt.m2306defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m3286getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m3285getMinHeightD9Ej5fM()), paddingValues);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                                    Function3 content$iv = function3;
                                    int $changed$iv = ((i >> 18) & 7168) | 432;
                                    composer.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                                    composer.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    Density density$iv$iv = (Density) consume;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                    int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
                                    Modifier modifier = modifier$iv;
                                    if (!($composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer.startReusableNode();
                                    if ($composer.getInserting()) {
                                        composer.createNode(factory$iv$iv$iv);
                                    } else {
                                        $composer.useNode();
                                    }
                                    $composer.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m4575constructorimpl($composer);
                                    Arrangement.Horizontal horizontal = horizontalArrangement$iv;
                                    Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m4582setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                                    $composer.enableReusing();
                                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                    composer.startReplaceableGroup(2058660585);
                                    int i2 = ($changed$iv$iv$iv >> 9) & 14;
                                    Composer $composer$iv = $composer;
                                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                                    content$iv.invoke(RowScopeInstance.INSTANCE, $composer$iv, Integer.valueOf((($changed$iv >> 6) & 112) | 6));
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
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
                        }), $composer, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
