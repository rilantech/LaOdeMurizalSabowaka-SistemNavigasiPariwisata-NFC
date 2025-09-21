package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    public Result decode(BinaryBitmap image) throws NotFoundException, FormatException {
        return decode(image, (Map<DecodeHintType, ?>) null);
    }

    public Result decode(BinaryBitmap image, Map<DecodeHintType, ?> hints) throws NotFoundException, FormatException {
        try {
            return doDecode(image, hints);
        } catch (NotFoundException nfe) {
            if (!(hints != null && hints.containsKey(DecodeHintType.TRY_HARDER)) || !image.isRotateSupported()) {
                throw nfe;
            }
            BinaryBitmap rotatedImage = image.rotateCounterClockwise();
            Result doDecode = doDecode(rotatedImage, hints);
            Result result = doDecode;
            Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
            int orientation = 270;
            if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                orientation = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
            }
            result.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(orientation));
            ResultPoint[] resultPoints = result.getResultPoints();
            ResultPoint[] points = resultPoints;
            if (resultPoints != null) {
                int height = rotatedImage.getHeight();
                for (int i = 0; i < points.length; i++) {
                    points[i] = new ResultPoint((((float) height) - points[i].getY()) - 1.0f, points[i].getX());
                }
            }
            return result;
        }
    }

    public void reset() {
    }

    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        Map<DecodeHintType, ?> map2 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i5 = height >> 1;
        int i6 = 0;
        int i7 = 1;
        boolean z = map2 != null && map2.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z ? 8 : 5));
        if (z) {
            i = height;
        } else {
            i = 15;
        }
        BitArray bitArray2 = bitArray;
        EnumMap enumMap = map2;
        int i8 = 0;
        while (i8 < i) {
            int i9 = i8 + 1;
            int i10 = i9 / 2;
            if (((i8 & 1) == 0 ? i7 : i6) == 0) {
                i10 = -i10;
            }
            int i11 = (i10 * max) + i5;
            if (i11 < 0 || i11 >= height) {
                break;
            }
            try {
                bitArray2 = binaryBitmap.getBlackRow(i11, bitArray2);
                int i12 = i6;
                while (i12 < 2) {
                    if (i12 == i7) {
                        bitArray2.reverse();
                        if (enumMap != null && enumMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        Result decodeRow = decodeRow(i11, bitArray2, enumMap);
                        if (i12 == i7) {
                            try {
                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    i3 = height;
                                    float f = (float) width;
                                    try {
                                        i2 = width;
                                    } catch (ReaderException e) {
                                        i2 = width;
                                        i4 = 1;
                                        i12++;
                                        i7 = i4;
                                        height = i3;
                                        width = i2;
                                        i6 = 0;
                                    }
                                    try {
                                        resultPoints[0] = new ResultPoint((f - resultPoints[i6].getX()) - 1.0f, resultPoints[i6].getY());
                                        i4 = 1;
                                        try {
                                            resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                        } catch (ReaderException e2) {
                                        }
                                    } catch (ReaderException e3) {
                                        i4 = 1;
                                        i12++;
                                        i7 = i4;
                                        height = i3;
                                        width = i2;
                                        i6 = 0;
                                    }
                                }
                            } catch (ReaderException e4) {
                                i2 = width;
                                i3 = height;
                                i4 = 1;
                                i12++;
                                i7 = i4;
                                height = i3;
                                width = i2;
                                i6 = 0;
                            }
                        }
                        return decodeRow;
                    } catch (ReaderException e5) {
                        i2 = width;
                        i3 = height;
                        i4 = i7;
                        i12++;
                        i7 = i4;
                        height = i3;
                        width = i2;
                        i6 = 0;
                    }
                }
                continue;
            } catch (NotFoundException e6) {
            }
            i8 = i9;
            i7 = i7;
            height = height;
            width = width;
            i6 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPattern(BitArray row, int start, int[] counters) throws NotFoundException {
        int numCounters = counters.length;
        Arrays.fill(counters, 0, numCounters, 0);
        int end = row.getSize();
        if (start < end) {
            boolean isWhite = !row.get(start);
            int counterPosition = 0;
            int i = start;
            while (i < end) {
                if (!(row.get(i) ^ isWhite)) {
                    counterPosition++;
                    if (counterPosition == numCounters) {
                        break;
                    }
                    counters[counterPosition] = 1;
                    isWhite = !isWhite;
                } else {
                    counters[counterPosition] = counters[counterPosition] + 1;
                }
                i++;
            }
            if (counterPosition == numCounters) {
                return;
            }
            if (counterPosition != numCounters - 1 || i != end) {
                throw NotFoundException.getNotFoundInstance();
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPatternInReverse(BitArray row, int start, int[] counters) throws NotFoundException {
        int numTransitionsLeft = counters.length;
        boolean last = row.get(start);
        while (start > 0 && numTransitionsLeft >= 0) {
            start--;
            if (row.get(start) != last) {
                numTransitionsLeft--;
                last = !last;
            }
        }
        if (numTransitionsLeft < 0) {
            recordPattern(row, start + 1, counters);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] counters, int[] pattern, float maxIndividualVariance) {
        int numCounters = counters.length;
        int total = 0;
        int patternLength = 0;
        for (int i = 0; i < numCounters; i++) {
            total += counters[i];
            patternLength += pattern[i];
        }
        if (total < patternLength) {
            return Float.POSITIVE_INFINITY;
        }
        float unitBarWidth = ((float) total) / ((float) patternLength);
        float maxIndividualVariance2 = maxIndividualVariance * unitBarWidth;
        float totalVariance = 0.0f;
        for (int x = 0; x < numCounters; x++) {
            int counter = counters[x];
            float scaledPattern = ((float) pattern[x]) * unitBarWidth;
            float f = ((float) counter) > scaledPattern ? ((float) counter) - scaledPattern : scaledPattern - ((float) counter);
            float variance = f;
            if (f > maxIndividualVariance2) {
                return Float.POSITIVE_INFINITY;
            }
            totalVariance += variance;
        }
        return totalVariance / ((float) total);
    }
}
