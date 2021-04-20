package com.example.miscontactosintens.pojo;

public class Mascotas implements Comparable<Mascotas>{

    private int id;
    private String nombre;
    private int linkes;
    private int foto;

    public  Mascotas(){

    }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Mascotas o) {
        int byAge = Integer.compare(o.linkes,linkes);
        if ( byAge != 0 ) {
            return byAge;
        }
        if ( nombre == null ) {
            return o.nombre == null ? 0 : 1;
        }
        if ( o.nombre == null ) {
            return 1;
        }
        return nombre.compareToIgnoreCase(o.nombre);
    }

}
