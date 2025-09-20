package com.example.aplikasiwisatawan.ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "BelajarTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Theme.kt */
public final class ThemeKt {
    private static final ColorScheme DarkColorScheme = ColorSchemeKt.m1661darkColorSchemeG1PFcw$default(ColorKt.getPurple80(), 0, 0, 0, 0, ColorKt.getPurpleGrey80(), 0, 0, 0, ColorKt.getPink80(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 536870366, (Object) null);
    private static final ColorScheme LightColorScheme = ColorSchemeKt.m1663lightColorSchemeG1PFcw$default(ColorKt.getPurple40(), 0, 0, 0, 0, ColorKt.getPurpleGrey40(), 0, 0, 0, ColorKt.getPink40(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 536870366, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BelajarTheme(boolean r10, boolean r11, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 805940894(0x3009ae9e, float:5.0088456E-10)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            java.lang.String r1 = "C(BelajarTheme)P(1,2)41@1304L21,55@1823L7,64@2126L126:Theme.kt#91vwmn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r14
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0024
            r2 = r15 & 1
            if (r2 != 0) goto L_0x0022
            boolean r2 = r13.changed((boolean) r10)
            if (r2 == 0) goto L_0x0022
            r2 = 4
            goto L_0x0023
        L_0x0022:
            r2 = 2
        L_0x0023:
            r1 = r1 | r2
        L_0x0024:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x002b
            r1 = r1 | 48
            goto L_0x003b
        L_0x002b:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003b
            boolean r3 = r13.changed((boolean) r11)
            if (r3 == 0) goto L_0x0038
            r3 = 32
            goto L_0x003a
        L_0x0038:
            r3 = 16
        L_0x003a:
            r1 = r1 | r3
        L_0x003b:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x0042
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0052
        L_0x0042:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0052
            boolean r3 = r13.changedInstance(r12)
            if (r3 == 0) goto L_0x004f
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0051
        L_0x004f:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0051:
            r1 = r1 | r3
        L_0x0052:
            r3 = r1 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L_0x0064
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x005f
            goto L_0x0064
        L_0x005f:
            r13.skipToGroupEnd()
            goto L_0x012a
        L_0x0064:
            r13.startDefaults()
            r3 = r14 & 1
            r4 = 0
            if (r3 == 0) goto L_0x007e
            boolean r3 = r13.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0073
            goto L_0x007e
        L_0x0073:
            r13.skipToGroupEnd()
            r2 = r15 & 1
            if (r2 == 0) goto L_0x007c
            r1 = r1 & -15
        L_0x007c:
            r8 = r1
            goto L_0x008d
        L_0x007e:
            r3 = r15 & 1
            if (r3 == 0) goto L_0x0088
            boolean r10 = androidx.compose.foundation.DarkThemeKt.isSystemInDarkTheme(r13, r4)
            r1 = r1 & -15
        L_0x0088:
            if (r2 == 0) goto L_0x008c
            r11 = 1
            goto L_0x007c
        L_0x008c:
            r8 = r1
        L_0x008d:
            r13.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x009c
            r1 = -1
            java.lang.String r2 = "com.example.aplikasiwisatawan.ui.theme.BelajarTheme (Theme.kt:45)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L_0x009c:
            r0 = -232584889(0xfffffffff2230947, float:-3.2292654E30)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "48@1606L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            java.lang.String r0 = "CC:CompositionLocal.kt#9igjgp"
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            if (r11 == 0) goto L_0x00d0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r5 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            java.lang.Object r6 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r2 = r6
            android.content.Context r2 = (android.content.Context) r2
            if (r10 == 0) goto L_0x00cb
            androidx.compose.material3.ColorScheme r3 = androidx.compose.material3.DynamicTonalPaletteKt.dynamicDarkColorScheme(r2)
            goto L_0x00d7
        L_0x00cb:
            androidx.compose.material3.ColorScheme r3 = androidx.compose.material3.DynamicTonalPaletteKt.dynamicLightColorScheme(r2)
            goto L_0x00d7
        L_0x00d0:
            if (r10 == 0) goto L_0x00d5
            androidx.compose.material3.ColorScheme r3 = DarkColorScheme
            goto L_0x00d7
        L_0x00d5:
            androidx.compose.material3.ColorScheme r3 = LightColorScheme
        L_0x00d7:
            r13.endReplaceableGroup()
            r9 = r3
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r5 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r1, r0)
            java.lang.Object r0 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            android.view.View r0 = (android.view.View) r0
            r1 = -232584538(0xfffffffff2230aa6, float:-3.2293715E30)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "57@1869L245"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            boolean r1 = r0.isInEditMode()
            if (r1 != 0) goto L_0x010a
            com.example.aplikasiwisatawan.ui.theme.ThemeKt$BelajarTheme$1 r1 = new com.example.aplikasiwisatawan.ui.theme.ThemeKt$BelajarTheme$1
            r1.<init>(r0, r9, r10)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r13, r4)
        L_0x010a:
            r13.endReplaceableGroup()
            androidx.compose.material3.Typography r3 = com.example.aplikasiwisatawan.ui.theme.TypeKt.getTypography()
            int r1 = r8 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | 384(0x180, float:5.38E-43)
            r2 = 0
            r7 = 2
            r1 = r9
            r4 = r12
            r5 = r13
            androidx.compose.material3.MaterialThemeKt.MaterialTheme(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0129
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0129:
            r1 = r8
        L_0x012a:
            androidx.compose.runtime.ScopeUpdateScope r0 = r13.endRestartGroup()
            if (r0 != 0) goto L_0x0131
            goto L_0x0141
        L_0x0131:
            com.example.aplikasiwisatawan.ui.theme.ThemeKt$BelajarTheme$2 r8 = new com.example.aplikasiwisatawan.ui.theme.ThemeKt$BelajarTheme$2
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            r7 = r15
            r2.<init>(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.updateScope(r8)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.aplikasiwisatawan.ui.theme.ThemeKt.BelajarTheme(boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
