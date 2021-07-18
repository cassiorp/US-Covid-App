package com.example.uscovidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uscovidapp.historyStates.AdaptadorDoRecyclerViewStates;
import com.example.uscovidapp.historyStates.StatesHistoryData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActualStatesFragment extends Fragment {

    View view;

    private RecyclerView recyclerView;
    private List<StatesHistoryData> dados = new ArrayList<>();

    private AdaptadorDoRecyclerViewStates adaptadorDoRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_actual_states, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewCurrent);

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