package com.project.sahifah.adapter.adapterdoa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.R;
import com.project.sahifah.model.doa.Detail;
import com.project.sahifah.utility.PreferenceUtils;

import java.util.List;

public class AdapterDoaLatin extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Detail> dataItemList;
    private Context context;

    public AdapterDoaLatin(List<Detail> dataItemList){
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.v_doa_tanpaindo, parent, false);
        context = parent.getContext();
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Penampung)holder).txtArab.setText(dataItemList.get(position).getArab());
        ((Penampung)holder).txtArab.setTextSize((float) PreferenceUtils.getUkuranFontArab(context));
        ((Penampung)holder).txtBaca.setText(dataItemList.get(position).getLatin());
        ((Penampung)holder).txtBaca.setTextSize((float) PreferenceUtils.getUkuranFont(context));
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtArab, txtBaca;
        public Penampung(View itemView) {
            super(itemView);
            txtArab = itemView.findViewById(R.id.txtArab);
            txtBaca = itemView.findViewById(R.id.txtBaca);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtArab.getText());
        }
    }

    public void removeLatin(int position){
        dataItemList.get(position).getLatin().replace(dataItemList.get(position).getLatin(), "");
        notifyItemChanged(position);
        notifyItemRangeChanged(position, dataItemList.size());
    }
}