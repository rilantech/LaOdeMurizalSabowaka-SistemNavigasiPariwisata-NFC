package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002X\u0002"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
public final class CrossfadeKt {
    public static final <T> void Crossfade(T targetState, Modifier modifier, FiniteAnimationSpec<Float> animationSpec, String label, Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        String label2;
        String label3;
        FiniteAnimationSpec animationSpec2;
        Modifier modifier3;
        T t = targetState;
        Function3<? super T, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-310686752);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(4,3!1,2)55@2280L36,56@2332L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed((Object) t) ? 4 : 2;
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
            $dirty |= 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            label2 = label;
        } else if ((i2 & 7168) == 0) {
            label2 = label;
            $dirty |= $composer2.changed((Object) label2) ? 2048 : 1024;
        } else {
            label2 = label;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((i2 & 57344) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (i4 == 4 && (46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec2 = animationSpec;
            modifier3 = modifier2;
            label3 = label2;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                animationSpec2 = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            } else {
                animationSpec2 = animationSpec;
            }
            if (i5 != 0) {
                label2 = "Crossfade";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-310686752, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:48)");
            }
            label3 = label2;
            Crossfade(TransitionKt.updateTransition(t, label2, $composer2, ($dirty2 & 8) | ($dirty2 & 14) | (($dirty2 >> 6) & 112), 0), modifier3, (FiniteAnimationSpec<Float>) animationSpec2, (Function1) null, content, $composer2, ($dirty2 & 112) | 512 | ($dirty2 & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CrossfadeKt$Crossfade$1(targetState, modifier3, animationSpec2, label3, content, $changed, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(Object targetState, Modifier modifier, FiniteAnimationSpec animationSpec, Function3 content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        FiniteAnimationSpec animationSpec2;
        Modifier modifier3;
        Object obj = targetState;
        Function3 function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3,2)71@2743L29,72@2788L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(obj) ? 4 : 2;
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
            $dirty |= 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (i4 == 4 && ($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec2 = animationSpec;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                animationSpec2 = AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null);
            } else {
                animationSpec2 = animationSpec;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, $dirty, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:65)");
            }
            Crossfade(TransitionKt.updateTransition(obj, (String) null, $composer2, ($dirty & 8) | ($dirty & 14), 2), modifier3, (FiniteAnimationSpec<Float>) animationSpec2, (Function1) null, content, $composer2, ($dirty & 112) | 512 | (($dirty << 3) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i5 = $dirty;
            Composer composer = $composer2;
            return;
        }
        int i6 = $dirty;
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new CrossfadeKt$Crossfade$2(targetState, modifier2, animationSpec2, content, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0424  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void Crossfade(androidx.compose.animation.core.Transition<T> r35, androidx.compose.ui.Modifier r36, androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r37, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> r38, kotlin.jvm.functions.Function3<? super T, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r8 = r35
            r9 = r39
            r10 = r41
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 679005231(0x2878cc2f, float:1.3811041E-14)
            r1 = r40
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Crossfade)P(3!1,2)103@4375L64,104@4461L66,138@5750L159:Crossfade.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r41
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r42 & r2
            r3 = 2
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = r3
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r42 & 1
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r4 = r36
            goto L_0x0056
        L_0x0041:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0054
            r4 = r36
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0050
            r5 = 32
            goto L_0x0052
        L_0x0050:
            r5 = 16
        L_0x0052:
            r1 = r1 | r5
            goto L_0x0056
        L_0x0054:
            r4 = r36
        L_0x0056:
            r5 = r42 & 2
            if (r5 == 0) goto L_0x005c
            r1 = r1 | 128(0x80, float:1.794E-43)
        L_0x005c:
            r6 = r42 & 4
            if (r6 == 0) goto L_0x0065
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r38
            goto L_0x007a
        L_0x0065:
            r7 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0078
            r7 = r38
            boolean r12 = r11.changedInstance(r7)
            if (r12 == 0) goto L_0x0074
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r1 = r1 | r12
            goto L_0x007a
        L_0x0078:
            r7 = r38
        L_0x007a:
            r12 = r42 & 8
            if (r12 == 0) goto L_0x0081
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0093
        L_0x0081:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x0093
            boolean r12 = r11.changedInstance(r9)
            if (r12 == 0) goto L_0x0090
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r1 = r1 | r12
        L_0x0093:
            r12 = r1
            if (r5 != r3) goto L_0x00ae
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r12
            r3 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r3) goto L_0x00ae
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x00a5
            goto L_0x00ae
        L_0x00a5:
            r11.skipToGroupEnd()
            r15 = r37
            r13 = r4
            r8 = r7
            goto L_0x0428
        L_0x00ae:
            if (r2 == 0) goto L_0x00b6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00b7
        L_0x00b6:
            r13 = r4
        L_0x00b7:
            r14 = 0
            if (r5 == 0) goto L_0x00c4
            r1 = 7
            r2 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r14, r14, r2, r1, r2)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            r15 = r1
            goto L_0x00c6
        L_0x00c4:
            r15 = r37
        L_0x00c6:
            if (r6 == 0) goto L_0x00cd
            androidx.compose.animation.CrossfadeKt$Crossfade$3 r1 = androidx.compose.animation.CrossfadeKt$Crossfade$3.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r7 = r1
        L_0x00cd:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r2 = -1
            if (r1 == 0) goto L_0x00d9
            java.lang.String r1 = "androidx.compose.animation.Crossfade (Crossfade.kt:97)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r2, r1)
        L_0x00d9:
            r0 = r14
            r1 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r3)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r5 = 0
            r6 = r11
            r16 = 0
            java.lang.Object r2 = r6.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r2 != r3) goto L_0x0114
            r3 = 0
            androidx.compose.runtime.snapshots.SnapshotStateList r18 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r38 = r18
            r19 = 0
            java.lang.Object r14 = r35.getCurrentState()
            r20 = r0
            r0 = r38
            r0.add(r14)
            r0 = r18
            r6.updateRememberedValue(r0)
            goto L_0x0117
        L_0x0114:
            r20 = r0
            r0 = r2
        L_0x0117:
            r11.endReplaceableGroup()
            r6 = r0
            androidx.compose.runtime.snapshots.SnapshotStateList r6 = (androidx.compose.runtime.snapshots.SnapshotStateList) r6
            r0 = 0
            r1 = r0
            r0 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            r2 = 0
            r3 = r11
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r14 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r37 = r0
            java.lang.Object r0 = r16.getEmpty()
            if (r5 != r0) goto L_0x014c
            r0 = 0
            java.util.LinkedHashMap r16 = new java.util.LinkedHashMap
            r16.<init>()
            java.util.Map r16 = (java.util.Map) r16
            r0 = r16
            r3.updateRememberedValue(r0)
            goto L_0x014d
        L_0x014c:
            r0 = r5
        L_0x014d:
            r11.endReplaceableGroup()
            r14 = r0
            java.util.Map r14 = (java.util.Map) r14
            r0 = -1621449213(0xffffffff9f5aa603, float:-4.6300617E-20)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "111@4841L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            java.lang.Object r0 = r35.getCurrentState()
            java.lang.Object r1 = r35.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r5 = 1
            if (r0 == 0) goto L_0x01cf
            int r0 = r6.size()
            if (r0 != r5) goto L_0x0184
            r0 = 0
            java.lang.Object r1 = r6.get(r0)
            java.lang.Object r0 = r35.getTargetState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x01cf
        L_0x0184:
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r1 = r12 & 14
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            boolean r3 = r11.changed((java.lang.Object) r8)
            r4 = r11
            r16 = 0
            java.lang.Object r5 = r4.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x01b1
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r38 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r5 != r1) goto L_0x01af
            goto L_0x01b3
        L_0x01af:
            r1 = r5
            goto L_0x01c2
        L_0x01b1:
            r38 = r1
        L_0x01b3:
            r1 = 0
            r18 = r1
            androidx.compose.animation.CrossfadeKt$Crossfade$4$1 r1 = new androidx.compose.animation.CrossfadeKt$Crossfade$4$1
            r1.<init>(r8)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4.updateRememberedValue(r1)
        L_0x01c2:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.collections.CollectionsKt.removeAll(r0, r1)
            r14.clear()
        L_0x01cf:
            r11.endReplaceableGroup()
            java.lang.Object r0 = r35.getTargetState()
            boolean r0 = r14.containsKey(r0)
            if (r0 != 0) goto L_0x027e
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            r2 = 0
            java.util.Iterator r3 = r0.iterator()
        L_0x01e5:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0211
            java.lang.Object r4 = r3.next()
            r5 = r4
            r16 = 0
            r38 = r0
            java.lang.Object r0 = r7.invoke(r5)
            r17 = r1
            java.lang.Object r1 = r35.getTargetState()
            java.lang.Object r1 = r7.invoke(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0209
            goto L_0x0216
        L_0x0209:
            int r2 = r2 + 1
            r0 = r38
            r1 = r17
            goto L_0x01e5
        L_0x0211:
            r38 = r0
            r17 = r1
            r2 = -1
        L_0x0216:
            r5 = r2
            r0 = -1
            if (r5 != r0) goto L_0x0222
            java.lang.Object r0 = r35.getTargetState()
            r6.add(r0)
            goto L_0x0229
        L_0x0222:
            java.lang.Object r0 = r35.getTargetState()
            r6.set(r5, r0)
        L_0x0229:
            r14.clear()
            r4 = r6
            java.util.List r4 = (java.util.List) r4
            r16 = 0
            r0 = 0
            int r3 = r4.size()
            r2 = r0
        L_0x0238:
            if (r2 >= r3) goto L_0x0277
            java.lang.Object r17 = r4.get(r2)
            r1 = r17
            r18 = 0
            androidx.compose.animation.CrossfadeKt$Crossfade$5$1 r0 = new androidx.compose.animation.CrossfadeKt$Crossfade$5$1
            r36 = r0
            r38 = r1
            r1 = r35
            r19 = r2
            r2 = r12
            r20 = r3
            r3 = r15
            r21 = r4
            r4 = r38
            r22 = r5
            r8 = 1
            r5 = r39
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = -1426421288(0xffffffffaafa89d8, float:-4.450457E-13)
            r1 = r36
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r0, r8, r1)
            r1 = r38
            r14.put(r1, r0)
            int r2 = r19 + 1
            r8 = r35
            r3 = r20
            r4 = r21
            r5 = r22
            goto L_0x0238
        L_0x0277:
            r19 = r2
            r21 = r4
            r22 = r5
        L_0x027e:
            int r0 = r12 >> 3
            r0 = r0 & 14
            r1 = 0
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r3 = 0
            int r4 = r0 >> 3
            r4 = r4 & 14
            int r5 = r0 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r3, r11, r4)
            int r5 = r0 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r8 = 0
            r36 = r1
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = 0
            int r16 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r11, r1)
            androidx.compose.runtime.CompositionLocalMap r1 = r11.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r17 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r18 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r13)
            r37 = r2
            int r2 = r5 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r38 = r18
            r18 = r17
            r17 = 0
            r19 = r3
            androidx.compose.runtime.Applier r3 = r11.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x02e5
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02e5:
            r11.startReusableNode()
            boolean r3 = r11.getInserting()
            if (r3 == 0) goto L_0x02f4
            r3 = r18
            r11.createNode(r3)
            goto L_0x02f9
        L_0x02f4:
            r3 = r18
            r11.useNode()
        L_0x02f9:
            r18 = r3
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m4575constructorimpl(r11)
            r20 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            r22 = r5
            kotlin.jvm.functions.Function2 r5 = r21.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m4582setimpl((androidx.compose.runtime.Composer) r3, r1, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetCompositeKeyHash()
            r21 = 0
            r23 = r3
            r24 = 0
            boolean r25 = r23.getInserting()
            if (r25 != 0) goto L_0x033d
            r25 = r1
            java.lang.Object r1 = r23.rememberedValue()
            r26 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 != 0) goto L_0x033a
            goto L_0x0341
        L_0x033a:
            r4 = r23
            goto L_0x0351
        L_0x033d:
            r25 = r1
            r26 = r4
        L_0x0341:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            r4 = r23
            r4.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            r3.apply(r1, r5)
        L_0x0351:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m4567constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m4566boximpl(r1)
            int r3 = r2 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r38
            r4.invoke(r1, r11, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r1)
            int r1 = r2 >> 9
            r1 = r1 & 14
            r3 = r11
            r5 = 0
            r38 = r1
            r1 = -1253629358(0xffffffffb5472252, float:-7.418322E-7)
            r20 = r2
            java.lang.String r2 = "C71@3331L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r1, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r0 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r21 = r3
            r23 = 0
            r24 = r0
            r0 = 2072161918(0x7b82ae7e, float:1.3570754E36)
            r27 = r1
            java.lang.String r1 = "C:Crossfade.kt#xbi5r1"
            r28 = r2
            r2 = r21
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            r0 = -1621447954(0xffffffff9f5aaaee, float:-4.6304685E-20)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = ""
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            r21 = 0
            r29 = r1
            int r1 = r0.size()
            r30 = r4
            r4 = r21
        L_0x03bd:
            if (r4 >= r1) goto L_0x03ff
            java.lang.Object r21 = r0.get(r4)
            r31 = r21
            r32 = 0
            r33 = r0
            r0 = r31
            r31 = r1
            java.lang.Object r1 = r7.invoke(r0)
            r34 = r5
            r5 = -450541366(0xffffffffe52548ca, float:-4.8783324E22)
            r2.startMovableGroup(r5, r1)
            java.lang.String r1 = "141@5871L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            java.lang.Object r1 = r14.get(r0)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r40 = r0
            r5 = 0
            if (r1 != 0) goto L_0x03ea
            goto L_0x03f1
        L_0x03ea:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r1.invoke(r2, r0)
        L_0x03f1:
            r2.endMovableGroup()
            int r4 = r4 + 1
            r1 = r31
            r0 = r33
            r5 = r34
            goto L_0x03bd
        L_0x03ff:
            r33 = r0
            r34 = r5
            r2.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0427
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0427:
            r8 = r7
        L_0x0428:
            androidx.compose.runtime.ScopeUpdateScope r14 = r11.endRestartGroup()
            if (r14 != 0) goto L_0x042f
            goto L_0x0448
        L_0x042f:
            androidx.compose.animation.CrossfadeKt$Crossfade$7 r16 = new androidx.compose.animation.CrossfadeKt$Crossfade$7
            r0 = r16
            r1 = r35
            r2 = r13
            r3 = r15
            r4 = r8
            r5 = r39
            r6 = r41
            r7 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x0448:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.CrossfadeKt.Crossfade(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, androidx.compose.animation.core.FiniteAnimationSpec, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
