package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;

public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] contentMimeTypes) {
        editorInfo.contentMimeTypes = contentMimeTypes;
    }

    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        String[] result = editorInfo.contentMimeTypes;
        return result != null ? result : EMPTY_STRING_ARRAY;
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence sourceText) {
        Api30Impl.setInitialSurroundingSubText(editorInfo, sourceText, 0);
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence subText, int subTextStart) {
        Preconditions.checkNotNull(subText);
        Api30Impl.setInitialSurroundingSubText(editorInfo, subText, subTextStart);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence subText, int selStart, int selEnd) {
        CharSequence newInitialSurroundingText;
        CharSequence charSequence = subText;
        int i = selStart;
        int i2 = selEnd;
        int sourceSelLength = i2 - i;
        int newSelLength = sourceSelLength > 1024 ? 0 : sourceSelLength;
        int maxLengthMinusSelection = 2048 - newSelLength;
        int newAfterCursorLength = Math.min(subText.length() - i2, maxLengthMinusSelection - Math.min(i, (int) (((double) maxLengthMinusSelection) * 0.8d)));
        int newBeforeCursorLength = Math.min(i, maxLengthMinusSelection - newAfterCursorLength);
        int newBeforeCursorHead = i - newBeforeCursorLength;
        if (isCutOnSurrogate(charSequence, i - newBeforeCursorLength, 0)) {
            newBeforeCursorHead++;
            newBeforeCursorLength--;
        }
        if (isCutOnSurrogate(charSequence, (i2 + newAfterCursorLength) - 1, 1)) {
            newAfterCursorLength--;
        }
        int newTextLength = newBeforeCursorLength + newSelLength + newAfterCursorLength;
        if (newSelLength != sourceSelLength) {
            newInitialSurroundingText = TextUtils.concat(new CharSequence[]{charSequence.subSequence(newBeforeCursorHead, newBeforeCursorHead + newBeforeCursorLength), charSequence.subSequence(i2, i2 + newAfterCursorLength)});
        } else {
            newInitialSurroundingText = charSequence.subSequence(newBeforeCursorHead, newBeforeCursorHead + newTextLength);
        }
        int newSelHead = 0 + newBeforeCursorLength;
        setSurroundingText(editorInfo, newInitialSurroundingText, newSelHead, newSelHead + newSelLength);
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int length, int flags) {
        return Api30Impl.getInitialTextBeforeCursor(editorInfo, length, flags);
    }

    public static CharSequence getInitialSelectedText(EditorInfo editorInfo, int flags) {
        return Api30Impl.getInitialSelectedText(editorInfo, flags);
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int length, int flags) {
        return Api30Impl.getInitialTextAfterCursor(editorInfo, length, flags);
    }

    private static boolean isCutOnSurrogate(CharSequence sourceText, int cutPosition, int policy) {
        switch (policy) {
            case 0:
                return Character.isLowSurrogate(sourceText.charAt(cutPosition));
            case 1:
                return Character.isHighSurrogate(sourceText.charAt(cutPosition));
            default:
                return false;
        }
    }

    private static boolean isPasswordInputType(int inputType) {
        int variation = inputType & 4095;
        return variation == 129 || variation == 225 || variation == 18;
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence surroundingText, int selectionHead, int selectionEnd) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, surroundingText != null ? new SpannableStringBuilder(surroundingText) : null);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, selectionHead);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, selectionEnd);
    }

    static int getProtocol(EditorInfo editorInfo) {
        return 1;
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence sourceText, int subTextStart) {
            editorInfo.setInitialSurroundingSubText(sourceText, subTextStart);
        }

        static CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int length, int flags) {
            return editorInfo.getInitialTextBeforeCursor(length, flags);
        }

        static CharSequence getInitialSelectedText(EditorInfo editorInfo, int flags) {
            return editorInfo.getInitialSelectedText(flags);
        }

        static CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int length, int flags) {
            return editorInfo.getInitialTextAfterCursor(length, flags);
        }
    }
}
