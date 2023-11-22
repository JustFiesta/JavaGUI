package com.example.jdbc;

public class Miejscowosc {
    String nazwa, id;

    public Miejscowosc(String id, String nazwa) {
        this.nazwa = nazwa;
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
