package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil {
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;

    private MatrixUtil() {
    }

    static {
        int[] iArr = new int[7];
        int[] iArr2 = iArr;
        // fill-array-data instruction
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        iArr[3] = -1;
        iArr[4] = -1;
        iArr[5] = -1;
        iArr[6] = -1;
        int[] iArr3 = new int[7];
        int[] iArr4 = iArr3;
        // fill-array-data instruction
        iArr3[0] = 6;
        iArr3[1] = 18;
        iArr3[2] = -1;
        iArr3[3] = -1;
        iArr3[4] = -1;
        iArr3[5] = -1;
        iArr3[6] = -1;
        int[] iArr5 = new int[7];
        int[] iArr6 = iArr5;
        // fill-array-data instruction
        iArr5[0] = 6;
        iArr5[1] = 22;
        iArr5[2] = -1;
        iArr5[3] = -1;
        iArr5[4] = -1;
        iArr5[5] = -1;
        iArr5[6] = -1;
        int[] iArr7 = new int[7];
        int[] iArr8 = iArr7;
        // fill-array-data instruction
        iArr7[0] = 6;
        iArr7[1] = 26;
        iArr7[2] = -1;
        iArr7[3] = -1;
        iArr7[4] = -1;
        iArr7[5] = -1;
        iArr7[6] = -1;
        int[] iArr9 = new int[7];
        int[] iArr10 = iArr9;
        // fill-array-data instruction
        iArr9[0] = 6;
        iArr9[1] = 30;
        iArr9[2] = -1;
        iArr9[3] = -1;
        iArr9[4] = -1;
        iArr9[5] = -1;
        iArr9[6] = -1;
        int[] iArr11 = new int[7];
        int[] iArr12 = iArr11;
        // fill-array-data instruction
        iArr11[0] = 6;
        iArr11[1] = 34;
        iArr11[2] = -1;
        iArr11[3] = -1;
        iArr11[4] = -1;
        iArr11[5] = -1;
        iArr11[6] = -1;
        int[] iArr13 = new int[7];
        int[] iArr14 = iArr13;
        // fill-array-data instruction
        iArr13[0] = 6;
        iArr13[1] = 22;
        iArr13[2] = 38;
        iArr13[3] = -1;
        iArr13[4] = -1;
        iArr13[5] = -1;
        iArr13[6] = -1;
        int[] iArr15 = new int[7];
        int[] iArr16 = iArr15;
        // fill-array-data instruction
        iArr15[0] = 6;
        iArr15[1] = 24;
        iArr15[2] = 42;
        iArr15[3] = -1;
        iArr15[4] = -1;
        iArr15[5] = -1;
        iArr15[6] = -1;
        int[] iArr17 = new int[7];
        int[] iArr18 = iArr17;
        // fill-array-data instruction
        iArr17[0] = 6;
        iArr17[1] = 26;
        iArr17[2] = 46;
        iArr17[3] = -1;
        iArr17[4] = -1;
        iArr17[5] = -1;
        iArr17[6] = -1;
        int[] iArr19 = new int[7];
        int[] iArr20 = iArr19;
        // fill-array-data instruction
        iArr19[0] = 6;
        iArr19[1] = 28;
        iArr19[2] = 50;
        iArr19[3] = -1;
        iArr19[4] = -1;
        iArr19[5] = -1;
        iArr19[6] = -1;
        int[] iArr21 = new int[7];
        int[] iArr22 = iArr21;
        // fill-array-data instruction
        iArr21[0] = 6;
        iArr21[1] = 30;
        iArr21[2] = 54;
        iArr21[3] = -1;
        iArr21[4] = -1;
        iArr21[5] = -1;
        iArr21[6] = -1;
        int[] iArr23 = new int[7];
        int[] iArr24 = iArr23;
        // fill-array-data instruction
        iArr23[0] = 6;
        iArr23[1] = 32;
        iArr23[2] = 58;
        iArr23[3] = -1;
        iArr23[4] = -1;
        iArr23[5] = -1;
        iArr23[6] = -1;
        int[] iArr25 = new int[7];
        int[] iArr26 = iArr25;
        // fill-array-data instruction
        iArr25[0] = 6;
        iArr25[1] = 34;
        iArr25[2] = 62;
        iArr25[3] = -1;
        iArr25[4] = -1;
        iArr25[5] = -1;
        iArr25[6] = -1;
        int[] iArr27 = new int[7];
        int[] iArr28 = iArr27;
        // fill-array-data instruction
        iArr27[0] = 6;
        iArr27[1] = 26;
        iArr27[2] = 46;
        iArr27[3] = 66;
        iArr27[4] = -1;
        iArr27[5] = -1;
        iArr27[6] = -1;
        int[] iArr29 = new int[7];
        int[] iArr30 = iArr29;
        // fill-array-data instruction
        iArr29[0] = 6;
        iArr29[1] = 26;
        iArr29[2] = 48;
        iArr29[3] = 70;
        iArr29[4] = -1;
        iArr29[5] = -1;
        iArr29[6] = -1;
        int[] iArr31 = new int[7];
        int[] iArr32 = iArr31;
        // fill-array-data instruction
        iArr31[0] = 6;
        iArr31[1] = 26;
        iArr31[2] = 50;
        iArr31[3] = 74;
        iArr31[4] = -1;
        iArr31[5] = -1;
        iArr31[6] = -1;
        int[] iArr33 = new int[7];
        int[] iArr34 = iArr33;
        // fill-array-data instruction
        iArr33[0] = 6;
        iArr33[1] = 30;
        iArr33[2] = 54;
        iArr33[3] = 78;
        iArr33[4] = -1;
        iArr33[5] = -1;
        iArr33[6] = -1;
        int[] iArr35 = new int[7];
        int[] iArr36 = iArr35;
        // fill-array-data instruction
        iArr35[0] = 6;
        iArr35[1] = 30;
        iArr35[2] = 56;
        iArr35[3] = 82;
        iArr35[4] = -1;
        iArr35[5] = -1;
        iArr35[6] = -1;
        int[] iArr37 = new int[7];
        int[] iArr38 = iArr37;
        // fill-array-data instruction
        iArr37[0] = 6;
        iArr37[1] = 30;
        iArr37[2] = 58;
        iArr37[3] = 86;
        iArr37[4] = -1;
        iArr37[5] = -1;
        iArr37[6] = -1;
        int[] iArr39 = new int[7];
        int[] iArr40 = iArr39;
        // fill-array-data instruction
        iArr39[0] = 6;
        iArr39[1] = 34;
        iArr39[2] = 62;
        iArr39[3] = 90;
        iArr39[4] = -1;
        iArr39[5] = -1;
        iArr39[6] = -1;
        int[] iArr41 = new int[7];
        int[] iArr42 = iArr41;
        // fill-array-data instruction
        iArr41[0] = 6;
        iArr41[1] = 28;
        iArr41[2] = 50;
        iArr41[3] = 72;
        iArr41[4] = 94;
        iArr41[5] = -1;
        iArr41[6] = -1;
        int[] iArr43 = new int[7];
        int[] iArr44 = iArr43;
        // fill-array-data instruction
        iArr43[0] = 6;
        iArr43[1] = 26;
        iArr43[2] = 50;
        iArr43[3] = 74;
        iArr43[4] = 98;
        iArr43[5] = -1;
        iArr43[6] = -1;
        int[] iArr45 = new int[7];
        int[] iArr46 = iArr45;
        // fill-array-data instruction
        iArr45[0] = 6;
        iArr45[1] = 30;
        iArr45[2] = 54;
        iArr45[3] = 78;
        iArr45[4] = 102;
        iArr45[5] = -1;
        iArr45[6] = -1;
        int[] iArr47 = new int[7];
        int[] iArr48 = iArr47;
        // fill-array-data instruction
        iArr47[0] = 6;
        iArr47[1] = 28;
        iArr47[2] = 54;
        iArr47[3] = 80;
        iArr47[4] = 106;
        iArr47[5] = -1;
        iArr47[6] = -1;
        int[] iArr49 = new int[7];
        int[] iArr50 = iArr49;
        // fill-array-data instruction
        iArr49[0] = 6;
        iArr49[1] = 32;
        iArr49[2] = 58;
        iArr49[3] = 84;
        iArr49[4] = 110;
        iArr49[5] = -1;
        iArr49[6] = -1;
        int[] iArr51 = new int[7];
        int[] iArr52 = iArr51;
        // fill-array-data instruction
        iArr51[0] = 6;
        iArr51[1] = 30;
        iArr51[2] = 58;
        iArr51[3] = 86;
        iArr51[4] = 114;
        iArr51[5] = -1;
        iArr51[6] = -1;
        int[] iArr53 = new int[7];
        int[] iArr54 = iArr53;
        // fill-array-data instruction
        iArr53[0] = 6;
        iArr53[1] = 34;
        iArr53[2] = 62;
        iArr53[3] = 90;
        iArr53[4] = 118;
        iArr53[5] = -1;
        iArr53[6] = -1;
        int[] iArr55 = new int[7];
        int[] iArr56 = iArr55;
        // fill-array-data instruction
        iArr55[0] = 6;
        iArr55[1] = 26;
        iArr55[2] = 50;
        iArr55[3] = 74;
        iArr55[4] = 98;
        iArr55[5] = 122;
        iArr55[6] = -1;
        int[] iArr57 = new int[7];
        int[] iArr58 = iArr57;
        // fill-array-data instruction
        iArr57[0] = 6;
        iArr57[1] = 30;
        iArr57[2] = 54;
        iArr57[3] = 78;
        iArr57[4] = 102;
        iArr57[5] = 126;
        iArr57[6] = -1;
        int[] iArr59 = new int[7];
        int[] iArr60 = iArr59;
        // fill-array-data instruction
        iArr59[0] = 6;
        iArr59[1] = 26;
        iArr59[2] = 52;
        iArr59[3] = 78;
        iArr59[4] = 104;
        iArr59[5] = 130;
        iArr59[6] = -1;
        int[] iArr61 = new int[7];
        int[] iArr62 = iArr61;
        // fill-array-data instruction
        iArr61[0] = 6;
        iArr61[1] = 30;
        iArr61[2] = 56;
        iArr61[3] = 82;
        iArr61[4] = 108;
        iArr61[5] = 134;
        iArr61[6] = -1;
        int[] iArr63 = new int[7];
        int[] iArr64 = iArr63;
        // fill-array-data instruction
        iArr63[0] = 6;
        iArr63[1] = 34;
        iArr63[2] = 60;
        iArr63[3] = 86;
        iArr63[4] = 112;
        iArr63[5] = 138;
        iArr63[6] = -1;
        int[] iArr65 = new int[7];
        int[] iArr66 = iArr65;
        // fill-array-data instruction
        iArr65[0] = 6;
        iArr65[1] = 30;
        iArr65[2] = 58;
        iArr65[3] = 86;
        iArr65[4] = 114;
        iArr65[5] = 142;
        iArr65[6] = -1;
        int[] iArr67 = new int[7];
        int[] iArr68 = iArr67;
        // fill-array-data instruction
        iArr67[0] = 6;
        iArr67[1] = 34;
        iArr67[2] = 62;
        iArr67[3] = 90;
        iArr67[4] = 118;
        iArr67[5] = 146;
        iArr67[6] = -1;
        int[] iArr69 = new int[7];
        int[] iArr70 = iArr69;
        // fill-array-data instruction
        iArr69[0] = 6;
        iArr69[1] = 30;
        iArr69[2] = 54;
        iArr69[3] = 78;
        iArr69[4] = 102;
        iArr69[5] = 126;
        iArr69[6] = 150;
        int[] iArr71 = new int[7];
        int[] iArr72 = iArr71;
        // fill-array-data instruction
        iArr71[0] = 6;
        iArr71[1] = 24;
        iArr71[2] = 50;
        iArr71[3] = 76;
        iArr71[4] = 102;
        iArr71[5] = 128;
        iArr71[6] = 154;
        int[] iArr73 = new int[7];
        int[] iArr74 = iArr73;
        // fill-array-data instruction
        iArr73[0] = 6;
        iArr73[1] = 28;
        iArr73[2] = 54;
        iArr73[3] = 80;
        iArr73[4] = 106;
        iArr73[5] = 132;
        iArr73[6] = 158;
        int[] iArr75 = new int[7];
        int[] iArr76 = iArr75;
        // fill-array-data instruction
        iArr75[0] = 6;
        iArr75[1] = 32;
        iArr75[2] = 58;
        iArr75[3] = 84;
        iArr75[4] = 110;
        iArr75[5] = 136;
        iArr75[6] = 162;
        int[] iArr77 = new int[7];
        int[] iArr78 = iArr77;
        // fill-array-data instruction
        iArr77[0] = 6;
        iArr77[1] = 26;
        iArr77[2] = 54;
        iArr77[3] = 82;
        iArr77[4] = 110;
        iArr77[5] = 138;
        iArr77[6] = 166;
        int[] iArr79 = new int[7];
        // fill-array-data instruction
        iArr79[0] = 6;
        iArr79[1] = 30;
        iArr79[2] = 58;
        iArr79[3] = 86;
        iArr79[4] = 114;
        iArr79[5] = 142;
        iArr79[6] = 170;
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][]{iArr2, iArr4, iArr6, iArr8, iArr10, iArr12, iArr14, iArr16, iArr18, iArr20, iArr22, iArr24, iArr26, iArr28, iArr30, iArr32, iArr34, iArr36, iArr38, iArr40, iArr42, iArr44, iArr46, iArr48, iArr50, iArr52, iArr54, iArr56, iArr58, iArr60, iArr62, iArr64, iArr66, iArr68, iArr70, iArr72, iArr74, iArr76, iArr78, iArr79};
    }

    static void clearMatrix(ByteMatrix matrix) {
        matrix.clear((byte) -1);
    }

    static void buildMatrix(BitArray dataBits, ErrorCorrectionLevel ecLevel, Version version, int maskPattern, ByteMatrix matrix) throws WriterException {
        clearMatrix(matrix);
        embedBasicPatterns(version, matrix);
        embedTypeInfo(ecLevel, maskPattern, matrix);
        maybeEmbedVersionInfo(version, matrix);
        embedDataBits(dataBits, maskPattern, matrix);
    }

    static void embedBasicPatterns(Version version, ByteMatrix matrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(matrix);
        embedDarkDotAtLeftBottomCorner(matrix);
        maybeEmbedPositionAdjustmentPatterns(version, matrix);
        embedTimingPatterns(matrix);
    }

    static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i, bitArray);
        for (int i2 = 0; i2 < bitArray.getSize(); i2++) {
            boolean z = bitArray.get((bitArray.getSize() - 1) - i2);
            int[] iArr = TYPE_INFO_COORDINATES[i2];
            byteMatrix.set(iArr[0], iArr[1], z);
            if (i2 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i2) - 1, 8, z);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i2 - 8), z);
            }
        }
    }

    static void maybeEmbedVersionInfo(Version version, ByteMatrix matrix) throws WriterException {
        if (version.getVersionNumber() >= 7) {
            BitArray versionInfoBits = new BitArray();
            makeVersionInfoBits(version, versionInfoBits);
            int bitIndex = 17;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    boolean bit = versionInfoBits.get(bitIndex);
                    bitIndex--;
                    matrix.set(i, (matrix.getHeight() - 11) + j, bit);
                    matrix.set((matrix.getHeight() - 11) + j, i, bit);
                }
            }
        }
    }

    static void embedDataBits(BitArray dataBits, int maskPattern, ByteMatrix matrix) throws WriterException {
        boolean bit;
        int bitIndex = 0;
        int direction = -1;
        int x = matrix.getWidth() - 1;
        int y = matrix.getHeight() - 1;
        while (x > 0) {
            if (x == 6) {
                x--;
            }
            while (y >= 0 && y < matrix.getHeight()) {
                for (int i = 0; i < 2; i++) {
                    int xx = x - i;
                    if (isEmpty(matrix.get(xx, y))) {
                        if (bitIndex < dataBits.getSize()) {
                            bit = dataBits.get(bitIndex);
                            bitIndex++;
                        } else {
                            bit = false;
                        }
                        if (maskPattern != -1 && MaskUtil.getDataMaskBit(maskPattern, xx, y)) {
                            bit = !bit;
                        }
                        matrix.set(xx, y, bit);
                    }
                }
                y += direction;
            }
            direction = -direction;
            y += direction;
            x -= 2;
        }
        if (bitIndex != dataBits.getSize()) {
            throw new WriterException("Not all bits consumed: " + bitIndex + '/' + dataBits.getSize());
        }
    }

    static int findMSBSet(int value) {
        return 32 - Integer.numberOfLeadingZeros(value);
    }

    static int calculateBCHCode(int value, int poly) {
        if (poly != 0) {
            int msbSetInPoly = findMSBSet(poly);
            int value2 = value << (msbSetInPoly - 1);
            while (findMSBSet(value2) >= msbSetInPoly) {
                value2 ^= poly << (findMSBSet(value2) - msbSetInPoly);
            }
            return value2;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void makeTypeInfoBits(ErrorCorrectionLevel ecLevel, int maskPattern, BitArray bits) throws WriterException {
        if (QRCode.isValidMaskPattern(maskPattern)) {
            int typeInfo = (ecLevel.getBits() << 3) | maskPattern;
            bits.appendBits(typeInfo, 5);
            bits.appendBits(calculateBCHCode(typeInfo, TYPE_INFO_POLY), 10);
            BitArray maskBits = new BitArray();
            maskBits.appendBits(TYPE_INFO_MASK_PATTERN, 15);
            bits.xor(maskBits);
            if (bits.getSize() != 15) {
                throw new WriterException("should not happen but we got: " + bits.getSize());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void makeVersionInfoBits(Version version, BitArray bits) throws WriterException {
        bits.appendBits(version.getVersionNumber(), 6);
        bits.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bits.getSize() != 18) {
            throw new WriterException("should not happen but we got: " + bits.getSize());
        }
    }

    private static boolean isEmpty(int value) {
        return value == -1;
    }

    private static void embedTimingPatterns(ByteMatrix matrix) {
        for (int i = 8; i < matrix.getWidth() - 8; i++) {
            int bit = (i + 1) % 2;
            if (isEmpty(matrix.get(i, 6))) {
                matrix.set(i, 6, bit);
            }
            if (isEmpty(matrix.get(6, i))) {
                matrix.set(6, i, bit);
            }
        }
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix matrix) throws WriterException {
        if (matrix.get(8, matrix.getHeight() - 8) != 0) {
            matrix.set(8, matrix.getHeight() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void embedHorizontalSeparationPattern(int xStart, int yStart, ByteMatrix matrix) throws WriterException {
        int x = 0;
        while (x < 8) {
            if (isEmpty(matrix.get(xStart + x, yStart))) {
                matrix.set(xStart + x, yStart, 0);
                x++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedVerticalSeparationPattern(int xStart, int yStart, ByteMatrix matrix) throws WriterException {
        int y = 0;
        while (y < 7) {
            if (isEmpty(matrix.get(xStart, yStart + y))) {
                matrix.set(xStart, yStart + y, 0);
                y++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedPositionAdjustmentPattern(int xStart, int yStart, ByteMatrix matrix) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                matrix.set(xStart + x, yStart + y, POSITION_ADJUSTMENT_PATTERN[y][x]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int xStart, int yStart, ByteMatrix matrix) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                matrix.set(xStart + x, yStart + y, POSITION_DETECTION_PATTERN[y][x]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix matrix) throws WriterException {
        int pdpWidth = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, matrix);
        embedPositionDetectionPattern(matrix.getWidth() - pdpWidth, 0, matrix);
        embedPositionDetectionPattern(0, matrix.getWidth() - pdpWidth, matrix);
        embedHorizontalSeparationPattern(0, 7, matrix);
        embedHorizontalSeparationPattern(matrix.getWidth() - 8, 7, matrix);
        embedHorizontalSeparationPattern(0, matrix.getWidth() - 8, matrix);
        embedVerticalSeparationPattern(7, 0, matrix);
        embedVerticalSeparationPattern((matrix.getHeight() - 7) - 1, 0, matrix);
        embedVerticalSeparationPattern(7, matrix.getHeight() - 7, matrix);
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix matrix) {
        if (version.getVersionNumber() >= 2) {
            int index = version.getVersionNumber() - 1;
            int[][] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
            int[] coordinates = iArr[index];
            int numCoordinates = iArr[index].length;
            for (int i = 0; i < numCoordinates; i++) {
                for (int j = 0; j < numCoordinates; j++) {
                    int y = coordinates[i];
                    int i2 = coordinates[j];
                    int x = i2;
                    if (!(i2 == -1 || y == -1 || !isEmpty(matrix.get(x, y)))) {
                        embedPositionAdjustmentPattern(x - 2, y - 2, matrix);
                    }
                }
            }
        }
    }
}
