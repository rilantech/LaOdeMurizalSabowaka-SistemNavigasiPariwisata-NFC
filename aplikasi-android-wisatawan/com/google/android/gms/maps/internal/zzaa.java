package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.internal.maps.zzu;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public abstract class zzaa extends zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb();
                break;
            case 2:
                zzu zzb = zzt.zzb(parcel.readStrongBinder());
                zzc.zzc(parcel);
                zzc(zzb);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
