package com.example.uscovidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uscovidapp.historyUS.HistoryUSFragement;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private Button historyStatesButton, actualStatesButton, historyUSButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(teste());
        replaceFragment(new CovidFragment());

        historyStatesButton = findViewById(R.id.buttonHistoryStates);
        actualStatesButton = findViewById(R.id.buttonActual);
        historyUSButton = findViewById(R.id.buttonHistoryUS);

        historyUSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HistoryUSFragement());
            }
        });

        historyStatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HistoryStatesFragment());
            }
        });

        actualStatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ActualStatesFragment());
            }
        });

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

    public String teste() {
        final String[] textView = new String[1];
        // ...

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.covidtracking.com/v1/us/daily.json";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView[0] = response.substring(0,500);
                        System.out.println("AAAAAAAAAAAAAA" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView[0] = ("That didn't work!");
                System.out.println("Erro");
                System.out.println(error.networkResponse);
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        return textView[0];
    }
}