package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdr implements ListenerHolder.Notifier {
    final /* synthetic */ Location zza;

    zzdr(zzdt zzdt, Location location) {
        this.zza = location;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationListener) obj).onLocationChanged(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
