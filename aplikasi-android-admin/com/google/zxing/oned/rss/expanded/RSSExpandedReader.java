package com.google.zxing.oned.rss.expanded;

import androidx.compose.runtime.ComposerKt;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, ComposerKt.providerMapsKey};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS;
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;

    static {
        int[] iArr = new int[8];
        int[] iArr2 = iArr;
        // fill-array-data instruction
        iArr[0] = 1;
        iArr[1] = 3;
        iArr[2] = 9;
        iArr[3] = 27;
        iArr[4] = 81;
        iArr[5] = 32;
        iArr[6] = 96;
        iArr[7] = 77;
        int[] iArr3 = new int[8];
        int[] iArr4 = iArr3;
        // fill-array-data instruction
        iArr3[0] = 20;
        iArr3[1] = 60;
        iArr3[2] = 180;
        iArr3[3] = 118;
        iArr3[4] = 143;
        iArr3[5] = 7;
        iArr3[6] = 21;
        iArr3[7] = 63;
        int[] iArr5 = new int[8];
        int[] iArr6 = iArr5;
        // fill-array-data instruction
        iArr5[0] = 189;
        iArr5[1] = 145;
        iArr5[2] = 13;
        iArr5[3] = 39;
        iArr5[4] = 117;
        iArr5[5] = 140;
        iArr5[6] = 209;
        iArr5[7] = 205;
        int[] iArr7 = new int[8];
        int[] iArr8 = iArr7;
        // fill-array-data instruction
        iArr7[0] = 193;
        iArr7[1] = 157;
        iArr7[2] = 49;
        iArr7[3] = 147;
        iArr7[4] = 19;
        iArr7[5] = 57;
        iArr7[6] = 171;
        iArr7[7] = 91;
        int[] iArr9 = new int[8];
        int[] iArr10 = iArr9;
        // fill-array-data instruction
        iArr9[0] = 62;
        iArr9[1] = 186;
        iArr9[2] = 136;
        iArr9[3] = 197;
        iArr9[4] = 169;
        iArr9[5] = 85;
        iArr9[6] = 44;
        iArr9[7] = 132;
        int[] iArr11 = new int[8];
        int[] iArr12 = iArr11;
        // fill-array-data instruction
        iArr11[0] = 185;
        iArr11[1] = 133;
        iArr11[2] = 188;
        iArr11[3] = 142;
        iArr11[4] = 4;
        iArr11[5] = 12;
        iArr11[6] = 36;
        iArr11[7] = 108;
        int[] iArr13 = new int[8];
        int[] iArr14 = iArr13;
        // fill-array-data instruction
        iArr13[0] = 113;
        iArr13[1] = 128;
        iArr13[2] = 173;
        iArr13[3] = 97;
        iArr13[4] = 80;
        iArr13[5] = 29;
        iArr13[6] = 87;
        iArr13[7] = 50;
        int[] iArr15 = new int[8];
        int[] iArr16 = iArr15;
        // fill-array-data instruction
        iArr15[0] = 150;
        iArr15[1] = 28;
        iArr15[2] = 84;
        iArr15[3] = 41;
        iArr15[4] = 123;
        iArr15[5] = 158;
        iArr15[6] = 52;
        iArr15[7] = 156;
        int[] iArr17 = new int[8];
        int[] iArr18 = iArr17;
        // fill-array-data instruction
        iArr17[0] = 46;
        iArr17[1] = 138;
        iArr17[2] = 203;
        iArr17[3] = 187;
        iArr17[4] = 139;
        iArr17[5] = 206;
        iArr17[6] = 196;
        iArr17[7] = 166;
        int[] iArr19 = new int[8];
        int[] iArr20 = iArr19;
        // fill-array-data instruction
        iArr19[0] = 76;
        iArr19[1] = 17;
        iArr19[2] = 51;
        iArr19[3] = 153;
        iArr19[4] = 37;
        iArr19[5] = 111;
        iArr19[6] = 122;
        iArr19[7] = 155;
        int[] iArr21 = new int[8];
        int[] iArr22 = iArr21;
        // fill-array-data instruction
        iArr21[0] = 43;
        iArr21[1] = 129;
        iArr21[2] = 176;
        iArr21[3] = 106;
        iArr21[4] = 107;
        iArr21[5] = 110;
        iArr21[6] = 119;
        iArr21[7] = 146;
        int[] iArr23 = new int[8];
        int[] iArr24 = iArr23;
        // fill-array-data instruction
        iArr23[0] = 16;
        iArr23[1] = 48;
        iArr23[2] = 144;
        iArr23[3] = 10;
        iArr23[4] = 30;
        iArr23[5] = 90;
        iArr23[6] = 59;
        iArr23[7] = 177;
        int[] iArr25 = new int[8];
        int[] iArr26 = iArr25;
        // fill-array-data instruction
        iArr25[0] = 109;
        iArr25[1] = 116;
        iArr25[2] = 137;
        iArr25[3] = 200;
        iArr25[4] = 178;
        iArr25[5] = 112;
        iArr25[6] = 125;
        iArr25[7] = 164;
        int[] iArr27 = new int[8];
        int[] iArr28 = iArr27;
        // fill-array-data instruction
        iArr27[0] = 70;
        iArr27[1] = 210;
        iArr27[2] = 208;
        iArr27[3] = 202;
        iArr27[4] = 184;
        iArr27[5] = 130;
        iArr27[6] = 179;
        iArr27[7] = 115;
        int[] iArr29 = new int[8];
        int[] iArr30 = iArr29;
        // fill-array-data instruction
        iArr29[0] = 134;
        iArr29[1] = 191;
        iArr29[2] = 151;
        iArr29[3] = 31;
        iArr29[4] = 93;
        iArr29[5] = 68;
        iArr29[6] = 204;
        iArr29[7] = 190;
        int[] iArr31 = new int[8];
        int[] iArr32 = iArr31;
        // fill-array-data instruction
        iArr31[0] = 148;
        iArr31[1] = 22;
        iArr31[2] = 66;
        iArr31[3] = 198;
        iArr31[4] = 172;
        iArr31[5] = 94;
        iArr31[6] = 71;
        iArr31[7] = 2;
        int[] iArr33 = new int[8];
        int[] iArr34 = iArr33;
        // fill-array-data instruction
        iArr33[0] = 6;
        iArr33[1] = 18;
        iArr33[2] = 54;
        iArr33[3] = 162;
        iArr33[4] = 64;
        iArr33[5] = 192;
        iArr33[6] = 154;
        iArr33[7] = 40;
        int[] iArr35 = new int[8];
        int[] iArr36 = iArr35;
        // fill-array-data instruction
        iArr35[0] = 120;
        iArr35[1] = 149;
        iArr35[2] = 25;
        iArr35[3] = 75;
        iArr35[4] = 14;
        iArr35[5] = 42;
        iArr35[6] = 126;
        iArr35[7] = 167;
        int[] iArr37 = new int[8];
        int[] iArr38 = iArr37;
        // fill-array-data instruction
        iArr37[0] = 79;
        iArr37[1] = 26;
        iArr37[2] = 78;
        iArr37[3] = 23;
        iArr37[4] = 69;
        iArr37[5] = 207;
        iArr37[6] = 199;
        iArr37[7] = 175;
        int[] iArr39 = new int[8];
        int[] iArr40 = iArr39;
        // fill-array-data instruction
        iArr39[0] = 103;
        iArr39[1] = 98;
        iArr39[2] = 83;
        iArr39[3] = 38;
        iArr39[4] = 114;
        iArr39[5] = 131;
        iArr39[6] = 182;
        iArr39[7] = 124;
        int[] iArr41 = new int[8];
        int[] iArr42 = iArr41;
        // fill-array-data instruction
        iArr41[0] = 161;
        iArr41[1] = 61;
        iArr41[2] = 183;
        iArr41[3] = 127;
        iArr41[4] = 170;
        iArr41[5] = 88;
        iArr41[6] = 53;
        iArr41[7] = 159;
        int[] iArr43 = new int[8];
        int[] iArr44 = iArr43;
        // fill-array-data instruction
        iArr43[0] = 55;
        iArr43[1] = 165;
        iArr43[2] = 73;
        iArr43[3] = 8;
        iArr43[4] = 24;
        iArr43[5] = 72;
        iArr43[6] = 5;
        iArr43[7] = 15;
        int[] iArr45 = new int[8];
        // fill-array-data instruction
        iArr45[0] = 45;
        iArr45[1] = 135;
        iArr45[2] = 194;
        iArr45[3] = 160;
        iArr45[4] = 58;
        iArr45[5] = 174;
        iArr45[6] = 100;
        iArr45[7] = 89;
        WEIGHTS = new int[][]{iArr2, iArr4, iArr6, iArr8, iArr10, iArr12, iArr14, iArr16, iArr18, iArr20, iArr22, iArr24, iArr26, iArr28, iArr30, iArr32, iArr34, iArr36, iArr38, iArr40, iArr42, iArr44, iArr45};
    }

    public Result decodeRow(int rowNumber, BitArray row, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(rowNumber, row));
        } catch (NotFoundException e) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(rowNumber, row));
        }
    }

    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    /* access modifiers changed from: package-private */
    public List<ExpandedPair> decodeRow2pairs(int rowNumber, BitArray row) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(row, this.pairs, rowNumber));
            } catch (NotFoundException nfe) {
                if (this.pairs.isEmpty()) {
                    throw nfe;
                } else if (checkChecksum()) {
                    return this.pairs;
                } else {
                    boolean tryStackedDecode = !this.rows.isEmpty();
                    storeRow(rowNumber, false);
                    if (tryStackedDecode) {
                        List<ExpandedPair> checkRows = checkRows(false);
                        List<ExpandedPair> ps = checkRows;
                        if (checkRows != null) {
                            return ps;
                        }
                        List<ExpandedPair> checkRows2 = checkRows(true);
                        List<ExpandedPair> ps2 = checkRows2;
                        if (checkRows2 != null) {
                            return ps2;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    private List<ExpandedPair> checkRows(boolean reverse) {
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (reverse) {
            Collections.reverse(this.rows);
        }
        List<ExpandedPair> ps = null;
        try {
            ps = checkRows(new ArrayList(), 0);
        } catch (NotFoundException e) {
        }
        if (reverse) {
            Collections.reverse(this.rows);
        }
        return ps;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> collectedRows, int currentRow) throws NotFoundException {
        int i = currentRow;
        while (i < this.rows.size()) {
            ExpandedRow row = this.rows.get(i);
            this.pairs.clear();
            for (ExpandedRow collectedRow : collectedRows) {
                this.pairs.addAll(collectedRow.getPairs());
            }
            this.pairs.addAll(row.getPairs());
            if (!isValidSequence(this.pairs)) {
                i++;
            } else if (checkChecksum()) {
                return this.pairs;
            } else {
                List<ExpandedRow> arrayList = new ArrayList<>();
                List<ExpandedRow> rs = arrayList;
                arrayList.addAll(collectedRows);
                rs.add(row);
                try {
                    return checkRows(rs, i + 1);
                } catch (NotFoundException e) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> pairs2) {
        for (int[] sequence : FINDER_PATTERN_SEQUENCES) {
            if (pairs2.size() <= sequence.length) {
                boolean stop = true;
                int j = 0;
                while (true) {
                    if (j >= pairs2.size()) {
                        break;
                    } else if (pairs2.get(j).getFinderPattern().getValue() != sequence[j]) {
                        stop = false;
                        break;
                    } else {
                        j++;
                    }
                }
                if (stop) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int rowNumber, boolean wasReversed) {
        int insertPos = 0;
        boolean prevIsSame = false;
        boolean nextIsSame = false;
        while (true) {
            if (insertPos >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(insertPos);
            ExpandedRow erow = expandedRow;
            if (expandedRow.getRowNumber() > rowNumber) {
                nextIsSame = erow.isEquivalent(this.pairs);
                break;
            } else {
                prevIsSame = erow.isEquivalent(this.pairs);
                insertPos++;
            }
        }
        if (!nextIsSame && !prevIsSame && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(insertPos, new ExpandedRow(this.pairs, rowNumber, wasReversed));
            removePartialRows(this.pairs, this.rows);
        }
    }

    private static void removePartialRows(List<ExpandedPair> pairs2, List<ExpandedRow> rows2) {
        Iterator<ExpandedRow> iterator = rows2.iterator();
        while (iterator.hasNext()) {
            ExpandedRow next = iterator.next();
            ExpandedRow r = next;
            if (next.getPairs().size() != pairs2.size()) {
                boolean allFound = true;
                Iterator<ExpandedPair> it = r.getPairs().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ExpandedPair p = it.next();
                    boolean found = false;
                    Iterator<ExpandedPair> it2 = pairs2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (p.equals(it2.next())) {
                                found = true;
                                continue;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!found) {
                        allFound = false;
                        break;
                    }
                }
                if (allFound) {
                    iterator.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> pairs2, Iterable<ExpandedRow> rows2) {
        for (ExpandedRow r : rows2) {
            boolean allFound = true;
            Iterator<ExpandedPair> it = pairs2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ExpandedPair p = it.next();
                boolean found = false;
                Iterator<ExpandedPair> it2 = r.getPairs().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (p.equals(it2.next())) {
                            found = true;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!found) {
                    allFound = false;
                    continue;
                    break;
                }
            }
            if (allFound) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> pairs2) throws NotFoundException, FormatException {
        String resultingString = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(pairs2)).parseInformation();
        ResultPoint[] firstPoints = pairs2.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] lastPoints = pairs2.get(pairs2.size() - 1).getFinderPattern().getResultPoints();
        return new Result(resultingString, (byte[]) null, new ResultPoint[]{firstPoints[0], firstPoints[1], lastPoints[0], lastPoints[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        ExpandedPair firstPair = expandedPair;
        DataCharacter checkCharacter = expandedPair.getLeftChar();
        DataCharacter rightChar = firstPair.getRightChar();
        DataCharacter firstCharacter = rightChar;
        if (rightChar == null) {
            return false;
        }
        int checksum = firstCharacter.getChecksumPortion();
        int s = 2;
        for (int i = 1; i < this.pairs.size(); i++) {
            ExpandedPair currentPair = this.pairs.get(i);
            checksum += currentPair.getLeftChar().getChecksumPortion();
            s++;
            DataCharacter rightChar2 = currentPair.getRightChar();
            DataCharacter currentRightChar = rightChar2;
            if (rightChar2 != null) {
                checksum += currentRightChar.getChecksumPortion();
                s++;
            }
        }
        if (((s - 4) * 211) + (checksum % 211) == checkCharacter.getValue()) {
            return true;
        }
        return false;
    }

    private static int getNextSecondBar(BitArray row, int initialPos) {
        if (row.get(initialPos)) {
            return row.getNextSet(row.getNextUnset(initialPos));
        }
        return row.getNextUnset(row.getNextSet(initialPos));
    }

    /* access modifiers changed from: package-private */
    public ExpandedPair retrieveNextPair(BitArray row, List<ExpandedPair> previousPairs, int rowNumber) throws NotFoundException {
        FinderPattern pattern;
        DataCharacter rightChar;
        boolean isOddPattern = previousPairs.size() % 2 == 0;
        if (this.startFromEven) {
            isOddPattern = !isOddPattern;
        }
        boolean keepFinding = true;
        int forcedOffset = -1;
        do {
            findNextPair(row, previousPairs, forcedOffset);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(row, rowNumber, isOddPattern);
            pattern = parseFoundFinderPattern;
            if (parseFoundFinderPattern == null) {
                forcedOffset = getNextSecondBar(row, this.startEnd[0]);
                continue;
            } else {
                keepFinding = false;
                continue;
            }
        } while (keepFinding);
        DataCharacter leftChar = decodeDataCharacter(row, pattern, isOddPattern, true);
        if (previousPairs.isEmpty() || !previousPairs.get(previousPairs.size() - 1).mustBeLast()) {
            try {
                rightChar = decodeDataCharacter(row, pattern, isOddPattern, false);
            } catch (NotFoundException e) {
                rightChar = null;
            }
            return new ExpandedPair(leftChar, rightChar, pattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void findNextPair(BitArray row, List<ExpandedPair> previousPairs, int forcedOffset) throws NotFoundException {
        int rowOffset;
        BitArray bitArray = row;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        int[] counters = decodeFinderCounters;
        decodeFinderCounters[0] = 0;
        counters[1] = 0;
        counters[2] = 0;
        counters[3] = 0;
        int width = row.getSize();
        if (forcedOffset >= 0) {
            rowOffset = forcedOffset;
            List<ExpandedPair> list = previousPairs;
        } else if (previousPairs.isEmpty()) {
            rowOffset = 0;
            List<ExpandedPair> list2 = previousPairs;
        } else {
            rowOffset = previousPairs.get(previousPairs.size() - 1).getFinderPattern().getStartEnd()[1];
        }
        boolean searchingEvenPair = previousPairs.size() % 2 != 0;
        if (this.startFromEven) {
            searchingEvenPair = !searchingEvenPair;
        }
        boolean isWhite = false;
        while (rowOffset < width) {
            boolean z = !bitArray.get(rowOffset);
            isWhite = z;
            if (!z) {
                break;
            }
            rowOffset++;
        }
        int counterPosition = 0;
        int patternStart = rowOffset;
        for (int x = rowOffset; x < width; x++) {
            if (bitArray.get(x) ^ isWhite) {
                counters[counterPosition] = counters[counterPosition] + 1;
            } else {
                if (counterPosition == 3) {
                    if (searchingEvenPair) {
                        reverseCounters(counters);
                    }
                    if (isFinderPattern(counters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = patternStart;
                        iArr[1] = x;
                        return;
                    }
                    if (searchingEvenPair) {
                        reverseCounters(counters);
                    }
                    patternStart += counters[0] + counters[1];
                    counters[0] = counters[2];
                    counters[1] = counters[3];
                    counters[2] = 0;
                    counters[3] = 0;
                    counterPosition--;
                } else {
                    counterPosition++;
                }
                counters[counterPosition] = 1;
                isWhite = !isWhite;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void reverseCounters(int[] counters) {
        int length = counters.length;
        for (int i = 0; i < length / 2; i++) {
            int tmp = counters[i];
            counters[i] = counters[(length - i) - 1];
            counters[(length - i) - 1] = tmp;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.startEnd;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.startEnd;
            int i7 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = nextUnset;
            i3 = i7;
            i4 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i4;
        try {
            return new FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        BitArray bitArray2 = bitArray;
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            recordPatternInReverse(bitArray2, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray2, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / 17.0f;
        float f = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(sum - f) / f <= 0.3f) {
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
                float f2 = (((float) dataCharacterCounters[i3]) * 1.0f) / sum;
                int i4 = (int) (0.5f + f2);
                if (i4 <= 0) {
                    if (f2 >= 0.3f) {
                        i4 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i4 > 8) {
                    if (f2 <= 8.7f) {
                        i4 = 8;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i5 = i3 / 2;
                if ((i3 & 1) == 0) {
                    oddCounts[i5] = i4;
                    oddRoundingErrors[i5] = f2 - ((float) i4);
                } else {
                    evenCounts[i5] = i4;
                    evenRoundingErrors[i5] = f2 - ((float) i4);
                }
            }
            adjustOddEvenCounts(17);
            int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (z2 ^ true ? 1 : 0)) - 1;
            int i6 = 0;
            int i7 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                if (isNotA1left(finderPattern, z, z2)) {
                    i6 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
                }
                i7 += oddCounts[length2];
            }
            int i8 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                if (isNotA1left(finderPattern, z, z2)) {
                    i8 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
                }
            }
            int i9 = i6 + i8;
            if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i10 = (13 - i7) / 2;
            int i11 = SYMBOL_WIDEST[i10];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i11, true) * EVEN_TOTAL_SUBSET[i10]) + RSSUtils.getRSSvalue(evenCounts, 9 - i11, false) + GSUM[i10], i9);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isNotA1left(FinderPattern pattern, boolean isOddPattern, boolean leftChar) {
        return pattern.getValue() != 0 || !isOddPattern || !leftChar;
    }

    private void adjustOddEvenCounts(int numModules) throws NotFoundException {
        int oddSum = MathUtils.sum(getOddCounts());
        int evenSum = MathUtils.sum(getEvenCounts());
        boolean incrementOdd = false;
        boolean decrementOdd = false;
        if (oddSum > 13) {
            decrementOdd = true;
        } else if (oddSum < 4) {
            incrementOdd = true;
        }
        boolean incrementEven = false;
        boolean decrementEven = false;
        if (evenSum > 13) {
            decrementEven = true;
        } else if (evenSum < 4) {
            incrementEven = true;
        }
        int mismatch = (oddSum + evenSum) - numModules;
        boolean evenParityBad = false;
        boolean oddParityBad = (oddSum & 1) == 1;
        if ((evenSum & 1) == 0) {
            evenParityBad = true;
        }
        if (mismatch == 1) {
            if (oddParityBad) {
                if (!evenParityBad) {
                    decrementOdd = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (evenParityBad) {
                decrementEven = true;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (mismatch == -1) {
            if (oddParityBad) {
                if (!evenParityBad) {
                    incrementOdd = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (evenParityBad) {
                incrementEven = true;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (mismatch != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (oddParityBad) {
            if (!evenParityBad) {
                throw NotFoundException.getNotFoundInstance();
            } else if (oddSum < evenSum) {
                incrementOdd = true;
                decrementEven = true;
            } else {
                decrementOdd = true;
                incrementEven = true;
            }
        } else if (evenParityBad) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (incrementOdd) {
            if (!decrementOdd) {
                increment(getOddCounts(), getOddRoundingErrors());
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (decrementOdd) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (incrementEven) {
            if (!decrementEven) {
                increment(getEvenCounts(), getOddRoundingErrors());
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (decrementEven) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
