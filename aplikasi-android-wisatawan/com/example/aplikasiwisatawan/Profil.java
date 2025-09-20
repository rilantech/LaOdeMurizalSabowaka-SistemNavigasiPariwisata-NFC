package com.example.aplikasiwisatawan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Profil extends Fragment {
    public static String lati;
    public static String longi;
    /* access modifiers changed from: private */
    public String URLSimpankunjungan = (KoneksiApi.URL_API + "api/tambahpengunjungwisata");
    TextView alamat;
    TextView biaya;
    ImageView fotobesar;
    ImageView fotokecil1;
    ImageView fotokecil2;
    ImageView fotokecil3;
    TextView info;
    TextView namawisata;
    /* access modifiers changed from: private */
    public RequestQueue rQueue;
    /* access modifiers changed from: private */
    public String tanggal = "";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profil, (ViewGroup) null);
        this.namawisata = (TextView) view.findViewById(R.id.namawisata);
        this.alamat = (TextView) view.findViewById(R.id.alamat);
        this.biaya = (TextView) view.findViewById(R.id.biaya);
        this.info = (TextView) view.findViewById(R.id.info);
        this.fotobesar = (ImageView) view.findViewById(R.id.fotobesar);
        this.fotokecil1 = (ImageView) view.findViewById(R.id.fotokecil1);
        this.fotokecil2 = (ImageView) view.findViewById(R.id.fotokecil2);
        this.fotokecil3 = (ImageView) view.findViewById(R.id.fotokecil3);
        this.tanggal = getCurretDate();
        Volley.newRequestQueue(getContext()).add(new JsonObjectRequest(0, KoneksiApi.URL_API + "api/datawisata/" + Baca_Tag_Wisata.userData, (JSONObject) null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                JSONObject jSONObject = response;
                try {
                    String urlGambar = KoneksiApi.URL_API + "kumpulanfoto/";
                    String kodew = jSONObject.getString("id");
                    String string = jSONObject.getString("kategori");
                    String namaw = jSONObject.getString("namawisata");
                    String alam = jSONObject.getString("alamat");
                    String bia = jSONObject.getString("biaya");
                    Profil.longi = jSONObject.getString("longitude");
                    Profil.lati = jSONObject.getString("latitude");
                    String inf = jSONObject.getString("info");
                    String fotbes = jSONObject.getString("fotobesar");
                    String fotkec1 = jSONObject.getString("fotokecil1");
                    String fotkec2 = jSONObject.getString("fotokecil2");
                    String fotkec3 = jSONObject.getString("fotokecil3");
                    String str = urlGambar;
                    Profil.this.namawisata.setText(namaw);
                    Profil.this.alamat.setText(alam);
                    Profil.this.biaya.setText(bia);
                    Profil.this.info.setText(inf);
                    String ftkecil2 = urlGambar + fotkec2;
                    String ftkecil3 = urlGambar + fotkec3;
                    String str2 = kodew;
                    String str3 = fotkec3;
                    String fotkec32 = Profil.this.URLSimpankunjungan;
                    String str4 = fotkec2;
                    String str5 = fotkec1;
                    String str6 = fotbes;
                    final String fotbes2 = namaw;
                    String str7 = inf;
                    final String inf2 = alam;
                    AnonymousClass3 r1 = new StringRequest(1, fotkec32, new Response.Listener<String>() {
                        public void onResponse(String response) {
                        }
                    }, new Response.ErrorListener() {
                        public void onErrorResponse(VolleyError error) {
                        }
                    }) {
                        /* access modifiers changed from: protected */
                        public Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("tanggal", Profil.this.tanggal);
                            params.put("nama", Login.nama);
                            params.put("wisata", fotbes2);
                            params.put("alamat", inf2);
                            return params;
                        }
                    };
                    Profil profil = Profil.this;
                    RequestQueue unused = profil.rQueue = Volley.newRequestQueue(profil.getContext());
                    Profil.this.rQueue.add(r1);
                    ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) Profil.this).load(urlGambar + fotbes).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(Profil.this.fotobesar);
                    ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) Profil.this).load(urlGambar + fotkec1).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(Profil.this.fotokecil1);
                    ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) Profil.this).load(ftkecil2).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(Profil.this.fotokecil2);
                    ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) Profil.this).load(ftkecil3).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(Profil.this.fotokecil3);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Profil.this.getContext(), volleyError.getMessage(), 0).show();
            }
        }));
        return view;
    }

    public String getCurretDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(1);
        int month = c.get(2);
        return c.get(5) + "/" + (month + 1) + "/" + year;
    }
}
