package com.project.sahifah.amalan.bulanramadhan.khusus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.project.sahifah.R;

public class MalamKe1 extends Fragment {

    View v;
    TextView txtFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.harike1, parent, false);
        txtFragment = v.findViewById(R.id.txtfragment);
        txtFragment.setText("Doa Malam Ke 1");
        return v;
    }

}
