package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u001a\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J)\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion;", "", "linearity", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "subpixelTextPositioning", "", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLinearity-4e0Vf04$ui_text_release", "()I", "I", "getSubpixelTextPositioning$ui_text_release", "()Z", "copy", "copy-JdDtMQo$ui_text_release", "(IZ)Landroidx/compose/ui/text/style/TextMotion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "Linearity", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMotion.android.kt */
public final class TextMotion {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final TextMotion Animated = new TextMotion(Linearity.Companion.m5744getLinear4e0Vf04(), true, (DefaultConstructorMarker) null);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextMotion Static = new TextMotion(Linearity.Companion.m5743getFontHinting4e0Vf04(), false, (DefaultConstructorMarker) null);
    private final int linearity;
    private final boolean subpixelTextPositioning;

    public /* synthetic */ TextMotion(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    private TextMotion(int linearity2, boolean subpixelTextPositioning2) {
        this.linearity = linearity2;
        this.subpixelTextPositioning = subpixelTextPositioning2;
    }

    /* renamed from: getLinearity-4e0Vf04$ui_text_release  reason: not valid java name */
    public final int m5735getLinearity4e0Vf04$ui_text_release() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text_release() {
        return this.subpixelTextPositioning;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Companion;", "", "()V", "Animated", "Landroidx/compose/ui/text/style/TextMotion;", "getAnimated", "()Landroidx/compose/ui/text/style/TextMotion;", "Static", "getStatic", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextMotion.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextMotion getStatic() {
            return TextMotion.Static;
        }

        public final TextMotion getAnimated() {
            return TextMotion.Animated;
        }
    }

    /* renamed from: copy-JdDtMQo$ui_text_release$default  reason: not valid java name */
    public static /* synthetic */ TextMotion m5733copyJdDtMQo$ui_text_release$default(TextMotion textMotion, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = textMotion.linearity;
        }
        if ((i2 & 2) != 0) {
            z = textMotion.subpixelTextPositioning;
        }
        return textMotion.m5734copyJdDtMQo$ui_text_release(i, z);
    }

    /* renamed from: copy-JdDtMQo$ui_text_release  reason: not valid java name */
    public final TextMotion m5734copyJdDtMQo$ui_text_release(int linearity2, boolean subpixelTextPositioning2) {
        return new TextMotion(linearity2, subpixelTextPositioning2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TextMotion) && Linearity.m5739equalsimpl0(this.linearity, ((TextMotion) other).linearity) && this.subpixelTextPositioning == ((TextMotion) other).subpixelTextPositioning) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Linearity.m5740hashCodeimpl(this.linearity) * 31) + Boolean.hashCode(this.subpixelTextPositioning);
    }

    public String toString() {
        if (Intrinsics.areEqual((Object) this, (Object) Static)) {
            return "TextMotion.Static";
        }
        if (Intrinsics.areEqual((Object) this, (Object) Animated)) {
            return "TextMotion.Animated";
        }
        return "Invalid";
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextMotion.android.kt */
    public static final class Linearity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int FontHinting = m5737constructorimpl(2);
        /* access modifiers changed from: private */
        public static final int Linear = m5737constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int None = m5737constructorimpl(3);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Linearity m5736boximpl(int i) {
            return new Linearity(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m5737constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5738equalsimpl(int i, Object obj) {
            return (obj instanceof Linearity) && i == ((Linearity) obj).m5742unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5739equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5740hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m5738equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5740hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5742unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;", "", "()V", "FontHinting", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "getFontHinting-4e0Vf04", "()I", "I", "Linear", "getLinear-4e0Vf04", "None", "getNone-4e0Vf04", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: TextMotion.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getLinear-4e0Vf04  reason: not valid java name */
            public final int m5744getLinear4e0Vf04() {
                return Linearity.Linear;
            }

            /* renamed from: getFontHinting-4e0Vf04  reason: not valid java name */
            public final int m5743getFontHinting4e0Vf04() {
                return Linearity.FontHinting;
            }

            /* renamed from: getNone-4e0Vf04  reason: not valid java name */
            public final int m5745getNone4e0Vf04() {
                return Linearity.None;
            }
        }

        private /* synthetic */ Linearity(int value2) {
            this.value = value2;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5741toStringimpl(int arg0) {
            if (m5739equalsimpl0(arg0, Linear)) {
                return "Linearity.Linear";
            }
            if (m5739equalsimpl0(arg0, FontHinting)) {
                return "Linearity.FontHinting";
            }
            if (m5739equalsimpl0(arg0, None)) {
                return "Linearity.None";
            }
            return "Invalid";
        }

        public String toString() {
            return m5741toStringimpl(this.value);
        }
    }
}
