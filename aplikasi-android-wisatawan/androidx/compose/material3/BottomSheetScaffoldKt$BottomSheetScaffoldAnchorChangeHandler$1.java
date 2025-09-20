package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "previousTarget", "Landroidx/compose/material3/SheetValue;", "previousAnchors", "", "", "newAnchors"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1 implements AnchorChangeHandler<SheetValue> {
    final /* synthetic */ Function2<SheetValue, Float, Unit> $animateTo;
    final /* synthetic */ Function1<SheetValue, Unit> $snapTo;
    final /* synthetic */ SheetState $state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1(SheetState sheetState, Function2<? super SheetValue, ? super Float, Unit> function2, Function1<? super SheetValue, Unit> function1) {
        this.$state = sheetState;
        this.$animateTo = function2;
        this.$snapTo = function1;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.Map<androidx.compose.material3.SheetValue, java.lang.Float>, java.util.Map, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAnchorsChanged(androidx.compose.material3.SheetValue r6, java.util.Map<androidx.compose.material3.SheetValue, java.lang.Float> r7, java.util.Map<androidx.compose.material3.SheetValue, java.lang.Float> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "previousTarget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "previousAnchors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "newAnchors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Object r0 = r7.get(r6)
            java.lang.Float r0 = (java.lang.Float) r0
            int[] r1 = androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1.WhenMappings.$EnumSwitchMapping$0
            int r2 = r6.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x0037;
                case 2: goto L_0x0037;
                case 3: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0029:
            androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Expanded
            boolean r1 = r8.containsKey(r1)
            if (r1 == 0) goto L_0x0034
            androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.Expanded
            goto L_0x0039
        L_0x0034:
            androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.PartiallyExpanded
            goto L_0x0039
        L_0x0037:
            androidx.compose.material3.SheetValue r1 = androidx.compose.material3.SheetValue.PartiallyExpanded
        L_0x0039:
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r8, r1)
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((float) r2, (java.lang.Float) r0)
            if (r3 != 0) goto L_0x006f
            androidx.compose.material3.SheetState r3 = r5.$state
            androidx.compose.material3.SwipeableV2State r3 = r3.getSwipeableState$material3_release()
            boolean r3 = r3.isAnimationRunning()
            if (r3 == 0) goto L_0x006a
            kotlin.jvm.functions.Function2<androidx.compose.material3.SheetValue, java.lang.Float, kotlin.Unit> r3 = r5.$animateTo
            androidx.compose.material3.SheetState r4 = r5.$state
            androidx.compose.material3.SwipeableV2State r4 = r4.getSwipeableState$material3_release()
            float r4 = r4.getLastVelocity()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r3.invoke(r1, r4)
            goto L_0x006f
        L_0x006a:
            kotlin.jvm.functions.Function1<androidx.compose.material3.SheetValue, kotlin.Unit> r3 = r5.$snapTo
            r3.invoke(r1)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1.onAnchorsChanged(androidx.compose.material3.SheetValue, java.util.Map, java.util.Map):void");
    }
}
