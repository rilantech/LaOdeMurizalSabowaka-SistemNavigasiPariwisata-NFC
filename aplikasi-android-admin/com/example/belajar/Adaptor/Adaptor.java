package com.example.belajar.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.belajar.R;
import java.util.ArrayList;

public class Adaptor extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetData> model;

    public Adaptor(Context context2, ArrayList<GetData> model2) {
        this.inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.model = model2;
    }

    public int getCount() {
        return this.model.size();
    }

    public Object getItem(int position) {
        return this.model.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view1 = this.inflater.inflate(R.layout.list_datawisata, (ViewGroup) null);
        if (view1 != null) {
            ((TextView) view1.findViewById(R.id.kodewisata)).setText(this.model.get(position).getKodewisata());
            ((TextView) view1.findViewById(R.id.kategori)).setText(this.model.get(position).getKategori());
            ((TextView) view1.findViewById(R.id.namawisata)).setText(this.model.get(position).getNamawisata());
            ((TextView) view1.findViewById(R.id.alamat)).setText(this.model.get(position).getAlamat());
            ((TextView) view1.findViewById(R.id.biaya)).setText(this.model.get(position).getBiaya());
            ((TextView) view1.findViewById(R.id.longitude)).setText(this.model.get(position).getLongitude());
            ((TextView) view1.findViewById(R.id.latitude)).setText(this.model.get(position).getLatitude());
            ((TextView) view1.findViewById(R.id.info)).setText(this.model.get(position).getInfo());
            ((TextView) view1.findViewById(R.id.foto)).setText(this.model.get(position).getFoto());
        }
        return view1;
    }
}
