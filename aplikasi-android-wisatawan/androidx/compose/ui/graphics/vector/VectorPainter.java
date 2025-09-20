package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002Jd\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2;\u0010,\u001a7\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020'0-¢\u0006\u0002\b/H\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u000fH\u0014J\u0012\u00104\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0011H\u0014JR\u00106\u001a\u00020\r2\u0006\u00107\u001a\u0002082;\u00109\u001a7\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020'0-¢\u0006\u0002\b/H\u0002¢\u0006\u0002\u0010:J\f\u0010;\u001a\u00020'*\u00020<H\u0014R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048@@@X\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118@@@X\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u00020\u00198VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR4\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "()V", "<set-?>", "", "autoMirror", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror$delegate", "Landroidx/compose/runtime/MutableState;", "composition", "Landroidx/compose/runtime/Composition;", "currentAlpha", "", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "isDirty", "setDirty", "isDirty$delegate", "size", "getSize-NH-jbRc$ui_release", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "RenderVector", "", "name", "", "viewportWidth", "viewportHeight", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "RenderVector$ui_release", "(Ljava/lang/String;FFLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "composeVector", "parent", "Landroidx/compose/runtime/CompositionContext;", "composable", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function4;)Landroidx/compose/runtime/Composition;", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainter extends Painter {
    public static final int $stable = 8;
    private final MutableState autoMirror$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    private final MutableState isDirty$delegate;
    private final MutableState size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3060boximpl(Size.Companion.m3081getZeroNHjbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public final VectorComponent vector;

    public VectorPainter() {
        VectorComponent $this$vector_u24lambda_u240 = new VectorComponent();
        $this$vector_u24lambda_u240.setInvalidateCallback$ui_release(new VectorPainter$vector$1$1(this));
        this.vector = $this$vector_u24lambda_u240;
        this.isDirty$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentAlpha = 1.0f;
    }

    /* renamed from: getSize-NH-jbRc$ui_release  reason: not valid java name */
    public final long m3982getSizeNHjbRc$ui_release() {
        return ((Size) this.size$delegate.getValue()).m3077unboximpl();
    }

    /* renamed from: setSize-uvyYCjk$ui_release  reason: not valid java name */
    public final void m3983setSizeuvyYCjk$ui_release(long j) {
        this.size$delegate.setValue(Size.m3060boximpl(j));
    }

    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror$delegate.getValue()).booleanValue();
    }

    public final void setAutoMirror$ui_release(boolean z) {
        this.autoMirror$delegate.setValue(Boolean.valueOf(z));
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter value) {
        this.vector.setIntrinsicColorFilter$ui_release(value);
    }

    private final Composition composeVector(CompositionContext parent, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> composable) {
        Composition next;
        Composition existing = this.composition;
        if (existing == null || existing.isDisposed()) {
            next = CompositionKt.Composition(new VectorApplier(this.vector.getRoot()), parent);
        } else {
            next = existing;
        }
        this.composition = next;
        next.setContent(ComposableLambdaKt.composableLambdaInstance(-1916507005, true, new VectorPainter$composeVector$1(composable, this)));
        return next;
    }

    private final boolean isDirty() {
        return ((Boolean) this.isDirty$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setDirty(boolean z) {
        this.isDirty$delegate.setValue(Boolean.valueOf(z));
    }

    public final void RenderVector$ui_release(String name, float viewportWidth, float viewportHeight, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        String str = name;
        Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4 = content;
        Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(function4, "content");
        Composer $composer2 = $composer.startRestartGroup(1264894527);
        ComposerKt.sourceInformation($composer2, "C(RenderVector)P(1,3,2)233@8813L28,237@8882L117:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264894527, $changed, -1, "androidx.compose.ui.graphics.vector.VectorPainter.RenderVector (VectorPainter.kt:221)");
        } else {
            int i = $changed;
        }
        VectorComponent $this$RenderVector_u24lambda_u241 = this.vector;
        $this$RenderVector_u24lambda_u241.setName(str);
        $this$RenderVector_u24lambda_u241.setViewportWidth(viewportWidth);
        $this$RenderVector_u24lambda_u241.setViewportHeight(viewportHeight);
        Composition composition2 = composeVector(ComposablesKt.rememberCompositionContext($composer2, 0), function4);
        EffectsKt.DisposableEffect((Object) composition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new VectorPainter$RenderVector$2(composition2), $composer2, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VectorPainter$RenderVector$3(this, name, viewportWidth, viewportHeight, content, $changed));
        }
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3981getIntrinsicSizeNHjbRc() {
        return m3982getSizeNHjbRc$ui_release();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope $this$onDraw) {
        DrawScope drawScope = $this$onDraw;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        VectorComponent $this$onDraw_u24lambda_u243 = this.vector;
        ColorFilter filter = this.currentColorFilter;
        if (filter == null) {
            filter = $this$onDraw_u24lambda_u243.getIntrinsicColorFilter$ui_release();
        }
        if (!getAutoMirror$ui_release() || $this$onDraw.getLayoutDirection() != LayoutDirection.Rtl) {
            $this$onDraw_u24lambda_u243.draw(drawScope, this.currentAlpha, filter);
        } else {
            DrawScope $this$mirror$iv = $this$onDraw;
            DrawScope $this$scale_u2dFgt4K4Q_u24default$iv$iv = $this$mirror$iv;
            long pivot$iv$iv = $this$scale_u2dFgt4K4Q_u24default$iv$iv.m3865getCenterF1C5BW0();
            DrawScope $this$withTransform$iv$iv$iv = $this$scale_u2dFgt4K4Q_u24default$iv$iv;
            DrawContext $this$withTransform_u24lambda_u246$iv$iv$iv = $this$withTransform$iv$iv$iv.getDrawContext();
            DrawScope drawScope2 = $this$mirror$iv;
            long previousSize$iv$iv$iv = $this$withTransform_u24lambda_u246$iv$iv$iv.m3809getSizeNHjbRc();
            $this$withTransform_u24lambda_u246$iv$iv$iv.getCanvas().save();
            $this$withTransform_u24lambda_u246$iv$iv$iv.getTransform().m3925scale0AR0LA0(-1.0f, 1.0f, pivot$iv$iv);
            $this$onDraw_u24lambda_u243.draw($this$withTransform$iv$iv$iv, this.currentAlpha, filter);
            $this$withTransform_u24lambda_u246$iv$iv$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv$iv.m3810setSizeuvyYCjk(previousSize$iv$iv$iv);
        }
        if (isDirty()) {
            setDirty(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }
}
