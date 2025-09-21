package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B$\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tB\u0014\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\b\u0010\fJ1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00078Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f\u0001\n\u0001\u00020\u000bø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "constructor-impl", "(III)I", "mask", "", "(I)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-gijOMQM", "(IIII)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: LineBreak.android.kt */
public final class LineBreak {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Heading = m5630constructorimpl(Strategy.Companion.m5651getBalancedfcGXIks(), Strictness.Companion.m5662getLooseusljTpc(), WordBreak.Companion.m5673getPhrasejp8hJ3c());
    /* access modifiers changed from: private */
    public static final int Paragraph = m5630constructorimpl(Strategy.Companion.m5652getHighQualityfcGXIks(), Strictness.Companion.m5664getStrictusljTpc(), WordBreak.Companion.m5672getDefaultjp8hJ3c());
    /* access modifiers changed from: private */
    public static final int Simple = m5630constructorimpl(Strategy.Companion.m5653getSimplefcGXIks(), Strictness.Companion.m5663getNormalusljTpc(), WordBreak.Companion.m5672getDefaultjp8hJ3c());
    private final int mask;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ LineBreak m5628boximpl(int i) {
        return new LineBreak(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m5629constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5633equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).m5640unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5634equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5638hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5633equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m5638hashCodeimpl(this.mask);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5640unboximpl() {
        return this.mask;
    }

    private /* synthetic */ LineBreak(int mask2) {
        this.mask = mask2;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5630constructorimpl(int strategy, int strictness, int wordBreak) {
        return m5629constructorimpl(LineBreak_androidKt.packBytes(strategy, strictness, wordBreak));
    }

    /* renamed from: getStrategy-fcGXIks  reason: not valid java name */
    public static final int m5635getStrategyfcGXIks(int arg0) {
        return Strategy.m5645constructorimpl(LineBreak_androidKt.unpackByte1(arg0));
    }

    /* renamed from: getStrictness-usljTpc  reason: not valid java name */
    public static final int m5636getStrictnessusljTpc(int arg0) {
        return Strictness.m5655constructorimpl(LineBreak_androidKt.unpackByte2(arg0));
    }

    /* renamed from: getWordBreak-jp8hJ3c  reason: not valid java name */
    public static final int m5637getWordBreakjp8hJ3c(int arg0) {
        return WordBreak.m5666constructorimpl(LineBreak_androidKt.unpackByte3(arg0));
    }

    /* renamed from: copy-gijOMQM$default  reason: not valid java name */
    public static /* synthetic */ int m5632copygijOMQM$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = m5635getStrategyfcGXIks(i);
        }
        if ((i5 & 2) != 0) {
            i3 = m5636getStrictnessusljTpc(i);
        }
        if ((i5 & 4) != 0) {
            i4 = m5637getWordBreakjp8hJ3c(i);
        }
        return m5631copygijOMQM(i, i2, i3, i4);
    }

    /* renamed from: copy-gijOMQM  reason: not valid java name */
    public static final int m5631copygijOMQM(int arg0, int strategy, int strictness, int wordBreak) {
        return m5630constructorimpl(strategy, strictness, wordBreak);
    }

    public String toString() {
        return m5639toStringimpl(this.mask);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5639toStringimpl(int arg0) {
        return "LineBreak(strategy=" + Strategy.m5649toStringimpl(m5635getStrategyfcGXIks(arg0)) + ", strictness=" + Strictness.m5659toStringimpl(m5636getStrictnessusljTpc(arg0)) + ", wordBreak=" + WordBreak.m5670toStringimpl(m5637getWordBreakjp8hJ3c(arg0)) + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "()V", "Heading", "Landroidx/compose/ui/text/style/LineBreak;", "getHeading-rAG3T2k", "()I", "I", "Paragraph", "getParagraph-rAG3T2k", "Simple", "getSimple-rAG3T2k", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineBreak.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getSimple-rAG3T2k  reason: not valid java name */
        public final int m5643getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* renamed from: getHeading-rAG3T2k  reason: not valid java name */
        public final int m5641getHeadingrAG3T2k() {
            return LineBreak.Heading;
        }

        /* renamed from: getParagraph-rAG3T2k  reason: not valid java name */
        public final int m5642getParagraphrAG3T2k() {
            return LineBreak.Paragraph;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineBreak.android.kt */
    public static final class Strategy {
        /* access modifiers changed from: private */
        public static final int Balanced = m5645constructorimpl(3);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int HighQuality = m5645constructorimpl(2);
        /* access modifiers changed from: private */
        public static final int Simple = m5645constructorimpl(1);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strategy m5644boximpl(int i) {
            return new Strategy(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m5645constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5646equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).m5650unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5647equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5648hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m5646equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5648hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5650unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "()V", "Balanced", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getBalanced-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Simple", "getSimple-fcGXIks", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineBreak.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getSimple-fcGXIks  reason: not valid java name */
            public final int m5653getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* renamed from: getHighQuality-fcGXIks  reason: not valid java name */
            public final int m5652getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getBalanced-fcGXIks  reason: not valid java name */
            public final int m5651getBalancedfcGXIks() {
                return Strategy.Balanced;
            }
        }

        private /* synthetic */ Strategy(int value2) {
            this.value = value2;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5649toStringimpl(int arg0) {
            if (m5647equalsimpl0(arg0, Simple)) {
                return "Strategy.Simple";
            }
            if (m5647equalsimpl0(arg0, HighQuality)) {
                return "Strategy.HighQuality";
            }
            if (m5647equalsimpl0(arg0, Balanced)) {
                return "Strategy.Balanced";
            }
            return "Invalid";
        }

        public String toString() {
            return m5649toStringimpl(this.value);
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineBreak.android.kt */
    public static final class Strictness {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Default = m5655constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Loose = m5655constructorimpl(2);
        /* access modifiers changed from: private */
        public static final int Normal = m5655constructorimpl(3);
        /* access modifiers changed from: private */
        public static final int Strict = m5655constructorimpl(4);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strictness m5654boximpl(int i) {
            return new Strictness(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m5655constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5656equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).m5660unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5657equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5658hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m5656equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5658hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5660unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineBreak.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getDefault-usljTpc  reason: not valid java name */
            public final int m5661getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc  reason: not valid java name */
            public final int m5662getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc  reason: not valid java name */
            public final int m5663getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc  reason: not valid java name */
            public final int m5664getStrictusljTpc() {
                return Strictness.Strict;
            }
        }

        private /* synthetic */ Strictness(int value2) {
            this.value = value2;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5659toStringimpl(int arg0) {
            if (m5657equalsimpl0(arg0, Default)) {
                return "Strictness.None";
            }
            if (m5657equalsimpl0(arg0, Loose)) {
                return "Strictness.Loose";
            }
            if (m5657equalsimpl0(arg0, Normal)) {
                return "Strictness.Normal";
            }
            if (m5657equalsimpl0(arg0, Strict)) {
                return "Strictness.Strict";
            }
            return "Invalid";
        }

        public String toString() {
            return m5659toStringimpl(this.value);
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineBreak.android.kt */
    public static final class WordBreak {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Default = m5666constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Phrase = m5666constructorimpl(2);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ WordBreak m5665boximpl(int i) {
            return new WordBreak(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m5666constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5667equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).m5671unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5668equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5669hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m5667equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5669hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5671unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineBreak.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getDefault-jp8hJ3c  reason: not valid java name */
            public final int m5672getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c  reason: not valid java name */
            public final int m5673getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }
        }

        private /* synthetic */ WordBreak(int value2) {
            this.value = value2;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5670toStringimpl(int arg0) {
            if (m5668equalsimpl0(arg0, Default)) {
                return "WordBreak.None";
            }
            if (m5668equalsimpl0(arg0, Phrase)) {
                return "WordBreak.Phrase";
            }
            return "Invalid";
        }

        public String toString() {
            return m5670toStringimpl(this.value);
        }
    }
}
