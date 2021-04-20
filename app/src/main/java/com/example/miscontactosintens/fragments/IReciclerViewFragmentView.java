package com.example.miscontactosintens.fragments;

import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public interface IReciclerViewFragmentView {

    public void generarLinerLayaoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public ContactoAdaptador2 crearAdaptador2(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(ContactoAdaptador contactoAdaptador);

    public void inicializarAdaptadorRV2(ContactoAdaptador2 contactoAdaptador2);

    public void generarGirdLayaout();
}
