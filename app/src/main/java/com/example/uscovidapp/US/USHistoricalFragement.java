package com.example.uscovidapp.US;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uscovidapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class USHistoricalFragement extends Fragment {
    View view;
    TextView textView;

    private RecyclerView recyclerView;
    private List<USModel> dados = new ArrayList<>();
    private USRecyclerViewAdapater adaptadorDoRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_historical_u_s_fragement, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewUS);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        adaptadorDoRecyclerView = new USRecyclerViewAdapater(dados);
        recyclerView.setAdapter(adaptadorDoRecyclerView);
        Bundle b = getArguments();
        String usRespose = b.getString("response");
        adaptadorDoRecyclerView.getList().addAll(mountData(usRespose));
        return view;
    }


    public List<USModel> mountData(String response) {
        try {
            List<USModel> dados = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String data = jsonObject.getString("date");
                String casos = jsonObject.getString("positive");
                String mortes = jsonObject.getString("death");
                USModel USModel = new USModel(dataFormatter(data), casos, mortes);
                dados.add(USModel);
            }
            return dados;
        }catch (JSONException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    private String dataFormatter(String data) {
        String ano = data.substring(0, 4);
        String mes = data.substring(4,6);
        String dia = data.substring(6, data.length());
        return dia + "/" + mes + "/" + ano;
    }
}