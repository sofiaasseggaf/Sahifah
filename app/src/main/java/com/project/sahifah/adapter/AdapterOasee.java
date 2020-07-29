package com.project.sahifah.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.sahifah.R;
import com.project.sahifah.model.ModelOase;
import com.project.sahifah.model.ModelQuran;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterOasee extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ModelOase> dataItemList;

    public AdapterOasee(List<ModelOase> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oase, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Penampung)holder).oase_title.setText(dataItemList.get(position).getTitle());
        ((Penampung)holder).oase_date.setText(dataItemList.get(position).getCreatedDate());
        /*ImageView img_oase = ((Penampung)holder).oase_img;
        if (dataItemList.get(position).getImage() != null){
            Picasso.get().load(dataItemList.get(position).getImage()).into(img_oase);
        } else {
            ((Penampung)holder).oase_img.setImageResource(R.drawable.img_oase_1);
        }*/
        try {
            Bitmap bitmap= BitmapFactory.decodeFile(dataItemList.get(position).getImage());
            ((Penampung)holder).oase_img.setImageBitmap(bitmap);
        }  catch (Exception e){
        }
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }

    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView oase_img;
        TextView oase_title, oase_date;
        public Penampung(View itemView) {
            super(itemView);
            oase_img = itemView.findViewById(R.id.oase_img);
            oase_title = itemView.findViewById(R.id.oase_title);
            oase_date = itemView.findViewById(R.id.oase_date);
        }
        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + oase_title.getText());
        }
    }
}
