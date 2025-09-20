package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.belajar.R;

public final class HalamanUtamaAdminBinding implements ViewBinding {
    public final ImageView btnLogout;
    public final LinearLayout main;
    public final TextView result;
    private final LinearLayout rootView;
    public final Button tombolBacaTag;
    public final Button tombolInputKode;
    public final Button tombolScan;
    public final TextView tvNama;
    public final TextView tvPassword;
    public final TextView tvUsername;

    private HalamanUtamaAdminBinding(LinearLayout rootView2, ImageView btnLogout2, LinearLayout main2, TextView result2, Button tombolBacaTag2, Button tombolInputKode2, Button tombolScan2, TextView tvNama2, TextView tvPassword2, TextView tvUsername2) {
        this.rootView = rootView2;
        this.btnLogout = btnLogout2;
        this.main = main2;
        this.result = result2;
        this.tombolBacaTag = tombolBacaTag2;
        this.tombolInputKode = tombolInputKode2;
        this.tombolScan = tombolScan2;
        this.tvNama = tvNama2;
        this.tvPassword = tvPassword2;
        this.tvUsername = tvUsername2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HalamanUtamaAdminBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static HalamanUtamaAdminBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.halaman_utama_admin, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static HalamanUtamaAdminBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.btnLogout;
        ImageView btnLogout2 = (ImageView) ViewBindings.findChildViewById(view, R.id.btnLogout);
        if (btnLogout2 != null) {
            LinearLayout main2 = (LinearLayout) view;
            id = R.id.result;
            TextView result2 = (TextView) ViewBindings.findChildViewById(view, R.id.result);
            if (result2 != null) {
                id = R.id.tombol_baca_tag;
                Button tombolBacaTag2 = (Button) ViewBindings.findChildViewById(view, R.id.tombol_baca_tag);
                if (tombolBacaTag2 != null) {
                    id = R.id.tombol_input_kode;
                    Button tombolInputKode2 = (Button) ViewBindings.findChildViewById(view, R.id.tombol_input_kode);
                    if (tombolInputKode2 != null) {
                        id = R.id.tombol_scan;
                        Button tombolScan2 = (Button) ViewBindings.findChildViewById(view, R.id.tombol_scan);
                        if (tombolScan2 != null) {
                            id = R.id.tvNama;
                            TextView tvNama2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvNama);
                            if (tvNama2 != null) {
                                id = R.id.tvPassword;
                                TextView tvPassword2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvPassword);
                                if (tvPassword2 != null) {
                                    id = R.id.tvUsername;
                                    TextView tvUsername2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvUsername);
                                    if (tvUsername2 != null) {
                                        return new HalamanUtamaAdminBinding((LinearLayout) view, btnLogout2, main2, result2, tombolBacaTag2, tombolInputKode2, tombolScan2, tvNama2, tvPassword2, tvUsername2);
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
