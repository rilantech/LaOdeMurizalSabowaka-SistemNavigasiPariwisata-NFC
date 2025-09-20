package com.example.belajar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    public static String hasil_scan;
    FrameLayout framelayout;
    private ZXingScannerView mScannerView;
    ImageView tombol_kembali;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_layout);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        this.framelayout = (FrameLayout) findViewById(R.id.frame_layout_camera);
        initScannerView();
        this.tombol_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ScannerActivity.this.finish();
            }
        });
    }

    private void initScannerView() {
        ZXingScannerView zXingScannerView = new ZXingScannerView(this);
        this.mScannerView = zXingScannerView;
        zXingScannerView.setAutoFocus(true);
        this.mScannerView.setResultHandler(this);
        this.mScannerView.setAspectTolerance(0.5f);
        this.framelayout.addView(this.mScannerView);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mScannerView.setResultHandler(this);
        this.mScannerView.startCamera();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mScannerView.stopCamera();
    }

    public void handleResult(Result rawResult) {
        Intent intent = new Intent();
        intent.putExtra("kodewisata", rawResult.getText());
        hasil_scan = String.valueOf(rawResult);
        setResult(-1, intent);
        finish();
    }
}
