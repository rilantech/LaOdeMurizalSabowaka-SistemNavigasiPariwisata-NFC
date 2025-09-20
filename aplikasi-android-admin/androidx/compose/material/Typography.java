package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012Bo\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015¨\u0006*"}, d2 = {"Landroidx/compose/material/Typography;", "", "defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "h1", "Landroidx/compose/ui/text/TextStyle;", "h2", "h3", "h4", "h5", "h6", "subtitle1", "subtitle2", "body1", "body2", "button", "caption", "overline", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBody1", "()Landroidx/compose/ui/text/TextStyle;", "getBody2", "getButton", "getCaption", "getH1", "getH2", "getH3", "getH4", "getH5", "getH6", "getOverline", "getSubtitle1", "getSubtitle2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Typography.kt */
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption;
    private final TextStyle h1;
    private final TextStyle h2;
    private final TextStyle h3;
    private final TextStyle h4;
    private final TextStyle h5;
    private final TextStyle h6;
    private final TextStyle overline;
    private final TextStyle subtitle1;
    private final TextStyle subtitle2;

    public Typography(TextStyle h12, TextStyle h22, TextStyle h32, TextStyle h42, TextStyle h52, TextStyle h62, TextStyle subtitle12, TextStyle subtitle22, TextStyle body12, TextStyle body22, TextStyle button2, TextStyle caption2, TextStyle overline2) {
        Intrinsics.checkNotNullParameter(h12, "h1");
        Intrinsics.checkNotNullParameter(h22, "h2");
        Intrinsics.checkNotNullParameter(h32, "h3");
        Intrinsics.checkNotNullParameter(h42, "h4");
        Intrinsics.checkNotNullParameter(h52, "h5");
        Intrinsics.checkNotNullParameter(h62, "h6");
        Intrinsics.checkNotNullParameter(subtitle12, "subtitle1");
        Intrinsics.checkNotNullParameter(subtitle22, "subtitle2");
        Intrinsics.checkNotNullParameter(body12, "body1");
        Intrinsics.checkNotNullParameter(body22, "body2");
        Intrinsics.checkNotNullParameter(button2, "button");
        Intrinsics.checkNotNullParameter(caption2, "caption");
        Intrinsics.checkNotNullParameter(overline2, "overline");
        this.h1 = h12;
        this.h2 = h22;
        this.h3 = h32;
        this.h4 = h42;
        this.h5 = h52;
        this.h6 = h62;
        this.subtitle1 = subtitle12;
        this.subtitle2 = subtitle22;
        this.body1 = body12;
        this.body2 = body22;
        this.button = button2;
        this.caption = caption2;
        this.overline = overline2;
    }

    public final TextStyle getH1() {
        return this.h1;
    }

    public final TextStyle getH2() {
        return this.h2;
    }

    public final TextStyle getH3() {
        return this.h3;
    }

    public final TextStyle getH4() {
        return this.h4;
    }

    public final TextStyle getH5() {
        return this.h5;
    }

    public final TextStyle getH6() {
        return this.h6;
    }

    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption() {
        return this.caption;
    }

    public final TextStyle getOverline() {
        return this.overline;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Typography(androidx.compose.ui.text.font.FontFamily r48, androidx.compose.ui.text.TextStyle r49, androidx.compose.ui.text.TextStyle r50, androidx.compose.ui.text.TextStyle r51, androidx.compose.ui.text.TextStyle r52, androidx.compose.ui.text.TextStyle r53, androidx.compose.ui.text.TextStyle r54, androidx.compose.ui.text.TextStyle r55, androidx.compose.ui.text.TextStyle r56, androidx.compose.ui.text.TextStyle r57, androidx.compose.ui.text.TextStyle r58, androidx.compose.ui.text.TextStyle r59, androidx.compose.ui.text.TextStyle r60, androidx.compose.ui.text.TextStyle r61, int r62, kotlin.jvm.internal.DefaultConstructorMarker r63) {
        /*
            r47 = this;
            r0 = r62
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000f
            androidx.compose.ui.text.font.FontFamily$Companion r1 = androidx.compose.ui.text.font.FontFamily.Companion
            androidx.compose.ui.text.font.SystemFontFamily r1 = r1.getDefault()
            androidx.compose.ui.text.font.FontFamily r1 = (androidx.compose.ui.text.font.FontFamily) r1
            goto L_0x0011
        L_0x000f:
            r1 = r48
        L_0x0011:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x005f
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r2 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r8 = r2.getLight()
            r2 = 96
            long r6 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r2)
            r4 = -4613937818241073152(0xbff8000000000000, double:-1.5)
            long r13 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r4)
            r33 = 16777081(0xffff79, float:2.3509698E-38)
            r34 = 0
            r4 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r3, r4, r6, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31, r32, r33, r34)
            goto L_0x0061
        L_0x005f:
            r2 = r49
        L_0x0061:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x00b0
            androidx.compose.ui.text.TextStyle r4 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r3 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r9 = r3.getLight()
            r3 = 60
            long r7 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r3)
            r5 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            long r14 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r5)
            r34 = 16777081(0xffff79, float:2.3509698E-38)
            r35 = 0
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r4, r5, r7, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33, r34, r35)
            goto L_0x00b2
        L_0x00b0:
            r3 = r50
        L_0x00b2:
            r4 = r0 & 8
            r5 = 0
            if (r4 == 0) goto L_0x0100
            androidx.compose.ui.text.TextStyle r6 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r4 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r4.getNormal()
            r4 = 48
            long r9 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r4)
            long r16 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r5)
            r36 = 16777081(0xffff79, float:2.3509698E-38)
            r37 = 0
            r7 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            androidx.compose.ui.text.TextStyle r4 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r6, r7, r9, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33, r34, r35, r36, r37)
            goto L_0x0102
        L_0x0100:
            r4 = r51
        L_0x0102:
            r6 = r0 & 16
            r7 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            if (r6 == 0) goto L_0x0154
            androidx.compose.ui.text.TextStyle r9 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r6 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r14 = r6.getNormal()
            r6 = 34
            long r12 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r6)
            long r19 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r7)
            r39 = 16777081(0xffff79, float:2.3509698E-38)
            r40 = 0
            r10 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            androidx.compose.ui.text.TextStyle r6 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r9, r10, r12, r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r33, r34, r35, r36, r37, r38, r39, r40)
            goto L_0x0156
        L_0x0154:
            r6 = r52
        L_0x0156:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x01a7
            androidx.compose.ui.text.TextStyle r10 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r9 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r15 = r9.getNormal()
            r9 = 24
            long r13 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r9)
            long r20 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r5)
            r40 = 16777081(0xffff79, float:2.3509698E-38)
            r41 = 0
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r10, r11, r13, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r29, r30, r31, r32, r34, r35, r36, r37, r38, r39, r40, r41)
            goto L_0x01a9
        L_0x01a7:
            r5 = r53
        L_0x01a9:
            r9 = r0 & 64
            r10 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            if (r9 == 0) goto L_0x01ff
            androidx.compose.ui.text.TextStyle r12 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r9 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r17 = r9.getMedium()
            r9 = 20
            long r15 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r9)
            long r22 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r10)
            r42 = 16777081(0xffff79, float:2.3509698E-38)
            r43 = 0
            r13 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            androidx.compose.ui.text.TextStyle r9 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r12, r13, r15, r17, r18, r19, r20, r21, r22, r24, r25, r26, r27, r29, r30, r31, r32, r33, r34, r36, r37, r38, r39, r40, r41, r42, r43)
            goto L_0x0201
        L_0x01ff:
            r9 = r54
        L_0x0201:
            r12 = r0 & 128(0x80, float:1.794E-43)
            r13 = 16
            if (r12 == 0) goto L_0x0252
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r12 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r12.getNormal()
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r13)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r10)
            r44 = 16777081(0xffff79, float:2.3509698E-38)
            r45 = 0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            androidx.compose.ui.text.TextStyle r10 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r14, r15, r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45)
            goto L_0x0254
        L_0x0252:
            r10 = r55
        L_0x0254:
            r11 = r0 & 256(0x100, float:3.59E-43)
            r12 = 14
            if (r11 == 0) goto L_0x02aa
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r11.getMedium()
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            r15 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r15)
            r44 = 16777081(0xffff79, float:2.3509698E-38)
            r45 = 0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r14, r15, r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45)
            goto L_0x02ac
        L_0x02aa:
            r11 = r56
        L_0x02ac:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x02fd
            androidx.compose.ui.text.TextStyle r15 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r20 = r14.getNormal()
            long r18 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r13)
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            long r25 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r13)
            r45 = 16777081(0xffff79, float:2.3509698E-38)
            r46 = 0
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            androidx.compose.ui.text.TextStyle r13 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r15, r16, r18, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46)
            goto L_0x02ff
        L_0x02fd:
            r13 = r57
        L_0x02ff:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x034e
            androidx.compose.ui.text.TextStyle r15 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r14 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r20 = r14.getNormal()
            long r18 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            long r25 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r7)
            r45 = 16777081(0xffff79, float:2.3509698E-38)
            r46 = 0
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            androidx.compose.ui.text.TextStyle r7 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r15, r16, r18, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46)
            goto L_0x0350
        L_0x034e:
            r7 = r58
        L_0x0350:
            r8 = r0 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x03a1
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r8.getMedium()
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            r15 = 4608308318706860032(0x3ff4000000000000, double:1.25)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r15)
            r44 = 16777081(0xffff79, float:2.3509698E-38)
            r45 = 0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            androidx.compose.ui.text.TextStyle r8 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r14, r15, r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45)
            goto L_0x03a3
        L_0x03a1:
            r8 = r59
        L_0x03a3:
            r12 = r0 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x03f9
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r12 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r12.getNormal()
            r12 = 12
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r12)
            r15 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r15)
            r44 = 16777081(0xffff79, float:2.3509698E-38)
            r45 = 0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            androidx.compose.ui.text.TextStyle r12 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r14, r15, r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45)
            goto L_0x03fb
        L_0x03f9:
            r12 = r60
        L_0x03fb:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x044e
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.getDefaultTextStyle()
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r19 = r0.getNormal()
            r0 = 10
            long r17 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r0)
            r15 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            long r24 = androidx.compose.ui.unit.TextUnitKt.getSp((double) r15)
            r44 = 16777081(0xffff79, float:2.3509698E-38)
            r45 = 0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            androidx.compose.ui.text.TextStyle r0 = androidx.compose.ui.text.TextStyle.m7047copyv2rsoow$default(r14, r15, r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45)
            goto L_0x0450
        L_0x044e:
            r0 = r61
        L_0x0450:
            r48 = r1
            r49 = r2
            r50 = r3
            r51 = r4
            r52 = r6
            r53 = r5
            r54 = r9
            r55 = r10
            r56 = r11
            r57 = r13
            r58 = r7
            r59 = r8
            r60 = r12
            r61 = r0
            r47.<init>(r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.Typography.<init>(androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Typography(androidx.compose.ui.text.font.FontFamily r30, androidx.compose.ui.text.TextStyle r31, androidx.compose.ui.text.TextStyle r32, androidx.compose.ui.text.TextStyle r33, androidx.compose.ui.text.TextStyle r34, androidx.compose.ui.text.TextStyle r35, androidx.compose.ui.text.TextStyle r36, androidx.compose.ui.text.TextStyle r37, androidx.compose.ui.text.TextStyle r38, androidx.compose.ui.text.TextStyle r39, androidx.compose.ui.text.TextStyle r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.ui.text.TextStyle r43) {
        /*
            r29 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r36
            r7 = r37
            r8 = r38
            r9 = r39
            r10 = r40
            r11 = r41
            r12 = r42
            r13 = r43
            java.lang.String r14 = "defaultFontFamily"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r14)
            java.lang.String r14 = "h1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r14)
            java.lang.String r14 = "h2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r14)
            java.lang.String r14 = "h3"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r14)
            java.lang.String r14 = "h4"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
            java.lang.String r14 = "h5"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r14)
            java.lang.String r14 = "h6"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r14)
            java.lang.String r14 = "subtitle1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r14)
            java.lang.String r14 = "subtitle2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r14)
            java.lang.String r14 = "body1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r14)
            java.lang.String r14 = "body2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r14)
            java.lang.String r14 = "button"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r14)
            java.lang.String r14 = "caption"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r14)
            java.lang.String r14 = "overline"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r14)
            androidx.compose.ui.text.TextStyle r16 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r1, r0)
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r2, r0)
            androidx.compose.ui.text.TextStyle r18 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r3, r0)
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r4, r0)
            androidx.compose.ui.text.TextStyle r20 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r5, r0)
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r6, r0)
            androidx.compose.ui.text.TextStyle r22 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r7, r0)
            androidx.compose.ui.text.TextStyle r23 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r8, r0)
            androidx.compose.ui.text.TextStyle r24 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r9, r0)
            androidx.compose.ui.text.TextStyle r25 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r10, r0)
            androidx.compose.ui.text.TextStyle r26 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r11, r0)
            androidx.compose.ui.text.TextStyle r27 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r12, r0)
            androidx.compose.ui.text.TextStyle r28 = androidx.compose.material.TypographyKt.withDefaultFontFamily(r13, r0)
            r15 = r29
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.Typography.<init>(androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle):void");
    }

    public static /* synthetic */ Typography copy$default(Typography typography, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i, Object obj) {
        TextStyle textStyle14;
        TextStyle textStyle15;
        TextStyle textStyle16;
        TextStyle textStyle17;
        TextStyle textStyle18;
        TextStyle textStyle19;
        TextStyle textStyle20;
        TextStyle textStyle21;
        TextStyle textStyle22;
        TextStyle textStyle23;
        TextStyle textStyle24;
        TextStyle textStyle25;
        TextStyle textStyle26;
        Typography typography2 = typography;
        int i2 = i;
        if ((i2 & 1) != 0) {
            textStyle14 = typography2.h1;
        } else {
            textStyle14 = textStyle;
        }
        if ((i2 & 2) != 0) {
            textStyle15 = typography2.h2;
        } else {
            textStyle15 = textStyle2;
        }
        if ((i2 & 4) != 0) {
            textStyle16 = typography2.h3;
        } else {
            textStyle16 = textStyle3;
        }
        if ((i2 & 8) != 0) {
            textStyle17 = typography2.h4;
        } else {
            textStyle17 = textStyle4;
        }
        if ((i2 & 16) != 0) {
            textStyle18 = typography2.h5;
        } else {
            textStyle18 = textStyle5;
        }
        if ((i2 & 32) != 0) {
            textStyle19 = typography2.h6;
        } else {
            textStyle19 = textStyle6;
        }
        if ((i2 & 64) != 0) {
            textStyle20 = typography2.subtitle1;
        } else {
            textStyle20 = textStyle7;
        }
        if ((i2 & 128) != 0) {
            textStyle21 = typography2.subtitle2;
        } else {
            textStyle21 = textStyle8;
        }
        if ((i2 & 256) != 0) {
            textStyle22 = typography2.body1;
        } else {
            textStyle22 = textStyle9;
        }
        if ((i2 & 512) != 0) {
            textStyle23 = typography2.body2;
        } else {
            textStyle23 = textStyle10;
        }
        if ((i2 & 1024) != 0) {
            textStyle24 = typography2.button;
        } else {
            textStyle24 = textStyle11;
        }
        if ((i2 & 2048) != 0) {
            textStyle25 = typography2.caption;
        } else {
            textStyle25 = textStyle12;
        }
        if ((i2 & 4096) != 0) {
            textStyle26 = typography2.overline;
        } else {
            textStyle26 = textStyle13;
        }
        return typography.copy(textStyle14, textStyle15, textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26);
    }

    public final Typography copy(TextStyle h12, TextStyle h22, TextStyle h32, TextStyle h42, TextStyle h52, TextStyle h62, TextStyle subtitle12, TextStyle subtitle22, TextStyle body12, TextStyle body22, TextStyle button2, TextStyle caption2, TextStyle overline2) {
        Intrinsics.checkNotNullParameter(h12, "h1");
        Intrinsics.checkNotNullParameter(h22, "h2");
        Intrinsics.checkNotNullParameter(h32, "h3");
        Intrinsics.checkNotNullParameter(h42, "h4");
        Intrinsics.checkNotNullParameter(h52, "h5");
        Intrinsics.checkNotNullParameter(h62, "h6");
        Intrinsics.checkNotNullParameter(subtitle12, "subtitle1");
        Intrinsics.checkNotNullParameter(subtitle22, "subtitle2");
        Intrinsics.checkNotNullParameter(body12, "body1");
        Intrinsics.checkNotNullParameter(body22, "body2");
        Intrinsics.checkNotNullParameter(button2, "button");
        Intrinsics.checkNotNullParameter(caption2, "caption");
        Intrinsics.checkNotNullParameter(overline2, "overline");
        return new Typography(h12, h22, h32, h42, h52, h62, subtitle12, subtitle22, body12, body22, button2, caption2, overline2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Typography) && Intrinsics.areEqual((Object) this.h1, (Object) ((Typography) other).h1) && Intrinsics.areEqual((Object) this.h2, (Object) ((Typography) other).h2) && Intrinsics.areEqual((Object) this.h3, (Object) ((Typography) other).h3) && Intrinsics.areEqual((Object) this.h4, (Object) ((Typography) other).h4) && Intrinsics.areEqual((Object) this.h5, (Object) ((Typography) other).h5) && Intrinsics.areEqual((Object) this.h6, (Object) ((Typography) other).h6) && Intrinsics.areEqual((Object) this.subtitle1, (Object) ((Typography) other).subtitle1) && Intrinsics.areEqual((Object) this.subtitle2, (Object) ((Typography) other).subtitle2) && Intrinsics.areEqual((Object) this.body1, (Object) ((Typography) other).body1) && Intrinsics.areEqual((Object) this.body2, (Object) ((Typography) other).body2) && Intrinsics.areEqual((Object) this.button, (Object) ((Typography) other).button) && Intrinsics.areEqual((Object) this.caption, (Object) ((Typography) other).caption) && Intrinsics.areEqual((Object) this.overline, (Object) ((Typography) other).overline)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.h1.hashCode() * 31) + this.h2.hashCode()) * 31) + this.h3.hashCode()) * 31) + this.h4.hashCode()) * 31) + this.h5.hashCode()) * 31) + this.h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Typography(h1=").append(this.h1).append(", h2=").append(this.h2).append(", h3=").append(this.h3).append(", h4=").append(this.h4).append(", h5=").append(this.h5).append(", h6=").append(this.h6).append(", subtitle1=").append(this.subtitle1).append(", subtitle2=").append(this.subtitle2).append(", body1=").append(this.body1).append(", body2=").append(this.body2).append(", button=").append(this.button).append(", caption=");
        sb.append(this.caption).append(", overline=").append(this.overline).append(')');
        return sb.toString();
    }
}
