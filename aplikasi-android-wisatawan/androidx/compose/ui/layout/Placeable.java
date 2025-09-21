package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J@\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010$¢\u0006\u0002\b&H$ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(R)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@DX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR/\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@DX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "()J", "J", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "onMeasuredSizeChanged", "", "placeAt", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "PlacementScope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Placeable.kt */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public long apparentToRealOffset = IntOffset.Companion.m5972getZeronOccac();
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private int width;

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public abstract void m4726placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1);

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredWidth() {
        return IntSize.m6004getWidthimpl(this.measuredSize);
    }

    public int getMeasuredHeight() {
        return IntSize.m6003getHeightimpl(this.measuredSize);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g  reason: not valid java name */
    public final long m4724getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasuredSize-ozmzZPI  reason: not valid java name */
    public final void m4727setMeasuredSizeozmzZPI(long value) {
        if (!IntSize.m6002equalsimpl0(this.measuredSize, value)) {
            this.measuredSize = value;
            onMeasuredSizeChanged();
        }
    }

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(IntSize.m6004getWidthimpl(this.measuredSize), Constraints.m5790getMinWidthimpl(this.measurementConstraints), Constraints.m5788getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m6003getHeightimpl(this.measuredSize), Constraints.m5789getMinHeightimpl(this.measurementConstraints), Constraints.m5787getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m6004getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m6003getHeightimpl(this.measuredSize)) / 2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasurementConstraints-msEJaDk  reason: not valid java name */
    public final long m4725getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0  reason: not valid java name */
    public final void m4728setMeasurementConstraintsBRTryo0(long value) {
        if (!Constraints.m5781equalsimpl0(this.measurementConstraints, value)) {
            this.measurementConstraints = value;
            onMeasuredSizeChanged();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac  reason: not valid java name */
    public final long m4723getApparentToRealOffsetnOccac() {
        return this.apparentToRealOffset;
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JJ\u0010\u001a\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u001b\b\b\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001c¢\u0006\u0002\b\u001eH\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 JJ\u0010!\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u001b\b\b\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001c¢\u0006\u0002\b\u001eH\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010 J)\u0010#\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0017J$\u0010#\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JD\u0010%\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010 J?\u0010%\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eJD\u0010'\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010 J?\u0010'\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "place", "", "Landroidx/compose/ui/layout/Placeable;", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "placeWithLayer", "placeWithLayer-aW-9-wM", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Placeable.kt */
    public static abstract class PlacementScope {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static LayoutCoordinates _coordinates;
        /* access modifiers changed from: private */
        public static LayoutNodeLayoutDelegate layoutDelegate;
        /* access modifiers changed from: private */
        public static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;
        /* access modifiers changed from: private */
        public static int parentWidth;

        /* access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* access modifiers changed from: protected */
        public abstract int getParentWidth();

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        /* renamed from: placeRelative-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m4730placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m4736placeRelative70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        /* renamed from: placeRelative-70tqf50  reason: not valid java name */
        public final void m4736placeRelative70tqf50(Placeable $this$placeRelative_u2d70tqf50, long position, float zIndex) {
            float f = zIndex;
            Intrinsics.checkNotNullParameter($this$placeRelative_u2d70tqf50, "$this$placeRelative");
            Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv = $this$placeRelative_u2d70tqf50;
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
                long other$iv$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.apparentToRealOffset;
                $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position) + IntOffset.m5962getXimpl(other$iv$iv$iv), IntOffset.m5963getYimpl(position) + IntOffset.m5963getYimpl(other$iv$iv$iv)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long position$iv$iv = IntOffsetKt.IntOffset((getParentWidth() - $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv.getWidth()) - IntOffset.m5962getXimpl(position), IntOffset.m5963getYimpl(position));
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2 = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
            long other$iv$iv$iv2 = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv$iv) + IntOffset.m5962getXimpl(other$iv$iv$iv2), IntOffset.m5963getYimpl(position$iv$iv) + IntOffset.m5963getYimpl(other$iv$iv$iv2)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.placeRelative(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        public final void placeRelative(Placeable $this$placeRelative, int x, int y, float zIndex) {
            float f = zIndex;
            Intrinsics.checkNotNullParameter($this$placeRelative, "<this>");
            long position$iv = IntOffsetKt.IntOffset(x, y);
            Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv = $this$placeRelative;
            if (getParentLayoutDirection() != LayoutDirection.Ltr) {
                if (getParentWidth() != 0) {
                    long position$iv$iv = IntOffsetKt.IntOffset((getParentWidth() - $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv.getWidth()) - IntOffset.m5962getXimpl(position$iv), IntOffset.m5963getYimpl(position$iv));
                    Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
                    long other$iv$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.apparentToRealOffset;
                    $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv$iv) + IntOffset.m5962getXimpl(other$iv$iv$iv), IntOffset.m5963getYimpl(position$iv$iv) + IntOffset.m5963getYimpl(other$iv$iv$iv)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                    return;
                }
            }
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2 = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
            long other$iv$iv$iv2 = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv) + IntOffset.m5962getXimpl(other$iv$iv$iv2), IntOffset.m5963getYimpl(position$iv) + IntOffset.m5963getYimpl(other$iv$iv$iv2)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.place(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        public final void place(Placeable $this$place, int x, int y, float zIndex) {
            Placeable placeable = $this$place;
            Intrinsics.checkNotNullParameter($this$place, "<this>");
            long position$iv = IntOffsetKt.IntOffset(x, y);
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv = $this$place;
            long other$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv) + IntOffset.m5962getXimpl(other$iv$iv), IntOffset.m5963getYimpl(position$iv) + IntOffset.m5963getYimpl(other$iv$iv)), zIndex, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m4729place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m4733place70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        /* renamed from: place-70tqf50  reason: not valid java name */
        public final void m4733place70tqf50(Placeable $this$place_u2d70tqf50, long position, float zIndex) {
            Intrinsics.checkNotNullParameter($this$place_u2d70tqf50, "$this$place");
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv = $this$place_u2d70tqf50;
            long other$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position) + IntOffset.m5962getXimpl(other$iv$iv), IntOffset.m5963getYimpl(position) + IntOffset.m5963getYimpl(other$iv$iv)), zIndex, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m4731placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            float f2;
            Function1 function12;
            if (obj == null) {
                if ((i & 2) != 0) {
                    f2 = 0.0f;
                } else {
                    f2 = f;
                }
                if ((i & 4) != 0) {
                    function12 = PlaceableKt.DefaultLayerBlock;
                } else {
                    function12 = function1;
                }
                placementScope.m4737placeRelativeWithLayeraW9wM(placeable, j, f2, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m4737placeRelativeWithLayeraW9wM(Placeable $this$placeRelativeWithLayer_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            float f = zIndex;
            Function1<? super GraphicsLayerScope, Unit> function1 = layerBlock;
            Intrinsics.checkNotNullParameter($this$placeRelativeWithLayer_u2daW_u2d9_u2dwM, "$this$placeRelativeWithLayer");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv = $this$placeRelativeWithLayer_u2daW_u2d9_u2dwM;
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
                long other$iv$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.apparentToRealOffset;
                $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position) + IntOffset.m5962getXimpl(other$iv$iv$iv), IntOffset.m5963getYimpl(position) + IntOffset.m5963getYimpl(other$iv$iv$iv)), f, function1);
                return;
            }
            long position$iv$iv = IntOffsetKt.IntOffset((getParentWidth() - $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv.getWidth()) - IntOffset.m5962getXimpl(position), IntOffset.m5963getYimpl(position));
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2 = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
            long other$iv$iv$iv2 = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv$iv) + IntOffset.m5962getXimpl(other$iv$iv$iv2), IntOffset.m5963getYimpl(position$iv$iv) + IntOffset.m5963getYimpl(other$iv$iv$iv2)), f, function1);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            float f2;
            Function1 function12;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f2 = 0.0f;
                } else {
                    f2 = f;
                }
                if ((i3 & 8) != 0) {
                    function12 = PlaceableKt.DefaultLayerBlock;
                } else {
                    function12 = function1;
                }
                placementScope.placeRelativeWithLayer(placeable, i, i2, f2, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public final void placeRelativeWithLayer(Placeable $this$placeRelativeWithLayer, int x, int y, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            float f = zIndex;
            Function1<? super GraphicsLayerScope, Unit> function1 = layerBlock;
            Intrinsics.checkNotNullParameter($this$placeRelativeWithLayer, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long position$iv = IntOffsetKt.IntOffset(x, y);
            Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv = $this$placeRelativeWithLayer;
            if (getParentLayoutDirection() != LayoutDirection.Ltr) {
                if (getParentWidth() != 0) {
                    long position$iv$iv = IntOffsetKt.IntOffset((getParentWidth() - $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv.getWidth()) - IntOffset.m5962getXimpl(position$iv), IntOffset.m5963getYimpl(position$iv));
                    Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
                    long other$iv$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.apparentToRealOffset;
                    $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv$iv) + IntOffset.m5962getXimpl(other$iv$iv$iv), IntOffset.m5963getYimpl(position$iv$iv) + IntOffset.m5963getYimpl(other$iv$iv$iv)), f, function1);
                    return;
                }
            }
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2 = $this$placeAutoMirrored_u2daW_u2d9_u2dwM$iv;
            long other$iv$iv$iv2 = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv$iv2.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv) + IntOffset.m5962getXimpl(other$iv$iv$iv2), IntOffset.m5963getYimpl(position$iv) + IntOffset.m5963getYimpl(other$iv$iv$iv2)), f, function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            float f2;
            Function1 function12;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f2 = 0.0f;
                } else {
                    f2 = f;
                }
                if ((i3 & 8) != 0) {
                    function12 = PlaceableKt.DefaultLayerBlock;
                } else {
                    function12 = function1;
                }
                placementScope.placeWithLayer(placeable, i, i2, f2, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public final void placeWithLayer(Placeable $this$placeWithLayer, int x, int y, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            Function1<? super GraphicsLayerScope, Unit> function1 = layerBlock;
            Placeable placeable = $this$placeWithLayer;
            Intrinsics.checkNotNullParameter($this$placeWithLayer, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long position$iv = IntOffsetKt.IntOffset(x, y);
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv = $this$placeWithLayer;
            long other$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv) + IntOffset.m5962getXimpl(other$iv$iv), IntOffset.m5963getYimpl(position$iv) + IntOffset.m5963getYimpl(other$iv$iv)), zIndex, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m4732placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            float f2;
            Function1 function12;
            if (obj == null) {
                if ((i & 2) != 0) {
                    f2 = 0.0f;
                } else {
                    f2 = f;
                }
                if ((i & 4) != 0) {
                    function12 = PlaceableKt.DefaultLayerBlock;
                } else {
                    function12 = function1;
                }
                placementScope.m4738placeWithLayeraW9wM(placeable, j, f2, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        /* renamed from: placeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m4738placeWithLayeraW9wM(Placeable $this$placeWithLayer_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            Intrinsics.checkNotNullParameter($this$placeWithLayer_u2daW_u2d9_u2dwM, "$this$placeWithLayer");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv = $this$placeWithLayer_u2daW_u2d9_u2dwM;
            long other$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position) + IntOffset.m5962getXimpl(other$iv$iv), IntOffset.m5963getYimpl(position) + IntOffset.m5963getYimpl(other$iv$iv)), zIndex, layerBlock);
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release  reason: not valid java name */
        public final void m4735placeAutoMirroredaW9wM$ui_release(Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            float f = zIndex;
            Function1<? super GraphicsLayerScope, Unit> function1 = layerBlock;
            Intrinsics.checkNotNullParameter($this$placeAutoMirrored_u2daW_u2d9_u2dwM, "$this$placeAutoMirrored");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM;
                long other$iv$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.apparentToRealOffset;
                $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position) + IntOffset.m5962getXimpl(other$iv$iv), IntOffset.m5963getYimpl(position) + IntOffset.m5963getYimpl(other$iv$iv)), f, function1);
                return;
            }
            long position$iv = IntOffsetKt.IntOffset((getParentWidth() - $this$placeAutoMirrored_u2daW_u2d9_u2dwM.getWidth()) - IntOffset.m5962getXimpl(position), IntOffset.m5963getYimpl(position));
            Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv2 = $this$placeAutoMirrored_u2daW_u2d9_u2dwM;
            long other$iv$iv2 = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv2.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM$iv2.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position$iv) + IntOffset.m5962getXimpl(other$iv$iv2), IntOffset.m5963getYimpl(position$iv) + IntOffset.m5963getYimpl(other$iv$iv2)), f, function1);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release  reason: not valid java name */
        public final void m4734placeApparentToRealOffsetaW9wM$ui_release(Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            Intrinsics.checkNotNullParameter($this$placeApparentToRealOffset_u2daW_u2d9_u2dwM, "$this$placeApparentToRealOffset");
            long other$iv = $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM.apparentToRealOffset;
            $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM.m4726placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5962getXimpl(position) + IntOffset.m5962getXimpl(other$iv), IntOffset.m5963getYimpl(position) + IntOffset.m5963getYimpl(other$iv)), zIndex, layerBlock);
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002JA\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0019\b\u0004\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\u0002\b\u001cH\bø\u0001\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope$Companion;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "()V", "_coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "<set-?>", "Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "", "parentWidth", "getParentWidth", "()I", "configureForPlacingForAlignment", "", "scope", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "executeWithRtlMirroringValues", "", "lookaheadCapablePlaceable", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Placeable.kt */
        public static final class Companion extends PlacementScope {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: protected */
            public LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            /* access modifiers changed from: protected */
            public int getParentWidth() {
                return PlacementScope.parentWidth;
            }

            public LayoutCoordinates getCoordinates() {
                LayoutNodeLayoutDelegate access$getLayoutDelegate$cp;
                if (PlacementScope._coordinates == null && (access$getLayoutDelegate$cp = PlacementScope.layoutDelegate) != null) {
                    access$getLayoutDelegate$cp.onCoordinatesUsed();
                }
                return PlacementScope._coordinates;
            }

            public final void executeWithRtlMirroringValues(int parentWidth, LayoutDirection parentLayoutDirection, LookaheadCapablePlaceable lookaheadCapablePlaceable, Function1<? super PlacementScope, Unit> block) {
                Intrinsics.checkNotNullParameter(parentLayoutDirection, "parentLayoutDirection");
                Intrinsics.checkNotNullParameter(block, "block");
                LayoutCoordinates previousLayoutCoordinates = PlacementScope._coordinates;
                int previousParentWidth = PlacementScope.Companion.getParentWidth();
                LayoutDirection previousParentLayoutDirection = PlacementScope.Companion.getParentLayoutDirection();
                LayoutNodeLayoutDelegate previousLayoutDelegate = PlacementScope.layoutDelegate;
                Companion companion = PlacementScope.Companion;
                PlacementScope.parentWidth = parentWidth;
                Companion companion2 = PlacementScope.Companion;
                PlacementScope.parentLayoutDirection = parentLayoutDirection;
                boolean wasPlacingForAlignment = configureForPlacingForAlignment(lookaheadCapablePlaceable);
                block.invoke(this);
                if (lookaheadCapablePlaceable != null) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(wasPlacingForAlignment);
                }
                Companion companion3 = PlacementScope.Companion;
                PlacementScope.parentWidth = previousParentWidth;
                Companion companion4 = PlacementScope.Companion;
                PlacementScope.parentLayoutDirection = previousParentLayoutDirection;
                PlacementScope._coordinates = previousLayoutCoordinates;
                PlacementScope.layoutDelegate = previousLayoutDelegate;
            }

            /* access modifiers changed from: private */
            public final boolean configureForPlacingForAlignment(LookaheadCapablePlaceable scope) {
                if (scope == null) {
                    PlacementScope._coordinates = null;
                    PlacementScope.layoutDelegate = null;
                    return false;
                }
                boolean wasPlacingForAlignment = scope.isPlacingForAlignment$ui_release();
                LookaheadCapablePlaceable parent = scope.getParent();
                boolean z = false;
                if (parent != null && parent.isPlacingForAlignment$ui_release()) {
                    z = true;
                }
                if (z) {
                    scope.setPlacingForAlignment$ui_release(true);
                }
                PlacementScope.layoutDelegate = scope.getLayoutNode().getLayoutDelegate$ui_release();
                if (scope.isPlacingForAlignment$ui_release() || scope.isShallowPlacing$ui_release()) {
                    PlacementScope._coordinates = null;
                    return wasPlacingForAlignment;
                }
                PlacementScope._coordinates = scope.getCoordinates();
                return wasPlacingForAlignment;
            }
        }
    }
}
