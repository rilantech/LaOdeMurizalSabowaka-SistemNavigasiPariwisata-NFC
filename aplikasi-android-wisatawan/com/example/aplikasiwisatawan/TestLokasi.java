package com.example.aplikasiwisatawan;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class TestLokasi extends AppCompatActivity {
    /* access modifiers changed from: private */
    public TextView akurasi;
    /* access modifiers changed from: private */
    public TextView altitude;
    private Button btnFind;
    /* access modifiers changed from: private */
    public String latit;
    /* access modifiers changed from: private */
    public TextView latitude;
    private FusedLocationProviderClient locationProviderClient;
    /* access modifiers changed from: private */
    public String longit;
    /* access modifiers changed from: private */
    public TextView longitude;
    /* access modifiers changed from: private */
    public WebView webviewku;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_test_lokasi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new TestLokasi$$ExternalSyntheticLambda0());
        this.latitude = (TextView) findViewById(R.id.lat);
        this.longitude = (TextView) findViewById(R.id.longi);
        this.altitude = (TextView) findViewById(R.id.alti);
        this.akurasi = (TextView) findViewById(R.id.akurasi);
        this.btnFind = (Button) findViewById(R.id.btn_find);
        this.webviewku = (WebView) findViewById(R.id.webviewku);
        this.locationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
        this.btnFind.setOnClickListener(new TestLokasi$$ExternalSyntheticLambda1(this));
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-example-aplikasiwisatawan-TestLokasi  reason: not valid java name */
    public /* synthetic */ void m0lambda$onCreate$1$comexampleaplikasiwisatawanTestLokasi(View v) {
        getLocation();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 10) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            getLocation();
        } else {
            Toast.makeText(this, "Izin lokasi tidak di izinkan!", 0).show();
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.locationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        String unused = TestLokasi.this.latit = String.valueOf(location.getLatitude());
                        String unused2 = TestLokasi.this.longit = String.valueOf(location.getLongitude());
                        TestLokasi.this.latitude.setText(TestLokasi.this.latit);
                        TestLokasi.this.longitude.setText(TestLokasi.this.longit);
                        TestLokasi.this.altitude.setText(String.valueOf(location.getAltitude()));
                        TestLokasi.this.akurasi.setText(location.getAccuracy() + "%");
                        TestLokasi.this.webviewku.setWebChromeClient(new WebChromeClient());
                        TestLokasi.this.webviewku.getSettings().setJavaScriptEnabled(true);
                        TestLokasi.this.webviewku.loadUrl("https://www.google.com/maps?saddr=" + TestLokasi.this.latit + "," + TestLokasi.this.longit + "&daddr=-5.6697097,122.6768942");
                        return;
                    }
                    Toast.makeText(TestLokasi.this, "Lokasi tidak aktif", 0).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception e) {
                    Toast.makeText(TestLokasi.this, e.getLocalizedMessage(), 0).show();
                }
            });
        } else {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 10);
        }
    }
}
