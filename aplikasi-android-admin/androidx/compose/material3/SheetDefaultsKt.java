package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0000\u001aA\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0001¢\u0006\u0002\u0010\u001a\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"BottomSheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getBottomSheetMaxWidth", "()F", "F", "DragHandleVerticalPadding", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetDefaultsKt {
    private static final float BottomSheetMaxWidth = Dp.m7554constructorimpl((float) 640);
    /* access modifiers changed from: private */
    public static final float DragHandleVerticalPadding = Dp.m7554constructorimpl((float) 22);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SheetState sheetState, Orientation orientation, Function1<? super Float, Unit> onFling) {
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(onFling, "onFling");
        return new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(sheetState, onFling, orientation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.SheetState rememberSheetState(boolean r17, kotlin.jvm.functions.Function1<? super androidx.compose.material3.SheetValue, java.lang.Boolean> r18, androidx.compose.material3.SheetValue r19, boolean r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r7 = r21
            r0 = 1032784200(0x3d8f0948, float:0.06984192)
            r7.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSheetState)P(3)422@15342L100,416@15112L330:SheetDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x0014
            r1 = 0
            r8 = r1
            goto L_0x0016
        L_0x0014:
            r8 = r17
        L_0x0016:
            r1 = r23 & 2
            if (r1 == 0) goto L_0x0020
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1 r1 = androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9 = r1
            goto L_0x0022
        L_0x0020:
            r9 = r18
        L_0x0022:
            r1 = r23 & 4
            if (r1 == 0) goto L_0x002a
            androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Hidden
            r10 = r1
            goto L_0x002c
        L_0x002a:
            r10 = r19
        L_0x002c:
            r1 = r23 & 8
            if (r1 == 0) goto L_0x0033
            r1 = 0
            r11 = r1
            goto L_0x0035
        L_0x0033:
            r11 = r20
        L_0x0035:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0044
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:410)"
            r12 = r22
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
            goto L_0x0046
        L_0x0044:
            r12 = r22
        L_0x0046:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r9}
            androidx.compose.material3.SheetState$Companion r1 = androidx.compose.material3.SheetState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r1.Saver(r8, r9)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r11)
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r10, r9, r3}
            r3 = 8
            r4 = 0
            r5 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r7.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            r5 = 0
            int r6 = r2.length
            r13 = 0
        L_0x0073:
            if (r13 >= r6) goto L_0x007f
            r14 = r2[r13]
            boolean r15 = r7.changed((java.lang.Object) r14)
            r5 = r5 | r15
            int r13 = r13 + 1
            goto L_0x0073
        L_0x007f:
            r6 = r21
            r13 = 0
            java.lang.Object r14 = r6.rememberedValue()
            r15 = 0
            if (r5 != 0) goto L_0x0096
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r17 = r2
            java.lang.Object r2 = r16.getEmpty()
            if (r14 != r2) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            r2 = r14
            goto L_0x00a7
        L_0x0096:
            r17 = r2
        L_0x0098:
            r2 = 0
            r18 = r2
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1 r2 = new androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
            r2.<init>(r8, r10, r9, r11)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6.updateRememberedValue(r2)
        L_0x00a7:
            r21.endReplaceableGroup()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r2 = 0
            r5 = 72
            r6 = 4
            r4 = r21
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.SheetState r0 = (androidx.compose.material3.SheetState) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00c4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00c4:
            r21.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt.rememberSheetState(boolean, kotlin.jvm.functions.Function1, androidx.compose.material3.SheetValue, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.SheetState");
    }

    public static final float getBottomSheetMaxWidth() {
        return BottomSheetMaxWidth;
    }
}
