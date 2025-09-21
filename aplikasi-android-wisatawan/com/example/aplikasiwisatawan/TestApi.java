package com.example.aplikasiwisatawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TestApi extends AppCompatActivity {
    public static String kodew;
    TextView alamat;
    TextView biaya;
    Button bukahl;
    ImageView fot;
    TextView info;
    TextView kategori;
    TextView kodewisata;
    TextView latitude;
    TextView longitude;
    TextView namawisata;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_test_api);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new TestApi$$ExternalSyntheticLambda0());
        String str = "http://192.168.241.119:8000/api/datawisata/" + "600";
        this.bukahl = (Button) findViewById(R.id.bukahl);
        this.kodewisata = (TextView) findViewById(R.id.kodewisata);
        this.kategori = (TextView) findViewById(R.id.kategori);
        this.namawisata = (TextView) findViewById(R.id.namawisata);
        this.alamat = (TextView) findViewById(R.id.alamat);
        this.biaya = (TextView) findViewById(R.id.biaya);
        this.longitude = (TextView) findViewById(R.id.longitude);
        this.latitude = (TextView) findViewById(R.id.latitude);
        this.info = (TextView) findViewById(R.id.info);
        this.fot = (ImageView) findViewById(R.id.foto);
        this.bukahl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TestApi.this.startActivity(new Intent(TestApi.this.getApplicationContext(), Login.class));
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }
}
