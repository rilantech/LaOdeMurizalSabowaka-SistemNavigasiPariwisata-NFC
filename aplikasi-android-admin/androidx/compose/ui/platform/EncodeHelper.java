package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidClipboardManager.android.kt */
public final class EncodeHelper {
    private Parcel parcel;

    public EncodeHelper() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final String encodedString() {
        String encodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return encodeToString;
    }

    public final void encode(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        if (!Color.m4964equalsimpl0(spanStyle.m6994getColor0d7_KjU(), Color.Companion.m4999getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m6794encode8_81llA(spanStyle.m6994getColor0d7_KjU());
        }
        if (!TextUnit.m7732equalsimpl0(spanStyle.m6995getFontSizeXSAIIZE(), TextUnit.Companion.m7746getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m6791encodeR2X_6o(spanStyle.m6995getFontSizeXSAIIZE());
        }
        FontWeight it = spanStyle.getFontWeight();
        if (it != null) {
            encode((byte) 3);
            encode(it);
        }
        FontStyle r0 = spanStyle.m6996getFontStyle4Lr2A7w();
        if (r0 != null) {
            int it2 = r0.m7137unboximpl();
            encode((byte) 4);
            m6796encodenzbMABs(it2);
        }
        FontSynthesis r02 = spanStyle.m6997getFontSynthesisZQGJjVo();
        if (r02 != null) {
            int it3 = r02.m7148unboximpl();
            encode((byte) 5);
            m6793encode6p3vJLY(it3);
        }
        String it4 = spanStyle.getFontFeatureSettings();
        if (it4 != null) {
            encode((byte) 6);
            encode(it4);
        }
        if (!TextUnit.m7732equalsimpl0(spanStyle.m6998getLetterSpacingXSAIIZE(), TextUnit.Companion.m7746getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m6791encodeR2X_6o(spanStyle.m6998getLetterSpacingXSAIIZE());
        }
        BaselineShift r03 = spanStyle.m6993getBaselineShift5SSeXJ0();
        if (r03 != null) {
            float it5 = r03.m7315unboximpl();
            encode((byte) 8);
            m6792encode4Dl_Bck(it5);
        }
        TextGeometricTransform it6 = spanStyle.getTextGeometricTransform();
        if (it6 != null) {
            encode((byte) 9);
            encode(it6);
        }
        if (!Color.m4964equalsimpl0(spanStyle.m6992getBackground0d7_KjU(), Color.Companion.m4999getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m6794encode8_81llA(spanStyle.m6992getBackground0d7_KjU());
        }
        TextDecoration it7 = spanStyle.getTextDecoration();
        if (it7 != null) {
            encode((byte) 11);
            encode(it7);
        }
        Shadow it8 = spanStyle.getShadow();
        if (it8 != null) {
            encode((byte) 12);
            encode(it8);
        }
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m6794encode8_81llA(long color) {
        m6795encodeVKZWuLQ(color);
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m6791encodeR2X_6o(long textUnit) {
        long r0 = TextUnit.m7734getTypeUIouoOA(textUnit);
        byte typeCode = 0;
        if (!TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7769getUnspecifiedUIouoOA())) {
            if (TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7768getSpUIouoOA())) {
                typeCode = 1;
            } else if (TextUnitType.m7763equalsimpl0(r0, TextUnitType.Companion.m7767getEmUIouoOA())) {
                typeCode = 2;
            }
        }
        encode(typeCode);
        if (!TextUnitType.m7763equalsimpl0(TextUnit.m7734getTypeUIouoOA(textUnit), TextUnitType.Companion.m7769getUnspecifiedUIouoOA())) {
            encode(TextUnit.m7735getValueimpl(textUnit));
        }
    }

    public final void encode(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m6796encodenzbMABs(int fontStyle) {
        byte b = 0;
        if (!FontStyle.m7134equalsimpl0(fontStyle, FontStyle.Companion.m7139getNormal_LCdwA()) && FontStyle.m7134equalsimpl0(fontStyle, FontStyle.Companion.m7138getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m6793encode6p3vJLY(int fontSynthesis) {
        byte value = 0;
        if (!FontSynthesis.m7143equalsimpl0(fontSynthesis, FontSynthesis.Companion.m7150getNoneGVVA2EU())) {
            if (FontSynthesis.m7143equalsimpl0(fontSynthesis, FontSynthesis.Companion.m7149getAllGVVA2EU())) {
                value = 1;
            } else if (FontSynthesis.m7143equalsimpl0(fontSynthesis, FontSynthesis.Companion.m7152getWeightGVVA2EU())) {
                value = 2;
            } else if (FontSynthesis.m7143equalsimpl0(fontSynthesis, FontSynthesis.Companion.m7151getStyleGVVA2EU())) {
                value = 3;
            }
        }
        encode(value);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m6792encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        m6794encode8_81llA(shadow.m5320getColor0d7_KjU());
        encode(Offset.m4713getXimpl(shadow.m5321getOffsetF1C5BW0()));
        encode(Offset.m4714getYimpl(shadow.m5321getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m6795encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    public final void encode(String string) {
        Intrinsics.checkNotNullParameter(string, TypedValues.Custom.S_STRING);
        this.parcel.writeString(string);
    }
}
