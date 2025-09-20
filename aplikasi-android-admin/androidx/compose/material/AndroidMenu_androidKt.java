package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aq\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001aa\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
public final class AndroidMenu_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @kotlin.ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void m2870DropdownMenuILWXrKs(boolean r28, kotlin.jvm.functions.Function0 r29, androidx.compose.ui.Modifier r30, long r31, androidx.compose.ui.window.PopupProperties r33, kotlin.jvm.functions.Function3 r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r11 = r29
            r12 = r34
            r13 = r36
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -840283139(0xffffffffcdea4bfd, float:-4.91356064E8)
            r1 = r35
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)96@4692L21,91@4548L219:AndroidMenu.android.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r36
            r2 = r37 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r15 = r28
            goto L_0x003d
        L_0x002a:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003b
            r15 = r28
            boolean r2 = r14.changed((boolean) r15)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r15 = r28
        L_0x003d:
            r2 = r37 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r14.changedInstance(r11)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r37 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r30
            goto L_0x0072
        L_0x005d:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0070
            r3 = r30
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x006c
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r4
            goto L_0x0072
        L_0x0070:
            r3 = r30
        L_0x0072:
            r4 = r37 & 8
            if (r4 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r31
            goto L_0x0090
        L_0x007b:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x008e
            r5 = r31
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x008a
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r7
            goto L_0x0090
        L_0x008e:
            r5 = r31
        L_0x0090:
            r7 = r37 & 16
            if (r7 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r8 = r33
            goto L_0x00b0
        L_0x0099:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00ae
            r8 = r33
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00aa
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r9
            goto L_0x00b0
        L_0x00ae:
            r8 = r33
        L_0x00b0:
            r9 = r37 & 32
            r10 = 458752(0x70000, float:6.42848E-40)
            if (r9 == 0) goto L_0x00ba
            r9 = 196608(0x30000, float:2.75506E-40)
        L_0x00b8:
            r1 = r1 | r9
            goto L_0x00ca
        L_0x00ba:
            r9 = r13 & r10
            if (r9 != 0) goto L_0x00ca
            boolean r9 = r14.changedInstance(r12)
            if (r9 == 0) goto L_0x00c7
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00c7:
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b8
        L_0x00ca:
            r9 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r9
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r10) goto L_0x00e8
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x00db
            goto L_0x00e8
        L_0x00db:
            r14.skipToGroupEnd()
            r16 = r3
            r17 = r5
            r19 = r8
            r21 = r9
            goto L_0x0177
        L_0x00e8:
            if (r2 == 0) goto L_0x00f1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00f3
        L_0x00f1:
            r16 = r3
        L_0x00f3:
            if (r4 == 0) goto L_0x010a
            r1 = 0
            r2 = 0
            float r3 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r3)
            r2 = 0
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r4)
            long r1 = androidx.compose.ui.unit.DpKt.m7575DpOffsetYgX7TsA(r1, r2)
            r17 = r1
            goto L_0x010c
        L_0x010a:
            r17 = r5
        L_0x010c:
            if (r7 == 0) goto L_0x0126
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r26 = 62
            r27 = 0
            r20 = 1
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r19 = r1
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0128
        L_0x0126:
            r19 = r8
        L_0x0128:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0134
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:84)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x0134:
            r0 = 0
            r1 = 1
            androidx.compose.foundation.ScrollState r5 = androidx.compose.foundation.ScrollKt.rememberScrollState(r0, r14, r0, r1)
            r0 = r9 & 14
            r1 = r9 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r9 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r9 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r9 << 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            int r2 = r9 << 3
            r1 = r1 & r2
            r10 = r0 | r1
            r20 = 0
            r0 = r28
            r1 = r29
            r2 = r16
            r3 = r17
            r6 = r19
            r7 = r34
            r8 = r14
            r21 = r9
            r9 = r10
            r10 = r20
            m2869DropdownMenu4kj_NE(r0, r1, r2, r3, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0177
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0177:
            androidx.compose.runtime.ScopeUpdateScope r10 = r14.endRestartGroup()
            if (r10 != 0) goto L_0x017e
            goto L_0x019c
        L_0x017e:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1 r20 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
            r0 = r20
            r1 = r28
            r2 = r29
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r34
            r8 = r36
            r9 = r37
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m2870DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0109  */
    /* renamed from: DropdownMenu-4kj-_NE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2869DropdownMenu4kj_NE(boolean r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, long r31, androidx.compose.foundation.ScrollState r33, androidx.compose.ui.window.PopupProperties r34, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r11 = r29
            r12 = r35
            r13 = r37
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -2135362555(0xffffffff80b8f405, float:-1.6985269E-38)
            r1 = r36
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)151@7781L21,155@7950L42,159@8140L51,160@8227L7,164@8351L131,168@8492L443:AndroidMenu.android.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r37
            r2 = r38 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r15 = r28
            goto L_0x003d
        L_0x002a:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003b
            r15 = r28
            boolean r2 = r14.changed((boolean) r15)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r15 = r28
        L_0x003d:
            r2 = r38 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r14.changedInstance(r11)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r38 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r30
            goto L_0x0072
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0070
            r4 = r30
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r5
            goto L_0x0072
        L_0x0070:
            r4 = r30
        L_0x0072:
            r5 = r38 & 8
            if (r5 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r31
            goto L_0x0090
        L_0x007b:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008e
            r6 = r31
            boolean r8 = r14.changed((long) r6)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r6 = r31
        L_0x0090:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00ab
            r8 = r38 & 16
            if (r8 != 0) goto L_0x00a5
            r8 = r33
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a7
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a5:
            r8 = r33
        L_0x00a7:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r1 = r1 | r9
            goto L_0x00ad
        L_0x00ab:
            r8 = r33
        L_0x00ad:
            r9 = r38 & 32
            if (r9 == 0) goto L_0x00b7
            r10 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r10
            r10 = r34
            goto L_0x00ce
        L_0x00b7:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00cc
            r10 = r34
            boolean r16 = r14.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00c7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r16
            goto L_0x00ce
        L_0x00cc:
            r10 = r34
        L_0x00ce:
            r16 = r38 & 64
            if (r16 == 0) goto L_0x00d7
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d4:
            r1 = r1 | r16
            goto L_0x00e9
        L_0x00d7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00e9
            boolean r16 = r14.changedInstance(r12)
            if (r16 == 0) goto L_0x00e6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00e6:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d4
        L_0x00e9:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r3 = r1 & r16
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r3 != r0) goto L_0x0109
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00fa
            goto L_0x0109
        L_0x00fa:
            r14.skipToGroupEnd()
            r22 = r1
            r16 = r4
            r17 = r6
            r19 = r8
            r20 = r10
            goto L_0x030b
        L_0x0109:
            r14.startDefaults()
            r0 = r13 & 1
            if (r0 == 0) goto L_0x012a
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0117
            goto L_0x012a
        L_0x0117:
            r14.skipToGroupEnd()
            r0 = r38 & 16
            if (r0 == 0) goto L_0x0122
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r0
        L_0x0122:
            r17 = r10
            r3 = 1
            r10 = r8
            r8 = r6
            r6 = r1
            r7 = r4
            goto L_0x017e
        L_0x012a:
            if (r2 == 0) goto L_0x0131
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0132
        L_0x0131:
            r0 = r4
        L_0x0132:
            if (r5 == 0) goto L_0x0147
            r2 = 0
            r4 = 0
            float r5 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r5)
            r4 = 0
            r5 = 0
            float r3 = (float) r4
            float r3 = androidx.compose.ui.unit.Dp.m7554constructorimpl(r3)
            long r2 = androidx.compose.ui.unit.DpKt.m7575DpOffsetYgX7TsA(r2, r3)
            r6 = r2
        L_0x0147:
            r2 = r38 & 16
            if (r2 == 0) goto L_0x0157
            r2 = 0
            r3 = 1
            androidx.compose.foundation.ScrollState r4 = androidx.compose.foundation.ScrollKt.rememberScrollState(r2, r14, r2, r3)
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r2
            r8 = r4
            goto L_0x0158
        L_0x0157:
            r3 = 1
        L_0x0158:
            if (r9 == 0) goto L_0x0178
            androidx.compose.ui.window.PopupProperties r2 = new androidx.compose.ui.window.PopupProperties
            r26 = 62
            r27 = 0
            r20 = 1
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r19 = r2
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27)
            r17 = r2
            r10 = r8
            r8 = r6
            r7 = r0
            r6 = r1
            goto L_0x017e
        L_0x0178:
            r17 = r10
            r10 = r8
            r8 = r6
            r7 = r0
            r6 = r1
        L_0x017e:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0190
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:146)"
            r2 = -2135362555(0xffffffff80b8f405, float:-1.6985269E-38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x0190:
            r0 = 0
            r1 = r0
            r0 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r2)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r5 = 0
            r30 = r14
            r16 = 0
            java.lang.Object r3 = r30.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r20.getEmpty()
            if (r3 != r2) goto L_0x01ca
            r2 = 0
            r32 = r0
            androidx.compose.animation.core.MutableTransitionState r0 = new androidx.compose.animation.core.MutableTransitionState
            r33 = r1
            r18 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r18)
            r0.<init>(r1)
            r1 = r30
            r1.updateRememberedValue(r0)
            goto L_0x01d1
        L_0x01ca:
            r32 = r0
            r33 = r1
            r1 = r30
            r0 = r3
        L_0x01d1:
            r14.endReplaceableGroup()
            r5 = r0
            androidx.compose.animation.core.MutableTransitionState r5 = (androidx.compose.animation.core.MutableTransitionState) r5
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r28)
            r5.setTargetState(r0)
            java.lang.Object r0 = r5.getCurrentState()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0201
            java.lang.Object r0 = r5.getTargetState()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01f9
            goto L_0x0201
        L_0x01f9:
            r21 = r5
            r22 = r6
            r30 = r8
            goto L_0x02fa
        L_0x0201:
            r0 = 0
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r2 = 0
            r3 = r14
            r4 = 0
            r30 = r0
            java.lang.Object r0 = r3.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r31 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x023e
            r1 = 0
            androidx.compose.ui.graphics.TransformOrigin$Companion r18 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r18 = r18.m5390getCenterSzJe1aQ()
            r32 = r0
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m5377boximpl(r18)
            r33 = r1
            r1 = 0
            r34 = r2
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r3.updateRememberedValue(r0)
            goto L_0x0242
        L_0x023e:
            r32 = r0
            r34 = r2
        L_0x0242:
            r14.endReplaceableGroup()
            r4 = r0
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r30 = r1
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r1)
            java.lang.Object r1 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r16 = r1
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            r0 = 6
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            boolean r2 = r14.changed((java.lang.Object) r4)
            r3 = r14
            r18 = 0
            r30 = r0
            java.lang.Object r0 = r3.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x0296
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r31 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r0 != r1) goto L_0x0293
            goto L_0x0298
        L_0x0293:
            r32 = r0
            goto L_0x02a7
        L_0x0296:
            r31 = r1
        L_0x0298:
            r1 = 0
            r32 = r0
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 r0 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            r0.<init>(r4)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3.updateRememberedValue(r0)
        L_0x02a7:
            r14.endReplaceableGroup()
            r23 = r0
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            androidx.compose.material.DropdownMenuPositionProvider r0 = new androidx.compose.material.DropdownMenuPositionProvider
            r24 = 0
            r19 = r0
            r20 = r8
            r22 = r16
            r19.<init>(r20, r22, r23, r24)
            r18 = r0
            r19 = r18
            androidx.compose.ui.window.PopupPositionProvider r19 = (androidx.compose.ui.window.PopupPositionProvider) r19
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2 r3 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
            r0 = r3
            r1 = r5
            r2 = r4
            r30 = r8
            r9 = 1
            r8 = r3
            r3 = r10
            r20 = r4
            r4 = r7
            r21 = r5
            r5 = r35
            r22 = r6
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = -47803778(0xfffffffffd26927e, float:-1.383828E37)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r9, r8)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0 = r22 & 112(0x70, float:1.57E-43)
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r22 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r5 = r0 | r1
            r6 = 0
            r0 = r19
            r1 = r29
            r2 = r17
            r4 = r14
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r0, r1, r2, r3, r4, r5, r6)
        L_0x02fa:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0303
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0303:
            r16 = r7
            r19 = r10
            r20 = r17
            r17 = r30
        L_0x030b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r14.endRestartGroup()
            if (r10 != 0) goto L_0x0312
            goto L_0x0333
        L_0x0312:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$3 r21 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$3
            r0 = r21
            r1 = r28
            r2 = r29
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            r8 = r35
            r9 = r37
            r11 = r10
            r10 = r38
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9, r10)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0333:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m2869DropdownMenu4kj_NE(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.foundation.ScrollState, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItem(kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.foundation.layout.PaddingValues r22, androidx.compose.foundation.interaction.MutableInteractionSource r23, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r9 = r19
            r10 = r24
            r11 = r26
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1988562892(0xffffffff8978f034, float:-2.9964857E-33)
            r1 = r25
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenuItem)P(5,4,2,1,3)207@10118L39,210@10212L227:AndroidMenu.android.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r26
            r2 = r27 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r20
            goto L_0x0054
        L_0x003f:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r20
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r20
        L_0x0054:
            r4 = r27 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r21
            goto L_0x0072
        L_0x005d:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r21
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r21
        L_0x0072:
            r6 = r27 & 8
            if (r6 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r22
            goto L_0x0090
        L_0x007b:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008e
            r7 = r22
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r7 = r22
        L_0x0090:
            r8 = r27 & 16
            r13 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x009c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r23
            goto L_0x00b1
        L_0x009c:
            r14 = r11 & r13
            if (r14 != 0) goto L_0x00af
            r14 = r23
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00ab
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r15
            goto L_0x00b1
        L_0x00af:
            r14 = r23
        L_0x00b1:
            r15 = r27 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00bb
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b9:
            r1 = r1 | r15
            goto L_0x00cb
        L_0x00bb:
            r15 = r11 & r16
            if (r15 != 0) goto L_0x00cb
            boolean r15 = r12.changedInstance(r10)
            if (r15 == 0) goto L_0x00c8
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00c8:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b9
        L_0x00cb:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r13) goto L_0x00e6
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00dc
            goto L_0x00e6
        L_0x00dc:
            r12.skipToGroupEnd()
            r13 = r3
            r17 = r5
            r18 = r7
            goto L_0x0175
        L_0x00e6:
            if (r2 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00ef
        L_0x00ee:
            r13 = r3
        L_0x00ef:
            if (r4 == 0) goto L_0x00f5
            r1 = 1
            r17 = r1
            goto L_0x00f7
        L_0x00f5:
            r17 = r5
        L_0x00f7:
            if (r6 == 0) goto L_0x0102
            androidx.compose.material.MenuDefaults r1 = androidx.compose.material.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getDropdownMenuItemContentPadding()
            r18 = r1
            goto L_0x0104
        L_0x0102:
            r18 = r7
        L_0x0104:
            if (r8 == 0) goto L_0x0138
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = 0
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x012e
            r8 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r8)
            goto L_0x012f
        L_0x012e:
            r8 = r6
        L_0x012f:
            r12.endReplaceableGroup()
            r1 = r8
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r14 = r1
        L_0x0138:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0144
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:202)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x0144:
            r0 = r15 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r15
            r0 = r0 | r1
            r1 = r15 & r16
            r7 = r0 | r1
            r8 = 0
            r0 = r19
            r1 = r13
            r2 = r17
            r3 = r18
            r4 = r14
            r5 = r24
            r6 = r12
            androidx.compose.material.MenuKt.DropdownMenuItemContent(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0175
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0175:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x017c
            goto L_0x0199
        L_0x017c:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2 r16 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2
            r0 = r16
            r1 = r19
            r2 = r13
            r3 = r17
            r4 = r18
            r5 = r14
            r6 = r24
            r7 = r26
            r9 = r8
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
