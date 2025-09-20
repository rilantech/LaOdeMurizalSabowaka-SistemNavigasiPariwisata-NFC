package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzm();
    private static final String zza = PatternItem.class.getSimpleName();
    private final int zzb;
    private final Float zzc;

    public PatternItem(int i, Float f) {
        boolean z = true;
        if (i != 1 && (f == null || f.floatValue() < 0.0f)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid PatternItem: type=" + i + " length=" + f);
        this.zzb = i;
        this.zzc = f;
    }

    static List zza(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PatternItem patternItem = (PatternItem) it.next();
            if (patternItem != null) {
                int i = patternItem.zzb;
                boolean z = true;
                switch (i) {
                    case 0:
                        if (patternItem.zzc == null) {
                            z = false;
                        }
                        Preconditions.checkState(z, "length must not be null.");
                        patternItem = new Dash(patternItem.zzc.floatValue());
                        break;
                    case 1:
                        patternItem = new Dot();
                        break;
                    case 2:
                        if (patternItem.zzc == null) {
                            z = false;
                        }
                        Preconditions.checkState(z, "length must not be null.");
                        patternItem = new Gap(patternItem.zzc.floatValue());
                        break;
                    default:
                        Log.w(zza, "Unknown PatternItem type: " + i);
                        break;
                }
            } else {
                patternItem = null;
            }
            arrayList.add(patternItem);
        }
        return arrayList;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) o;
        return this.zzb == patternItem.zzb && Objects.equal(this.zzc, patternItem.zzc);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc);
    }

    public String toString() {
        return "[PatternItem: type=" + this.zzb + " length=" + this.zzc + "]";
    }

    public void writeToParcel(Parcel out, int i) {
        int i2 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        SafeParcelWriter.writeInt(out, 2, i2);
        SafeParcelWriter.writeFloatObject(out, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }
}
