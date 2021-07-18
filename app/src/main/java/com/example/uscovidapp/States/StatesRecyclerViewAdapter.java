package com.example.uscovidapp.States;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

import java.util.ArrayList;
import java.util.List;

public class StatesRecyclerViewAdapter extends RecyclerView.Adapter<StatesLineModel>{

    private final List<StatesModel> list;

    private Context ativityEmExecucao;

    public StatesRecyclerViewAdapter(List<StatesModel> valores) {
        list = new ArrayList<>();
        for (StatesModel a : valores) {
            list.add(a);
        }
    }

    public List<StatesModel> getList() {
        return list;
    }

    /**
     * Método executado sempre que a tela é executada
     * @return
     */
    @Override
    public StatesLineModel onCreateViewHolder(ViewGroup parent, int viewType) {
        ativityEmExecucao = parent.getContext();
        final StatesLineModel holder = new StatesLineModel(LayoutInflater.from(ativityEmExecucao)
                .inflate(R.layout.linha_recycler_view_states, parent, false));

        return holder;
    }
    @Override
    public void onBindViewHolder(StatesLineModel holder, int position) {
        // dado selecionado
        StatesModel conteudoLinha = list.get(position);
        // exibe dados
        holder.estado.setText(conteudoLinha.getState());
        holder.cases.setText(conteudoLinha.getPositive());
        holder.mortes.setText(conteudoLinha.getDeath());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}
