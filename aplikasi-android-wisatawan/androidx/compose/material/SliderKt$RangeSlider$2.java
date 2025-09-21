package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "invoke", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i2, Function0<Unit> function0, List<Float> list, SliderColors sliderColors) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$value = closedFloatingPointRange2;
        this.$$dirty = i;
        this.$onValueChangeState = state;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$enabled = z;
        this.$steps = i2;
        this.$onValueChangeFinished = function0;
        this.$tickFractions = list;
        this.$colors = sliderColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r47, androidx.compose.runtime.Composer r48, int r49) {
        /*
            r46 = this;
            r0 = r46
            r1 = r47
            r15 = r48
            r14 = r49
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C315@14165L7,*320@14326L7,331@14754L60,332@14842L67,334@14919L164,341@15092L169,349@15283L24,350@15339L964,374@16373L857,374@16326L904,416@18249L63,424@18539L65,430@18732L340:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r49
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0022
            boolean r3 = r15.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = 2
        L_0x0021:
            r2 = r2 | r3
        L_0x0022:
            r16 = r2
            r2 = r16 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0036
            boolean r2 = r48.getSkipping()
            if (r2 != 0) goto L_0x0031
            goto L_0x0036
        L_0x0031:
            r48.skipToGroupEnd()
            goto L_0x04cd
        L_0x0036:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0045
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:314)"
            r4 = 652589923(0x26e5bb63, float:1.5940858E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r2, r3)
        L_0x0045:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r5, r6)
            java.lang.Object r7 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r48)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r7 != r2) goto L_0x0064
            r2 = 1
            r23 = r2
            goto L_0x0066
        L_0x0064:
            r23 = 0
        L_0x0066:
            long r2 = r47.m459getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r2)
            float r13 = (float) r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r12 = r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r11 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r5, r6)
            java.lang.Object r5 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r48)
            r2 = r5
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 0
            float r4 = androidx.compose.material.SliderKt.getThumbRadius()
            float r4 = r2.m5825toPx0680j_4(r4)
            float r4 = r13 - r4
            r12.element = r4
            float r4 = androidx.compose.material.SliderKt.getThumbRadius()
            float r4 = r2.m5825toPx0680j_4(r4)
            r11.element = r4
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r4 = 0
            r5 = 0
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r10)
            java.lang.String r8 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            r6 = 0
            r7 = r48
            r17 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r20.getEmpty()
            if (r9 != r10) goto L_0x00e6
            r10 = 0
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r2 = invoke$scaleToOffset(r3, r11, r12, r2)
            androidx.compose.runtime.MutableFloatState r2 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r2)
            r7.updateRememberedValue(r2)
            goto L_0x00e7
        L_0x00e6:
            r2 = r9
        L_0x00e7:
            r48.endReplaceableGroup()
            r38 = r2
            androidx.compose.runtime.MutableFloatState r38 = (androidx.compose.runtime.MutableFloatState) r38
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r4 = 0
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            r6 = 0
            r7 = r48
            r9 = 0
            java.lang.Object r10 = r7.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r19.getEmpty()
            if (r10 != r1) goto L_0x012a
            r1 = 0
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r2 = invoke$scaleToOffset(r3, r11, r12, r2)
            androidx.compose.runtime.MutableFloatState r1 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r2)
            r7.updateRememberedValue(r1)
            goto L_0x012b
        L_0x012a:
            r1 = r10
        L_0x012b:
            r48.endReplaceableGroup()
            androidx.compose.runtime.MutableFloatState r1 = (androidx.compose.runtime.MutableFloatState) r1
            androidx.compose.material.SliderKt$RangeSlider$2$2 r2 = new androidx.compose.material.SliderKt$RangeSlider$2$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r2.<init>(r3, r11, r12)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            float r4 = r11.element
            float r5 = r12.element
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            r5 = r38
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$value
            java.lang.Comparable r6 = r6.getStart()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            int r7 = r0.$$dirty
            int r7 = r7 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r9 = r7 | 3072(0xc00, float:4.305E-42)
            r7 = r48
            r10 = r8
            r8 = r9
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.material.SliderKt$RangeSlider$2$3 r2 = new androidx.compose.material.SliderKt$RangeSlider$2$3
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r2.<init>(r3, r11, r12)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            float r4 = r11.element
            float r5 = r12.element
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            r5 = r1
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$value
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            int r7 = r0.$$dirty
            int r7 = r7 >> 9
            r7 = r7 & 112(0x70, float:1.57E-43)
            r8 = r7 | 3072(0xc00, float:4.305E-42)
            r7 = r48
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r2, r3, r4, r5, r6, r7, r8)
            r2 = 0
            r3 = r2
            r4 = 0
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r15.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r5)
            r5 = r48
            r6 = r2
            r2 = 0
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r10)
            r7 = 0
            r8 = r48
            r9 = 0
            java.lang.Object r10 = r8.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r10 != r2) goto L_0x01e0
            r2 = 0
            r19 = 0
            kotlin.coroutines.EmptyCoroutineContext r19 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r21 = r2
            r2 = r19
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r5)
            r19 = r3
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r2 = r3
            r8.updateRememberedValue(r2)
            goto L_0x01e3
        L_0x01e0:
            r19 = r3
            r2 = r10
        L_0x01e3:
            r48.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r35 = r2.getCoroutineScope()
            r48.endReplaceableGroup()
            androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1 r2 = new androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
            java.util.List<java.lang.Float> r3 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r0.$onValueChangeFinished
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.$onValueChangeState
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r28 = r2
            r29 = r38
            r30 = r1
            r31 = r3
            r32 = r11
            r33 = r12
            r34 = r4
            r36 = r5
            r37 = r6
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37)
            r3 = 0
            androidx.compose.runtime.State r32 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r15, r3)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            float r3 = r11.element
            java.lang.Float r27 = java.lang.Float.valueOf(r3)
            float r3 = r12.element
            java.lang.Float r28 = java.lang.Float.valueOf(r3)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$value
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r4 = r0.$onValueChangeState
            r24 = r38
            r25 = r1
            r26 = r2
            r29 = r3
            r30 = r4
            java.lang.Object[] r2 = new java.lang.Object[]{r24, r25, r26, r27, r28, r29, r30}
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            r6 = 8
            r7 = 0
            r8 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r15.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            r8 = 0
            int r9 = r2.length
            r10 = r8
            r8 = 0
        L_0x024a:
            if (r8 >= r9) goto L_0x025b
            r17 = r6
            r6 = r2[r8]
            boolean r19 = r15.changed((java.lang.Object) r6)
            r10 = r10 | r19
            int r8 = r8 + 1
            r6 = r17
            goto L_0x024a
        L_0x025b:
            r17 = r6
            r6 = r48
            r8 = 0
            java.lang.Object r9 = r6.rememberedValue()
            r19 = 0
            if (r10 != 0) goto L_0x0275
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r9 != r2) goto L_0x0273
            goto L_0x0277
        L_0x0273:
            r2 = r9
            goto L_0x0295
        L_0x0275:
            r21 = r2
        L_0x0277:
            r2 = 0
            androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1 r20 = new androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
            r24 = r20
            r25 = r38
            r26 = r1
            r27 = r3
            r28 = r11
            r29 = r12
            r30 = r4
            r31 = r5
            r24.<init>(r25, r26, r27, r28, r29, r30, r31)
            kotlin.jvm.functions.Function2 r20 = (kotlin.jvm.functions.Function2) r20
            r2 = r20
            r6.updateRememberedValue(r2)
        L_0x0295:
            r48.endReplaceableGroup()
            r3 = 0
            androidx.compose.runtime.State r28 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r15, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r17 = r2
            androidx.compose.ui.Modifier r17 = (androidx.compose.ui.Modifier) r17
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$endInteractionSource
            r20 = r38
            androidx.compose.runtime.State r20 = (androidx.compose.runtime.State) r20
            r21 = r1
            androidx.compose.runtime.State r21 = (androidx.compose.runtime.State) r21
            boolean r4 = r0.$enabled
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            r18 = r2
            r19 = r3
            r22 = r4
            r24 = r13
            r25 = r5
            r26 = r32
            r27 = r28
            androidx.compose.ui.Modifier r17 = androidx.compose.material.SliderKt.rangeSliderPressDragModifier(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$value
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r10 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$value
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$value
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r9 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r18 = androidx.compose.material.SliderKt.calcFraction(r2, r3, r10)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r19 = androidx.compose.material.SliderKt.calcFraction(r2, r3, r9)
            int r2 = r0.$steps
            float r2 = (float) r2
            float r2 = r2 * r19
            double r2 = (double) r2
            double r2 = java.lang.Math.floor(r2)
            float r2 = (float) r2
            int r8 = (int) r2
            int r2 = r0.$steps
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 - r18
            float r2 = r2 * r3
            double r2 = (double) r2
            double r2 = java.lang.Math.floor(r2)
            float r2 = (float) r2
            int r7 = (int) r2
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r39 = r2
            androidx.compose.ui.Modifier r39 = (androidx.compose.ui.Modifier) r39
            boolean r2 = r0.$enabled
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r3 = r0.$onValueChangeState
            java.lang.Float r4 = java.lang.Float.valueOf(r9)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.$onValueChangeState
            r6 = 0
            r20 = 0
            r21 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r24 = r15.changed((java.lang.Object) r3)
            boolean r25 = r15.changed((java.lang.Object) r4)
            r24 = r24 | r25
            r25 = r48
            r26 = 0
            r27 = r3
            java.lang.Object r3 = r25.rememberedValue()
            r29 = 0
            if (r24 != 0) goto L_0x03b8
            androidx.compose.runtime.Composer$Companion r30 = androidx.compose.runtime.Composer.Companion
            r31 = r4
            java.lang.Object r4 = r30.getEmpty()
            if (r3 != r4) goto L_0x03b3
            goto L_0x03ba
        L_0x03b3:
            r30 = r3
            r4 = r25
            goto L_0x03cb
        L_0x03b8:
            r31 = r4
        L_0x03ba:
            r4 = 0
            r30 = r3
            androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1 r3 = new androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
            r3.<init>(r5, r9)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = r25
            r4.updateRememberedValue(r3)
        L_0x03cb:
            r48.endReplaceableGroup()
            r42 = r3
            kotlin.jvm.functions.Function1 r42 = (kotlin.jvm.functions.Function1) r42
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.$onValueChangeFinished
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r44 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r9)
            r40 = r10
            r41 = r2
            r43 = r3
            r45 = r8
            androidx.compose.ui.Modifier r20 = androidx.compose.material.SliderKt.sliderSemantics(r39, r40, r41, r42, r43, r44, r45)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r39 = r2
            androidx.compose.ui.Modifier r39 = (androidx.compose.ui.Modifier) r39
            boolean r2 = r0.$enabled
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r3 = r0.$onValueChangeState
            java.lang.Float r4 = java.lang.Float.valueOf(r10)
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r5 = r0.$onValueChangeState
            r6 = 0
            r24 = 0
            r25 = r6
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            boolean r1 = r15.changed((java.lang.Object) r3)
            boolean r6 = r15.changed((java.lang.Object) r4)
            r1 = r1 | r6
            r6 = r48
            r22 = 0
            r26 = r3
            java.lang.Object r3 = r6.rememberedValue()
            r27 = 0
            if (r1 != 0) goto L_0x0437
            androidx.compose.runtime.Composer$Companion r29 = androidx.compose.runtime.Composer.Companion
            r30 = r1
            java.lang.Object r1 = r29.getEmpty()
            if (r3 != r1) goto L_0x0435
            goto L_0x0439
        L_0x0435:
            r1 = r3
            goto L_0x0448
        L_0x0437:
            r30 = r1
        L_0x0439:
            r1 = 0
            r29 = r1
            androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
            r1.<init>(r5, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6.updateRememberedValue(r1)
        L_0x0448:
            r48.endReplaceableGroup()
            r42 = r1
            kotlin.jvm.functions.Function1 r42 = (kotlin.jvm.functions.Function1) r42
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onValueChangeFinished
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r44 = kotlin.ranges.RangesKt.rangeTo((float) r10, (float) r3)
            r40 = r9
            r41 = r2
            r43 = r1
            r45 = r7
            androidx.compose.ui.Modifier r1 = androidx.compose.material.SliderKt.sliderSemantics(r39, r40, r41, r42, r43, r44, r45)
            boolean r2 = r0.$enabled
            java.util.List<java.lang.Float> r5 = r0.$tickFractions
            androidx.compose.material.SliderColors r6 = r0.$colors
            float r3 = r12.element
            float r4 = r11.element
            float r22 = r3 - r4
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$endInteractionSource
            r24 = r3
            int r3 = r0.$$dirty
            int r25 = r3 >> 9
            r25 = r25 & 14
            r26 = 14159872(0xd81000, float:1.9842207E-38)
            r25 = r25 | r26
            r26 = 57344(0xe000, float:8.0356E-41)
            int r3 = r3 >> 9
            r3 = r3 & r26
            r25 = r25 | r3
            r26 = 0
            r3 = r18
            r27 = r4
            r4 = r19
            r29 = r7
            r7 = r22
            r22 = r8
            r8 = r27
            r27 = r9
            r9 = r24
            r24 = r10
            r10 = r17
            r30 = r11
            r11 = r20
            r31 = r12
            r12 = r1
            r33 = r13
            r13 = r48
            r14 = r25
            r15 = r26
            androidx.compose.material.SliderKt.RangeSliderImpl(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x04cd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$RangeSlider$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> $valueRange2, ClosedFloatingPointRange<Float> offset) {
        return SliderKt.scale(minPx.element, maxPx.element, offset, $valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> $valueRange2, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        return SliderKt.scale($valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
    }
}
