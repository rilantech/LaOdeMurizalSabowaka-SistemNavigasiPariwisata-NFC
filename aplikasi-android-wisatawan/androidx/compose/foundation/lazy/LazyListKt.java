package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010!\u001a\u0001\u0010\"\u001a\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0#¢\u0006\u0002\b\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(androidx.compose.ui.Modifier r31, androidx.compose.foundation.lazy.LazyListState r32, androidx.compose.foundation.layout.PaddingValues r33, boolean r34, boolean r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, int r38, androidx.compose.ui.Alignment.Horizontal r39, androidx.compose.foundation.layout.Arrangement.Vertical r40, androidx.compose.ui.Alignment.Vertical r41, androidx.compose.foundation.layout.Arrangement.Horizontal r42, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46, int r47) {
        /*
            r15 = r31
            r14 = r32
            r13 = r33
            r12 = r34
            r11 = r35
            r10 = r36
            r9 = r43
            r8 = r45
            r7 = r46
            r6 = r47
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 620764179(0x25001c13, float:1.1111742E-16)
            r1 = r44
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)78@3680L50,80@3756L48,82@3830L292,95@4128L48,97@4224L18,103@4479L277,111@4820L164,121@5208L7,99@4334L1359:LazyList.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r45
            r2 = r46
            r3 = r6 & 1
            r16 = 2
            if (r3 == 0) goto L_0x004a
            r1 = r1 | 6
            goto L_0x0059
        L_0x004a:
            r3 = r8 & 14
            if (r3 != 0) goto L_0x0059
            boolean r3 = r5.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0056
            r3 = 4
            goto L_0x0058
        L_0x0056:
            r3 = r16
        L_0x0058:
            r1 = r1 | r3
        L_0x0059:
            r3 = r6 & 2
            r17 = 32
            r18 = 16
            if (r3 == 0) goto L_0x0064
            r1 = r1 | 48
            goto L_0x0074
        L_0x0064:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0074
            boolean r3 = r5.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0071
            r3 = r17
            goto L_0x0073
        L_0x0071:
            r3 = r18
        L_0x0073:
            r1 = r1 | r3
        L_0x0074:
            r3 = r6 & 4
            r19 = 256(0x100, float:3.59E-43)
            r20 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x007f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x008f
        L_0x007f:
            r3 = r8 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x008f
            boolean r3 = r5.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x008c
            r3 = r19
            goto L_0x008e
        L_0x008c:
            r3 = r20
        L_0x008e:
            r1 = r1 | r3
        L_0x008f:
            r3 = r6 & 8
            if (r3 == 0) goto L_0x0096
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a6
        L_0x0096:
            r3 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x00a6
            boolean r3 = r5.changed((boolean) r12)
            if (r3 == 0) goto L_0x00a3
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x00a5
        L_0x00a3:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x00a5:
            r1 = r1 | r3
        L_0x00a6:
            r3 = r6 & 16
            r21 = 57344(0xe000, float:8.0356E-41)
            if (r3 == 0) goto L_0x00b0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c0
        L_0x00b0:
            r3 = r8 & r21
            if (r3 != 0) goto L_0x00c0
            boolean r3 = r5.changed((boolean) r11)
            if (r3 == 0) goto L_0x00bd
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00bf
        L_0x00bd:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00bf:
            r1 = r1 | r3
        L_0x00c0:
            r3 = r6 & 32
            r22 = 458752(0x70000, float:6.42848E-40)
            if (r3 == 0) goto L_0x00ca
            r3 = 196608(0x30000, float:2.75506E-40)
        L_0x00c8:
            r1 = r1 | r3
            goto L_0x00da
        L_0x00ca:
            r3 = r8 & r22
            if (r3 != 0) goto L_0x00da
            boolean r3 = r5.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x00d7
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00d7:
            r3 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00c8
        L_0x00da:
            r3 = r6 & 64
            r23 = 3670016(0x380000, float:5.142788E-39)
            if (r3 == 0) goto L_0x00e6
            r3 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r3
            r3 = r37
            goto L_0x00fc
        L_0x00e6:
            r3 = r8 & r23
            if (r3 != 0) goto L_0x00fa
            r3 = r37
            boolean r24 = r5.changed((boolean) r3)
            if (r24 == 0) goto L_0x00f5
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f7
        L_0x00f5:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x00f7:
            r1 = r1 | r24
            goto L_0x00fc
        L_0x00fa:
            r3 = r37
        L_0x00fc:
            r4 = r6 & 128(0x80, float:1.794E-43)
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            if (r4 == 0) goto L_0x0109
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r25
            r0 = r38
            goto L_0x011f
        L_0x0109:
            r25 = r8 & r24
            if (r25 != 0) goto L_0x011d
            r0 = r38
            boolean r26 = r5.changed((int) r0)
            if (r26 == 0) goto L_0x0118
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011a
        L_0x0118:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x011a:
            r1 = r1 | r26
            goto L_0x011f
        L_0x011d:
            r0 = r38
        L_0x011f:
            r0 = r6 & 256(0x100, float:3.59E-43)
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x012c
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r27
            r3 = r39
            goto L_0x0142
        L_0x012c:
            r27 = r8 & r26
            if (r27 != 0) goto L_0x0140
            r3 = r39
            boolean r27 = r5.changed((java.lang.Object) r3)
            if (r27 == 0) goto L_0x013b
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x013d
        L_0x013b:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x013d:
            r1 = r1 | r27
            goto L_0x0142
        L_0x0140:
            r3 = r39
        L_0x0142:
            r3 = r6 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x014d
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r27
            r8 = r40
            goto L_0x0165
        L_0x014d:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r8 & r27
            if (r27 != 0) goto L_0x0163
            r8 = r40
            boolean r27 = r5.changed((java.lang.Object) r8)
            if (r27 == 0) goto L_0x015e
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0160
        L_0x015e:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0160:
            r1 = r1 | r27
            goto L_0x0165
        L_0x0163:
            r8 = r40
        L_0x0165:
            r8 = r6 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x016e
            r2 = r2 | 6
            r10 = r41
            goto L_0x0181
        L_0x016e:
            r27 = r7 & 14
            if (r27 != 0) goto L_0x017f
            r10 = r41
            boolean r27 = r5.changed((java.lang.Object) r10)
            if (r27 == 0) goto L_0x017c
            r16 = 4
        L_0x017c:
            r2 = r2 | r16
            goto L_0x0181
        L_0x017f:
            r10 = r41
        L_0x0181:
            r10 = r6 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x018a
            r2 = r2 | 48
            r12 = r42
            goto L_0x019e
        L_0x018a:
            r16 = r7 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x019c
            r12 = r42
            boolean r16 = r5.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x0197
            goto L_0x0199
        L_0x0197:
            r17 = r18
        L_0x0199:
            r2 = r2 | r17
            goto L_0x019e
        L_0x019c:
            r12 = r42
        L_0x019e:
            r12 = r6 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x01a5
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x01b4
        L_0x01a5:
            r12 = r7 & 896(0x380, float:1.256E-42)
            if (r12 != 0) goto L_0x01b4
            boolean r12 = r5.changedInstance(r9)
            if (r12 == 0) goto L_0x01b0
            goto L_0x01b2
        L_0x01b0:
            r19 = r20
        L_0x01b2:
            r2 = r2 | r19
        L_0x01b4:
            r12 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r1
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r6) goto L_0x01e0
            r2 = r12 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r2 != r6) goto L_0x01e0
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x01cb
            goto L_0x01e0
        L_0x01cb:
            r5.skipToGroupEnd()
            r13 = r34
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r41
            r21 = r42
            r11 = r5
            r23 = r12
            r12 = r1
            goto L_0x0353
        L_0x01e0:
            if (r4 == 0) goto L_0x01e6
            r2 = 0
            r16 = r2
            goto L_0x01e8
        L_0x01e6:
            r16 = r38
        L_0x01e8:
            if (r0 == 0) goto L_0x01ee
            r0 = 0
            r17 = r0
            goto L_0x01f0
        L_0x01ee:
            r17 = r39
        L_0x01f0:
            if (r3 == 0) goto L_0x01f6
            r0 = 0
            r18 = r0
            goto L_0x01f8
        L_0x01f6:
            r18 = r40
        L_0x01f8:
            if (r8 == 0) goto L_0x01fe
            r0 = 0
            r19 = r0
            goto L_0x0200
        L_0x01fe:
            r19 = r41
        L_0x0200:
            if (r10 == 0) goto L_0x0206
            r0 = 0
            r20 = r0
            goto L_0x0208
        L_0x0206:
            r20 = r42
        L_0x0208:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0216
            java.lang.String r0 = "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)"
            r2 = 620764179(0x25001c13, float:1.1111742E-16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r12, r0)
        L_0x0216:
            int r0 = r1 >> 3
            r0 = r0 & 14
            int r2 = r12 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            kotlin.jvm.functions.Function0 r10 = androidx.compose.foundation.lazy.LazyListItemProviderKt.rememberLazyListItemProviderLambda(r14, r9, r5, r0)
            int r0 = r1 >> 3
            r0 = r0 & 14
            int r2 = r1 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r25 = androidx.compose.foundation.lazy.LazyListSemanticsKt.rememberLazyListSemanticState(r14, r11, r5, r0)
            r0 = r1 & 112(0x70, float:1.57E-43)
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = r1 & r21
            r0 = r0 | r2
            int r2 = r1 >> 6
            r2 = r2 & r22
            r0 = r0 | r2
            int r2 = r1 >> 6
            r2 = r2 & r23
            r0 = r0 | r2
            int r2 = r12 << 21
            r2 = r2 & r24
            r0 = r0 | r2
            int r2 = r12 << 21
            r2 = r2 & r26
            r0 = r0 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r1
            r23 = r0 | r2
            r24 = 0
            r0 = r10
            r8 = r1
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r6 = r5
            r5 = r16
            r38 = r6
            r6 = r17
            r7 = r19
            r28 = r8
            r8 = r20
            r9 = r18
            r29 = r10
            r10 = r38
            r11 = r23
            r13 = r34
            r23 = r12
            r12 = r24
            kotlin.jvm.functions.Function2 r8 = rememberLazyListMeasurePolicy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r12 = r28
            r0 = r12 & 112(0x70, float:1.57E-43)
            r11 = r38
            r9 = r29
            ScrollPositionUpdater(r9, r14, r11, r0)
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r1 = 6
            androidx.compose.foundation.OverscrollEffect r10 = r0.overscrollEffect(r11, r1)
            if (r35 == 0) goto L_0x029f
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x02a1
        L_0x029f:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x02a1:
            r7 = r0
            androidx.compose.ui.layout.RemeasurementModifier r0 = r32.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.Modifier r0 = r15.then(r0)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r1 = r32.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            int r1 = r12 >> 6
            r1 = r1 & r21
            int r2 = r12 << 6
            r2 = r2 & r22
            r21 = r1 | r2
            r1 = r9
            r2 = r25
            r3 = r7
            r4 = r37
            r5 = r34
            r6 = r11
            r15 = r7
            r7 = r21
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r0, r15)
            r1 = r12 & 112(0x70, float:1.57E-43)
            int r2 = r12 >> 15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r12 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | r2
            r1 = r32
            r2 = r16
            r3 = r34
            r4 = r15
            r5 = r11
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.OverscrollKt.overscroll(r0, r10)
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r5 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            boolean r5 = r1.reverseDirection(r5, r15, r13)
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r32.getInternalInteractionSource$foundation_release()
            r1 = r14
            androidx.compose.foundation.gestures.ScrollableState r1 = (androidx.compose.foundation.gestures.ScrollableState) r1
            r2 = r15
            r3 = r10
            r4 = r37
            r6 = r36
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r32.getPrefetchState$foundation_release()
            r6 = 0
            r7 = 0
            r1 = r9
            r4 = r8
            r5 = r11
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0349
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0349:
            r21 = r20
            r20 = r19
            r19 = r18
            r18 = r17
            r17 = r16
        L_0x0353:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 != 0) goto L_0x035e
            r24 = r11
            r25 = r12
            goto L_0x0394
        L_0x035e:
            androidx.compose.foundation.lazy.LazyListKt$LazyList$1 r22 = new androidx.compose.foundation.lazy.LazyListKt$LazyList$1
            r0 = r22
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r36
            r7 = r37
            r8 = r17
            r9 = r18
            r10 = r19
            r24 = r11
            r11 = r20
            r25 = r12
            r12 = r21
            r13 = r43
            r14 = r45
            r30 = r15
            r15 = r46
            r16 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r30
            r1.updateScope(r0)
        L_0x0394:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ScrollPositionUpdater(Function0<? extends LazyListItemProvider> itemProviderLambda, LazyListState state, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-331135862);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(itemProviderLambda) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331135862, $changed, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:140)");
            }
            LazyListItemProvider itemProvider = (LazyListItemProvider) itemProviderLambda.invoke();
            if (itemProvider.getItemCount() > 0) {
                LazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(state, itemProvider, 0, 2, (Object) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyListKt$ScrollPositionUpdater$1(itemProviderLambda, state, $changed));
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(Function0<? extends LazyListItemProvider> itemProviderLambda, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, boolean isVertical, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, Composer $composer, int $changed, int i) {
        Alignment.Vertical verticalAlignment2;
        Arrangement.Horizontal horizontalArrangement2;
        Arrangement.Vertical verticalArrangement2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(183156450);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListMeasurePolicy)P(5,7,1,6,4!2,8)173@7248L7052:LazyList.kt#428nma");
        Alignment.Horizontal horizontalAlignment2 = (i2 & 64) != 0 ? null : horizontalAlignment;
        if ((i2 & 128) != 0) {
            verticalAlignment2 = null;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if ((i2 & 256) != 0) {
            horizontalArrangement2 = null;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if ((i2 & 512) != 0) {
            verticalArrangement2 = null;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, $changed, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        } else {
            int i3 = $changed;
        }
        Object[] keys$iv = {state, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new LazyListKt$rememberLazyListMeasurePolicy$1$1(isVertical, contentPadding, reverseLayout, state, itemProviderLambda, verticalArrangement2, horizontalArrangement2, beyondBoundsItemCount, horizontalAlignment2, verticalAlignment2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }
}
