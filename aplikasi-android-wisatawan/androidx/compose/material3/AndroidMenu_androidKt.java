package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
public final class AndroidMenu_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e5  */
    /* renamed from: DropdownMenu-ILWXrKs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1535DropdownMenuILWXrKs(boolean r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, long r37, androidx.compose.ui.window.PopupProperties r39, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r10 = r35
            r11 = r40
            r12 = r42
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 354826666(0x152639aa, float:3.3568922E-26)
            r1 = r41
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)81@4015L42,85@4205L51,86@4292L7,90@4416L131,94@4557L400:AndroidMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r42
            r2 = r43 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r14 = r34
            goto L_0x003d
        L_0x002a:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x003b
            r14 = r34
            boolean r2 = r13.changed((boolean) r14)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r14 = r34
        L_0x003d:
            r2 = r43 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r13.changedInstance(r10)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r43 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r36
            goto L_0x0072
        L_0x005d:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0070
            r4 = r36
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r5
            goto L_0x0072
        L_0x0070:
            r4 = r36
        L_0x0072:
            r5 = r43 & 8
            if (r5 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r37
            goto L_0x0090
        L_0x007b:
            r6 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008e
            r6 = r37
            boolean r8 = r13.changed((long) r6)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r6 = r37
        L_0x0090:
            r8 = r43 & 16
            if (r8 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r39
            goto L_0x00b0
        L_0x0099:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r12
            if (r9 != 0) goto L_0x00ae
            r9 = r39
            boolean r15 = r13.changed((java.lang.Object) r9)
            if (r15 == 0) goto L_0x00aa
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r15
            goto L_0x00b0
        L_0x00ae:
            r9 = r39
        L_0x00b0:
            r15 = r43 & 32
            if (r15 == 0) goto L_0x00b8
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b6:
            r1 = r1 | r15
            goto L_0x00c9
        L_0x00b8:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00c9
            boolean r15 = r13.changedInstance(r11)
            if (r15 == 0) goto L_0x00c6
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00c6:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b6
        L_0x00c9:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r3 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r3) goto L_0x00e5
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x00da
            goto L_0x00e5
        L_0x00da:
            r13.skipToGroupEnd()
            r16 = r4
            r23 = r6
            r17 = r9
            goto L_0x0287
        L_0x00e5:
            if (r2 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00f0
        L_0x00ee:
            r16 = r4
        L_0x00f0:
            if (r5 == 0) goto L_0x0107
            r1 = 0
            r2 = 0
            float r3 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r3)
            r2 = 0
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5844constructorimpl(r4)
            long r1 = androidx.compose.ui.unit.DpKt.m5865DpOffsetYgX7TsA(r1, r2)
            r23 = r1
            goto L_0x0109
        L_0x0107:
            r23 = r6
        L_0x0109:
            if (r8 == 0) goto L_0x0123
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r32 = 62
            r33 = 0
            r26 = 1
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r25 = r1
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33)
            r9 = r1
        L_0x0123:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x012f
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x012f:
            r0 = 0
            r1 = r0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r3)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r5 = 0
            r6 = r13
            r7 = 0
            java.lang.Object r8 = r6.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r8 != r3) goto L_0x0163
            r3 = 0
            r37 = r1
            androidx.compose.animation.core.MutableTransitionState r1 = new androidx.compose.animation.core.MutableTransitionState
            r38 = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            r1.<init>(r2)
            r6.updateRememberedValue(r1)
            goto L_0x0168
        L_0x0163:
            r37 = r1
            r38 = r2
            r1 = r8
        L_0x0168:
            r13.endReplaceableGroup()
            r7 = r1
            androidx.compose.animation.core.MutableTransitionState r7 = (androidx.compose.animation.core.MutableTransitionState) r7
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r34)
            r7.setTargetState(r1)
            java.lang.Object r1 = r7.getCurrentState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0194
            java.lang.Object r1 = r7.getTargetState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0190
            goto L_0x0194
        L_0x0190:
            r36 = r7
            goto L_0x027c
        L_0x0194:
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r2 = 0
            r3 = r13
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x01cc
            r8 = 0
            androidx.compose.ui.graphics.TransformOrigin$Companion r17 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r17 = r17.m3680getCenterSzJe1aQ()
            r36 = r0
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3667boximpl(r17)
            r37 = r1
            r1 = 0
            r38 = r2
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r3.updateRememberedValue(r0)
            goto L_0x01d3
        L_0x01cc:
            r36 = r0
            r37 = r1
            r38 = r2
            r0 = r5
        L_0x01d3:
            r13.endReplaceableGroup()
            r8 = r0
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r4)
            java.lang.Object r3 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r25 = r3
            androidx.compose.ui.unit.Density r25 = (androidx.compose.ui.unit.Density) r25
            r0 = 6
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            boolean r2 = r13.changed((java.lang.Object) r8)
            r3 = r13
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x0220
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r36 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r5 != r0) goto L_0x021e
            goto L_0x0222
        L_0x021e:
            r0 = r5
            goto L_0x0231
        L_0x0220:
            r36 = r0
        L_0x0222:
            r0 = 0
            r37 = r0
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 r0 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            r0.<init>(r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3.updateRememberedValue(r0)
        L_0x0231:
            r13.endReplaceableGroup()
            r21 = r0
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            androidx.compose.material3.DropdownMenuPositionProvider r0 = new androidx.compose.material3.DropdownMenuPositionProvider
            r22 = 0
            r17 = r0
            r18 = r23
            r20 = r25
            r17.<init>(r18, r20, r21, r22)
            r6 = r17
            androidx.compose.ui.window.PopupPositionProvider r6 = (androidx.compose.ui.window.PopupPositionProvider) r6
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1 r5 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
            r0 = r5
            r1 = r7
            r2 = r8
            r3 = r16
            r4 = r40
            r36 = r7
            r7 = r5
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = -1192563503(0xffffffffb8eaecd1, float:-1.12021E-4)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r7)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r15 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r5 = r0 | r1
            r7 = 0
            r0 = r6
            r1 = r35
            r2 = r9
            r4 = r13
            r6 = r7
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r0, r1, r2, r3, r4, r5, r6)
        L_0x027c:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0285
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0285:
            r17 = r9
        L_0x0287:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x028e
            goto L_0x02ad
        L_0x028e:
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2 r18 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
            r0 = r18
            r1 = r34
            r2 = r35
            r3 = r16
            r4 = r23
            r6 = r17
            r7 = r40
            r8 = r42
            r10 = r9
            r9 = r43
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m1535DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DropdownMenuItem(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean enabled, MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Function2 function2;
        boolean z;
        Composer $composer2;
        MutableInteractionSource interactionSource2;
        PaddingValues contentPadding2;
        MenuItemColors colors2;
        boolean enabled2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Function2 leadingIcon3;
        Function2 trailingIcon3;
        boolean enabled3;
        MenuItemColors colors3;
        PaddingValues contentPadding3;
        MutableInteractionSource mutableInteractionSource;
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = text;
        Function0<Unit> function0 = onClick;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(function22, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenuItem)P(7,6,5,4,8,2)144@6904L12,146@7049L39,148@7098L319:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i4 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 4 : 2;
        }
        if ((i4 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i4 & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i3 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function23 = leadingIcon;
        } else if ((i3 & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(leadingIcon) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = leadingIcon;
        }
        int i7 = i4 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            function2 = trailingIcon;
        } else if ((i3 & 57344) == 0) {
            function2 = trailingIcon;
            $dirty2 |= $composer3.changedInstance(function2) ? 16384 : 8192;
        } else {
            function2 = trailingIcon;
        }
        int i8 = i4 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = enabled;
        } else if ((i3 & 458752) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = enabled;
        }
        if ((i3 & 3670016) == 0) {
            if ((i4 & 64) != 0) {
                MenuItemColors menuItemColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            MenuItemColors menuItemColors2 = colors;
        }
        int i9 = i4 & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            PaddingValues paddingValues = contentPadding;
        } else if ((i3 & 29360128) == 0) {
            $dirty2 |= $composer3.changed((Object) contentPadding) ? 8388608 : 4194304;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i10 = i4 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        } else if ((i3 & 234881024) == 0) {
            $dirty2 |= $composer3.changed((Object) interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource3 = interactionSource;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i3 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 != 0) {
                    leadingIcon3 = null;
                } else {
                    leadingIcon3 = leadingIcon;
                }
                if (i7 != 0) {
                    trailingIcon3 = null;
                } else {
                    trailingIcon3 = function2;
                }
                if (i8 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if ((i4 & 64) != 0) {
                    colors3 = MenuDefaults.INSTANCE.m1851itemColors5tl4gsc(0, 0, 0, 0, 0, 0, $composer3, 1572864, 63);
                    $dirty2 &= -3670017;
                } else {
                    colors3 = colors;
                }
                if (i9 != 0) {
                    contentPadding3 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    contentPadding3 = contentPadding;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    PaddingValues contentPadding4 = contentPadding3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                    } else {
                        mutableInteractionSource = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    contentPadding2 = contentPadding4;
                    $dirty = $dirty3;
                    interactionSource2 = mutableInteractionSource;
                    modifier2 = modifier3;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    enabled2 = enabled3;
                    colors2 = colors3;
                } else {
                    contentPadding2 = contentPadding3;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    enabled2 = enabled3;
                    colors2 = colors3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i4 & 64) != 0) {
                    leadingIcon2 = leadingIcon;
                    colors2 = colors;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2 & -3670017;
                    trailingIcon2 = function2;
                    enabled2 = z;
                    modifier2 = modifier;
                } else {
                    leadingIcon2 = leadingIcon;
                    colors2 = colors;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    trailingIcon2 = function2;
                    enabled2 = z;
                    modifier2 = modifier;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826340448, $dirty, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
            }
            int i11 = $dirty;
            $composer2 = $composer3;
            MenuKt.DropdownMenuItemContent(text, onClick, modifier2, leadingIcon2, trailingIcon2, enabled2, colors2, contentPadding2, interactionSource2, $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            leadingIcon2 = leadingIcon;
            colors2 = colors;
            contentPadding2 = contentPadding;
            interactionSource2 = interactionSource;
            int i12 = $dirty2;
            trailingIcon2 = function2;
            $composer2 = $composer3;
            enabled2 = z;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenuItem$2(text, onClick, modifier2, leadingIcon2, trailingIcon2, enabled2, colors2, contentPadding2, interactionSource2, $changed, i));
        }
    }
}
