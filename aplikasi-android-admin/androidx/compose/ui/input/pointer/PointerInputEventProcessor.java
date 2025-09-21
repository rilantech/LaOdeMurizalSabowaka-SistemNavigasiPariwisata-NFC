package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "isProcessing", "", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInputEventProcessor.kt */
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private final HitTestResult hitResult = new HitTestResult();
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
    private final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode root2) {
        Intrinsics.checkNotNullParameter(root2, "root");
        this.root = root2;
        this.hitPathTracker = new HitPathTracker(root2.getCoordinates());
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    /* renamed from: process-BIzXfog$default  reason: not valid java name */
    public static /* synthetic */ int m6208processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m6209processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0067 A[SYNTHETIC] */
    /* renamed from: process-BIzXfog  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m6209processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent r24, androidx.compose.ui.input.pointer.PositionCalculator r25, boolean r26) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r0 = "pointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "positionCalculator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r1.isProcessing
            r4 = 0
            if (r0 == 0) goto L_0x001e
            int r0 = androidx.compose.ui.input.pointer.PointerInputEventProcessorKt.ProcessResult(r4, r4)
            return r0
        L_0x001e:
            r0 = 1
            r1.isProcessing = r0     // Catch:{ all -> 0x013f }
            androidx.compose.ui.input.pointer.PointerInputChangeEventProducer r5 = r1.pointerInputChangeEventProducer     // Catch:{ all -> 0x013f }
            androidx.compose.ui.input.pointer.InternalPointerEvent r5 = r5.produce(r2, r3)     // Catch:{ all -> 0x013f }
            java.util.Map r6 = r5.getChanges()     // Catch:{ all -> 0x013f }
            java.util.Collection r6 = r6.values()     // Catch:{ all -> 0x013f }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x013f }
            r7 = 0
            boolean r8 = r6 instanceof java.util.Collection     // Catch:{ all -> 0x013f }
            if (r8 == 0) goto L_0x0043
            r8 = r6
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x013f }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x013f }
            if (r8 == 0) goto L_0x0043
            r6 = r4
            goto L_0x006a
        L_0x0043:
            java.util.Iterator r8 = r6.iterator()     // Catch:{ all -> 0x013f }
        L_0x0047:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x013f }
            if (r9 == 0) goto L_0x0069
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x013f }
            r10 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10     // Catch:{ all -> 0x013f }
            r11 = 0
            boolean r12 = r10.getPressed()     // Catch:{ all -> 0x013f }
            if (r12 != 0) goto L_0x0064
            boolean r12 = r10.getPreviousPressed()     // Catch:{ all -> 0x013f }
            if (r12 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r10 = r4
            goto L_0x0065
        L_0x0064:
            r10 = r0
        L_0x0065:
            if (r10 == 0) goto L_0x0047
            r6 = r0
            goto L_0x006a
        L_0x0069:
            r6 = r4
        L_0x006a:
            if (r6 != 0) goto L_0x006e
            r6 = r0
            goto L_0x006f
        L_0x006e:
            r6 = r4
        L_0x006f:
            java.util.Map r7 = r5.getChanges()     // Catch:{ all -> 0x013f }
            java.util.Collection r7 = r7.values()     // Catch:{ all -> 0x013f }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x013f }
            r8 = 0
            java.util.Iterator r9 = r7.iterator()     // Catch:{ all -> 0x013f }
        L_0x007f:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x013f }
            if (r10 == 0) goto L_0x00d6
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x013f }
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ all -> 0x013f }
            r12 = 0
            if (r6 != 0) goto L_0x0095
            boolean r13 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r11)     // Catch:{ all -> 0x013f }
            if (r13 == 0) goto L_0x00d3
        L_0x0095:
            int r13 = r11.m6193getTypeT8wyACA()     // Catch:{ all -> 0x013f }
            androidx.compose.ui.input.pointer.PointerType$Companion r14 = androidx.compose.ui.input.pointer.PointerType.Companion     // Catch:{ all -> 0x013f }
            int r14 = r14.m6269getTouchT8wyACA()     // Catch:{ all -> 0x013f }
            boolean r19 = androidx.compose.ui.input.pointer.PointerType.m6262equalsimpl0(r13, r14)     // Catch:{ all -> 0x013f }
            androidx.compose.ui.node.LayoutNode r15 = r1.root     // Catch:{ all -> 0x013f }
            long r16 = r11.m6190getPositionF1C5BW0()     // Catch:{ all -> 0x013f }
            androidx.compose.ui.node.HitTestResult r13 = r1.hitResult     // Catch:{ all -> 0x013f }
            r21 = 8
            r22 = 0
            r20 = 0
            r18 = r13
            androidx.compose.ui.node.LayoutNode.m6536hitTestM_7yMNQ$ui_release$default(r15, r16, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x013f }
            androidx.compose.ui.node.HitTestResult r13 = r1.hitResult     // Catch:{ all -> 0x013f }
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ all -> 0x013f }
            boolean r13 = r13.isEmpty()     // Catch:{ all -> 0x013f }
            r13 = r13 ^ r0
            if (r13 == 0) goto L_0x00d3
            androidx.compose.ui.input.pointer.HitPathTracker r13 = r1.hitPathTracker     // Catch:{ all -> 0x013f }
            long r14 = r11.m6189getIdJ3iCeTQ()     // Catch:{ all -> 0x013f }
            androidx.compose.ui.node.HitTestResult r0 = r1.hitResult     // Catch:{ all -> 0x013f }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x013f }
            r13.m6119addHitPathKNwqfcY(r14, r0)     // Catch:{ all -> 0x013f }
            androidx.compose.ui.node.HitTestResult r0 = r1.hitResult     // Catch:{ all -> 0x013f }
            r0.clear()     // Catch:{ all -> 0x013f }
        L_0x00d3:
            r0 = 1
            goto L_0x007f
        L_0x00d6:
            androidx.compose.ui.input.pointer.HitPathTracker r0 = r1.hitPathTracker     // Catch:{ all -> 0x013f }
            r0.removeDetachedPointerInputFilters()     // Catch:{ all -> 0x013f }
            androidx.compose.ui.input.pointer.HitPathTracker r0 = r1.hitPathTracker     // Catch:{ all -> 0x013f }
            r7 = r26
            boolean r0 = r0.dispatchChanges(r5, r7)     // Catch:{ all -> 0x013d }
            boolean r8 = r5.getSuppressMovementConsumption()     // Catch:{ all -> 0x013d }
            if (r8 == 0) goto L_0x00ee
            r16 = r4
            goto L_0x0132
        L_0x00ee:
            java.util.Map r8 = r5.getChanges()     // Catch:{ all -> 0x013d }
            java.util.Collection r8 = r8.values()     // Catch:{ all -> 0x013d }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x013d }
            r9 = 0
            boolean r10 = r8 instanceof java.util.Collection     // Catch:{ all -> 0x013d }
            if (r10 == 0) goto L_0x010a
            r10 = r8
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ all -> 0x013d }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x013d }
            if (r10 == 0) goto L_0x010a
            r16 = r4
            goto L_0x0132
        L_0x010a:
            java.util.Iterator r10 = r8.iterator()     // Catch:{ all -> 0x013d }
        L_0x010e:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x013d }
            if (r11 == 0) goto L_0x0130
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x013d }
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch:{ all -> 0x013d }
            r13 = 0
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r12)     // Catch:{ all -> 0x013d }
            if (r14 == 0) goto L_0x012a
            boolean r14 = r12.isConsumed()     // Catch:{ all -> 0x013d }
            if (r14 == 0) goto L_0x012a
            r12 = 1
            goto L_0x012b
        L_0x012a:
            r12 = r4
        L_0x012b:
            if (r12 == 0) goto L_0x010e
            r16 = 1
            goto L_0x0132
        L_0x0130:
            r16 = r4
        L_0x0132:
            r8 = r16
            int r9 = androidx.compose.ui.input.pointer.PointerInputEventProcessorKt.ProcessResult(r0, r8)     // Catch:{ all -> 0x013d }
            r1.isProcessing = r4
            r4 = r5
            r5 = r8
            return r9
        L_0x013d:
            r0 = move-exception
            goto L_0x0142
        L_0x013f:
            r0 = move-exception
            r7 = r26
        L_0x0142:
            r1.isProcessing = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputEventProcessor.m6209processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent, androidx.compose.ui.input.pointer.PositionCalculator, boolean):int");
    }

    public final void processCancel() {
        if (!this.isProcessing) {
            this.pointerInputChangeEventProducer.clear();
            this.hitPathTracker.processCancel();
        }
    }
}
