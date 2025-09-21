package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockFace$2 extends Lambda implements Function3<List<? extends Integer>, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockFace$2(TimePickerState timePickerState, boolean z, TimePickerColors timePickerColors, int i) {
        super(3);
        this.$state = timePickerState;
        this.$autoSwitchToMinute = z;
        this.$colors = timePickerColors;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((List<Integer>) (List) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(List<Integer> screen, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        ComposerKt.sourceInformation($composer, "C1140@44371L1479:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1628166511, $changed, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1139)");
        }
        Modifier access$drawSelector = TimePickerKt.drawSelector(SizeKt.m612size3ABfNKs(TimePickerKt.clockDial(Modifier.Companion, this.$state, this.$autoSwitchToMinute), TimePickerTokens.INSTANCE.m2762getClockDialContainerSizeD9Ej5fM()), this.$state, this.$colors);
        float access$getOuterCircleSizeRadius$p = TimePickerKt.OuterCircleSizeRadius;
        final TimePickerColors timePickerColors = this.$colors;
        final TimePickerState timePickerState = this.$state;
        final boolean z = this.$autoSwitchToMinute;
        final int i = this.$$dirty;
        final List<Integer> list = screen;
        TimePickerKt.m2162CircularLayoutuFdPcIQ(access$drawSelector, access$getOuterCircleSizeRadius$p, ComposableLambdaKt.composableLambda($composer, -1385633737, true, new Function2<Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                invoke((Composer) p1, ((Number) p2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C1147@44633L1207:TimePicker.kt#uh7d8r");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1385633737, $changed, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1146)");
                    }
                    ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m3243boximpl(timePickerColors.m2151clockDialContentColorvNxB06k$material3_release(false)))};
                    final List<Integer> list = list;
                    final TimePickerState timePickerState = timePickerState;
                    final boolean z = z;
                    final int i = i;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, -2018362505, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                            invoke((Composer) p1, ((Number) p2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer, int $changed) {
                            int outerValue;
                            ComposerKt.sourceInformation($composer, "C1160@45216L592:TimePicker.kt#uh7d8r");
                            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2018362505, $changed, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1149)");
                                }
                                $composer.startReplaceableGroup(-504302403);
                                ComposerKt.sourceInformation($composer, "*1156@45037L64");
                                int size = list.size();
                                TimePickerState timePickerState = timePickerState;
                                List<Integer> list = list;
                                boolean z = z;
                                int i = i;
                                for (int i2 = 0; i2 < size; i2++) {
                                    int it = i2;
                                    if (!timePickerState.is24hour() || Selection.m1956equalsimpl0(timePickerState.m2191getSelectionJiIwxys$material3_release(), Selection.Companion.m1961getMinuteJiIwxys())) {
                                        outerValue = list.get(it).intValue();
                                    } else {
                                        outerValue = list.get(it).intValue() % 12;
                                    }
                                    TimePickerKt.ClockText(timePickerState, outerValue, z, $composer, (i & 14) | (i & 896));
                                }
                                $composer.endReplaceableGroup();
                                if (Selection.m1956equalsimpl0(timePickerState.m2191getSelectionJiIwxys$material3_release(), Selection.Companion.m1960getHourJiIwxys()) && timePickerState.is24hour()) {
                                    Modifier r4 = BackgroundKt.m166backgroundbw27NRU(SizeKt.m612size3ABfNKs(LayoutIdKt.layoutId(Modifier.Companion, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m2762getClockDialContainerSizeD9Ej5fM()), Color.Companion.m3288getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                    float access$getInnerCircleRadius$p = TimePickerKt.InnerCircleRadius;
                                    final TimePickerState timePickerState2 = timePickerState;
                                    final boolean z2 = z;
                                    final int i3 = i;
                                    TimePickerKt.m2162CircularLayoutuFdPcIQ(r4, access$getInnerCircleRadius$p, ComposableLambdaKt.composableLambda($composer, -448649404, true, new Function2<Composer, Integer, Unit>() {
                                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                            invoke((Composer) p1, ((Number) p2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer, int $changed) {
                                            ComposerKt.sourceInformation($composer, "C*1169@45696L64:TimePicker.kt#uh7d8r");
                                            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-448649404, $changed, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1166)");
                                                }
                                                int size = TimePickerKt.ExtraHours.size();
                                                TimePickerState timePickerState = timePickerState2;
                                                boolean z = z2;
                                                int i = i3;
                                                for (int it = 0; it < size; it++) {
                                                    TimePickerKt.ClockText(timePickerState, ((Number) TimePickerKt.ExtraHours.get(it)).intValue(), z, $composer, (i & 14) | (i & 896));
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer.skipToGroupEnd();
                                        }
                                    }), $composer, 432, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer.skipToGroupEnd();
                        }
                    }), $composer, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }), $composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
