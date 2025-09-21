package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.maps.zzao;
import com.google.android.gms.internal.maps.zzap;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzah();
    /* access modifiers changed from: private */
    public zzap zza;
    private TileProvider zzb;
    private boolean zzc = true;
    private float zzd;
    private boolean zze = true;
    private float zzf = 0.0f;

    public TileOverlayOptions() {
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.zze = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.zze;
    }

    public TileProvider getTileProvider() {
        return this.zzb;
    }

    public float getTransparency() {
        return this.zzf;
    }

    public float getZIndex() {
        return this.zzd;
    }

    public boolean isVisible() {
        return this.zzc;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.zzb = (TileProvider) Preconditions.checkNotNull(tileProvider, "tileProvider must not be null.");
        this.zza = new zzag(this, tileProvider);
        return this;
    }

    public TileOverlayOptions transparency(float transparency) {
        boolean z = false;
        if (transparency >= 0.0f && transparency <= 1.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Transparency must be in the range [0..1]");
        this.zzf = transparency;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.zzc = z;
        return this;
    }

    public void writeToParcel(Parcel out, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        zzap zzap = this.zza;
        if (zzap == null) {
            iBinder = null;
        } else {
            iBinder = zzap.asBinder();
        }
        SafeParcelWriter.writeIBinder(out, 2, iBinder, false);
        SafeParcelWriter.writeBoolean(out, 3, isVisible());
        SafeParcelWriter.writeFloat(out, 4, getZIndex());
        SafeParcelWriter.writeBoolean(out, 5, getFadeIn());
        SafeParcelWriter.writeFloat(out, 6, getTransparency());
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }

    public TileOverlayOptions zIndex(float f) {
        this.zzd = f;
        return this;
    }

    TileOverlayOptions(IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        zzaf zzaf;
        zzap zzc2 = zzao.zzc(iBinder);
        this.zza = zzc2;
        if (zzc2 == null) {
            zzaf = null;
        } else {
            zzaf = new zzaf(this);
        }
        this.zzb = zzaf;
        this.zzc = z;
        this.zzd = f;
        this.zze = z2;
        this.zzf = f2;
    }
}
