package com.project.sahifah.adapter;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class AdapterOase extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "AdapterOase";

    private List<ModelOase> dataItemList;
    private OnNoteListener mOnNoteListener;

    public AdapterOase(List<ModelOase> dataItemList, OnNoteListener onNoteListener) {
        this.dataItemList = dataItemList;
        this.mOnNoteListener = mOnNoteListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oase, parent, false);
        return new Penampung(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        try{
            ((Penampung)holder).oase_img.setImageResource(R.drawable.img_oase_2);
            ((Penampung)holder).oase_title.setText(dataItemList.get(position).getTitle());
            /*String month = mNotes.get(position).getTimestamp().substring(0, 2);
            month = Utility.getMonthFromNumber(month);
            String year = mNotes.get(position).getTimestamp().substring(3);
            String timestamp = month + " " + year;
            ((Penampung)holder).oase_date.setText(timestamp);*/
            ((Penampung)holder).oase_date.setText(dataItemList.get(position).getCreatedDate());
        }catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage() );
        }
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }

    public class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView oase_img;
        TextView oase_title, oase_date;
        OnNoteListener mOnNoteListener;

        public Penampung(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            oase_img = itemView.findViewById(R.id.oase_img);
            oase_title = itemView.findViewById(R.id.oase_title);
            oase_date = itemView.findViewById(R.id.oase_date);
            mOnNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
