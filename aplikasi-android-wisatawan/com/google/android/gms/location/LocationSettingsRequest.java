package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzah();
    private final List zza;
    private final boolean zzb;
    private final boolean zzc;

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public static final class Builder {
        private final ArrayList zza = new ArrayList();
        private boolean zzb = false;
        private boolean zzc = false;

        public Builder addAllLocationRequests(Collection<LocationRequest> requests) {
            for (LocationRequest next : requests) {
                if (next != null) {
                    this.zza.add(next);
                }
            }
            return this;
        }

        public Builder addLocationRequest(LocationRequest request) {
            if (request != null) {
                this.zza.add(request);
            }
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zza, this.zzb, this.zzc);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzb = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzc = z;
            return this;
        }
    }

    LocationSettingsRequest(List list, boolean z, boolean z2) {
        this.zza = list;
        this.zzb = z;
        this.zzc = z2;
    }

    public void writeToParcel(Parcel dest, int i) {
        List list = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeTypedList(dest, 1, Collections.unmodifiableList(list), false);
        SafeParcelWriter.writeBoolean(dest, 2, this.zzb);
        SafeParcelWriter.writeBoolean(dest, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
