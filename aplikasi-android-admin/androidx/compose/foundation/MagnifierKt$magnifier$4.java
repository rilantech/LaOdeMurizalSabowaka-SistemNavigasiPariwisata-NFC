package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<Density, Offset> $magnifierCenter;
    final /* synthetic */ Function1<DpSize, Unit> $onSizeChanged;
    final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
    final /* synthetic */ Function1<Density, Offset> $sourceCenter;
    final /* synthetic */ MagnifierStyle $style;
    final /* synthetic */ float $zoom;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
        super(3);
        this.$sourceCenter = function1;
        this.$magnifierCenter = function12;
        this.$zoom = f;
        this.$onSizeChanged = function13;
        this.$platformMagnifierFactory = platformMagnifierFactory;
        this.$style = magnifierStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv$iv5;
        Object value$iv$iv6;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(-454877003);
        ComposerKt.sourceInformation(composer, "C271@11563L7,272@11602L7,273@11650L47,274@11729L34,275@11798L37,276@11859L26,277@11918L35,278@11984L331,288@12344L62,293@12536L107,305@13220L2602,371@15879L344,383@16592L78:Magnifier.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-454877003, $changed, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:270)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view = (View) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4702boximpl(Offset.Companion.m4728getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState anchorPositionInRoot$delegate = (MutableState) value$iv$iv;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, composer, 0);
        State updatedMagnifierCenter$delegate = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, composer, 0);
        State updatedZoom$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), composer, 0);
        State updatedOnSizeChanged$delegate = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, composer, 0);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(density, rememberUpdatedState, anchorPositionInRoot$delegate));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        State sourceCenterInRoot$delegate = (State) value$iv$iv2;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv3 = $composer;
        Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        State<T> state = rememberUpdatedState;
        if (it$iv$iv3 == Composer.Companion.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$isMagnifierShown$2$1(sourceCenterInRoot$delegate));
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        State isMagnifierShown$delegate = (State) value$iv$iv3;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv4 = $composer;
        Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
        if (it$iv$iv4 == Composer.Companion.getEmpty()) {
            value$iv$iv4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
            $this$cache$iv$iv4.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        final MutableSharedFlow onNeedsUpdate = (MutableSharedFlow) value$iv$iv4;
        Float valueOf = Float.valueOf(this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom);
        MagnifierStyle magnifierStyle = this.$style;
        Object[] objArr = {view, density, valueOf, magnifierStyle, Boolean.valueOf(Intrinsics.areEqual((Object) magnifierStyle, (Object) MagnifierStyle.Companion.getTextDefault()))};
        final PlatformMagnifierFactory platformMagnifierFactory = this.$platformMagnifierFactory;
        final MagnifierStyle magnifierStyle2 = this.$style;
        final View view2 = view;
        final Density density2 = density;
        Object[] objArr2 = objArr;
        final float f = this.$zoom;
        final MutableSharedFlow mutableSharedFlow = onNeedsUpdate;
        final State state2 = updatedOnSizeChanged$delegate;
        final State state3 = isMagnifierShown$delegate;
        final State state4 = sourceCenterInRoot$delegate;
        final State state5 = updatedMagnifierCenter$delegate;
        final MutableState mutableState = anchorPositionInRoot$delegate;
        final State state6 = updatedZoom$delegate;
        EffectsKt.LaunchedEffect(objArr2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 72);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) anchorPositionInRoot$delegate);
        Composer $this$cache$iv$iv5 = $composer;
        Object it$iv$iv5 = $this$cache$iv$iv5.rememberedValue();
        if (invalid$iv$iv || it$iv$iv5 == Composer.Companion.getEmpty()) {
            value$iv$iv5 = (Function1) new MagnifierKt$magnifier$4$2$1(anchorPositionInRoot$delegate);
            $this$cache$iv$iv5.updateRememberedValue(value$iv$iv5);
        } else {
            value$iv$iv5 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned($this$composed, (Function1) value$iv$iv5), new Function1<DrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((DrawScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope $this$drawBehind) {
                Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
                onNeedsUpdate.tryEmit(Unit.INSTANCE);
            }
        });
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) sourceCenterInRoot$delegate);
        Composer $this$cache$iv$iv6 = $composer;
        Object it$iv$iv6 = $this$cache$iv$iv6.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv6 == Composer.Companion.getEmpty()) {
            value$iv$iv6 = (Function1) new MagnifierKt$magnifier$4$4$1(sourceCenterInRoot$delegate);
            $this$cache$iv$iv6.updateRememberedValue(value$iv$iv6);
        } else {
            value$iv$iv6 = it$iv$iv6;
        }
        $composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) value$iv$iv6, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return semantics$default;
    }

    /* access modifiers changed from: private */
    public static final long invoke$lambda$1(MutableState<Offset> $anchorPositionInRoot$delegate) {
        return ((Offset) $anchorPositionInRoot$delegate.getValue()).m4723unboximpl();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Offset> $anchorPositionInRoot$delegate, long value) {
        $anchorPositionInRoot$delegate.setValue(Offset.m4702boximpl(value));
    }

    /* access modifiers changed from: private */
    public static final Function1<Density, Offset> invoke$lambda$3(State<? extends Function1<? super Density, Offset>> $updatedSourceCenter$delegate) {
        return (Function1) $updatedSourceCenter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Function1<Density, Offset> invoke$lambda$4(State<? extends Function1<? super Density, Offset>> $updatedMagnifierCenter$delegate) {
        return (Function1) $updatedMagnifierCenter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$5(State<Float> $updatedZoom$delegate) {
        return ((Number) $updatedZoom$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final Function1<DpSize, Unit> invoke$lambda$6(State<? extends Function1<? super DpSize, Unit>> $updatedOnSizeChanged$delegate) {
        return (Function1) $updatedOnSizeChanged$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final long invoke$lambda$8(State<Offset> $sourceCenterInRoot$delegate) {
        return ((Offset) $sourceCenterInRoot$delegate.getValue()).m4723unboximpl();
    }

    /* access modifiers changed from: private */
    public static final boolean invoke$lambda$10(State<Boolean> $isMagnifierShown$delegate) {
        return ((Boolean) $isMagnifierShown$delegate.getValue()).booleanValue();
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", i = {0}, l = {363}, m = "invokeSuspend", n = {"magnifier"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1  reason: invalid class name */
    /* compiled from: Magnifier.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r1 = new AnonymousClass1(platformMagnifierFactory, magnifierStyle2, view2, density2, f, mutableSharedFlow, state2, state3, state4, state5, mutableState, state6, continuation);
            r1.L$0 = obj;
            return r1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: androidx.compose.foundation.PlatformMagnifier} */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ad, code lost:
            r3.dismiss();
            r0 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b3, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r19
                int r2 = r1.label
                switch(r2) {
                    case 0: goto L_0x0024;
                    case 1: goto L_0x0013;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0013:
                r1 = r19
                r2 = r20
                java.lang.Object r0 = r1.L$0
                r3 = r0
                androidx.compose.foundation.PlatformMagnifier r3 = (androidx.compose.foundation.PlatformMagnifier) r3
                kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0021 }
                goto L_0x00ad
            L_0x0021:
                r0 = move-exception
                goto L_0x00b6
            L_0x0024:
                kotlin.ResultKt.throwOnFailure(r20)
                r1 = r19
                r2 = r20
                java.lang.Object r3 = r1.L$0
                kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
                androidx.compose.foundation.PlatformMagnifierFactory r4 = r11
                androidx.compose.foundation.MagnifierStyle r5 = r12
                android.view.View r6 = r13
                androidx.compose.ui.unit.Density r7 = r14
                float r8 = r15
                androidx.compose.foundation.PlatformMagnifier r4 = r4.create(r5, r6, r7, r8)
                kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
                r5.<init>()
                long r6 = r4.m1966getSizeYbymL2g()
                androidx.compose.ui.unit.Density r8 = r14
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r9 = r17
                r10 = r6
                r12 = 0
                kotlin.jvm.functions.Function1 r9 = androidx.compose.foundation.MagnifierKt$magnifier$4.invoke$lambda$6(r9)
                if (r9 == 0) goto L_0x0065
                r13 = 0
                long r14 = androidx.compose.ui.unit.IntSizeKt.m7724toSizeozmzZPI(r10)
                long r10 = r8.m7533toDpSizekrfVVM(r14)
                androidx.compose.ui.unit.DpSize r8 = androidx.compose.ui.unit.DpSize.m7640boximpl(r10)
                r9.invoke(r8)
            L_0x0065:
                r5.element = r6
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r6 = r16
                kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$1 r7 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$1
                r8 = 0
                r7.<init>(r4, r8)
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.onEach(r6, r7)
                kotlinx.coroutines.flow.FlowKt.launchIn(r6, r3)
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$2 r3 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$2     // Catch:{ all -> 0x00b4 }
                androidx.compose.ui.unit.Density r11 = r14     // Catch:{ all -> 0x00b4 }
                androidx.compose.runtime.State<java.lang.Boolean> r12 = r18     // Catch:{ all -> 0x00b4 }
                androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> r13 = r19     // Catch:{ all -> 0x00b4 }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset>> r14 = r20     // Catch:{ all -> 0x00b4 }
                androidx.compose.runtime.MutableState<androidx.compose.ui.geometry.Offset> r15 = r21     // Catch:{ all -> 0x00b4 }
                androidx.compose.runtime.State<java.lang.Float> r6 = r22     // Catch:{ all -> 0x00b4 }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r7 = r17     // Catch:{ all -> 0x00b4 }
                r9 = r3
                r10 = r4
                r16 = r6
                r17 = r5
                r18 = r7
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00b4 }
                kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3     // Catch:{ all -> 0x00b4 }
                kotlinx.coroutines.flow.Flow r3 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r3)     // Catch:{ all -> 0x00b4 }
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x00b4 }
                r1.L$0 = r4     // Catch:{ all -> 0x00b4 }
                r5 = 1
                r1.label = r5     // Catch:{ all -> 0x00b4 }
                java.lang.Object r3 = kotlinx.coroutines.flow.FlowKt.collect(r3, r6)     // Catch:{ all -> 0x00b4 }
                if (r3 != r0) goto L_0x00ac
                return r0
            L_0x00ac:
                r3 = r4
            L_0x00ad:
                r3.dismiss()
                r0 = r3
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            L_0x00b4:
                r0 = move-exception
                r3 = r4
            L_0x00b6:
                r3.dismiss()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierKt$magnifier$4.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
