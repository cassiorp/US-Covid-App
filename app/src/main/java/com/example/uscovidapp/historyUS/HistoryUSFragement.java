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

import com.example.uscovidapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HistoryUSFragement extends Fragment {
    View view;
    TextView textView;

    private RecyclerView recyclerView;
    private List<USHistoryData> dados = new ArrayList<>();
    private AdaptadorDoRecyclerViewUS adaptadorDoRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_history_u_s_fragement, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewUS);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        adaptadorDoRecyclerView = new AdaptadorDoRecyclerViewUS(dados);
        recyclerView.setAdapter(adaptadorDoRecyclerView);
        Bundle b = getArguments();
        String usRespose = b.getString("response");
        adaptadorDoRecyclerView.getList().addAll(mountData(usRespose));
        return view;
    }


    public List<USHistoryData> mountData(String response) {
        try {
            List<USHistoryData> dados = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String data = jsonObject.getString("date");
                String casos = jsonObject.getString("positive");
                String mortes = jsonObject.getString("death");
                USHistoryData USHistoryData = new USHistoryData(data, casos, mortes);
                dados.add(USHistoryData);
            }
            return dados;
        }catch (JSONException e){
            throw new RuntimeException(e.getMessage());
        }

    }

}