package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/SpanStyle;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$SpanStyleSaver$1 extends Lambda implements Function2<SaverScope, SpanStyle, Object> {
    public static final SaversKt$SpanStyleSaver$1 INSTANCE = new SaversKt$SpanStyleSaver$1();

    SaversKt$SpanStyleSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope $this$Saver, SpanStyle it) {
        SaverScope saverScope = $this$Saver;
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.arrayListOf(SaversKt.save(Color.m4953boximpl(it.m6994getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope), SaversKt.save(TextUnit.m7725boximpl(it.m6995getFontSizeXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(it.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), saverScope), SaversKt.save(it.m6996getFontStyle4Lr2A7w()), SaversKt.save(it.m6997getFontSynthesisZQGJjVo()), SaversKt.save(-1), SaversKt.save(it.getFontFeatureSettings()), SaversKt.save(TextUnit.m7725boximpl(it.m6998getLetterSpacingXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(it.m6993getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), saverScope), SaversKt.save(it.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), saverScope), SaversKt.save(it.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), saverScope), SaversKt.save(Color.m4953boximpl(it.m6992getBackground0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope), SaversKt.save(it.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), saverScope), SaversKt.save(it.getShadow(), SaversKt.getSaver(Shadow.Companion), saverScope));
    }
}
