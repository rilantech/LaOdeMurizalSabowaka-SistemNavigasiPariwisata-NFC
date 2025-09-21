package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        public MediaDescriptionCompat createFromParcel(Parcel in) {
            return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(in));
        }

        public MediaDescriptionCompat[] newArray(int size) {
            return new MediaDescriptionCompat[size];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    MediaDescriptionCompat(String mediaId, CharSequence title, CharSequence subtitle, CharSequence description, Bitmap icon, Uri iconUri, Bundle extras, Uri mediaUri) {
        this.mMediaId = mediaId;
        this.mTitle = title;
        this.mSubtitle = subtitle;
        this.mDescription = description;
        this.mIcon = icon;
        this.mIconUri = iconUri;
        this.mExtras = extras;
        this.mMediaUri = mediaUri;
    }

    MediaDescriptionCompat(Parcel in) {
        this.mMediaId = in.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        ClassLoader loader = getClass().getClassLoader();
        this.mIcon = (Bitmap) in.readParcelable(loader);
        this.mIconUri = (Uri) in.readParcelable(loader);
        this.mExtras = in.readBundle(loader);
        this.mMediaUri = (Uri) in.readParcelable(loader);
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), dest, flags);
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public Object getMediaDescription() {
        Object bob = this.mDescriptionObj;
        if (bob != null) {
            return bob;
        }
        Object bob2 = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(bob2, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(bob2, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(bob2, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(bob2, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(bob2, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(bob2, this.mIconUri);
        MediaDescriptionCompatApi21.Builder.setExtras(bob2, this.mExtras);
        MediaDescriptionCompatApi23.Builder.setMediaUri(bob2, this.mMediaUri);
        Object build = MediaDescriptionCompatApi21.Builder.build(bob2);
        this.mDescriptionObj = build;
        return build;
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r7) {
        /*
            if (r7 == 0) goto L_0x0075
            android.support.v4.media.MediaDescriptionCompat$Builder r0 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r0.<init>()
            java.lang.String r1 = android.support.v4.media.MediaDescriptionCompatApi21.getMediaId(r7)
            r0.setMediaId(r1)
            java.lang.CharSequence r1 = android.support.v4.media.MediaDescriptionCompatApi21.getTitle(r7)
            r0.setTitle(r1)
            java.lang.CharSequence r1 = android.support.v4.media.MediaDescriptionCompatApi21.getSubtitle(r7)
            r0.setSubtitle(r1)
            java.lang.CharSequence r1 = android.support.v4.media.MediaDescriptionCompatApi21.getDescription(r7)
            r0.setDescription(r1)
            android.graphics.Bitmap r1 = android.support.v4.media.MediaDescriptionCompatApi21.getIconBitmap(r7)
            r0.setIconBitmap(r1)
            android.net.Uri r1 = android.support.v4.media.MediaDescriptionCompatApi21.getIconUri(r7)
            r0.setIconUri(r1)
            android.os.Bundle r1 = android.support.v4.media.MediaDescriptionCompatApi21.getExtras(r7)
            r2 = 0
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r1 == 0) goto L_0x0044
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1)
            android.os.Parcelable r4 = r1.getParcelable(r3)
            r2 = r4
            android.net.Uri r2 = (android.net.Uri) r2
        L_0x0044:
            if (r2 == 0) goto L_0x005d
            java.lang.String r4 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r5 = r1.containsKey(r4)
            if (r5 == 0) goto L_0x0057
            int r5 = r1.size()
            r6 = 2
            if (r5 != r6) goto L_0x0057
            r1 = 0
            goto L_0x005d
        L_0x0057:
            r1.remove(r3)
            r1.remove(r4)
        L_0x005d:
            r0.setExtras(r1)
            if (r2 == 0) goto L_0x0066
            r0.setMediaUri(r2)
            goto L_0x006e
        L_0x0066:
            android.net.Uri r3 = android.support.v4.media.MediaDescriptionCompatApi23.getMediaUri(r7)
            r0.setMediaUri(r3)
        L_0x006e:
            android.support.v4.media.MediaDescriptionCompat r3 = r0.build()
            r3.mDescriptionObj = r7
            return r3
        L_0x0075:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder setMediaId(String mediaId) {
            this.mMediaId = mediaId;
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.mTitle = title;
            return this;
        }

        public Builder setSubtitle(CharSequence subtitle) {
            this.mSubtitle = subtitle;
            return this;
        }

        public Builder setDescription(CharSequence description) {
            this.mDescription = description;
            return this;
        }

        public Builder setIconBitmap(Bitmap icon) {
            this.mIcon = icon;
            return this;
        }

        public Builder setIconUri(Uri iconUri) {
            this.mIconUri = iconUri;
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public Builder setMediaUri(Uri mediaUri) {
            this.mMediaUri = mediaUri;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }
    }
}
