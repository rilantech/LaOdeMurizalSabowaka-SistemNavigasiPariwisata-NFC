package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSizeKt$textFieldMinSize$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSizeKt$textFieldMinSize$1(TextStyle textStyle) {
        super(3);
        this.$style = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(1582736677);
        ComposerKt.sourceInformation(composer, "C38@1591L7,39@1652L7,40@1707L7,42@1740L88,45@1849L312,54@2186L101:TextFieldSize.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1582736677, $changed, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        ComposerKt.sourceInformationMarkerEnd($composer);
        FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        Object key1$iv = this.$style;
        TextStyle textStyle = this.$style;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed((Object) layoutDirection);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        TextStyle resolvedStyle = (TextStyle) value$iv$iv;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) fontFamilyResolver) | composer.changed((Object) resolvedStyle);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
            FontFamily fontFamily = resolvedStyle.getFontFamily();
            FontWeight fontWeight = resolvedStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontWeight fontWeight2 = fontWeight;
            FontStyle r16 = resolvedStyle.m7058getFontStyle4Lr2A7w();
            int $changed$iv = r16 != null ? r16.m7137unboximpl() : FontStyle.Companion.m7139getNormal_LCdwA();
            FontSynthesis r162 = resolvedStyle.m7059getFontSynthesisZQGJjVo();
            value$iv$iv2 = fontFamilyResolver.m7108resolveDPcqOEQ(fontFamily, fontWeight2, $changed$iv, r162 != null ? r162.m7148unboximpl() : FontSynthesis.Companion.m7149getAllGVVA2EU());
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        State typeface$delegate = (State) value$iv$iv2;
        TextStyle textStyle2 = this.$style;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv3 = $composer;
        Object value$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
        if (value$iv$iv3 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv3;
            value$iv$iv3 = new TextFieldSize(layoutDirection, density, fontFamilyResolver, textStyle2, invoke$lambda$2(typeface$delegate));
            $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
        } else {
            Object it$iv$iv3 = value$iv$iv3;
            Composer composer2 = $this$cache$iv$iv3;
        }
        $composer.endReplaceableGroup();
        final TextFieldSize minSizeState = (TextFieldSize) value$iv$iv3;
        minSizeState.update(layoutDirection, density, fontFamilyResolver, resolvedStyle, invoke$lambda$2(typeface$delegate));
        Modifier layout = LayoutModifierKt.layout(Modifier.Companion, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                return m2683invoke3p2s80s((MeasureScope) p1, (Measurable) p2, ((Constraints) p3).m7504unboximpl());
            }

            /* renamed from: invoke-3p2s80s  reason: not valid java name */
            public final MeasureResult m2683invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                Measurable measurable2 = measurable;
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable2, "measurable");
                SizeKt.m2307defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, (Object) null);
                long minSize = minSizeState.m2682getMinSizeYbymL2g();
                final Placeable measured = measurable2.m6399measureBRTryo0(Constraints.m7489copyZbe2FdA$default(constraints, RangesKt.coerceIn(IntSize.m7714getWidthimpl(minSize), Constraints.m7500getMinWidthimpl(constraints), Constraints.m7498getMaxWidthimpl(constraints)), 0, RangesKt.coerceIn(IntSize.m7713getHeightimpl(minSize), Constraints.m7499getMinHeightimpl(constraints), Constraints.m7497getMaxHeightimpl(constraints)), 0, 10, (Object) null));
                return MeasureScope.layout$default($this$layout, measured.getWidth(), measured.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((Placeable.PlacementScope) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope $this$layout) {
                        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default($this$layout, measured, 0, 0, 0.0f, 4, (Object) null);
                    }
                }, 4, (Object) null);
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return layout;
    }

    /* access modifiers changed from: private */
    public static final Object invoke$lambda$2(State<? extends Object> $typeface$delegate) {
        return $typeface$delegate.getValue();
    }
}
