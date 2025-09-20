package com.example.belajar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Detail_Data extends AppCompatActivity {
    TextView alamat;
    TextView biaya;
    TextView foto;
    TextView info;
    TextView kategori;
    TextView kodewisata;
    TextView label;
    TextView latitude;
    TextView longitude;
    TextView namawisata;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_detail_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new Detail_Data$$ExternalSyntheticLambda0());
        this.label = (TextView) findViewById(R.id.lbl);
        if (getIntent().getExtras().containsKey("detail_Data")) {
            this.label.setText("Edit Data");
            getData();
        }
        this.kodewisata = (TextView) findViewById(R.id.kodewisata);
        this.kategori = (TextView) findViewById(R.id.kategori);
        this.namawisata = (TextView) findViewById(R.id.namawisata);
        this.alamat = (TextView) findViewById(R.id.alamat);
        this.biaya = (TextView) findViewById(R.id.biaya);
        this.longitude = (TextView) findViewById(R.id.longitude);
        this.latitude = (TextView) findViewById(R.id.latitude);
        this.info = (TextView) findViewById(R.id.info);
        this.foto = (TextView) findViewById(R.id.foto);
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    private void getData() {
        Volley.newRequestQueue(this).add(new StringRequest(0, new Configurasi().baseUrl() + "1", new Response.Listener<String>() {
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s).getJSONObject("dataku");
                    String gkodewisata = jsonObject.getString("kodewisata");
                    String gkategori = jsonObject.getString("kategori");
                    String gnamawisata = jsonObject.getString("namawisata");
                    String galamat = jsonObject.getString("alamat");
                    String gbiaya = jsonObject.getString("biaya");
                    String glongitude = jsonObject.getString("longitude");
                    String glatitude = jsonObject.getString("latitude");
                    String ginfo = jsonObject.getString("info");
                    String gfoto = jsonObject.getString("foto");
                    Detail_Data.this.kodewisata.setText(gkodewisata);
                    Detail_Data.this.kategori.setText(gkategori);
                    Detail_Data.this.namawisata.setText(gnamawisata);
                    Detail_Data.this.alamat.setText(galamat);
                    Detail_Data.this.biaya.setText(gbiaya);
                    Detail_Data.this.longitude.setText(glongitude);
                    Detail_Data.this.latitude.setText(glatitude);
                    Detail_Data.this.info.setText(ginfo);
                    Detail_Data.this.foto.setText(gfoto);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("id", Detail_Data.this.getIntent().getStringExtra("detail_data"));
                return form;
            }
        });
    }
}
