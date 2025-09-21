package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbe;
import com.google.android.gms.maps.model.PointOfInterest;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzr extends zzbe {
    final /* synthetic */ GoogleMap.OnPoiClickListener zza;

    zzr(GoogleMap googleMap, GoogleMap.OnPoiClickListener onPoiClickListener) {
        this.zza = onPoiClickListener;
    }

    public final void zzb(PointOfInterest pointOfInterest) throws RemoteException {
        this.zza.onPoiClick(pointOfInterest);
    }
}
