package com.example.belajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class HalamanUtamaAdmin extends AppCompatActivity {
    ImageView btnLogout;
    PreferenceHelper preferenceHelper;
    TextView resultText;
    Button tombol_baca_tag;
    Button tombol_input_kode;
    Button tombol_scan;
    TextView tvNama;
    TextView tvPassword;
    TextView tvUsername;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.halaman_utama_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new HalamanUtamaAdmin$$ExternalSyntheticLambda0());
        this.preferenceHelper = new PreferenceHelper(this);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvUsername = (TextView) findViewById(R.id.tvUsername);
        this.tvPassword = (TextView) findViewById(R.id.tvPassword);
        this.btnLogout = (ImageView) findViewById(R.id.btnLogout);
        this.tombol_input_kode = (Button) findViewById(R.id.tombol_input_kode);
        this.tombol_baca_tag = (Button) findViewById(R.id.tombol_baca_tag);
        this.tombol_scan = (Button) findViewById(R.id.tombol_scan);
        this.resultText = (TextView) findViewById(R.id.result);
        this.tvNama.setText("Welcome " + this.preferenceHelper.getNama());
        this.tvUsername.setText("Username : " + this.preferenceHelper.getUsername());
        this.tvPassword.setText("Password : " + this.preferenceHelper.getPassword());
        this.btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new SweetAlertDialog(HalamanUtamaAdmin.this, 3).setTitleText("Konfirmasi").setContentText("Apakah Anda Ingin Logout ?").setConfirmText("Ok").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        HalamanUtamaAdmin.this.preferenceHelper.putIsLogin(false);
                        Intent intent = new Intent(HalamanUtamaAdmin.this, Login.class);
                        intent.addFlags(268468224);
                        HalamanUtamaAdmin.this.startActivity(intent);
                        HalamanUtamaAdmin.this.finish();
                    }
                }).setCancelButton("Batal", (SweetAlertDialog.OnSweetClickListener) new SweetAlertDialog.OnSweetClickListener() {
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                }).show();
            }
        });
        this.tombol_input_kode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HalamanUtamaAdmin.this.startActivity(new Intent(HalamanUtamaAdmin.this, Input_Kode_Wisata.class));
            }
        });
        this.tombol_baca_tag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HalamanUtamaAdmin.this.startActivity(new Intent(HalamanUtamaAdmin.this, Baca_Tag_Wisata.class));
            }
        });
        this.tombol_scan.setOnClickListener(new HalamanUtamaAdmin$$ExternalSyntheticLambda1(this));
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-example-belajar-HalamanUtamaAdmin  reason: not valid java name */
    public /* synthetic */ void m0lambda$onCreate$1$comexamplebelajarHalamanUtamaAdmin(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            starScan();
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
            starScan();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 0);
        }
    }

    private void starScan() {
        startActivityForResult(new Intent(getApplicationContext(), ScannerActivity.class), 20);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == -1 && data != null) {
            String code = data.getStringExtra("result");
            new SweetAlertDialog(this, 2).setTitleText("Info").setContentText("Kode Wisata Berhasil Terbaca").show();
            this.resultText.setText(code);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 0) {
            return;
        }
        if (grantResults[0] == 0) {
            starScan();
        } else {
            Toast.makeText(this, "Gagal membuka kamera", 1).show();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.preferenceHelper.putIsLogin(false);
        Intent intent = new Intent(this, Login.class);
        intent.addFlags(268468224);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (Login.status.booleanValue()) {
            new SweetAlertDialog(this, 2).setTitleText("Info").setContentText("Berhasil Login").show();
        }
        Login.status = false;
    }
}
