package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbc;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzi extends zzbc {
    final /* synthetic */ GoogleMap.OnMyLocationClickListener zza;

    zzi(GoogleMap googleMap, GoogleMap.OnMyLocationClickListener onMyLocationClickListener) {
        this.zza = onMyLocationClickListener;
    }

    public final void zzb(Location location) {
        this.zza.onMyLocationClick(location);
    }
}
