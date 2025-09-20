package com.example.aplikasiwisatawan;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class Halaman_Navigasi extends AppCompatActivity {
    Halaman adapter;
    TabLayout tabLayout;
    ImageView tombol_kembali;
    ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.halaman_navigasi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new Halaman_Navigasi$$ExternalSyntheticLambda0());
        this.tabLayout = (TabLayout) findViewById(R.id.tab);
        this.viewPager = (ViewPager) findViewById(R.id.viewpager);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        Halaman halaman = new Halaman(getApplicationContext(), getSupportFragmentManager(), this.tabLayout.getTabCount());
        this.adapter = halaman;
        this.viewPager.setAdapter(halaman);
        this.tombol_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Halaman_Navigasi.this.finish();
            }
        });
        this.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
        this.tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                Halaman_Navigasi.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }
}
