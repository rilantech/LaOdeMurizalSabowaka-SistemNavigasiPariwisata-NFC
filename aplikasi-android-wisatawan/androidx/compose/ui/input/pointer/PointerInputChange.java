package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B^\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011BT\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0014Bp\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001aBd\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0006\u00108\u001a\u000209Jw\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJo\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJw\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJm\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ}\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\t2\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\b\u0010K\u001a\u00020LH\u0016R\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\"R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188GX\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b*\u0010\u001e\u001a\u0004\b)\u0010+R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010(\u001a\u0004\b,\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010(\u001a\u0004\b3\u0010'R\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "pressure", "", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "(JJJZFJJZZILjava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "get_historical$annotations", "()V", "<set-?>", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "isConsumed", "isConsumed$annotations", "()Z", "getPosition-F1C5BW0", "getPressed", "getPressure", "()F", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerEvent.kt */
public final class PointerInputChange {
    public static final int $stable = 0;
    private List<HistoricalChange> _historical;
    private ConsumedData consumed;
    private final long id;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, (List<HistoricalChange>) list, j6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, z3, i, j6);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    public static /* synthetic */ void getHistorical$annotations() {
    }

    private static /* synthetic */ void get_historical$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    private PointerInputChange(long id2, long uptimeMillis2, long position2, boolean pressed2, float pressure2, long previousUptimeMillis2, long previousPosition2, boolean previousPressed2, boolean isInitiallyConsumed, int type2, long scrollDelta2) {
        this.id = id2;
        this.uptimeMillis = uptimeMillis2;
        this.position = position2;
        this.pressed = pressed2;
        this.pressure = pressure2;
        this.previousUptimeMillis = previousUptimeMillis2;
        this.previousPosition = previousPosition2;
        this.previousPressed = previousPressed2;
        this.type = type2;
        this.scrollDelta = scrollDelta2;
        boolean z = isInitiallyConsumed;
        this.consumed = new ConsumedData(z, z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputChange(long r22, long r24, long r26, boolean r28, float r29, long r30, long r32, boolean r34, boolean r35, int r36, long r37, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4559getTouchT8wyACA()
            r17 = r1
            goto L_0x0011
        L_0x000f:
            r17 = r36
        L_0x0011:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3019getZeroF1C5BW0()
            r18 = r0
            goto L_0x0020
        L_0x001e:
            r18 = r37
        L_0x0020:
            r20 = 0
            r2 = r21
            r3 = r22
            r5 = r24
            r7 = r26
            r9 = r28
            r10 = r29
            r11 = r30
            r13 = r32
            r15 = r34
            r16 = r35
            r2.<init>((long) r3, (long) r5, (long) r7, (boolean) r9, (float) r10, (long) r11, (long) r13, (boolean) r15, (boolean) r16, (int) r17, (long) r18, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputChange.<init>(long, long, long, boolean, float, long, long, boolean, boolean, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m4479getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m4480getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getPreviousPosition-F1C5BW0  reason: not valid java name */
    public final long m4481getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m4483getTypeT8wyACA() {
        return this.type;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m4482getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputChange(long r21, long r23, long r25, boolean r27, long r28, long r30, boolean r32, boolean r33, int r34, long r35, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m4559getTouchT8wyACA()
            r16 = r1
            goto L_0x0011
        L_0x000f:
            r16 = r34
        L_0x0011:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x001e
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3019getZeroF1C5BW0()
            r17 = r0
            goto L_0x0020
        L_0x001e:
            r17 = r35
        L_0x0020:
            r19 = 0
            r2 = r20
            r3 = r21
            r5 = r23
            r7 = r25
            r9 = r27
            r10 = r28
            r12 = r30
            r14 = r32
            r15 = r33
            r2.<init>((long) r3, (long) r5, (long) r7, (boolean) r9, (long) r10, (long) r12, (boolean) r14, (boolean) r15, (int) r16, (long) r17, (kotlin.jvm.internal.DefaultConstructorMarker) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputChange.<init>(long, long, long, boolean, long, long, boolean, boolean, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private PointerInputChange(long id2, long uptimeMillis2, long position2, boolean pressed2, long previousUptimeMillis2, long previousPosition2, boolean previousPressed2, boolean isInitiallyConsumed, int type2, long scrollDelta2) {
        this(id2, uptimeMillis2, position2, pressed2, 1.0f, previousUptimeMillis2, previousPosition2, previousPressed2, isInitiallyConsumed, type2, scrollDelta2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, (i2 & 256) != 0 ? PointerType.Companion.m4559getTouchT8wyACA() : i, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private PointerInputChange(long id2, long uptimeMillis2, long position2, boolean pressed2, long previousUptimeMillis2, long previousPosition2, boolean previousPressed2, ConsumedData consumed2, int type2) {
        this(id2, uptimeMillis2, position2, pressed2, 1.0f, previousUptimeMillis2, previousPosition2, previousPressed2, consumed2.getDownChange() || consumed2.getPositionChange(), type2, Offset.Companion.m3019getZeroF1C5BW0(), (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(consumed2, "consumed");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private PointerInputChange(long id2, long uptimeMillis2, long position2, boolean pressed2, float pressure2, long previousUptimeMillis2, long previousPosition2, boolean previousPressed2, boolean isInitiallyConsumed, int type2, List<HistoricalChange> historical, long scrollDelta2) {
        this(id2, uptimeMillis2, position2, pressed2, pressure2, previousUptimeMillis2, previousPosition2, previousPressed2, isInitiallyConsumed, type2, scrollDelta2, (DefaultConstructorMarker) null);
        List<HistoricalChange> list = historical;
        Intrinsics.checkNotNullParameter(list, "historical");
        this._historical = list;
    }

    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    /* renamed from: copy-Ezr-O64$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4468copyEzrO64$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, Object obj) {
        long j6;
        long j7;
        long j8;
        boolean z3;
        long j9;
        long j10;
        boolean z4;
        ConsumedData consumedData2;
        int i3;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i4 = i2;
        if ((i4 & 1) != 0) {
            j6 = pointerInputChange2.id;
        } else {
            j6 = j;
        }
        if ((i4 & 2) != 0) {
            j7 = pointerInputChange2.uptimeMillis;
        } else {
            j7 = j2;
        }
        if ((i4 & 4) != 0) {
            j8 = pointerInputChange2.position;
        } else {
            j8 = j3;
        }
        if ((i4 & 8) != 0) {
            z3 = pointerInputChange2.pressed;
        } else {
            z3 = z;
        }
        if ((i4 & 16) != 0) {
            j9 = pointerInputChange2.previousUptimeMillis;
        } else {
            j9 = j4;
        }
        if ((i4 & 32) != 0) {
            j10 = pointerInputChange2.previousPosition;
        } else {
            j10 = j5;
        }
        if ((i4 & 64) != 0) {
            z4 = pointerInputChange2.previousPressed;
        } else {
            z4 = z2;
        }
        if ((i4 & 128) != 0) {
            consumedData2 = pointerInputChange2.consumed;
        } else {
            consumedData2 = consumedData;
        }
        if ((i4 & 256) != 0) {
            i3 = pointerInputChange2.type;
        } else {
            i3 = i;
        }
        return pointerInputChange.m4474copyEzrO64(j6, j7, j8, z3, j9, j10, z4, consumedData2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* renamed from: copy-Ezr-O64  reason: not valid java name */
    public final /* synthetic */ PointerInputChange m4474copyEzrO64(long id2, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition2, boolean previousPressed2, ConsumedData consumed2, int type2) {
        ConsumedData consumedData = consumed2;
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        PointerInputChange pointerInputChange = new PointerInputChange(id2, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition2, previousPressed2, consumed2.getDownChange() || consumed2.getPositionChange(), type2, (List) getHistorical(), this.scrollDelta, (DefaultConstructorMarker) null);
        this.consumed = consumedData;
        return pointerInputChange;
    }

    /* renamed from: copy-JKmWfYY$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4469copyJKmWfYY$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9;
        boolean z3;
        long j10;
        long j11;
        boolean z4;
        int i3;
        int i4;
        long j12;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i5 = i2;
        if ((i5 & 1) != 0) {
            j7 = pointerInputChange2.id;
        } else {
            j7 = j;
        }
        if ((i5 & 2) != 0) {
            j8 = pointerInputChange2.uptimeMillis;
        } else {
            j8 = j2;
        }
        if ((i5 & 4) != 0) {
            j9 = pointerInputChange2.position;
        } else {
            j9 = j3;
        }
        if ((i5 & 8) != 0) {
            z3 = pointerInputChange2.pressed;
        } else {
            z3 = z;
        }
        if ((i5 & 16) != 0) {
            j10 = pointerInputChange2.previousUptimeMillis;
        } else {
            j10 = j4;
        }
        if ((i5 & 32) != 0) {
            j11 = pointerInputChange2.previousPosition;
        } else {
            j11 = j5;
        }
        if ((i5 & 64) != 0) {
            z4 = pointerInputChange2.previousPressed;
        } else {
            z4 = z2;
        }
        if ((i5 & 128) != 0) {
            i3 = pointerInputChange2.type;
        } else {
            i3 = i;
        }
        if ((i5 & 256) != 0) {
            i4 = i3;
            j12 = pointerInputChange2.scrollDelta;
        } else {
            i4 = i3;
            j12 = j6;
        }
        return pointerInputChange.m4475copyJKmWfYY(j7, j8, j9, z3, j10, j11, z4, i4, j12);
    }

    /* renamed from: copy-JKmWfYY  reason: not valid java name */
    public final PointerInputChange m4475copyJKmWfYY(long id2, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition2, boolean previousPressed2, int type2, long scrollDelta2) {
        return m4478copywbzehF4(id2, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition2, previousPressed2, type2, getHistorical(), scrollDelta2);
    }

    /* renamed from: copy-0GkPj7c$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4467copy0GkPj7c$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9;
        boolean z3;
        long j10;
        long j11;
        boolean z4;
        int i3;
        int i4;
        long j12;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i5 = i2;
        if ((i5 & 1) != 0) {
            j7 = pointerInputChange2.id;
        } else {
            j7 = j;
        }
        if ((i5 & 2) != 0) {
            j8 = pointerInputChange2.uptimeMillis;
        } else {
            j8 = j2;
        }
        if ((i5 & 4) != 0) {
            j9 = pointerInputChange2.position;
        } else {
            j9 = j3;
        }
        if ((i5 & 8) != 0) {
            z3 = pointerInputChange2.pressed;
        } else {
            z3 = z;
        }
        if ((i5 & 16) != 0) {
            j10 = pointerInputChange2.previousUptimeMillis;
        } else {
            j10 = j4;
        }
        if ((i5 & 32) != 0) {
            j11 = pointerInputChange2.previousPosition;
        } else {
            j11 = j5;
        }
        if ((i5 & 64) != 0) {
            z4 = pointerInputChange2.previousPressed;
        } else {
            z4 = z2;
        }
        if ((i5 & 256) != 0) {
            i3 = pointerInputChange2.type;
        } else {
            i3 = i;
        }
        if ((i5 & 512) != 0) {
            i4 = i3;
            j12 = pointerInputChange2.scrollDelta;
        } else {
            i4 = i3;
            j12 = j6;
        }
        return pointerInputChange.m4473copy0GkPj7c(j7, j8, j9, z3, j10, j11, z4, consumedData, i4, j12);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    /* renamed from: copy-0GkPj7c  reason: not valid java name */
    public final PointerInputChange m4473copy0GkPj7c(long id2, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition2, boolean previousPressed2, ConsumedData consumed2, int type2, long scrollDelta2) {
        ConsumedData consumedData = consumed2;
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        PointerInputChange pointerInputChange = new PointerInputChange(id2, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition2, previousPressed2, consumed2.getDownChange() || consumed2.getPositionChange(), type2, (List) getHistorical(), scrollDelta2, (DefaultConstructorMarker) null);
        this.consumed = consumedData;
        return pointerInputChange;
    }

    /* renamed from: copy-Tn9QgHE$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4471copyTn9QgHE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9;
        boolean z3;
        float f2;
        long j10;
        long j11;
        boolean z4;
        int i3;
        int i4;
        boolean z5;
        long j12;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i5 = i2;
        if ((i5 & 1) != 0) {
            j7 = pointerInputChange2.id;
        } else {
            j7 = j;
        }
        if ((i5 & 2) != 0) {
            j8 = pointerInputChange2.uptimeMillis;
        } else {
            j8 = j2;
        }
        if ((i5 & 4) != 0) {
            j9 = pointerInputChange2.position;
        } else {
            j9 = j3;
        }
        if ((i5 & 8) != 0) {
            z3 = pointerInputChange2.pressed;
        } else {
            z3 = z;
        }
        if ((i5 & 16) != 0) {
            f2 = pointerInputChange2.pressure;
        } else {
            f2 = f;
        }
        if ((i5 & 32) != 0) {
            j10 = pointerInputChange2.previousUptimeMillis;
        } else {
            j10 = j4;
        }
        if ((i5 & 64) != 0) {
            j11 = pointerInputChange2.previousPosition;
        } else {
            j11 = j5;
        }
        if ((i5 & 128) != 0) {
            z4 = pointerInputChange2.previousPressed;
        } else {
            z4 = z2;
        }
        if ((i5 & 256) != 0) {
            i3 = pointerInputChange2.type;
        } else {
            i3 = i;
        }
        if ((i5 & 512) != 0) {
            z5 = z4;
            i4 = i3;
            j12 = pointerInputChange2.scrollDelta;
        } else {
            z5 = z4;
            i4 = i3;
            j12 = j6;
        }
        return pointerInputChange.m4477copyTn9QgHE(j7, j8, j9, z3, f2, j10, j11, z5, i4, j12);
    }

    /* renamed from: copy-Tn9QgHE  reason: not valid java name */
    public final PointerInputChange m4477copyTn9QgHE(long id2, long currentTime, long currentPosition, boolean currentPressed, float pressure2, long previousTime, long previousPosition2, boolean previousPressed2, int type2, long scrollDelta2) {
        PointerInputChange it = new PointerInputChange(id2, currentTime, currentPosition, currentPressed, pressure2, previousTime, previousPosition2, previousPressed2, false, type2, (List) getHistorical(), scrollDelta2, (DefaultConstructorMarker) null);
        it.consumed = this.consumed;
        return it;
    }

    /* renamed from: copy-OHpmEuE$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4470copyOHpmEuE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9;
        boolean z3;
        long j10;
        long j11;
        boolean z4;
        int i3;
        int i4;
        long j12;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i5 = i2;
        if ((i5 & 1) != 0) {
            j7 = pointerInputChange2.id;
        } else {
            j7 = j;
        }
        if ((i5 & 2) != 0) {
            j8 = pointerInputChange2.uptimeMillis;
        } else {
            j8 = j2;
        }
        if ((i5 & 4) != 0) {
            j9 = pointerInputChange2.position;
        } else {
            j9 = j3;
        }
        if ((i5 & 8) != 0) {
            z3 = pointerInputChange2.pressed;
        } else {
            z3 = z;
        }
        if ((i5 & 16) != 0) {
            j10 = pointerInputChange2.previousUptimeMillis;
        } else {
            j10 = j4;
        }
        if ((i5 & 32) != 0) {
            j11 = pointerInputChange2.previousPosition;
        } else {
            j11 = j5;
        }
        if ((i5 & 64) != 0) {
            z4 = pointerInputChange2.previousPressed;
        } else {
            z4 = z2;
        }
        if ((i5 & 128) != 0) {
            i3 = pointerInputChange2.type;
        } else {
            i3 = i;
        }
        if ((i5 & 512) != 0) {
            i4 = i3;
            j12 = pointerInputChange2.scrollDelta;
        } else {
            i4 = i3;
            j12 = j6;
        }
        return pointerInputChange.m4476copyOHpmEuE(j7, j8, j9, z3, j10, j11, z4, i4, list, j12);
    }

    /* renamed from: copy-OHpmEuE  reason: not valid java name */
    public final PointerInputChange m4476copyOHpmEuE(long id2, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition2, boolean previousPressed2, int type2, List<HistoricalChange> historical, long scrollDelta2) {
        Intrinsics.checkNotNullParameter(historical, "historical");
        return m4478copywbzehF4(id2, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition2, previousPressed2, type2, historical, scrollDelta2);
    }

    /* renamed from: copy-wbzehF4$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m4472copywbzehF4$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9;
        boolean z3;
        float f2;
        long j10;
        long j11;
        boolean z4;
        int i3;
        List list2;
        List list3;
        boolean z5;
        long j12;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i4 = i2;
        if ((i4 & 1) != 0) {
            j7 = pointerInputChange2.id;
        } else {
            j7 = j;
        }
        if ((i4 & 2) != 0) {
            j8 = pointerInputChange2.uptimeMillis;
        } else {
            j8 = j2;
        }
        if ((i4 & 4) != 0) {
            j9 = pointerInputChange2.position;
        } else {
            j9 = j3;
        }
        if ((i4 & 8) != 0) {
            z3 = pointerInputChange2.pressed;
        } else {
            z3 = z;
        }
        if ((i4 & 16) != 0) {
            f2 = pointerInputChange2.pressure;
        } else {
            f2 = f;
        }
        if ((i4 & 32) != 0) {
            j10 = pointerInputChange2.previousUptimeMillis;
        } else {
            j10 = j4;
        }
        if ((i4 & 64) != 0) {
            j11 = pointerInputChange2.previousPosition;
        } else {
            j11 = j5;
        }
        if ((i4 & 128) != 0) {
            z4 = pointerInputChange2.previousPressed;
        } else {
            z4 = z2;
        }
        if ((i4 & 256) != 0) {
            i3 = pointerInputChange2.type;
        } else {
            i3 = i;
        }
        int i5 = i3;
        if ((i4 & 512) != 0) {
            list2 = pointerInputChange.getHistorical();
        } else {
            list2 = list;
        }
        if ((i4 & 1024) != 0) {
            z5 = z4;
            list3 = list2;
            j12 = pointerInputChange2.scrollDelta;
        } else {
            z5 = z4;
            list3 = list2;
            j12 = j6;
        }
        return pointerInputChange.m4478copywbzehF4(j7, j8, j9, z3, f2, j10, j11, z5, i5, list3, j12);
    }

    /* renamed from: copy-wbzehF4  reason: not valid java name */
    public final PointerInputChange m4478copywbzehF4(long id2, long currentTime, long currentPosition, boolean currentPressed, float pressure2, long previousTime, long previousPosition2, boolean previousPressed2, int type2, List<HistoricalChange> historical, long scrollDelta2) {
        Intrinsics.checkNotNullParameter(historical, "historical");
        PointerInputChange it = new PointerInputChange(id2, currentTime, currentPosition, currentPressed, pressure2, previousTime, previousPosition2, previousPressed2, false, type2, (List) historical, scrollDelta2, (DefaultConstructorMarker) null);
        it.consumed = this.consumed;
        return it;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PointerInputChange(id=").append(PointerId.m4465toStringimpl(this.id)).append(", uptimeMillis=").append(this.uptimeMillis).append(", position=").append(Offset.m3011toStringimpl(this.position)).append(", pressed=").append(this.pressed).append(", pressure=").append(this.pressure).append(", previousUptimeMillis=").append(this.previousUptimeMillis).append(", previousPosition=").append(Offset.m3011toStringimpl(this.previousPosition)).append(", previousPressed=").append(this.previousPressed).append(", isConsumed=").append(isConsumed()).append(", type=").append(PointerType.m4554toStringimpl(this.type)).append(", historical=").append(getHistorical()).append(",scrollDelta=");
        sb.append(Offset.m3011toStringimpl(this.scrollDelta)).append(')');
        return sb.toString();
    }
}
