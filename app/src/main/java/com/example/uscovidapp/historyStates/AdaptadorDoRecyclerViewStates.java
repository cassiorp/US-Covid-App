package com.example.uscovidapp.historyStates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorDoRecyclerViewStates  extends RecyclerView.Adapter<ModeloDeLinhaStates>{

    private final List<StatesHistoryData> list;

    private Context ativityEmExecucao;

    public AdaptadorDoRecyclerViewStates(List<StatesHistoryData> valores) {
        list = new ArrayList<>();
        for (StatesHistoryData a : valores) {
            list.add(a);
        }
    }

    public List<StatesHistoryData> getList() {
        return list;
    }

    /**
     * Método executado sempre que a tela é executada
     * @return
     */
    @Override
    public ModeloDeLinhaStates onCreateViewHolder(ViewGroup parent, int viewType) {
        ativityEmExecucao = parent.getContext();
        final ModeloDeLinhaStates holder = new ModeloDeLinhaStates(LayoutInflater.from(ativityEmExecucao)
                .inflate(R.layout.linha_recycler_view_states, parent, false));

        return holder;
    }
    @Override
    public void onBindViewHolder(ModeloDeLinhaStates holder, int position) {
        // dado selecionado
        StatesHistoryData conteudoLinha = list.get(position);
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
