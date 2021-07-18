package com.example.uscovidapp.States;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

public class StatesLineModel extends RecyclerView.ViewHolder {

    public TextView estado;
    public TextView mortes;
    public TextView cases;

    public StatesLineModel(View itemView) {
        super(itemView);
        estado = itemView.findViewById(R.id.textViewState);
        mortes = itemView.findViewById(R.id.textViewMortes);
        cases = itemView.findViewById(R.id.textViewCasos);
    }

}