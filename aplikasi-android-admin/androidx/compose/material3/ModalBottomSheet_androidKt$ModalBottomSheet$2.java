package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ AnchorChangeHandler<SheetValue> $anchorChangeHandler;
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$2(long j, Function0<Unit> function0, SheetState sheetState, int i, Modifier modifier, AnchorChangeHandler<SheetValue> anchorChangeHandler, Function1<? super Float, Unit> function1, Shape shape, long j2, long j3, float f, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i2, CoroutineScope coroutineScope) {
        super(2);
        this.$scrimColor = j;
        this.$animateToDismiss = function0;
        this.$sheetState = sheetState;
        this.$$dirty = i;
        this.$modifier = modifier;
        this.$anchorChangeHandler = anchorChangeHandler;
        this.$settleToDismiss = function1;
        this.$shape = shape;
        this.$containerColor = j2;
        this.$contentColor = j3;
        this.$tonalElevation = f;
        this.$dragHandle = function2;
        this.$content = function3;
        this.$$dirty1 = i2;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C177@8118L4446:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1424497392, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:176)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            final long j = this.$scrimColor;
            final Function0<Unit> function0 = this.$animateToDismiss;
            final SheetState sheetState = this.$sheetState;
            final int i2 = this.$$dirty;
            final Modifier modifier = this.$modifier;
            final AnchorChangeHandler<SheetValue> anchorChangeHandler = this.$anchorChangeHandler;
            final Function1<Float, Unit> function1 = this.$settleToDismiss;
            final Shape shape = this.$shape;
            final long j2 = this.$containerColor;
            final long j3 = this.$contentColor;
            final float f = this.$tonalElevation;
            final Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
            final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
            final int i3 = this.$$dirty1;
            final CoroutineScope coroutineScope = this.$scope;
            BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer, 574030426, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:40:0x0192  */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x01a0  */
                /* JADX WARNING: Removed duplicated region for block: B:47:0x0228  */
                /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r32, androidx.compose.runtime.Composer r33, int r34) {
                    /*
                        r31 = this;
                        r0 = r31
                        r1 = r32
                        r15 = r33
                        r14 = r34
                        java.lang.String r2 = "$this$BoxWithConstraints"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                        java.lang.String r2 = "C179@8226L168,184@8434L48,190@8711L36,191@8776L244,200@9080L348,212@9716L75,185@8495L4059:ModalBottomSheet.android.kt#uh7d8r"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
                        r2 = r34
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
                        boolean r2 = r33.getSkipping()
                        if (r2 != 0) goto L_0x0031
                        goto L_0x0036
                    L_0x0031:
                        r33.skipToGroupEnd()
                        goto L_0x022b
                    L_0x0036:
                        boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r2 == 0) goto L_0x0045
                        r2 = -1
                        java.lang.String r3 = "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:177)"
                        r4 = 574030426(0x2237025a, float:2.480237E-18)
                        androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r2, r3)
                    L_0x0045:
                        long r2 = r32.m2169getConstraintsmsEJaDk()
                        int r13 = androidx.compose.ui.unit.Constraints.m7497getMaxHeightimpl(r2)
                        long r2 = r11
                        kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r13
                        androidx.compose.material3.SheetState r5 = r14
                        androidx.compose.material3.SheetValue r5 = r5.getTargetValue()
                        androidx.compose.material3.SheetValue r6 = androidx.compose.material3.SheetValue.Hidden
                        r9 = 0
                        r10 = 1
                        if (r5 == r6) goto L_0x005f
                        r5 = r10
                        goto L_0x0060
                    L_0x005f:
                        r5 = r9
                    L_0x0060:
                        int r6 = r15
                        int r6 = r6 >> 21
                        r7 = r6 & 14
                        r6 = r33
                        androidx.compose.material3.ModalBottomSheet_androidKt.m3566Scrim3JVO9M(r2, r4, r5, r6, r7)
                        androidx.compose.material3.Strings$Companion r2 = androidx.compose.material3.Strings.Companion
                        int r2 = r2.m3703getBottomSheetPaneTitleadMyvUU()
                        r3 = 6
                        java.lang.String r12 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r2, r15, r3)
                        androidx.compose.ui.Modifier r2 = r16
                        float r4 = androidx.compose.material3.SheetDefaultsKt.getBottomSheetMaxWidth()
                        r5 = 0
                        r6 = 0
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m2329widthInVpY3zN4$default(r2, r5, r4, r10, r6)
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r5, r10, r6)
                        androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r4 = r4.getTopCenter()
                        androidx.compose.ui.Modifier r2 = r1.align(r2, r4)
                        r4 = 0
                        r5 = 0
                        r7 = 1157296644(0x44faf204, float:2007.563)
                        r15.startReplaceableGroup(r7)
                        java.lang.String r11 = "CC(remember)P(1):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r15, r11)
                        boolean r17 = r15.changed((java.lang.Object) r12)
                        r18 = r33
                        r19 = 0
                        java.lang.Object r8 = r18.rememberedValue()
                        r21 = 0
                        if (r17 != 0) goto L_0x00bb
                        androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r7 = r22.getEmpty()
                        if (r8 != r7) goto L_0x00b7
                        goto L_0x00bb
                    L_0x00b7:
                        r3 = r8
                        r7 = r18
                        goto L_0x00ca
                    L_0x00bb:
                        r7 = 0
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1$1 r3 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1$1
                        r3.<init>(r12)
                        kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                        r7 = r18
                        r7.updateRememberedValue(r3)
                    L_0x00ca:
                        r33.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r9, r3, r10, r6)
                        androidx.compose.material3.SheetState r3 = r14
                        androidx.compose.material3.SheetState r4 = r14
                        int r5 = r15
                        r7 = 6
                        int r5 = r5 >> r7
                        r5 = r5 & 14
                        r7 = 0
                        r8 = 1157296644(0x44faf204, float:2007.563)
                        r15.startReplaceableGroup(r8)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r15, r11)
                        boolean r8 = r15.changed((java.lang.Object) r3)
                        r9 = r33
                        r17 = 0
                        java.lang.Object r10 = r9.rememberedValue()
                        r19 = 0
                        if (r8 != 0) goto L_0x0104
                        androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r6 = r21.getEmpty()
                        if (r10 != r6) goto L_0x0102
                        goto L_0x0104
                    L_0x0102:
                        r1 = r10
                        goto L_0x0111
                    L_0x0104:
                        r6 = 0
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2$1 r1 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2$1
                        r1.<init>(r4)
                        kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                        r9.updateRememberedValue(r1)
                    L_0x0111:
                        r33.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r1)
                        androidx.compose.material3.SheetState r2 = r14
                        androidx.compose.material3.SheetState r3 = r14
                        kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r4 = r18
                        int r5 = r15
                        r6 = 6
                        int r5 = r5 >> r6
                        r5 = r5 & 14
                        r6 = 0
                        r7 = 1157296644(0x44faf204, float:2007.563)
                        r15.startReplaceableGroup(r7)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r15, r11)
                        boolean r7 = r15.changed((java.lang.Object) r2)
                        r8 = r33
                        r9 = 0
                        java.lang.Object r10 = r8.rememberedValue()
                        r17 = 0
                        if (r7 != 0) goto L_0x014e
                        androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
                        r21 = r2
                        java.lang.Object r2 = r19.getEmpty()
                        if (r10 != r2) goto L_0x014c
                        goto L_0x0150
                    L_0x014c:
                        r2 = r10
                        goto L_0x0160
                    L_0x014e:
                        r21 = r2
                    L_0x0150:
                        r2 = 0
                        r19 = r2
                        androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r3, r2, r4)
                        r8.updateRememberedValue(r2)
                    L_0x0160:
                        r33.endReplaceableGroup()
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollConnection) r2
                        r3 = 2
                        r4 = 0
                        androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r1, r2, r4, r3, r4)
                        androidx.compose.material3.SheetState r2 = r14
                        androidx.compose.material3.AnchorChangeHandler<androidx.compose.material3.SheetValue> r3 = r17
                        float r4 = (float) r13
                        kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r5 = r18
                        kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r6 = r18
                        r7 = 0
                        r8 = 0
                        r9 = 1157296644(0x44faf204, float:2007.563)
                        r15.startReplaceableGroup(r9)
                        androidx.compose.runtime.ComposerKt.sourceInformation(r15, r11)
                        boolean r9 = r15.changed((java.lang.Object) r5)
                        r10 = r33
                        r11 = 0
                        r17 = r5
                        java.lang.Object r5 = r10.rememberedValue()
                        r19 = 0
                        if (r9 != 0) goto L_0x01a0
                        androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
                        r21 = r7
                        java.lang.Object r7 = r20.getEmpty()
                        if (r5 != r7) goto L_0x019d
                        goto L_0x01a2
                    L_0x019d:
                        r20 = r5
                        goto L_0x01b1
                    L_0x01a0:
                        r21 = r7
                    L_0x01a2:
                        r7 = 0
                        r20 = r5
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1 r5 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1
                        r5.<init>(r6)
                        kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                        r10.updateRememberedValue(r5)
                    L_0x01b1:
                        r33.endReplaceableGroup()
                        kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                        androidx.compose.ui.Modifier r2 = androidx.compose.material3.ModalBottomSheet_androidKt.modalBottomSheetSwipeable(r1, r2, r3, r4, r5)
                        androidx.compose.ui.graphics.Shape r3 = r19
                        long r4 = r20
                        long r6 = r22
                        float r8 = r24
                        androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5 r1 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r25
                        kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r10 = r26
                        int r11 = r27
                        r17 = r12
                        androidx.compose.material3.SheetState r12 = r14
                        r19 = r13
                        kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r13
                        kotlinx.coroutines.CoroutineScope r14 = r28
                        r20 = r8
                        int r8 = r15
                        r23 = r1
                        r24 = r9
                        r25 = r10
                        r26 = r11
                        r27 = r12
                        r28 = r13
                        r29 = r14
                        r30 = r8
                        r23.<init>(r24, r25, r26, r27, r28, r29, r30)
                        r8 = 1371274015(0x51bbfb1f, float:1.009215E11)
                        r9 = 1
                        androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r8, r9, r1)
                        r11 = r1
                        kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
                        int r1 = r15
                        int r8 = r1 >> 6
                        r8 = r8 & 112(0x70, float:1.57E-43)
                        r9 = 12582912(0xc00000, float:1.7632415E-38)
                        r8 = r8 | r9
                        int r9 = r1 >> 6
                        r9 = r9 & 896(0x380, float:1.256E-42)
                        r8 = r8 | r9
                        int r9 = r1 >> 6
                        r9 = r9 & 7168(0x1c00, float:1.0045E-41)
                        r8 = r8 | r9
                        r9 = 57344(0xe000, float:8.0356E-41)
                        r10 = 6
                        int r1 = r1 >> r10
                        r1 = r1 & r9
                        r13 = r8 | r1
                        r9 = 0
                        r10 = 0
                        r14 = 96
                        r8 = r20
                        r1 = r17
                        r12 = r33
                        r17 = r19
                        androidx.compose.material3.SurfaceKt.m3772SurfaceT9BRK9s(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
                        boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r2 == 0) goto L_0x022b
                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                    L_0x022b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2.AnonymousClass1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
                }
            }), $composer, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
