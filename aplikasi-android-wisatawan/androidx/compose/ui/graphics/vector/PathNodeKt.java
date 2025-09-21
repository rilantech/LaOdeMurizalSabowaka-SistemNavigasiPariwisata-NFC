package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ai\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b28\b\u0004\u0010(\u001a2\u0012\u0013\u0012\u00110%¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\b¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020#0)H\b\u001a*\u0010.\u001a\u00020 *\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"ArcToKey", "", "CloseKey", "CurveToKey", "HorizontalToKey", "LineToKey", "MoveToKey", "NUM_ARC_TO_ARGS", "", "NUM_CURVE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_MOVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "QuadToKey", "ReflectiveCurveToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "RelativeCloseKey", "RelativeCurveToKey", "RelativeHorizontalToKey", "RelativeLineToKey", "RelativeMoveToKey", "RelativeQuadToKey", "RelativeReflectiveCurveToKey", "RelativeReflectiveQuadToKey", "RelativeVerticalToKey", "VerticalToKey", "pathNodesFromArgs", "", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "args", "", "count", "numArgs", "nodeFor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subArray", "start", "addPathNodes", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathNode.kt */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final void addPathNodes(char $this$addPathNodes, List<PathNode> nodes, float[] args, int count) {
        PathNode pathNode;
        PathNode pathNode2;
        PathNode pathNode3;
        PathNode pathNode4;
        PathNode pathNode5;
        PathNode pathNode6;
        PathNode pathNode7;
        PathNode pathNode8;
        PathNode pathNode9;
        PathNode pathNode10;
        PathNode pathNode11;
        PathNode pathNode12;
        PathNode pathNode13;
        PathNode pathNode14;
        PathNode pathNode15;
        PathNode pathNode16;
        PathNode pathNode17;
        PathNode pathNode18;
        char c = $this$addPathNodes;
        List<PathNode> list = nodes;
        float[] fArr = args;
        Intrinsics.checkNotNullParameter(list, "nodes");
        Intrinsics.checkNotNullParameter(fArr, "args");
        if (c == 'z' || c == 'Z') {
            list.add(PathNode.Close.INSTANCE);
        } else if (c == 'm') {
            int end$iv = count - 2;
            for (int index$iv = 0; index$iv <= end$iv; index$iv += 2) {
                float[] array = args;
                int start = index$iv;
                PathNode node$iv = new PathNode.RelativeMoveTo(array[start], array[start + 1]);
                if ((node$iv instanceof PathNode.MoveTo) && index$iv > 0) {
                    pathNode18 = new PathNode.LineTo(fArr[index$iv], fArr[index$iv + 1]);
                } else if (index$iv > 0) {
                    pathNode18 = new PathNode.RelativeLineTo(fArr[index$iv], fArr[index$iv + 1]);
                } else {
                    pathNode18 = node$iv;
                }
                list.add(pathNode18);
            }
        } else if (c == 'M') {
            int end$iv2 = count - 2;
            for (int index$iv2 = 0; index$iv2 <= end$iv2; index$iv2 += 2) {
                float[] array2 = args;
                int start2 = index$iv2;
                PathNode node$iv2 = new PathNode.MoveTo(array2[start2], array2[start2 + 1]);
                if (index$iv2 > 0) {
                    pathNode17 = new PathNode.LineTo(fArr[index$iv2], fArr[index$iv2 + 1]);
                } else if (!(node$iv2 instanceof PathNode.RelativeMoveTo) || index$iv2 <= 0) {
                    pathNode17 = node$iv2;
                } else {
                    pathNode17 = new PathNode.RelativeLineTo(fArr[index$iv2], fArr[index$iv2 + 1]);
                }
                list.add(pathNode17);
            }
        } else if (c == 'l') {
            int end$iv3 = count - 2;
            for (int index$iv3 = 0; index$iv3 <= end$iv3; index$iv3 += 2) {
                float[] array3 = args;
                int start3 = index$iv3;
                PathNode node$iv3 = new PathNode.RelativeLineTo(array3[start3], array3[start3 + 1]);
                if ((node$iv3 instanceof PathNode.MoveTo) && index$iv3 > 0) {
                    pathNode16 = new PathNode.LineTo(fArr[index$iv3], fArr[index$iv3 + 1]);
                } else if (!(node$iv3 instanceof PathNode.RelativeMoveTo) || index$iv3 <= 0) {
                    pathNode16 = node$iv3;
                } else {
                    pathNode16 = new PathNode.RelativeLineTo(fArr[index$iv3], fArr[index$iv3 + 1]);
                }
                list.add(pathNode16);
            }
        } else if (c == 'L') {
            int end$iv4 = count - 2;
            for (int index$iv4 = 0; index$iv4 <= end$iv4; index$iv4 += 2) {
                float[] array4 = args;
                int start4 = index$iv4;
                PathNode node$iv4 = new PathNode.LineTo(array4[start4], array4[start4 + 1]);
                if ((node$iv4 instanceof PathNode.MoveTo) && index$iv4 > 0) {
                    pathNode15 = new PathNode.LineTo(fArr[index$iv4], fArr[index$iv4 + 1]);
                } else if (!(node$iv4 instanceof PathNode.RelativeMoveTo) || index$iv4 <= 0) {
                    pathNode15 = node$iv4;
                } else {
                    pathNode15 = new PathNode.RelativeLineTo(fArr[index$iv4], fArr[index$iv4 + 1]);
                }
                list.add(pathNode15);
            }
        } else if (c == 'h') {
            int end$iv5 = count - 1;
            for (int index$iv5 = 0; index$iv5 <= end$iv5; index$iv5++) {
                PathNode node$iv5 = new PathNode.RelativeHorizontalTo(args[index$iv5]);
                if ((node$iv5 instanceof PathNode.MoveTo) && index$iv5 > 0) {
                    pathNode14 = new PathNode.LineTo(fArr[index$iv5], fArr[index$iv5 + 1]);
                } else if (!(node$iv5 instanceof PathNode.RelativeMoveTo) || index$iv5 <= 0) {
                    pathNode14 = node$iv5;
                } else {
                    pathNode14 = new PathNode.RelativeLineTo(fArr[index$iv5], fArr[index$iv5 + 1]);
                }
                list.add(pathNode14);
            }
        } else if (c == 'H') {
            int end$iv6 = count - 1;
            for (int index$iv6 = 0; index$iv6 <= end$iv6; index$iv6++) {
                PathNode node$iv6 = new PathNode.HorizontalTo(args[index$iv6]);
                if ((node$iv6 instanceof PathNode.MoveTo) && index$iv6 > 0) {
                    pathNode13 = new PathNode.LineTo(fArr[index$iv6], fArr[index$iv6 + 1]);
                } else if (!(node$iv6 instanceof PathNode.RelativeMoveTo) || index$iv6 <= 0) {
                    pathNode13 = node$iv6;
                } else {
                    pathNode13 = new PathNode.RelativeLineTo(fArr[index$iv6], fArr[index$iv6 + 1]);
                }
                list.add(pathNode13);
            }
        } else if (c == 'v') {
            int end$iv7 = count - 1;
            for (int index$iv7 = 0; index$iv7 <= end$iv7; index$iv7++) {
                PathNode node$iv7 = new PathNode.RelativeVerticalTo(args[index$iv7]);
                if ((node$iv7 instanceof PathNode.MoveTo) && index$iv7 > 0) {
                    pathNode12 = new PathNode.LineTo(fArr[index$iv7], fArr[index$iv7 + 1]);
                } else if (!(node$iv7 instanceof PathNode.RelativeMoveTo) || index$iv7 <= 0) {
                    pathNode12 = node$iv7;
                } else {
                    pathNode12 = new PathNode.RelativeLineTo(fArr[index$iv7], fArr[index$iv7 + 1]);
                }
                list.add(pathNode12);
            }
        } else if (c == 'V') {
            int end$iv8 = count - 1;
            for (int index$iv8 = 0; index$iv8 <= end$iv8; index$iv8++) {
                PathNode node$iv8 = new PathNode.VerticalTo(args[index$iv8]);
                if ((node$iv8 instanceof PathNode.MoveTo) && index$iv8 > 0) {
                    pathNode11 = new PathNode.LineTo(fArr[index$iv8], fArr[index$iv8 + 1]);
                } else if (!(node$iv8 instanceof PathNode.RelativeMoveTo) || index$iv8 <= 0) {
                    pathNode11 = node$iv8;
                } else {
                    pathNode11 = new PathNode.RelativeLineTo(fArr[index$iv8], fArr[index$iv8 + 1]);
                }
                list.add(pathNode11);
            }
        } else if (c == 'c') {
            int end$iv9 = count - 6;
            for (int index$iv9 = 0; index$iv9 <= end$iv9; index$iv9 += 6) {
                float[] array5 = args;
                int start5 = index$iv9;
                PathNode node$iv9 = new PathNode.RelativeCurveTo(array5[start5], array5[start5 + 1], array5[start5 + 2], array5[start5 + 3], array5[start5 + 4], array5[start5 + 5]);
                if ((node$iv9 instanceof PathNode.MoveTo) && index$iv9 > 0) {
                    pathNode10 = new PathNode.LineTo(fArr[index$iv9], fArr[index$iv9 + 1]);
                } else if (!(node$iv9 instanceof PathNode.RelativeMoveTo) || index$iv9 <= 0) {
                    pathNode10 = node$iv9;
                } else {
                    pathNode10 = new PathNode.RelativeLineTo(fArr[index$iv9], fArr[index$iv9 + 1]);
                }
                list.add(pathNode10);
            }
        } else if (c == 'C') {
            int end$iv10 = count - 6;
            for (int index$iv10 = 0; index$iv10 <= end$iv10; index$iv10 += 6) {
                float[] array6 = args;
                int start6 = index$iv10;
                PathNode node$iv10 = new PathNode.CurveTo(array6[start6], array6[start6 + 1], array6[start6 + 2], array6[start6 + 3], array6[start6 + 4], array6[start6 + 5]);
                if ((node$iv10 instanceof PathNode.MoveTo) && index$iv10 > 0) {
                    pathNode9 = new PathNode.LineTo(fArr[index$iv10], fArr[index$iv10 + 1]);
                } else if (!(node$iv10 instanceof PathNode.RelativeMoveTo) || index$iv10 <= 0) {
                    pathNode9 = node$iv10;
                } else {
                    pathNode9 = new PathNode.RelativeLineTo(fArr[index$iv10], fArr[index$iv10 + 1]);
                }
                list.add(pathNode9);
            }
        } else if (c == 's') {
            int end$iv11 = count - 4;
            for (int index$iv11 = 0; index$iv11 <= end$iv11; index$iv11 += 4) {
                float[] array7 = args;
                int start7 = index$iv11;
                PathNode node$iv11 = new PathNode.RelativeReflectiveCurveTo(array7[start7], array7[start7 + 1], array7[start7 + 2], array7[start7 + 3]);
                if ((node$iv11 instanceof PathNode.MoveTo) && index$iv11 > 0) {
                    pathNode8 = new PathNode.LineTo(fArr[index$iv11], fArr[index$iv11 + 1]);
                } else if (!(node$iv11 instanceof PathNode.RelativeMoveTo) || index$iv11 <= 0) {
                    pathNode8 = node$iv11;
                } else {
                    pathNode8 = new PathNode.RelativeLineTo(fArr[index$iv11], fArr[index$iv11 + 1]);
                }
                list.add(pathNode8);
            }
        } else if (c == 'S') {
            int end$iv12 = count - 4;
            for (int index$iv12 = 0; index$iv12 <= end$iv12; index$iv12 += 4) {
                float[] array8 = args;
                int start8 = index$iv12;
                PathNode node$iv12 = new PathNode.ReflectiveCurveTo(array8[start8], array8[start8 + 1], array8[start8 + 2], array8[start8 + 3]);
                if ((node$iv12 instanceof PathNode.MoveTo) && index$iv12 > 0) {
                    pathNode7 = new PathNode.LineTo(fArr[index$iv12], fArr[index$iv12 + 1]);
                } else if (!(node$iv12 instanceof PathNode.RelativeMoveTo) || index$iv12 <= 0) {
                    pathNode7 = node$iv12;
                } else {
                    pathNode7 = new PathNode.RelativeLineTo(fArr[index$iv12], fArr[index$iv12 + 1]);
                }
                list.add(pathNode7);
            }
        } else if (c == 'q') {
            int end$iv13 = count - 4;
            for (int index$iv13 = 0; index$iv13 <= end$iv13; index$iv13 += 4) {
                float[] array9 = args;
                int start9 = index$iv13;
                PathNode node$iv13 = new PathNode.RelativeQuadTo(array9[start9], array9[start9 + 1], array9[start9 + 2], array9[start9 + 3]);
                if ((node$iv13 instanceof PathNode.MoveTo) && index$iv13 > 0) {
                    pathNode6 = new PathNode.LineTo(fArr[index$iv13], fArr[index$iv13 + 1]);
                } else if (!(node$iv13 instanceof PathNode.RelativeMoveTo) || index$iv13 <= 0) {
                    pathNode6 = node$iv13;
                } else {
                    pathNode6 = new PathNode.RelativeLineTo(fArr[index$iv13], fArr[index$iv13 + 1]);
                }
                list.add(pathNode6);
            }
        } else if (c == 'Q') {
            int end$iv14 = count - 4;
            for (int index$iv14 = 0; index$iv14 <= end$iv14; index$iv14 += 4) {
                float[] array10 = args;
                int start10 = index$iv14;
                PathNode node$iv14 = new PathNode.QuadTo(array10[start10], array10[start10 + 1], array10[start10 + 2], array10[start10 + 3]);
                if ((node$iv14 instanceof PathNode.MoveTo) && index$iv14 > 0) {
                    pathNode5 = new PathNode.LineTo(fArr[index$iv14], fArr[index$iv14 + 1]);
                } else if (!(node$iv14 instanceof PathNode.RelativeMoveTo) || index$iv14 <= 0) {
                    pathNode5 = node$iv14;
                } else {
                    pathNode5 = new PathNode.RelativeLineTo(fArr[index$iv14], fArr[index$iv14 + 1]);
                }
                list.add(pathNode5);
            }
        } else if (c == 't') {
            int end$iv15 = count - 2;
            for (int index$iv15 = 0; index$iv15 <= end$iv15; index$iv15 += 2) {
                float[] array11 = args;
                int start11 = index$iv15;
                PathNode node$iv15 = new PathNode.RelativeReflectiveQuadTo(array11[start11], array11[start11 + 1]);
                if ((node$iv15 instanceof PathNode.MoveTo) && index$iv15 > 0) {
                    pathNode4 = new PathNode.LineTo(fArr[index$iv15], fArr[index$iv15 + 1]);
                } else if (!(node$iv15 instanceof PathNode.RelativeMoveTo) || index$iv15 <= 0) {
                    pathNode4 = node$iv15;
                } else {
                    pathNode4 = new PathNode.RelativeLineTo(fArr[index$iv15], fArr[index$iv15 + 1]);
                }
                list.add(pathNode4);
            }
        } else if (c == 'T') {
            int end$iv16 = count - 2;
            for (int index$iv16 = 0; index$iv16 <= end$iv16; index$iv16 += 2) {
                float[] array12 = args;
                int start12 = index$iv16;
                PathNode node$iv16 = new PathNode.ReflectiveQuadTo(array12[start12], array12[start12 + 1]);
                if ((node$iv16 instanceof PathNode.MoveTo) && index$iv16 > 0) {
                    pathNode3 = new PathNode.LineTo(fArr[index$iv16], fArr[index$iv16 + 1]);
                } else if (!(node$iv16 instanceof PathNode.RelativeMoveTo) || index$iv16 <= 0) {
                    pathNode3 = node$iv16;
                } else {
                    pathNode3 = new PathNode.RelativeLineTo(fArr[index$iv16], fArr[index$iv16 + 1]);
                }
                list.add(pathNode3);
            }
        } else if (c == 'a') {
            int end$iv17 = count - 7;
            for (int index$iv17 = 0; index$iv17 <= end$iv17; index$iv17 += 7) {
                float[] array13 = args;
                int start13 = index$iv17;
                PathNode node$iv17 = new PathNode.RelativeArcTo(array13[start13], array13[start13 + 1], array13[start13 + 2], Float.compare(array13[start13 + 3], 0.0f) != 0, Float.compare(array13[start13 + 4], 0.0f) != 0, array13[start13 + 5], array13[start13 + 6]);
                if ((node$iv17 instanceof PathNode.MoveTo) && index$iv17 > 0) {
                    pathNode2 = new PathNode.LineTo(fArr[index$iv17], fArr[index$iv17 + 1]);
                } else if (!(node$iv17 instanceof PathNode.RelativeMoveTo) || index$iv17 <= 0) {
                    pathNode2 = node$iv17;
                } else {
                    pathNode2 = new PathNode.RelativeLineTo(fArr[index$iv17], fArr[index$iv17 + 1]);
                }
                list.add(pathNode2);
            }
        } else if (c == 'A') {
            int end$iv18 = count - 7;
            for (int index$iv18 = 0; index$iv18 <= end$iv18; index$iv18 += 7) {
                float[] array14 = args;
                int start14 = index$iv18;
                PathNode node$iv18 = new PathNode.ArcTo(array14[start14], array14[start14 + 1], array14[start14 + 2], Float.compare(array14[start14 + 3], 0.0f) != 0, Float.compare(array14[start14 + 4], 0.0f) != 0, array14[start14 + 5], array14[start14 + 6]);
                if ((node$iv18 instanceof PathNode.MoveTo) && index$iv18 > 0) {
                    pathNode = new PathNode.LineTo(fArr[index$iv18], fArr[index$iv18 + 1]);
                } else if (!(node$iv18 instanceof PathNode.RelativeMoveTo) || index$iv18 <= 0) {
                    pathNode = node$iv18;
                } else {
                    pathNode = new PathNode.RelativeLineTo(fArr[index$iv18], fArr[index$iv18 + 1]);
                }
                list.add(pathNode);
            }
        } else {
            throw new IllegalArgumentException("Unknown command for: " + c);
        }
    }

    private static final void pathNodesFromArgs(List<PathNode> nodes, float[] args, int count, int numArgs, Function2<? super float[], ? super Integer, ? extends PathNode> nodeFor) {
        PathNode pathNode;
        int end = count - numArgs;
        int index = 0;
        while (index <= end) {
            PathNode node = (PathNode) nodeFor.invoke(args, Integer.valueOf(index));
            if ((node instanceof PathNode.MoveTo) && index > 0) {
                pathNode = new PathNode.LineTo(args[index], args[index + 1]);
            } else if (!(node instanceof PathNode.RelativeMoveTo) || index <= 0) {
                pathNode = node;
            } else {
                pathNode = new PathNode.RelativeLineTo(args[index], args[index + 1]);
            }
            nodes.add(pathNode);
            index += numArgs;
        }
    }
}
