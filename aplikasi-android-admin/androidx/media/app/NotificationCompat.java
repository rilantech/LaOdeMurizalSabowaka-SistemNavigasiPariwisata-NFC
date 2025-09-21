package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

public class NotificationCompat {
    private NotificationCompat() {
    }

    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Object tokenInner;
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null || (tokenInner = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) == null) {
                return null;
            }
            return MediaSessionCompat.Token.fromToken(tokenInner);
        }

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setShowActionsInCompactView(int... actions) {
            this.mActionsToShowInCompact = actions;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean show) {
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            builder.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
        }

        /* access modifiers changed from: package-private */
        public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle style) {
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr != null) {
                style.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.mToken;
            if (token != null) {
                style.setMediaSession((MediaSession.Token) token.getToken());
            }
            return style;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public RemoteViews generateContentView() {
            int numActionsInCompact;
            RemoteViews view = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int numActions = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr == null) {
                numActionsInCompact = 0;
            } else {
                numActionsInCompact = Math.min(iArr.length, 3);
            }
            view.removeAllViews(R.id.media_actions);
            if (numActionsInCompact > 0) {
                int i = 0;
                while (i < numActionsInCompact) {
                    if (i < numActions) {
                        view.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
                        i++;
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(numActions - 1)}));
                    }
                }
            }
            if (this.mShowCancelButton != 0) {
                view.setViewVisibility(R.id.end_padder, 8);
                view.setViewVisibility(R.id.cancel_action, 0);
                view.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
                view.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                view.setViewVisibility(R.id.end_padder, 0);
                view.setViewVisibility(R.id.cancel_action, 8);
            }
            return view;
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean tombstone = action.getActionIntent() == null;
            RemoteViews button = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            button.setImageViewResource(R.id.action0, action.getIcon());
            if (!tombstone) {
                button.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
            }
            button.setContentDescription(R.id.action0, action.getTitle());
            return button;
        }

        /* access modifiers changed from: package-private */
        public int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public RemoteViews generateBigContentView() {
            int actionCount = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews big = applyStandardTemplate(false, getBigContentViewLayoutResource(actionCount), false);
            big.removeAllViews(R.id.media_actions);
            if (actionCount > 0) {
                for (int i = 0; i < actionCount; i++) {
                    big.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i)));
                }
            }
            if (this.mShowCancelButton != 0) {
                big.setViewVisibility(R.id.cancel_action, 0);
                big.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
                big.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
            } else {
                big.setViewVisibility(R.id.cancel_action, 8);
            }
            return big;
        }

        /* access modifiers changed from: package-private */
        public int getBigContentViewLayoutResource(int actionCount) {
            return actionCount <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            builder.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() != null) {
                return R.layout.notification_template_media_custom;
            }
            return super.getContentViewLayoutResource();
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getBigContentViewLayoutResource(int actionCount) {
            return actionCount <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        private void setBackgroundColor(RemoteViews views) {
            int color;
            if (this.mBuilder.getColor() != 0) {
                color = this.mBuilder.getColor();
            } else {
                color = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            }
            views.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", color);
        }
    }
}
