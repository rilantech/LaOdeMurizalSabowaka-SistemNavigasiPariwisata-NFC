package androidx.compose.foundation.text;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003j\u0002`\n0\u0002H\u0001¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\rH\u0000\u001a_\u0010\u0012\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003j\u0002`\n0\u00020\u0001*\u00020\r2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0000\"K\u0010\u0000\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003j\u0002`\n0\u00020\u0001X\u0004¢\u0006\u0002\n\u0000*:\b\u0000\u0010\u0016\"\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u00032\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0003*\u0018\b\u0000\u0010\u0017\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0018"}, d2 = {"EmptyInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "Landroidx/compose/foundation/text/PlaceholderRange;", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/text/InlineContentRange;", "InlineChildren", "text", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "hasInlineContent", "", "resolveInlineContent", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "InlineContentRange", "PlaceholderRange", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnnotatedStringResolveInlineContent.kt */
public final class AnnotatedStringResolveInlineContentKt {
    private static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> EmptyInlineContent = new Pair<>(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    public static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent(AnnotatedString $this$resolveInlineContent, Map<String, InlineTextContent> inlineContent) {
        AnnotatedString annotatedString = $this$resolveInlineContent;
        Map<String, InlineTextContent> map = inlineContent;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        if (map == null || inlineContent.isEmpty()) {
            return EmptyInlineContent;
        }
        List stringAnnotations = annotatedString.getStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, $this$resolveInlineContent.getText().length());
        List placeholders = new ArrayList();
        List inlineComposables = new ArrayList();
        List $this$fastForEach$iv = stringAnnotations;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            AnnotatedString.Range annotation = $this$fastForEach$iv.get(index$iv);
            InlineTextContent inlineTextContent = map.get(annotation.getItem());
            if (inlineTextContent != null) {
                placeholders.add(new AnnotatedString.Range(inlineTextContent.getPlaceholder(), annotation.getStart(), annotation.getEnd()));
                inlineComposables.add(new AnnotatedString.Range(inlineTextContent.getChildren(), annotation.getStart(), annotation.getEnd()));
            }
            index$iv++;
            AnnotatedString annotatedString2 = $this$resolveInlineContent;
            map = inlineContent;
        }
        return new Pair<>(placeholders, inlineComposables);
    }

    public static final boolean hasInlineContent(AnnotatedString $this$hasInlineContent) {
        Intrinsics.checkNotNullParameter($this$hasInlineContent, "<this>");
        return $this$hasInlineContent.hasStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, $this$hasInlineContent.getText().length());
    }

    public static final void InlineChildren(AnnotatedString text, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> inlineContents, Composer $composer, int $changed) {
        Function0<ComposeUiNode> function0;
        AnnotatedString annotatedString = text;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list = inlineContents;
        int i = $changed;
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        Composer $composer2 = $composer.startRestartGroup(-1794596951);
        ComposerKt.sourceInformation($composer2, "C(InlineChildren)P(1)*75@2735L356:AnnotatedStringResolveInlineContent.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1794596951, i, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:70)");
        }
        List $this$fastForEach$iv = inlineContents;
        int $i$f$fastForEach = false;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            AnnotatedString.Range<Function3<String, Composer, Integer, Unit>> range = $this$fastForEach$iv.get(index$iv);
            AnnotatedString.Range range2 = range;
            Function3 content = (Function3) range2.component1();
            int start = range2.component2();
            int end = range2.component3();
            MeasurePolicy measurePolicy$iv = AnnotatedStringResolveInlineContentKt$InlineChildren$1$2.INSTANCE;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int $i$f$fastForEach2 = $i$f$fastForEach;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(Modifier.Companion);
            Function0<ComposeUiNode> function02 = constructor;
            int i2 = size;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = function02;
                $composer2.createNode(function0);
            } else {
                function0 = function02;
                $composer2.useNode();
            }
            Function0<ComposeUiNode> function03 = function0;
            Composer $this$Layout_u24lambda_u240$iv = Updater.m4575constructorimpl($composer2);
            AnnotatedString.Range<Function3<String, Composer, Integer, Unit>> range3 = range;
            Updater.m4582setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4582setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
            Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u240$iv;
            if (!$this$set_impl_u24lambda_u240$iv$iv.getInserting()) {
                CompositionLocalMap compositionLocalMap = localMap$iv;
                if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                    Composer composer = $this$set_impl_u24lambda_u240$iv$iv;
                    skippableUpdate$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                    $composer2.startReplaceableGroup(2058660585);
                    Composer $composer3 = $composer2;
                    int i3 = ($changed$iv$iv >> 9) & 14;
                    int i4 = $changed$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1488000014, "C76@2767L42:AnnotatedStringResolveInlineContent.kt#423gt5");
                    content.invoke(annotatedString.subSequence(start, end).getText(), $composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    index$iv++;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    size = i2;
                }
            }
            $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m4566boximpl(SkippableUpdater.m4567constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer32 = $composer2;
            int i32 = ($changed$iv$iv >> 9) & 14;
            int i42 = $changed$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer32, -1488000014, "C76@2767L42:AnnotatedStringResolveInlineContent.kt#423gt5");
            content.invoke(annotatedString.subSequence(start, end).getText(), $composer32, 0);
            ComposerKt.sourceInformationMarkerEnd($composer32);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
            $i$f$fastForEach = $i$f$fastForEach2;
            size = i2;
        }
        int i5 = $i$f$fastForEach;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AnnotatedStringResolveInlineContentKt$InlineChildren$2(annotatedString, list, i));
        }
    }
}
