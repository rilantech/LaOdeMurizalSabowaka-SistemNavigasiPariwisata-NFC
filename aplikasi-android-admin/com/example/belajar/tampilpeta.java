package com.example.belajar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tampilpeta extends AppCompatActivity {
    double latAsal = -5.6835003d;
    double latTujuan = -5.6594375d;
    double longAsal = 122.6706851d;
    double longTujuan = 122.684259d;
    WebView wbv;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_tampilpeta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new tampilpeta$$ExternalSyntheticLambda0());
        WebView webView = (WebView) findViewById(R.id.myWebView);
        this.wbv = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.wbv.getSettings().setDomStorageEnabled(true);
        this.wbv.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (URLUtil.isNetworkUrl((String) null)) {
                    return false;
                }
                if (!tampilpeta.this.appInstalledOrNot((String) null)) {
                    return true;
                }
                tampilpeta.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) null)));
                return true;
            }
        });
        this.wbv.loadUrl("https://www.google.com/maps?saddr=" + this.latAsal + "," + this.longAsal + "&daddr=" + this.latTujuan + "," + this.longTujuan);
        Toast.makeText(this, "Loading Direction, Plase Wait...", 1).show();
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: package-private */
    public boolean appInstalledOrNot(String url) {
        try {
            getPackageManager().getPackageInfo(url, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
