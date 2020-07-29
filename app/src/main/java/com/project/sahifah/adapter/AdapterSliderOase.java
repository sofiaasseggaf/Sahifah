package com.project.sahifah.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.project.sahifah.HomeActivity;
import com.project.sahifah.R;
import com.project.sahifah.model.ModelSliderOase;

import java.util.List;

public class AdapterSliderOase extends PagerAdapter {

    private List<ModelSliderOase> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterSliderOase(List<ModelSliderOase> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_slider_artikel, container, false);
        ImageView imageView;
        TextView textView;
        imageView = view.findViewById(R.id.slider_oase_img);
        textView = view.findViewById(R.id.slider_oase_title);

        imageView.setImageResource(models.get(position).getImage());
        textView.setText(models.get(position).getTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("param", "15"); //intent.putExtra("param", models.get(position).getTitle());
                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
