package com.example.belajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.belajar.Adaptor.Adaptor;
import com.example.belajar.Adaptor.GetData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataApi extends AppCompatActivity {
    Adaptor adaptor;
    ListView listView;
    ArrayList<GetData> model;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((int) R.layout.activity_data_api);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new DataApi$$ExternalSyntheticLambda0());
        this.listView = (ListView) findViewById(R.id.list);
        load_data();
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                PopupMenu popupMenu = new PopupMenu(DataApi.this.getApplicationContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_opsi, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.edit) {
                            Intent intent = new Intent(DataApi.this, Detail_Data.class);
                            intent.putExtra("detail_data", DataApi.this.model.get(position).getId());
                            DataApi.this.startActivity(intent);
                        } else if (item.getItemId() == R.id.hapus) {
                            Toast.makeText(DataApi.this, "Anda Menekan Tombol Hapus", 0).show();
                        }
                        return false;
                    }
                });
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }

    /* access modifiers changed from: package-private */
    public void load_data() {
        Volley.newRequestQueue(this).add(new StringRequest(0, new Configurasi().baseUrl() + "/3", new Response.Listener<String>() {
            public void onResponse(String s) {
                try {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = jsonObject.getJSONArray("datawisata");
                        DataApi.this.model = new ArrayList<>();
                        int i = 0;
                        while (i <= jsonArray.length()) {
                            JSONObject getData = jsonArray.getJSONObject(i);
                            ArrayList<GetData> arrayList = DataApi.this.model;
                            JSONObject jsonObject2 = jsonObject;
                            GetData getData2 = r7;
                            GetData getData3 = new GetData(getData.getInt("id"), getData.getString("kodewisata"), getData.getString("kategori"), getData.getString("namawisata"), getData.getString("alamat"), getData.getString("biaya"), getData.getString("longitude"), getData.getString("latitude"), getData.getString("info"), getData.getString("foto"));
                            arrayList.add(getData2);
                            i++;
                            jsonObject = jsonObject2;
                        }
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        DataApi.this.adaptor = new Adaptor(DataApi.this.getApplicationContext(), DataApi.this.model);
                        DataApi.this.listView.setAdapter(DataApi.this.adaptor);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    String str = s;
                    e.printStackTrace();
                    DataApi.this.adaptor = new Adaptor(DataApi.this.getApplicationContext(), DataApi.this.model);
                    DataApi.this.listView.setAdapter(DataApi.this.adaptor);
                }
                DataApi.this.adaptor = new Adaptor(DataApi.this.getApplicationContext(), DataApi.this.model);
                DataApi.this.listView.setAdapter(DataApi.this.adaptor);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
            }
        }));
    }
}
