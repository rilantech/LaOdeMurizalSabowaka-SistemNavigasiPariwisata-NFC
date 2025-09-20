package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public class PinConfig extends AbstractSafeParcelable {
    public static final int BITMAP_LENGTH_DP = 37;
    public static final int BITMAP_WIDTH_DP = 26;
    public static final Parcelable.Creator<PinConfig> CREATOR = new zzo();
    public static final int DEFAULT_PIN_BACKGROUND_COLOR = -1424587;
    public static final int DEFAULT_PIN_BORDER_COLOR = -3857889;
    public static final int DEFAULT_PIN_GLYPH_COLOR = -5041134;
    private final int zza;
    private final int zzb;
    private final Glyph zzc;

    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    public static class Builder {
        private int zza = PinConfig.DEFAULT_PIN_BACKGROUND_COLOR;
        private int zzb = PinConfig.DEFAULT_PIN_BORDER_COLOR;
        private Glyph zzc = new Glyph((int) PinConfig.DEFAULT_PIN_GLYPH_COLOR);

        public PinConfig build() {
            return new PinConfig(this.zza, this.zzb, this.zzc);
        }

        public Builder setBackgroundColor(int i) {
            this.zza = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setGlyph(Glyph glyph) {
            this.zzc = glyph;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    public static class Glyph extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Glyph> CREATOR = new zzf();
        public static final float DEFAULT_CIRCLE_RADIUS_DP = 5.0f;
        public static final float X_COORDINATE_DP = 13.0f;
        public static final float Y_COORDINATE_DP = 13.0f;
        private String zza;
        private BitmapDescriptor zzb;
        private int zzc;
        private int zzd;

        public Glyph(int glyphColor) {
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zzc = glyphColor;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Glyph)) {
                return false;
            }
            Glyph glyph = (Glyph) o;
            if (this.zzc != glyph.zzc || !zzn.zza(this.zza, glyph.zza) || this.zzd != glyph.zzd) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor = this.zzb;
            if ((bitmapDescriptor == null && glyph.zzb != null) || (bitmapDescriptor != null && glyph.zzb == null)) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor2 = glyph.zzb;
            if (bitmapDescriptor == null || bitmapDescriptor2 == null) {
                return true;
            }
            return zzn.zza(ObjectWrapper.unwrap(bitmapDescriptor.zza()), ObjectWrapper.unwrap(bitmapDescriptor2.zza()));
        }

        public BitmapDescriptor getBitmapDescriptor() {
            return this.zzb;
        }

        public int getGlyphColor() {
            return this.zzc;
        }

        public String getText() {
            return this.zza;
        }

        public int getTextColor() {
            return this.zzd;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.zza, this.zzb, Integer.valueOf(this.zzc)});
        }

        public void writeToParcel(Parcel out, int i) {
            IBinder iBinder;
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
            SafeParcelWriter.writeString(out, 2, getText(), false);
            BitmapDescriptor bitmapDescriptor = this.zzb;
            if (bitmapDescriptor == null) {
                iBinder = null;
            } else {
                iBinder = bitmapDescriptor.zza().asBinder();
            }
            SafeParcelWriter.writeIBinder(out, 3, iBinder, false);
            SafeParcelWriter.writeInt(out, 4, getGlyphColor());
            SafeParcelWriter.writeInt(out, 5, getTextColor());
            SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
        }

        public Glyph(BitmapDescriptor bitmapDescriptor) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zzb = bitmapDescriptor;
        }

        public Glyph(String text) {
            this(text, ViewCompat.MEASURED_STATE_MASK);
        }

        public Glyph(String text, int textColor) {
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zza = text;
            this.zzd = textColor;
        }

        Glyph(String str, IBinder iBinder, int i, int i2) {
            BitmapDescriptor bitmapDescriptor;
            this.zzc = PinConfig.DEFAULT_PIN_GLYPH_COLOR;
            this.zzd = ViewCompat.MEASURED_STATE_MASK;
            this.zza = str;
            if (iBinder == null) {
                bitmapDescriptor = null;
            } else {
                bitmapDescriptor = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
            }
            this.zzb = bitmapDescriptor;
            this.zzc = i;
            this.zzd = i2;
        }
    }

    PinConfig(int i, int i2, Glyph glyph) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = glyph;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getBackgroundColor() {
        return this.zza;
    }

    public int getBorderColor() {
        return this.zzb;
    }

    public Glyph getGlyph() {
        return this.zzc;
    }

    public void writeToParcel(Parcel out, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        SafeParcelWriter.writeInt(out, 2, getBackgroundColor());
        SafeParcelWriter.writeInt(out, 3, getBorderColor());
        SafeParcelWriter.writeParcelable(out, 4, getGlyph(), flags, false);
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }
}
