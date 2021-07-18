package com.example.uscovidapp.historyStates;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.uscovidapp.R;
import com.example.uscovidapp.historyUS.AdaptadorDoRecyclerViewUS;
import com.example.uscovidapp.historyUS.USHistoryData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HistoryStatesFragment extends Fragment {
    View view;

    private RecyclerView recyclerView;
    private List<StatesHistoryData> dados = new ArrayList<>();

    private AdaptadorDoRecyclerViewStates adaptadorDoRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history_states, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewStatesHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        adaptadorDoRecyclerView = new AdaptadorDoRecyclerViewStates(dados);
        recyclerView.setAdapter(adaptadorDoRecyclerView);

        Bundle b = getArguments();
        String response = b.getString("responseState");
        adaptadorDoRecyclerView.getList().addAll(mountData(response));

        return view;
    }

    private List<StatesHistoryData> mountData(String response) {
        try {
            List<StatesHistoryData> dados = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String state = jsonObject.getString("state");
                String casos = jsonObject.getString("positive");
                String mortes = jsonObject.getString("death");
                StatesHistoryData USHistoryData = new StatesHistoryData(state, casos, mortes);
                dados.add(USHistoryData);
            }
            return dados;
        }catch (JSONException e){
            throw new RuntimeException(e.getMessage() + e.getCause());
        }
    }

}