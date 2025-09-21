package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0015\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a]\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0000\u001a]\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0014\u001aU\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00122\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"applyDiff", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "callback", "Landroidx/compose/ui/node/DiffCallback;", "backward", "", "oldStart", "", "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", "", "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "oldSize", "newSize", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MyersDiff.kt */
public final class MyersDiffKt {
    private static final IntStack calculateDiff(int oldSize, int newSize, DiffCallback cb) {
        int[] snake;
        int i = oldSize;
        int i2 = newSize;
        int oldEnd = ((i + i2) + 1) / 2;
        IntStack diagonals = new IntStack(oldEnd * 3);
        IntStack stack = new IntStack(oldEnd * 4);
        stack.pushRange(0, i, 0, i2);
        int[] forward = CenteredArray.m4779constructorimpl(new int[((oldEnd * 2) + 1)]);
        int[] backward = CenteredArray.m4779constructorimpl(new int[((oldEnd * 2) + 1)]);
        int[] snake2 = Snake.m5019constructorimpl(new int[5]);
        while (stack.isNotEmpty()) {
            int newEnd = stack.pop();
            int newStart = stack.pop();
            int oldEnd2 = stack.pop();
            int oldStart = stack.pop();
            int oldStart2 = oldStart;
            int max = oldEnd;
            int oldEnd3 = oldEnd2;
            int newStart2 = newStart;
            int[] iArr = forward;
            int[] forward2 = forward;
            int newEnd2 = newEnd;
            int[] snake3 = snake2;
            if (m4904midPointq5eDKzI(oldStart, oldEnd2, newStart, newEnd, cb, iArr, backward, snake2)) {
                if (Snake.m5022getDiagonalSizeimpl(snake3) > 0) {
                    snake = snake3;
                    Snake.m5017addDiagonalToStackimpl(snake, diagonals);
                } else {
                    snake = snake3;
                }
                stack.pushRange(oldStart2, Snake.m5027getStartXimpl(snake), newStart2, Snake.m5028getStartYimpl(snake));
                stack.pushRange(Snake.m5023getEndXimpl(snake), oldEnd3, Snake.m5024getEndYimpl(snake), newEnd2);
                int newStart3 = oldSize;
                snake2 = snake;
                oldEnd = max;
                forward = forward2;
            } else {
                int newStart4 = oldSize;
                snake2 = snake3;
                oldEnd = max;
                forward = forward2;
            }
        }
        int max2 = oldEnd;
        diagonals.sortDiagonals();
        diagonals.pushDiagonal(oldSize, i2, 0);
        return diagonals;
    }

    private static final void applyDiff(IntStack diagonals, DiffCallback callback) {
        int posX = 0;
        int posY = 0;
        int i = 0;
        while (i < diagonals.getSize()) {
            int startX = diagonals.get(i) - diagonals.get(i + 2);
            int startY = diagonals.get(i + 1) - diagonals.get(i + 2);
            int len = diagonals.get(i + 2);
            i += 3;
            while (posX < startX) {
                callback.remove(posY, posX);
                posX++;
            }
            while (posY < startY) {
                callback.insert(posY);
                posY++;
            }
            while (true) {
                int len2 = len - 1;
                if (len > 0) {
                    callback.same(posX, posY);
                    posX++;
                    posY++;
                    len = len2;
                }
            }
        }
    }

    public static final void executeDiff(int oldSize, int newSize, DiffCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        applyDiff(calculateDiff(oldSize, newSize, callback), callback);
    }

    /* renamed from: midPoint-q5eDKzI  reason: not valid java name */
    private static final boolean m4904midPointq5eDKzI(int oldStart, int oldEnd, int newStart, int newEnd, DiffCallback cb, int[] forward, int[] backward, int[] snake) {
        int i = oldStart;
        int i2 = oldEnd;
        int oldSize = i2 - i;
        int newSize = newEnd - newStart;
        if (oldSize < 1 || newSize < 1) {
            return false;
        }
        int max = ((oldSize + newSize) + 1) / 2;
        CenteredArray.m4785setimpl(forward, 1, i);
        CenteredArray.m4785setimpl(backward, 1, i2);
        int d = 0;
        while (d < max) {
            int d2 = d;
            if (m4903forward4l5_RBY(oldStart, oldEnd, newStart, newEnd, cb, forward, backward, d2, snake) || m4902backward4l5_RBY(oldStart, oldEnd, newStart, newEnd, cb, forward, backward, d2, snake)) {
                return true;
            }
            d = d2 + 1;
            int[] iArr = forward;
            int[] iArr2 = backward;
        }
        return false;
    }

    /* renamed from: forward-4l5_RBY  reason: not valid java name */
    private static final boolean m4903forward4l5_RBY(int oldStart, int oldEnd, int newStart, int newEnd, DiffCallback cb, int[] forward, int[] backward, int d, int[] snake) {
        int x;
        int startX;
        int i = oldEnd;
        int i2 = newEnd;
        int[] iArr = forward;
        int i3 = d;
        int oldSize = i - oldStart;
        int newSize = i2 - newStart;
        int i4 = 1;
        boolean checkForSnake = Math.abs(oldSize - newSize) % 2 == 1;
        int delta = oldSize - newSize;
        int k = -i3;
        while (k <= i3) {
            if (k == (-i3) || (k != i3 && CenteredArray.m4782getimpl(iArr, k + 1) > CenteredArray.m4782getimpl(iArr, k - 1))) {
                startX = CenteredArray.m4782getimpl(iArr, k + 1);
                x = startX;
            } else {
                startX = CenteredArray.m4782getimpl(iArr, k - 1);
                x = startX + 1;
            }
            int y = (newStart + (x - oldStart)) - k;
            int startY = (i3 == 0 || x != startX) ? y : y - 1;
            int y2 = y;
            while (true) {
                if (x < i && y2 < i2) {
                    if (!cb.areItemsTheSame(x, y2)) {
                        break;
                    }
                    x++;
                    y2++;
                } else {
                    DiffCallback diffCallback = cb;
                }
            }
            CenteredArray.m4785setimpl(iArr, k, x);
            if (checkForSnake) {
                int backwardsK = delta - k;
                if (backwardsK < (-i3) + i4 || backwardsK > i3 - 1) {
                    int[] iArr2 = backward;
                } else if (CenteredArray.m4782getimpl(backward, backwardsK) <= x) {
                    fillSnake(startX, startY, x, y2, false, snake);
                    return true;
                } else {
                    i4 = 1;
                }
            } else {
                int[] iArr3 = backward;
            }
            k += 2;
            i = oldEnd;
        }
        int[] iArr4 = backward;
        return false;
    }

    /* renamed from: backward-4l5_RBY  reason: not valid java name */
    private static final boolean m4902backward4l5_RBY(int oldStart, int oldEnd, int newStart, int newEnd, DiffCallback cb, int[] forward, int[] backward, int d, int[] snake) {
        int x;
        int startX;
        int i = oldStart;
        int i2 = newStart;
        int[] iArr = backward;
        int i3 = d;
        int oldSize = oldEnd - i;
        int newSize = newEnd - i2;
        boolean checkForSnake = (oldSize - newSize) % 2 == 0;
        int delta = oldSize - newSize;
        for (int k = -i3; k <= i3; k += 2) {
            if (k == (-i3) || (k != i3 && CenteredArray.m4782getimpl(iArr, k + 1) < CenteredArray.m4782getimpl(iArr, k - 1))) {
                startX = CenteredArray.m4782getimpl(iArr, k + 1);
                x = startX;
            } else {
                startX = CenteredArray.m4782getimpl(iArr, k - 1);
                x = startX - 1;
            }
            int y = newEnd - ((oldEnd - x) - k);
            int startY = (i3 == 0 || x != startX) ? y : y + 1;
            int y2 = y;
            while (true) {
                if (x > i && y2 > i2) {
                    if (!cb.areItemsTheSame(x - 1, y2 - 1)) {
                        break;
                    }
                    x--;
                    y2--;
                } else {
                    DiffCallback diffCallback = cb;
                }
            }
            DiffCallback diffCallback2 = cb;
            CenteredArray.m4785setimpl(iArr, k, x);
            if (checkForSnake) {
                int forwardsK = delta - k;
                if (forwardsK < (-i3) || forwardsK > i3 || CenteredArray.m4782getimpl(forward, forwardsK) < x) {
                } else {
                    int i4 = forwardsK;
                    int i5 = y2;
                    fillSnake(x, y2, startX, startY, true, snake);
                    return true;
                }
            }
        }
        DiffCallback diffCallback3 = cb;
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v0, types: [int[], java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fillSnake(int r1, int r2, int r3, int r4, boolean r5, int[] r6) {
        /*
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r6[r0] = r1
            r0 = 1
            r6[r0] = r2
            r0 = 2
            r6[r0] = r3
            r0 = 3
            r6[r0] = r4
            r0 = 4
            r6[r0] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MyersDiffKt.fillSnake(int, int, int, int, boolean, int[]):void");
    }

    /* access modifiers changed from: private */
    public static final void swap(int[] $this$swap, int i, int j) {
        int tmp = $this$swap[i];
        $this$swap[i] = $this$swap[j];
        $this$swap[j] = tmp;
    }
}
