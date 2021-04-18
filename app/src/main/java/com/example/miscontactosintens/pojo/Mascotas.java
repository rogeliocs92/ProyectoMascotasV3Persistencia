package com.example.miscontactosintens.pojo;

public class Mascotas {
    private String nombre;
    private String linkes;


    private int foto;

    public Mascotas(int foto, String nombre, String linkes) {
        this.nombre = nombre;
        this.linkes = linkes;
        this.foto=foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinkes() {
        return linkes;
    }

    public void setLinkes(String linkes) {
        this.linkes = linkes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
