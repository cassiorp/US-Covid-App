package com.example.uscovidapp.US;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

public class USLineModel extends RecyclerView.ViewHolder {

    public TextView data;
    public TextView mortes;
    public TextView cases;

    public USLineModel(View itemView) {
        super(itemView);
        data = itemView.findViewById(R.id.date);
        mortes = itemView.findViewById(R.id.mortes);
        cases = itemView.findViewById(R.id.casos);
    }

}