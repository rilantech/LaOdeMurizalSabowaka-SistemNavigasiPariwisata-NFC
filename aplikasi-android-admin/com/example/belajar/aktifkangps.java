package com.example.belajar;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.TooltipKt;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class aktifkangps extends AppCompatActivity {
    private final int REQUEST_CHECK_CODE = 8989;
    Button aktifgps;
    private LocationSettingsRequest.Builder builder;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_aktifkangps);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new aktifkangps$$ExternalSyntheticLambda0());
        this.aktifgps = (Button) findViewById(R.id.aktifgps);
        this.builder = new LocationSettingsRequest.Builder().addLocationRequest(new LocationRequest().setFastestInterval(TooltipKt.TooltipDuration).setInterval(3000).setPriority(100));
        LocationServices.getSettingsClient((Activity) this).checkLocationSettings(this.builder.build()).addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            public void onComplete(Task<LocationSettingsResponse> task) {
                try {
                    task.getResult(ApiException.class);
                } catch (ApiException e) {
                    switch (e.getStatusCode()) {
                        case 6:
                            try {
                                ((ResolvableApiException) e).startResolutionForResult(aktifkangps.this, 8989);
                                return;
                            } catch (IntentSender.SendIntentException e2) {
                                e.printStackTrace();
                                return;
                            } catch (ClassCastException e3) {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }
}
