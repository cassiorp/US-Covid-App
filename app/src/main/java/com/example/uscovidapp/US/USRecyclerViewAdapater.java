package com.example.uscovidapp.US;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.uscovidapp.R;

import java.util.ArrayList;
import java.util.List;

public class USRecyclerViewAdapater extends RecyclerView.Adapter<USLineModel> {
    // valores
    private final List<USModel> list;

    private Context ativityEmExecucao;

    public USRecyclerViewAdapater(List<USModel> valores) {
        list = new ArrayList<>();
        for (USModel a : valores) {
            list.add(a);
        }
    }

    public List<USModel> getList() {
        return list;
    }

    /**
     * Método executado sempre que a tela é executada
     * @return
     */
    @Override
    public USLineModel onCreateViewHolder(ViewGroup parent, int viewType) {
        ativityEmExecucao = parent.getContext();
        final USLineModel holder = new USLineModel(LayoutInflater.from(ativityEmExecucao)
                .inflate(R.layout.linha_recycler_view, parent, false));

        return holder;
    }
    @Override
    public void onBindViewHolder(USLineModel holder, int position) {
        // dado selecionado
        USModel conteudoLinha = list.get(position);
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