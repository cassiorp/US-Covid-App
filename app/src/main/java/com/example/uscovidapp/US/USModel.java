package com.example.uscovidapp.US;

public class USModel {

    private String data;
    private String casos;
    private String mortes;

    public USModel(String data, String casos, String mortes) {
        this.data = data;
        this.casos = casos;
        this.mortes = mortes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCasos() {
        return casos;
    }

    public void setCasos(String casos) {
        this.casos = casos;
    }

    public String getMortes() {
        return mortes;
    }

    public void setMortes(String mortes) {
        this.mortes = mortes;
    }
}
