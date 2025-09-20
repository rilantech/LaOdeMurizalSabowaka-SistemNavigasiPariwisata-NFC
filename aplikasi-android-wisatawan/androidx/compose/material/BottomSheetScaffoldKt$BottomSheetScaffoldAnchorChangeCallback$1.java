package androidx.compose.material;

import androidx.compose.material.AnchoredDraggableState;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "prevTarget", "Landroidx/compose/material/BottomSheetValue;", "prevAnchors", "", "", "newAnchors"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1 implements AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ BottomSheetState $state;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1(BottomSheetState bottomSheetState, CoroutineScope coroutineScope) {
        this.$state = bottomSheetState;
        this.$scope = coroutineScope;
    }

    /* JADX WARNING: type inference failed for: r14v0, types: [java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float>, java.util.Map, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAnchorsChanged(androidx.compose.material.BottomSheetValue r12, java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float> r13, java.util.Map<androidx.compose.material.BottomSheetValue, java.lang.Float> r14) {
        /*
            r11 = this;
            java.lang.String r0 = "prevTarget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "prevAnchors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "newAnchors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.Object r0 = r13.get(r12)
            java.lang.Float r0 = (java.lang.Float) r0
            int[] r1 = androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1.WhenMappings.$EnumSwitchMapping$0
            int r2 = r12.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x0037;
                case 2: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0029:
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Expanded
            boolean r1 = r14.containsKey(r1)
            if (r1 == 0) goto L_0x0034
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Expanded
            goto L_0x0039
        L_0x0034:
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Collapsed
            goto L_0x0039
        L_0x0037:
            androidx.compose.material.BottomSheetValue r1 = androidx.compose.material.BottomSheetValue.Collapsed
        L_0x0039:
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r14, r1)
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((float) r2, (java.lang.Float) r0)
            if (r3 != 0) goto L_0x0082
            androidx.compose.material.BottomSheetState r3 = r11.$state
            boolean r3 = r3.isAnimationRunning$material_release()
            r4 = 0
            if (r3 == 0) goto L_0x0067
            kotlinx.coroutines.CoroutineScope r5 = r11.$scope
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$1 r3 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$1
            androidx.compose.material.BottomSheetState r6 = r11.$state
            r3.<init>(r6, r1, r4)
            r8 = r3
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)
            goto L_0x0082
        L_0x0067:
            androidx.compose.material.BottomSheetState r3 = r11.$state
            boolean r3 = r3.trySnapTo$material_release(r1)
            if (r3 != 0) goto L_0x0082
            kotlinx.coroutines.CoroutineScope r5 = r11.$scope
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2 r6 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2
            androidx.compose.material.BottomSheetState r7 = r11.$state
            r6.<init>(r7, r1, r4)
            r8 = r6
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1.onAnchorsChanged(androidx.compose.material.BottomSheetValue, java.util.Map, java.util.Map):void");
    }
}
