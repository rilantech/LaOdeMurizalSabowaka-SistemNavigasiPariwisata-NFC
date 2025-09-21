package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $bottomSheet;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(Function0<Float> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, float f, Function2<? super Composer, ? super Integer, Unit> function23, BottomSheetState bottomSheetState, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.$sheetOffset = function0;
        this.$topBar = function2;
        this.$floatingActionButton = function22;
        this.$floatingActionButtonPosition = i;
        this.$sheetPeekHeight = f;
        this.$snackbarHost = function23;
        this.$sheetState = bottomSheetState;
        this.$bottomSheet = function3;
        this.$$dirty = i2;
        this.$body = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m2911invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m7504unboximpl());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: androidx.compose.ui.layout.Placeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v44, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0158 A[LOOP:3: B:29:0x0152->B:31:0x0158, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02d2 A[LOOP:7: B:83:0x02cc->B:85:0x02d2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x033b  */
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m2911invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope r40, long r41) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            java.lang.String r2 = "$this$SubcomposeLayout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            int r2 = androidx.compose.ui.unit.Constraints.m7498getMaxWidthimpl(r41)
            int r10 = androidx.compose.ui.unit.Constraints.m7497getMaxHeightimpl(r41)
            r17 = 10
            r18 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r41
            long r11 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r11, r13, r14, r15, r16, r17, r18)
            androidx.compose.material.BottomSheetScaffoldLayoutSlot r3 = androidx.compose.material.BottomSheetScaffoldLayoutSlot.Sheet
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceables$1 r4 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceables$1
            kotlin.jvm.functions.Function3<java.lang.Integer, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$bottomSheet
            int r6 = r0.$$dirty
            r4.<init>(r5, r10, r6)
            r5 = 835355605(0x31ca83d5, float:5.8939613E-9)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r5, r6, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.util.List r3 = r1.subcompose(r3, r4)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r7 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r7)
            r5.<init>(r8)
            java.util.Collection r5 = (java.util.Collection) r5
            r8 = r3
            r9 = 0
            java.util.Iterator r13 = r8.iterator()
        L_0x0050:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0067
            java.lang.Object r14 = r13.next()
            r15 = r14
            androidx.compose.ui.layout.Measurable r15 = (androidx.compose.ui.layout.Measurable) r15
            r16 = 0
            androidx.compose.ui.layout.Placeable r15 = r15.m6399measureBRTryo0(r11)
            r5.add(r15)
            goto L_0x0050
        L_0x0067:
            r30 = r5
            java.util.List r30 = (java.util.List) r30
            kotlin.jvm.functions.Function0<java.lang.Float> r3 = r0.$sheetOffset
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            int r13 = kotlin.math.MathKt.roundToInt((float) r3)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$topBar
            if (r3 == 0) goto L_0x00c0
            r5 = r3
            r8 = 0
            androidx.compose.material.BottomSheetScaffoldLayoutSlot r9 = androidx.compose.material.BottomSheetScaffoldLayoutSlot.TopBar
            java.util.List r3 = r1.subcompose(r9, r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r9 = 0
            java.util.ArrayList r14 = new java.util.ArrayList
            int r15 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r7)
            r14.<init>(r15)
            java.util.Collection r14 = (java.util.Collection) r14
            r15 = r3
            r16 = 0
            java.util.Iterator r17 = r15.iterator()
        L_0x00a1:
            boolean r18 = r17.hasNext()
            if (r18 == 0) goto L_0x00b9
            java.lang.Object r18 = r17.next()
            r4 = r18
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            r19 = 0
            androidx.compose.ui.layout.Placeable r4 = r4.m6399measureBRTryo0(r11)
            r14.add(r4)
            goto L_0x00a1
        L_0x00b9:
            r4 = r14
            java.util.List r4 = (java.util.List) r4
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            r14 = r4
            r3 = 0
            if (r14 == 0) goto L_0x010c
            r4 = r14
            r5 = 0
            boolean r8 = r4.isEmpty()
            if (r8 == 0) goto L_0x00d0
            r8 = 0
            goto L_0x0103
        L_0x00d0:
            java.lang.Object r8 = r4.get(r3)
            r9 = r8
            androidx.compose.ui.layout.Placeable r9 = (androidx.compose.ui.layout.Placeable) r9
            r15 = 0
            int r9 = r9.getHeight()
            r15 = 1
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r4)
            if (r15 > r3) goto L_0x0102
        L_0x00e4:
            java.lang.Object r17 = r4.get(r15)
            r18 = r17
            androidx.compose.ui.layout.Placeable r18 = (androidx.compose.ui.layout.Placeable) r18
            r19 = 0
            int r18 = r18.getHeight()
            r19 = r18
            r7 = r19
            if (r9 >= r7) goto L_0x00fb
            r8 = r17
            r9 = r7
        L_0x00fb:
            if (r15 == r3) goto L_0x0102
            int r15 = r15 + 1
            r7 = 10
            goto L_0x00e4
        L_0x0102:
        L_0x0103:
            androidx.compose.ui.layout.Placeable r8 = (androidx.compose.ui.layout.Placeable) r8
            if (r8 == 0) goto L_0x010c
            int r3 = r8.getHeight()
            goto L_0x010d
        L_0x010c:
            r3 = 0
        L_0x010d:
            r15 = r3
            int r24 = r10 - r15
            r25 = 7
            r26 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r19 = r11
            long r8 = androidx.compose.ui.unit.Constraints.m7489copyZbe2FdA$default(r19, r21, r22, r23, r24, r25, r26)
            androidx.compose.material.BottomSheetScaffoldLayoutSlot r3 = androidx.compose.material.BottomSheetScaffoldLayoutSlot.Body
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceables$1 r4 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceables$1
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$body
            float r7 = r0.$sheetPeekHeight
            int r6 = r0.$$dirty
            r4.<init>(r5, r7, r6)
            r5 = -2019457358(0xffffffff87a186b2, float:-2.4303754E-34)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r5, r6, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.util.List r3 = r1.subcompose(r3, r4)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r6)
            r5.<init>(r7)
            java.util.Collection r5 = (java.util.Collection) r5
            r6 = r3
            r7 = 0
            java.util.Iterator r17 = r6.iterator()
        L_0x0152:
            boolean r19 = r17.hasNext()
            if (r19 == 0) goto L_0x016e
            java.lang.Object r19 = r17.next()
            r20 = r3
            r3 = r19
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            r21 = 0
            androidx.compose.ui.layout.Placeable r3 = r3.m6399measureBRTryo0(r8)
            r5.add(r3)
            r3 = r20
            goto L_0x0152
        L_0x016e:
            r20 = r3
            r28 = r5
            java.util.List r28 = (java.util.List) r28
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$floatingActionButton
            if (r3 == 0) goto L_0x01c0
            r4 = 0
            androidx.compose.material.BottomSheetScaffoldLayoutSlot r5 = androidx.compose.material.BottomSheetScaffoldLayoutSlot.Fab
            java.util.List r5 = r1.subcompose(r5, r3)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r17 = r3
            r19 = r4
            r3 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r3)
            r7.<init>(r4)
            r3 = r7
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = r5
            r7 = 0
            java.util.Iterator r20 = r4.iterator()
        L_0x019d:
            boolean r21 = r20.hasNext()
            if (r21 == 0) goto L_0x01b9
            java.lang.Object r21 = r20.next()
            r22 = r4
            r4 = r21
            androidx.compose.ui.layout.Measurable r4 = (androidx.compose.ui.layout.Measurable) r4
            r23 = 0
            androidx.compose.ui.layout.Placeable r4 = r4.m6399measureBRTryo0(r11)
            r3.add(r4)
            r4 = r22
            goto L_0x019d
        L_0x01b9:
            r22 = r4
            java.util.List r3 = (java.util.List) r3
            goto L_0x01c1
        L_0x01c0:
            r3 = 0
        L_0x01c1:
            r17 = r3
            if (r17 == 0) goto L_0x0214
            r3 = r17
            r4 = 0
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x01d1
            r6 = 0
            goto L_0x020b
        L_0x01d1:
            r5 = 0
            java.lang.Object r6 = r3.get(r5)
            r5 = r6
            androidx.compose.ui.layout.Placeable r5 = (androidx.compose.ui.layout.Placeable) r5
            r7 = 0
            int r5 = r5.getWidth()
            r7 = 1
            r19 = r4
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r3)
            if (r7 > r4) goto L_0x0208
        L_0x01e8:
            java.lang.Object r20 = r3.get(r7)
            r21 = r20
            androidx.compose.ui.layout.Placeable r21 = (androidx.compose.ui.layout.Placeable) r21
            r22 = 0
            int r21 = r21.getWidth()
            r22 = r21
            r21 = r3
            r3 = r22
            if (r5 >= r3) goto L_0x0201
            r6 = r20
            r5 = r3
        L_0x0201:
            if (r7 == r4) goto L_0x020a
            int r7 = r7 + 1
            r3 = r21
            goto L_0x01e8
        L_0x0208:
            r21 = r3
        L_0x020a:
        L_0x020b:
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            if (r6 == 0) goto L_0x0214
            int r3 = r6.getWidth()
            goto L_0x0215
        L_0x0214:
            r3 = 0
        L_0x0215:
            r19 = r3
            if (r17 == 0) goto L_0x0268
            r3 = r17
            r4 = 0
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0225
            r6 = 0
            goto L_0x025f
        L_0x0225:
            r5 = 0
            java.lang.Object r6 = r3.get(r5)
            r5 = r6
            androidx.compose.ui.layout.Placeable r5 = (androidx.compose.ui.layout.Placeable) r5
            r7 = 0
            int r5 = r5.getHeight()
            r7 = 1
            r20 = r4
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r3)
            if (r7 > r4) goto L_0x025c
        L_0x023c:
            java.lang.Object r21 = r3.get(r7)
            r22 = r21
            androidx.compose.ui.layout.Placeable r22 = (androidx.compose.ui.layout.Placeable) r22
            r23 = 0
            int r22 = r22.getHeight()
            r23 = r22
            r22 = r3
            r3 = r23
            if (r5 >= r3) goto L_0x0255
            r6 = r21
            r5 = r3
        L_0x0255:
            if (r7 == r4) goto L_0x025e
            int r7 = r7 + 1
            r3 = r22
            goto L_0x023c
        L_0x025c:
            r22 = r3
        L_0x025e:
        L_0x025f:
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            if (r6 == 0) goto L_0x0268
            int r3 = r6.getHeight()
            goto L_0x0269
        L_0x0268:
            r3 = 0
        L_0x0269:
            r20 = r3
            int r3 = r0.$floatingActionButtonPosition
            androidx.compose.material.FabPosition$Companion r4 = androidx.compose.material.FabPosition.Companion
            int r4 = r4.m3027getCenter5ygKITE()
            boolean r3 = androidx.compose.material.FabPosition.m3023equalsimpl0(r3, r4)
            if (r3 == 0) goto L_0x0280
            int r3 = r2 - r19
            int r3 = r3 / 2
            r35 = r3
            goto L_0x028d
        L_0x0280:
            int r3 = r2 - r19
            float r4 = androidx.compose.material.BottomSheetScaffoldKt.FabSpacing
            int r4 = r1.m7529roundToPx0680j_4(r4)
            int r3 = r3 - r4
            r35 = r3
        L_0x028d:
            float r3 = r0.$sheetPeekHeight
            float r3 = r1.m7535toPx0680j_4(r3)
            int r4 = r20 / 2
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x02a7
            int r3 = r13 - r20
            float r4 = androidx.compose.material.BottomSheetScaffoldKt.FabSpacing
            int r4 = r1.m7529roundToPx0680j_4(r4)
            int r3 = r3 - r4
            goto L_0x02ab
        L_0x02a7:
            int r3 = r20 / 2
            int r3 = r13 - r3
        L_0x02ab:
            r21 = r3
            androidx.compose.material.BottomSheetScaffoldLayoutSlot r3 = androidx.compose.material.BottomSheetScaffoldLayoutSlot.Snackbar
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$snackbarHost
            java.util.List r3 = r1.subcompose(r3, r4)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            r6 = r3
            r7 = 0
            java.util.Iterator r18 = r6.iterator()
        L_0x02cc:
            boolean r22 = r18.hasNext()
            if (r22 == 0) goto L_0x02e8
            java.lang.Object r22 = r18.next()
            r23 = r3
            r3 = r22
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            r24 = 0
            androidx.compose.ui.layout.Placeable r3 = r3.m6399measureBRTryo0(r11)
            r5.add(r3)
            r3 = r23
            goto L_0x02cc
        L_0x02e8:
            r23 = r3
            r32 = r5
            java.util.List r32 = (java.util.List) r32
            r3 = r32
            r4 = 0
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x02fd
            r6 = 0
            goto L_0x0337
        L_0x02fd:
            r5 = 0
            java.lang.Object r6 = r3.get(r5)
            r5 = r6
            androidx.compose.ui.layout.Placeable r5 = (androidx.compose.ui.layout.Placeable) r5
            r7 = 0
            int r5 = r5.getWidth()
            r7 = 1
            r18 = r4
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r3)
            if (r7 > r4) goto L_0x0334
        L_0x0314:
            java.lang.Object r22 = r3.get(r7)
            r23 = r22
            androidx.compose.ui.layout.Placeable r23 = (androidx.compose.ui.layout.Placeable) r23
            r24 = 0
            int r23 = r23.getWidth()
            r24 = r23
            r23 = r3
            r3 = r24
            if (r5 >= r3) goto L_0x032d
            r6 = r22
            r5 = r3
        L_0x032d:
            if (r7 == r4) goto L_0x0336
            int r7 = r7 + 1
            r3 = r23
            goto L_0x0314
        L_0x0334:
            r23 = r3
        L_0x0336:
        L_0x0337:
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            if (r6 == 0) goto L_0x0340
            int r5 = r6.getWidth()
            goto L_0x0341
        L_0x0340:
            r5 = 0
        L_0x0341:
            r18 = r5
            r3 = r32
            r4 = 0
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x034f
            r4 = 0
            goto L_0x038b
        L_0x034f:
            r5 = 0
            java.lang.Object r6 = r3.get(r5)
            r7 = r6
            androidx.compose.ui.layout.Placeable r7 = (androidx.compose.ui.layout.Placeable) r7
            r16 = 0
            int r7 = r7.getHeight()
            r5 = 1
            r22 = r4
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r3)
            if (r5 > r4) goto L_0x0387
        L_0x0367:
            java.lang.Object r23 = r3.get(r5)
            r24 = r23
            androidx.compose.ui.layout.Placeable r24 = (androidx.compose.ui.layout.Placeable) r24
            r25 = 0
            int r24 = r24.getHeight()
            r25 = r24
            r24 = r3
            r3 = r25
            if (r7 >= r3) goto L_0x0380
            r6 = r23
            r7 = r3
        L_0x0380:
            if (r5 == r4) goto L_0x0389
            int r5 = r5 + 1
            r3 = r24
            goto L_0x0367
        L_0x0387:
            r24 = r3
        L_0x0389:
            r4 = r6
        L_0x038b:
            androidx.compose.ui.layout.Placeable r4 = (androidx.compose.ui.layout.Placeable) r4
            if (r4 == 0) goto L_0x0394
            int r3 = r4.getHeight()
            goto L_0x0395
        L_0x0394:
            r3 = 0
        L_0x0395:
            r16 = r3
            int r3 = r2 - r18
            int r22 = r3 / 2
            androidx.compose.material.BottomSheetState r3 = r0.$sheetState
            androidx.compose.material.BottomSheetValue r3 = r3.getCurrentValue()
            int[] r4 = androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            switch(r3) {
                case 1: goto L_0x03b7;
                case 2: goto L_0x03b2;
                default: goto L_0x03ac;
            }
        L_0x03ac:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x03b2:
            int r3 = r10 - r16
            r38 = r3
            goto L_0x03bb
        L_0x03b7:
            int r3 = r21 - r16
            r38 = r3
        L_0x03bb:
            r3 = r1
            androidx.compose.ui.layout.MeasureScope r3 = (androidx.compose.ui.layout.MeasureScope) r3
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1 r4 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1
            r27 = r4
            r29 = r14
            r31 = r17
            r33 = r15
            r34 = r13
            r36 = r21
            r37 = r22
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            r7 = r4
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r23 = 4
            r24 = 0
            r6 = 0
            r4 = r2
            r5 = r10
            r25 = r8
            r8 = r23
            r9 = r24
            androidx.compose.ui.layout.MeasureResult r3 = androidx.compose.ui.layout.MeasureScope.layout$default(r3, r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.m2911invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
    }
}
