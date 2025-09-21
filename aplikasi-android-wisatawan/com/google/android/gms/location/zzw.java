package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public interface zzw extends IInterface {
    void zzd(LocationResult locationResult) throws RemoteException;

    void zze(LocationAvailability locationAvailability) throws RemoteException;

    void zzf() throws RemoteException;
}
