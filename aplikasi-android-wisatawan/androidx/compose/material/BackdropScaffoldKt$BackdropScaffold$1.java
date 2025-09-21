package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $backLayer;
    final /* synthetic */ Function1<Constraints, Constraints> $calculateBackLayerConstraints;
    final /* synthetic */ long $frontLayerBackgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $frontLayerContent;
    final /* synthetic */ long $frontLayerContentColor;
    final /* synthetic */ float $frontLayerElevation;
    final /* synthetic */ long $frontLayerScrimColor;
    final /* synthetic */ Shape $frontLayerShape;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ float $headerHeight;
    final /* synthetic */ float $headerHeightPx;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $peekHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ boolean $stickyFrontLayer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, float f, boolean z, boolean z2, BackdropScaffoldState backdropScaffoldState, float f2, int i, Shape shape, long j, long j2, float f3, int i2, float f4, float f5, Function2<? super Composer, ? super Integer, Unit> function22, long j3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$modifier = modifier;
        this.$backLayer = function2;
        this.$calculateBackLayerConstraints = function1;
        this.$headerHeightPx = f;
        this.$stickyFrontLayer = z;
        this.$gesturesEnabled = z2;
        this.$scaffoldState = backdropScaffoldState;
        this.$peekHeightPx = f2;
        this.$$dirty = i;
        this.$frontLayerShape = shape;
        this.$frontLayerBackgroundColor = j;
        this.$frontLayerContentColor = j2;
        this.$frontLayerElevation = f3;
        this.$$dirty1 = i2;
        this.$headerHeight = f4;
        this.$peekHeight = f5;
        this.$frontLayerContent = function22;
        this.$frontLayerScrimColor = j3;
        this.$snackbarHost = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C297@13395L24,298@13428L3119:BackdropScaffold.kt#jmzs0o");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1049909631, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
            }
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer.endReplaceableGroup();
            final CoroutineScope scope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer.endReplaceableGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(this.$modifier, 0.0f, 1, (Object) null);
            Function2<Composer, Integer, Unit> function2 = this.$backLayer;
            Function1<Constraints, Constraints> function1 = this.$calculateBackLayerConstraints;
            final float f = this.$headerHeightPx;
            final boolean z = this.$stickyFrontLayer;
            final boolean z2 = this.$gesturesEnabled;
            final BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
            final float f2 = this.$peekHeightPx;
            final int i2 = this.$$dirty;
            final Shape shape = this.$frontLayerShape;
            AnonymousClass1 r30 = r9;
            final long j = this.$frontLayerBackgroundColor;
            final long j2 = this.$frontLayerContentColor;
            final float f3 = this.$frontLayerElevation;
            final int i3 = this.$$dirty1;
            final float f4 = this.$headerHeight;
            final float f5 = this.$peekHeight;
            final Function2<Composer, Integer, Unit> function22 = this.$frontLayerContent;
            final long j3 = this.$frontLayerScrimColor;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function3 = this.$snackbarHost;
            AnonymousClass1 r9 = new Function4<Constraints, Float, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    m1174invokejYbf7pk(((Constraints) p1).m5794unboximpl(), ((Number) p2).floatValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:47:0x023c  */
                /* JADX WARNING: Removed duplicated region for block: B:50:0x0248  */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x024e  */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x0281  */
                /* JADX WARNING: Removed duplicated region for block: B:57:0x0297  */
                /* JADX WARNING: Removed duplicated region for block: B:61:0x0328  */
                /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke-jYbf7pk  reason: not valid java name */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void m1174invokejYbf7pk(long r37, float r39, androidx.compose.runtime.Composer r40, int r41) {
                    /*
                        r36 = this;
                        r0 = r36
                        r1 = r39
                        r14 = r40
                        r15 = r41
                        java.lang.String r2 = "CP(1:c#ui.unit.Constraints)344@15194L57,342@15132L942,366@16117L420:BackdropScaffold.kt#jmzs0o"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
                        r2 = r41
                        r3 = r15 & 14
                        r4 = 2
                        r12 = r37
                        if (r3 != 0) goto L_0x0020
                        boolean r3 = r14.changed((long) r12)
                        if (r3 == 0) goto L_0x001e
                        r3 = 4
                        goto L_0x001f
                    L_0x001e:
                        r3 = r4
                    L_0x001f:
                        r2 = r2 | r3
                    L_0x0020:
                        r3 = r15 & 112(0x70, float:1.57E-43)
                        if (r3 != 0) goto L_0x0030
                        boolean r3 = r14.changed((float) r1)
                        if (r3 == 0) goto L_0x002d
                        r3 = 32
                        goto L_0x002f
                    L_0x002d:
                        r3 = 16
                    L_0x002f:
                        r2 = r2 | r3
                    L_0x0030:
                        r11 = r2
                        r2 = r11 & 731(0x2db, float:1.024E-42)
                        r3 = 146(0x92, float:2.05E-43)
                        if (r2 != r3) goto L_0x0045
                        boolean r2 = r40.getSkipping()
                        if (r2 != 0) goto L_0x003e
                        goto L_0x0045
                    L_0x003e:
                        r40.skipToGroupEnd()
                        r19 = r11
                        goto L_0x032b
                    L_0x0045:
                        boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r2 == 0) goto L_0x0054
                        r2 = -1
                        java.lang.String r3 = "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)"
                        r5 = 1800047509(0x6b4a8b95, float:2.4486217E26)
                        androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r2, r3)
                    L_0x0054:
                        int r2 = androidx.compose.ui.unit.Constraints.m5787getMaxHeightimpl(r37)
                        float r10 = (float) r2
                        float r2 = r10
                        float r2 = r10 - r2
                        boolean r3 = r11
                        if (r3 == 0) goto L_0x0068
                        float r2 = java.lang.Math.min(r2, r1)
                        r16 = r2
                        goto L_0x006a
                    L_0x0068:
                        r16 = r2
                    L_0x006a:
                        boolean r2 = r12
                        r3 = 0
                        if (r2 == 0) goto L_0x007e
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        androidx.compose.material.BackdropScaffoldState r5 = r13
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = r5.getNestedScrollConnection$material_release()
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r2, r5, r3, r4, r3)
                        goto L_0x0082
                    L_0x007e:
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                    L_0x0082:
                        r9 = r2
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r17 = r2.then(r9)
                        androidx.compose.material.BackdropScaffoldState r2 = r13
                        r18 = r2
                        androidx.compose.material.SwipeableState r18 = (androidx.compose.material.SwipeableState) r18
                        float r2 = r14
                        java.lang.Float r2 = java.lang.Float.valueOf(r2)
                        androidx.compose.material.BackdropValue r5 = androidx.compose.material.BackdropValue.Concealed
                        kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
                        java.lang.Float r5 = java.lang.Float.valueOf(r16)
                        androidx.compose.material.BackdropValue r6 = androidx.compose.material.BackdropValue.Revealed
                        kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r6)
                        kotlin.Pair[] r4 = new kotlin.Pair[r4]
                        r8 = 0
                        r4[r8] = r2
                        r6 = 1
                        r4[r6] = r5
                        java.util.Map r19 = kotlin.collections.MapsKt.mapOf(r4)
                        androidx.compose.foundation.gestures.Orientation r20 = androidx.compose.foundation.gestures.Orientation.Vertical
                        boolean r2 = r12
                        r27 = 496(0x1f0, float:6.95E-43)
                        r28 = 0
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 0
                        r21 = r2
                        androidx.compose.ui.Modifier r2 = androidx.compose.material.SwipeableKt.m1431swipeablepPrIpRY$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1 r4 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
                        androidx.compose.material.BackdropScaffoldState r5 = r13
                        kotlinx.coroutines.CoroutineScope r7 = r24
                        r4.<init>(r5, r7)
                        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r8, r4, r6, r3)
                        r7 = r2
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        androidx.compose.material.BackdropScaffoldState r3 = r13
                        androidx.compose.material.BackdropScaffoldState r4 = r13
                        int r5 = r15
                        int r5 = r5 >> 12
                        r5 = r5 & 14
                        r17 = 0
                        r8 = 1157296644(0x44faf204, float:2007.563)
                        r14.startReplaceableGroup(r8)
                        java.lang.String r8 = "CC(remember)P(1):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
                        boolean r8 = r14.changed((java.lang.Object) r3)
                        r19 = r40
                        r20 = 0
                        java.lang.Object r6 = r19.rememberedValue()
                        r22 = 0
                        if (r8 != 0) goto L_0x0112
                        androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r1 = r23.getEmpty()
                        if (r6 != r1) goto L_0x010e
                        goto L_0x0112
                    L_0x010e:
                        r1 = r6
                        r4 = r19
                        goto L_0x0123
                    L_0x0112:
                        r1 = 0
                        r23 = r1
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1 r1 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                        r1.<init>(r4)
                        kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                        r4 = r19
                        r4.updateRememberedValue(r1)
                    L_0x0123:
                        r40.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r1)
                        androidx.compose.ui.Modifier r2 = r1.then(r7)
                        androidx.compose.ui.graphics.Shape r3 = r16
                        long r4 = r17
                        r1 = r7
                        long r6 = r19
                        float r8 = r21
                        r17 = r1
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2 r1 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2
                        r19 = r8
                        float r8 = r25
                        r20 = r9
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r26
                        r32 = r10
                        int r10 = r15
                        r13 = r11
                        long r11 = r27
                        r33 = r13
                        androidx.compose.material.BackdropScaffoldState r13 = r13
                        int r15 = r22
                        r34 = r6
                        boolean r6 = r12
                        kotlinx.coroutines.CoroutineScope r7 = r24
                        r22 = r1
                        r23 = r8
                        r24 = r9
                        r25 = r10
                        r26 = r11
                        r28 = r13
                        r29 = r15
                        r30 = r6
                        r31 = r7
                        r22.<init>(r23, r24, r25, r26, r28, r29, r30, r31)
                        r6 = -1065299503(0xffffffffc080d1d1, float:-4.0256124)
                        r7 = 1
                        androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r6, r7, r1)
                        r10 = r1
                        kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                        int r1 = r22
                        int r6 = r1 >> 3
                        r6 = r6 & 112(0x70, float:1.57E-43)
                        r8 = 1572864(0x180000, float:2.204052E-39)
                        r6 = r6 | r8
                        int r8 = r1 >> 6
                        r8 = r8 & 896(0x380, float:1.256E-42)
                        r6 = r6 | r8
                        int r8 = r1 >> 6
                        r8 = r8 & 7168(0x1c00, float:1.0045E-41)
                        r6 = r6 | r8
                        r8 = 458752(0x70000, float:6.42848E-40)
                        int r1 = r1 << 6
                        r1 = r1 & r8
                        r12 = r6 | r1
                        r8 = 0
                        r13 = 16
                        r15 = r7
                        r1 = r17
                        r6 = r34
                        r9 = r19
                        r11 = 0
                        r17 = r20
                        r18 = r32
                        r15 = r11
                        r19 = r33
                        r11 = r40
                        androidx.compose.material.SurfaceKt.m1420SurfaceFjzlyU(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        r3 = r2
                        androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                        androidx.compose.material.BackdropScaffoldState r2 = r13
                        boolean r2 = r2.isRevealed()
                        if (r2 == 0) goto L_0x01ca
                        float r2 = r10
                        float r10 = r18 - r2
                        int r2 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
                        if (r2 != 0) goto L_0x01c3
                        r8 = 1
                        goto L_0x01c4
                    L_0x01c3:
                        r8 = r15
                    L_0x01c4:
                        if (r8 == 0) goto L_0x01ca
                        float r2 = r23
                        r7 = r2
                        goto L_0x01d2
                    L_0x01ca:
                        r2 = 0
                        r4 = 0
                        float r5 = (float) r2
                        float r5 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r5)
                        r7 = r5
                    L_0x01d2:
                        r8 = 7
                        r9 = 0
                        r4 = 0
                        r5 = 0
                        r6 = 0
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m542paddingqDBjuR0$default(r3, r4, r5, r6, r7, r8, r9)
                        androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r3 = r3.getBottomCenter()
                        kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r29
                        androidx.compose.material.BackdropScaffoldState r5 = r13
                        int r6 = r22
                        r7 = 48
                        r8 = 0
                        r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                        r14.startReplaceableGroup(r9)
                        java.lang.String r9 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r9)
                        r9 = 0
                        int r10 = r7 >> 3
                        r10 = r10 & 14
                        int r11 = r7 >> 3
                        r11 = r11 & 112(0x70, float:1.57E-43)
                        r10 = r10 | r11
                        androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r9, r14, r10)
                        int r11 = r7 << 3
                        r11 = r11 & 112(0x70, float:1.57E-43)
                        r12 = 0
                        r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                        r14.startReplaceableGroup(r13)
                        java.lang.String r13 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
                        int r13 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r15)
                        androidx.compose.runtime.CompositionLocalMap r15 = r40.getCurrentCompositionLocalMap()
                        androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r20 = r20.getConstructor()
                        kotlin.jvm.functions.Function3 r21 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r2)
                        int r0 = r11 << 9
                        r0 = r0 & 7168(0x1c00, float:1.0045E-41)
                        r0 = r0 | 6
                        r22 = r21
                        r21 = r20
                        r20 = 0
                        r23 = r1
                        androidx.compose.runtime.Applier r1 = r40.getApplier()
                        boolean r1 = r1 instanceof androidx.compose.runtime.Applier
                        if (r1 != 0) goto L_0x023f
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x023f:
                        r40.startReusableNode()
                        boolean r1 = r40.getInserting()
                        if (r1 == 0) goto L_0x024e
                        r1 = r21
                        r14.createNode(r1)
                        goto L_0x0253
                    L_0x024e:
                        r1 = r21
                        r40.useNode()
                    L_0x0253:
                        r21 = r1
                        androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2865constructorimpl(r40)
                        r24 = 0
                        androidx.compose.ui.node.ComposeUiNode$Companion r25 = androidx.compose.ui.node.ComposeUiNode.Companion
                        r26 = r2
                        kotlin.jvm.functions.Function2 r2 = r25.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r10, r2)
                        androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r2 = r2.getSetResolvedCompositionLocals()
                        androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r1, r15, r2)
                        androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r2 = r2.getSetCompositeKeyHash()
                        r25 = 0
                        r27 = r1
                        r28 = 0
                        boolean r29 = r27.getInserting()
                        if (r29 != 0) goto L_0x0297
                        r29 = r3
                        java.lang.Object r3 = r27.rememberedValue()
                        r30 = r8
                        java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
                        boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r8)
                        if (r3 != 0) goto L_0x0294
                        goto L_0x029b
                    L_0x0294:
                        r8 = r27
                        goto L_0x02ab
                    L_0x0297:
                        r29 = r3
                        r30 = r8
                    L_0x029b:
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
                        r8 = r27
                        r8.updateRememberedValue(r3)
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
                        r1.apply(r3, r2)
                    L_0x02ab:
                        androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2857constructorimpl(r40)
                        androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2856boximpl(r1)
                        int r2 = r0 >> 3
                        r2 = r2 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                        r3 = r22
                        r3.invoke(r1, r14, r2)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r14.startReplaceableGroup(r1)
                        int r1 = r0 >> 9
                        r1 = r1 & 14
                        r2 = r40
                        r8 = 0
                        r22 = r0
                        r0 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
                        r24 = r1
                        java.lang.String r1 = "C71@3331L9:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
                        androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        int r1 = r7 >> 6
                        r1 = r1 & 112(0x70, float:1.57E-43)
                        r1 = r1 | 6
                        androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
                        r25 = r2
                        r27 = 0
                        r28 = r0
                        r0 = 1395535663(0x532e2f2f, float:7.4811592E11)
                        r31 = r1
                        java.lang.String r1 = "C375@16478L45:BackdropScaffold.kt#jmzs0o"
                        r32 = r3
                        r3 = r25
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
                        androidx.compose.material.SnackbarHostState r0 = r5.getSnackbarHostState()
                        int r1 = r6 >> 18
                        r1 = r1 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                        r4.invoke(r0, r3, r1)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
                        r40.endReplaceableGroup()
                        r40.endNode()
                        r40.endReplaceableGroup()
                        r40.endReplaceableGroup()
                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r0 == 0) goto L_0x032b
                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                    L_0x032b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.AnonymousClass1.m1174invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                }
            };
            BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function2, function1, ComposableLambdaKt.composableLambda(composer, 1800047509, true, r30), $composer, 3120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
