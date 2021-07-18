package com.example.uscovidapp.historyUS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorDoRecyclerViewUS extends RecyclerView.Adapter<ModeloDeLinhaUS> {
    // valores
    private final List<USHistoryData> list;

    private Context ativityEmExecucao;

    public AdaptadorDoRecyclerViewUS(List<USHistoryData> valores) {
        list = new ArrayList<>();
        for (USHistoryData a : valores) {
            list.add(a);
        }
    }

    public List<USHistoryData> getList() {
        return list;
    }

    /**
     * Método executado sempre que a tela é executada
     * @return
     */
    @Override
    public ModeloDeLinhaUS onCreateViewHolder(ViewGroup parent, int viewType) {
        ativityEmExecucao = parent.getContext();
        final ModeloDeLinhaUS holder = new ModeloDeLinhaUS(LayoutInflater.from(ativityEmExecucao)
                .inflate(R.layout.linha_recycler_view, parent, false));

        return holder;
    }
    @Override
    public void onBindViewHolder(ModeloDeLinhaUS holder, int position) {
        // dado selecionado
        USHistoryData conteudoLinha = list.get(position);
        // exibe dados
        holder.data.setText(String.valueOf(conteudoLinha.getData()));
        holder.cases.setText(String.valueOf(conteudoLinha.getCasos()));
        holder.mortes.setText(conteudoLinha.getMortes());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

}