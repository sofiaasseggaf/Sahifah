package com.project.sahifah.adapter.adaptersurah;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.R;
import com.project.sahifah.model.ModelQuran;
import com.project.sahifah.utility.PreferenceUtils;

import java.util.List;

public class AdapterSurahTerjemahan extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ModelQuran> dataItemList;
    private Context context;

    public AdapterSurahTerjemahan(List<ModelQuran> dataItemList){
        this.dataItemList = dataItemList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.v_surah_tanpalatin, parent, false);
        context = parent.getContext();
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Penampung)holder).txtNo.setText(String.valueOf(1+position));
        ((Penampung)holder).txtNo.setTextSize((float)PreferenceUtils.getUkuranFont(context));
        //((Penampung)holder).txtNoAyat.setText(String.valueOf(1+position));
        //((Penampung)holder).txtNoAyat.setTextSize((float)PreferenceUtils.getUkuranFont(context));
        ((Penampung)holder).txtArab.setText(dataItemList.get(position).getAyahText());
        ((Penampung)holder).txtArab.setTextSize((float)PreferenceUtils.getUkuranFontArab(context));
        //((Penampung)holder).txtBaca.setText(dataItemList.get(position).getReadText());
        //((Penampung)holder).txtBaca.setTextSize((float)PreferenceUtils.getUkuranFont(context));
        ((Penampung)holder).txtIndo.setText(dataItemList.get(position).getIndoText());
        ((Penampung)holder).txtIndo.setTextSize((float)PreferenceUtils.getUkuranFont(context));
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtArab, txtBaca, txtIndo, txtNo, txtNoAyat;
        public Penampung(View itemView) {
            super(itemView);
            txtNo = itemView.findViewById(R.id.txtNo);
            //txtNoAyat = itemView.findViewById(R.id.txtNoAyat);
            txtArab = itemView.findViewById(R.id.txtArab);
            //txtBaca = itemView.findViewById(R.id.txtBaca);
            txtIndo = itemView.findViewById(R.id.txtIndo);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtIndo.getText());
        }
    }
}
