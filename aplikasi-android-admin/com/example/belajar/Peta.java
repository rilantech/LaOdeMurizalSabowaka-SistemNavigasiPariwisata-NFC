package com.example.belajar;

import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.compose.material3.TooltipKt;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import org.json.JSONException;
import org.json.JSONObject;

public class Peta extends Fragment {
    public static String latitdst;
    public static String longitdst;
    public static WebView webviewku;
    private final int REQUEST_CHECK_CODE = 8989;
    /* access modifiers changed from: private */
    public LocationSettingsRequest.Builder builder;
    public String latit;
    private FusedLocationProviderClient locationProviderClient;
    public String longi;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.peta, (ViewGroup) null);
        this.locationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
        webviewku = (WebView) view.findViewById(R.id.webviewku);
        Volley.newRequestQueue(getContext()).add(new JsonObjectRequest(0, KoneksiApi.URL_API + "api/datawisata/" + Baca_Tag_Wisata.userData, (JSONObject) null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try {
                    Peta.longitdst = response.getString("longitude");
                    Peta.latitdst = response.getString("latitude");
                    Peta.this.getLocation();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Peta.this.getContext(), volleyError.getMessage(), 0).show();
            }
        }));
        return view;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        getLocation();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 10) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            getLocation();
        } else {
            Toast.makeText(getContext(), "Izin lokasi tidak di izinkan!", 0).show();
        }
    }

    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.locationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        Peta.this.latit = String.valueOf(location.getLatitude());
                        Peta.this.longi = String.valueOf(location.getLongitude());
                        Peta.webviewku.setWebChromeClient(new WebChromeClient());
                        Peta.webviewku.getSettings().setJavaScriptEnabled(true);
                        Peta.webviewku.loadUrl("https://www.google.com/maps?saddr=" + Peta.this.latit + "," + Peta.this.longi + "&daddr=" + Peta.latitdst + "," + Peta.longitdst);
                        return;
                    }
                    Toast.makeText(Peta.this.getContext(), "GPS tidak aktif", 0).show();
                    LocationSettingsRequest.Builder unused = Peta.this.builder = new LocationSettingsRequest.Builder().addLocationRequest(new LocationRequest().setFastestInterval(TooltipKt.TooltipDuration).setInterval(3000).setPriority(100));
                    LocationServices.getSettingsClient(Peta.this.getContext()).checkLocationSettings(Peta.this.builder.build()).addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
                        public void onComplete(Task<LocationSettingsResponse> task) {
                            try {
                                task.getResult(ApiException.class);
                            } catch (ApiException e) {
                                switch (e.getStatusCode()) {
                                    case 6:
                                        try {
                                            ((ResolvableApiException) e).startResolutionForResult(Peta.this.getActivity(), 8989);
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
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception e) {
                    Toast.makeText(Peta.this.getContext(), e.getLocalizedMessage(), 0).show();
                }
            });
        } else {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 10);
        }
    }
}
