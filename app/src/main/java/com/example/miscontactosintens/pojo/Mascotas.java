package com.example.miscontactosintens.pojo;

public class Mascotas {
    private String nombre;
    private int linkes;


    private int foto;

    public Mascotas(int foto, String nombre, int linkes) {
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

    public int getLinkes() {
        return linkes;
    }

    public void setLinkes(int linkes) {
        this.linkes = linkes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
