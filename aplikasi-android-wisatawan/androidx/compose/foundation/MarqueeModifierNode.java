package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B8\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u000209H\u0002J\u0011\u0010>\u001a\u000209H@ø\u0001\u0000¢\u0006\u0002\u0010?JC\u0010@\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\f\u0010C\u001a\u000209*\u00020DH\u0016J\u001c\u0010E\u001a\u00020\u0006*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0006H\u0016J\u001c\u0010J\u001a\u00020\u0006*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020\u0006H\u0016J)\u0010L\u001a\u00020M*\u00020N2\u0006\u0010G\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001c\u0010T\u001a\u00020\u0006*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0006H\u0016J\u001c\u0010U\u001a\u00020\u0006*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020\u0006H\u0016R4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R+\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R+\u0010%\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020$8B@BX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020-0,X\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0016\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00103\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b4\u0010\u0012R\u0019\u0010\r\u001a\u00020\u000eX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u00107\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getAnimationMode-ZbEOnfQ", "()I", "setAnimationMode-97h66l8", "(I)V", "animationMode$delegate", "Landroidx/compose/runtime/MutableState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "contentWidth", "getContentWidth", "setContentWidth", "contentWidth$delegate", "direction", "", "getDirection", "()F", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "offset", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "F", "onAttach", "", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {
    private final MutableState animationMode$delegate;
    private final MutableIntState containerWidth$delegate;
    private final MutableIntState contentWidth$delegate;
    /* access modifiers changed from: private */
    public int delayMillis;
    private final MutableState hasFocus$delegate;
    /* access modifiers changed from: private */
    public int initialDelayMillis;
    /* access modifiers changed from: private */
    public int iterations;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    /* access modifiers changed from: private */
    public float velocity;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BasicMarquee.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ MarqueeModifierNode(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, marqueeSpacing, f);
    }

    private MarqueeModifierNode(int iterations2, int animationMode, int delayMillis2, int initialDelayMillis2, MarqueeSpacing spacing, float velocity2) {
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        this.iterations = iterations2;
        this.delayMillis = delayMillis2;
        this.initialDelayMillis = initialDelayMillis2;
        this.velocity = velocity2;
        this.contentWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.spacing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(spacing, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animationMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m232boximpl(animationMode), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new MarqueeModifierNode$spacingPx$2(spacing, this));
    }

    /* access modifiers changed from: private */
    public final int getContentWidth() {
        return this.contentWidth$delegate.getIntValue();
    }

    private final void setContentWidth(int i) {
        this.contentWidth$delegate.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public final int getContainerWidth() {
        return this.containerWidth$delegate.getIntValue();
    }

    private final void setContainerWidth(int i) {
        this.containerWidth$delegate.setIntValue(i);
    }

    /* access modifiers changed from: private */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    private final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing$delegate.getValue();
    }

    public final void setSpacing(MarqueeSpacing marqueeSpacing) {
        Intrinsics.checkNotNullParameter(marqueeSpacing, "<set-?>");
        this.spacing$delegate.setValue(marqueeSpacing);
    }

    /* renamed from: getAnimationMode-ZbEOnfQ  reason: not valid java name */
    public final int m247getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode$delegate.getValue()).m238unboximpl();
    }

    /* renamed from: setAnimationMode-97h66l8  reason: not valid java name */
    public final void m249setAnimationMode97h66l8(int i) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.m232boximpl(i));
    }

    /* access modifiers changed from: private */
    public final float getDirection() {
        int i;
        float signum = Math.signum(this.velocity);
        switch (WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = -1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return signum * ((float) i);
    }

    /* access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx$delegate.getValue()).intValue();
    }

    public void onAttach() {
        restartAnimation();
    }

    /* renamed from: update-lWfNwf4  reason: not valid java name */
    public final void m250updatelWfNwf4(int iterations2, int animationMode, int delayMillis2, int initialDelayMillis2, MarqueeSpacing spacing, float velocity2) {
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        setSpacing(spacing);
        m249setAnimationMode97h66l8(animationMode);
        if (this.iterations != iterations2 || this.delayMillis != delayMillis2 || this.initialDelayMillis != initialDelayMillis2 || !Dp.m5849equalsimpl0(this.velocity, velocity2)) {
            this.iterations = iterations2;
            this.delayMillis = delayMillis2;
            this.initialDelayMillis = initialDelayMillis2;
            this.velocity = velocity2;
            restartAnimation();
        }
    }

    public void onFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        setHasFocus(focusState.getHasFocus());
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m248measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable placeable = measurable.m4689measureBRTryo0(Constraints.m5779copyZbe2FdA$default(constraints, 0, Integer.MAX_VALUE, 0, 0, 13, (Object) null));
        setContainerWidth(ConstraintsKt.m5802constrainWidthK40F9xA(constraints, placeable.getWidth()));
        setContentWidth(placeable.getWidth());
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, getContainerWidth(), placeable.getHeight(), (Map) null, new MarqueeModifierNode$measure$1(placeable, this), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return measurable.maxIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return measurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return measurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    public void draw(ContentDrawScope $this$draw) {
        boolean firstCopyVisible;
        boolean z;
        int i;
        ContentDrawScope contentDrawScope = $this$draw;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        float clipOffset = this.offset.getValue().floatValue() * getDirection();
        boolean z2 = true;
        if (getDirection() == 1.0f) {
            firstCopyVisible = this.offset.getValue().floatValue() < ((float) getContentWidth());
        } else {
            firstCopyVisible = this.offset.getValue().floatValue() < ((float) getContainerWidth());
        }
        if (getDirection() == 1.0f) {
            z = this.offset.getValue().floatValue() > ((float) ((getContentWidth() + getSpacingPx()) - getContainerWidth()));
        } else {
            z = this.offset.getValue().floatValue() > ((float) getSpacingPx());
        }
        boolean secondCopyVisible = z;
        if (getDirection() != 1.0f) {
            z2 = false;
        }
        if (z2) {
            i = getContentWidth() + getSpacingPx();
        } else {
            i = (-getContentWidth()) - getSpacingPx();
        }
        float secondCopyOffset = (float) i;
        DrawScope $this$clipRect_u2drOu3jXo_u24default$iv = contentDrawScope;
        float right$iv = clipOffset + ((float) getContainerWidth());
        float bottom$iv = Size.m3069getHeightimpl($this$clipRect_u2drOu3jXo_u24default$iv.m3866getSizeNHjbRc());
        int clipOp$iv = ClipOp.Companion.m3242getIntersectrtfAjoo();
        DrawScope $this$withTransform$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3809getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        long previousSize$iv$iv2 = previousSize$iv$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3921clipRectN_I0leg(clipOffset, 0.0f, right$iv, bottom$iv, clipOp$iv);
        DrawScope $this$draw_u24lambda_u241 = $this$withTransform$iv$iv;
        if (firstCopyVisible) {
            $this$draw.drawContent();
        }
        if (secondCopyVisible) {
            DrawScope $this$translate_u24default$iv = $this$draw_u24lambda_u241;
            float f = clipOffset;
            $this$translate_u24default$iv.getDrawContext().getTransform().translate(secondCopyOffset, 0.0f);
            DrawScope drawScope = $this$translate_u24default$iv;
            $this$draw.drawContent();
            boolean z3 = firstCopyVisible;
            DrawScope drawScope2 = $this$draw_u24lambda_u241;
            $this$translate_u24default$iv.getDrawContext().getTransform().translate(-secondCopyOffset, -0.0f);
        } else {
            boolean z4 = firstCopyVisible;
            DrawScope drawScope3 = $this$draw_u24lambda_u241;
        }
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv2.m3810setSizeuvyYCjk(previousSize$iv$iv2);
    }

    private final void restartAnimation() {
        if (isAttached()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new MarqueeModifierNode$restartAnimation$1(this, (Continuation<? super MarqueeModifierNode$restartAnimation$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object runAnimation(Continuation<? super Unit> $completion) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new MarqueeModifierNode$runAnimation$2(this, (Continuation<? super MarqueeModifierNode$runAnimation$2>) null), $completion);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
