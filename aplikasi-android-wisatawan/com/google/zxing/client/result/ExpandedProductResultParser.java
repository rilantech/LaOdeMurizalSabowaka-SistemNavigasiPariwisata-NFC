package com.google.zxing.client.result;

public final class ExpandedProductResultParser extends ResultParser {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01e6, code lost:
        if (r4.equals("10") != false) goto L_0x01fe;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.ExpandedProductParsedResult parse(com.google.zxing.Result r34) {
        /*
            r33 = this;
            com.google.zxing.BarcodeFormat r0 = r34.getBarcodeFormat()
            com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.RSS_EXPANDED
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r0 = getMassagedText(r34)
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            r16 = 0
            r17 = 0
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r14 = r16
        L_0x003e:
            int r3 = r0.length()
            if (r14 >= r3) goto L_0x026a
            java.lang.String r3 = findAIvalue(r14, r0)
            r4 = r17
            r4 = r3
            if (r3 != 0) goto L_0x004e
            return r2
        L_0x004e:
            int r3 = r4.length()
            r5 = 2
            int r3 = r3 + r5
            int r3 = r3 + r14
            r6 = r3
            java.lang.String r3 = findValue(r3, r0)
            int r7 = r3.length()
            int r14 = r6 + r7
            int r6 = r4.hashCode()
            r7 = 0
            r8 = 4
            r9 = 3
            switch(r6) {
                case 1536: goto L_0x01f3;
                case 1537: goto L_0x01e9;
                case 1567: goto L_0x01e0;
                case 1568: goto L_0x01d6;
                case 1570: goto L_0x01cc;
                case 1572: goto L_0x01c2;
                case 1574: goto L_0x01b8;
                case 1567966: goto L_0x01ae;
                case 1567967: goto L_0x01a3;
                case 1567968: goto L_0x0198;
                case 1567969: goto L_0x018c;
                case 1567970: goto L_0x0180;
                case 1567971: goto L_0x0174;
                case 1567972: goto L_0x0168;
                case 1567973: goto L_0x015c;
                case 1567974: goto L_0x0150;
                case 1567975: goto L_0x0144;
                case 1568927: goto L_0x0138;
                case 1568928: goto L_0x012c;
                case 1568929: goto L_0x0120;
                case 1568930: goto L_0x0114;
                case 1568931: goto L_0x0108;
                case 1568932: goto L_0x00fc;
                case 1568933: goto L_0x00f0;
                case 1568934: goto L_0x00e4;
                case 1568935: goto L_0x00d8;
                case 1568936: goto L_0x00cc;
                case 1575716: goto L_0x00c0;
                case 1575717: goto L_0x00b4;
                case 1575718: goto L_0x00a8;
                case 1575719: goto L_0x009c;
                case 1575747: goto L_0x0090;
                case 1575748: goto L_0x0084;
                case 1575749: goto L_0x0078;
                case 1575750: goto L_0x006c;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x01fd
        L_0x006c:
            java.lang.String r5 = "3933"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 34
            goto L_0x01fe
        L_0x0078:
            java.lang.String r5 = "3932"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 33
            goto L_0x01fe
        L_0x0084:
            java.lang.String r5 = "3931"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 32
            goto L_0x01fe
        L_0x0090:
            java.lang.String r5 = "3930"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 31
            goto L_0x01fe
        L_0x009c:
            java.lang.String r5 = "3923"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 30
            goto L_0x01fe
        L_0x00a8:
            java.lang.String r5 = "3922"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 29
            goto L_0x01fe
        L_0x00b4:
            java.lang.String r5 = "3921"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 28
            goto L_0x01fe
        L_0x00c0:
            java.lang.String r5 = "3920"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 27
            goto L_0x01fe
        L_0x00cc:
            java.lang.String r5 = "3209"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 26
            goto L_0x01fe
        L_0x00d8:
            java.lang.String r5 = "3208"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 25
            goto L_0x01fe
        L_0x00e4:
            java.lang.String r5 = "3207"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 24
            goto L_0x01fe
        L_0x00f0:
            java.lang.String r5 = "3206"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 23
            goto L_0x01fe
        L_0x00fc:
            java.lang.String r5 = "3205"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 22
            goto L_0x01fe
        L_0x0108:
            java.lang.String r5 = "3204"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 21
            goto L_0x01fe
        L_0x0114:
            java.lang.String r5 = "3203"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 20
            goto L_0x01fe
        L_0x0120:
            java.lang.String r5 = "3202"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 19
            goto L_0x01fe
        L_0x012c:
            java.lang.String r5 = "3201"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 18
            goto L_0x01fe
        L_0x0138:
            java.lang.String r5 = "3200"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 17
            goto L_0x01fe
        L_0x0144:
            java.lang.String r5 = "3109"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 16
            goto L_0x01fe
        L_0x0150:
            java.lang.String r5 = "3108"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 15
            goto L_0x01fe
        L_0x015c:
            java.lang.String r5 = "3107"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 14
            goto L_0x01fe
        L_0x0168:
            java.lang.String r5 = "3106"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 13
            goto L_0x01fe
        L_0x0174:
            java.lang.String r5 = "3105"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 12
            goto L_0x01fe
        L_0x0180:
            java.lang.String r5 = "3104"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 11
            goto L_0x01fe
        L_0x018c:
            java.lang.String r5 = "3103"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 10
            goto L_0x01fe
        L_0x0198:
            java.lang.String r5 = "3102"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 9
            goto L_0x01fe
        L_0x01a3:
            java.lang.String r5 = "3101"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 8
            goto L_0x01fe
        L_0x01ae:
            java.lang.String r5 = "3100"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 7
            goto L_0x01fe
        L_0x01b8:
            java.lang.String r5 = "17"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 6
            goto L_0x01fe
        L_0x01c2:
            java.lang.String r5 = "15"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 5
            goto L_0x01fe
        L_0x01cc:
            java.lang.String r5 = "13"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = r8
            goto L_0x01fe
        L_0x01d6:
            java.lang.String r5 = "11"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = r9
            goto L_0x01fe
        L_0x01e0:
            java.lang.String r6 = "10"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x006a
            goto L_0x01fe
        L_0x01e9:
            java.lang.String r5 = "01"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = 1
            goto L_0x01fe
        L_0x01f3:
            java.lang.String r5 = "00"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006a
            r5 = r7
            goto L_0x01fe
        L_0x01fd:
            r5 = -1
        L_0x01fe:
            switch(r5) {
                case 0: goto L_0x0264;
                case 1: goto L_0x025f;
                case 2: goto L_0x0259;
                case 3: goto L_0x0253;
                case 4: goto L_0x024d;
                case 5: goto L_0x0247;
                case 6: goto L_0x0241;
                case 7: goto L_0x0235;
                case 8: goto L_0x0235;
                case 9: goto L_0x0235;
                case 10: goto L_0x0235;
                case 11: goto L_0x0235;
                case 12: goto L_0x0235;
                case 13: goto L_0x0235;
                case 14: goto L_0x0235;
                case 15: goto L_0x0235;
                case 16: goto L_0x0235;
                case 17: goto L_0x0229;
                case 18: goto L_0x0229;
                case 19: goto L_0x0229;
                case 20: goto L_0x0229;
                case 21: goto L_0x0229;
                case 22: goto L_0x0229;
                case 23: goto L_0x0229;
                case 24: goto L_0x0229;
                case 25: goto L_0x0229;
                case 26: goto L_0x0229;
                case 27: goto L_0x021f;
                case 28: goto L_0x021f;
                case 29: goto L_0x021f;
                case 30: goto L_0x021f;
                case 31: goto L_0x0208;
                case 32: goto L_0x0208;
                case 33: goto L_0x0208;
                case 34: goto L_0x0208;
                default: goto L_0x0201;
            }
        L_0x0201:
            r15.put(r4, r3)
            r17 = r4
            goto L_0x003e
        L_0x0208:
            int r5 = r3.length()
            if (r5 >= r8) goto L_0x020f
            return r2
        L_0x020f:
            java.lang.String r28 = r3.substring(r9)
            java.lang.String r30 = r3.substring(r7, r9)
            java.lang.String r29 = r4.substring(r9)
            r17 = r4
            goto L_0x003e
        L_0x021f:
            r28 = r3
            java.lang.String r29 = r4.substring(r9)
            r17 = r4
            goto L_0x003e
        L_0x0229:
            r25 = r3
            java.lang.String r26 = "LB"
            java.lang.String r27 = r4.substring(r9)
            r17 = r4
            goto L_0x003e
        L_0x0235:
            r25 = r3
            java.lang.String r26 = "KG"
            java.lang.String r27 = r4.substring(r9)
            r17 = r4
            goto L_0x003e
        L_0x0241:
            r24 = r3
            r17 = r4
            goto L_0x003e
        L_0x0247:
            r23 = r3
            r17 = r4
            goto L_0x003e
        L_0x024d:
            r22 = r3
            r17 = r4
            goto L_0x003e
        L_0x0253:
            r21 = r3
            r17 = r4
            goto L_0x003e
        L_0x0259:
            r20 = r3
            r17 = r4
            goto L_0x003e
        L_0x025f:
            r1 = r3
            r17 = r4
            goto L_0x003e
        L_0x0264:
            r19 = r3
            r17 = r4
            goto L_0x003e
        L_0x026a:
            com.google.zxing.client.result.ExpandedProductParsedResult r2 = new com.google.zxing.client.result.ExpandedProductParsedResult
            r3 = r2
            r4 = r0
            r5 = r1
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r31 = r14
            r14 = r27
            r32 = r15
            r15 = r28
            r16 = r29
            r17 = r30
            r18 = r32
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ExpandedProductResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.ExpandedProductParsedResult");
    }

    private static String findAIvalue(int i, String rawText) {
        if (rawText.charAt(i) != '(') {
            return null;
        }
        CharSequence rawTextAux = rawText.substring(i + 1);
        StringBuilder buf = new StringBuilder();
        for (int index = 0; index < rawTextAux.length(); index++) {
            char charAt = rawTextAux.charAt(index);
            char currentChar = charAt;
            if (charAt == ')') {
                return buf.toString();
            }
            if (currentChar < '0' || currentChar > '9') {
                return null;
            }
            buf.append(currentChar);
        }
        return buf.toString();
    }

    private static String findValue(int i, String rawText) {
        StringBuilder buf = new StringBuilder();
        String rawTextAux = rawText.substring(i);
        for (int index = 0; index < rawTextAux.length(); index++) {
            char charAt = rawTextAux.charAt(index);
            char c = charAt;
            if (charAt == '(') {
                if (findAIvalue(index, rawTextAux) != null) {
                    break;
                }
                buf.append('(');
            } else {
                buf.append(c);
            }
        }
        return buf.toString();
    }
}
