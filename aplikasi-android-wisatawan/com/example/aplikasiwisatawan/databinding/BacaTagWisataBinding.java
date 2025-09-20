package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class BacaTagWisataBinding implements ViewBinding {
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final ImageView tombolKembali;
    public final Button tombolbacatag;

    private BacaTagWisataBinding(LinearLayout rootView2, LinearLayout main2, ImageView tombolKembali2, Button tombolbacatag2) {
        this.rootView = rootView2;
        this.main = main2;
        this.tombolKembali = tombolKembali2;
        this.tombolbacatag = tombolbacatag2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BacaTagWisataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static BacaTagWisataBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.baca_tag_wisata, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BacaTagWisataBinding bind(View rootView2) {
        LinearLayout main2 = (LinearLayout) rootView2;
        int id = R.id.tombol_kembali;
        ImageView tombolKembali2 = (ImageView) ViewBindings.findChildViewById(rootView2, R.id.tombol_kembali);
        if (tombolKembali2 != null) {
            id = R.id.tombolbacatag;
            Button tombolbacatag2 = (Button) ViewBindings.findChildViewById(rootView2, R.id.tombolbacatag);
            if (tombolbacatag2 != null) {
                return new BacaTagWisataBinding((LinearLayout) rootView2, main2, tombolKembali2, tombolbacatag2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
