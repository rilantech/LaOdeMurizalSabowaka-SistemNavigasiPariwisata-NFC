package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzk();
    private static final String zza = MapStyleOptions.class.getSimpleName();
    private final String zzb;

    public MapStyleOptions(String json) {
        Preconditions.checkNotNull(json, "json must not be null");
        this.zzb = json;
    }

    public static MapStyleOptions loadRawResourceStyle(Context clientContext, int resourceId) throws Resources.NotFoundException {
        try {
            return new MapStyleOptions(new String(IOUtils.readInputStreamFully(clientContext.getResources().openRawResource(resourceId)), Key.STRING_CHARSET_NAME));
        } catch (IOException e) {
            String obj = e.toString();
            throw new Resources.NotFoundException("Failed to read resource " + resourceId + ": " + obj);
        }
    }

    public void writeToParcel(Parcel out, int i) {
        String str = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        SafeParcelWriter.writeString(out, 2, str, false);
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }
}
