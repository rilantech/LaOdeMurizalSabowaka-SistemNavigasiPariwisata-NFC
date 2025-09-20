package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzi();
    public final LatLng northeast;
    public final LatLng southwest;

    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    public static final class Builder {
        private double zza = Double.POSITIVE_INFINITY;
        private double zzb = Double.NEGATIVE_INFINITY;
        private double zzc = Double.NaN;
        private double zzd = Double.NaN;

        public LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.zzc), "no included points");
            return new LatLngBounds(new LatLng(this.zza, this.zzc), new LatLng(this.zzb, this.zzd));
        }

        public Builder include(LatLng point) {
            Preconditions.checkNotNull(point, "point must not be null");
            this.zza = Math.min(this.zza, point.latitude);
            this.zzb = Math.max(this.zzb, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.zzc)) {
                this.zzc = d;
                this.zzd = d;
            } else {
                double d2 = this.zzc;
                double d3 = this.zzd;
                if (d2 > d3 ? !(d2 <= d || d <= d3) : !(d2 <= d && d <= d3)) {
                    Parcelable.Creator<LatLngBounds> creator = LatLngBounds.CREATOR;
                    if (((d2 - d) + 360.0d) % 360.0d < ((d - this.zzd) + 360.0d) % 360.0d) {
                        this.zzc = d;
                    } else {
                        this.zzd = d;
                    }
                }
            }
            return this;
        }
    }

    public LatLngBounds(LatLng southwest2, LatLng northeast2) {
        boolean z;
        Preconditions.checkNotNull(southwest2, "southwest must not be null.");
        Preconditions.checkNotNull(northeast2, "northeast must not be null.");
        double d = northeast2.latitude;
        double d2 = southwest2.latitude;
        Object[] objArr = {Double.valueOf(d2), Double.valueOf(northeast2.latitude)};
        if (d >= d2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "southern latitude exceeds northern latitude (%s > %s)", objArr);
        this.southwest = southwest2;
        this.northeast = northeast2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attrs) {
        return GoogleMapOptions.zzb(context, attrs);
    }

    private final boolean zza(double d) {
        LatLng latLng = this.northeast;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    public boolean contains(LatLng point) {
        LatLng latLng = (LatLng) Preconditions.checkNotNull(point, "point must not be null.");
        double d = latLng.latitude;
        return this.southwest.latitude <= d && d <= this.northeast.latitude && zza(latLng.longitude);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d;
        LatLng latLng = this.northeast;
        LatLng latLng2 = this.southwest;
        double d2 = latLng2.latitude + latLng.latitude;
        double d3 = latLng.longitude;
        double d4 = latLng2.longitude;
        if (d4 <= d3) {
            d = (d3 + d4) / 2.0d;
        } else {
            d = ((d3 + 360.0d) + d4) / 2.0d;
        }
        return new LatLng(d2 / 2.0d, d);
    }

    public int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        LatLng latLng = (LatLng) Preconditions.checkNotNull(point, "point must not be null.");
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!zza(d3)) {
            if (((d2 - d3) + 360.0d) % 360.0d < ((d3 - d) + 360.0d) % 360.0d) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        LatLng latLng = this.southwest;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        SafeParcelWriter.writeParcelable(out, 2, latLng, flags, false);
        SafeParcelWriter.writeParcelable(out, 3, this.northeast, flags, false);
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }
}
