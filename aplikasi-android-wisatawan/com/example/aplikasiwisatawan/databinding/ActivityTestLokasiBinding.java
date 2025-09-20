package com.example.aplikasiwisatawan.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.aplikasiwisatawan.R;

public final class ActivityTestLokasiBinding implements ViewBinding {
    public final TextView akurasi;
    public final TextView alti;
    public final Button btnFind;
    public final TextView lat;
    public final TextView longi;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final WebView webviewku;

    private ActivityTestLokasiBinding(LinearLayout rootView2, TextView akurasi2, TextView alti2, Button btnFind2, TextView lat2, TextView longi2, LinearLayout main2, WebView webviewku2) {
        this.rootView = rootView2;
        this.akurasi = akurasi2;
        this.alti = alti2;
        this.btnFind = btnFind2;
        this.lat = lat2;
        this.longi = longi2;
        this.main = main2;
        this.webviewku = webviewku2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestLokasiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static ActivityTestLokasiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_test_lokasi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityTestLokasiBinding bind(View rootView2) {
        View view = rootView2;
        int id = R.id.akurasi;
        TextView akurasi2 = (TextView) ViewBindings.findChildViewById(view, R.id.akurasi);
        if (akurasi2 != null) {
            id = R.id.alti;
            TextView alti2 = (TextView) ViewBindings.findChildViewById(view, R.id.alti);
            if (alti2 != null) {
                id = R.id.btn_find;
                Button btnFind2 = (Button) ViewBindings.findChildViewById(view, R.id.btn_find);
                if (btnFind2 != null) {
                    id = R.id.lat;
                    TextView lat2 = (TextView) ViewBindings.findChildViewById(view, R.id.lat);
                    if (lat2 != null) {
                        id = R.id.longi;
                        TextView longi2 = (TextView) ViewBindings.findChildViewById(view, R.id.longi);
                        if (longi2 != null) {
                            LinearLayout main2 = (LinearLayout) view;
                            id = R.id.webviewku;
                            WebView webviewku2 = (WebView) ViewBindings.findChildViewById(view, R.id.webviewku);
                            if (webviewku2 != null) {
                                return new ActivityTestLokasiBinding((LinearLayout) view, akurasi2, alti2, btnFind2, lat2, longi2, main2, webviewku2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
