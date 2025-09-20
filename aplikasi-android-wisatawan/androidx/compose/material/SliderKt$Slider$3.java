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
final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = i;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: androidx.compose.material.SliderDraggableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v0, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r47, androidx.compose.runtime.Composer r48, int r49) {
        /*
            r46 = this;
            r0 = r46
            r1 = r47
            r11 = r48
            r12 = r49
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C176@8217L7,*181@8378L7,192@8792L24,193@8841L54,194@8922L36,196@8989L392,205@9391L83,207@9507L623,236@10624L55,243@10965L209:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r49
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0022
            boolean r3 = r11.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = 2
        L_0x0021:
            r2 = r2 | r3
        L_0x0022:
            r13 = r2
            r2 = r13 & 91
            r3 = 18
            if (r2 != r3) goto L_0x0035
            boolean r2 = r48.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r48.skipToGroupEnd()
            goto L_0x036a
        L_0x0035:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0044
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.Slider.<anonymous> (Slider.kt:175)"
            r4 = 2085116814(0x7c485b8e, float:4.1612653E36)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r12, r2, r3)
        L_0x0044:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r7 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r48)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r9 = 0
            if (r7 != r2) goto L_0x0064
            r2 = 1
            r18 = r2
            goto L_0x0066
        L_0x0064:
            r18 = r9
        L_0x0066:
            long r2 = r47.m459getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m5788getMaxWidthimpl(r2)
            float r10 = (float) r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r15 = r2
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            r14 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r5 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r48)
            r2 = r5
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 0
            float r4 = androidx.compose.material.SliderKt.getThumbRadius()
            float r4 = r2.m5825toPx0680j_4(r4)
            float r4 = r10 - r4
            r5 = 0
            float r4 = java.lang.Math.max(r4, r5)
            r15.element = r4
            float r4 = androidx.compose.material.SliderKt.getThumbRadius()
            float r4 = r2.m5825toPx0680j_4(r4)
            float r6 = r15.element
            float r4 = java.lang.Math.min(r4, r6)
            r14.element = r4
            r2 = r9
            r3 = 0
            r4 = 773894976(0x2e20b340, float:3.6538994E-11)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r4 = r48
            r6 = r9
            r7 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r8)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r17 = 0
            r19 = r48
            r20 = 0
            java.lang.Object r9 = r19.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r22.getEmpty()
            if (r9 != r8) goto L_0x0102
            r8 = 0
            r22 = 0
            kotlin.coroutines.EmptyCoroutineContext r22 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r1 = r22
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r4)
            r22 = r2
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r1 = r2
            r2 = r19
            r2.updateRememberedValue(r1)
            goto L_0x0107
        L_0x0102:
            r22 = r2
            r2 = r19
            r1 = r9
        L_0x0107:
            r48.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r31 = r1.getCoroutineScope()
            r48.endReplaceableGroup()
            float r1 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r3 = 0
            r4 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r6 = 0
            r7 = r48
            r8 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r3
            java.lang.Object r3 = r19.getEmpty()
            if (r9 != r3) goto L_0x0148
            r3 = 0
            float r1 = invoke$scaleToOffset(r2, r14, r15, r1)
            androidx.compose.runtime.MutableFloatState r1 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r1)
            r7.updateRememberedValue(r1)
            goto L_0x0149
        L_0x0148:
            r1 = r9
        L_0x0149:
            r48.endReplaceableGroup()
            androidx.compose.runtime.MutableFloatState r1 = (androidx.compose.runtime.MutableFloatState) r1
            r2 = 0
            r3 = r2
            r2 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r4 = 0
            r5 = r48
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r8 = 0
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x017a
            r9 = 0
            r16 = 0
            androidx.compose.runtime.MutableFloatState r9 = androidx.compose.runtime.PrimitiveSnapshotStateKt.mutableFloatStateOf(r16)
            r5.updateRememberedValue(r9)
            goto L_0x017b
        L_0x017a:
            r9 = r7
        L_0x017b:
            r48.endReplaceableGroup()
            r34 = r9
            androidx.compose.runtime.MutableFloatState r34 = (androidx.compose.runtime.MutableFloatState) r34
            float r2 = r14.element
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            float r3 = r15.element
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit>> r5 = r0.$onValueChangeState
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            int r7 = r0.$$dirty
            int r7 = r7 >> 6
            r7 = r7 & 896(0x380, float:1.256E-42)
            r8 = 0
            r9 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            boolean r9 = r11.changed((java.lang.Object) r2)
            boolean r16 = r11.changed((java.lang.Object) r3)
            r9 = r9 | r16
            boolean r16 = r11.changed((java.lang.Object) r4)
            r9 = r9 | r16
            r16 = r48
            r17 = 0
            r26 = r2
            java.lang.Object r2 = r16.rememberedValue()
            r27 = 0
            if (r9 != 0) goto L_0x01d7
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r28 = r3
            java.lang.Object r3 = r19.getEmpty()
            if (r2 != r3) goto L_0x01d2
            goto L_0x01d9
        L_0x01d2:
            r29 = r2
            r3 = r16
            goto L_0x01ff
        L_0x01d7:
            r28 = r3
        L_0x01d9:
            r3 = 0
            r29 = r2
            androidx.compose.material.SliderDraggableState r2 = new androidx.compose.material.SliderDraggableState
            androidx.compose.material.SliderKt$Slider$3$draggableState$1$1 r30 = new androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
            r19 = r30
            r20 = r1
            r21 = r34
            r22 = r14
            r23 = r15
            r24 = r5
            r25 = r6
            r19.<init>(r20, r21, r22, r23, r24, r25)
            r5 = r30
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r2.<init>(r5)
            r3 = r16
            r3.updateRememberedValue(r2)
        L_0x01ff:
            r48.endReplaceableGroup()
            r23 = r2
            androidx.compose.material.SliderDraggableState r23 = (androidx.compose.material.SliderDraggableState) r23
            androidx.compose.material.SliderKt$Slider$3$2 r2 = new androidx.compose.material.SliderKt$Slider$3$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r2.<init>(r3, r14, r15)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            float r4 = r14.element
            float r5 = r15.element
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            r5 = r1
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            float r6 = r0.$value
            int r7 = r0.$$dirty
            int r8 = r7 >> 9
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            int r7 = r7 << 12
            r9 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r9
            r8 = r8 | r7
            r7 = r48
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1 r2 = new androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            java.util.List<java.lang.Float> r3 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r0.$onValueChangeFinished
            r26 = r2
            r27 = r1
            r28 = r3
            r29 = r14
            r30 = r15
            r32 = r23
            r33 = r4
            r26.<init>(r27, r28, r29, r30, r31, r32, r33)
            r3 = 0
            androidx.compose.runtime.State r9 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r11, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = r23
            androidx.compose.foundation.gestures.DraggableState r3 = (androidx.compose.foundation.gestures.DraggableState) r3
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            r19 = r1
            androidx.compose.runtime.State r19 = (androidx.compose.runtime.State) r19
            r21 = r34
            androidx.compose.runtime.MutableState r21 = (androidx.compose.runtime.MutableState) r21
            boolean r5 = r0.$enabled
            r8 = r14
            r14 = r2
            r7 = r15
            r15 = r3
            r16 = r4
            r17 = r10
            r20 = r9
            r22 = r5
            androidx.compose.ui.Modifier r14 = androidx.compose.material.SliderKt.sliderTapModifier(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r37 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r40 = r23.isDragging()
            r35 = r2
            androidx.compose.ui.Modifier r35 = (androidx.compose.ui.Modifier) r35
            r36 = r23
            androidx.compose.foundation.gestures.DraggableState r36 = (androidx.compose.foundation.gestures.DraggableState) r36
            boolean r2 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            r4 = 0
            r5 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r6)
            boolean r6 = r11.changed((java.lang.Object) r9)
            r15 = r48
            r16 = 0
            r17 = r1
            java.lang.Object r1 = r15.rememberedValue()
            r19 = 0
            if (r6 != 0) goto L_0x02bb
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r4
            java.lang.Object r4 = r20.getEmpty()
            if (r1 != r4) goto L_0x02b8
            goto L_0x02bd
        L_0x02b8:
            r20 = r1
            goto L_0x02cf
        L_0x02bb:
            r21 = r4
        L_0x02bd:
            r4 = 0
            r20 = r1
            androidx.compose.material.SliderKt$Slider$3$drag$1$1 r1 = new androidx.compose.material.SliderKt$Slider$3$drag$1$1
            r22 = r4
            r4 = 0
            r1.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r15.updateRememberedValue(r1)
        L_0x02cf:
            r48.endReplaceableGroup()
            r42 = r1
            kotlin.jvm.functions.Function3 r42 = (kotlin.jvm.functions.Function3) r42
            r44 = 32
            r45 = 0
            r41 = 0
            r38 = r2
            r39 = r3
            r43 = r18
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45)
            float r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r15 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r16 = androidx.compose.material.SliderKt.calcFraction(r2, r3, r15)
            boolean r2 = r0.$enabled
            java.util.List<java.lang.Float> r4 = r0.$tickFractions
            androidx.compose.material.SliderColors r5 = r0.$colors
            float r3 = r7.element
            float r6 = r8.element
            float r6 = r3 - r6
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            androidx.compose.ui.Modifier r19 = r14.then(r1)
            r20 = r1
            int r1 = r0.$$dirty
            int r21 = r1 >> 9
            r0 = r21 & 14
            r0 = r0 | 512(0x200, float:7.175E-43)
            r21 = r3
            int r3 = r1 >> 15
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            int r1 = r1 >> 6
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = r21
            r3 = r16
            r21 = r7
            r7 = r1
            r1 = r8
            r8 = r19
            r19 = r9
            r9 = r48
            r22 = r10
            r10 = r0
            androidx.compose.material.SliderKt.SliderImpl(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x036a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x036a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$Slider$3.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> $valueRange2, float offset) {
        return SliderKt.scale(minPx.element, maxPx.element, offset, $valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> $valueRange2, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        return SliderKt.scale($valueRange2.getStart().floatValue(), $valueRange2.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
    }
}
