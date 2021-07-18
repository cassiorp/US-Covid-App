package com.example.uscovidapp.historyStates;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

public class ModeloDeLinhaStates extends RecyclerView.ViewHolder {

    public TextView estado;
    public TextView mortes;
    public TextView cases;

    public ModeloDeLinhaStates(View itemView) {
        super(itemView);
        estado = itemView.findViewById(R.id.textViewState);
        mortes = itemView.findViewById(R.id.textViewMortes);
        cases = itemView.findViewById(R.id.textViewCasos);
    }

}