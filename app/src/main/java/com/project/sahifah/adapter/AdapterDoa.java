package com.project.sahifah.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.R;
import com.project.sahifah.model.doa.Detail;

import java.util.List;

public class AdapterDoa extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Detail> dataItemList;

    public AdapterDoa(List<Detail> dataItemList){
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doa, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Penampung)holder).txtArab.setText(dataItemList.get(position).getArab());
        ((Penampung)holder).txtBaca.setText(dataItemList.get(position).getLatin());
        ((Penampung)holder).txtIndo.setText(dataItemList.get(position).getTerjemahan());
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtArab, txtBaca, txtIndo;
        public Penampung(View itemView) {
            super(itemView);
            txtArab = itemView.findViewById(R.id.txtArab);
            txtBaca = itemView.findViewById(R.id.txtBaca);
            txtIndo = itemView.findViewById(R.id.txtIndo);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtIndo.getText());
        }
    }
}
