package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPicker$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ StateData $stateData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPicker$1(StateData stateData, DatePickerColors datePickerColors, Modifier modifier, Function1<? super Integer, Unit> function1, int i) {
        super(2);
        this.$stateData = stateData;
        this.$colors = datePickerColors;
        this.$modifier = modifier;
        this.$onYearSelected = function1;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        long containerColor;
        Object value$iv$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1640@67154L329,1648@67656L11,1653@67868L24,1654@67933L53,1655@68025L51,1656@68085L2826:DatePicker.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-145469688, i, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1636)");
            }
            int currentYear = this.$stateData.getCurrentMonth().getYear();
            int displayedYear = this.$stateData.getDisplayedMonth().getYear();
            final LazyGridState lazyGridState = LazyGridStateKt.rememberLazyGridState(Integer.max(0, (displayedYear - this.$stateData.getYearRange().getFirst()) - 3), 0, composer, 0, 2);
            composer.startReplaceableGroup(-969349200);
            ComposerKt.sourceInformation(composer, "1649@67705L11,1649@67769L7");
            if (Color.m4964equalsimpl0(this.$colors.m3409getContainerColor0d7_KjU$material3_release(), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m3333getSurface0d7_KjU())) {
                ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(SurfaceKt.getLocalAbsoluteTonalElevation());
                ComposerKt.sourceInformationMarkerEnd($composer);
                containerColor = ColorSchemeKt.m3374surfaceColorAtElevation3ABfNKs(colorScheme, ((Dp) consume).m7568unboximpl());
            } else {
                containerColor = this.$colors.m3409getContainerColor0d7_KjU$material3_release();
            }
            $composer.endReplaceableGroup();
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer.endReplaceableGroup();
            String scrollToEarlierYearsLabel = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3719getDatePickerScrollToShowEarlierYearsadMyvUU(), composer, 6);
            String scrollToLaterYearsLabel = Strings_androidKt.m3763getStringNWtq28(Strings.Companion.m3720getDatePickerScrollToShowLaterYearsadMyvUU(), composer, 6);
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(BackgroundKt.m1877backgroundbw27NRU$default(this.$modifier, containerColor, (Shape) null, 2, (Object) null), false, AnonymousClass1.INSTANCE, 1, (Object) null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            StateData stateData = this.$stateData;
            Function1<Integer, Unit> function1 = this.$onYearSelected;
            final StateData stateData2 = stateData;
            final int i2 = displayedYear;
            final int i3 = currentYear;
            final Function1<Integer, Unit> function12 = function1;
            final int i4 = this.$$dirty;
            final DatePickerColors datePickerColors = this.$colors;
            final String str = scrollToEarlierYearsLabel;
            final String str2 = scrollToLaterYearsLabel;
            LazyGridDslKt.LazyVerticalGrid(fixed, semantics$default, lazyGridState, (PaddingValues) null, false, Arrangement.INSTANCE.m2132spacedBy0680j_4(DatePickerKt.YearsVerticalPadding), spaceEvenly, (FlingBehavior) null, false, new Function1<LazyGridScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((LazyGridScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridScope $this$LazyVerticalGrid) {
                    Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
                    int count = CollectionsKt.count(stateData2.getYearRange());
                    final StateData stateData = stateData2;
                    final int i = i2;
                    final int i2 = i3;
                    final Function1<Integer, Unit> function1 = function12;
                    final int i3 = i4;
                    final DatePickerColors datePickerColors = datePickerColors;
                    final LazyGridState lazyGridState = lazyGridState;
                    final CoroutineScope coroutineScope = coroutineScope;
                    final String str = str;
                    final String str2 = str2;
                    LazyGridScope.items$default($this$LazyVerticalGrid, count, (Function1) null, (Function2) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1369226173, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                            invoke((LazyGridItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:31:0x013b  */
                        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void invoke(androidx.compose.foundation.lazy.grid.LazyGridItemScope r24, int r25, androidx.compose.runtime.Composer r26, int r27) {
                            /*
                                r23 = this;
                                r0 = r23
                                r7 = r25
                                r15 = r26
                                r14 = r27
                                java.lang.String r1 = "$this$items"
                                r13 = r24
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
                                java.lang.String r1 = "C1697@70359L32,*1698@70427L54,1672@68906L1981:DatePicker.kt#uh7d8r"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
                                r1 = r27
                                r2 = r14 & 112(0x70, float:1.57E-43)
                                if (r2 != 0) goto L_0x0026
                                boolean r2 = r15.changed((int) r7)
                                if (r2 == 0) goto L_0x0023
                                r2 = 32
                                goto L_0x0025
                            L_0x0023:
                                r2 = 16
                            L_0x0025:
                                r1 = r1 | r2
                            L_0x0026:
                                r12 = r1
                                r1 = r12 & 721(0x2d1, float:1.01E-42)
                                r2 = 144(0x90, float:2.02E-43)
                                if (r1 != r2) goto L_0x003a
                                boolean r1 = r26.getSkipping()
                                if (r1 != 0) goto L_0x0034
                                goto L_0x003a
                            L_0x0034:
                                r26.skipToGroupEnd()
                                r1 = r12
                                goto L_0x013e
                            L_0x003a:
                                boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r1 == 0) goto L_0x0049
                                r1 = -1
                                java.lang.String r2 = "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1669)"
                                r3 = 1369226173(0x519cbbbd, float:8.4145578E10)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r1, r2)
                            L_0x0049:
                                androidx.compose.material3.StateData r1 = r4
                                kotlin.ranges.IntRange r1 = r1.getYearRange()
                                int r1 = r1.getFirst()
                                int r11 = r7 + r1
                                java.lang.String r10 = androidx.compose.material3.DatePickerKt.toLocalString(r11)
                                androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                                androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
                                androidx.compose.material3.tokens.DatePickerModalTokens r2 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
                                float r2 = r2.m4107getSelectionYearContainerWidthD9Ej5fM()
                                androidx.compose.material3.tokens.DatePickerModalTokens r3 = androidx.compose.material3.tokens.DatePickerModalTokens.INSTANCE
                                float r3 = r3.m4106getSelectionYearContainerHeightD9Ej5fM()
                                androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m2316requiredSizeVpY3zN4(r1, r2, r3)
                                androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1 r9 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1
                                androidx.compose.foundation.lazy.grid.LazyGridState r2 = r10
                                kotlinx.coroutines.CoroutineScope r4 = r11
                                java.lang.String r5 = r12
                                java.lang.String r6 = r13
                                r1 = r9
                                r3 = r25
                                r1.<init>(r2, r3, r4, r5, r6)
                                kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                                r1 = 0
                                r2 = 0
                                r3 = 1
                                androidx.compose.ui.Modifier r8 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r8, r2, r9, r3, r1)
                                int r1 = r5
                                if (r11 != r1) goto L_0x008c
                                r9 = r3
                                goto L_0x008d
                            L_0x008c:
                                r9 = r2
                            L_0x008d:
                                int r1 = r6
                                if (r11 != r1) goto L_0x0092
                                r2 = r3
                            L_0x0092:
                                kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r1 = r7
                                java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
                                kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r5 = r7
                                int r6 = r8
                                int r6 = r6 >> 3
                                r6 = r6 & 14
                                r16 = 0
                                r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
                                r15.startReplaceableGroup(r3)
                                java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
                                boolean r3 = r15.changed((java.lang.Object) r1)
                                boolean r17 = r15.changed((java.lang.Object) r4)
                                r3 = r3 | r17
                                r17 = r26
                                r18 = 0
                                r19 = r1
                                java.lang.Object r1 = r17.rememberedValue()
                                r20 = 0
                                if (r3 != 0) goto L_0x00d6
                                androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
                                r22 = r3
                                java.lang.Object r3 = r21.getEmpty()
                                if (r1 != r3) goto L_0x00d1
                                goto L_0x00d8
                            L_0x00d1:
                                r21 = r1
                                r3 = r17
                                goto L_0x00e9
                            L_0x00d6:
                                r22 = r3
                            L_0x00d8:
                                r3 = 0
                                r21 = r1
                                androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$2$1 r1 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$2$1
                                r1.<init>(r5, r11)
                                kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
                                r3 = r17
                                r3.updateRememberedValue(r1)
                            L_0x00e9:
                                r26.endReplaceableGroup()
                                kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
                                androidx.compose.material3.Strings$Companion r3 = androidx.compose.material3.Strings.Companion
                                int r3 = r3.m3717getDatePickerNavigateToYearDescriptionadMyvUU()
                                r4 = 6
                                java.lang.String r3 = androidx.compose.material3.Strings_androidKt.m3763getStringNWtq28(r3, r15, r4)
                                java.lang.Object[] r4 = new java.lang.Object[]{r10}
                                r5 = 1
                                java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r5)
                                java.lang.String r3 = java.lang.String.format(r3, r4)
                                java.lang.String r4 = "format(this, *args)"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                                androidx.compose.material3.DatePickerColors r4 = r9
                                androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$3 r6 = new androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$3
                                r6.<init>(r10)
                                r7 = 2095319565(0x7ce40a0d, float:9.47238E36)
                                androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r7, r5, r6)
                                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                                int r6 = r8
                                int r6 = r6 << 9
                                r7 = 458752(0x70000, float:6.42848E-40)
                                r6 = r6 & r7
                                r7 = 1572864(0x180000, float:2.204052E-39)
                                r16 = r6 | r7
                                r6 = r10
                                r10 = r2
                                r2 = r11
                                r11 = r1
                                r1 = r12
                                r12 = r3
                                r13 = r4
                                r14 = r5
                                r15 = r26
                                androidx.compose.material3.DatePickerKt.Year(r8, r9, r10, r11, r12, r13, r14, r15, r16)
                                boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r3 == 0) goto L_0x013e
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            L_0x013e:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$YearPicker$1.AnonymousClass2.AnonymousClass1.invoke(androidx.compose.foundation.lazy.grid.LazyGridItemScope, int, androidx.compose.runtime.Composer, int):void");
                        }
                    }), 14, (Object) null);
                }
            }, $composer, 1769472, 408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
