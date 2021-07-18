package com.example.uscovidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uscovidapp.States.StatesCurrentFragment;
import com.example.uscovidapp.States.StatesHistoricalFragment;
import com.example.uscovidapp.US.USHistoricalFragement;

public class MainActivity extends AppCompatActivity {
    String usHistoryResponse = "";
    String statesHistoryResponse = "";
    String statesCurrentResponse = "";
    Bundle args = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getStatesHistoricalResponse();
        getUSHistoryResponse();
        getStatesCurrentResponse();
        replaceFragment(new CovidFragment());
    }

    public void startUSHistory(View view) {
        USHistoricalFragement fragment = new USHistoricalFragement();
        args.putString("response", usHistoryResponse);
        fragment.setArguments(args);
        replaceFragment(fragment);
    }

    public void startStatesHistory(View view) {
        StatesHistoricalFragment fragment = new StatesHistoricalFragment();
        args.putString("responseState", statesHistoryResponse);
        fragment.setArguments(args);
        replaceFragment(fragment);
    }
    public void startStatesCurrent(View view) {
        StatesCurrentFragment fragment = new StatesCurrentFragment();
        args.putString("responseStateCurrent", statesCurrentResponse);
        fragment.setArguments(args);
        replaceFragment(fragment);
    }

    public void getUSHistoryResponse(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.covidtracking.com/v1/us/daily.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        usHistoryResponse = response;
                        Toast.makeText(getBaseContext(), "sucesso US", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

    public void getStatesHistoricalResponse(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.covidtracking.com/v1/states/daily.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        statesHistoryResponse = response;
                        Toast.makeText(getBaseContext(), "sucesso Historical", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

    public void getStatesCurrentResponse(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.covidtracking.com/v1/states/current.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        statesCurrentResponse = response;
                        Toast.makeText(getBaseContext(), "sucesso Current", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

}