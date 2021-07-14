package com.example.uscovidapp.historyUS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorDoRecyclerView extends RecyclerView.Adapter<ModeloDeLinha> {
    // valores
    private final List<DadosUS> list;

    private Context ativityEmExecucao;

    public AdaptadorDoRecyclerView(List<DadosUS> valores) {
        list = new ArrayList<>();
        for (DadosUS a : valores) {
            list.add(a);
        }
    }

    public List<DadosUS> getList() {
        return list;
    }

    /**
     * Método executado sempre que a tela é executada
     * @return
     */
    @Override
    public ModeloDeLinha onCreateViewHolder(ViewGroup parent, int viewType) {
        ativityEmExecucao = parent.getContext();
        final ModeloDeLinha holder = new ModeloDeLinha(LayoutInflater.from(ativityEmExecucao)
                .inflate(R.layout.linha_recycler_view, parent, false));

        return holder;
    }
    @Override
    public void onBindViewHolder(ModeloDeLinha holder, int position) {
        // dado selecionado
        DadosUS conteudoLinha = list.get(position);
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