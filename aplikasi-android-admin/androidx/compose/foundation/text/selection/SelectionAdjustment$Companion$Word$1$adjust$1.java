package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
/* synthetic */ class SelectionAdjustment$Companion$Word$1$adjust$1 extends FunctionReferenceImpl implements Function1<Integer, TextRange> {
    SelectionAdjustment$Companion$Word$1$adjust$1(Object obj) {
        super(1, obj, TextLayoutResult.class, "getWordBoundary", "getWordBoundary--jx7JFs(I)J", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return TextRange.m7023boximpl(m2778invokejx7JFs(((Number) p1).intValue()));
    }

    /* renamed from: invoke--jx7JFs  reason: not valid java name */
    public final long m2778invokejx7JFs(int p0) {
        return ((TextLayoutResult) this.receiver).m7009getWordBoundaryjx7JFs(p0);
    }
}
