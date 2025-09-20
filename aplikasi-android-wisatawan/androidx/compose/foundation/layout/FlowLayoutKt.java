package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aW\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aW\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2*\u0010\u001e\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012*\u0010(\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b*\u0010+\u001a4\u0010,\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a4\u0010-\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0001\u0010.\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002#\u00102\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112#\u0010%\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001aF\u0010.\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001aS\u00109\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002#\u00102\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112\u0006\u0010:\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001a\u0001\u0010;\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002#\u00102\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112#\u0010%\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112\u0006\u0010:\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001a%\u0010<\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010=\u001a9\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u0019\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bE\u0010F\u001a\u001c\u0010G\u001a\u00020\f*\u00020H2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\fH\u0000\u001a\u0014\u0010%\u001a\u00020\f*\u00020I2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u001c\u0010J\u001a\u00020\f*\u00020H2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\fH\u0000\u001a\u0014\u00102\u001a\u00020\f*\u00020I2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a?\u0010K\u001a\u00020\f*\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010L\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010I\u0012\u0004\u0012\u00020\u00040\u000eH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bM\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006O"}, d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "flowMeasurePolicy", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "mainAxisArrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "mainAxisArrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "crossAxisArrangement", "crossAxisArrangementSpacing", "flowMeasurePolicy-bs7tm-s", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Lkotlin/jvm/functions/Function5;FI)Landroidx/compose/ui/layout/MeasurePolicy;", "getHorizontalArrangement", "getVerticalArrangement", "intrinsicCrossAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "mainAxisSizes", "crossAxisSizes", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measureHelper", "Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-w1Onq5I", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;Landroidx/compose/foundation/layout/LayoutOrientation;JI)Landroidx/compose/foundation/layout/FlowResult;", "crossAxisMin", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "mainAxisMin", "measureAndCache", "storePlaceable", "measureAndCache-6m2dt9o", "(Landroidx/compose/ui/layout/Measurable;JLandroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function1;)I", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
public final class FlowLayoutKt {
    /* access modifiers changed from: private */
    public static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart());
    /* access modifiers changed from: private */
    public static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.Companion.vertical$foundation_layout_release(Alignment.Companion.getTop());

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInEachRow, Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Horizontal horizontalArrangement2;
        Arrangement.Vertical verticalArrangement2;
        int maxItemsInEachRow2;
        Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(1098475987);
        ComposerKt.sourceInformation(composer, "CC(FlowRow)P(3,1,4,2)61@2468L113,66@2586L134:FlowLayout.kt#2w3rfo");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        if ((i & 2) != 0) {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if ((i & 4) != 0) {
            verticalArrangement2 = Arrangement.INSTANCE.getTop();
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if ((i & 8) != 0) {
            maxItemsInEachRow2 = Integer.MAX_VALUE;
        } else {
            maxItemsInEachRow2 = maxItemsInEachRow;
        }
        MeasurePolicy measurePolicy = rowMeasurementHelper(horizontalArrangement2, verticalArrangement2, maxItemsInEachRow2, composer, (($changed >> 3) & 14) | (($changed >> 3) & 112) | (($changed >> 3) & 896));
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier2);
        int $changed$iv$iv = (((($changed << 3) & 112) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer);
        Modifier modifier3 = modifier2;
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u240$iv;
        if (!$this$set_impl_u24lambda_u240$iv$iv.getInserting()) {
            Arrangement.Horizontal horizontal = horizontalArrangement2;
            Arrangement.Vertical vertical = verticalArrangement2;
            if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv;
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                int i2 = ($changed$iv$iv >> 9) & 14;
                Composer $composer2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer2, 483375157, "C67@2635L9:FlowLayout.kt#2w3rfo");
                function3.invoke(FlowRowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed >> 9) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            }
        } else {
            Arrangement.Vertical vertical2 = verticalArrangement2;
        }
        $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        int i22 = ($changed$iv$iv >> 9) & 14;
        Composer $composer22 = $composer;
        ComposerKt.sourceInformationMarkerStart($composer22, 483375157, "C67@2635L9:FlowLayout.kt#2w3rfo");
        function3.invoke(FlowRowScopeInstance.INSTANCE, $composer22, Integer.valueOf((($changed >> 9) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer22);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInEachColumn, Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Vertical verticalArrangement2;
        Arrangement.Horizontal horizontalArrangement2;
        int maxItemsInEachColumn2;
        Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(-310290901);
        ComposerKt.sourceInformation(composer, "CC(FlowColumn)P(3,4,1,2)111@4318L119,116@4442L137:FlowLayout.kt#2w3rfo");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        if ((i & 2) != 0) {
            verticalArrangement2 = Arrangement.INSTANCE.getTop();
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if ((i & 4) != 0) {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if ((i & 8) != 0) {
            maxItemsInEachColumn2 = Integer.MAX_VALUE;
        } else {
            maxItemsInEachColumn2 = maxItemsInEachColumn;
        }
        MeasurePolicy measurePolicy = columnMeasurementHelper(verticalArrangement2, horizontalArrangement2, maxItemsInEachColumn2, composer, (($changed >> 3) & 14) | (($changed >> 3) & 112) | (($changed >> 3) & 896));
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier2);
        int $changed$iv$iv = (((($changed << 3) & 112) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2865constructorimpl($composer);
        Modifier modifier3 = modifier2;
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2872setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv$iv = $this$Layout_u24lambda_u240$iv;
        if (!$this$set_impl_u24lambda_u240$iv$iv.getInserting()) {
            Arrangement.Vertical vertical = verticalArrangement2;
            Arrangement.Horizontal horizontal = horizontalArrangement2;
            if (Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash$iv))) {
                Composer composer2 = $this$set_impl_u24lambda_u240$iv$iv;
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                int i2 = ($changed$iv$iv >> 9) & 14;
                Composer $composer2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer2, -681937527, "C117@4494L9:FlowLayout.kt#2w3rfo");
                function3.invoke(FlowColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed >> 9) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            }
        } else {
            Arrangement.Horizontal horizontal2 = horizontalArrangement2;
        }
        $this$set_impl_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2856boximpl(SkippableUpdater.m2857constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        int i22 = ($changed$iv$iv >> 9) & 14;
        Composer $composer22 = $composer;
        ComposerKt.sourceInformationMarkerStart($composer22, -681937527, "C117@4494L9:FlowLayout.kt#2w3rfo");
        function3.invoke(FlowColumnScopeInstance.INSTANCE, $composer22, Integer.valueOf((($changed >> 9) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer22);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    /* access modifiers changed from: private */
    public static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getVerticalArrangement(Arrangement.Vertical verticalArrangement) {
        return new FlowLayoutKt$getVerticalArrangement$1(verticalArrangement);
    }

    /* access modifiers changed from: private */
    public static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getHorizontalArrangement(Arrangement.Horizontal horizontalArrangement) {
        return new FlowLayoutKt$getHorizontalArrangement$1(horizontalArrangement);
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        Object value$iv$iv;
        Arrangement.Horizontal horizontal = horizontalArrangement;
        Arrangement.Vertical vertical = verticalArrangement;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(horizontal, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(vertical, "verticalArrangement");
        composer.startReplaceableGroup(1479255111);
        ComposerKt.sourceInformation(composer, "C(rowMeasurementHelper)P(!1,2)168@6017L633:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:163)");
        }
        Object key3$iv = Integer.valueOf(maxItemsInMainAxis);
        int i2 = (i & 14) | (i & 112) | (i & 896);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) horizontal) | composer.changed((Object) vertical) | composer.changed(key3$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = m477flowMeasurePolicybs7tms(LayoutOrientation.Horizontal, getHorizontalArrangement(horizontalArrangement), horizontalArrangement.m430getSpacingD9Ej5fM(), SizeMode.Wrap, CROSS_AXIS_ALIGNMENT_TOP, getVerticalArrangement(verticalArrangement), verticalArrangement.m444getSpacingD9Ej5fM(), maxItemsInMainAxis);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        Object value$iv$iv;
        Arrangement.Vertical vertical = verticalArrangement;
        Arrangement.Horizontal horizontal = horizontalArrangement;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(vertical, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontal, "horizontalArrangement");
        composer.startReplaceableGroup(-2013098357);
        ComposerKt.sourceInformation(composer, "C(columnMeasurementHelper)P(2)189@6875L634:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:184)");
        }
        Object key3$iv = Integer.valueOf(maxItemsInMainAxis);
        int i2 = (i & 14) | (i & 112) | (i & 896);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) vertical) | composer.changed((Object) horizontal) | composer.changed(key3$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = m477flowMeasurePolicybs7tms(LayoutOrientation.Vertical, getVerticalArrangement(verticalArrangement), verticalArrangement.m444getSpacingD9Ej5fM(), SizeMode.Wrap, CROSS_AXIS_ALIGNMENT_START, getHorizontalArrangement(horizontalArrangement), horizontalArrangement.m430getSpacingD9Ej5fM(), maxItemsInMainAxis);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* access modifiers changed from: private */
    /* renamed from: flowMeasurePolicy-bs7tm-s  reason: not valid java name */
    public static final MeasurePolicy m477flowMeasurePolicybs7tms(LayoutOrientation orientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> mainAxisArrangement, float mainAxisArrangementSpacing, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> crossAxisArrangement, float crossAxisArrangementSpacing, int maxItemsInMainAxis) {
        return new FlowLayoutKt$flowMeasurePolicy$1(orientation, mainAxisArrangement, mainAxisArrangementSpacing, crossAxisSize, crossAxisAlignment, maxItemsInMainAxis, crossAxisArrangementSpacing, crossAxisArrangement);
    }

    /* access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int fixedSpace = 0;
        int currentFixedSpace = 0;
        int lastBreak = 0;
        List $this$fastForEachIndexed$iv = children;
        int size = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int index = index$iv;
            int size2 = mainAxisSize.invoke((IntrinsicMeasurable) $this$fastForEachIndexed$iv.get(index$iv), Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue() + mainAxisSpacing;
            if ((index + 1) - lastBreak == maxItemsInMainAxis || index + 1 == children.size()) {
                lastBreak = index;
                fixedSpace = Math.max(fixedSpace, (currentFixedSpace + size2) - mainAxisSpacing);
                currentFixedSpace = 0;
            } else {
                currentFixedSpace += size2;
            }
        }
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3 = mainAxisSize;
        int i = maxItemsInMainAxis;
        return fixedSpace;
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> crossAxisSize, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis) {
        int i = crossAxisAvailable;
        int size = children.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = 0;
        }
        int[] mainAxisSizes = iArr;
        int size2 = children.size();
        int[] iArr2 = new int[size2];
        for (int i3 = 0; i3 < size2; i3++) {
            iArr2[i3] = 0;
        }
        int[] crossAxisSizes = iArr2;
        int size3 = children.size();
        for (int index = 0; index < size3; index++) {
            IntrinsicMeasurable child = (IntrinsicMeasurable) children.get(index);
            int mainAxisItemSize = mainAxisSize.invoke(child, Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue();
            mainAxisSizes[index] = mainAxisItemSize;
            crossAxisSizes[index] = crossAxisSize.invoke(child, Integer.valueOf(index), Integer.valueOf(mainAxisItemSize)).intValue();
        }
        List<? extends IntrinsicMeasurable> list = children;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3 = mainAxisSize;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32 = crossAxisSize;
        int maxMainAxisSize = ArraysKt.sum(mainAxisSizes);
        int mainAxisUsed = maxMainAxisSize;
        if (!(crossAxisSizes.length == 0)) {
            int crossAxisUsed = crossAxisSizes[0];
            IntIterator it = new IntRange(1, ArraysKt.getLastIndex(crossAxisSizes)).iterator();
            while (it.hasNext()) {
                int it2 = crossAxisSizes[it.nextInt()];
                if (crossAxisUsed < it2) {
                    crossAxisUsed = it2;
                }
            }
            if (!(mainAxisSizes.length == 0)) {
                int minimumItemSize = mainAxisSizes[0];
                IntIterator it3 = new IntRange(1, ArraysKt.getLastIndex(mainAxisSizes)).iterator();
                while (it3.hasNext()) {
                    int it4 = mainAxisSizes[it3.nextInt()];
                    if (minimumItemSize < it4) {
                        minimumItemSize = it4;
                    }
                }
                int crossAxisUsed2 = crossAxisUsed;
                int low = minimumItemSize;
                int high = maxMainAxisSize;
                while (low < high && crossAxisUsed2 != i) {
                    int mid = (low + high) / 2;
                    int mainAxisUsed2 = mid;
                    int high2 = high;
                    int low2 = low;
                    crossAxisUsed2 = intrinsicCrossAxisSize(children, mainAxisSizes, crossAxisSizes, mainAxisUsed2, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis);
                    if (crossAxisUsed2 == i) {
                        return mainAxisUsed2;
                    }
                    if (crossAxisUsed2 > i) {
                        low = mid + 1;
                        mainAxisUsed = mainAxisUsed2;
                        high = high2;
                    } else {
                        high = mid - 1;
                        mainAxisUsed = mainAxisUsed2;
                        low = low2;
                    }
                }
                return mainAxisUsed;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, int[] mainAxisSizes, int[] crossAxisSizes, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis) {
        return intrinsicCrossAxisSize(children, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$1(mainAxisSizes), (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$2(crossAxisSizes), mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis);
    }

    /* access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> crossAxisSize, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis) {
        int i;
        List<? extends IntrinsicMeasurable> list = children;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3 = mainAxisSize;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32 = crossAxisSize;
        if (children.isEmpty()) {
            return 0;
        }
        Object nextChild = CollectionsKt.getOrNull(list, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) nextChild;
        int nextCrossAxisSize = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(mainAxisAvailable)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) nextChild;
        int nextMainAxisSize = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, 0, Integer.valueOf(nextCrossAxisSize)).intValue() : 0;
        int remaining = mainAxisAvailable;
        int lastBreak = 0;
        int totalCrossAxisSize = 0;
        int lastBreak2 = 0;
        List $this$fastForEachIndexed$iv = children;
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv.size();
        while (index$iv < size) {
            IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) $this$fastForEachIndexed$iv.get(index$iv);
            int index = index$iv;
            Intrinsics.checkNotNull(nextChild);
            remaining -= nextMainAxisSize;
            int childCrossAxisSize = nextCrossAxisSize;
            lastBreak = Math.max(lastBreak, childCrossAxisSize);
            Object obj = nextChild;
            nextChild = CollectionsKt.getOrNull(list, index + 1);
            IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) nextChild;
            if (intrinsicMeasurable4 != null) {
                int i2 = childCrossAxisSize;
                int i3 = nextMainAxisSize;
                i = function32.invoke(intrinsicMeasurable4, Integer.valueOf(index + 1), Integer.valueOf(mainAxisAvailable)).intValue();
            } else {
                int i4 = nextMainAxisSize;
                i = 0;
            }
            nextCrossAxisSize = i;
            IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) nextChild;
            int nextMainAxisSize2 = intrinsicMeasurable5 != null ? function3.invoke(intrinsicMeasurable5, Integer.valueOf(index + 1), Integer.valueOf(nextCrossAxisSize)).intValue() + mainAxisSpacing : 0;
            if (remaining < 0 || index + 1 == children.size()) {
                int i5 = maxItemsInMainAxis;
            } else if ((index + 1) - lastBreak2 != maxItemsInMainAxis && remaining - nextMainAxisSize2 >= 0) {
                index$iv++;
                nextMainAxisSize = nextMainAxisSize2;
                list = children;
            }
            totalCrossAxisSize += lastBreak + crossAxisSpacing;
            remaining = mainAxisAvailable;
            nextMainAxisSize2 -= mainAxisSpacing;
            lastBreak2 = index + 1;
            lastBreak = 0;
            index$iv++;
            nextMainAxisSize = nextMainAxisSize2;
            list = children;
        }
        return totalCrossAxisSize - crossAxisSpacing;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: breakDownItems-w1Onq5I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.layout.FlowResult m476breakDownItemsw1Onq5I(androidx.compose.ui.layout.MeasureScope r30, androidx.compose.foundation.layout.RowColumnMeasurementHelper r31, androidx.compose.foundation.layout.LayoutOrientation r32, long r33, int r35) {
        /*
            r6 = r30
            r7 = r32
            java.lang.String r0 = "$this$breakDownItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "measureHelper"
            r8 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 16
            r2 = 0
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.foundation.layout.RowColumnMeasureHelperResult[] r4 = new androidx.compose.foundation.layout.RowColumnMeasureHelperResult[r1]
            r5 = 0
            r3.<init>(r4, r5)
            r9 = r3
            r0 = 0
            int r0 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r33)
            r10 = r0
            r0 = 0
            int r0 = androidx.compose.ui.unit.Constraints.m5790getMinWidthimpl(r33)
            r11 = r0
            r0 = 0
            int r0 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r33)
            r12 = r0
            java.util.List r13 = r31.getMeasurables()
            androidx.compose.ui.layout.Placeable[] r14 = r31.getPlaceables()
            float r0 = r31.m583getArrangementSpacingD9Ej5fM()
            float r0 = r6.m5825toPx0680j_4(r0)
            double r0 = (double) r0
            double r0 = java.lang.Math.ceil(r0)
            float r0 = (float) r0
            int r15 = (int) r0
            long r0 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m505constructorimpl(r11, r10, r5, r12)
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r13, r5)
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
            if (r2 == 0) goto L_0x0070
            androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1 r4 = new androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1
            r4.<init>(r14)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            int r2 = m478measureAndCache6m2dt9o(r2, r0, r7, r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0071
        L_0x0070:
            r2 = 0
        L_0x0071:
            r4 = 0
            int r3 = r13.size()
            java.lang.Integer[] r3 = new java.lang.Integer[r3]
            r17 = 0
            r18 = r10
            r19 = r11
            r20 = 0
            r21 = 0
            int r5 = r13.size()
            r24 = r2
            r25 = r17
            r26 = r18
            r2 = r19
            r27 = r20
            r6 = r21
        L_0x0092:
            if (r6 >= r5) goto L_0x0123
            kotlin.jvm.internal.Intrinsics.checkNotNull(r24)
            int r17 = r24.intValue()
            r18 = r5
            int r5 = r27 + r17
            int r26 = r26 - r17
            int r8 = r6 + 1
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r13, r8)
            androidx.compose.ui.layout.Measurable r8 = (androidx.compose.ui.layout.Measurable) r8
            if (r8 == 0) goto L_0x00c1
            r28 = r11
            androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1 r11 = new androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1
            r11.<init>(r14, r6)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            int r8 = m478measureAndCache6m2dt9o(r8, r0, r7, r11)
            int r8 = r8 + r15
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00c4
        L_0x00c1:
            r28 = r11
            r8 = 0
        L_0x00c4:
            int r11 = r6 + 1
            r29 = r12
            int r12 = r13.size()
            if (r11 >= r12) goto L_0x00e8
            int r11 = r6 + 1
            int r11 = r11 - r4
            r12 = r35
            if (r11 >= r12) goto L_0x00ea
            if (r8 == 0) goto L_0x00dd
            int r11 = r8.intValue()
            goto L_0x00de
        L_0x00dd:
            r11 = 0
        L_0x00de:
            int r11 = r26 - r11
            if (r11 >= 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            r27 = r5
            r24 = r8
            goto L_0x0117
        L_0x00e8:
            r12 = r35
        L_0x00ea:
            int r2 = java.lang.Math.max(r2, r5)
            int r2 = java.lang.Math.min(r2, r10)
            r5 = 0
            r11 = r10
            int r4 = r6 + 1
            int r19 = r6 + 1
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r3[r25] = r19
            int r25 = r25 + 1
            if (r8 == 0) goto L_0x010d
            int r19 = r8.intValue()
            int r19 = r19 - r15
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            goto L_0x010f
        L_0x010d:
            r19 = 0
        L_0x010f:
            r8 = r19
            r27 = r5
            r24 = r8
            r26 = r11
        L_0x0117:
            int r6 = r6 + 1
            r8 = r31
            r5 = r18
            r11 = r28
            r12 = r29
            goto L_0x0092
        L_0x0123:
            r28 = r11
            r29 = r12
            r12 = r35
            r22 = 14
            r23 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r16 = r0
            r18 = r2
            long r5 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m509copyyUG9Ft0$default(r16, r18, r19, r20, r21, r22, r23)
            long r5 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m520toBoxConstraintsOenEA2s(r5, r7)
            r19 = r2
            r8 = r3
            r2 = r5
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.Object r11 = kotlin.collections.ArraysKt.getOrNull((T[]) r8, (int) r6)
            java.lang.Integer r11 = (java.lang.Integer) r11
            r16 = r6
            r17 = r11
            r6 = r19
            r11 = r4
        L_0x0155:
            if (r17 == 0) goto L_0x0195
            int r18 = r17.intValue()
            r19 = r0
            r0 = r31
            r1 = r30
            r4 = r11
            r7 = r5
            r5 = r18
            androidx.compose.foundation.layout.RowColumnMeasureHelperResult r0 = r0.m584measureWithoutPlacing_EkL_Y(r1, r2, r4, r5)
            int r1 = r0.getCrossAxisSize()
            int r5 = r7 + r1
            int r1 = r0.getMainAxisSize()
            int r6 = java.lang.Math.max(r6, r1)
            r9.add(r0)
            int r11 = r17.intValue()
            int r1 = r16 + 1
            java.lang.Object r4 = kotlin.collections.ArraysKt.getOrNull((T[]) r8, (int) r1)
            r17 = r4
            java.lang.Integer r17 = (java.lang.Integer) r17
            r7 = r32
            r16 = r1
            r0 = r19
            goto L_0x0155
        L_0x0195:
            r19 = r0
            r7 = r5
            r0 = 0
            int r0 = androidx.compose.ui.unit.Constraints.m5789getMinHeightimpl(r33)
            int r0 = java.lang.Math.max(r7, r0)
            r1 = 0
            int r1 = androidx.compose.ui.unit.Constraints.m5790getMinWidthimpl(r33)
            int r1 = java.lang.Math.max(r6, r1)
            androidx.compose.foundation.layout.FlowResult r4 = new androidx.compose.foundation.layout.FlowResult
            r4.<init>(r1, r0, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.m476breakDownItemsw1Onq5I(androidx.compose.ui.layout.MeasureScope, androidx.compose.foundation.layout.RowColumnMeasurementHelper, androidx.compose.foundation.layout.LayoutOrientation, long, int):androidx.compose.foundation.layout.FlowResult");
    }

    public static final int mainAxisMin(Measurable $this$mainAxisMin, LayoutOrientation orientation, int crossAxisSize) {
        Intrinsics.checkNotNullParameter($this$mainAxisMin, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return $this$mainAxisMin.minIntrinsicWidth(crossAxisSize);
        }
        return $this$mainAxisMin.minIntrinsicHeight(crossAxisSize);
    }

    public static final int crossAxisMin(Measurable $this$crossAxisMin, LayoutOrientation orientation, int mainAxisSize) {
        Intrinsics.checkNotNullParameter($this$crossAxisMin, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return $this$crossAxisMin.minIntrinsicHeight(mainAxisSize);
        }
        return $this$crossAxisMin.minIntrinsicWidth(mainAxisSize);
    }

    public static final int mainAxisSize(Placeable $this$mainAxisSize, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter($this$mainAxisSize, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public static final int crossAxisSize(Placeable $this$crossAxisSize, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter($this$crossAxisSize, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    /* renamed from: measureAndCache-6m2dt9o  reason: not valid java name */
    private static final int m478measureAndCache6m2dt9o(Measurable $this$measureAndCache_u2d6m2dt9o, long constraints, LayoutOrientation orientation, Function1<? super Placeable, Unit> storePlaceable) {
        if (!(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData($this$measureAndCache_u2d6m2dt9o)) == 0.0f)) {
            return mainAxisMin($this$measureAndCache_u2d6m2dt9o, orientation, Integer.MAX_VALUE);
        }
        Placeable placeable = $this$measureAndCache_u2d6m2dt9o.m4689measureBRTryo0(OrientationIndependentConstraints.m520toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m509copyyUG9Ft0$default(constraints, 0, 0, 0, 0, 14, (Object) null), orientation));
        storePlaceable.invoke(placeable);
        return mainAxisSize(placeable, orientation);
    }
}
