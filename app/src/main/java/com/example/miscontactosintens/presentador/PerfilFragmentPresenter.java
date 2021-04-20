package com.example.miscontactosintens.presentador;

import android.content.Context;

import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.db.ConstructorContactos;
import com.example.miscontactosintens.fragments.IReciclerViewFragmentView;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IReciclerViewFragmentPresenter{

    private IReciclerViewFragmentView iReciclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Mascotas> contactos;
    public PerfilFragmentPresenter(IReciclerViewFragmentView iReciclerViewFragmentView, Context context) {
        this.iReciclerViewFragmentView=iReciclerViewFragmentView;
        this.context=context;
        obtenerDatos();
    }


    @Override
    public void obtenerDatos() {
        constructorContactos=new ConstructorContactos(context);
        contactos=constructorContactos.obtenerDatos();
        mostrarDatos();
    }

    @Override
    public void mostrarDatos() {
        iReciclerViewFragmentView.inicializarAdaptadorRV2(iReciclerViewFragmentView.crearAdaptador2(contactos));
        iReciclerViewFragmentView.generarGirdLayaout();
    }
}
