package com.example.uscovidapp.US;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
                USModel USModel = new USModel(dataFormatter(data), prettyNumberFormatter(casos), prettyNumberFormatter(mortes));
                dados.add(USModel);
            }
            return dados;
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private String dataFormatter(String data) {
        String ano = data.substring(0, 4);
        String mes = data.substring(4, 6);
        String dia = data.substring(6, data.length());
        return dia + "/" + mes + "/" + ano;
    }

    private String prettyNumberFormatter(String casos) {
        if (casos.length() <= 3) {
            return casos;
        }

        if (casos.length() > 3 && casos.length() <= 6) {
            return thousandFormatter(casos);
        }

        if(casos.length() > 6 && casos.length() <= 9){
            return millionFormatter(casos);
        }

        return casos;
    }

    private String millionFormatter(String casos) {
        String unidade = casos.substring(casos.length()-3, casos.length());
        String dezena = casos.substring(casos.length()-6, casos.length());
        casos = casos = casos.replaceAll(dezena+"$", "."+dezena);
        casos = casos = casos.replaceAll(unidade+"$", "."+unidade);
        return casos + " mi";
    }

    private String thousandFormatter(String casos) {
        String unidade = casos.substring(casos.length()-3, casos.length());
        String formatAux = "."+unidade;
        casos = casos.replaceAll(unidade+"$",formatAux);
        return casos + " mil";
    }
}