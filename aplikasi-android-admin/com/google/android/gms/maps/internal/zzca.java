package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzca extends zza implements IUiSettingsDelegate {
    zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    public final boolean isCompassEnabled() throws RemoteException {
        Parcel zzJ = zzJ(10, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isIndoorLevelPickerEnabled() throws RemoteException {
        Parcel zzJ = zzJ(17, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isMapToolbarEnabled() throws RemoteException {
        Parcel zzJ = zzJ(19, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        Parcel zzJ = zzJ(11, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isRotateGesturesEnabled() throws RemoteException {
        Parcel zzJ = zzJ(15, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isScrollGesturesEnabled() throws RemoteException {
        Parcel zzJ = zzJ(12, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isScrollGesturesEnabledDuringRotateOrZoom() throws RemoteException {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isTiltGesturesEnabled() throws RemoteException {
        Parcel zzJ = zzJ(14, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isZoomControlsEnabled() throws RemoteException {
        Parcel zzJ = zzJ(9, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isZoomGesturesEnabled() throws RemoteException {
        Parcel zzJ = zzJ(13, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final void setAllGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(8, zza);
    }

    public final void setCompassEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(2, zza);
    }

    public final void setIndoorLevelPickerEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(16, zza);
    }

    public final void setMapToolbarEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(18, zza);
    }

    public final void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(3, zza);
    }

    public final void setRotateGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(7, zza);
    }

    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(4, zza);
    }

    public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(20, zza);
    }

    public final void setTiltGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(6, zza);
    }

    public final void setZoomControlsEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(1, zza);
    }

    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(5, zza);
    }
}
