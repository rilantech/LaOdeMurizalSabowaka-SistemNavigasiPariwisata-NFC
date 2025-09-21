package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u0017\"\b\b\u0000\u0010\b*\u00020\u0002*\u00020\u0014H\u0002\u001aa\u0010\u0018\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r10, androidx.compose.ui.Modifier r11, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1783766393(0xffffffff95ade287, float:-7.023154E-26)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidView)105@5394L130:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r14
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0019
            r1 = r1 | 6
            goto L_0x0027
        L_0x0019:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0027
            boolean r2 = r13.changedInstance(r10)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r1 = r1 | r2
        L_0x0027:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x002e
            r1 = r1 | 48
            goto L_0x003e
        L_0x002e:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003e
            boolean r3 = r13.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x003b
            r3 = 32
            goto L_0x003d
        L_0x003b:
            r3 = 16
        L_0x003d:
            r1 = r1 | r3
        L_0x003e:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x0045
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0055
        L_0x0045:
            r4 = r14 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0055
            boolean r4 = r13.changedInstance(r12)
            if (r4 == 0) goto L_0x0052
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0054
        L_0x0052:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0054:
            r1 = r1 | r4
        L_0x0055:
            r9 = r1
            r1 = r9 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r1 != r4) goto L_0x0067
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            r13.skipToGroupEnd()
            goto L_0x00a4
        L_0x0067:
            if (r2 == 0) goto L_0x006e
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r11 = r1
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
        L_0x006e:
            if (r3 == 0) goto L_0x0072
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r12 = NoOpUpdate
        L_0x0072:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x007e
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:100)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x007e:
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r4 = NoOpUpdate
            r0 = r9 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r1 = r9 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            int r2 = r9 << 6
            r1 = r1 & r2
            r7 = r0 | r1
            r3 = 0
            r8 = 4
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            AndroidView(r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00a4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00a4:
            androidx.compose.runtime.ScopeUpdateScope r0 = r13.endRestartGroup()
            if (r0 != 0) goto L_0x00ab
            goto L_0x00bb
        L_0x00ab:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1 r7 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
            r1 = r7
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r14
            r6 = r15
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.updateScope(r7)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: kotlin.jvm.functions.Function1<? super T, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r28, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r29, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r26
            r9 = r32
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -180024211(0xfffffffff5450c6d, float:-2.497887E32)
            r1 = r31
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AndroidView)P(!2,3)209@11810L23,211@11934L7,212@11989L7,219@12445L7,220@12516L7:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r32
            r2 = r33 & 1
            if (r2 == 0) goto L_0x0020
            r1 = r1 | 6
            goto L_0x002e
        L_0x0020:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002e
            boolean r2 = r10.changedInstance(r8)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r1 = r1 | r2
        L_0x002e:
            r2 = r33 & 2
            if (r2 == 0) goto L_0x0037
            r1 = r1 | 48
            r3 = r27
            goto L_0x004c
        L_0x0037:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004a
            r3 = r27
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r1 = r1 | r4
            goto L_0x004c
        L_0x004a:
            r3 = r27
        L_0x004c:
            r4 = r33 & 4
            if (r4 == 0) goto L_0x0055
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r28
            goto L_0x006a
        L_0x0055:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0068
            r5 = r28
            boolean r6 = r10.changedInstance(r5)
            if (r6 == 0) goto L_0x0064
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r1 = r1 | r6
            goto L_0x006a
        L_0x0068:
            r5 = r28
        L_0x006a:
            r6 = r33 & 8
            if (r6 == 0) goto L_0x0073
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r29
            goto L_0x0088
        L_0x0073:
            r7 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0086
            r7 = r29
            boolean r11 = r10.changedInstance(r7)
            if (r11 == 0) goto L_0x0082
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r1 = r1 | r11
            goto L_0x0088
        L_0x0086:
            r7 = r29
        L_0x0088:
            r11 = r33 & 16
            if (r11 == 0) goto L_0x0091
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r12 = r30
            goto L_0x00a8
        L_0x0091:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00a6
            r12 = r30
            boolean r13 = r10.changedInstance(r12)
            if (r13 == 0) goto L_0x00a2
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r1 = r1 | r13
            goto L_0x00a8
        L_0x00a6:
            r12 = r30
        L_0x00a8:
            r13 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r13
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r14) goto L_0x00c1
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c1
        L_0x00b8:
            r10.skipToGroupEnd()
            r11 = r3
            r14 = r7
            r15 = r12
            r12 = r5
            goto L_0x0279
        L_0x00c1:
            if (r2 == 0) goto L_0x00c8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00c9
        L_0x00c8:
            r1 = r3
        L_0x00c9:
            if (r4 == 0) goto L_0x00cd
            r2 = 0
            goto L_0x00ce
        L_0x00cd:
            r2 = r5
        L_0x00ce:
            if (r6 == 0) goto L_0x00d3
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r3 = NoOpUpdate
            goto L_0x00d4
        L_0x00d3:
            r3 = r7
        L_0x00d4:
            if (r11 == 0) goto L_0x00d9
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r4 = NoOpUpdate
            r12 = r4
        L_0x00d9:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x00e5
            r4 = -1
            java.lang.String r5 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:202)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r4, r5)
        L_0x00e5:
            r0 = 0
            int r4 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r0)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.ComposedModifierKt.materializeModifier(r10, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 6
            r11 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r14, r15)
            java.lang.Object r16 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r6 = r16
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r11 = 6
            r16 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r14, r15)
            java.lang.Object r17 = r10.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r7 = r17
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.CompositionLocalMap r11 = r10.getCurrentCompositionLocalMap()
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r14, r15)
            java.lang.Object r18 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r0 = r18
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r16 = 6
            r17 = 0
            r31 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r15)
            java.lang.Object r1 = r10.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.savedstate.SavedStateRegistryOwner r1 = (androidx.savedstate.SavedStateRegistryOwner) r1
            if (r2 == 0) goto L_0x01e9
            r14 = -88753439(0xfffffffffab5bae1, float:-4.7179804E35)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "224@12626L37,223@12560L843"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r14 = r13 & 14
            kotlin.jvm.functions.Function0 r14 = createAndroidViewNodeFactory(r8, r10, r14)
            r15 = r14
            r14 = 0
            r22 = r14
            r23 = 0
            r14 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            androidx.compose.runtime.Applier r14 = r10.getApplier()
            boolean r14 = r14 instanceof androidx.compose.ui.node.UiApplier
            if (r14 != 0) goto L_0x018b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x018b:
            r10.startReusableNode()
            boolean r14 = r10.getInserting()
            if (r14 == 0) goto L_0x019f
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1 r14 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1
            r14.<init>(r15)
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r10.createNode(r14)
            goto L_0x01a2
        L_0x019f:
            r10.useNode()
        L_0x01a2:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2865constructorimpl(r10)
            r24 = 0
            r27 = r14
            r25 = r15
            r15 = r5
            r16 = r4
            r17 = r6
            r18 = r0
            r19 = r1
            r20 = r7
            r21 = r11
            m6082updateViewHolderParams6NefGtU(r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1 r14 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1.INSTANCE
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = r27
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r2, r14)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2 r14 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2.INSTANCE
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r12, r14)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3 r14 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3.INSTANCE
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r3, r14)
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            goto L_0x026b
        L_0x01e9:
            r14 = -88752574(0xfffffffffab5be42, float:-4.718323E35)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "242@13483L37,241@13425L756"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r14 = r13 & 14
            kotlin.jvm.functions.Function0 r14 = createAndroidViewNodeFactory(r8, r10, r14)
            r15 = r14
            r14 = 0
            r22 = r14
            r23 = 0
            r14 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            androidx.compose.runtime.Applier r14 = r10.getApplier()
            boolean r14 = r14 instanceof androidx.compose.ui.node.UiApplier
            if (r14 != 0) goto L_0x0216
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0216:
            r10.startNode()
            boolean r14 = r10.getInserting()
            if (r14 == 0) goto L_0x022a
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 r14 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
            r14.<init>(r15)
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r10.createNode(r14)
            goto L_0x022d
        L_0x022a:
            r10.useNode()
        L_0x022d:
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2865constructorimpl(r10)
            r24 = 0
            r27 = r14
            r25 = r15
            r15 = r5
            r16 = r4
            r17 = r6
            r18 = r0
            r19 = r1
            r20 = r7
            r21 = r11
            m6082updateViewHolderParams6NefGtU(r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1 r14 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1.INSTANCE
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = r27
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r12, r14)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2 r14 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2.INSTANCE
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            androidx.compose.runtime.Updater.m2872setimpl((androidx.compose.runtime.Composer) r15, r3, r14)
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
        L_0x026b:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0274
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0274:
            r11 = r31
            r14 = r3
            r15 = r12
            r12 = r2
        L_0x0279:
            androidx.compose.runtime.ScopeUpdateScope r7 = r10.endRestartGroup()
            if (r7 != 0) goto L_0x0280
            goto L_0x0299
        L_0x0280:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r16 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r0 = r16
            r1 = r26
            r2 = r11
            r3 = r12
            r4 = r14
            r5 = r15
            r6 = r32
            r8 = r7
            r7 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(Function1<? super Context, ? extends T> factory, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(2030558801);
        ComposerKt.sourceInformation($composer, "C(createAndroidViewNodeFactory)264@14333L23,265@14388L7,266@14422L28,267@14502L7:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, $changed, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:261)");
        }
        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionContext parentReference = ComposablesKt.rememberCompositionContext($composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function0<LayoutNode> androidView_androidKt$createAndroidViewNodeFactory$1 = new AndroidView_androidKt$createAndroidViewNodeFactory$1((Context) consume, factory, parentReference, (SaveableStateRegistry) consume2, compositeKeyHash);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return androidView_androidKt$createAndroidViewNodeFactory$1;
    }

    /* renamed from: updateViewHolderParams-6NefGtU  reason: not valid java name */
    private static final <T extends View> void m6082updateViewHolderParams6NefGtU(Composer $this$updateViewHolderParams_u2d6NefGtU, Modifier modifier, int compositeKeyHash, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        Updater.m2872setimpl($this$updateViewHolderParams_u2d6NefGtU, compositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m2872setimpl($this$updateViewHolderParams_u2d6NefGtU, modifier, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.m2872setimpl($this$updateViewHolderParams_u2d6NefGtU, density, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.m2872setimpl($this$updateViewHolderParams_u2d6NefGtU, lifecycleOwner, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.m2872setimpl($this$updateViewHolderParams_u2d6NefGtU, savedStateRegistryOwner, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.m2872setimpl($this$updateViewHolderParams_u2d6NefGtU, layoutDirection, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
        Function2 block$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
        Composer $this$set_impl_u24lambda_u240$iv = $this$updateViewHolderParams_u2d6NefGtU;
        if ($this$set_impl_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$set_impl_u24lambda_u240$iv.rememberedValue(), (Object) Integer.valueOf(compositeKeyHash))) {
            $this$set_impl_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash));
            $this$updateViewHolderParams_u2d6NefGtU.apply(Integer.valueOf(compositeKeyHash), block$iv);
        }
    }

    /* access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode $this$requireViewFactoryHolder) {
        AndroidViewHolder interopViewFactoryHolder$ui_release = $this$requireViewFactoryHolder.getInteropViewFactoryHolder$ui_release();
        if (interopViewFactoryHolder$ui_release != null) {
            Intrinsics.checkNotNull(interopViewFactoryHolder$ui_release, "null cannot be cast to non-null type androidx.compose.ui.viewinterop.ViewFactoryHolder<T of androidx.compose.ui.viewinterop.AndroidView_androidKt.requireViewFactoryHolder>");
            return (ViewFactoryHolder) interopViewFactoryHolder$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
