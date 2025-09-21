package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class ActivityDetailDataBinding implements ViewBinding {
    public final TextView alamat;
    public final TextView biaya;
    public final TextView foto;
    public final TextView info;
    public final TextView kategori;
    public final TextView kodewisata;
    public final TextView latitude;
    public final TextView lbl;
    public final TextView longitude;
    public final LinearLayout main;
    public final TextView namawisata;
    private final LinearLayout rootView;

    private ActivityDetailDataBinding(LinearLayout rootView2, TextView alamat2, TextView biaya2, TextView foto2, TextView info2, TextView kategori2, TextView kodewisata2, TextView latitude2, TextView lbl2, TextView longitude2, LinearLayout main2, TextView namawisata2) {
        this.rootView = rootView2;
        this.alamat = alamat2;
        this.biaya = biaya2;
        this.foto = foto2;
        this.info = info2;
        this.kategori = kategori2;
        this.kodewisata = kodewisata2;
        this.latitude = latitude2;
        this.lbl = lbl2;
        this.longitude = longitude2;
        this.main = main2;
        this.namawisata = namawisata2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDetailDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityDetailDataBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_detail_data, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityDetailDataBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.alamat;
        TextView alamat2 = (TextView) ViewBindings.findChildViewById(view, R.id.alamat);
        if (alamat2 != null) {
            id = R.id.biaya;
            TextView biaya2 = (TextView) ViewBindings.findChildViewById(view, R.id.biaya);
            if (biaya2 != null) {
                id = R.id.foto;
                TextView foto2 = (TextView) ViewBindings.findChildViewById(view, R.id.foto);
                if (foto2 != null) {
                    id = R.id.info;
                    TextView info2 = (TextView) ViewBindings.findChildViewById(view, R.id.info);
                    if (info2 != null) {
                        id = R.id.kategori;
                        TextView kategori2 = (TextView) ViewBindings.findChildViewById(view, R.id.kategori);
                        if (kategori2 != null) {
                            id = R.id.kodewisata;
                            TextView kodewisata2 = (TextView) ViewBindings.findChildViewById(view, R.id.kodewisata);
                            if (kodewisata2 != null) {
                                id = R.id.latitude;
                                TextView latitude2 = (TextView) ViewBindings.findChildViewById(view, R.id.latitude);
                                if (latitude2 != null) {
                                    id = R.id.lbl;
                                    TextView lbl2 = (TextView) ViewBindings.findChildViewById(view, R.id.lbl);
                                    if (lbl2 != null) {
                                        id = R.id.longitude;
                                        TextView longitude2 = (TextView) ViewBindings.findChildViewById(view, R.id.longitude);
                                        if (longitude2 != null) {
                                            LinearLayout main2 = (LinearLayout) view;
                                            id = R.id.namawisata;
                                            TextView namawisata2 = (TextView) ViewBindings.findChildViewById(view, R.id.namawisata);
                                            if (namawisata2 != null) {
                                                return new ActivityDetailDataBinding((LinearLayout) view, alamat2, biaya2, foto2, info2, kategori2, kodewisata2, latitude2, lbl2, longitude2, main2, namawisata2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
