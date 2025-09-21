package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras = new Bundle();
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    NotificationCompatBuilder(NotificationCompat.Builder b) {
        this.mBuilderCompat = b;
        Context context = b.mContext;
        this.mContext = context;
        Notification.Builder createBuilder = Api26Impl.createBuilder(b.mContext, b.mChannelId);
        this.mBuilder = createBuilder;
        Notification n = b.mNotification;
        createBuilder.setWhen(n.when).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, b.mTickerView).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS).setOngoing((n.flags & 2) != 0).setOnlyAlertOnce((n.flags & 8) != 0).setAutoCancel((n.flags & 16) != 0).setDefaults(n.defaults).setContentTitle(b.mContentTitle).setContentText(b.mContentText).setContentInfo(b.mContentInfo).setContentIntent(b.mContentIntent).setDeleteIntent(n.deleteIntent).setFullScreenIntent(b.mFullScreenIntent, (n.flags & 128) != 0).setNumber(b.mNumber).setProgress(b.mProgressMax, b.mProgress, b.mProgressIndeterminate);
        Api23Impl.setLargeIcon(createBuilder, b.mLargeIcon == null ? null : b.mLargeIcon.toIcon(context));
        Api16Impl.setPriority(Api16Impl.setUsesChronometer(Api16Impl.setSubText(createBuilder, b.mSubText), b.mUseChronometer), b.mPriority);
        if (b.mStyle instanceof NotificationCompat.CallStyle) {
            for (NotificationCompat.Action action : ((NotificationCompat.CallStyle) b.mStyle).getActionsListWithSystemActions()) {
                addAction(action);
            }
        } else {
            Iterator<NotificationCompat.Action> it = b.mActions.iterator();
            while (it.hasNext()) {
                addAction(it.next());
            }
        }
        if (b.mExtras != null) {
            this.mExtras.putAll(b.mExtras);
        }
        this.mContentView = b.mContentView;
        this.mBigContentView = b.mBigContentView;
        Api17Impl.setShowWhen(this.mBuilder, b.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, b.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, b.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, b.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, b.mGroupSummary);
        this.mGroupAlertBehavior = b.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, b.mCategory);
        Api21Impl.setColor(this.mBuilder, b.mColor);
        Api21Impl.setVisibility(this.mBuilder, b.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, b.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, n.sound, n.audioAttributes);
        List<String> people = b.mPeople;
        if (people != null && !people.isEmpty()) {
            for (String person : people) {
                Api21Impl.addPerson(this.mBuilder, person);
            }
        }
        this.mHeadsUpContentView = b.mHeadsUpContentView;
        if (b.mInvisibleActions.size() > 0) {
            Bundle carExtenderBundle = b.getExtras().getBundle("android.car.EXTENSIONS");
            carExtenderBundle = carExtenderBundle == null ? new Bundle() : carExtenderBundle;
            Bundle extenderBundleCopy = new Bundle(carExtenderBundle);
            Bundle listBundle = new Bundle();
            for (int i = 0; i < b.mInvisibleActions.size(); i++) {
                listBundle.putBundle(Integer.toString(i), NotificationCompatJellybean.getBundleForAction(b.mInvisibleActions.get(i)));
            }
            carExtenderBundle.putBundle("invisible_actions", listBundle);
            extenderBundleCopy.putBundle("invisible_actions", listBundle);
            b.getExtras().putBundle("android.car.EXTENSIONS", carExtenderBundle);
            this.mExtras.putBundle("android.car.EXTENSIONS", extenderBundleCopy);
        }
        if (b.mSmallIcon != null) {
            Api23Impl.setSmallIcon(this.mBuilder, b.mSmallIcon);
        }
        Api19Impl.setExtras(this.mBuilder, b.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, b.mRemoteInputHistory);
        if (b.mContentView != null) {
            Api24Impl.setCustomContentView(this.mBuilder, b.mContentView);
        }
        if (b.mBigContentView != null) {
            Api24Impl.setCustomBigContentView(this.mBuilder, b.mBigContentView);
        }
        if (b.mHeadsUpContentView != null) {
            Api24Impl.setCustomHeadsUpContentView(this.mBuilder, b.mHeadsUpContentView);
        }
        Api26Impl.setBadgeIconType(this.mBuilder, b.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, b.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, b.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, b.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, b.mGroupAlertBehavior);
        if (b.mColorizedSet) {
            Api26Impl.setColorized(this.mBuilder, b.mColorized);
        }
        if (!TextUtils.isEmpty(b.mChannelId)) {
            this.mBuilder.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
        }
        Iterator<Person> it2 = b.mPersonList.iterator();
        while (it2.hasNext()) {
            Api28Impl.addPerson(this.mBuilder, it2.next().toAndroidPerson());
        }
        Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, b.mAllowSystemGeneratedContextualActions);
        Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(b.mBubbleMetadata));
        if (b.mLocusId != null) {
            Api29Impl.setLocusId(this.mBuilder, b.mLocusId.toLocusId());
        }
        if (b.mFgsDeferBehavior != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, b.mFgsDeferBehavior);
        }
        if (b.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate((long[]) null);
            this.mBuilder.setSound((Uri) null);
            n.defaults &= -2;
            n.defaults &= -3;
            this.mBuilder.setDefaults(n.defaults);
            if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
            }
            Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        }
    }

    private static List<String> combineLists(List<String> first, List<String> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ArraySet<String> people = new ArraySet<>(first.size() + second.size());
        people.addAll((Collection<? extends String>) first);
        people.addAll((Collection<? extends String>) second);
        return new ArrayList(people);
    }

    private static List<String> getPeople(List<Person> people) {
        if (people == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>(people.size());
        for (Person person : people) {
            result.add(person.resolveToLegacyUri());
        }
        return result;
    }

    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    public Notification build() {
        RemoteViews styleContentView;
        Bundle extras;
        RemoteViews styleHeadsUpContentView;
        RemoteViews styleBigContentView;
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        if (style != null) {
            styleContentView = style.makeContentView(this);
        } else {
            styleContentView = null;
        }
        Notification n = buildInternal();
        if (styleContentView != null) {
            n.contentView = styleContentView;
        } else if (this.mBuilderCompat.mContentView != null) {
            n.contentView = this.mBuilderCompat.mContentView;
        }
        if (!(style == null || (styleBigContentView = style.makeBigContentView(this)) == null)) {
            n.bigContentView = styleBigContentView;
        }
        if (!(style == null || (styleHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) == null)) {
            n.headsUpContentView = styleHeadsUpContentView;
        }
        if (!(style == null || (extras = NotificationCompat.getExtras(n)) == null)) {
            style.addCompatExtras(extras);
        }
        return n;
    }

    private void addAction(NotificationCompat.Action action) {
        Bundle actionExtras;
        IconCompat iconCompat = action.getIconCompat();
        Notification.Action.Builder actionBuilder = Api23Impl.createBuilder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (RemoteInput remoteInput : RemoteInput.fromCompat(action.getRemoteInputs())) {
                Api20Impl.addRemoteInput(actionBuilder, remoteInput);
            }
        }
        if (action.getExtras() != null) {
            actionExtras = new Bundle(action.getExtras());
        } else {
            actionExtras = new Bundle();
        }
        actionExtras.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        Api24Impl.setAllowGeneratedReplies(actionBuilder, action.getAllowGeneratedReplies());
        actionExtras.putInt("android.support.action.semanticAction", action.getSemanticAction());
        Api28Impl.setSemanticAction(actionBuilder, action.getSemanticAction());
        Api29Impl.setContextual(actionBuilder, action.isContextual());
        Api31Impl.setAuthenticationRequired(actionBuilder, action.isAuthenticationRequired());
        actionExtras.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        Api20Impl.addExtras(actionBuilder, actionExtras);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(actionBuilder));
    }

    /* access modifiers changed from: protected */
    public Notification buildInternal() {
        return Api16Impl.build(this.mBuilder);
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static Notification.Builder setSubText(Notification.Builder builder, CharSequence text) {
            return builder.setSubText(text);
        }

        static Notification.Builder setUsesChronometer(Notification.Builder builder, boolean b) {
            return builder.setUsesChronometer(b);
        }

        static Notification.Builder setPriority(Notification.Builder builder, int pri) {
            return builder.setPriority(pri);
        }

        static Notification build(Notification.Builder builder) {
            return builder.build();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Notification.Builder setShowWhen(Notification.Builder builder, boolean show) {
            return builder.setShowWhen(show);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static Notification.Builder setExtras(Notification.Builder builder, Bundle extras) {
            return builder.setExtras(extras);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Notification.Action.Builder createBuilder(int icon, CharSequence title, PendingIntent intent) {
            return new Notification.Action.Builder(icon, title, intent);
        }

        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle extras) {
            return builder.addExtras(extras);
        }

        static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder setGroup(Notification.Builder builder, String groupKey) {
            return builder.setGroup(groupKey);
        }

        static Notification.Builder setGroupSummary(Notification.Builder builder, boolean isGroupSummary) {
            return builder.setGroupSummary(isGroupSummary);
        }

        static Notification.Builder setLocalOnly(Notification.Builder builder, boolean localOnly) {
            return builder.setLocalOnly(localOnly);
        }

        static Notification.Builder setSortKey(Notification.Builder builder, String sortKey) {
            return builder.setSortKey(sortKey);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Notification.Builder addPerson(Notification.Builder builder, String uri) {
            return builder.addPerson(uri);
        }

        static Notification.Builder setCategory(Notification.Builder builder, String category) {
            return builder.setCategory(category);
        }

        static Notification.Builder setColor(Notification.Builder builder, int argb) {
            return builder.setColor(argb);
        }

        static Notification.Builder setVisibility(Notification.Builder builder, int visibility) {
            return builder.setVisibility(visibility);
        }

        static Notification.Builder setPublicVersion(Notification.Builder builder, Notification n) {
            return builder.setPublicVersion(n);
        }

        static Notification.Builder setSound(Notification.Builder builder, Uri sound, Object audioAttributes) {
            return builder.setSound(sound, (AudioAttributes) audioAttributes);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Notification.Action.Builder createBuilder(Icon icon, CharSequence title, PendingIntent intent) {
            return new Notification.Action.Builder(icon, title, intent);
        }

        static Notification.Builder setSmallIcon(Notification.Builder builder, Object icon) {
            return builder.setSmallIcon((Icon) icon);
        }

        static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean allowGeneratedReplies) {
            return builder.setAllowGeneratedReplies(allowGeneratedReplies);
        }

        static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] text) {
            return builder.setRemoteInputHistory(text);
        }

        static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews contentView) {
            return builder.setCustomContentView(contentView);
        }

        static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews contentView) {
            return builder.setCustomBigContentView(contentView);
        }

        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews contentView) {
            return builder.setCustomHeadsUpContentView(contentView);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Notification.Builder createBuilder(Context context, String channelId) {
            return new Notification.Builder(context, channelId);
        }

        static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int groupAlertBehavior) {
            return builder.setGroupAlertBehavior(groupAlertBehavior);
        }

        static Notification.Builder setColorized(Notification.Builder builder, boolean colorize) {
            return builder.setColorized(colorize);
        }

        static Notification.Builder setBadgeIconType(Notification.Builder builder, int icon) {
            return builder.setBadgeIconType(icon);
        }

        static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence text) {
            return builder.setSettingsText(text);
        }

        static Notification.Builder setShortcutId(Notification.Builder builder, String shortcutId) {
            return builder.setShortcutId(shortcutId);
        }

        static Notification.Builder setTimeoutAfter(Notification.Builder builder, long durationMs) {
            return builder.setTimeoutAfter(durationMs);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int semanticAction) {
            return builder.setSemanticAction(semanticAction);
        }

        static Notification.Builder addPerson(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean isContextual) {
            return builder.setContextual(isContextual);
        }

        static Notification.Builder setLocusId(Notification.Builder builder, Object locusId) {
            return builder.setLocusId((LocusId) locusId);
        }

        static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata data) {
            return builder.setBubbleMetadata(data);
        }

        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean allowed) {
            return builder.setAllowSystemGeneratedContextualActions(allowed);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean authenticationRequired) {
            return builder.setAuthenticationRequired(authenticationRequired);
        }

        static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int behavior) {
            return builder.setForegroundServiceBehavior(behavior);
        }
    }
}
