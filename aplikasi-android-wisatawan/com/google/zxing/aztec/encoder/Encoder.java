package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    public static AztecCode encode(byte[] data) {
        return encode(data, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        BitArray bitArray;
        int i6;
        boolean z2;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int i7 = 11;
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i8 = 32;
        boolean z3 = true;
        if (i2 != 0) {
            z = i2 < 0;
            i4 = Math.abs(i2);
            if (z) {
                i8 = 4;
            }
            if (i4 <= i8) {
                i5 = totalBitsInLayer(i4, z);
                i3 = WORD_SIZE[i4];
                int i9 = i5 - (i5 % i3);
                bitArray = stuffBits(encode, i3);
                if (bitArray.getSize() + size > i9) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z && bitArray.getSize() > (i3 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        } else {
            BitArray bitArray2 = null;
            int i10 = 0;
            int i11 = 0;
            while (i10 <= 32) {
                boolean z4 = i10 <= 3 ? z3 : false;
                int i12 = z4 ? i10 + 1 : i10;
                int i13 = totalBitsInLayer(i12, z4);
                if (size2 <= i13) {
                    int i14 = WORD_SIZE[i12];
                    if (i11 != i14) {
                        bitArray2 = stuffBits(encode, i14);
                    } else {
                        i14 = i11;
                    }
                    int i15 = i13 - (i13 % i14);
                    if ((!z4 || bitArray2.getSize() <= (i14 << 6)) && bitArray2.getSize() + size <= i15) {
                        bitArray = bitArray2;
                        z = z4;
                        i4 = i12;
                        i5 = i13;
                        i3 = i14;
                    } else {
                        z2 = z3;
                        i11 = i14;
                    }
                } else {
                    z2 = z3;
                }
                i10++;
                z3 = z2;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i5, i3);
        int size3 = bitArray.getSize() / i3;
        BitArray generateModeMessage = generateModeMessage(z, i4, size3);
        if (!z) {
            i7 = 14;
        }
        int i16 = i7 + (i4 << 2);
        int[] iArr = new int[i16];
        int i17 = 2;
        if (z) {
            for (int i18 = 0; i18 < i16; i18++) {
                iArr[i18] = i18;
            }
            i6 = i16;
        } else {
            int i19 = i16 / 2;
            i6 = i16 + 1 + (((i19 - 1) / 15) * 2);
            int i20 = i6 / 2;
            for (int i21 = 0; i21 < i19; i21++) {
                int i22 = (i21 / 15) + i21;
                iArr[(i19 - i21) - (z3 ? 1 : 0)] = (i20 - i22) - 1;
                iArr[i19 + i21] = i22 + i20 + z3;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i23 = 0;
        int i24 = 0;
        while (i23 < i4) {
            int i25 = ((i4 - i23) << i17) + (z ? 9 : 12);
            int i26 = 0;
            while (i26 < i25) {
                int i27 = i26 << 1;
                int i28 = 0;
                while (i28 < i17) {
                    if (generateCheckWords.get(i24 + i27 + i28)) {
                        int i29 = i23 << 1;
                        bitMatrix.set(iArr[i29 + i28], iArr[i29 + i26]);
                    }
                    if (generateCheckWords.get((i25 << 1) + i24 + i27 + i28)) {
                        int i30 = i23 << 1;
                        bitMatrix.set(iArr[i30 + i26], iArr[((i16 - 1) - i30) - i28]);
                    }
                    if (generateCheckWords.get((i25 << 2) + i24 + i27 + i28)) {
                        int i31 = (i16 - 1) - (i23 << 1);
                        bitMatrix.set(iArr[i31 - i28], iArr[i31 - i26]);
                    }
                    if (generateCheckWords.get((i25 * 6) + i24 + i27 + i28)) {
                        int i32 = i23 << 1;
                        bitMatrix.set(iArr[((i16 - 1) - i32) - i26], iArr[i32 + i28]);
                    }
                    i28++;
                    i17 = 2;
                }
                i26++;
                i17 = 2;
            }
            i24 += i25 << 3;
            i23++;
            i17 = 2;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            int i33 = i6 / 2;
            drawBullsEye(bitMatrix, i33, 7);
            int i34 = 0;
            int i35 = 0;
            while (i35 < (i16 / 2) - 1) {
                for (int i36 = i33 & 1; i36 < i6; i36 += 2) {
                    int i37 = i33 - i34;
                    bitMatrix.set(i37, i36);
                    int i38 = i33 + i34;
                    bitMatrix.set(i38, i36);
                    bitMatrix.set(i36, i37);
                    bitMatrix.set(i36, i38);
                }
                i35 += 15;
                i34 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i4);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix matrix, int center, int size) {
        for (int i = 0; i < size; i += 2) {
            for (int j = center - i; j <= center + i; j++) {
                matrix.set(j, center - i);
                matrix.set(j, center + i);
                matrix.set(center - i, j);
                matrix.set(center + i, j);
            }
        }
        matrix.set(center - size, center - size);
        matrix.set((center - size) + 1, center - size);
        matrix.set(center - size, (center - size) + 1);
        matrix.set(center + size, center - size);
        matrix.set(center + size, (center - size) + 1);
        matrix.set(center + size, (center + size) - 1);
    }

    static BitArray generateModeMessage(boolean compact, int layers, int messageSizeInWords) {
        BitArray modeMessage = new BitArray();
        if (compact) {
            modeMessage.appendBits(layers - 1, 2);
            modeMessage.appendBits(messageSizeInWords - 1, 6);
            return generateCheckWords(modeMessage, 28, 4);
        }
        modeMessage.appendBits(layers - 1, 5);
        modeMessage.appendBits(messageSizeInWords - 1, 11);
        return generateCheckWords(modeMessage, 40, 4);
    }

    private static void drawModeMessage(BitMatrix matrix, boolean compact, int matrixSize, BitArray modeMessage) {
        int center = matrixSize / 2;
        if (compact) {
            for (int i = 0; i < 7; i++) {
                int offset = (center - 3) + i;
                if (modeMessage.get(i)) {
                    matrix.set(offset, center - 5);
                }
                if (modeMessage.get(i + 7)) {
                    matrix.set(center + 5, offset);
                }
                if (modeMessage.get(20 - i)) {
                    matrix.set(offset, center + 5);
                }
                if (modeMessage.get(27 - i)) {
                    matrix.set(center - 5, offset);
                }
            }
            return;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            int offset2 = (center - 5) + i2 + (i2 / 5);
            if (modeMessage.get(i2)) {
                matrix.set(offset2, center - 7);
            }
            if (modeMessage.get(i2 + 10)) {
                matrix.set(center + 7, offset2);
            }
            if (modeMessage.get(29 - i2)) {
                matrix.set(offset2, center + 7);
            }
            if (modeMessage.get(39 - i2)) {
                matrix.set(center - 7, offset2);
            }
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int totalBits, int wordSize) {
        ReedSolomonEncoder rs = new ReedSolomonEncoder(getGF(wordSize));
        int totalWords = totalBits / wordSize;
        int[] messageWords = bitsToWords(bitArray, wordSize, totalWords);
        rs.encode(messageWords, totalWords - (bitArray.getSize() / wordSize));
        BitArray bitArray2 = new BitArray();
        BitArray messageBits = bitArray2;
        bitArray2.appendBits(0, totalBits % wordSize);
        for (int messageWord : messageWords) {
            messageBits.appendBits(messageWord, wordSize);
        }
        return messageBits;
    }

    private static int[] bitsToWords(BitArray stuffedBits, int wordSize, int totalWords) {
        int[] message = new int[totalWords];
        int n = stuffedBits.getSize() / wordSize;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = 0; j < wordSize; j++) {
                value |= stuffedBits.get((i * wordSize) + j) ? 1 << ((wordSize - j) - 1) : 0;
            }
            message[i] = value;
        }
        return message;
    }

    private static GenericGF getGF(int wordSize) {
        switch (wordSize) {
            case 4:
                return GenericGF.AZTEC_PARAM;
            case 6:
                return GenericGF.AZTEC_DATA_6;
            case 8:
                return GenericGF.AZTEC_DATA_8;
            case 10:
                return GenericGF.AZTEC_DATA_10;
            case 12:
                return GenericGF.AZTEC_DATA_12;
            default:
                throw new IllegalArgumentException("Unsupported word size " + wordSize);
        }
    }

    static BitArray stuffBits(BitArray bits, int wordSize) {
        BitArray out = new BitArray();
        int n = bits.getSize();
        int mask = (1 << wordSize) - 2;
        int i = 0;
        while (i < n) {
            int word = 0;
            for (int j = 0; j < wordSize; j++) {
                if (i + j >= n || bits.get(i + j)) {
                    word |= 1 << ((wordSize - 1) - j);
                }
            }
            if ((word & mask) == mask) {
                out.appendBits(word & mask, wordSize);
                i--;
            } else if ((word & mask) == 0) {
                out.appendBits(word | 1, wordSize);
                i--;
            } else {
                out.appendBits(word, wordSize);
            }
            i += wordSize;
        }
        return out;
    }

    private static int totalBitsInLayer(int layers, boolean compact) {
        return ((compact ? 88 : 112) + (layers << 4)) * layers;
    }
}
