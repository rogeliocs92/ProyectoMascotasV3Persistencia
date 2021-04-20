package com.example.miscontactosintens.presentador;

import android.content.Context;

import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.db.ConstructorContactos;
import com.example.miscontactosintens.fragments.IReciclerViewFragmentView;
import com.example.miscontactosintens.fragments.RecyclerViewFragment;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class ReciclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {

    private IReciclerViewFragmentView iReciclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Mascotas> contactos;
    public ReciclerViewFragmentPresenter(IReciclerViewFragmentView iReciclerViewFragmentView, Context context) {
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
        iReciclerViewFragmentView.inicializarAdaptadorRV(iReciclerViewFragmentView.crearAdaptador(contactos));
        iReciclerViewFragmentView.generarLinerLayaoutVertical();
    }
}
