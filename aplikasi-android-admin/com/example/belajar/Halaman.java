package com.example.belajar;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/* compiled from: Halaman_Navigasi */
class Halaman extends FragmentStatePagerAdapter {
    Context context;
    int jumlah_tab;

    Halaman(Context context2, FragmentManager fm, int jml_tab) {
        super(fm);
        this.context = context2;
        this.jumlah_tab = jml_tab;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Profil();
            case 1:
                return new Peta();
            case 2:
                return new TentangAplikasi();
            default:
                return null;
        }
    }

    public int getCount() {
        return this.jumlah_tab;
    }
}
