package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.google.android.gms.location.DeviceOrientationRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material/SnackbarHostState;", "snackbar", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void SnackbarHost(SnackbarHostState hostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> snackbar, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Function3 function3;
        Function3 snackbar2;
        Modifier modifier3;
        Modifier modifier4;
        SnackbarHostState snackbarHostState = hostState;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(snackbarHostState, "hostState");
        Composer $composer2 = $composer.startRestartGroup(431012348);
        ComposerKt.sourceInformation($composer2, "C(SnackbarHost)156@6461L7,157@6473L340,167@6818L134:SnackbarHost.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) snackbarHostState) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function3 = snackbar;
        } else if ((i2 & 896) == 0) {
            function3 = snackbar;
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = snackbar;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            Function3 snackbar3 = i4 != 0 ? ComposableSingletons$SnackbarHostKt.INSTANCE.m2981getLambda1$material_release() : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431012348, $dirty2, -1, "androidx.compose.material.SnackbarHost (SnackbarHost.kt:150)");
            }
            SnackbarData currentSnackbarData = hostState.getCurrentSnackbarData();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalAccessibilityManager());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect((Object) currentSnackbarData, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$SnackbarHost$1(currentSnackbarData, (AccessibilityManager) consume, (Continuation<? super SnackbarHostKt$SnackbarHost$1>) null), $composer2, 64);
            FadeInFadeOutWithScale(hostState.getCurrentSnackbarData(), modifier4, snackbar3, $composer2, ($dirty2 & 112) | ($dirty2 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            snackbar2 = snackbar3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            snackbar2 = function3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarHostKt$SnackbarHost$2(hostState, modifier3, snackbar2, $changed, i));
        }
    }

    public static final long toMillis(SnackbarDuration $this$toMillis, boolean hasAction, AccessibilityManager accessibilityManager) {
        long original;
        Intrinsics.checkNotNullParameter($this$toMillis, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toMillis.ordinal()]) {
            case 1:
                original = Long.MAX_VALUE;
                break;
            case 2:
                original = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
                break;
            case 3:
                original = 4000;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (accessibilityManager == null) {
            return original;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(original, true, true, hasAction);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02a6 A[LOOP:2: B:75:0x02a4->B:76:0x02a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x031c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FadeInFadeOutWithScale(androidx.compose.material.SnackbarData r37, androidx.compose.ui.Modifier r38, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r6 = r37
            r7 = r39
            r8 = r41
            r0 = 2036134589(0x795cf2bd, float:7.170179E34)
            r1 = r40
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FadeInFadeOutWithScale)P(1,2)261@9210L48,315@11457L246:SnackbarHost.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r41
            r2 = r42 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            goto L_0x002b
        L_0x001d:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r9.changed((java.lang.Object) r6)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
        L_0x002b:
            r2 = r42 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            r3 = r38
            goto L_0x0049
        L_0x0034:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0047
            r3 = r38
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r38
        L_0x0049:
            r4 = r42 & 4
            if (r4 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x0050:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0060
            boolean r4 = r9.changedInstance(r7)
            if (r4 == 0) goto L_0x005d
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r4
        L_0x0060:
            r10 = r1
            r1 = r10 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r1 != r4) goto L_0x0075
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            r9.skipToGroupEnd()
            r17 = r3
            goto L_0x031f
        L_0x0075:
            if (r2 == 0) goto L_0x007c
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x007d
        L_0x007c:
            r1 = r3
        L_0x007d:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0089
            r2 = -1
            java.lang.String r3 = "androidx.compose.material.FadeInFadeOutWithScale (SnackbarHost.kt:256)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r2, r3)
        L_0x0089:
            r0 = 0
            r2 = r0
            r3 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            r4 = 0
            r5 = r9
            r11 = 0
            java.lang.Object r12 = r5.rememberedValue()
            r13 = 0
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r12 != r14) goto L_0x00b4
            r14 = 0
            androidx.compose.material.FadeInFadeOutState r15 = new androidx.compose.material.FadeInFadeOutState
            r15.<init>()
            r14 = r15
            r5.updateRememberedValue(r14)
            goto L_0x00b5
        L_0x00b4:
            r14 = r12
        L_0x00b5:
            r9.endReplaceableGroup()
            r2 = r14
            androidx.compose.material.FadeInFadeOutState r2 = (androidx.compose.material.FadeInFadeOutState) r2
            java.lang.Object r3 = r2.getCurrent()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x0164
            r2.setCurrent(r6)
            java.util.List r3 = r2.getItems()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r5 = 0
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r12)
            r11.<init>(r12)
            java.util.Collection r11 = (java.util.Collection) r11
            r12 = r3
            r13 = 0
            java.util.Iterator r14 = r12.iterator()
        L_0x00e4:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0101
            java.lang.Object r15 = r14.next()
            r16 = r15
            androidx.compose.material.FadeInFadeOutAnimationItem r16 = (androidx.compose.material.FadeInFadeOutAnimationItem) r16
            r17 = 0
            java.lang.Object r18 = r16.getKey()
            r0 = r18
            androidx.compose.material.SnackbarData r0 = (androidx.compose.material.SnackbarData) r0
            r11.add(r0)
            r0 = 0
            goto L_0x00e4
        L_0x0101:
            r0 = r11
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            boolean r3 = r0.contains(r6)
            if (r3 != 0) goto L_0x0115
            r0.add(r6)
        L_0x0115:
            java.util.List r3 = r2.getItems()
            r3.clear()
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.filterNotNull(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r5 = r2.getItems()
            java.util.Collection r5 = (java.util.Collection) r5
            r11 = 0
            java.util.Iterator r12 = r3.iterator()
        L_0x0130:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0160
            java.lang.Object r13 = r12.next()
            r14 = r13
            androidx.compose.material.SnackbarData r14 = (androidx.compose.material.SnackbarData) r14
            r15 = 0
            androidx.compose.material.FadeInFadeOutAnimationItem r4 = new androidx.compose.material.FadeInFadeOutAnimationItem
            r16 = r3
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1 r3 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1
            r3.<init>(r14, r6, r0, r2)
            r17 = r0
            r0 = -94104314(0xfffffffffa641506, float:-2.9606752E35)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r6, r3)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r4.<init>(r14, r0)
            r5.add(r4)
            r6 = r37
            r3 = r16
            r0 = r17
            goto L_0x0130
        L_0x0160:
            r17 = r0
            r16 = r3
        L_0x0164:
            int r0 = r10 >> 3
            r0 = r0 & 14
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r5 = 0
            int r6 = r0 >> 3
            r6 = r6 & 14
            int r11 = r0 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r6 = r6 | r11
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r5, r9, r6)
            int r11 = r0 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 0
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r13)
            java.lang.String r13 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r13)
            r13 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r13)
            androidx.compose.runtime.CompositionLocalMap r13 = r9.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r16 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r1)
            r17 = r1
            int r1 = r11 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r18 = 6
            r1 = r1 | 6
            r19 = r16
            r16 = 0
            r20 = r3
            androidx.compose.runtime.Applier r3 = r9.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x01c9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01c9:
            r9.startReusableNode()
            boolean r3 = r9.getInserting()
            if (r3 == 0) goto L_0x01d6
            r9.createNode(r15)
            goto L_0x01d9
        L_0x01d6:
            r9.useNode()
        L_0x01d9:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r9)
            r21 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r4
            kotlin.jvm.functions.Function2 r4 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r6, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r13, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetCompositeKeyHash()
            r22 = 0
            r24 = r3
            r25 = 0
            boolean r26 = r24.getInserting()
            if (r26 != 0) goto L_0x021b
            r26 = r5
            java.lang.Object r5 = r24.rememberedValue()
            r27 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x0218
            goto L_0x021f
        L_0x0218:
            r6 = r24
            goto L_0x022f
        L_0x021b:
            r26 = r5
            r27 = r6
        L_0x021f:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r6 = r24
            r6.updateRememberedValue(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r3.apply(r5, r4)
        L_0x022f:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r3)
            int r4 = r1 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = r19
            r5.invoke(r3, r9, r4)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r3)
            int r3 = r1 >> 9
            r3 = r3 & 14
            r4 = r9
            r6 = 0
            r19 = r1
            r1 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r21 = r3
            java.lang.String r3 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r1, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r0 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r22 = r4
            r24 = 0
            r25 = r0
            r0 = -1050268607(0xffffffffc1662c41, float:-14.385804)
            r28 = r1
            java.lang.String r1 = "C316@11495L21:SnackbarHost.kt#jmzs0o"
            r29 = r3
            r3 = r22
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r1)
            r0 = 0
            androidx.compose.runtime.RecomposeScope r0 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r3, r0)
            r2.setScope(r0)
            r0 = -1656513320(0xffffffff9d439cd8, float:-2.5889121E-21)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            java.util.List r0 = r2.getItems()
            r1 = 0
            r22 = 0
            r38 = r1
            int r1 = r0.size()
            r30 = r2
            r2 = r22
        L_0x02a4:
            if (r2 >= r1) goto L_0x02f5
            java.lang.Object r22 = r0.get(r2)
            r31 = r22
            androidx.compose.material.FadeInFadeOutAnimationItem r31 = (androidx.compose.material.FadeInFadeOutAnimationItem) r31
            r32 = 0
            java.lang.Object r33 = r31.component1()
            r34 = r0
            r0 = r33
            androidx.compose.material.SnackbarData r0 = (androidx.compose.material.SnackbarData) r0
            r33 = r1
            kotlin.jvm.functions.Function3 r1 = r31.component2()
            r31 = r5
            r5 = -208579897(0xfffffffff39152c7, float:-2.3027404E31)
            r3.startMovableGroup(r5, r0)
            java.lang.String r5 = "319@11610L63"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r5)
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 r5 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
            r5.<init>(r7, r0, r10)
            r35 = r0
            r0 = 2041982076(0x79b62c7c, float:1.1823753E35)
            r36 = r6
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r0, r6, r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r18)
            r1.invoke(r0, r3, r5)
            r3.endMovableGroup()
            int r2 = r2 + 1
            r5 = r31
            r1 = r33
            r0 = r34
            r6 = r36
            goto L_0x02a4
        L_0x02f5:
            r34 = r0
            r31 = r5
            r36 = r6
            r3.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x031f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031f:
            androidx.compose.runtime.ScopeUpdateScope r6 = r9.endRestartGroup()
            if (r6 != 0) goto L_0x0326
            goto L_0x033b
        L_0x0326:
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3 r11 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3
            r0 = r11
            r1 = r37
            r2 = r17
            r3 = r39
            r4 = r41
            r5 = r42
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r6.updateScope(r11)
        L_0x033b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.FadeInFadeOutWithScale(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animation, boolean visible, Function0<Unit> onAnimationFinish, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1016418159);
        ComposerKt.sourceInformation(composer, "C(animatedOpacity)P(!1,2)347@12351L49,348@12405L169:SnackbarHost.kt#jmzs0o");
        Function0 onAnimationFinish2 = (i & 4) != 0 ? SnackbarHostKt$animatedOpacity$1.INSTANCE : onAnimationFinish;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1016418159, i2, -1, "androidx.compose.material.animatedOpacity (SnackbarHost.kt:342)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.0f, 0.0f, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Animatable alpha = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(visible), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedOpacity$2(alpha, visible, animation, onAnimationFinish2, (Continuation<? super SnackbarHostKt$animatedOpacity$2>) null), composer, ((i2 >> 3) & 14) | 64);
        State<Float> asState = alpha.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animation, boolean visible, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(2003504988);
        ComposerKt.sourceInformation($composer, "C(animatedScale)360@12726L51,361@12782L143:SnackbarHost.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2003504988, $changed, -1, "androidx.compose.material.animatedScale (SnackbarHost.kt:359)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.8f, 0.0f, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Animatable scale = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(visible), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedScale$1(scale, visible, animation, (Continuation<? super SnackbarHostKt$animatedScale$1>) null), $composer, (($changed >> 3) & 14) | 64);
        State<Float> asState = scale.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }
}
