package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000e\u001aR\u0010\u000f\u001a\u00020\t*\u00020\t2A\u0010\u0010\u001a=\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\u0002\b\u0007H\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"LookaheadLayout", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "LookaheadScope", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "intermediateLayout", "measure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
public final class LookaheadScopeKt {
    @Deprecated(message = "LookaheadLayout has been replaced with LookaheadScope that does not require a Modifier or a MeasurePolicy.", replaceWith = @ReplaceWith(expression = "LookaheadScope { Layout(content = { content() }, \n modifier = modifier, measurePolicy = measurePolicy) }", imports = {}))
    public static final void LookaheadLayout(Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> content, Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(1551346597);
        ComposerKt.sourceInformation($composer2, "C(LookaheadLayout)P(!1,2)51@1893L160:LookaheadScope.kt#80mrfh");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed((Object) measurePolicy) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1551346597, $dirty, -1, "androidx.compose.ui.layout.LookaheadLayout (LookaheadScope.kt:46)");
            }
            LookaheadScope(ComposableLambdaKt.composableLambda($composer2, 1705879204, true, new LookaheadScopeKt$LookaheadLayout$1(modifier, measurePolicy, $dirty, content)), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LookaheadScopeKt$LookaheadLayout$2(content, modifier, measurePolicy, $changed, i));
        }
    }

    public static final void LookaheadScope(Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1078066484);
        ComposerKt.sourceInformation($composer2, "C(LookaheadScope)111@4255L33,112@4293L484:LookaheadScope.kt#80mrfh");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1078066484, $dirty, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:110)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new LookaheadScopeImpl((Function0) null, 1, (DefaultConstructorMarker) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            LookaheadScopeImpl scope = (LookaheadScopeImpl) value$iv$iv;
            Function0 factory$iv = LookaheadScopeKt$LookaheadScope$1.INSTANCE;
            $composer2.startReplaceableGroup(-692256719);
            ComposerKt.sourceInformation($composer2, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$LookaheadScope_u24lambda_u241 = Updater.m2865constructorimpl($composer2);
            Updater.m2869initimpl($this$LookaheadScope_u24lambda_u241, LookaheadScopeKt$LookaheadScope$2$1.INSTANCE);
            Updater.m2872setimpl($this$LookaheadScope_u24lambda_u241, scope, LookaheadScopeKt$LookaheadScope$2$2.INSTANCE);
            int i = (6 >> 6) & 14;
            Composer $composer3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1223115506, "C124@4752L9:LookaheadScope.kt#80mrfh");
            content.invoke(scope, $composer3, Integer.valueOf((($dirty << 3) & 112) | 8));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LookaheadScopeKt$LookaheadScope$4(content, $changed));
        }
    }

    public static final Modifier intermediateLayout(Modifier $this$intermediateLayout, Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measure) {
        Intrinsics.checkNotNullParameter($this$intermediateLayout, "<this>");
        Intrinsics.checkNotNullParameter(measure, "measure");
        return $this$intermediateLayout.then(new IntermediateLayoutElement(measure));
    }
}
