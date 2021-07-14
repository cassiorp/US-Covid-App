package com.example.uscovidapp.historyUS;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uscovidapp.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoryUSFragement extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<DadosUS> dados = new ArrayList<>();
    private ArrayAdapter<String> adapterSpinner;
    private AdaptadorDoRecyclerView adaptadorDoRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_history_u_s_fragement, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewUS);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        // Valores e Adapter
        adaptadorDoRecyclerView = new AdaptadorDoRecyclerView(dados);
        // vincilar adaptador e RecyclerView
        recyclerView.setAdapter(adaptadorDoRecyclerView);

        DadosUS dado1 = new DadosUS("data", "caso", "Morte");
        DadosUS dado2 = new DadosUS("data", "caso", "Morte");
        DadosUS dado3 = new DadosUS("data", "caso", "Morte");
        List<DadosUS> list = Arrays.asList(dado1, dado2, dado3);

        adaptadorDoRecyclerView.getList().addAll(list);

        return view;
    }





}