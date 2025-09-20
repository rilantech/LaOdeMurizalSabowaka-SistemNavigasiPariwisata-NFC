package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final byte[] PUNCTUATION = new byte[128];
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, Base64.padSymbol, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    static {
        byte[] bArr = new byte[128];
        MIXED = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = TEXT_MIXED_RAW;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i2];
            if (b > 0) {
                MIXED[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr3 = TEXT_PUNCTUATION_RAW;
            if (i < bArr3.length) {
                byte b2 = bArr3[i];
                if (b2 > 0) {
                    PUNCTUATION[b2] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private PDF417HighLevelEncoder() {
    }

    static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        if (compaction == Compaction.TEXT) {
            encodeText(str, 0, length, sb, 0);
        } else if (compaction == Compaction.BYTE) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (compaction == Compaction.NUMERIC) {
            sb.append(902);
            encodeNumeric(str, 0, length, sb);
        } else {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append(902);
                    encodeNumeric(str, i, determineConsecutiveDigitCount, sb);
                    i += determineConsecutiveDigitCount;
                    i3 = 2;
                    i2 = 0;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        if (i3 != 0) {
                            sb.append(900);
                            i2 = 0;
                            i3 = 0;
                        }
                        i2 = encodeText(str, i, determineConsecutiveTextCount, sb, i2);
                        i += determineConsecutiveTextCount;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        int i4 = determineConsecutiveBinaryCount + i;
                        byte[] bytes2 = str.substring(i, i4).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i3, sb);
                            i2 = 0;
                            i3 = 1;
                        }
                        i = i4;
                    }
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 0
            r5 = r20
            r6 = r4
        L_0x0010:
            int r7 = r17 + r6
            char r8 = r0.charAt(r7)
            r9 = 26
            r10 = 32
            r11 = 28
            r12 = 27
            r13 = 2
            r14 = 29
            r15 = 1
            switch(r5) {
                case 0: goto L_0x00bd;
                case 1: goto L_0x0080;
                case 2: goto L_0x0035;
                default: goto L_0x0025;
            }
        L_0x0025:
            boolean r7 = isPunctuation(r8)
            if (r7 == 0) goto L_0x012a
            byte[] r7 = PUNCTUATION
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f6
        L_0x0035:
            boolean r9 = isMixed(r8)
            if (r9 == 0) goto L_0x0045
            byte[] r7 = MIXED
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f6
        L_0x0045:
            boolean r9 = isAlphaUpper(r8)
            if (r9 == 0) goto L_0x0051
            r3.append(r11)
            r5 = r4
            goto L_0x0010
        L_0x0051:
            boolean r9 = isAlphaLower(r8)
            if (r9 == 0) goto L_0x005d
            r3.append(r12)
            r5 = r15
            goto L_0x0010
        L_0x005d:
            int r7 = r7 + 1
            if (r7 >= r1) goto L_0x0073
            char r7 = r0.charAt(r7)
            boolean r7 = isPunctuation(r7)
            if (r7 == 0) goto L_0x0073
            r5 = 25
            r3.append(r5)
            r5 = 3
            goto L_0x0010
        L_0x0073:
            r3.append(r14)
            byte[] r7 = PUNCTUATION
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f6
        L_0x0080:
            boolean r7 = isAlphaLower(r8)
            if (r7 == 0) goto L_0x0094
            if (r8 != r10) goto L_0x008d
            r3.append(r9)
            goto L_0x00f6
        L_0x008d:
            int r8 = r8 + -97
            char r7 = (char) r8
            r3.append(r7)
            goto L_0x00f6
        L_0x0094:
            boolean r7 = isAlphaUpper(r8)
            if (r7 == 0) goto L_0x00a4
            r3.append(r12)
            int r8 = r8 + -65
            char r7 = (char) r8
            r3.append(r7)
            goto L_0x00f6
        L_0x00a4:
            boolean r7 = isMixed(r8)
            if (r7 == 0) goto L_0x00b1
            r3.append(r11)
            r5 = r13
            goto L_0x0010
        L_0x00b1:
            r3.append(r14)
            byte[] r7 = PUNCTUATION
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f6
        L_0x00bd:
            boolean r7 = isAlphaUpper(r8)
            if (r7 == 0) goto L_0x00d0
            if (r8 != r10) goto L_0x00c9
            r3.append(r9)
            goto L_0x00f6
        L_0x00c9:
            int r8 = r8 + -65
            char r7 = (char) r8
            r3.append(r7)
            goto L_0x00f6
        L_0x00d0:
            boolean r7 = isAlphaLower(r8)
            if (r7 == 0) goto L_0x00dd
            r3.append(r12)
            r5 = r15
            goto L_0x0010
        L_0x00dd:
            boolean r7 = isMixed(r8)
            if (r7 == 0) goto L_0x00ea
            r3.append(r11)
            r5 = r13
            goto L_0x0010
        L_0x00ea:
            r3.append(r14)
            byte[] r7 = PUNCTUATION
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
        L_0x00f6:
            int r6 = r6 + 1
            if (r6 < r1) goto L_0x0010
            int r0 = r3.length()
            r1 = r4
            r6 = r1
        L_0x0101:
            if (r1 >= r0) goto L_0x011f
            int r7 = r1 % 2
            if (r7 == 0) goto L_0x0109
            r7 = r15
            goto L_0x010a
        L_0x0109:
            r7 = r4
        L_0x010a:
            if (r7 == 0) goto L_0x0118
            int r6 = r6 * 30
            char r7 = r3.charAt(r1)
            int r6 = r6 + r7
            char r6 = (char) r6
            r2.append(r6)
            goto L_0x011c
        L_0x0118:
            char r6 = r3.charAt(r1)
        L_0x011c:
            int r1 = r1 + 1
            goto L_0x0101
        L_0x011f:
            int r0 = r0 % r13
            if (r0 == 0) goto L_0x0129
            int r6 = r6 * 30
            int r6 = r6 + r14
            char r0 = (char) r6
            r2.append(r0)
        L_0x0129:
            return r5
        L_0x012a:
            r3.append(r14)
            r5 = r4
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodeBinary(byte[] bytes, int startpos, int count, int startmode, StringBuilder sb) {
        if (count == 1 && startmode == 0) {
            sb.append(913);
        } else if (count % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        int idx = startpos;
        if (count >= 6) {
            char[] chars = new char[5];
            while ((startpos + count) - idx >= 6) {
                long t = 0;
                for (int i = 0; i < 6; i++) {
                    t = (t << 8) + ((long) (bytes[idx + i] & UByte.MAX_VALUE));
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    chars[i2] = (char) ((int) (t % 900));
                    t /= 900;
                }
                for (int i3 = 4; i3 >= 0; i3--) {
                    sb.append(chars[i3]);
                }
                idx += 6;
            }
        }
        for (int i4 = idx; i4 < startpos + count; i4++) {
            sb.append((char) (bytes[i4] & 255));
        }
    }

    private static void encodeNumeric(String msg, int startpos, int count, StringBuilder sb) {
        BigInteger divide;
        int idx = 0;
        StringBuilder tmp = new StringBuilder((count / 3) + 1);
        BigInteger num900 = BigInteger.valueOf(900);
        BigInteger num0 = BigInteger.valueOf(0);
        while (idx < count) {
            tmp.setLength(0);
            int len = Math.min(44, count - idx);
            BigInteger bigint = new BigInteger("1" + msg.substring(startpos + idx, startpos + idx + len));
            do {
                tmp.append((char) bigint.mod(num900).intValue());
                divide = bigint.divide(num900);
                bigint = divide;
            } while (!divide.equals(num0));
            for (int i = tmp.length() - 1; i >= 0; i--) {
                sb.append(tmp.charAt(i));
            }
            idx += len;
        }
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isAlphaUpper(char ch) {
        if (ch != ' ') {
            return ch >= 'A' && ch <= 'Z';
        }
        return true;
    }

    private static boolean isAlphaLower(char ch) {
        if (ch != ' ') {
            return ch >= 'a' && ch <= 'z';
        }
        return true;
    }

    private static boolean isMixed(char ch) {
        return MIXED[ch] != -1;
    }

    private static boolean isPunctuation(char ch) {
        return PUNCTUATION[ch] != -1;
    }

    private static boolean isText(char ch) {
        if (ch == 9 || ch == 10 || ch == 13) {
            return true;
        }
        return ch >= ' ' && ch <= '~';
    }

    private static int determineConsecutiveDigitCount(CharSequence msg, int startpos) {
        int count = 0;
        int len = msg.length();
        int idx = startpos;
        if (startpos < len) {
            char ch = msg.charAt(startpos);
            while (isDigit(ch) && idx < len) {
                count++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
        }
        return count;
    }

    private static int determineConsecutiveTextCount(CharSequence msg, int startpos) {
        int len = msg.length();
        int idx = startpos;
        while (idx < len) {
            char ch = msg.charAt(idx);
            int numericCount = 0;
            while (numericCount < 13 && isDigit(ch) && idx < len) {
                numericCount++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
            if (numericCount < 13) {
                if (numericCount <= 0) {
                    if (!isText(msg.charAt(idx))) {
                        break;
                    }
                    idx++;
                }
            } else {
                return (idx - startpos) - numericCount;
            }
        }
        return idx - startpos;
    }

    private static int determineConsecutiveBinaryCount(String msg, int startpos, Charset encoding) throws WriterException {
        CharsetEncoder encoder = encoding.newEncoder();
        int len = msg.length();
        int idx = startpos;
        while (idx < len) {
            char ch = msg.charAt(idx);
            int numericCount = 0;
            while (numericCount < 13 && isDigit(ch)) {
                numericCount++;
                int i = idx + numericCount;
                int i2 = i;
                if (i >= len) {
                    break;
                }
                ch = msg.charAt(i2);
            }
            if (numericCount >= 13) {
                return idx - startpos;
            }
            char ch2 = msg.charAt(idx);
            if (encoder.canEncode(ch2)) {
                idx++;
            } else {
                throw new WriterException("Non-encodable character detected: " + ch2 + " (Unicode: " + ch2 + ')');
            }
        }
        return idx - startpos;
    }

    private static void encodingECI(int eci, StringBuilder sb) throws WriterException {
        if (eci >= 0 && eci < 900) {
            sb.append(927);
            sb.append((char) eci);
        } else if (eci < 810900) {
            sb.append(926);
            sb.append((char) ((eci / 900) - 1));
            sb.append((char) (eci % 900));
        } else if (eci < 811800) {
            sb.append(925);
            sb.append((char) (810900 - eci));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + eci);
        }
    }
}
