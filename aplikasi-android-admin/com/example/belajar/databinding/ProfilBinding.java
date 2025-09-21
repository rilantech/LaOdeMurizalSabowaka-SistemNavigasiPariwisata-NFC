package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.belajar.R;

public final class ProfilBinding implements ViewBinding {
    public final TextView alamat;
    public final TextView biaya;
    public final ImageView fotobesar;
    public final ImageView fotokecil1;
    public final ImageView fotokecil2;
    public final ImageView fotokecil3;
    public final TextView info;
    public final LinearLayout linearLayout3;
    public final LinearLayout linearLayout5;
    public final LinearLayout linearLayout6;
    public final ConstraintLayout main;
    public final TextView namawisata;
    private final ScrollView rootView;
    public final TextView textView;

    private ProfilBinding(ScrollView rootView2, TextView alamat2, TextView biaya2, ImageView fotobesar2, ImageView fotokecil12, ImageView fotokecil22, ImageView fotokecil32, TextView info2, LinearLayout linearLayout32, LinearLayout linearLayout52, LinearLayout linearLayout62, ConstraintLayout main2, TextView namawisata2, TextView textView2) {
        this.rootView = rootView2;
        this.alamat = alamat2;
        this.biaya = biaya2;
        this.fotobesar = fotobesar2;
        this.fotokecil1 = fotokecil12;
        this.fotokecil2 = fotokecil22;
        this.fotokecil3 = fotokecil32;
        this.info = info2;
        this.linearLayout3 = linearLayout32;
        this.linearLayout5 = linearLayout52;
        this.linearLayout6 = linearLayout62;
        this.main = main2;
        this.namawisata = namawisata2;
        this.textView = textView2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ProfilBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ProfilBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.profil, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ProfilBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.alamat;
        TextView alamat2 = (TextView) ViewBindings.findChildViewById(view, R.id.alamat);
        if (alamat2 != null) {
            id = R.id.biaya;
            TextView biaya2 = (TextView) ViewBindings.findChildViewById(view, R.id.biaya);
            if (biaya2 != null) {
                id = R.id.fotobesar;
                ImageView fotobesar2 = (ImageView) ViewBindings.findChildViewById(view, R.id.fotobesar);
                if (fotobesar2 != null) {
                    id = R.id.fotokecil1;
                    ImageView fotokecil12 = (ImageView) ViewBindings.findChildViewById(view, R.id.fotokecil1);
                    if (fotokecil12 != null) {
                        id = R.id.fotokecil2;
                        ImageView fotokecil22 = (ImageView) ViewBindings.findChildViewById(view, R.id.fotokecil2);
                        if (fotokecil22 != null) {
                            id = R.id.fotokecil3;
                            ImageView fotokecil32 = (ImageView) ViewBindings.findChildViewById(view, R.id.fotokecil3);
                            if (fotokecil32 != null) {
                                id = R.id.info;
                                TextView info2 = (TextView) ViewBindings.findChildViewById(view, R.id.info);
                                if (info2 != null) {
                                    id = R.id.linearLayout3;
                                    LinearLayout linearLayout32 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout3);
                                    if (linearLayout32 != null) {
                                        id = R.id.linearLayout5;
                                        LinearLayout linearLayout52 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout5);
                                        if (linearLayout52 != null) {
                                            id = R.id.linearLayout6;
                                            LinearLayout linearLayout62 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout6);
                                            if (linearLayout62 != null) {
                                                id = R.id.main;
                                                ConstraintLayout main2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.main);
                                                if (main2 != null) {
                                                    id = R.id.namawisata;
                                                    TextView namawisata2 = (TextView) ViewBindings.findChildViewById(view, R.id.namawisata);
                                                    if (namawisata2 != null) {
                                                        id = R.id.textView;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView);
                                                        if (textView2 != null) {
                                                            return new ProfilBinding((ScrollView) view, alamat2, biaya2, fotobesar2, fotokecil12, fotokecil22, fotokecil32, info2, linearLayout32, linearLayout52, linearLayout62, main2, namawisata2, textView2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
