package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView view, int actionId) {
        return false;
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View view, DragEvent event) {
        return false;
    }

    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        /* JADX INFO: finally extract failed */
        static boolean onDropForTextView(DragEvent event, TextView view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            int offset = view.getOffsetForPosition(event.getX(), event.getY());
            view.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) view.getText(), offset);
                ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(event.getClipData(), 3).build());
                view.endBatchEdit();
                return true;
            } catch (Throwable th) {
                view.endBatchEdit();
                throw th;
            }
        }

        static boolean onDropForView(DragEvent event, View view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(event.getClipData(), 3).build());
            return true;
        }
    }

    static Activity tryGetActivity(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
