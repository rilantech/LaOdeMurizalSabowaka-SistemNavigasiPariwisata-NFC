package com.example.belajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.example.belajar.R;
import com.google.android.material.tabs.TabLayout;

public final class HalamanNavigasiBinding implements ViewBinding {
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final TabLayout tab;
    public final ImageView tombolKembali;
    public final ViewPager viewpager;

    private HalamanNavigasiBinding(LinearLayout rootView2, LinearLayout main2, TabLayout tab2, ImageView tombolKembali2, ViewPager viewpager2) {
        this.rootView = rootView2;
        this.main = main2;
        this.tab = tab2;
        this.tombolKembali = tombolKembali2;
        this.viewpager = viewpager2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HalamanNavigasiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, (ViewGroup) null, false);
    }

    public static HalamanNavigasiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.halaman_navigasi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static HalamanNavigasiBinding bind(View rootView2) {
        LinearLayout main2 = (LinearLayout) rootView2;
        int id = R.id.tab;
        TabLayout tab2 = (TabLayout) ViewBindings.findChildViewById(rootView2, R.id.tab);
        if (tab2 != null) {
            id = R.id.tombol_kembali;
            ImageView tombolKembali2 = (ImageView) ViewBindings.findChildViewById(rootView2, R.id.tombol_kembali);
            if (tombolKembali2 != null) {
                ViewPager viewpager2 = (ViewPager) ViewBindings.findChildViewById(rootView2, R.id.viewpager);
                if (viewpager2 != null) {
                    return new HalamanNavigasiBinding((LinearLayout) rootView2, main2, tab2, tombolKembali2, viewpager2);
                }
                id = R.id.viewpager;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}
