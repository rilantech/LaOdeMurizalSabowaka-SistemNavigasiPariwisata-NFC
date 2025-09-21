package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0001H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "T", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableKt$swipeable$3 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Map<Float, T> $anchors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ ResistanceConfig $resistance;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ SwipeableState<T> $state;
    final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;
    final /* synthetic */ float $velocityThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableKt$swipeable$3(Map<Float, ? extends T> map, SwipeableState<T> swipeableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, ResistanceConfig resistanceConfig, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, float f) {
        super(3);
        this.$anchors = map;
        this.$state = swipeableState;
        this.$orientation = orientation;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$reverseDirection = z2;
        this.$resistance = resistanceConfig;
        this.$thresholds = function2;
        this.$velocityThreshold = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            java.lang.String r2 = "$this$composed"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 1169892884(0x45bb2614, float:5988.76)
            r1.startReplaceableGroup(r2)
            java.lang.String r4 = "C588@24733L7,590@24775L502,611@25538L55:Swipeable.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0025
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.swipeable.<anonymous> (Swipeable.kt:581)"
            r6 = r25
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r4, r5)
            goto L_0x0027
        L_0x0025:
            r6 = r25
        L_0x0027:
            java.util.Map<java.lang.Float, T> r2 = r0.$anchors
            boolean r2 = r2.isEmpty()
            r4 = 1
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x011c
            java.util.Map<java.lang.Float, T> r2 = r0.$anchors
            java.util.Collection r2 = r2.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.distinct(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            java.util.Map<java.lang.Float, T> r5 = r0.$anchors
            int r5 = r5.size()
            if (r2 != r5) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r4 = 0
        L_0x004d:
            if (r4 == 0) goto L_0x010e
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r5 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r7, r8)
            java.lang.Object r7 = r1.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            r2 = r7
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.material3.SwipeableState<T> r4 = r0.$state
            java.util.Map<java.lang.Float, T> r5 = r0.$anchors
            r4.ensureInit$material3_release(r5)
            java.util.Map<java.lang.Float, T> r4 = r0.$anchors
            androidx.compose.material3.SwipeableState<T> r5 = r0.$state
            androidx.compose.material3.SwipeableKt$swipeable$3$3 r7 = new androidx.compose.material3.SwipeableKt$swipeable$3$3
            androidx.compose.material3.SwipeableState<T> r9 = r0.$state
            java.util.Map<java.lang.Float, T> r10 = r0.$anchors
            androidx.compose.material3.ResistanceConfig r11 = r0.$resistance
            kotlin.jvm.functions.Function2<T, T, androidx.compose.material3.ThresholdConfig> r13 = r0.$thresholds
            float r14 = r0.$velocityThreshold
            r15 = 0
            r8 = r7
            r12 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 520(0x208, float:7.29E-43)
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r4, r5, r7, r1, r8)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material3.SwipeableState<T> r5 = r0.$state
            boolean r12 = r5.isAnimationRunning()
            androidx.compose.material3.SwipeableState<T> r5 = r0.$state
            androidx.compose.foundation.gestures.DraggableState r8 = r5.getDraggableState$material3_release()
            r7 = r4
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.foundation.gestures.Orientation r9 = r0.$orientation
            boolean r10 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r11 = r0.$interactionSource
            androidx.compose.material3.SwipeableState<T> r4 = r0.$state
            androidx.compose.material3.SwipeableState<T> r5 = r0.$state
            r13 = 0
            r14 = 0
            r15 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r15)
            boolean r15 = r1.changed((java.lang.Object) r4)
            r16 = r24
            r17 = 0
            java.lang.Object r1 = r16.rememberedValue()
            r18 = 0
            if (r15 != 0) goto L_0x00d8
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r2
            java.lang.Object r2 = r19.getEmpty()
            if (r1 != r2) goto L_0x00d3
            goto L_0x00da
        L_0x00d3:
            r19 = r1
            r2 = r16
            goto L_0x00ee
        L_0x00d8:
            r20 = r2
        L_0x00da:
            r2 = 0
            r19 = r1
            androidx.compose.material3.SwipeableKt$swipeable$3$4$1 r1 = new androidx.compose.material3.SwipeableKt$swipeable$3$4$1
            r21 = r2
            r2 = 0
            r1.<init>(r5, r2)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r2 = r16
            r2.updateRememberedValue(r1)
        L_0x00ee:
            r24.endReplaceableGroup()
            r14 = r1
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            boolean r15 = r0.$reverseDirection
            r16 = 32
            r17 = 0
            r13 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x010a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010a:
            r24.endReplaceableGroup()
            return r1
        L_0x010e:
            r1 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "You cannot have two anchors mapped to the same state."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x011c:
            r1 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "You must have at least one anchor."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$swipeable$3.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
